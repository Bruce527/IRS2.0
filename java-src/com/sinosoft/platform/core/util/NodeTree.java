/**
 * 
 */
package com.sinosoft.platform.core.util;

import java.io.Serializable;
import java.util.List;

/**
 * 节点封装类（树）
 * @author Darker.Wang
 * @date 2016-6-21 上午10:16:17
 */
public class NodeTree implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//节点id,它是重要的来加载远程数据 
	private Integer fid;
	private String text;//节点文本来显示 
	private String state;//节点状态,“open”或“closed”,默认是“open”。当设置为“closed”,节点有子节点,并将负载从远程站点 
	private Integer checked;//显示选定的节点是否选中。 
	private Integer num;//排序号
	private List<NodeAttri> attributes;//自定义属性可以被添加到一个节点 
	private List<NodeTree> children;//一个数组节点定义了一些子节点
	private List<NodeParam> parameters;
	//定义子节点形成规则和方式
	private String sonNodeContent;
	private String sonNodeType;
	//添加存储DTO的类名和类
	private String code;
	private String name;
	/**
	 * 
	 */
	public NodeTree() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getChecked() {
		return checked;
	}

	public void setChecked(Integer checked) {
		this.checked = checked;
	}

	public List<NodeAttri> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<NodeAttri> attributes) {
		this.attributes = attributes;
	}

	public List<NodeTree> getChildren() {
		return children;
	}

	public void setChildren(List<NodeTree> children) {
		this.children = children;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public List<NodeParam> getParameters() {
		return parameters;
	}

	public void setParameters(List<NodeParam> parameters) {
		this.parameters = parameters;
	}

	public String getSonNodeContent() {
		return sonNodeContent;
	}

	public void setSonNodeContent(String sonNodeContent) {
		this.sonNodeContent = sonNodeContent;
	}

	public String getSonNodeType() {
		return sonNodeType;
	}

	public void setSonNodeType(String conNodeType) {
		this.sonNodeType = conNodeType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
