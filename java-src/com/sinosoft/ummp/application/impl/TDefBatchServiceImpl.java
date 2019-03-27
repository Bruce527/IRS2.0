/**
 * 
 */
package com.sinosoft.ummp.application.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.platform.core.util.NumberUtils;
import com.sinosoft.platform.core.util.PubFun;
import com.sinosoft.ummp.application.TDefBatchService;
import com.sinosoft.ummp.domain.mapper.TDefBatchMapper;
import com.sinosoft.ummp.domain.model.TDefBatch;
import com.sinosoft.ummp.domain.model.TDefBatchExample;

/**
 * @author Darker.Wang
 * @date 2016-7-8 下午2:17:07
 * @company SINOSOFT
 */
@Service
public class TDefBatchServiceImpl implements TDefBatchService{

	@Autowired
	TDefBatchMapper tDefBatchMapper;
	@Autowired
	SequenceService	sequenceService;
	Logger logger = Logger.getLogger(TDefBatchServiceImpl.class);
	/**
	 * 
	 */
	public TDefBatchServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.TDefBatchService#getBatchNo(java.lang.String)
	 */
	@Override
	@Transactional
	public String getBatchNo(String batchType) {
		// TODO Auto-generated method stub
		TDefBatchExample example = new TDefBatchExample();
		TDefBatchExample.Criteria criteria = example.createCriteria();
		criteria.andBatchTypeEqualTo(batchType);
		int max = tDefBatchMapper.selectMaxBatchNoByExample(example);
		
		if(max > 0){
			List<TDefBatch> tDefBatchs = tDefBatchMapper.selectByExample(example);
			TDefBatch tDefBatch = tDefBatchs.get(0);
			tDefBatch.setBatchNo(Long.parseLong(""+(max+1)));
			tDefBatchMapper.updateByPrimaryKey(tDefBatch);
		}else{
			max = 1;
			TDefBatch tDefBatch = new TDefBatch();
			tDefBatch.setBatchType(batchType);
			tDefBatch.setInsertTime(DateUtils.getCurrentTimestamp());
			String currentDate = DateUtils.getCurrentDate();
			currentDate = currentDate.replace("-","");
			tDefBatch.setDateSerial(currentDate);
			tDefBatch.setBatchNo(Long.parseLong(""+(max+1)));
			tDefBatchMapper.insertSelective(tDefBatch);
		}
		return ""+max;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.TDefBatchService#getBatchNo(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public String getBatchNo(String batchType, BigDecimal comId) {
		// TODO Auto-generated method stub
		return getBatchNo(batchType);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.TDefBatchService#getBatchNo(java.lang.String, java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public String getBatchNo(String batchType, String currentDate,
			BigDecimal comId) {
		return getBatchNo(batchType,currentDate);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.TDefBatchService#getBatchNo(java.lang.String, java.lang.String)
	 */
	@Override
	public String getBatchNo(String batchType, String currentDate) {
		// TODO Auto-generated method stub
		currentDate = currentDate.replace("-","");
		TDefBatchExample example = new TDefBatchExample();
		TDefBatchExample.Criteria criteria = example.createCriteria();
		criteria.andBatchTypeEqualTo(batchType);
		criteria.andDateSerialLike(currentDate);
		int max = tDefBatchMapper.selectMaxBatchNoByExample(example);
		if(max > 0){
			List<TDefBatch> tDefBatchs = tDefBatchMapper.selectByExample(example);
			TDefBatch tDefBatch = tDefBatchs.get(0);
			tDefBatch.setDateSerial(currentDate);
			tDefBatch.setBatchNo(Long.parseLong(""+(max+1)));
			tDefBatchMapper.updateByPrimaryKey(tDefBatch);
		}else{
			max = 1;
			TDefBatch tDefBatch = new TDefBatch();
			tDefBatch.setBatchNo(Long.parseLong(""+(max+1)));
			tDefBatch.setBatchType(batchType);
			tDefBatch.setDateSerial(currentDate);
			tDefBatch.setInsertTime(DateUtils.getCurrentTimestamp());
			tDefBatchMapper.insertSelective(tDefBatch);
		}
		return ""+max;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.TDefBatchService#getTransNo(java.lang.String)
	 */
	@Override
	public String getTransNo(String currentDate) {
		// TODO Auto-generated method stub
		currentDate = currentDate.replace("-","");
		TDefBatchExample example = new TDefBatchExample();
		TDefBatchExample.Criteria criteria = example.createCriteria();
		criteria.andDateSerialEqualTo(currentDate);
		int max = tDefBatchMapper.selectMaxTransNoByExample(example);
		if(max > 0){
			List<TDefBatch> tDefBatchs = tDefBatchMapper.selectByExample(example);
			TDefBatch tDefBatch = tDefBatchs.get(0);
			tDefBatch.setTransNo(Long.parseLong(""+(max+1)));
			tDefBatchMapper.updateByPrimaryKey(tDefBatch);
		}else{
			max = 1;
			TDefBatch tDefBatch = new TDefBatch();
			tDefBatch.setDateSerial(currentDate);
			tDefBatch.setInsertTime(DateUtils.getCurrentTimestamp());
			tDefBatch.setTransNo(Long.parseLong(""+(max+1)));
			tDefBatchMapper.insertSelective(tDefBatch);
		}
		return ""+max;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.TDefBatchService#getTransNo(java.lang.String, java.lang.String)
	 */
	@Override
	public String getTransNo(String currentDate, String companyCode) {
		// TODO Auto-generated method stub
		String num = getTransNo(currentDate);
		num = PubFun.getNumber(num, 10);
		return companyCode+DateUtils.getCurrentDate().replace("-", "")+num;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.TDefBatchService#getBatchNo(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String getBatchNo(String tInsureType, String tBatchType,String tCompanyCode) {
		// TODO Auto-generated method stub
		String tInt = getBatchNo("BATCHNO");
		StringBuffer sb = new StringBuffer();
		sb.append(tCompanyCode);
		sb.append(tInsureType);
		sb.append(tBatchType);
		sb.append(NumberUtils.getNumber(tInt, 10));
		logger.info(" get a new batchNo : "+sb.toString());
		return sb.toString();
	}

}
