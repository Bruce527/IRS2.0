package com.sinosoft.platform.core.domain.mapper;

import java.util.List;

import com.sinosoft.platform.core.domain.model.DefReportCol;
import com.sinosoft.platform.core.domain.model.DefUserExample;




public interface DefReportColMapper {

	List<DefReportCol> selectByExample(DefUserExample defReportColExample);
	
}
