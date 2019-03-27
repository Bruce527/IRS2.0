/**
 * 
 */
package com.sinosoft.ummp.util;

/**
 * 统一监管平台上下文
 * @author Darker.Wang
 * @date 2016-10-13 下午2:24:04
 * @company SINOSOFT
 */
public interface UMMPContext {
	/** 保单登记平台（与 T_DEF_PLAT_COM 唯一对应） **/
	public static final int SUBMIT_PLAT_PRP = 1;
	/** 江苏中介平台（与 T_DEF_PLAT_COM 唯一对应）**/
	public static final int SUBMIT_PLAT_JSAP = 2;
	/** 北京健康险平台（与 T_DEF_PLAT_COM 唯一对应）**/
	public static final int SUBMIT_PLAT_BJHI = 3;
	/** 北京意外险平台（与 T_DEF_PLAT_COM 唯一对应）**/
	public static final int SUBMIT_PLAT_BJAI = 4;
	/** 上海人身险平台（与 T_DEF_PLAT_COM 唯一对应）**/
	public static final int SUBMIT_PLAT_SHIA = 5;
	/*** 山东意外险平台（山东预警）（与 T_DEF_PLAT_COM 唯一对应）*/
	public static final int SUBMIT_PLAT_SDPT = 6;
	
	/** 系统默认自动用户**/
	public static final String AUTO_USER = "SYS-AUTO";
}
