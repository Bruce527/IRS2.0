/**
 * 
 */
package com.sinosoft.ummp.application;

import java.util.List;

import com.sinosoft.platform.core.util.NodeTree;

/**
 * DTO 解析接口
 * @author Darker.Wang
 * @date 2016-7-28 下午6:06:50
 * @company SINOSOFT
 */
public interface DTOAnalizyService {

	/**
	 * 根业务类型解析DTO报送接口类信息 (以对ID赋值完毕)
	 * @param bussType
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<NodeTree> dtoAnalizy(String bussType) 
			throws ClassNotFoundException, InstantiationException, IllegalAccessException;
}
