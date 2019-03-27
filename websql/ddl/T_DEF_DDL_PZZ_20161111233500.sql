prompt PL/SQL Developer import file
prompt Created on 2016年11月11日 by gyas-itpingw
set feedback off
set define off
prompt Dropping T_DEF_ACTION_TRACE...
drop table T_DEF_ACTION_TRACE cascade constraints;
prompt Dropping T_DEF_BAG_EVENT...
drop table T_DEF_BAG_EVENT cascade constraints;
prompt Dropping T_DEF_BATCH...
drop table T_DEF_BATCH cascade constraints;
prompt Dropping T_DEF_PLAT_COM...
drop table T_DEF_PLAT_COM cascade constraints;
prompt Dropping T_DEF_BUSS_MODEL...
drop table T_DEF_BUSS_MODEL cascade constraints;
prompt Dropping T_DEF_BUSS_IMPL...
drop table T_DEF_BUSS_IMPL cascade constraints;
prompt Dropping T_DEF_BUSS_SEND_RELA...
drop table T_DEF_BUSS_SEND_RELA cascade constraints;
prompt Dropping T_DEF_MSG_NODE...
drop table T_DEF_MSG_NODE cascade constraints;
prompt Dropping T_DEF_BUSS_XENGIN...
drop table T_DEF_BUSS_XENGIN cascade constraints;
prompt Dropping T_DEF_CODE_DICT...
drop table T_DEF_CODE_DICT cascade constraints;
prompt Dropping T_DEF_CODE_MAPPING...
drop table T_DEF_CODE_MAPPING cascade constraints;
prompt Dropping T_DEF_JDBC...
drop table T_DEF_JDBC cascade constraints;
prompt Dropping T_DEF_JOB_LOG...
drop table T_DEF_JOB_LOG cascade constraints;
prompt Dropping T_DEF_MANAGE_COM...
drop table T_DEF_MANAGE_COM cascade constraints;
prompt Dropping T_DEF_MONITOR...
drop table T_DEF_MONITOR cascade constraints;
prompt Dropping T_DEF_MONITOR_ACTION...
drop table T_DEF_MONITOR_ACTION cascade constraints;
prompt Dropping T_DEF_NOTICE...
drop table T_DEF_NOTICE cascade constraints;
prompt Dropping T_DEF_MONITOR_NOTIC_RELA...
drop table T_DEF_MONITOR_NOTIC_RELA cascade constraints;
prompt Dropping T_DEF_MSG_NODESQL_RELA...
drop table T_DEF_MSG_NODESQL_RELA cascade constraints;
prompt Dropping T_DEF_MSG_NODE_ATTRI...
drop table T_DEF_MSG_NODE_ATTRI cascade constraints;
prompt Dropping T_DEF_NOTICE_ACCOUNT...
drop table T_DEF_NOTICE_ACCOUNT cascade constraints;
prompt Dropping T_DEF_NOTICE_ADD...
drop table T_DEF_NOTICE_ADD cascade constraints;
prompt Dropping T_DEF_NOTICE_MAIN...
drop table T_DEF_NOTICE_MAIN cascade constraints;
prompt Dropping T_DEF_NOTICE_SECRETLY...
drop table T_DEF_NOTICE_SECRETLY cascade constraints;
prompt Dropping T_DEF_ROLE...
drop table T_DEF_ROLE cascade constraints;
prompt Dropping T_DEF_PLAT_ROLE_RELA...
drop table T_DEF_PLAT_ROLE_RELA cascade constraints;
prompt Dropping T_DEF_PRIVILEGE...
drop table T_DEF_PRIVILEGE cascade constraints;
prompt Dropping T_DEF_REPORT_COL...
drop table T_DEF_REPORT_COL cascade constraints;
prompt Dropping T_DEF_ROLE_PRIVILEGE_RELA...
drop table T_DEF_ROLE_PRIVILEGE_RELA cascade constraints;
prompt Dropping T_DEF_SEND...
drop table T_DEF_SEND cascade constraints;
prompt Dropping T_DEF_SFTP...
drop table T_DEF_SFTP cascade constraints;
prompt Dropping T_DEF_SQL...
drop table T_DEF_SQL cascade constraints;
prompt Dropping T_DEF_SQL_PARAMS...
drop table T_DEF_SQL_PARAMS cascade constraints;
prompt Dropping T_DEF_TRANSCODE_TRACE...
drop table T_DEF_TRANSCODE_TRACE cascade constraints;
prompt Dropping T_DEF_TRANSEXC...
drop table T_DEF_TRANSEXC cascade constraints;
prompt Dropping T_DEF_TRANSEXC_ACTION...
drop table T_DEF_TRANSEXC_ACTION cascade constraints;
prompt Dropping T_DEF_TRANSEXC_AFTER...
drop table T_DEF_TRANSEXC_AFTER cascade constraints;
prompt Dropping T_DEF_TRANSEXC_BEFORE...
drop table T_DEF_TRANSEXC_BEFORE cascade constraints;
prompt Dropping T_DEF_TRANS_CODE...
drop table T_DEF_TRANS_CODE cascade constraints;
prompt Dropping T_DEF_USER...
drop table T_DEF_USER cascade constraints;
prompt Dropping T_DEF_USER_ROLE_RELA...
drop table T_DEF_USER_ROLE_RELA cascade constraints;
prompt Dropping T_DEF_USER_TRACE...
drop table T_DEF_USER_TRACE cascade constraints;
prompt Dropping T_DEF_WSP_REQUEST...
drop table T_DEF_WSP_REQUEST cascade constraints;
prompt Dropping T_DEF_WSP_PARAM...
drop table T_DEF_WSP_PARAM cascade constraints;
prompt Dropping T_DEF_WSP_RETURN...
drop table T_DEF_WSP_RETURN cascade constraints;
prompt Dropping T_DOC_MAIN...
drop table T_DOC_MAIN cascade constraints;
prompt Dropping T_DOC_PAGES...
drop table T_DOC_PAGES cascade constraints;
prompt Dropping T_DOC_UPDOWN...
drop table T_DOC_UPDOWN cascade constraints;
prompt Dropping T_TEMP_NODE...
drop table T_TEMP_NODE cascade constraints;
prompt Dropping T_TEMP_NODE_ATTRI...
drop table T_TEMP_NODE_ATTRI cascade constraints;
prompt Dropping T_TEMP_NODE_PARAM...
drop table T_TEMP_NODE_PARAM cascade constraints;

prompt Dropping T_DEF_ACTION_RETURN...
drop table T_DEF_ACTION_RETURN cascade constraints;
prompt Dropping T_DEF_SQL_INFO...
drop table T_DEF_SQL_INFO cascade constraints;
prompt Creating T_DEF_ACTION_TRACE...
create table T_DEF_ACTION_TRACE
(
  id               NUMBER(19) not null,
  batch_no         VARCHAR2(50),
  batch_type       VARCHAR2(50),
  buss_no          VARCHAR2(50),
  buss_type        VARCHAR2(50),
  sub_buss_type    VARCHAR2(50),
  plat_com         NUMBER(19),
  action_no        VARCHAR2(50) not null,
  action_date      DATE,
  action_all_count NUMBER(10),
  action_suc_count NUMBER(10),
  action_type      VARCHAR2(50),
  action_msg       VARCHAR2(200),
  data_msg         VARCHAR2(200),
  data_status      VARCHAR2(10),
  es_status        NUMBER(1),
  insert_time      DATE,
  last_modify_time DATE,
  operator         VARCHAR2(50),
  standby1         VARCHAR2(50),
  standby2         VARCHAR2(50),
  standby3         VARCHAR2(50),
  standby4         VARCHAR2(50),
  state_flag       VARCHAR2(50),
  start_date       DATE,
  end_date         DATE,
  action_time      VARCHAR2(20)
)
;
comment on table T_DEF_ACTION_TRACE
  is '动态记录轨迹表';
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
  is '交易业务流水号';
comment on column T_DEF_ACTION_TRACE.action_date
  is '交易业务日期';
comment on column T_DEF_ACTION_TRACE.action_all_count
  is '交易业务记录';
comment on column T_DEF_ACTION_TRACE.action_suc_count
  is '交易业务成功记录';
comment on column T_DEF_ACTION_TRACE.action_type
  is '交易业务类型';
comment on column T_DEF_ACTION_TRACE.action_msg
  is '交易业务提示信息';
comment on column T_DEF_ACTION_TRACE.data_msg
  is '数据信息：失败必填，成功：操作成功';
comment on column T_DEF_ACTION_TRACE.data_status
  is '数据状态 1-成功 0-失败';
comment on column T_DEF_ACTION_TRACE.es_status
  is '状态标识';
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
  is '状态标识';
comment on column T_DEF_ACTION_TRACE.start_date
  is '起始日期';
comment on column T_DEF_ACTION_TRACE.end_date
  is '结束日期';
comment on column T_DEF_ACTION_TRACE.action_time
  is '操作实时时间';
alter table T_DEF_ACTION_TRACE
  add constraint PK_T_DEF_ACTION_TRACE primary key (ID);

prompt Creating T_DEF_BAG_EVENT...
create table T_DEF_BAG_EVENT
(
  id               NUMBER(19) not null,
  monitor_code     VARCHAR2(20 CHAR),
  sql_id           NUMBER(19),
  es_status        NUMBER(1),
  insert_time      DATE,
  last_modify_time DATE,
  operator         VARCHAR2(50)
)
;
comment on table T_DEF_BAG_EVENT
  is '包与事件关联表';
comment on column T_DEF_BAG_EVENT.monitor_code
  is '监控编码';
comment on column T_DEF_BAG_EVENT.sql_id
  is '事件ID';
comment on column T_DEF_BAG_EVENT.es_status
  is '状态标识 1 有效 0 无效 2 删除';
comment on column T_DEF_BAG_EVENT.insert_time
  is '入库时间';
comment on column T_DEF_BAG_EVENT.last_modify_time
  is '最后一次修改时间';
comment on column T_DEF_BAG_EVENT.operator
  is '操作者';
alter table T_DEF_BAG_EVENT
  add constraint T_DEF_BAG_EVENT primary key (ID);

prompt Creating T_DEF_BATCH...
create table T_DEF_BATCH
(
  id             NUMBER(19) not null,
  mapping_no     VARCHAR2(50),
  batch_type     VARCHAR2(50),
  batch_no       NUMBER(10),
  trans_no       NUMBER(10),
  trans_date     VARCHAR2(50),
  buss_no        VARCHAR2(50),
  buss_type      VARCHAR2(50),
  sub_batch_type VARCHAR2(50),
  insert_time    DATE,
  date_serial    VARCHAR2(21)
)
;
comment on column T_DEF_BATCH.id
  is '变更号，无则可做';
comment on column T_DEF_BATCH.mapping_no
  is '变更ID';
comment on column T_DEF_BATCH.batch_type
  is '批次类型';
comment on column T_DEF_BATCH.batch_no
  is '批次号';
comment on column T_DEF_BATCH.trans_no
  is '交易号';
comment on column T_DEF_BATCH.trans_date
  is '交易日期';
comment on column T_DEF_BATCH.buss_no
  is '业务号';
comment on column T_DEF_BATCH.buss_type
  is '业务类型';
comment on column T_DEF_BATCH.sub_batch_type
  is '父级批次类型';
comment on column T_DEF_BATCH.insert_time
  is '入库日期';
comment on column T_DEF_BATCH.date_serial
  is '当前日期';
alter table T_DEF_BATCH
  add constraint PK_T_DEF_BATCH primary key (ID);

prompt Creating T_DEF_PLAT_COM...
create table T_DEF_PLAT_COM
(
  com_id         NUMBER(19) not null,
  com_code       VARCHAR2(50 CHAR),
  com_name       VARCHAR2(20 CHAR),
  com_pid        NUMBER(19),
  com_name_short VARCHAR2(20 CHAR),
  com_name_en    VARCHAR2(50 CHAR),
  com_address    VARCHAR2(100 CHAR),
  com_email      VARCHAR2(50 CHAR),
  com_phone      VARCHAR2(20 CHAR)
)
;
comment on table T_DEF_PLAT_COM
  is '用来存储平台机构的基本信息';
