package com.sinosoft.ummp.domain.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinosoft.ummp.domain.model.TTempNodeAttri;
import com.sinosoft.ummp.domain.model.TTempNodeAttriExample;

public interface TTempNodeAttriMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE_ATTRI
     *
     * @mbggenerated Tue Jun 21 10:57:47 CST 2016
     */
    int countByExample(TTempNodeAttriExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE_ATTRI
     *
     * @mbggenerated Tue Jun 21 10:57:47 CST 2016
     */
    int deleteByExample(TTempNodeAttriExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE_ATTRI
     *
     * @mbggenerated Tue Jun 21 10:57:47 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE_ATTRI
     *
     * @mbggenerated Tue Jun 21 10:57:47 CST 2016
     */
    int insert(TTempNodeAttri record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE_ATTRI
     *
     * @mbggenerated Tue Jun 21 10:57:47 CST 2016
     */
    int insertSelective(TTempNodeAttri record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE_ATTRI
     *
     * @mbggenerated Tue Jun 21 10:57:47 CST 2016
     */
    List<TTempNodeAttri> selectByExample(TTempNodeAttriExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE_ATTRI
     *
     * @mbggenerated Tue Jun 21 10:57:47 CST 2016
     */
    TTempNodeAttri selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE_ATTRI
     *
     * @mbggenerated Tue Jun 21 10:57:47 CST 2016
     */
    int updateByExampleSelective(@Param("record") TTempNodeAttri record, @Param("example") TTempNodeAttriExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE_ATTRI
     *
     * @mbggenerated Tue Jun 21 10:57:47 CST 2016
     */
    int updateByExample(@Param("record") TTempNodeAttri record, @Param("example") TTempNodeAttriExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE_ATTRI
     *
     * @mbggenerated Tue Jun 21 10:57:47 CST 2016
     */
    int updateByPrimaryKeySelective(TTempNodeAttri record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE_ATTRI
     *
     * @mbggenerated Tue Jun 21 10:57:47 CST 2016
     */
    int updateByPrimaryKey(TTempNodeAttri record);
    /**
     * 根据NodeId获取对应的属性
     * @param nodeId
     * @return
     */
    List<TTempNodeAttri> selectByNodeId(Integer nodeId);

	/**
	 * @param nodeId
	 */
	int deleteByNodeIdRecurs(BigDecimal nodeId);
}