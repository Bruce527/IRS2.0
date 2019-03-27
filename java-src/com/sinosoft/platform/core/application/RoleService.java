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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sinosoft.platform.core.domain.model.DefPrivilege;
import com.sinosoft.platform.core.domain.model.DefRole;
import com.sinosoft.platform.core.domain.model.DefRolePrivilegeRela;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.platform.core.util.Nodes;

public interface RoleService {
	void updateRole(DefRole defRole,LoginInfo loginInfo) throws CoreException;

	void deleteRole(BigDecimal rid,LoginInfo loginInfo);

	void deleteR2P(BigDecimal rid,LoginInfo loginInfo);

	void deleteR2P(BigDecimal rid, String privilegetype,LoginInfo loginInfo);

	void save(DefRole defRole,LoginInfo loginInfo) throws CoreException;

	void saveSet(DefRolePrivilegeRela defRolePrivilegeRela,LoginInfo loginInfo);
	
	DefRole get(BigDecimal key);
	
	void sortDefPrivilegeList(List<DefPrivilege> privilegeList);

	List<Nodes> queryMenu(BigDecimal rid);
	
	List<Nodes> queryMenu(List<DefRole> listRole, boolean hasRemoteMenu);

	Map<String, Object> getPageList(DataGridModel dgm, DefRole defRole);
	
	List<Nodes> queryRole(BigDecimal userId);

	List<Nodes> querySystem(BigDecimal rid);

	List<Nodes> querySystem();

	List<Nodes> queryMenu(BigDecimal rid, boolean hasRemoteMenu);

	@SuppressWarnings("rawtypes")
	ArrayList menuIdaddPid(ArrayList distinctMenuId1);

	DefRole selectById(BigDecimal id);

	List<Nodes> queryPlat();

	List<Nodes> queryPlat(BigDecimal bigDecimal);

	@SuppressWarnings("rawtypes")
	void dealWithPlatId(BigDecimal roleId, ArrayList platIds);

}