comment on column T_DEF_PLAT_COM.com_code
  is '机构编码';
comment on column T_DEF_PLAT_COM.com_name
  is '机构名称';
comment on column T_DEF_PLAT_COM.com_pid
  is '父类机构ID';
comment on column T_DEF_PLAT_COM.com_name_short
  is '机构简称';
comment on column T_DEF_PLAT_COM.com_name_en
  is '机构英文名称';
comment on column T_DEF_PLAT_COM.com_address
  is '机构地址';
comment on column T_DEF_PLAT_COM.com_email
  is '机构联系EMAIL';
comment on column T_DEF_PLAT_COM.com_phone
  is '机构联系电话';
alter table T_DEF_PLAT_COM
  add constraint PK_T_DEF_PLATCOM primary key (COM_ID);

prompt Creating T_DEF_BUSS_MODEL...
create table T_DEF_BUSS_MODEL
(
  buss_id       NUMBER(19) not null,
  buss_pid      NUMBER(19),
  buss_type     VARCHAR2(50 CHAR),
  buss_code     VARCHAR2(100 CHAR),
  buss_name     VARCHAR2(50 CHAR),
  com_id        NUMBER(19),
  rc_status     NUMBER(1),
  is_title      NUMBER(1),
  title_info    VARCHAR2(100 CHAR),
  sub_buss_type VARCHAR2(50 CHAR)
)
;
comment on table T_DEF_BUSS_MODEL
  is '平台业务模型定义表';
comment on column T_DEF_BUSS_MODEL.buss_id
  is '平台业务类型ID';
comment on column T_DEF_BUSS_MODEL.buss_pid
  is '父类业务类型ID(暂时未用)';
comment on column T_DEF_BUSS_MODEL.buss_type
  is '业务类型  与 T_DEF_CODE_DICT中定义类型一致';
comment on column T_DEF_BUSS_MODEL.buss_code
  is '业务类型编码';
comment on column T_DEF_BUSS_MODEL.buss_name
  is '业务类型名称';
comment on column T_DEF_BUSS_MODEL.com_id
  is '对应 PLATCOM 中的 COM_ID';
comment on column T_DEF_BUSS_MODEL.rc_status
  is '状态标识 1 有效 0 无效 2 删除';
comment on column T_DEF_BUSS_MODEL.is_title
  is '是否需要标题 用于报文引擎时所用 1 是 0 否';
comment on column T_DEF_BUSS_MODEL.title_info
  is '具体TITLE信息';
comment on column T_DEF_BUSS_MODEL.sub_buss_type
  is '报文定义 MSG_REQUEST 请求报文 MSG_RESPONSE 返回报文';
alter table T_DEF_BUSS_MODEL
  add constraint PK_T_DEF_BUSSMODEL primary key (BUSS_ID);
alter table T_DEF_BUSS_MODEL
  add constraint FK_T_DEF_BU_REFERENCE_T_DEF_PL foreign key (COM_ID)
  references T_DEF_PLAT_COM (COM_ID);

prompt Creating T_DEF_BUSS_IMPL...
create table T_DEF_BUSS_IMPL
(
  impl_id          NUMBER(19) not null,
  impl_type        VARCHAR2(20 CHAR),
  impl_code        VARCHAR2(50 CHAR),
  impl_name        VARCHAR2(50 CHAR),
  buss_id          NUMBER(19),
  format_type      VARCHAR2(20 CHAR),
  send_type        VARCHAR2(20 CHAR),
  rc_status        NUMBER(1),
  insert_time      DATE,
  last_modify_time DATE,
  operator         VARCHAR2(50 CHAR)
)
;
comment on table T_DEF_BUSS_IMPL
  is '业务实现方式定义';
comment on column T_DEF_BUSS_IMPL.impl_type
  is '与 T_DEF_CODE_DICT 中定义的CODE相同';
comment on column T_DEF_BUSS_IMPL.impl_code
  is '实现方式编码';
comment on column T_DEF_BUSS_IMPL.impl_name
  is '现方式名称';
comment on column T_DEF_BUSS_IMPL.format_type
  is '报文格式 对应T_DEF_CODE_DICT中的CODE';
comment on column T_DEF_BUSS_IMPL.send_type
  is '报文格式 对应T_DEF_CODE_DICT中的CODE';
comment on column T_DEF_BUSS_IMPL.rc_status
  is '状态标识 0-无效 1-有效 2-删除';
alter table T_DEF_BUSS_IMPL
  add constraint PK_T_DEF_BUSS_IMPL primary key (IMPL_ID);
alter table T_DEF_BUSS_IMPL
  add constraint FK_BUSSIMPL_BUSSMODE foreign key (BUSS_ID)
  references T_DEF_BUSS_MODEL (BUSS_ID);

prompt Creating T_DEF_BUSS_SEND_RELA...
create table T_DEF_BUSS_SEND_RELA
(
  id               NUMBER(19) not null,
  buss_id          NUMBER(19),
  send_id          NUMBER(19),
  rc_status        NUMBER(1),
  insert_time      DATE,
  last_modify_time DATE,
  operator         VARCHAR2(50)
)
;
comment on table T_DEF_BUSS_SEND_RELA
  is '业务报送关联定义';
comment on column T_DEF_BUSS_SEND_RELA.buss_id
  is '业务ID';
comment on column T_DEF_BUSS_SEND_RELA.send_id
  is '报送接口';
comment on column T_DEF_BUSS_SEND_RELA.rc_status
  is '有效标识 1 有效 0 无效 2 删除';
comment on column T_DEF_BUSS_SEND_RELA.insert_time
  is '入库时间';
comment on column T_DEF_BUSS_SEND_RELA.last_modify_time
  is '最后一次修改时间';
comment on column T_DEF_BUSS_SEND_RELA.operator
  is '操作者';
alter table T_DEF_BUSS_SEND_RELA
  add constraint PK_T_DEF_BUSS_SEND_RELA primary key (ID);
alter table T_DEF_BUSS_SEND_RELA
  add constraint FK_BUSS2BS_RELA foreign key (BUSS_ID)
  references T_DEF_BUSS_MODEL (BUSS_ID);

prompt Creating T_DEF_MSG_NODE...
create table T_DEF_MSG_NODE
(
  node_id       NUMBER(19) not null,
  node_pid      NUMBER(19),
  node_code     VARCHAR2(50 CHAR),
  node_name     VARCHAR2(50 CHAR),
  node_text     VARCHAR2(50 CHAR),
  node_num      NUMBER(10),
  rc_status     NUMBER(1),
  son_node_type NUMBER(1)
)
;
comment on table T_DEF_MSG_NODE
  is '报文引擎节点定义表';
comment on column T_DEF_MSG_NODE.node_id
  is '序列ID';
comment on column T_DEF_MSG_NODE.node_pid
  is '父类序列ID';
comment on column T_DEF_MSG_NODE.node_code
  is '节点编码';
comment on column T_DEF_MSG_NODE.node_name
  is '节点名称';
comment on column T_DEF_MSG_NODE.node_text
  is '节点文本';
comment on column T_DEF_MSG_NODE.node_num
  is '节点加载顺序';
comment on column T_DEF_MSG_NODE.rc_status
  is '状态标识 1 有效 0 无效 2 删除';
comment on column T_DEF_MSG_NODE.son_node_type
  is '是否有子节点 1 是  0 或 null 否';
alter table T_DEF_MSG_NODE
  add constraint PK_T_DEF_MSG_NODE primary key (NODE_ID);

prompt Creating T_DEF_BUSS_XENGIN...
create table T_DEF_BUSS_XENGIN
(
  id                   NUMBER(19) not null,
  node_id              NUMBER(19),
  impl_id              NUMBER(19),
  buss_id              NUMBER(19),
  rc_status            NUMBER(1),
  insert_time          DATE,
  operator             VARCHAR2(50),
  last_modify_time     DATE,
  last_modify_operator VARCHAR2(50)
)
;
comment on table T_DEF_BUSS_XENGIN
  is '定义业务报文引擎的节点关联';
comment on column T_DEF_BUSS_XENGIN.impl_id
  is '实现ID';
comment on column T_DEF_BUSS_XENGIN.rc_status
  is '是否有效 1-有效 0-无效 一个业务号ID只存在一个有效的记录';
alter table T_DEF_BUSS_XENGIN
  add constraint PK_T_DEF_BUSS_XENGIN primary key (ID);
alter table T_DEF_BUSS_XENGIN
  add constraint FK_MSG_NODE foreign key (NODE_ID)
  references T_DEF_MSG_NODE (NODE_ID);

prompt Creating T_DEF_CODE_DICT...
create table T_DEF_CODE_DICT
(
  code_type        VARCHAR2(50 CHAR) not null,
  code             VARCHAR2(50 CHAR) not null,
  code_name        VARCHAR2(50 CHAR) not null,
  code_alias       VARCHAR2(200),
  com_id           NUMBER(19),
  es_status        NUMBER(1) not null,
  code_group_rela  VARCHAR2(50 CHAR),
  code_status_rela VARCHAR2(50 CHAR)
)
;
comment on table T_DEF_CODE_DICT
  is '枚举字典定义表';
comment on column T_DEF_CODE_DICT.code_type
  is '枚举编码类型';
comment on column T_DEF_CODE_DICT.code
  is '枚举编码值';
comment on column T_DEF_CODE_DICT.code_name
  is '枚举编码名称';
comment on column T_DEF_CODE_DICT.code_alias
  is '枚举编码别名';
comment on column T_DEF_CODE_DICT.com_id
  is '机构ID，对应 T_DEF_PLATCOM 的 COM_ID，那个机构下可以用该码';
comment on column T_DEF_CODE_DICT.es_status
  is '状态标识 1 有效 0 无效 2 删除';
comment on column T_DEF_CODE_DICT.code_group_rela
  is '编码群组关联';
comment on column T_DEF_CODE_DICT.code_status_rela
  is '编码状态关联';
alter table T_DEF_CODE_DICT
  add constraint PK_T_DEF_CODEDICT unique (CODE_TYPE, CODE, COM_ID);

prompt Creating T_DEF_CODE_MAPPING...
create table T_DEF_CODE_MAPPING
(
  id               NUMBER(19) not null,
  code_type        VARCHAR2(50 CHAR) not null,
  basic_code       VARCHAR2(300 CHAR) not null,
  basic_code_name  VARCHAR2(600 CHAR),
  target_code      VARCHAR2(300 CHAR),
  target_code_name VARCHAR2(600 CHAR),
  com_id           NUMBER(19),
  manage_id        NUMBER(19),
  remark           VARCHAR2(600 CHAR),
  es_status        NUMBER(1)
)
;
comment on table T_DEF_CODE_MAPPING
  is '枚举码表映射关系';
comment on column T_DEF_CODE_MAPPING.id
  is '序列ID';
comment on column T_DEF_CODE_MAPPING.code_type
  is '转换映射类型';
comment on column T_DEF_CODE_MAPPING.basic_code
  is '待转换值编码';
comment on column T_DEF_CODE_MAPPING.basic_code_name
  is '待转换名称';
comment on column T_DEF_CODE_MAPPING.target_code
  is '转换后编码';
comment on column T_DEF_CODE_MAPPING.target_code_name
  is '转换后名称';
comment on column T_DEF_CODE_MAPPING.com_id
  is '所属平台机构，对应 T_DEF_PLATCOM 的 COM_ID';
comment on column T_DEF_CODE_MAPPING.manage_id
  is '所属管理机构';
comment on column T_DEF_CODE_MAPPING.remark
  is '备注';
comment on column T_DEF_CODE_MAPPING.es_status
  is '状态标识 1 有效 0 无效 2 删除';
alter table T_DEF_CODE_MAPPING
  add constraint PK_T_DEF_CODEMAPPING primary key (ID);

