CREATE OR REPLACE PROCEDURE PROC_12424 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_12449 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_10927 IS 
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
                          END)';
CREATE OR REPLACE PROCEDURE PROC_10930 IS 
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
                                AND a.is_show=0)--�����ε�����
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
   AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn}) 
   AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'') ';
CREATE OR REPLACE PROCEDURE PROC_12813 IS 
CREATE OR REPLACE PROCEDURE PROC_12814 IS 
CREATE OR REPLACE PROCEDURE PROC_10924 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_10934 IS 
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
                                AND a.is_show=0)--�����ε�����
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
   AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn}) 
   AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'') 
) WHERE flag = 1';
CREATE OR REPLACE PROCEDURE PROC_12501 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12513 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12520 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12451 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12833 IS 
CREATE OR REPLACE PROCEDURE PROC_12472 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_12469 IS 
--�µ�(�б�)
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
--�µ������ڣ�

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

--��ȫ�շ�(�Ƕ���)

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
--��ȫ���ѣ��Ƕ��ᣩ

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

--����
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
 
 
';
CREATE OR REPLACE PROCEDURE PROC_12471 IS 
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
      
      
      
      
      
      

';
CREATE OR REPLACE PROCEDURE PROC_12834 IS 
CREATE OR REPLACE PROCEDURE PROC_12835 IS 
CREATE OR REPLACE PROCEDURE PROC_999 IS 
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
GROUP BY BATCHNO,STATEFLAG,transType';
CREATE OR REPLACE PROCEDURE PROC_993 IS 
CREATE OR REPLACE PROCEDURE PROC_998 IS 
CREATE OR REPLACE PROCEDURE PROC_997 IS 
CREATE OR REPLACE PROCEDURE PROC_996 IS 
CREATE OR REPLACE PROCEDURE PROC_995 IS 
CREATE OR REPLACE PROCEDURE PROC_994 IS 
CREATE OR REPLACE PROCEDURE PROC_12453 IS 
';
CREATE OR REPLACE PROCEDURE PROC_10625 IS 
CREATE OR REPLACE PROCEDURE PROC_10627 IS 
CREATE OR REPLACE PROCEDURE PROC_10626 IS 
CREATE OR REPLACE PROCEDURE PROC_11376 IS 
CREATE OR REPLACE PROCEDURE PROC_11377 IS 
CREATE OR REPLACE PROCEDURE PROC_11378 IS 
CREATE OR REPLACE PROCEDURE PROC_11526 IS 
CREATE OR REPLACE PROCEDURE PROC_11527 IS 
CREATE OR REPLACE PROCEDURE PROC_11362 IS 
CREATE OR REPLACE PROCEDURE PROC_11368 IS 
CREATE OR REPLACE PROCEDURE PROC_11361 IS 
CREATE OR REPLACE PROCEDURE PROC_11363 IS 
CREATE OR REPLACE PROCEDURE PROC_11367 IS 
CREATE OR REPLACE PROCEDURE PROC_11369 IS 
CREATE OR REPLACE PROCEDURE PROC_12431 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_12434 IS 
CREATE OR REPLACE PROCEDURE PROC_12454 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12461 IS 
--�µ�(�б�)
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
--�µ������ڣ�

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

--��ȫ�շ�(�Ƕ���)

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
--��ȫ���ѣ��Ƕ��ᣩ

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

';
CREATE OR REPLACE PROCEDURE PROC_12464 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_12428 IS 
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
--�µ������ڣ�

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

--��ȫ�շ�(�Ƕ���)

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
--��ȫ���ѣ��Ƕ��ᣩ

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

--����
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
 
 
';
CREATE OR REPLACE PROCEDURE PROC_11528 IS 
CREATE OR REPLACE PROCEDURE PROC_12895 IS 
CREATE OR REPLACE PROCEDURE PROC_12896 IS 
CREATE OR REPLACE PROCEDURE PROC_12897 IS 
CREATE OR REPLACE PROCEDURE PROC_10675 IS 
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
  AND ppps.premium_status = ''2'' --2:�Ѹ� 1:Ӧ��δ��
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
                                AND a.is_show=0)--�����ε�����     
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
   AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn}) 
   AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'') ';
