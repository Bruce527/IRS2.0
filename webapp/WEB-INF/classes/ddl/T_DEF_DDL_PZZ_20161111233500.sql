prompt PL/SQL Developer import file
prompt Created on 2016��11��11�� by gyas-itpingw
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
  is '��̬��¼�켣��';
comment on column T_DEF_ACTION_TRACE.batch_no
  is '�������κ�';
comment on column T_DEF_ACTION_TRACE.batch_type
  is '������������';
comment on column T_DEF_ACTION_TRACE.buss_no
  is '����ҵ���';
comment on column T_DEF_ACTION_TRACE.buss_type
  is '����ҵ������';
comment on column T_DEF_ACTION_TRACE.sub_buss_type
  is '���׸���ҵ������ EB-���� SB-����';
comment on column T_DEF_ACTION_TRACE.plat_com
  is '�������뼴ƽ̨���룬��ӦPLAT_COM�е�ID';
comment on column T_DEF_ACTION_TRACE.action_no
  is '����ҵ����ˮ��';
comment on column T_DEF_ACTION_TRACE.action_date
  is '����ҵ������';
comment on column T_DEF_ACTION_TRACE.action_all_count
  is '����ҵ���¼';
comment on column T_DEF_ACTION_TRACE.action_suc_count
  is '����ҵ��ɹ���¼';
comment on column T_DEF_ACTION_TRACE.action_type
  is '����ҵ������';
comment on column T_DEF_ACTION_TRACE.action_msg
  is '����ҵ����ʾ��Ϣ';
comment on column T_DEF_ACTION_TRACE.data_msg
  is '������Ϣ��ʧ�ܱ���ɹ��������ɹ�';
comment on column T_DEF_ACTION_TRACE.data_status
  is '����״̬ 1-�ɹ� 0-ʧ��';
comment on column T_DEF_ACTION_TRACE.es_status
  is '״̬��ʶ';
comment on column T_DEF_ACTION_TRACE.insert_time
  is '�������';
comment on column T_DEF_ACTION_TRACE.last_modify_time
  is '���һ���޸�����';
comment on column T_DEF_ACTION_TRACE.operator
  is '������';
comment on column T_DEF_ACTION_TRACE.standby1
  is '�����ֶ�1';
comment on column T_DEF_ACTION_TRACE.standby2
  is '�����ֶ�2';
comment on column T_DEF_ACTION_TRACE.standby3
  is '�����ֶ�3';
comment on column T_DEF_ACTION_TRACE.standby4
  is '�����ֶ�4';
comment on column T_DEF_ACTION_TRACE.state_flag
  is '״̬��ʶ';
comment on column T_DEF_ACTION_TRACE.start_date
  is '��ʼ����';
comment on column T_DEF_ACTION_TRACE.end_date
  is '��������';
comment on column T_DEF_ACTION_TRACE.action_time
  is '����ʵʱʱ��';
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
  is '�����¼�������';
comment on column T_DEF_BAG_EVENT.monitor_code
  is '��ر���';
comment on column T_DEF_BAG_EVENT.sql_id
  is '�¼�ID';
comment on column T_DEF_BAG_EVENT.es_status
  is '״̬��ʶ 1 ��Ч 0 ��Ч 2 ɾ��';
comment on column T_DEF_BAG_EVENT.insert_time
  is '���ʱ��';
comment on column T_DEF_BAG_EVENT.last_modify_time
  is '���һ���޸�ʱ��';
comment on column T_DEF_BAG_EVENT.operator
  is '������';
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
  is '����ţ��������';
comment on column T_DEF_BATCH.mapping_no
  is '���ID';
comment on column T_DEF_BATCH.batch_type
  is '��������';
comment on column T_DEF_BATCH.batch_no
  is '���κ�';
comment on column T_DEF_BATCH.trans_no
  is '���׺�';
comment on column T_DEF_BATCH.trans_date
  is '��������';
comment on column T_DEF_BATCH.buss_no
  is 'ҵ���';
comment on column T_DEF_BATCH.buss_type
  is 'ҵ������';
comment on column T_DEF_BATCH.sub_batch_type
  is '������������';
comment on column T_DEF_BATCH.insert_time
  is '�������';
comment on column T_DEF_BATCH.date_serial
  is '��ǰ����';
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
  is '�����洢ƽ̨�����Ļ�����Ϣ';
comment on column T_DEF_PLAT_COM.com_code
  is '��������';
comment on column T_DEF_PLAT_COM.com_name
  is '��������';
comment on column T_DEF_PLAT_COM.com_pid
  is '�������ID';
comment on column T_DEF_PLAT_COM.com_name_short
  is '�������';
comment on column T_DEF_PLAT_COM.com_name_en
  is '����Ӣ������';
comment on column T_DEF_PLAT_COM.com_address
  is '������ַ';
comment on column T_DEF_PLAT_COM.com_email
  is '������ϵEMAIL';
comment on column T_DEF_PLAT_COM.com_phone
  is '������ϵ�绰';
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
  is 'ƽ̨ҵ��ģ�Ͷ����';
comment on column T_DEF_BUSS_MODEL.buss_id
  is 'ƽ̨ҵ������ID';
comment on column T_DEF_BUSS_MODEL.buss_pid
  is '����ҵ������ID(��ʱδ��)';
comment on column T_DEF_BUSS_MODEL.buss_type
  is 'ҵ������  �� T_DEF_CODE_DICT�ж�������һ��';
comment on column T_DEF_BUSS_MODEL.buss_code
  is 'ҵ�����ͱ���';
comment on column T_DEF_BUSS_MODEL.buss_name
  is 'ҵ����������';
comment on column T_DEF_BUSS_MODEL.com_id
  is '��Ӧ PLATCOM �е� COM_ID';
