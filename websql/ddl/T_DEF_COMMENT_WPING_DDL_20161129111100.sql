/**
 ����: ���±�T_DEF_ACTION_TRACE��T_DEF_ACTION_RETURN ��˵��
 ����: 2016-11-29
 ����: ��Ƽ
**/
-- Add comments to the table T_DEF_ACTION_TRACE 
comment on table T_DEF_ACTION_TRACE
  is '��̬��¼�켣��';
-- Add comments to the columns 
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
  is '����ҵ����ˮ�ţ���ACTION_RETURN����';
comment on column T_DEF_ACTION_TRACE.action_date
  is '����ҵ�����ڣ���ǰ������������';
comment on column T_DEF_ACTION_TRACE.action_all_count
  is '����ҵ���¼����';
comment on column T_DEF_ACTION_TRACE.action_suc_count
  is '����ҵ��ɹ���¼';
comment on column T_DEF_ACTION_TRACE.action_type
  is '����ҵ�����ͣ��ӿ�';
comment on column T_DEF_ACTION_TRACE.action_msg
  is '����ҵ����ʾ��Ϣ���ӿڽ�����Ϣ';
comment on column T_DEF_ACTION_TRACE.data_msg
  is '������Ϣ��ʧ�ܱ���ɹ��������ɹ�';
comment on column T_DEF_ACTION_TRACE.data_status
  is '����״̬ 1-�ɹ� 0-ʧ��';
comment on column T_DEF_ACTION_TRACE.es_status
  is '������¼״̬��ʶ 1 - ��Ч 0 - ��Ч 2 - ɾ��';
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
  is '״̬��ʶ������ҵ��״̬��ʾ';
comment on column T_DEF_ACTION_TRACE.start_date
  is '��ʼ���ڣ�����ҵ����ʼ����';
comment on column T_DEF_ACTION_TRACE.end_date
  is '�������ڣ�����ҵ���������';
comment on column T_DEF_ACTION_TRACE.action_time
  is '����ʵʱʱ��';

-- Add comments to the T_DEF_ACTION_RETURN columns 
comment on column T_DEF_ACTION_RETURN.action_no
  is 'ҵ����ˮ�ţ���ACTION_TRACE��';
comment on column T_DEF_ACTION_RETURN.plat_com
  is '�������� ��PLAT_COM��ID��';
comment on column T_DEF_ACTION_RETURN.buss_type
  is 'ҵ������ ��ACTION_TRACE����ͬ';
comment on column T_DEF_ACTION_RETURN.sub_buss_type
  is 'ҵ������ ��ACTION_TRACE����ͬ';
comment on column T_DEF_ACTION_RETURN.status
  is 'ҵ��״̬���Ƿ�ɹ����յ���������ƽ̨������ʶ';
comment on column T_DEF_ACTION_RETURN.data_status
  is 'ҵ����״̬���Ƿ���ɹ��������Ǽ��ã�';
comment on column T_DEF_ACTION_RETURN.check_status
  is 'У��״̬������У������ʹ�ã������Ǽ��������ã�';
comment on column T_DEF_ACTION_RETURN.query_no
  is '��ѯ�룬�����룬��ƽ̨����ʱƽ̨����';
comment on column T_DEF_ACTION_RETURN.return_msg
  is '������Ϣ����ƽ̨����ʱƽ̨����';
comment on column T_DEF_ACTION_RETURN.erro_ratio
  is '�����ʣ����δ�������ʣ������Ǽ��ã�';
comment on column T_DEF_ACTION_RETURN.err_info_path
  is '�����ļ�·���������Ǽ��ã�';
comment on column T_DEF_ACTION_RETURN.return_code
  is '�����룬ƽ̨���ر���';
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