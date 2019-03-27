prompt PL/SQL Developer import file
prompt create or replace views
prompt Created on 2016年11月14日 by gyas-itpingw
set feedback off
set define off
-- 存在与否校验
prompt create or replace views V_CHECK_EXITORNOT...
CREATE OR REPLACE VIEW V_CHECK_EXITORNOT AS
SELECT ERRORTABLE,COLNAME,ALLCOUNTS,ERRORMSG,ERRCOUNTS FROM (
SELECT errortable,ColName,SUM(allcounts) AS allcounts,errormsg,sum(errcounts) AS errcounts FROM(
 select '保单信息表：LCCont' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '在交易表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lcpoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_lCCont o
   UNION ALL
   select '交易信息表：LCPoltransaction' AS errortable,'NOT IN LCCont' ColName,1 AS allcounts,
          '在保单表不存在' errormsg,
          (CASE WHEN EXISTS
          (SELECT 'E'
             FROM t_prp_lCCont t
            WHERE t.transactionno = o.transactionno
             AND t.policyno = o.policyno
             )
           THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_lcpoltransaction o
   UNION ALL
 select '保单受益人信息表：LCBnf' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '在交易表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lcpoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCBnf o
  UNION ALL
 select '保单信息表：lCCont' AS errortable,'NOT IN lcpoltransaction' ColName,1 AS allcounts,
        '在保单不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lcpoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_lCCont o
     UNION ALL
 select '被保人信息表：LCInsured' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '在交易表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lcpoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCInsured o
        UNION ALL
 select '被保人信息表：LCInsured' AS errortable,'NOT IN LCCont' ColName,1 AS allcounts,
        '在保单表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lCCont t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCInsured o
    UNION ALL
 select '保单险种信息表：LCProduct' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '在交易表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lcpoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
          THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCProduct o
        UNION ALL
 select '保单险种信息表：LCProduct' AS errortable,'NOT IN LCCont' ColName,1 AS allcounts,
        '在保单表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lCCont t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
          THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCProduct o
   UNION ALL
 select '保单险种信息表：LCProduct' AS errortable,'NOT IN LMProduct' ColName,1 AS allcounts,
        '在险种定义表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LMProduct t
          WHERE t.productcode = o.productcode
           )
          THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCProduct o
    UNION ALL
 select '保险账户表：LCInsureAcc' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '在交易表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lcpoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCInsureAcc o
       UNION ALL
 select '保险账户表：LCInsureAcc' AS errortable,'NOT IN LCInsured' ColName,1 AS allcounts,
        '在交易表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LCInsured t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCInsureAcc o
    UNION ALL
 select '险种被保人关联表：LCProdInsuRela' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '在交易表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lcpoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCProdInsuRela o
    UNION ALL
   select '险种被保人关联表：LCProdInsuRela' AS errortable,'NOT IN LCCont' ColName,1 AS allcounts,
          '在保单表不存在' errormsg,
          (CASE WHEN EXISTS
          (SELECT 'E'
             FROM t_prp_lCCont t
            WHERE t.transactionno = o.transactionno
             AND t.policyno = o.policyno
             )
           THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCProdInsuRela o
       UNION ALL
   select '险种被保人关联表：LCProdInsuRela' AS errortable,'NOT IN LCInsured' ColName,1 AS allcounts,
          '在保单表不存在' errormsg,
          (CASE WHEN EXISTS
          (SELECT 'E'
             FROM t_prp_LCInsured t
            WHERE t.transactionno = o.transactionno
             AND t.policyno = o.policyno
             AND t.insuredno = t.insuredno
             )
           THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCProdInsuRela o
          UNION ALL
    select '险种被保人关联表：LCProdInsuRela' AS errortable,'NOT IN LCProduct' ColName,1 AS allcounts,
            '在保单表不存在' errormsg,
            (CASE WHEN EXISTS
            (SELECT 'E'
               FROM t_prp_LCProduct t
              WHERE t.transactionno = o.transactionno
               AND t.policyno = o.policyno
               AND t.productno = o.productno
               )
             THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCProdInsuRela o
 UNION ALL
 select '保单信息表：LCCont' AS errortable,'NOT IN LCProdInsuRela' ColName,1 AS allcounts,
        '在险种关联表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LCProdInsuRela t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_lCCont o
   UNION ALL
 select '被保人信息表：LCInsured' AS errortable,'NOT IN LCProdInsuRela' ColName,1 AS allcounts,
        '在险种关联表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT DISTINCT 'E'
           FROM t_prp_LCProdInsuRela t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           AND t.insuredno = o.insuredno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCInsured o
    UNION ALL
  select '保单险种表：LCProduct' AS errortable,'NOT IN LCProdInsuRela' ColName,1 AS allcounts,
         '在险种关联表不存在' errormsg,
          (CASE WHEN EXISTS
          (SELECT 'E'
             FROM t_prp_LCProdInsuRela t
            WHERE t.transactionno = o.transactionno
             AND t.policyno = o.policyno
             AND t.productNo = o.productNo
             )
           THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCProduct o
    UNION ALL
  select '保单信息表：LCCont' AS errortable,'NOT IN LCProduct' ColName,1 AS allcounts,
          '在险种表不存在' errormsg,
          (CASE WHEN EXISTS
          (SELECT 'E'
             FROM t_prp_LCProduct t
            WHERE t.transactionno = o.transactionno
             AND t.policyno = o.policyno
             )
           THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_lCCont o
    UNION ALL
 select '生存经领取表：LJAGetLivBene' AS errortable,'NOT IN LCCont' ColName,1 AS allcounts,
        '在保单表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lCCont t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LJAGetLivBene o
    UNION ALL
 select '红利领取息表：LJDivDistrib' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '在交易表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LCPoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LJDivDistrib o
   UNION ALL
 select '红利领取息表：LJDivDistrib' AS errortable,'NOT IN LCCont' ColName,1 AS allcounts,
        '在保单表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lCCont t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LJDivDistrib o
    UNION ALL
 select '保费明细表：LJAPay' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '在交易表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LCPoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LJApay o
 UNION ALL
 select '保费明细表：LJAPay' AS errortable,'NOT IN LCCont' ColName,1 AS allcounts,
        '在保单表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lCCont t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_lJApay o
    UNION ALL
 select '付费信息信息表：LJAGet' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '在交易表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LCPoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LJAGet o
  UNION ALL
 select '付费信息信息表：LJAGet' AS errortable,'NOT IN LCCont' ColName,1 AS allcounts,
        '在交易表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lCCont t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LJAGet o
    UNION ALL
 select '代理人员信息表：LAAgent' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '在交易表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lcpoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LAAgent o
    UNION ALL
 select '销售人员信息表：LASales' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '在交易表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LCPoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LASales o
    UNION ALL
 select '理赔信息表：LLClaimPolicy' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '在交易表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LCPoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LLClaimPolicy o
    UNION ALL
 select '理赔受益人信息表：LLBnf' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '在交易表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LCPoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCBnf o
    UNION ALL
 select '理赔信息表：LLClaimPolicy' AS errortable,'NOT IN LLBnf' ColName,1 AS allcounts,
        '在理赔受益人表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LLBnf t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           AND t.ClaimNo = o.ClmCaseNo
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LLClaimPolicy o
    UNION ALL
 select '理赔受益人信息表：LLBnf' AS errortable,'NOT IN LLClaimPolicy' ColName,1 AS allcounts,
        '在理赔受益人信息表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT DISTINCT 'E'
           FROM t_prp_LLClaimPolicy t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           AND t.ClmCaseNo = o.ClaimNo
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LLBnf o
    UNION ALL
 select '险种关联表：LCProdInsuRela' AS errortable,'NOT IN LCInsured' ColName,1 AS allcounts,
        '在被保人表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LCInsured t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           AND t.insuredno = o.insuredno
           )
         THEN 0 ELSE 1 END) AS errcounts FROM t_prp_LCProdInsuRela o
    UNION ALL
 select '险种关联表：LCProdInsuRela' AS errortable,'NOT IN LCProduct' ColName,1 AS allcounts,
        '在险种表不存在' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LCProduct t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           AND t.productNo = o.productNo
           )
        THEN 0 ELSE 1 END) AS errcounts FROM t_prp_LCProdInsuRela o
 )GROUP BY errortable,ColName,errormsg
 )
WHERE errcounts > 0
ORDER BY errortable;

--唯一性校验
prompt create or replace views V_CHECK_ONLY...
CREATE OR REPLACE VIEW V_CHECK_ONLY AS
SELECT ERRORTABLE,COLNAME,ALLCOUNTS,ERRORMSG,ERRCOUNTS FROM (
SELECT errortable,colname,sum(allcounts) AS allcounts,errormsg,SUM(counts) AS errcounts FROM (
select '保单交易信息表：T_PRP_LCPoltransaction' AS errortable,'TransactionNo' ColName,count(1) AS allcounts,'唯一性校验失败' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from T_PRP_LCPoltransaction GROUP BY TransactionNo UNION ALL
select '保单信息表：T_PRP_LCCont' AS errortable,'TransactionNo,PolicyNo' ColName,count(1) AS allcounts,'唯一性校验失败' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LCCont GROUP BY TransactionNo,PolicyNo UNION ALL
select '被保险人表：T_PRP_LCInsured' AS errortable,'TransactionNo,PolicyNo,InsuredNo' ColName,count(1) AS allcounts,'唯一性校验失败' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LCInsured GROUP BY TransactionNo,PolicyNo,InsuredNo UNION ALL
select '受益人表：T_PRP_LCBnf' AS errortable,'TransactionNo,PolicyNo,ProductNo,BnfSerialNum' ColName,count(1) AS allcounts,'唯一性校验失败' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LCBnf GROUP BY TransactionNo,PolicyNo,ProductNo,BnfSerialNum UNION ALL
select '保单险种信息表：T_PRP_LCProduct' AS errortable,'TransactionNo,PolicyNo,ProductNo' ColName,count(1) AS allcounts,'唯一性校验失败' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LCProduct GROUP BY TransactionNo,PolicyNo,ProductNo UNION ALL
select '被保险人险种关联表：T_PRP_LCProdInsuRela' AS errortable,'TransactionNo,PolicyNo,ProductNo,InsuredNo' ColName,count(1) AS allcounts,'唯一性校验失败' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LCProdInsuRela GROUP BY TransactionNo,PolicyNo,ProductNo,InsuredNo UNION ALL
select '保险账户表：T_PRP_LCInsureAcc' AS errortable,'TransactionNo,PolicyNo,ProductNo,InsuAccNo,AccType' ColName,count(1) AS allcounts,'唯一性校验失败' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LCInsureAcc GROUP BY TransactionNo,PolicyNo,ProductNo,InsuAccNo,AccType UNION ALL
select '付费明细表：T_PRP_LJAGet' AS errortable,'TransactionNo,PolicyNo,ActuGetNo,GetType' ColName,count(1) AS allcounts,'唯一性校验失败' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LJAGet GROUP BY TransactionNo,PolicyNo,ActuGetNo,GetType UNION ALL
select '保费明细表：T_PRP_LJAPay' AS errortable,'TransactionNo,PolicyNo,PayNo,ProductNo' ColName,count(1) AS allcounts,'唯一性校验失败' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LJAPay GROUP BY TransactionNo,PolicyNo,PayNo,ProductNo UNION ALL
select '生存金领取表：T_PRP_LJAGetLivBene' AS errortable,'TransactionNo,PolicyNo,ProductNo,WDNo' ColName,count(1) AS allcounts,'唯一性校验失败' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LJAGetLivBene GROUP BY TransactionNo,PolicyNo,ProductNo,WDNo UNION ALL
select '红利分配表：T_PRP_LJDivDistrib' AS errortable,'TransactionNo,PolicyNo,ProductNo,DivYear,DivType,DivDistribMeth' ColName,count(1) AS allcounts,'唯一性校验失败' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LJDivDistrib GROUP BY TransactionNo,PolicyNo,ProductNo,DivYear,DivType,DivDistribMeth UNION ALL
select '保险中介渠道及从业人员信息表：T_PRP_LAAgent' AS errortable,'TransactionNo,PolicyNo,AgencyCode,AgentCode' ColName,count(1) AS allcounts,'唯一性校验失败' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LAAgent GROUP BY TransactionNo,PolicyNo,AgencyCode,AgentCode UNION ALL
select '保险公司销售服务人员信息表：T_PRP_LASales' AS errortable,'TransactionNo,PolicyNo,AgentCode' ColName,count(1) AS allcounts,'唯一性校验失败' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LASales GROUP BY TransactionNo,PolicyNo,AgentCode UNION ALL
select '理赔保单明细表：T_PRP_LLClaimPolicy' AS errortable,'TransactionNo,PolicyNo,ClmCaseNo,ProductNo,BenefitType' ColName,count(1) AS allcounts,'唯一性校验失败' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy GROUP BY TransactionNo,PolicyNo,ClmCaseNo,ProductNo,BenefitType UNION ALL
select '理赔受益人账户表：T_PRP_LLBnf' AS errortable,'TransactionNo,ClaimNo,PolicyNo,ProductNo,BnfSerialNum' ColName,count(1) AS allcounts,'唯一性校验失败' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LLBnf GROUP BY TransactionNo,ClaimNo,PolicyNo,ProductNo,BnfSerialNum UNION ALL
select '险种定义表：T_PRP_LMProduct' AS errortable,'TransactionNo,CompanyCode,ProductCode' ColName,count(1) AS allcounts,'唯一性校验失败' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LMProduct GROUP BY TransactionNo,CompanyCode,ProductCode
) GROUP BY errortable,ColName,errormsg ) WHERE errcounts > 0 ORDER BY errortable;

--转码校验
prompt create or replace views V_CHECK_TRANSCODE...
CREATE OR REPLACE VIEW V_CHECK_TRANSCODE AS
SELECT ERRORTABLE,CHECKINFO,ALLCOUNTS,COMPANYCODE,TRANSCOL,ERRORCOUNTS FROM (
--保单交易表
select '保单交易表:T_PRP_LCPolTransaction' AS  ErrorTable, '交易编码' AS  CHeckInfo,count(TransactionNo) AS AllCounts, '公司编码' AS CompanyCode,'CompanyCode' AS TransCol,count(CompanyCode) AS ErrorCounts
from T_PRP_lcpoltransaction
where CompanyCode NOT IN ( select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode') union
select '保单交易表:T_PRP_LCPolTransaction', '交易编码',count(TransactionNo),'业务类型','busstype',count(BussType) from  T_PRP_lcpoltransaction where busstype not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='busstype')  union
select '保单交易表:T_PRP_LCPolTransaction', '交易编码',count(TransactionNo),'证件类型','CertType',count(CertType) from  T_PRP_lcpoltransaction where certtype not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='certtype')  union
--个人保单表
select '个人保单表:T_PRP_LCCont', '交易编码',count(TransactionNo),'公司编码','CompanyCode',count(CompanyCode) from  T_PRP_LCCont where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '个人保单表:T_PRP_LCCont', '交易编码',count(TransactionNo),'个团标志','GPFlag',count(GPFlag) from  T_PRP_lccont where GPFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='gpflag')  union
select '个人保单表:T_PRP_LCCont', '交易编码',count(TransactionNo),'家庭单类型','FamilyPolType',count(FamilyPolType) from  T_PRP_lccont where FamilyPolType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='familypoltype')  union
select '个人保单表:T_PRP_LCCont', '交易编码',count(TransactionNo),'管理机构','ManageCom',count(ManageCom) from  T_PRP_lccont where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
select '个人保单表:T_PRP_LCCont', '交易编码',count(TransactionNo),'销售渠道','DistribChnl',count(DistribChnl) from  T_PRP_lccont where DistribChnl not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='distribchnl')  union
select '个人保单表:T_PRP_LCCont', '交易编码',count(TransactionNo),'投保人性别','AppntSex',count(AppntSex) from  T_PRP_lccont where AppntSex not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='sex')  union
select '个人保单表:T_PRP_LCCont', '交易编码',count(TransactionNo),'投保人证件类型','AppntCertType',count(AppntCertType) from  T_PRP_lccont where AppntCertType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='certtype')  union
select '个人保单表:T_PRP_LCCont', '交易编码',count(TransactionNo),'省','Province',count(Province) from  T_PRP_lccont where Province not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='city')  union
select '个人保单表:T_PRP_LCCont', '交易编码',count(TransactionNo),'市','City',count(City) from  T_PRP_lccont where Province not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='city')  union
select '个人保单表:T_PRP_LCCont', '交易编码',(SELECT COUNT(t.transactionno) FROM T_PRP_lccont t GROUP BY t.transactionno) AS allcount,'区/县','County',count(1) from  T_PRP_lccont WHERE County IS NOT NULL AND County not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='city') AND County not in (select BASIC_CODE from T_DEF_code_mapping where CODE_TYPE='city') GROUP BY TransactionNo  union
select '个人保单表:T_PRP_LCCont', '交易编码',count(TransactionNo),'交费间隔','PayMode',count(PayMode) from  T_PRP_lccont where PayMode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='paymode')  union
select '个人保单表:T_PRP_LCCont', '交易编码',count(TransactionNo),'交费方式','PayWay',count(PayWay) from  T_PRP_lccont where PayWay not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='payway')  union
select '个人保单表:T_PRP_LCCont', '交易编码',count(TransactionNo),'币别','Currency',count(Currency) from  T_PRP_lccont where Currency not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='currency')  union
select '个人保单表:T_PRP_LCCont', '交易编码',count(TransactionNo),'核保类型','UWType',count(UWType) from  T_PRP_lccont where UWType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='uwtype')  union
select '个人保单表:T_PRP_LCCont', '交易编码',count(TransactionNo),'保单状态','PolStatus',count(PolStatus) from  T_PRP_lccont where PolStatus not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='polstatus')  union
select '个人保单表:T_PRP_LCCont', '交易编码',count(TransactionNo),'保单形式','PolicyType',count(PolicyType) from  T_PRP_lccont where PolicyType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='policytype')  union
select '个人保单表:T_PRP_LCCont', '交易编码',count(TransactionNo),'保单终止原因','TerminationReason',count(TerminationReason) from  T_PRP_lccont where TerminationReason not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='terminationreason')  union
--被保险人险种关联表
select '被保险人险种关联表：T_PRP_LCProdInsuRela', '交易编码',count(TransactionNo),'公司编码','CompanyCode',count(CompanyCode) from  T_PRP_LCProdInsuRela where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '被保险人险种关联表：T_PRP_LCProdInsuRela', '交易编码',count(TransactionNo),'管理机构','ManageCom',count(ManageCom) from  T_PRP_LCProdInsuRela where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
select '个人险种表：T_PRP_LCProduct', '交易编码',count(TransactionNo),'保单类型标记','PolTypeFlag',count(PolTypeFlag) from  T_PRP_LCProduct where PolTypeFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='poltypeflag')  union
select '个人险种表：T_PRP_LCProduct', '交易编码',count(TransactionNo),'主附险标记','PMainProductFlag',count(MainProductFlag) from  T_PRP_LCProduct where MainProductFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='mainproductflag')  union
select '个人险种表：T_PRP_LCProduct', '交易编码',count(TransactionNo),'管理机构','ManageCom',count(ManageCom) from  T_PRP_LCProduct where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
select '个人险种表：T_PRP_LCProduct', '交易编码',count(TransactionNo),'交费间隔', 'PayMode',count(PayMode) from  T_PRP_LCProduct where PayMode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='paymode')  union
select '个人险种表：T_PRP_LCProduct', '交易编码',count(TransactionNo),'交费年期类型','PayTermType',count(PayTermType) from  T_PRP_LCProduct where PayTermType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='paytermtype')  union
select '个人险种表：T_PRP_LCProduct', '交易编码',count(TransactionNo),'保险年期类型','InsurancePeriodFlag',count(InsurancePeriodFlag) from  T_PRP_LCProduct where InsurancePeriodFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='insuranceperiodflag')  union
select '个人险种表：T_PRP_LCProduct', '交易编码',count(TransactionNo),'被保险人类型','InsuredType',count(InsuredType) from  T_PRP_LCProduct where InsuredType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='insuredtype')  union
select '个人险种表：T_PRP_LCProduct', '交易编码',count(TransactionNo),'核保结论','UWConclusion',count(UWConclusion) from  T_PRP_LCProduct where UWConclusion not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='uwconclusion')  union
select '个人险种表：T_PRP_LCProduct', '交易编码',count(TransactionNo),'保单险种状态','Status',count(Status) from  T_PRP_LCProduct where Status not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='polstatus')  union
--受益人表
select '受益人表：T_PRP_LCBnf', '交易编码',count(TransactionNo),'公司编码','CompanyCode',count(CompanyCode) from  T_PRP_LCBnf where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '受益人表：T_PRP_LCBnf', '交易编码',count(TransactionNo),'受益人类别','BnfCat',count(BnfCat) from  T_PRP_LCBnf where BnfCat not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='bnfcat')  union
select '受益人表：T_PRP_LCBnf', '交易编码',count(TransactionNo),'受益人级别','BnfLevel',count(BnfLevel) from  T_PRP_LCBnf where BnfLevel not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='bnflevel')  union
select '受益人表：T_PRP_LCBnf', '交易编码',count(TransactionNo),'与被保人关系','RelationToInsured',count(RelationToInsured) from  T_PRP_LCBnf where RelationToInsured not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='relationtoinsured')  union
select '受益人表：T_PRP_LCBnf', '交易编码',count(TransactionNo),'受益人性别','Sex',count(Sex) from  T_PRP_LCBnf where Sex not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='sex')  union
select '受益人表：T_PRP_LCBnf', '交易编码',count(TransactionNo),'受益人证件类型','CertType',count(CertType) from  T_PRP_LCBnf where CertType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='certtype')  union
--被保险人表
select '被保险人表：T_PRP_LCInsured', '交易编码',count(TransactionNo),'公司编码','CompanyCode',count(CompanyCode) from  T_PRP_LCInsured where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '被保险人表：T_PRP_LCInsured', '交易编码',count(TransactionNo),'管理机构','ManageCom',count(ManageCom) from  T_PRP_LCInsured where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
select '被保险人表：T_PRP_LCInsured', '交易编码',count(TransactionNo),'与主被保人关系','RelationToMainInsured',count(RelationToMainInsured) from  T_PRP_LCInsured where RelationToMainInsured not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='relationtoinsured')  union
select '被保险人表：T_PRP_LCInsured', '交易编码',count(TransactionNo),'与投保人关系','RelationToAppnt',count(RelationToAppnt) from  T_PRP_LCInsured where RelationToAppnt not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='relationtoinsured')  union
select '被保险人表：T_PRP_LCInsured', '交易编码',count(TransactionNo),'被保人性别','InsuredSex',count(InsuredSex) from  T_PRP_LCInsured where InsuredSex not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='sex')  union
select '被保险人表：T_PRP_LCInsured', '交易编码',count(TransactionNo),'证件类型','InsuredCertType',count(InsuredCertType) from  T_PRP_LCInsured where InsuredCertType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='certtype')  union
select '被保险人表：T_PRP_LCInsured', '交易编码',count(TransactionNo),'国籍','Country',count(Country) from  T_PRP_LCInsured where Country not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='country')  union
select '被保险人表：T_PRP_LCInsured', '交易编码',count(TransactionNo),'民族','Nationality',count(Nationality) from  T_PRP_LCInsured where Nationality not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='nationality')  union
select '被保险人表：T_PRP_LCInsured', '交易编码',count(TransactionNo),'婚姻状况','MarriageStatus',count(MarriageStatus) from  T_PRP_LCInsured where MarriageStatus not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='marriagestatus')  union
select '被保险人表：T_PRP_LCInsured', '交易编码',count(TransactionNo),'健康状况','HealthCondition',count(HealthCondition) from  T_PRP_LCInsured where HealthCondition not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='healthcondition')  union
select '被保险人表：T_PRP_LCInsured', '交易编码',count(TransactionNo),'学历','EducateLevel',count(EducateLevel) from  T_PRP_LCInsured where EducateLevel not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='educatelevel')  union
select '被保险人表：T_PRP_LCInsured', '交易编码',count(TransactionNo),'职位','Position',count(Position) from  T_PRP_LCInsured where Position not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='position')  union
select '被保险人表：T_PRP_LCInsured', '交易编码',count(TransactionNo),'职业代码','OccupationType',count(OccupationType) from  T_PRP_LCInsured where OccupationType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='occupationtype')  union
select '被保险人表：T_PRP_LCInsured', '交易编码',count(TransactionNo),'兼职代码','PartTimeOccupationType',count(PartTimeOccupationType) from  T_PRP_LCInsured where PartTimeOccupationType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='occupationtype')  union
select '被保险人表：T_PRP_LCInsured', '交易编码',count(TransactionNo),'是否吸烟标志','SmokeFlag',count(SmokeFlag) from  T_PRP_LCInsured where SmokeFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='smokeflag')  union
select '被保险人表：T_PRP_LCInsured', '交易编码',count(TransactionNo),'驾照类型','LicenseType',count(LicenseType) from  T_PRP_LCInsured where LicenseType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='licensetype')  union
select '被保险人表：T_PRP_LCInsured', '交易编码',count(TransactionNo),'是否有社保标志','SocialInsuFlag',count(SocialInsuFlag) from  T_PRP_LCInsured where SocialInsuFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='socialinsuflag')  union
select '被保险人表：T_PRP_LCInsured', '交易编码',count(TransactionNo),'居民类型','ResidentType',count(ResidentType) from  T_PRP_LCInsured where ResidentType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='residenttype')  union
select '被保险人表：T_PRP_LCInsured', '交易编码',count(TransactionNo),'被保险人类型','InsuredType',count(InsuredType) from  T_PRP_LCInsured where InsuredType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='insuredtype')  union
--保险账户表
select '保险账户表:T_PRP_LCInsureAcc', '交易编码',count(TransactionNo),'公司编码','CompanyCode',count(CompanyCode) from  T_PRP_LCInsureAcc where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '保险账户表:T_PRP_LCInsureAcc', '交易编码',count(TransactionNo),'管理机构','ManageCom',count(ManageCom) from  T_PRP_LCInsureAcc where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
select '保险账户表:T_PRP_LCInsureAcc', '交易编码',count(TransactionNo),'账户类型','AccType',count(AccType) from  T_PRP_LCInsureAcc where AccType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='acctype')  union
--理赔保单明细表
select '理赔保单明细表：T_PRP_LLClaimPolicy', '交易编码',count(TransactionNo),'公司编码','CompanyCode',count(CompanyCode) from  T_PRP_LLClaimPolicy where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '理赔保单明细表：T_PRP_LLClaimPolicy', '交易编码',count(TransactionNo),'出险原因','LossOccurReason',count(LossOccurReason) from  T_PRP_LLClaimPolicy where LossOccurReason not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='lossoccurreason')  union
select '理赔保单明细表：T_PRP_LLClaimPolicy', '交易编码',count(TransactionNo),'赔付责任类型','BenefitType',count(BenefitType) from  T_PRP_LLClaimPolicy where BenefitType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='benefittype')  union
select '理赔保单明细表：T_PRP_LLClaimPolicy', '交易编码',count(TransactionNo),'币别','Currency',count(Currency) from  T_PRP_LLClaimPolicy where Currency not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='currency')  union
select '理赔保单明细表：T_PRP_LLClaimPolicy', '交易编码',count(TransactionNo),'核赔结论类型','PayStatusCode',count(PayStatusCode) from  T_PRP_LLClaimPolicy where PayStatusCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='paystatuscode')  union
select '理赔保单明细表：T_PRP_LLClaimPolicy', '交易编码',count(TransactionNo),'管理机构','ManageCom',count(ManageCom) from  T_PRP_LLClaimPolicy where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
--理赔受益人表
select '理赔受益人表：T_PRP_LLBnf', '交易编码',count(TransactionNo),'公司编码','CompanyCode',count(CompanyCode) from  T_PRP_LLBnf where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '理赔受益人表：T_PRP_LLBnf', '交易编码',count(TransactionNo),'受益人类别','BnfCat',count(BnfCat) from  T_PRP_LLBnf where BnfCat not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='bnfcat')  union
select '理赔受益人表：T_PRP_LLBnf', '交易编码',count(TransactionNo),'受益人级别','BnfLevel',count(BnfLevel) from  T_PRP_LLBnf where BnfLevel not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='bnflevel')  union
select '理赔受益人表：T_PRP_LLBnf', '交易编码',count(TransactionNo),'受益人与被保人关系','RelationToInsured',count(RelationToInsured) from  T_PRP_LLBnf where RelationToInsured not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='relationtoinsured')  union
select '理赔受益人表：T_PRP_LLBnf', '交易编码',count(TransactionNo),'受益人性别','Sex',count(Sex) from  T_PRP_LLBnf where Sex not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='sex')  union
select '理赔受益人表：T_PRP_LLBnf', '交易编码',count(TransactionNo),'受益人证件类型','CertType',count(CertType) from  T_PRP_LLBnf where CertType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='certtype')  union
select '理赔受益人表：T_PRP_LLBnf', '交易编码',count(TransactionNo),'领款人与被保人关系','RelationOfPayeeAndInsured',count(RelationOfPayeeAndInsured) from  T_PRP_LLBnf where RelationOfPayeeAndInsured not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='relationtoinsured')  union
select '理赔受益人表：T_PRP_LLBnf', '交易编码',count(TransactionNo),'领款人性别','PayeeSex',count(PayeeSex) from  T_PRP_LLBnf where PayeeSex not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='sex')  union
select '理赔受益人表：T_PRP_LLBnf', '交易编码',count(TransactionNo),'领款人证件类型','PayeeCertType',count(PayeeCertType) from  T_PRP_LLBnf where PayeeCertType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='certtype')  union
select '理赔受益人表：T_PRP_LLBnf', '交易编码',count(TransactionNo),'保险金领取方式','BenefitWDMthd',count(BenefitWDMthd) from  T_PRP_LLBnf where BenefitWDMthd not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='benefitwdmthd')  union
select '理赔受益人表：T_PRP_LLBnf', '交易编码',count(TransactionNo),'保险金支付方式','BenefitPayMthd',count(BenefitPayMthd) from  T_PRP_LLBnf where BenefitPayMthd not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='payway')  union
--销售服务人员信息表
select '销售服务人员信息表：T_PRP_LAAgent', '交易编码',count(TransactionNo),'公司编码','CompanyCode',count(CompanyCode) from  T_PRP_LAAgent where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '销售服务人员信息表：T_PRP_LAAgent', '交易编码',count(TransactionNo),'管理机构','ManageCom',count(ManageCom) from  T_PRP_LAAgent where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
select '销售服务人员信息表：T_PRP_LAAgent', '交易编码',count(TransactionNo),'性别','Sex',count(Sex) from  T_PRP_LAAgent where Sex not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='sex')  union
select '销售服务人员信息表：T_PRP_LAAgent', '交易编码',count(TransactionNo),'内勤标志','OfficeWorkFlag',count(OfficeWorkFlag) from T_PRP_LAAgent where OfficeWorkFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='officeworkflag')  union
select '销售服务人员信息表：T_PRP_LAAgent', '交易编码',count(TransactionNo),'是否专职标志','FullTimeFlag',count(FullTimeFlag) from  T_PRP_LAAgent where FullTimeFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='fulltimeflag')  union
select '销售服务人员信息表：T_PRP_LAAgent', '交易编码',count(TransactionNo),'证件类型','CertType',count(CertType) from  T_PRP_LAAgent where CertType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='certtype')  union
--暂收费表
select '暂收费表：T_PRP_LJTempFee', '交易编码',count(TransactionNo),'公司编码','CompanyCode',count(CompanyCode) from  T_PRP_LJTempFee where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '暂收费表：T_PRP_LJTempFee', '交易编码',count(TransactionNo),'管理机构','ManageCom',count(ManageCom) from  T_PRP_LJTempFee where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
select '暂收费表：T_PRP_LJTempFee', '交易编码',count(TransactionNo),'币别','Currency',count(Currency) from  T_PRP_LJTempFee where Currency not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='currency')  union
select '暂收费表：T_PRP_LJTempFee', '交易编码',count(TransactionNo),'证件类型','CertType',count(CertType) from  T_PRP_LJTempFee where CertType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='certtype')  union
--红利分配表
select '红利分配表：T_PRP_LJDivDistrib', '交易编码',count(TransactionNo),'公司编码','CompanyCode',count(CompanyCode) from  T_PRP_LJDivDistrib where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '红利分配表：T_PRP_LJDivDistrib', '交易编码',count(TransactionNo),'红利类型','DivType',count(DivType) from  T_PRP_LJDivDistrib where DivType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='divtype')  union
select '红利分配表：T_PRP_LJDivDistrib', '交易编码',count(TransactionNo),'红利分配方式','DivDistribMeth',count(DivDistribMeth) from  T_PRP_LJDivDistrib where DivDistribMeth not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='divdistribmeth')  union
select '红利分配表：T_PRP_LJDivDistrib', '交易编码',count(TransactionNo),'管理机构','ManageCom',count(ManageCom) from  T_PRP_LJDivDistrib where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
select '红利分配表：T_PRP_LJDivDistrib', '交易编码',count(TransactionNo),'证件类型','CertType',count(CertType) from  T_PRP_LJDivDistrib where CertType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='certtype')  union
--生存金领取表
select '生存金领取表：T_PRP_LJAGetLivBene', '交易编码',count(TransactionNo),'公司编码','CompanyCode',count(CompanyCode) from  T_PRP_LJAGetLivBene where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '生存金领取表：T_PRP_LJAGetLivBene', '交易编码',count(TransactionNo),'管理机构','ManageCom',count(ManageCom) from  T_PRP_LJAGetLivBene where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
select '生存金领取表：T_PRP_LJAGetLivBene', '交易编码',count(TransactionNo),'证件类型','CertType',count(CertType) from  T_PRP_LJAGetLivBene where CertType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='certtype')  union
--保费明细表
select '保费明细表：T_PRP_LJAPay', '交易编码',count(TransactionNo), '公司编码','CompanyCode',count(CompanyCode) from  T_PRP_LJAPay where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '保费明细表：T_PRP_LJAPay', '交易编码',count(TransactionNo), '管理机构','ManageCom',count(ManageCom) from  T_PRP_LJAPay where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
select '保费明细表：T_PRP_LJAPay', '交易编码',count(TransactionNo), '证件类型', 'CertType',count(CertType)  FROM T_PRP_LJAPay WHERE CertType NOT in(SELECT TARGET_CODE FROM T_DEF_code_mapping WHERE CODE_TYPE='certtype')  union
--险种定义表
select '险种定义表：T_PRP_T_PRP_LMProduct', '交易编码',count(TransactionNo), '公司编码','CompanyCode',count(CompanyCode)   FROM T_PRP_LMProduct WHERE CompanyCode NOT in(select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE ='companycode')  union
select '险种定义表：T_PRP_LMProduct', '交易编码',count(TransactionNo),'保险账户标记','InsuAccFlag',count(InsuAccFlag) from  T_PRP_LMProduct where InsuAccFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='insuaccflag')  union
select '险种定义表：T_PRP_LMProduct', '交易编码',count(TransactionNo),'险类','ProductType',count(ProductType) from  T_PRP_LMProduct where ProductType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='producttype')  union
select '险种定义表：T_PRP_LMProduct', '交易编码',count(TransactionNo),'投资类别','InvestmentType',count(InvestmentType) from  T_PRP_LMProduct where InvestmentType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='investmenttype')  union
select '险种定义表：T_PRP_LMProduct', '交易编码',count(TransactionNo),'长短险标志','TermType',count(TermType) from  T_PRP_LMProduct where TermType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='termtype')  union
select '险种定义表：T_PRP_LMProduct', '交易编码',count(TransactionNo),'个团标志','GPFlag',count(GPFlag) from  T_PRP_LMProduct where GPFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='gpflag')  union
select '险种定义表：T_PRP_LMProduct', '交易编码',count(TransactionNo),'主附险标志','MainProductFlag',count(MainProductFlag) from  T_PRP_LMProduct where MainProductFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='mainproductflag')  union
select '险种定义表：T_PRP_LMProduct', '交易编码',count(TransactionNo),'产品在售标记','SaleFlag',count(SaleFlag) from  T_PRP_LMProduct where SaleFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='saleflag')
) WHERE errorcounts > 0;

