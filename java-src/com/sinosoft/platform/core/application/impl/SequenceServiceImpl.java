/**
 * 
 */
package com.sinosoft.platform.core.application.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.domain.mapper.CommonServiceMapper;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;


/**
 * <p>序列操作服务类(工具服务类)<p>
 * @author Darker.Wang
 * @date 2016-5-23 下午 9:29:00
 * @version 1.0
 * @company SINOSOFT
 */
@Service(value="sequenceService")
public class SequenceServiceImpl implements SequenceService{

	@Autowired
	CommonServiceMapper commonServiceMapper;
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.SequenceService#getSeqValByName(java.lang.String)
	 */
	@Override
	public String getSeqValByName(String seqName) {
		BigDecimal value = null;
		try{
			value = commonServiceMapper.getSeqValByName(seqName);
			return value.toString();
		}catch(Exception e){
			System.out.println("SequenceService : no sequence "+seqName+" and create it now ");
			this.addSequnce(seqName, 1, 1);
			value = commonServiceMapper.getSeqValByName(seqName);
			return value.toString();
		}
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.SequenceService#addSequnce(java.lang.String, int, int)
	 */
	@Override
	public int addSequnce(String seqName, int start, int step) {
		// TODO Auto-generated method stub
		try{
			String sql = "create sequence "+seqName
					+" minvalue 1"
					+" maxvalue 9999999999999999999"
					+" start with "+start
					+" increment by "+step
					+" cache 20";
			SqlAdapter sqlAdapter = new SqlAdapter();
			sqlAdapter.setSql(sql);
			return sqlAdapterMapper.excuteInsert(sqlAdapter); 
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("SequenceService : create sequence named "+seqName+" failed!");
			return -1;
		}
	}


	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.SequenceService#delSequnce(java.lang.String)
	 */
	@Override
	public int delSequnce(String seqName) {
		// TODO Auto-generated method stub
		try{
			String sql = "DROP SEQUENCE "+seqName;
			SqlAdapter sqlAdapter = new SqlAdapter();
			sqlAdapter.setSql(sql);
			return sqlAdapterMapper.excuteDelete(sqlAdapter);
		}catch(Exception e){
			System.out.println("SequenceService : no sequence named "+seqName +" exists!");
		}
		return -1;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.SequenceService#getSerialNo()
	 */
	@Override
	public BigDecimal getSerialNo() {
		// TODO Auto-generated method stub
		BigDecimal serialNo = this.getBigSeqValByName("SEQ_SERIALNO");
		return serialNo;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.SequenceService#getSerialNo(int)
	 */
	@Override
	public String getSerialNo(int length) {
		// TODO Auto-generated method stub
		String serialNo = this.getSeqValByName("SEQ_SERIALNO");
		if(length < serialNo.length()){
			return serialNo.toString();
		}
		int size = serialNo.length();
		for(int i = 0; i < length-size; i++){
			serialNo = "0"+serialNo;
		}
		return serialNo;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.SequenceService#getSerialNo(java.lang.String, int)
	 */
	@Override
	public String getSerialNo(String seqName, int length) {
		// TODO Auto-generated method stub
		String serialNo = this.getSeqValByName(seqName);
		if(length < serialNo.length()){
			return serialNo.toString();
		}
		int size = serialNo.length();
		for(int i = 0; i < length-size; i++){
			serialNo = "0"+serialNo;
		}
		return serialNo;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.SequenceService#getMaxNo(java.lang.String, int)
	 */
	@Override
	public String getMaxNo(String seqName, int length) {
		// TODO Auto-generated method stub
		String maxNo = this.getSeqValByName(seqName);
		if(length < maxNo.length()){
			return maxNo;
		}
		int size = maxNo.length();
		for(int i = 0; i < length-size; i++){
			maxNo = "0"+maxNo;
		}
		return maxNo;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.SequenceService#getBigSeqValByName(java.lang.String)
	 */
	@Override
	public BigDecimal getBigSeqValByName(String seqName) {
		// TODO Auto-generated method stub
		BigDecimal value = null;
		try{
			value = commonServiceMapper.getSeqValByName(seqName);
			return value;
		}catch(Exception e){
			System.out.println("SequenceService : no sequence named "+seqName+" and create it now ");
			this.addSequnce(seqName, 1, 1);
			value = commonServiceMapper.getSeqValByName(seqName);
			return value;
		}
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.SequenceService#getSeqValByName(java.lang.String, int)
	 */
	@Override
	public String getSeqValByName(String seqName, int length) {
		// TODO Auto-generated method stub
		String value = this.getSeqValByName(seqName);
		if(length < value.length()){
			return value;
		}
		int size = value.length();
		for(int i = 0; i < length-size; i++){
			value = "0"+value;
		}
		return value;
	}

}
