/**
功能: 初始化QRTZ_LOCKS
作者: 王萍
版本: 201611112300
日期: 2016-11-11
**/

DELETE FROM qrtz_trigger_log;
DELETE FROM qrtz_simple_triggers;
DELETE FROM qrtz_blob_triggers;
DELETE FROM qrtz_cron_triggers;
DELETE FROM qrtz_fired_triggers;
DELETE FROM qrtz_triggers;
DELETE FROM qrtz_job_details;
delete from QRTZ_LOCKS where lock_name in ('CALENDAR_ACCESS','JOB_ACCESS','MISFIRE_ACCESS','STATE_ACCESS','TRIGGER_ACCESS');
insert into QRTZ_LOCKS (lock_name) values ('CALENDAR_ACCESS');
insert into QRTZ_LOCKS (lock_name) values ('JOB_ACCESS');
insert into QRTZ_LOCKS (lock_name) values ('MISFIRE_ACCESS');
insert into QRTZ_LOCKS (lock_name) values ('STATE_ACCESS');
insert into QRTZ_LOCKS (lock_name) values ('TRIGGER_ACCESS');
commit;

