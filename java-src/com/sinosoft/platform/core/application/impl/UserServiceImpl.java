package com.sinosoft.platform.core.application.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.application.MenuService;
import com.sinosoft.platform.core.application.RoleService;
import com.sinosoft.platform.core.application.UserService;
import com.sinosoft.platform.core.domain.mapper.CommonServiceMapper;
import com.sinosoft.platform.core.domain.mapper.DefReportColMapper;
import com.sinosoft.platform.core.domain.mapper.DefUserMapper;
import com.sinosoft.platform.core.domain.mapper.DefUserRoleRelaMapper;
import com.sinosoft.platform.core.domain.mapper.TDefCodeDictMapper;
import com.sinosoft.platform.core.domain.mapper.TDefManageComMapper;
import com.sinosoft.platform.core.domain.mapper.TDefPlatComMapper;
import com.sinosoft.platform.core.domain.mapper.TDefUserMapper;
import com.sinosoft.platform.core.domain.mapper.TDefUserTraceMapper;
import com.sinosoft.platform.core.domain.mapper.UserServiceMapper;
import com.sinosoft.platform.core.domain.model.DefPrivilege;
import com.sinosoft.platform.core.domain.model.DefReportCol;
import com.sinosoft.platform.core.domain.model.DefRole;
import com.sinosoft.platform.core.domain.model.DefUser;
import com.sinosoft.platform.core.domain.model.DefUserExample;
import com.sinosoft.platform.core.domain.model.DefUserRoleRela;
import com.sinosoft.platform.core.domain.model.DefUserRoleRelaExample;
import com.sinosoft.platform.core.domain.model.TDefCodeDict;
import com.sinosoft.platform.core.domain.model.TDefManageCom;
import com.sinosoft.platform.core.domain.model.TDefManageComExample;
import com.sinosoft.platform.core.domain.model.TDefPlatCom;
import com.sinosoft.platform.core.domain.model.TDefUser;
import com.sinosoft.platform.core.domain.model.TDefUserExample;
import com.sinosoft.platform.core.domain.model.TDefUserTrace;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.platform.core.util.Nodes;
import com.sinosoft.ummp.domain.mapper.TDefNoticeAddMapper;
import com.sinosoft.ummp.domain.mapper.TDefNoticeMainMapper;
import com.sinosoft.ummp.domain.model.TDefNoticeAddExample;
import com.sinosoft.ummp.domain.model.TDefNoticeMainExample;