--非空校验
prompt create or replace views V_CHECK_ISNULL...
CREATE OR REPLACE VIEW V_CHECK_ISNULL AS
SELECT ERRORTABLE,COLNAME,ALLCOUNTS,ERRORMSG,ERRCOUNTS FROM (
  SELECT errortable,ColName,SUM(allcounts) AS allcounts,errormsg,SUM(counts) AS errcounts FROM (
  -- T_PRP_LMProduct
  select '险种定义表：T_PRP_LMProduct' AS errortable,'ProductName' ColName,1 AS allcounts,'产品名称为空' errormsg,(CASE WHEN ProductName IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LMProduct UNION ALL
  select '险种定义表：T_PRP_LMProduct' AS errortable,'AssumIntRate' ColName,1 AS allcounts,'预定利率为空' errormsg,(CASE WHEN AssumIntRate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LMProduct UNION ALL
  select '险种定义表：T_PRP_LMProduct' AS errortable,'ProductType' ColName,1 AS allcounts,'险类为空' errormsg,(CASE WHEN ProductType IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LMProduct UNION ALL
  select '险种定义表：T_PRP_LMProduct' AS errortable,'InvestmentType' ColName,1 AS allcounts,'投资类别为空' errormsg,(CASE WHEN InvestmentType IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LMProduct UNION ALL
  select '险种定义表：T_PRP_LMProduct' AS errortable,'TermType' ColName,1 AS allcounts,'长短险标志为空' errormsg,(CASE WHEN TermType IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LMProduct UNION ALL
  select '险种定义表：T_PRP_LMProduct' AS errortable,'GPFlag' ColName,1 AS allcounts,'个团标志为空' errormsg,(CASE WHEN GPFlag IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LMProduct UNION ALL
  select '险种定义表：T_PRP_LMProduct' AS errortable,'MainProductFlag' ColName,1 AS allcounts,'主附险标志为空' errormsg,(CASE WHEN MainProductFlag IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LMProduct UNION ALL
  -- T_PRP_LCPoltransaction
  select '保单交易信息表：T_PRP_LCPoltransaction' AS errortable,'TransAmnt' ColName,1 AS allcounts,'交易金额为空' errormsg,(CASE WHEN TransAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCPoltransaction UNION ALL
  select '保单交易信息表：T_PRP_LCPoltransaction' AS errortable,'TransDate' ColName,1 AS allcounts,'交易日期为空' errormsg,(CASE WHEN TransDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCPoltransaction UNION ALL
  -- T_PRP_LCCont
  select '保单信息表：T_PRP_LCCont' AS errortable,'PrtNo' ColName,1 AS allcounts,'印刷号码为空' errormsg,(CASE WHEN PrtNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'GPFlag' ColName,1 AS allcounts,'个团标志为空' errormsg,(CASE WHEN GPFlag IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'GPFlag' ColName,1 AS allcounts,'个团标1有效失败' errormsg,(CASE WHEN GPFlag = '1' THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'FamilyPolType' ColName,1 AS allcounts,'家庭单类型为空' errormsg,(CASE WHEN FamilyPolType IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'ManageCom' ColName,1 AS allcounts,'管理机构为空' errormsg,(CASE WHEN ManageCom IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'ManageComName' ColName,1 AS allcounts,'管理机构名称为空' errormsg,(CASE WHEN ManageComName IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'DistribChnl' ColName,1 AS allcounts,'销售渠道为空' errormsg,(CASE WHEN DistribChnl IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'AppntNo' ColName,1 AS allcounts,'投保人客户号码为空' errormsg,(CASE WHEN AppntNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'AppntName' ColName,1 AS allcounts,'投保人名称为空' errormsg,(CASE WHEN AppntName IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'AppntSex' ColName,1 AS allcounts,'投保人性别为空' errormsg,(CASE WHEN AppntSex IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'AppntBirthDate' ColName,1 AS allcounts,'投保人出生日期为空' errormsg,(CASE WHEN AppntBirthDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'AppntCertType' ColName,1 AS allcounts,'投保人证件类型为空' errormsg,(CASE WHEN AppntCertType IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'AppntCertNo' ColName,1 AS allcounts,'投保人证件号码为空' errormsg,(CASE WHEN AppntCertNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'PayMode' ColName,1 AS allcounts,'交费间隔为空' errormsg,(CASE WHEN PayMode IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'SignDate' ColName,1 AS allcounts,'签单日期为空' errormsg,(CASE WHEN SignDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'Currency' ColName,1 AS allcounts,'币别为空' errormsg,(CASE WHEN Currency IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'Copies' ColName,1 AS allcounts,'份数为空' errormsg,(CASE WHEN Copies IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'Premium' ColName,1 AS allcounts,'保费为空' errormsg,(CASE WHEN Premium IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'SumInsured' ColName,1 AS allcounts,'保额为空' errormsg,(CASE WHEN SumInsured IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'CashValue' ColName,1 AS allcounts,'现金价值为空' errormsg,(CASE WHEN CashValue IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'PolBalance' ColName,1 AS allcounts,'保单余额为空' errormsg,(CASE WHEN PolBalance IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'AccumPremium' ColName,1 AS allcounts,'累计保费为空' errormsg,(CASE WHEN AccumPremium IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'AccumLoanMoney' ColName,1 AS allcounts,'当前借款金额为空' errormsg,(CASE WHEN AccumLoanMoney IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'EffDate' ColName,1 AS allcounts,'保单生效日期为空' errormsg,(CASE WHEN EffDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'PolStatus' ColName,1 AS allcounts,'保单状态为空' errormsg,(CASE WHEN PolStatus IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'PolicyType' ColName,1 AS allcounts,'保单形式为空' errormsg,(CASE WHEN PolicyType IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '保单信息表：T_PRP_LCCont' AS errortable,'PolicyEndDate' ColName,1 AS allcounts,'保单满期日期为空' errormsg,(CASE WHEN PolicyEndDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  -- T_PRP_LCProdInsuRela
  select '被保险人险种关联表：T_PRP_LCProdInsuRela' AS errortable,'ManageCom' ColName,1 AS allcounts,'管理机构为空' errormsg,(CASE WHEN ManageCom IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProdInsuRela UNION ALL
  -- T_PRP_LCProduct
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'GPFlag' ColName,1 AS allcounts,'个团标志为空' errormsg,(CASE WHEN GPFlag IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'PolTypeFlag' ColName,1 AS allcounts,'保单类型标记为空' errormsg,(CASE WHEN PolTypeFlag IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'MainProductNo' ColName,1 AS allcounts,'主险保险险种号码为空' errormsg,(CASE WHEN MainProductNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'MainProductFlag' ColName,1 AS allcounts,'主附险标记为空' errormsg,(CASE WHEN MainProductFlag IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'ProductCode' ColName,1 AS allcounts,'产品编码为空' errormsg,(CASE WHEN ProductCode IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'ManageCom' ColName,1 AS allcounts,'管理机构为空' errormsg,(CASE WHEN ManageCom IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'EffDate' ColName,1 AS allcounts,'产品生效日期为空' errormsg,(CASE WHEN EffDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'InvalidDate' ColName,1 AS allcounts,'保险责任终止日期为空' errormsg,(CASE WHEN InvalidDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'PayMode' ColName,1 AS allcounts,'交费间隔为空' errormsg,(CASE WHEN PayMode IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'PayTerm' ColName,1 AS allcounts,'交费年期为空' errormsg,(CASE WHEN PayTerm IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'InsurancePeriodFlag' ColName,1 AS allcounts,'保险年期类型为空' errormsg,(CASE WHEN InsurancePeriodFlag IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'InsurancePeriod' ColName,1 AS allcounts,'保险年期为空' errormsg,(CASE WHEN InsurancePeriod IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'Copies' ColName,1 AS allcounts,'份数为空' errormsg,(CASE WHEN Copies IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'Premium' ColName,1 AS allcounts,'当期保费为空' errormsg,(CASE WHEN Premium IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'AccumPremium' ColName,1 AS allcounts,'累计保费为空' errormsg,(CASE WHEN AccumPremium IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'BasicSumInsured' ColName,1 AS allcounts,'基本保额为空' errormsg,(CASE WHEN BasicSumInsured IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'RiskAmnt' ColName,1 AS allcounts,'风险保额为空' errormsg,(CASE WHEN RiskAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'CashValue' ColName,1 AS allcounts,'现金价值为空' errormsg,(CASE WHEN CashValue IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'AccumDiv' ColName,1 AS allcounts,'累计红利金额为空' errormsg,(CASE WHEN AccumDiv IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'AccumDivInt' ColName,1 AS allcounts,'累计红利利息为空' errormsg,(CASE WHEN AccumDivInt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'AccumDivSI' ColName,1 AS allcounts,'累计红利保额为空' errormsg,(CASE WHEN AccumDivSI IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'SurrenderAmnt' ColName,1 AS allcounts,'退保金额为空' errormsg,(CASE WHEN SurrenderAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'AccumAnnuityWD' ColName,1 AS allcounts,'累计领取年金金额为空' errormsg,(CASE WHEN AccumAnnuityWD IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'AccumMaturityWD' ColName,1 AS allcounts,'满期金金额为空' errormsg,(CASE WHEN AccumMaturityWD IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'AccumClmBenefit' ColName,1 AS allcounts,'累计赔付金额为空' errormsg,(CASE WHEN AccumClmBenefit IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'AccumClmTimes' ColName,1 AS allcounts,'累计赔付次数为空' errormsg,(CASE WHEN AccumClmTimes IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '保单险种信息表：T_PRP_LCProduct' AS errortable,'Status' ColName,1 AS allcounts,'保单险种状态空' errormsg,(CASE WHEN Status IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  -- T_PRP_LCBnf
  select '受益人表：T_PRP_LCBnf' AS errortable,'ProductNo' ColName,1 AS allcounts,'个单保险险种号码为空' errormsg,(CASE WHEN ProductNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCBnf UNION ALL
  select '受益人表：T_PRP_LCBnf' AS errortable,'InsuredNo' ColName,1 AS allcounts,'被保人客户号码为空' errormsg,(CASE WHEN InsuredNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCBnf UNION ALL
  select '受益人表：T_PRP_LCBnf' AS errortable,'BnfCat' ColName,1 AS allcounts,'受益人类别为空' errormsg,(CASE WHEN BnfCat IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCBnf UNION ALL
  select '受益人表：T_PRP_LCBnf' AS errortable,'BnfLevel' ColName,1 AS allcounts,'受益人级别为空' errormsg,(CASE WHEN BnfLevel IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCBnf UNION ALL
  select '受益人表：T_PRP_LCBnf' AS errortable,'RelationToInsured' ColName,1 AS allcounts,'与被保人关系为空' errormsg,(CASE WHEN RelationToInsured IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCBnf UNION ALL
  select '受益人表：T_PRP_LCBnf' AS errortable,'PercentOfBenefit' ColName,1 AS allcounts,'受益比例为空' errormsg,(CASE WHEN PercentOfBenefit IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCBnf UNION ALL
  select '受益人表：T_PRP_LCBnf' AS errortable,'Name' ColName,1 AS allcounts,'受益人姓名为空' errormsg,(CASE WHEN Name IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCBnf UNION ALL
  -- T_PRP_LCInsured
  select '被保险人表：T_PRP_LCInsured' AS errortable,'ManageCom' ColName,1 AS allcounts,'管理机构为空' errormsg,(CASE WHEN ManageCom IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '被保险人表：T_PRP_LCInsured' AS errortable,'RelationToMainInsured' ColName,1 AS allcounts,'与主被保人关系为空' errormsg,(CASE WHEN RelationToMainInsured IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '被保险人表：T_PRP_LCInsured' AS errortable,'MainInsuredNo' ColName,1 AS allcounts,'主被保人客户号为空' errormsg,(CASE WHEN MainInsuredNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '被保险人表：T_PRP_LCInsured' AS errortable,'RelationToAppnt' ColName,1 AS allcounts,'与投保人关系为空' errormsg,(CASE WHEN RelationToAppnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '被保险人表：T_PRP_LCInsured' AS errortable,'InsuredName' ColName,1 AS allcounts,'被保人名称为空' errormsg,(CASE WHEN InsuredName IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '被保险人表：T_PRP_LCInsured' AS errortable,'InsuredSex' ColName,1 AS allcounts,'被保人性别为空' errormsg,(CASE WHEN InsuredSex IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '被保险人表：T_PRP_LCInsured' AS errortable,'InsuredBirthDate' ColName,1 AS allcounts,'被保人出生日期为空' errormsg,(CASE WHEN InsuredBirthDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '被保险人表：T_PRP_LCInsured' AS errortable,'InsuredCertNo' ColName,1 AS allcounts,'证件号码为空' errormsg,(CASE WHEN InsuredCertNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '被保险人表：T_PRP_LCInsured' AS errortable,'AppAge' ColName,1 AS allcounts,'投保时年龄为空' errormsg,(CASE WHEN AppAge IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '被保险人表：T_PRP_LCInsured' AS errortable,'Height' ColName,1 AS allcounts,'身高为空' errormsg,(CASE WHEN Height IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '被保险人表：T_PRP_LCInsured' AS errortable,'Weight' ColName,1 AS allcounts,'体重为空' errormsg,(CASE WHEN Weight IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '被保险人表：T_PRP_LCInsured' AS errortable,'Salary' ColName,1 AS allcounts,'年收入为空' errormsg,(CASE WHEN Salary IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '被保险人表：T_PRP_LCInsured' AS errortable,'OccupationType' ColName,1 AS allcounts,'职业代码为空' errormsg,(CASE WHEN OccupationType IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '被保险人表：T_PRP_LCInsured' AS errortable,'BMI' ColName,1 AS allcounts,'身体指标为空' errormsg,(CASE WHEN BMI IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  -- T_PRP_LCInsureAcc
  select '保险账户表：T_PRP_LCInsureAcc' AS errortable,'ManageCom' ColName,1 AS allcounts,'身体指标为空' errormsg,(CASE WHEN ManageCom IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsureAcc UNION ALL
  select '保险账户表：T_PRP_LCInsureAcc' AS errortable,'AccumCommission' ColName,1 AS allcounts,'累计手续费为空' errormsg,(CASE WHEN AccumCommission IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsureAcc UNION ALL
  select '保险账户表：T_PRP_LCInsureAcc' AS errortable,'AccumMngFee' ColName,1 AS allcounts,'累计保单管理费为空' errormsg,(CASE WHEN AccumMngFee IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsureAcc UNION ALL
  select '保险账户表：T_PRP_LCInsureAcc' AS errortable,'AccumRiskPremium' ColName,1 AS allcounts,'累计风险保费为空' errormsg,(CASE WHEN AccumRiskPremium IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsureAcc UNION ALL
  select '保险账户表：T_PRP_LCInsureAcc' AS errortable,'AccountDate' ColName,1 AS allcounts,'账户成立日期为空' errormsg,(CASE WHEN AccountDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsureAcc UNION ALL
  select '保险账户表：T_PRP_LCInsureAcc' AS errortable,'AccumPay' ColName,1 AS allcounts,'累计交费为空' errormsg,(CASE WHEN AccumPay IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsureAcc UNION ALL
  select '保险账户表：T_PRP_LCInsureAcc' AS errortable,'AccumDwAmnt' ColName,1 AS allcounts,'累计领取为空' errormsg,(CASE WHEN AccumDwAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsureAcc UNION ALL
  select '保险账户表：T_PRP_LCInsureAcc' AS errortable,'AccountValue' ColName,1 AS allcounts,'保险账户价值为空' errormsg,(CASE WHEN AccountValue IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsureAcc UNION ALL
  select '保险账户表：T_PRP_LCInsureAcc' AS errortable,'AccountUnitNumber' ColName,1 AS allcounts,'保险账户单位数为空' errormsg,(CASE WHEN AccountUnitNumber IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsureAcc UNION ALL
  -- T_PRP_LLClaimPolicy
  select '理赔保单明细表：T_PRP_LLClaimPolicy' AS errortable,'ClmRegisterNo' ColName,1 AS allcounts,'立案号为空' errormsg,(CASE WHEN ClmRegisterNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '理赔保单明细表：T_PRP_LLClaimPolicy' AS errortable,'BenefitType' ColName,1 AS allcounts,'赔付责任类型为空' errormsg,(CASE WHEN BenefitType IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '理赔保单明细表：T_PRP_LLClaimPolicy' AS errortable,'Currency' ColName,1 AS allcounts,'币别为空' errormsg,(CASE WHEN Currency IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '理赔保单明细表：T_PRP_LLClaimPolicy' AS errortable,'ClmAcountAmnt' ColName,1 AS allcounts,'核算赔付金额为空' errormsg,(CASE WHEN ClmAcountAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '理赔保单明细表：T_PRP_LLClaimPolicy' AS errortable,'ClmAssessAmnt' ColName,1 AS allcounts,'核赔赔付金额为空' errormsg,(CASE WHEN ClmAssessAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '理赔保单明细表：T_PRP_LLClaimPolicy' AS errortable,'RejectAmnt' ColName,1 AS allcounts,'拒赔金额为空' errormsg,(CASE WHEN RejectAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '理赔保单明细表：T_PRP_LLClaimPolicy' AS errortable,'PrePayAmnt' ColName,1 AS allcounts,'预付金额为空' errormsg,(CASE WHEN PrePayAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '理赔保单明细表：T_PRP_LLClaimPolicy' AS errortable,'ApproveAmnt' ColName,1 AS allcounts,'通融给付金额合计为空' errormsg,(CASE WHEN ApproveAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '理赔保单明细表：T_PRP_LLClaimPolicy' AS errortable,'AgreeAmnt' ColName,1 AS allcounts,'协议给付合计为空' errormsg,(CASE WHEN AgreeAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '理赔保单明细表：T_PRP_LLClaimPolicy' AS errortable,'ClmSettDate' ColName,1 AS allcounts,'结案日期为空' errormsg,(CASE WHEN ClmSettDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '理赔保单明细表：T_PRP_LLClaimPolicy' AS errortable,'PayStatusCode' ColName,1 AS allcounts,'核赔结论类型为空' errormsg,(CASE WHEN PayStatusCode IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '理赔保单明细表：T_PRP_LLClaimPolicy' AS errortable,'ManageCom' ColName,1 AS allcounts,'管理机构为空' errormsg,(CASE WHEN ManageCom IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  -- T_PRP_LLBnf
  select '理赔受益人账户表：T_PRP_LLBnf' AS errortable,'InsuredNo' ColName,1 AS allcounts,'被保人客户号码为空' errormsg,(CASE WHEN InsuredNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLBnf UNION ALL
  select '理赔受益人账户表：T_PRP_LLBnf' AS errortable,'BnfCat' ColName,1 AS allcounts,'受益人类别为空' errormsg,(CASE WHEN BnfCat IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLBnf UNION ALL
  select '理赔受益人账户表：T_PRP_LLBnf' AS errortable,'BnfLevel' ColName,1 AS allcounts,'受益人级别为空' errormsg,(CASE WHEN BnfLevel IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLBnf UNION ALL
  select '理赔受益人账户表：T_PRP_LLBnf' AS errortable,'RelationToInsured' ColName,1 AS allcounts,'受益人与被保人关系为空' errormsg,(CASE WHEN RelationToInsured IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLBnf UNION ALL
  select '理赔受益人账户表：T_PRP_LLBnf' AS errortable,'Name' ColName,1 AS allcounts,'受益人姓名为空' errormsg,(CASE WHEN Name IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLBnf UNION ALL
  select '理赔受益人账户表：T_PRP_LLBnf' AS errortable,'PercentOfBenefit' ColName,1 AS allcounts,'受益比例为空' errormsg,(CASE WHEN PercentOfBenefit IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLBnf UNION ALL
  select '理赔受益人账户表：T_PRP_LLBnf' AS errortable,'DrawingAmnt' ColName,1 AS allcounts,'受益金额为空' errormsg,(CASE WHEN DrawingAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLBnf UNION ALL
  -- T_PRP_LASales
  select '保险公司销售服务人员信息表：T_PRP_LASales' AS errortable,'ManageCom' ColName,1 AS allcounts,'管理机构为空' errormsg,(CASE WHEN ManageCom IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LASales UNION ALL
  select '保险公司销售服务人员信息表：T_PRP_LASales' AS errortable,'Name' ColName,1 AS allcounts,'姓名为空' errormsg,(CASE WHEN Name IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LASales UNION ALL
  select '保险公司销售服务人员信息表：T_PRP_LASales' AS errortable,'BusiDevCertifNo' ColName,1 AS allcounts,'执业证号码为空' errormsg,(CASE WHEN BusiDevCertifNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LASales UNION ALL
  select '保险公司销售服务人员信息表：T_PRP_LASales' AS errortable,'AgentSignFlag' ColName,1 AS allcounts,'是否签署代理合同为空' errormsg,(CASE WHEN AgentSignFlag IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LASales UNION ALL
  select '保险公司销售服务人员信息表：T_PRP_LASales' AS errortable,'SaleSvcFlag' ColName,1 AS allcounts,'销售服务人员标志为空' errormsg,(CASE WHEN SaleSvcFlag IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LASales UNION ALL
  -- T_PRP_LAAgent
  select '保险中介渠道及从业人员信息表：T_PRP_LAAgent' AS errortable,'ManageCom' ColName,1 AS allcounts,'管理机构为空' errormsg,(CASE WHEN ManageCom IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LAAgent UNION ALL
  select '保险中介渠道及从业人员信息表：T_PRP_LAAgent' AS errortable,'AgencyName' ColName,1 AS allcounts,'代理或经纪机构名称为空' errormsg,(CASE WHEN AgencyName IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LAAgent UNION ALL
  select '保险中介渠道及从业人员信息表：T_PRP_LAAgent' AS errortable,'BusiDevCertifNo' ColName,1 AS allcounts,'执业证号码为空' errormsg,(CASE WHEN BusiDevCertifNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LAAgent UNION ALL
  select '保险中介渠道及从业人员信息表：T_PRP_LAAgent' AS errortable,'AgentSignFlag' ColName,1 AS allcounts,'是否签署代理合同为空' errormsg,(CASE WHEN AgentSignFlag IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LAAgent UNION ALL
  -- T_PRP_LJDivDistrib
  select '红利分配表：T_PRP_LJDivDistrib' AS errortable,'DivAmnt' ColName,1 AS allcounts,'红利金额为空' errormsg,(CASE WHEN DivAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJDivDistrib UNION ALL
  select '红利分配表：T_PRP_LJDivDistrib' AS errortable,'AppntNo' ColName,1 AS allcounts,'投保人客户号码为空' errormsg,(CASE WHEN AppntNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJDivDistrib UNION ALL
  select '红利分配表：T_PRP_LJDivDistrib' AS errortable,'AppntName' ColName,1 AS allcounts,'投保人名称为空' errormsg,(CASE WHEN AppntName IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJDivDistrib UNION ALL
  -- T_PRP_LJAGetLivBene
  select '生存金领取表：T_PRP_LJAGetLivBene' AS errortable,'AppntNo' ColName,1 AS allcounts,'投保人客户号码为空' errormsg,(CASE WHEN AppntNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAGetLivBene UNION ALL
  select '生存金领取表：T_PRP_LJAGetLivBene' AS errortable,'InsuredNo' ColName,1 AS allcounts,'被保人客户号码为空' errormsg,(CASE WHEN InsuredNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAGetLivBene UNION ALL
  select '生存金领取表：T_PRP_LJAGetLivBene' AS errortable,'BenefitDate' ColName,1 AS allcounts,'给付日期为空' errormsg,(CASE WHEN BenefitDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAGetLivBene UNION ALL
  select '生存金领取表：T_PRP_LJAGetLivBene' AS errortable,'BenefitAmount' ColName,1 AS allcounts,'给付金额为空' errormsg,(CASE WHEN BenefitAmount IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAGetLivBene UNION ALL
  -- T_PRP_LJAPay
  select '保费明细表：T_PRP_LJAPay' AS errortable,'ProductCode' ColName,1 AS allcounts,'产品编码为空' errormsg,(CASE WHEN ProductCode IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAPay UNION ALL
  select '保费明细表：T_PRP_LJAPay' AS errortable,'ManageCom' ColName,1 AS allcounts,'管理机构为空' errormsg,(CASE WHEN ManageCom IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAPay UNION ALL
  select '保费明细表：T_PRP_LJAPay' AS errortable,'AppntNo' ColName,1 AS allcounts,'投保人客户号码为空' errormsg,(CASE WHEN AppntNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAPay UNION ALL
  select '保费明细表：T_PRP_LJAPay' AS errortable,'SumActuPayMoney' ColName,1 AS allcounts,'实交金额为空' errormsg,(CASE WHEN SumActuPayMoney IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAPay UNION ALL
  select '保费明细表：T_PRP_LJAPay' AS errortable,'EnterAccDate' ColName,1 AS allcounts,'到账日期为空' errormsg,(CASE WHEN EnterAccDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAPay UNION ALL
  select '保费明细表：T_PRP_LJAPay' AS errortable,'ConfDate' ColName,1 AS allcounts,'到账日期为空' errormsg,(CASE WHEN ConfDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAPay UNION ALL
  select '保费明细表：T_PRP_LJAPay' AS errortable,'EnterAccDate' ColName,1 AS allcounts,'到账日期为空' errormsg,(CASE WHEN EnterAccDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAPay UNION ALL
  select '保费明细表：T_PRP_LJAPay' AS errortable,'EnterAccDate' ColName,1 AS allcounts,'确认日期为空' errormsg,(CASE WHEN EnterAccDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAPay UNION ALL
  -- T_PRP_LJAGet
  select '付费明细表：T_PRP_LJAGet' AS errortable,'PrtNo' ColName,1 AS allcounts,'印刷号码为空' errormsg,(CASE WHEN PrtNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAGet UNION ALL
  select '付费明细表：T_PRP_LJAGet' AS errortable,'GetWay' ColName,1 AS allcounts,'付费方式为空' errormsg,(CASE WHEN GetWay IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAGet UNION ALL
  select '付费明细表：T_PRP_LJAGet' AS errortable,'Currency' ColName,1 AS allcounts,'币别为空' errormsg,(CASE WHEN Currency IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAGet UNION ALL
  select '付费明细表：T_PRP_LJAGet' AS errortable,'SumActuGetMoney' ColName,1 AS allcounts,'实付金额为空' errormsg,(CASE WHEN SumActuGetMoney IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAGet UNION ALL
  select '付费明细表：T_PRP_LJAGet' AS errortable,'EnterAccDate' ColName,1 AS allcounts,'到账日期为空' errormsg,(CASE WHEN EnterAccDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAGet UNION ALL
  select '付费明细表：T_PRP_LJAGet' AS errortable,'ConfDate' ColName,1 AS allcounts,'确认日期为空' errormsg,(CASE WHEN ConfDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAGet
) GROUP BY errortable,ColName,errormsg ) WHERE errcounts > 0 ORDER BY errortable;
prompt create or replace views OVER 