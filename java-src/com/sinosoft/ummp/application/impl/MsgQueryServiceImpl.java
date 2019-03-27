/**
 * 
 */
package com.sinosoft.ummp.application.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.platform.core.domain.mapper.TDefSqlInfoMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlParamsMapper;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.ummp.application.MsgQueryService;
import com.sinosoft.ummp.domain.mapper.TDefBussImplMapper;
import com.sinosoft.ummp.domain.mapper.TDefBussModelMapper;
import com.sinosoft.ummp.domain.mapper.TDefBussXenginMapper;
import com.sinosoft.ummp.domain.mapper.TDefMsgNodeAttriMapper;
import com.sinosoft.ummp.domain.mapper.TDefMsgNodeMapper;
import com.sinosoft.ummp.domain.mapper.TDefMsgNodesqlRelaMapper;
import com.sinosoft.ummp.domain.mapper.TTempNodeAttriMapper;
import com.sinosoft.ummp.domain.mapper.TTempNodeMapper;
import com.sinosoft.ummp.domain.mapper.TTempNodeParamMapper;
import com.sinosoft.ummp.domain.model.TDefBussModel;
import com.sinosoft.ummp.domain.model.TDefBussModelExample;
import com.sinosoft.ummp.domain.model.TDefBussXengin;
import com.sinosoft.ummp.domain.model.TDefBussXenginExample;
import com.sinosoft.ummp.domain.pojo.MsgQueryPOJO;
import com.sinosoft.ummp.exception.CISException;

/**
 * 报文查询服务接口实现类
 * @author Darker.Wang
 * @date 2016-6-28 下午10:00:08
 * @version 1.0
 * @company SINOSOFT
 */
@Service
public class MsgQueryServiceImpl implements MsgQueryService {

	@Autowired
	TDefBussModelMapper tDefBussModelMapper;
	@Autowired
	TDefBussImplMapper tDefBussImplMapper;
	@Autowired
	TTempNodeMapper tTempNodeMapper;
	@Autowired
	TTempNodeAttriMapper tTempNodeAttriMapper;
	@Autowired
	TTempNodeParamMapper tTempNodeParamMapper;
	@Autowired
	TDefBussXenginMapper tDefBussXenginMapper;
	@Autowired
	TDefSqlMapper tDefSqlMapper;
	@Autowired
	TDefSqlInfoMapper tDefSqlInfoMapper;
	@Autowired
	TDefSqlParamsMapper tDefSqlParamsMapper;
	@Autowired
	TDefMsgNodeMapper tDefMsgNodeMapper;
	@Autowired
	TDefMsgNodeAttriMapper tDefMsgNodeAttriMapper;
	@Autowired
	TDefMsgNodesqlRelaMapper tDefMsgNodesqlRelaMapper;

