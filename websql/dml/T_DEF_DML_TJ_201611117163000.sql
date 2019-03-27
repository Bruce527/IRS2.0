update  T_DEF_SQL_INFO  set sql_info=replace(sql_info,'DetailResultUpload','DetailResultQuery') where sql_id=11388;
update   t_Def_Code_Dict  set  code_status_rela='''6'''  where  code='DetailUpload';                
update   t_Def_Code_Dict  set  code_status_rela='''6'',''6W''' where  code='DetailResultQuery';
update T_DEF_MSG_NODE set node_code='PDL',
                          node_name='PDL',
                          node_TEXT='PDL'  where NODE_id in('19288','19279');
                          
commit;