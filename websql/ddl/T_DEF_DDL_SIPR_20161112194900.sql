CREATE OR REPLACE PROCEDURE PROC_12424 IS   V_ID NUMBER :=12424;  V_SQL_ID NUMBER :=12424;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LJAPAY A
   SET A.MANAGECOM = (CASE
                       WHEN A.MANAGECOM IN
                            (SELECT BASIC_CODE
                               FROM T_DEF_CODE_MAPPING
                              WHERE CODE_TYPE = ''managecom''
                              AND COM_ID = ''1'') THEN
                        (SELECT TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE B.CODE_TYPE = ''managecom''
                            AND A.MANAGECOM = B.BASIC_CODE
                            AND B.COM_ID = ''1'')
                       ELSE
                        A.MANAGECOM
                     END),
       A.BANKCODE = (CASE
                      WHEN A.BANKCODE IN
                           (SELECT BASIC_CODE
                              FROM T_DEF_CODE_MAPPING
                             WHERE CODE_TYPE = ''bankcode''
                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''bankcode''
                           AND A.BANKCODE = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.BANKCODE
                    END),
       A.CERTTYPE = (CASE
                      WHEN A.CERTTYPE IN
                           (SELECT BASIC_CODE
                              FROM T_DEF_CODE_MAPPING
                             WHERE CODE_TYPE = ''certtype''
                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''certtype''
                           AND A.CERTTYPE = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.CERTTYPE
                    END)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12424;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12449 IS   V_ID NUMBER :=12449;  V_SQL_ID NUMBER :=12449;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_CHG_TRANS_ID_MAP a
   set a.transno = (case
                   
                     when ((select count(companycode)
                              from T_PRP_chg_trans_id_map
                             where dateserial = to_char(sysdate, ''yyyymmdd'')
                               and companycode = ''000000'') <> 0 and
                          companycode = ''000000'' and (select count(companycode)
                              from T_PRP_chg_trans_id_map
                             where dateserial = to_char(sysdate, ''yyyymmdd'')
                               and companycode = ''000031'')<>0) then
                      (''000031'' || to_char(SYSDATE, ''yyyymmdd'') ||
                      lpad(((select to_number(substr(max(TRANSNO), 15))
                                from T_PRP_chg_trans_id_map
                               where dateserial = to_char(sysdate, ''yyyymmdd'')
                                 and companycode = ''000031'') +
                            to_number(substr(a.TRANSNO, 15))),
                            ''10'',
                            ''0''))
                     else
                      a.transno
                   end),
       a.companycode = ''000031''
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12449;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10927 IS   V_ID NUMBER :=10927;  V_SQL_ID NUMBER :=10951;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LASALES A
   SET A.COMPANYCODE = case
                         when (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.COMPANYCODE = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''companycode''
                                  AND B.COM_ID = 1) is not null then
                          (SELECT B.TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE A.COMPANYCODE = B.BASIC_CODE
                              AND B.CODE_TYPE = ''companycode''
                              AND B.COM_ID = 1)
                         else
                          a.companycode
                       end,
       
       A.SEX = case
                 when (SELECT B.TARGET_CODE
                         FROM T_DEF_CODE_MAPPING B
                        WHERE A.SEX = B.BASIC_CODE
                          AND B.CODE_TYPE = ''sex''
                          AND B.COM_ID = 1) is not null then
                  (SELECT B.TARGET_CODE
                     FROM T_DEF_CODE_MAPPING B
                    WHERE A.SEX = B.BASIC_CODE
                      AND B.CODE_TYPE = ''sex''
                      AND B.COM_ID = 1)
                 else
                  a.sex
               end,
       
       A.OFFICEWORKFLAG = case
                            when (SELECT B.TARGET_CODE
                                    FROM T_DEF_CODE_MAPPING B
                                   WHERE A.OFFICEWORKFLAG = B.BASIC_CODE
                                     AND B.CODE_TYPE = ''officeworkflag''
                                     AND B.COM_ID = 1) is not null then
                             (SELECT B.TARGET_CODE
                                FROM T_DEF_CODE_MAPPING B
                               WHERE A.OFFICEWORKFLAG = B.BASIC_CODE
                                 AND B.CODE_TYPE = ''officeworkflag''
                                 AND B.COM_ID = 1)
                            else
                             a.officeworkflag
                          end,
       
       A.AGENTSIGNFLAG = case
                           when (SELECT B.TARGET_CODE
                                   FROM T_DEF_CODE_MAPPING B
                                  WHERE A.AGENTSIGNFLAG = B.BASIC_CODE
                                    AND B.CODE_TYPE = ''agentsignflag''
                                    AND B.COM_ID = 1) is not null then
                            (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.AGENTSIGNFLAG = B.BASIC_CODE
                                AND B.CODE_TYPE = ''agentsignflag''
                                AND B.COM_ID = 1)
                           else
                            a.agentsignflag
                         end,
       
       A.FULLTIMEFLAG = case
                          when (SELECT B.TARGET_CODE
                                  FROM T_DEF_CODE_MAPPING B
                                 WHERE A.FULLTIMEFLAG = B.BASIC_CODE
                                   AND B.CODE_TYPE = ''fulltimeflag''
                                   AND B.COM_ID = 1) is not null then
                           (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.FULLTIMEFLAG = B.BASIC_CODE
                               AND B.CODE_TYPE = ''fulltimeflag''
                               AND B.COM_ID = 1)
                          else
                           a.fulltimeflag
                        end,
       
       A.SALESVCFLAG = case
                         when (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.SALESVCFLAG = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''salesvcflag''
                                  AND B.COM_ID = 1) is not null then
                          (SELECT B.TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE A.SALESVCFLAG = B.BASIC_CODE
                              AND B.CODE_TYPE = ''salesvcflag''
                              AND B.COM_ID = 1)
                         else
                          a.salesvcflag
                       end,
       
       A.MANAGECOM = case
                       when (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.MANAGECOM = B.BASIC_CODE
                                AND B.CODE_TYPE = ''managecom''
                                AND B.COM_ID = 1) is not null then
                        (SELECT B.TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE A.MANAGECOM = B.BASIC_CODE
                            AND B.CODE_TYPE = ''managecom''
                            AND B.COM_ID = 1)
                       else
                        a.managecom
                     end,
       
       A.AGENTCODE = case
                       when (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.AGENTCODE = B.BASIC_CODE
                                AND B.CODE_TYPE = ''agentcode''
                                AND B.COM_ID = 1) is not null then
                        (SELECT B.TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE A.AGENTCODE = B.BASIC_CODE
                            AND B.CODE_TYPE = ''agentcode''
                            AND B.COM_ID = 1)
                       else
                        a.agentcode
                     end,
       
       A.CERTTYPE = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.CERTTYPE = B.BASIC_CODE
                               AND B.CODE_TYPE = ''certtype''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.CERTTYPE = B.BASIC_CODE
                           AND B.CODE_TYPE = ''certtype''
                           AND B.COM_ID = 1)
                      else
                       a.certtype
                    end,
      A.TRANSACTIONNO = (CASE
                            WHEN A.TRANSACTIONNO IN
                                 (SELECT C.CHGID
                                    FROM T_PRP_CHG_TRANS_ID_MAP C
                                 ) THEN
                             (SELECT Max(C.TRANSNO)
                                FROM  T_PRP_CHG_TRANS_ID_MAP C
                                 WHERE A.TRANSACTIONNO = C.CHGID
                             )
                            ELSE
                             A.TRANSACTIONNO
                          END)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10927;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10930 IS   V_ID NUMBER :=10930;  V_SQL_ID NUMBER :=10954;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='SELECT DISTINCT
        pc.policy_chg_id as TransactionNo,
       ''000031'' AS COMPANYCODE,
       '''' AS GRPPOLICYNO,
       P.POLICY_NO AS POLICYNO,
       P.BRANCH_CODE AS MANAGECOM,
       PD.PD_PRODUCT_ID AS PRODUCTNO,
       pd.product_code ||
       (LPAD(row_number() over(partition BY p.policy_no,
                  pd.product_code order BY pd.product_code),
             3,
             0)) AS INSUACCNO,
       NVL(PA.ACCOUNT_TYPE, ''002'') AS ACCTYPE,
       (CASE
         WHEN pdpp.SV_Charge_Rate IS NOT NULL THEN
          pdpp.SV_Charge_Rate * PPP.FEE
         ELSE
          0
       END) AS ACCUMCOMMISSION,
       NVL((SELECT SUM(PPFD.AMOUNT)
             FROM ODS_STG.OFE_T_POL_PLAN_FUND_DISTRI PPFD
            WHERE PPFD.POLICY_ID = P.POLICY_ID
              AND PPFD.POLICY_PLAN_ID = PP.POLICY_PLAN_ID
              AND PPFD.DISTRIBUTE_CODE = ''AMC''),
           0) AS ACCUMMNGFEE,
       NVL((SELECT SUM(PPFD.AMOUNT)
             FROM ODS_STG.OFE_T_POL_PLAN_FUND_DISTRI PPFD
            WHERE PPFD.POLICY_ID = P.POLICY_ID
              AND PPFD.POLICY_PLAN_ID = PP.POLICY_PLAN_ID
              AND PPFD.DISTRIBUTE_CODE = ''COI''),
           0) AS ACCUMRISKPREMIUM,
       (CASE
         WHEN PA.INSERT_TIME IS NULL THEN
          pd.insert_time
         ELSE
          pa.insert_time
       END) AS ACCOUNTDATE,
       PPP.DUE_DATE AS SETTLEMENTDATE,
       NVL((SELECT SUM(NVL(PATL.AMOUNT, 0))
             FROM ODS_STG.OFE_T_POL_ACCOUNT_TRANS_LIST PATL
            WHERE PATL.POLICY_ID = P.POLICY_ID
              AND PATL.AMOUNT >= 0
              AND PATL.POL_ACCOUNT_ID = PA.POL_ACCOUNT_ID
              AND RC_STATE = ''E''),
           0) AS ACCUMPAY,
       NVL((SELECT SUM(PATL.AMOUNT)
             FROM ODS_STG.OFE_T_POL_ACCOUNT_TRANS_LIST PATL
            WHERE PATL.POLICY_ID = P.POLICY_ID
              AND PATL.AMOUNT < 0
              AND PATL.POL_ACCOUNT_ID = PA.POL_ACCOUNT_ID
              AND RC_STATE = ''E''),
           0) AS ACCUMDWAMNT,
       (CASE
         WHEN p.policy_status NOT IN (''1'', ''3'') THEN
          0
         ELSE
          NVL((SELECT SUM(PPFV.ACCOUNT_VALUE)
                FROM ODS_STG.OFE_T_POL_PLAN_FUND_VALUE PPFV
               WHERE PPFV.POLICY_ID = P.POLICY_ID
                 AND PPFV.POLICY_PLAN_ID = PP.POLICY_PLAN_ID
                 AND PPFV.RC_STATE = ''E''),
              0)
       END) AS ACCOUNTVALUE,
       (SELECT COUNT(PATL.POLICY_ID)
          FROM ODS_STG.OFE_T_POL_ACCOUNT_TRANS_LIST PATL
         WHERE PATL.POLICY_ID = P.POLICY_ID
           AND PATL.RC_STATE = ''E'') AS ACCOUNTUNITNUMBER,
       P.OPERATOR_ID AS OPERATOR,
       TO_DATE(TO_CHAR(P.INSERT_TIME, ''yyyy-mm-dd''), ''yyyy-mm-dd'') AS MAKEDATE,
       TO_CHAR(P.INSERT_TIME, ''hh:mi:ss'') AS MAKETIME,
       TO_DATE(TO_CHAR(SYSDATE, ''yyyy-mm-dd''), ''yyyy-mm-dd'') AS MODIFYDATE,
       TO_CHAR(SYSDATE, ''hh:mi:ss'') AS MODIFYTIME
  from ods_stg.OFE_T_POLICY_CHANGE pc
  left join ODS_STG.OFE_T_POLICY P
    on pc.policy_id = pc.policy_id
  LEFT JOIN ODS_STG.OFE_T_POL_PLAN PP
    ON PP.RC_STATE = ''E''
   AND PP.POLICY_ID = P.POLICY_ID
  LEFT JOIN ODS_STG.OFE_T_PD_PRODUCT PD
    ON PD.RC_STATE = ''E''
   AND PD.PD_PRODUCT_ID = PP.PD_PRODUCT_ID
  LEFT JOIN ODS_STG.OFE_T_PD_PRODUCT_PLAN pdpp
    ON pdpp.rc_state = ''E''
   AND pdpp.pd_plan_id = pp.pd_plan_id
  LEFT JOIN ODS_STG.OFE_T_POL_ACCOUNT PA
    ON PA.RC_STATE = ''E''
   AND PA.POLICY_ID = P.POLICY_ID
  LEFT JOIN ODS_STG.OFE_T_POL_PLAN_PREM PPP
    ON ppp.rc_state = ''E''
   AND PPP.POLICY_ID = P.POLICY_ID
   AND ppp.policy_plan_id = pp.policy_plan_id
 WHERE P.RC_STATE = ''E''
   --AND PD.BASIC_PRODUCT_FLAG = ''B''
   AND PD.COVERAGE_TERM_TYPE <> ''M''
   AND NOT EXISTS (SELECT 1 FROM ODS_STG.OFE_T_RLS_POLICY A WHERE TO_CHAR(A.PNO) = TO_CHAR(P.POLICY_NO) AND A.FLAG = ''1'')
   and pc.item_id is not null
   and pc.rc_state = ''E''
   AND PC.POLICY_ID = P.POLICY_ID
   AND PC.POLICY_CHG_ID > 0
   AND P.POLICY_ID > 0 
   AND PD.PD_PRODUCT_ID NOT IN (SELECT DISTINCT c.pd_product_id
                                from ODS_STG.OFE_t_Cfg_Plan_Print a,ODS_STG.OFE_t_pd_product_plan b,
                                ODS_STG.OFE_T_POL_PLAN c,ods_stg.OFE_T_PD_PRODUCT d
                                where a.pd_plan_id=b.pd_plan_id 
                                AND d.pd_product_id=c.pd_product_id
                                AND b.pd_product_id=c.pd_product_id 
                                AND a.is_show=0)--需屏蔽的险种
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
   AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn}) 
   AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'') '; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10930;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12813 IS   V_ID NUMBER :=12813;  V_SQL_ID NUMBER :=12845;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LJAGetLivBene'' AS TableName,       ''TransactionNo'' AS FieldName,       ''COUNT'' AS CheckType,       NVL((SELECT COUNT(1)          FROM T_PRP_LJAGetLivBene A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12813;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12814 IS   V_ID NUMBER :=12814;  V_SQL_ID NUMBER :=12846;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LJAGetLivBene'' AS TableName,        ''BenefitAmount'' AS FieldName,        ''SUM'' AS CheckType,        NVL((SELECT SUM(A.BenefitAmount)           FROM T_PRP_LJAGetLivBene A, T_PRP_LCPOLTRANSACTION B          WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12814;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10924 IS   V_ID NUMBER :=10924;  V_SQL_ID NUMBER :=10948;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='SELECT 
TRANSACTIONNO,
MAX(COMPANYCODE) AS COMPANYCODE,
POLICYNO,
MAX(MANAGECOM) AS MANAGECOM,
AGENCYCODE,
MAX(AGENCYNAME) AS AGENCYNAME,
AGENTCODE,
MAX(NAME) AS NAME,
MAX(SEX) AS SEX,
MAX(BIRTHDATE)  AS BIRTHDATE,
MAX(QUAFCERTNO)  AS QUAFCERTNO,
MAX(CERTSTARTDATE)  AS CERTSTARTDATE,
MAX(CERTENDDATE)  AS CERTENDDATE,
MAX(BUSIDEVCERTIFNO) AS BUSIDEVCERTIFNO,
MAX(OFFICEWORKFLAG) AS OFFICEWORKFLAG,
MAX(AGENTSIGNFLAG) AS AGENTSIGNFLAG,
MAX(FULLTIMEFLAG) AS FULLTIMEFLAG,
MAX(CERTTYPE) AS CERTTYPE,
MAX(CERTNO) AS CERTNO,
MAX(SALEJUDGE) AS SALEJUDGE
FROM (
SELECT 
       PC.POLICY_CHG_ID AS TRANSACTIONNO,
       ''000031'' AS COMPANYCODE,
       P.POLICY_NO AS POLICYNO,
       P.BRANCH_CODE AS MANAGECOM,
       PAR.AGENT_CODE AS AGENCYCODE,
       NVL(PAR.SALES_PERSON_NAME,''AGC_''||PAR.Policy_Sales_ID) AS AGENCYNAME,
       PAR.Policy_Sales_ID AS AGENTCODE,
       PAR.SALES_PERSON_NAME AS NAME,
       '''' AS SEX,
       '''' AS BIRTHDATE,
       PAR.Policy_Sales_ID AS QUAFCERTNO,
       '''' AS CERTSTARTDATE,
       '''' AS CERTENDDATE,
       ''000000'' AS BUSIDEVCERTIFNO,
       (CASE (CASE
         WHEN PAR.AGENT_CODE IS NULL THEN
          ''2''
         ELSE
          ''1''
       END) WHEN ''1'' THEN ''N'' ELSE ''Y'' END) AS OFFICEWORKFLAG,
       ''Y'' AS AGENTSIGNFLAG,
       '''' AS FULLTIMEFLAG,
       '''' AS CERTTYPE,
       PAR.SALES_CERTI_NO AS CERTNO,
       '''' AS SALEJUDGE,
       P.OPERATOR_ID AS OPERATOR,
       TO_DATE(TO_CHAR(P.POLICY_ISSUE_DATE,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MAKEDATE,
       TO_CHAR(P.INSERT_TIME, ''hh24:mi:ss'') AS MAKETIME,
       TO_DATE(TO_CHAR(SYSDATE,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MODIFYDATE,
       TO_CHAR(SYSDATE, ''hh24:mi:ss'') AS MODIFYTIME   
FROM ODS_STG.OFE_T_POLICY_CHANGE PC
LEFT JOIN ODS_STG.OFE_T_POLICY P ON P.RC_STATE = ''E'' AND P.POLICY_ID = PC.POLICY_ID
LEFT JOIN ODS_STG.OFE_T_POL_PLAN PP ON PP.RC_STATE = ''E'' AND PP.POLICY_ID = P.POLICY_ID
LEFT JOIN ODS_STG.OFE_T_PD_PRODUCT PD ON PD.RC_STATE = ''E'' AND PD.PD_PRODUCT_ID = PP.PD_PRODUCT_ID
LEFT JOIN ODS_STG.OFE_T_POL_AGENT_ROLE PAR
     ON PAR.RC_STATE = ''E''
     AND PAR.AGENT_ROLE = ''2''
     AND PAR.POLICY_ID = P.POLICY_ID
WHERE P.RC_STATE = ''E''
  AND PD.BASIC_PRODUCT_FLAG = ''B''
  AND PD.COVERAGE_TERM_TYPE <> ''M''
  AND NOT EXISTS(SELECT 1 FROM ODS_STG.OFE_T_RLS_POLICY A WHERE TO_CHAR(A.PNO) = TO_CHAR(P.POLICY_NO) AND A.FLAG = ''1'')
  AND PC.RC_STATE = ''E'' 
  AND PD.PD_PRODUCT_ID NOT IN (SELECT DISTINCT c.pd_product_id
                                from ODS_STG.OFE_t_Cfg_Plan_Print a,ODS_STG.OFE_t_pd_product_plan b,
                                ODS_STG.OFE_T_POL_PLAN c,ods_stg.OFE_T_PD_PRODUCT d
                                where a.pd_plan_id=b.pd_plan_id 
                                AND d.pd_product_id=c.pd_product_id
                                AND b.pd_product_id=c.pd_product_id 
                                AND a.is_show=0)
  AND PC.POLICY_ID = P.POLICY_ID 
  AND PC.POLICY_CHG_ID > 0
  AND P.POLICY_ID > 0
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
  AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn})
  AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
) GROUP BY TRANSACTIONNO, POLICYNO, AGENCYCODE, AGENTCODE
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10924;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10934 IS   V_ID NUMBER :=10934;  V_SQL_ID NUMBER :=10958;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='SELECT TRANSACTIONNO,
COMPANYCODE,GRPPOLICYNO,POLICYNO,PRTNO,
GPFLAG,FAMILYPOLTYPE,MANAGECOM,
MANAGECOMNAME,DISTRIBCHNL,
AGENCYCODE,AGENCYNAME,
APPNTNO,CUSTOMERNO,APPNTNAME,
APPNTSEX,APPNTBIRTHDATE,
APPNTCERTTYPE,APPNTCERTNO,
PROVINCE,CITY,COUNTY,STREET,
APPNTMP,APPNTFP,EMAIL,PAYMODE,
PAYWAY,SIGNDATE,CURRENCY,
COPIES,PREMIUM,SUMINSURED,
CASHVALUE,POLBALANCE,
ACCUMPREMIUM,ACCUMLOANMONEY,
APLMONEY,CURPAIDTODATE,
PAYBEGINDATE,EFFDATE,UWDATE,
UWTYPE,POLAPPLYDATE,CUSTOMGETPOLDATE,
POLSTATUS,BANKCODE,BANKNAME,
BANKACCNO,ACCNAME,POLICYTYPE,
POLICYENDDATE,TERMINATIONDATE,SUSPENDDATE,
RECOVERDATE,TERMINATIONREASON,
OPERATOR,MAKEDATE,MAKETIME,
MODIFYDATE,MODIFYTIME
FROM (
SELECT PC.POLICY_CHG_ID AS TRANSACTIONNO,
       ''000031'' AS COMPANYCODE,
       '''' AS GRPPOLICYNO,
       P.POLICY_NO AS POLICYNO,
       P.APPLICATION_ID AS PRTNO,
       ''01'' GPFLAG,
       ''Y'' AS FAMILYPOLTYPE,
       P.BRANCH_CODE AS MANAGECOM,
       (SELECT NAME FROM ODS_STG.OFE_CTP_BRANCH_NLS WHERE ID = P.BRANCH_CODE) AS MANAGECOMNAME,
       P.CHANNEL_TYPE AS DISTRIBCHNL,
       '''' AS AGENCYCODE,
       '''' AS AGENCYNAME,
       PCM.CLIENT_ID AS APPNTNO,
       '''' AS CUSTOMERNO,
       PCM.CLIENT_NAME AS APPNTNAME,
       PCM.CLIENT_SEX AS APPNTSEX,
       PCM.CLIENT_BIRTHDAY AS APPNTBIRTHDATE,
       (CASE
         WHEN PCM.CLIENT_ID_NO IS NULL THEN  ''990''  ELSE  PCM.CLIENT_ID_TYPE
       END) AS APPNTCERTTYPE,
       NVL(PCM.CLIENT_ID_NO, ''99'') AS APPNTCERTNO,
       PCA.PROVINCE AS PROVINCE,
       PCA.CITY AS CITY,
       PCA.COUNTRY AS COUNTY,
       REGEXP_REPLACE(PCA.ADDRESS, ''\\|\*|\?|[|]'', '' '') AS STREET,
       PCA.MOBILE AS APPNTMP,
       PCA.PHONE AS APPNTFP,
       PCA.EMAIL AS EMAIL,
       (CASE
         WHEN PP.PAY_MODE IS NOT NULL THEN
          PP.PAY_MODE
         WHEN PP.PAY_MODE IS NULL AND
              PP.PREM_PAYMENT_PERIOD_TYPE IN (''L'', ''WL'') THEN  ''01''  ELSE  ''99''
       END) AS PAYMODE,
       P.PAYMENT_METHOD AS PAYWAY,
       P.POLICY_ISSUE_DATE AS SIGNDATE,
       ''156'' AS CURRENCY,
       NVL(TO_NUMBER(PP.UNIT), 1) AS COPIES,
       (CASE WHEN
               NVL((SELECT SUM(FEE)                             
                     FROM ODS_STG.OFE_T_POL_PLAN_PREM_SCHE OPPS1
                    WHERE 1 = 1 AND OPPS1.POLICY_ID = P.POLICY_ID AND RC_STATE = ''E'' AND PREMIUM_STATUS = ''2''
                      AND DUE_DATE = PPPCC.DUE_DATE),0)=0 
                THEN NVL((SELECT SUM(AMOUNT)
                         FROM ODS_STG.OFE_T_POL_PLAN_TOPUP_LIST PTL
                        WHERE PTL.POLICY_ID = P.POLICY_ID
                            AND PTL.POLICY_PLAN_ID = PP.POLICY_PLAN_ID),0)
              ELSE NVL((SELECT SUM(FEE) FROM ODS_STG.OFE_T_POL_PLAN_PREM_SCHE OPPS1
                    WHERE 1 = 1  AND OPPS1.POLICY_ID = P.POLICY_ID  AND RC_STATE = ''E'' AND PREMIUM_STATUS = ''2''
                      AND DUE_DATE = PPPCC.DUE_DATE), 0) END) AS PREMIUM,
       NVL((SELECT SUM(OPP.SUM_ASSURED)
             FROM ODS_STG.OFE_T_POL_PLAN OPP
            WHERE OPP.RC_STATE = ''E''
              AND OPP.POLICY_ID = P.POLICY_ID),  0) AS SUMINSURED,
       NVL((SELECT SUM(NVL((CASE P.POLICY_STATUS WHEN ''4'' THEN 0 
                                ELSE PPCV.CASH_VALUE END), 0)) FROM ODS_STG.OFE_T_POL_PLAN_CASH_VALUE PPCV
            WHERE PPCV.POLICY_ID = P.POLICY_ID
              AND PPCV.RC_STATE = ''E''),  0) AS CASHVALUE,
       NVL((SELECT TPA.CAPITAL_BALANCE FROM ODS_STG.OFE_T_POL_ACCOUNT TPA
            WHERE TPA.ACCOUNT_TYPE = ''13''
              AND TPA.POLICY_ID = P.POLICY_ID
              AND TPA.POL_PLAN_ID = PP.POLICY_PLAN_ID),0) AS POLBALANCE,
       (CASE WHEN NVL((SELECT SUM(PPPCCC.FEE)
             FROM ODS_STG.OFE_T_POL_PLAN_PREM_SCHE PPPCCC
            WHERE PPPCCC.POLICY_ID =
                  (SELECT POLICY_ID FROM ODS_STG.OFE_T_POLICY PPPP
                    WHERE PPPP.POLICY_NO = P.POLICY_NO
                      AND PPPP.RC_STATE = ''E''
                      AND PPPP.POLICY_ID = PC.POLICY_ID)
              AND PREMIUM_STATUS = ''2''
              AND RC_STATE = ''E''
              AND PPPCCC.PAY_TO_DATE <= PPPCC.PAY_TO_DATE),0.00) = 0 
           THEN 
          NVL((SELECT SUM(AMOUNT) FROM ODS_STG.OFE_T_POL_PLAN_TOPUP_LIST PTL
                        WHERE PTL.POLICY_ID = P.POLICY_ID AND PTL.POLICY_PLAN_ID = PP.POLICY_PLAN_ID),0)  ELSE 
          NVL((SELECT SUM(PPPCCC.FEE)
             FROM ODS_STG.OFE_T_POL_PLAN_PREM_SCHE PPPCCC
            WHERE PPPCCC.POLICY_ID =  (SELECT POLICY_ID FROM ODS_STG.OFE_T_POLICY PPPP
                    WHERE PPPP.POLICY_NO = P.POLICY_NO AND PPPP.RC_STATE = ''E'' AND PPPP.POLICY_ID = PC.POLICY_ID)
              AND PREMIUM_STATUS = ''2''
              AND RC_STATE = ''E''
              AND PPPCCC.PAY_TO_DATE <= PPPCC.PAY_TO_DATE),0.00) END)AS ACCUMPREMIUM,
       NVL((SELECT (TPA.CAPITAL_BALANCE + TPA.INTEREST_BALANCE)  FROM ODS_STG.OFE_T_POL_ACCOUNT TPA
            WHERE TPA.ACCOUNT_TYPE = ''6''
              AND TPA.POLICY_ID = P.POLICY_ID
              AND TPA.POL_PLAN_ID = PP.POLICY_PLAN_ID), 0) AS ACCUMLOANMONEY,
       NVL((SELECT (TPA.CAPITAL_BALANCE + TPA.INTEREST_BALANCE)
             FROM ODS_STG.OFE_T_POL_ACCOUNT TPA
            WHERE TPA.ACCOUNT_TYPE = ''7'' AND TPA.POLICY_ID = P.POLICY_ID  AND TPA.POL_PLAN_ID = PP.POLICY_PLAN_ID),  0) AS APLMONEY,
       PPPCC.PAY_TO_DATE AS CURPAIDTODATE,
       P.POLICY_EFFECTIVE_DATE AS PAYBEGINDATE,
       P.POLICY_EFFECTIVE_DATE AS EFFDATE,  UAM.UWDATE AS UWDATE,
       UAM.UWTYPE AS UWTYPE,
       P.POLICY_ISSUE_DATE AS POLAPPLYDATE,  P.RECEIPT_DATE AS CUSTOMGETPOLDATE, P.POLICY_STATUS AS POLSTATUS,
       (CASE
         WHEN (SELECT MAX(BK.BANK_BRANCH_CODE)
                 FROM ODS_STG.OFE_T_BK_ACC_MST BK
                WHERE BK.POLICY_NO = P.POLICY_NO
                  AND BK.RC_STATE = ''E'') IS NOT NULL THEN
          (SELECT MAX(BK.BANK_CODE)
             FROM ODS_STG.OFE_T_BK_ACC_MST BK
            WHERE BK.POLICY_NO = P.POLICY_NO
              AND BK.RC_STATE = ''E'') || ''-'' ||
          (SELECT MAX(BK.BANK_BRANCH_CODE)
             FROM ODS_STG.OFE_T_BK_ACC_MST BK
            WHERE BK.POLICY_NO = P.POLICY_NO
              AND BK.RC_STATE = ''E'')  ELSE
          (SELECT MAX(BK.BANK_CODE) FROM ODS_STG.OFE_T_BK_ACC_MST BK
            WHERE BK.POLICY_NO = P.POLICY_NO  AND BK.RC_STATE = ''E'')  END) AS BANKCODE,
       (CASE
         WHEN (SELECT MAX(BK.BANK_BRANCH_CODE)
                 FROM ODS_STG.OFE_T_BK_ACC_MST BK  WHERE BK.POLICY_NO = P.POLICY_NO  AND BK.RC_STATE = ''E'') IS NOT NULL THEN
          (SELECT MAX(T.BANK_NAME) FROM ODS_STG.OFE_T_BK_ACC_MST BK, ODS_STG.OFE_T_CFG_BANK T
            WHERE T.BANK_CODE = BK.BANK_CODE  AND BK.POLICY_NO = P.POLICY_NO) || ''-'' ||
          (SELECT MAX(TB.BANK_BRANCH_NAME)  FROM ODS_STG.OFE_T_BK_ACC_MST      BK,  ODS_STG.OFE_T_CFG_BANK_BRANCH TB
            WHERE TB.BANK_BRANCH_CODE = BK.BANK_BRANCH_CODE AND BK.POLICY_NO = P.POLICY_NO)
         ELSE
          (SELECT MAX(T.BANK_NAME)  FROM ODS_STG.OFE_T_BK_ACC_MST BK, ODS_STG.OFE_T_CFG_BANK T
            WHERE T.BANK_CODE = BK.BANK_CODE  AND BK.POLICY_NO = P.POLICY_NO) END) AS BANKNAME,
       (SELECT MAX(BK.BANK_ACC_NO)
          FROM ODS_STG.OFE_T_BK_ACC_MST BK  WHERE BK.POLICY_NO = P.POLICY_NO  AND BK.RC_STATE = ''E'') AS BANKACCNO,
       (SELECT MAX(BK.BANK_OWNER_NAME)  FROM ODS_STG.OFE_T_BK_ACC_MST BK
         WHERE BK.POLICY_NO = P.POLICY_NO  AND BK.RC_STATE = ''E'') AS ACCNAME,  ''1'' AS POLICYTYPE,
       PP.EXPIRED_DATE AS POLICYENDDATE, P.POLICY_EFFECTIVE_DATE AS TERMINATIONDATE,
       (CASE P.POLICY_STATUS  WHEN ''3'' THEN P.POLICY_EFFECTIVE_DATE  ELSE  NULL
       END) AS SUSPENDDATE,  '''' AS RECOVERDATE,
       (CASE P.POLICY_STATUS WHEN ''4'' THEN
          (SELECT DICTCODE  FROM ODS_STG.OFE_CTP_GEN_DICT
            WHERE DICTTYPE = ''TERMINA_STATUS'' AND DICTCODE = P.TERMINAL_CAUSE)
         ELSE ''99''
       END) AS TERMINATIONREASON,
       P.OPERATOR_ID AS OPERATOR,
       TO_DATE(TO_CHAR(P.INSERT_TIME, ''YYYY-MM-DD''), ''YYYY-MM-DD'') AS MAKEDATE,
       TO_CHAR(P.INSERT_TIME, ''HH:MM:SS'') AS MAKETIME,
       TO_DATE(TO_CHAR(SYSDATE, ''YYYY-MM-DD''), ''YYYY-MM-DD'') AS MODIFYDATE,
       TO_CHAR(SYSDATE, ''HH:MM:SS'') AS MODIFYTIME,
       row_number() OVER(PARTITION BY PC.POLICY_CHG_ID ORDER BY PPPCC.PAY_TO_DATE DESC ) AS flag
  FROM ODS_STG.OFE_T_POLICY_CHANGE PC
  LEFT JOIN ODS_STG.OFE_T_POLICY P ON PC.RC_STATE = ''E''AND PC.POLICY_ID = P.POLICY_ID
  LEFT JOIN ODS_STG.OFE_T_POL_PLAN PP ON PP.RC_STATE = ''E''AND PP.POLICY_ID = P.POLICY_ID
   AND PP.POLICY_PLAN_ID = PP.MAIN_PLAN_ID
LEFT JOIN    ODS_STG.OFE_T_POL_PLAN_PREM_SCHE PPPCC
            ON  PPPCC.Due_Date <= PC.Effective_Date
           AND PPPCC.POLICY_ID = P.POLICY_ID
           AND PPPCC.PREMIUM_STATUS = ''2''
           AND PPPCC.POLICY_PLAN_ID = PP.POLICY_PLAN_ID
           AND PPPCC.RC_STATE = ''E''
  LEFT JOIN ODS_STG.OFE_T_PD_PRODUCT PD
    ON PD.RC_STATE = ''E''
   AND PD.PD_PRODUCT_ID = PP.PD_PRODUCT_ID
  LEFT JOIN ODS_STG.OFE_T_POL_CLN_MST PCM
    ON PCM.RC_STATE = ''E''
   AND PCM.POLICY_ID = P.POLICY_ID
   AND PCM.CLIENT_ROLE = ''1''
  LEFT JOIN ODS_STG.OFE_T_POL_CLN_ADDRESS PCA
    ON PCA.RC_STATE = ''E''
   AND PCA.POLICY_ID = P.POLICY_ID
   AND PCA.POLICY_CLIENT_ID = PCM.POLICY_CLIENT_ID
  LEFT JOIN ODS_STG.OFE_T_UW_MST UM
    ON UM.RC_STATE = ''E''
   AND UM. CLIENT_ACCEPT_FLAG <> ''0''
   AND UM.BUSINESS_NO = P.POLICY_NO
  LEFT JOIN (SELECT UW.BUSINESS_NO,MAX(UW.AUTO_UW_FINISH_TIME) AS UWDATE,
                    UW.RC_STATE,
                    (CASE
                      WHEN COUNT(1) > 1 THEN ''2''  ELSE  ''1''
                    END) AS UWTYPE FROM ODS_STG.OFE_T_UW_AUTO_MST UW
              WHERE UW.RC_STATE = ''E''
              GROUP BY BUSINESS_NO, RC_STATE) UAM
    ON UAM.RC_STATE = ''E''
   AND UAM.BUSINESS_NO = P.POLICY_NO
 WHERE 1 = 1
   AND PCM.CLIENT_ROLE = ''1''
   AND PD.BASIC_PRODUCT_FLAG = ''B''
   AND PD.COVERAGE_TERM_TYPE <> ''M''
   AND NOT EXISTS
 (SELECT 1 FROM ODS_STG.OFE_T_RLS_POLICY A WHERE TO_CHAR(A.PNO) = TO_CHAR(P.POLICY_NO) AND A.FLAG = ''1'')
   AND PC.RC_STATE = ''E''
   AND PC.POLICY_ID = P.POLICY_ID
   AND PC.POLICY_CHG_ID > 0
   AND P.POLICY_ID > 0
   AND PD.PD_PRODUCT_ID NOT IN (SELECT DISTINCT c.pd_product_id from ODS_STG.OFE_t_Cfg_Plan_Print a,ODS_STG.OFE_t_pd_product_plan b,
                                ODS_STG.OFE_T_POL_PLAN c,ods_stg.OFE_T_PD_PRODUCT d
                                where a.pd_plan_id=b.pd_plan_id 
                                AND d.pd_product_id=c.pd_product_id
                                AND b.pd_product_id=c.pd_product_id 
                                AND a.is_show=0)--需屏蔽的险种
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
   AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn}) 
   AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'') 
) WHERE flag = 1'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10934;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12501 IS   V_ID NUMBER :=12501;  V_SQL_ID NUMBER :=12520;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='  DELETE FROM  T_PRP_LCPolTransaction T WHERE NOT EXISTS (SELECT ''x'' FROM T_PRP_LCCont TT WHERE T.Policyno = TT.Policyno)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12501;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12513 IS   V_ID NUMBER :=12513;  V_SQL_ID NUMBER :=12532;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='  DELETE FROM  T_PRP_LLClaimPolicy T WHERE NOT EXISTS (SELECT ''x'' FROM T_PRP_LCCont TT WHERE T.TRANSACTIONNO = TT.TRANSACTIONNO AND TT.Policyno = T.policyNo)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12513;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12520 IS   V_ID NUMBER :=12520;  V_SQL_ID NUMBER :=12539;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='  DELETE FROM  T_PRP_LCProdInsuRela T WHERE NOT EXISTS (select ''x'' from T_PRP_LCProduct p where p.productno = T.productno  AND p.policyno = T.policyno)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12520;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12451 IS   V_ID NUMBER :=12451;  V_SQL_ID NUMBER :=12451;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE  FROM T_PRP_LCProduct where transactionno in (select transactionno from T_PRP_LCPolTransaction where transdate between to_date(''#{startDate}'', ''yyyy-mm-dd'') and to_date(''#{endDate}'', ''yyyy-mm-dd''))
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12451;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12833 IS   V_ID NUMBER :=12833;  V_SQL_ID NUMBER :=12865;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='select ''PDL-Head'' as "PDL-Head",''PDL-Body'' as "PDL-Body" from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12833;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12472 IS   V_ID NUMBER :=12472;  V_SQL_ID NUMBER :=12472;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCBNF A
   SET A.COMPANYCODE = case
                         when (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.COMPANYCODE = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''companycode''
                                  AND B.COM_ID = 1) is not null then
                          (SELECT B.TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE A.COMPANYCODE = B.BASIC_CODE
                              AND B.CODE_TYPE = ''companycode''
                              AND B.COM_ID = 1)
                         else
                          a.companycode
                       end,
       
       A.BNFCAT = case
                    when (SELECT B.TARGET_CODE
                            FROM T_DEF_CODE_MAPPING B
                           WHERE A.BNFCAT = B.BASIC_CODE
                             AND B.CODE_TYPE = ''bnfcat''
                             AND B.COM_ID = 1) is not null then
                     (SELECT B.TARGET_CODE
                        FROM T_DEF_CODE_MAPPING B
                       WHERE A.BNFCAT = B.BASIC_CODE
                         AND B.CODE_TYPE = ''bnfcat''
                         AND B.COM_ID = 1)
                    else
                     a.bnfcat
                  end,
       
       A.BNFLEVEL = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.BNFLEVEL = B.BASIC_CODE
                               AND B.CODE_TYPE = ''bnflevel''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.BNFLEVEL = B.BASIC_CODE
                           AND B.CODE_TYPE = ''bnflevel''
                           AND B.COM_ID = 1)
                      else
                       a.bnflevel
                    end,
       
       A.RELATIONTOINSURED = case
                               when (SELECT B.TARGET_CODE
                                       FROM T_DEF_CODE_MAPPING B
                                      WHERE A.RELATIONTOINSURED = B.BASIC_CODE
                                        AND B.CODE_TYPE = ''relationtoinsured''
                                        AND B.COM_ID = 1) is not null then
                                (SELECT B.TARGET_CODE
                                   FROM T_DEF_CODE_MAPPING B
                                  WHERE A.RELATIONTOINSURED = B.BASIC_CODE
                                    AND B.CODE_TYPE = ''relationtoinsured''
                                    AND B.COM_ID = 1)
                               else
                                a.relationtoinsured
                             end,
       
       A.SEX = case
                 when (SELECT B.TARGET_CODE
                         FROM T_DEF_CODE_MAPPING B
                        WHERE A.SEX = B.BASIC_CODE
                          AND B.CODE_TYPE = ''sex''
                          AND B.COM_ID = 1) is not null then
                  (SELECT B.TARGET_CODE
                     FROM T_DEF_CODE_MAPPING B
                    WHERE A.SEX = B.BASIC_CODE
                      AND B.CODE_TYPE = ''sex''
                      AND B.COM_ID = 1)
                 else
                  a.sex
               end,
       
       A.CERTTYPE = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.CERTTYPE = B.BASIC_CODE
                               AND B.CODE_TYPE = ''certtype''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.CERTTYPE = B.BASIC_CODE
                           AND B.CODE_TYPE = ''certtype''
                           AND B.COM_ID = 1)
                      else
                       a.certtype
                    end
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12472;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12469 IS   V_ID NUMBER :=12469;  V_SQL_ID NUMBER :=12469;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='
--新单(承保)
select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''01'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode)  companyCODE,
       ht.agentcode AgentCode,
       ht.contno PolicyNo,
       h1.managecom ManageCom,
       nvl(ha.name,hm.name) Name,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=va.sex) Sex,
       va.birthday BirthDate,
       '''' QuafCertNo,
       ha.IndueforMdate CertStartDate,
       ha.OutWorkDate CertEndDate,
       ''000000'' BusiDevCertifNo,
       ha.insideflag OfficeWorkFlag,
       (case when va.agentcode is not null then ''Y'' else ''N'' end) AgentSignFlag,
       '''' FullTimeFlag,
       ''1'' SaleSvcFlag,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=va.idnotype) CertType,
       ha.idno CertNo,
       '''' SaleJudge,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
inner join ODS_STG.HNW_hccont ht on hc.grpcontno=ht.grpcontno and ht.contno=hc.contno
left join ODS_STG.HNW_haagent ha on ht.agentcode=ha.agentcode
left join ODS_STG.HNW_vw_agent va on ht.agentcode=va.agentcode
left join ODS_STG.HNW_vw_agentcom hm on ht.agentcode=hm.agentcom
where 1=1 and (h1.othernotype=''1'' and h1.tempfeetype=''8'') and  h1.conttype=''1'' 
     and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
                    
union all
--新单（续期）

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''02'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode)  companyCODE,
       ht.agentcode AgentCode,
       ht.contno PolicyNo,
       h1.managecom ManageCom,
       nvl(ha.name,hm.name) Name,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=va.sex) Sex,
       va.birthday BirthDate,
       '''' QuafCertNo,
       ha.IndueforMdate CertStartDate,
       ha.OutWorkDate CertEndDate,
       ''000000'' BusiDevCertifNo,
       ha.insideflag OfficeWorkFlag,
       (case when va.agentcode is not null then ''Y'' else ''N'' end) AgentSignFlag,
       '''' FullTimeFlag,
       ''1'' SaleSvcFlag,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=va.idnotype) CertType,
       ha.idno CertNo,
       '''' SaleJudge,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
inner join ODS_STG.HNW_hccont ht on hc.grpcontno=ht.grpcontno and ht.contno=hc.contno
left join ODS_STG.HNW_haagent ha on ht.agentcode=ha.agentcode
left join ODS_STG.HNW_vw_agent va on ht.agentcode=va.agentcode
left join ODS_STG.HNW_vw_agentcom hm on ht.agentcode=hm.agentcom
where 1=1 and (h1.othernotype in (''1'', ''2'') and h1.tempfeetype=''9'') and h1.conttype=''1''  
      and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
         
         
union all

--保全收费(非定结)

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''03'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode)  companyCODE,
       ht.agentcode AgentCode,
       ht.contno PolicyNo,
       h1.managecom ManageCom,
       nvl(ha.name,hm.name) Name,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=va.sex) Sex,
       va.birthday BirthDate,
       '''' QuafCertNo,
       ha.IndueforMdate CertStartDate,
       ha.OutWorkDate CertEndDate,
       ''000000'' BusiDevCertifNo,
       ha.insideflag OfficeWorkFlag,
       (case when va.agentcode is not null then ''Y'' else ''N'' end) AgentSignFlag,
       '''' FullTimeFlag,
       ''1'' SaleSvcFlag,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=va.idnotype) CertType,
       ha.idno CertNo,
       '''' SaleJudge,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join (select endorno, grpcontno, contno,feefinatype as feefinatype,sum(getmoney) as sumactupaymoney
  from ODS_STG.HNW_hejsgetendorse
 group by endorno, grpcontno, contno,feefinatype) h2 on h1.otherno=h2.endorno
left join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
inner join ODS_STG.HNW_hccont ht on hc.grpcontno=ht.grpcontno and ht.contno=hc.contno
left join ODS_STG.HNW_haagent ha on ht.agentcode=ha.agentcode
left join ODS_STG.HNW_vw_agent va on ht.agentcode=va.agentcode
left join ODS_STG.HNW_vw_agentcom hm on ht.agentcode=hm.agentcom
where (h1.othernotype = ''2'' and h1.incometype = ''0'')  and h1.conttype=''1'' 
      and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

union all 
--保全付费（非定结）

select ''G''||substr(hj1.actugetno,12)||substr(h2.contno,11)||''04'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode)  companyCODE,
       ht.agentcode AgentCode,
       ht.contno PolicyNo,
       hj1.managecom ManageCom,
       nvl(ha.name,hm.name) Name,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=va.sex) Sex,
       va.birthday BirthDate,
       '''' QuafCertNo,
       ha.IndueforMdate CertStartDate,
       ha.OutWorkDate CertEndDate,
       ''000000'' BusiDevCertifNo,
       ha.insideflag OfficeWorkFlag,
       (case when va.agentcode is not null then ''Y'' else ''N'' end) AgentSignFlag,
       '''' FullTimeFlag,
       ''1'' SaleSvcFlag,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=va.idnotype) CertType,
       ha.idno CertNo,
       '''' SaleJudge,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate

from ODS_STG.HNW_hjaget hj1
inner join (select endorno, grpcontno, contno,feefinatype as feefinatype,sum(getmoney) as sumactupaymoney
  from ODS_STG.HNW_hejsgetendorse 
 group by endorno, grpcontno, contno,feefinatype) h2 on hj1.otherno = h2.endorno
left join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
inner join ODS_STG.HNW_hccont ht on hc.grpcontno=ht.grpcontno and ht.contno=hc.contno
left join ODS_STG.HNW_haagent ha on ht.agentcode=ha.agentcode
left join ODS_STG.HNW_vw_agent va on ht.agentcode=va.agentcode
left join ODS_STG.HNW_vw_agentcom hm on ht.agentcode=hm.agentcom
where 1=1 and (hj1.othernotype = ''2'' and hj1.tempfeetype = ''4'') and hj1.conttype=''1'' 
and hj1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

union all

--理赔
select  ''L''||substr(hl.clmno,2)||substr(hc.contno,11)||''05'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode)  companyCODE,
       ht.agentcode AgentCode,
       ht.contno PolicyNo,
       hc.managecom ManageCom,
       nvl(ha.name,hm.name) Name,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=va.sex) Sex,
       va.birthday BirthDate,
       '''' QuafCertNo,
       ha.IndueforMdate CertStartDate,
       ha.OutWorkDate CertEndDate,
       ''000000'' BusiDevCertifNo,
       ha.insideflag OfficeWorkFlag,
       (case when va.agentcode is not null then ''Y'' else ''N'' end) AgentSignFlag,
       '''' FullTimeFlag,
       ''1'' SaleSvcFlag,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=va.idnotype) CertType,
       ha.idno CertNo,
       '''' SaleJudge,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
  from ODS_STG.HNW_hlclaim hl
  inner join ODS_STG.HNW_hcinsured hc
    on hl.segment1 = hc.contno
inner join ODS_STG.HNW_hccont ht on hc.grpcontno=ht.grpcontno and ht.contno=hc.contno
left join ODS_STG.HNW_haagent ha on ht.agentcode=ha.agentcode
left join ODS_STG.HNW_vw_agent va on ht.agentcode=va.agentcode
left join ODS_STG.HNW_vw_agentcom hm on ht.agentcode=hm.agentcom
 where 1 = 1  and hl.conttype=''1''  and hl.endcasedate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
 
 
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12469;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12471 IS   V_ID NUMBER :=12471;  V_SQL_ID NUMBER :=12471;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='
select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''01'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       h2.contno PolicyNo,
      h3.polno  ProductNo,
      hc.insuredno  InsuredNo,
      ''2'' BnfCat,
       hc.contno BnfSerialNum,
       ''1'' BnfLevel,
       ''00'' RelationToInsured,
       ''1'' PercentOfBenefit,
      hc.insuredno ICCustomerNo,
        '''' CustomerNo,
        hc.insuredfirstname||'' ''||hc.insuredsurname Name,
        (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=hc.sex) Sex,
        hc.birthday BirthDate,
        (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) CertType,
        hc.idno CertNo,
        to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
left join ODS_STG.HNW_hcpol h3 on hc.grpcontno=h3.grpcontno and hc.contno=h3.contno
where 1=1 and (h1.othernotype=''1'' and h1.tempfeetype=''8'') and  h1.conttype=''1'' 
     and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
                 
union all

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''02'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       h2.contno PolicyNo,
       h3.polno  ProductNo,
       hc.insuredno  InsuredNo,
       ''2'' BnfCat,
        hc.contno BnfSerialNum,
        ''1'' BnfLevel,
        ''00'' RelationToInsured,
        ''1'' PercentOfBenefit,
       hc.insuredno ICCustomerNo,
        '''' CustomerNo,
        hc.insuredfirstname||'' ''||hc.insuredsurname Name,
        (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=hc.sex) Sex,
        hc.birthday BirthDate,
        (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) CertType,
        hc.idno CertNo,
        to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
left join ODS_STG.HNW_hcpol h3 on hc.grpcontno=h3.grpcontno and hc.contno=h3.contno
where 1=1 and (h1.othernotype in (''1'', ''2'') and h1.tempfeetype=''9'') and h1.conttype=''1''  
      and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
      
      
      
      
      
      

'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12471;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12834 IS   V_ID NUMBER :=12834;  V_SQL_ID NUMBER :=12866;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='select ''IncResultQuery'' as RequestType,''#{companyCode}'' as CompanyCode,''#{serialNo}'' as SerialNo,''#{dateSerialNo}'' as TimeStamp,''L'' as DataType from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12834;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12835 IS   V_ID NUMBER :=12835;  V_SQL_ID NUMBER :=12867;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='select tr.queryno AS QueryNo  from T_PRP_LCPOLTRANSACTION_return tr where  tr.stateflag in (''4'', ''4W'', ''5E'')   and tr.status in (''0000'', ''0001'')   and queryno is not null   and tr.batchno = ''#{batchNo}''   and exists (select ''X''          from T_PRP_lcpoltransaction t         where t.batchno = tr.batchno           and t.stateflag in (''4'', ''4W'', ''5E'')           and t.transtype = ''INC'')'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12835;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_999 IS   V_ID NUMBER :=999;  V_SQL_ID NUMBER :=999;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='SELECT batchNo AS batchNo,
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
GROUP BY BATCHNO,STATEFLAG,transType'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 999;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_993 IS   V_ID NUMBER :=993;  V_SQL_ID NUMBER :=993;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='select distinct batchNo,stateFlag,(select code_name from t_def_code_dict where code_type = ''BUSSFLAG'' and COM_ID = 1 and code = stateflag) as stateFlagName from T_PRP_LCPoltransaction where 1 = 1 and transdate >= to_date(''#{startDate}'',''yyyy-mm-dd'') and TransDate <= to_date(''#{endDate}'',''yyyy-mm-dd'') '; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 993;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_998 IS   V_ID NUMBER :=998;  V_SQL_ID NUMBER :=998;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :=''; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 998;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_997 IS   V_ID NUMBER :=997;  V_SQL_ID NUMBER :=997;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :=''; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 997;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_996 IS   V_ID NUMBER :=996;  V_SQL_ID NUMBER :=996;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :=''; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 996;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_995 IS   V_ID NUMBER :=995;  V_SQL_ID NUMBER :=995;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :=''; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 995;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_994 IS   V_ID NUMBER :=994;  V_SQL_ID NUMBER :=994;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :=''; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 994;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12453 IS   V_ID NUMBER :=12453;  V_SQL_ID NUMBER :=12453;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE  FROM T_PRP_LJAPay where transactionno in (select transactionno from T_PRP_LCPolTransaction where transdate between to_date(''#{startDate}'', ''yyyy-mm-dd'') and to_date(''#{endDate}'', ''yyyy-mm-dd''))
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12453;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10625 IS   V_ID NUMBER :=10625;  V_SQL_ID NUMBER :=10645;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='select ''PDL-Head'' as "PDL-Head",''PDL-Body'' as "PDL-Body" from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10625;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10627 IS   V_ID NUMBER :=10627;  V_SQL_ID NUMBER :=10647;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='SELECT LCPT.BATCHNO AS BatchNo,       MAX(TO_CHAR(LCPT.TRANSDATE, ''yyyymmdd'')) AS TransDate,       COUNT(1) AS TransCount,       EDP.PAGE_NAME AS FileName,       EDP.MD5_CODE AS FileMD5No  FROM T_PRP_LCPOLTRANSACTION LCPT, T_DOC_MAIN EDM, T_DOC_PAGES EDP WHERE LCPT.BATCHNO = EDM.BATCH_NO   AND EDM.DOC_ID = EDP.DOC_ID   AND LCPT.BATCHNO = ''#{batchNo}''   AND LCPT.TRANSTYPE = ''HIS'' GROUP BY LCPT.BATCHNO,          EDP.PAGE_ID,          EDP.PAGE_NAME,          EDP.MD5_CODE,          EDM.DOC_ID'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10627;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10626 IS   V_ID NUMBER :=10626;  V_SQL_ID NUMBER :=10646;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='select ''HisUpload'' as RequestType,''#{companyCode}'' as CompanyCode,''#{serialNo}'' as SerialNo,''#{dateSerialNo}'' as TimeStamp,''L'' as DataType from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10626;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_11376 IS   V_ID NUMBER :=11376;  V_SQL_ID NUMBER :=11396;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='select ''PDL-Head'' as "PDL-Head",''PDL-Body'' as "PDL-Body" from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 11376;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_11377 IS   V_ID NUMBER :=11377;  V_SQL_ID NUMBER :=11397;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='select ''SummaryCheckResultQuery'' as RequestType,''#{companyCode}'' as CompanyCode,''#{serialNo}'' as SerialNo,''#{dateSerialNo}'' as TimeStamp,''L'' as DataType from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 11377;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_11378 IS   V_ID NUMBER :=11378;  V_SQL_ID NUMBER :=11398;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='select LCPT.queryno AS QueryNo            from T_PRP_lcpoltransaction_return  LCPT            where batchno = ''#{batchNo}''            and status in (''0000'', ''0001'')               and stateflag = ''5W''               and queryno is not NULL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 11378;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_11526 IS   V_ID NUMBER :=11526;  V_SQL_ID NUMBER :=11533;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='select ''PDL-Head'' as "PDL-Head",''PDL-Body'' as "PDL-Body" from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 11526;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_11527 IS   V_ID NUMBER :=11527;  V_SQL_ID NUMBER :=11534;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :=' select ''IncUpload'' as RequestType,''#{companyCode}'' as CompanyCode,''#{serialNo}'' as SerialNo,''#{dateSerialNo}'' as TimeStamp,''L'' as DataType from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 11527;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_11362 IS   V_ID NUMBER :=11362;  V_SQL_ID NUMBER :=11382;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='select ''DetailUpload'' as RequestType,''#{companyCode}'' as CompanyCode,''#{serialNo}'' as SerialNo,''#{dateSerialNo}'' as TimeStamp,''L'' as DataType from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 11362;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_11368 IS   V_ID NUMBER :=11368;  V_SQL_ID NUMBER :=11388;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='select ''DetailResultUpload'' as RequestType,''#{companyCode}'' as CompanyCode,''#{serialNo}'' as SerialNo,''#{dateSerialNo}'' as TimeStamp,''L'' as DataType from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 11368;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_11361 IS   V_ID NUMBER :=11361;  V_SQL_ID NUMBER :=11381;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='select ''PDL-Head'' as "PDL-Head",''PDL-Body'' as "PDL-Body" from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 11361;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_11363 IS   V_ID NUMBER :=11363;  V_SQL_ID NUMBER :=11383;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='select lcpt.batchno as BatchNo,       max(to_char(lcpt.TransDate, ''yyyymmdd'')) as TransDate,       count(1)  as TransCount,       edp.Page_Name as FileName,       edp.MD5_Code as FileMD5No  from T_PRP_LCPolTransaction lcpt, T_doc_main edm, T_doc_pages edp where lcpt.batchno = edm.batch_no   and edm.doc_id = edp.doc_id  and lcpt.batchNo =''#{batchNo}''   and lcpt.stateflag = ''6'' group by lcpt.batchno,          edp.page_id,          edp.Page_Name,          edp.MD5_Code,          edm.doc_id'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 11363;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_11367 IS   V_ID NUMBER :=11367;  V_SQL_ID NUMBER :=11387;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='select ''PDL-Head'' as "PDL-Head",''PDL-Body'' as "PDL-Body" from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 11367;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_11369 IS   V_ID NUMBER :=11369;  V_SQL_ID NUMBER :=11389;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='select lcpt.queryno as QueryNo          from (select queryno, datastatus, returndocid, status,requestdocid                from T_PRP_lcpoltransaction_return                where batchno = ''#{batchNo}''                and status in (''0000'', ''0001'')                and stateflag = ''6W''               and queryno is not null              order by returndocid desc) lcpt where rownum = 1'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 11369;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12431 IS   V_ID NUMBER :=12431;  V_SQL_ID NUMBER :=12431;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LAAGENT A
   SET A.MANAGECOM = CASE
                       WHEN (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.MANAGECOM = B.BASIC_CODE
                                AND B.CODE_TYPE = ''managecom''
                                AND B.COM_ID = 1) IS NOT NULL THEN
                        (SELECT B.TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE A.MANAGECOM = B.BASIC_CODE
                            AND B.CODE_TYPE = ''managecom''
                            AND B.COM_ID = 1)
                       ELSE
                        A.MANAGECOM
                     END,
       
       A.COMPANYCODE = CASE
                         WHEN (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.COMPANYCODE = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''companycode''
                                  AND B.COM_ID = 1) IS NOT NULL THEN
                          (SELECT B.TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE A.COMPANYCODE = B.BASIC_CODE
                              AND B.CODE_TYPE = ''companycode''
                              AND B.COM_ID = 1)
                         ELSE
                          A.COMPANYCODE
                       END,
       A.SEX = case
                 when
                 
                  (SELECT B.TARGET_CODE
                     FROM T_DEF_CODE_MAPPING B
                    WHERE A.SEX = B.BASIC_CODE
                      AND B.CODE_TYPE = ''sex''
                      AND B.COM_ID = 1) is not null then
                  (SELECT B.TARGET_CODE
                     FROM T_DEF_CODE_MAPPING B
                    WHERE A.SEX = B.BASIC_CODE
                      AND B.CODE_TYPE = ''sex''
                      AND B.COM_ID = 1)
                 else
                  a.sex
               end,
       A.OFFICEWORKFLAG = case
                            when (SELECT B.TARGET_CODE
                                    FROM T_DEF_CODE_MAPPING B
                                   WHERE A.OFFICEWORKFLAG = B.BASIC_CODE
                                     AND B.CODE_TYPE = ''officeworkflag''
                                     AND B.COM_ID = 1) is not null then
                             (SELECT B.TARGET_CODE
                                FROM T_DEF_CODE_MAPPING B
                               WHERE A.OFFICEWORKFLAG = B.BASIC_CODE
                                 AND B.CODE_TYPE = ''officeworkflag''
                                 AND B.COM_ID = 1)
                            else
                             a.officeworkflag
                          end,
       A.FULLTIMEFLAG = case
                          when (SELECT B.TARGET_CODE
                                  FROM T_DEF_CODE_MAPPING B
                                 WHERE A.FULLTIMEFLAG = B.BASIC_CODE
                                   AND B.CODE_TYPE = ''fulltimeflag''
                                   AND B.COM_ID = 1) is not null then
                           (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.FULLTIMEFLAG = B.BASIC_CODE
                               AND B.CODE_TYPE = ''fulltimeflag''
                               AND B.COM_ID = 1)
                          else
                           a.fulltimeflag
                        end,
       A.CERTTYPE = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.CERTTYPE = B.BASIC_CODE
                               AND B.CODE_TYPE = ''certtype''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.CERTTYPE = B.BASIC_CODE
                           AND B.CODE_TYPE = ''certtype''
                           AND B.COM_ID = 1)
                      else
                       a.certtype
                    end,
       A.AGENTSIGNFLAG = case
                           when (SELECT B.TARGET_CODE
                                   FROM T_DEF_CODE_MAPPING B
                                  WHERE A.AGENTSIGNFLAG = B.BASIC_CODE
                                    AND B.CODE_TYPE = ''agentsignflag''
                                    AND B.COM_ID = 1) is not null then
                            (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.AGENTSIGNFLAG = B.BASIC_CODE
                                AND B.CODE_TYPE = ''agentsignflag''
                                AND B.COM_ID = 1)
                           else
                            a.agentsignflag
                         end
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12431;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12434 IS   V_ID NUMBER :=12434;  V_SQL_ID NUMBER :=12434;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE  FROM T_PRP_LMProduct where transactionno in (select transactionno from T_PRP_LCPolTransaction where transdate between to_date(''#{startDate}'', ''yyyy-mm-dd'') and to_date(''#{endDate}'', ''yyyy-mm-dd''))'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12434;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12454 IS   V_ID NUMBER :=12454;  V_SQL_ID NUMBER :=12454;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE  FROM T_PRP_LJDivDistrib where transactionno in (select transactionno from T_PRP_LCPolTransaction where transdate between to_date(''#{startDate}'', ''yyyy-mm-dd'') and to_date(''#{endDate}'', ''yyyy-mm-dd''))
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12454;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12461 IS   V_ID NUMBER :=12461;  V_SQL_ID NUMBER :=12461;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='
--新单(承保)
select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''01'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       h5.polno ProductNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''conttype'' and ORIGINCODE=h1.conttype) GPFlag,
       ''1'' PolTypeFlag,
       h5.polno MainProductNo,
       ''1'' MainProductFlag,
       h5.riskcode ProductCode,
       h1.managecom ManageCom,
       h5.cvalidate EffDate,
       h5.firstpaydate PayBeginDate,
       h5.payenddate FinalPayDate,
       h5.paytodate CurPaidToDate,
       '''' AnnStartWithdwlDate,
       '''' AnnGetTodwlDate,
       '''' PenStartWithdwlDate,
       '''' PenGetTodwlDate,
       h5.enddate InvalidDate,
       nvl((select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''payintv'' and ORIGINCODE=h5.payintv),''99'') PayMode,
       ''Y'' PayTermType,
       h5.payyears PayTerm,
       ''Y'' InsurancePeriodFlag,
       h5.years InsurancePeriod,
       h5.mult Copies,
       h5.sumprem Premium,
       h5.sumprem AccumPremium,
       h5.amnt BasicSumInsured,
       h5.riskamnt RiskAmnt,
       0 CashValue,
       0 AccumDiv,
       0 AccumDivInt,
       0 AccumDivSI,
       '''' LstDistriDate,
       0 SurrenderAmnt,
       0 AccumAnnuityWD,
       0 AccumMaturityWD,
       h5.sumprem AccumClmBenefit,
       h5.claimtimes AccumClmTimes,
       case when hc.relationtomaininsured =''00'' then ''01'' else ''02'' end InsuredType,
       ''10'' UWConclusion,
       ''1'' Status,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
left join ODS_STG.HNW_hcpol h5 on hc.grpcontno=h5.grpcontno and hc.contno=h5.contno 
where 1=1 and (h1.othernotype=''1'' and h1.tempfeetype=''8'') and  h1.conttype=''1'' 
     and h1.enteraccdate  BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

union all
--新单（续期）

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''02'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=h2.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       h5.polno ProductNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''conttype'' and ORIGINCODE=h1.conttype) GPFlag,
       ''1'' PolTypeFlag,
       h5.polno MainProductNo,
       ''1'' MainProductFlag,
       h5.riskcode ProductCode,
       h1.managecom ManageCom,
       h5.cvalidate EffDate,
       h5.firstpaydate PayBeginDate,
       h5.payenddate FinalPayDate,
       h5.paytodate CurPaidToDate,
       '''' AnnStartWithdwlDate,
       '''' AnnGetTodwlDate,
       '''' PenStartWithdwlDate,
       '''' PenGetTodwlDate,
       h5.enddate InvalidDate,
       nvl((select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''payintv'' and ORIGINCODE=h5.payintv),''99'') PayMode,
       ''Y'' PayTermType,
       h5.payyears PayTerm,
       ''Y'' InsurancePeriodFlag,
       h5.years InsurancePeriod,
       h5.mult Copies,
       h5.sumprem Premium,
       h5.sumprem AccumPremium,
       h5.amnt BasicSumInsured,
       h5.riskamnt RiskAmnt,
       0 CashValue,
       0 AccumDiv,
       0AccumDivInt,
       0 AccumDivSI,
       '''' LstDistriDate,
       0 SurrenderAmnt,
       0 AccumAnnuityWD,
       0 AccumMaturityWD,
       h5.sumprem AccumClmBenefit,
       h5.claimtimes AccumClmTimes,
       case when hc.relationtomaininsured =''00'' then ''01'' else ''02'' end InsuredType,
       ''10'' UWConclusion,
       ''1'' Status,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
left join ODS_STG.HNW_hcpol h5 on hc.grpcontno=h5.grpcontno and hc.contno=h5.contno 
where 1=1 and (h1.othernotype in (''1'', ''2'') and h1.tempfeetype=''9'') and h1.conttype=''1''  
      and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

union all

--保全收费(非定结)

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''03'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       h5.polno ProductNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''conttype'' and ORIGINCODE=h1.conttype) GPFlag,
       ''1'' PolTypeFlag,
       h5.polno MainProductNo,
       ''1'' MainProductFlag,
       h5.riskcode ProductCode,
       h1.managecom ManageCom,
       h5.cvalidate EffDate,
       h5.firstpaydate PayBeginDate,
       h5.payenddate FinalPayDate,
       h5.paytodate CurPaidToDate,
       '''' AnnStartWithdwlDate,
       '''' AnnGetTodwlDate,
       '''' PenStartWithdwlDate,
       '''' PenGetTodwlDate,
       h5.enddate InvalidDate,
       nvl((select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''payintv'' and ORIGINCODE=h5.payintv),''99'') PayMode,
       ''Y'' PayTermType,
       h5.payyears PayTerm,
       ''Y'' InsurancePeriodFlag,
       h5.years InsurancePeriod,
       h5.mult Copies,
       h5.sumprem Premium,
       h5.sumprem AccumPremium,
       h5.amnt BasicSumInsured,
       h5.riskamnt RiskAmnt,
       0 CashValue,
       0 AccumDiv,
       0 AccumDivInt,
       0 AccumDivSI,
       '''' LstDistriDate,
       0 SurrenderAmnt,
       0 AccumAnnuityWD,
       0 AccumMaturityWD,
       h5.sumprem AccumClmBenefit,
       h5.claimtimes AccumClmTimes,
       case when hc.relationtomaininsured =''00'' then ''01'' else ''02'' end InsuredType,
       ''10'' UWConclusion,
       ''1'' Status,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate

from ODS_STG.HNW_hjapay h1
inner join (select endorno, grpcontno, contno,feefinatype as feefinatype,sum(getmoney) as sumactupaymoney
  from ODS_STG.HNW_hejsgetendorse
 group by endorno, grpcontno, contno,feefinatype) h2 on h1.otherno=h2.endorno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
left join ODS_STG.HNW_hcpol h5 on hc.grpcontno=h5.grpcontno and hc.contno=h5.contno
where (h1.othernotype = ''2'' and h1.incometype = ''0'')  and h1.conttype=''1'' 
      and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

union all
--保全付费（非定结）

select ''G''||substr(hj1.actugetno,12)||substr(h2.contno,11)||''04'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       h5.polno ProductNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''conttype'' and ORIGINCODE=h.conttype) GPFlag,
       ''1'' PolTypeFlag,
       h5.polno MainProductNo,
       ''1'' MainProductFlag,
       h5.riskcode ProductCode,
       hj1.managecom ManageCom,
       h5.cvalidate EffDate,
       h5.firstpaydate PayBeginDate,
       h5.payenddate FinalPayDate,
       h5.paytodate CurPaidToDate,
       '''' AnnStartWithdwlDate,
       '''' AnnGetTodwlDate,
       '''' PenStartWithdwlDate,
       '''' PenGetTodwlDate,
       h5.enddate InvalidDate,
      nvl((select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''payintv'' and ORIGINCODE=h5.payintv),''99'') PayMode,
       ''Y'' PayTermType,
       h5.payyears PayTerm,
       ''Y'' InsurancePeriodFlag,
       h5.years InsurancePeriod,
       h5.mult Copies,
       h5.sumprem Premium,
       h5.sumprem AccumPremium,
       h5.amnt BasicSumInsured,
       h5.riskamnt RiskAmnt,
       0 CashValue,
       0 AccumDiv,
       0 AccumDivInt,
       0 AccumDivSI,
       '''' LstDistriDate,
       0 SurrenderAmnt,
       0 AccumAnnuityWD,
       0 AccumMaturityWD,
       h5.sumprem AccumClmBenefit,
       h5.claimtimes AccumClmTimes,
       case when hc.relationtomaininsured =''00'' then ''01'' else ''02'' end InsuredType,
       ''10'' UWConclusion,
       ''1'' Status,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate

from ODS_STG.HNW_hjaget hj1
inner join (select endorno, grpcontno, contno,feefinatype as feefinatype,sum(getmoney) as sumactupaymoney
  from ODS_STG.HNW_hejsgetendorse 
 group by endorno, grpcontno, contno,feefinatype) h2 on hj1.otherno = h2.endorno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
left join ODS_STG.HNW_hcpol h5 on hc.grpcontno=h5.grpcontno and hc.contno=h5.contno 
left join ODS_STG.HNW_hcgrpcont h on h.grpcontno=hj1.grpcontno
where 1=1 and (hj1.othernotype = ''2'' and hj1.tempfeetype = ''4'') and hj1.conttype=''1'' 
and hj1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12461;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12464 IS   V_ID NUMBER :=12464;  V_SQL_ID NUMBER :=12464;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCPRODUCT A
   SET A.GPFLAG = (CASE
                    WHEN A.GPFLAG IN (SELECT BASIC_CODE
                                        FROM T_DEF_CODE_MAPPING
                                       WHERE CODE_TYPE = ''gpflag''
                                         AND COM_ID = ''1'') THEN
                     (SELECT TARGET_CODE
                        FROM T_DEF_CODE_MAPPING B
                       WHERE B.CODE_TYPE = ''gpflag''
                         AND A.GPFLAG = B.BASIC_CODE
                         AND B.COM_ID = ''1'')
                    ELSE
                     A.GPFLAG
                  END),
       A.POLTYPEFLAG = (CASE
                         WHEN A.POLTYPEFLAG IN
                              (SELECT BASIC_CODE
                                 FROM T_DEF_CODE_MAPPING
                                WHERE CODE_TYPE = ''poltypeflag''
                                  AND COM_ID = ''1'') THEN
                          (SELECT TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE B.CODE_TYPE = ''poltypeflag''
                              AND A.POLTYPEFLAG = B.BASIC_CODE
                              AND B.COM_ID = ''1'')
                         ELSE
                          A.POLTYPEFLAG
                       END),
       A.MAINPRODUCTFLAG = (CASE
                             WHEN A.MAINPRODUCTFLAG IN
                                  (SELECT BASIC_CODE
                                     FROM T_DEF_CODE_MAPPING
                                    WHERE CODE_TYPE = ''mainproductflag''
                                      AND COM_ID = ''1'') THEN
                              (SELECT TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE B.CODE_TYPE = ''mainproductflag''
                                  AND A.MAINPRODUCTFLAG = B.BASIC_CODE
                                  AND B.COM_ID = ''1'')
                             ELSE
                              A.MAINPRODUCTFLAG
                           END),
       A.MANAGECOM = (CASE
                       WHEN A.MANAGECOM IN
                            (SELECT BASIC_CODE
                               FROM T_DEF_CODE_MAPPING
                              WHERE CODE_TYPE = ''managecom''
                                AND COM_ID = ''1'') THEN
                        (SELECT TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE B.CODE_TYPE = ''managecom''
                            AND A.MANAGECOM = B.BASIC_CODE
                            AND B.COM_ID = ''1'')
                       ELSE
                        A.MANAGECOM
                     END),
       A.PAYMODE = (CASE
                     WHEN A.PAYMODE IN (SELECT BASIC_CODE
                                          FROM T_DEF_CODE_MAPPING
                                         WHERE CODE_TYPE = ''paymode''
                                           AND COM_ID = ''1'') THEN
                      (SELECT TARGET_CODE
                         FROM T_DEF_CODE_MAPPING B
                        WHERE B.CODE_TYPE = ''paymode''
                          AND A.PAYMODE = B.BASIC_CODE
                          AND B.COM_ID = ''1'')
                     ELSE
                      A.PAYMODE
                   END),
       A.PAYTERMTYPE = (CASE
                         WHEN A.PAYTERMTYPE IN
                              (SELECT BASIC_CODE
                                 FROM T_DEF_CODE_MAPPING
                                WHERE CODE_TYPE = ''paytermtype''
                                  AND COM_ID = ''1'') THEN
                          (SELECT TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE B.CODE_TYPE = ''paytermtype''
                              AND A.PAYTERMTYPE = B.BASIC_CODE
                              AND B.COM_ID = ''1'')
                         ELSE
                          A.PAYTERMTYPE
                       END),
       A.INSURANCEPERIODFLAG = (CASE
                                 WHEN A.INSURANCEPERIODFLAG IN
                                      (SELECT BASIC_CODE
                                         FROM T_DEF_CODE_MAPPING
                                        WHERE CODE_TYPE =
                                              ''insuranceperiodflag''
                                          AND COM_ID = ''1'') THEN
                                  (SELECT TARGET_CODE
                                     FROM T_DEF_CODE_MAPPING B
                                    WHERE B.CODE_TYPE = ''insuranceperiodflag''
                                      AND A.INSURANCEPERIODFLAG = B.BASIC_CODE
                                      AND B.COM_ID = ''1'')
                                 ELSE
                                  A.INSURANCEPERIODFLAG
                               END),
       A.INSUREDTYPE = (CASE
                         WHEN A.INSUREDTYPE IN
                              (SELECT BASIC_CODE
                                 FROM T_DEF_CODE_MAPPING
                                WHERE CODE_TYPE = ''insuredtype''
                                  AND COM_ID = ''1'') THEN
                          (SELECT TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE B.CODE_TYPE = ''insuredtype''
                              AND A.INSUREDTYPE = B.BASIC_CODE
                              AND B.COM_ID = ''1'')
                         ELSE
                          A.INSUREDTYPE
                       END),
       A.UWCONCLUSION = (CASE
                          WHEN A.UWCONCLUSION IN
                               (SELECT BASIC_CODE
                                  FROM T_DEF_CODE_MAPPING
                                 WHERE CODE_TYPE = ''uwconclusion''
                                   AND COM_ID = ''1'') THEN
                           (SELECT TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE B.CODE_TYPE = ''uwconclusion''
                               AND A.UWCONCLUSION = B.BASIC_CODE
                               AND B.COM_ID = ''1'')
                          ELSE
                           A.UWCONCLUSION
                        END),
       A.STATUS = (CASE
                    WHEN A.STATUS IN (SELECT BASIC_CODE
                                        FROM T_DEF_CODE_MAPPING
                                       WHERE CODE_TYPE = ''polstatus''
                                         AND COM_ID = ''1'') THEN
                     (SELECT TARGET_CODE
                        FROM T_DEF_CODE_MAPPING B
                       WHERE B.CODE_TYPE = ''polstatus''
                         AND A.STATUS = B.BASIC_CODE
                         AND B.COM_ID = ''1'')
                    ELSE
                     A.STATUS
                  END)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12464;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12428 IS   V_ID NUMBER :=12428;  V_SQL_ID NUMBER :=12428;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='--新单(承保)
select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''01'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=h1.comcode) CompanyCode,
       ht.agentcode AgentCode,
       h2.contno PolicyNo,
       h1.managecom ManageCom,
       h1.agentcode AgencyCode,
       ha.name AgencyName,
       ha.name Name,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=va.sex) Sex,
       va.birthday BirthDate,
       '''' QuafCertNo,
       ha.IndueforMdate CertStartDate,
       ha.OutWorkDate CertEndDate,
       '''' AgencyFlag,
       ha.insideflag OfficeWorkFlag,
       '''' FullTimeFlag,
       ''1'' AgentSignFlag,
       ''000000'' BusiDevCertifNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=va.idnotype) CertType,
       ha.idno CertNo,
       '''' SaleJudge,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
inner join ODS_STG.HNW_hccont ht on hc.grpcontno=ht.grpcontno and ht.contno=hc.contno
left join ODS_STG.HNW_haagent ha on ht.agentcode=ha.agentcode
left join ODS_STG.HNW_vw_agent va on ht.agentcode=va.agentcode
left join ODS_STG.HNW_vw_agentcom hm on ht.agentcode=hm.agentcom
where 1=1 and (h1.othernotype=''1'' and h1.tempfeetype=''8'') and  h1.conttype=''1'' 
     and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
                    
union all
--新单（续期）

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''02'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=h1.comcode) CompanyCode,
       ht.agentcode AgentCode,
       h2.contno PolicyNo,
       h1.managecom ManageCom,
       h1.agentcode AgencyCode,
       ha.name AgencyName,
       ha.name Name,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=va.sex) Sex,
       va.birthday BirthDate,
       '''' QuafCertNo,
       ha.IndueforMdate CertStartDate,
       ha.OutWorkDate CertEndDate,
       '''' AgencyFlag,
       ha.insideflag OfficeWorkFlag,
       '''' FullTimeFlag,
        ''1'' AgentSignFlag,
        ''000000'' BusiDevCertifNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=va.idnotype) CertType,
       ha.idno CertNo,
       '''' SaleJudge,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
inner join ODS_STG.HNW_hccont ht on hc.grpcontno=ht.grpcontno and ht.contno=hc.contno
left join ODS_STG.HNW_haagent ha on ht.agentcode=ha.agentcode
left join ODS_STG.HNW_vw_agent va on ht.agentcode=va.agentcode
left join ODS_STG.HNW_vw_agentcom hm on ht.agentcode=hm.agentcom
where 1=1 and (h1.othernotype in (''1'', ''2'') and h1.tempfeetype=''9'') and h1.conttype=''1''  
      and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
         
         
union all

--保全收费(非定结)

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''03'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=h1.comcode) CompanyCode,
       ht.agentcode AgentCode,
       h2.contno PolicyNo,
       h1.managecom ManageCom,
       h1.agentcode AgencyCode,
       ha.name AgencyName,
       ha.name Name,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=va.sex) Sex,
       va.birthday BirthDate,
       '''' QuafCertNo,
       ha.IndueforMdate CertStartDate,
       ha.OutWorkDate CertEndDate,
       '''' AgencyFlag,
       ha.insideflag OfficeWorkFlag,
       '''' FullTimeFlag,
        ''1'' AgentSignFlag,
        ''000000'' BusiDevCertifNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=va.idnotype) CertType,
       ha.idno CertNo,
       '''' SaleJudge,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join (select endorno, grpcontno, contno,feefinatype as feefinatype,sum(getmoney) as sumactupaymoney
  from ODS_STG.HNW_hejsgetendorse
 group by endorno, grpcontno, contno,feefinatype) h2 on h1.otherno=h2.endorno
left join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
inner join ODS_STG.HNW_hccont ht on hc.grpcontno=ht.grpcontno and ht.contno=hc.contno
left join ODS_STG.HNW_haagent ha on ht.agentcode=ha.agentcode
left join ODS_STG.HNW_vw_agent va on ht.agentcode=va.agentcode
left join ODS_STG.HNW_vw_agentcom hm on ht.agentcode=hm.agentcom
where (h1.othernotype = ''2'' and h1.incometype = ''0'')  and h1.conttype=''1'' 
      and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

union all 
--保全付费（非定结）

select ''G''||substr(hj1.actugetno,12)||substr(h2.contno,11)||''04'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       ht.agentcode AgentCode,
       h2.contno PolicyNo,
       hj1.managecom ManageCom,
       hj1.agentcode AgencyCode,
       ha.name AgencyName,
       ha.name Name,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=va.sex) Sex,
       va.birthday BirthDate,
       '''' QuafCertNo,
       ha.IndueforMdate CertStartDate,
       ha.OutWorkDate CertEndDate,
       '''' AgencyFlag,
       ha.insideflag OfficeWorkFlag,
       '''' FullTimeFlag,
        ''1'' AgentSignFlag,
        ''000000'' BusiDevCertifNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=va.idnotype) CertType,
       ha.idno CertNo,
       '''' SaleJudge,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate

from ODS_STG.HNW_hjaget hj1
inner join (select endorno, grpcontno, contno,feefinatype as feefinatype,sum(getmoney) as sumactupaymoney
  from ODS_STG.HNW_hejsgetendorse 
 group by endorno, grpcontno, contno,feefinatype) h2 on hj1.otherno = h2.endorno
left join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
inner join ODS_STG.HNW_hccont ht on hc.grpcontno=ht.grpcontno and ht.contno=hc.contno
left join ODS_STG.HNW_haagent ha on ht.agentcode=ha.agentcode
left join ODS_STG.HNW_vw_agent va on ht.agentcode=va.agentcode
left join ODS_STG.HNW_vw_agentcom hm on ht.agentcode=hm.agentcom
where 1=1 and (hj1.othernotype = ''2'' and hj1.tempfeetype = ''4'') and hj1.conttype=''1'' 
and hj1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

union all

--理赔
select  ''L''||substr(hl.clmno,2)||substr(hc.contno,11)||''05'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hl.comcode) CompanyCode,
       ht.agentcode AgentCode,
       ht.contno PolicyNo,
       hc.managecom ManageCom,
       ht.agentcode AgencyCode,
       ha.name AgencyName,
       ha.name Name,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=va.sex) Sex,
       va.birthday BirthDate,
       '''' QuafCertNo,
       ha.IndueforMdate CertStartDate,
       ha.OutWorkDate CertEndDate,
       '''' AgencyFlag,
       ha.insideflag OfficeWorkFlag,
       '''' FullTimeFlag,
        ''1'' AgentSignFlag,
        ''000000'' BusiDevCertifNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=va.idnotype) CertType,
       ha.idno CertNo,
       '''' SaleJudge,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
  from ODS_STG.HNW_hlclaim hl
  inner join ODS_STG.HNW_hcinsured hc
    on hl.segment1 = hc.contno
inner join ODS_STG.HNW_hccont ht on hc.grpcontno=ht.grpcontno and ht.contno=hc.contno
left join ODS_STG.HNW_haagent ha on ht.agentcode=ha.agentcode
left join ODS_STG.HNW_vw_agent va on ht.agentcode=va.agentcode
left join ODS_STG.HNW_vw_agentcom hm on ht.agentcode=hm.agentcom
 where 1 = 1  and hl.conttype=''1''  and hl.endcasedate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
 
 
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12428;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_11528 IS   V_ID NUMBER :=11528;  V_SQL_ID NUMBER :=11535;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='   SELECT LCPT.BATCHNO AS BatchNo,           MAX(TO_CHAR(LCPT.TRANSDATE, ''yyyymmdd'')) AS TransDate,           COUNT(1) AS TransCount,           EDP.PAGE_NAME AS FileName,           EDP.MD5_CODE AS FileMD5No      FROM T_PRP_LCPOLTRANSACTION LCPT, T_DOC_MAIN EDM, T_DOC_PAGES EDP     WHERE LCPT.BATCHNO = EDM.BATCH_NO       AND EDM.DOC_ID = EDP.DOC_ID       AND LCPT.BATCHNO = ''#{batchNo}''       AND LCPT.TRANSTYPE = ''INC''     GROUP BY LCPT.BATCHNO,              EDP.PAGE_ID,              EDP.PAGE_NAME,              EDP.MD5_CODE,              EDM.DOC_ID'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 11528;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12895 IS   V_ID NUMBER :=12895;  V_SQL_ID NUMBER :=12935;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='select ''PDL-Head'' as "PDL-Head",''PDL-Body'' as "PDL-Body" from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12895;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12896 IS   V_ID NUMBER :=12896;  V_SQL_ID NUMBER :=12936;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='select ''FaiResultQuery'' as RequestType,''#{companyCode}'' as CompanyCode,''#{serialNo}'' as SerialNo,''#{dateSerialNo}'' as TimeStamp,''L'' as DataType from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12896;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12897 IS   V_ID NUMBER :=12897;  V_SQL_ID NUMBER :=12937;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='select lcpt.queryno as QueryNo  from T_PRP_LCPolTransaction_Return lcpt where     lcpt.batchno = ''#{batchNo}''              and lcpt.stateflag in (''4'', ''4W'', ''5E'')   and (lcpt.queryno is not null or trim(lcpt.queryno) <> '''')   and exists (select ''X''          from T_PRP_lcpoltransaction t         where             t.stateflag in (''4'', ''4W'', ''5E'')           and t.transtype = ''FAI'')'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12897;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10675 IS   V_ID NUMBER :=10675;  V_SQL_ID NUMBER :=10699;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='SELECT pc.policy_chg_id as TransactionNo,
       ''000031'' AS CompanyCode,
       '''' AS GrpPolicyNo,
       p.Policy_No as PolicyNo,
       ppps.Policy_Plan_Prem_Sche_ID AS PayNo,
       pd.pd_product_id as ProductNo,
       pd.Product_Code as ProductCode,
       p.Branch_Code as ManageCom,
       (select pcm.Client_ID
          from ods_stg.OFE_T_POL_CLN_MST pcm
         where pcm.policy_id = p.policy_id
           and pcm.client_role = ''1''
           and pcm.rc_state = ''E'') as AppntNo,
       (CASE 
        WHEN NVL(ppps.fee,0)=0
        THEN NVL((SELECT SUM(AMOUNT)
         FROM ODS_STG.OFE_T_POL_PLAN_TOPUP_LIST PTL
        WHERE PTL.POLICY_ID = P.POLICY_ID
          AND PTL.POLICY_PLAN_ID = PP.POLICY_PLAN_ID),0)
         ELSE NVL(ppps.fee,0)
       end)AS SumActuPayMoney,
       ppps.Due_Date AS EnterAccDate,
       ppps.due_date AS ConfDate,
       ppps.Pay_To_Date AS CurPaidToDate,
       (case
         when (select max(bk.bank_branch_code)
                 from ods_stg.OFE_T_BK_ACC_MST bk
                where bk.policy_no = p.policy_no
                  and bk.rc_state = ''E'') is not null then
          (select max(bk.bank_code)
             from ods_stg.OFE_T_BK_ACC_MST bk
            where bk.policy_no = p.policy_no
              and bk.rc_state = ''E'') || ''-'' ||
          (select max(bk.bank_branch_code)
             from ods_stg.OFE_T_BK_ACC_MST bk
            where bk.policy_no = p.policy_no
              and bk.rc_state = ''E'')
         ELSE  
          (select max(bk.bank_code)
             from ods_stg.OFE_T_BK_ACC_MST bk
            where bk.policy_no = p.policy_no
              and bk.rc_state = ''E'')
       end) as BankCode,
       (case
         when (select max(bk.bank_branch_code)
                 from ods_stg.OFE_T_BK_ACC_MST bk
                where bk.policy_no = p.policy_no
                  and bk.rc_state = ''E'') is not null then
          (select max(t.bank_name)
             from ods_stg.OFE_T_BK_ACC_MST bk, ods_stg.OFE_T_CFG_BANK t
            where t.bank_code = bk.bank_code
              and bk.policy_no = p.policy_no) || ''-'' ||
          (select max(tb.bank_branch_name)
             from ods_stg.OFE_T_BK_ACC_MST      bk,
                  ods_stg.OFE_T_CFG_BANK_Branch tb
            where tb.bank_branch_code = bk.bank_branch_code
              and bk.policy_no = p.policy_no)
         else
          (select max(t.bank_name)
             from ods_stg.OFE_T_BK_ACC_MST bk, ods_stg.OFE_T_CFG_BANK t
            where t.bank_code = bk.bank_code
              and bk.policy_no = p.policy_no)
       end) as BankName,
       (select max(bk.bank_acc_no)
          from ods_stg.OFE_T_BK_ACC_MST bk
         where bk.policy_no = p.policy_no
           and bk.rc_state = ''E'') as BankAccNo,
       (select max(bk.bank_owner_name)
          from ods_stg.OFE_T_BK_ACC_MST bk
         where bk.policy_no = p.policy_no
           and bk.rc_state = ''E'') as AccName,
        (CASE WHEN PCM.CLIENT_ID_NO IS NULL THEN ''990'' ELSE PCM.CLIENT_ID_TYPE END)  as CertType,
          NVL(PCM.CLIENT_ID_NO,''99'') as CertNo,
       p.operator_id as operator,
       to_date(to_char(p.insert_time, ''yyyy-mm-dd''), ''yyyy-mm-dd'') as makedate,
       to_char(p.insert_time, ''hh:mm:ss'') as maketime,
       to_date(to_char(sysdate, ''yyyy-mm-dd''), ''yyyy-mm-dd'') as modifydate,
       to_char(sysdate, ''hh:mm:ss'') as modifytime
  from ods_stg.OFE_T_POLICY_CHANGE pc
  left join ODS_STG.OFE_T_POLICY P
    on pc.policy_id = p.policy_id
  LEFT JOIN ODS_STG.OFE_T_POL_PLAN PP
    ON PP.RC_STATE = ''E''
   AND PP.POLICY_ID = P.POLICY_ID
  LEFT JOIN ODS_STG.OFE_T_PD_PRODUCT PD
    ON PD.RC_STATE = ''E''
   AND PD.PD_PRODUCT_ID = PP.PD_PRODUCT_ID
   LEFT JOIN ODS_STG.OFE_T_POL_CLN_MST     PCM 
     ON PCM.RC_STATE = ''E''
     AND PCM.POLICY_ID = P.POLICY_ID
     AND PCM.CLIENT_ROLE = ''1''
  LEFT JOIN ODS_STG.OFE_T_POL_PLAN_PREM PPP
    ON ppp.rc_state = ''E''
   AND ppp.policy_id = p.policy_id
   AND ppp.policy_plan_id = pp.policy_plan_id
  LEFT JOIN ODS_STG.OFE_T_POL_PLAN_PREM_SCHE ppps ON  ppps.rc_state = ''E''
  AND ppps.due_date <= pc.effective_date
  AND ppps.policy_id = p.policy_id 
  AND ppps.policy_plan_id = pp.policy_plan_id
  AND ppps.premium_status = ''2'' --2:已付 1:应付未付
 WHERE P.RC_STATE = ''E''
   AND PD.COVERAGE_TERM_TYPE <> ''M''
   AND NOT EXISTS
 (SELECT 1 FROM ODS_STG.OFE_T_RLS_POLICY A WHERE TO_CHAR(A.PNO) = TO_CHAR(P.POLICY_NO) AND A.FLAG = ''1'')
   and pc.item_id is not null
   and pc.rc_state = ''E''
   AND PC.POLICY_ID = P.POLICY_ID
   AND ppps.policy_plan_id = pp.policy_plan_id
   AND PC.POLICY_CHG_ID > 0
   AND P.POLICY_ID > 0
AND PD.PD_PRODUCT_ID NOT IN (SELECT DISTINCT c.pd_product_id
                                from ODS_STG.OFE_t_Cfg_Plan_Print a,ODS_STG.OFE_t_pd_product_plan b,
                                ODS_STG.OFE_T_POL_PLAN c,ods_stg.OFE_T_PD_PRODUCT d
                                where a.pd_plan_id=b.pd_plan_id 
                                AND d.pd_product_id=c.pd_product_id
                                AND b.pd_product_id=c.pd_product_id 
                                AND a.is_show=0)--需屏蔽的险种     
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
   AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn}) 
   AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'') '; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10675;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10674 IS   V_ID NUMBER :=10674;  V_SQL_ID NUMBER :=10698;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='SELECT 
    PC.POLICY_CHG_ID AS TRANSACTIONNO
    ,''000031'' AS COMPANYCODE
    ,'''' AS GRPPOLICYNO
    ,P.POLICY_NO AS POLICYNO
    ,PD.PD_PRODUCT_ID AS PRODUCTNO
    ,''01'' AS GPFLAG
    ,''1'' AS POLTYPEFLAG
    ,(CASE WHEN PP.POLICY_PLAN_ID = PP.MAIN_PLAN_ID THEN PP.PD_PRODUCT_ID 
      ELSE PD.PD_PRODUCT_ID END) AS MAINPRODUCTNO
    ,(CASE WHEN PP.MAIN_PLAN_ID = PP.POLICY_PLAN_ID THEN ''1'' 
           WHEN PP.MAIN_PLAN_ID != PP.POLICY_PLAN_ID THEN ''2'' ELSE ''3'' END) 
           AS  MAINPRODUCTFLAG
    ,PD.PRODUCT_CODE AS PRODUCTCODE
    ,P.BRANCH_CODE AS MANAGECOM
    ,PP.PLAN_EFFECTIVE_DATE AS EFFDATE
    ,PP.PLAN_EFFECTIVE_DATE AS PAYBEGINDATE
    ,PP.PLAN_PAID_UP_DATE AS FINALPAYDATE
    ,PP.PLAN_PAID_UP_DATE AS CURPAIDTODATE
    ,(SELECT TPP.PLAN_START_DATE FROM ODS_STG.OFE_T_PD_PRODUCT_PLAN TPP 
             WHERE TPP.PD_PRODUCT_ID = PP.PD_PRODUCT_ID 
             AND TPP.PD_PLAN_ID = PP.PD_PLAN_ID) AS ANNSTARTWITHDWLDATE
    ,(SELECT TPP.PLAN_END_DATE FROM ODS_STG.OFE_T_PD_PRODUCT_PLAN TPP 
             WHERE TPP.PD_PRODUCT_ID = PP.PD_PRODUCT_ID 
             AND TPP.PD_PLAN_ID = PP.PD_PLAN_ID) AS ANNGETTODWLDATE
    ,'''' AS PENSTARTWITHDWLDATE
    ,'''' AS PENGETTODWLDATE
    ,NVL(PP.EXPIRED_DATE,TO_DATE(''9999-12-25'',''yyyy-mm-dd'')) AS INVALIDDATE
    ,NVL(PP.PAY_MODE,''99'') AS PAYMODE
    ,NVL(PP.PAY_START_TYPE,''Y'') AS PAYTERMTYPE
    ,PP.PREM_PAYMENT_PERIOD AS PAYTERM
    ,PP.PLAN_TERM_TYPE AS INSURANCEPERIODFLAG
    ,PP.PLAN_TERM AS INSURANCEPERIOD
    ,NVL(TO_NUMBER(PP.UNIT),0) AS COPIES
      ,NVL(PP.SUM_ASSURED,0) AS PREMIUM
    ,NVL(PP.ANNUAL_PREMIUM,0.00) AS ACCUMPREMIUM
    ,NVL(PP.SUM_ASSURED,0) AS BASICSUMINSURED 
    ,NVL((SELECT SUM(PPR.ACCUM_SA_OF_RISK) FROM ODS_STG.OFE_T_UW_POL_PLAN_REIN PPR 
             WHERE PPR.POLICY_PLAN_ID = PP.POLICY_PLAN_ID 
             AND PPR.RC_STATE = ''E''),0) AS RISKAMNT
    ,(CASE WHEN P.POLICY_STATUS = ''4'' THEN 0 ELSE NVL(CAST((SELECT SUM(ATL.AMOUNT) FROM 
             ODS_STG.OFE_T_POL_ACCOUNT_TRANS_LIST ATL,
             ODS_STG.OFE_T_POL_ACCOUNT TPA 
             WHERE TPA.ACCOUNT_TYPE = ''4'' 
             AND TPA.POL_ACCOUNT_ID = ATL.POL_ACCOUNT_ID 
             AND ATL.POLICY_ID = P.POLICY_ID) AS DECIMAL(16,2)),0) END ) AS CASHVALUE
    ,NVL(CAST((SELECT SUM(ATL.AMOUNT) FROM 
             ODS_STG.OFE_T_POL_ACCOUNT_TRANS_LIST ATL,
             ODS_STG.OFE_T_POL_ACCOUNT TPA 
             WHERE TPA.ACCOUNT_TYPE = ''5'' 
             AND ATL.FEE_CODE=''C'' 
             AND TPA.POL_ACCOUNT_ID = ATL.POL_ACCOUNT_ID 
             AND ATL.POLICY_ID = P.POLICY_ID)  AS DECIMAL(16,2)),0) AS ACCUMDIV
    ,NVL((SELECT SUM(ATL.AMOUNT) FROM 
             ODS_STG.OFE_T_POL_ACCOUNT_TRANS_LIST ATL,
             ODS_STG.OFE_T_POL_ACCOUNT TPA 
             WHERE TPA.ACCOUNT_TYPE = ''5'' 
             AND ATL.FEE_CODE=''I'' 
             AND TPA.POL_ACCOUNT_ID = ATL.POL_ACCOUNT_ID 
             AND ATL.POLICY_ID = P.POLICY_ID ),0) AS ACCUMDIVINT
    ,0 AS ACCUMDIVSI
    ,(SELECT MAX(ATL.TRANS_DATE) FROM 
             ODS_STG.OFE_T_POL_ACCOUNT_TRANS_LIST ATL,
             ODS_STG.OFE_T_POL_ACCOUNT TPA 
             WHERE TPA.ACCOUNT_TYPE = ''5'' 
             AND TPA.POL_ACCOUNT_ID = ATL.POL_ACCOUNT_ID 
             AND ATL.POLICY_ID = P.POLICY_ID ) AS LSTDISTRIDATE
    ,NVL((SELECT SUM(BFD.AMOUNT) FROM ODS_STG.OFE_T_BUSINESS_FEE_DETAIL BFD 
       WHERE BFD.POLICY_ID=P.POLICY_ID 
       AND BFD.RC_STATE=''E'' 
       AND BFD.BUSINESS_TYPE=''52''),0) AS SURRENDERAMNT
    ,0 AS ACCUMANNUITYWD
    ,NVL((SELECT SUM(ATL.AMOUNT) FROM 
             ODS_STG.OFE_T_POL_ACCOUNT_TRANS_LIST ATL,
             ODS_STG.OFE_T_POL_ACCOUNT TPA 
             WHERE TPA.ACCOUNT_TYPE = ''11'' 
             AND TPA.POL_ACCOUNT_ID = ATL.POL_ACCOUNT_ID 
             AND ATL.POLICY_ID = P.POLICY_ID ),0) AS ACCUMMATURITYWD
    ,NVL((SELECT SUM(BFD.AMOUNT) FROM ODS_STG.OFE_T_BUSINESS_FEE_DETAIL BFD 
      WHERE BFD.POLICY_ID=P.POLICY_ID
       AND BFD.RC_STATE=''E'' 
       AND BFD.BUSINESS_TYPE=''3''),0) AS ACCUMCLMBENEFIT
    ,(SELECT SUM(TPB.CLAIM_TIMES) FROM 
             ODS_STG.OFE_T_PD_PLAN_BENEFIT TPB,
             ODS_STG.OFE_T_PD_PRODUCT PD 
             WHERE TPB.PD_PLAN_ID = PP.PD_PLAN_ID
             AND TPB.RC_STATE = ''E''
             AND PD.PD_PRODUCT_ID = PP.PD_PRODUCT_ID
             ) AS ACCUMCLMTIMES
    ,''01'' AS INSUREDTYPE
    ,(SELECT  MAX(UT.UW_DECISION) FROM 
             ODS_STG.OFE_T_UW_POL_PLAN_MST UT 
             WHERE UT.POL_PLAN_ID = PP.POLICY_PLAN_ID) AS UWCONCLUSION
    ,PP.PLAN_STATUS AS STATUS
    ,P.OPERATOR_ID AS OPERATOR
    ,TO_DATE(TO_CHAR(SYSDATE,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MAKEDATE,
     TO_CHAR(SYSDATE,''hh24:mi:ss'') AS MAKETIME,
     TO_DATE(TO_CHAR(SYSDATE,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MODIFYDATE,
     TO_CHAR(SYSDATE,''hh24:mi:ss'') AS MODIFYTIME
FROM ODS_STG.OFE_T_POLICY_CHANGE PC
LEFT JOIN ODS_STG.OFE_T_POLICY P ON P.RC_STATE = ''E'' AND P.POLICY_ID = PC.POLICY_ID
LEFT JOIN ODS_STG.OFE_T_POL_PLAN PP 
     ON PP.RC_STATE = ''E'' 
     AND PP.POLICY_ID = P.POLICY_ID 
LEFT JOIN ODS_STG.OFE_T_PD_PRODUCT PD 
     ON PD.RC_STATE = ''E'' 
     AND PD.PD_PRODUCT_ID = PP.PD_PRODUCT_ID
WHERE 1 = 1
  AND PD.BASIC_PRODUCT_FLAG = ''B'' 
  AND PD.COVERAGE_TERM_TYPE <> ''M''
  AND P.RC_STATE = ''E''
  AND NOT EXISTS(
      SELECT 1 FROM ODS_STG.OFE_T_RLS_POLICY A WHERE TO_CHAR(A.PNO) = TO_CHAR(P.POLICY_NO) AND A.FLAG = ''1'' 
  )
  AND PC.RC_STATE = ''E''
  AND PC.POLICY_ID = P.POLICY_ID 
  AND PC.POLICY_CHG_ID > 0
  AND P.POLICY_ID > 0
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
  AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn}) 
  AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10674;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12528 IS   V_ID NUMBER :=12528;  V_SQL_ID NUMBER :=12547;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='  DELETE FROM  T_PRP_LJDivDistrib T WHERE NOT EXISTS (SELECT ''x'' FROM T_PRP_LCPolTransaction TT WHERE T.TRANSACTIONNO = TT.TRANSACTIONNO AND TT.Policyno = T.policyNo)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12528;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12523 IS   V_ID NUMBER :=12523;  V_SQL_ID NUMBER :=12542;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE FROM  T_PRP_LJAGet T WHERE NOT EXISTS (SELECT ''x'' FROM T_PRP_LCPolTransaction TT WHERE T.TRANSACTIONNO = TT.TRANSACTIONNO AND TT.Policyno = T.policyNo)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12523;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12525 IS   V_ID NUMBER :=12525;  V_SQL_ID NUMBER :=12544;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='  DELETE FROM  T_PRP_LJAGet T WHERE NOT EXISTS (SELECT ''x'' FROM T_PRP_LCPolTransaction TT WHERE TT.Policyno = T.policyNo)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12525;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12526 IS   V_ID NUMBER :=12526;  V_SQL_ID NUMBER :=12545;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :=' DELETE FROM  T_PRP_LJAGetLivBene T where T.policyno NOT IN  (select cc.policyno from T_PRP_LCCont cc)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12526;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12529 IS   V_ID NUMBER :=12529;  V_SQL_ID NUMBER :=12548;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE FROM  T_PRP_LASales T WHERE NOT EXISTS (SELECT ''x'' FROM T_PRP_LCPolTransaction TT WHERE T.TRANSACTIONNO = TT.TRANSACTIONNO AND TT.Policyno = T.policyNo)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12529;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12531 IS   V_ID NUMBER :=12531;  V_SQL_ID NUMBER :=12550;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE FROM  T_PRP_LAAgent T WHERE NOT EXISTS (SELECT ''x'' FROM T_PRP_LCPolTransaction TT WHERE T.TRANSACTIONNO = TT.TRANSACTIONNO AND TT.Policyno = T.policyNo)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12531;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12532 IS   V_ID NUMBER :=12532;  V_SQL_ID NUMBER :=12551;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='  DELETE FROM  T_PRP_LAAgent T WHERE transactionno NOT IN (SELECT p.transactionno FROM  T_PRP_LCPolTransaction p,T_PRP_LAAgent TT where p.transactionno = TT.transactionno and p.policyno = TT.policyno)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12532;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12533 IS   V_ID NUMBER :=12533;  V_SQL_ID NUMBER :=12552;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE FROM  T_PRP_LJTempFee T WHERE NOT EXISTS (SELECT ''x'' FROM T_PRP_LCCont TT WHERE T.TRANSACTIONNO = TT.TRANSACTIONNO AND TT.Policyno = T.policyNo)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12533;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12534 IS   V_ID NUMBER :=12534;  V_SQL_ID NUMBER :=12553;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE FROM  T_PRP_LMProduct T WHERE NOT EXISTS (SELECT ''x'' FROM T_PRP_LCPolTransaction TT WHERE T.TRANSACTIONNO = TT.TRANSACTIONNO)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12534;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10866 IS   V_ID NUMBER :=10866;  V_SQL_ID NUMBER :=10890;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='SELECT 
       PC.POLICY_CHG_ID AS TRANSACTIONNO,
       ''000031'' AS COMPANYCODE,
       '''' AS GRPPOLICYNO,
       TO_CHAR(P.POLICY_NO) AS POLICYNO,
       PD.PD_PRODUCT_ID AS PRODUCTNO,
       TO_CHAR(GETS.CND_ID) AS WDNO,
       PCM.CLIENT_ID AS APPNTNO,
       (SELECT T.CLIENT_ID
          FROM ODS_STG.OFE_T_POL_CLN_MST T
         WHERE T.CLIENT_ROLE = ''2''
           AND T.RC_STATE = ''E''
           AND T.POLICY_ID = P.POLICY_ID) AS INSUREDNO,
       TO_DATE(TO_CHAR(GETS.CND_FINISH_DATE,''YYYY-MM-DD''),''YYYY-MM-DD'') AS BENEFITDATE,
       NVL(GETS.AMOUNT,0) AS BENEFITAMOUNT,
       TO_DATE(TO_CHAR(GETS.CND_FINISH_DATE,''YYYY-MM-DD''),''YYYY-MM-DD'') AS ENTERACCDATE,
       P.BRANCH_CODE AS MANAGECOM,
       (SELECT MAX(PPC.NEXT_DECLARATION_DATE) FROM ODS_STG.OFE_T_POL_PLAN_COVERAGE PPC 
        WHERE PPC.RC_STATE = ''E''  AND PPC.POLICY_ID = P.POLICY_ID 
         AND PPC.PAY_TYPE = ''1'' AND PPC.POLICY_PLAN_ID = PP.POLICY_PLAN_ID) AS WITHDRAWALTODATE,
       (CASE WHEN (SELECT MAX(BK.BANK_BRANCH_CODE) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
       WHERE BK.POLICY_NO=P.POLICY_NO AND BK.RC_STATE=''E'') IS NOT NULL 
       THEN (SELECT MAX(BK.BANK_CODE) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
       WHERE BK.POLICY_NO=P.POLICY_NO AND BK.RC_STATE=''E'')
       ||''-''||(SELECT MAX(BK.BANK_BRANCH_CODE) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
       WHERE BK.POLICY_NO=P.POLICY_NO AND BK.RC_STATE=''E'')
       ELSE (SELECT MAX(BK.BANK_CODE) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
       WHERE BK.POLICY_NO=P.POLICY_NO AND BK.RC_STATE=''E'') END) AS BANKCODE,
       (CASE WHEN (SELECT MAX(BK.BANK_BRANCH_CODE) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
       WHERE BK.POLICY_NO=P.POLICY_NO AND BK.RC_STATE=''E'') IS NOT NULL 
       THEN 
       (SELECT MAX(T.BANK_NAME) 
       FROM ODS_STG.OFE_T_BK_ACC_MST BK,ODS_STG.OFE_T_CFG_BANK T 
       WHERE T.BANK_CODE = BK.BANK_CODE AND BK.POLICY_NO=P.POLICY_NO)
       ||''-''||
       (SELECT MAX(TB.BANK_BRANCH_NAME) 
       FROM ODS_STG.OFE_T_BK_ACC_MST BK,ODS_STG.OFE_T_CFG_BANK_BRANCH TB 
       WHERE TB.BANK_BRANCH_CODE = BK.BANK_BRANCH_CODE AND BK.POLICY_NO=P.POLICY_NO)
       ELSE (SELECT MAX(T.BANK_NAME) 
       FROM ODS_STG.OFE_T_BK_ACC_MST  BK,ODS_STG.OFE_T_CFG_BANK T 
       WHERE T.BANK_CODE = BK.BANK_CODE AND BK.POLICY_NO=P.POLICY_NO) 
       END) AS BANKNAME, 
       (SELECT MAX(BK.BANK_ACC_NO) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
       WHERE BK.POLICY_NO=P.POLICY_NO AND BK.RC_STATE=''E'') AS BANKACCNO,   
       (SELECT MAX(BK.BANK_OWNER_NAME) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
       WHERE BK.POLICY_NO=P.POLICY_NO AND BK.RC_STATE=''E'') AS ACCNAME,
           (CASE WHEN PCM.CLIENT_ID_NO IS NULL THEN ''990'' ELSE PCM.CLIENT_ID_TYPE END)  AS CERTTYPE
       ,  NVL(PCM.CLIENT_ID_NO,''99'') AS CERTNO,
      P.OPERATOR_ID AS OPERATOR,
      TO_DATE(TO_CHAR(P.INSERT_TIME,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MAKEDATE,
      TO_CHAR(P.INSERT_TIME,''hh:mm:ss'') AS MAKETIME,
      TO_DATE(TO_CHAR(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MODIFYDATE,
      TO_CHAR(sysdate,''hh:mm:ss'') AS MODIFYTIME 
FROM ODS_STG.OFE_T_POLICY_CHANGE PC
LEFT JOIN ODS_STG.OFE_T_POLICY P
     ON P.RC_STATE = ''E'' AND  PC.POLICY_ID = P.POLICY_ID
LEFT JOIN ODS_STG.OFE_T_POL_PLAN PP
     ON PP.RC_STATE = ''E''
     AND PP.POLICY_ID = P.POLICY_ID
LEFT JOIN ODS_STG.OFE_T_PD_PRODUCT PD
     ON PD.RC_STATE = ''E''
     AND PD.PD_PRODUCT_ID = PP.PD_PRODUCT_ID
LEFT JOIN ODS_STG.OFE_T_POL_CLN_MST PCM 
     ON PCM.RC_STATE = ''E'' AND PCM.POLICY_ID = P.POLICY_ID 
     AND PCM.CLIENT_ROLE = ''1''
RIGHT JOIN (SELECT CM.CND_ID,CM.BUSINESS_TYPE,
   (CASE WHEN CM.BUSINESS_TYPE = ''1'' 
              THEN BUSINESS_NO
         WHEN CM.BUSINESS_TYPE IN (''2'',''4'') 
              THEN (SELECT MAX(TP.POLICY_NO) 
                     FROM ODS_STG.OFE_T_POLICY TP,ODS_STG.OFE_T_POLICY_CHANGE TPC
                     WHERE TPC.RC_STATE = ''E''
                     AND TP.RC_STATE = TPC.RC_STATE
                     AND TP.POLICY_ID = TPC.POLICY_ID
                     AND TPC.CHANGE_ID = CM.BUSINESS_NO)
         WHEN CM.BUSINESS_TYPE = ''3''
              THEN (SELECT MAX(TP.POLICY_NO) 
                 FROM ODS_STG.OFE_T_POLICY TP, ODS_STG.OFE_T_CLAIM_CASE TCC 
                 WHERE TP.RC_STATE = ''E''
                 AND TCC.RC_STATE = TP.RC_STATE
                 AND TCC.POLICY_ID = TP.POLICY_ID
                 AND TCC.CASE_ID = CM.BUSINESS_NO  )
         ELSE BUSINESS_NO END) AS POLICY_NO,TRAN_REF_ID,
       CM.AMOUNT, CM.CND_TYPE,CM.CND_METHOD,CM.RETRY_COUNT,CM.CND_REQUEST_TIME,
       CM.CND_FINISH_DATE,CM.BK_ACC_MST_ID,CM.ACCOUNT_MAPPING_ID,CM.STATUS,CM.RC_STATE
       FROM ODS_STG.OFE_T_CND_MST CM) GETS ON GETS.CND_TYPE = ''D'' 
       AND GETS.POLICY_NO = P.POLICY_NO AND PC.POLICY_ID = P.POLICY_ID 
       AND PC.POLICY_ID = PP.POLICY_ID
WHERE 1=1
AND GETS.POLICY_NO = P.POLICY_NO
AND PC.RC_STATE = ''E''
--AND PD.BASIC_PRODUCT_FLAG = ''B'' 
AND PD.COVERAGE_TERM_TYPE <> ''M''
AND GETS.STATUS=''4''
AND NOT EXISTS (SELECT 1 FROM ODS_STG.OFE_T_RLS_POLICY A WHERE TO_CHAR(A.PNO) = TO_CHAR(P.POLICY_NO) AND A.FLAG = ''1'')
AND PC.ITEM_ID IS NOT NULL
AND PC.POLICY_CHG_ID > 0
AND P.POLICY_ID > 0
AND PD.PD_PRODUCT_ID NOT IN (SELECT DISTINCT c.pd_product_id
                                from ODS_STG.OFE_t_Cfg_Plan_Print a,ODS_STG.OFE_t_pd_product_plan b,
                                ODS_STG.OFE_T_POL_PLAN c,ods_stg.OFE_T_PD_PRODUCT d
                                where a.pd_plan_id=b.pd_plan_id 
                                AND d.pd_product_id=c.pd_product_id
                                AND b.pd_product_id=c.pd_product_id 
                                AND a.is_show=0)
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn}) 
AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10866;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10869 IS   V_ID NUMBER :=10869;  V_SQL_ID NUMBER :=10893;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LJAGETLIVBENE A
   SET A.MANAGECOM = (CASE
                       WHEN A.MANAGECOM IN
                            (SELECT BASIC_CODE
                               FROM T_DEF_CODE_MAPPING
                              WHERE CODE_TYPE = ''managecom''
                                AND COM_ID = ''1'') THEN
                        (SELECT TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE B.CODE_TYPE = ''managecom''
                            AND A.MANAGECOM = B.BASIC_CODE
                            AND B.COM_ID = ''1'')
                       ELSE
                        A.MANAGECOM
                     END),
       A.BANKCODE = (CASE
                      WHEN A.BANKCODE IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING
                                           WHERE CODE_TYPE = ''bankcode''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''bankcode''
                           AND A.BANKCODE = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.BANKCODE
                    END),
       A.CERTTYPE = (CASE
                      WHEN A.CERTTYPE IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING
                                           WHERE CODE_TYPE = ''certtype''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''certtype''
                           AND A.CERTTYPE = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.CERTTYPE
                    END),
       A.TRANSACTIONNO = (CASE
                            WHEN A.TRANSACTIONNO IN
                                 (SELECT C.CHGID
                                    FROM T_PRP_CHG_TRANS_ID_MAP C
                                 ) THEN
                             (SELECT Max(C.TRANSNO)
                                FROM  T_PRP_CHG_TRANS_ID_MAP C
                                 WHERE A.TRANSACTIONNO = C.CHGID
                             )
                            ELSE
                             A.TRANSACTIONNO
                          END)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10869;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10777 IS   V_ID NUMBER :=10777;  V_SQL_ID NUMBER :=10801;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LLBNF A
   SET A.BNFCAT = (CASE
                    WHEN A.BNFCAT IN (SELECT BASIC_CODE
                                        FROM T_DEF_CODE_MAPPING B
                                       WHERE CODE_TYPE = ''bnfcat''
                                         AND COM_ID = ''1'') THEN
                     (SELECT TARGET_CODE
                        FROM T_DEF_CODE_MAPPING B
                       WHERE B.CODE_TYPE = ''bnfcat''
                         AND A.BNFCAT = B.BASIC_CODE
                         AND B.COM_ID = ''1'')
                    ELSE
                     A.BNFCAT
                  END),
       A.RELATIONTOINSURED = (CASE
                      WHEN A.RELATIONTOINSURED IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING B
                                           WHERE CODE_TYPE = ''relationtoinsured''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''relationtoinsured''
                           AND A.RELATIONTOINSURED = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.RELATIONTOINSURED
                    END),
                    A.BNFLEVEL = (CASE
                      WHEN A.BNFLEVEL IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING B
                                           WHERE CODE_TYPE = ''bnflevel''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''bnflevel''
                           AND A.BNFLEVEL = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.BNFLEVEL
                    END),
       A.SEX = (CASE
                 WHEN A.SEX IN (SELECT BASIC_CODE
                                  FROM T_DEF_CODE_MAPPING B
                                 WHERE CODE_TYPE = ''sex''
                                   AND COM_ID = ''1'') THEN
                  (SELECT TARGET_CODE
                     FROM T_DEF_CODE_MAPPING B
                    WHERE B.CODE_TYPE = ''sex''
                      AND A.SEX = B.BASIC_CODE
                      AND B.COM_ID = ''1'')
                 ELSE
                  A.SEX
               END),
       A.CERTTYPE = (CASE
                      WHEN A.CERTTYPE IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING B
                                           WHERE CODE_TYPE = ''certtype''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''certtype''
                           AND A.CERTTYPE = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.CERTTYPE
                    END),
       A.RELATIONOFPAYEEANDINSURED = (CASE
                                       WHEN A.RELATIONOFPAYEEANDINSURED IN
                                            (SELECT BASIC_CODE
                                               FROM T_DEF_CODE_MAPPING B
                                              WHERE CODE_TYPE =
                                                    ''relationtoinsured''
                                                AND COM_ID = ''1'') THEN
                                        (SELECT TARGET_CODE
                                           FROM T_DEF_CODE_MAPPING B
                                          WHERE B.CODE_TYPE =
                                                ''relationtoinsured''
                                            AND A.RELATIONOFPAYEEANDINSURED =
                                                B.BASIC_CODE
                                            AND B.COM_ID = ''1'')
                                       ELSE
                                        A.RELATIONOFPAYEEANDINSURED
                                     END),
       A.PAYEESEX = (CASE
                      WHEN A.PAYEESEX IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING B
                                           WHERE CODE_TYPE = ''sex''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''sex''
                           AND A.PAYEESEX = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.PAYEESEX
                    END),
       A.PAYEECERTTYPE = (CASE
                           WHEN A.PAYEECERTTYPE IN
                                (SELECT BASIC_CODE
                                   FROM T_DEF_CODE_MAPPING B
                                  WHERE CODE_TYPE = ''certtype''
                                    AND COM_ID = ''1'') THEN
                            (SELECT TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE B.CODE_TYPE = ''certtype''
                                AND A.PAYEECERTTYPE = B.BASIC_CODE
                                AND B.COM_ID = ''1'')
                           ELSE
                            A.PAYEECERTTYPE
                         END),
       A.BENEFITWDMTHD = (CASE
                           WHEN A.BENEFITWDMTHD IN
                                (SELECT BASIC_CODE
                                   FROM T_DEF_CODE_MAPPING B
                                  WHERE CODE_TYPE = ''benefitwdmthd''
                                    AND COM_ID = ''1'') THEN
                            (SELECT TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE B.CODE_TYPE = ''benefitwdmthd''
                                AND A.BENEFITWDMTHD = B.BASIC_CODE
                                AND B.COM_ID = ''1'')
                           ELSE
                            A.BENEFITWDMTHD
                         END),
       A.BENEFITPAYMTHD = (CASE
                            WHEN A.BENEFITPAYMTHD IN
                                 (SELECT BASIC_CODE
                                    FROM T_DEF_CODE_MAPPING B
                                   WHERE CODE_TYPE = ''payway''
                                     AND COM_ID = ''1'') THEN
                             (SELECT TARGET_CODE
                                FROM T_DEF_CODE_MAPPING B
                               WHERE B.CODE_TYPE = ''payway''
                                 AND A.BENEFITPAYMTHD = B.BASIC_CODE
                                 AND B.COM_ID = ''1'')
                            ELSE
                             A.BENEFITPAYMTHD
                          END),
       A.BANKCODE = (CASE
                      WHEN A.BANKCODE IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING B
                                           WHERE CODE_TYPE = ''bankcode''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''bankcode''
                           AND A.BANKCODE = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.BANKCODE
                    END),
       A.TRANSACTIONNO = (CASE
                            WHEN A.TRANSACTIONNO IN
                                 (SELECT C.CHGID
                                    FROM T_PRP_CHG_TRANS_ID_MAP C
                                 ) THEN
                             (SELECT Max(C.TRANSNO)
                                FROM  T_PRP_CHG_TRANS_ID_MAP C
                                 WHERE A.TRANSACTIONNO = C.CHGID
                             )
                            ELSE
                             A.TRANSACTIONNO
                          END)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10777;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10778 IS   V_ID NUMBER :=10778;  V_SQL_ID NUMBER :=10802;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCPRODUCT A
   SET A.GPFLAG = (CASE
                    WHEN A.GPFLAG IN (SELECT BASIC_CODE
                                        FROM T_DEF_CODE_MAPPING
                                       WHERE CODE_TYPE = ''gpflag''
                                         AND COM_ID = ''1'') THEN
                     (SELECT TARGET_CODE
                        FROM T_DEF_CODE_MAPPING B
                       WHERE B.CODE_TYPE = ''gpflag''
                         AND A.GPFLAG = B.BASIC_CODE
                         AND B.COM_ID = ''1'')
                    ELSE
                     A.GPFLAG
                  END),
       A.POLTYPEFLAG = (CASE
                         WHEN A.POLTYPEFLAG IN
                              (SELECT BASIC_CODE
                                 FROM T_DEF_CODE_MAPPING
                                WHERE CODE_TYPE = ''poltypeflag''
                                  AND COM_ID = ''1'') THEN
                          (SELECT TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE B.CODE_TYPE = ''poltypeflag''
                              AND A.POLTYPEFLAG = B.BASIC_CODE
                              AND B.COM_ID = ''1'')
                         ELSE
                          A.POLTYPEFLAG
                       END),
       A.MAINPRODUCTFLAG = (CASE
                             WHEN A.MAINPRODUCTFLAG IN
                                  (SELECT BASIC_CODE
                                     FROM T_DEF_CODE_MAPPING
                                    WHERE CODE_TYPE = ''mainproductflag''
                                      AND COM_ID = ''1'') THEN
                              (SELECT TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE B.CODE_TYPE = ''mainproductflag''
                                  AND A.MAINPRODUCTFLAG = B.BASIC_CODE
                                  AND B.COM_ID = ''1'')
                             ELSE
                              A.MAINPRODUCTFLAG
                           END),
       A.MANAGECOM = (CASE
                       WHEN A.MANAGECOM IN
                            (SELECT BASIC_CODE
                               FROM T_DEF_CODE_MAPPING
                              WHERE CODE_TYPE = ''managecom''
                                AND COM_ID = ''1'') THEN
                        (SELECT TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE B.CODE_TYPE = ''managecom''
                            AND A.MANAGECOM = B.BASIC_CODE
                            AND B.COM_ID = ''1'')
                       ELSE
                        A.MANAGECOM
                     END),
       A.PAYMODE = (CASE
                     WHEN A.PAYMODE IN (SELECT BASIC_CODE
                                          FROM T_DEF_CODE_MAPPING
                                         WHERE CODE_TYPE = ''paymode''
                                           AND COM_ID = ''1'') THEN
                      (SELECT TARGET_CODE
                         FROM T_DEF_CODE_MAPPING B
                        WHERE B.CODE_TYPE = ''paymode''
                          AND A.PAYMODE = B.BASIC_CODE
                          AND B.COM_ID = ''1'')
                     ELSE
                      A.PAYMODE
                   END),
       A.PAYTERMTYPE = (CASE
                         WHEN A.PAYTERMTYPE IN
                              (SELECT BASIC_CODE
                                 FROM T_DEF_CODE_MAPPING
                                WHERE CODE_TYPE = ''paytermtype''
                                  AND COM_ID = ''1'') THEN
                          (SELECT TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE B.CODE_TYPE = ''paytermtype''
                              AND A.PAYTERMTYPE = B.BASIC_CODE
                              AND B.COM_ID = ''1'')
                         ELSE
                          A.PAYTERMTYPE
                       END),
       A.INSURANCEPERIODFLAG = (CASE
                                 WHEN A.INSURANCEPERIODFLAG IN
                                      (SELECT BASIC_CODE
                                         FROM T_DEF_CODE_MAPPING
                                        WHERE CODE_TYPE =
                                              ''insuranceperiodflag''
                                          AND COM_ID = ''1'') THEN
                                  (SELECT TARGET_CODE
                                     FROM T_DEF_CODE_MAPPING B
                                    WHERE B.CODE_TYPE = ''insuranceperiodflag''
                                      AND A.INSURANCEPERIODFLAG = B.BASIC_CODE
                                      AND B.COM_ID = ''1'')
                                 ELSE
                                  A.INSURANCEPERIODFLAG
                               END),
       A.INSUREDTYPE = (CASE
                         WHEN A.INSUREDTYPE IN
                              (SELECT BASIC_CODE
                                 FROM T_DEF_CODE_MAPPING
                                WHERE CODE_TYPE = ''insuredtype''
                                  AND COM_ID = ''1'') THEN
                          (SELECT TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE B.CODE_TYPE = ''insuredtype''
                              AND A.INSUREDTYPE = B.BASIC_CODE
                              AND B.COM_ID = ''1'')
                         ELSE
                          A.INSUREDTYPE
                       END),
       A.UWCONCLUSION = (CASE
                          WHEN A.UWCONCLUSION IN
                               (SELECT BASIC_CODE
                                  FROM T_DEF_CODE_MAPPING
                                 WHERE CODE_TYPE = ''uwconclusion''
                                   AND COM_ID = ''1'') THEN
                           (SELECT TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE B.CODE_TYPE = ''uwconclusion''
                               AND A.UWCONCLUSION = B.BASIC_CODE
                               AND B.COM_ID = ''1'')
                          ELSE
                           A.UWCONCLUSION
                        END),
       A.STATUS = (CASE
                    WHEN A.STATUS IN (SELECT BASIC_CODE
                                        FROM T_DEF_CODE_MAPPING
                                       WHERE CODE_TYPE = ''polstatus''
                                         AND COM_ID = ''1'') THEN
                     (SELECT TARGET_CODE
                        FROM T_DEF_CODE_MAPPING B
                       WHERE B.CODE_TYPE = ''polstatus''
                         AND A.STATUS = B.BASIC_CODE
                         AND B.COM_ID = ''1'')
                    ELSE
                     A.STATUS
                  END),
       A.TRANSACTIONNO = (CASE
                            WHEN A.TRANSACTIONNO IN
                                 (SELECT C.CHGID
                                    FROM T_PRP_CHG_TRANS_ID_MAP C
                                 ) THEN
                             (SELECT Max(C.TRANSNO)
                                FROM  T_PRP_CHG_TRANS_ID_MAP C
                                 WHERE A.TRANSACTIONNO = C.CHGID
                             )
                            ELSE
                             A.TRANSACTIONNO
                          END)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10778;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10779 IS   V_ID NUMBER :=10779;  V_SQL_ID NUMBER :=10803;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LJAPAY A
   SET A.MANAGECOM = (CASE
                       WHEN A.MANAGECOM IN
                            (SELECT BASIC_CODE
                               FROM T_DEF_CODE_MAPPING
                              WHERE CODE_TYPE = ''managecom''
                              AND COM_ID = ''1'') THEN
                        (SELECT TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE B.CODE_TYPE = ''managecom''
                            AND A.MANAGECOM = B.BASIC_CODE
                            AND B.COM_ID = ''1'')
                       ELSE
                        A.MANAGECOM
                     END),
       A.BANKCODE = (CASE
                      WHEN A.BANKCODE IN
                           (SELECT BASIC_CODE
                              FROM T_DEF_CODE_MAPPING
                             WHERE CODE_TYPE = ''bankcode''
                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''bankcode''
                           AND A.BANKCODE = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.BANKCODE
                    END),
       A.CERTTYPE = (CASE
                      WHEN A.CERTTYPE IN
                           (SELECT BASIC_CODE
                              FROM T_DEF_CODE_MAPPING
                             WHERE CODE_TYPE = ''certtype''
                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''certtype''
                           AND A.CERTTYPE = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.CERTTYPE
                    END),
       A.TRANSACTIONNO = (CASE
                            WHEN A.TRANSACTIONNO IN
                                 (SELECT C.CHGID
                                    FROM T_PRP_CHG_TRANS_ID_MAP C
                                 ) THEN
                             (SELECT Max(C.TRANSNO)
                                FROM  T_PRP_CHG_TRANS_ID_MAP C
                                 WHERE A.TRANSACTIONNO = C.CHGID
                             )
                            ELSE
                             A.TRANSACTIONNO
                          END)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10779;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10781 IS   V_ID NUMBER :=10781;  V_SQL_ID NUMBER :=10805;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LLCLAIMPOLICY A
   SET A.MANAGECOM = (CASE
                       WHEN A.MANAGECOM IN
                            (SELECT BASIC_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE CODE_TYPE = ''managecom''
                                AND COM_ID = ''1'') THEN
                        (SELECT TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE B.CODE_TYPE = ''managecom''
                            AND A.MANAGECOM = B.BASIC_CODE
                            AND B.COM_ID = ''1'')
                       ELSE
                        A.MANAGECOM
                     END),
       A.PAYSTATUSCODE = (CASE
                           WHEN A.PAYSTATUSCODE IN
                                (SELECT BASIC_CODE
                                   FROM T_DEF_CODE_MAPPING
                                  WHERE CODE_TYPE = ''paystatuscode''
                                    AND COM_ID = ''1'') THEN
                            (SELECT TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE B.CODE_TYPE = ''paystatuscode''
                                AND A.PAYSTATUSCODE = B.BASIC_CODE
                                AND B.COM_ID = ''1'')
                           ELSE
                            A.PAYSTATUSCODE
                         END),
       A.CURRENCY = (CASE
                      WHEN A.CURRENCY IN
                           (SELECT BASIC_CODE
                              FROM T_DEF_CODE_MAPPING
                             WHERE CODE_TYPE = ''currency''
                               AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''currency''
                           AND A.CURRENCY = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.CURRENCY
                    END),
       A.BENEFITTYPE = (CASE
                         WHEN A.BENEFITTYPE IN
                              (SELECT BASIC_CODE
                                 FROM T_DEF_CODE_MAPPING
                                WHERE CODE_TYPE = ''benefittype''
                                  AND COM_ID = ''1'') THEN
                          (SELECT TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE B.CODE_TYPE = ''benefittype''
                              AND A.BENEFITTYPE = B.BASIC_CODE
                              AND B.COM_ID = ''1'')
                         ELSE
                          A.BENEFITTYPE
                       END),
       A.LOSSOCCURREASON = (CASE
                             WHEN A.LOSSOCCURREASON IN
                                  (SELECT BASIC_CODE
                                     FROM T_DEF_CODE_MAPPING
                                    WHERE CODE_TYPE = ''lossoccurreason''
                                      AND COM_ID = ''1'') THEN
                              (SELECT TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE B.CODE_TYPE = ''lossoccurreason''
                                  AND A.LOSSOCCURREASON = B.BASIC_CODE
                                  AND B.COM_ID = ''1'')
                             ELSE
                              A.LOSSOCCURREASON
                           END),
       A.TRANSACTIONNO = (CASE
                            WHEN A.TRANSACTIONNO IN
                                 (SELECT C.CHGID
                                    FROM T_PRP_CHG_TRANS_ID_MAP C
                                 ) THEN
                             (SELECT Max(C.TRANSNO)
                                FROM  T_PRP_CHG_TRANS_ID_MAP C
                                 WHERE A.TRANSACTIONNO = C.CHGID
                             )
                            ELSE
                             A.TRANSACTIONNO
                          END)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10781;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10783 IS   V_ID NUMBER :=10783;  V_SQL_ID NUMBER :=10807;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LMPRODUCT A
   SET A.INSUACCFLAG = (CASE
                         WHEN A.INSUACCFLAG IN
                              (SELECT BASIC_CODE
                                 FROM T_DEF_CODE_MAPPING
                                WHERE CODE_TYPE = ''insuaccflag''
                                  AND COM_ID = ''1'') THEN
                          (SELECT TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE B.CODE_TYPE = ''insuaccflag''
                              AND A.INSUACCFLAG = B.BASIC_CODE
                              AND B.COM_ID = ''1'')
                         ELSE
                          A.INSUACCFLAG
                       END),
       A.PRODUCTTYPE = (CASE
                         WHEN A.PRODUCTTYPE IN
                              (SELECT BASIC_CODE
                                 FROM T_DEF_CODE_MAPPING
                                WHERE CODE_TYPE = ''producttype''
                                  AND COM_ID = ''1'') THEN
                          (SELECT DISTINCT TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE B.CODE_TYPE = ''producttype''
                              AND A.PRODUCTTYPE = B.BASIC_CODE
                              AND B.COM_ID = ''1'')
                         ELSE
                          A.PRODUCTTYPE
                       END),
       A.INVESTMENTTYPE = (CASE
                            WHEN A.INVESTMENTTYPE IN
                                 (SELECT BASIC_CODE
                                    FROM T_DEF_CODE_MAPPING
                                   WHERE CODE_TYPE = ''investmenttype''
                                     AND COM_ID = ''1'') THEN
                             (SELECT TARGET_CODE
                                FROM T_DEF_CODE_MAPPING B
                               WHERE B.CODE_TYPE = ''investmenttype''
                                 AND A.INVESTMENTTYPE = B.BASIC_CODE
                                 AND B.COM_ID = ''1'')
                            ELSE
                             A.INVESTMENTTYPE
                          END),
       A.TERMTYPE = (CASE
                      WHEN A.TERMTYPE IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING
                                           WHERE CODE_TYPE = ''termtype''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''termtype''
                           AND A.TERMTYPE = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.TERMTYPE
                    END),
       A.GPFLAG = (CASE
                    WHEN A.GPFLAG IN (SELECT BASIC_CODE
                                        FROM T_DEF_CODE_MAPPING
                                       WHERE CODE_TYPE = ''gpflag''
                                         AND COM_ID = ''1'') THEN
                     (SELECT TARGET_CODE
                        FROM T_DEF_CODE_MAPPING B
                       WHERE B.CODE_TYPE = ''gpflag''
                         AND A.GPFLAG = B.BASIC_CODE
                         AND B.COM_ID = ''1'')
                    ELSE
                     A.GPFLAG
                  END),
       A.MAINPRODUCTFLAG = (CASE
                             WHEN A.MAINPRODUCTFLAG IN
                                  (SELECT BASIC_CODE
                                     FROM T_DEF_CODE_MAPPING
                                    WHERE CODE_TYPE = ''mainproductflag''
                                      AND COM_ID = ''1'') THEN
                              (SELECT TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE B.CODE_TYPE = ''mainproductflag''
                                  AND A.MAINPRODUCTFLAG = B.BASIC_CODE
                                  AND B.COM_ID = ''1'')
                             ELSE
                              A.MAINPRODUCTFLAG
                           END),
       A.SALEFLAG = (CASE
                      WHEN A.SALEFLAG IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING
                                           WHERE CODE_TYPE = ''saleflag''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''saleflag''
                           AND A.SALEFLAG = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.SALEFLAG
                    END),
       A.TRANSACTIONNO = (CASE
                            WHEN A.TRANSACTIONNO IN
                                 (SELECT C.CHGID
                                    FROM T_PRP_CHG_TRANS_ID_MAP C
                                 ) THEN
                             (SELECT Max(C.TRANSNO)
                                FROM  T_PRP_CHG_TRANS_ID_MAP C
                                 WHERE A.TRANSACTIONNO = C.CHGID
                             )
                            ELSE
                             A.TRANSACTIONNO
                          END)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10783;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10928 IS   V_ID NUMBER :=10928;  V_SQL_ID NUMBER :=10952;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='SELECT 
       pc.policy_chg_id as TransactionNo,
       ''000031'' AS CompanyCode,
       p.policy_no as PolicyNo,
       PD.PD_PRODUCT_ID as ProductNo,
       (select t.client_id
          from ods_stg.OFE_T_POL_CLN_MST t
         where t.policy_id = p.policy_id
           and client_role = ''2''
           and t.rc_state = ''E'') as InsuredNo,
       ''1'' as BnfCat,
       bnf.BnfSerialNum as BnfSerialNum,
       bnf.BnfLevel as BnfLevel,
       bnf.RelationToInsured as RelationToInsured,
       bnf.PercentOfBenefit as PercentOfBenefit,
       bnf.client_id as ICCustomerNo,
       '''' as CustomerNo,
       bnf.client_name as Name,
       bnf.client_sex as Sex,
       bnf.client_birthday as BirthDate,
       bnf.client_id_type as CertType,
       bnf.client_id_no as CertNo,
       p.operator_id as operator,
       to_date(to_char(p.insert_time,''yyyy-mm-dd''),''yyyy-mm-dd'') as makedate,
       to_char(p.insert_time,''hh:mm:ss'') as maketime,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') as modifydate,
       to_char(sysdate,''hh:mm:ss'') as modifytime
FROM ODS_STG.OFE_T_POLICY_CHANGE PC
LEFT JOIN ODS_STG.OFE_T_POLICY P ON P.RC_STATE = ''E'' AND P.POLICY_ID = PC.POLICY_ID
LEFT JOIN ODS_STG.OFE_T_POL_PLAN PP ON PP.RC_STATE = ''E'' AND PP.POLICY_ID = P.POLICY_ID
LEFT JOIN ODS_STG.OFE_T_PD_PRODUCT PD ON PD.RC_STATE = ''E'' AND PD.PD_PRODUCT_ID = PP.PD_PRODUCT_ID 
LEFT JOIN 
       (SELECT PBI.POLICY_ID AS POLICY_ID,
               PBI.POLICY_CLIENT_ID AS POLICY_CLIENT_ID,
               PCM.CLIENT_ID AS CLIENT_ID,
               ROW_NUMBER() OVER(PARTITION BY PCM.POLICY_ID,PP.PD_PRODUCT_ID ORDER BY PCM.POLICY_ID,PP.PD_PRODUCT_ID) AS BNFSERIALNUM,
               PBI.BENEFICIARY_ORDER AS BNFLEVEL,
               PBI.BNF_RELATION_TO_INSURED AS RELATIONTOINSURED,
               PBI.BENEFICIARY_PERCENTAGE AS PERCENTOFBENEFIT,
               PCM.CLIENT_ROLE,
               PCM.CLIENT_NAME,
               PCM.CLIENT_SEX,
               PCM.CLIENT_BIRTHDAY,
               PCM.CLIENT_ID_TYPE,
               PCM.CLIENT_ID_NO,
               PP.POLICY_PLAN_ID,
               PP.PD_PRODUCT_ID
          FROM ODS_STG.OFE_T_POL_BENEFICIARY_INFO PBI,
               ODS_STG.OFE_T_POL_CLN_MST          PCM,
               ODS_STG.OFE_T_POL_PLAN             PP
         WHERE PBI.POLICY_CLIENT_ID = PCM.POLICY_CLIENT_ID
           AND PBI.RC_STATE = ''E''
           AND PCM.RC_STATE = ''E''
           AND PP.RC_STATE = ''E''
           AND PP.POLICY_ID = PCM.POLICY_ID
        UNION ALL
        SELECT P.POLICY_ID,
               PCM.POLICY_CLIENT_ID,
               PCM.CLIENT_ID AS CLIENT_ID,
               ROW_NUMBER() OVER(PARTITION BY PCM.POLICY_ID,PP.PD_PRODUCT_ID ORDER BY PCM.POLICY_ID,PP.PD_PRODUCT_ID) AS BNFSERIALNUM,
               1 AS BNFLEVEL,
               PP.RELATIONSHIP_TO_INSURED AS RELATIONTOINSURED,
               1.0 AS PERCENTOFBENEFIT,
               PCM.CLIENT_ROLE,
               ''法定受益人'' AS CLIENT_NAME,
               PCM.CLIENT_SEX,
               PCM.CLIENT_BIRTHDAY,
               PCM.CLIENT_ID_TYPE,
               PCM.CLIENT_ID_NO,
               PP.POLICY_PLAN_ID,
               PP.PD_PRODUCT_ID
          FROM ODS_STG.OFE_T_POL_CLN_MST PCM,
               ODS_STG.OFE_T_POLICY      P,
               ODS_STG.OFE_T_POL_PLAN    PP
         WHERE P.POLICY_ID = PCM.POLICY_ID
           AND P.RC_STATE = ''E''
           AND PCM.RC_STATE = ''E''
           AND PP.RC_STATE = ''E''
           AND P.STATUTORY_BENEFICIARY_FLAG = ''1''
           AND PCM.CLIENT_ROLE != ''3''
           AND PP.POLICY_ID = P.POLICY_ID
           AND PP.POLICY_CLIENT_ID = PCM.POLICY_CLIENT_ID
           AND NOT EXISTS (SELECT 1
                  FROM ODS_STG.OFE_T_POL_BENEFICIARY_INFO T
                 WHERE T.POLICY_ID = P.POLICY_ID)) BNF
     ON bnf.POLICY_ID = p.policy_id
     AND bnf.PD_PRODUCT_ID = pd.PD_PRODUCT_ID
     AND bnf.POLICY_PLAN_ID = pp.policy_plan_id
WHERE 1 = 1
  AND PD.COVERAGE_TERM_TYPE <> ''M''
  AND NOT EXISTS(SELECT 1 FROM ODS_STG.OFE_T_RLS_POLICY A WHERE TO_CHAR(A.PNO) = TO_CHAR(P.POLICY_NO) AND A.FLAG = ''1'')
  AND PC.RC_STATE = ''E'' 
  AND PC.POLICY_ID = P.POLICY_ID 
  AND PC.POLICY_CHG_ID > 0
  AND P.POLICY_ID > 0
  AND BNF.POLICY_ID = P.POLICY_ID
  AND BNF.PD_PRODUCT_ID = PD.PD_PRODUCT_ID
  AND BNF.POLICY_PLAN_ID = PP.POLICY_PLAN_ID
  AND PD.PD_PRODUCT_ID NOT IN (SELECT DISTINCT c.pd_product_id
                                from ODS_STG.OFE_t_Cfg_Plan_Print a,ODS_STG.OFE_t_pd_product_plan b,
                                ODS_STG.OFE_T_POL_PLAN c,ods_stg.OFE_T_PD_PRODUCT d
                                where a.pd_plan_id=b.pd_plan_id 
                                AND d.pd_product_id=c.pd_product_id
                                AND b.pd_product_id=c.pd_product_id 
                                AND a.is_show=0)--需屏蔽的险种
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
  AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn})
  AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10928;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10932 IS   V_ID NUMBER :=10932;  V_SQL_ID NUMBER :=10956;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='  SELECT 
        PC.POLICY_CHG_ID AS TRANSACTIONNO,
        ''000031'' AS COMPANYCODE,
        '''' AS GRPPOLICYNO,
        P.POLICY_NO AS POLICYNO,
        PCM.CLIENT_ID AS INSUREDNO,
        '''' AS CUSTOMERNO,
        P.BRANCH_CODE AS MANAGECOM,
        ''00'' AS RELATIONTOMAININSURED,
        PCM.CLIENT_ID AS MAININSUREDNO,
        NVL(PP.RELATIONSHIP_TO_INSURED,''99'') AS RELATIONTOAPPNT,
        PCM.CLIENT_NAME AS INSUREDNAME,
        PCM.CLIENT_SEX AS INSUREDSEX,
        PCM.CLIENT_BIRTHDAY AS INSUREDBIRTHDATE,
        NVL(PCM.CLIENT_ID_TYPE,''990'') AS INSUREDCERTTYPE,
        NVL(PCM.CLIENT_ID_NO,''99'') AS INSUREDCERTNO,
        PP.ISSUE_AGE AS APPAGE,
        NVL(PCI.NATIONALITY,''156'') AS COUNTRY,
        ''01'' AS NATIONALITY,
        (SELECT MAX(REGEXP_REPLACE( PCA.ADDRESS,''\\|\*|\?|[|]'','' '')) 
           FROM ODS_STG.OFE_T_POL_CLN_ADDRESS PCA
          WHERE PCA.POLICY_ID = P.POLICY_ID
            AND PCA.POLICY_CLIENT_ID = PCM.POLICY_CLIENT_ID
            AND PCA.RC_STATE = ''E'') AS RGTADDRESS,
        NVL(PCI.MARITAL_STATUS,''90'') AS MARRIAGESTATUS,
        '''' AS MARRIAGEDATE,
        '''' AS HEALTHCONDITION,
        NVL(PCI.HEIGHT,0) AS HEIGHT,
        NVL(PCI.WEIGHT,0) AS WEIGHT,
        PCI.EDUCATION AS EDUCATELEVEL,
        '''' AS STARTWORKDATE,
        '''' AS POSITION,
        NVL(PCI.AVERAGE_ANNUAL_INCOME,0) AS SALARY,
        NVL(PCI.OCCUPATION_CODE,''Y03'') AS OCCUPATIONTYPE,
        (SELECT OCCUPATION_CODE
           FROM ODS_STG.OFE_T_CFG_OCCUP_CODE
          WHERE OCCUPATION_CODE = PCI.OCCUPATION_CODE) AS OCCUPATION,
        '''' AS PARTTIMEOCCUPATIONTYPE,
        '''' AS PARTTIMEOCCUPATION,
        NVL(PCI.SMOKE_FLAG,''N'') AS SMOKEFLAG,
        (CASE WHEN NVL(PCI.HEIGHT,0) = 0 THEN 0
        ELSE 
          ROUND(NVL(PCI.WEIGHT,0) /
          (PCI.HEIGHT * PCI.HEIGHT),2)
        END) AS BMI,
        '''' AS LICENSE,
        '''' AS LICENSETYPE,
        '''' AS SOCIALINSUNO,
        PCI.SOCIAL_SECURITY_FLAG AS SOCIALINSUFLAG,
        PCI.LIVING_RANGE AS RESIDENTTYPE,
        ''01'' AS INSUREDTYPE,
        P.OPERATOR_ID AS OPERATOR,
        TO_DATE(TO_CHAR(P.INSERT_TIME,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MAKEDATE,
        TO_CHAR(P.INSERT_TIME,''hh24:mi:ss'') AS MAKETIME,
        TO_DATE(TO_CHAR(SYSDATE,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MODIFYDATE,
        TO_CHAR(SYSDATE,''hh24:mi:ss'') AS MODIFYTIME
  FROM ODS_STG.OFE_T_POLICY_CHANGE PC
  LEFT JOIN ODS_STG.OFE_T_POLICY P 
       ON P.RC_STATE = ''E'' AND P.POLICY_ID = PC.POLICY_ID
  LEFT JOIN ODS_STG.OFE_T_POL_PLAN   PP 
       ON PP.POLICY_ID = P.POLICY_ID 
       AND PP.RC_STATE = ''E''
  LEFT JOIN ODS_STG.OFE_T_PD_PRODUCT PD 
       ON PD.RC_STATE = ''E'' 
       AND PD.PD_PRODUCT_ID = PP.PD_PRODUCT_ID
  LEFT JOIN ODS_STG.OFE_T_POL_CLN_MST     PCM 
       ON PCM.RC_STATE = ''E''
       AND  PCM.POLICY_ID = P.POLICY_ID
  LEFT JOIN ODS_STG.OFE_T_POL_CLN_INFO    PCI
       ON PCI.RC_STATE = ''E''
       AND PCI.POLICY_ID = P.POLICY_ID
  WHERE 1 = 1
  AND PC.RC_STATE = ''E''
  AND PD.BASIC_PRODUCT_FLAG = ''B'' 
  AND PD.COVERAGE_TERM_TYPE <> ''M''
  AND PCM.CLIENT_ROLE = ''2''
  AND PCI.POLICY_CLIENT_ID = PCM.POLICY_CLIENT_ID
  AND NOT EXISTS(SELECT 1 FROM ODS_STG.OFE_T_RLS_POLICY A WHERE TO_CHAR(A.PNO) = TO_CHAR(P.POLICY_NO) AND A.FLAG = ''1'')
  AND PC.POLICY_ID = P.POLICY_ID 
  AND PC.POLICY_CHG_ID > 0
  AND P.POLICY_ID > 0
  AND PD.PD_PRODUCT_ID NOT IN (SELECT DISTINCT c.pd_product_id
                                from ODS_STG.OFE_t_Cfg_Plan_Print a,ODS_STG.OFE_t_pd_product_plan b,
                                ODS_STG.OFE_T_POL_PLAN c,ods_stg.OFE_T_PD_PRODUCT d
                                where a.pd_plan_id=b.pd_plan_id 
                                AND d.pd_product_id=c.pd_product_id
                                AND b.pd_product_id=c.pd_product_id 
                                AND a.is_show=0)
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
   AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn})
  AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10932;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10947 IS   V_ID NUMBER :=10947;  V_SQL_ID NUMBER :=10971;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='SELECT  
     PC.POLICY_CHG_ID AS TRANSACTIONNO,
     '''' AS TRANSTYPE,
     '''' AS BATCHNO,
     ''000031'' AS COMPANYCODE,
     '''' AS GRPPOLICYNO,
     ''1''AS STATEFLAG,
     TO_CHAR(P.POLICY_NO) AS POLICYNO,
     PC.ITEM_ID AS BUSSTYPE,
     NVL((SELECT SUM(CASE WHEN POL_FEE.TRANSACTION_FEE_AMOUNT IS NULL THEN 0.00
                 ELSE POL_FEE.TRANSACTION_FEE_AMOUNT END)
          FROM (SELECT A.POLICY_ID,
                       C.POLICY_CHG_ID TRANSACTION_ITEM_ID,
                       B.POLICY_PLAN_ID POLICY_PLAN_ID,
                       ''保费'' TRANSACTION_FEE_TYPE,
                       A.FEE TRANSACTION_FEE_AMOUNT,
                       A.DUE_DATE TRANS_DATE
                FROM ODS_STG.OFE_T_POL_PLAN_PREM A,
                     ODS_STG.OFE_T_POL_PLAN      B,
                     ODS_STG.OFE_T_POLICY_CHANGE C
               WHERE A.RC_STATE = ''E''
               AND B.RC_STATE = ''E''
               AND C.RC_STATE = ''E''
               AND A.POLICY_PLAN_ID = B.POLICY_PLAN_ID
               AND C.POLICY_ID = B.POLICY_ID
               AND C.ITEM_ID = 0
               AND NOT EXISTS
               (SELECT 1
                  FROM ODS_STG.OFE_T_BUSINESS_FEE_DETAIL
                  WHERE BUSINESS_ID2 = C.POLICY_CHG_ID
                  AND BUSINESS_TYPE = ''4'')
                  UNION ALL
                  SELECT A.POLICY_ID,
                         A.BUSINESS_ID2 TRANSACTION_ITEM_ID,
                         A.POL_PLAN_ID POLICY_PLAN_ID,
                         B.DICTVALUE TRANSACTION_FEE_TYPE,
                         A.AMOUNT TRANSACTION_FEE_AMOUNT,
                         A.DUE_DATE TRANS_DATE
                  FROM ODS_STG.OFE_T_BUSINESS_FEE_DETAIL A,
                       ODS_STG.OFE_CTP_GEN_DICT          B
                 WHERE A.BUSINESS_TYPE IN (''2'', ''4'')
               AND A.FEE_TYPE = B.DICTCODE(+)
                 AND B.DICTTYPE(+) = ''FEE_TYPE''
                 AND A.FEE_TYPE <> ''99''
                 AND RC_STATE = ''E''
                 UNION ALL
                 SELECT A.POLICY_ID,
                        B.POLICY_CHG_ID TRANSACTION_ITEM_ID,
                        A.POL_PLAN_ID POLICY_PLAN_ID,
                        C.DICTVALUE TRANSACTION_FEE_TYPE,
                        A.AMOUNT TRANSACTION_FEE_AMOUNT,
                        A.DUE_DATE TRANS_DATE
                 FROM ODS_STG.OFE_T_BUSINESS_FEE_DETAIL A,
                      ODS_STG.OFE_T_CLAIM_CASE          B,
                      ODS_STG.OFE_CTP_GEN_DICT          C
                 WHERE A.BUSINESS_TYPE IN (''3'')
                 AND A.BUSINESS_ID1 = B.CASE_ID
                 AND B.CASE_DECISION IN (''1'', ''3'', ''4'')
                 AND A.FEE_TYPE = C.DICTCODE(+)
                 AND C.DICTTYPE(+) = ''FEE_TYPE''
                 AND A.FEE_TYPE <> ''99''
                 AND A.RC_STATE = ''E''
                 AND B.RC_STATE = ''E''
                 UNION ALL
                 SELECT A.POLICY_ID,
                        A.POLICY_CHG_ID TRANSACTION_ITEM_ID,
                        B.POL_PLAN_ID POLICY_PLAN_ID,
                        C.ACCOUNT_TYPE_NAME ||
                        DECODE(A.FEE_CODE,
                               ''C'',
                               ''本金'',
                               ''I'',
                               ''利息'',
                               ''IC'',
                               ''归本'') TRANSACTION_FEE_TYPE,
                       A.AMOUNT TRANSACTION_FEE_AMOUNT,
                       A.TRANS_DATE
                 FROM ODS_STG.OFE_T_POL_ACCOUNT_TRANS_LIST A,
                      ODS_STG.OFE_T_POL_ACCOUNT            B,
                      ODS_STG.OFE_T_ACCOUNT_TYPE           C
                WHERE A.POL_ACCOUNT_ID = B.POL_ACCOUNT_ID
                AND B.ACCOUNT_TYPE = C.ACCOUNT_TYPE
                AND B.ACCOUNT_TYPE NOT IN (''10'', ''14'')
                AND A.RC_STATE = ''E''
                AND B.RC_STATE = ''E''
                AND C.RC_STATE = ''E''
                UNION ALL
               SELECT A.POLICY_ID,
                      A.POLICY_CHG_ID TRANSACTION_ITEM_ID,
                      A.POLICY_PLAN_ID,
                      DECODE(A.DISTRIBUTE_CODE,
                            ''BRC'',
                            ''投连保费初始费用'',
                            ''ABRC'',
                            ''额外投资保费初始费用'',
                            ''TUC'',
                            ''投连定期追加初始费用'',
                            ''LSC'',
                            ''投连额外追加初始费用'',
                            ''COI'',
                            ''投连月扣-风险保险费'',
                            ''URP'',
                            ''投连月扣-附加险保险费'',
                            ''AMC'',
                            ''投连月扣-保单管理费'',
                            ''GBC'',
                            ''投连月扣-保证利益费用'',
                            ''BOD'',
                            ''投连买卖价差'',
                            ''FSC'',
                            ''投连账户转换'') TRANSACTION_FEE_TYPE,
                       A.AMOUNT TRANSACTION_FEE_AMOUNT,
                       A.TRANS_DATE
                       FROM ODS_STG.OFE_T_POL_PLAN_FUND_DISTRI A
                 WHERE A.RC_STATE = ''E''
                       AND DISTRIBUTE_CODE IN
                       (''BRC'', ''TUC'', ''LSC'', ''COI'', ''URP'', ''AMC'', ''GBC'',
                       ''BOD'', ''FSC'', ''ABRC'')
                UNION ALL
                SELECT T.POLICY_ID,
                       T.POLICY_CHG_ID TRANSACTION_ITEM_ID,
                       T.POLICY_PLAN_ID,
                       DECODE(TRANS_TYPE,
                             ''R'',
                             ''投连赎回金额'',
                             ''P'',
                             ''投连申购金额'') TRANSACTION_FEE_TYPE,
                       SUM(T.AMOUNT) TRANSACTION_FEE_AMOUNT,
                       T.TRANS_DATE
                       FROM ODS_STG.OFE_T_FUND_TRANS T
                 WHERE RC_STATE = ''E''
                       AND T.TRANS_TYPE IN (''R'', ''P'')
                       GROUP BY T.POLICY_CHG_ID,
                       T.POLICY_ID,
                       T.POLICY_PLAN_ID,
                       T.TRANS_DATE,
                       T.TRANS_TYPE) POL_FEE
                 WHERE POL_FEE.POLICY_ID = P.POLICY_ID
                       AND POL_FEE.TRANSACTION_ITEM_ID = PC.POLICY_CHG_ID),0) AS TRANSAMNT,
           NVL(PC.EFFECTIVE_DATE, PC.APPLY_DATE) AS TRANSDATE,
          (CASE WHEN (SELECT MAX(BK.BANK_BRANCH_CODE)             
                        FROM ODS_STG.OFE_T_BK_ACC_MST BK     
                       WHERE BK.POLICY_NO = P.POLICY_NO AND BK.RC_STATE=''E'') IS NOT NULL 
                             THEN (SELECT MAX(BK.BANK_CODE) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
                       WHERE BK.POLICY_NO = P.POLICY_NO AND BK.RC_STATE=''E'')
                             ||''-''||(SELECT MAX(BK.BANK_BRANCH_CODE) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
                       WHERE BK.POLICY_NO = P.POLICY_NO AND BK.RC_STATE=''E'')
                             ELSE (SELECT MAX(BK.BANK_CODE) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
                       WHERE BK.POLICY_NO = P.POLICY_NO AND BK.RC_STATE=''E'') END) AS BANKCODE,
           (CASE WHEN (SELECT MAX(BK.BANK_BRANCH_CODE) 
                        FROM ODS_STG.OFE_T_BK_ACC_MST BK 
                       WHERE BK.POLICY_NO=P.POLICY_NO AND BK.RC_STATE=''E'') IS NOT NULL 
                             THEN 
                             (SELECT MAX(T.BANK_NAME) 
                        FROM ODS_STG.OFE_T_BK_ACC_MST BK,ODS_STG.OFE_T_CFG_BANK T 
                       WHERE T.BANK_CODE = BK.BANK_CODE AND BK.POLICY_NO=P.POLICY_NO)
                             ||''-''||
                            (SELECT MAX(TB.BANK_BRANCH_NAME) 
                             FROM ODS_STG.OFE_T_BK_ACC_MST BK,ODS_STG.OFE_T_CFG_BANK_BRANCH TB 
                       WHERE TB.BANK_BRANCH_CODE = BK.BANK_BRANCH_CODE 
                             AND BK.POLICY_NO=P.POLICY_NO)
                             ELSE (SELECT MAX(T.BANK_NAME) 
                        FROM ODS_STG.OFE_T_BK_ACC_MST BK,ODS_STG.OFE_T_CFG_BANK T 
                       WHERE T.BANK_CODE = BK.BANK_CODE AND BK.POLICY_NO=P.POLICY_NO) 
                             END) AS BANKNAME, 
          (SELECT MAX(BK.BANK_ACC_NO) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
            WHERE BK.POLICY_NO=P.POLICY_NO AND BK.RC_STATE=''E'') AS BANKACCNO,   
          (SELECT MAX(BK.BANK_OWNER_NAME) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
             WHERE BK.POLICY_NO=P.POLICY_NO AND BK.RC_STATE=''E'') AS ACCNAME,
          NVL((SELECT MAX(BK.ID_TYPE) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
                WHERE BK.POLICY_NO=P.POLICY_NO AND BK.RC_STATE=''E''),''990'') AS CERTTYPE,
          (SELECT MAX(BK.ID_NO) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
       WHERE BK.POLICY_NO=P.POLICY_NO AND BK.RC_STATE=''E'') AS CERTNO,
       PC.OPERATOR_ID AS OPERATOR,
       TO_DATE(TO_CHAR(PC.INSERT_TIME,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MAKEDATE,
       TO_CHAR(PC.INSERT_TIME,''hh24:mi:ss'') AS MAKETIME,
       TO_DATE(TO_CHAR(SYSDATE,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MODIFYDATE,
       TO_CHAR(SYSDATE,''hh24:mI:ss'') AS MODIFYTIME
  FROM ODS_STG.OFE_T_POLICY_CHANGE PC
  LEFT JOIN ODS_STG.OFE_T_POLICY P ON P.RC_STATE = ''E'' AND P.POLICY_ID = PC.POLICY_ID
  LEFT JOIN ODS_STG.OFE_T_POL_PLAN PP ON PP.RC_STATE = ''E'' AND PP.POLICY_ID = P.POLICY_ID
  LEFT JOIN ODS_STG.OFE_T_PD_PRODUCT PD ON PD.RC_STATE = ''E'' AND PD.PD_PRODUCT_ID = PP.PD_PRODUCT_ID
  WHERE PC.ITEM_ID IS NOT NULL
   AND PC.RC_STATE = ''E''
   AND P.POLICY_ID = PC.POLICY_ID
   AND PD.BASIC_PRODUCT_FLAG = ''B'' --主附险标记 B主险 R 附件险
   AND PD.COVERAGE_TERM_TYPE <> ''M'' --长短险标记 M 极端险 S短险 L长险
   AND NOT EXISTS(SELECT 1 FROM ODS_STG.OFE_T_RLS_POLICY A WHERE TO_CHAR(A.PNO) = TO_CHAR(P.POLICY_NO) AND A.FLAG = ''1'' )
  AND PC.POLICY_ID = P.POLICY_ID 
  AND PC.POLICY_CHG_ID > 0
  AND P.POLICY_ID > 0
  AND PD.PD_PRODUCT_ID NOT IN (SELECT DISTINCT c.pd_product_id
                                from ODS_STG.OFE_t_Cfg_Plan_Print a,ODS_STG.OFE_t_pd_product_plan b,
                                ODS_STG.OFE_T_POL_PLAN c,ods_stg.OFE_T_PD_PRODUCT d
                                where a.pd_plan_id=b.pd_plan_id 
                                AND d.pd_product_id=c.pd_product_id
                                AND b.pd_product_id=c.pd_product_id 
                                AND a.is_show=0)--需屏蔽的险种
  AND P.POLICY_NO = (case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)

  AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn})
  AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10947;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10929 IS   V_ID NUMBER :=10929;  V_SQL_ID NUMBER :=10953;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCBNF A
   SET A.COMPANYCODE = case
                         when (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.COMPANYCODE = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''companycode''
                                  AND B.COM_ID = 1) is not null then
                          (SELECT B.TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE A.COMPANYCODE = B.BASIC_CODE
                              AND B.CODE_TYPE = ''companycode''
                              AND B.COM_ID = 1)
                         else
                          a.companycode
                       end,
       
       A.BNFCAT = case
                    when (SELECT B.TARGET_CODE
                            FROM T_DEF_CODE_MAPPING B
                           WHERE A.BNFCAT = B.BASIC_CODE
                             AND B.CODE_TYPE = ''bnfcat''
                             AND B.COM_ID = 1) is not null then
                     (SELECT B.TARGET_CODE
                        FROM T_DEF_CODE_MAPPING B
                       WHERE A.BNFCAT = B.BASIC_CODE
                         AND B.CODE_TYPE = ''bnfcat''
                         AND B.COM_ID = 1)
                    else
                     a.bnfcat
                  end,
       
       A.BNFLEVEL = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.BNFLEVEL = B.BASIC_CODE
                               AND B.CODE_TYPE = ''bnflevel''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.BNFLEVEL = B.BASIC_CODE
                           AND B.CODE_TYPE = ''bnflevel''
                           AND B.COM_ID = 1)
                      else
                       a.bnflevel
                    end,
       
       A.RELATIONTOINSURED = case
                               when (SELECT B.TARGET_CODE
                                       FROM T_DEF_CODE_MAPPING B
                                      WHERE A.RELATIONTOINSURED = B.BASIC_CODE
                                        AND B.CODE_TYPE = ''relationtoinsured''
                                        AND B.COM_ID = 1) is not null then
                                (SELECT B.TARGET_CODE
                                   FROM T_DEF_CODE_MAPPING B
                                  WHERE A.RELATIONTOINSURED = B.BASIC_CODE
                                    AND B.CODE_TYPE = ''relationtoinsured''
                                    AND B.COM_ID = 1)
                               else
                                a.relationtoinsured
                             end,
       
       A.SEX = case
                 when (SELECT B.TARGET_CODE
                         FROM T_DEF_CODE_MAPPING B
                        WHERE A.SEX = B.BASIC_CODE
                          AND B.CODE_TYPE = ''sex''
                          AND B.COM_ID = 1) is not null then
                  (SELECT B.TARGET_CODE
                     FROM T_DEF_CODE_MAPPING B
                    WHERE A.SEX = B.BASIC_CODE
                      AND B.CODE_TYPE = ''sex''
                      AND B.COM_ID = 1)
                 else
                  a.sex
               end,
       
       A.CERTTYPE = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.CERTTYPE = B.BASIC_CODE
                               AND B.CODE_TYPE = ''certtype''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.CERTTYPE = B.BASIC_CODE
                           AND B.CODE_TYPE = ''certtype''
                           AND B.COM_ID = 1)
                      else
                       a.certtype
                    end,A.TRANSACTIONNO = (CASE
                            WHEN A.TRANSACTIONNO IN
                                 (SELECT C.CHGID
                                    FROM T_PRP_CHG_TRANS_ID_MAP C
                                 ) THEN
                             (SELECT Max(C.TRANSNO)
                                FROM  T_PRP_CHG_TRANS_ID_MAP C
                                 WHERE A.TRANSACTIONNO = C.CHGID
                             )
                            ELSE
                             A.TRANSACTIONNO
                          END)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10929;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10936 IS   V_ID NUMBER :=10936;  V_SQL_ID NUMBER :=10960;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCCONT A
   SET A.COMPANYCODE = case
                         when (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.COMPANYCODE = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''companycode''
                                  AND B.COM_ID = 1) is not null then
                          (SELECT B.TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE A.COMPANYCODE = B.BASIC_CODE
                              AND B.CODE_TYPE = ''companycode''
                              AND B.COM_ID = 1)
                         else
                          a.companycode
                       end,
       
       A.GPFLAG = case
                    when (SELECT B.TARGET_CODE
                            FROM T_DEF_CODE_MAPPING B
                           WHERE A.GRPPOLICYNO = B.BASIC_CODE
                             AND B.CODE_TYPE = ''gpflag''
                             AND B.COM_ID = 1) is not null then
                     (SELECT B.TARGET_CODE
                        FROM T_DEF_CODE_MAPPING B
                       WHERE A.GRPPOLICYNO = B.BASIC_CODE
                         AND B.CODE_TYPE = ''gpflag''
                         AND B.COM_ID = 1)
                    else
                     a.gpflag
                  end,
       
       A.FAMILYPOLTYPE = case
                           when (SELECT B.TARGET_CODE
                                   FROM T_DEF_CODE_MAPPING B
                                  WHERE A.FAMILYPOLTYPE = B.BASIC_CODE
                                    AND B.CODE_TYPE = ''familypoltype''
                                    AND B.COM_ID = 1) is not null then
                            (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.FAMILYPOLTYPE = B.BASIC_CODE
                                AND B.CODE_TYPE = ''familypoltype''
                                AND B.COM_ID = 1)
                           else
                            a.familypoltype
                         end,
       
       A.MANAGECOM = case
                       when (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.MANAGECOM = B.BASIC_CODE
                                AND B.CODE_TYPE = ''managecom''
                                AND B.COM_ID = 1) is not null then
                        (SELECT B.TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE A.MANAGECOM = B.BASIC_CODE
                            AND B.CODE_TYPE = ''managecom''
                            AND B.COM_ID = 1)
                       else
                        a.managecom
                     end,
       
       A.MANAGECOMNAME = case
                           when (SELECT B.TARGET_CODE
                                   FROM T_DEF_CODE_MAPPING B
                                  WHERE A.MANAGECOMNAME = B.BASIC_CODE
                                    AND B.CODE_TYPE = ''managecomname''
                                    AND B.COM_ID = 1) is not null then
                            (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.MANAGECOMNAME = B.BASIC_CODE
                                AND B.CODE_TYPE = ''managecomname''
                                AND B.COM_ID = 1)
                           else
                            a.managecomname
                         end,
       
       A.APPNTSEX = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.APPNTSEX = B.BASIC_CODE
                               AND B.CODE_TYPE = ''sex''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.APPNTSEX = B.BASIC_CODE
                           AND B.CODE_TYPE = ''sex''
                           AND B.COM_ID = 1)
                      else
                       a.appntsex
                    end,
       
       A.APPNTCERTTYPE = case
                           when (SELECT B.TARGET_CODE
                                   FROM T_DEF_CODE_MAPPING B
                                  WHERE A.APPNTCERTTYPE = B.BASIC_CODE
                                    AND B.CODE_TYPE = ''certtype''
                                    AND B.COM_ID = 1) is not null then
                            (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.APPNTCERTTYPE = B.BASIC_CODE
                                AND B.CODE_TYPE = ''certtype''
                                AND B.COM_ID = 1)
                           else
                            a.appntcerttype
                         end,
       
       A.PROVINCE = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.PROVINCE = B.BASIC_CODE
                               AND B.CODE_TYPE = ''city''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.PROVINCE = B.BASIC_CODE
                           AND B.CODE_TYPE = ''city''
                           AND B.COM_ID = 1)
                      else
                       a.province
                    end,
       
       A.CITY = case
                  when (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.CITY = B.BASIC_CODE
                           AND B.CODE_TYPE = ''city''
                           AND B.COM_ID = 1) is not null then
                   (SELECT B.TARGET_CODE
                      FROM T_DEF_CODE_MAPPING B
                     WHERE A.CITY = B.BASIC_CODE
                       AND B.CODE_TYPE = ''city''
                       AND B.COM_ID = 1)
                  else
                   a.CITY
                end,
       A.COUNTY = case
                    when (SELECT B.TARGET_CODE
                            FROM T_DEF_CODE_MAPPING B
                           WHERE A.COUNTY = B.BASIC_CODE
                             AND B.CODE_TYPE = ''city''
                             AND B.COM_ID = 1) is not null then
                     (SELECT B.TARGET_CODE
                        FROM T_DEF_CODE_MAPPING B
                       WHERE A.COUNTY = B.BASIC_CODE
                         AND B.CODE_TYPE = ''city''
                         AND B.COM_ID = 1)
                    else
                     a.county
                  end,
       
       A.PAYMODE = case
                     when
                     
                      (SELECT B.TARGET_CODE
                         FROM T_DEF_CODE_MAPPING B
                        WHERE A.PAYMODE = B.BASIC_CODE
                          AND B.CODE_TYPE = ''paymode''
                          AND B.COM_ID = 1) is not null then
                      (SELECT B.TARGET_CODE
                         FROM T_DEF_CODE_MAPPING B
                        WHERE A.PAYMODE = B.BASIC_CODE
                          AND B.CODE_TYPE = ''paymode''
                          AND B.COM_ID = 1)
                     else
                      a.paymode
                   end,
       
       A.PAYWAY = case
                    when (SELECT B.TARGET_CODE
                            FROM T_DEF_CODE_MAPPING B
                           WHERE A.PAYWAY = B.BASIC_CODE
                             AND B.CODE_TYPE = ''payway''
                             AND B.COM_ID = 1) is not null then
                     (SELECT B.TARGET_CODE
                        FROM T_DEF_CODE_MAPPING B
                       WHERE A.PAYWAY = B.BASIC_CODE
                         AND B.CODE_TYPE = ''payway''
                         AND B.COM_ID = 1)
                    else
                     a.payway
                  end,
       
       A.CURRENCY = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.CURRENCY = B.BASIC_CODE
                               AND B.CODE_TYPE = ''currency''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.CURRENCY = B.BASIC_CODE
                           AND B.CODE_TYPE = ''currency''
                           AND B.COM_ID = 1)
                      else
                       a.currency
                    end,
       
       A.UWTYPE = case
                    when (SELECT B.TARGET_CODE
                            FROM T_DEF_CODE_MAPPING B
                           WHERE A.UWTYPE = B.BASIC_CODE
                             AND B.CODE_TYPE = ''uwtype''
                             AND B.COM_ID = 1) is not null then
                     (SELECT B.TARGET_CODE
                        FROM T_DEF_CODE_MAPPING B
                       WHERE A.UWTYPE = B.BASIC_CODE
                         AND B.CODE_TYPE = ''uwtype''
                         AND B.COM_ID = 1)
                    else
                     a.uwtype
                  end,
       A.POLSTATUS = case
                       when (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.POLSTATUS = B.BASIC_CODE
                                AND B.CODE_TYPE = ''polstatus''
                                AND B.COM_ID = 1) is not null then
                        (SELECT B.TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE A.POLSTATUS = B.BASIC_CODE
                            AND B.CODE_TYPE = ''polstatus''
                            AND B.COM_ID = 1)
                       else
                        a.polstatus
                     end,
       
       A.BANKCODE = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.BANKCODE = B.BASIC_CODE
                               AND B.CODE_TYPE = ''bankcode''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.BANKCODE = B.BASIC_CODE
                           AND B.CODE_TYPE = ''bankcode''
                           AND B.COM_ID = 1)
                      else
                       a.bankcode
                    end,
       
       A.POLICYTYPE = case
                        when (SELECT B.TARGET_CODE
                                FROM T_DEF_CODE_MAPPING B
                               WHERE A.POLICYTYPE = B.BASIC_CODE
                                 AND B.CODE_TYPE = ''policytype''
                                 AND B.COM_ID = 1) is not null then
                         (SELECT B.TARGET_CODE
                            FROM T_DEF_CODE_MAPPING B
                           WHERE A.POLICYTYPE = B.BASIC_CODE
                             AND B.CODE_TYPE = ''policytype''
                             AND B.COM_ID = 1)
                        else
                         a.policytype
                      end,
       
       A.DISTRIBCHNL = case
                         when (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.DISTRIBCHNL = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''distribchnl''
                                  AND B.COM_ID = 1) is not null then
                          (SELECT B.TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE A.DISTRIBCHNL = B.BASIC_CODE
                              AND B.CODE_TYPE = ''distribchnl''
                              AND B.COM_ID = 1)
                         else
                          a.distribchnl
                       end,
       A.TERMINATIONREASON = case
                               when (SELECT B.TARGET_CODE
                                       FROM T_DEF_CODE_MAPPING B
                                      WHERE A.TERMINATIONREASON = B.BASIC_CODE
                                        AND B.CODE_TYPE = ''terminationreason''
                                        AND B.COM_ID = 1) is not null then
                                (SELECT B.TARGET_CODE
                                   FROM T_DEF_CODE_MAPPING B
                                  WHERE A.TERMINATIONREASON = B.BASIC_CODE
                                    AND B.CODE_TYPE = ''terminationreason''
                                    AND B.COM_ID = 1)
                               else
                                a.terminationreason
                             end,A.TRANSACTIONNO = (CASE
                            WHEN A.TRANSACTIONNO IN
                                 (SELECT C.CHGID
                                    FROM T_PRP_CHG_TRANS_ID_MAP C
                                 ) THEN
                             (SELECT Max(C.TRANSNO)
                                FROM  T_PRP_CHG_TRANS_ID_MAP C
                                 WHERE A.TRANSACTIONNO = C.CHGID
                             )
                            ELSE
                             A.TRANSACTIONNO
                          END)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10936;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10701 IS   V_ID NUMBER :=10701;  V_SQL_ID NUMBER :=10725;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='select *  from (SELECT 
 (SELECT MAX(PC.POLICY_CHG_ID)  
       FROM ODS_STG.OFE_T_POLICY_CHANGE PC
       LEFT JOIN ODS_STG.OFE_T_POLICY P ON P.RC_STATE = ''E'' AND P.POLICY_ID = PC.POLICY_ID
       LEFT JOIN ODS_STG.OFE_T_POL_PLAN PP ON PP.RC_STATE = ''E'' AND PP.POLICY_ID = P.POLICY_ID
       LEFT JOIN ODS_STG.OFE_T_PD_PRODUCT PD ON PD.RC_STATE = ''E'' AND PD.PD_PRODUCT_ID = PP.PD_PRODUCT_ID
       WHERE 1 = 1
       AND PD.COVERAGE_TERM_TYPE <> ''M''
       AND NOT EXISTS(
           SELECT 1 FROM ODS_STG.OFE_T_RLS_POLICY A 
            WHERE TO_CHAR(A.PNO) = TO_CHAR(P.POLICY_NO) AND A.FLAG = ''1'')
      AND PC.RC_STATE = ''E'' 
      AND PC.POLICY_ID = P.POLICY_ID 
      AND PC.POLICY_CHG_ID > 0
      AND P.POLICY_ID > 0
      AND PD.PD_PRODUCT_ID NOT IN (SELECT DISTINCT c.pd_product_id
                                from ODS_STG.OFE_t_Cfg_Plan_Print a,ODS_STG.OFE_t_pd_product_plan b,
                                ODS_STG.OFE_T_POL_PLAN c,ods_stg.OFE_T_PD_PRODUCT d
                                where a.pd_plan_id=b.pd_plan_id 
                                AND d.pd_product_id=c.pd_product_id
                                AND b.pd_product_id=c.pd_product_id 
                                AND a.is_show=0)   
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
      AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn})
      AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')) AS TRANSACTIONNO,
      RISK.*
      FROM (
SELECT DISTINCT
       ''000031'' AS COMPANYCODE,
       TO_CHAR(PD.PRODUCT_CODE) AS PRODUCTCODE,
       PD.PRODUCT_NAME AS PRODUCTNAME,
       PD.PRODUCT_SHORT_NAME AS PRODUCTABBR,
       PD.PRODUCT_NAME_ENG AS PRODUCTENNAME,
       TO_CHAR(PD.PRODUCT_CODE) AS PORDUCTENABBR,
       ''Y'' AS INSUACCFLAG,
       0.001 AS ASSUMINTRATE,
       (CASE WHEN PPC.PRODUCT_CATEGORY IS NULL THEN ''1-3'' 
        ELSE (CASE WHEN (PPC.PRODUCT_CATEGORY = ''3-1'' AND PD.PRODUCT_NAME LIKE ''%防癌%'') THEN ''15220''
                   WHEN (PPC.PRODUCT_CATEGORY = ''3-1'' AND PD.PRODUCT_CODE LIKE ''CDC'') THEN ''CDC'' 
                   WHEN (PPC.PRODUCT_CATEGORY = ''3-1'' AND PD.PRODUCT_CODE IN (''PCB'',''FDC'')) THEN ''15290''
               ELSE PPC.PRODUCT_CATEGORY
               END
              )
         END) AS PRODUCTTYPE,
       (CASE
         WHEN PD.FUND_INVEST_FLAG = ''1'' THEN ''230''
         WHEN PD.DVD_FLAG = ''1'' THEN ''210''
         WHEN PRODUCT_CATEGORY = ''U'' THEN ''220'' 
         --WHEN PD.UL_FLAG = ''1'' THEN ''220''
         ELSE ''999''
       END) AS INVESTMENTTYPE,
       PD.COVERAGE_TERM_TYPE AS TERMTYPE,
       ''01'' AS GPFLAG,
       PD.BASIC_PRODUCT_FLAG AS MAINPRODUCTFLAG,
       (CASE
         WHEN (SELECT COUNT(1)
                 FROM ODS_STG.OFE_T_PD_PRODUCT_PLAN TT
                WHERE TT.PD_PRODUCT_ID = PD.PD_PRODUCT_ID
                  AND (TT.PLAN_END_DATE IS NULL OR TT.PLAN_END_DATE = '''')) > 0 THEN
          NULL
         ELSE
          (SELECT MAX(TT.PLAN_END_DATE)
             FROM ODS_STG.OFE_T_PD_PRODUCT_PLAN TT
            WHERE TT.PD_PRODUCT_ID = PD.PD_PRODUCT_ID)
       END) AS STOPDATE,
       (CASE
         WHEN (SELECT COUNT(1)
                 FROM ODS_STG.OFE_T_PD_PRODUCT_PLAN TT
                WHERE TT.PD_PRODUCT_ID = PD.PD_PRODUCT_ID
                  AND TT.PLAN_END_DATE IS NULL) > 0 THEN
          ''Y''
         ELSE
          ''N''
       END) AS SALEFLAG,
       '''' AS CIRCRISKCODE,
       PD.OPERATOR_ID AS OPERATOR,
       TO_DATE(TO_CHAR(pd.insert_time, ''yyyy-mm-dd''), ''yyyy-mm-dd'') AS MAKEDATE,
       TO_CHAR(SYSDATE, ''hh:mm:ss'') AS MAKETIME,
       TO_DATE(TO_CHAR(SYSDATE, ''yyyy-mm-dd''), ''yyyy-mm-dd'') AS MODIFYDATE,
       TO_CHAR(SYSDATE, ''hh:mm:ss'') AS MODIFYTIME
  FROM ODS_STG.OFE_T_PD_PRODUCT PD
  LEFT JOIN ODS_STG.OFE_T_PD_PRODUCT_CATEGORY PPC 
       ON PPC.RC_STATE = ''E'' 
       AND PPC.PD_PRODUCT_ID = PD.PD_PRODUCT_ID
       AND PPC.CATEGORY_TYPE = ''04''
 WHERE 1=1
   AND PD.RC_STATE = ''E''
   AND pd.COVERAGE_TERM_TYPE <> ''M''
 ) RISK) where TRANSACTIONNO is not null'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10701;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10700 IS   V_ID NUMBER :=10700;  V_SQL_ID NUMBER :=10724;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='SELECT DISTINCT
       pc.policy_chg_id as TransactionNo,
       ''000031'' AS COMPANYCODE,
       CLM.CASE_NO AS CLMCASENO,
       CLM.CLAIM_REGISTER_ID AS CLMREGISTERNO,
       '''' AS GRPPOLICYNO,
       P.POLICY_NO AS POLICYNO,
       PD.PD_PRODUCT_ID AS PRODUCTNO,
       NVL(CLM.REGISTER_DATE, CLM.APPLY_DATE) AS RGTDATE,
       CLM.ACCIDENT_DATE AS LOSSOCCURDATE,
       '''' AS LOSSOCCURLOCATION,
       NVL(CLM.CLAIM_CAUSE, ''1'') AS LOSSOCCURREASON,
       CLM.COMMENTS AS ACCIDENTDESC,
       NVL(CLM.CLAIM_ITEM, ''306'') AS BENEFITTYPE,
       PD.PRODUCT_CODE AS PRODUCTCODE,
       ''156'' AS CURRENCY,
       NVL((CLM.CALC_AMOUNT + CLM.CALC_ADJUST_AMOUNT), 0) AS CLMACOUNTAMNT,
       NVL((CLM.PAYMENT_AMOUNT + CLM.ADJUST_AMOUNT), 0) AS CLMASSESSAMNT,
       (CASE CCB.DECISION
         WHEN ''2'' THEN
          CCB.PAYMENT_AMOUNT
         ELSE
          0
       END) AS REJECTAMNT,
       (CASE CCB.DECISION
         WHEN ''1'' THEN
          CCB.PAYMENT_AMOUNT
         ELSE
          0
       END) AS PREPAYAMNT,
       (CASE CCB.DECISION
         WHEN ''4'' THEN
          CCB.PAYMENT_AMOUNT
         ELSE
          0
       END) AS APPROVEAMNT,
       (CASE CCB.DECISION
         WHEN ''4'' THEN
          CCB.PAYMENT_AMOUNT
         ELSE
          0
       END) AS AGREEAMNT,
       CLM.SETTLE_DATE AS CLMSETTDATE,
       NVL(CCB.DECISION, 1) AS PAYSTATUSCODE,
       P.BRANCH_CODE AS MANAGECOM,
       P.OPERATOR_ID AS OPERATOR,
       TO_DATE(TO_CHAR(CLM.INSERT_TIME, ''yyyy-mm-dd''), ''yyyy-mm-dd'') AS MAKEDATE,
       TO_CHAR(CLM.INSERT_TIME, ''hh24:mi:ss'') AS MAKETIME,
       TO_DATE(TO_CHAR(SYSDATE, ''yyyy-mm-dd''), ''yyyy-mm-dd'') AS MODIFYDATE,
       TO_CHAR(SYSDATE, ''hh24:mi:ss'') AS MODIFYTIME
  FROM ODS_STG.OFE_T_POLICY_CHANGE PC  
LEFT JOIN ODS_STG.OFE_T_POLICY P ON P.RC_STATE = ''E'' AND P.POLICY_ID = PC.POLICY_ID
RIGHT JOIN (SELECT CLMP.*,
                    CRG.REGISTER_TYPE,
                    CRG.CLAIM_ITEM,
                    CRG.APPLY_DATE,
                    CRG.REGISTER_DATE,
                    CRG.CLAIM_REGISTER_ITEM_ID
               FROM (SELECT CC.POLICY_ID,
                            CC.CASE_ID,
                            CC.CLAIM_REGISTER_ID,
                            CC.CLIENT_ID,
                            CC.CASE_NO,
                            CC.ACCIDENT_DATE,
                            CC.CASE_DECISION,
                            CC.CLAIM_CAUSE,
                            CC.COMMENTS,
                            CC.PAYMENT_RATE,
                            CC.CALC_AMOUNT,
                            CC.CALC_ADJUST_AMOUNT,
                            CC.ADJUST_AMOUNT,
                            CC.PAYMENT_AMOUNT,
                            CC.SETTLE_DATE,
                            CCP.CLAIM_CASE_POLICY_ID,
                            CCP.OPERATOR_ID,
                            CCP.INSERT_TIME
                       FROM ODS_STG.OFE_T_CLAIM_CASE        CC,
                            ODS_STG.OFE_T_CLAIM_CASE_POLICY CCP
                      WHERE CC.CASE_ID = CCP.CASE_ID
                        AND CC.RC_STATE = ''E''
                        AND CCP.RC_STATE = ''E'') CLMP
               LEFT JOIN (SELECT CR.CLAIM_REGISTER_ID,
                                CR.CLIENT_ID,
                                CR.REGISTER_TYPE,
                                CRI.CLAIM_ITEM,
                                CR.APPLY_DATE,
                                CR.REGISTER_DATE,
                                CRI.CLAIM_REGISTER_ITEM_ID
                           FROM ODS_STG.OFE_T_CLAIM_REGISTER CR
                           LEFT JOIN ODS_STG.OFE_T_CLAIM_REGISTER_ITEM CRI
                             ON CRI.RC_STATE = ''E''
                            AND CR.RC_STATE = ''E''
                            AND CR.REGISTER_TYPE = ''1''
                            AND CR.CLAIM_REGISTER_ID = CRI.CLAIM_REGISTER_ID) CRG
                 ON CLMP.CLAIM_REGISTER_ID = CRG.CLAIM_REGISTER_ID
                AND CLMP.CLIENT_ID = CRG.CLIENT_ID) CLM 
     ON PC.POLICY_ID = CLM.POLICY_ID
LEFT JOIN ODS_STG.OFE_T_POL_PLAN PP 
     ON PP.RC_STATE = ''E'' 
     AND PP.POLICY_ID = P.POLICY_ID
LEFT JOIN ODS_STG.OFE_T_PD_PRODUCT PD 
     ON PD.RC_STATE = ''E'' 
     AND PD.PD_PRODUCT_ID = PP.PD_PRODUCT_ID
LEFT JOIN ODS_STG.OFE_T_CLAIM_CASE_BENEFIT CCB
     ON CCB.RC_STATE = ''E''
     AND CCB.CASE_ID = CLM.CASE_ID
     AND CCB.POL_PLAN_ID = PP.POLICY_PLAN_ID
 WHERE 1 = 1
   --AND PC.POLICY_ID = CLM.POLICY_ID
   AND PD.BASIC_PRODUCT_FLAG = ''B''
   AND PD.COVERAGE_TERM_TYPE <> ''M''
   AND NOT EXISTS (SELECT 1 FROM ODS_STG.OFE_T_RLS_POLICY A WHERE TO_CHAR(A.PNO) = TO_CHAR(P.POLICY_NO) AND A.FLAG = ''1'')
   AND PC.ITEM_ID IS NOT NULL
   AND PC.RC_STATE = ''E'' 
   AND PC.POLICY_ID = P.POLICY_ID 
   AND PC.POLICY_CHG_ID > 0
   AND P.POLICY_ID > 0
   AND PD.PD_PRODUCT_ID NOT IN (SELECT DISTINCT c.pd_product_id
                                from ODS_STG.OFE_t_Cfg_Plan_Print a,ODS_STG.OFE_t_pd_product_plan b,
                                ODS_STG.OFE_T_POL_PLAN c,ods_stg.OFE_T_PD_PRODUCT d
                                where a.pd_plan_id=b.pd_plan_id 
                                AND d.pd_product_id=c.pd_product_id
                                AND b.pd_product_id=c.pd_product_id 
                                AND a.is_show=0)--需屏蔽的险种     
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
  AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn}) 
  AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'') '; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10700;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10653 IS   V_ID NUMBER :=10653;  V_SQL_ID NUMBER :=10678;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :=' SELECT
      TransactionNo
      ,CompanyCode
      ,GrpPolicyNo
      ,PolicyNo
      ,ProductNo
      ,DivYear
      ,DivType
      ,DivDistribMeth
      ,SUM(DivAmnt) AS DivAmnt
      ,MAX(ManageCom) AS ManageCom
      ,MAX(AppntNo) AS AppntNo
      ,MAX(AppntName) AS AppntName
      ,MAX(BankCode) AS BankCode
      ,MAX(BankName) AS BankName
      ,MAX(BankAccNo) AS BankAccNo
      ,MAX(AccName) AS AccName
      ,MAX(CertType) AS CertType
      ,MAX(CertNo) AS CertNo
      ,MAX(OPERATOR) AS OPERATOR
      ,MAX(MAKEDATE) AS MAKEDATE
      ,MAX(MAKETIME) AS MAKETIME
      ,MAX(MODIFYDATE) AS MODIFYDATE 
      ,MAX(MODIFYTIME) AS MODIFYTIME
 FROM (
 SELECT 
      PC.POLICY_CHG_ID AS TRANSACTIONNO,
      ''000031'' AS COMPANYCODE,
      '''' AS GRPPOLICYNO,
       P.POLICY_NO AS POLICYNO,
       PP.POLICY_PLAN_ID AS PRODUCTNO,
       TO_CHAR(PPC.NEXT_DECLARATION_DATE,''yyyy'') AS DIVYEAR,
       ''1'' AS DIVTYPE,
       NVL(PPC.COVERAGE_DEAL_OPTION,9) AS DIVDISTRIBMETH,
       NVL((SELECT SUM(AMOUNT) FROM ODS_STG.OFE_T_POL_ACCOUNT_TRANS_LIST PATL WHERE PATL.POLICY_ID = PC.POLICY_ID
       AND PATL.POLICY_CHG_ID = PC.POLICY_CHG_ID AND PATL.POL_ACCOUNT_ID = PA.POL_ACCOUNT_ID),0) as DivAmnt,
       P.BRANCH_CODE AS MANAGECOM,
       PCM.CLIENT_ID AS APPNTNO,
       PCM.CLIENT_NAME AS APPNTNAME,
       (CASE WHEN (SELECT MAX(BK.BANK_BRANCH_CODE) FROM                   
       ODS_STG.OFE_T_BK_ACC_MST BK 
       WHERE BK.POLICY_NO=P.POLICY_NO AND BK.RC_STATE=''E'') IS NOT NULL 
       THEN (SELECT MAX(BK.BANK_CODE) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
       WHERE BK.POLICY_NO=P.POLICY_NO AND BK.RC_STATE=''E'')
       ||''-''||(SELECT MAX(BK.BANK_BRANCH_CODE) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
       WHERE BK.POLICY_NO=P.POLICY_NO AND BK.RC_STATE=''E'')
       ELSE (SELECT MAX(BK.BANK_CODE) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
       WHERE BK.POLICY_NO=P.POLICY_NO AND BK.RC_STATE=''E'') END) AS BANKCODE,
       (CASE WHEN (SELECT MAX(BK.BANK_BRANCH_CODE) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
       WHERE BK.POLICY_NO=P.POLICY_NO AND BK.RC_STATE=''E'') IS NOT NULL 
       THEN 
       (SELECT MAX(T.BANK_NAME) 
       FROM ODS_STG.OFE_T_BK_ACC_MST BK,ODS_STG.OFE_T_CFG_BANK T 
       WHERE T.BANK_CODE = BK.BANK_CODE AND BK.POLICY_NO=P.POLICY_NO)
       ||''-''||
       (SELECT MAX(TB.BANK_BRANCH_NAME) 
       FROM ODS_STG.OFE_T_BK_ACC_MST BK,ODS_STG.OFE_T_CFG_BANK_BRANCH TB 
       WHERE TB.BANK_BRANCH_CODE = BK.BANK_BRANCH_CODE AND BK.POLICY_NO=P.POLICY_NO)
       ELSE (SELECT MAX(T.BANK_NAME) 
       FROM ODS_STG.OFE_T_BK_ACC_MST BK,ODS_STG.OFE_T_CFG_BANK T 
       WHERE T.BANK_CODE = BK.BANK_CODE AND BK.POLICY_NO=P.POLICY_NO) 
       END) AS BANKNAME, 
       (SELECT MAX(BK.BANK_ACC_NO) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
       WHERE BK.POLICY_NO=P.POLICY_NO AND BK.RC_STATE=''E'') AS BANKACCNO,   
       (SELECT MAX(BK.BANK_OWNER_NAME) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
       WHERE BK.POLICY_NO=P.POLICY_NO AND BK.RC_STATE=''E'') AS ACCNAME,
        (CASE WHEN PCM.CLIENT_ID_NO IS NULL THEN ''990'' ELSE PCM.CLIENT_ID_TYPE END)  AS CERTTYPE
       , NVL(PCM.CLIENT_ID_NO,''99'') AS CERTNO,
       P.OPERATOR_ID AS OPERATOR,
       TO_DATE(TO_CHAR(P.INSERT_TIME,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MAKEDATE,
       TO_CHAR(P.INSERT_TIME,''hh:mm:ss'') AS MAKETIME,
       TO_DATE(TO_CHAR(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') aS MODIFYDATE,
       TO_CHAR(sysdate,''hh:mm:ss'') AS MODIFYTIME
  FROM ODS_STG.OFE_T_POLICY_CHANGE PC 
  LEFT JOIN ODS_STG.OFE_T_POLICY P ON P.RC_STATE = ''E'' AND P.POLICY_ID = PC.POLICY_ID
  LEFT JOIN ODS_STG.OFE_T_POL_PLAN PP ON PP.RC_STATE = ''E'' AND PP.POLICY_ID = P.POLICY_ID
  LEFT JOIN ODS_STG.OFE_T_PD_PRODUCT PD ON PD.RC_STATE = ''E'' AND PD.PD_PRODUCT_ID = PP.PD_PRODUCT_ID 
  LEFT JOIN ODS_STG.OFE_T_POL_ACCOUNT PA 
       ON PA.RC_STATE= ''E'' AND PA.POLICY_ID = P.POLICY_ID 
       AND PA.ACCOUNT_TYPE=''5'' AND PA.POL_PLAN_ID = PP.POLICY_PLAN_ID
  LEFT JOIN ODS_STG.OFE_T_POL_PLAN_COVERAGE PPC ON PPC.RC_STATE = ''E'' 
       AND PPC.POLICY_ID = P.POLICY_ID AND PPC.PAY_TYPE = ''2''
  LEFT JOIN ODS_STG.OFE_T_POL_CLN_MST PCM ON PCM.RC_STATE = ''E'' 
       AND PCM.POLICY_ID = P.POLICY_ID AND PCM.CLIENT_ROLE = ''1''
WHERE PC.RC_STATE = ''E''
  AND PD.BASIC_PRODUCT_FLAG = ''B'' 
  AND PD.COVERAGE_TERM_TYPE <> ''M''
  AND PD.DVD_FLAG=''1''
  AND P.POLICY_ID > 0 
  AND PC.POLICY_CHG_ID > 0
  AND NOT EXISTS(SELECT 1 FROM ODS_STG.OFE_T_RLS_POLICY A WHERE TO_CHAR(A.PNO) = TO_CHAR(P.POLICY_NO) AND A.FLAG = ''1'')
AND PD.PD_PRODUCT_ID NOT IN (SELECT DISTINCT c.pd_product_id
                                from ODS_STG.OFE_t_Cfg_Plan_Print a,ODS_STG.OFE_t_pd_product_plan b,
                                ODS_STG.OFE_T_POL_PLAN c,ods_stg.OFE_T_PD_PRODUCT d
                                where a.pd_plan_id=b.pd_plan_id 
                                AND d.pd_product_id=c.pd_product_id
                                AND b.pd_product_id=c.pd_product_id 
                                AND a.is_show=0)--需屏蔽的险种     
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn}) 
AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
  ) 
 WHERE 1=1
 GROUP BY TRANSACTIONNO,COMPANYCODE,GRPPOLICYNO,POLICYNO,PRODUCTNO,DIVYEAR,DIVTYPE,DIVDISTRIBMETH'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10653;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12894 IS   V_ID NUMBER :=12894;  V_SQL_ID NUMBER :=12934;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='select  lcpt.batchno as BatchNo,        max(to_char(lcpt.TransDate, ''yyyymmdd'')) as TransDate,                count(1) as TransCount,             edp.Page_Name as FileName,                edp.MD5_Code as FileMD5No                  from T_PRP_LCPolTransaction lcpt, T_doc_main edm, T_doc_pages edp           where lcpt.batchno = edm.batch_no           and edm.doc_id = edp.doc_id           and lcpt.batchNo = ''#{batchNo}''            and lcpt.transtype = ''FAI''           group by lcpt.batchno,edp.page_id,edp.Page_Name,edp.MD5_Code,edm.doc_id'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12894;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12892 IS   V_ID NUMBER :=12892;  V_SQL_ID NUMBER :=12932;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='select ''PDL-Head'' as "PDL-Head",''PDL-Body'' as "PDL-Body" from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12892;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12893 IS   V_ID NUMBER :=12893;  V_SQL_ID NUMBER :=12933;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='select ''FaiUpload'' as RequestType,''#{companyCode}'' as CompanyCode,''#{serialNo}'' as SerialNo,''#{dateSerialNo}'' as TimeStamp,''L'' as DataType from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12893;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12510 IS   V_ID NUMBER :=12510;  V_SQL_ID NUMBER :=12529;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='  DELETE FROM  T_PRP_LCProduct T WHERE NOT EXISTS (SELECT ''x'' FROM T_PRP_LCCont TT WHERE T.TRANSACTIONNO = TT.TRANSACTIONNO AND TT.Policyno = T.policyNo)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12510;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12508 IS   V_ID NUMBER :=12508;  V_SQL_ID NUMBER :=12527;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='  DELETE FROM  T_PRP_LCCont T WHERE NOT EXISTS (SELECT ''x'' FROM T_PRP_LCPolTransaction TT WHERE T.TRANSACTIONNO = TT.TRANSACTIONNO AND T.Policyno = TT.Policyno)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12508;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12512 IS   V_ID NUMBER :=12512;  V_SQL_ID NUMBER :=12531;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :=' DELETE FROM  T_PRP_LLBnf T WHERE NOT EXISTS (SELECT ''x'' FROM T_PRP_LCCont TT WHERE T.TRANSACTIONNO = TT.TRANSACTIONNO AND TT.Policyno = T.policyNo)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12512;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12514 IS   V_ID NUMBER :=12514;  V_SQL_ID NUMBER :=12533;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='  DELETE FROM  T_PRP_LCBnf T WHERE NOT EXISTS (SELECT ''x'' FROM T_PRP_LCCont TT WHERE T.TRANSACTIONNO = TT.TRANSACTIONNO AND TT.Policyno = T.policyNo)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12514;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12515 IS   V_ID NUMBER :=12515;  V_SQL_ID NUMBER :=12534;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='  DELETE FROM  T_PRP_LCInsureAcc T WHERE NOT EXISTS (SELECT ''x'' FROM T_PRP_LCCont TT WHERE T.TRANSACTIONNO = TT.TRANSACTIONNO AND TT.Policyno = T.policyNo)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12515;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12522 IS   V_ID NUMBER :=12522;  V_SQL_ID NUMBER :=12541;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='  DELETE FROM  T_PRP_LJAPay T WHERE NOT EXISTS (SELECT ''x'' FROM T_PRP_LCCont TT WHERE TT.Policyno = T.policyNo)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12522;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10776 IS   V_ID NUMBER :=10776;  V_SQL_ID NUMBER :=10800;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LJDIVDISTRIB A
   SET A.MANAGECOM = (CASE
                       WHEN A.MANAGECOM IN
                            (SELECT BASIC_CODE
                               FROM T_DEF_CODE_MAPPING
                              WHERE CODE_TYPE = ''managecom''
                                AND COM_ID = ''1'') THEN
                        (SELECT TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE B.CODE_TYPE = ''managecom''
                            AND A.MANAGECOM = B.BASIC_CODE
                            AND B.COM_ID = ''1'')
                       ELSE
                        A.MANAGECOM
                     END),
       A.BANKCODE = (CASE
                      WHEN A.BANKCODE IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING
                                           WHERE CODE_TYPE = ''bankcode''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''bankcode''
                           AND A.BANKCODE = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.BANKCODE
                    END),
       A.CERTTYPE = (CASE
                      WHEN A.CERTTYPE IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING
                                           WHERE CODE_TYPE = ''certtype''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''certtype''
                           AND A.CERTTYPE = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.CERTTYPE
                    END),
       A.DIVTYPE = (CASE
                     WHEN A.DIVTYPE IN (SELECT BASIC_CODE
                                          FROM T_DEF_CODE_MAPPING
                                         WHERE CODE_TYPE = ''divtype''
                                           AND COM_ID = ''1'') THEN
                      (SELECT TARGET_CODE
                         FROM T_DEF_CODE_MAPPING B
                        WHERE B.CODE_TYPE = ''divtype''
                          AND A.DIVTYPE = B.BASIC_CODE
                          AND B.COM_ID = ''1'')
                     ELSE
                      A.DIVTYPE
                   END),
       A.DIVDISTRIBMETH = (CASE
                            WHEN A.DIVDISTRIBMETH IN
                                 (SELECT BASIC_CODE
                                    FROM T_DEF_CODE_MAPPING
                                   WHERE CODE_TYPE = ''divdistribmeth''
                                     AND COM_ID = ''1'') THEN
                             (SELECT TARGET_CODE
                                FROM T_DEF_CODE_MAPPING B
                               WHERE B.CODE_TYPE = ''divdistribmeth''
                                 AND A.DIVDISTRIBMETH = B.BASIC_CODE
                                 AND B.COM_ID = ''1'')
                            ELSE
                             A.DIVDISTRIBMETH
                          END),
       A.TRANSACTIONNO = (CASE
                            WHEN A.TRANSACTIONNO IN
                                 (SELECT C.CHGID
                                    FROM T_PRP_CHG_TRANS_ID_MAP C
                                 ) THEN
                             (SELECT Max(C.TRANSNO)
                                FROM  T_PRP_CHG_TRANS_ID_MAP C
                                 WHERE A.TRANSACTIONNO = C.CHGID
                             )
                            ELSE
                             A.TRANSACTIONNO
                          END)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10776;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10635 IS   V_ID NUMBER :=10635;  V_SQL_ID NUMBER :=10659;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='SELECT  
          PC.POLICY_CHG_ID AS TRANSACTIONNO,
          ''000031'' AS COMPANYCODE,
          '''' AS GRPPOLICYNO,
          P.POLICY_NO AS POLICYNO,
          PD.PD_PRODUCT_ID AS PRODUCTNO,
          PCM.CLIENT_ID AS INSUREDNO,
          '''' AS CUSTOMERNO,
          P.BRANCH_CODE AS MANAGECOM,
          P.OPERATOR_ID AS OPERATOR,
          TO_DATE(TO_CHAR(P.INSERT_TIME,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MAKEDATE,
          TO_CHAR(P.INSERT_TIME, ''hh24:mi:ss'') AS MAKETIME,
          TO_DATE(TO_CHAR(SYSDATE,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MODIFYDATE,
          TO_CHAR(SYSDATE, ''hh24:mi:ss'') AS MODIFYTIME 
FROM ODS_STG.OFE_T_POLICY_CHANGE PC
LEFT JOIN ODS_STG.OFE_T_POLICY P ON P.RC_STATE = ''E'' AND P.POLICY_ID = PC.POLICY_ID
LEFT JOIN ODS_STG.OFE_T_POL_PLAN PP 
     ON PP.RC_STATE = ''E''
     AND PP.POLICY_ID = P.POLICY_ID
LEFT JOIN ODS_STG.OFE_T_PD_PRODUCT PD 
     ON PD.RC_STATE = ''E'' 
     AND PD.PD_PRODUCT_ID = PP.PD_PRODUCT_ID
LEFT JOIN ODS_STG.OFE_T_POL_CLN_MST   PCM
     ON PCM.RC_STATE = ''E''
     AND PCM.POLICY_ID = P.POLICY_ID
WHERE 1 = 1
AND PCM.CLIENT_ROLE = ''2''
--AND PD.BASIC_PRODUCT_FLAG = ''B'' 
AND PD.COVERAGE_TERM_TYPE <> ''M''
AND NOT EXISTS(SELECT 1 FROM ODS_STG.OFE_T_RLS_POLICY A WHERE TO_CHAR(A.PNO) = TO_CHAR(P.POLICY_NO) AND A.FLAG = ''1'' )
AND PC.RC_STATE = ''E''
AND PC.POLICY_ID = P.POLICY_ID 
AND PC.POLICY_CHG_ID > 0
AND P.POLICY_ID > 0
AND PD.PD_PRODUCT_ID NOT IN (SELECT DISTINCT c.pd_product_id
                                from ODS_STG.OFE_t_Cfg_Plan_Print a,ODS_STG.OFE_t_pd_product_plan b,
                                ODS_STG.OFE_T_POL_PLAN c,ods_stg.OFE_T_PD_PRODUCT d
                                where a.pd_plan_id=b.pd_plan_id 
                                AND d.pd_product_id=c.pd_product_id
                                AND b.pd_product_id=c.pd_product_id 
                                AND a.is_show=0)--需屏蔽的险种     
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn}) 
AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'') '; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10635;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10683 IS   V_ID NUMBER :=10683;  V_SQL_ID NUMBER :=10707;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='SELECT  
     pc.policy_chg_id as TransactionNo,
     ''000031'' AS COMPANYCODE,
     CLM.CASE_NO AS CLAIMNO,
     '''' AS GRPPOLICYNO,
     P.POLICY_NO AS POLICYNO,
     PD.PD_PRODUCT_ID AS PRODUCTNO,
     PCM.CLIENT_ID AS INSUREDNO,
     '''' AS CUSTOMERNO,
     ROW_NUMBER() OVER (PARTITION BY CLM.POLICY_ID,PD.PD_PRODUCT_ID ORDER BY CLM.CASE_ID ) AS BNFSERIALNUM,
     ''1'' AS  BNFCAT,--1 身故, 2 生存 3 未知
     TO_NUMBER(BNF.BNFLEVEL) AS BNFLEVEL,
     BNF.RELATIONTOINSURED AS RELATIONTOINSURED,
     BNF.CLIENT_NAME AS NAME,
     BNF.CLIENT_SEX AS SEX,
     BNF.CLIENT_BIRTHDAY AS BIRTHDATE,
     BNF.CLIENT_ID_TYPE AS CERTTYPE,
     BNF.CLIENT_ID_NO AS CERTNO,
     ''00'' AS RELATIONOFPAYEEANDINSURED,
     CP.PAYEE_ID AS PAYEENO,
     CP.PAYEE_NAME AS PAYEENAME,
     CP.PAYEE_SEX AS PAYEESEX,
     CP.PAYEE_BIRTHDAY AS PAYEEBIRTHDAY,
     CP.PAYEE_ID_TYPE AS PAYEECERTTYPE,
     CP.PAYEE_ID_NO AS PAYEECERTNO,
     NVL(CP.PAYMENT_FREQ,1) AS PERCENTOFBENEFIT,
     NVL(CP.PAYMENT_AMOUNT,0) AS DRAWINGAMNT,
     CP.PAYMENT_MODE AS BENEFITWDMTHD,
     CP.PAYMENT_METHOD AS BENEFITPAYMTHD,
     (CASE WHEN (SELECT MAX(BK.BANK_BRANCH_CODE) 
                   FROM ODS_STG.OFE_T_BK_ACC_MST BK 
                  WHERE BK.POLICY_NO = P.POLICY_NO AND BK.RC_STATE=''E'') IS NOT NULL 
           THEN (SELECT MAX(BK.BANK_CODE) 
                   FROM ODS_STG.OFE_T_BK_ACC_MST BK 
                  WHERE BK.POLICY_NO = P.POLICY_NO AND BK.RC_STATE=''E'')
                 ||''-''||(SELECT MAX(BK.BANK_BRANCH_CODE) 
                           FROM ODS_STG.OFE_T_BK_ACC_MST BK 
                          WHERE BK.POLICY_NO = P.POLICY_NO AND BK.RC_STATE=''E'')
           ELSE (SELECT MAX(BK.BANK_CODE) 
                   FROM ODS_STG.OFE_T_BK_ACC_MST BK 
                  WHERE BK.POLICY_NO = P.POLICY_NO AND BK.RC_STATE=''E'') END) AS BANKCODE,
     (CASE WHEN (SELECT MAX(BK.BANK_BRANCH_CODE) 
                   FROM ODS_STG.OFE_T_BK_ACC_MST BK 
                  WHERE BK.POLICY_NO = P.POLICY_NO AND BK.RC_STATE=''E'') IS NOT NULL 
           THEN (SELECT MAX(T.BANK_NAME) 
                   FROM ODS_STG.OFE_T_BK_ACC_MST BK,ODS_STG.OFE_T_CFG_BANK T 
                  WHERE T.BANK_CODE = BK.BANK_CODE AND BK.POLICY_NO = P.POLICY_NO)
                  ||''-''||(SELECT MAX(TB.BANK_BRANCH_NAME) 
                            FROM ODS_STG.OFE_T_BK_ACC_MST BK,ODS_STG.OFE_T_CFG_BANK_BRANCH TB 
                           WHERE TB.BANK_BRANCH_CODE = BK.BANK_BRANCH_CODE AND BK.POLICY_NO = P.POLICY_NO)
           ELSE (SELECT MAX(T.BANK_NAME) 
                   FROM ODS_STG.OFE_T_BK_ACC_MST BK,ODS_STG.OFE_T_CFG_BANK T 
                  WHERE T.BANK_CODE = BK.BANK_CODE AND BK.POLICY_NO = P.POLICY_NO) 
           END) AS BANKNAME, 
     (SELECT MAX(BK.BANK_ACC_NO) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
       WHERE BK.POLICY_NO = P.POLICY_NO AND BK.RC_STATE=''E'') AS BANKACCNO,   
     (SELECT MAX(BK.BANK_OWNER_NAME) FROM ODS_STG.OFE_T_BK_ACC_MST BK 
       WHERE BK.POLICY_NO = P.POLICY_NO AND BK.RC_STATE=''E'') AS ACCNAME,
     PC.OPERATOR_ID AS OPERATOR,
     TO_DATE(TO_CHAR(PC.INSERT_TIME,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MAKEDATE,
     TO_CHAR(PC.INSERT_TIME,''hh24:mi:ss'') AS MAKETIME,
     TO_DATE(TO_CHAR(SYSDATE,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MODIFYDATE,
     TO_CHAR(SYSDATE,''hh24:mi:ss'') AS MODIFYTIME
FROM ODS_STG.OFE_T_POLICY_CHANGE PC
LEFT JOIN ODS_STG.OFE_T_POLICY P ON P.RC_STATE = ''E'' AND P.POLICY_ID = PC.POLICY_ID
RIGHT JOIN (SELECT CC.POLICY_ID,CC.CASE_ID,CC.CLAIM_REGISTER_ID,CC.CLIENT_ID,
                      CC.CASE_NO,CC.ACCIDENT_DATE,CC.CASE_DECISION,CC.CLAIM_CAUSE,
                      CC.COMMENTS,CC.PAYMENT_RATE,CC.CALC_AMOUNT,CC.CALC_ADJUST_AMOUNT,
                      CC.ADJUST_AMOUNT,CC.PAYMENT_AMOUNT,CC.SETTLE_DATE,
                      CCP.CLAIM_CASE_POLICY_ID,CCP.OPERATOR_ID,CCP.INSERT_TIME 
                FROM ODS_STG.OFE_T_CLAIM_CASE CC,ODS_STG.OFE_T_CLAIM_CASE_POLICY CCP
               WHERE CC.CASE_ID = CCP.CASE_ID 
                 AND CC.RC_STATE = ''E'' 
                 AND CCP.RC_STATE = ''E''
         ) CLM on CLM.policy_id = pc.policy_id
LEFT JOIN ODS_STG.OFE_T_POL_PLAN PP 
     ON PP.RC_STATE = ''E'' 
     AND PP.POLICY_ID = P.POLICY_ID
LEFT JOIN ODS_STG.OFE_T_PD_PRODUCT PD 
     ON PD.RC_STATE = ''E'' 
     AND PD.PD_PRODUCT_ID = PP.PD_PRODUCT_ID
LEFT JOIN ODS_STG.OFE_T_CLAIM_PAYMENT CP
     ON CP.CASE_ID = CLM.CASE_ID
     AND CP.RC_STATE = ''E''
LEFT JOIN ODS_STG.OFE_T_POL_CLN_MST  PCM
     ON PCM.RC_STATE = ''E''
     AND PCM.POLICY_ID = CLM.POLICY_ID
     AND PCM.CLIENT_ROLE = ''2''
LEFT JOIN (SELECT PBI.POLICY_ID AS POLICY_ID,
           PBI.POLICY_CLIENT_ID AS POLICY_CLIENT_ID,
           PCM.CLIENT_ID AS CLIENT_ID,
           ROW_NUMBER() OVER(PARTITION BY PCM.POLICY_ID, PP.POLICY_PLAN_ID ORDER BY PCM.POLICY_ID, PP.POLICY_PLAN_ID) AS BNFSERIALNUM,
           PBI.BENEFICIARY_ORDER AS BNFLEVEL,
           PBI.BNF_RELATION_TO_INSURED AS RELATIONTOINSURED,
           PBI.BENEFICIARY_PERCENTAGE AS PERCENTOFBENEFIT,
           PCM.CLIENT_ROLE,
           PCM.CLIENT_NAME,
           PCM.CLIENT_SEX,
           PCM.CLIENT_BIRTHDAY,
           PCM.CLIENT_ID_TYPE,
           PCM.CLIENT_ID_NO,
           PP.POLICY_PLAN_ID,
           PP.PD_PRODUCT_ID
      FROM ODS_STG.OFE_T_POL_BENEFICIARY_INFO PBI,
           ODS_STG.OFE_T_POL_CLN_MST          PCM,
           ODS_STG.OFE_T_POL_PLAN             PP
     WHERE PBI.POLICY_CLIENT_ID = PCM.POLICY_CLIENT_ID
       AND PBI.RC_STATE = ''E''
       AND PCM.RC_STATE = ''E''
       AND PP.RC_STATE = ''E''
       AND PP.POLICY_ID = PCM.POLICY_ID
    UNION ALL
    SELECT P.POLICY_ID,
           PCM.POLICY_CLIENT_ID,
           PCM.CLIENT_ID AS CLIENT_ID,
           ROW_NUMBER() OVER(PARTITION BY PCM.POLICY_ID, PP.POLICY_PLAN_ID ORDER BY PCM.POLICY_ID, PP.POLICY_PLAN_ID) AS BNFSERIALNUM,
           1 AS BNFLEVEL,
           PP.RELATIONSHIP_TO_INSURED AS RELATIONTOINSURED,
           1.0 AS PERCENTOFBENEFIT,
           PCM.CLIENT_ROLE,
           ''法定受益人'' AS CLIENT_NAME,
           PCM.CLIENT_SEX,
           PCM.CLIENT_BIRTHDAY,
           PCM.CLIENT_ID_TYPE,
           PCM.CLIENT_ID_NO,
           PP.POLICY_PLAN_ID,
           PP.PD_PRODUCT_ID
      FROM ODS_STG.OFE_T_POL_CLN_MST PCM,
           ODS_STG.OFE_T_POLICY      P,
           ODS_STG.OFE_T_POL_PLAN    PP
     WHERE P.POLICY_ID = PCM.POLICY_ID
       AND P.RC_STATE = ''E''
       AND PCM.RC_STATE = ''E''
       AND PP.RC_STATE = ''E''
       AND P.STATUTORY_BENEFICIARY_FLAG = ''1''
       AND PCM.CLIENT_ROLE != ''3''
       AND PP.POLICY_ID = P.POLICY_ID
       AND PP.POLICY_CLIENT_ID = PCM.POLICY_CLIENT_ID
       AND NOT EXISTS (SELECT 1
              FROM ODS_STG.OFE_T_POL_BENEFICIARY_INFO T
             WHERE T.POLICY_ID = P.POLICY_ID)) BNF
  ON BNF.POLICY_ID = CLM.POLICY_ID
  AND BNF.PD_PRODUCT_ID = PD.PD_PRODUCT_ID
  AND BNF.POLICY_ID = PC.POLICY_ID
WHERE 1 = 1
 AND PC.POLICY_ID = CLM.POLICY_ID
 --AND PD.BASIC_PRODUCT_FLAG = ''B''
 AND PD.COVERAGE_TERM_TYPE <> ''M''
 AND NOT EXISTS
 (SELECT 1 FROM ODS_STG.OFE_T_RLS_POLICY A WHERE TO_CHAR(A.PNO) = TO_CHAR(P.POLICY_NO) AND A.FLAG = ''1'')
 AND PC.ITEM_ID IS NOT NULL
 AND PC.RC_STATE = ''E'' 
 AND PC.POLICY_ID = P.POLICY_ID 
 AND PC.POLICY_CHG_ID > 0
 AND P.POLICY_ID > 0
AND PD.PD_PRODUCT_ID NOT IN (SELECT DISTINCT c.pd_product_id
                                from ODS_STG.OFE_t_Cfg_Plan_Print a,ODS_STG.OFE_t_pd_product_plan b,
                                ODS_STG.OFE_T_POL_PLAN c,ods_stg.OFE_T_PD_PRODUCT d
                                where a.pd_plan_id=b.pd_plan_id 
                                AND d.pd_product_id=c.pd_product_id
                                AND b.pd_product_id=c.pd_product_id 
                                AND a.is_show=0)--需屏蔽的险种     
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn}) 
AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10683;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12837 IS   V_ID NUMBER :=12837;  V_SQL_ID NUMBER :=12869;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='select ''HisResultQuery'' as RequestType,''#{companyCode}'' as CompanyCode,''#{serialNo}'' as SerialNo,''#{dateSerialNo}'' as TimeStamp,''L'' as DataType from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12837;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10920 IS   V_ID NUMBER :=10920;  V_SQL_ID NUMBER :=10944;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCPOLTRANSACTION A
   SET A.COMPANYCODE = case
                         when (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.COMPANYCODE = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''companycode''
                                  AND B.COM_ID = 1) is not null then
                          (SELECT B.TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE A.COMPANYCODE = B.BASIC_CODE
                              AND B.CODE_TYPE = ''companycode''
                              AND B.COM_ID = 1)
                         else
                          a.companycode
                       end,
       
       A.BUSSTYPE = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.BUSSTYPE = B.BASIC_CODE
                               AND B.CODE_TYPE = ''busstype''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.BUSSTYPE = B.BASIC_CODE
                           AND B.CODE_TYPE = ''busstype''
                           AND B.COM_ID = 1)
                      else
                       a.busstype
                    end,
       
       A.CERTTYPE = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.CERTTYPE = B.BASIC_CODE
                               AND B.CODE_TYPE = ''certtype''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.CERTTYPE = B.BASIC_CODE
                           AND B.CODE_TYPE = ''certtype''
                           AND B.COM_ID = 1)
                      else
                       a.certtype
                    end,
       A.BANKCODE = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.BANKCODE = B.BASIC_CODE
                               AND B.CODE_TYPE = ''bankcode''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.BANKCODE = B.BASIC_CODE
                           AND B.CODE_TYPE = ''bankcode''
                           AND B.COM_ID = 1)
                      else
                       a.bankcode
                    end,A.TRANSACTIONNO = (CASE
                            WHEN A.TRANSACTIONNO IN
                                 (SELECT C.CHGID
                                    FROM T_PRP_CHG_TRANS_ID_MAP C
                                 ) THEN
                             (SELECT Max(C.TRANSNO)
                                FROM  T_PRP_CHG_TRANS_ID_MAP C
                                 WHERE A.TRANSACTIONNO = C.CHGID
                             )
                            ELSE
                             A.TRANSACTIONNO
                          END)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10920;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10925 IS   V_ID NUMBER :=10925;  V_SQL_ID NUMBER :=10949;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LAAGENT A
   SET A.MANAGECOM = CASE
                       WHEN (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.MANAGECOM = B.BASIC_CODE
                                AND B.CODE_TYPE = ''managecom''
                                AND B.COM_ID = 1) IS NOT NULL THEN
                        (SELECT B.TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE A.MANAGECOM = B.BASIC_CODE
                            AND B.CODE_TYPE = ''managecom''
                            AND B.COM_ID = 1)
                       ELSE
                        A.MANAGECOM
                     END,
       
       A.COMPANYCODE = CASE
                         WHEN (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.COMPANYCODE = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''companycode''
                                  AND B.COM_ID = 1) IS NOT NULL THEN
                          (SELECT B.TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE A.COMPANYCODE = B.BASIC_CODE
                              AND B.CODE_TYPE = ''companycode''
                              AND B.COM_ID = 1)
                         ELSE
                          A.COMPANYCODE
                       END,
       A.SEX = case
                 when
                 
                  (SELECT B.TARGET_CODE
                     FROM T_DEF_CODE_MAPPING B
                    WHERE A.SEX = B.BASIC_CODE
                      AND B.CODE_TYPE = ''sex''
                      AND B.COM_ID = 1) is not null then
                  (SELECT B.TARGET_CODE
                     FROM T_DEF_CODE_MAPPING B
                    WHERE A.SEX = B.BASIC_CODE
                      AND B.CODE_TYPE = ''sex''
                      AND B.COM_ID = 1)
                 else
                  a.sex
               end,
       A.OFFICEWORKFLAG = case
                            when (SELECT B.TARGET_CODE
                                    FROM T_DEF_CODE_MAPPING B
                                   WHERE A.OFFICEWORKFLAG = B.BASIC_CODE
                                     AND B.CODE_TYPE = ''officeworkflag''
                                     AND B.COM_ID = 1) is not null then
                             (SELECT B.TARGET_CODE
                                FROM T_DEF_CODE_MAPPING B
                               WHERE A.OFFICEWORKFLAG = B.BASIC_CODE
                                 AND B.CODE_TYPE = ''officeworkflag''
                                 AND B.COM_ID = 1)
                            else
                             a.officeworkflag
                          end,
       A.FULLTIMEFLAG = case
                          when (SELECT B.TARGET_CODE
                                  FROM T_DEF_CODE_MAPPING B
                                 WHERE A.FULLTIMEFLAG = B.BASIC_CODE
                                   AND B.CODE_TYPE = ''fulltimeflag''
                                   AND B.COM_ID = 1) is not null then
                           (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.FULLTIMEFLAG = B.BASIC_CODE
                               AND B.CODE_TYPE = ''fulltimeflag''
                               AND B.COM_ID = 1)
                          else
                           a.fulltimeflag
                        end,
       A.CERTTYPE = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.CERTTYPE = B.BASIC_CODE
                               AND B.CODE_TYPE = ''certtype''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.CERTTYPE = B.BASIC_CODE
                           AND B.CODE_TYPE = ''certtype''
                           AND B.COM_ID = 1)
                      else
                       a.certtype
                    end,
       A.AGENTSIGNFLAG = case
                           when (SELECT B.TARGET_CODE
                                   FROM T_DEF_CODE_MAPPING B
                                  WHERE A.AGENTSIGNFLAG = B.BASIC_CODE
                                    AND B.CODE_TYPE = ''agentsignflag''
                                    AND B.COM_ID = 1) is not null then
                            (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.AGENTSIGNFLAG = B.BASIC_CODE
                                AND B.CODE_TYPE = ''agentsignflag''
                                AND B.COM_ID = 1)
                           else
                            a.agentsignflag
                         end,A.TRANSACTIONNO = (CASE
                            WHEN A.TRANSACTIONNO IN
                                 (SELECT C.CHGID
                                    FROM T_PRP_CHG_TRANS_ID_MAP C
                                 ) THEN
                             (SELECT Max(C.TRANSNO)
                                FROM  T_PRP_CHG_TRANS_ID_MAP C
                                 WHERE A.TRANSACTIONNO = C.CHGID
                             )
                            ELSE
                             A.TRANSACTIONNO
                          END)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10925;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10926 IS   V_ID NUMBER :=10926;  V_SQL_ID NUMBER :=10950;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :=' SELECT  
       PC.POLICY_CHG_ID AS TRANSACTIONNO,
       ''000031'' AS COMPANYCODE,
       PAR.Policy_Sales_ID AS AGENTCODE,
       P.POLICY_NO AS POLICYNO,
       P.BRANCH_CODE AS MANAGECOM,
       nvl(PAR.SALES_PERSON_NAME,''SLA_''||PAR.Policy_Sales_ID) AS NAME,
       '''' AS SEX,
       '''' AS BIRTHDATE,
       PAR.Policy_Sales_ID AS QUAFCERTNO,
       '''' AS CERTSTARTDATE,
       '''' AS CERTENDDATE,
       PAR.Policy_Sales_ID AS BUSIDEVCERTIFNO,
       ''Y'' AS OFFICEWORKFLAG,
       (case when par.AGENT_CODE is null then ''Y''
         else ''N'' end) AS AgentSignFlag,  
       '''' AS FULLTIMEFLAG,
       ''1'' AS SALESVCFLAG,
       '''' AS CERTTYPE,
       '''' AS CERTNO,
       '''' AS SALEJUDGE,
       P.OPERATOR_ID AS OPERATOR,
       to_date(to_char(P.INSERT_TIME,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MAKEDATE,
       TO_CHAR(P.INSERT_TIME, ''hh24:mi:ss'') AS MAKETIME,
       to_date(to_char(SYSDATE,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MODIFYDATE,
       TO_CHAR(SYSDATE, ''hh24:mi:ss'') AS MODIFYTIME
FROM ODS_STG.OFE_T_POLICY_CHANGE PC
LEFT JOIN ODS_STG.OFE_T_POLICY P ON P.RC_STATE = ''E'' AND P.POLICY_ID = PC.POLICY_ID
LEFT JOIN ODS_STG.OFE_T_POL_PLAN   PP 
     ON PP.RC_STATE = ''E''
     AND PP.POLICY_ID = P.POLICY_ID
     AND PP.POLICY_PLAN_ID = PP.MAIN_PLAN_ID
LEFT JOIN ODS_STG.OFE_T_PD_PRODUCT      PD
     ON PD.PD_PRODUCT_ID = PP.PD_PRODUCT_ID
LEFT JOIN ODS_STG.OFE_T_POL_AGENT_ROLE PAR 
     ON PAR.POLICY_ID = P.POLICY_ID 
     AND PAR.RC_STATE = ''E'' 
     AND PAR.AGENT_ROLE = ''2''
WHERE 1=1
 AND PD.BASIC_PRODUCT_FLAG = ''B''
 AND PD.COVERAGE_TERM_TYPE <> ''M''
 AND NOT EXISTS(SELECT 1 FROM ODS_STG.OFE_T_RLS_POLICY A WHERE TO_CHAR(A.PNO) = TO_CHAR(P.POLICY_NO) AND A.FLAG = ''1'') 
 AND PC.RC_STATE = ''E'' 
 AND PC.POLICY_ID = P.POLICY_ID 
 AND PC.POLICY_CHG_ID > 0
 AND P.POLICY_ID > 0
 AND PD.PD_PRODUCT_ID NOT IN (SELECT DISTINCT c.pd_product_id
                                from ODS_STG.OFE_t_Cfg_Plan_Print a,ODS_STG.OFE_t_pd_product_plan b,
                                ODS_STG.OFE_T_POL_PLAN c,ods_stg.OFE_T_PD_PRODUCT d
                                where a.pd_plan_id=b.pd_plan_id 
                                AND d.pd_product_id=c.pd_product_id
                                AND b.pd_product_id=c.pd_product_id 
                                AND a.is_show=0)--需屏蔽的险种
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
  AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn})
 AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10926;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10931 IS   V_ID NUMBER :=10931;  V_SQL_ID NUMBER :=10955;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCINSUREACC A
   SET A.COMPANYCODE = case
                         when (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.COMPANYCODE = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''companycode''
                                  AND B.COM_ID = 1) is not null then
                          (SELECT B.TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE A.COMPANYCODE = B.BASIC_CODE
                              AND B.CODE_TYPE = ''companycode''
                              AND B.COM_ID = 1)
                         else
                          a.companycode
                       end,
       A.ACCTYPE = case
                     when (SELECT B.TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE A.ACCTYPE = B.BASIC_CODE
                              AND B.CODE_TYPE = ''acctype''
                              AND B.COM_ID = 1) is not null then
                      (SELECT B.TARGET_CODE
                         FROM T_DEF_CODE_MAPPING B
                        WHERE A.ACCTYPE = B.BASIC_CODE
                          AND B.CODE_TYPE = ''acctype''
                          AND B.COM_ID = 1)
                     else
                      a.acctype
                   end,
       A.MANAGECOM = case
                       when (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.MANAGECOM = B.BASIC_CODE
                                AND B.CODE_TYPE = ''managecom''
                                AND B.COM_ID = 1) is not null then
                        (SELECT B.TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE A.MANAGECOM = B.BASIC_CODE
                            AND B.CODE_TYPE = ''managecom''
                            AND B.COM_ID = 1)
                       else
                        a.managecom
                     end,A.TRANSACTIONNO = (CASE
                            WHEN A.TRANSACTIONNO IN
                                 (SELECT C.CHGID
                                    FROM T_PRP_CHG_TRANS_ID_MAP C
                                 ) THEN
                             (SELECT Max(C.TRANSNO)
                                FROM  T_PRP_CHG_TRANS_ID_MAP C
                                 WHERE A.TRANSACTIONNO = C.CHGID
                             )
                            ELSE
                             A.TRANSACTIONNO
                          END)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10931;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12838 IS   V_ID NUMBER :=12838;  V_SQL_ID NUMBER :=12870;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='select tr.queryno AS QueryNo  from T_PRP_LCPOLTRANSACTION_return tr where  tr.stateflag in (''4'', ''4W'', ''5E'')   and tr.status in (''0000'', ''0001'')   and queryno is not null   and tr.batchno = ''#{batchNo}''   and exists (select ''X''          from T_PRP_lcpoltransaction t         where t.batchno = tr.batchno           and t.stateflag in (''4'', ''4W'', ''5E'')           and t.transtype = ''HIS'')'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12838;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10863 IS   V_ID NUMBER :=10863;  V_SQL_ID NUMBER :=10887;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='SELECT DISTINCT
       pc.POLICY_CHG_ID AS TransactionNo,
       ''000031'' AS CompanyCode,
       '''' AS GrpPolicyNo,
       p.Policy_No as PolicyNo,
       p.Application_ID as PrtNo,
       to_char(gets.cnd_id) as ActuGetNo,
       nvl(getsd.PREM_TYPE, ''99'') AS GetType,
       nvl(gets.cnd_method, ''99'') AS GetWay,
       ''156'' AS Currency,
       nvl(gets.AMOUNT, 0) AS SumActuGetMoney,
       gets.CND_FINISH_DATE AS EnterAccDate,
       gets.cnd_finish_date AS ConfDate,
       (case
         when (select max(bk.bank_branch_code)
                 from ods_stg.OFE_T_BK_ACC_MST bk
                where bk.policy_no = p.policy_no
                  and bk.rc_state = ''E'') is not null then
          (select max(bk.bank_code)
             from ods_stg.OFE_T_BK_ACC_MST bk
            where bk.policy_no = p.policy_no
              and bk.rc_state = ''E'') || ''-'' ||
          (select max(bk.bank_branch_code)
             from ods_stg.OFE_T_BK_ACC_MST bk
            where bk.policy_no = p.policy_no
              and bk.rc_state = ''E'')
         else
          (select max(bk.bank_code)
             from ods_stg.OFE_T_BK_ACC_MST bk
            where bk.policy_no = p.policy_no
              and bk.rc_state = ''E'')
       end) as BankCode,
       (case
         when (select max(bk.bank_branch_code)
                 from ods_stg.OFE_T_BK_ACC_MST bk
                where bk.policy_no = p.policy_no
                  and bk.rc_state = ''E'') is not null then
          (select max(t.bank_name)
             from ods_stg.OFE_T_BK_ACC_MST bk, ods_stg.OFE_T_CFG_BANK t
            where t.bank_code = bk.bank_code
              and bk.policy_no = p.policy_no) || ''-'' ||
          (select max(tb.bank_branch_name)
             from ods_stg.OFE_T_BK_ACC_MST      bk,
                  ods_stg.OFE_T_CFG_BANK_Branch tb
            where tb.bank_branch_code = bk.bank_branch_code
              and bk.policy_no = p.policy_no)
         else
          (select max(t.bank_name)
             from ods_stg.OFE_T_BK_ACC_MST bk, ods_stg.OFE_T_CFG_BANK t
            where t.bank_code = bk.bank_code
              and bk.policy_no = p.policy_no)
       end) as BankName,
       (select max(bk.bank_acc_no)
          from ods_stg.OFE_T_BK_ACC_MST bk
         where bk.policy_no = p.policy_no
           and bk.rc_state = ''E'') as BankAccNo,
       (select max(bk.bank_owner_name)
          from ods_stg.OFE_T_BK_ACC_MST bk
         where bk.policy_no = p.policy_no
           and bk.rc_state = ''E'') as AccName,
       (CASE WHEN PCM.CLIENT_ID_NO IS NULL THEN ''990'' ELSE PCM.CLIENT_ID_TYPE END)  as CertType,
       NVL(PCM.CLIENT_ID_NO,''99'') as CertNo,
       p.operator_id as operator,
       to_date(to_char(p.insert_time, ''yyyy-mm-dd''), ''yyyy-mm-dd'') as makedate,
       to_char(p.insert_time, ''hh:mm:ss'') as maketime,
       to_date(to_char(sysdate, ''yyyy-mm-dd''), ''yyyy-mm-dd'') as modifydate,
       to_char(sysdate, ''hh:mm:ss'') as modifytime
  from ods_stg.OFE_T_POLICY_CHANGE pc
  left join ODS_STG.OFE_T_POLICY P
    on pc.policy_id = p.policy_id
  LEFT JOIN ODS_STG.OFE_T_POL_PLAN PP
    ON PP.RC_STATE = ''E''
   AND PP.POLICY_ID = P.POLICY_ID
  LEFT JOIN ODS_STG.OFE_T_PD_PRODUCT PD
    ON PD.RC_STATE = ''E''
   AND PD.PD_PRODUCT_ID = PP.PD_PRODUCT_ID
RIGHT JOIN (SELECT cm.cnd_id,cm.business_type,
   (CASE WHEN cm.business_type = ''1'' 
              THEN business_no
         WHEN cm.business_type IN (''2'',''4'') 
              THEN (SELECT max(tp.policy_no) 
                     FROM ods_stg.OFE_T_POLICY tp,ods_stg.OFE_T_POLICY_CHANGE tpc
                     WHERE tpc.rc_state = ''E''
                     AND tp.rc_state = tpc.rc_state
                     AND tp.policy_id = tpc.policy_id
                     AND tpc.change_id = cm.business_no)
         WHEN cm.business_type = ''3''
              THEN (SELECT max(tp.policy_no) 
                 FROM ods_stg.OFE_T_POLICY tp, ods_stg.OFE_T_Claim_case tcc 
                 WHERE tp.rc_state = ''E''
                 AND tcc.rc_state = tp.rc_state
                 AND tcc.policy_id = tp.policy_id
                 AND tcc.case_id = cm.business_no  )
         ELSE business_no END) AS policy_no,TRAN_REF_ID,
       cm.amount, cm.cnd_type,cm.cnd_method,cm.retry_count,cm.cnd_request_time,
       cm.cnd_finish_date,cm.bk_acc_mst_id,cm.account_mapping_id,cm.status,cm.rc_state
FROM ods_stg.OFE_T_CND_MST cm) gets
ON gets.cnd_type = ''D'' AND gets.policy_no = p.policy_no
LEFT JOIN ods_stg.OFE_T_FEE_STREAM getsd ON getsd.rc_state = ''E'' 
     AND getsd.tran_reference_id = gets.CND_ID
     LEFT JOIN ODS_STG.OFE_T_POL_CLN_MST     PCM 
     ON PCM.RC_STATE = ''E''
     AND PCM.POLICY_ID = P.POLICY_ID
     AND PCM.CLIENT_ROLE = ''1''
WHERE 1=1
 AND gets.cnd_finish_date IS NOT NULL 
 AND gets.CND_FINISH_DATE IS NOT NULL
 AND PD.BASIC_PRODUCT_FLAG = ''B''
 AND PD.COVERAGE_TERM_TYPE <> ''M''
 AND NOT EXISTS (SELECT 1 FROM ODS_STG.OFE_T_RLS_POLICY A WHERE TO_CHAR(A.PNO) = TO_CHAR(P.POLICY_NO) AND A.FLAG = ''1'')
 and pc.item_id is not null
 and pc.rc_state = ''E''
 AND PC.POLICY_ID = P.POLICY_ID
 AND PC.POLICY_CHG_ID > 0
 AND P.POLICY_ID > 0
 AND gets.policy_no = p.policy_no
AND PD.PD_PRODUCT_ID NOT IN (SELECT DISTINCT c.pd_product_id
                                from ODS_STG.OFE_t_Cfg_Plan_Print a,ODS_STG.OFE_t_pd_product_plan b,
                                ODS_STG.OFE_T_POL_PLAN c,ods_stg.OFE_T_PD_PRODUCT d
                                where a.pd_plan_id=b.pd_plan_id 
                                AND d.pd_product_id=c.pd_product_id
                                AND b.pd_product_id=c.pd_product_id 
                                AND a.is_show=0)--需屏蔽的险种  
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn}) 
AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'') '; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10863;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12836 IS   V_ID NUMBER :=12836;  V_SQL_ID NUMBER :=12868;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='select ''PDL-Head'' as "PDL-Head",''PDL-Body'' as "PDL-Body" from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12836;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10775 IS   V_ID NUMBER :=10775;  V_SQL_ID NUMBER :=10799;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCPRODINSURELA A
   SET A.ManageCom = (CASE
                            WHEN A.ManageCom IN
                                 (SELECT BASIC_CODE
                                    FROM T_DEF_CODE_MAPPING
                                   WHERE CODE_TYPE = ''managecom''
                                   AND COM_ID = ''1'') THEN
                             (SELECT TARGET_CODE
                                FROM T_DEF_CODE_MAPPING B
                               WHERE B.CODE_TYPE = ''managecom''
                                 AND A.ManageCom = B.BASIC_CODE
                                 AND B.COM_ID = ''1'')
                            ELSE
                             A.ManageCom
                          END),
       A.TRANSACTIONNO = (CASE
                            WHEN A.TRANSACTIONNO IN
                                 (SELECT C.CHGID
                                    FROM T_PRP_CHG_TRANS_ID_MAP C
                                 ) THEN
                             (SELECT Max(C.TRANSNO)
                                FROM  T_PRP_CHG_TRANS_ID_MAP C
                                 WHERE A.TRANSACTIONNO = C.CHGID
                             )
                            ELSE
                             A.TRANSACTIONNO
                          END)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10775;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10933 IS   V_ID NUMBER :=10933;  V_SQL_ID NUMBER :=10957;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCINSURED A
   SET A.COMPANYCODE = CASE
                         WHEN (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                                WHERE A.COMPANYCODE = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''companycode''
                                  AND B.COM_ID = 1) IS NOT NULL THEN
                          (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                            WHERE A.COMPANYCODE = B.BASIC_CODE
                              AND B.CODE_TYPE = ''companycode''
                              AND B.COM_ID = 1)
                         ELSE
                          A.COMPANYCODE
                       END,
       
       A.MANAGECOM = CASE
                       WHEN (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                              WHERE A.MANAGECOM = B.BASIC_CODE
                                AND B.CODE_TYPE = ''managecom''
                                AND B.COM_ID = 1) IS NOT NULL THEN
                        (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                          WHERE A.MANAGECOM = B.BASIC_CODE
                            AND B.CODE_TYPE = ''managecom''
                            AND B.COM_ID = 1)
                       ELSE
                        A.MANAGECOM
                     END,
       
       A.RELATIONTOMAININSURED = CASE
                                   WHEN (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                                          WHERE A.RELATIONTOMAININSURED =
                                                B.BASIC_CODE
                                            AND B.CODE_TYPE =
                                                ''relationtoinsured''
                                            AND B.COM_ID = 1) IS NOT NULL THEN
                                    (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                                      WHERE A.RELATIONTOMAININSURED =
                                            B.BASIC_CODE
                                        AND B.CODE_TYPE = ''relationtoinsured''
                                        AND B.COM_ID = 1)
                                   ELSE
                                    A.RELATIONTOMAININSURED
                                 END,
       
       A.RELATIONTOAPPNT = CASE
                             WHEN (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                                    WHERE A.RELATIONTOAPPNT = B.BASIC_CODE
                                      AND B.CODE_TYPE = ''relationtoinsured''
                                      AND B.COM_ID = 1) IS NOT NULL THEN
                              (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                                WHERE A.RELATIONTOAPPNT = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''relationtoinsured''
                                  AND B.COM_ID = 1)
                             ELSE
                              A.RELATIONTOAPPNT
                           END,
       
       A.INSUREDSEX = CASE
                        WHEN (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                               WHERE A.INSUREDSEX = B.BASIC_CODE
                                 AND B.CODE_TYPE = ''sex''
                                 AND B.COM_ID = 1) IS NOT NULL THEN
                         (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                           WHERE A.INSUREDSEX = B.BASIC_CODE
                             AND B.CODE_TYPE = ''sex''
                             AND B.COM_ID = 1)
                        ELSE
                         A.INSUREDSEX
                      END,
       
       A.INSUREDCERTTYPE = CASE
                             WHEN (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                                    WHERE A.INSUREDCERTTYPE = B.BASIC_CODE
                                      AND B.CODE_TYPE = ''certtype''
                                      AND B.COM_ID = 1) IS NOT NULL THEN
                              (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                                WHERE A.INSUREDCERTTYPE = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''certtype''
                                  AND B.COM_ID = 1)
                             ELSE
                              A.INSUREDCERTTYPE
                           END,
       
       A.COUNTRY = CASE
                     WHEN
                     
                      (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                        WHERE A.COUNTRY = B.BASIC_CODE
                          AND B.CODE_TYPE = ''country''
                          AND B.COM_ID = 1) IS NOT NULL THEN
                      (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                        WHERE A.COUNTRY = B.BASIC_CODE
                          AND B.CODE_TYPE = ''country''
                          AND B.COM_ID = 1)
                     ELSE
                      A.COUNTRY
                   END,
       
       A.MARRIAGESTATUS = CASE
                            WHEN (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                                   WHERE A.MARRIAGESTATUS = B.BASIC_CODE
                                     AND B.CODE_TYPE = ''marriagestatus''
                                     AND B.COM_ID = 1) IS NOT NULL THEN
                             (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                               WHERE A.MARRIAGESTATUS = B.BASIC_CODE
                                 AND B.CODE_TYPE = ''marriagestatus''
                                 AND B.COM_ID = 1)
                            ELSE
                             A.MARRIAGESTATUS
                          END,
       
     
       A.EDUCATELEVEL = CASE
                          WHEN (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                                 WHERE A.EDUCATELEVEL = B.BASIC_CODE
                                   AND B.CODE_TYPE = ''educatelevel''
                                   AND B.COM_ID = 1) IS NOT NULL THEN
                           (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                             WHERE A.EDUCATELEVEL = B.BASIC_CODE
                               AND B.CODE_TYPE = ''educatelevel''
                               AND B.COM_ID = 1)
                          ELSE
                           A.EDUCATELEVEL
                        END,
       
       A.POSITION = CASE
                      WHEN (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                             WHERE A.POSITION = B.BASIC_CODE
                               AND B.CODE_TYPE = ''occupationtype''
                               AND B.COM_ID = 1) IS NOT NULL THEN
                       (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                         WHERE A.POSITION = B.BASIC_CODE
                           AND B.CODE_TYPE = ''occupationtype''
                           AND B.COM_ID = 1)
                      ELSE
                       A.POSITION
                    END,
       
       A.SMOKEFLAG = CASE
                       WHEN (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                              WHERE A.SMOKEFLAG = B.BASIC_CODE
                                AND B.CODE_TYPE = ''smokeflag''
                                AND B.COM_ID = 1) IS NOT NULL THEN
                        (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                          WHERE A.SMOKEFLAG = B.BASIC_CODE
                            AND B.CODE_TYPE = ''smokeflag''
                            AND B.COM_ID = 1)
                       ELSE
                        A.SMOKEFLAG
                     END,
            
       A.LICENSETYPE = CASE
                         WHEN (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                                WHERE A.LICENSETYPE = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''licensetype''
                                  AND B.COM_ID = 1) IS NOT NULL THEN
                          (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                            WHERE A.LICENSETYPE = B.BASIC_CODE
                              AND B.CODE_TYPE = ''licensetype''
                              AND B.COM_ID = 1)
                         ELSE
                          A.LICENSETYPE
                       END,
       
       A.SOCIALINSUFLAG = CASE
                            WHEN (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                                   WHERE A.SOCIALINSUFLAG= B.BASIC_CODE
                                     AND B.CODE_TYPE = ''socialinsuflag''
                                     AND B.COM_ID = 1) IS NOT NULL THEN
                             (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                               WHERE A.SOCIALINSUFLAG= B.BASIC_CODE
                                 AND B.CODE_TYPE = ''socialinsuflag''
                                 AND B.COM_ID = 1)
                            ELSE
                             A.SOCIALINSUFLAG
                          END,
       
       A.NATIONALITY = CASE
                         WHEN (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                                WHERE A.NATIONALITY = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''nationality''
                                  AND B.COM_ID = 1) IS NOT NULL THEN
                          (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                            WHERE A.NATIONALITY = B.BASIC_CODE
                              AND B.CODE_TYPE = ''nationality''
                              AND B.COM_ID = 1)
                         ELSE
                          A.NATIONALITY
                       END,
       
       A.HEALTHCONDITION = CASE
                             WHEN (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                                    WHERE A.HEALTHCONDITION = B.BASIC_CODE
                                      AND B.CODE_TYPE = ''healthcondition''
                                      AND B.COM_ID = 1) IS NOT NULL THEN
                              (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.HEALTHCONDITION = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''healthcondition''
                                  AND B.COM_ID = 1)
                             ELSE
                              A.HEALTHCONDITION
                           END,
       
       A.RESIDENTTYPE = CASE
                          WHEN (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                                 WHERE A.RESIDENTTYPE = B.BASIC_CODE
                                   AND B.CODE_TYPE = ''residenttype''
                                   AND B.COM_ID = 1) IS NOT NULL THEN
                           (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                             WHERE A.RESIDENTTYPE = B.BASIC_CODE
                               AND B.CODE_TYPE = ''residenttype''
                               AND B.COM_ID = 1)
                          ELSE
                           A.RESIDENTTYPE
                        END,
       A.TRANSACTIONNO = (CASE
                           WHEN A.TRANSACTIONNO IN
                                (SELECT C.CHGID FROM T_PRP_CHG_TRANS_ID_MAP C) THEN
                            (SELECT MAX(C.TRANSNO)
                               FROM T_PRP_CHG_TRANS_ID_MAP C
                              WHERE A.TRANSACTIONNO = C.CHGID)
                           ELSE
                            A.TRANSACTIONNO
                         END),
       A.OCCUPATIONTYPE = CASE
                            WHEN (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                                   WHERE A.OCCUPATIONTYPE = B.BASIC_CODE
                                     AND B.CODE_TYPE = ''occupationtype''
                                     AND B.COM_ID = 1) IS NOT NULL THEN
                             (SELECT B.TARGET_CODE FROM T_DEF_CODE_MAPPING B
                               WHERE A.OCCUPATIONTYPE = B.BASIC_CODE
                                 AND B.CODE_TYPE = ''occupationtype''
                                 AND B.COM_ID = 1)
                            ELSE
                             A.OCCUPATIONTYPE
                          END
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10933;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10867 IS   V_ID NUMBER :=10867;  V_SQL_ID NUMBER :=10891;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LJAGET A
    SET A.GETTYPE = (CASE
                      WHEN A.GETTYPE IN (SELECT BASIC_CODE
                                           FROM T_DEF_CODE_MAPPING
                                          WHERE CODE_TYPE = ''gettype''
                                            AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''gettype''
                           AND A.GETTYPE = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.GETTYPE
                    END),
        A.GETWAY = (CASE
                     WHEN A.GETWAY IN (SELECT BASIC_CODE
                                         FROM T_DEF_CODE_MAPPING
                                        WHERE CODE_TYPE = ''getway''
                                          AND COM_ID = ''1'') THEN
                      (SELECT TARGET_CODE
                         FROM T_DEF_CODE_MAPPING B
                        WHERE B.CODE_TYPE = ''getway''
                          AND A.GETWAY = B.BASIC_CODE
                          AND B.COM_ID = ''1'')
                     ELSE
                      A.GETWAY
                   END),
        A.CURRENCY = (CASE
                       WHEN A.CURRENCY IN (SELECT BASIC_CODE
                                             FROM T_DEF_CODE_MAPPING
                                            WHERE CODE_TYPE = ''currency''
                                              AND COM_ID = ''1'') THEN
                        (SELECT TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE B.CODE_TYPE = ''currency''
                            AND A.CURRENCY = B.BASIC_CODE
                            AND B.COM_ID = ''1'')
                       ELSE
                        A.CURRENCY
                     END),
        A.CERTTYPE = (CASE
                       WHEN A.CERTTYPE IN (SELECT BASIC_CODE
                                             FROM T_DEF_CODE_MAPPING
                                            WHERE CODE_TYPE = ''certtype''
                                              AND COM_ID = ''1'') THEN
                        (SELECT TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE B.CODE_TYPE = ''certtype''
                            AND A.CERTTYPE = B.BASIC_CODE
                            AND B.COM_ID = ''1'')
                       ELSE
                        A.CERTTYPE
                     END),
       A.TRANSACTIONNO = (CASE
                            WHEN A.TRANSACTIONNO IN
                                 (SELECT C.CHGID
                                    FROM T_PRP_CHG_TRANS_ID_MAP C
                                 ) THEN
                             (SELECT Max(C.TRANSNO)
                                FROM  T_PRP_CHG_TRANS_ID_MAP C
                                 WHERE A.TRANSACTIONNO = C.CHGID
                             )
                            ELSE
                             A.TRANSACTIONNO
                          END)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10867;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12448 IS   V_ID NUMBER :=12448;  V_SQL_ID NUMBER :=12448;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE  FROM T_PRP_LCProdInsuRela where transactionno in (select transactionno from T_PRP_LCPolTransaction where transdate between to_date(''#{startDate}'', ''yyyy-mm-dd'') and
       to_date(''#{endDate}'', ''yyyy-mm-dd''))
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12448;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12433 IS   V_ID NUMBER :=12433;  V_SQL_ID NUMBER :=12433;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='
--保全付费（非定结）
select ''G''||substr(hj1.actugetno,12)||substr(h2.contno,11)||''04'' TransactionNo,
        (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       hc.prtno PrtNo,
       hj1.actugetno ActuGetNo,
       (case
           when hj1.othernotype = ''2'' and hj1.tempfeetype = ''4'' then
            ''04''
           when hj1.othernotype = ''4'' and hj1.tempfeetype = ''4'' then
            ''01''
           when hj1.othernotype = ''5'' and hj1.tempfeetype = ''4'' then
            ''12''
           when hj1.othernotype = ''6'' and hj1.tempfeetype = ''4'' then
            ''04''
           else
            ''99''
         end) GetType,
       ''20'' GetWay,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''currency'' and ORIGINCODE=h.currency ) Currency，
       hj1.sumgetmoney SumActuGetMoney,
       hj1.enteraccdate EnterAccDate,
       hj1.confdate ConfDate,
       hj1.bankcode BankCode,
       (select bankname from ODS_STG.HNW_ldbank where bankcode=hj1.bankcode) BankName,
       hj1.bankaccno BankAccNo,
       hj1.accname AccName,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) CertType,
       hc.idno CertNo,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate

from ODS_STG.HNW_hjaget hj1
inner join (select endorno, grpcontno, contno,feefinatype as feefinatype,sum(getmoney) as sumactupaymoney
  from ODS_STG.HNW_hejsgetendorse 
 group by endorno, grpcontno, contno,feefinatype) h2 on hj1.otherno = h2.endorno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
left join ODS_STG.HNW_hcgrpcont h on h.grpcontno=h2.grpcontno 
where 1=1 and (hj1.othernotype = ''2'' and hj1.tempfeetype = ''4'') and hj1.conttype=''1'' 
and hj1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12433;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12457 IS   V_ID NUMBER :=12457;  V_SQL_ID NUMBER :=12457;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE  FROM T_PRP_LJAGet where transactionno in (select transactionno from T_PRP_LCPolTransaction where transdate between to_date(''#{startDate}'', ''yyyy-mm-dd'') and to_date(''#{endDate}'', ''yyyy-mm-dd''))
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12457;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12459 IS   V_ID NUMBER :=12459;  V_SQL_ID NUMBER :=12459;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE  FROM T_PRP_LCPolTransaction where transdate  between to_date(''#{startDate}'', ''yyyy-mm-dd'') and
       to_date(''#{endDate}'', ''yyyy-mm-dd'')
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12459;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12465 IS   V_ID NUMBER :=12465;  V_SQL_ID NUMBER :=12465;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='--新单(承保)
select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''01'' TransactionNo,
      (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       ''02''  BussType,
       h2.sumactupaymoney TransAmnt,
       h1.enteraccdate TransDate,
       hc.bankcode BankCode,
      (select bankname from ODS_STG.HNW_ldbank where bankcode=hc.bankcode) BankName,
       hc.bankaccno BankAccNo,
       hc.accname AccName,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) CertType,
       hc.idno CertNo,
       ''1'' STATEFLAG,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
where 1=1 and (h1.othernotype=''1'' and h1.tempfeetype=''8'') and  h1.conttype=''1'' 
     and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
                    
union all
--新单（续期）

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''02'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       ''03''  BussType,
       h2.sumactupaymoney TransAmnt,
       h1.enteraccdate TransDate,
       hc.bankcode BankCode,
       (select bankname from ODS_STG.HNW_ldbank where bankcode=hc.bankcode) BankName,
       hc.bankaccno BankAccNo,
       hc.accname AccName,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) CertType,
       hc.idno CertNo,
       ''1'' STATEFLAG,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
where 1=1 and (h1.othernotype in (''1'', ''2'') and h1.tempfeetype=''9'') and h1.conttype=''1''  
      and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
         
         
union all

--保全收费(非定结)

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''03'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       case when h2.feefinatype=''NI'' then ''24'' else case when h2.feefinatype=''ZT'' then ''25'' else 
        case when h2.feefinatype=''IC'' then ''18'' else case when h2.feefinatype=''CT'' then ''31'' else '''' end  end end  end  BussType,
       h2.sumactupaymoney TransAmnt,
       h1.enteraccdate TransDate,
       hc.bankcode BankCode,
       (select bankname from ODS_STG.HNW_ldbank where bankcode=hc.bankcode) BankName,
       hc.bankaccno BankAccNo,
       hc.accname AccName,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) CertType,
       hc.idno CertNo,
       ''1'' STATEFLAG,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
from ODS_STG.HNW_hjapay h1
inner join (select endorno, grpcontno, contno,feefinatype as feefinatype,sum(getmoney) as sumactupaymoney
  from ODS_STG.HNW_hejsgetendorse
 group by endorno, grpcontno, contno,feefinatype) h2 on h1.otherno=h2.endorno
left join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
where (h1.othernotype = ''2'' and h1.incometype = ''0'')  and h1.conttype=''1'' 
      and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

union all 
--保全付费（非定结）

select ''G''||substr(hj1.actugetno,12)||substr(h2.contno,11)||''04'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       case when h2.feefinatype=''NI'' then ''24'' else case when h2.feefinatype=''ZT'' then ''25'' else 
        case when h2.feefinatype=''IC'' then ''18'' else case when h2.feefinatype=''CT'' then ''31'' else '''' end  end end  end  BussType,
       h2.sumactupaymoney  TransAmnt,
       hj1.enteraccdate TransDate,
       hc.bankcode BankCode,
       (select bankname from ODS_STG.HNW_ldbank where bankcode=hc.bankcode) BankName,
       hc.bankaccno BankAccNo,
       hc.accname AccName,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) CertType,
       hc.idno CertNo,
       ''1'' STATEFLAG,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate

from ODS_STG.HNW_hjaget hj1
inner join (select endorno, grpcontno, contno,feefinatype as feefinatype,sum(getmoney) as sumactupaymoney
  from ODS_STG.HNW_hejsgetendorse 
 group by endorno, grpcontno, contno,feefinatype) h2 on hj1.otherno = h2.endorno
left join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
where 1=1 and (hj1.othernotype = ''2'' and hj1.tempfeetype = ''4'') and hj1.conttype=''1'' 
and hj1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

union all

--理赔
select  ''L''||substr(hl.clmno,2)||substr(hc.contno,11)||''05'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hl.comcode) CompanyCode,
       '''' GrpPolicyNo,
       hc.contno PolicyNo,
       ''15'' BussType,
       hl.clmamt * -1 TransAmnt,
       hl.endcasedate TransDate,
       hl.bankcode BankCode,
       hl.bankname BankName,
       hl.bankaccno BankAccNo,
       hl.bankaccname AccName,
        (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) CertType,
       hc.idno CertNo,
       ''1'' STATEFLAG,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
  from ODS_STG.HNW_hlclaim hl
  inner join ODS_STG.HNW_hcinsured hc
    on hl.segment1 = hc.contno

 where 1 = 1  and hl.conttype=''1''  and hl.endcasedate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
 
 

'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12465;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12466 IS   V_ID NUMBER :=12466;  V_SQL_ID NUMBER :=12466;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCPOLTRANSACTION A
   SET A.COMPANYCODE = case
                         when (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.COMPANYCODE = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''companycode''
                                  AND B.COM_ID = 1) is not null then
                          (SELECT B.TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE A.COMPANYCODE = B.BASIC_CODE
                              AND B.CODE_TYPE = ''companycode''
                              AND B.COM_ID = 1)
                         else
                          a.companycode
                       end,
       
       A.BUSSTYPE = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.BUSSTYPE = B.BASIC_CODE
                               AND B.CODE_TYPE = ''busstype''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.BUSSTYPE = B.BASIC_CODE
                           AND B.CODE_TYPE = ''busstype''
                           AND B.COM_ID = 1)
                      else
                       a.busstype
                    end,
       
       A.CERTTYPE = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.CERTTYPE = B.BASIC_CODE
                               AND B.CODE_TYPE = ''certtype''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.CERTTYPE = B.BASIC_CODE
                           AND B.CODE_TYPE = ''certtype''
                           AND B.COM_ID = 1)
                      else
                       a.certtype
                    end,
       A.BANKCODE = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.BANKCODE = B.BASIC_CODE
                               AND B.CODE_TYPE = ''bankcode''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.BANKCODE = B.BASIC_CODE
                           AND B.CODE_TYPE = ''bankcode''
                           AND B.COM_ID = 1)
                      else
                       a.bankcode
                    end
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12466;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12467 IS   V_ID NUMBER :=12467;  V_SQL_ID NUMBER :=12467;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='
--新单(承保)

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''01'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=h2.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       hc.insuredno InsuredNo,
       '''' CustomerNo,
       h1.managecom ManageCom,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hrelation'' and ORIGINCODE=hc.relationtomaininsured) RelationToMainInsured,
       hc.maininsuredno MainInsuredNo,
       nvl((select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hrelation'' and ORIGINCODE=hc.relationtoappnt),''98'') RelationToAppnt,
       hc.insuredsurname InsuredName,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=hc.sex) InsuredSex,
       hc.birthday InsuredBirthDate,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) InsuredCertType,
       hc.idno InsuredCertNo,
       trunc(months_between(hc.cvalidate,hc.birthday)/12)  AppAge,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''nationality'' and ORIGINCODE=hc.nationality) Country,
       '''' Nationality,
       hc.rgtaddress RgtAddress,
       hc.marriage MarriageStatus,
       hc.marriagedate MarriageDate,
       hc.health HealthCondition,
       hc.stature Height,
       hc.avoirdupois Weight,
       hc.degree EducateLevel ,
       hc.startworkdate StartWorkDate,
       hc.position Position,
       hc.salary Salary,
       nvl(hc.occupationcode,''001001'') OccupationType,
       '''' Occupation,
       hc.pluralitytype PartTimeOccupationType,
       '''' PartTimeOccupation,
       hc.smokeflag SmokeFlag,
       hc.license License,
       hc.licensetype LicenseType,
       '''' SocialInsuNo,
       '''' SocialInsuFlag,
       '''' ResidentType,
       case when hc.relationtomaininsured =''00'' then ''01'' else ''02'' end InsuredType,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
where 1=1 and (h1.othernotype=''1'' and h1.tempfeetype=''8'') and  h1.conttype=''1'' 
          and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

union all
--新单（续期）

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''02'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=h2.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       hc.insuredno InsuredNo,
       '''' CustomerNo,
       h1.managecom ManageCom,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hrelation'' and ORIGINCODE=hc.relationtomaininsured) RelationToMainInsured,
       hc.maininsuredno MainInsuredNo,
       nvl((select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hrelation'' and ORIGINCODE=hc.relationtoappnt),''98'') RelationToAppnt,
       hc.insuredsurname InsuredName,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=hc.sex) InsuredSex,
       hc.birthday InsuredSex,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) InsuredCertType,
       hc.idno InsuredCertNo,
       trunc(months_between(hc.cvalidate,hc.birthday)/12)  AppAge,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''nationality'' and ORIGINCODE=hc.nationality)  Country,
       '''' Nationality,
       hc.rgtaddress RgtAddress,
       hc.marriage MarriageStatus,
       hc.marriagedate MarriageDate,
       hc.health HealthCondition,
       hc.stature Height,
       hc.avoirdupois Weight,
       hc.degree EducateLevel ,
       hc.startworkdate StartWorkDate,
       hc.position Position,
       hc.salary Salary,
       nvl(hc.occupationcode,''001001'') OccupationType,
       '''' Occupation,
       hc.pluralitytype PartTimeOccupationType,
       '''' PartTimeOccupation,
       hc.smokeflag SmokeFlag,
       hc.license License,
       hc.licensetype LicenseType,
       '''' SocialInsuNo,
       '''' SocialInsuFlag,
       '''' ResidentType,
       case when hc.relationtomaininsured =''00'' then ''01'' else ''02'' end InsuredType,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
where 1=1 and (h1.othernotype in (''1'', ''2'') and h1.tempfeetype=''9'') and h1.conttype=''1''  
          and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

union all

--保全收费(非定结)

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''03'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       hc.insuredno InsuredNo,
       '''' CustomerNo,
       h1.managecom ManageCom,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hrelation'' and ORIGINCODE=hc.relationtomaininsured) RelationToMainInsured,
       hc.maininsuredno MainInsuredNo,
       nvl((select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hrelation'' and ORIGINCODE=hc.relationtoappnt),''98'') RelationToAppnt,
       hc.insuredsurname InsuredName,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=hc.sex) InsuredSex,
       hc.birthday InsuredSex,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) InsuredCertType,
       hc.idno InsuredCertNo,
       trunc(months_between(hc.cvalidate,hc.birthday)/12)  AppAge,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''nationality'' and ORIGINCODE=hc.nationality)  Country,
       '''' Nationality,
       hc.rgtaddress RgtAddress,
       hc.marriage MarriageStatus,
       hc.marriagedate MarriageDate,
       hc.health HealthCondition,
       hc.stature Height,
       hc.avoirdupois Weight,
       hc.degree EducateLevel ,
       hc.startworkdate StartWorkDate,
       hc.position Position,
       hc.salary Salary,
       nvl(hc.occupationcode,''001001'') OccupationType,
       '''' Occupation,
       hc.pluralitytype PartTimeOccupationType,
       '''' PartTimeOccupation,
       hc.smokeflag SmokeFlag,
       hc.license License,
       hc.licensetype LicenseType,
       '''' SocialInsuNo,
       '''' SocialInsuFlag,
       '''' ResidentType,
       case when hc.relationtomaininsured =''00'' then ''01'' else ''02'' end InsuredType,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate

from ODS_STG.HNW_hjapay h1
inner join (select endorno, grpcontno, contno,feefinatype as feefinatype,sum(getmoney) as sumactupaymoney
  from ODS_STG.HNW_hejsgetendorse
 group by endorno, grpcontno, contno,feefinatype) h2 on h1.otherno=h2.endorno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
left join ODS_STG.HNW_hpedoritem hp1 on h1.otherno=hp1.edorappno and h2.contno=hp1.contno
where (h1.othernotype = ''2'' and h1.incometype = ''0'')  and h1.conttype=''1'' 
               and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

union all
--保全付费（非定结）

select ''G''||substr(hj1.actugetno,12)||substr(h2.contno,11)||''04'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       hc.insuredno InsuredNo,
       '''' CustomerNo,
       hj1.managecom ManageCom,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hrelation'' and ORIGINCODE=hc.relationtomaininsured) RelationToMainInsured,
       hc.maininsuredno MainInsuredNo,
       nvl((select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hrelation'' and ORIGINCODE=hc.relationtoappnt),''98'') RelationToAppnt,
       hc.insuredsurname InsuredName,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=hc.sex) InsuredSex,
       hc.birthday InsuredSex,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) InsuredCertType,
       hc.idno InsuredCertNo,
       trunc(months_between(hc.cvalidate,hc.birthday)/12)  AppAge,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''nationality'' and ORIGINCODE=hc.nationality)  Country,
       '''' Nationality,
       hc.rgtaddress RgtAddress,
       hc.marriage MarriageStatus,
       hc.marriagedate MarriageDate,
       hc.health HealthCondition,
       hc.stature Height,
       hc.avoirdupois Weight,
       hc.degree EducateLevel ,
       hc.startworkdate StartWorkDate,
       hc.position Position,
       hc.salary Salary,
       nvl(hc.occupationcode,''001001'') OccupationType,
       '''' Occupation,
       hc.pluralitytype PartTimeOccupationType,
       '''' PartTimeOccupation,
       hc.smokeflag SmokeFlag,
       hc.license License,
       hc.licensetype LicenseType,
       '''' SocialInsuNo,
       '''' SocialInsuFlag,
       '''' ResidentType,
       case when hc.relationtomaininsured =''00'' then ''01'' else ''02'' end InsuredType,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate

from ODS_STG.HNW_hjaget hj1
inner join (select endorno, grpcontno, contno,feefinatype as feefinatype,sum(getmoney) as sumactupaymoney
  from ODS_STG.HNW_hejsgetendorse 
 group by endorno, grpcontno, contno,feefinatype) h2 on hj1.otherno = h2.endorno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
left join ODS_STG.HNW_hpedoritem hp1 on hj1.otherno=hp1.edorappno and h2.contno=hp1.contno

where 1=1 and (hj1.othernotype = ''2'' and hj1.tempfeetype = ''4'') and hj1.conttype=''1'' 
          and hj1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12467;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12468 IS   V_ID NUMBER :=12468;  V_SQL_ID NUMBER :=12468;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCINSURED A
   SET A.COMPANYCODE = case
                         when (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.COMPANYCODE = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''companycode''
                                  AND B.COM_ID = 1) is not null then
                          (SELECT B.TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE A.COMPANYCODE = B.BASIC_CODE
                              AND B.CODE_TYPE = ''companycode''
                              AND B.COM_ID = 1)
                         else
                          a.companycode
                       end,
       
       A.MANAGECOM = case
                       when (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.MANAGECOM = B.BASIC_CODE
                                AND B.CODE_TYPE = ''managecom''
                                AND B.COM_ID = 1) is not null then
                        (SELECT B.TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE A.MANAGECOM = B.BASIC_CODE
                            AND B.CODE_TYPE = ''managecom''
                            AND B.COM_ID = 1)
                       else
                        a.managecom
                     end,
       
       A.RELATIONTOMAININSURED = case
                                   when (SELECT B.TARGET_CODE
                                           FROM T_DEF_CODE_MAPPING B
                                          WHERE A.RELATIONTOMAININSURED =
                                                B.BASIC_CODE
                                            AND B.CODE_TYPE =
                                                ''relationtoinsured''
                                            AND B.COM_ID = 1) is not null then
                                    (SELECT B.TARGET_CODE
                                       FROM T_DEF_CODE_MAPPING B
                                      WHERE A.RELATIONTOMAININSURED =
                                            B.BASIC_CODE
                                        AND B.CODE_TYPE = ''relationtoinsured''
                                        AND B.COM_ID = 1)
                                   else
                                    a.relationtomaininsured
                                 end,
       
       A.RELATIONTOAPPNT = case
                             when (SELECT B.TARGET_CODE
                                     FROM T_DEF_CODE_MAPPING B
                                    WHERE A.RELATIONTOAPPNT = B.BASIC_CODE
                                      AND B.CODE_TYPE = ''relationtoappnt''
                                      AND B.COM_ID = 1) is not null then
                              (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.RELATIONTOAPPNT = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''relationtoappnt''
                                  AND B.COM_ID = 1)
                             else
                              a.relationtoappnt
                           end,
       
       A.INSUREDSEX = case
                        when (SELECT B.TARGET_CODE
                                FROM T_DEF_CODE_MAPPING B
                               WHERE A.INSUREDSEX = B.BASIC_CODE
                                 AND B.CODE_TYPE = ''sex''
                                 AND B.COM_ID = 1) is not null then
                         (SELECT B.TARGET_CODE
                            FROM T_DEF_CODE_MAPPING B
                           WHERE A.INSUREDSEX = B.BASIC_CODE
                             AND B.CODE_TYPE = ''sex''
                             AND B.COM_ID = 1)
                        else
                         a.insuredsex
                      end,
       
       A.INSUREDCERTTYPE = case
                             when (SELECT B.TARGET_CODE
                                     FROM T_DEF_CODE_MAPPING B
                                    WHERE A.INSUREDCERTTYPE = B.BASIC_CODE
                                      AND B.CODE_TYPE = ''certtype''
                                      AND B.COM_ID = 1) is not null then
                              (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.INSUREDCERTTYPE = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''certtype''
                                  AND B.COM_ID = 1)
                             else
                              a.insuredcerttype
                           end,
       
       A.COUNTRY = case
                     when
                     
                      (SELECT B.TARGET_CODE
                         FROM T_DEF_CODE_MAPPING B
                        WHERE A.COUNTRY = B.BASIC_CODE
                          AND B.CODE_TYPE = ''country''
                          AND B.COM_ID = 1) is not null then
                      (SELECT B.TARGET_CODE
                         FROM T_DEF_CODE_MAPPING B
                        WHERE A.COUNTRY = B.BASIC_CODE
                          AND B.CODE_TYPE = ''country''
                          AND B.COM_ID = 1)
                     else
                      a.country
                   end,
       
       A.MARRIAGESTATUS = case
                            when (SELECT B.TARGET_CODE
                                    FROM T_DEF_CODE_MAPPING B
                                   WHERE A.MARRIAGESTATUS = B.BASIC_CODE
                                     AND B.CODE_TYPE = ''marriagestatus''
                                     AND B.COM_ID = 1) is not null then
                             (SELECT B.TARGET_CODE
                                FROM T_DEF_CODE_MAPPING B
                               WHERE A.MARRIAGESTATUS = B.BASIC_CODE
                                 AND B.CODE_TYPE = ''marriagestatus''
                                 AND B.COM_ID = 1)
                            else
                             a.marriagestatus
                          end,
       
       --受教育，未找到,学历代码
       A.EDUCATELEVEL = case
                            when (SELECT B.TARGET_CODE
                                    FROM T_DEF_CODE_MAPPING B
                                   WHERE A.EDUCATELEVEL = B.BASIC_CODE
                                     AND B.CODE_TYPE = ''educatelevel''
                                     AND B.COM_ID = 1) is not null then
                             (SELECT B.TARGET_CODE
                                FROM T_DEF_CODE_MAPPING B
                               WHERE A.EDUCATELEVEL = B.BASIC_CODE
                                 AND B.CODE_TYPE = ''educatelevel''
                                 AND B.COM_ID = 1)
                            else
                             a.EDUCATELEVEL
                          end,
       
       A.POSITION = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.POSITION = B.BASIC_CODE
                               AND B.CODE_TYPE = ''occupationtype''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.POSITION = B.BASIC_CODE
                           AND B.CODE_TYPE = ''occupationtype''
                           AND B.COM_ID = 1)
                      else
                       a.position
                    end,
       
       A.SMOKEFLAG = case
                       when (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.SMOKEFLAG = B.BASIC_CODE
                                AND B.CODE_TYPE = ''smokeflag''
                                AND B.COM_ID = 1) is not null then
                        (SELECT B.TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE A.SMOKEFLAG = B.BASIC_CODE
                            AND B.CODE_TYPE = ''smokeflag''
                            AND B.COM_ID = 1)
                       else
                        a.smokeflag
                     end,
       --码表code_type字段没有licensetype       
       a.LICENSETYPE = case
                         when (select b.target_code
                                 from T_DEF_CODE_MAPPING b
                                where a.LICENSETYPE = b.basic_code
                                  and b.code_type = ''licensetype''
                                  and b.com_id = 1) is not null then
                          (select b.target_code
                             from T_DEF_CODE_MAPPING b
                            where a.LICENSETYPE = b.basic_code
                              and b.code_type = ''licensetype''
                              and b.com_id = 1)
                         else
                          a.licensetype
                       end,
       
       A.SOCIALINSUFLAG = case
                            when (SELECT B.TARGET_CODE
                                    FROM T_DEF_CODE_MAPPING B
                                   WHERE A.SMOKEFLAG = B.BASIC_CODE
                                     AND B.CODE_TYPE = ''socialinsuflag''
                                     AND B.COM_ID = 1) is not null then
                             (SELECT B.TARGET_CODE
                                FROM T_DEF_CODE_MAPPING B
                               WHERE A.SMOKEFLAG = B.BASIC_CODE
                                 AND B.CODE_TYPE = ''socialinsuflag''
                                 AND B.COM_ID = 1)
                            else
                             a.socialinsuflag
                          end,
       
       A.NATIONALITY = case
                         when (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.NATIONALITY = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''nationality''
                                  AND B.COM_ID = 1) is not null then
                          (SELECT B.TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE A.NATIONALITY = B.BASIC_CODE
                              AND B.CODE_TYPE = ''nationality''
                              AND B.COM_ID = 1)
                         else
                          a.nationality
                       end,
       
       A.HEALTHCONDITION = case
                             when (SELECT B.TARGET_CODE
                                     FROM T_DEF_CODE_MAPPING B
                                    WHERE A.HEALTHCONDITION = B.BASIC_CODE
                                      AND B.CODE_TYPE = ''healthcondition''
                                      AND B.COM_ID = 1) is not null then
                              (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.HEALTHCONDITION = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''healthcondition''
                                  AND B.COM_ID = 1)
                             else
                              a.healthcondition
                           end,
       
       A.RESIDENTTYPE = case
                          when (SELECT B.TARGET_CODE
                                  FROM T_DEF_CODE_MAPPING B
                                 WHERE A.RESIDENTTYPE = B.BASIC_CODE
                                   AND B.CODE_TYPE = ''residenttype''
                                   AND B.COM_ID = 1) is not null then
                           (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.RESIDENTTYPE = B.BASIC_CODE
                               AND B.CODE_TYPE = ''residenttype''
                               AND B.COM_ID = 1)
                          else
                           a.residenttype
                        end'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12468;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12516 IS   V_ID NUMBER :=12516;  V_SQL_ID NUMBER :=12535;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='  DELETE FROM  T_PRP_LCInsured T WHERE NOT EXISTS (SELECT ''x'' FROM T_PRP_LCCont TT WHERE T.TRANSACTIONNO = TT.TRANSACTIONNO AND TT.Policyno = T.policyNo)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12516;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12517 IS   V_ID NUMBER :=12517;  V_SQL_ID NUMBER :=12536;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='  DELETE FROM  T_PRP_LCProdInsuRela T WHERE T.insuredno NOT IN (SELECT DISTINCT TT.insuredno FROM T_PRP_LCInsured TT)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12517;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12519 IS   V_ID NUMBER :=12519;  V_SQL_ID NUMBER :=12538;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='  DELETE FROM  T_PRP_LCProdInsuRela T WHERE NOT EXISTS (SELECT ''x'' FROM T_PRP_LCCont TT WHERE T.TRANSACTIONNO = TT.TRANSACTIONNO AND TT.Policyno = T.policyNo)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12519;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12521 IS   V_ID NUMBER :=12521;  V_SQL_ID NUMBER :=12540;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE FROM  T_PRP_LJAPay T WHERE NOT EXISTS (SELECT ''x'' FROM T_PRP_LCPolTransaction TT WHERE T.TRANSACTIONNO = TT.TRANSACTIONNO AND TT.Policyno = T.policyNo)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12521;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12772 IS   V_ID NUMBER :=12772;  V_SQL_ID NUMBER :=12804;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCProduct'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MIN'' AS CheckType,       NVL((SELECT MIN(a.TRANSACTIONNO)          FROM T_PRP_LCProduct a,t_Prp_Lcpoltransaction b          WHERE b.batchno = ''#{batchNo}''         AND a.transactionno = b.transactionno         AND b.STATEFLAG = ''5''),''null'')AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12772;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12803 IS   V_ID NUMBER :=12803;  V_SQL_ID NUMBER :=12835;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LJTempFee'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MIN'' AS CheckType,       NVL((SELECT MIN(a.TRANSACTIONNO)          FROM T_PRP_LJTempFee a,t_Prp_Lcpoltransaction b          WHERE b.batchno = ''#{batchNo}''         AND a.transactionno = b.transactionno         AND b.STATEFLAG = ''5''),''null'')AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12803;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12804 IS   V_ID NUMBER :=12804;  V_SQL_ID NUMBER :=12836;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LJTempFee'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MAX'' AS CheckType,       NVL((SELECT MAX(A.TRANSACTIONNO)          FROM T_PRP_LJTempFee A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),''null'') AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12804;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12805 IS   V_ID NUMBER :=12805;  V_SQL_ID NUMBER :=12837;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LJTempFee'' AS TableName,       ''TransactionNo'' AS FieldName,       ''COUNT'' AS CheckType,       NVL((SELECT COUNT(1)          FROM T_PRP_LJTempFee A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12805;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12806 IS   V_ID NUMBER :=12806;  V_SQL_ID NUMBER :=12838;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LJTempFee'' AS TableName,        ''PayAmnt'' AS FieldName,        ''SUM'' AS CheckType,        NVL((SELECT SUM(A.PayAmnt)           FROM T_PRP_LJTempFee A, T_PRP_LCPOLTRANSACTION B          WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12806;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12807 IS   V_ID NUMBER :=12807;  V_SQL_ID NUMBER :=12839;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LJDivDistrib'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MIN'' AS CheckType,       NVL((SELECT MIN(a.TRANSACTIONNO)          FROM T_PRP_LJDivDistrib a,t_Prp_Lcpoltransaction b          WHERE b.batchno = ''#{batchNo}''         AND a.transactionno = b.transactionno         AND b.STATEFLAG = ''5''),''null'')AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12807;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12808 IS   V_ID NUMBER :=12808;  V_SQL_ID NUMBER :=12840;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LJDivDistrib'' AS TableName,       ''TransactionNo'' AS FieldName,       ''COUNT'' AS CheckType,       NVL((SELECT COUNT(1)          FROM T_PRP_LJDivDistrib A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12808;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12809 IS   V_ID NUMBER :=12809;  V_SQL_ID NUMBER :=12841;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LJDivDistrib'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MAX'' AS CheckType,       NVL((SELECT MAX(a.TRANSACTIONNO)          FROM T_PRP_LJDivDistrib a,t_Prp_Lcpoltransaction b          WHERE b.batchno = ''#{batchNo}''         AND a.transactionno = b.transactionno         AND b.STATEFLAG = ''5''),''null'')AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12809;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12812 IS   V_ID NUMBER :=12812;  V_SQL_ID NUMBER :=12844;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LJAGetLivBene'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MAX'' AS CheckType,       NVL((SELECT MAX(A.TRANSACTIONNO)          FROM T_PRP_LJAGetLivBene A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),''null'') AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12812;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12821 IS   V_ID NUMBER :=12821;  V_SQL_ID NUMBER :=12853;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LJAGet'' AS TableName,       ''TransactionNo'' AS FieldName,       ''COUNT'' AS CheckType,       NVL((SELECT COUNT(1)          FROM T_PRP_LJAGet A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12821;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12822 IS   V_ID NUMBER :=12822;  V_SQL_ID NUMBER :=12854;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LJAGet'' AS TableName,        ''SumActuGetMoney'' AS FieldName,        ''SUM'' AS CheckType,        NVL((SELECT SUM(A.SumActuGetMoney)           FROM T_PRP_LJAGet A, T_PRP_LCPOLTRANSACTION B          WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12822;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12773 IS   V_ID NUMBER :=12773;  V_SQL_ID NUMBER :=12805;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCProduct'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MAX'' AS CheckType,       NVL((SELECT MAX(A.TRANSACTIONNO)          FROM T_PRP_LCProduct A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),''null'') AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12773;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12774 IS   V_ID NUMBER :=12774;  V_SQL_ID NUMBER :=12806;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCProduct'' AS TableName,       ''TransactionNo'' AS FieldName,       ''COUNT'' AS CheckType,       NVL((SELECT COUNT(1)          FROM T_PRP_LCProduct A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12774;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12775 IS   V_ID NUMBER :=12775;  V_SQL_ID NUMBER :=12807;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCProduct'' AS TableName,        ''Premium'' AS FieldName,        ''SUM'' AS CheckType,        NVL((SELECT SUM(A.Premium)           FROM T_PRP_LCProduct A, T_PRP_LCPOLTRANSACTION B          WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12775;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12776 IS   V_ID NUMBER :=12776;  V_SQL_ID NUMBER :=12808;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCProdInsuRela'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MIN'' AS CheckType,       NVL((SELECT MIN(a.TRANSACTIONNO)          FROM T_PRP_LCProdInsuRela a,t_Prp_Lcpoltransaction b          WHERE b.batchno = ''#{batchNo}''         AND a.transactionno = b.transactionno         AND b.STATEFLAG = ''5''),''null'')AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12776;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12777 IS   V_ID NUMBER :=12777;  V_SQL_ID NUMBER :=12809;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCProdInsuRela'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MAX'' AS CheckType,       NVL((SELECT MAX(A.TRANSACTIONNO)          FROM T_PRP_LCProdInsuRela A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),''null'') AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12777;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12778 IS   V_ID NUMBER :=12778;  V_SQL_ID NUMBER :=12810;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCProdInsuRela'' AS TableName,       ''TransactionNo'' AS FieldName,       ''COUNT'' AS CheckType,       NVL((SELECT COUNT(1)          FROM T_PRP_LCProdInsuRela A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12778;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12779 IS   V_ID NUMBER :=12779;  V_SQL_ID NUMBER :=12811;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCBnf'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MIN'' AS CheckType,       NVL((SELECT MIN(a.TRANSACTIONNO)          FROM T_PRP_LCBnf a,t_Prp_Lcpoltransaction b          WHERE b.batchno = ''#{batchNo}''         AND a.transactionno = b.transactionno         AND b.STATEFLAG = ''5''),''null'')AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12779;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12780 IS   V_ID NUMBER :=12780;  V_SQL_ID NUMBER :=12812;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCBnf'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MAX'' AS CheckType,       NVL((SELECT MAX(A.TRANSACTIONNO)          FROM T_PRP_LCBnf A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),''null'') AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12780;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12771 IS   V_ID NUMBER :=12771;  V_SQL_ID NUMBER :=12803;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCCont'' AS TableName,        ''Premium'' AS FieldName,        ''SUM'' AS CheckType,        NVL((SELECT SUM(A.Premium)           FROM T_PRP_LCCont A, T_PRP_LCPOLTRANSACTION B          WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12771;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12781 IS   V_ID NUMBER :=12781;  V_SQL_ID NUMBER :=12813;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCBnf'' AS TableName,       ''TransactionNo'' AS FieldName,       ''COUNT'' AS CheckType,       NVL((SELECT COUNT(1)          FROM T_PRP_LCBnf A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12781;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12782 IS   V_ID NUMBER :=12782;  V_SQL_ID NUMBER :=12814;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCInsured'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MIN'' AS CheckType,       NVL((SELECT MIN(a.TRANSACTIONNO)          FROM T_PRP_LCInsured a,t_Prp_Lcpoltransaction b          WHERE b.batchno = ''#{batchNo}''         AND a.transactionno = b.transactionno         AND b.STATEFLAG = ''5''),''null'')AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12782;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12783 IS   V_ID NUMBER :=12783;  V_SQL_ID NUMBER :=12815;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCInsured'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MAX'' AS CheckType,       NVL((SELECT MAX(A.TRANSACTIONNO)          FROM T_PRP_LCInsured A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),''null'') AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12783;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12784 IS   V_ID NUMBER :=12784;  V_SQL_ID NUMBER :=12816;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCInsured'' AS TableName,       ''TransactionNo'' AS FieldName,       ''COUNT'' AS CheckType,       NVL((SELECT COUNT(1)          FROM T_PRP_LCInsured A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12784;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12785 IS   V_ID NUMBER :=12785;  V_SQL_ID NUMBER :=12817;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCInsureAcc'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MIN'' AS CheckType,       NVL((SELECT MIN(a.TRANSACTIONNO)          FROM T_PRP_LCInsureAcc a,t_Prp_Lcpoltransaction b          WHERE b.batchno = ''#{batchNo}''         AND a.transactionno = b.transactionno         AND b.STATEFLAG = ''5''),''null'')AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12785;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12786 IS   V_ID NUMBER :=12786;  V_SQL_ID NUMBER :=12818;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCInsureAcc'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MAX'' AS CheckType,       NVL((SELECT MAX(A.TRANSACTIONNO)          FROM T_PRP_LCInsureAcc A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),''null'') AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12786;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12787 IS   V_ID NUMBER :=12787;  V_SQL_ID NUMBER :=12819;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCInsureAcc'' AS TableName,       ''TransactionNo'' AS FieldName,       ''COUNT'' AS CheckType,       NVL((SELECT COUNT(1)          FROM T_PRP_LCInsureAcc A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12787;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12788 IS   V_ID NUMBER :=12788;  V_SQL_ID NUMBER :=12820;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCInsureAcc'' AS TableName,        ''AccountValue'' AS FieldName,        ''SUM'' AS CheckType,        NVL((SELECT SUM(A.AccountValue)           FROM T_PRP_LCInsureAcc A, T_PRP_LCPOLTRANSACTION B          WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12788;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12789 IS   V_ID NUMBER :=12789;  V_SQL_ID NUMBER :=12821;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LLClaimPolicy'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MIN'' AS CheckType,       NVL((SELECT MIN(a.TRANSACTIONNO)          FROM T_PRP_LLClaimPolicy a,t_Prp_Lcpoltransaction b          WHERE b.batchno = ''#{batchNo}''         AND a.transactionno = b.transactionno         AND b.STATEFLAG = ''5''),''null'')AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12789;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12800 IS   V_ID NUMBER :=12800;  V_SQL_ID NUMBER :=12832;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LAAgent'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MIN'' AS CheckType,       NVL((SELECT MIN(a.TRANSACTIONNO)          FROM T_PRP_LAAgent a,t_Prp_Lcpoltransaction b          WHERE b.batchno = ''#{batchNo}''         AND a.transactionno = b.transactionno         AND b.STATEFLAG = ''5''),''null'')AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12800;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12801 IS   V_ID NUMBER :=12801;  V_SQL_ID NUMBER :=12833;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LAAgent'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MAX'' AS CheckType,       NVL((SELECT MAX(A.TRANSACTIONNO)          FROM T_PRP_LAAgent A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),''null'') AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12801;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12802 IS   V_ID NUMBER :=12802;  V_SQL_ID NUMBER :=12834;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LAAgent'' AS TableName,       ''TransactionNo'' AS FieldName,       ''COUNT'' AS CheckType,       NVL((SELECT COUNT(1)          FROM T_PRP_LAAgent A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12802;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12815 IS   V_ID NUMBER :=12815;  V_SQL_ID NUMBER :=12847;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LJAPay'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MIN'' AS CheckType,       NVL((SELECT MIN(a.TRANSACTIONNO)          FROM T_PRP_LJAPay a,t_Prp_Lcpoltransaction b          WHERE b.batchno = ''#{batchNo}''         AND a.transactionno = b.transactionno         AND b.STATEFLAG = ''5''),''null'')AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12815;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12816 IS   V_ID NUMBER :=12816;  V_SQL_ID NUMBER :=12848;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LJAPay'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MAX'' AS CheckType,       NVL((SELECT MAX(A.TRANSACTIONNO)          FROM T_PRP_LJAPay A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),''null'') AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12816;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12817 IS   V_ID NUMBER :=12817;  V_SQL_ID NUMBER :=12849;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LJAPay'' AS TableName,       ''TransactionNo'' AS FieldName,       ''COUNT'' AS CheckType,       NVL((SELECT COUNT(1)          FROM T_PRP_LJAPay A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12817;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12818 IS   V_ID NUMBER :=12818;  V_SQL_ID NUMBER :=12850;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LJAPay'' AS TableName,        ''SumActuPayMoney'' AS FieldName,        ''SUM'' AS CheckType,        NVL((SELECT SUM(A.SumActuPayMoney)           FROM T_PRP_LJAPay A, T_PRP_LCPOLTRANSACTION B          WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12818;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12819 IS   V_ID NUMBER :=12819;  V_SQL_ID NUMBER :=12851;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LJAGet'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MIN'' AS CheckType,       NVL((SELECT MIN(a.TRANSACTIONNO)          FROM T_PRP_LJAGet a,t_Prp_Lcpoltransaction b          WHERE b.batchno = ''#{batchNo}''         AND a.transactionno = b.transactionno         AND b.STATEFLAG = ''5''),''null'')AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12819;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12810 IS   V_ID NUMBER :=12810;  V_SQL_ID NUMBER :=12842;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LJDivDistrib'' AS TableName,        ''DivAmnt'' AS FieldName,        ''SUM'' AS CheckType,        NVL((SELECT SUM(A.DivAmnt)           FROM T_PRP_LJDivDistrib A, T_PRP_LCPOLTRANSACTION B          WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12810;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12811 IS   V_ID NUMBER :=12811;  V_SQL_ID NUMBER :=12843;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LJAGetLivBene'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MIN'' AS CheckType,       NVL((SELECT MIN(a.TRANSACTIONNO)          FROM T_PRP_LJAGetLivBene a,t_Prp_Lcpoltransaction b          WHERE b.batchno = ''#{batchNo}''         AND a.transactionno = b.transactionno         AND b.STATEFLAG = ''5''),''null'')AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12811;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12820 IS   V_ID NUMBER :=12820;  V_SQL_ID NUMBER :=12852;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LJAGet'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MAX'' AS CheckType,       NVL((SELECT MAX(A.TRANSACTIONNO)          FROM T_PRP_LJAGet A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),''null'') AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12820;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12429 IS   V_ID NUMBER :=12429;  V_SQL_ID NUMBER :=12429;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE  FROM T_PRP_LLBnf where transactionno in (select transactionno from T_PRP_LCPolTransaction where transdate between to_date(''#{startDate}'', ''yyyy-mm-dd'') and to_date(''#{endDate}'', ''yyyy-mm-dd''))'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12429;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12432 IS   V_ID NUMBER :=12432;  V_SQL_ID NUMBER :=12432;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE  FROM T_PRP_LLClaimPolicy where transactionno in (select transactionno from T_PRP_LCPolTransaction where transdate between to_date(''#{startDate}'', ''yyyy-mm-dd'') and to_date(''#{endDate}'', ''yyyy-mm-dd''))'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12432;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12435 IS   V_ID NUMBER :=12435;  V_SQL_ID NUMBER :=12435;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LJAGET A
    SET A.GETTYPE = (CASE
                      WHEN A.GETTYPE IN (SELECT BASIC_CODE
                                           FROM T_DEF_CODE_MAPPING
                                          WHERE CODE_TYPE = ''gettype''
                                            AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''gettype''
                           AND A.GETTYPE = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.GETTYPE
                    END),
        A.GETWAY = (CASE
                     WHEN A.GETWAY IN (SELECT BASIC_CODE
                                         FROM T_DEF_CODE_MAPPING
                                        WHERE CODE_TYPE = ''getway''
                                          AND COM_ID = ''1'') THEN
                      (SELECT TARGET_CODE
                         FROM T_DEF_CODE_MAPPING B
                        WHERE B.CODE_TYPE = ''getway''
                          AND A.GETWAY = B.BASIC_CODE
                          AND B.COM_ID = ''1'')
                     ELSE
                      A.GETWAY
                   END),
        A.CURRENCY = (CASE
                       WHEN A.CURRENCY IN (SELECT BASIC_CODE
                                             FROM T_DEF_CODE_MAPPING
                                            WHERE CODE_TYPE = ''currency''
                                              AND COM_ID = ''1'') THEN
                        (SELECT TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE B.CODE_TYPE = ''currency''
                            AND A.CURRENCY = B.BASIC_CODE
                            AND B.COM_ID = ''1'')
                       ELSE
                        A.CURRENCY
                     END),
        A.CERTTYPE = (CASE
                       WHEN A.CERTTYPE IN (SELECT BASIC_CODE
                                             FROM T_DEF_CODE_MAPPING
                                            WHERE CODE_TYPE = ''certtype''
                                              AND COM_ID = ''1'') THEN
                        (SELECT TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE B.CODE_TYPE = ''certtype''
                            AND A.CERTTYPE = B.BASIC_CODE
                            AND B.COM_ID = ''1'')
                       ELSE
                        A.CERTTYPE
                     END),
       A.TRANSACTIONNO = (CASE
                            WHEN A.TRANSACTIONNO IN
                                 (SELECT C.CHGID
                                    FROM T_PRP_CHG_TRANS_ID_MAP C
                                 ) THEN
                             (SELECT Max(C.TRANSNO)
                                FROM  T_PRP_CHG_TRANS_ID_MAP C
                                 WHERE A.TRANSACTIONNO = C.CHGID
                             )
                            ELSE
                             A.TRANSACTIONNO
                          END)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12435;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12436 IS   V_ID NUMBER :=12436;  V_SQL_ID NUMBER :=12436;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='
--新单(承保)
select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''01'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=h2.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       hc1.prtno PrtNo,
      (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''conttype'' and ORIGINCODE=h1.conttype) GPFlag,
      (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''familyflag'' and ORIGINCODE=hc1.familyflag) FamilyPolType,
       hc1.managecom ManageCom,
     (select name from ODS_STG.HNW_ldcom where comcode=hc1.managecom) ManageComName, 
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''agenttype'' and ORIGINCODE=hc1.agenttype) DistribChnl,
       hc1.agentcode AgencyCode,
       (select max(name) from ODS_STG.HNW_haagent where agentcode=hc1.agentcode) AgencyName,
       hc1.appntno AppntNo,
       '''' CustomerNo,
       nvl(hc2.name,hc3.appntfirstname||hc3.appntsurname) AppntName,
      nvl((select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=hc3.appntsex),''9'') AppntSex,
       hc3.appntbirthday AppntBirthDate,
       nvl((select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc3.idtype),''990'') AppntCertType,
       nvl(hc3.idno,''0000'') AppntCertNo,
       rpad(nvl(ha1.province,ha2.province),6,0) Province,
       rpad(nvl(ha1.city,ha2.city),6,0) City,
       nvl(ha1.county,ha2.county) County,
       '''' Street,
       nvl(hc2.phone,'''') AppntMP,
       '''' AppntFP,
       '''' EMail,
      (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''payintv'' and ORIGINCODE=hc1.payintv) PayMode,
      (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''paymode'' and ORIGINCODE=hc1.paymode) PayWay,
       hc1.signdate SignDate,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''currency'' and ORIGINCODE=hc1.currency) Currency,
       1 Copies,
       hc1.prem Premium,
       hc1.amnt SumInsured,
       0 CashValue,
       hc1.outpay PolBalance,
       hc1.prem AccumPremium,
       0 AccumLoanMoney,
       0 APLMoney,
       '''' CurPaidToDate,
       hc1.cvalidate PayBeginDate,
       hc1.cvalidate EffDate,
       hc1.uwdate UWDate,
       ''2'' UWType,
       hc1.polapplydate PolApplyDate,
       hc1.customgetpoldate CustomGetPolDate,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''polstate'' and ORIGINCODE=hc1.state) PolStatus,
        hc.bankcode BankCode,
        (select bankname from ODS_STG.HNW_ldbank where bankcode=hc.bankcode) BankName,
       hc.bankaccno BankAccNo,
       hc.accname AccName,
       ''1'' PolicyType,
       hc1.enddate PolicyEndDate,
       '''' TerminationDate,
       '''' SuspendDate,
       '''' RecoverDate,
       '''' TerminationReason,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
left join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
left join ODS_STG.HNW_hcgrpcont hc1 on hc1.grpcontno=hc.grpcontno
left join ODS_STG.HNW_hcgrpappnt hc2 on hc1.grpcontno=hc2.grpcontno 
left join ODS_STG.HNW_hcappnt hc3 on hc1.grpcontno=hc3.grpcontno 
left join ODS_STG.HNW_hcgrpaddress ha1 on hc2.customerno=ha1.customerno and hc2.addressno=ha1.addressno
left join ODS_STG.HNW_hcaddress ha2 on hc3.appntno=ha2.customerno and hc3.addressno=ha2.addressno
where 1=1 and (h1.othernotype=''1'' and h1.tempfeetype=''8'') and  h1.conttype=''1'' 
     and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
  
union all
--新单（续期）

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''02'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=h2.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       hc1.prtno PrtNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''conttype'' and ORIGINCODE=h1.conttype) GPFlag,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''familyflag'' and ORIGINCODE=hc1.familyflag) FamilyPolType,
       hc1.managecom ManageCom,
       (select name from ODS_STG.HNW_ldcom where comcode=hc1.managecom) ManageComName, 
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''agenttype'' and ORIGINCODE=hc1.agenttype)  DistribChnl,
       hc1.agentcode AgencyCode,
       (select max(name) from ODS_STG.HNW_haagent where agentcode=hc1.agentcode) AgencyName,
       hc1.appntno AppntNo,
       '''' CustomerNo,
       nvl(hc2.name,hc3.appntfirstname||hc3.appntsurname) AppntName,
       nvl((select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=hc3.appntsex),''9'') AppntSex,
       hc3.appntbirthday AppntBirthDate,
       nvl((select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc3.idtype),''990'')AppntCertType,
       nvl(hc3.idno,''0000'') AppntCertNo,
       rpad(nvl(ha1.province,ha2.province),6,0) Province,
       rpad(nvl(ha1.city,ha2.city),6,0) City,
       nvl(ha1.county,ha2.county) County,
       '''' Street,
       nvl(hc2.phone,'''') AppntMP,
       '''' AppntFP,
       '''' EMail,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''payintv'' and ORIGINCODE=hc1.payintv) PayMode,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''paymode'' and ORIGINCODE=hc1.paymode) PayWay,
       hc1.signdate SignDate,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''currency'' and ORIGINCODE=hc1.currency) Currency,
       1 Copies,
       hc1.prem Premium,
       hc1.amnt SumInsured,
       0 CashValue,
       hc1.outpay PolBalance,
       hc1.prem AccumPremium,
       0 AccumLoanMoney,
       0 APLMoney,
       '''' CurPaidToDate,
       hc1.cvalidate PayBeginDate,
       hc1.cvalidate EffDate,
       hc1.uwdate UWDate,
       ''2'' UWType,
       hc1.polapplydate PolApplyDate,
       hc1.customgetpoldate CustomGetPolDate,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''polstate'' and ORIGINCODE=hc1.state) PolStatus,
        hc.bankcode BankCode,
        (select bankname from ODS_STG.HNW_ldbank where bankcode=hc.bankcode) BankName,
       hc.bankaccno BankAccNo,
       hc.accname AccName,
       ''1'' PolicyType,
       hc1.enddate PolicyEndDate,
       '''' TerminationDate,
       '''' SuspendDate,
       '''' RecoverDate,
       '''' TerminationReason,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
left join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
left join ODS_STG.HNW_hcgrpcont hc1 on hc1.grpcontno=hc.grpcontno
left join ODS_STG.HNW_hcgrpappnt hc2 on hc1.grpcontno=hc2.grpcontno 
left join ODS_STG.HNW_hcappnt hc3 on hc1.grpcontno=hc3.grpcontno 
left join ODS_STG.HNW_hcgrpaddress ha1 on hc2.customerno=ha1.customerno and hc2.addressno=ha1.addressno
left join ODS_STG.HNW_hcaddress ha2 on hc3.appntno=ha2.customerno and hc3.addressno=ha2.addressno
where 1=1 and (h1.othernotype in (''1'', ''2'') and h1.tempfeetype=''9'') and h1.conttype=''1''  
      and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
     
union all

--保全收费(非定结)

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''03'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       hc1.prtno PrtNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''conttype'' and ORIGINCODE=h1.conttype) GPFlag,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''familyflag'' and ORIGINCODE=hc1.familyflag) FamilyPolType,
       hc1.managecom ManageCom,
       (select name from ODS_STG.HNW_ldcom where comcode=hc1.managecom) ManageComName, 
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''agenttype'' and ORIGINCODE=hc1.agenttype)  DistribChnl,
       hc1.agentcode AgencyCode,
       (select max(name) from ODS_STG.HNW_haagent where agentcode=hc1.agentcode)  AgencyName,
       hc1.appntno AppntNo,
       '''' CustomerNo,
       nvl(hc2.name,hc3.appntfirstname||hc3.appntsurname) AppntName,
       nvl((select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=hc3.appntsex),''9'') AppntSex,
       hc3.appntbirthday AppntBirthDate,
       nvl((select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc3.idtype),''990'') AppntCertType,
       nvl(hc3.idno,''0000'') AppntCertNo,
       rpad(nvl(ha1.province,ha2.province),6,0) Province,
       rpad(nvl(ha1.city,ha2.city),6,0) City,
       nvl(ha1.county,ha2.county) County,
       '''' Street,
       nvl(hc2.phone,'''') AppntMP,
       '''' AppntFP,
       '''' EMail,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''payintv'' and ORIGINCODE=hc1.payintv) PayMode,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''paymode'' and ORIGINCODE=hc1.paymode) PayWay,
       hc1.signdate SignDate,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''currency'' and ORIGINCODE=hc1.currency) Currency,
       1 Copies,
       hc1.prem Premium,
       hc1.amnt SumInsured,
       0 CashValue,
       hc1.outpay PolBalance,
       hc1.prem AccumPremium,
       0 AccumLoanMoney,
       0 APLMoney,
       '''' CurPaidToDate,
       hc1.cvalidate PayBeginDate,
       hc1.cvalidate EffDate,
       hc1.uwdate UWDate,
       ''2'' UWType,
       hc1.polapplydate PolApplyDate,
       hc1.customgetpoldate CustomGetPolDate,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''polstate'' and ORIGINCODE=hc1.state) PolStatus,
        hc.bankcode BankCode,
        (select bankname from ODS_STG.HNW_ldbank where bankcode=hc.bankcode) BankName,
       hc.bankaccno BankAccNo,
       hc.accname AccName,
       ''1'' PolicyType,
       hc1.enddate PolicyEndDate,
       '''' TerminationDate,
       '''' SuspendDate,
       '''' RecoverDate,
       '''' TerminationReason,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate

from ODS_STG.HNW_hjapay h1
inner join (select endorno, grpcontno, contno,feefinatype as feefinatype,sum(getmoney) as sumactupaymoney
  from ODS_STG.HNW_hejsgetendorse
 group by endorno, grpcontno, contno,feefinatype) h2 on h1.otherno=h2.endorno
left join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
left join ODS_STG.HNW_hpedoritem hp1 on h1.otherno=hp1.edorappno and h2.contno=hp1.contno
left join ODS_STG.HNW_hcgrpcont hc1 on hc1.grpcontno=h2.grpcontno
left join ODS_STG.HNW_hcgrpappnt hc2 on hc1.grpcontno=hc2.grpcontno 
left join ODS_STG.HNW_hcappnt hc3 on hc1.grpcontno=hc3.grpcontno 
left join ODS_STG.HNW_hcgrpaddress ha1 on hc2.customerno=ha1.customerno and hc2.addressno=ha1.addressno
left join ODS_STG.HNW_hcaddress ha2 on hc3.appntno=ha2.customerno and hc3.addressno=ha2.addressno
where (h1.othernotype = ''2'' and h1.incometype = ''0'')  and h1.conttype=''1'' 
      and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

union all
--保全付费（非定结）

select ''G''||substr(hj1.actugetno,12)||substr(h2.contno,11)||''04'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       hc1.prtno PrtNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''conttype'' and ORIGINCODE=hj1.conttype) GPFlag,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''familyflag'' and ORIGINCODE=hc1.familyflag) FamilyPolType,
       hc1.managecom ManageCom,
       (select name from ODS_STG.HNW_ldcom where comcode=hc1.managecom) ManageComName, 
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''agenttype'' and ORIGINCODE=hc1.agenttype)  DistribChnl,
       hc1.agentcode AgencyCode,
       (select max(name) from ODS_STG.HNW_haagent where agentcode=hc1.agentcode)  AgencyName,
       hc1.appntno AppntNo,
       '''' CustomerNo,
       nvl(hc2.name,hc3.appntfirstname||hc3.appntsurname) AppntName,
       nvl((select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=hc3.appntsex),''9'') AppntSex,
       hc3.appntbirthday AppntBirthDate,
       nvl((select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc3.idtype),''990'') AppntCertType,
       nvl(hc3.idno,''0000'') AppntCertNo,
       rpad(nvl(ha1.province,ha2.province),6,0) Province,
       rpad(nvl(ha1.city,ha2.city),6,0) City,
       nvl(ha1.county,ha2.county) County,
       '''' Street,
       nvl(hc2.phone,'''') AppntMP,
       '''' AppntFP,
       '''' EMail,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''payintv'' and ORIGINCODE=hc1.payintv) PayMode,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''paymode'' and ORIGINCODE=hc1.paymode) PayWay,
       hc1.signdate SignDate,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''currency'' and ORIGINCODE=hc1.currency) Currency,
       1 Copies,
       hc1.prem Premium,
       hc1.amnt SumInsured,
       0 CashValue,
       hc1.outpay PolBalance,
       hc1.prem AccumPremium,
       0 AccumLoanMoney,
       0 APLMoney,
       '''' CurPaidToDate,
       hc1.cvalidate PayBeginDate,
       hc1.cvalidate EffDate,
       hc1.uwdate UWDate,
       ''2'' UWType,
       hc1.polapplydate PolApplyDate,
       hc1.customgetpoldate CustomGetPolDate,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''polstate'' and ORIGINCODE=hc1.state) PolStatus,
        hc.bankcode BankCode,
        (select bankname from ODS_STG.HNW_ldbank where bankcode=hc.bankcode) BankName,
       hc.bankaccno BankAccNo,
       hc.accname AccName,
       ''1'' PolicyType,
       hc1.enddate PolicyEndDate,
       '''' TerminationDate,
       '''' SuspendDate,
       '''' RecoverDate,
       '''' TerminationReason,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate

from ODS_STG.HNW_hjaget hj1
inner join (select endorno, grpcontno, contno,feefinatype as feefinatype,sum(getmoney) as sumactupaymoney
  from ODS_STG.HNW_hejsgetendorse 
 group by endorno, grpcontno, contno,feefinatype) h2 on hj1.otherno = h2.endorno
left join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
left join ODS_STG.HNW_hpedoritem hp1 on hj1.otherno=hp1.edorappno and h2.contno=hp1.contno
left join ODS_STG.HNW_hcgrpcont hc1 on hc1.grpcontno=h2.grpcontno
left join ODS_STG.HNW_hcgrpappnt hc2 on hc1.grpcontno=hc2.grpcontno
left join ODS_STG.HNW_hcappnt hc3 on hc1.grpcontno=hc3.grpcontno 
left join ODS_STG.HNW_hcgrpaddress ha1 on hc2.customerno=ha1.customerno and hc2.addressno=ha1.addressno
left join ODS_STG.HNW_hcaddress ha2 on hc3.appntno=ha2.customerno and hc3.addressno=ha2.addressno
where 1=1 and (hj1.othernotype = ''2'' and hj1.tempfeetype = ''4'') and hj1.conttype=''1'' 
and hj1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12436;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12527 IS   V_ID NUMBER :=12527;  V_SQL_ID NUMBER :=12546;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='  DELETE FROM  T_PRP_LJAGetLivBene T WHERE NOT EXISTS (SELECT ''x'' FROM T_PRP_LCPolTransaction TT WHERE T.TRANSACTIONNO = TT.TRANSACTIONNO AND TT.Policyno = T.policyNo)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12527;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_10871 IS   V_ID NUMBER :=10871;  V_SQL_ID NUMBER :=10895;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='SELECT chgid,
       ''000031'' || to_char(SYSDATE, ''yyyymmdd'') ||
       lpad(rownum, ''10'', ''0'') AS transno,
       BUSSNO,
       busstype,
       to_char(SYSDATE, ''yyyymmdd'') AS dateserial,
       ''000000'' AS companycode
       
  FROM (
        SELECT TO_CHAR(PC.POLICY_CHG_ID) AS CHGID,
                TO_CHAR(P.POLICY_NO) AS BUSSNO,
                ''OFE'' AS BUSSTYPE,
                Effective_Date AS transdate
          FROM ODS_STG.OFE_T_POLICY_CHANGE PC,
                ODS_STG.OFE_T_POLICY        P,
                ODS_STG.OFE_T_POL_PLAN      PP,
                ODS_STG.OFE_T_PD_PRODUCT    PD
         WHERE PC.RC_STATE = ''E''
           AND PP.RC_STATE = ''E''
           AND PD.RC_STATE = ''E''
           AND PP.POLICY_ID = P.POLICY_ID
           AND PP.POLICY_ID = PC.POLICY_ID
           AND PC.POLICY_ID = P.POLICY_ID
           AND PD.PD_PRODUCT_ID = PP.PD_PRODUCT_ID
           AND PD.BASIC_PRODUCT_FLAG = ''B''
           AND PD.COVERAGE_TERM_TYPE <> ''M''
           AND P.POLICY_ID > 0
           AND PC.POLICY_ID > 0
           AND NOT EXISTS (SELECT 1
                  FROM ODS_STG.OFE_T_RLS_POLICY A
                 WHERE TO_CHAR(A.PNO) = TO_CHAR(P.POLICY_NO)
                   AND A.FLAG = ''1'')
           AND PC.Effective_Date between
               to_date(''#{startDate}'', ''yyyy-mm-dd'') and
               to_date(''#{endDate}'', ''yyyy-mm-dd'')
        UNION
        SELECT TO_CHAR(SYSDATE, ''yyyymmdd'') || TO_CHAR(PC.CREF) AS chgid,
               TO_CHAR(PC.PNO) AS bussno,
               ''RLS'' AS busstype,
               TO_DATE(PC.CDOT, ''yyyy-mm-dd'') AS transdate
          FROM ODS_STG.RLS_LFPCHG PC
         WHERE PC.CTSTU = ''09''
           AND PC.CTC <> ''A''
           AND TO_DATE(PC.CDOT, ''yyyy-mm-dd'') BETWEEN
               TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND
               TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')) mp
 where 1 = 1
   AND mp.transdate between to_date(''#{startDate}'', ''yyyy-mm-dd'') and
       to_date(''#{endDate}'', ''yyyy-mm-dd'')'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 10871;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12473 IS   V_ID NUMBER :=12473;  V_SQL_ID NUMBER :=12473;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='
select ''L''||substr(h1.clmno,2)||substr(hc.contno,11)||''05'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       h1.inputclmno ClaimNo,
       '''' GrpPolicyNo,
       h1.segment1 PolicyNo,
       h1.segment2 ProductNo,
       hc.insuredno InsuredNo,
       '''' CustomerNo,
        h1.segment1 BnfSerialNum,
       ''2'' BnfCat,
       ''1'' BnfLevel,
       ''00'' RelationToInsured,
        hc.name Name,
        (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=hc.sex) Sex,
        hc.birthday BirthDate,
        (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) CertType,
        hc.idno  CertNo,
        ''00'' RelationOfPayeeAndInsured,
        hc.insuredno PayeeNo,
        hc.name PayeeName,
        (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''sex'' and ORIGINCODE=hc.sex) PayeeSex,
        hc.birthday PayeeBirthday,
        (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) PayeeCertType,
        hc.idno  PayeeCertNo,
        1 PercentOfBenefit,
         h1.clmamt DrawingAmnt,
         '''' BenefitWDMthd,
         '''' BenefitPayMthd,
         h1.bankcode BankCode,
         h1.bankname BankName,
         h1.bankaccno BankAccNo,
         h1.bankaccno AccName,
          to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'')  MakeDate
          
from ODS_STG.HNW_hlclaim h1
inner join ODS_STG.HNW_hcinsured hc
    on h1.segment1 = hc.contno
left join ODS_STG.HNW_hcpol h5 on hc.grpcontno=h5.grpcontno and hc.contno=h5.contno 
left join ODS_STG.HNW_hcgrpcont h on h.grpcontno=h1.policyno
where 1=1 and h1.conttype=''1'' and h1.endcasedate  BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12473;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12421 IS   V_ID NUMBER :=12421;  V_SQL_ID NUMBER :=12421;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='--chgid,transno,bussno,busstype,dateserial,companycode
SELECT TransactionNo as chgid,
       ''000031'' || to_char(SYSDATE, ''yyyymmdd'') ||
       lpad((''0'' + rownum), ''10'', ''0'') AS transno,
       PolicyNo as BUSSNO,
       ''HNW'' busstype,
       to_char(SYSDATE, ''yyyymmdd'') AS dateserial,
       ''000000'' AS companycode
       
  FROM (--新单(承保)
select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''01'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode)  BatchNo,
      (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       ''02''  BussType,
       h2.sumactupaymoney TransAmnt,
       h1.enteraccdate TransDate,
       hc.bankcode BankCode,
      (select bankname from ODS_STG.HNW_ldbank where bankcode=hc.bankcode) BankName,
       hc.bankaccno BankAccNo,
       hc.accname AccName,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) CertType,
       hc.idno CertNo,
       ''1'' STATEFLAG,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
where 1=1 and (h1.othernotype=''1'' and h1.tempfeetype=''8'') and  h1.conttype=''1'' 
     and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
                    
union all
--新单（续期）

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''02'' TransactionNo,
      (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode)  BatchNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       ''03''  BussType,
       h2.sumactupaymoney TransAmnt,
       h1.enteraccdate TransDate,
       hc.bankcode BankCode,
       (select bankname from ODS_STG.HNW_ldbank where bankcode=hc.bankcode) BankName,
       hc.bankaccno BankAccNo,
       hc.accname AccName,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) CertType,
       hc.idno CertNo,
       ''1'' STATEFLAG,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
where 1=1 and (h1.othernotype in (''1'', ''2'') and h1.tempfeetype=''9'') and h1.conttype=''1''  
      and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
         
         
union all

--保全收费(非定结)

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''03'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode)  BatchNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       case when h2.feefinatype=''NI'' then ''24'' else case when h2.feefinatype=''ZT'' then ''25'' else 
        case when h2.feefinatype=''IC'' then ''18'' else case when h2.feefinatype=''CT'' then ''31'' else '''' end  end end  end  BussType,
       h2.sumactupaymoney TransAmnt,
       h1.enteraccdate TransDate,
       hc.bankcode BankCode,
       (select bankname from ODS_STG.HNW_ldbank where bankcode=hc.bankcode) BankName,
       hc.bankaccno BankAccNo,
       hc.accname AccName,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) CertType,
       hc.idno CertNo,
       ''1'' STATEFLAG,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
from ODS_STG.HNW_hjapay h1
inner join (select endorno, grpcontno, contno,feefinatype as feefinatype,sum(getmoney) as sumactupaymoney
  from ODS_STG.HNW_hejsgetendorse
 group by endorno, grpcontno, contno,feefinatype) h2 on h1.otherno=h2.endorno
left join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
where (h1.othernotype = ''2'' and h1.incometype = ''0'')  and h1.conttype=''1'' 
      and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

union all 
--保全付费（非定结）

select ''G''||substr(hj1.actugetno,12)||substr(h2.contno,11)||''04'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode)  BatchNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       case when h2.feefinatype=''NI'' then ''24'' else case when h2.feefinatype=''ZT'' then ''25'' else 
        case when h2.feefinatype=''IC'' then ''18'' else case when h2.feefinatype=''CT'' then ''31'' else '''' end  end end  end  BussType,
       h2.sumactupaymoney  TransAmnt,
       hj1.enteraccdate TransDate,
       hc.bankcode BankCode,
       (select bankname from ODS_STG.HNW_ldbank where bankcode=hc.bankcode) BankName,
       hc.bankaccno BankAccNo,
       hc.accname AccName,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) CertType,
       hc.idno CertNo,
       ''1'' STATEFLAG,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate

from ODS_STG.HNW_hjaget hj1
inner join (select endorno, grpcontno, contno,feefinatype as feefinatype,sum(getmoney) as sumactupaymoney
  from ODS_STG.HNW_hejsgetendorse 
 group by endorno, grpcontno, contno,feefinatype) h2 on hj1.otherno = h2.endorno
left join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
where 1=1 and (hj1.othernotype = ''2'' and hj1.tempfeetype = ''4'') and hj1.conttype=''1'' 
and hj1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

union all

--理赔
select  ''L''||substr(hl.clmno,2)||substr(hc.contno,11)||''05'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hl.comcode)  BatchNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hl.comcode) CompanyCode,
       '''' GrpPolicyNo,
       hc.contno PolicyNo,
       ''15'' BussType,
       hl.clmamt * -1 TransAmnt,
       hl.endcasedate TransDate,
       hl.bankcode BankCode,
       hl.bankname BankName,
       hl.bankaccno BankAccNo,
       hl.bankaccname AccName,
        (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) CertType,
       hc.idno CertNo,
       ''1'' STATEFLAG,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
  from ODS_STG.HNW_hlclaim hl
  inner join ODS_STG.HNW_hcinsured hc
    on hl.segment1 = hc.contno

 where 1 = 1  and hl.conttype=''1''  and hl.endcasedate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd''))
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12421;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12530 IS   V_ID NUMBER :=12530;  V_SQL_ID NUMBER :=12549;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='  DELETE FROM  T_PRP_LASales T WHERE NOT EXISTS (SELECT ''x'' FROM T_PRP_LCCont TT WHERE TT.Policyno = T.policyNo)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12530;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12438 IS   V_ID NUMBER :=12438;  V_SQL_ID NUMBER :=12438;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCCONT A
   SET A.COMPANYCODE = case
                         when (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.COMPANYCODE = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''companycode''
                                  AND B.COM_ID = 1) is not null then
                          (SELECT B.TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE A.COMPANYCODE = B.BASIC_CODE
                              AND B.CODE_TYPE = ''companycode''
                              AND B.COM_ID = 1)
                         else
                          a.companycode
                       end,
       
       A.GPFLAG = case
                    when (SELECT B.TARGET_CODE
                            FROM T_DEF_CODE_MAPPING B
                           WHERE A.GRPPOLICYNO = B.BASIC_CODE
                             AND B.CODE_TYPE = ''gpflag''
                             AND B.COM_ID = 1) is not null then
                     (SELECT B.TARGET_CODE
                        FROM T_DEF_CODE_MAPPING B
                       WHERE A.GRPPOLICYNO = B.BASIC_CODE
                         AND B.CODE_TYPE = ''gpflag''
                         AND B.COM_ID = 1)
                    else
                     a.gpflag
                  end,
       
       A.FAMILYPOLTYPE = case
                           when (SELECT B.TARGET_CODE
                                   FROM T_DEF_CODE_MAPPING B
                                  WHERE A.FAMILYPOLTYPE = B.BASIC_CODE
                                    AND B.CODE_TYPE = ''familypoltype''
                                    AND B.COM_ID = 1) is not null then
                            (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.FAMILYPOLTYPE = B.BASIC_CODE
                                AND B.CODE_TYPE = ''familypoltype''
                                AND B.COM_ID = 1)
                           else
                            a.familypoltype
                         end,
       
       A.MANAGECOM = case
                       when (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.MANAGECOM = B.BASIC_CODE
                                AND B.CODE_TYPE = ''managecom''
                                AND B.COM_ID = 1) is not null then
                        (SELECT B.TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE A.MANAGECOM = B.BASIC_CODE
                            AND B.CODE_TYPE = ''managecom''
                            AND B.COM_ID = 1)
                       else
                        a.managecom
                     end,
       
       A.MANAGECOMNAME = case
                           when (SELECT B.TARGET_CODE
                                   FROM T_DEF_CODE_MAPPING B
                                  WHERE A.MANAGECOMNAME = B.BASIC_CODE
                                    AND B.CODE_TYPE = ''managecomname''
                                    AND B.COM_ID = 1) is not null then
                            (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.MANAGECOMNAME = B.BASIC_CODE
                                AND B.CODE_TYPE = ''managecomname''
                                AND B.COM_ID = 1)
                           else
                            a.managecomname
                         end,
       
       A.APPNTSEX = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.APPNTSEX = B.BASIC_CODE
                               AND B.CODE_TYPE = ''sex''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.APPNTSEX = B.BASIC_CODE
                           AND B.CODE_TYPE = ''sex''
                           AND B.COM_ID = 1)
                      else
                       a.appntsex
                    end,
       
       A.APPNTCERTTYPE = case
                           when (SELECT B.TARGET_CODE
                                   FROM T_DEF_CODE_MAPPING B
                                  WHERE A.APPNTCERTTYPE = B.BASIC_CODE
                                    AND B.CODE_TYPE = ''certtype''
                                    AND B.COM_ID = 1) is not null then
                            (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.APPNTCERTTYPE = B.BASIC_CODE
                                AND B.CODE_TYPE = ''certtype''
                                AND B.COM_ID = 1)
                           else
                            a.appntcerttype
                         end,
       
       A.PROVINCE = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.PROVINCE = B.BASIC_CODE
                               AND B.CODE_TYPE = ''city''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.PROVINCE = B.BASIC_CODE
                           AND B.CODE_TYPE = ''city''
                           AND B.COM_ID = 1)
                      else
                       a.province
                    end,
       
       A.CITY = case
                  when (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.CITY = B.BASIC_CODE
                           AND B.CODE_TYPE = ''city''
                           AND B.COM_ID = 1) is not null then
                   (SELECT B.TARGET_CODE
                      FROM T_DEF_CODE_MAPPING B
                     WHERE A.CITY = B.BASIC_CODE
                       AND B.CODE_TYPE = ''city''
                       AND B.COM_ID = 1)
                  else
                   a.CITY
                end,
       A.COUNTY = case
                    when (SELECT B.TARGET_CODE
                            FROM T_DEF_CODE_MAPPING B
                           WHERE A.COUNTY = B.BASIC_CODE
                             AND B.CODE_TYPE = ''city''
                             AND B.COM_ID = 1) is not null then
                     (SELECT B.TARGET_CODE
                        FROM T_DEF_CODE_MAPPING B
                       WHERE A.COUNTY = B.BASIC_CODE
                         AND B.CODE_TYPE = ''city''
                         AND B.COM_ID = 1)
                    else
                     a.county
                  end,
       
       A.PAYMODE = case
                     when
                     
                      (SELECT B.TARGET_CODE
                         FROM T_DEF_CODE_MAPPING B
                        WHERE A.PAYMODE = B.BASIC_CODE
                          AND B.CODE_TYPE = ''paymode''
                          AND B.COM_ID = 1) is not null then
                      (SELECT B.TARGET_CODE
                         FROM T_DEF_CODE_MAPPING B
                        WHERE A.PAYMODE = B.BASIC_CODE
                          AND B.CODE_TYPE = ''paymode''
                          AND B.COM_ID = 1)
                     else
                      a.paymode
                   end,
       
       A.PAYWAY = case
                    when (SELECT B.TARGET_CODE
                            FROM T_DEF_CODE_MAPPING B
                           WHERE A.PAYWAY = B.BASIC_CODE
                             AND B.CODE_TYPE = ''payway''
                             AND B.COM_ID = 1) is not null then
                     (SELECT B.TARGET_CODE
                        FROM T_DEF_CODE_MAPPING B
                       WHERE A.PAYWAY = B.BASIC_CODE
                         AND B.CODE_TYPE = ''payway''
                         AND B.COM_ID = 1)
                    else
                     a.payway
                  end,
       
       A.CURRENCY = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.CURRENCY = B.BASIC_CODE
                               AND B.CODE_TYPE = ''currency''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.CURRENCY = B.BASIC_CODE
                           AND B.CODE_TYPE = ''currency''
                           AND B.COM_ID = 1)
                      else
                       a.currency
                    end,
       
       A.UWTYPE = case
                    when (SELECT B.TARGET_CODE
                            FROM T_DEF_CODE_MAPPING B
                           WHERE A.UWTYPE = B.BASIC_CODE
                             AND B.CODE_TYPE = ''uwtype''
                             AND B.COM_ID = 1) is not null then
                     (SELECT B.TARGET_CODE
                        FROM T_DEF_CODE_MAPPING B
                       WHERE A.UWTYPE = B.BASIC_CODE
                         AND B.CODE_TYPE = ''uwtype''
                         AND B.COM_ID = 1)
                    else
                     a.uwtype
                  end,
       A.POLSTATUS = case
                       when (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.POLSTATUS = B.BASIC_CODE
                                AND B.CODE_TYPE = ''polstatus''
                                AND B.COM_ID = 1) is not null then
                        (SELECT B.TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE A.POLSTATUS = B.BASIC_CODE
                            AND B.CODE_TYPE = ''polstatus''
                            AND B.COM_ID = 1)
                       else
                        a.polstatus
                     end,
       
       A.BANKCODE = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.BANKCODE = B.BASIC_CODE
                               AND B.CODE_TYPE = ''bankcode''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.BANKCODE = B.BASIC_CODE
                           AND B.CODE_TYPE = ''bankcode''
                           AND B.COM_ID = 1)
                      else
                       a.bankcode
                    end,
       
       A.POLICYTYPE = case
                        when (SELECT B.TARGET_CODE
                                FROM T_DEF_CODE_MAPPING B
                               WHERE A.POLICYTYPE = B.BASIC_CODE
                                 AND B.CODE_TYPE = ''policytype''
                                 AND B.COM_ID = 1) is not null then
                         (SELECT B.TARGET_CODE
                            FROM T_DEF_CODE_MAPPING B
                           WHERE A.POLICYTYPE = B.BASIC_CODE
                             AND B.CODE_TYPE = ''policytype''
                             AND B.COM_ID = 1)
                        else
                         a.policytype
                      end,
       
       A.DISTRIBCHNL = case
                         when (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.DISTRIBCHNL = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''distribchnl''
                                  AND B.COM_ID = 1) is not null then
                          (SELECT B.TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE A.DISTRIBCHNL = B.BASIC_CODE
                              AND B.CODE_TYPE = ''distribchnl''
                              AND B.COM_ID = 1)
                         else
                          a.distribchnl
                       end,
       A.TERMINATIONREASON = case
                               when (SELECT B.TARGET_CODE
                                       FROM T_DEF_CODE_MAPPING B
                                      WHERE A.TERMINATIONREASON = B.BASIC_CODE
                                        AND B.CODE_TYPE = ''terminationreason''
                                        AND B.COM_ID = 1) is not null then
                                (SELECT B.TARGET_CODE
                                   FROM T_DEF_CODE_MAPPING B
                                  WHERE A.TERMINATIONREASON = B.BASIC_CODE
                                    AND B.CODE_TYPE = ''terminationreason''
                                    AND B.COM_ID = 1)
                               else
                                a.terminationreason
                             end
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12438;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12439 IS   V_ID NUMBER :=12439;  V_SQL_ID NUMBER :=12439;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE  FROM T_PRP_LCBnf where transactionno in (select transactionno from T_PRP_LCPolTransaction where transdate between to_date(''#{startDate}'', ''yyyy-mm-dd'') and to_date(''#{endDate}'', ''yyyy-mm-dd''))
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12439;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12440 IS   V_ID NUMBER :=12440;  V_SQL_ID NUMBER :=12440;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE  FROM T_PRP_LCCont where transactionno in (select transactionno from T_PRP_LCPolTransaction where transdate between to_date(''#{startDate}'', ''yyyy-mm-dd'') and to_date(''#{endDate}'', ''yyyy-mm-dd''))
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12440;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12443 IS   V_ID NUMBER :=12443;  V_SQL_ID NUMBER :=12443;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LMPRODUCT A
   SET A.INSUACCFLAG = (CASE
                         WHEN A.INSUACCFLAG IN
                              (SELECT BASIC_CODE
                                 FROM T_DEF_CODE_MAPPING
                                WHERE CODE_TYPE = ''insuaccflag''
                                  AND COM_ID = ''1'') THEN
                          (SELECT TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE B.CODE_TYPE = ''insuaccflag''
                              AND A.INSUACCFLAG = B.BASIC_CODE
                              AND B.COM_ID = ''1'')
                         ELSE
                          A.INSUACCFLAG
                       END),
       A.PRODUCTTYPE = (CASE
                         WHEN A.PRODUCTTYPE IN
                              (SELECT BASIC_CODE
                                 FROM T_DEF_CODE_MAPPING
                                WHERE CODE_TYPE = ''producttype''
                                  AND COM_ID = ''1'') THEN
                          (SELECT DISTINCT TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE B.CODE_TYPE = ''producttype''
                              AND A.PRODUCTTYPE = B.BASIC_CODE
                              AND B.COM_ID = ''1'')
                         ELSE
                          A.PRODUCTTYPE
                       END),
       A.INVESTMENTTYPE = (CASE
                            WHEN A.INVESTMENTTYPE IN
                                 (SELECT BASIC_CODE
                                    FROM T_DEF_CODE_MAPPING
                                   WHERE CODE_TYPE = ''investmenttype''
                                     AND COM_ID = ''1'') THEN
                             (SELECT TARGET_CODE
                                FROM T_DEF_CODE_MAPPING B
                               WHERE B.CODE_TYPE = ''investmenttype''
                                 AND A.INVESTMENTTYPE = B.BASIC_CODE
                                 AND B.COM_ID = ''1'')
                            ELSE
                             A.INVESTMENTTYPE
                          END),
       A.TERMTYPE = (CASE
                      WHEN A.TERMTYPE IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING
                                           WHERE CODE_TYPE = ''termtype''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''termtype''
                           AND A.TERMTYPE = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.TERMTYPE
                    END),
       A.GPFLAG = (CASE
                    WHEN A.GPFLAG IN (SELECT BASIC_CODE
                                        FROM T_DEF_CODE_MAPPING
                                       WHERE CODE_TYPE = ''gpflag''
                                         AND COM_ID = ''1'') THEN
                     (SELECT TARGET_CODE
                        FROM T_DEF_CODE_MAPPING B
                       WHERE B.CODE_TYPE = ''gpflag''
                         AND A.GPFLAG = B.BASIC_CODE
                         AND B.COM_ID = ''1'')
                    ELSE
                     A.GPFLAG
                  END),
       A.MAINPRODUCTFLAG = (CASE
                             WHEN A.MAINPRODUCTFLAG IN
                                  (SELECT BASIC_CODE
                                     FROM T_DEF_CODE_MAPPING
                                    WHERE CODE_TYPE = ''mainproductflag''
                                      AND COM_ID = ''1'') THEN
                              (SELECT TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE B.CODE_TYPE = ''mainproductflag''
                                  AND A.MAINPRODUCTFLAG = B.BASIC_CODE
                                  AND B.COM_ID = ''1'')
                             ELSE
                              A.MAINPRODUCTFLAG
                           END),
       A.SALEFLAG = (CASE
                      WHEN A.SALEFLAG IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING
                                           WHERE CODE_TYPE = ''saleflag''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''v''
                           AND A.SALEFLAG = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.SALEFLAG
                    END)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12443;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12444 IS   V_ID NUMBER :=12444;  V_SQL_ID NUMBER :=12444;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE  FROM T_PRP_LCInsureAcc where transactionno in (select transactionno from T_PRP_LCPolTransaction where transdate between to_date(''#{startDate}'', ''yyyy-mm-dd'') and
       to_date(''#{endDate}'', ''yyyy-mm-dd''))
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12444;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12452 IS   V_ID NUMBER :=12452;  V_SQL_ID NUMBER :=12452;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE  FROM T_PRP_LJAGetLivBene where transactionno in (select transactionno from T_PRP_LCPolTransaction where transdate between to_date(''#{startDate}'', ''yyyy-mm-dd'') and to_date(''#{endDate}'', ''yyyy-mm-dd''))
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12452;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12441 IS   V_ID NUMBER :=12441;  V_SQL_ID NUMBER :=12441;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='


select ''000031''||to_char(sysdate,''yyyymmdd'') ||lpad(rownum,10,''0'') TransactionNo,
       ''000031'' CompanyCode,
       hm.riskcode ProductCode,
       hm.riskname ProductName,
       hm.riskshortname ProductAbbr,
       '''' ProductEnName,
       '''' PorductEnAbbr,
       ''N'' InsuAccFlag,
       0 AssumIntRate,
       ''15000'' ProductType,
       ''999'' InvestmentType,
       ''21'' TermType,
       ''01'' GPFlag,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''mainproductflag'' and ORIGINCODE=hm.subriskflag) MainProductFlag,
       hm.enddate StopDate,
       (case when hm.enddate is null then ''Y'' else ''N'' end) SaleFlag,
       '''' CircRiskCode,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from   ODS_STG.HNW_hmrisk hm where 1 = 1
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12441;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12456 IS   V_ID NUMBER :=12456;  V_SQL_ID NUMBER :=12456;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE  FROM T_PRP_LJTempFee where transactionno in (select transactionno from T_PRP_LCPolTransaction where transdate between to_date(''#{startDate}'', ''yyyy-mm-dd'') and to_date(''#{endDate}'', ''yyyy-mm-dd''))
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12456;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12458 IS   V_ID NUMBER :=12458;  V_SQL_ID NUMBER :=12458;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE  FROM T_PRP_CHG_TRANS_ID_MAP where transno IN (select transactionno from T_PRP_LCPolTransaction where transdate between to_date(''#{startDate}'', ''yyyy-mm-dd'') and to_date(''#{endDate}'', ''yyyy-mm-dd''))
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12458;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12470 IS   V_ID NUMBER :=12470;  V_SQL_ID NUMBER :=12470;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LASALES A
   SET A.COMPANYCODE = case
                         when (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.COMPANYCODE = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''companycode''
                                  AND B.COM_ID = 1) is not null then
                          (SELECT B.TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE A.COMPANYCODE = B.BASIC_CODE
                              AND B.CODE_TYPE = ''companycode''
                              AND B.COM_ID = 1)
                         else
                          a.companycode
                       end,
       
       A.SEX = case
                 when (SELECT B.TARGET_CODE
                         FROM T_DEF_CODE_MAPPING B
                        WHERE A.SEX = B.BASIC_CODE
                          AND B.CODE_TYPE = ''sex''
                          AND B.COM_ID = 1) is not null then
                  (SELECT B.TARGET_CODE
                     FROM T_DEF_CODE_MAPPING B
                    WHERE A.SEX = B.BASIC_CODE
                      AND B.CODE_TYPE = ''sex''
                      AND B.COM_ID = 1)
                 else
                  a.sex
               end,
       
       A.OFFICEWORKFLAG = case
                            when (SELECT B.TARGET_CODE
                                    FROM T_DEF_CODE_MAPPING B
                                   WHERE A.OFFICEWORKFLAG = B.BASIC_CODE
                                     AND B.CODE_TYPE = ''officeworkflag''
                                     AND B.COM_ID = 1) is not null then
                             (SELECT B.TARGET_CODE
                                FROM T_DEF_CODE_MAPPING B
                               WHERE A.OFFICEWORKFLAG = B.BASIC_CODE
                                 AND B.CODE_TYPE = ''officeworkflag''
                                 AND B.COM_ID = 1)
                            else
                             a.officeworkflag
                          end,
       
       A.AGENTSIGNFLAG = case
                           when (SELECT B.TARGET_CODE
                                   FROM T_DEF_CODE_MAPPING B
                                  WHERE A.AGENTSIGNFLAG = B.BASIC_CODE
                                    AND B.CODE_TYPE = ''agentsignflag''
                                    AND B.COM_ID = 1) is not null then
                            (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.AGENTSIGNFLAG = B.BASIC_CODE
                                AND B.CODE_TYPE = ''agentsignflag''
                                AND B.COM_ID = 1)
                           else
                            a.agentsignflag
                         end,
       
       A.FULLTIMEFLAG = case
                          when (SELECT B.TARGET_CODE
                                  FROM T_DEF_CODE_MAPPING B
                                 WHERE A.FULLTIMEFLAG = B.BASIC_CODE
                                   AND B.CODE_TYPE = ''fulltimeflag''
                                   AND B.COM_ID = 1) is not null then
                           (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.FULLTIMEFLAG = B.BASIC_CODE
                               AND B.CODE_TYPE = ''fulltimeflag''
                               AND B.COM_ID = 1)
                          else
                           a.fulltimeflag
                        end,
       
       A.SALESVCFLAG = case
                         when (SELECT B.TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE A.SALESVCFLAG = B.BASIC_CODE
                                  AND B.CODE_TYPE = ''salesvcflag''
                                  AND B.COM_ID = 1) is not null then
                          (SELECT B.TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE A.SALESVCFLAG = B.BASIC_CODE
                              AND B.CODE_TYPE = ''salesvcflag''
                              AND B.COM_ID = 1)
                         else
                          a.salesvcflag
                       end,
       
       A.MANAGECOM = case
                       when (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.MANAGECOM = B.BASIC_CODE
                                AND B.CODE_TYPE = ''managecom''
                                AND B.COM_ID = 1) is not null then
                        (SELECT B.TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE A.MANAGECOM = B.BASIC_CODE
                            AND B.CODE_TYPE = ''managecom''
                            AND B.COM_ID = 1)
                       else
                        a.managecom
                     end,
       
       A.AGENTCODE = case
                       when (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.AGENTCODE = B.BASIC_CODE
                                AND B.CODE_TYPE = ''agentcode''
                                AND B.COM_ID = 1) is not null then
                        (SELECT B.TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE A.AGENTCODE = B.BASIC_CODE
                            AND B.CODE_TYPE = ''agentcode''
                            AND B.COM_ID = 1)
                       else
                        a.agentcode
                     end,
       
       A.CERTTYPE = case
                      when (SELECT B.TARGET_CODE
                              FROM T_DEF_CODE_MAPPING B
                             WHERE A.CERTTYPE = B.BASIC_CODE
                               AND B.CODE_TYPE = ''certtype''
                               AND B.COM_ID = 1) is not null then
                       (SELECT B.TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE A.CERTTYPE = B.BASIC_CODE
                           AND B.CODE_TYPE = ''certtype''
                           AND B.COM_ID = 1)
                      else
                       a.certtype
                    end
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12470;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12474 IS   V_ID NUMBER :=12474;  V_SQL_ID NUMBER :=12474;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LLBNF A
   SET A.BNFCAT = (CASE
                    WHEN A.BNFCAT IN (SELECT BASIC_CODE
                                        FROM T_DEF_CODE_MAPPING B
                                       WHERE CODE_TYPE = ''bnfcat''
                                         AND COM_ID = ''1'') THEN
                     (SELECT TARGET_CODE
                        FROM T_DEF_CODE_MAPPING B
                       WHERE B.CODE_TYPE = ''bnfcat''
                         AND A.BNFCAT = B.BASIC_CODE
                         AND B.COM_ID = ''1'')
                    ELSE
                     A.BNFCAT
                  END),
       A.RELATIONTOINSURED = (CASE
                      WHEN A.RELATIONTOINSURED IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING B
                                           WHERE CODE_TYPE = ''relationtoinsured''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''relationtoinsured''
                           AND A.RELATIONTOINSURED = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.RELATIONTOINSURED
                    END),
                    A.BNFLEVEL = (CASE
                      WHEN A.BNFLEVEL IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING B
                                           WHERE CODE_TYPE = ''bnflevel''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''bnflevel''
                           AND A.BNFLEVEL = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.BNFLEVEL
                    END),
       A.SEX = (CASE
                 WHEN A.SEX IN (SELECT BASIC_CODE
                                  FROM T_DEF_CODE_MAPPING B
                                 WHERE CODE_TYPE = ''sex''
                                   AND COM_ID = ''1'') THEN
                  (SELECT TARGET_CODE
                     FROM T_DEF_CODE_MAPPING B
                    WHERE B.CODE_TYPE = ''sex''
                      AND A.SEX = B.BASIC_CODE
                      AND B.COM_ID = ''1'')
                 ELSE
                  A.SEX
               END),
       A.CERTTYPE = (CASE
                      WHEN A.CERTTYPE IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING B
                                           WHERE CODE_TYPE = ''certtype''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''certtype''
                           AND A.CERTTYPE = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.CERTTYPE
                    END),
       A.RELATIONOFPAYEEANDINSURED = (CASE
                                       WHEN A.RELATIONOFPAYEEANDINSURED IN
                                            (SELECT BASIC_CODE
                                               FROM T_DEF_CODE_MAPPING B
                                              WHERE CODE_TYPE =
                                                    ''relationtoinsured''
                                                AND COM_ID = ''1'') THEN
                                        (SELECT TARGET_CODE
                                           FROM T_DEF_CODE_MAPPING B
                                          WHERE B.CODE_TYPE =
                                                ''relationtoinsured''
                                            AND A.RELATIONOFPAYEEANDINSURED =
                                                B.BASIC_CODE
                                            AND B.COM_ID = ''1'')
                                       ELSE
                                        A.RELATIONOFPAYEEANDINSURED
                                     END),
       A.PAYEESEX = (CASE
                      WHEN A.PAYEESEX IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING B
                                           WHERE CODE_TYPE = ''sex''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''sex''
                           AND A.PAYEESEX = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.PAYEESEX
                    END),
       A.PAYEECERTTYPE = (CASE
                           WHEN A.PAYEECERTTYPE IN
                                (SELECT BASIC_CODE
                                   FROM T_DEF_CODE_MAPPING B
                                  WHERE CODE_TYPE = ''certtype''
                                    AND COM_ID = ''1'') THEN
                            (SELECT TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE B.CODE_TYPE = ''certtype''
                                AND A.PAYEECERTTYPE = B.BASIC_CODE
                                AND B.COM_ID = ''1'')
                           ELSE
                            A.PAYEECERTTYPE
                         END),
       A.BENEFITWDMTHD = (CASE
                           WHEN A.BENEFITWDMTHD IN
                                (SELECT BASIC_CODE
                                   FROM T_DEF_CODE_MAPPING B
                                  WHERE CODE_TYPE = ''benefitwdmthd''
                                    AND COM_ID = ''1'') THEN
                            (SELECT TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE B.CODE_TYPE = ''benefitwdmthd''
                                AND A.BENEFITWDMTHD = B.BASIC_CODE
                                AND B.COM_ID = ''1'')
                           ELSE
                            A.BENEFITWDMTHD
                         END),
       A.BENEFITPAYMTHD = (CASE
                            WHEN A.BENEFITPAYMTHD IN
                                 (SELECT BASIC_CODE
                                    FROM T_DEF_CODE_MAPPING B
                                   WHERE CODE_TYPE = ''payway''
                                     AND COM_ID = ''1'') THEN
                             (SELECT TARGET_CODE
                                FROM T_DEF_CODE_MAPPING B
                               WHERE B.CODE_TYPE = ''payway''
                                 AND A.BENEFITPAYMTHD = B.BASIC_CODE
                                 AND B.COM_ID = ''1'')
                            ELSE
                             A.BENEFITPAYMTHD
                          END),
       A.BANKCODE = (CASE
                      WHEN A.BANKCODE IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING B
                                           WHERE CODE_TYPE = ''bankcode''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''bankcode''
                           AND A.BANKCODE = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.BANKCODE
                    END),
       A.TRANSACTIONNO = (CASE
                            WHEN A.TRANSACTIONNO IN
                                 (SELECT C.CHGID
                                    FROM T_PRP_CHG_TRANS_ID_MAP C
                                 ) THEN
                             (SELECT Max(C.TRANSNO)
                                FROM  T_PRP_CHG_TRANS_ID_MAP C
                                 WHERE A.TRANSACTIONNO = C.CHGID
                             )
                            ELSE
                             A.TRANSACTIONNO
                          END)

'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12474;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12475 IS   V_ID NUMBER :=12475;  V_SQL_ID NUMBER :=12475;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''01'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       hc.prtno PrtNo,
       h1.managecom ManageCom,
       h1.payno ReceiptNo,
       h1.sumactupaymoney PayAmnt,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''currency'' and ORIGINCODE=hc1.currency) Currency,
       h1.enteraccdate EnterAccDate,
       h1.confdate RecogDate,
       hc.bankcode BankCode,
       (select bankname from ODS_STG.HNW_ldbank where bankcode=hc.bankcode) BankName,
       hc.bankaccno BankAccNo,
       hc.accname AccName,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) CertType,
       hc.idno CertNo,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
left join ODS_STG.HNW_hcgrpcont hc1 on hc.grpcontno=hc1.grpcontno
where 1=1 and (h1.othernotype=''1'' and h1.tempfeetype=''8'') and  h1.conttype=''1'' 
     and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

union all
--新单（续期）

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''02'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       hc.prtno PrtNo,
       h1.managecom ManageCom,
       h1.payno ReceiptNo,
       h1.sumactupaymoney PayAmnt,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''currency'' and ORIGINCODE=hc1.currency) Currency,
       h1.enteraccdate EnterAccDate,
       h1.confdate RecogDate,
       hc.bankcode BankCode,
       (select bankname from ODS_STG.HNW_ldbank where bankcode=hc.bankcode) BankName,
       hc.bankaccno BankAccNo,
       hc.accname AccName,
        (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) CertType,
       hc.idno CertNo,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
left join ODS_STG.HNW_hcgrpcont hc1 on hc.grpcontno=hc1.grpcontno
where 1=1 and (h1.othernotype in (''1'', ''2'') and h1.tempfeetype=''9'') and h1.conttype=''1''  
      and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

union all

--保全收费(非定结)

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''03'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       hc.prtno PrtNo,
       h1.managecom ManageCom,
       h1.payno ReceiptNo,
       h1.sumactupaymoney PayAmnt,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''currency'' and ORIGINCODE=hc1.currency) Currency,
       h1.enteraccdate EnterAccDate,
       h1.confdate RecogDate,
       hc.bankcode BankCode,
       (select bankname from ODS_STG.HNW_ldbank where bankcode=hc.bankcode) BankName,
       hc.bankaccno BankAccNo,
       hc.accname AccName,
        (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) CertType,
       hc.idno CertNo,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate

from ODS_STG.HNW_hjapay h1
inner join (select endorno, grpcontno, contno,feefinatype as feefinatype,sum(getmoney) as sumactupaymoney
  from ODS_STG.HNW_hejsgetendorse
 group by endorno, grpcontno, contno,feefinatype) h2 on h1.otherno=h2.endorno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
left join ODS_STG.HNW_hcgrpcont hc1 on hc.grpcontno=hc1.grpcontno
where (h1.othernotype = ''2'' and h1.incometype = ''0'')  and h1.conttype=''1'' 
      and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12475;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12476 IS   V_ID NUMBER :=12476;  V_SQL_ID NUMBER :=12476;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LJTEMPFEE A
   SET A.CURRENCY = (CASE
                      WHEN A.CURRENCY IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING
                                           WHERE CODE_TYPE = ''currency''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''currency''
                           AND A.CURRENCY = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.CURRENCY
                    END),
       A.BANKCODE = (CASE
                      WHEN A.BANKCODE IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING
                                           WHERE CODE_TYPE = ''bankcode''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''bankcode''
                           AND A.BANKCODE = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.BANKCODE
                    END),
       A.CERTTYPE = (CASE
                      WHEN A.CERTTYPE IN (SELECT BASIC_CODE
                                            FROM T_DEF_CODE_MAPPING
                                           WHERE CODE_TYPE = ''certtype''
                                             AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''certtype''
                           AND A.CERTTYPE = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.CERTTYPE
                    END), A.MANAGECOM = CASE
                       WHEN (SELECT B.TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE A.MANAGECOM = B.BASIC_CODE
                                AND B.CODE_TYPE = ''managecom''
                                AND B.COM_ID = 1) IS NOT NULL THEN
                        (SELECT B.TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE A.MANAGECOM = B.BASIC_CODE
                            AND B.CODE_TYPE = ''managecom''
                            AND B.COM_ID = 1)
                       ELSE
                        A.MANAGECOM
                     END,
       A.TRANSACTIONNO = (CASE
                            WHEN A.TRANSACTIONNO IN
                                 (SELECT C.CHGID
                                    FROM T_PRP_CHG_TRANS_ID_MAP C
                                 ) THEN
                             (SELECT Max(C.TRANSNO)
                                FROM  T_PRP_CHG_TRANS_ID_MAP C
                                 WHERE A.TRANSACTIONNO = C.CHGID
                             )
                            ELSE
                             A.TRANSACTIONNO
                          END)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12476;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12422 IS   V_ID NUMBER :=12422;  V_SQL_ID NUMBER :=12422;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''01'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=h2.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       h1.payno PayNo,
       hc2.polno ProductNo,
       hc2.riskcode ProductCode,
       h1.managecom ManageCom,
       h1.appntno AppntNo,
       h1.sumactupaymoney SumActuPayMoney,
       h1.enteraccdate EnterAccDate,
       h1.confdate ConfDate,
       h1.paydate CurPaidToDate,
       hc.bankcode BankCode,
       (select bankname from ODS_STG.HNW_ldbank where bankcode=hc.bankcode) BankName,
       hc.bankaccno BankAccNo,
       hc.accname AccName,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) CertType,
       hc.idno CertNo,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
left join ODS_STG.HNW_hcpol hc2 on hc.grpcontno=hc2.grpcontno and hc.contno=hc2.contno
where 1=1 and h1.othernotype=''1'' and h1.tempfeetype=''8''  and h1.conttype=''1'' 
          and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

union all
--新单（续期）

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''02'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=h2.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       h1.payno PayNo,
       hc2.polno ProductNo,
       hc2.riskcode ProductCode,
       h1.managecom ManageCom,
       h1.appntno AppntNo,
       h1.sumactupaymoney SumActuPayMoney,
       h1.enteraccdate EnterAccDate,
       h1.confdate ConfDate,
       h1.paydate CurPaidToDate,
       hc.bankcode BankCode,
       (select bankname from ODS_STG.HNW_ldbank where bankcode=hc.bankcode) BankName,
       hc.bankaccno BankAccNo,
       hc.accname AccName,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) CertType,
       hc.idno CertNo,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
left join ODS_STG.HNW_hcpol hc2 on hc.grpcontno=hc2.grpcontno and hc.contno=hc2.contno
where 1=1 and (h1.othernotype in (''1'', ''2'') and h1.tempfeetype=''9'')   and h1.conttype=''1''
           and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

union all

--保全收费(非定结)

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''03'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       h1.payno PayNo,
       hc2.polno ProductNo,
       hc2.riskcode ProductCode,
       h1.managecom ManageCom,
       h1.appntno AppntNo,
       h1.sumactupaymoney SumActuPayMoney,
       h1.enteraccdate EnterAccDate,
       h1.confdate ConfDate,
       h1.paydate CurPaidToDate,
       hc.bankcode BankCode,
       (select bankname from ODS_STG.HNW_ldbank where bankcode=hc.bankcode) BankName,
       hc.bankaccno BankAccNo,
       hc.accname AccName,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''hidtype'' and ORIGINCODE=hc.idtype) CertType,
       hc.idno CertNo,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate

from ODS_STG.HNW_hjapay h1
inner join (select endorno, grpcontno, contno,feefinatype as feefinatype,sum(getmoney) as sumactupaymoney
  from ODS_STG.HNW_hejsgetendorse
 group by endorno, grpcontno, contno,feefinatype) h2 on h1.otherno=h2.endorno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
left join ODS_STG.HNW_hcpol hc2 on hc.grpcontno=hc2.grpcontno and hc.contno=hc2.contno
where (h1.othernotype = ''2'' and h1.incometype = ''0'')  and h1.conttype=''1'' 
      and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')


'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12422;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12426 IS   V_ID NUMBER :=12426;  V_SQL_ID NUMBER :=12426;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='
--新单(承保)

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''01'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=h2.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       hc1.polno ProductNo,
       hc.insuredno InsuredNo,
       '''' CustomerNo,
       h1.managecom ManageCom,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
inner join ODS_STG.HNW_hcpol hc1 on hc.grpcontno=hc1.grpcontno and hc.contno=hc1.contno
where 1=1 and (h1.othernotype=''1'' and h1.tempfeetype=''8'') and  h1.conttype=''1'' 
           and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

union all
--新单（续期）

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''02'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=h2.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       hc1.polno ProductNo,
       hc.insuredno InsuredNo,
       '''' CustomerNo,
       h1.managecom ManageCom,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate
       
from ODS_STG.HNW_hjapay h1
inner join ODS_STG.HNW_hjapaycont h2 on h2.payno=h1.payno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
inner join ODS_STG.HNW_hcpol hc1 on hc.grpcontno=hc1.grpcontno and hc.contno=hc1.contno
where 1=1 and (h1.othernotype in (''1'', ''2'') and h1.tempfeetype=''9'') and h1.conttype=''1''  
      and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
      
union all

--保全收费(非定结)

select ''P''||substr(h1.payno,12)||substr(h2.contno,11)||''03'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       hc1.polno ProductNo,
       hc.insuredno InsuredNo,
       '''' CustomerNo,
       h1.managecom ManageCom,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate

from ODS_STG.HNW_hjapay h1
inner join (select endorno, grpcontno, contno,feefinatype as feefinatype,sum(getmoney) as sumactupaymoney
  from ODS_STG.HNW_hejsgetendorse
 group by endorno, grpcontno, contno,feefinatype) h2 on h1.otherno=h2.endorno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
inner join ODS_STG.HNW_hcpol hc1 on hc.grpcontno=hc1.grpcontno and hc.contno=hc1.contno
where(h1.othernotype = ''2'' and h1.incometype = ''0'')  and h1.conttype=''1'' 
      and h1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
      
union all
--保全付费（非定结）

select ''G''||substr(hj1.actugetno,12)||substr(h2.contno,11)||''04'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=hc.comcode) CompanyCode,
       '''' GrpPolicyNo,
       h2.contno PolicyNo,
       hc1.polno ProductNo,
       hc.insuredno InsuredNo,
       '''' CustomerNo,
       hj1.managecom ManageCom,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate

from ODS_STG.HNW_hjaget hj1
inner join (select endorno, grpcontno, contno,feefinatype as feefinatype,sum(getmoney) as sumactupaymoney
  from ODS_STG.HNW_hejsgetendorse 
 group by endorno, grpcontno, contno,feefinatype) h2 on hj1.otherno = h2.endorno
inner join ODS_STG.HNW_hcinsured hc on h2.grpcontno=hc.grpcontno and h2.contno=hc.contno
inner join ODS_STG.HNW_hcpol hc1 on hc.grpcontno=hc1.grpcontno and hc.contno=hc1.contno
where 1=1 and (hj1.othernotype = ''2'' and hj1.tempfeetype = ''4'') and hj1.conttype=''1'' 
and hj1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')

'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12426;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12427 IS   V_ID NUMBER :=12427;  V_SQL_ID NUMBER :=12427;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCPRODINSURELA A
   SET A.ManageCom = (CASE
                            WHEN A.ManageCom IN
                                 (SELECT BASIC_CODE
                                    FROM T_DEF_CODE_MAPPING
                                   WHERE CODE_TYPE = ''managecom''
                                   AND COM_ID = ''1'') THEN
                             (SELECT TARGET_CODE
                                FROM T_DEF_CODE_MAPPING B
                               WHERE B.CODE_TYPE = ''managecom''
                                 AND A.ManageCom = B.BASIC_CODE
                                 AND B.COM_ID = ''1'')
                            ELSE
                             A.ManageCom
                          END)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12427;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12446 IS   V_ID NUMBER :=12446;  V_SQL_ID NUMBER :=12446;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :='


select ''L''||substr(h1.clmno,2)||substr(hc.contno,11)||''05'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=h1.comcode) CompanyCode,
       h1.inputclmno ClmCaseNo,
       h1.inputclmno ClmRegisterNo,
       '''' GrpPolicyNo,
       h1.segment1 PolicyNo,
       h1.segment2 ProductNo,
       h1.applydate RgtDate,--立案日期
       h1.accidentdate LossOccurDate,
       '''' LossOccurLocation,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''accidentreason'' and ORIGINCODE=h1.accidentreason) LossOccurReason,
       h1.accidentdesc AccidentDesc,
       ''3'' BenefitType,
       h5.riskcode ProductCode,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''currency'' and ORIGINCODE=h1.paycurrency) Currency,
       h1.clmamt ClmAcountAmnt,
       h1.clmamt ClmAssessAmnt,
       0 RejectAmnt,
       0 PrePayAmnt,
       0 ApproveAmnt,
       0 AgreeAmnt,
       h1.endcasedate ClmSettDate,
       ''01'' PayStatusCode,
       h1.mngcom ManageCom,
       to_date(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') MakeDate

from ODS_STG.HNW_hlclaim h1
inner join ODS_STG.HNW_hcinsured hc
    on h1.segment1 = hc.contno
left join ODS_STG.HNW_hcpol h5 on hc.grpcontno=h5.grpcontno and hc.contno=h5.contno 
left join ODS_STG.HNW_hcgrpcont h on h.grpcontno=h1.policyno
where 1=1 and h1.conttype=''1'' and h1.endcasedate  BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')




'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12446;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12447 IS   V_ID NUMBER :=12447;  V_SQL_ID NUMBER :=12447;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LLCLAIMPOLICY A
   SET A.MANAGECOM = (CASE
                       WHEN A.MANAGECOM IN
                            (SELECT BASIC_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE CODE_TYPE = ''managecom''
                                AND COM_ID = ''1'') THEN
                        (SELECT TARGET_CODE
                           FROM T_DEF_CODE_MAPPING B
                          WHERE B.CODE_TYPE = ''managecom''
                            AND A.MANAGECOM = B.BASIC_CODE
                            AND B.COM_ID = ''1'')
                       ELSE
                        A.MANAGECOM
                     END),
       A.PAYSTATUSCODE = (CASE
                           WHEN A.PAYSTATUSCODE IN
                                (SELECT BASIC_CODE
                                   FROM T_DEF_CODE_MAPPING
                                  WHERE CODE_TYPE = ''paystatuscode''
                                    AND COM_ID = ''1'') THEN
                            (SELECT TARGET_CODE
                               FROM T_DEF_CODE_MAPPING B
                              WHERE B.CODE_TYPE = ''paystatuscode''
                                AND A.PAYSTATUSCODE = B.BASIC_CODE
                                AND B.COM_ID = ''1'')
                           ELSE
                            A.PAYSTATUSCODE
                         END),
       A.CURRENCY = (CASE
                      WHEN A.CURRENCY IN
                           (SELECT BASIC_CODE
                              FROM T_DEF_CODE_MAPPING
                             WHERE CODE_TYPE = ''currency''
                               AND COM_ID = ''1'') THEN
                       (SELECT TARGET_CODE
                          FROM T_DEF_CODE_MAPPING B
                         WHERE B.CODE_TYPE = ''currency''
                           AND A.CURRENCY = B.BASIC_CODE
                           AND B.COM_ID = ''1'')
                      ELSE
                       A.CURRENCY
                    END),
       A.BENEFITTYPE = (CASE
                         WHEN A.BENEFITTYPE IN
                              (SELECT BASIC_CODE
                                 FROM T_DEF_CODE_MAPPING
                                WHERE CODE_TYPE = ''benefittype''
                                  AND COM_ID = ''1'') THEN
                          (SELECT TARGET_CODE
                             FROM T_DEF_CODE_MAPPING B
                            WHERE B.CODE_TYPE = ''benefittype''
                              AND A.BENEFITTYPE = B.BASIC_CODE
                              AND B.COM_ID = ''1'')
                         ELSE
                          A.BENEFITTYPE
                       END),
       A.LOSSOCCURREASON = (CASE
                             WHEN A.LOSSOCCURREASON IN
                                  (SELECT BASIC_CODE
                                     FROM T_DEF_CODE_MAPPING
                                    WHERE CODE_TYPE = ''lossoccurreason''
                                      AND COM_ID = ''1'') THEN
                              (SELECT TARGET_CODE
                                 FROM T_DEF_CODE_MAPPING B
                                WHERE B.CODE_TYPE = ''lossoccurreason''
                                  AND A.LOSSOCCURREASON = B.BASIC_CODE
                                  AND B.COM_ID = ''1'')
                             ELSE
                              A.LOSSOCCURREASON
                           END)
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12447;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12437 IS   V_ID NUMBER :=12437;  V_SQL_ID NUMBER :=12437;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE  FROM T_PRP_LASales where transactionno in (select transactionno from T_PRP_LCPolTransaction where transdate between to_date(''#{startDate}'', ''yyyy-mm-dd'') and to_date(''#{endDate}'', ''yyyy-mm-dd''))
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12437;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12445 IS   V_ID NUMBER :=12445;  V_SQL_ID NUMBER :=12445;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE  FROM T_PRP_LCInsured where transactionno in (select transactionno from T_PRP_LCPolTransaction where transdate between to_date(''#{startDate}'', ''yyyy-mm-dd'') and to_date(''#{endDate}'', ''yyyy-mm-dd''))
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12445;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12455 IS   V_ID NUMBER :=12455;  V_SQL_ID NUMBER :=12455;  V_SQL_TYPE VARCHAR(20) := 'D';  V_SQL_INFO CLOB :='DELETE  FROM T_PRP_LAAgent where transactionno in (select transactionno from T_PRP_LCPolTransaction where transdate between to_date(''#{startDate}'', ''yyyy-mm-dd'') and to_date(''#{endDate}'', ''yyyy-mm-dd''))
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12455;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12823 IS   V_ID NUMBER :=12823;  V_SQL_ID NUMBER :=12855;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LMProduct'' AS TableName,       ''TransactionNo'' AS FieldName,       ''COUNT'' AS CheckType,       NVL((SELECT COUNT(1)          FROM T_PRP_LMProduct A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12823;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12791 IS   V_ID NUMBER :=12791;  V_SQL_ID NUMBER :=12823;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LLClaimPolicy'' AS TableName,       ''TransactionNo'' AS FieldName,       ''COUNT'' AS CheckType,       NVL((SELECT COUNT(1)          FROM T_PRP_LLClaimPolicy A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12791;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12792 IS   V_ID NUMBER :=12792;  V_SQL_ID NUMBER :=12824;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LLClaimPolicy'' AS TableName,        ''ClmAssessAmnt'' AS FieldName,        ''SUM'' AS CheckType,        NVL((SELECT SUM(A.ClmAssessAmnt)           FROM T_PRP_LLClaimPolicy A, T_PRP_LCPOLTRANSACTION B          WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12792;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12793 IS   V_ID NUMBER :=12793;  V_SQL_ID NUMBER :=12825;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LLBnf'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MIN'' AS CheckType,       NVL((SELECT MIN(a.TRANSACTIONNO)          FROM T_PRP_LLBnf a,t_Prp_Lcpoltransaction b          WHERE b.batchno = ''#{batchNo}''         AND a.transactionno = b.transactionno         AND b.STATEFLAG = ''5''),''null'')AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12793;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12794 IS   V_ID NUMBER :=12794;  V_SQL_ID NUMBER :=12826;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LLBnf'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MAX'' AS CheckType,       NVL((SELECT MAX(A.TRANSACTIONNO)          FROM T_PRP_LLBnf A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),''null'') AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12794;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12795 IS   V_ID NUMBER :=12795;  V_SQL_ID NUMBER :=12827;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LLBnf'' AS TableName,       ''TransactionNo'' AS FieldName,       ''COUNT'' AS CheckType,       NVL((SELECT COUNT(1)          FROM T_PRP_LLBnf A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12795;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12796 IS   V_ID NUMBER :=12796;  V_SQL_ID NUMBER :=12828;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LLBnf'' AS TableName,        ''DrawingAmnt'' AS FieldName,        ''SUM'' AS CheckType,        NVL((SELECT SUM(A.DrawingAmnt)           FROM T_PRP_LLBnf A, T_PRP_LCPOLTRANSACTION B          WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12796;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12797 IS   V_ID NUMBER :=12797;  V_SQL_ID NUMBER :=12829;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LASales'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MIN'' AS CheckType,       NVL((SELECT MIN(a.TRANSACTIONNO)          FROM T_PRP_LASales a,t_Prp_Lcpoltransaction b          WHERE b.batchno = ''#{batchNo}''         AND a.transactionno = b.transactionno         AND b.STATEFLAG = ''5''),''null'')AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12797;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12798 IS   V_ID NUMBER :=12798;  V_SQL_ID NUMBER :=12830;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LASales'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MAX'' AS CheckType,       NVL((SELECT MAX(A.TRANSACTIONNO)          FROM T_PRP_LASales A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),''null'') AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12798;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12799 IS   V_ID NUMBER :=12799;  V_SQL_ID NUMBER :=12831;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LASales'' AS TableName,       ''TransactionNo'' AS FieldName,       ''COUNT'' AS CheckType,       NVL((SELECT COUNT(1)          FROM T_PRP_LASales A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12799;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12790 IS   V_ID NUMBER :=12790;  V_SQL_ID NUMBER :=12822;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LLClaimPolicy'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MAX'' AS CheckType,       NVL((SELECT MAX(A.TRANSACTIONNO)          FROM T_PRP_LLClaimPolicy A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),''null'') AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12790;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12760 IS   V_ID NUMBER :=12760;  V_SQL_ID NUMBER :=12792;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='select ''PDL-Head'' as "PDL-Head",''PDL-Body'' as "PDL-Body" from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12760;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12761 IS   V_ID NUMBER :=12761;  V_SQL_ID NUMBER :=12793;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :=' select ''SummaryCheck'' as RequestType,''#{companyCode}'' as CompanyCode,''#{serialNo}'' as SerialNo,''#{dateSerialNo}'' as TimeStamp,''L'' as DataType from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12761;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12762 IS   V_ID NUMBER :=12762;  V_SQL_ID NUMBER :=12794;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='select ''D'' as PeriodType,
       ''20161109'' as PeriodValue,
       to_char(to_date(substr(''#{startDate}'',0,10), ''yyyy-mm-dd''),
               ''yyyymmdd'') as StartDate,
       to_char(to_date(substr(''#{endDate}'',0,10),''yyyy-mm-dd''),''yyyymmdd'') as EndDate,
       ''KPIset '' as KPIset
  from dual'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12762;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12763 IS   V_ID NUMBER :=12763;  V_SQL_ID NUMBER :=12795;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='select '''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM, '''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM, '''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM, '''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM, '''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM, '''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM,'''' AS ITEM FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12763;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12764 IS   V_ID NUMBER :=12764;  V_SQL_ID NUMBER :=12796;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCPolTransaction'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MIN'' AS CheckType,       NVL((SELECT MIN(b.TRANSACTIONNO)          FROM t_Prp_Lcpoltransaction b          WHERE b.batchno = ''#{batchNo}''         AND b.STATEFLAG = ''5''),''null'')AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12764;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12765 IS   V_ID NUMBER :=12765;  V_SQL_ID NUMBER :=12797;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCPolTransaction'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MAX'' AS CheckType,       NVL((SELECT MAX(B.TRANSACTIONNO)          FROM T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND B.STATEFLAG = ''5''),''null'') AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12765;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12766 IS   V_ID NUMBER :=12766;  V_SQL_ID NUMBER :=12798;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCPolTransaction'' AS TableName,       ''TransactionNo'' AS FieldName,       ''COUNT'' AS CheckType,       NVL((SELECT COUNT(1)          FROM T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12766;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12767 IS   V_ID NUMBER :=12767;  V_SQL_ID NUMBER :=12799;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCPolTransaction'' AS TableName,        ''SumActuGetMoney'' AS FieldName,        ''SUM'' AS CheckType,        NVL((SELECT SUM(B.TransAmnt)           FROM T_PRP_LCPOLTRANSACTION B          WHERE B.BATCHNO = ''#{batchNo}''           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12767;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12768 IS   V_ID NUMBER :=12768;  V_SQL_ID NUMBER :=12800;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCCont'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MIN'' AS CheckType,       NVL((SELECT MIN(a.TRANSACTIONNO)          FROM T_PRP_LCCont a,t_Prp_Lcpoltransaction b          WHERE b.batchno = ''#{batchNo}''         AND a.transactionno = b.transactionno         AND b.STATEFLAG = ''5''),''null'')AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12768;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12769 IS   V_ID NUMBER :=12769;  V_SQL_ID NUMBER :=12801;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCCont'' AS TableName,       ''TransactionNo'' AS FieldName,       ''MAX'' AS CheckType,       NVL((SELECT MAX(A.TRANSACTIONNO)          FROM T_PRP_LCCont A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),''null'') AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12769;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12770 IS   V_ID NUMBER :=12770;  V_SQL_ID NUMBER :=12802;  V_SQL_TYPE VARCHAR(20) := 'O';  V_SQL_INFO CLOB :='SELECT ''LCCont'' AS TableName,       ''TransactionNo'' AS FieldName,       ''COUNT'' AS CheckType,       NVL((SELECT COUNT(1)          FROM T_PRP_LCCont A, T_PRP_LCPOLTRANSACTION B         WHERE B.BATCHNO = ''#{batchNo}''           AND A.TRANSACTIONNO = B.TRANSACTIONNO           AND B.STATEFLAG = ''5''),0) AS Value  FROM DUAL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12770;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12851 IS   V_ID NUMBER :=12851;  V_SQL_ID NUMBER :=12891;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCCONT SET AccumPremium =0 WHERE AccumPremium IS NULL   
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12851;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12853 IS   V_ID NUMBER :=12853;  V_SQL_ID NUMBER :=12893;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCCONT SET premium = 0 WHERE premium IS NULL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12853;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12872 IS   V_ID NUMBER :=12872;  V_SQL_ID NUMBER :=12912;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCCONT
       SET city = ''''
     WHERE TRANSACTIONNO NOT IN
           (SELECT TRANSACTIONNO
              FROM T_PRP_LCCONT
             WHERE REGEXP_LIKE(city, ''(^[+-]?\d{0,}\.?\d{0,}$)''))'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12872;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12873 IS   V_ID NUMBER :=12873;  V_SQL_ID NUMBER :=12913;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_lcinsured SET OccupationType = ''0001001'' WHERE occupationtype IS NOT NULL AND LENGTH(occupationtype) <> 7'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12873;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12875 IS   V_ID NUMBER :=12875;  V_SQL_ID NUMBER :=12915;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_lcinsured SET country = ''156'' WHERE  country IS NULL OR country != ''156'''; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12875;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12876 IS   V_ID NUMBER :=12876;  V_SQL_ID NUMBER :=12916;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_lcinsured SET rgtaddress = regexp_replace(rgtaddress,''[|]'','''') WHERE  exists (SELECT ''X'' FROM T_PRP_lcinsured WHERE regexp_like(rgtaddress,''[|]''))'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12876;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12877 IS   V_ID NUMBER :=12877;  V_SQL_ID NUMBER :=12917;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_lcinsured SET insuredname = regexp_replace(insuredname,''[|]'','''')  WHERE  exists (SELECT ''X'' FROM T_PRP_lcinsured WHERE regexp_like(insuredname,''[|]''))'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12877;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12878 IS   V_ID NUMBER :=12878;  V_SQL_ID NUMBER :=12918;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_lcproduct SET InvalidDate = date ''9999-12-31'' WHERE InvalidDate IS NULL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12878;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12879 IS   V_ID NUMBER :=12879;  V_SQL_ID NUMBER :=12919;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_llbnf SET  PercentOfBenefit = 1 WHERE PercentOfBenefit IS NULL OR PercentOfBenefit = ''''
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12879;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12880 IS   V_ID NUMBER :=12880;  V_SQL_ID NUMBER :=12920;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_laagent SET Agencyname = ''AGCN-XX'' WHERE Agencyname IS NULL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12880;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12881 IS   V_ID NUMBER :=12881;  V_SQL_ID NUMBER :=12921;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_llbnf DrawingAmnt SET DrawingAmnt = 0 WHERE DrawingAmnt IS NULL
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12881;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12882 IS   V_ID NUMBER :=12882;  V_SQL_ID NUMBER :=12922;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_laagent SET SEX= ''9'' WHERE SEX IS NULL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12882;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12884 IS   V_ID NUMBER :=12884;  V_SQL_ID NUMBER :=12924;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_laagent SET BusiDevCertifNo = ''BDCN-00000'' WHERE BusiDevCertifNo IS NULL
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12884;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12885 IS   V_ID NUMBER :=12885;  V_SQL_ID NUMBER :=12925;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_laagent SET AgentSignFlag = ''Y'' WHERE AgentSignFlag IS NULL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12885;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12886 IS   V_ID NUMBER :=12886;  V_SQL_ID NUMBER :=12926;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_laagent SET agencycode = ''AGTC-00000'' WHERE agentcode IS NULL
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12886;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12887 IS   V_ID NUMBER :=12887;  V_SQL_ID NUMBER :=12927;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_ljaget SET CertType = ''111'' WHERE certtype = ''00'''; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12887;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12888 IS   V_ID NUMBER :=12888;  V_SQL_ID NUMBER :=12928;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_ljaget SET CertType = ''990'' WHERE CertType = ''04'''; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12888;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12889 IS   V_ID NUMBER :=12889;  V_SQL_ID NUMBER :=12929;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_laagent SET Agencycode = ''AGCC-00000'' WHERE Agencycode IS NULL
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12889;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12890 IS   V_ID NUMBER :=12890;  V_SQL_ID NUMBER :=12930;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :=' UPDATE T_PRP_llclaimpolicy SET ClmSettDate = RgtDate+1 WHERE ClmSettDate IS NULL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12890;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12891 IS   V_ID NUMBER :=12891;  V_SQL_ID NUMBER :=12931;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_lasales SET SaleSvcFlag = ''1'' WHERE SaleSvcFlag IS NULL'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12891;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12898 IS   V_ID NUMBER :=12898;  V_SQL_ID NUMBER :=12938;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_CHG_TRANS_ID_MAP a
   set a.transno = (case
                   
                     when ((select count(companycode)
                              from T_PRP_chg_trans_id_map
                             where dateserial = to_char(sysdate, ''yyyymmdd'')
                               and companycode = ''000000'') <> 0 and
                          companycode = ''000000'' and (select count(companycode)
                              from T_PRP_chg_trans_id_map
                             where dateserial = to_char(sysdate, ''yyyymmdd'')
                               and companycode = ''000031'')<>0) then
                      (''000031'' || to_char(SYSDATE, ''yyyymmdd'') ||
                      lpad(((select to_number(substr(max(TRANSNO), 15))
                                from T_PRP_chg_trans_id_map
                               where dateserial = to_char(sysdate, ''yyyymmdd'')
                                 and companycode = ''000031'') +
                            to_number(substr(a.TRANSNO, 15))),
                            ''10'',
                            ''0''))
                     else
                      a.transno
                   end),
       a.companycode = ''000031''
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12898;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12855 IS   V_ID NUMBER :=12855;  V_SQL_ID NUMBER :=12895;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCCONT SET Copies = 1 WHERE  Copies = 0
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12855;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12857 IS   V_ID NUMBER :=12857;  V_SQL_ID NUMBER :=12897;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCCONT SET Copies = 1 WHERE  Copies IS NULL
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12857;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12859 IS   V_ID NUMBER :=12859;  V_SQL_ID NUMBER :=12899;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCCONT
       SET STREET = REGEXP_REPLACE(STREET, ''[|]'', '''') WHERE 
                EXISTS (SELECT ''X'' FROM T_PRP_LCCONT WHERE REGEXP_LIKE(STREET, ''[|]''))'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12859;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12861 IS   V_ID NUMBER :=12861;  V_SQL_ID NUMBER :=12901;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCCONT SET uwdate = to_date(to_char(uwdate,''yyyy-mm-dd''),''yyyy-mm-dd'')'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12861;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12862 IS   V_ID NUMBER :=12862;  V_SQL_ID NUMBER :=12902;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCCONT SET APLMoney = 0 WHERE  APLMoney IS NULL
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12862;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12864 IS   V_ID NUMBER :=12864;  V_SQL_ID NUMBER :=12904;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCCONT SET TerminationReason = ''99'' WHERE TerminationReason = ''4'''; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12864;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12865 IS   V_ID NUMBER :=12865;  V_SQL_ID NUMBER :=12905;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCCONT SET CashValue = 0 WHERE  CashValue IS NULL
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12865;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12866 IS   V_ID NUMBER :=12866;  V_SQL_ID NUMBER :=12906;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCCONT SET AccumLoanMoney = 0 WHERE  AccumLoanMoney IS NULL
'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12866;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12867 IS   V_ID NUMBER :=12867;  V_SQL_ID NUMBER :=12907;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCCONT SET province = '''',city = '''',county = '''' WHERE province like ''%上海%'''; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12867;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12868 IS   V_ID NUMBER :=12868;  V_SQL_ID NUMBER :=12908;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_lcinsured SET Salary = 0 WHERE  Salary IS NULL OR Salary = '''''; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12868;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12869 IS   V_ID NUMBER :=12869;  V_SQL_ID NUMBER :=12909;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_LCCONT
       SET county = ''''
     WHERE TRANSACTIONNO NOT IN
           (SELECT TRANSACTIONNO
              FROM T_PRP_LCCONT
             WHERE REGEXP_LIKE(county, ''(^[+-]?\d{0,}\.?\d{0,}$)''))'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12869;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12870 IS   V_ID NUMBER :=12870;  V_SQL_ID NUMBER :=12910;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='UPDATE T_PRP_lcinsured SET OccupationType = ''2147003'' WHERE OccupationType IS NULL  or OccupationType = '''''; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12870;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/
CREATE OR REPLACE PROCEDURE PROC_12871 IS   V_ID NUMBER :=12871;  V_SQL_ID NUMBER :=12911;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :=' UPDATE T_PRP_LCCONT
       SET PROVINCE = ''''
     WHERE TRANSACTIONNO NOT IN
           (SELECT TRANSACTIONNO
              FROM T_PRP_LCCONT
             WHERE REGEXP_LIKE(PROVINCE, ''(^[+-]?\d{0,}\.?\d{0,}$)''))'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12871;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/--insert into about LCPolicyDeliveryRate procedure by kongweiqi 
CREATE OR REPLACE PROCEDURE PROC_12966 IS   V_ID NUMBER :=12966;  V_SQL_ID NUMBER :=12941;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :=' select  ''000031''||year||LPAD(ROWNUM,10,''0'') as  id,YEAR,POLICYNO,SOURCECODE,SOURCECODE2,to_date(APPDATE,''yyyy-mm-dd'') as APPDATE,to_date(UNDERDATE,''yyyy-mm-dd'') as UNDERDATE,channel,AGENTTYPE,ISRECIEPTOK,case when polRecieptDate=''0'' then nullwhen polRecieptDate is null then nullelseto_Date(POLRECIEPTDATE,''yyyy-mm-dd'') end  as POLRECIEPTDATE,COMPANYCODE,AREACODE,OPERATOR,MAKEDATE,MAKETIME,MODIFYDATE,MODIFYTIME from (SELECT  to_char(t.policy_issue_date,''yyyy'') as year,t.policy_no  as POLICYNO,--保单号,       t.policy_source  as SOURCECODE,--保单来源代码,       t.policy_source2 as  SOURCECODE2,-- 保单来源代码2,       t.channel_type as channel,-- 渠道类型,       ag.agent_type  as AGENTTYPE,--销售类型代码,       to_char(app.application_submit_date, ''yyyymmdd'')  as APPDATE ,--投保日期,       to_char(t.policy_issue_date, ''yyyymmdd'')as UNDERDATE ,-- 承保日期,       nvl2(ac.receipt_date, ''01'', ''00'')  as ISRECIEPTOK,--是否回执签收成功,       to_char(ac.receipt_date, ''yyyymmdd'')  as POLRECIEPTDATE,--保单签收回执日期,       ''000031''  as COMPANYCODE,--法人机构代码,       substr(ct.company_name,1,2) as AREACODE,--  保单归属机构, ''0'' AS OPERATOR,                   TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MAKEDATE,                   TO_CHAR(sysdate,''hh:mm:ss'') AS MAKETIME,                   TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MODIFYDATE,                   TO_CHAR(sysdate,''hh:mm:ss'') AS MODIFYTIME  FROM ODS_STG.OFE_t_policy t  left join ODS_STG.OFE_t_app_mst app    on app.policy_no = t.policy_no   and app.rc_state = ''E''  join (SELECT agt.policy_id,max(agt.agent_type) agent_type FROM ODS_STG.OFE_t_pol_agent_role agt    WHERE agt.agent_role = ''1''    and agt.agent_type not in (''BB'',''BK'',''SP'',''WD'')   and agt.rc_state = ''E'' group by agt.policy_id) ag on ag.policy_id = t.policy_id  left join ODS_STG.OFE_t_pol_acknowledgement ac    on ac.policy_no = t.policy_no   and ac.rc_state = ''E''  left join ODS_STG.OFE_t_cfg_company_map ct on ct.company_id = t.branch_code and ct.rc_state = ''E''  join ODS_STG.OFE_t_pol_plan tp on tp.policy_id = t.policy_id and (tp.terminal_cause not in (''4'',''17'') or tp.terminal_cause <> ''5'' or  tp.terminal_cause is null)  join ODS_STG.OFE_t_pd_product pd on pd.pd_product_id = tp.pd_product_id and pd.COVERAGE_TERM_TYPE <> ''M'' and pd.basic_product_flag = ''B'' and pd.rc_state = ''E'' WHERE t.rc_state = ''E'' and to_char(t.policy_issue_date,''yyyy'')=''?year?'' and not exists( SELECT 1 FROM ODS_STG.OFE_t_rls_policy rls WHERE rls.pno = t.policy_no and rls.flag = ''1'' ) union all SELECT   substr(pml.pdos,1,4) as year, to_char(pml.pno) as POLICYNO,--  保单号, '''' as SOURCECODE, to_char(pml.psour) as SOURCECODE2,-- 保单来源代码2, ''1'' as channel, to_char(ag.agtyp) as AGENTTYPE,-- 销售类型代码, to_char(pml.pdos) as APPDATE,-- 投保日期, to_char(pml.PDOI) as UNDERDATE,-- 承保日期,case when pml.pprptdt <> ''0'' then ''01'' else ''00'' end as ISRECIEPTOK, to_char(pml.PPRPTDT) as POLRECIEPTDATE, ''000031'' as COMPANYCODE,--法人机构代码, to_char(ct.province_cn)  as AREACODE,--保单归属机构,''0'' AS OPERATOR,                   TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MAKEDATE,                   TO_CHAR(sysdate,''hh:mm:ss'') AS MAKETIME,                   TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MODIFYDATE,                   TO_CHAR(sysdate,''hh:mm:ss'') AS MODIFYTIMEFROM ods_stg.rls_lfppml pml left join ODS_STG.ref_city ct on ct.policy_prefix =(CASE WHEN PML.PNO LIKE ''S%'' THEN ''501''                                                          WHEN PML.PNO LIKE ''G%'' THEN ''301''                                                          WHEN PML.PNO LIKE ''B%'' THEN ''101''                                                          ELSE TO_CHAR(SUBSTR(PML.PNO,1,3)) END) JOIN ODS_STG.RAS_AGPCONT AG ON AG.AGAGC=SUBSTR(PML.PPAGT1,-6) AND AG.INS_CODE=PML.INS_CODE                                                             WHERE substr(pml.pdos,1,4)=''?year?'' and (AG.agtyp not in (''BB'',''BK'',''SP'',''WD'') or ag.agtyp is null) and pml.pstu not in (''Z'',''C'') and exists( SELECT 1 FROM ODS_STG.OFE_t_rls_policy rls WHERE rls.pno = to_char(pml.pno) and rls.flag = ''1'' )) '; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12966;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/--LCReviewSuccessRateCREATE OR REPLACE PROCEDURE PROC_12967 IS   V_ID NUMBER :=12967;  V_SQL_ID NUMBER :=12942;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :=' select  ''000031''||to_char(sysdate,''yyyy'')||LPAD(ROWNUM,10,''0'') as  id,YEAR,POLICYNO,SOURCECODE,SOURCECODE2,CHANNEL,AGENTTYPE,to_date(UNDERDATE,''yyyy-mm-dd'') as UNDERDATE,to_date(POLRECIEPTDATE,''yyyy-mm-dd'')  as  POLRECIEPTDATE,to_date(HESITATEENDDATE,''yyyy-mm-dd'') as HESITATEENDDATE,ISRETURNVISIT,COMPANYCODE,AREACODE,to_date(RETURNVISITDATE,''yyyy-mm-dd'') as RETURNVISITDATE,RETURNVISITTYPE,OPERATOR,MAKEDATE,MAKETIME,MODIFYDATE,MODIFYTIME from (    select to_char(a.issure_date,''yyyy'') as year,   a.policy_code as POLICYNO ,-- 保单号 ,   '''' as SOURCECODE,   '''' as SOURCECODE2,       case when source_code = ''TDN'' then ''121''   -- 121 网销--工行--电话销售            when channel_name in (''新渠道'',''非工银保'',''工行银保'',''团险'',''银保'') then ''221''  -- 银保            when channel_name in (''个险经代'') then ''210''  -- 经代            when channel_name in (''理财顾问'',''个险'') then ''210''  -- 个险                          end as  CHANNEL ,--所属渠道,            '''' as AGENTTYPE,       to_char(a.issure_date,''yyyymmdd'')  as UNDERDATE,--  承保日期,       case when receipt_sign_date is null and QUESTION_COMPLETE_INCOOLING=''1'' then to_char(a.issure_date+1,''yyyymmdd'')                  else   to_char(a.receipt_sign_date,''yyyymmdd'') end  as POLRECIEPTDATE,  -- 保单签收回执日期,       case when receipt_sign_date is null and QUESTION_COMPLETE_INCOOLING=''1'' then to_char(a.issure_date+16,''yyyymmdd'')                  else   to_char(a.cooling_end_date,''yyyymmdd'') end   as HESITATEENDDATE,--犹豫期截止日期,       case when a.QUESTION_COMPLETE_INCOOLING=''0'' then ''00''             when a.QUESTION_COMPLETE_INCOOLING=''1'' then ''01'' end  as ISRETURNVISIT,-- 是否回访成功,       case when a.QUESTION_COMPLETE_INCOOLING=''0'' then null             when a.QUESTION_COMPLETE_INCOOLING=''1'' then to_char(a.QUESTION_COMPLETE_DATE, ''yyyymmdd'')        end  as RETURNVISITDATE,-- 回访成功日期,       ''01''  as RETURNVISITTYPE,--回访方式,       ''000031''   as COMPANYCODE,--法人机构代码,       a.branch_province as areacode,-- 监管辖区代码       ''SYS'' AS OPERATOR,         TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MAKEDATE,          TO_CHAR(sysdate,''hh:mm:ss'') AS MAKETIME,        TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MODIFYDATE,      TO_CHAR(sysdate,''hh:mm:ss'') AS MODIFYTIME  from ODS_STG.ccs_tbrptcw a where  to_char(a.issure_date,''yyyy'')=''?year?''   and a.policystatus in (''1'',''2'',''6'',''B'',''F'')) where UNDERDATE - POLRECIEPTDATE <=0  '; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12967;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/--LCClaimGetRateCREATE OR REPLACE PROCEDURE PROC_12968 IS   V_ID NUMBER :=12968;  V_SQL_ID NUMBER :=12943;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :=' select ''000031''||year||LPAD(ROWNUM,10,''0'') as  id,YEAR,CLAIMNO,(case when APPCLAIMDATE<REPORTDATE then to_date(APPCLAIMDATE,''yyyy-mm-dd'') else to_date(REPORTDATE,''yyyy-mm-dd'') end ) as REPORTDATE ,to_date(APPCLAIMDATE,''yyyy-mm-dd'') as APPCLAIMDATE,to_date(ENDCASEDATE,''yyyy-mm-dd'') as ENDCASEDATE,ENDCASETYPE,COMPANYCODE,AREACODE,OPERATOR,MAKEDATE,MAKETIME,MODIFYDATE,MODIFYTIME from (SELECT  to_char(cla.settle_date,''yyyy'') as year, cla.case_no as CLAIMNO ,-- 理赔赔案号,  NVL(NVL(TO_CHAR(APP.REGISTER_DATE, ''yyyymmdd''),                       TO_CHAR(REG.APPLY_DATE, ''yyyymmdd'')),                   TO_CHAR(REG.REGISTER_DATE, ''yyyymmdd'')) AS REPORTDATE, --报案日期,               NVL(TO_CHAR(REG.APPLY_DATE, ''yyyymmdd''),                   TO_CHAR(REG.REGISTER_DATE, ''yyyymmdd'')) AS APPCLAIMDATE, -- 理赔申请日期,                TO_CHAR(CLA.SETTLE_DATE, ''yyyymmdd'') AS ENDCASEDATE, --结案日期,       case         when cla.CASE_DECISION=''1'' then 01         when cla.CASE_DECISION=''2'' then 04         when cla.CASE_DECISION=''3'' then 02         when cla.CASE_DECISION=''4'' then 05       end  as ENDCASETYPE,--结案类型代码,        ''000031'' as COMPANYCODE,--法人机构代码,         substr(ct.company_name,1,2) as AREACODE,-- 保单归属机构,       ''SYS'' AS OPERATOR,                   TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MAKEDATE,                   TO_CHAR(sysdate,''hh:mm:ss'') AS MAKETIME,                   TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MODIFYDATE,                   TO_CHAR(sysdate,''hh:mm:ss'') AS MODIFYTIME  from ODS_STG.OFE_t_claim_case cla, ODS_STG.OFE_t_claim_register reg, ODS_STG.OFE_t_policy t,   ODS_STG.OFE_t_cfg_company_map ct,ODS_STG.OFE_t_claim_application app WHERE cla.rc_state = ''E''   and cla.claim_register_id=reg.claim_register_id   and t.policy_id = cla.policy_id   and ct.company_id = t.branch_code   and app.claim_application_id(+) = reg.claim_application_id    and t.rc_state = ''E''   and reg.register_type=''1''   and cla.case_decision in (''1'',''2'',''3'',''4'')   and to_char(cla.settle_date,''yyyy'')=''?year?''   and reg.rc_state = ''E''   and ct.rc_state = ''E''    and app.rc_state(+) = ''E''  UNION ALLselect * from ( SELECT  substr(CLM.CLDOT,1,4) as year, to_char(CLM.CLCLM) as CLAIMNO,-- 赔案号, to_char(CLM.CLDOC) as REPORTDATE,--报案日期, to_char(CLM.CLDOC) as APPCLAIMDATE,-- 理赔申请日期, to_char(CLM.CLDOT) as ENDCASEDATE,-- 结案日期,       CASE          WHEN to_char(clm.CLSTU)=''P'' AND CLM.CLLTER NOT IN (''05'',''96'',''97'',''98'',''99'') THEN 01         WHEN to_char(clm.CLSTU)=''P'' AND CLM.CLLTER=''96'' THEN 02         WHEN to_char(clm.CLSTU)=''P'' AND CLM.CLLTER IN (''05'',''97'') THEN 05         WHEN to_char(clm.CLSTU)=''P'' AND CLM.CLLTER IN (''98'',''99'') THEN 04         WHEN to_char(clm.CLSTU)=''R'' THEN 04         ELSE 99       END AS ENDCASETYPE,--结案类型代码,       ''000031''as COMPANYCODE,-- 法人机构代码,       to_char(ct.province_cn) as AREACODE,--保单归属机构,       ''SYS'' AS OPERATOR,                   TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MAKEDATE,                   TO_CHAR(sysdate,''hh:mm:ss'') AS MAKETIME,                   TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MODIFYDATE,                   TO_CHAR(sysdate,''hh:mm:ss'') AS MODIFYTIMEFROM ods_stg.rls_lfppml PML,      ODS_STG.ref_city CT,      ODS_stg.Rls_Lfpclm CLMWHERE ct.policy_prefix =(CASE WHEN PML.PNO LIKE ''S%'' THEN ''501''                              WHEN PML.PNO LIKE ''G%'' THEN ''301''                              WHEN PML.PNO LIKE ''B%'' THEN ''101''                              ELSE TO_CHAR(SUBSTR(PML.PNO,1,3)) END)  AND CLM.CLPNO=PML.PNO  AND clm.CLSTU in (''P'',''A'',''R'')  AND CLM.CLDOT BETWEEN 20150101 AND 20150116 ) where year =''?year?''UNION ALL select * from (SELECT  substr(CLMH.HCDOT,1,4) as year ,to_char(CLMH.HCLMNO) as CLAIMNO,--赔案号, to_char(CLMH.HCDOS) as REPORTDATE,-- 报案日期, to_char(CLMH.HCDOS) as APPCLAIMDATE,-- 理赔申请日期,to_char(CLMH.HCDOT) as ENDCASEDATE,--结案日期,       CASE          WHEN to_char(clmH.HCSTU)=''P'' AND clmH.HCLTER NOT IN (''05'',''96'',''97'',''98'',''99'') THEN 01         WHEN to_char(clmH.HCSTU)=''P'' AND clmH.HCLTER=''96'' THEN 02         WHEN to_char(clmH.HCSTU)=''P'' AND clmH.HCLTER IN (''05'',''97'') THEN 05         WHEN to_char(clmH.HCSTU)=''P'' AND clmH.HCLTER IN (''98'',''99'') THEN 04         WHEN to_char(clmH.HCSTU)=''R'' THEN 04         ELSE 99       END AS ENDCASETYPE,-- 结案类型代码,''000031'' as COMPANYCODE,--法人机构代码, to_char(ct.province_cn) as AREACODE,--保单归属机构 ,     ''SYS'' AS OPERATOR,                   TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MAKEDATE,                   TO_CHAR(sysdate,''hh:mm:ss'') AS MAKETIME,                   TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MODIFYDATE,                   TO_CHAR(sysdate,''hh:mm:ss'') AS MODIFYTIMEFROM ods_stg.rls_lfppml PML,      ODS_STG.ref_city CT,      ODS_stg.RLS_LFPCLMH CLMHWHERE ct.policy_prefix =(CASE WHEN PML.PNO LIKE ''S%'' THEN ''501''                              WHEN PML.PNO LIKE ''G%'' THEN ''301''                              WHEN PML.PNO LIKE ''B%'' THEN ''101''                              ELSE TO_CHAR(SUBSTR(PML.PNO,1,3)) END)  AND CLMH.PNO=PML.PNO   and clmh.HCSTU in (''P'',''A'',''R'')   AND CLMH.HCDOT BETWEEN 20150101 AND 20150116 ) where year =''?year?''UNION ALLselect   to_char(t.endcasedate, ''yyyy'') as year ,to_char(t.inputclmno) as CLAIMNO,--赔案号,       to_char((case         when t.accidentdate is null then          t.acceptdate         else          t.accidentdate       end),''YYYYMMDD'')as REPORTDATE,-- 报案日期,       to_char(t.acceptdate,''YYYYMMDD'') as APPCLAIMDATE,--理赔申请日期,       to_char(t.endcasedate,''YYYYMMDD'') as ENDCASEDATE,--结案日期,      case         when t.clmamt = 0 then04         else01       end AS ENDCASETYPE,--结案类型代码,       ''000031'' as COMPANYCODE,--法人机构代码,        to_char((select substr(t.name,1,2) from ODS_stg.hnw_ldcom t where t.comcode in (select t1.managecom          from ODS_stg.hnw_hcgrpcont t1         where t1.grpcontno = t.policyno))) as AREACODE,--保单归属机构,          ''SYS'' AS OPERATOR,                   TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MAKEDATE,                   TO_CHAR(sysdate,''hh:mm:ss'') AS MAKETIME,                   TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MODIFYDATE,                   TO_CHAR(sysdate,''hh:mm:ss'') AS MODIFYTIME  from ODS_stg.HNW_hlclaim t where t.conttype = ''1''   and to_char(t.endcasedate,''yyyy'' )=''?year?'')   '; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12968;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/--LCPreservationPeriodCREATE OR REPLACE PROCEDURE PROC_12969 IS   V_ID NUMBER :=12969;  V_SQL_ID NUMBER :=12944;  V_SQL_TYPE VARCHAR(20) := 'Q';  V_SQL_INFO CLOB :=' select ''000031''||year||LPAD(ROWNUM,10,''0'') as  id,YEAR,APPPOLNO,APPPOLTYPE,to_date(APPPOLDATE,''yyyy-mm-dd'') as APPPOLDATE,ISUNDER,to_date(UNDERDATE,''yyyy-mm-dd'') as UNDERDATE,COMPANYCODE,AREACODE,OPERATOR,MAKEDATE,MAKETIME,MODIFYDATE,MODIFYTIME from (SELECT   to_char(NT1.FINISH_DATE,''yyyy'') as year , TO_CHAR(CHG.POLICY_CHG_ID)  as APPPOLNO,--保全受理号,        CASE          WHEN APP.POS_SOURCE IN (''02'',''03'') THEN 2         ELSE 1       END AS APPPOLTYPE,-- 保全申请类型,        TO_CHAR(APP.ACCEPT_SIGN_DATE,''YYYYMMDD'') AS  APPPOLDATE,--保全申请日期,       (case when INFO.AUDIT_DECISION is not null then ''1'' else ''0'' end ) as ISUNDER,--是否审核通过,        TO_CHAR(NT1.FINISH_DATE,''YYYYMMDD'') as UNDERDATE,--审核通过日期,        ''000031'' AS COMPANYCODE,-- 法人机构代码,        SUBSTR(CP.COMPANY_NAME,1,2)as AREACODE ,--保单归属机构,          ''SYS'' AS OPERATOR,                   TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MAKEDATE,                   TO_CHAR(sysdate,''hh:mm:ss'') AS MAKETIME,                   TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MODIFYDATE,                   TO_CHAR(sysdate,''hh:mm:ss'') AS MODIFYTIME  FROM ODS_STG.OFE_T_POS_APPLICATION APP, ODS_STG.OFE_T_POLICY_CHANGE CHG, ODS_STG.OFE_T_POS_ITEM_INFO INFO,        ODS_STG.OFE_T_POLICY P, ODS_STG.OFE_T_WORKFLOW_EXT NT,       (SELECT NTH.TASK_ID, MIN(NTH.STARTTIME) FINISH_DATE           FROM ODS_STG.OFE_T_WORKFLOW_EXT_HIS NTH          WHERE NTH.TASK_STATUS_CODE IN (''POS0005'',''POS0099A'',''POS0099B'',''POS0099C'')         GROUP BY NTH.TASK_ID)NT1,       ODS_STG.OFE_T_CFG_COMPANY_MAP CP WHERE APP.CHANGE_ID=CHG.CHANGE_ID   AND CHG.POLICY_CHG_ID=INFO.POLICY_CHG_ID   AND APP.POLICY_ID=P.POLICY_ID   AND APP.TASK_ID=NT.TASK_ID   AND APP.TASK_ID=NT1.TASK_ID   AND P.BRANCH_CODE=CP.COMPANY_ID   AND NT.TASK_STATUS_CODE IN (''POS0005'',''POS0099A'',''POS0099B'',''POS0099C'')   AND to_char(APP.ACCEPT_SIGN_DATE,''yyyy'')=''?year?''    AND  to_char(NT1.FINISH_DATE,''yyyy'')=''?year?''   AND APP.POS_SOURCE NOT IN (''06'',''07'',''30'',''65'',''99'') /*保全来源不是“内部差错更正申请”，“投诉转办申请”，"理赔","客户级变更",“其它”*/   AND APP.RC_STATE=''E''   AND CHG.RC_STATE=''E''   AND INFO.RC_STATE=''E''   AND P.RC_STATE=''E''   AND CP.RC_STATE=''E''UNIONSELECT to_char(APP.ACCEPT_SIGN_DATE,''yyyy'') as year ,  TO_CHAR(CHG.POLICY_CHG_ID) as APPPOLNO,--保全受理号,         CASE          WHEN APP.POS_SOURCE IN (''02'',''03'') THEN 2         ELSE 1       END AS  APPPOLTYPE,--保全申请类型,       TO_CHAR(APP.ACCEPT_SIGN_DATE,''YYYYMMDD'') as APPPOLDATE,--保全申请日期,       ( case when INFO.AUDIT_DECISION is not null then ''1'' else ''0'' end )as ISUNDER,--是否审核通过,        TO_CHAR(C.FINISH_DATE,''YYYYMMDD'') as UNDERDATE,--审核通过日期,        ''000031'' AS COMPANYCODE,-- 法人机构代码,        SUBSTR(CP.COMPANY_NAME,1,2) as AREACODE,--保单归属机构,   ''SYS'' AS OPERATOR,                   TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MAKEDATE,                   TO_CHAR(sysdate,''hh:mm:ss'') AS MAKETIME,                   TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MODIFYDATE,                   TO_CHAR(sysdate,''hh:mm:ss'') AS MODIFYTIME  FROM ODS_STG.OFE_T_POS_APPLICATION APP, ODS_STG.OFE_T_POLICY_CHANGE CHG, ODS_STG.OFE_T_POS_ITEM_INFO INFO, ODS_STG.OFE_T_POLICY P,        ODS_STG.OFE_T_CHANGE C, ODS_STG.OFE_T_CHANGE_ITEM CI, ODS_STG.OFE_T_CFG_COMPANY_MAP CP  WHERE APP.CHANGE_ID=CHG.CHANGE_ID   AND CHG.POLICY_CHG_ID=INFO.POLICY_CHG_ID   AND APP.POLICY_ID=P.POLICY_ID   AND C.CHANGE_ID=CHG.CHANGE_ID   AND P.BRANCH_CODE=CP.COMPANY_ID   AND APP.STATUS NOT IN (''3'',''-1'') /*3 试算， -1 预校验*/   AND CHG.ITEM_ID BETWEEN 1 AND 90   AND to_char(C.FINISH_DATE,''yyyy'')=''?year?''   AND to_char(APP.ACCEPT_SIGN_DATE,''yyyy'')=''?year?''   AND NOT EXISTS (SELECT 1 FROM ODS_STG.OFE_T_WORKFLOW_EXT NT WHERE APP.TASK_ID=NT.TASK_ID)   AND APP.POS_SOURCE NOT IN (''06'',''07'',''30'',''65'',''99'') /*保全来源不是“内部差错更正申请”，“投诉转办申请”，"理赔","客户级变更",“其它”*/   AND CI.ITEM_ID=CHG.ITEM_ID   AND APP.RC_STATE=''E''   AND CHG.RC_STATE=''E''   AND INFO.RC_STATE=''E''   AND P.RC_STATE=''E''     AND C.RC_STATE=''E''   AND CP.RC_STATE=''E''UNION ALLselect * from (SELECT       substr(chg.CTDOS,1,4) as year ,to_char(chg.pno||chg.ctc) as APPPOLNO,-- 保全受理号,1 as APPPOLTYPE,-- 保全申请类型,to_char(chg.CTDOS) as APPPOLDATE,--保全申请日期,(CASE WHEN chg.CDOA IS NULL THEN ''0'' ELSE ''1'' END) as ISUNDER,-- 是否审核通过,to_char(chg.CDOA) as UNDERDATE,--审核通过日期,''000031'' as COMPANYCODE,---法人机构代码,to_char(ct.province_cn) as AREACODE,--保单归属机构, ''SYS'' AS OPERATOR,                   TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MAKEDATE,                   TO_CHAR(sysdate,''hh:mm:ss'') AS MAKETIME,                   TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MODIFYDATE,                   TO_CHAR(sysdate,''hh:mm:ss'') AS MODIFYTIME   FROM ods_stg.rls_lfppml pml join (SELECT pno,CTSTU,ctc,cdot,CTDOS,CDOA  FROM  ODS_STG.RLS_LFPCHG          UNION ALL           SELECT pno,CTSTU,ctc,cdot,CTDOS,CDOA   FROM  ODS_STG.RLS_LFPCHGH ) chg    on pml.pno = chg.pno and chg.CTSTU = ''09''left join ODS_STG.ref_city ct on ct.policy_prefix =(CASE WHEN PML.PNO LIKE ''S%'' THEN ''501''                                                         WHEN PML.PNO LIKE ''G%'' THEN ''301''                                                         WHEN PML.PNO LIKE ''B%'' THEN ''101''                                                         ELSE TO_CHAR(SUBSTR(PML.PNO,1,3)) END)WHERE chg.CTDOS between ''20150101'' and ''20150116'' and chg.CDOA between ''20150101'' and ''20150116'')where   year=''?year?''union allselect to_char(t.uwdate,''yyyy'') as year ,to_char(t.edoracceptno)as APPPOLNO,-- 保全受理号,        1 as APPPOLTYPE,-- 保全申请类型,        to_char(t.approvedate,''YYYYMMDD'') as APPPOLDATE,--保全申请日期,        decode(t.uwstate, ''0'', ''01'', ''00'')as ISUNDER,-- 是否审核通过,        to_char(t.uwdate,''YYYYMMDD'')as UNDERDATE,-- 审核通过日期,        ''000031'' as COMPANYCODE,--法人机构代码,        to_char((select substr(t.name,1,2) from ODS_STG.hnw_ldcom t where t.comcode=t.managecom)) as AREACODE,--保单归属机构，    ''SYS'' AS OPERATOR,                   TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MAKEDATE,                   TO_CHAR(sysdate,''hh:mm:ss'') AS MAKETIME,                   TO_DATE(to_char(sysdate,''yyyy-mm-dd''),''yyyy-mm-dd'') AS MODIFYDATE,                   TO_CHAR(sysdate,''hh:mm:ss'') AS MODIFYTIME from ODS_stg.HNW_hpedorapp t  where t.conttype = ''1''    and t.uwstate in (''0'', ''4'')    and to_char(t.uwdate,''yyyy'') =''?year?'')   '; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12969;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/--updateCREATE OR REPLACE PROCEDURE PROC_12971 IS   V_ID NUMBER :=12971;  V_SQL_ID NUMBER :=12951;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :=' update T_PRP_LCPolicyDeliveryRate a set sourcecode=(select target_code from T_DEF_code_mapping where code_type = ''sourcecode'' and basic_code = a.sourcecode)where exists(select target_code from T_DEF_code_mapping where code_type = ''sourcecode'' and basic_code = a.sourcecode)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12971;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12972 IS   V_ID NUMBER :=12972;  V_SQL_ID NUMBER :=12952;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :=' update T_PRP_LCPolicyDeliveryRate a set areacode=(select target_code from T_DEF_code_mapping where code_type = ''areacode'' and basic_code=a.areacode ) where exists(select target_code from T_DEF_code_mapping where code_type = ''areacode'' and basic_code = a.areacode)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12972;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12973 IS   V_ID NUMBER :=12973;  V_SQL_ID NUMBER :=12953;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :=' update T_PRP_LCPolicyDeliveryRate a set sourcecode2=(select target_code from T_DEF_code_mapping where code_type = ''sourcecode2'' and basic_code = a.sourcecode2)where exists(select target_code from T_DEF_code_mapping where code_type = ''sourcecode2'' and basic_code = a.sourcecode2)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12973;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12974 IS   V_ID NUMBER :=12974;  V_SQL_ID NUMBER :=12954;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :=' update T_PRP_LCPolicyDeliveryRate a set channel=(select target_code from T_DEF_code_mapping where code_type = ''channel'' and basic_code = a.channel)where exists(select target_code from T_DEF_code_mapping where code_type = ''channel'' and basic_code = a.channel)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12974;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12975 IS   V_ID NUMBER :=12975;  V_SQL_ID NUMBER :=12955;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :=' update T_PRP_LCPolicyDeliveryRate a set agenttype=(select target_code from T_DEF_code_mapping where code_type = ''agenttype'' and basic_code = a.agenttype)where exists(select target_code from T_DEF_code_mapping where code_type =''agenttype'' and basic_code = a.agenttype)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12975;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12976 IS   V_ID NUMBER :=12976;  V_SQL_ID NUMBER :=12956;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :=' update T_PRP_LCPolicyDeliveryRate a set areacode=(select target_code from T_DEF_code_mapping where code_type = ''areacode'' and basic_code = a.areacode)where exists(select target_code from T_DEF_code_mapping where code_type =''areacode'' and basic_code = a.areacode)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12976;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12977 IS   V_ID NUMBER :=12977;  V_SQL_ID NUMBER :=12957;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :=' update T_PRP_LCPolicyDeliveryRate a set areacode=(select target_code from T_DEF_code_mapping where code_type = ''areacode'' and basic_code=a.areacode ) where exists(select target_code from T_DEF_code_mapping where code_type = ''areacode'' and basic_code = a.areacode)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12977;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12978 IS   V_ID NUMBER :=12978;  V_SQL_ID NUMBER :=12958;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :=' update T_PRP_LCPolicyDeliveryRate a set sourcecode=(select target_code from T_DEF_code_mapping where code_type = ''sourcecode'' and basic_code = a.sourcecode)where exists(select target_code from T_DEF_code_mapping where code_type = ''sourcecode'' and basic_code = a.sourcecode)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12978;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12979 IS   V_ID NUMBER :=12979;  V_SQL_ID NUMBER :=12959;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :=' update T_PRP_LCPolicyDeliveryRate a set sourcecode2=(select target_code from T_DEF_code_mapping where code_type = ''sourcecode2'' and basic_code = a.sourcecode2)where exists(select target_code from T_DEF_code_mapping where code_type = ''sourcecode2'' and basic_code = a.sourcecode2)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12979;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12980 IS   V_ID NUMBER :=12980;  V_SQL_ID NUMBER :=12960;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :=' update T_PRP_LCPolicyDeliveryRate a set channel=(select target_code from T_DEF_code_mapping where code_type = ''channel'' and basic_code = a.channel)where exists(select target_code from T_DEF_code_mapping where code_type = ''channel'' and basic_code = a.channel)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12980;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12981 IS   V_ID NUMBER :=12981;  V_SQL_ID NUMBER :=13000;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_LCPolicyDeliveryRate a set agenttype=(select target_code from T_DEF_code_mapping where code_type = ''agenttype'' and basic_code = a.agenttype)where exists(select target_code from T_DEF_code_mapping where code_type =''agenttype'' and basic_code = a.agenttype)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12981;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12982 IS   V_ID NUMBER :=12982;  V_SQL_ID NUMBER :=13001;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_LCPolicyDeliveryRate a set agenttype=(select target_code from T_DEF_code_mapping where code_type = ''agenttype'' and basic_code = a.agenttype)where exists(select target_code from T_DEF_code_mapping where code_type =''agenttype'' and basic_code = a.agenttype)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12982;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12983 IS   V_ID NUMBER :=12983;  V_SQL_ID NUMBER :=13002;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_LCREVIEWSUCCESSRATE a set isreturnvisit=(select target_code from T_DEF_code_mapping where code_type = ''isreturnvisit'' and basic_code = a.isreturnvisit)where exists(select target_code from T_DEF_code_mapping where code_type =''isreturnvisit'' and basic_code = a.isreturnvisit)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12983;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12984 IS   V_ID NUMBER :=12984;  V_SQL_ID NUMBER :=13100;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_LCPolicyDeliveryRate a set areacode=(select target_code from T_DEF_code_mapping where code_type = ''areacode'' and basic_code = a.areacode)where exists(select target_code from T_DEF_code_mapping where code_type =''areacode'' and basic_code = a.areacode)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12984;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12985 IS   V_ID NUMBER :=12985;  V_SQL_ID NUMBER :=13003;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_LCClaimGetRate  a set areacode=(select target_code from T_DEF_code_mapping where code_type = ''areacode'' and basic_code=a.areacode ) where exists(select target_code from T_DEF_code_mapping where code_type = ''areacode'' and basic_code = a.areacode)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12985;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12986 IS   V_ID NUMBER :=12986;  V_SQL_ID NUMBER :=13004;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_LCClaimGetRate a set endcasetype=(select target_code from T_DEF_code_mapping where code_type = ''endcasetype'' and basic_code = a.endcasetype)where exists(select target_code from T_DEF_code_mapping where code_type = ''endcasetype'' and basic_code = a.endcasetype)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12986;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12987 IS   V_ID NUMBER :=12987;  V_SQL_ID NUMBER :=13005;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_LCClaimGetRate a set areacode=(select target_code from T_DEF_code_mapping where code_type = ''areacode'' and basic_code = a.areacode)where exists(select target_code from T_DEF_code_mapping where code_type = ''areacode'' and basic_code = a.areacode)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12987;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12988 IS   V_ID NUMBER :=12988;  V_SQL_ID NUMBER :=13006;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_LCPreservationPeriod  a set areacode=(select target_code from T_DEF_code_mapping where code_type = ''areacode'' and basic_code=a.areacode ) where exists(select target_code from T_DEF_code_mapping where code_type = ''areacode'' and basic_code = a.areacode)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12988;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12989 IS   V_ID NUMBER :=12989;  V_SQL_ID NUMBER :=13007;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_LCPreservationPeriod  a set isunder=(select target_code from T_DEF_code_mapping where code_type = ''isunder'' and basic_code = a.isunder)where exists(select target_code from T_DEF_code_mapping where code_type = ''isunder'' and basic_code = a.isunder)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12989;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12990 IS   V_ID NUMBER :=12990;  V_SQL_ID NUMBER :=13008;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_LCPreservationPeriod  a set apppoltype=(select target_code from T_DEF_code_mapping where code_type = ''apppoltype'' and basic_code = a.apppoltype)where exists(select target_code from T_DEF_code_mapping where code_type =''apppoltype'' and basic_code = a.apppoltype)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12990;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12991 IS   V_ID NUMBER :=12991;  V_SQL_ID NUMBER :=13009;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_LCPreservationPeriod  a set areacode=(select target_code from T_DEF_code_mapping where code_type = ''areacode'' and basic_code = a.areacode)where exists(select target_code from T_DEF_code_mapping where code_type =''areacode'' and basic_code = a.areacode)'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12991;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12992 IS   V_ID NUMBER :=12992;  V_SQL_ID NUMBER :=13010;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_LCPHONECOMPLETERATE set callNumber = substr(callNumber,1,2)||''****''||substr(callNumber,7,2) where length(trim(callNumber)) = 8'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12992;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12993 IS   V_ID NUMBER :=12993;  V_SQL_ID NUMBER :=13011;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_LCPHONECOMPLETERATE set callNumber = substr(callNumber,1,3)||''****''||substr(callNumber,8,2) where length(trim(callNumber)) = 9'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12993;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/   CREATE OR REPLACE PROCEDURE PROC_12994 IS   V_ID NUMBER :=12994;  V_SQL_ID NUMBER :=13012;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_LCPHONECOMPLETERATE set callNumber = substr(callNumber,1,3)||''****''||substr(callNumber,8,3) where length(trim(callNumber)) = 10'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12994;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/CREATE OR REPLACE PROCEDURE PROC_12995 IS   V_ID NUMBER :=12995;  V_SQL_ID NUMBER :=13013;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_LCPHONECOMPLETERATE set callNumber = substr(callNumber,1,4)||''****''||substr(callNumber,9,3) where length(trim(callNumber)) = 11'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12995;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/  CREATE OR REPLACE PROCEDURE PROC_12996 IS   V_ID NUMBER :=12996;  V_SQL_ID NUMBER :=13014;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_LCPHONECOMPLETERATE set callNumber = substr(callNumber,1,4)||''****''||substr(callNumber,9,4) where length(trim(callNumber)) = 12'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12996;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/   CREATE OR REPLACE PROCEDURE PROC_12997 IS   V_ID NUMBER :=12997;  V_SQL_ID NUMBER :=13015;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_LCPHONECOMPLETERATE set callNumber = substr(callNumber,1,5)||''****''||substr(callNumber,10,4) where length(trim(callNumber)) = 13'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12997;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/  CREATE OR REPLACE PROCEDURE PROC_12998 IS   V_ID NUMBER :=12998;  V_SQL_ID NUMBER :=13016;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_LCPHONECOMPLETERATE set callNumber = substr(callNumber,1,5)||''****''||substr(callNumber,10,5) where length(trim(callNumber)) = 14'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12998;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/ CREATE OR REPLACE PROCEDURE PROC_12999 IS   V_ID NUMBER :=12999;  V_SQL_ID NUMBER := 13018;  V_SQL_TYPE VARCHAR(20) := 'U';  V_SQL_INFO CLOB :='update T_PRP_LCPHONECOMPLETERATE set callNumber = substr(callNumber,1,6)||''****''||substr(callNumber,10,5) where length(trim(callNumber)) = 15'; BEGIN    DELETE FROM T_DEF_SQL_INFO WHERE ID = 12999;   INSERT INTO T_DEF_SQL_INFO VALUES (V_ID, V_SQL_ID, V_SQL_TYPE, V_SQL_INFO);   COMMIT; END;/  