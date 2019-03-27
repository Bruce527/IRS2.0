/**
 * 
 */
package com.sinosoft.ummp.application.impl;

import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.util.UDPClient;
import com.sinosoft.ummp.application.BamcUsabilityReportService;
import com.sinosoft.ummp.exception.CISException;
import com.sinosoft.ummp.exception.CISExceptionRunable;

import config.Config;

/**
 * 可用性信息上送接口,心跳监控作业实现类
 * @author Darker.Wang
 * @date 2016-10-8 上午9:44:10
 * @company SINOSOFT
 */
@Service("bamcUsabilityReportService")
public class BamcUsabilityReportServiceImpl implements BamcUsabilityReportService {

	
	String logRootPath = null;
	
	private static Logger logger = Logger.getLogger(BamcUsabilityReportServiceImpl.class);
	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.quartz.jobs.HeartBeatJob#buildMsg(com.sinosoft.platform.core.domain.pojo.ParamPOJO)
	 */
	@Override
	public String buildMsg(ParamPOJO pojo,String amcType) {
		logger.debug("- AMC type: "+amcType);
		// TODO 构建报送XML
		logger.debug(pojo);
		/**
		 * APPSNAME:ICP (上报应用简称)
		 * TYPE :01-主机应用监控 02-开放平台应用监控 03-分行自行开发应用监控 (监控类别)
		 * IP : (上报地点 开放平台应用：IP地址 主机应用：分区序号)
		 * OCCUREDAPPSNAME 发生应用简称
		 * OCCUREDIP 发生地点
		 * MODULECODE 模块代码
		 * SUBMODULECODE 子模块代码
		 * STATUS 状态标志 
		 * MSG 状态信息
		 * **/
		String IP = Config.getAppsIP();
		String APPSNAME = Config.getAppsName();
		Properties prop = Config.getProperties("amc.service");
		
		StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"GBK\" ?>");
		sb.append("<APPROOT type=\"BAMC_USABILITY_REPORT\" ver=\"2.0\" from =\""+APPSNAME+"\" to=\"F-AMC\" mode=\"asy\">");
		/** 上报可用性报文的网关设备IP **/
		
		Config.CodeMap codeMap = Config.createCodeMap("UR");
		//公共部分
		sb.append(_buildMsgPublic(APPSNAME,"02",IP));
		//私有部分
		sb.append("<PRIVATE>");
		//ROWSET
		sb.append("<ROWSET>");
		
		/**** 配置文件控制 ****/
		
		//一下部分支持单个
		Map<String,Map<String,String>> codes = codeMap.getCodeMap(prop);
		if(codes.containsKey(amcType)){
			Map<String,String> cm = codes.get(amcType);
			String rName = cm.get("OCCUREDAPPSNAME");
			String rIp = cm.get("OCCUREDIP");
			String rModel = cm.get("MODULECODE");
			String rSubModel = cm.get("SUBMODULECODE");
			String rStatus = cm.get("STATUS");
			String rMsg = cm.get("MSG");
			sb.append(_buildMsgRow(rName,rIp,rModel,rSubModel,rStatus,rMsg));
		}
//		//以下部分支持多个
//		Iterator<String> iter = codes.keySet().iterator();
//		while(iter.hasNext()){
//			String key = iter.next();
//			Map<String,String> cm = codes.get(key);
//			String rName = cm.get("OCCUREDAPPSNAME");
//			String rIp = cm.get("OCCUREDIP");
//			String rModel = cm.get("MODULECODE");
//			String rSubModel = cm.get("SUBMODULECODE");
//			String rStatus = cm.get("STATUS");
//			String rMsg = cm.get("MSG");
//			sb.append(_buildMsgRow(rName,rIp,rModel,rSubModel,rStatus,rMsg));
//		}
		
		//多个监测可以重复ROW
		sb.append("</ROWSET>");
		sb.append("</PRIVATE>");
		sb.append("</APPROOT>");
		return sb.toString();
	}
	/**
	 * 
	 * @param appsName 通用网关应用 EG:F-CGSE
	 * @param type 01-主机应用监控  02-开发平台应用监控 03-分行自行开发应用监控
	 * @param ip 上报可用性报文的网关设备IP
	 * @return 
	 */
	public String _buildMsgPublic(String appsName,String type,String ip){
		System.out.println("- 监测上报 APP: "+appsName+" IP: "+ip+" TYPE: "+type);
		StringBuffer sb = new StringBuffer();
		sb.append("<PUBLIC>");
		sb.append("<APPSNAME>"+appsName+"</APPSNAME>");//通用网关应用
		sb.append("<TYPE>"+type+"</TYPE>");//开发平台应用监控
		sb.append("<IP>"+ip+"</IP>");//上报可用性报文的网关设备IP
		sb.append("</PUBLIC>");//
		return sb.toString();
	}
	/**
	 * 
	 * @param occuredAppsName 网关监测名称 EG:F-EBANKP
	 * @param occuredIp 可用性的设备IP
	 * @param moduleCode 模块名称
	 * @param subModuleCode 子模块名称
	 * @param status 状态： 0-正常 1-警告 2-故障 
	 * @param msg 状态信息描述
	 * @return
	 */
	public String _buildMsgRow(String occuredAppsName,String occuredIp,
			String moduleCode,String subModuleCode,String status,String msg){
		System.out.println("- 具体监测 OCCAPPNAME: "+occuredAppsName
				+" OCCIP: "+occuredIp
				+" MCODE: "+moduleCode
				+" SMCODE: "+subModuleCode
				+" STATUS: "+status
				+" MSG: "+msg);
		StringBuffer sb = new StringBuffer();
		sb.append("<ROW>");
		sb.append("<OCCUREDAPPSNAME>"+occuredAppsName+"</OCCUREDAPPSNAME>");//-网关监测个人网银
		sb.append("<OCCUREDIP>"+occuredIp+"</OCCUREDIP>");//个人网银发生可用性的设备IP
		sb.append("<MODULECODE>"+moduleCode+"</MODULECODE>");//模块名称
		sb.append("<SUBMODULECODE>"+subModuleCode+"</SUBMODULECODE>");//子模块名称
		sb.append("<STATUS>"+status+"</STATUS>");//状态
		sb.append("<MSG>"+msg+"</MSG>");//状态信息
		sb.append("</ROW>");
		return sb.toString();
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.quartz.jobs.BamcUsabilityReportJob#sendMsg(java.lang.String)
	 */
	@Override
	public int sendMsg(String msg){
		try {
			logger.info("- sendMsg doing ... ");
			String remoteHost = (String) Config.getProperties("amc.service").get("AMC_REMOTE_HOST");
			int remotePort = Integer.parseInt((String) Config.getProperties("amc.service").get("AMC_REMOTE_PORT"));
			UDPClient client = new UDPClient(remoteHost,remotePort);
			client.setBasePath(getLogRootPath());
			logger.info("- heart log path : "+client.getBasePath());
			return client.sendMsg(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			new CISException("心跳报送失败",CISExceptionRunable.EXCEPTION_ERROR_L3);
			return -1;
		}
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.BamcUsabilityReportService#getLogRootPath()
	 */
	@Override
	public String getLogRootPath() {
		// TODO Auto-generated method stub
		if(logRootPath == null || "".equals(logRootPath)){
			logRootPath = Config.getProperties().getProperty("ROOT_PATH");
		}
		return logRootPath;
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.BamcUsabilityReportService#setLogRootPath()
	 */
	@Override
	public void setLogRootPath(String logRootPath) {
		// TODO Auto-generated method stub
		this.logRootPath = logRootPath;
	}
}
