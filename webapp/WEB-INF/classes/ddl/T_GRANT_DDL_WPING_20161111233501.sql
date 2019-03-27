
CREATE OR REPLACE PACKAGE pkg_gyas_grant_infra IS
  -- Author  : ZHIQIANGZHAO
  -- Created : 02-°ËÔÂ-16 16:16:21
  -- Purpose : grant role1 to role2 and create synonyms

  --1¡¢grant select/insert/delete/update to app
  procedure p_bulk_grant_to_app_s1(i_owner in varchar2, i_app in varchar2);
   --2¡¢create synonyms 
  procedure p_bulk_create_syn_for_app_s2(i_owner in varchar2,i_app in varchar2);

end pkg_gyas_grant_infra;
/
CREATE OR REPLACE PACKAGE BODY pkg_gyas_grant_infra IS
  procedure p_bulk_grant_to_app_s1(i_owner in varchar2, i_app in varchar2) as
  begin
    --grant select/insert/delete/update to app
    for i in (select 'grant select,insert,update,delete on ' || owner || '.' ||
                     table_name || ' to ' || i_app as sqltext1
                from all_tables t
               where t.owner = upper(i_owner)
                 and t.table_name not like 'attrep_%') loop
      execute immediate i.sqltext1;
    end loop;
    --grant sequence to app
    for j in (select 'grant select on ' || sequence_owner || '.' ||
                     sequence_name || ' to ' || i_app as sqltext2
                from all_sequences t
               where t.sequence_owner = upper(i_owner)) loop
      execute immediate j.sqltext2;
    end loop;
    --grant procedure/package/function/type to app
    for k in (select 'grant execute on ' || owner || '.' || object_name ||
                     ' to ' || i_app as sqltext3
                from all_objects t
               where t.owner = upper(i_owner)
                 and object_type in
                     ('PROCEDURE', 'PACKAGE', 'FUNCTION', 'TYPE')) loop
      execute immediate k.sqltext3;
    end loop;
    --grant view to app
    for l in (select 'grant select on ' || owner || '.' || object_name ||
                     ' to ' || i_app as sqltext4
                from all_objects t
               where t.owner = upper(i_owner)
                 and object_type in ('VIEW')) loop
      execute immediate l.sqltext4;
    end loop;
    --grant privs granted by other users to app
    for m in (select 'grant ' || t.privilege || ' on ' || table_schema || '.' ||
                     table_name || ' to ' || i_app as sqltext5
                from all_tab_privs t
               where grantee = upper(i_owner)) loop
      execute immediate m.sqltext5;
    end loop;
  end;

  --create synonyms     
  procedure p_bulk_create_syn_for_app_s2(i_owner in varchar2,
                                         i_app   in varchar2) as
  begin
    for i in (select 'create or replace synonym ' || i_app || '.' ||
                     object_name || ' for ' || owner || '.' || object_name as sqltext
                from all_objects
               where owner = upper(i_owner)
                 and object_type in ('PROCEDURE',
                                     'PACKAGE',
                                     'FUNCTION',
                                     'TYPE',
                                     'SEQUENCE',
                                     'TABLE',
                                     'VIEW')) loop
      execute immediate i.sqltext;
    end loop;
    --synonyms for owner's synonyms
    for j in (select 'create or replace synonym ' || i_app || '.' ||
                     synonym_name || ' for ' || table_owner ||
                     decode(table_owner, '', '', '.') || table_name ||
                     decode(db_link, '', '', '@' || db_link) as sqltext2
                from all_synonyms
               where owner = upper(i_owner)) loop
      execute immediate j.sqltext2;
    end loop;
  end;
  
end pkg_gyas_grant_infra;
/