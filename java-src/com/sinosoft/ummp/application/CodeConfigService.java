/**
 * 
 */
package com.sinosoft.ummp.application;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.ummp.domain.model.TDefTransCode;


public interface CodeConfigService {

	Map<String, Object> getPageList(DataGridModel dgm, TDefTransCode transCode);

	void deleteByPremaryKey(BigDecimal id);

	List<TDefTransCode> queryCodeType();

}
