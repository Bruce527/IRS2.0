package com.sinosoft.ummp.application;
/*****************************************************
 * HISTORY
 * 
 * 2016/06/21 lht 创建文件
 * 
 * YYYY/MM/DD ----- 增加新功�?
 * 
 *****************************************************/
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sinosoft.platform.core.domain.model.TDefManageCom;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;

public interface ManageComService {

	void saveManageCom(TDefManageCom tDefManageCom,LoginInfo loginInfo) throws CoreException;

	void updateManageCom(TDefManageCom tDefManageCom,LoginInfo loginInfo);
	
	void deleteManageCom(BigDecimal id);
	
	List<TDefManageCom> loadManageCom();
	
	Map<String, Object> getPageList(DataGridModel dgm, TDefManageCom tDefManageCom) ;

	TDefManageCom get(BigDecimal key);

	TDefManageCom selectById(BigDecimal id);
}
