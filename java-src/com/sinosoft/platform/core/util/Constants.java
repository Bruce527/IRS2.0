package com.sinosoft.platform.core.util;

/**
 * 上下文基本配置类<br>
 * 
 * @author Darker.Wang
 * @date 2016-8-11 下午5:25:41
 * @company SINOSOFT
 */

public class Constants {
	/**添加操作命名标识**/
	public final static String OPERATE_TYPE_ADD = "0";
	/**更新操作命名标识**/
	public final static String OPERATE_TYPE_UPDATE = "1";
	/**删除操作命名标识**/
	public final static String OPERATE_TYPE_DELETE = "2";
	/**返回失败标识**/
	public final static String RESULT_FAILED = "0";
	/**返回成功标识**/
	public final static String RESULT_SUCCESS = "1";
	/**用户Session标注定义码：用于送Session中取和存**/
	public final static String USER_INFO_SESSION = "userSessionInfo";
	/**
	 * 批处理执行用户
	 */
	public final static String JOB_USER = "SYS-AUTO";
	/**
	 * 是否需要改变编码
	 */
	public static final boolean CHANGECHARSET = false; // Unicode to GBK

}