comment on column T_DEF_BUSS_MODEL.rc_status
  is '״̬��ʶ 1 ��Ч 0 ��Ч 2 ɾ��';
comment on column T_DEF_BUSS_MODEL.is_title
  is '�Ƿ���Ҫ���� ���ڱ�������ʱ���� 1 �� 0 ��';
comment on column T_DEF_BUSS_MODEL.title_info
  is '����TITLE��Ϣ';
comment on column T_DEF_BUSS_MODEL.sub_buss_type
  is '���Ķ��� MSG_REQUEST ������ MSG_RESPONSE ���ر���';
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
  is 'ҵ��ʵ�ַ�ʽ����';
comment on column T_DEF_BUSS_IMPL.impl_type
  is '�� T_DEF_CODE_DICT �ж����CODE��ͬ';
comment on column T_DEF_BUSS_IMPL.impl_code
  is 'ʵ�ַ�ʽ����';
comment on column T_DEF_BUSS_IMPL.impl_name
  is '�ַ�ʽ����';
comment on column T_DEF_BUSS_IMPL.format_type
  is '���ĸ�ʽ ��ӦT_DEF_CODE_DICT�е�CODE';
comment on column T_DEF_BUSS_IMPL.send_type
  is '���ĸ�ʽ ��ӦT_DEF_CODE_DICT�е�CODE';
comment on column T_DEF_BUSS_IMPL.rc_status
  is '״̬��ʶ 0-��Ч 1-��Ч 2-ɾ��';
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
  is 'ҵ���͹�������';
comment on column T_DEF_BUSS_SEND_RELA.buss_id
  is 'ҵ��ID';
comment on column T_DEF_BUSS_SEND_RELA.send_id
  is '���ͽӿ�';
comment on column T_DEF_BUSS_SEND_RELA.rc_status
  is '��Ч��ʶ 1 ��Ч 0 ��Ч 2 ɾ��';
comment on column T_DEF_BUSS_SEND_RELA.insert_time
  is '���ʱ��';
comment on column T_DEF_BUSS_SEND_RELA.last_modify_time
  is '���һ���޸�ʱ��';
comment on column T_DEF_BUSS_SEND_RELA.operator
  is '������';
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
  is '��������ڵ㶨���';
comment on column T_DEF_MSG_NODE.node_id
  is '����ID';
comment on column T_DEF_MSG_NODE.node_pid
  is '��������ID';
comment on column T_DEF_MSG_NODE.node_code
  is '�ڵ����';
comment on column T_DEF_MSG_NODE.node_name
  is '�ڵ�����';
comment on column T_DEF_MSG_NODE.node_text
  is '�ڵ��ı�';
comment on column T_DEF_MSG_NODE.node_num
  is '�ڵ����˳��';
comment on column T_DEF_MSG_NODE.rc_status
  is '״̬��ʶ 1 ��Ч 0 ��Ч 2 ɾ��';
comment on column T_DEF_MSG_NODE.son_node_type
  is '�Ƿ����ӽڵ� 1 ��  0 �� null ��';
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
  is '����ҵ��������Ľڵ����';
comment on column T_DEF_BUSS_XENGIN.impl_id
  is 'ʵ��ID';
comment on column T_DEF_BUSS_XENGIN.rc_status
  is '�Ƿ���Ч 1-��Ч 0-��Ч һ��ҵ���IDֻ����һ����Ч�ļ�¼';
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
  is 'ö���ֵ䶨���';
comment on column T_DEF_CODE_DICT.code_type
  is 'ö�ٱ�������';
comment on column T_DEF_CODE_DICT.code
  is 'ö�ٱ���ֵ';
comment on column T_DEF_CODE_DICT.code_name
  is 'ö�ٱ�������';
comment on column T_DEF_CODE_DICT.code_alias
  is 'ö�ٱ������';
comment on column T_DEF_CODE_DICT.com_id
  is '����ID����Ӧ T_DEF_PLATCOM �� COM_ID���Ǹ������¿����ø���';
comment on column T_DEF_CODE_DICT.es_status
  is '״̬��ʶ 1 ��Ч 0 ��Ч 2 ɾ��';
comment on column T_DEF_CODE_DICT.code_group_rela
  is '����Ⱥ�����';
comment on column T_DEF_CODE_DICT.code_status_rela
  is '����״̬����';
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
  is 'ö�����ӳ���ϵ';
comment on column T_DEF_CODE_MAPPING.id
  is '����ID';
comment on column T_DEF_CODE_MAPPING.code_type
  is 'ת��ӳ������';
comment on column T_DEF_CODE_MAPPING.basic_code
  is '��ת��ֵ����';
comment on column T_DEF_CODE_MAPPING.basic_code_name
  is '��ת������';
comment on column T_DEF_CODE_MAPPING.target_code
  is 'ת�������';
comment on column T_DEF_CODE_MAPPING.target_code_name
  is 'ת��������';
comment on column T_DEF_CODE_MAPPING.com_id
  is '����ƽ̨��������Ӧ T_DEF_PLATCOM �� COM_ID';
comment on column T_DEF_CODE_MAPPING.manage_id
  is '�����������';
comment on column T_DEF_CODE_MAPPING.remark
  is '��ע';
comment on column T_DEF_CODE_MAPPING.es_status
  is '״̬��ʶ 1 ��Ч 0 ��Ч 2 ɾ��';
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
  is '����ϵͳ�õ��Ķ���JDBC��Ϣ';
comment on column T_DEF_JDBC.jdbc_type
  is 'JDBC���ͣ�1 ��ʾͨ���û����ƻ�ȡ 2����ʾͨ��JNDI��ȡ 3����ʾ�ֲ�ʽ��ȡ 4:��ʾSPRING����Դ��ȡ';
