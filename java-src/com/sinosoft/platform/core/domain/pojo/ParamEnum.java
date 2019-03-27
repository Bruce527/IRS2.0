/**
 * 
 */
package com.sinosoft.platform.core.domain.pojo;

/**
 * 参数枚举
 * @author Darker.Wang
 * @date 2016-7-26 下午8:11:17
 * @company SINOSOFT
 */
public interface ParamEnum {
	/**存量批次数据**/
	public static final String BATCH_TYPE_HIS = "HIS";
	/**增量批次数据**/
	public static final String BATCH_TYPE_INC = "INC";
	/**失败批次数据**/
	public static final String BATCH_TYPE_FAI = "FAI";
	/**详细批次数据**/
	public static final String BATCH_TYPE_DET = "DET";
	/**其他批次数据**/
	public static final String BATCH_TYPE_OTH = "OTH";
	
	/**增量数据**/
	public static final String DATA_TYPE_I = "I";
	/**存量数据**/
	public static final String BATCH_TYPE_L = "L";
	
	/**寿险**/
	public static final String INSURE_TYPE_L = "L";
	/**财险**/
	public static final String INSURE_TYPE_P = "P";
	/**健康险**/
	public static final String INSURE_TYPE_H = "H";
}