CREATE OR REPLACE PROCEDURE PROC_10674 IS 
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
  AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')';
CREATE OR REPLACE PROCEDURE PROC_12528 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12523 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12525 IS 
CREATE OR REPLACE PROCEDURE PROC_12526 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12529 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12531 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12532 IS 
CREATE OR REPLACE PROCEDURE PROC_12533 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12534 IS 
';
CREATE OR REPLACE PROCEDURE PROC_10866 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_10869 IS 
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
                          END)';
CREATE OR REPLACE PROCEDURE PROC_10777 IS 
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
                          END)';
CREATE OR REPLACE PROCEDURE PROC_10778 IS 
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
                          END)';
CREATE OR REPLACE PROCEDURE PROC_10779 IS 
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
                          END)';
CREATE OR REPLACE PROCEDURE PROC_10781 IS 
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
                          END)';
CREATE OR REPLACE PROCEDURE PROC_10783 IS 
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
                          END)';
CREATE OR REPLACE PROCEDURE PROC_10928 IS 
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
               ''����������'' AS CLIENT_NAME,
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
                                AND a.is_show=0)--�����ε�����
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
  AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn})
  AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')';
CREATE OR REPLACE PROCEDURE PROC_10932 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_10947 IS 
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
                       ''����'' TRANSACTION_FEE_TYPE,
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
                               ''����'',
                               ''I'',
                               ''��Ϣ'',
                               ''IC'',
                               ''�鱾'') TRANSACTION_FEE_TYPE,
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
                            ''Ͷ�����ѳ�ʼ����'',
                            ''ABRC'',
                            ''����Ͷ�ʱ��ѳ�ʼ����'',
                            ''TUC'',
                            ''Ͷ������׷�ӳ�ʼ����'',
                            ''LSC'',
                            ''Ͷ������׷�ӳ�ʼ����'',
                            ''COI'',
                            ''Ͷ���¿�-���ձ��շ�'',
                            ''URP'',
                            ''Ͷ���¿�-�����ձ��շ�'',
                            ''AMC'',
                            ''Ͷ���¿�-����������'',
                            ''GBC'',
                            ''Ͷ���¿�-��֤�������'',
                            ''BOD'',
                            ''Ͷ�������۲�'',
                            ''FSC'',
                            ''Ͷ���˻�ת��'') TRANSACTION_FEE_TYPE,
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
                             ''Ͷ����ؽ��'',
                             ''P'',
                             ''Ͷ���깺���'') TRANSACTION_FEE_TYPE,
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
   AND PD.BASIC_PRODUCT_FLAG = ''B'' --�����ձ�� B���� R ������
   AND PD.COVERAGE_TERM_TYPE <> ''M'' --�����ձ�� M ������ S���� L����
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
                                AND a.is_show=0)--�����ε�����
  AND P.POLICY_NO = (case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)

  AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn})
  AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')';
CREATE OR REPLACE PROCEDURE PROC_10929 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_10936 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_10701 IS 
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
        ELSE (CASE WHEN (PPC.PRODUCT_CATEGORY = ''3-1'' AND PD.PRODUCT_NAME LIKE ''%����%'') THEN ''15220''
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
 ) RISK) where TRANSACTIONNO is not null';
CREATE OR REPLACE PROCEDURE PROC_10700 IS 
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
                                AND a.is_show=0)--�����ε�����     
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
  AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn}) 
  AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'') ';
CREATE OR REPLACE PROCEDURE PROC_10653 IS 
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
                                AND a.is_show=0)--�����ε�����     
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn}) 
AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
  ) 
 WHERE 1=1
 GROUP BY TRANSACTIONNO,COMPANYCODE,GRPPOLICYNO,POLICYNO,PRODUCTNO,DIVYEAR,DIVTYPE,DIVDISTRIBMETH';