comment on column T_DEF_JDBC.jdbc_code
  is '��ʾ�����';
comment on column T_DEF_JDBC.jdbc_name
  is '��ʾ������';
comment on column T_DEF_JDBC.driver_name
  is '��������';
comment on column T_DEF_JDBC.url
  is '����URL';
comment on column T_DEF_JDBC.username
  is '�û���';
comment on column T_DEF_JDBC.password
  is '�û�����';
comment on column T_DEF_JDBC.jndi_name
  is 'TYPEΪ2ʱ �ǿ� �����������JDBC����';
comment on column T_DEF_JDBC.dialect
  is '���ԣ�˵�����������ݿ�';
comment on column T_DEF_JDBC.description
  is '������TYPEΪ3�Ƿǿ�';
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
  is 'Jobִ����־';
comment on column T_DEF_JOB_LOG.id
  is 'ID';
comment on column T_DEF_JOB_LOG.job_code
  is 'JOB����';
comment on column T_DEF_JOB_LOG.job_name
  is 'JOB����';
comment on column T_DEF_JOB_LOG.job_group
  is 'JOB���';
comment on column T_DEF_JOB_LOG.job_type
  is 'JOB����';
comment on column T_DEF_JOB_LOG.job_status
  is 'JOB״̬����ӦT_DEF_CODE_DICT �� JOB_STATUS';
comment on column T_DEF_JOB_LOG.start_time
  is '��ʼ����';
comment on column T_DEF_JOB_LOG.end_time
  is '��������';
comment on column T_DEF_JOB_LOG.run_msg
  is '������Ϣ';
comment on column T_DEF_JOB_LOG.insert_time
  is '�������';
comment on column T_DEF_JOB_LOG.last_modify_time
  is '���һ���޸�����';
comment on column T_DEF_JOB_LOG.operator
  is '������';
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
  is '������������';
comment on column T_DEF_MANAGE_COM.id
  is '����ID';
comment on column T_DEF_MANAGE_COM.fid
  is '�������ID';
comment on column T_DEF_MANAGE_COM.manage_code
  is '�����������';
comment on column T_DEF_MANAGE_COM.manage_name
  is '�����������';
comment on column T_DEF_MANAGE_COM.manage_name_short
  is '����������';
comment on column T_DEF_MANAGE_COM.manage_enname
  is '�������Ӣ������';
comment on column T_DEF_MANAGE_COM.manage_enname_short
  is '�������Ӣ�ļ��';
comment on column T_DEF_MANAGE_COM.manage_inner_code
  is '�����ڲ�����';
comment on column T_DEF_MANAGE_COM.status
  is '״̬ 1 ��Ч';
comment on column T_DEF_MANAGE_COM.open_date
  is '��������ʱ��';
comment on column T_DEF_MANAGE_COM.close_date
  is '�����ر�ʱ�� �����ʾδ�ر�';
comment on column T_DEF_MANAGE_COM.mmonitor_type
  is '�����������';
comment on column T_DEF_MANAGE_COM.mmonitor_code
  is '�û����ڼ�ܶ�Ӧ�Ĵ���';
comment on column T_DEF_MANAGE_COM.address
  is '�칫��ַ';
comment on column T_DEF_MANAGE_COM.email
  is '��������';
comment on column T_DEF_MANAGE_COM.phone
  is '�����绰';
comment on column T_DEF_MANAGE_COM.zipcode
  is '�ʱ�';
comment on column T_DEF_MANAGE_COM.insert_time
  is '���ʱ��';
comment on column T_DEF_MANAGE_COM.last_modify_time
  is '���һ�θ���ʱ��';
comment on column T_DEF_MANAGE_COM.remark
  is '��ע';
comment on column T_DEF_MANAGE_COM.license_type
  is '��������';
comment on column T_DEF_MANAGE_COM.inner_fid
  is '�ϼ������ڲ�����';
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
  is '����������';
comment on column T_DEF_MONITOR.monitor_code
  is '��ر���';
comment on column T_DEF_MONITOR.monitor_name
  is '�������';
comment on column T_DEF_MONITOR.monitor_level
  is '��ؽ��';
comment on column T_DEF_MONITOR.rc_status
  is '״̬��ʶ 1 ��Ч 0 ��Ч 2 ɾ��';
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
  is '��¼��صĹ켣';
comment on column T_DEF_MONITOR_ACTION.monitor_id
  is '���ID';
comment on column T_DEF_MONITOR_ACTION.monitor_type
  is '�������
E������
S������
C�������ĵ�
D��ɾ������
U����������
I����������
Q����ѯ����
O������';
comment on column T_DEF_MONITOR_ACTION.monitor_buss
  is '��ص����Ǹ�ҵ�� �������������ĵ�ʱ��';
comment on column T_DEF_MONITOR_ACTION.start_time
  is '��ؿ�ʼʱ�� ��ȷ����';
comment on column T_DEF_MONITOR_ACTION.end_time
  is '��ؽ���ʱ�� ��ȷ����';
comment on column T_DEF_MONITOR_ACTION.mresult
  is '��ؽ��';
comment on column T_DEF_MONITOR_ACTION.user_id
  is '����ߣ��û�';
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
  is '����֪ͨ��Ϣ';
comment on column T_DEF_NOTICE.notice_type
  is '�� T_DEF_CODEDICT �ж����NOTICE_TYPE ��Ӧ��CODEһ��';
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
  is '��������֪ͨ�Ĺ�����Ϣ';
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
  is '���屨�Ľڵ��SQL';
comment on column T_DEF_MSG_NODESQL_RELA.node_id
  is 'T_DEF_MSG_NODE �ж�Ӧ�� NODE_ID';
