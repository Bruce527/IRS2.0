package com.sinosoft.platform.core.util;
/*****************************************************
 * HISTORY
 * 
 * 2013/04/11 yangzd 创建文件
 * 
 * YYYY/MM/DD ----- 增加新功能
 * 
 *****************************************************/
import java.util.ArrayList;
import java.util.List;

/**
 * 节点定义
 * @author Darker.Wang
 * @date 2016-8-11 下午5:40:47
 * @company SINOSOFT
 */
public class Nodes {


	private Integer id ;

	private String pId = "0"; // 夫级菜单的 id

	private String name = "";

	private String target = "";

	private String system = "";

	private String click = "";
	
	private String url = "";
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getClick() {
		return click;
	}

	public void setClick(String click) {
		this.click = click;
	}

	private List<Nodes> Nodes = new ArrayList<Nodes>();

	// 可根据需要添加其他属性

	public Integer getId() {

		return id;

	}

	public void setId(Integer id) {

		this.id = id;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getTarget() {

		return target;

	}

	public void setTarget(String target) {

		this.target = target;

	}

	public List<Nodes> getNodes() {

		return Nodes;

	}

	public void setNodes(List<Nodes> Nodes) {

		this.Nodes = Nodes;

	}

	public String getpId() {

		return pId;

	}

	public void setpId(String pId) {

		this.pId = pId;

	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

}