	private static Logger logger = Logger.getLogger(MsgQueryServiceImpl.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.debug("MsgQueryServiceImpl main: ");
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.MsgQueryService#queryBaseMsg(com.sinosoft.ummp.domain.pojo.MsgQueryPOJO)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List queryBaseMsg(MsgQueryPOJO pojo,DataGridModel dgm) {
		if(dgm != null){
			pojo.setQueryStartIndex(dgm.getStartIndex());
			pojo.setQueryEndIndex(dgm.getEndIndex());
			pojo.setOrder(dgm.getOrder());
			pojo.setSort(dgm.getSort());
		}
		List list = tDefBussModelMapper.selectByPOJO(pojo);
		return list;
	}
	public int countBaseMsg(MsgQueryPOJO pojo,DataGridModel dgm) {
		if(dgm != null){
			pojo.setQueryStartIndex(dgm.getStartIndex());
			pojo.setQueryEndIndex(dgm.getEndIndex());
			pojo.setOrder(dgm.getOrder());
			pojo.setSort(dgm.getSort());
		}
		int count = tDefBussModelMapper.countByPOJO(pojo);
		return count;
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.MsgQueryService#checkMsgEnginIsUsing(java.math.BigDecimal)
	 */
	@Override
	public boolean checkMsgEnginIsUsing(BigDecimal bussId) {
		// TODO Auto-generated method stub
		logger.debug("checkMsgEnginIsUsing not impl : "+false);
		return false;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.MsgQueryService#pushMsgEngin4Update(java.math.BigDecimal, java.math.BigDecimal)
	 */
	@Override
	@Transactional
	public boolean pushMsgEngin4Update(BigDecimal bussId) throws CISException {
		// TODO Auto-generated method stub
		// TODO 1、将当前业务模型信息同步推送到临时节点处，修改
		if(!pushBussNode2Temp(bussId)){
			return false;
		}
		// TODO 2、将当前使用修改为无效,只修改这一层状态足以，起到控制的作用（方便后期改回来）
		TDefBussModel record = tDefBussModelMapper.selectByPrimaryKey(bussId);
		record.setRcStatus(Short.parseShort("0"));
		int i = tDefBussModelMapper.updateByPrimaryKey(record);
		if(i > 0){
			return true;
		}
		// TODO 3、返回，考录是否需要插入修改日志，以便确认是否修改完毕或者查询，恢复等
		return false;
	}

	/**
	 * 将节点信息（属性和参数）推送到临时节点
	 * @param bussId
	 * @return
	 */
	@Transactional
	private boolean pushBussNode2Temp(BigDecimal bussId) throws CISException{
		// TODO Auto-generated method stub
		TDefBussXenginExample example = new TDefBussXenginExample();
		example.createCriteria().andBussIdEqualTo(bussId);
		List<TDefBussXengin> bussXengins = tDefBussXenginMapper.selectByExample(example);
		for(TDefBussXengin x : bussXengins){
			try{
				BigDecimal nodeId = x.getNodeId();
				//防止逐渐冲突，先删除临时节点内数据
				tTempNodeMapper.deleteByNodeIdRecurs(nodeId);
				tTempNodeAttriMapper.deleteByNodeIdRecurs(nodeId);
				tTempNodeParamMapper.deleteByNodeIdRecurs(nodeId);
				//将节点对应的SQL推送到临时节点
				tDefMsgNodeMapper.push2TempNode(nodeId);
				tDefMsgNodeMapper.push2TempNodeAttri(nodeId);
				tDefMsgNodeMapper.push2TempNodeParam(nodeId);
			}catch(Exception e){
				e.printStackTrace();
				CISException ce = new CISException();
				ce.setException(e);
				ce.setFunction("pushBussNode2Temp");
				ce.setMessage(e.getMessage());
				ce.setClazz("MsgQueryServiceImpl");
				throw ce;
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.MsgQueryService#loseEffect(java.math.BigDecimal)
	 */
	@Override
	public Map<String, String> loseEffect(BigDecimal bussId) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String,String>();
		try{
			TDefBussModel bm = tDefBussModelMapper.selectByPrimaryKey(bussId);
			if(0 == bm.getRcStatus()){
				map.put("msg", "已经是失效状态");
				return map;
			}
			bm.setRcStatus(Short.parseShort("0"));
			int i = tDefBussModelMapper.updateByPrimaryKey(bm);
			if(i>0){
				map.put("msg", "success");
			}else{
				map.put("msg", "操作失败，请重试！");
			}
		}catch(Exception e){
			map.put("msg", "操作异常，请重试！");
		}
		return map;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.MsgQueryService#reEffect(java.math.BigDecimal)
	 */
	@Override
	@Transactional
	public Map<String, String> reEffect(BigDecimal bussId) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String,String>();
		try{
			TDefBussModel bm = tDefBussModelMapper.selectByPrimaryKey(bussId);
			TDefBussModelExample example = new TDefBussModelExample();
			example.createCriteria().
			andBussTypeEqualTo(bm.getBussType()).
			andBussIdNotEqualTo(bussId).
			andSubBussTypeEqualTo(bm.getSubBussType());
			//同类其他的更新为失效，该指定ID更新为有效
			List<TDefBussModel> bms = tDefBussModelMapper.selectByExample(example);
			for(TDefBussModel tbm : bms){
				tbm.setRcStatus(Short.parseShort("0"));
				tDefBussModelMapper.updateByPrimaryKey(tbm);
			}
			bm.setRcStatus(Short.parseShort("1"));
			int i = tDefBussModelMapper.updateByPrimaryKey(bm);
			if(i>0){
				map.put("msg", "success");
			}else{
				map.put("msg", "操作失败，请重试！");
			}
		}catch(Exception e){
			map.put("msg", "操作异常，请重试！");
		}
		return map;
	}
}