comment on column T_DEF_MSG_NODESQL_RELA.sql_id
  is 'T_DEF_SQL �ж����ID';
comment on column T_DEF_MSG_NODESQL_RELA.rc_status
  is '״̬ ��ʶ 1 ��Ч 0 ��Ч 2 ɾ��';
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
  is '���Ľڵ����Զ����';
comment on column T_DEF_MSG_NODE_ATTRI.node_id
  is '�����ڵ�ID����ӦT_DEF_MSG_NODE��ID';
comment on column T_DEF_MSG_NODE_ATTRI.attri_code
  is '��Ӧ���Եı���';
comment on column T_DEF_MSG_NODE_ATTRI.attri_name
  is '��Ӧ���Ե���������';
comment on column T_DEF_MSG_NODE_ATTRI.attri_value
  is '��Ӧ���Ե�ֵ';
comment on column T_DEF_MSG_NODE_ATTRI.attri_num
  is '���Լ���˳��';
comment on column T_DEF_MSG_NODE_ATTRI.rc_status
  is '��Ч��ʶ 1 ��Ч 0 ��Ч 2 ɾ��';
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
  is '���֪ͨ�˻���';
comment on column T_DEF_NOTICE_ACCOUNT.notice_type
  is 'F-����   I-�ռ�';
comment on column T_DEF_NOTICE_ACCOUNT.web_address
  is '��������ַ ������õ�';
comment on column T_DEF_NOTICE_ACCOUNT.web_port
  is '�������˿� ������õ�';
comment on column T_DEF_NOTICE_ACCOUNT.account_addr
  is '�˻���ַ';
comment on column T_DEF_NOTICE_ACCOUNT.account_user
  is '�˻��û�';
comment on column T_DEF_NOTICE_ACCOUNT.account_pass
  is '�˻�����';
comment on column T_DEF_NOTICE_ACCOUNT.er_status
  is '״̬��ʶ';
comment on column T_DEF_NOTICE_ACCOUNT.insert_time
  is '���ʱ��';
comment on column T_DEF_NOTICE_ACCOUNT.last_modify_time
  is '���һ���޸�ʱ��';
comment on column T_DEF_NOTICE_ACCOUNT.operator
  is '������';
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
  is '֪ͨ������Ա';
comment on column T_DEF_NOTICE_ADD.notice_to
  is '֪ͨ��ַ���ʼ�֪ͨʱ������� ΢��֪ͨʱ��΢�ź� QQ֪ͨʱ��QQ��';
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
  is '��Ҫ֪ͨ����';
comment on column T_DEF_NOTICE_MAIN.notice_to
  is '֪ͨ��ַ���ʼ�֪ͨʱ������� ΢��֪ͨʱ��΢�ź� QQ֪ͨʱ��QQ��';
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
  is '����֪ͨ��Ա';
comment on column T_DEF_NOTICE_SECRETLY.notice_to
  is '֪ͨ��ַ���ʼ�֪ͨʱ������� ΢��֪ͨʱ��΢�ź� QQ֪ͨʱ��QQ��';
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
  is '����ID';
comment on column T_DEF_ROLE.rolecode
  is '��ɫ����';
comment on column T_DEF_ROLE.rolename
  is '��ɫ����';
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
  is 'ƽ̨��ɫ����������';
comment on column T_DEF_PLAT_ROLE_RELA.id
  is '����ID';
comment on column T_DEF_PLAT_ROLE_RELA.role_id
  is '��ɫID';
comment on column T_DEF_PLAT_ROLE_RELA.com_id
  is 'ƽ̨ID';
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
  is '����ID';
comment on column T_DEF_PRIVILEGE.privilegecode
  is '�˵�����';
comment on column T_DEF_PRIVILEGE.privilegename
  is '�˵�����';
comment on column T_DEF_PRIVILEGE.privilegetype
  is '�˵�����:
system - ϵͳ����Ȩ��
menu - �˵�����Ȩ��
function - ��ť����Ȩ��
data - ���ݷ���Ȩ��
';
comment on column T_DEF_PRIVILEGE.url
  is '�˵�url:privilegetypeΪmenu�Ĳ˵�����Ȩ�޲�����';
comment on column T_DEF_PRIVILEGE.pid
  is '�˵��ĸ��ڵ�id:privilegetypeΪmenu�Ĳ˵�����Ȩ�޲�����';
comment on column T_DEF_PRIVILEGE.method
  is '���ʷ�ʽ:privilegetypeΪfunction�Ĳ˵�����Ȩ�޲�����
�ɷ��ʵİ�ť��������У�
create
read
delete
update';
comment on column T_DEF_PRIVILEGE.pre
  is 'ǰһ�˵�id';
comment on column T_DEF_PRIVILEGE.next
  is '��һ�˵�id';
comment on column T_DEF_PRIVILEGE.num
  is '����˳��';
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
  is '��ɫ�˵�������';
comment on column T_DEF_ROLE_PRIVILEGE_RELA.id
  is '����ID';
comment on column T_DEF_ROLE_PRIVILEGE_RELA.role_id
  is '��ɫID';
comment on column T_DEF_ROLE_PRIVILEGE_RELA.privilege_id
  is '�˵�ID';
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
  is 'ҵ���ͷ�ʽ';
comment on column T_DEF_SEND.send_type
  is '�� T_DEF_CODEDICT �� CODE ��ͬ';
comment on column T_DEF_SEND.send_encode
  is 'UTF-8�� GBK�� Ĭ��UTF-8';
comment on column T_DEF_SEND.send_user
  is '������SEND_TYPEΪPROXCY �������SFTPʱ �е��Ǳ���Ķ�Ӧ���û�';