prompt Creating T_DEF_JDBC...
create table T_DEF_JDBC
(
  id          NUMBER(19) not null,
  jdbc_type   VARCHAR2(10 CHAR),
  jdbc_code   VARCHAR2(50 CHAR),
  jdbc_name   VARCHAR2(50 CHAR),
  driver_name VARCHAR2(50 CHAR),
  url         VARCHAR2(100 CHAR),
  username    VARCHAR2(50 CHAR),
  password    VARCHAR2(50 CHAR),
  jndi_name   VARCHAR2(50 CHAR),
  dialect     VARCHAR2(50 CHAR),
  description VARCHAR2(2000 CHAR)
)
;
comment on table T_DEF_JDBC
  is '定义系统用到的额外JDBC信息';
comment on column T_DEF_JDBC.jdbc_type
  is 'JDBC类型：1 表示通过用户名称获取 2：表示通过JNDI获取 3：表示分布式获取 4:表示SPRING数据源获取';
comment on column T_DEF_JDBC.jdbc_code
  is '显示其编码';
comment on column T_DEF_JDBC.jdbc_name
  is '显示器名称';
comment on column T_DEF_JDBC.driver_name
  is '驱动名称';
comment on column T_DEF_JDBC.url
  is '访问URL';
comment on column T_DEF_JDBC.username
  is '用户名';
comment on column T_DEF_JDBC.password
  is '用户密码';
comment on column T_DEF_JDBC.jndi_name
  is 'TYPE为2时 非空 服务器定义的JDBC名称';
comment on column T_DEF_JDBC.dialect
  is '方言，说明是那种数据库';
comment on column T_DEF_JDBC.description
  is '描述，TYPE为3是非空';
alter table T_DEF_JDBC
  add constraint PK_T_DEF_JDBC primary key (ID);

prompt Creating T_DEF_JOB_LOG...
create table T_DEF_JOB_LOG
(
  id               NUMBER(19) not null,
  job_code         VARCHAR2(50),
  job_name         VARCHAR2(50),
  job_group        VARCHAR2(50),
  job_type         VARCHAR2(50),
  job_status       VARCHAR2(1),
  start_time       VARCHAR2(20),
  end_time         VARCHAR2(20),
  run_msg          VARCHAR2(50),
  insert_time      DATE,
  last_modify_time DATE,
  operator         VARCHAR2(20)
)
;
comment on table T_DEF_JOB_LOG
  is 'Job执行日志';
comment on column T_DEF_JOB_LOG.id
  is 'ID';
comment on column T_DEF_JOB_LOG.job_code
  is 'JOB编码';
comment on column T_DEF_JOB_LOG.job_name
  is 'JOB名称';
comment on column T_DEF_JOB_LOG.job_group
  is 'JOB组别';
comment on column T_DEF_JOB_LOG.job_type
  is 'JOB类型';
comment on column T_DEF_JOB_LOG.job_status
  is 'JOB状态，对应T_DEF_CODE_DICT 中 JOB_STATUS';
comment on column T_DEF_JOB_LOG.start_time
  is '开始日期';
comment on column T_DEF_JOB_LOG.end_time
  is '结束日期';
comment on column T_DEF_JOB_LOG.run_msg
  is '运行信息';
comment on column T_DEF_JOB_LOG.insert_time
  is '入库日期';
comment on column T_DEF_JOB_LOG.last_modify_time
  is '最后一次修改日期';
comment on column T_DEF_JOB_LOG.operator
  is '操作者';
alter table T_DEF_JOB_LOG
  add constraint T_DEF_JOB_LOG_PK primary key (ID);

prompt Creating T_DEF_MANAGE_COM...
create table T_DEF_MANAGE_COM
(
  id                  NUMBER(19) not null,
  fid                 NUMBER(19),
  manage_code         VARCHAR2(20 CHAR),
  manage_name         VARCHAR2(50 CHAR),
  manage_name_short   VARCHAR2(20 CHAR),
  manage_enname       VARCHAR2(50 CHAR),
  manage_enname_short VARCHAR2(20 CHAR),
  manage_inner_code   VARCHAR2(20 CHAR),
  status              VARCHAR2(20 CHAR),
  open_date           DATE,
  close_date          DATE,
  mmonitor_type       VARCHAR2(20 CHAR),
  mmonitor_code       VARCHAR2(20 CHAR),
  address             VARCHAR2(200 CHAR),
  email               VARCHAR2(20 CHAR),
  phone               VARCHAR2(15 CHAR),
  zipcode             NUMBER(6),
  insert_time         DATE,
  last_modify_time    DATE,
  remark              VARCHAR2(200 CHAR),
  license_type        VARCHAR2(20 CHAR),
  inner_fid           VARCHAR2(20 CHAR)
)
;
comment on table T_DEF_MANAGE_COM
  is '管理机构定义表';
comment on column T_DEF_MANAGE_COM.id
  is '序列ID';
comment on column T_DEF_MANAGE_COM.fid
  is '父类机构ID';
comment on column T_DEF_MANAGE_COM.manage_code
  is '管理机构编码';
comment on column T_DEF_MANAGE_COM.manage_name
  is '管理机构名称';
comment on column T_DEF_MANAGE_COM.manage_name_short
  is '管理机构简称';
comment on column T_DEF_MANAGE_COM.manage_enname
  is '管理机构英文名称';
comment on column T_DEF_MANAGE_COM.manage_enname_short
  is '管理机构英文简称';
comment on column T_DEF_MANAGE_COM.manage_inner_code
  is '机构内部代码';
comment on column T_DEF_MANAGE_COM.status
  is '状态 1 有效';
comment on column T_DEF_MANAGE_COM.open_date
  is '机构开设时间';
comment on column T_DEF_MANAGE_COM.close_date
  is '机构关闭时间 空则表示未关闭';
comment on column T_DEF_MANAGE_COM.mmonitor_type
  is '机构监管类型';
comment on column T_DEF_MANAGE_COM.mmonitor_code
  is '该机构在监管对应的代码';
comment on column T_DEF_MANAGE_COM.address
  is '办公地址';
comment on column T_DEF_MANAGE_COM.email
  is '公共邮箱';
comment on column T_DEF_MANAGE_COM.phone
  is '公共电话';
comment on column T_DEF_MANAGE_COM.zipcode
  is '邮编';
comment on column T_DEF_MANAGE_COM.insert_time
  is '入库时间';
comment on column T_DEF_MANAGE_COM.last_modify_time
  is '最后一次更改时间';
comment on column T_DEF_MANAGE_COM.remark
  is '备注';
comment on column T_DEF_MANAGE_COM.license_type
  is '牌照类型';
comment on column T_DEF_MANAGE_COM.inner_fid
  is '上级机构内部编码';
alter table T_DEF_MANAGE_COM
  add constraint PK_T_DEF_MANAGE_COM primary key (ID);

prompt Creating T_DEF_MONITOR...
create table T_DEF_MONITOR
(
  monitor_id       NUMBER(19) not null,
  monitor_code     VARCHAR2(20 CHAR),
  monitor_name     VARCHAR2(20 CHAR),
  monitor_level    NUMBER(1),
  rc_status        NUMBER(1),
  insert_time      CHAR(10),
  last_modify_time CHAR(10),
  operator         CHAR(10)
)
;
comment on table T_DEF_MONITOR
  is '定义监控类型';
comment on column T_DEF_MONITOR.monitor_code
  is '监控编码';
comment on column T_DEF_MONITOR.monitor_name
  is '监控名称';
comment on column T_DEF_MONITOR.monitor_level
  is '监控界别';
comment on column T_DEF_MONITOR.rc_status
  is '状态标识 1 有效 0 无效 2 删除';
alter table T_DEF_MONITOR
  add constraint PK_T_DEF_MONITOR primary key (MONITOR_ID);

prompt Creating T_DEF_MONITOR_ACTION...
create table T_DEF_MONITOR_ACTION
(
  action_id        NUMBER(19) not null,
  action_msg       VARCHAR2(100 CHAR),
  all_count        NUMBER(10),
  succ_count       NUMBER(10),
  fail_count       NUMBER(10),
  monitor_id       NUMBER(19),
  monitor_type     VARCHAR2(20 CHAR),
  monitor_buss     VARCHAR2(20 CHAR),
  start_time       DATE,
  end_time         DATE,
  mresult          VARCHAR2(50 CHAR),
  user_id          NUMBER(20),
  insert_time      DATE,
  last_modify_time DATE,
  operator         VARCHAR2(50 CHAR)
)
;
comment on table T_DEF_MONITOR_ACTION
  is '记录监控的轨迹';
comment on column T_DEF_MONITOR_ACTION.monitor_id
  is '监控ID';
comment on column T_DEF_MONITOR_ACTION.monitor_type
  is '监控类型
E：提数
S：报送
C：创建文档
D：删除数据
U：更改数据
I：插入数据
Q：查询数据
O：其他';
comment on column T_DEF_MONITOR_ACTION.monitor_buss
  is '监控的是那个业务 提数报送生成文档时用';
comment on column T_DEF_MONITOR_ACTION.start_time
  is '监控开始时间 精确到秒';
comment on column T_DEF_MONITOR_ACTION.end_time
  is '监控结束时间 精确到秒';
comment on column T_DEF_MONITOR_ACTION.mresult
  is '监控结果';
comment on column T_DEF_MONITOR_ACTION.user_id
  is '监控者：用户';
alter table T_DEF_MONITOR_ACTION
  add constraint PK_T_DEF_MONITOR_ACTION primary key (ACTION_ID);

prompt Creating T_DEF_NOTICE...
create table T_DEF_NOTICE
(
  notice_id   NUMBER(19) not null,
  notice_type VARCHAR2(20 CHAR),
  notice_code VARCHAR2(20 CHAR),
  notice_name VARCHAR2(20 CHAR)
)
;
comment on table T_DEF_NOTICE
  is '定义通知信息';
comment on column T_DEF_NOTICE.notice_type
  is '与 T_DEF_CODEDICT 中定义的NOTICE_TYPE 对应的CODE一样';
alter table T_DEF_NOTICE
  add constraint PK_T_DEF_NOTICE primary key (NOTICE_ID);

prompt Creating T_DEF_MONITOR_NOTIC_RELA...
create table T_DEF_MONITOR_NOTIC_RELA
(
  id         NUMBER(19) not null,
  monitor_id NUMBER(19),
  notice_id  NUMBER(19)
)
;
comment on table T_DEF_MONITOR_NOTIC_RELA
  is '定义监控与通知的关联信息';
alter table T_DEF_MONITOR_NOTIC_RELA
  add constraint PK_T_DEF_MONITOR_NOTIC_RELA primary key (ID);
alter table T_DEF_MONITOR_NOTIC_RELA
  add constraint FK_MONOTICE_NOTICE foreign key (NOTICE_ID)
  references T_DEF_NOTICE (NOTICE_ID);
alter table T_DEF_MONITOR_NOTIC_RELA
  add constraint FK_NOTICE_MONITOR foreign key (MONITOR_ID)
  references T_DEF_MONITOR (MONITOR_ID);

prompt Creating T_DEF_MSG_NODESQL_RELA...
create table T_DEF_MSG_NODESQL_RELA
(
  id        NUMBER(19) not null,
  node_id   NUMBER(19),
  sql_id    NUMBER(19),
  rc_status NUMBER(1)
)
;
comment on table T_DEF_MSG_NODESQL_RELA
  is '定义报文节点的SQL';
comment on column T_DEF_MSG_NODESQL_RELA.node_id
  is 'T_DEF_MSG_NODE 中对应的 NODE_ID';
comment on column T_DEF_MSG_NODESQL_RELA.sql_id
  is 'T_DEF_SQL 中定义的ID';
comment on column T_DEF_MSG_NODESQL_RELA.rc_status
  is '状态 标识 1 有效 0 无效 2 删除';
alter table T_DEF_MSG_NODESQL_RELA
  add constraint PK_T_DEF_MSG_NODESQL_RELA primary key (ID);
alter table T_DEF_MSG_NODESQL_RELA
  add constraint FK_T_DEF_MS_REFERENCE_T_DEF_NO foreign key (NODE_ID)
  references T_DEF_MSG_NODE (NODE_ID);

