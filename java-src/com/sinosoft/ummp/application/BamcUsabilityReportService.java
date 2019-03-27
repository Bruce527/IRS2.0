/**
 * 
 */
package com.sinosoft.ummp.application;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;



/**
 * 可用性信息上送接口【主动心跳检测接口】(BAMC_USABILITY_REPORT)<br>
 * 用于心跳监控作业接口，原则上不小于1分钟，默认5分钟执行一次
 * <p>FROM AXA Application Manage and Control interface<p>
 * @author Darker.Wang
 * @date 2016-10-8 上午9:43:27
 * @company SINOSOFT
 * @version 2.0
 */
public interface BamcUsabilityReportService {
	/** 01 主机应用监控 **/
	public static final String BAMC_UR_TYPE_MAIN = "01";
	/** 02 开放平台应用监控 **/
	public static final String BAMC_UR_TYPE_OPEN = "02";
	/** 03 分行自行开发应用监控 **/
	public static final String BAMC_UR_TYPE_SELF = "03";
	/** 0:正常 **/
	public static final String BAMC_UR_STATUS_LIVE = "0";
	/** 1:警告 **/
	public static final String BAMC_UR_STATUS_WORRY = "1";
	/** 2:故障 **/
	public static final String BAMC_UR_STATUS_ERROR = "2";
	/**
	 * 获取日志根目录
	 * @return
	 */
	public String getLogRootPath();
	/**
	 * 设置日志根目录
	 * @return
	 */
	public void setLogRootPath(String logRootPath);
	
	/**
	 * 发送消息
	 * @param msg 根据服务端确定发送数据的格式
	 * @return 1-成功 0-失败 -1-异常
	 * @throws  
	 */
	public int sendMsg(String msg);
	/**
	 * 构建AMC信息
	 * @param pojo
	 * @param amcType 在 amc.service.properties 中配置的第二个标识，如： UR_LIVE_XX 
	 * @return
	 */
	String buildMsg(ParamPOJO pojo, String amcType);
}