CREATE OR REPLACE PROCEDURE PROC_12894 IS 
CREATE OR REPLACE PROCEDURE PROC_12892 IS 
CREATE OR REPLACE PROCEDURE PROC_12893 IS 
CREATE OR REPLACE PROCEDURE PROC_12510 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12508 IS 
CREATE OR REPLACE PROCEDURE PROC_12512 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12514 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12515 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12522 IS 
CREATE OR REPLACE PROCEDURE PROC_10776 IS 
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
                          END)';
CREATE OR REPLACE PROCEDURE PROC_10635 IS 
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
                                AND a.is_show=0)--�����ε�����     
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn}) 
AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'') ';
CREATE OR REPLACE PROCEDURE PROC_10683 IS 
     pc.policy_chg_id as TransactionNo,
     ''000031'' AS COMPANYCODE,
     CLM.CASE_NO AS CLAIMNO,
     '''' AS GRPPOLICYNO,
     P.POLICY_NO AS POLICYNO,
     PD.PD_PRODUCT_ID AS PRODUCTNO,
     PCM.CLIENT_ID AS INSUREDNO,
     '''' AS CUSTOMERNO,
     ROW_NUMBER() OVER (PARTITION BY CLM.POLICY_ID,PD.PD_PRODUCT_ID ORDER BY CLM.CASE_ID ) AS BNFSERIALNUM,
     ''1'' AS  BNFCAT,--1 ����, 2 ���� 3 δ֪
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
           ''����������'' AS CLIENT_NAME,
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
                                AND a.is_show=0)--�����ε�����     
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn}) 
AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')
';
CREATE OR REPLACE PROCEDURE PROC_12837 IS 
CREATE OR REPLACE PROCEDURE PROC_10920 IS 
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
                          END)';
CREATE OR REPLACE PROCEDURE PROC_10925 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_10926 IS 
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
                                AND a.is_show=0)--�����ε�����
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
  AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn})
 AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')';
CREATE OR REPLACE PROCEDURE PROC_10931 IS 
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
                          END)';
