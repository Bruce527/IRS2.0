/**
 功能: QRTZ 初始化
 作者: 王萍
 版本: 201611112300
 日期: 2016-11-11
**/
prompt PL/SQL Developer import file
prompt Created on 2016年11月14日 by gyas-itpingw
set feedback off
set define off
--drop index 
prompt droping indexs ...
DROP INDEX IDX_QRTZ_T_NEXT_FIRE_TIME;
DROP INDEX IDX_QRTZ_T_NFT_ST;
DROP INDEX IDX_QRTZ_T_STATE;
DROP INDEX IDX_QRTZ_T_VOLATILE;
DROP INDEX IDX_QRTZ_FT_JOB_GROUP;
DROP INDEX IDX_QRTZ_FT_JOB_NAME;
DROP INDEX IDX_QRTZ_FT_JOB_REQ_RECOVERY;
DROP INDEX IDX_QRTZ_FT_JOB_STATEFUL;
DROP INDEX IDX_QRTZ_FT_TRIG_GROUP;
DROP INDEX IDX_QRTZ_FT_TRIG_INST_NAME;
DROP INDEX IDX_QRTZ_FT_TRIG_NAME;
DROP INDEX IDX_QRTZ_FT_TRIG_NM_GP;
DROP INDEX IDX_QRTZ_FT_TRIG_VOLATILE;
--drop table
prompt droping tables ...
drop table QRTZ_TRIGGER_LOG;
drop table QRTZ_SIMPLE_TRIGGERS;
drop table QRTZ_CALENDARS;
drop table QRTZ_CRON_TRIGGERS;
drop table QRTZ_FIRED_TRIGGERS;
drop table QRTZ_JOB_LISTENERS;
drop table QRTZ_LOCKS;
drop table QRTZ_PAUSED_TRIGGER_GRPS;
drop table QRTZ_SCHEDULER_STATE;
drop TABLE QRTZ_TRIGGER_LISTENERS;
drop table QRTZ_BLOB_TRIGGERS;
drop table QRTZ_TRIGGERS;
drop table QRTZ_JOB_DETAILS;

