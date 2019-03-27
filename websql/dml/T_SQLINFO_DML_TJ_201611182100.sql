/**
功能: 修改报送SQL
作者: 唐杰
版本: 201611182100
日期: 2016-11-18
**/

   update T_DEF_SQL_info
   set SQl_info = replace(sql_info,
                          'WHERE B.BATCHNO = ''#{batchNo}''',
                          'where b.transdate  BETWEEN TO_DATE(''#{startDate}'',''yyyy-mm-dd'') 
                          AND TO_DATE(''#{endDate}'',''yyyy-mm -dd '')')
 where sql_id > 12795
   and sql_id < 12856 and  SQL_INFO like '%B.BATCHNO%';
   
   
    update T_DEF_SQL_info
   set SQl_info = replace(sql_info,
                          'WHERE b.batchno = ''#{batchNo}''',
                          'where b.transdate  BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') 
                          AND TO_DATE(''#{endDate}'',''yyyy-mm-dd '')')
 where sql_id > 12795
   and sql_id < 12856 and  SQL_INFO like '%b.batchno%';
   commit;