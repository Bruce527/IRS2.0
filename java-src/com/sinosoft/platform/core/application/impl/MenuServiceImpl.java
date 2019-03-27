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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.platform.core.application.MenuService;
import com.sinosoft.platform.core.domain.mapper.CommonServiceMapper;
import com.sinosoft.platform.core.domain.mapper.DefPrivilegeMapper;
import com.sinosoft.platform.core.domain.mapper.DefRolePrivilegeRelaMapper;
import com.sinosoft.platform.core.domain.mapper.MenuServiceMapper;
import com.sinosoft.platform.core.domain.model.DefPrivilege;
import com.sinosoft.platform.core.domain.model.DefPrivilegeExample;
import com.sinosoft.platform.core.domain.model.DefRolePrivilegeRela;
import com.sinosoft.platform.core.domain.model.DefRolePrivilegeRelaExample;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.platform.core.util.Nodes;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MenuServiceImpl implements MenuService
{

	private static final Logger log = Logger.getLogger(MenuServiceImpl.class);
	Map<BigDecimal, DefPrivilege> fakeids = new HashMap<BigDecimal, DefPrivilege>();

	@Autowired
	MenuServiceMapper menuServiceMapper;

	@Autowired
	DefPrivilegeMapper defPrivilegeMapper;
	
	@Autowired
	DefRolePrivilegeRelaMapper defRolePrivilegeRelaMapper;
	@Autowired
	CommonServiceMapper commonService;
	
	public List<DefPrivilege> loadPrivilege()
	{
		DefPrivilegeExample examp = new DefPrivilegeExample();

		List<DefPrivilege> privilegeList = defPrivilegeMapper.selectByExample(examp);
		
		return privilegeList;
	}

	/**
	 * 增加多个菜单
	 */
	@Override
	@Transactional
	public void saveMenu(List<LinkedHashMap<String, Object>> list,LoginInfo loginInfo)
	{
		List<DefPrivilege> defPrivileges = new ArrayList<DefPrivilege>();
		for (int i = 0; i < list.size(); i++)
		{
			DefPrivilege defPrivilege = new DefPrivilege();
			String tPid = list.get(i).get("pid").toString();
			String tPre = list.get(i).get("pre").toString();
			String tNext = list.get(i).get("next").toString();
			if(tPid!=null && !"".equals(tPid))
			{
				defPrivilege.setPid(tPid);
			}
			if(tPre!=null && !"".equals(tPre))
			{
				defPrivilege.setPre(tPre);
			}
			if(tNext!=null && !"".equals(tNext))
			{
				defPrivilege.setNext(tNext);
			}
			defPrivilege.setMethod(list.get(i).get("method").toString());
			defPrivilege.setPrivilegename((String) list.get(i).get("privilegename"));
			defPrivilege.setPrivilegeDescribe((String) list.get(i).get("privilegeDescribe"));
			defPrivilege.setPrivilegeSign((String) list.get(i).get("privilegeSign"));
			defPrivilege.setUrl(list.get(i).get("url").toString());
			defPrivileges.add(defPrivilege);
			fakeids.put(new BigDecimal(list.get(i).get("fakeid").toString()), defPrivilege);
		}
		saveMenus(defPrivileges,loginInfo);
		for (DefPrivilege defPrivilege : defPrivileges)
		{
			saveMenu(defPrivilege,loginInfo);
		}
	}

	@Transactional
	private void saveMenus(List<DefPrivilege> defPrivileges,LoginInfo loginInfo)
	{
		List<DefPrivilege> leftprivileges = new ArrayList<DefPrivilege>();
		for (DefPrivilege defPrivilege : defPrivileges)
		{
			String pid = defPrivilege.getPid();
			// 父节点是新增的节点，有id的进行处理，没有则跳出循环进入下一次的递归循环
			if (isNewNode(pid))
			{
				if (fakeids.get(pid).getId() != null)
				{
					defPrivilege.setPid(fakeids.get(pid).getId().toString());
				}
				else
				{
					leftprivileges.add(defPrivilege);
					continue;
				}
			}
			// 计算节点顺序编码Num，对于无法计算的，进入递归循环。这里都是有父节点的节点。
			int newNum = calNum(defPrivilege);
			if (newNum == -1)
			{
				leftprivileges.add(defPrivilege);
				continue;
			}
			else
			{
				defPrivilege.setNum(new Long(newNum));
			}
			
			BigDecimal privilegeSeq = commonService.getSeqValByName("SEQ_T_DEF_Privilege");
			defPrivilege.setId(privilegeSeq);
			this.defPrivilegeMapper.insert(defPrivilege);
			updateMenus(defPrivileges);
		}
		// 对没有处理的节点，递归循环
		if (leftprivileges.size() > 0)
		{
			saveMenus(leftprivileges,loginInfo);
		}
	}

	/**
	 * 增加菜单
	 */
	@Transactional
	public void saveMenu(DefPrivilege defPrivilege,LoginInfo loginInfo)
	{
		String newId = getNewId();// 新生成的节点编码
		defPrivilege.setPrivilegecode(newId);
		dealPrivilegetype(defPrivilege);
		log.debug(defPrivilege.getPrivilegeDescribe());
		DefPrivilege existPrivilege = this.defPrivilegeMapper.selectByPrimaryKey(defPrivilege.getId());
		if(null==existPrivilege)
		{
			this.defPrivilegeMapper.insert(defPrivilege);
		}
		else
		{
			this.defPrivilegeMapper.updateByPrimaryKey(defPrivilege);
		}
		dealRelaAfterAdd(defPrivilege,loginInfo);
		updateAllAfterNewNode(defPrivilege.getNum().intValue(), defPrivilege.getId());
	}

	@Transactional
	private void updateMenus(List<DefPrivilege> privileges)
	{
		for (DefPrivilege privilege : privileges)
		{
			String pid = privilege.getPid();
			String pre = privilege.getPre();
			String next = privilege.getNext();

			if (isNewNode(pid))
			{
				if (fakeids.get(pid).getId() != null)
				{
					privilege.setPid(fakeids.get(pid).getId().toString());
				}
			}
			if (isNewNode(pre))
			{
				if (fakeids.get(pre).getId() != null)
				{
					privilege.setPre(fakeids.get(pre).getId().toString());
				}
			}
			if (isNewNode(next))
			{
				if (fakeids.get(next).getId() != null)
				{
					privilege.setNext(fakeids.get(next).getId().toString());
				}
			}
		}
	}

	/**
	 * 当页面的系统不输入时，默认本地菜单localmenu。 输入system时，也是本地菜单localmenu
	 * 输入其他系统编码时，是远程菜单remotemenu
	 */
	private void dealPrivilegetype(DefPrivilege defPrivilege)
	{
		if (defPrivilege.getMethod() != "" && defPrivilege.getMethod() != null
				&& defPrivilege.getMethod() != "system")
		{
			defPrivilege.setPrivilegetype("remotemenu");
		}
		else
		{
			defPrivilege.setPrivilegetype("localmenu");
		}
	}

	/**
	 * 删除菜单
	 */
	@Transactional
	public void deleteMenu(BigDecimal pid,LoginInfo loginInfo)
	{
		DefPrivilege defPrivilege = this.defPrivilegeMapper.selectByPrimaryKey(pid);
		
		if (hasChildren(defPrivilege))
		{
			log.info("存在子菜单，无法直接删除父菜单");
			//throw new CoreException("存在子菜单，无法直接删除父菜单");
		}
		
		deleteR2P(pid,loginInfo);

		DefPrivilege defPrivilege1 = this.defPrivilegeMapper.selectByPrimaryKey(pid);
		dealRelaAfterDelete(defPrivilege1,loginInfo);
		this.defPrivilegeMapper.deleteByPrimaryKey(defPrivilege1.getId());

	}

	/**
	 * 更新菜单
	 */
	@Transactional
	public void updatePrivilege(DefPrivilege defPrivilege,LoginInfo loginInfo)
	{
		dealPrivilegetype(defPrivilege);
		DefPrivilege oldprivilege = this.defPrivilegeMapper.selectByPrimaryKey(defPrivilege.getId());
		dealRelaAfterDelete(oldprivilege,loginInfo);
		oldprivilege.setPrivilegename(defPrivilege.getPrivilegename());
		oldprivilege.setUrl(defPrivilege.getUrl());
		oldprivilege.setPrivilegetype(defPrivilege.getPrivilegetype());
		oldprivilege.setPrivilegeDescribe(defPrivilege.getPrivilegeDescribe());
		oldprivilege.setPrivilegeSign(defPrivilege.getPrivilegeSign());
		oldprivilege.setMethod(defPrivilege.getMethod());
		oldprivilege.setPre(defPrivilege.getPre());
		oldprivilege.setNext(defPrivilege.getNext());
		oldprivilege.setPid(defPrivilege.getPid());
		int newNum = calNum(oldprivilege);
		oldprivilege.setNum(new Long(newNum));
		dealRelaAfterAdd(oldprivilege,loginInfo);
		
		this.defPrivilegeMapper.updateByPrimaryKey(oldprivilege);
		updateAllAfterNewNode(newNum, oldprivilege.getId());
	}

	@Transactional
	// 处理新增后的节点间关系
	public void dealRelaAfterAdd(DefPrivilege defPrivilege,LoginInfo loginInfo)
	{
		if (hasPreNode(defPrivilege))
		{
			setNextForPrePrivilege(defPrivilege, defPrivilege.getId(),loginInfo);
		}
		if (hasNextNode(defPrivilege))
		{
			setPreForNextPrivilege(defPrivilege, defPrivilege.getId());
		}
	}

	@Transactional
	// 处理删除后的节点间关系
	public void dealRelaAfterDelete(DefPrivilege oldprivilege,LoginInfo loginInfo)
	{
		if (hasPreNode(oldprivilege) && hasNextNode(oldprivilege))
		{
			setNextForPrePrivilege(oldprivilege, new BigDecimal(oldprivilege.getNext()),loginInfo);
			setPreForNextPrivilege(oldprivilege, new BigDecimal(oldprivilege.getPre()));
		}
		else if (hasPreNode(oldprivilege))
		{
			setNextForPrePrivilege(oldprivilege, null,loginInfo);
		}
		else if (hasNextNode(oldprivilege))
		{
			setPreForNextPrivilege(oldprivilege, null);
		}
	}

	/**
	 * 有后一节点
	 */
	private boolean hasNextNode(DefPrivilege defPrivilege)
	{
		return !("".equals(defPrivilege.getNext()))
				&& !(null == defPrivilege.getNext());
	}

	/**
	 * 有前一节点
	 */
	private boolean hasPreNode(DefPrivilege defPrivilege)
	{
		return !("".equals(defPrivilege.getPre()))
				&& !(null == defPrivilege.getPre());
	}

	/**
	 * 修改后一节点
	 */
	@Transactional
	private void setNextForPrePrivilege(DefPrivilege defPrivilege, BigDecimal next,LoginInfo loginInfo)
	{
		DefPrivilege prePrivilege;
		prePrivilege = this.defPrivilegeMapper.selectByPrimaryKey(new BigDecimal(defPrivilege.getPre()));
		if(prePrivilege != null && next != null && !"".equals(next)){
			prePrivilege.setNext(next.toString());
		}
		this.defPrivilegeMapper.updateByPrimaryKey(prePrivilege);
	}

	/**
	 * 修改前一节点
	 */
	@Transactional
	private void setPreForNextPrivilege(DefPrivilege defPrivilege, BigDecimal pre)
	{
		DefPrivilege nextPrivilege;
		String id = defPrivilege.getNext();
		nextPrivilege = this.defPrivilegeMapper.selectByPrimaryKey(new BigDecimal(id));
		if(nextPrivilege != null && pre != null && !"".equals(pre)){
			nextPrivilege.setPre(pre.toString());
		}
		defPrivilegeMapper.updateByPrimaryKey(nextPrivilege);
	}

	/**
	 * 计算菜单加载的顺序
	 */
	@Transactional
	private Integer calNum(DefPrivilege defPrivilege)
	{
		DefPrivilege prePrivilege = new DefPrivilege();
		DefPrivilege nextPrivilege = new DefPrivilege();
		DefPrivilege fatherPrivilege = new DefPrivilege();
		String pid = defPrivilege.getPid();
		String pre = defPrivilege.getPre();
		String next = defPrivilege.getNext();
		if (hasPreNode(defPrivilege))
		{// 有pre节点的，取pre的num+1。有next节点的，取next的num。否则只有父节点，取父节点的num+1
			if (isNewNode(pre))
			{// pre是新增的节点，则递归到下次处理。
				return -1;
			}
			else
			{
				prePrivilege = this.defPrivilegeMapper.selectByPrimaryKey(new BigDecimal(pre));
				return prePrivilege.getNum().intValue() + 1;
			}
		}
		else if (hasNextNode(defPrivilege) && !isNewNode(next))
		{// 有next节点且不是新节点，取next的num。
			nextPrivilege = this.defPrivilegeMapper.selectByPrimaryKey(new BigDecimal(next));
			return nextPrivilege.getNum().intValue();
		}
		else
		{
			fatherPrivilege = this.defPrivilegeMapper.selectByPrimaryKey(new BigDecimal(pid));
			return fatherPrivilege.getNum().intValue() + 1;
		}
	}

	/**
	 * 判断该节点是否是新节点
	 */
	private boolean isNewNode(String pre)
	{
		if(null!=pre)
		{
			return pre.toString().length() > 3 && pre.toString().substring(0, 3).equals("-99");
		}
		return false;
	}

	/**
	 * 修改菜单加载顺序
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	private void updateAllAfterNewNode(Integer bd1, BigDecimal bd2)
	{	
		Map paramMap = new HashMap();
		paramMap.put("bd1", bd1);
		paramMap.put("bd2", bd2);
		this.menuServiceMapper.updateAllAfterNewNode(paramMap);
	}

	/**
	 * 计算菜单编码
	 */
	@Transactional
	private String getNewId()
	{// 计算code
		String result = "";
		List<DefPrivilege> menuCode = this.menuServiceMapper.queryPrivilegecode();
		result = Integer.parseInt(menuCode.get(0).getPrivilegecode()) + 1 + "";
		return result;
	}

	/**
	 * 是否有子菜单
	 */
	@Transactional
	private boolean hasChildren(DefPrivilege defPrivilege)
	{
		boolean result = false;
		List<DefPrivilege> menuCode = this.menuServiceMapper.queryMenuChildren(defPrivilege);
		if (menuCode.size() > 0)
		{
			result = true;
		}
		return result;
	}

	/**
	 * 查询菜单列表
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, Object> getPageList(DataGridModel dgm,
			DefPrivilege defPrivilege)
	{
		Map<String, Object> result = new HashMap<String, Object>(2);
		Map paramMap = new HashMap();
		paramMap.put("privilegecode", defPrivilege.getPrivilegecode());
		paramMap.put("privilegename", defPrivilege.getPrivilegename());
		paramMap.put("privilegeDescribe", defPrivilege.getPrivilegeDescribe());
		paramMap.put("privilegeSign", defPrivilege.getPrivilegeSign());
		
		paramMap.put("queryStartIndex", dgm.getStartIndex());
		paramMap.put("queryEndIndex", dgm.getEndIndex());
		int total = menuServiceMapper.queryMenuListInfoCounts(paramMap);
		List<Map> list = menuServiceMapper.queryMenuListInfoPages(paramMap);
		result.put("total", total);
		result.put("rows", list);
		return result;
	}

	/*
	 * 查询菜单树
	 */
	@Transactional
	public List<Nodes> queryMenu()
	{
		
		DefPrivilegeExample examp = new DefPrivilegeExample();
		List<DefPrivilege> privilegeList = defPrivilegeMapper.selectByExample(examp);

		Collections.sort(privilegeList, new Comparator<DefPrivilege>()
		{
			public int compare(DefPrivilege p1, DefPrivilege p2)
			{
				return (p1.getNum() > p2.getNum()) ? 1 : 0;
			}
		});
		ArrayList<Nodes> list = new ArrayList<Nodes>();
		for (DefPrivilege defPrivilege : privilegeList)
		{
			if (defPrivilege.getPrivilegetype().equals("localmenu") || defPrivilege.getPrivilegetype().equals("remotemenu"))
			{
				Nodes nodes = new Nodes();
				nodes.setId(defPrivilege.getId().intValue());
				nodes.setpId(defPrivilege.getPid());
				nodes.setSystem(defPrivilege.getMethod());
				nodes.setName(defPrivilege.getPrivilegename());
				nodes.setUrl(defPrivilege.getUrl());
				list.add(nodes);
			}
		}
		return list;
	}

	/**
	 * 根据id得到菜单对象
	 * @return 
	 */
	@Transactional
	public DefPrivilege get(BigDecimal pid)
	{
		return this.defPrivilegeMapper.selectByPrimaryKey(pid);
	}

	/**
	 * 删除角色菜单对应关系
	 */
	@Transactional
	public void deleteR2P(BigDecimal pid,LoginInfo loginInfo)
	{
		DefPrivilege privilege = this.get(pid);
		
		DefRolePrivilegeRelaExample examp = new DefRolePrivilegeRelaExample();
		examp.createCriteria().andPrivilegeIdEqualTo(privilege.getId());
		Iterator<DefRolePrivilegeRela> iter = this.defRolePrivilegeRelaMapper.selectByExample(examp).iterator();
		
		while (iter.hasNext())
		{
			DefRolePrivilegeRela defRolePrivilegeRela =  iter.next();
			this.defRolePrivilegeRelaMapper.deleteByPrimaryKey(defRolePrivilegeRela.getId());
		}
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.MenuService#queryMenuByUrl(java.lang.String)
	 */
	@Override
	public List<DefPrivilege> queryMenuByUrl(String url) {
		DefPrivilegeExample example = new DefPrivilegeExample();
		example.createCriteria().andUrlEqualTo(url);
		return defPrivilegeMapper.selectByExample(example);
	}

	@Override
	public DefPrivilege selectById(BigDecimal id) {
		DefPrivilegeExample example = new DefPrivilegeExample();
		example.createCriteria().andIdEqualTo(id);
		List<DefPrivilege> defPrivileges = this.defPrivilegeMapper.selectByExample(example);
		return defPrivileges.get(0);
	}
}