prompt create table QRTZ_JOB_DETAILS ...
-- Create table QRTZ_JOB_DETAILS
create table QRTZ_JOB_DETAILS
(
  job_name          VARCHAR2(200) not null,
  job_group         VARCHAR2(200) not null,
  description       VARCHAR2(250),
  job_class_name    VARCHAR2(250) not null,
  is_durable        VARCHAR2(1) not null,
  is_volatile       VARCHAR2(1) not null,
  is_stateful       VARCHAR2(1) not null,
  requests_recovery VARCHAR2(1) not null,
  job_data          BLOB
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table QRTZ_JOB_DETAILS
  add primary key (JOB_NAME, JOB_GROUP);
-- Create/Recreate indexes 
create index IDX_QRTZ_J_REQ_RECOVERY on QRTZ_JOB_DETAILS (REQUESTS_RECOVERY);

prompt create table QRTZ_TRIGGERS ...
-- Create table QRTZ_TRIGGERS
create table QRTZ_TRIGGERS
(
  trigger_name   VARCHAR2(200) not null,
  trigger_group  VARCHAR2(200) not null,
  job_name       VARCHAR2(200) not null,
  job_group      VARCHAR2(200) not null,
  is_volatile    VARCHAR2(1) not null,
  description    VARCHAR2(250),
  next_fire_time NUMBER(13),
  prev_fire_time NUMBER(13),
  priority       NUMBER(13),
  trigger_state  VARCHAR2(16) not null,
  trigger_type   VARCHAR2(8) not null,
  start_time     NUMBER(13) not null,
  end_time       NUMBER(13),
  calendar_name  VARCHAR2(200),
  misfire_instr  NUMBER(2),
  job_data       BLOB
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table QRTZ_TRIGGERS
  add primary key (TRIGGER_NAME, TRIGGER_GROUP);
alter table QRTZ_TRIGGERS
  add foreign key (JOB_NAME, JOB_GROUP)
  references QRTZ_JOB_DETAILS (JOB_NAME, JOB_GROUP);
-- Create/Recreate indexes 
create index IDX_QRTZ_T_NEXT_FIRE_TIME on QRTZ_TRIGGERS (NEXT_FIRE_TIME);
create index IDX_QRTZ_T_NFT_ST on QRTZ_TRIGGERS (NEXT_FIRE_TIME, TRIGGER_STATE);
create index IDX_QRTZ_T_STATE on QRTZ_TRIGGERS (TRIGGER_STATE);
create index IDX_QRTZ_T_VOLATILE on QRTZ_TRIGGERS (IS_VOLATILE);

prompt create table QRTZ_BLOB_TRIGGERS ...
-- Create table QRTZ_BLOB_TRIGGERS
create table QRTZ_BLOB_TRIGGERS
(
  trigger_name  VARCHAR2(200) not null,
  trigger_group VARCHAR2(200) not null,
  blob_data     BLOB
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table QRTZ_BLOB_TRIGGERS
  add primary key (TRIGGER_NAME, TRIGGER_GROUP);
alter table QRTZ_BLOB_TRIGGERS
  add foreign key (TRIGGER_NAME, TRIGGER_GROUP)
  references QRTZ_TRIGGERS (TRIGGER_NAME, TRIGGER_GROUP);
  

prompt create table QRTZ_TRIGGER_LOG ...
-- Create table QRTZ_TRIGGER_LOG
create table QRTZ_TRIGGER_LOG
(
  id               VARCHAR2(50 CHAR) not null,
  trigger_name     VARCHAR2(50 CHAR) not null,
  job_group        VARCHAR2(50 CHAR) not null,
  job_name         VARCHAR2(50 CHAR) not null,
  job_desc         VARCHAR2(100 CHAR),
  start_time       VARCHAR2(50 CHAR),
  end_time         VARCHAR2(50 CHAR),
  execute_type     NUMBER(1),
  run_status       NUMBER(1),
  log_flag         NUMBER(1),
  log_msg          VARCHAR2(200 CHAR),
  rc_status        NUMBER(1),
  insert_time      VARCHAR2(50 CHAR),
  last_modify_time VARCHAR2(50 CHAR),
  operator         VARCHAR2(50)
);
-- Add comments to the table 
comment on table QRTZ_TRIGGER_LOG
  is '批处理日志表';
-- Add comments to the columns 
comment on column QRTZ_TRIGGER_LOG.job_name
  is '实现ID';
comment on column QRTZ_TRIGGER_LOG.execute_type
  is '执行方式 0-手动 1-自动';
comment on column QRTZ_TRIGGER_LOG.run_status
  is '运行状态：0-停止 1-等待 2-执行中 9-执行完毕';
comment on column QRTZ_TRIGGER_LOG.log_flag
  is '日志标识 1-正常 0-异常';
comment on column QRTZ_TRIGGER_LOG.rc_status
  is '是否有效 1-有效 0-无效 一个业务号ID只存在一个有效的记录';
-- Create/Recreate primary, unique and foreign key constraints 
alter table QRTZ_TRIGGER_LOG
  add constraint PK_QRTZ_TRIGER_LOG primary key (ID, TRIGGER_NAME, JOB_NAME);


prompt create table QRTZ_SIMPLE_TRIGGERS ...
-- Create table QRTZ_SIMPLE_TRIGGERS
create table QRTZ_SIMPLE_TRIGGERS
(
  trigger_name    VARCHAR2(200) not null,
  trigger_group   VARCHAR2(200) not null,
  repeat_count    NUMBER(7) not null,
  repeat_interval NUMBER(12) not null,
  times_triggered NUMBER(10) not null
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table QRTZ_SIMPLE_TRIGGERS
  add primary key (TRIGGER_NAME, TRIGGER_GROUP);
alter table QRTZ_SIMPLE_TRIGGERS
  add foreign key (TRIGGER_NAME, TRIGGER_GROUP)
  references QRTZ_TRIGGERS (TRIGGER_NAME, TRIGGER_GROUP);

prompt create table QRTZ_SCHEDULER_STATE ...  
-- Create table QRTZ_SCHEDULER_STATE
create table QRTZ_SCHEDULER_STATE
(
  instance_name     VARCHAR2(200) not null,
  last_checkin_time NUMBER(13) not null,
  checkin_interval  NUMBER(13) not null
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table QRTZ_SCHEDULER_STATE
  add primary key (INSTANCE_NAME);

prompt create table QRTZ_PAUSED_TRIGGER_GRPS ...  
-- Create table QRTZ_PAUSED_TRIGGER_GRPS
create table QRTZ_PAUSED_TRIGGER_GRPS
(
  trigger_group VARCHAR2(200) not null
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table QRTZ_PAUSED_TRIGGER_GRPS
  add primary key (TRIGGER_GROUP);


prompt create table QRTZ_LOCKS ...  
-- Create table QRTZ_LOCKS
create table QRTZ_LOCKS
(
  lock_name VARCHAR2(40) not null
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table QRTZ_LOCKS
  add primary key (LOCK_NAME);

prompt create table QRTZ_JOB_LISTENERS ...  
-- Create table QRTZ_JOB_LISTENERS
create table QRTZ_JOB_LISTENERS
(
  job_name     VARCHAR2(200) not null,
  job_group    VARCHAR2(200) not null,
  job_listener VARCHAR2(200) not null
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table QRTZ_JOB_LISTENERS
  add primary key (JOB_NAME, JOB_GROUP, JOB_LISTENER);
alter table QRTZ_JOB_LISTENERS
  add foreign key (JOB_NAME, JOB_GROUP)
  references QRTZ_JOB_DETAILS (JOB_NAME, JOB_GROUP);


prompt create table QRTZ_FIRED_TRIGGERS ... 
-- Create table QRTZ_FIRED_TRIGGERS
create table QRTZ_FIRED_TRIGGERS
(
  entry_id          VARCHAR2(95) not null,
  trigger_name      VARCHAR2(200) not null,
  trigger_group     VARCHAR2(200) not null,
  is_volatile       VARCHAR2(1) not null,
  instance_name     VARCHAR2(200) not null,
  fired_time        NUMBER(13) not null,
  priority          NUMBER(13) not null,
  state             VARCHAR2(16) not null,
  job_name          VARCHAR2(200),
  job_group         VARCHAR2(200),
  is_stateful       VARCHAR2(1),
  requests_recovery VARCHAR2(1)
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table QRTZ_FIRED_TRIGGERS
  add primary key (ENTRY_ID);
-- Create/Recreate indexes 

create index IDX_QRTZ_FT_JOB_GROUP on QRTZ_FIRED_TRIGGERS (JOB_GROUP);
create index IDX_QRTZ_FT_JOB_NAME on QRTZ_FIRED_TRIGGERS (JOB_NAME);
create index IDX_QRTZ_FT_JOB_REQ_RECOVERY on QRTZ_FIRED_TRIGGERS (REQUESTS_RECOVERY);
create index IDX_QRTZ_FT_JOB_STATEFUL on QRTZ_FIRED_TRIGGERS (IS_STATEFUL);
create index IDX_QRTZ_FT_TRIG_GROUP on QRTZ_FIRED_TRIGGERS (TRIGGER_GROUP);
create index IDX_QRTZ_FT_TRIG_INST_NAME on QRTZ_FIRED_TRIGGERS (INSTANCE_NAME);
create index IDX_QRTZ_FT_TRIG_NAME on QRTZ_FIRED_TRIGGERS (TRIGGER_NAME);
create index IDX_QRTZ_FT_TRIG_NM_GP on QRTZ_FIRED_TRIGGERS (TRIGGER_NAME, TRIGGER_GROUP);
create index IDX_QRTZ_FT_TRIG_VOLATILE on QRTZ_FIRED_TRIGGERS (IS_VOLATILE);


prompt create table QRTZ_CRON_TRIGGERS ... 
-- Create table QRTZ_CRON_TRIGGERS
create table QRTZ_CRON_TRIGGERS
(
  trigger_name    VARCHAR2(200) not null,
  trigger_group   VARCHAR2(200) not null,
  cron_expression VARCHAR2(120) not null,
  time_zone_id    VARCHAR2(80)
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table QRTZ_CRON_TRIGGERS
  add primary key (TRIGGER_NAME, TRIGGER_GROUP);
alter table QRTZ_CRON_TRIGGERS
  add foreign key (TRIGGER_NAME, TRIGGER_GROUP)
  references QRTZ_TRIGGERS (TRIGGER_NAME, TRIGGER_GROUP);

prompt create table QRTZ_CALENDARS ...   
-- Create table QRTZ_CALENDARS
create table QRTZ_CALENDARS
(
  calendar_name VARCHAR2(200) not null,
  calendar      BLOB not null
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table QRTZ_CALENDARS
  add primary key (CALENDAR_NAME);

prompt create table QRTZ_TRIGGER_LISTENERS ...   
-- Create table
create table QRTZ_TRIGGER_LISTENERS
(
  trigger_name     VARCHAR2(200) not null,
  trigger_group    VARCHAR2(200) not null,
  trigger_listener VARCHAR2(200) not null
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table QRTZ_TRIGGER_LISTENERS
  add primary key (TRIGGER_NAME, TRIGGER_GROUP, TRIGGER_LISTENER);
alter table QRTZ_TRIGGER_LISTENERS
  add foreign key (TRIGGER_NAME, TRIGGER_GROUP)
  references QRTZ_TRIGGERS (TRIGGER_NAME, TRIGGER_GROUP);

prompt create table QRTZ_TABLES OVER