prompt Creating T_DEF_MSG_NODE_ATTRI...
create table T_DEF_MSG_NODE_ATTRI
(
  id          NUMBER(19) not null,
  node_id     NUMBER(19),
  attri_code  VARCHAR2(50 CHAR),
  attri_name  VARCHAR2(50 CHAR),
  attri_value VARCHAR2(50 CHAR),
  attri_num   NUMBER(10),
  rc_status   NUMBER(1)
)
;
comment on table T_DEF_MSG_NODE_ATTRI
  is '报文节点属性定义表';
comment on column T_DEF_MSG_NODE_ATTRI.node_id
  is '所属节点ID，对应T_DEF_MSG_NODE中ID';
comment on column T_DEF_MSG_NODE_ATTRI.attri_code
  is '对应属性的编码';
comment on column T_DEF_MSG_NODE_ATTRI.attri_name
  is '对应属性的中文名称';
comment on column T_DEF_MSG_NODE_ATTRI.attri_value
  is '对应属性的值';
comment on column T_DEF_MSG_NODE_ATTRI.attri_num
  is '属性加载顺序';
comment on column T_DEF_MSG_NODE_ATTRI.rc_status
  is '有效标识 1 有效 0 无效 2 删除';
alter table T_DEF_MSG_NODE_ATTRI
  add constraint PK_T_DEF_MSG_NODE_ATTRI primary key (ID);
alter table T_DEF_MSG_NODE_ATTRI
  add constraint FK_T_DEF_MS_REFERENCE_T_DEF_MS foreign key (NODE_ID)
  references T_DEF_MSG_NODE (NODE_ID);

prompt Creating T_DEF_NOTICE_ACCOUNT...
create table T_DEF_NOTICE_ACCOUNT
(
  id               NUMBER(19) not null,
  notice_type      VARCHAR2(20 CHAR),
  web_address      VARCHAR2(50 CHAR),
  web_port         VARCHAR2(20 CHAR),
  account_addr     VARCHAR2(100 CHAR),
  account_user     VARCHAR2(50 CHAR),
  account_pass     VARCHAR2(50 CHAR),
  er_status        VARCHAR2(20 CHAR),
  insert_time      DATE,
  last_modify_time DATE,
  operator         VARCHAR2(50 CHAR)
)
;
comment on table T_DEF_NOTICE_ACCOUNT
  is '监控通知账户表';
comment on column T_DEF_NOTICE_ACCOUNT.notice_type
  is 'F-发送   I-收件';
comment on column T_DEF_NOTICE_ACCOUNT.web_address
  is '服务器地址 如果有用到';
comment on column T_DEF_NOTICE_ACCOUNT.web_port
  is '服务器端口 如果有用到';
comment on column T_DEF_NOTICE_ACCOUNT.account_addr
  is '账户地址';
comment on column T_DEF_NOTICE_ACCOUNT.account_user
  is '账户用户';
comment on column T_DEF_NOTICE_ACCOUNT.account_pass
  is '账户密码';
comment on column T_DEF_NOTICE_ACCOUNT.er_status
  is '状态标识';
comment on column T_DEF_NOTICE_ACCOUNT.insert_time
  is '入库时间';
comment on column T_DEF_NOTICE_ACCOUNT.last_modify_time
  is '最后一次修改时间';
comment on column T_DEF_NOTICE_ACCOUNT.operator
  is '操作者';
alter table T_DEF_NOTICE_ACCOUNT
  add constraint PK_T_DEF_NOTICE_ACCOUNT primary key (ID);

prompt Creating T_DEF_NOTICE_ADD...
create table T_DEF_NOTICE_ADD
(
  id        NUMBER(19) not null,
  notice_id NUMBER(19),
  notice_to VARCHAR2(20 CHAR)
)
;
comment on table T_DEF_NOTICE_ADD
  is '通知附加人员';
comment on column T_DEF_NOTICE_ADD.notice_to
  is '通知地址：邮件通知时是邮箱号 微信通知时是微信好 QQ通知时是QQ号';
alter table T_DEF_NOTICE_ADD
  add constraint PK_T_DEF_NOTICE_ADD primary key (ID);
alter table T_DEF_NOTICE_ADD
  add constraint FK_T_DEF_NO_REFERENCE_T_DEF_NO foreign key (NOTICE_ID)
  references T_DEF_NOTICE (NOTICE_ID);

prompt Creating T_DEF_NOTICE_MAIN...
create table T_DEF_NOTICE_MAIN
(
  id        NUMBER(19) not null,
  notice_id NUMBER(19),
  notice_to VARCHAR2(20 CHAR)
)
;
comment on table T_DEF_NOTICE_MAIN
  is '主要通知的人';
comment on column T_DEF_NOTICE_MAIN.notice_to
  is '通知地址：邮件通知时是邮箱号 微信通知时是微信好 QQ通知时是QQ号';
alter table T_DEF_NOTICE_MAIN
  add constraint PK_T_DEF_NOTICE_MAIN primary key (ID);

prompt Creating T_DEF_NOTICE_SECRETLY...
create table T_DEF_NOTICE_SECRETLY
(
  id        NUMBER(19) not null,
  notice_id NUMBER(19),
  notice_to VARCHAR2(20 CHAR)
)
;
comment on table T_DEF_NOTICE_SECRETLY
  is '秘密通知人员';
comment on column T_DEF_NOTICE_SECRETLY.notice_to
  is '通知地址：邮件通知时是邮箱号 微信通知时是微信好 QQ通知时是QQ号';
alter table T_DEF_NOTICE_SECRETLY
  add constraint PK_T_DEF_NOTICE_SECRETLY primary key (ID);

prompt Creating T_DEF_ROLE...
create table T_DEF_ROLE
(
  id       NUMBER(19) not null,
  rolecode VARCHAR2(20 CHAR),
  rolename VARCHAR2(20 CHAR)
)
;
comment on column T_DEF_ROLE.id
  is '序列ID';
comment on column T_DEF_ROLE.rolecode
  is '角色编码';
comment on column T_DEF_ROLE.rolename
  is '角色名称';
alter table T_DEF_ROLE
  add constraint T_DEF_ROLE_PK primary key (ID);

prompt Creating T_DEF_PLAT_ROLE_RELA...
create table T_DEF_PLAT_ROLE_RELA
(
  id      NUMBER(19) not null,
  role_id NUMBER(19),
  com_id  NUMBER(19)
)
;
comment on table T_DEF_PLAT_ROLE_RELA
  is '平台角色关联关联表';
comment on column T_DEF_PLAT_ROLE_RELA.id
  is '序列ID';
comment on column T_DEF_PLAT_ROLE_RELA.role_id
  is '角色ID';
comment on column T_DEF_PLAT_ROLE_RELA.com_id
  is '平台ID';
alter table T_DEF_PLAT_ROLE_RELA
  add constraint PK_T_DEF_PLAT_ROLE_RELA primary key (ID);
alter table T_DEF_PLAT_ROLE_RELA
  add constraint FK_T_DEF_PL_REFERENCE_T_DEF_PL foreign key (COM_ID)
  references T_DEF_PLAT_COM (COM_ID);
alter table T_DEF_PLAT_ROLE_RELA
  add constraint FK_T_DEF_PL_REFERENCE_T_DEF_RO foreign key (ROLE_ID)
  references T_DEF_ROLE (ID);

prompt Creating T_DEF_PRIVILEGE...
create table T_DEF_PRIVILEGE
(
  id                 NUMBER(19) not null,
  privilegecode      VARCHAR2(20 CHAR),
  privilegename      VARCHAR2(20 CHAR),
  privilegetype      VARCHAR2(20 CHAR),
  url                VARCHAR2(100),
  pid                VARCHAR2(20 CHAR),
  method             VARCHAR2(20 CHAR),
  pre                VARCHAR2(20 CHAR),
  next               VARCHAR2(20 CHAR),
  num                NUMBER(10),
  privilege_describe VARCHAR2(50),
  privilege_sign     VARCHAR2(20)
)
;
comment on column T_DEF_PRIVILEGE.id
  is '序列ID';
comment on column T_DEF_PRIVILEGE.privilegecode
  is '菜单编码';
comment on column T_DEF_PRIVILEGE.privilegename
  is '菜单名称';
comment on column T_DEF_PRIVILEGE.privilegetype
  is '菜单类型:
system - 系统访问权限
menu - 菜单访问权限
function - 按钮访问权限
data - 数据访问权限
';
comment on column T_DEF_PRIVILEGE.url
  is '菜单url:privilegetype为menu的菜单管理权限才设置';
comment on column T_DEF_PRIVILEGE.pid
  is '菜单的父节点id:privilegetype为menu的菜单管理权限才设置';
comment on column T_DEF_PRIVILEGE.method
  is '访问方式:privilegetype为function的菜单管理权限才设置
可访问的按钮，常规的有：
create
read
delete
update';
comment on column T_DEF_PRIVILEGE.pre
  is '前一菜单id';
comment on column T_DEF_PRIVILEGE.next
  is '后一菜单id';
comment on column T_DEF_PRIVILEGE.num
  is '加载顺序';
alter table T_DEF_PRIVILEGE
  add constraint T_DEF_PRIVILEGE_PK primary key (ID);

prompt Creating T_DEF_REPORT_COL...
create table T_DEF_REPORT_COL
(
  report_code VARCHAR2(50) not null,
  column_no   VARCHAR2(20) not null,
  column_code VARCHAR2(50) not null,
  column_name VARCHAR2(120) not null
)
;

prompt Creating T_DEF_ROLE_PRIVILEGE_RELA...
create table T_DEF_ROLE_PRIVILEGE_RELA
(
  id           NUMBER(19) not null,
  role_id      NUMBER(19) not null,
  privilege_id NUMBER(19) not null
)
;
comment on table T_DEF_ROLE_PRIVILEGE_RELA
  is '角色菜单关联表';
comment on column T_DEF_ROLE_PRIVILEGE_RELA.id
  is '序列ID';
comment on column T_DEF_ROLE_PRIVILEGE_RELA.role_id
  is '角色ID';
comment on column T_DEF_ROLE_PRIVILEGE_RELA.privilege_id
  is '菜单ID';
alter table T_DEF_ROLE_PRIVILEGE_RELA
  add constraint T_DEF_ROLE_PRIVILEGE_RELA_PK primary key (ID);

prompt Creating T_DEF_SEND...
create table T_DEF_SEND
(
  id          NUMBER(19) not null,
  com_id      NUMBER(19),
  send_type   VARCHAR2(20 CHAR),
  send_encode VARCHAR2(20 CHAR),
  send_user   VARCHAR2(20 CHAR),
  send_pass   VARCHAR2(20 CHAR),
  send_api    VARCHAR2(100 CHAR),
  send_ip     VARCHAR2(10 CHAR),
  send_port   VARCHAR2(20 CHAR),
  max_count   NUMBER(9),
  min_count   NUMBER(9),
  batch_count NUMBER(9)
)
;
comment on table T_DEF_SEND
  is '业务报送方式';
comment on column T_DEF_SEND.send_type
  is '与 T_DEF_CODEDICT 中 CODE 相同';
comment on column T_DEF_SEND.send_encode
  is 'UTF-8、 GBK等 默认UTF-8';
comment on column T_DEF_SEND.send_user
  is '当报送SEND_TYPE为PROXCY 代理或者SFTP时 有但非必须的对应的用户';
comment on column T_DEF_SEND.send_pass
  is '当报送SEND_TYPE为PROXCY 代理或者SFTP时 有但非必须的对应的用户密码';
comment on column T_DEF_SEND.send_api
  is '报送的URL，当SEND_TYPE = HTTP 时有对应的URL路径';
comment on column T_DEF_SEND.send_ip
  is '当报送SEND_TYPE为PROXCY 代理或者SFTP时 有对应的IP';
comment on column T_DEF_SEND.send_port
  is '当报送SEND_TYPE为PROXCY 代理或者SFTP时 有对应的端口号';
comment on column T_DEF_SEND.batch_count
  is '承保拆单管理';
alter table T_DEF_SEND
  add constraint PK_T_DEF_SEND primary key (ID);
