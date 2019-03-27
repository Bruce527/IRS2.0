/**
 * 
 */
package com.sinosoft.ummp.application.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.ummp.application.SendConfigService;
import com.sinosoft.ummp.domain.mapper.TDefSendMapper;
import com.sinosoft.ummp.domain.mapper.TDefSftpMapper;
import com.sinosoft.ummp.domain.model.TDefSend;
import com.sinosoft.ummp.domain.model.TDefSendExample;
import com.sinosoft.ummp.domain.model.TDefSftp;
import com.sinosoft.ummp.domain.model.TDefSftpExample;
import com.sinosoft.ummp.domain.pojo.SFTPConfigPOJO;

/**
 * @author Darker.Wang
 * @date 2016-6-30 下午1:42:20
 * 
 */
@Service
public class SendConfigServiceImpl implements SendConfigService{

	@Autowired
	TDefSendMapper tDefSendMapper;
	@Autowired
	TDefSftpMapper tDefSftpMapper;
	@Autowired
	SequenceService sequenceService;
	/**
	 * 
	 */
	public SendConfigServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.SendConfigService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public TDefSend selectByComId(Integer comId) {
		// TODO Auto-generated method stub
		TDefSendExample example = new TDefSendExample();
				example.createCriteria().andComIdEqualTo(new BigDecimal(comId));
		List<TDefSend> tDefSends = tDefSendMapper.selectByExample(example); 
		if(tDefSends == null || tDefSends.size() < 1){
			return null;
		}
		return tDefSends.get(0);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.SendConfigService#selectByPrimaryKey(com.sinosoft.ummp.domain.model.TDefSend)
	 */
	@Override
	public TDefSend saveTDefSend(TDefSend tDefSend) {
		// TODO Auto-generated method stub
		try{
			BigDecimal id = tDefSend.getId();
			BigDecimal comId = tDefSend.getComId();
			TDefSend eTDefSend = selectByComId(Integer.parseInt(""+comId));
			if(eTDefSend == null ){
				id = new BigDecimal(sequenceService.getSeqValByName("SEQ_T_DEF_SEND"));
				tDefSend.setId(id);
				tDefSendMapper.insert(tDefSend);
			}else{
				tDefSend.setId(eTDefSend.getId());
				tDefSendMapper.updateByPrimaryKeySelective(tDefSend);	
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return tDefSend;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.SendConfigService#saveSFTPInfo(com.sinosoft.ummp.domain.pojo.SFTPConfigPOJO)
	 */
	@Override
	public boolean saveSFTPInfo(SFTPConfigPOJO pojo) {
		// TODO Auto-generated method stub
		TDefSftpExample example = null;
		if(pojo.getComId() != null){
			example = new TDefSftpExample();
			example.createCriteria().andComIdEqualTo(pojo.getComId());
		}
		if(pojo.getRoleId() != null){
			if(example == null){
				example = new TDefSftpExample();
			}
			example.createCriteria().andRoleIdEqualTo(pojo.getRoleId());
		}
		List<TDefSftp> tDefSftps = null;
		if(example != null){
			tDefSftps = tDefSftpMapper.selectByExample(example);
		}
		//存在
		if(tDefSftps != null && tDefSftps.size() > 0){
			for(TDefSftp sftp : tDefSftps){
				//根据ID更新
				TDefSftp tDefSftp_u_c = null;
				TDefSftp tDefSftp_d_c = null;
				if(sftp.getSftpType().equals("U")){
					tDefSftp_u_c = buildSFTPUpChange(sftp,pojo);
					TDefSftpExample example_u = new TDefSftpExample();
					example_u.createCriteria().andIdEqualTo(tDefSftp_u_c.getId());
					tDefSftpMapper.updateByExampleSelective(tDefSftp_u_c, example_u);
				}else{
					tDefSftp_d_c = buildSFTPDownChange(sftp,pojo);
					TDefSftpExample example_d = new TDefSftpExample();
					example_d.createCriteria().andIdEqualTo(tDefSftp_d_c.getId());
					tDefSftpMapper.updateByExampleSelective(tDefSftp_d_c, example_d);
				}
			}
			return true;
		}
		//不存在，则新增
		TDefSftp tDefSftp_u = buildSFTPUp(pojo);
		TDefSftp tDefSftp_d = buildSFTPDown(pojo);
		tDefSftpMapper.insert(tDefSftp_u);
		tDefSftpMapper.insert(tDefSftp_d);
		return true;
	}

	/**
	 * 构建上载SFTP
	 * @param pojo
	 * @return
	 */
	private TDefSftp buildSFTPUp(SFTPConfigPOJO pojo){
		String id_u = sequenceService.getSeqValByName("SEQ_T_DEF_SFTP");
		TDefSftp tDefSftp_u = new TDefSftp();
		tDefSftp_u.setId(Integer.parseInt(id_u));
		tDefSftp_u.setRoleId(pojo.getRoleId());
		tDefSftp_u.setComId(pojo.getComId());
		tDefSftp_u.setSftpPort(pojo.getUpPort());
		tDefSftp_u.setSftpIp(pojo.getUpIP());
		tDefSftp_u.setVisitUser(pojo.getUpUser());
		tDefSftp_u.setVisitPass(pojo.getUpPass());
		tDefSftp_u.setVisitUrl(pojo.getUpURL());
		tDefSftp_u.setSftpType("U");
		tDefSftp_u.setSftpUseType("FILE");
		tDefSftp_u.setIsNeedKey(Short.parseShort("0"));
		tDefSftp_u.setVisitKey(null);
		tDefSftp_u.setRemark("");
		tDefSftp_u.setSftpDisc("上载服务器");
		tDefSftp_u.setEsStatus(Short.parseShort("1"));
		return tDefSftp_u;
	}
	/**
	 * 构建下载SFTP
	 * @param pojo
	 * @return
	 */
	private TDefSftp buildSFTPDown(SFTPConfigPOJO pojo){
		String id_d = sequenceService.getSeqValByName("SEQ_T_DEF_SFTP");
		TDefSftp tDefSftp_d = new TDefSftp();
		tDefSftp_d.setId(Integer.parseInt(id_d));
		tDefSftp_d.setRoleId(pojo.getRoleId());
		tDefSftp_d.setComId(pojo.getComId());
		tDefSftp_d.setSftpPort(pojo.getDownPort());
		tDefSftp_d.setSftpIp(pojo.getDownIP());
		tDefSftp_d.setVisitUser(pojo.getDownUser());
		tDefSftp_d.setVisitPass(pojo.getDownPass());
		tDefSftp_d.setVisitUrl(pojo.getDownURL());
		tDefSftp_d.setSftpType("D");
		tDefSftp_d.setSftpUseType("FILE");
		tDefSftp_d.setIsNeedKey(Short.parseShort("0"));
		tDefSftp_d.setVisitKey(null);
		tDefSftp_d.setRemark("");
		tDefSftp_d.setSftpDisc("下载服务器");
		tDefSftp_d.setEsStatus(Short.parseShort("1"));
		return tDefSftp_d;
	}
	/**
	 * 上载服务修改
	 * @param tDefSftp_c
	 * @param pojo
	 * @return
	 */
	private TDefSftp buildSFTPUpChange(TDefSftp tDefSftp_c,SFTPConfigPOJO pojo){
		if(tDefSftp_c.getComId() != pojo.getComId()){
			tDefSftp_c.setComId(pojo.getComId());
		}
		if(tDefSftp_c.getRoleId() != pojo.getRoleId()){
			tDefSftp_c.setRoleId(pojo.getRoleId());
		}
		tDefSftp_c.setSftpPort(pojo.getUpPort());
		tDefSftp_c.setSftpIp(pojo.getUpIP());
		tDefSftp_c.setVisitUser(pojo.getUpUser());
		tDefSftp_c.setVisitPass(pojo.getUpPass());
		tDefSftp_c.setVisitUrl(pojo.getUpURL());
		return tDefSftp_c;
	}
	/**
	 * 下载服务修改
	 * @param tDefSftp_c
	 * @param pojo
	 * @return
	 */
	private TDefSftp buildSFTPDownChange(TDefSftp tDefSftp_c,SFTPConfigPOJO pojo){
		if(tDefSftp_c.getComId() != pojo.getComId()){
			tDefSftp_c.setComId(pojo.getComId());
		}
		if(tDefSftp_c.getRoleId() != pojo.getRoleId()){
			tDefSftp_c.setRoleId(pojo.getRoleId());
		}
		tDefSftp_c.setSftpPort(pojo.getDownPort());
		tDefSftp_c.setSftpIp(pojo.getDownIP());
		tDefSftp_c.setVisitUser(pojo.getDownUser());
		tDefSftp_c.setVisitPass(pojo.getDownPass());
		tDefSftp_c.setVisitUrl(pojo.getDownURL());
		return tDefSftp_c;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.SendConfigService#querySFTPInfo(com.sinosoft.ummp.domain.pojo.SFTPConfigPOJO)
	 */
	@Override
	public SFTPConfigPOJO querySFTPInfo(SFTPConfigPOJO pojo) {
		// TODO Auto-generated method stub
		TDefSftpExample example = null;
		if(pojo.getComId() != null){
			example = new TDefSftpExample();
			example.createCriteria().andComIdEqualTo(pojo.getComId());
		}
		if(pojo.getRoleId() != null){
			if(example == null){
				example = new TDefSftpExample();
			}
			example.createCriteria().andRoleIdEqualTo(pojo.getRoleId());
		}
		List<TDefSftp> tDefSftps = null;
		if(example != null){
			tDefSftps = tDefSftpMapper.selectByExample(example);
		}
		if(tDefSftps == null || tDefSftps.size() < 0){
			return null;
		}
		SFTPConfigPOJO rtvPojo = new SFTPConfigPOJO();
		rtvPojo.setComId(pojo.getComId());
		rtvPojo.setRoleId(pojo.getRoleId());
		for(TDefSftp sftp : tDefSftps){
			if(sftp.getSftpType().equals("U")){//上载服务器
//				rtvPojo.setId(sftp.getId());
				rtvPojo.setUpIP(sftp.getSftpIp());
				rtvPojo.setUpPort(sftp.getSftpPort());
				rtvPojo.setUpUser(sftp.getVisitUser());
				rtvPojo.setUpPass(sftp.getVisitPass());
				rtvPojo.setUpURL(sftp.getVisitUrl());
				continue;
			}
			if(sftp.getSftpType().equals("D")){//下载服务器
//				rtvPojo.setId(sftp.getId());
				rtvPojo.setDownIP(sftp.getSftpIp());
				rtvPojo.setDownPort(sftp.getSftpPort());
				rtvPojo.setDownUser(sftp.getVisitUser());
				rtvPojo.setDownPass(sftp.getVisitPass());
				rtvPojo.setDownURL(sftp.getVisitUrl());
				continue;
			}
		}
		return rtvPojo;
	}
}