@Service("userService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserServiceImpl implements UserService
{

	private static final Logger log = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private DefUserMapper defUserMapper;

	@Autowired
	private UserServiceMapper userServiceMapper;

	@Autowired
	private DefUserRoleRelaMapper defUserRoleRelaMapper;

	@Autowired
	CommonServiceMapper commonServiceMapper;
	
	@Autowired
	private TDefUserTraceMapper tDefUserTraceMapper;
	
	@Autowired
	private TDefPlatComMapper tDefPlatComMapper;
	
	@Autowired
	private TDefManageComMapper tDefManageComMapper;
	@Autowired
	private TDefCodeDictMapper tDefCodeDictMapper;
	
	@Autowired
	private DefReportColMapper defReportColMapper;
	
	@Autowired
	TDefUserMapper tDefUserMapper;
	
	@Autowired
	TDefNoticeMainMapper tDefNoticeMainMapper;
	@Autowired
	TDefNoticeAddMapper tDefNoticeAddMapper;
	
	@Autowired
	CodeQueryService codeQueryService;
	
	/**
	 * 根据用户名返回用户对象，认证登录时默认本地认证入口
	 * @throws CoreException 
	 */
	@Transactional
	public DefUser findUserByUser(DefUser defUser) throws CoreException{
		CoreException loginExcpeiton = new CoreException() ;
		if (defUser.getUsercode() == null || "".equals(defUser.getUsercode())){
			
			loginExcpeiton.setMessage("请输入用户名");
			loginExcpeiton.setErrorCode("1");
			throw loginExcpeiton;
		}
		if (defUser.getPassword() == null || "".equals(defUser.getPassword()))
		{
			loginExcpeiton.setMessage("请输入密码");
			loginExcpeiton.setErrorCode("2");
			throw loginExcpeiton;
		}

		//认证方式选择
		if(defUser.getEmpowerType() == null || "".equals(defUser.getEmpowerType())){
			loginExcpeiton.setMessage("请选择认证方式登录！");
			loginExcpeiton.setErrorCode("3");
			throw loginExcpeiton;
		}
		
		DefUser defUser1 = null;
		ArrayList<DefUser> userlist = userServiceMapper.queryUserByUserCode(defUser);
		if (userlist.size() <= 0){
			loginExcpeiton.setMessage("用户不存在");
			loginExcpeiton.setErrorCode("1");
			throw loginExcpeiton;
		}else{
			defUser1 = userlist.get(0);
		}
		return defUser1;
	}

	/**
	 * 增加一个用户
	 * @throws CoreException 
	 */
	@Transactional
	public void addUser(DefUser defUser,LoginInfo loginInfo) throws CoreException{
		checkUser(defUser);
		checkUserForAdd(defUser);
		passwordEncoder(defUser);
		BigDecimal userSeq = commonServiceMapper.getSeqValByName("SEQ_T_DEF_USER");
		defUser.setEmpowerCode(defUser.getEmpowerType().equals("0")?defUser.getUsercode():"");
		defUser.setId(userSeq);
		defUser.setIsLock("0");//0-无锁 1-已锁
		this.defUserMapper.insert(defUser);
	}
	/**
	 * 校验用户编码是否存在
	 * @param defUser
	 * @throws CoreException
	 */
	private void checkUserForAdd(DefUser defUser) throws CoreException{
		ArrayList<DefUser> userlist = null;
		userlist = this.userServiceMapper.queryUserByUserCode(defUser);
		if (userlist.size() > 0)
		{
			log.info("用户编码已经存在");
			throw new CoreException("该用户编码已经存在");
		}
	}

	/**
	 * md5加密
	 */
	public void passwordEncoder(DefUser defUser){
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		defUser.setPassword(md5.encodePassword(defUser.getPassword(), null));
	}

	/**
	 * 更新用户
	 * @throws CoreException 
	 */
	@Transactional
	public void updateUser(DefUser defUser,LoginInfo loginInfo) throws CoreException{
		checkUser(defUser);
		
		DefUserExample defUserExample = new DefUserExample();
		DefUserExample.Criteria criteria = defUserExample.createCriteria();
		criteria.andIdNotEqualTo(defUser.getId());
		criteria.andUsercodeEqualTo(defUser.getUsercode());
		
		List<DefUser> defUserList = defUserMapper.selectByExample(defUserExample);
		if (defUserList.size() > 0)
		{
			log.info("该用户登陆账号已经存在");
			throw new CoreException("该用户登陆账号已经存在，请更换");
		}
		
		DefUser defUser_db = this.defUserMapper.selectByPrimaryKey(defUser.getId());
		defUser.setPassword(defUser_db.getPassword());
		this.defUserMapper.updateByPrimaryKey(defUser);
	}

	/**
	 * 根据用户id删除用户
	 */
	@Transactional
	public void deleteUser(String uid,LoginInfo loginInfo){
		this.deleteU2R(uid,loginInfo);
		DefUser defUser = this.defUserMapper.selectByPrimaryKey(new BigDecimal(uid));
		TDefNoticeMainExample mainexample = new TDefNoticeMainExample();
		mainexample.createCriteria().andNoticeToEqualTo(uid);
		TDefNoticeAddExample addexample = new TDefNoticeAddExample();
		addexample.createCriteria().andNoticeToEqualTo(uid);
		tDefNoticeMainMapper.deleteByExample(mainexample);
		tDefNoticeAddMapper.deleteByExample(addexample);
		this.defUserMapper.deleteByPrimaryKey(defUser.getId());
	}
	
	/**
	 * 根据用户编码加载菜单
	 * @param userCode
	 * @return
	 */
	public List<Nodes> queryMenu(String userCode){
		ArrayList<DefRole> listRole = this.listRole(userCode);
		List<Nodes> list = new ArrayList<Nodes>();
		list = roleService.queryMenu(listRole, false);
		for (Nodes node : list){
			if (!"".equals(node.getUrl()) && null != node.getUrl()){
				node.setClick("addtab('" + node.getName() + "','"
						+ node.getUrl() + "');");
			}
		}
		// 以为一个用户可能有多个角色，菜单可能重复，此处菜单去重
		List<Nodes> list2 = new ArrayList<Nodes>();
		for (int i = 0; i < list.size(); i++){
			int num = 0;
			for (int j = 0; j < list2.size(); j++){	
				
				if (list.get(i).getId().equals(list2.get(j).getId()))
				{
					num += 1;
				}
			}
			if (num == 0)
			{
				list2.add(list.get(i));
			}
		}
		return list2;
	}
	/**
	 * 查询用户已分配的菜单并组成菜单树
	 */
	@Transactional
	public List<Nodes> queryMenu(BigDecimal uid){
		ArrayList<DefRole> listRole = this.listRole(uid);
		List<Nodes> list = new ArrayList<Nodes>();
		list = roleService.queryMenu(listRole, false);
		for (Nodes node : list){
			if (!"".equals(node.getUrl()) && null != node.getUrl()){
				node.setClick("addtab('" + node.getName() + "','"
						+ node.getUrl() + "');");
			}
		}
		// 以为一个用户可能有多个角色，菜单可能重复，此处菜单去重
		List<Nodes> list2 = new ArrayList<Nodes>();
		for (int i = 0; i < list.size(); i++){
			int num = 0;
			for (int j = 0; j < list2.size(); j++){	
				
				if (list.get(i).getId().equals(list2.get(j).getId()))
				{
					num += 1;
				}
			}
			if (num == 0)
			{
				list2.add(list.get(i));
			}
		}
		return list2;
	}

	/**
	 * 角色树
	 */
	@Transactional
	public List<Nodes> queryRole(BigDecimal uid){
		ArrayList<DefRole> roleList = this.listRole(uid);
		ArrayList<Nodes> list = new ArrayList<Nodes>();
		for (DefRole defRole : roleList){
			Nodes nodes = new Nodes();
			nodes.setId(defRole.getId().intValue());
			nodes.setName(defRole.getRolename());
			list.add(nodes);
		}
		return list;
	}

	/**
	 * 查询用户已有角色
	 */
	public ArrayList<DefRole> listRole(BigDecimal uid){
		ArrayList<DefRole> roleList = new ArrayList<DefRole>();
		DefUser defUser = get(uid);
		roleList = this.userServiceMapper.queryRolesByUserId(defUser);
		return roleList;
	}
	/**
	 * 根据用户编码查询已有角色
	 */
	public ArrayList<DefRole> listRole(String userCode){
		ArrayList<DefRole> roleList = new ArrayList<DefRole>();
		DefUser defUser = new DefUser();
		defUser.setUsercode(userCode);
		roleList = this.userServiceMapper.queryRolesByUserCode(defUser);
		return roleList;
	}
	/**
	 * 根据用户id删除用户角色关联表
	 */
	@Transactional
	public void deleteU2R(String uid,LoginInfo loginInfo){

		DefUserRoleRelaExample examp = new DefUserRoleRelaExample();
		examp.createCriteria().andUserIdEqualTo(uid);

		List<DefUserRoleRela> defUserRoleRela = this.defUserRoleRelaMapper.selectByExample(examp);

		Iterator<DefUserRoleRela> iter = defUserRoleRela.iterator();
		while (iter.hasNext())
		{
			DefUserRoleRela defUserRoleRela1 = iter.next();
			log.debug("id="+defUserRoleRela1.getId());
			this.defUserRoleRelaMapper.deleteByPrimaryKey(defUserRoleRela1.getId());
		}
	}
	/**
	 * 根据用户id删除用户角色关联表
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public void deleteU2RByUserCode(String userId,String userCode){

		Map map = new HashMap();
		map.put("userId", userId);
		map.put("userCode", userCode);
		defUserRoleRelaMapper.deleteU2RByUserIdAndCode(map);
	}
	/**
	 * 根据用户id得到用户对象
	 */
	public DefUser get(BigDecimal key){
		return this.defUserMapper.selectByPrimaryKey(key);
	}
	
	/**
	 * 根据用户ID 获取用户权限（角色对应的权限）
	 */
	public String getUserRolePrivilege(DefUser defUser){
		return this.userServiceMapper.queryUserRolePrivilegeByUserId(defUser);
	}
	/**
	 * 保存用户分配到的角色
	 */
	@Transactional
	public void saveSet(DefUserRoleRela defUserRoleRela,LoginInfo loginInfo){
		
		BigDecimal seqUserRole = commonServiceMapper.getSeqValByName("seq_t_def_user_role_rela");
		defUserRoleRela.setId(seqUserRole);
		this.defUserRoleRelaMapper.insert(defUserRoleRela);
	}

	/**
	 * 用户校验
	 * @throws CoreException 
	 */
	@Transactional
	public void checkUser(DefUser defUser) throws CoreException{
		if ("".equals(defUser.getUsername()) || defUser.getUsername() == null){
			log.info("用户名为空");
			throw new CoreException("用户名不能为空");
		}
		if ("".equals(defUser.getUsercode()) || defUser.getUsercode() == null){
			log.info("用户编码为空");
			throw new CoreException("用户编码不能为空");
		}

		if (defUser.getCompanyId() == null){
			log.info("管理机构为空");
			throw new CoreException("管理机构不能为空");
		}
	}

	/**
	 * 修改用户密码
	 * @throws CoreException 
	 * */
	@Transactional
	public void modifySave(String password, String password1, BigDecimal id) throws CoreException
	{
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();

		DefUser defUser = this.defUserMapper.selectByPrimaryKey(id);
		if (!md5.encodePassword(password, null).equals(defUser.getPassword()))
		{
			log.info("用户原始密码输入错误!");
			throw new CoreException("用户原始密码输入错误!");
		}
		defUser.setPassword(md5.encodePassword(password1, null));

		this.defUserMapper.updateByPrimaryKey(defUser);
	}

	/**
	 * 查询登陆信息
	 */
	@Override
	public HashMap<String, String> queryLoginInfo(LoginInfo loginInfo)
	{
		HashMap<String, String> msgMap = new HashMap<String, String>();
		DefUser defUser = defUserMapper.selectByPrimaryKey(loginInfo.getUserId());
		if (defUser != null)
		{
			msgMap.put("_user",defUser.getUsercode() + "-" + defUser.getUsername());
		}
		return msgMap;
	}

	/**
	 * 用户信息菜单页面，表格初始化，分页查询
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map<String, Object> getPageList(DataGridModel dgm, DefUser defUser,TDefCodeDict dict)
	{
		Map<String, Object> result = new HashMap<String, Object>(2);
		Map paramMap = new HashMap();
		paramMap.put("usercode", defUser.getUsercode());
		paramMap.put("username", defUser.getUsername());
		paramMap.put("companyid", defUser.getCompanyId());
		paramMap.put("startdate", defUser.getStartDate());
		paramMap.put("enddate", defUser.getEndDate());
		paramMap.put("codeName", dict.getCodeName());
		paramMap.put("userdescribe", defUser.getUserDescribe());
		paramMap.put("creatorcode", defUser.getCreatorCode());
		paramMap.put("email", defUser.getEmail());
		paramMap.put("empowerCode", defUser.getEmpowerCode());
		
		paramMap.put("queryStartIndex", dgm.getStartIndex());
		paramMap.put("queryEndIndex", dgm.getEndIndex());
		int total = userServiceMapper.queryUserListInfoCounts(paramMap);
		List<Map> list = userServiceMapper.queryUserListInfoPages(paramMap);

		result.put("total", total);
		result.put("rows", list);
		return result;
	}

	/**
	 * 更新页面信息带入，根据用户ID
	 */
	public Map<String, Object> getUpdateListInfo(BigDecimal userId)
	{

		// 查询用户基本信息
		DefUser defUser = defUserMapper.selectByPrimaryKey(userId);
		Map<String, Object> result = new HashMap<String, Object>(2);
		result.put("defUser", defUser);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.UserService#addUserTrace(com.sinosoft.core.domain.model.TDefUserTrace)
	 */
	@Override
	public void addUserTrace(TDefUserTrace trace) {
		// TODO Auto-generated method stub
		tDefUserTraceMapper.insert(trace);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.UserService#addUserTrace(javax.servlet.http.HttpServletRequest, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void  addUserTrace( LoginInfo loginInfo , String url,
			String funName, String msg) {
		// TODO Auto-generated method stub
		TDefUserTrace trace = new TDefUserTrace();
		String userId = ""+loginInfo.getUserId();
		if(userId == null || "".equals(userId)){
			userId = loginInfo.getUserCode();
		}
		trace.setUserId(userId);
		trace.setTraceFunc(funName);
		trace.setTraceMsg(msg);
		trace.setTraceUrl(url);
		trace.setUserIp(loginInfo.getUserIp());
		trace.setInsertTime(DateUtils.getCurrentTimestamp());
		addUserTrace(trace);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.UserService#getPlatComByUsercode(com.sinosoft.util.LoginInfo)
	 */
	@Override
	public List<TDefPlatCom> getPlatComByLoginInfo(LoginInfo loginInfo) {
		// TODO Auto-generated method stub
		return tDefPlatComMapper.selectByUserCode(loginInfo.getUserCode());
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.UserService#addUserTrace(com.sinosoft.util.LoginInfo, java.lang.String)
	 */
	@Override
	public void addUserTrace(LoginInfo loginInfo, String url) {
		// TODO Auto-generated method stub
		List<DefPrivilege> menus = menuService.queryMenuByUrl(url);
		if(menus != null && menus.size() > 0){
			DefPrivilege menu = menus.get(0);
			TDefUserTrace trace =new TDefUserTrace();
			trace.setPrivilegeId(menu.getId());
			trace.setInsertTime(DateUtils.getCurrentTimestamp());
			trace.setTraceMsg(menu.getPrivilegename());
			trace.setTraceUrl(url);
			trace.setUserId(loginInfo.getUserId().toString());
			trace.setUserIp(loginInfo.getUserIp());
			this.addUserTrace(trace);
		}
	}


	@Override
	public BigDecimal getIdByUsercode(DefUser defUser) {
		// TODO Auto-generated method stub
		return userServiceMapper.queryIdByUserCode(defUser);
	}
	
	/**
	 * 测试根据报表编码，获取报表相关信息
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Map<String, Object> getReportInfo(Map paramMap,String reportCode) {
		Map<String, Object> reportInfoMap = new HashMap<String, Object>();
		//1.获取报表名称，生成Excel时的sheet名
		TDefCodeDict defCode = codeQueryService.getQueryCode("reportCode", reportCode);
		reportInfoMap.put("reportName", defCode.getCodeName());
		//2.1获取报表的列编号，列编码，列名称
		DefUserExample defReportColExample = new DefUserExample();
		DefUserExample.Criteria criteria = defReportColExample.createCriteria();
		criteria.andReportCodeEqualTo(reportCode);
		List<DefReportCol> reportColInfoList = defReportColMapper.selectByExample(defReportColExample);
		//2.2添加表头信息
		Map<String, String> colMap=new HashMap<String, String>();
		colMap=this.getTableParam(colMap,defCode,paramMap);
		reportInfoMap.put("reportColNameMapping", colMap);
		//3.生成列编号与列名称的对应关系		
		Map<String, String> colNoToColNameMap = new HashMap<String, String>();
		for (DefReportCol defReportCol:reportColInfoList) {
			colNoToColNameMap.put(defReportCol.getColumnNo(), defReportCol.getColumnName());
		}
		reportInfoMap.put("reportColNoToColNameMapping", colNoToColNameMap);
		//4.生成列编号与列编码的对应关系	
		Map<String, String> colNoToColCodeMap = new HashMap<String, String>();
		for (DefReportCol defReportCol:reportColInfoList) {
			colNoToColCodeMap.put(defReportCol.getColumnNo(), defReportCol.getColumnCode());
		}
		reportInfoMap.put("reportColNoToColCodeMapping", colNoToColCodeMap);
		return reportInfoMap;
	}
	//添加表头信息
	@SuppressWarnings("rawtypes")
	public Map<String, String> getTableParam(Map<String, String> colMap,TDefCodeDict defCode,Map paramMap){
		colMap.put("col0", "报表名称");
		colMap.put("col1",  defCode.getCodeName());
		colMap.put("col2","起始日期" );
		colMap.put("col3",(String) paramMap.get("startDate") );
		colMap.put("col4","截止日期" );
		colMap.put("col5",(String) paramMap.get("endDate"));
		colMap.put("col6", "统一认证编码");
		colMap.put("col7", (String) paramMap.get("empowerCode"));
		colMap.put("col8", "用户编码");
		colMap.put("col9",(String) paramMap.get("userCode"));
		colMap.put("col10", "用户名称");
		colMap.put("col11",(String) paramMap.get("userName"));
		colMap.put("col12", defCode.getCodeName()+"如下:");
		return colMap;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map<String, Object> getPageListt(DataGridModel dgm, DefUser defUser,
			TDefCodeDict dict) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		Map paramMap = new HashMap();
		paramMap.put("startdate", defUser.getStartDate());
		paramMap.put("enddate", defUser.getEndDate());
		paramMap.put("codeName", dict.getCodeName());
		
		paramMap.put("queryStartIndex", dgm.getStartIndex());
		paramMap.put("queryEndIndex", dgm.getEndIndex());
		int total = userServiceMapper.queryUserListInfoCounts(paramMap);
		List<Map> list = userServiceMapper.exportExcel(paramMap);

		result.put("total", total);
		result.put("rows", list);
		return result;
	}
	
	@Override
	public List<TDefManageCom> getAllManage() {
		// TODO Auto-generated method stub
		TDefManageComExample example=new TDefManageComExample();
		return tDefManageComMapper.selectByExample(example);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, Object> getPageListLog(DataGridModel dgm, DefUser user) {
		Map<String,Object> result=new HashMap<String,Object>();
		Map paramMap=new HashMap();
		paramMap.put("startDate", user.getStartDate());
		paramMap.put("endDate",user.getEndDate());
		paramMap.put("userCode", user.getUsercode());
		paramMap.put("userName", user.getUsername());
		paramMap.put("empowerCode", user.getEmpowerCode());
		
		paramMap.put("queryStartIndex", dgm.getStartIndex());
		paramMap.put("queryEndIndex", dgm.getEndIndex());
		int total=tDefUserTraceMapper.queryCount(paramMap);
		List<Map> list = tDefUserTraceMapper.queryOperateLog(paramMap);
		result.put("total", total);
		result.put("rows", list);
		return result;
	}

	@Override
	public DefUser selectById(BigDecimal id) {
		DefUser defUser = this.defUserMapper.selectByPrimaryKey(id);
		return defUser;
	}

	@Override
	public boolean userValidityCheck(){
		// TODO Auto-generated method stub
		String cDateStr = DateUtils.getCurrentDate();
		log.info("userValidityCheck currentDate："+cDateStr);
		List<DefUser> tUsers = defUserMapper.getOutValidedUser();
		List<DefUser> uUsers = new ArrayList<DefUser>();
		for(DefUser tUser : tUsers){
			tUser.setUserState("0");//0-无效 1-有效 
			tUser.setIsLock("1");//1-锁定 0-未锁定
			uUsers.add(tUser);
		}
		return updateUsers(uUsers);
	}
	/**
	 * 更新用户
	 * @param tUsers
	 * @return
	 */
	private boolean updateUsers(List<DefUser> tUsers){
		for(DefUser tUser : tUsers){
			defUserMapper.updateByPrimaryKey(tUser);
		}
		return true;
	}
	
	public boolean userSSICCheck(){
		return false;
	}
	
	public static void main(String[] args){
		String cDateStr = "2016-02-02";
		String eDateStr = "2016-02-01 12:22:12";
		Date cDate = DateUtils.getDate(cDateStr);
		Date eDate = DateUtils.getDate(eDateStr);
		log.debug("eDate.compareTo(cDate): "+eDate.compareTo(cDate));
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.UserService#queryUserByCode(java.lang.String)
	 */
	@Override
	public DefUser queryUserByCode(String userCode) {
		// TODO Auto-generated method stub
		DefUserExample  example = new DefUserExample();
		example.createCriteria().andUsercodeEqualTo(userCode);
		example.setOrderByClause("ID");
		List<DefUser> users = defUserMapper.selectByExample(example);
		if(users != null && users.size() > 0){
			return users.get(0);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.UserService#checkUser(com.sinosoft.platform.core.util.LoginInfo)
	 */
	@Override
	public boolean checkUser(LoginInfo loginInfo) {
		// TODO Auto-generated method stub
		TDefUserExample example = new TDefUserExample();
		example.createCriteria().andUsercodeEqualTo(loginInfo.getUserCode());
		List<TDefUser> list = tDefUserMapper.selectByExample(example);
		if(list == null || list.size() <= 0){
			return false;
		}
		TDefUser tUser = list.get(0);
		if(tUser.getEmpowerType().equals("0")){
			return true;
		}
		return false;
	}
	
	/***************************CR1800450****************************************/
	/**
	 * 域登录验证
	 * @param userName AD域认证，用户的登录UserName
	 * @param password  AD域认证，用户的登录PassWord
	 * @return
	 */
	public  boolean  checkADLogin(String userName,String password ) {
		boolean loginflag=false;
		Properties prop=config.Config.getProperties("ldap");
        String host=prop.getProperty("ldap.host");//AD域IP
        String domain =prop.getProperty("ldap.domain");//域名后缀
        String port =prop.getProperty("ldap.port"); //端口，一般默认389
        String url = new String("ldap://" + host + ":" + port);//固定写法
        String user = domain+"\\"+userName;
        System.out.println("url="+url);
        Hashtable env = new Hashtable();//实例化一个Env
        DirContext ctx = null;
        env.put(Context.SECURITY_AUTHENTICATION, "simple");//LDAP访问安全级别(none,simple,strong),一种模式
        env.put(Context.SECURITY_PRINCIPAL, user); //用户名
        env.put(Context.SECURITY_CREDENTIALS, password);//密码
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");// LDAP工厂类
        env.put(Context.PROVIDER_URL, url);//Url
        try {
            ctx = new InitialDirContext(env);// 初始化上下文
            System.out.println("身份验证成功!");
            loginflag=true;
        } catch (AuthenticationException e) {
            System.out.println("身份验证失败!");
            e.printStackTrace();
        } catch (javax.naming.CommunicationException e) {
            System.out.println("AD域连接失败!");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("身份验证未知异常!");
            e.printStackTrace();
        } finally{
            if(null!=ctx){
                try {
                    ctx.close();
                    ctx=null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return loginflag;
	}

}