alter table T_DEF_SEND
  add constraint FK_PLAT_SEND foreign key (COM_ID)
  references T_DEF_PLAT_COM (COM_ID);

prompt Creating T_DEF_SFTP...
create table T_DEF_SFTP
(
  id            NUMBER(9) not null,
  sftp_ip       VARCHAR2(20) not null,
  sftp_port     VARCHAR2(10) not null,
  sftp_type     VARCHAR2(50),
  sftp_disc     VARCHAR2(50),
  sftp_use_type VARCHAR2(50),
  visit_user    VARCHAR2(100),
  visit_pass    VARCHAR2(50),
  visit_url     VARCHAR2(200),
  is_need_key   NUMBER(1),
  visit_key     VARCHAR2(50),
  com_id        NUMBER(9),
  role_id       NUMBER(9),
  es_status     NUMBER(1),
  remark        VARCHAR2(50)
)
;
comment on table T_DEF_SFTP
  is '用于定义相关服务器的信息';
comment on column T_DEF_SFTP.sftp_ip
  is '服务器IP';
comment on column T_DEF_SFTP.sftp_port
  is '服务器端口';
comment on column T_DEF_SFTP.sftp_type
  is '服务器类型：U 上传 D 下载 S 特殊 C 普通 O 其他';
comment on column T_DEF_SFTP.sftp_disc
  is '服务器描述';
comment on column T_DEF_SFTP.sftp_use_type
  is '服务器用途类型 FILE 文件服务器 IMAGE 图片服务器 WEB 应用服务器 NULL 没有类型说明';
comment on column T_DEF_SFTP.visit_user
  is '访问用户';
comment on column T_DEF_SFTP.visit_pass
  is '访问密码';
comment on column T_DEF_SFTP.visit_url
  is '访问路径';
comment on column T_DEF_SFTP.is_need_key
  is '访问是否需要密钥 1 - 是  0 - 否';
comment on column T_DEF_SFTP.visit_key
  is '访问密钥';
comment on column T_DEF_SFTP.com_id
  is '使用平台';
comment on column T_DEF_SFTP.role_id
  is '使用角色';
comment on column T_DEF_SFTP.es_status
  is '是否有效 1 或 NULL 有效 0 无效 2 删除';
comment on column T_DEF_SFTP.remark
  is '备注';
alter table T_DEF_SFTP
  add constraint PK_T_DEF_SFTP primary key (ID);

prompt Creating T_DEF_SQL...
create table T_DEF_SQL
(
  sql_id                NUMBER(19) not null,
  sql_code              VARCHAR2(50 CHAR),
  sql_type              VARCHAR2(50 CHAR),
  sql_from              VARCHAR2(50 CHAR),
  sql_from_jdbc_id      NUMBER(19),
  sql_into              VARCHAR2(50 CHAR),
  sql_into_jdbc_id      NUMBER(19),
  sql_into_target_table VARCHAR2(50 CHAR),
  sql_num               NUMBER(10),
  sql_desc              VARCHAR2(50 CHAR),
  com_id                NUMBER(19),
  pid                   NUMBER(19),
  pre_id                NUMBER(19),
  next_id               NUMBER(19),
  buss_type             VARCHAR2(50 CHAR),
  es_status             NUMBER(1),
  insert_time           DATE,
  last_modify_time      DATE,
  operator              VARCHAR2(20),
  sub_buss_type         VARCHAR2(50 CHAR)
)
;
comment on table T_DEF_SQL
  is 'SQL配置定义表';
comment on column T_DEF_SQL.sql_id
  is '序列ID';
comment on column T_DEF_SQL.sql_code
  is '算法编码';
comment on column T_DEF_SQL.sql_type
  is 'SQL类型
I：增 D：删 U：改 Q：查 O 其他';
comment on column T_DEF_SQL.sql_from
  is 'SQL来源，即在那个链接下执行SQL 为空则本地连接';
comment on column T_DEF_SQL.sql_from_jdbc_id
  is 'SQL执行的JDBC，为空或1则为本地';
comment on column T_DEF_SQL.sql_into
  is '指定插入数据源';
comment on column T_DEF_SQL.sql_into_jdbc_id
  is '指定插入数据源 用于SQL_TYPE 为 I 或者 U 的情况';
comment on column T_DEF_SQL.sql_into_target_table
  is '插入数据时的目标表';
comment on column T_DEF_SQL.sql_num
  is 'SQL加载顺序';
comment on column T_DEF_SQL.sql_desc
  is '算法描述';
comment on column T_DEF_SQL.com_id
  is '平台机构，对应 T_DEF_PLATCOM 的 COM_ID';
comment on column T_DEF_SQL.pid
  is '父类SQL';
comment on column T_DEF_SQL.pre_id
  is '上一条待执行SQL';
comment on column T_DEF_SQL.next_id
  is '下一条执行SQL';
comment on column T_DEF_SQL.buss_type
  is '业务类型';
comment on column T_DEF_SQL.es_status
  is '当前记录状态：1 有效 0 无效 2 删除';
comment on column T_DEF_SQL.insert_time
  is '入库时间';
comment on column T_DEF_SQL.last_modify_time
  is '最后一次修改时间';
comment on column T_DEF_SQL.operator
  is '操作者';
comment on column T_DEF_SQL.sub_buss_type
  is '上级业务类型';
alter table T_DEF_SQL
  add constraint PK_T_DEF_SQL primary key (SQL_ID);
alter table T_DEF_SQL
  add constraint FK_SQLJDBC_JDBCFROM foreign key (SQL_FROM_JDBC_ID)
  references T_DEF_JDBC (ID);
alter table T_DEF_SQL
  add constraint FK_SQLJDBC_JDBCTO foreign key (SQL_INTO_JDBC_ID)
  references T_DEF_JDBC (ID);
alter table T_DEF_SQL
  add constraint FK_SQLPID_SQLID foreign key (PID)
  references T_DEF_SQL (SQL_ID);
alter table T_DEF_SQL
  add constraint FK_SQL_PLAT foreign key (COM_ID)
  references T_DEF_PLAT_COM (COM_ID);

prompt Creating T_DEF_SQL_PARAMS...
create table T_DEF_SQL_PARAMS
(
  id               NUMBER(19) not null,
  sql_id           NUMBER(19),
  param_type       VARCHAR2(50 CHAR),
  param_code       VARCHAR2(50 CHAR),
  param_name       VARCHAR2(50 CHAR),
  param_value      VARCHAR2(200 CHAR),
  es_status        NUMBER(1),
  param_value_type VARCHAR2(50 CHAR),
  param_sub_type   NUMBER(1)
)
;
comment on table T_DEF_SQL_PARAMS
  is 'SQL配置参数定义表';
comment on column T_DEF_SQL_PARAMS.id
  is '序列ID';
comment on column T_DEF_SQL_PARAMS.sql_id
  is '对应T_DEF_SQL中的ID 无则表示该参数为系统默认，所有SQL都可用的';
comment on column T_DEF_SQL_PARAMS.param_type
  is '描述参数类型 0：参数屏蔽，设置空 1：取其外部传入Map的值，默认 2：参数通过可执行SQL获得 3：取其Value对应的值(固定值)
';
comment on column T_DEF_SQL_PARAMS.param_code
  is '参数编码';
comment on column T_DEF_SQL_PARAMS.param_name
  is '参数名称';
comment on column T_DEF_SQL_PARAMS.param_value
  is '参数默认值';
comment on column T_DEF_SQL_PARAMS.es_status
  is '是否有效：1 有效 0 无效 2 删除';
comment on column T_DEF_SQL_PARAMS.param_value_type
  is '参数值类型 STRING、DATE、NUMBER';
comment on column T_DEF_SQL_PARAMS.param_sub_type
  is '父级参数类型：括定其范围  1-正常SQLID对应的参数  0-系统默认的参数，任何SQL都可用，对应SQLID为空';
alter table T_DEF_SQL_PARAMS
  add constraint PK_T_DEF_SQLPARAMS primary key (ID);

prompt Creating T_DEF_TRANSCODE_TRACE...
create table T_DEF_TRANSCODE_TRACE
(
  id               NUMBER(19),
  batch_no         VARCHAR2(25),
  action_no        VARCHAR2(25),
  transexc_id      NUMBER(19),
  transexc_code    VARCHAR2(50),
  transexc_name    VARCHAR2(50),
  sql_id           NUMBER(19),
  sql_desc         VARCHAR2(50),
  msg              VARCHAR2(200),
  operator         VARCHAR2(50),
  insert_time      DATE,
  last_modify_time DATE,
  state_flag       VARCHAR2(2)
)
;
comment on table T_DEF_TRANSCODE_TRACE
  is '转码轨迹记录表';
comment on column T_DEF_TRANSCODE_TRACE.id
  is 'ID';
comment on column T_DEF_TRANSCODE_TRACE.batch_no
  is '批次号';
comment on column T_DEF_TRANSCODE_TRACE.action_no
  is '交易业务流水号';
comment on column T_DEF_TRANSCODE_TRACE.transexc_id
  is '传输ID';
comment on column T_DEF_TRANSCODE_TRACE.transexc_code
  is '传输编码';
comment on column T_DEF_TRANSCODE_TRACE.transexc_name
  is '传输名称呢个';
comment on column T_DEF_TRANSCODE_TRACE.sql_id
  is 'SQLID';
comment on column T_DEF_TRANSCODE_TRACE.sql_desc
  is 'SQL描述';
comment on column T_DEF_TRANSCODE_TRACE.msg
  is '转码信息';
comment on column T_DEF_TRANSCODE_TRACE.operator
  is '操作者';
comment on column T_DEF_TRANSCODE_TRACE.insert_time
  is '入库日期';
comment on column T_DEF_TRANSCODE_TRACE.last_modify_time
  is '最后一次修改日期';
comment on column T_DEF_TRANSCODE_TRACE.state_flag
  is '转台标识 1-成功 0-失败';

prompt Creating T_DEF_TRANSEXC...
create table T_DEF_TRANSEXC
(
  exc_id           NUMBER(19) not null,
  impl_id          NUMBER(19),
  com_id           NUMBER(19),
  buss_id          NUMBER(19),
  exc_code         VARCHAR2(50),
  exc_name         VARCHAR2(50),
  exc_desc         VARCHAR2(100),
  rc_status        NUMBER(1),
  insert_time      DATE,
  last_modify_time DATE,
  operator         VARCHAR2(50),
  exc_num          NUMBER(2)
)
;
comment on table T_DEF_TRANSEXC
  is '平台传输模型定义表';
comment on column T_DEF_TRANSEXC.exc_id
  is '传输ID';
comment on column T_DEF_TRANSEXC.impl_id
  is '实现ID';
comment on column T_DEF_TRANSEXC.com_id
  is '平台机构ID';
comment on column T_DEF_TRANSEXC.buss_id
  is '业务类型ID';
comment on column T_DEF_TRANSEXC.exc_code
  is '传输编码';
comment on column T_DEF_TRANSEXC.exc_name
  is '传输名称';
comment on column T_DEF_TRANSEXC.exc_desc
  is '传输描述';
comment on column T_DEF_TRANSEXC.rc_status
  is '状态标识 1-有效 0-无效 2-删除';
comment on column T_DEF_TRANSEXC.insert_time
  is '入库日期';
comment on column T_DEF_TRANSEXC.last_modify_time
  is '最后一次修改日期';
comment on column T_DEF_TRANSEXC.operator
  is '操作者';
comment on column T_DEF_TRANSEXC.exc_num
  is '执行排序';
alter table T_DEF_TRANSEXC
  add constraint PK_T_DEF_TRANSEXC primary key (EXC_ID);
alter table T_DEF_TRANSEXC
  add constraint FK_T_DEF_TR_REFERENCE_T_DEF_PL foreign key (COM_ID)
  references T_DEF_PLAT_COM (COM_ID);

prompt Creating T_DEF_TRANSEXC_ACTION...
create table T_DEF_TRANSEXC_ACTION
(
  id        NUMBER(19) not null,
  exc_id    NUMBER(19),
  sql_id    NUMBER(19),
  exc_num   NUMBER(10),
  rc_status NUMBER(1)
)
;
comment on table T_DEF_TRANSEXC_ACTION
  is '定义传输执行方式';
