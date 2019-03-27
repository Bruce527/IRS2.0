/**
 功能: 更新表：T_DEF_ACTION_TRACE、T_DEF_ACTION_RETURN 列说明
 日期: 2016-11-29
 作者: 王萍
**/
-- Add comments to the table T_DEF_ACTION_TRACE 
comment on table T_DEF_ACTION_TRACE
  is '动态记录轨迹表';
-- Add comments to the columns 
comment on column T_DEF_ACTION_TRACE.batch_no
  is '交易批次号';
comment on column T_DEF_ACTION_TRACE.batch_type
  is '交易批次类型';
comment on column T_DEF_ACTION_TRACE.buss_no
  is '交易业务号';
comment on column T_DEF_ACTION_TRACE.buss_type
  is '交易业务类型';
comment on column T_DEF_ACTION_TRACE.sub_buss_type
  is '交易父级业务类型 EB-提数 SB-报送';
comment on column T_DEF_ACTION_TRACE.plat_com
  is '机构编码即平台编码，对应PLAT_COM中的ID';
comment on column T_DEF_ACTION_TRACE.action_no
  is '交易业务流水号，与ACTION_RETURN关联';
comment on column T_DEF_ACTION_TRACE.action_date
  is '交易业务日期，当前报送提数日期';
comment on column T_DEF_ACTION_TRACE.action_all_count
  is '交易业务记录所有';
comment on column T_DEF_ACTION_TRACE.action_suc_count
  is '交易业务成功记录';
comment on column T_DEF_ACTION_TRACE.action_type
  is '交易业务类型，接口';
comment on column T_DEF_ACTION_TRACE.action_msg
  is '交易业务提示信息，接口交易信息';
comment on column T_DEF_ACTION_TRACE.data_msg
  is '数据信息：失败必填，成功：操作成功';
comment on column T_DEF_ACTION_TRACE.data_status
  is '数据状态 1-成功 0-失败';
comment on column T_DEF_ACTION_TRACE.es_status
  is '本条记录状态标识 1 - 有效 0 - 无效 2 - 删除';
comment on column T_DEF_ACTION_TRACE.insert_time
  is '入库日期';
comment on column T_DEF_ACTION_TRACE.last_modify_time
  is '最后一次修改日期';
comment on column T_DEF_ACTION_TRACE.operator
  is '操作者';
comment on column T_DEF_ACTION_TRACE.standby1
  is '备用字段1';
comment on column T_DEF_ACTION_TRACE.standby2
  is '备用字段2';
comment on column T_DEF_ACTION_TRACE.standby3
  is '备用字段3';
comment on column T_DEF_ACTION_TRACE.standby4
  is '备用字段4';
comment on column T_DEF_ACTION_TRACE.state_flag
  is '状态标识，本次业务状态标示';
comment on column T_DEF_ACTION_TRACE.start_date
  is '起始日期，本次业务起始日期';
comment on column T_DEF_ACTION_TRACE.end_date
  is '结束日期，本次业务结束日期';
comment on column T_DEF_ACTION_TRACE.action_time
  is '操作实时时间';

-- Add comments to the T_DEF_ACTION_RETURN columns 
comment on column T_DEF_ACTION_RETURN.action_no
  is '业务流水号，与ACTION_TRACE绑定';
comment on column T_DEF_ACTION_RETURN.plat_com
  is '机构编码 与PLAT_COM中ID绑定';
comment on column T_DEF_ACTION_RETURN.buss_type
  is '业务类型 与ACTION_TRACE中相同';
comment on column T_DEF_ACTION_RETURN.sub_buss_type
  is '业务类型 与ACTION_TRACE中相同';
comment on column T_DEF_ACTION_RETURN.status
  is '业务状态，是否成功接收到，用于与平台交互标识';
comment on column T_DEF_ACTION_RETURN.data_status
  is '业务处理状态，是否处理成功（保单登记用）';
comment on column T_DEF_ACTION_RETURN.check_status
  is '校验状态，用于校验数据使用（保单登记批处理用）';
comment on column T_DEF_ACTION_RETURN.query_no
  is '查询码，返回码，与平台交互时平台返回';
comment on column T_DEF_ACTION_RETURN.return_msg
  is '返回信息，与平台交互时平台返回';
comment on column T_DEF_ACTION_RETURN.erro_ratio
  is '错误率，批次处理错误率（保单登记用）';
comment on column T_DEF_ACTION_RETURN.err_info_path
  is '错误文件路径（保单登记用）';
comment on column T_DEF_ACTION_RETURN.return_code
  is '返回码，平台返回编码';
comment on column T_DEF_ACTION_RETURN.return_data
  is '返回数据，用于xml存储';
comment on column T_DEF_ACTION_RETURN.data_type
  is '数据类型，0-无需处理 1-需要处理';
comment on column T_DEF_ACTION_RETURN.data_flag
  is '状态标识：0-无需处理 1-等待处理 2-正在处理 9-处理完毕';
comment on column T_DEF_ACTION_RETURN.operator
  is '操作者';
comment on column T_DEF_ACTION_RETURN.insert_time
  is '入库日期';
comment on column T_DEF_ACTION_RETURN.last_modify_time
  is '最后一次修改日期';
comment on column T_DEF_ACTION_RETURN.es_status
  is '状态标识：1-有效 2-删除 0-无效';
comment on column T_DEF_ACTION_RETURN.standby1
  is '备用字段1';
comment on column T_DEF_ACTION_RETURN.standby2
  is '备用字段2';
comment on column T_DEF_ACTION_RETURN.standby3
  is '备用字段3';
comment on column T_DEF_ACTION_RETURN.standby4
  is '备用字段4';