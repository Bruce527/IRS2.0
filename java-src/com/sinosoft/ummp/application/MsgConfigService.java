/**
 * 
 */
package com.sinosoft.ummp.application;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.sinosoft.platform.core.domain.model.TDefPlatCom;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.platform.core.util.NodeAttri;
import com.sinosoft.platform.core.util.NodeParam;
import com.sinosoft.platform.core.util.NodeTree;
import com.sinosoft.ummp.domain.model.TTempNode;
import com.sinosoft.ummp.domain.model.TTempNodeAttri;
import com.sinosoft.ummp.domain.model.TTempNodeParam;
import com.sinosoft.ummp.domain.pojo.MsgConfigPOJO;

/**
 * 报文配置服务接口
 * @author Darker.Wang
 * @date 2016-5-24 下午12:14:59
 * @version 1.0
 * @company SINOSOFT
 */
public interface MsgConfigService {

	/**
	 * 显示所有平台，无关用户
	 * @return
	 */
	List<TDefPlatCom> listPlats();
	/**
	 * 通过用户编码，显示平台信息，平台选择由用户角色决定
	 * @param userCode
	 * @return
	 */
	List<TDefPlatCom> listPlatsByUserCode(String userCode);
	/**
	 * 构建子节点
	 * @param content
	 * @param type
	 * @return
	 */
	List<NodeTree> buildSonNode(String nodeCode,String content,String type) throws SQLException;
	
	/**
	 * 通过根节点获取临时节点树
	 * @return
	 */
	public List<NodeTree> getTempNodeTreeByRootId(Integer rootId);
	/**
	 * 获取临时节点表的所有根节点
	 * @return
	 */
	public List<NodeTree> getNodeRootFromTemp();
	/**
	 * 根据节点组加载树信息
	 * @param ids
	 * @return
	 */
	public List<NodeTree> getTempNodeList(List<Integer> ids);
	
	/**
	 * 根据当前节点获取节点数
	 * @return
	 */
	public NodeTree getTempNodeById(Integer id);
	/**
	 * 获取临时节点属性
	 * @param id
	 * @return
	 */
	public List<NodeAttri> getTempNodeAttriById(Integer id);
	/**
	 * 获取临时节点参数
	 * @param id
	 * @return
	 */
	public List<NodeParam> getTempNodeParamById(Integer id);
	/**
	 * 获取节点Id对应的Sql信息
	 * @param id
	 * @return
	 */
	public Map<String,String> getNodeSql(Integer id);
	/**
	 * 保存节点属性
	 * @param type 0- 新增 1-根据主键修改
	 * @param nodeAttri
	 * @return
	 */
	int saveTempNodeAttri(int type,TTempNodeAttri nodeAttri);
	/**
	 * 保存节点参数
	 * @param type 0- 新增 1-根据主键修改
	 * @param nodeAttri
	 * @return
	 */
	int saveTempNodeParam(int type,TTempNodeParam nodeParam);
	/**
	 * 保存节点
	 * @param type 0- 新增 1-根据主键修改
	 * @param tempNode
	 * @return
	 */
	int saveTempNode(int type,TTempNode tempNode);
	/**
	 * 删除临时节点属性
	 * @param id
	 * @return
	 */
	int deleteTempNodeAttri(Integer id);
	/**
	 * 删除临时节点参数
	 * @param id
	 * @return
	 */
	int deleteTempNodeParam(Integer id);
	/**
	 * 保存一个节点树
	 * @param nodeTree
	 * @return
	 */
	int saveNodeTree(NodeTree nodeTree);
	/**
	 * 根据父类节点删除NODE
	 * @param fid
	 * @return
	 */
	int deleteTempNodeByFid(Integer fid);
	/**
	 * 根据ID删除临时节点
	 * @param id
	 * @return
	 */
	int deleteTempNode(Integer id);
	/**
	 * 根据父类ID查询子节点
	 * @param fid
	 * @return
	 */
	List<TTempNode> selectTempNodeByFid(Integer fid);
	/**
	 * 获取浏览报文
	 * @param ids 根节点IDS 以“;”分隔
	 * @param xforma 报文格式
	 * @param title 报文标题
	 * @param isTitle 是否需要标题
	 * @return
	 */
	String getScanMsg(String ids,String xformat,String xtitle,String isTitle);
	/**
	 * 保存节点规则
	 * @param pojo
	 * @return
	 */
	Map<String,String> saveMsgEngin(LoginInfo loginInfo,MsgConfigPOJO pojo);
	/**
	 * 删除报文引擎
	 * @param bussId
	 * @return
	 */
	boolean deleteMsgEngen(BigDecimal bussId);
	/**
	 * 删除节点对的SQL相关信息
	 * @param nodeId
	 * @return
	 */
	boolean deleteNodeSql(BigDecimal nodeId);
	/**
	 * 获取报送接口 根节点信息（参数DTO）
	 * @return
	 */
	public List<NodeTree> getDTORootFromTemp(String type,String formatType,String bussType);
	/**
	 * 判断是否是系统默认参数:
	 * SQL_ID IS NULL AND PARAM_SUB_TYPE=0
	 * @param id
	 * @return
	 */
	boolean isSysDefaultParam(Integer id);
}