comment on column T_DEF_TRANSEXC_ACTION.exc_id
  is '对应 T_DEF_BUSS_TRANSEXC 中的ID';
comment on column T_DEF_TRANSEXC_ACTION.sql_id
  is '执行SQL，对应 T_DEF_SQL 中的SQL_ID';
comment on column T_DEF_TRANSEXC_ACTION.rc_status
  is '状态标识 1 有效 0 无效 2 删除';
alter table T_DEF_TRANSEXC_ACTION
  add constraint PK_T_DEF_TRANSEXC_ACTION primary key (ID);
alter table T_DEF_TRANSEXC_ACTION
  add constraint FK_TRANSEXC_SQL foreign key (SQL_ID)
  references T_DEF_SQL (SQL_ID)
  disable;
alter table T_DEF_TRANSEXC_ACTION
  add constraint FK_TRANS_TRANSEXC foreign key (EXC_ID)
  references T_DEF_TRANSEXC (EXC_ID);

prompt Creating T_DEF_TRANSEXC_AFTER...
create table T_DEF_TRANSEXC_AFTER
(
  id        NUMBER(19) not null,
  exc_id    NUMBER(19),
  sql_id    NUMBER(19),
  exc_num   NUMBER(10),
  rc_status NUMBER(1)
)
;
comment on table T_DEF_TRANSEXC_AFTER
  is '传输后执行SQL';
comment on column T_DEF_TRANSEXC_AFTER.exc_id
  is '对应 T_DEF_BUSS_TRANSEXC  中的 ID';
comment on column T_DEF_TRANSEXC_AFTER.sql_id
  is '执行SQL，对应 T_DEF_SQL 中的SQL_ID';
comment on column T_DEF_TRANSEXC_AFTER.exc_num
  is '执行顺序';
comment on column T_DEF_TRANSEXC_AFTER.rc_status
  is '状态标识 1 有效 0 无效 2 删除';
alter table T_DEF_TRANSEXC_AFTER
  add constraint PK_T_DEF_TRANSEXC_AFTER primary key (ID);
alter table T_DEF_TRANSEXC_AFTER
  add constraint FK_TRANSAFTER_TRANSEXC foreign key (EXC_ID)
  references T_DEF_TRANSEXC (EXC_ID);
alter table T_DEF_TRANSEXC_AFTER
  add constraint FK_TRANSAFTE_SQL foreign key (SQL_ID)
  references T_DEF_SQL (SQL_ID)
  disable;

prompt Creating T_DEF_TRANSEXC_BEFORE...
create table T_DEF_TRANSEXC_BEFORE
(
  id        NUMBER(19) not null,
  exc_id    NUMBER(19),
  sql_id    NUMBER(19),
  exc_num   NUMBER(10),
  rc_status NUMBER(1)
)
;
comment on table T_DEF_TRANSEXC_BEFORE
  is '传输执行前定义';
comment on column T_DEF_TRANSEXC_BEFORE.exc_id
  is '对应 T_DEF_BUSS_TRANSEXC  中的 ID';
comment on column T_DEF_TRANSEXC_BEFORE.sql_id
  is '执行SQL，对应 T_DEF_SQL 中的SQL_ID';
comment on column T_DEF_TRANSEXC_BEFORE.rc_status
  is '状态标识 1 有效 0 无效 2 删除';
alter table T_DEF_TRANSEXC_BEFORE
  add constraint PK_T_DEF_TRANSEXC_BEFORE primary key (ID);
alter table T_DEF_TRANSEXC_BEFORE
  add constraint FK_TRANSBEFO_SQL foreign key (SQL_ID)
  references T_DEF_SQL (SQL_ID)
  disable;
alter table T_DEF_TRANSEXC_BEFORE
  add constraint FK_TRANSBEFO_TRANSEXC foreign key (EXC_ID)
  references T_DEF_TRANSEXC (EXC_ID);

prompt Creating T_DEF_TRANS_CODE...
create table T_DEF_TRANS_CODE
(
  id                NUMBER(19) not null,
  target_table_name VARCHAR2(50 CHAR),
  target_col_name   VARCHAR2(50 CHAR),
  code_type         VARCHAR2(50 CHAR),
  data_type         VARCHAR2(50 CHAR)
)
;
comment on table T_DEF_TRANS_CODE
  is '转码算法配置表';
comment on column T_DEF_TRANS_CODE.id
  is '序列ID';
comment on column T_DEF_TRANS_CODE.target_table_name
  is '目标表名';
comment on column T_DEF_TRANS_CODE.target_col_name
  is '目标字段';
comment on column T_DEF_TRANS_CODE.code_type
  is '参考映射，代码映射使用的映射类型';
comment on column T_DEF_TRANS_CODE.data_type
  is '数据源';
alter table T_DEF_TRANS_CODE
  add constraint PK_T_DEF_TRANS_CODE primary key (ID);

prompt Creating T_DEF_USER...
create table T_DEF_USER
(
  id            NUMBER(19) not null,
  usercode      VARCHAR2(20),
  username      VARCHAR2(20),
  password      VARCHAR2(100),
  company_id    NUMBER(20),
  empower_type  VARCHAR2(10),
  empower_code  VARCHAR2(50),
  start_date    DATE,
  end_date      DATE,
  user_describe VARCHAR2(100),
  creator_code  VARCHAR2(20),
  email         VARCHAR2(50),
  is_lock       VARCHAR2(10),
  user_state    VARCHAR2(50 CHAR),
  ssiauth       VARCHAR2(250),
  ssisign       VARCHAR2(250)
)
;
comment on column T_DEF_USER.id
  is 'ID序列';
comment on column T_DEF_USER.usercode
  is '本地用户编码';
comment on column T_DEF_USER.username
  is '本地用户姓名';
comment on column T_DEF_USER.password
  is '本地认证密码';
comment on column T_DEF_USER.company_id
  is '用户公司编码';
comment on column T_DEF_USER.empower_type
  is '认证方式：1本地默认认证 2统一认证 3第三方认证';
comment on column T_DEF_USER.empower_code
  is '认证编码，用以与本地认证用户绑定';
comment on column T_DEF_USER.ssiauth
  is '认证作者';
comment on column T_DEF_USER.ssisign
  is '认证签名';
alter table T_DEF_USER
  add constraint T_DEF_USER_PK primary key (ID);

prompt Creating T_DEF_USER_ROLE_RELA...
create table T_DEF_USER_ROLE_RELA
(
  id        NUMBER(19) not null,
  role_id   NUMBER(19) not null,
  user_id   NUMBER(19),
  user_code VARCHAR2(50)
)
;
comment on column T_DEF_USER_ROLE_RELA.id
  is '学列ID';
comment on column T_DEF_USER_ROLE_RELA.role_id
  is '角色ID';
comment on column T_DEF_USER_ROLE_RELA.user_id
  is '用户ID';
comment on column T_DEF_USER_ROLE_RELA.user_code
  is '用户编码';
alter table T_DEF_USER_ROLE_RELA
  add constraint T_DEF_USER_ROLE_RELA_PK primary key (ID);

prompt Creating T_DEF_USER_TRACE...
create table T_DEF_USER_TRACE
(
  id           NUMBER(19) not null,
  user_ip      VARCHAR2(19),
  privilege_id NUMBER(19),
  insert_time  DATE,
  trace_url    CHAR(250),
  trace_func   CHAR(50),
  trace_msg    CHAR(100),
  user_id      VARCHAR2(20)
)
;
comment on table T_DEF_USER_TRACE
  is '用户操作履历表，记录用户操作的履历';
comment on column T_DEF_USER_TRACE.id
  is '序列ID';
comment on column T_DEF_USER_TRACE.user_ip
  is '访问用户使用的IP';
comment on column T_DEF_USER_TRACE.privilege_id
  is '用户访问的菜单';
comment on column T_DEF_USER_TRACE.insert_time
  is '访问时间';
comment on column T_DEF_USER_TRACE.trace_url
  is '访问地址';
comment on column T_DEF_USER_TRACE.trace_func
  is '访问函数或方法';
comment on column T_DEF_USER_TRACE.trace_msg
  is '反问信息';
comment on column T_DEF_USER_TRACE.user_id
  is '用户ID';
alter table T_DEF_USER_TRACE
  add constraint PK_T_DEF_USER_TRACE primary key (ID);

prompt Creating T_DEF_WSP_REQUEST...
create table T_DEF_WSP_REQUEST
(
  id             NUMBER(19) not null,
  com_id         NUMBER(19),
  request_method VARCHAR2(50),
  request_name   VARCHAR2(50),
  request_class  VARCHAR2(100),
  request_type   VARCHAR2(20),
  buss_type      VARCHAR2(50),
  es_status      NUMBER(1)
)
;
comment on table T_DEF_WSP_REQUEST
  is 'WebServicePort 远程请求定义表';
comment on column T_DEF_WSP_REQUEST.id
  is '请求唯一标识';
comment on column T_DEF_WSP_REQUEST.com_id
  is '结构编码';
comment on column T_DEF_WSP_REQUEST.request_method
  is '请求方法';
comment on column T_DEF_WSP_REQUEST.request_name
  is 'DTO名称';
comment on column T_DEF_WSP_REQUEST.request_class
  is 'DTO类名';
comment on column T_DEF_WSP_REQUEST.request_type
  is 'DTO 类型 1 远程接口';
comment on column T_DEF_WSP_REQUEST.buss_type
  is '与 T_DEF_CODE_DICT 中 BUSS_TYPE 相等';
comment on column T_DEF_WSP_REQUEST.es_status
  is '有效标识 0-无效 1-有效 2-删除';
alter table T_DEF_WSP_REQUEST
  add constraint PK_T_DEF_WSP_REQUEST primary key (ID);
alter table T_DEF_WSP_REQUEST
  add constraint FK_T_DEF_WSP_REQUEST foreign key (COM_ID)
  references T_DEF_PLAT_COM (COM_ID);

prompt Creating T_DEF_WSP_PARAM...
create table T_DEF_WSP_PARAM
(
  id          NUMBER(19) not null,
  request_id  NUMBER(19),
  param_name  VARCHAR2(50),
  param_class VARCHAR2(100),
  param_type  VARCHAR2(20),
  es_status   NUMBER(1),
  num         NUMBER(2),
  is_analizy  NUMBER(1)
)
;
comment on table T_DEF_WSP_PARAM
  is 'WebServicePort  参数';
comment on column T_DEF_WSP_PARAM.request_id
  is '请求ID';
comment on column T_DEF_WSP_PARAM.param_name
  is '参数名称';
comment on column T_DEF_WSP_PARAM.param_class
  is '参数类';
comment on column T_DEF_WSP_PARAM.param_type
  is '参数类型 0-空 1-单类 2-数组';
comment on column T_DEF_WSP_PARAM.es_status
  is '有效标识 0-无效1-有效 2-删除';
comment on column T_DEF_WSP_PARAM.num
  is '排序';
comment on column T_DEF_WSP_PARAM.is_analizy
  is '是否需要解析 null 或 0 不需要 1 则需要解析';
alter table T_DEF_WSP_PARAM
  add constraint PK_T_DEF_WSP_PARAM primary key (ID);
alter table T_DEF_WSP_PARAM
  add constraint FK_T_DEF_WS_PARAM2REQUEST foreign key (REQUEST_ID)
  references T_DEF_WSP_REQUEST (ID);

prompt Creating T_DEF_WSP_RETURN...
create table T_DEF_WSP_RETURN
(
  id           NUMBER(19) not null,
  request_id   NUMBER(19),
  return_name  VARCHAR2(50),
  return_class VARCHAR2(100),
  return_type  NUMBER(1),
  es_status    NUMBER(1)
)
;
comment on table T_DEF_WSP_RETURN
  is '远程请求 返回配置';
comment on column T_DEF_WSP_RETURN.request_id
  is '根节点DTO ID';
comment on column T_DEF_WSP_RETURN.return_name
  is '返回名称';