comment on column T_DEF_SEND.send_pass
  is '������SEND_TYPEΪPROXCY �������SFTPʱ �е��Ǳ���Ķ�Ӧ���û�����';
comment on column T_DEF_SEND.send_api
  is '���͵�URL����SEND_TYPE = HTTP ʱ�ж�Ӧ��URL·��';
comment on column T_DEF_SEND.send_ip
  is '������SEND_TYPEΪPROXCY �������SFTPʱ �ж�Ӧ��IP';
comment on column T_DEF_SEND.send_port
  is '������SEND_TYPEΪPROXCY �������SFTPʱ �ж�Ӧ�Ķ˿ں�';
comment on column T_DEF_SEND.batch_count
  is '�б��𵥹���';
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
  is '���ڶ�����ط���������Ϣ';
comment on column T_DEF_SFTP.sftp_ip
  is '������IP';
comment on column T_DEF_SFTP.sftp_port
  is '�������˿�';
comment on column T_DEF_SFTP.sftp_type
  is '���������ͣ�U �ϴ� D ���� S ���� C ��ͨ O ����';
comment on column T_DEF_SFTP.sftp_disc
  is '����������';
comment on column T_DEF_SFTP.sftp_use_type
  is '��������;���� FILE �ļ������� IMAGE ͼƬ������ WEB Ӧ�÷����� NULL û������˵��';
comment on column T_DEF_SFTP.visit_user
  is '�����û�';
comment on column T_DEF_SFTP.visit_pass
  is '��������';
comment on column T_DEF_SFTP.visit_url
  is '����·��';
comment on column T_DEF_SFTP.is_need_key
  is '�����Ƿ���Ҫ��Կ 1 - ��  0 - ��';
comment on column T_DEF_SFTP.visit_key
  is '������Կ';
comment on column T_DEF_SFTP.com_id
  is 'ʹ��ƽ̨';
comment on column T_DEF_SFTP.role_id
  is 'ʹ�ý�ɫ';
comment on column T_DEF_SFTP.es_status
  is '�Ƿ���Ч 1 �� NULL ��Ч 0 ��Ч 2 ɾ��';
comment on column T_DEF_SFTP.remark
  is '��ע';
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
  is 'SQL���ö����';
comment on column T_DEF_SQL.sql_id
  is '����ID';
comment on column T_DEF_SQL.sql_code
  is '�㷨����';
comment on column T_DEF_SQL.sql_type
  is 'SQL����
I���� D��ɾ U���� Q���� O ����';
comment on column T_DEF_SQL.sql_from
  is 'SQL��Դ�������Ǹ�������ִ��SQL Ϊ���򱾵�����';
comment on column T_DEF_SQL.sql_from_jdbc_id
  is 'SQLִ�е�JDBC��Ϊ�ջ�1��Ϊ����';
comment on column T_DEF_SQL.sql_into
  is 'ָ����������Դ';
comment on column T_DEF_SQL.sql_into_jdbc_id
  is 'ָ����������Դ ����SQL_TYPE Ϊ I ���� U �����';
comment on column T_DEF_SQL.sql_into_target_table
  is '��������ʱ��Ŀ���';
comment on column T_DEF_SQL.sql_num
  is 'SQL����˳��';
comment on column T_DEF_SQL.sql_desc
  is '�㷨����';
comment on column T_DEF_SQL.com_id
  is 'ƽ̨��������Ӧ T_DEF_PLATCOM �� COM_ID';
comment on column T_DEF_SQL.pid
  is '����SQL';
comment on column T_DEF_SQL.pre_id
  is '��һ����ִ��SQL';
comment on column T_DEF_SQL.next_id
  is '��һ��ִ��SQL';
comment on column T_DEF_SQL.buss_type
  is 'ҵ������';
comment on column T_DEF_SQL.es_status
  is '��ǰ��¼״̬��1 ��Ч 0 ��Ч 2 ɾ��';
comment on column T_DEF_SQL.insert_time
  is '���ʱ��';
comment on column T_DEF_SQL.last_modify_time
  is '���һ���޸�ʱ��';
comment on column T_DEF_SQL.operator
  is '������';
comment on column T_DEF_SQL.sub_buss_type
  is '�ϼ�ҵ������';
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
  is 'SQL���ò��������';
comment on column T_DEF_SQL_PARAMS.id
  is '����ID';
comment on column T_DEF_SQL_PARAMS.sql_id
  is '��ӦT_DEF_SQL�е�ID �����ʾ�ò���ΪϵͳĬ�ϣ�����SQL�����õ�';
comment on column T_DEF_SQL_PARAMS.param_type
  is '������������ 0���������Σ����ÿ� 1��ȡ���ⲿ����Map��ֵ��Ĭ�� 2������ͨ����ִ��SQL��� 3��ȡ��Value��Ӧ��ֵ(�̶�ֵ)
';
comment on column T_DEF_SQL_PARAMS.param_code
  is '��������';
comment on column T_DEF_SQL_PARAMS.param_name
  is '��������';
comment on column T_DEF_SQL_PARAMS.param_value
  is '����Ĭ��ֵ';
comment on column T_DEF_SQL_PARAMS.es_status
  is '�Ƿ���Ч��1 ��Ч 0 ��Ч 2 ɾ��';
comment on column T_DEF_SQL_PARAMS.param_value_type
  is '����ֵ���� STRING��DATE��NUMBER';
comment on column T_DEF_SQL_PARAMS.param_sub_type
  is '�����������ͣ������䷶Χ  1-����SQLID��Ӧ�Ĳ���  0-ϵͳĬ�ϵĲ������κ�SQL�����ã���ӦSQLIDΪ��';
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
  is 'ת��켣��¼��';
comment on column T_DEF_TRANSCODE_TRACE.id
  is 'ID';
