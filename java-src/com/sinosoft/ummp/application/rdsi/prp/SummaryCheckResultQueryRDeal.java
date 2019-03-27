package com.sinosoft.ummp.application.rdsi.prp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.eos.model.BussModel;
import com.sinosoft.eos.model.SubmitReturn;
import com.sinosoft.platform.core.domain.mapper.CommonServiceMapper;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.ummp.application.ReturnDealService;
import com.sinosoft.ummp.domain.mapper.TDefActionReturnMapper;
import com.sinosoft.ummp.domain.mapper.TPrpLcpoltransactionReturnMapper;
import com.sinosoft.ummp.domain.model.TDefActionReturn;
import com.sinosoft.ummp.domain.model.TDefActionReturnExample;
import com.sinosoft.ummp.domain.model.TPrpLcpoltransactionReturn;
/**
 * 汇总对账结果查询，返回处理
 * @author lht
 * @date 2016-9-15
 * @company SINOSOFT
 */
@Service
public class SummaryCheckResultQueryRDeal implements ReturnDealService {
	Logger logger = Logger.getLogger(SummaryCheckResultQueryRDeal.class);
	private TDefActionReturn record=new TDefActionReturn();
	@Autowired 
	TDefActionReturnMapper tDefActionReturnMapper;
	@Autowired
	CommonServiceMapper commonServiceMapper;
	@Autowired
	SummaryCheckRDeal summaryCheckRDeal;
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	@Autowired
	TPrpLcpoltransactionReturnMapper tPrpLcpoltransactionReturnMapper;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str="<?xml version="+"\"1.0\""+" encoding="+"\"UTF-8\""+"?><PDL><PDL-Head><RequestType>IncResultQuery</RequestType><CompanyCode>000000</CompanyCode><SerialNo>201508251502120123</SerialNo><TimeStamp>20150825150212</TimeStamp><DataType>L</DataType></PDL-Head><PDL-Body><QueryNo>0000000000000000000000000000000000001</QueryNo><Status>0000</Status><Msg>成功</Msg><DataStatus>0002</DataStatus><ErrInfoPath>/xxx/xxx/xxx/xxxxxx.zip</ErrInfoPath><ErrRatio>0.0001</ErrRatio></PDL-Body></PDL>";
		SummaryCheckRDeal parse=new SummaryCheckRDeal();
		parse.parse(str);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ReturnDealService#dealReturn(com.sinosoft.eos.model.SubmitReturn, com.sinosoft.platform.core.domain.pojo.ParamPOJO)
	 */
	@Override
	public boolean dealReturn(SubmitReturn sr, ParamPOJO pojo) {
		Object obj = sr.getReturnObj();
		String str=(String)obj;
		Map<String,String> map = summaryCheckRDeal.parse(str);
		map.put("ACTION_NO", sr.getSubmitSerialNo());
		BussModel model = sr.getBussModel();
		map.put("user", pojo.getUserCode());
		String batchNo = sr.getBussModel().getBatchNo();
		System.out.println(batchNo);
		String msg = map.get("Msg");
		System.out.println(msg);
		SqlAdapter sqlAdapter = new SqlAdapter();
		String sql="";
		String stateFlag = "6";//默认明细对账
		if(map.get("CheckStatus").equals("02170100")){
			stateFlag = "9";
		}else if(map.get("CheckStatus").equals("02110000")||map.get("CheckStatus").equals("02110314")){
			stateFlag = "5W";
		}
		sql="update t_prp_lcpoltransaction o set o.stateflag = '"+stateFlag+"' WHERE EXISTS (SELECT 'E' FROM t_prp_lcpoltransaction t WHERE t.batchno = '"+batchNo+"' AND t.transdate = o.transdate) and o.batchno is not null";
		System.out.println("sql-->"+sql);
		try {
			sqlAdapter.setSql(sql);
			sqlAdapterMapper.excuteUpdate(sqlAdapter);
		} catch (Exception e) {
			System.out.println("更新交易表状态时出错！！！");
			e.printStackTrace();
			return false;
		}
		dealTableReturn(map, model,stateFlag);
		return true;
	}
	/**
	 * update or insert return/trace
	 * @param map
	 * @param model
	 */
	@Transactional
	private void dealTableReturn(Map<String, String> map, BussModel model,String stateFlag) {
		TDefActionReturnExample example = new TDefActionReturnExample();
		example.createCriteria().andActionNoEqualTo(map.get("ACTION_NO"));
		List<TDefActionReturn> list = tDefActionReturnMapper.selectByExample(example);
		record.setStatus(map.get("Status"));
		record.setDataStatus(map.get("DataStatus"));
		record.setReturnMsg(map.get("Msg"));
		record.setQueryNo(map.get("QueryNo"));
		record.setOperator(map.get("user"));
		record.setLastModifyTime(new Date());
		if(list.isEmpty()){
			BigDecimal id=commonServiceMapper.getSeqValByName("SEQ_T_DEF_ACTION_RETURN");
			record.setId(id);
			record.setEsStatus((short)1);
			record.setBussType(model.getBussType());
			record.setPlatCom(model.getComId());
			record.setSubBussType(model.getSubBussType());
			record.setActionNo(map.get("ACTION_NO"));
			record.setBussType(map.get("RequestType"));
			tDefActionReturnMapper.insertSelective(record);
		}else{
			tDefActionReturnMapper.updateByExampleSelective(record, example);
		}
		summaryCheckRDeal.dealTableTrace(map, model,stateFlag);//调用通知接口差TRACE表
	}
	
	public void dealPolTransReturn(Map<String, String> map, BussModel model,String stateFlag) {
		TPrpLcpoltransactionReturn tPrpLcpoltransactionReturn = new TPrpLcpoltransactionReturn();
		tPrpLcpoltransactionReturn.setTransactionid(map.get("ACTION_NO"));
		
		tPrpLcpoltransactionReturn.setBatchno(model.getBatchNo());
		tPrpLcpoltransactionReturn.setSubbusstype(model.getSubBussType());
		tPrpLcpoltransactionReturn.setBusstype(map.get("RequestType"));
		tPrpLcpoltransactionReturn.setOperator(map.get("user"));
		tPrpLcpoltransactionReturn.setMsg(map.get("Msg"));
		tPrpLcpoltransactionReturn.setQueryno(map.get("QueryNo"));
		tPrpLcpoltransactionReturn.setMakedate(new Date());
		tPrpLcpoltransactionReturn.setMaketime(DateUtils.getCurrentTime());
		tPrpLcpoltransactionReturn.setModifydate(new Date());
		tPrpLcpoltransactionReturn.setModifytime(DateUtils.getCurrentTime());
		tPrpLcpoltransactionReturn.setStatus(map.get("Status"));
	 	tPrpLcpoltransactionReturn.setStateflag(stateFlag);//业务状态
		tPrpLcpoltransactionReturn.setCheckstatus(map.get("CheckStatus"));//汇总状态
		tPrpLcpoltransactionReturn.setDatastatus(map.get("DataStatus"));
		tPrpLcpoltransactionReturnMapper.insertSelective(tPrpLcpoltransactionReturn);
	}
	
}