comment on column T_DEF_WSP_RETURN.return_class
  is '返回类';
comment on column T_DEF_WSP_RETURN.return_type
  is '返回类型 0 无返回 1-单类 2-数组';
alter table T_DEF_WSP_RETURN
  add constraint PK_T_DEF_WSP_RETURN primary key (ID);
alter table T_DEF_WSP_RETURN
  add constraint FK_T_DEF_WS_RETURN2REQUEST foreign key (REQUEST_ID)
  references T_DEF_WSP_REQUEST (ID);

prompt Creating T_DOC_MAIN...
create table T_DOC_MAIN
(
  doc_id           NUMBER(19) not null,
  batch_no         VARCHAR2(45) not null,
  trans_no         VARCHAR2(45),
  doc_code         VARCHAR2(45),
  doc_unic         VARCHAR2(45),
  buss_type        VARCHAR2(50),
  sub_buss_type    VARCHAR2(50),
  doc_pages        INTEGER,
  action_times     INTEGER,
  doc_flag         VARCHAR2(2),
  doc_remark       VARCHAR2(380),
  com_id           VARCHAR2(15),
  es_status        NUMBER(1),
  scan_operator    VARCHAR2(15),
  insert_time      DATE,
  last_modify_time DATE,
  operator         VARCHAR2(20),
  version          VARCHAR2(45),
  print_code       VARCHAR2(45),
  action_flag      VARCHAR2(2)
)
;
comment on table T_DOC_MAIN
  is '文档信息表';
comment on column T_DOC_MAIN.doc_id
  is '唯一标示一份文件的编号，系统生成';
comment on column T_DOC_MAIN.batch_no
  is '不能为空，无时默认为0';
comment on column T_DOC_MAIN.trans_no
  is '交易编号';
comment on column T_DOC_MAIN.doc_code
  is '一份文件的号码，如投保单印刷号等';
comment on column T_DOC_MAIN.doc_unic
  is '文件编码：UTF-8 GBK 等';
comment on column T_DOC_MAIN.buss_type
  is '承保
理赔
保全
未清分';
comment on column T_DOC_MAIN.sub_buss_type
  is '投保单
体检资料
生调资料
......';
comment on column T_DOC_MAIN.doc_pages
  is '该单据页数';
comment on column T_DOC_MAIN.action_times
  is '操作的次数统计';
comment on column T_DOC_MAIN.doc_flag
  is '是否有效 0--无效1--有效';
comment on column T_DOC_MAIN.doc_remark
  is '备注';
comment on column T_DOC_MAIN.com_id
  is '平台机构';
comment on column T_DOC_MAIN.es_status
  is '1-有效 0-无效 2-删除';
comment on column T_DOC_MAIN.scan_operator
  is '扫描着';
comment on column T_DOC_MAIN.insert_time
  is '入库日期';
comment on column T_DOC_MAIN.last_modify_time
  is '最后一次修改时间';
comment on column T_DOC_MAIN.operator
  is '操作者';
comment on column T_DOC_MAIN.version
  is '版本';
comment on column T_DOC_MAIN.print_code
  is '打印编号';
comment on column T_DOC_MAIN.action_flag
  is '数据状态';
alter table T_DOC_MAIN
  add constraint PK_T_DOC_MAIN primary key (DOC_ID);
create index T_DOC_MAIN_IN1 on T_DOC_MAIN (BATCH_NO);

prompt Creating T_DOC_PAGES...
create table T_DOC_PAGES
(
  page_id          NUMBER(19) not null,
  page_code        VARCHAR2(50),
  page_name        VARCHAR2(64),
  page_count       INTEGER,
  page_suffix      VARCHAR2(9),
  page_type        VARCHAR2(6),
  page_flag        VARCHAR2(5) default 0,
  doc_id           NUMBER(19) not null,
  pic_path         VARCHAR2(380),
  pic_path_ftp     VARCHAR2(380),
  md5_code         VARCHAR2(200),
  operator         VARCHAR2(50),
  insert_time      DATE,
  last_modify_time DATE,
  scan_no          VARCHAR2(45) default 0,
  doc_key          VARCHAR2(30)
)
;
comment on table T_DOC_PAGES
  is '页码或者文件表,T_DOC_MAIN 的子表';
comment on column T_DOC_PAGES.page_id
  is '索引';
comment on column T_DOC_PAGES.page_code
  is '页码编码';
comment on column T_DOC_PAGES.page_name
  is '页码名称';
comment on column T_DOC_PAGES.page_count
  is '页码统计';
comment on column T_DOC_PAGES.page_suffix
  is '后缀';
comment on column T_DOC_PAGES.page_type
  is '类型';
comment on column T_DOC_PAGES.page_flag
  is '0--本地
1--上载中心';
comment on column T_DOC_PAGES.doc_id
  is '单据ID MAIN表外键';
comment on column T_DOC_PAGES.pic_path
  is '相对路径，相对于HTTP服务器';
comment on column T_DOC_PAGES.pic_path_ftp
  is '相对路径，相对于FTP服务器';
comment on column T_DOC_PAGES.md5_code
  is 'MD5码';
comment on column T_DOC_PAGES.operator
  is '操作者';
comment on column T_DOC_PAGES.insert_time
  is '入库时间';
comment on column T_DOC_PAGES.last_modify_time
  is '最后一次修改日期';
comment on column T_DOC_PAGES.scan_no
  is '扫描者';
comment on column T_DOC_PAGES.doc_key
  is '文件密钥，如果有';
alter table T_DOC_PAGES
  add constraint PK_T_DOC_PAGES primary key (PAGE_ID);
alter table T_DOC_PAGES
  add constraint FK_T_DOC_PAGES foreign key (DOC_ID)
  references T_DOC_MAIN (DOC_ID);

prompt Creating T_DOC_UPDOWN...
create table T_DOC_UPDOWN
(
  doc_name         VARCHAR2(200) not null,
  doc_type         VARCHAR2(20) not null,
  doc_make_time    DATE not null,
  doc_maker        VARCHAR2(200),
  doc_modify_time  DATE,
  doc_suffix       VARCHAR2(200) not null,
  doc_path         VARCHAR2(200),
  host_name        VARCHAR2(200),
  down_times       NUMBER,
  stand_flag1      VARCHAR2(200),
  stand_flag2      VARCHAR2(200),
  operator         VARCHAR2(50),
  insert_time      DATE,
  last_modify_time DATE
)
;
comment on table T_DOC_UPDOWN
  is '数据文件上传下载表';
comment on column T_DOC_UPDOWN.doc_name
  is '文件名称';
comment on column T_DOC_UPDOWN.doc_type
  is '文档类型 U：upload D：download O：other';
comment on column T_DOC_UPDOWN.doc_make_time
  is '创建时间';
comment on column T_DOC_UPDOWN.doc_maker
  is '创建者或者修改者';
comment on column T_DOC_UPDOWN.doc_modify_time
  is '修改时间';
comment on column T_DOC_UPDOWN.doc_suffix
  is '文件后缀';
comment on column T_DOC_UPDOWN.doc_path
  is '文件路径';
comment on column T_DOC_UPDOWN.host_name
  is '文件服务器';
comment on column T_DOC_UPDOWN.down_times
  is '下载次数';
alter table T_DOC_UPDOWN
  add constraint PK_T_DOC_UPDOWN primary key (DOC_NAME, DOC_TYPE, DOC_SUFFIX);

prompt Creating T_TEMP_NODE...
create table T_TEMP_NODE
(
  id               NUMBER(9) not null,
  fid              NUMBER(9),
  node_id          VARCHAR2(50),
  node_code        VARCHAR2(50),
  node_name        VARCHAR2(50),
  son_node_type    VARCHAR2(50),
  son_node_content VARCHAR2(4000)
)
;
comment on column T_TEMP_NODE.id
  is 'ID';
comment on column T_TEMP_NODE.fid
  is 'NULL-则表示MSG节点的跟节点 0-表示DTO的根节点';
comment on column T_TEMP_NODE.node_id
  is '节点ID，修改时该ID为T_DEF_MSG_NODE中的ID';
comment on column T_TEMP_NODE.node_code
  is '编码';
comment on column T_TEMP_NODE.node_name
  is '名称';
comment on column T_TEMP_NODE.son_node_type
  is '子节点类型 1为由子节点 否则无子节点';
comment on column T_TEMP_NODE.son_node_content
  is '子节点内容';

prompt Creating T_TEMP_NODE_ATTRI...
create table T_TEMP_NODE_ATTRI
(
  id          NUMBER(9) not null,
  node_id     NUMBER(9),
  attri_code  VARCHAR2(50),
  attri_name  VARCHAR2(50),
  attri_type  VARCHAR2(50),
  attri_value VARCHAR2(50)
)
;
comment on table T_TEMP_NODE_ATTRI
  is '临时节点属性表';
alter table T_TEMP_NODE_ATTRI
  add constraint PK_T_TEMP_NODE_ATTRI primary key (ID);

prompt Creating T_TEMP_NODE_PARAM...
create table T_TEMP_NODE_PARAM
(
  id               NUMBER(9),
  node_id          NUMBER(9),
  param_name       VARCHAR2(50),
  param_value      VARCHAR2(50),
  param_type       VARCHAR2(20),
  param_code       VARCHAR2(50),
  param_value_type VARCHAR2(20),
  param_sub_type   VARCHAR2(50)
)
;
comment on table T_TEMP_NODE_PARAM
  is '临时节点参数表，用于创建子节点的SQL参数';
comment on column T_TEMP_NODE_PARAM.id
  is 'ID';
comment on column T_TEMP_NODE_PARAM.node_id
  is '节点ID';
comment on column T_TEMP_NODE_PARAM.param_name
  is '参数名称';
comment on column T_TEMP_NODE_PARAM.param_value
  is '参数值，默认';
comment on column T_TEMP_NODE_PARAM.param_type
  is '参数类型';
comment on column T_TEMP_NODE_PARAM.param_code
  is '参数编码';
comment on column T_TEMP_NODE_PARAM.param_value_type
  is '参数值类型';
comment on column T_TEMP_NODE_PARAM.param_sub_type
  is '参数父级类型 0 系统默认 1 为SQL对参数';

