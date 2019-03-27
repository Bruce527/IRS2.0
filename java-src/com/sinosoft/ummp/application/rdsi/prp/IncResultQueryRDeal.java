/**
 * 
 */
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
 * @author Darker.Wang
 * @date 2016-9-9 上午11:37:20
 * @company SINOSOFT
 */
@Service
public class IncResultQueryRDeal implements ReturnDealService{
	private TDefActionReturn record=new TDefActionReturn();
	@Autowired 
	TDefActionReturnMapper tDefActionReturnMapper;
	@Autowired
	CommonServiceMapper commonServiceMapper;
	@Autowired
	IncUploadRDeal incUploadRDeal;
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	
	@Autowired
	TPrpLcpoltransactionReturnMapper tPrpLcpoltransactionReturnMapper;	
	Logger logger = Logger.getLogger(IncResultQueryRDeal.class);
	/**
	 * 
	 */
	public IncResultQueryRDeal() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str="<?xml version="+"\"1.0\""+" encoding="+"\"UTF-8\""+"?><PDL><PDL-Head><RequestType>IncResultQuery</RequestType><CompanyCode>000000</CompanyCode><SerialNo>201508251502120123</SerialNo><TimeStamp>20150825150212</TimeStamp><DataType>L</DataType></PDL-Head><PDL-Body><QueryNo>0000000000000000000000000000000000001</QueryNo><Status>0000</Status><Msg>成功</Msg><DataStatus>0002</DataStatus><ErrInfoPath>/xxx/xxx/xxx/xxxxxx.zip</ErrInfoPath><ErrRatio>0.0001</ErrRatio></PDL-Body></PDL>";
		IncUploadRDeal parse=new IncUploadRDeal();
		parse.parseXML(str);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ReturnDealService#dealReturn(com.sinosoft.eos.model.SubmitReturn, com.sinosoft.platform.core.domain.pojo.ParamPOJO)
	 */
	@Override
	public boolean dealReturn(SubmitReturn sr, ParamPOJO pojo) {
		Object obj = sr.getReturnObj();
		String str=(String)obj;
		Map<String,String> map = incUploadRDeal.parseXML(str);
		map.put("ACTION_NO", sr.getSubmitSerialNo());
		map.put("batchno", sr.getBussModel().getBatchNo());
		map.put("user", pojo.getUserCode());
		BussModel model = sr.getBussModel();
		dealTableReturn(map, model);
		return true;
	}
	/**
	 * update or insert return/trace
	 * @param map
	 * @param model
	 */
	@Transactional
	private void dealTableReturn(Map<String, String> map, BussModel model) {
		String batchno=map.get("batchno");
		SqlAdapter sqlAdapter = new SqlAdapter();
		TDefActionReturnExample example = new TDefActionReturnExample();
		example.createCriteria().andActionNoEqualTo(map.get("ACTION_NO"));
		List<TDefActionReturn> list = tDefActionReturnMapper.selectByExample(example);
		record.setErrInfoPath(map.get("ErrInfoPath"));
		if(map.get("ErrRatio") !=null)
		record.setErroRatio(new BigDecimal(map.get("ErrRatio")));
		record.setStatus(map.get("Status"));
		record.setDataStatus(map.get("DataStatus"));
		record.setReturnMsg(map.get("Msg"));
		String stateFlag="5E";
		String status = map.get("Status");
		if (status.equals("05050100") || status.equals("05050200")) {
			if("05050100".equals(status)){
				System.out.println("==全部失败==");
				stateFlag = "5";
			}
			if("05050200".equals(status)){
				System.out.println("==部分成功==");
				stateFlag = "5";//DealErrorBL该为5E
			}
		}else if (status.equals("05160000") || status.equals("05160314")) {
			stateFlag = "4W";
		}else {
			// 状态回退，待查询
			stateFlag = "5E";
		}

			String  sql="update t_prp_lcpoltransaction set stateflag='"+stateFlag+"' where batchno= '"+batchno+"'";
	
		try {
			sqlAdapter.setSql(sql);
			sqlAdapterMapper.excuteUpdate(sqlAdapter);
		} catch (Exception e) {
			System.out.println("更新交易表状态时出错！！！");
			e.printStackTrace();
		}
		record.setQueryNo(map.get("QueryNo"));
		record.setEsStatus((short)1);
		record.setBussType(model.getBussType());
		record.setPlatCom(model.getComId());
		record.setSubBussType(model.getSubBussType());
		record.setLastModifyTime(new Date());
		if(list.isEmpty()){
			BigDecimal id=commonServiceMapper.getSeqValByName("SEQ_T_DEF_ACTION_RETURN");
			record.setId(id);
			record.setEsStatus((short)1);
			record.setBussType(model.getBussType());
			record.setPlatCom(model.getComId());
			record.setSubBussType(model.getSubBussType());
			record.setLastModifyTime(new Date());
			record.setActionNo(map.get("ACTION_NO"));
			record.setBussType(map.get("RequestType"));
			record.setStandby1(stateFlag);
			tDefActionReturnMapper.insertSelective(record);
		}else{
			tDefActionReturnMapper.updateByExampleSelective(record, example);
		}
		incUploadRDeal.dealTableTrace(map, model,stateFlag);
		dealPolTransReturn(map, model);
	}
	/**
	 * 向return表插入数据
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public void dealPolTransReturn(Map<String, String> map, BussModel model) {
		TPrpLcpoltransactionReturn tPrpLcpoltransactionReturn = new TPrpLcpoltransactionReturn();
		String sql = "select t.doc_id from t_doc_main t where t.batch_no = '"+model.getBatchNo()+"'";
		SqlAdapter sqlAdapter = new SqlAdapter();
		sqlAdapter.setSql(sql);
		List<Map> lists = sqlAdapterMapper.excuteQuery(sqlAdapter);
		if(lists.size() != 0){ 
		String DocId = lists.get(0).get("DOC_ID").toString();
		tPrpLcpoltransactionReturn.setReturndocid(DocId);}
		tPrpLcpoltransactionReturn.setTransactionid(map.get("ACTION_NO"));
		tPrpLcpoltransactionReturn.setBatchno(model.getBatchNo());
		tPrpLcpoltransactionReturn.setSubbusstype(model.getSubBussType());
		tPrpLcpoltransactionReturn.setBusstype(map.get("RequestType"));
		tPrpLcpoltransactionReturn.setOperator(map.get("user"));
		tPrpLcpoltransactionReturn.setMsg(map.get("Msg"));
		tPrpLcpoltransactionReturn.setStatus(map.get("Status"));
		tPrpLcpoltransactionReturn.setQueryno(map.get("QueryNo"));
		tPrpLcpoltransactionReturn.setMakedate(new Date());
		tPrpLcpoltransactionReturn.setMaketime(DateUtils.getCurrentTime());
		tPrpLcpoltransactionReturn.setModifydate(new Date());
		tPrpLcpoltransactionReturn.setModifytime(DateUtils.getCurrentTime());
		String stateFlag="5E";
		String dataStatus = map.get("DataStatus");
		String status = map.get("Status");
		if (map.get("Status").equals("05050100") || map.get("Status").equals("05050200")) {
			tPrpLcpoltransactionReturn.setStateflag("5");
		}else if (map.get("Status").equals("05160000") || map.get("Status").equals("05160314")) {
			tPrpLcpoltransactionReturn.setStateflag("4W");
		}else {
			// 状态回退，待查询
			tPrpLcpoltransactionReturn.setStateflag("5E");
		}
		tPrpLcpoltransactionReturn.setStateflag(stateFlag);
		tPrpLcpoltransactionReturn.setStatus(status);
		tPrpLcpoltransactionReturn.setDatastatus(dataStatus);
		tPrpLcpoltransactionReturn.setErrinfopath(map.get("ErrInfoPath"));
		tPrpLcpoltransactionReturnMapper.insertSelective(tPrpLcpoltransactionReturn);
	}

}
