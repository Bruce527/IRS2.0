package com.sinosoft.platform.core.spring;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 配置于resources/spring/infrastructure-persistence.xml 中，<br>
 * 线程局部变量TreadLocal DBContextHolder 保存当前需要的数据类类型，<br>
 * 当 DBContextHolder.setDBType(DBContextHolder.XX) 保存当前需要的数据类型时候，<br>
 * DataSource 会从当前线程中查找线程变量的数据类型，从而决定使用何种数据源。<br>
 * @author Darker.Wang
 * @date 2016-7-7 下午1:52:51
 * @company SINOSOFT
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DBContextHolder.getDBType();
	}
}