comment on column T_DEF_TRANSCODE_TRACE.batch_no
  is '���κ�';
comment on column T_DEF_TRANSCODE_TRACE.action_no
  is '����ҵ����ˮ��';
comment on column T_DEF_TRANSCODE_TRACE.transexc_id
  is '����ID';
comment on column T_DEF_TRANSCODE_TRACE.transexc_code
  is '�������';
comment on column T_DEF_TRANSCODE_TRACE.transexc_name
  is '���������ظ�';
comment on column T_DEF_TRANSCODE_TRACE.sql_id
  is 'SQLID';
comment on column T_DEF_TRANSCODE_TRACE.sql_desc
  is 'SQL����';
comment on column T_DEF_TRANSCODE_TRACE.msg
  is 'ת����Ϣ';
comment on column T_DEF_TRANSCODE_TRACE.operator
  is '������';
comment on column T_DEF_TRANSCODE_TRACE.insert_time
  is '�������';
comment on column T_DEF_TRANSCODE_TRACE.last_modify_time
  is '���һ���޸�����';
comment on column T_DEF_TRANSCODE_TRACE.state_flag
  is 'ת̨��ʶ 1-�ɹ� 0-ʧ��';

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
  is 'ƽ̨����ģ�Ͷ����';
comment on column T_DEF_TRANSEXC.exc_id
  is '����ID';
comment on column T_DEF_TRANSEXC.impl_id
  is 'ʵ��ID';
comment on column T_DEF_TRANSEXC.com_id
  is 'ƽ̨����ID';
comment on column T_DEF_TRANSEXC.buss_id
  is 'ҵ������ID';
comment on column T_DEF_TRANSEXC.exc_code
  is '�������';
comment on column T_DEF_TRANSEXC.exc_name
  is '��������';
comment on column T_DEF_TRANSEXC.exc_desc
  is '��������';
comment on column T_DEF_TRANSEXC.rc_status
  is '״̬��ʶ 1-��Ч 0-��Ч 2-ɾ��';
comment on column T_DEF_TRANSEXC.insert_time
  is '�������';
comment on column T_DEF_TRANSEXC.last_modify_time
  is '���һ���޸�����';
comment on column T_DEF_TRANSEXC.operator
  is '������';
comment on column T_DEF_TRANSEXC.exc_num
  is 'ִ������';
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
  is '���崫��ִ�з�ʽ';
comment on column T_DEF_TRANSEXC_ACTION.exc_id
  is '��Ӧ T_DEF_BUSS_TRANSEXC �е�ID';
comment on column T_DEF_TRANSEXC_ACTION.sql_id
  is 'ִ��SQL����Ӧ T_DEF_SQL �е�SQL_ID';
comment on column T_DEF_TRANSEXC_ACTION.rc_status
  is '״̬��ʶ 1 ��Ч 0 ��Ч 2 ɾ��';
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
  is '�����ִ��SQL';
comment on column T_DEF_TRANSEXC_AFTER.exc_id
  is '��Ӧ T_DEF_BUSS_TRANSEXC  �е� ID';
comment on column T_DEF_TRANSEXC_AFTER.sql_id
  is 'ִ��SQL����Ӧ T_DEF_SQL �е�SQL_ID';
comment on column T_DEF_TRANSEXC_AFTER.exc_num
  is 'ִ��˳��';
comment on column T_DEF_TRANSEXC_AFTER.rc_status
  is '״̬��ʶ 1 ��Ч 0 ��Ч 2 ɾ��';
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
  is '����ִ��ǰ����';
comment on column T_DEF_TRANSEXC_BEFORE.exc_id
  is '��Ӧ T_DEF_BUSS_TRANSEXC  �е� ID';
comment on column T_DEF_TRANSEXC_BEFORE.sql_id
  is 'ִ��SQL����Ӧ T_DEF_SQL �е�SQL_ID';
comment on column T_DEF_TRANSEXC_BEFORE.rc_status
  is '״̬��ʶ 1 ��Ч 0 ��Ч 2 ɾ��';
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
  is 'ת���㷨���ñ�';
comment on column T_DEF_TRANS_CODE.id
  is '����ID';
comment on column T_DEF_TRANS_CODE.target_table_name
  is 'Ŀ�����';
comment on column T_DEF_TRANS_CODE.target_col_name
  is 'Ŀ���ֶ�';
comment on column T_DEF_TRANS_CODE.code_type
  is '�ο�ӳ�䣬����ӳ��ʹ�õ�ӳ������';
comment on column T_DEF_TRANS_CODE.data_type
  is '����Դ';
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
  is 'ID����';
comment on column T_DEF_USER.usercode
  is '�����û�����';
comment on column T_DEF_USER.username
  is '�����û�����';
comment on column T_DEF_USER.password
  is '������֤����';
comment on column T_DEF_USER.company_id
  is '�û���˾����';
comment on column T_DEF_USER.empower_type
  is '��֤��ʽ��1����Ĭ����֤ 2ͳһ��֤ 3��������֤';
comment on column T_DEF_USER.empower_code
  is '��֤���룬�����뱾����֤�û���';
comment on column T_DEF_USER.ssiauth
  is '��֤����';
comment on column T_DEF_USER.ssisign
  is '��֤ǩ��';
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
  is 'ѧ��ID';
comment on column T_DEF_USER_ROLE_RELA.role_id
  is '��ɫID';
comment on column T_DEF_USER_ROLE_RELA.user_id
  is '�û�ID';
comment on column T_DEF_USER_ROLE_RELA.user_code
  is '�û�����';
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
  is '�û�������������¼�û�����������';
comment on column T_DEF_USER_TRACE.id
  is '����ID';
