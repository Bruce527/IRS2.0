create or replace package pkg_gyas_icp_util is

  -- author  : gyas-itpingw
  -- created : 2016/11/24 19:27:23
  -- purpose : gyas_icp_pacakge

   -- 定义包体：类似于java方法
   procedure chg_seq_start_no(seq_name in varchar2,seq_start_no in number);

end pkg_gyas_icp_util;
/
create or replace package body pkg_gyas_icp_util is
  --创建包体：类似于java方法
 procedure chg_seq_start_no(seq_name in varchar2,seq_start_no in number) as
   BEGIN
      --删除
      for i in (SELECT 'drop sequence '||sequence_name as seq_drop_ddl
       from user_sequences where sequence_name = upper(seq_name)) loop
        execute immediate i.seq_drop_ddl;
      end loop;
      --新建
      for i in (SELECT 'create sequence '||sequence_name||
        ' minvalue '||min_value||
        ' maxvalue '||max_value||
        ' start with '||1||
        ' increment by '||increment_by ||
        ' cache '||cache_size as seq_create_ddl
        from user_sequences where sequence_name = upper(seq_name)) loop
        execute immediate i.seq_create_ddl;
      end loop;
  end;
end pkg_gyas_icp_util;
/
