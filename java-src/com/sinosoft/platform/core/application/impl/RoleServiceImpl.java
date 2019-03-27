package com.sinosoft.platform.core.application.impl;

/*****************************************************
 * HISTORY
 * 
 * 2016/05/12 gzq 创建文件
 * 
 * YYYY/MM/DD ----- 增加新功能
 * 
 *****************************************************/
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.platform.core.application.RoleService;
import com.sinosoft.platform.core.domain.mapper.CommonServiceMapper;
import com.sinosoft.platform.core.domain.mapper.DefPrivilegeMapper;
import com.sinosoft.platform.core.domain.mapper.DefRoleMapper;
import com.sinosoft.platform.core.domain.mapper.DefRolePrivilegeRelaMapper;
import com.sinosoft.platform.core.domain.mapper.DefUserRoleRelaMapper;
import com.sinosoft.platform.core.domain.mapper.RoleServiceMapper;
import com.sinosoft.platform.core.domain.mapper.TDefPlatComMapper;
import com.sinosoft.platform.core.domain.mapper.TDefPlatRoleRelaMapper;
import com.sinosoft.platform.core.domain.model.DefPrivilege;
import com.sinosoft.platform.core.domain.model.DefPrivilegeExample;
import com.sinosoft.platform.core.domain.model.DefRole;
import com.sinosoft.platform.core.domain.model.DefRoleExample;
import com.sinosoft.platform.core.domain.model.DefRolePrivilegeRela;
import com.sinosoft.platform.core.domain.model.DefRolePrivilegeRelaExample;
import com.sinosoft.platform.core.domain.model.DefUserRoleRela;
import com.sinosoft.platform.core.domain.model.DefUserRoleRelaExample;
import com.sinosoft.platform.core.domain.model.TDefPlatCom;
import com.sinosoft.platform.core.domain.model.TDefPlatComExample;
import com.sinosoft.platform.core.domain.model.TDefPlatRoleRela;
import com.sinosoft.platform.core.domain.model.TDefPlatRoleRelaExample;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.platform.core.util.Nodes;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RoleServiceImpl implements RoleService {

	@Autowired
	private DefRoleMapper defRoleMapper;

	@Autowired
	private RoleServiceMapper roleServiceMapper;

	@Autowired
	private DefPrivilegeMapper defPrivilegeMapper;

	@Autowired
	private DefRolePrivilegeRelaMapper defRolePrivilegeRelaMapper;

	@Autowired
	private DefUserRoleRelaMapper defUserRoleRelaMapper;

	@Autowired
	CommonServiceMapper commonService;

	@Autowired
	TDefPlatComMapper tDefPlatComMapper;

	@Autowired
	TDefPlatRoleRelaMapper tDefPlatRoleRelaMapper;

	private static final Logger log = Logger.getLogger(RoleServiceImpl.class);

	/**
	 * 角色列表查询
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public Map<String, Object> getPageList(DataGridModel dgm, DefRole defRole) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		// 分页查询处理
		Map paramMap = new HashMap();
		paramMap.put("roleCode", defRole.getRolecode());
		paramMap.put("roleName", defRole.getRolename());
		paramMap.put("queryStartIndex", dgm.getStartIndex());
		paramMap.put("queryEndIndex", dgm.getEndIndex());
		try {
			int total = roleServiceMapper.queryRoleListInfoCounts(paramMap);
			List<Map> list = roleServiceMapper.queryRoleListInfoPages(paramMap);
			result.put("total", total);
			result.put("rows", list);
		} catch (Exception e) {
			e.printStackTrace();
			paramMap.put("msg", "访问出错：" + e.getMessage());
		}

		return result;
	}

	/**
	 * 删除角色
	 */
	@Transactional
	public void deleteRole(BigDecimal rid, LoginInfo loginInfo) {
		DefRole defRole = this.get(rid);
		if (defRole != null) {
			deleteR2P(defRole.getId(), loginInfo);
			deleteU2R(defRole.getId(), loginInfo);
			deleteR2Plat(defRole.getId());
			defRoleMapper.deleteByPrimaryKey(defRole.getId());
		}
	}

	/**
	 * 增加角色
	 * 
	 * @throws CoreException
	 */
	@Transactional
	public void save(DefRole defRole, LoginInfo loginInfo) throws CoreException {
		checkRole(defRole);
		BigDecimal roleSeq = commonService.getSeqValByName("SEQ_T_DEF_ROLE");
		defRole.setId(roleSeq);
		this.defRoleMapper.insert(defRole);
	}

	/**
	 * 更新角色
	 * 
	 * @throws CoreException
	 */
	@Transactional
	public void updateRole(DefRole defRole, LoginInfo loginInfo)
			throws CoreException {
		if ("".equals(defRole.getRolecode())) {
			log.info("角色编码为空");
			throw new CoreException("角色编码不能为空");
		}
		if ("".equals(defRole.getRolename())) {
			log.info("角色名为空");
			throw new CoreException("角色名不能为空");
		}
		log.debug(defRole.getRolecode());
		this.defRoleMapper.updateByPrimaryKey(defRole);

	}

	/**
	 * 为角色分配菜单
	 */
	@Transactional
	public void saveSet(DefRolePrivilegeRela defRolePrivilegeRela,
			LoginInfo loginInfo) {

		BigDecimal rolePrivilegeSeq = commonService
				.getSeqValByName("SEQ_T_DEF_ROLE_PRIVILEGE_RELA");
		defRolePrivilegeRela.setId(rolePrivilegeSeq);
		this.defRolePrivilegeRelaMapper.insert(defRolePrivilegeRela);
	}

	/**
	 * 根据id得到角色对象
	 */
	@Transactional
	public DefRole get(BigDecimal key) {
		return this.defRoleMapper.selectByPrimaryKey(key);
	}

	/**
	 * 查询角色已有菜单并组成菜单树
	 */
	@Transactional
	public List<Nodes> queryMenu(BigDecimal rid) {
		ArrayList<Nodes> list = (ArrayList<Nodes>) queryMenu(rid, false);
		return list;
	}

	public List<Nodes> queryMenu(List<DefRole> listRole, boolean hasRemoteMenu) {
		ArrayList<DefPrivilege> defPrivilegeList = new ArrayList<DefPrivilege>();
		for (DefRole defRole : listRole) {
			String[] privilegetypes = new String[] { "localmenu", "remotemenu" };
			ArrayList<DefPrivilege> allprivilegeList = new ArrayList<DefPrivilege>();
			allprivilegeList = getDefPrivilegeListWithIdAndTypes(
					defRole.getId(), privilegetypes);
			for (DefPrivilege privilege : allprivilegeList) {
				// 菜单是访问其他系统的（method为system的菜单），校验是否有访问该系统的权限
				if (null != privilege.getMethod()
						&& !"".equals(privilege.getMethod())) {
					if (privilege.getMethod().equals("system")) {
						String result = "";

						DefPrivilegeExample defPrivilegeExample = new DefPrivilegeExample();
						defPrivilegeExample.createCriteria()
								.andPrivilegenameEqualTo(
										privilege.getPrivilegename());
						List<DefPrivilege> privilegeList = this.defPrivilegeMapper
								.selectByExample(defPrivilegeExample);
						if (privilegeList.size() > 0) {
							result = Integer.parseInt(privilegeList.get(0)
									.getId().toString())
									+ 0 + "";
						}
						if (result != null
								&& !result.equals("")
								&& hasPrivilege(defRole.getId(),
										new BigDecimal(result))) {
							defPrivilegeList.add(privilege);
						}
					} else if (hasRemoteMenu) {
						defPrivilegeList.add(privilege);
					}
				} else {
					defPrivilegeList.add(privilege);
				}
			}
		}
		sortDefPrivilegeList(defPrivilegeList);
		ArrayList<Nodes> list = new ArrayList<Nodes>();
		for (DefPrivilege defPrivilege : defPrivilegeList) {
			Nodes nodes = new Nodes();
			nodes.setId(defPrivilege.getId().intValue());
			nodes.setpId(defPrivilege.getPid());
			nodes.setName(defPrivilege.getPrivilegename());
			nodes.setUrl(defPrivilege.getUrl());
			list.add(nodes);
		}
		return list;
	}

	/**
	 * 查询角色已有菜单并组成菜单树 登录页面不显示远程菜单，只显示本地菜单和系统根菜单
	 */
	@Transactional
	public List<Nodes> queryMenu(BigDecimal roleId, boolean hasRemoteMenu) {
		DefRole defRole = defRoleMapper.selectByPrimaryKey(roleId);
		ArrayList<DefRole> listRole = new ArrayList<DefRole>();
		listRole.add(defRole);
		List<Nodes> list = queryMenu(listRole, hasRemoteMenu);
		return list;
	}

	/**
	 * 查询角色已有系统，封装成页面显示需要的Nodes
	 * 
	 * @param rid
	 */
	@Transactional
	public List<Nodes> querySystem(BigDecimal rid) {
		ArrayList<DefPrivilege> privilegeList = getPrivilegeListWithIdAndType(
				rid, "system");
		sortDefPrivilegeList(privilegeList);
		ArrayList<Nodes> list = new ArrayList<Nodes>();
		for (DefPrivilege privilege : privilegeList) {
			Nodes nodes = new Nodes();
			nodes.setId(privilege.getId().intValue());
			nodes.setName(privilege.getPrivilegename());
			list.add(nodes);
		}
		return list;
	}

	/*
	 * 查询所有系统
	 */
	@Transactional
	public List<Nodes> querySystem() {
		List<DefPrivilege> privilegeList = getDefPrivilegeListWithType("system");
		sortDefPrivilegeList(privilegeList);
		ArrayList<Nodes> list = new ArrayList<Nodes>();
		for (DefPrivilege defPrivilege : privilegeList) {
			Nodes nodes = new Nodes();
			nodes.setId(defPrivilege.getId().intValue());
			nodes.setName(defPrivilege.getPrivilegename());
			list.add(nodes);
		}
		return list;
	}

	/**
	 * 查询角色是否拥有权限
	 */
	@Transactional
	public boolean hasPrivilege(BigDecimal roleid, BigDecimal privilegeid) {
		boolean result = false;
		ArrayList<DefPrivilege> privilegeList = getPrivilegeListWithIdAndType(
				roleid, null);
		for (DefPrivilege privilege : privilegeList) {
			if (privilege.getId() == privilegeid) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * 查询角色拥有的权限
	 * 
	 * @param integer
	 *            某个角色id
	 * @param privilegetype
	 *            某个权限类型（localmenu--本地菜单；remotemenu--远程系统菜单；system--系统访问权限）
	 * @return
	 */
	@Transactional
	public ArrayList<DefPrivilege> getPrivilegeListWithIdAndType(
			BigDecimal integer, String privilegetype) {
		ArrayList<DefPrivilege> privilegeList = new ArrayList<DefPrivilege>();
		String[] privilegetypes = new String[1];
		if (null != privilegetype) {
			privilegetypes[0] = privilegetype;
			privilegeList = getDefPrivilegeListWithIdAndTypes(integer,
					privilegetypes);
		} else {
			privilegeList = getDefPrivilegeListWithIdAndTypes(integer,
					new String[0]);
		}
		return privilegeList;
	}

	/**
	 * 查询角色拥有的权限
	 * 
	 * @param integer
	 *            某个角色id
	 * @param privilegetypes
	 *            某个权限类型（localmenu--本地菜单；remotemenu--远程系统菜单；system--系统访问权限）
	 * @return
	 */
	@Transactional
	public ArrayList<DefPrivilege> getDefPrivilegeListWithIdAndTypes(
			BigDecimal roleId, String[] privilegetypes) {
		ArrayList<DefPrivilege> privilegeList = new ArrayList<DefPrivilege>();
		DefRole defRole = this.defRoleMapper.selectByPrimaryKey(roleId);

		List<DefPrivilege> defPrivilege = roleServiceMapper
				.queryPrivilageByRoleID(defRole);

		Iterator<DefPrivilege> iter = defPrivilege.iterator();
		while (iter.hasNext()) {
			DefPrivilege privilege = iter.next();
			if (null != privilegetypes && privilegetypes.length > 0) {
				for (String privilegetype : privilegetypes) {
					if (privilege.getPrivilegetype().equals(privilegetype)) {
						privilegeList.add(privilege);
					}
				}
			} else {
				privilegeList.add(privilege);
			}
		}
		return privilegeList;
	}

	/**
	 * 查询某类权限
	 * 
	 * @param privilegetype
	 *            某个权限类型（localmenu--本地菜单；remotemenu--远程系统菜单；system--系统访问权限）
	 * @return
	 */
	@Transactional
	public List<DefPrivilege> getDefPrivilegeListWithType(String privilegetype) {
		List<DefPrivilege> result = new ArrayList<DefPrivilege>();
		List<DefPrivilege> privilegeList = loadPrivilege();
		for (DefPrivilege privilege : privilegeList) {
			if (privilege.getPrivilegetype().equals("system")) {
				result.add(privilege);
			}
		}
		return result;
	}

	/**
	 * 查询所有菜单
	 * 
	 * @return
	 */
	public List<DefPrivilege> loadPrivilege() {
		DefPrivilegeExample examp = new DefPrivilegeExample();
		List<DefPrivilege> privilegeList = defPrivilegeMapper
				.selectByExample(examp);
		return privilegeList;
	}

	/**
	 * 查询所有权限
	 * 
	 * @return
	 */
	public List<DefRole> loadRole() {
		DefRoleExample examp = new DefRoleExample();
		List<DefRole> roleList = defRoleMapper.selectByExample(examp);
		return roleList;
	}

	/**
	 * 对权限列表按照num大小排序
	 * 
	 * @param privilegeList
	 */
	public void sortDefPrivilegeList(List<DefPrivilege> privilegeList) {
		Collections.sort(privilegeList, new Comparator<DefPrivilege>() {
			public int compare(DefPrivilege p1, DefPrivilege p2) {
				return (p1.getNum() > p2.getNum()) ? 1 : 0;
			}
		});
	}

	/**
	 * 根据角色id删除角色菜单关联关系
	 */
	@Transactional
	public void deleteR2P(BigDecimal rid, LoginInfo loginInfo) {
		deleteR2P(rid, null, loginInfo);
	}
	/**
	 * 删除平台与角色关联
	 * @param roleId
	 */
	private void deleteR2Plat(BigDecimal roleId){
		TDefPlatRoleRelaExample example = new TDefPlatRoleRelaExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		tDefPlatRoleRelaMapper.deleteByExample(example);
	}
	/**
	 * 根据角色id删除角色菜单关联关系，根据privilegetype
	 */
	@Transactional
	public void deleteR2P(BigDecimal rid, String privilegetype,
			LoginInfo loginInfo) {

		DefRolePrivilegeRelaExample examp = new DefRolePrivilegeRelaExample();
		examp.createCriteria().andRoleIdEqualTo(rid);

		List<DefRolePrivilegeRela> rolePrivilegeRelaList = defRolePrivilegeRelaMapper
				.selectByExample(examp);

		Iterator<DefRolePrivilegeRela> iter = rolePrivilegeRelaList.iterator();
		while (iter.hasNext()) {
			DefRolePrivilegeRela defRolePrivilegeRela = iter.next();

			DefPrivilege defPrivilege = this.defPrivilegeMapper
					.selectByPrimaryKey(defRolePrivilegeRela.getPrivilegeId());

			if (privilegetype != null
					&& privilegetype.equals(defPrivilege.getPrivilegetype())) {

				this.defRolePrivilegeRelaMapper
						.deleteByPrimaryKey(defRolePrivilegeRela.getId());
			}
		}
	}

	/**
	 * 根据角色id删除用户角色关联表
	 */
	@Transactional
	public void deleteU2R(BigDecimal rid, LoginInfo loginInfo) {

		DefUserRoleRelaExample examp = new DefUserRoleRelaExample();
		examp.createCriteria().andRoleIdEqualTo(rid);
		List<DefUserRoleRela> defUserRoleRelaList = defUserRoleRelaMapper
				.selectByExample(examp);

		Iterator<DefUserRoleRela> iter = defUserRoleRelaList.iterator();
		while (iter.hasNext()) {
			DefUserRoleRela defUserRoleRela = iter.next();
			this.defUserRoleRelaMapper.deleteByPrimaryKey(defUserRoleRela
					.getId());
		}
	}

	/**
	 * 查询角色树
	 */
	@Transactional
	public List<Nodes> queryRole(BigDecimal userId) {
		List<DefRole> roleList = loadRole();
		List<Nodes> list = new ArrayList<Nodes>();
		DefUserRoleRelaExample example = new DefUserRoleRelaExample();
		if (userId != null) {
			example.createCriteria().andUserIdEqualTo(userId.toString());
			List<DefUserRoleRela> list2 = defUserRoleRelaMapper
					.selectByExample(example);
			List<Integer> ids = new ArrayList<Integer>();
			for (DefUserRoleRela r : list2) {
				ids.add(r.getRoleId().intValue());
			}
			for (DefRole role : roleList) {
				if (ids.contains(role.getId().intValue())) {
					continue;
				}
				Nodes nodes = new Nodes();
				nodes.setId(role.getId().intValue());
				nodes.setName(role.getRolename());
				list.add(nodes);
			}
		} else {
			for (DefRole role : roleList) {
				Nodes nodes = new Nodes();
				nodes.setId(role.getId().intValue());
				nodes.setName(role.getRolename());
				list.add(nodes);
			}
		}

		return list;
	}

	/**
	 * 角色校验
	 * 
	 * @throws CoreException
	 */
	@Transactional
	public void checkRole(DefRole defRole) throws CoreException {
		if ("".equals(defRole.getRolename())) {
			log.info("角色名为空");
			throw new CoreException("角色名不能为空");
		} else {
			ArrayList<DefRole> rolelist = this.roleServiceMapper
					.queryRoleByRoleName(defRole);
			if (rolelist.size() > 0) {
				log.info("该角色已经存在");
				throw new CoreException("该角色已经存在");
			}
		}
		if ("".equals(defRole.getRolecode())) {
			log.info("角色编码为空");
			throw new CoreException("角色编码不能为空");
		} else {
			ArrayList<DefRole> rolelist = this.roleServiceMapper
					.queryRoleByRoleCode(defRole);
			if (rolelist.size() > 0) {
				log.info("角色编码已经存在");
				throw new CoreException("角色编码已经存在");
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ArrayList menuIdaddPid(ArrayList distinctMenuId1) {
		// TODO Auto-generated method stub
		ArrayList array = new ArrayList();
		for (int i = 0; i < distinctMenuId1.size(); i++) {
			String id1 = distinctMenuId1.get(i).toString();
			if (!array.contains(id1)) {
				array.add(id1);
			}
			DefPrivilege key = defPrivilegeMapper
					.selectByPrimaryKey(new BigDecimal(id1));
			if (key.getPid() != null && key.getPid() != "") {
				if (!array.contains(key.getPid().toString())) {
					array.add(key.getPid().toString());
				} else {
					continue;
				}
			}
		}
		return array;
	}

	@Override
	public DefRole selectById(BigDecimal id) {
		DefRoleExample example = new DefRoleExample();
		example.createCriteria().andIdEqualTo(id);
		List<DefRole> defRoleMapping = this.defRoleMapper
				.selectByExample(example);
		return defRoleMapping.get(0);
	}

	@Override
	public List<Nodes> queryPlat() {
		TDefPlatComExample example = new TDefPlatComExample();
		List<TDefPlatCom> com = tDefPlatComMapper.selectByExample(example);
		ArrayList<Nodes> list = new ArrayList<Nodes>();
		for (TDefPlatCom rr : com) {
			Nodes nodes = new Nodes();
			nodes.setId(rr.getComId().intValue());
			nodes.setName(rr.getComNameShort());
			list.add(nodes);
		}
		return list;
	}

	@Override
	public List<Nodes> queryPlat(BigDecimal roleId) {
		TDefPlatRoleRelaExample example = new TDefPlatRoleRelaExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		List<TDefPlatRoleRela> rr = tDefPlatRoleRelaMapper
				.selectByExample(example);
		List<BigDecimal> values = new ArrayList<BigDecimal>();
		ArrayList<Nodes> lis = new ArrayList<Nodes>();
		for (TDefPlatRoleRela oo : rr) {
			BigDecimal id = oo.getComId();
			values.add(id);
		}
		TDefPlatComExample pcom = new TDefPlatComExample();
		pcom.createCriteria().andComIdIn(values);
		List<TDefPlatCom> list = tDefPlatComMapper.selectByExample(pcom);
		for (TDefPlatCom tt : list) {
			Nodes nodes = new Nodes();
			nodes.setId(tt.getComId().intValue());
			nodes.setName(tt.getComNameShort());
			lis.add(nodes);
		}
		return lis;
	}

	/**
	 * 角色分配平台ID
	 */
	@SuppressWarnings("rawtypes")
	@Transactional
	@Override
	public void dealWithPlatId(BigDecimal roleId, ArrayList platIds) {
		TDefPlatRoleRelaExample example = new TDefPlatRoleRelaExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		tDefPlatRoleRelaMapper.deleteByExample(example);
		for (Object ids : platIds) {
			BigDecimal id = commonService
					.getSeqValByName("SEQ_T_DEF_PLAT_ROLE_RELA");
			TDefPlatRoleRela record = new TDefPlatRoleRela();
			record.setId(id);
			record.setRoleId(roleId);
			record.setComId(new BigDecimal(ids.toString()));
			tDefPlatRoleRelaMapper.insert(record);
			record = null;
		}
	}
}