comment on column T_DEF_USER_TRACE.user_ip
  is '�����û�ʹ�õ�IP';
comment on column T_DEF_USER_TRACE.privilege_id
  is '�û����ʵĲ˵�';
comment on column T_DEF_USER_TRACE.insert_time
  is '����ʱ��';
comment on column T_DEF_USER_TRACE.trace_url
  is '���ʵ�ַ';
comment on column T_DEF_USER_TRACE.trace_func
  is '���ʺ����򷽷�';
comment on column T_DEF_USER_TRACE.trace_msg
  is '������Ϣ';
comment on column T_DEF_USER_TRACE.user_id
  is '�û�ID';
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
  is 'WebServicePort Զ���������';
comment on column T_DEF_WSP_REQUEST.id
  is '����Ψһ��ʶ';
comment on column T_DEF_WSP_REQUEST.com_id
  is '�ṹ����';
comment on column T_DEF_WSP_REQUEST.request_method
  is '���󷽷�';
comment on column T_DEF_WSP_REQUEST.request_name
  is 'DTO����';
comment on column T_DEF_WSP_REQUEST.request_class
  is 'DTO����';
comment on column T_DEF_WSP_REQUEST.request_type
  is 'DTO ���� 1 Զ�̽ӿ�';
comment on column T_DEF_WSP_REQUEST.buss_type
  is '�� T_DEF_CODE_DICT �� BUSS_TYPE ���';
comment on column T_DEF_WSP_REQUEST.es_status
  is '��Ч��ʶ 0-��Ч 1-��Ч 2-ɾ��';
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
  is 'WebServicePort  ����';
comment on column T_DEF_WSP_PARAM.request_id
  is '����ID';
comment on column T_DEF_WSP_PARAM.param_name
  is '��������';
comment on column T_DEF_WSP_PARAM.param_class
  is '������';
comment on column T_DEF_WSP_PARAM.param_type
  is '�������� 0-�� 1-���� 2-����';
comment on column T_DEF_WSP_PARAM.es_status
  is '��Ч��ʶ 0-��Ч1-��Ч 2-ɾ��';
comment on column T_DEF_WSP_PARAM.num
  is '����';
comment on column T_DEF_WSP_PARAM.is_analizy
  is '�Ƿ���Ҫ���� null �� 0 ����Ҫ 1 ����Ҫ����';
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
  is 'Զ������ ��������';
comment on column T_DEF_WSP_RETURN.request_id
  is '���ڵ�DTO ID';
comment on column T_DEF_WSP_RETURN.return_name
  is '��������';
comment on column T_DEF_WSP_RETURN.return_class
  is '������';
comment on column T_DEF_WSP_RETURN.return_type
  is '�������� 0 �޷��� 1-���� 2-����';
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
  is '�ĵ���Ϣ��';
comment on column T_DOC_MAIN.doc_id
  is 'Ψһ��ʾһ���ļ��ı�ţ�ϵͳ����';
comment on column T_DOC_MAIN.batch_no
  is '����Ϊ�գ���ʱĬ��Ϊ0';
comment on column T_DOC_MAIN.trans_no
  is '���ױ��';
comment on column T_DOC_MAIN.doc_code
  is 'һ���ļ��ĺ��룬��Ͷ����ӡˢ�ŵ�';
comment on column T_DOC_MAIN.doc_unic
  is '�ļ����룺UTF-8 GBK ��';
comment on column T_DOC_MAIN.buss_type
  is '�б�
����
��ȫ
δ���';
comment on column T_DOC_MAIN.sub_buss_type
  is 'Ͷ����
�������
��������
......';
comment on column T_DOC_MAIN.doc_pages
  is '�õ���ҳ��';
comment on column T_DOC_MAIN.action_times
  is '�����Ĵ���ͳ��';
comment on column T_DOC_MAIN.doc_flag
  is '�Ƿ���Ч 0--��Ч1--��Ч';
comment on column T_DOC_MAIN.doc_remark
  is '��ע';
comment on column T_DOC_MAIN.com_id
  is 'ƽ̨����';
comment on column T_DOC_MAIN.es_status
  is '1-��Ч 0-��Ч 2-ɾ��';
comment on column T_DOC_MAIN.scan_operator
  is 'ɨ����';
comment on column T_DOC_MAIN.insert_time
  is '�������';
comment on column T_DOC_MAIN.last_modify_time
  is '���һ���޸�ʱ��';
comment on column T_DOC_MAIN.operator
  is '������';
comment on column T_DOC_MAIN.version
  is '�汾';
comment on column T_DOC_MAIN.print_code
  is '��ӡ���';
comment on column T_DOC_MAIN.action_flag
  is '����״̬';
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
  is 'ҳ������ļ���,T_DOC_MAIN ���ӱ�';
comment on column T_DOC_PAGES.page_id
  is '����';
comment on column T_DOC_PAGES.page_code
  is 'ҳ�����';
comment on column T_DOC_PAGES.page_name
  is 'ҳ������';
comment on column T_DOC_PAGES.page_count
  is 'ҳ��ͳ��';
comment on column T_DOC_PAGES.page_suffix
  is '��׺';
comment on column T_DOC_PAGES.page_type
  is '����';
comment on column T_DOC_PAGES.page_flag
  is '0--����
1--��������';
comment on column T_DOC_PAGES.doc_id
  is '����ID MAIN�����';
comment on column T_DOC_PAGES.pic_path
  is '���·���������HTTP������';
comment on column T_DOC_PAGES.pic_path_ftp
  is '���·���������FTP������';
comment on column T_DOC_PAGES.md5_code
  is 'MD5��';
comment on column T_DOC_PAGES.operator
  is '������';
comment on column T_DOC_PAGES.insert_time
  is '���ʱ��';
