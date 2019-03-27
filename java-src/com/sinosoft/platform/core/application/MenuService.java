package com.sinosoft.platform.core.application;
/*****************************************************
 * HISTORY
 * 
 * 2013/04/11 yangzd 创建文件
 * 
 * YYYY/MM/DD ----- 增加新功能
 * 
 *****************************************************/
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sinosoft.platform.core.domain.model.DefPrivilege;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.Nodes;
import com.sinosoft.platform.core.util.LoginInfo;

public interface MenuService {

	
	void saveMenu(List<LinkedHashMap<String, Object>> list,LoginInfo loginInfo);

	void updatePrivilege(DefPrivilege defPrivilege,LoginInfo loginInfo);
	
	void deleteMenu(BigDecimal pid,LoginInfo loginInfo);
	
	List<DefPrivilege> loadPrivilege();
	
	List<Nodes> queryMenu() ;
	
	Map<String, Object> getPageList(DataGridModel dgm, DefPrivilege defPrivilege) ;

	DefPrivilege get(BigDecimal key);
	
	List<DefPrivilege> queryMenuByUrl(String url) ;

	DefPrivilege selectById(BigDecimal id);
}
