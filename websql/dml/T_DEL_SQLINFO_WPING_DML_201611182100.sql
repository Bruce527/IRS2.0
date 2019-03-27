/**
 功能: 更新保单登记报送切面接口
 作者: 王萍
 日期: 2016-11-18
**/
CREATE OR REPLACE PROCEDURE PROC_999 IS  V_ID NUMBER :=999; V_SQL_ID NUMBER :=999; V_SQL_TYPE VARCHAR(20) := 'Q'; V_SQL_INFO CLOB :='SELECT batchNo,bussFlag,transType,batchType,startDate,endDate,
bussNo,bussType,companyCode,serialNo,dateSerialNo,currentDate,currentTime
FROM 
(SELECT batchNo AS batchNo,
       STATEFLAG AS bussFlag,
       TRANSTYPE AS transType,
       TRANSTYPE AS batchType,
       MIN(TRANSDATE) AS startDate,
       MAX(TRANSDATE) AS endDate,
      ''#{bussNo}'' AS bussNo,
      ''#{bussType}'' AS bussType,
      ''#{companyCode}'' AS companyCode,
      ''#{serialNo}'' AS serialNo,
      ''#{dateSerialNo}'' AS dateSerialNo,
      ''#{currentDate}'' AS currentDate,
      ''#{currentTime}'' AS currentTime
 FROM T_PRP_LCPOLTRANSACTION
WHERE BATCHNO IS NOT NULL
  AND to_char(TRANSDATE,''yyyy-mm-dd'')
  BETWEEN (CASE WHEN (SELECT ''#{startDate}'' FROM dual) IS NULL THEN to_char(TRANSDATE,''yyyy-mm-dd'') ELSE to_char(to_date(''#{startDate}'',''yyyy-mm-dd''),''yyyy-mm-dd'') END)
      AND (CASE WHEN (SELECT ''#{endDate}'' FROM dual) IS NULL THEN to_char(TRANSDATE,''yyyy-mm-dd'') ELSE to_char(to_date(''#{endDate}'',''yyyy-mm-dd''),''yyyy-mm-dd'') END)
  AND batchno = (CASE WHEN (SELECT ''#{batchNo}'' FROM dual) IS NULL THEN batchno ELSE ''#{batchNo}'' END)
  AND policyNo = (CASE WHEN (SELECT ''#{bussNo}'' FROM dual) IS NULL THEN policyNo ELSE ''#{bussNo}'' END)
  AND transType IN (#{groupRela})
  AND stateflag IN (#{statusRela})
  AND stateflag IS NOT NULL
  AND transType IS NOT NULL
GROUP BY BATCHNO,STATEFLAG,transType
ORDER BY batchno DESC
) t WHERE  ROWNUM =
(CASE WHEN (SELECT ''#{bussType}'' FROM dual) IN (''SummaryCheckResultQuery'',''SummaryCheck'') THEN  1
 ELSE  ROWNUM END)'; 
 BEGIN  
   DELETE FROM T_DEF_SQL_INFO WHERE ID = 999; 
   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);
 END;
/
EXECUTE PROC_999;
DROP  PROCEDURE PROC_999;
