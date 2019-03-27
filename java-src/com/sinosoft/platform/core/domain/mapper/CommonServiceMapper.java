package com.sinosoft.platform.core.domain.mapper;

import java.math.BigDecimal;
import java.util.Map;

public interface CommonServiceMapper {
	
	/**获取sequence的值
	 * @param paramMap
	 * @return
	 */
	public String getSeqValByName(Map<String,String> paramMap);
	/**获取sequence的值
	 * @param string
	 * @return
	 */
	public BigDecimal getSeqValByName(String seqName);
	
	/**
	 * 获取报表信息
	 * @param reportCode
	 * @return
	 */
	public Map<String, Object> getReportInfo(String reportCode);
	
}