comment on column T_DOC_PAGES.last_modify_time
  is '���һ���޸�����';
comment on column T_DOC_PAGES.scan_no
  is 'ɨ����';
comment on column T_DOC_PAGES.doc_key
  is '�ļ���Կ�������';
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
  is '�����ļ��ϴ����ر�';
comment on column T_DOC_UPDOWN.doc_name
  is '�ļ�����';
comment on column T_DOC_UPDOWN.doc_type
  is '�ĵ����� U��upload D��download O��other';
comment on column T_DOC_UPDOWN.doc_make_time
  is '����ʱ��';
comment on column T_DOC_UPDOWN.doc_maker
  is '�����߻����޸���';
comment on column T_DOC_UPDOWN.doc_modify_time
  is '�޸�ʱ��';
comment on column T_DOC_UPDOWN.doc_suffix
  is '�ļ���׺';
comment on column T_DOC_UPDOWN.doc_path
  is '�ļ�·��';
comment on column T_DOC_UPDOWN.host_name
  is '�ļ�������';
comment on column T_DOC_UPDOWN.down_times
  is '���ش���';
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
  is 'NULL-���ʾMSG�ڵ�ĸ��ڵ� 0-��ʾDTO�ĸ��ڵ�';
comment on column T_TEMP_NODE.node_id
  is '�ڵ�ID���޸�ʱ��IDΪT_DEF_MSG_NODE�е�ID';
comment on column T_TEMP_NODE.node_code
  is '����';
comment on column T_TEMP_NODE.node_name
  is '����';
comment on column T_TEMP_NODE.son_node_type
  is '�ӽڵ����� 1Ϊ���ӽڵ� �������ӽڵ�';
comment on column T_TEMP_NODE.son_node_content
  is '�ӽڵ�����';

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
  is '��ʱ�ڵ����Ա�';
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
  is '��ʱ�ڵ���������ڴ����ӽڵ��SQL����';
comment on column T_TEMP_NODE_PARAM.id
  is 'ID';
comment on column T_TEMP_NODE_PARAM.node_id
  is '�ڵ�ID';
comment on column T_TEMP_NODE_PARAM.param_name
  is '��������';
comment on column T_TEMP_NODE_PARAM.param_value
  is '����ֵ��Ĭ��';
comment on column T_TEMP_NODE_PARAM.param_type
  is '��������';
comment on column T_TEMP_NODE_PARAM.param_code
  is '��������';
comment on column T_TEMP_NODE_PARAM.param_value_type
  is '����ֵ����';
comment on column T_TEMP_NODE_PARAM.param_sub_type
  is '������������ 0 ϵͳĬ�� 1 ΪSQL�Բ���';

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
  is 'ҵ����ˮ�ţ���ACTION_TRACE��';
comment on column T_DEF_ACTION_RETURN.plat_com
  is '�������� ��PLAT_COM��ID��';
comment on column T_DEF_ACTION_RETURN.buss_type
  is 'ҵ������ ��ACTION_TRACE����ͬ';
comment on column T_DEF_ACTION_RETURN.sub_buss_type
  is 'ҵ������ ��ACTION_TRACE����ͬ';
comment on column T_DEF_ACTION_RETURN.status
  is 'ҵ��״̬���Ƿ�ɹ����յ�';
comment on column T_DEF_ACTION_RETURN.data_status
  is 'ҵ����״̬';
comment on column T_DEF_ACTION_RETURN.check_status
  is 'У��״̬������У������ʹ��';
comment on column T_DEF_ACTION_RETURN.query_no
  is '��ѯ�룬�����Ǽ�����';
comment on column T_DEF_ACTION_RETURN.return_msg
  is '������Ϣ';
comment on column T_DEF_ACTION_RETURN.erro_ratio
  is '������';
comment on column T_DEF_ACTION_RETURN.err_info_path
  is '�����ļ�·���������Ǽ�����';
comment on column T_DEF_ACTION_RETURN.return_code
  is '������';
comment on column T_DEF_ACTION_RETURN.return_data
  is '�������ݣ�����xml�洢';
comment on column T_DEF_ACTION_RETURN.data_type
  is '�������ͣ�0-���账�� 1-��Ҫ����';
comment on column T_DEF_ACTION_RETURN.data_flag
  is '״̬��ʶ��0-���账�� 1-�ȴ����� 2-���ڴ��� 9-�������';
comment on column T_DEF_ACTION_RETURN.operator
  is '������';
comment on column T_DEF_ACTION_RETURN.insert_time
  is '�������';
comment on column T_DEF_ACTION_RETURN.last_modify_time
  is '���һ���޸�����';
comment on column T_DEF_ACTION_RETURN.es_status
  is '״̬��ʶ��1-��Ч 2-ɾ�� 0-��Ч';
comment on column T_DEF_ACTION_RETURN.standby1
  is '�����ֶ�1';
comment on column T_DEF_ACTION_RETURN.standby2
  is '�����ֶ�2';
comment on column T_DEF_ACTION_RETURN.standby3
  is '�����ֶ�3';
comment on column T_DEF_ACTION_RETURN.standby4
  is '�����ֶ�4';
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
  is 'SQL�������鶨���';
-- Add comments to the columns 
comment on column T_DEF_SQL_INFO.id
  is '����ID';
comment on column T_DEF_SQL_INFO.sql_id
  is '��T_DEF_SQL�е�ID����';
comment on column T_DEF_SQL_INFO.sql_type
  is '��T_DEF_SQL�е�TYPE����';
comment on column T_DEF_SQL_INFO.sql_info
  is 'SQL��ϸ����';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_DEF_SQL_INFO
  add constraint PK_T_DEF_SQLINFO primary key (ID);