CREATE OR REPLACE PROCEDURE PROC_12838 IS 
CREATE OR REPLACE PROCEDURE PROC_10863 IS 
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
                                AND a.is_show=0)--�����ε�����  
  AND P.POLICY_NO =(case when (SELECT ''#{bussNo}'' FROM dual) IS NULL  THEN p.policy_No ELSE ''#{bussNo}'' END)
AND TO_CHAR(PC.ITEM_ID) IN (#{BussTypeIn}) 
AND PC.EFFECTIVE_DATE BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND TO_DATE(''#{endDate}'', ''yyyy-mm-dd'') ';
CREATE OR REPLACE PROCEDURE PROC_12836 IS 
CREATE OR REPLACE PROCEDURE PROC_10775 IS 
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
                          END)';
CREATE OR REPLACE PROCEDURE PROC_10933 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_10867 IS 
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
                          END)';
CREATE OR REPLACE PROCEDURE PROC_12448 IS 
       to_date(''#{endDate}'', ''yyyy-mm-dd''))
';
CREATE OR REPLACE PROCEDURE PROC_12433 IS 
--��ȫ���ѣ��Ƕ��ᣩ
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
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''currency'' and ORIGINCODE=h.currency ) Currency��
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

';
CREATE OR REPLACE PROCEDURE PROC_12457 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12459 IS 
       to_date(''#{endDate}'', ''yyyy-mm-dd'')
';
CREATE OR REPLACE PROCEDURE PROC_12465 IS 
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
--�µ������ڣ�

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

--��ȫ�շ�(�Ƕ���)

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
--��ȫ���ѣ��Ƕ��ᣩ

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

--����
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
 
 

';
CREATE OR REPLACE PROCEDURE PROC_12466 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_12467 IS 
--�µ�(�б�)

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
--�µ������ڣ�

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

--��ȫ�շ�(�Ƕ���)

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
--��ȫ���ѣ��Ƕ��ᣩ

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
          and hj1.enteraccdate BETWEEN TO_DATE(''#{startDate}'', ''yyyy-mm-dd'') AND  TO_DATE(''#{endDate}'', ''yyyy-mm-dd'')';
CREATE OR REPLACE PROCEDURE PROC_12468 IS 
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
       
       --�ܽ�����δ�ҵ�,ѧ������
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
       --���code_type�ֶ�û��licensetype       
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
                        end';
CREATE OR REPLACE PROCEDURE PROC_12516 IS 
CREATE OR REPLACE PROCEDURE PROC_12517 IS 
CREATE OR REPLACE PROCEDURE PROC_12519 IS 
CREATE OR REPLACE PROCEDURE PROC_12521 IS 
CREATE OR REPLACE PROCEDURE PROC_12772 IS 
CREATE OR REPLACE PROCEDURE PROC_12803 IS 
CREATE OR REPLACE PROCEDURE PROC_12804 IS 
CREATE OR REPLACE PROCEDURE PROC_12805 IS 
CREATE OR REPLACE PROCEDURE PROC_12806 IS 
CREATE OR REPLACE PROCEDURE PROC_12807 IS 
CREATE OR REPLACE PROCEDURE PROC_12808 IS 
CREATE OR REPLACE PROCEDURE PROC_12809 IS 
CREATE OR REPLACE PROCEDURE PROC_12812 IS 
CREATE OR REPLACE PROCEDURE PROC_12821 IS 
CREATE OR REPLACE PROCEDURE PROC_12822 IS 
CREATE OR REPLACE PROCEDURE PROC_12773 IS 
CREATE OR REPLACE PROCEDURE PROC_12774 IS 
CREATE OR REPLACE PROCEDURE PROC_12775 IS 
CREATE OR REPLACE PROCEDURE PROC_12776 IS 
CREATE OR REPLACE PROCEDURE PROC_12777 IS 
CREATE OR REPLACE PROCEDURE PROC_12778 IS 
CREATE OR REPLACE PROCEDURE PROC_12779 IS 
CREATE OR REPLACE PROCEDURE PROC_12780 IS 
CREATE OR REPLACE PROCEDURE PROC_12771 IS 
CREATE OR REPLACE PROCEDURE PROC_12781 IS 
CREATE OR REPLACE PROCEDURE PROC_12782 IS 
CREATE OR REPLACE PROCEDURE PROC_12783 IS 
CREATE OR REPLACE PROCEDURE PROC_12784 IS 
CREATE OR REPLACE PROCEDURE PROC_12785 IS 
CREATE OR REPLACE PROCEDURE PROC_12786 IS 
CREATE OR REPLACE PROCEDURE PROC_12787 IS 
CREATE OR REPLACE PROCEDURE PROC_12788 IS 
CREATE OR REPLACE PROCEDURE PROC_12789 IS 
CREATE OR REPLACE PROCEDURE PROC_12800 IS 
CREATE OR REPLACE PROCEDURE PROC_12801 IS 
CREATE OR REPLACE PROCEDURE PROC_12802 IS 
CREATE OR REPLACE PROCEDURE PROC_12815 IS 
CREATE OR REPLACE PROCEDURE PROC_12816 IS 
CREATE OR REPLACE PROCEDURE PROC_12817 IS 
CREATE OR REPLACE PROCEDURE PROC_12818 IS 
CREATE OR REPLACE PROCEDURE PROC_12819 IS 
CREATE OR REPLACE PROCEDURE PROC_12810 IS 
CREATE OR REPLACE PROCEDURE PROC_12811 IS 
CREATE OR REPLACE PROCEDURE PROC_12820 IS 
CREATE OR REPLACE PROCEDURE PROC_12429 IS 
CREATE OR REPLACE PROCEDURE PROC_12432 IS 
CREATE OR REPLACE PROCEDURE PROC_12435 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_12436 IS 
--�µ�(�б�)
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
--�µ������ڣ�

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

--��ȫ�շ�(�Ƕ���)

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
--��ȫ���ѣ��Ƕ��ᣩ

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

';
CREATE OR REPLACE PROCEDURE PROC_12527 IS 
';
CREATE OR REPLACE PROCEDURE PROC_10871 IS 
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
       to_date(''#{endDate}'', ''yyyy-mm-dd'')';
CREATE OR REPLACE PROCEDURE PROC_12473 IS 
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

';
CREATE OR REPLACE PROCEDURE PROC_12421 IS 
SELECT TransactionNo as chgid,
       ''000031'' || to_char(SYSDATE, ''yyyymmdd'') ||
       lpad((''0'' + rownum), ''10'', ''0'') AS transno,
       PolicyNo as BUSSNO,
       ''HNW'' busstype,
       to_char(SYSDATE, ''yyyymmdd'') AS dateserial,
       ''000000'' AS companycode
       
  FROM (--�µ�(�б�)
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
--�µ������ڣ�

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

--��ȫ�շ�(�Ƕ���)

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
--��ȫ���ѣ��Ƕ��ᣩ

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

--����
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
';
CREATE OR REPLACE PROCEDURE PROC_12530 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12438 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_12439 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12440 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12443 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_12444 IS 
       to_date(''#{endDate}'', ''yyyy-mm-dd''))
';
CREATE OR REPLACE PROCEDURE PROC_12452 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12441 IS 


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
';
CREATE OR REPLACE PROCEDURE PROC_12456 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12458 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12470 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_12474 IS 
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

';
CREATE OR REPLACE PROCEDURE PROC_12475 IS 
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
--�µ������ڣ�

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

--��ȫ�շ�(�Ƕ���)

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

';
CREATE OR REPLACE PROCEDURE PROC_12476 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_12422 IS 

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
--�µ������ڣ�

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

--��ȫ�շ�(�Ƕ���)

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


';
CREATE OR REPLACE PROCEDURE PROC_12426 IS 
--�µ�(�б�)

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
--�µ������ڣ�

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

--��ȫ�շ�(�Ƕ���)

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
--��ȫ���ѣ��Ƕ��ᣩ

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

';
CREATE OR REPLACE PROCEDURE PROC_12427 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_12446 IS 


select ''L''||substr(h1.clmno,2)||substr(hc.contno,11)||''05'' TransactionNo,
       (select TARGETCODE from ODS_STG.HNW_lddatamapping where MAPPINGCODE=''company'' and ORIGINCODE=h1.comcode) CompanyCode,
       h1.inputclmno ClmCaseNo,
       h1.inputclmno ClmRegisterNo,
       '''' GrpPolicyNo,
       h1.segment1 PolicyNo,
       h1.segment2 ProductNo,
       h1.applydate RgtDate,--��������
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




';
CREATE OR REPLACE PROCEDURE PROC_12447 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_12437 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12445 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12455 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12823 IS 
CREATE OR REPLACE PROCEDURE PROC_12791 IS 
CREATE OR REPLACE PROCEDURE PROC_12792 IS 
CREATE OR REPLACE PROCEDURE PROC_12793 IS 
CREATE OR REPLACE PROCEDURE PROC_12794 IS 
CREATE OR REPLACE PROCEDURE PROC_12795 IS 
CREATE OR REPLACE PROCEDURE PROC_12796 IS 
CREATE OR REPLACE PROCEDURE PROC_12797 IS 
CREATE OR REPLACE PROCEDURE PROC_12798 IS 
CREATE OR REPLACE PROCEDURE PROC_12799 IS 
CREATE OR REPLACE PROCEDURE PROC_12790 IS 
CREATE OR REPLACE PROCEDURE PROC_12760 IS 
CREATE OR REPLACE PROCEDURE PROC_12761 IS 
CREATE OR REPLACE PROCEDURE PROC_12762 IS 
       ''20161109'' as PeriodValue,
       to_char(to_date(substr(''#{startDate}'',0,10), ''yyyy-mm-dd''),
               ''yyyymmdd'') as StartDate,
       to_char(to_date(substr(''#{endDate}'',0,10),''yyyy-mm-dd''),''yyyymmdd'') as EndDate,
       ''KPIset '' as KPIset
  from dual';
CREATE OR REPLACE PROCEDURE PROC_12763 IS 
CREATE OR REPLACE PROCEDURE PROC_12764 IS 
CREATE OR REPLACE PROCEDURE PROC_12765 IS 
CREATE OR REPLACE PROCEDURE PROC_12766 IS 
CREATE OR REPLACE PROCEDURE PROC_12767 IS 
CREATE OR REPLACE PROCEDURE PROC_12768 IS 
CREATE OR REPLACE PROCEDURE PROC_12769 IS 
CREATE OR REPLACE PROCEDURE PROC_12770 IS 
CREATE OR REPLACE PROCEDURE PROC_12851 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12853 IS 
CREATE OR REPLACE PROCEDURE PROC_12872 IS 
       SET city = ''''
     WHERE TRANSACTIONNO NOT IN
           (SELECT TRANSACTIONNO
              FROM T_PRP_LCCONT
             WHERE REGEXP_LIKE(city, ''(^[+-]?\d{0,}\.?\d{0,}$)''))';
CREATE OR REPLACE PROCEDURE PROC_12873 IS 
CREATE OR REPLACE PROCEDURE PROC_12875 IS 
CREATE OR REPLACE PROCEDURE PROC_12876 IS 
CREATE OR REPLACE PROCEDURE PROC_12877 IS 
CREATE OR REPLACE PROCEDURE PROC_12878 IS 
CREATE OR REPLACE PROCEDURE PROC_12879 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12880 IS 
CREATE OR REPLACE PROCEDURE PROC_12881 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12882 IS 
CREATE OR REPLACE PROCEDURE PROC_12884 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12885 IS 
CREATE OR REPLACE PROCEDURE PROC_12886 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12887 IS 
CREATE OR REPLACE PROCEDURE PROC_12888 IS 
CREATE OR REPLACE PROCEDURE PROC_12889 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12890 IS 
CREATE OR REPLACE PROCEDURE PROC_12891 IS 
CREATE OR REPLACE PROCEDURE PROC_12898 IS 
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
';
CREATE OR REPLACE PROCEDURE PROC_12855 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12857 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12859 IS 
       SET STREET = REGEXP_REPLACE(STREET, ''[|]'', '''') WHERE 
                EXISTS (SELECT ''X'' FROM T_PRP_LCCONT WHERE REGEXP_LIKE(STREET, ''[|]''))';
CREATE OR REPLACE PROCEDURE PROC_12861 IS 
CREATE OR REPLACE PROCEDURE PROC_12862 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12864 IS 
CREATE OR REPLACE PROCEDURE PROC_12865 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12866 IS 
';
CREATE OR REPLACE PROCEDURE PROC_12867 IS 
CREATE OR REPLACE PROCEDURE PROC_12868 IS 
CREATE OR REPLACE PROCEDURE PROC_12869 IS 
       SET county = ''''
     WHERE TRANSACTIONNO NOT IN
           (SELECT TRANSACTIONNO
              FROM T_PRP_LCCONT
             WHERE REGEXP_LIKE(county, ''(^[+-]?\d{0,}\.?\d{0,}$)''))';
CREATE OR REPLACE PROCEDURE PROC_12870 IS 
CREATE OR REPLACE PROCEDURE PROC_12871 IS 
       SET PROVINCE = ''''
     WHERE TRANSACTIONNO NOT IN
           (SELECT TRANSACTIONNO
              FROM T_PRP_LCCONT
             WHERE REGEXP_LIKE(PROVINCE, ''(^[+-]?\d{0,}\.?\d{0,}$)''))';
CREATE OR REPLACE PROCEDURE PROC_12966 IS 