prompt Disabling triggers for T_DEF_ACTION_TRACE...
alter table T_DEF_ACTION_TRACE disable all triggers;
prompt Disabling triggers for T_DEF_BAG_EVENT...
alter table T_DEF_BAG_EVENT disable all triggers;
prompt Disabling triggers for T_DEF_BATCH...
alter table T_DEF_BATCH disable all triggers;
prompt Disabling triggers for T_DEF_PLAT_COM...
alter table T_DEF_PLAT_COM disable all triggers;
prompt Disabling triggers for T_DEF_BUSS_MODEL...
alter table T_DEF_BUSS_MODEL disable all triggers;
prompt Disabling triggers for T_DEF_BUSS_IMPL...
alter table T_DEF_BUSS_IMPL disable all triggers;
prompt Disabling triggers for T_DEF_BUSS_SEND_RELA...
alter table T_DEF_BUSS_SEND_RELA disable all triggers;
prompt Disabling triggers for T_DEF_MSG_NODE...
alter table T_DEF_MSG_NODE disable all triggers;
prompt Disabling triggers for T_DEF_BUSS_XENGIN...
alter table T_DEF_BUSS_XENGIN disable all triggers;
prompt Disabling triggers for T_DEF_CODE_DICT...
alter table T_DEF_CODE_DICT disable all triggers;
prompt Disabling triggers for T_DEF_CODE_MAPPING...
alter table T_DEF_CODE_MAPPING disable all triggers;
prompt Disabling triggers for T_DEF_JDBC...
alter table T_DEF_JDBC disable all triggers;
prompt Disabling triggers for T_DEF_JOB_LOG...
alter table T_DEF_JOB_LOG disable all triggers;
prompt Disabling triggers for T_DEF_MANAGE_COM...
alter table T_DEF_MANAGE_COM disable all triggers;
prompt Disabling triggers for T_DEF_MONITOR...
alter table T_DEF_MONITOR disable all triggers;
prompt Disabling triggers for T_DEF_MONITOR_ACTION...
alter table T_DEF_MONITOR_ACTION disable all triggers;
prompt Disabling triggers for T_DEF_NOTICE...
alter table T_DEF_NOTICE disable all triggers;
prompt Disabling triggers for T_DEF_MONITOR_NOTIC_RELA...
alter table T_DEF_MONITOR_NOTIC_RELA disable all triggers;
prompt Disabling triggers for T_DEF_MSG_NODESQL_RELA...
alter table T_DEF_MSG_NODESQL_RELA disable all triggers;
prompt Disabling triggers for T_DEF_MSG_NODE_ATTRI...
alter table T_DEF_MSG_NODE_ATTRI disable all triggers;
prompt Disabling triggers for T_DEF_NOTICE_ACCOUNT...
alter table T_DEF_NOTICE_ACCOUNT disable all triggers;
prompt Disabling triggers for T_DEF_NOTICE_ADD...
alter table T_DEF_NOTICE_ADD disable all triggers;
prompt Disabling triggers for T_DEF_NOTICE_MAIN...
alter table T_DEF_NOTICE_MAIN disable all triggers;
prompt Disabling triggers for T_DEF_NOTICE_SECRETLY...
alter table T_DEF_NOTICE_SECRETLY disable all triggers;
prompt Disabling triggers for T_DEF_ROLE...
alter table T_DEF_ROLE disable all triggers;
prompt Disabling triggers for T_DEF_PLAT_ROLE_RELA...
alter table T_DEF_PLAT_ROLE_RELA disable all triggers;
prompt Disabling triggers for T_DEF_PRIVILEGE...
alter table T_DEF_PRIVILEGE disable all triggers;
prompt Disabling triggers for T_DEF_REPORT_COL...
alter table T_DEF_REPORT_COL disable all triggers;
prompt Disabling triggers for T_DEF_ROLE_PRIVILEGE_RELA...
alter table T_DEF_ROLE_PRIVILEGE_RELA disable all triggers;
prompt Disabling triggers for T_DEF_SEND...
alter table T_DEF_SEND disable all triggers;
prompt Disabling triggers for T_DEF_SFTP...
alter table T_DEF_SFTP disable all triggers;
prompt Disabling triggers for T_DEF_SQL...
alter table T_DEF_SQL disable all triggers;
prompt Disabling triggers for T_DEF_SQL_PARAMS...
alter table T_DEF_SQL_PARAMS disable all triggers;
prompt Disabling triggers for T_DEF_TRANSCODE_TRACE...
alter table T_DEF_TRANSCODE_TRACE disable all triggers;
prompt Disabling triggers for T_DEF_TRANSEXC...
alter table T_DEF_TRANSEXC disable all triggers;
prompt Disabling triggers for T_DEF_TRANSEXC_ACTION...
alter table T_DEF_TRANSEXC_ACTION disable all triggers;
prompt Disabling triggers for T_DEF_TRANSEXC_AFTER...
alter table T_DEF_TRANSEXC_AFTER disable all triggers;
prompt Disabling triggers for T_DEF_TRANSEXC_BEFORE...
alter table T_DEF_TRANSEXC_BEFORE disable all triggers;
prompt Disabling triggers for T_DEF_TRANS_CODE...
alter table T_DEF_TRANS_CODE disable all triggers;
prompt Disabling triggers for T_DEF_USER...
alter table T_DEF_USER disable all triggers;
prompt Disabling triggers for T_DEF_USER_ROLE_RELA...
alter table T_DEF_USER_ROLE_RELA disable all triggers;
prompt Disabling triggers for T_DEF_USER_TRACE...
alter table T_DEF_USER_TRACE disable all triggers;
prompt Disabling triggers for T_DEF_WSP_REQUEST...
alter table T_DEF_WSP_REQUEST disable all triggers;
prompt Disabling triggers for T_DEF_WSP_PARAM...
alter table T_DEF_WSP_PARAM disable all triggers;
prompt Disabling triggers for T_DEF_WSP_RETURN...
alter table T_DEF_WSP_RETURN disable all triggers;
prompt Disabling triggers for T_DOC_MAIN...
alter table T_DOC_MAIN disable all triggers;
prompt Disabling triggers for T_DOC_PAGES...
alter table T_DOC_PAGES disable all triggers;
prompt Disabling triggers for T_DOC_UPDOWN...
alter table T_DOC_UPDOWN disable all triggers;
prompt Disabling triggers for T_TEMP_NODE...
alter table T_TEMP_NODE disable all triggers;
prompt Disabling triggers for T_TEMP_NODE_ATTRI...
alter table T_TEMP_NODE_ATTRI disable all triggers;
prompt Disabling triggers for T_TEMP_NODE_PARAM...
alter table T_TEMP_NODE_PARAM disable all triggers;
prompt Disabling foreign key constraints for T_DEF_BUSS_MODEL...
alter table T_DEF_BUSS_MODEL disable constraint FK_T_DEF_BU_REFERENCE_T_DEF_PL;
prompt Disabling foreign key constraints for T_DEF_BUSS_IMPL...
alter table T_DEF_BUSS_IMPL disable constraint FK_BUSSIMPL_BUSSMODE;
prompt Disabling foreign key constraints for T_DEF_BUSS_SEND_RELA...
alter table T_DEF_BUSS_SEND_RELA disable constraint FK_BUSS2BS_RELA;
prompt Disabling foreign key constraints for T_DEF_BUSS_XENGIN...
alter table T_DEF_BUSS_XENGIN disable constraint FK_MSG_NODE;
prompt Disabling foreign key constraints for T_DEF_MONITOR_NOTIC_RELA...
alter table T_DEF_MONITOR_NOTIC_RELA disable constraint FK_MONOTICE_NOTICE;
alter table T_DEF_MONITOR_NOTIC_RELA disable constraint FK_NOTICE_MONITOR;
prompt Disabling foreign key constraints for T_DEF_MSG_NODESQL_RELA...
alter table T_DEF_MSG_NODESQL_RELA disable constraint FK_T_DEF_MS_REFERENCE_T_DEF_NO;
prompt Disabling foreign key constraints for T_DEF_MSG_NODE_ATTRI...
alter table T_DEF_MSG_NODE_ATTRI disable constraint FK_T_DEF_MS_REFERENCE_T_DEF_MS;
prompt Disabling foreign key constraints for T_DEF_NOTICE_ADD...
alter table T_DEF_NOTICE_ADD disable constraint FK_T_DEF_NO_REFERENCE_T_DEF_NO;
prompt Disabling foreign key constraints for T_DEF_PLAT_ROLE_RELA...
alter table T_DEF_PLAT_ROLE_RELA disable constraint FK_T_DEF_PL_REFERENCE_T_DEF_PL;
alter table T_DEF_PLAT_ROLE_RELA disable constraint FK_T_DEF_PL_REFERENCE_T_DEF_RO;
prompt Disabling foreign key constraints for T_DEF_SEND...
alter table T_DEF_SEND disable constraint FK_PLAT_SEND;
prompt Disabling foreign key constraints for T_DEF_SQL...
alter table T_DEF_SQL disable constraint FK_SQLJDBC_JDBCFROM;
alter table T_DEF_SQL disable constraint FK_SQLJDBC_JDBCTO;
alter table T_DEF_SQL disable constraint FK_SQLPID_SQLID;
alter table T_DEF_SQL disable constraint FK_SQL_PLAT;
prompt Disabling foreign key constraints for T_DEF_TRANSEXC...
alter table T_DEF_TRANSEXC disable constraint FK_T_DEF_TR_REFERENCE_T_DEF_PL;
prompt Disabling foreign key constraints for T_DEF_TRANSEXC_ACTION...
alter table T_DEF_TRANSEXC_ACTION disable constraint FK_TRANS_TRANSEXC;
prompt Disabling foreign key constraints for T_DEF_TRANSEXC_AFTER...
alter table T_DEF_TRANSEXC_AFTER disable constraint FK_TRANSAFTER_TRANSEXC;
prompt Disabling foreign key constraints for T_DEF_TRANSEXC_BEFORE...
alter table T_DEF_TRANSEXC_BEFORE disable constraint FK_TRANSBEFO_TRANSEXC;
prompt Disabling foreign key constraints for T_DEF_WSP_REQUEST...
alter table T_DEF_WSP_REQUEST disable constraint FK_T_DEF_WSP_REQUEST;
prompt Disabling foreign key constraints for T_DEF_WSP_PARAM...
alter table T_DEF_WSP_PARAM disable constraint FK_T_DEF_WS_PARAM2REQUEST;
prompt Disabling foreign key constraints for T_DEF_WSP_RETURN...
alter table T_DEF_WSP_RETURN disable constraint FK_T_DEF_WS_RETURN2REQUEST;
prompt Disabling foreign key constraints for T_DOC_PAGES...
alter table T_DOC_PAGES disable constraint FK_T_DOC_PAGES;

-- Create table
create table T_DEF_ACTION_RETURN
(
  id               NUMBER(19) not null,
  action_no        VARCHAR2(50) not null,
  plat_com         NUMBER(10),
  buss_type        VARCHAR2(50),
  sub_buss_type    VARCHAR2(50),
  status           VARCHAR2(10),
  data_status      VARCHAR2(10),
  check_status     VARCHAR2(10),
  query_no         VARCHAR2(50),
  return_msg       VARCHAR2(200),
  erro_ratio       NUMBER,
  err_info_path    VARCHAR2(200),
  return_code      VARCHAR2(50),
  return_data      CLOB,
  data_type        VARCHAR2(2),
  data_flag        VARCHAR2(2),
  operator         VARCHAR2(50),
  insert_time      DATE,
  last_modify_time DATE,
  es_status        NUMBER(1),
  standby1         VARCHAR2(50),
  standby2         VARCHAR2(50),
  standby3         VARCHAR2(50),
  standby4         VARCHAR2(50)
);
-- Add comments to the columns 
comment on column T_DEF_ACTION_RETURN.action_no
  is '业务流水号，与ACTION_TRACE绑定';
comment on column T_DEF_ACTION_RETURN.plat_com
  is '机构编码 与PLAT_COM中ID绑定';
comment on column T_DEF_ACTION_RETURN.buss_type
  is '业务类型 与ACTION_TRACE中相同';
comment on column T_DEF_ACTION_RETURN.sub_buss_type
  is '业务类型 与ACTION_TRACE中相同';
comment on column T_DEF_ACTION_RETURN.status
  is '业务状态，是否成功接收到';
comment on column T_DEF_ACTION_RETURN.data_status
  is '业务处理状态';
comment on column T_DEF_ACTION_RETURN.check_status
  is '校验状态，用于校验数据使用';
comment on column T_DEF_ACTION_RETURN.query_no
  is '查询码，保单登记有用';
comment on column T_DEF_ACTION_RETURN.return_msg
  is '返回信息';
comment on column T_DEF_ACTION_RETURN.erro_ratio
  is '错误率';
comment on column T_DEF_ACTION_RETURN.err_info_path
  is '错误文件路径，保单登记有用';
comment on column T_DEF_ACTION_RETURN.return_code
  is '返回码';
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
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_DEF_ACTION_RETURN
  add constraint PK_T_DEF_ACTION_RETURN primary key (ID);


-- Create table
create table T_DEF_SQL_INFO
(
  id       NUMBER(19) not null,
  sql_id   NUMBER(19),
  sql_type VARCHAR2(50 CHAR),
  sql_info CLOB
);
-- Add comments to the table 
comment on table T_DEF_SQL_INFO
  is 'SQL配置详情定义表';
-- Add comments to the columns 
comment on column T_DEF_SQL_INFO.id
  is '序列ID';
comment on column T_DEF_SQL_INFO.sql_id
  is '与T_DEF_SQL中的ID关联';
comment on column T_DEF_SQL_INFO.sql_type
  is '与T_DEF_SQL中的TYPE关联';
comment on column T_DEF_SQL_INFO.sql_info
  is 'SQL详细描述';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_DEF_SQL_INFO
  add constraint PK_T_DEF_SQLINFO primary key (ID);
