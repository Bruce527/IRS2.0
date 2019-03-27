prompt PL/SQL Developer import file
prompt create or replace views
prompt Created on 2016��11��14�� by gyas-itpingw
set feedback off
set define off
-- �������У��
prompt create or replace views V_CHECK_EXITORNOT...
CREATE OR REPLACE VIEW V_CHECK_EXITORNOT AS
SELECT ERRORTABLE,COLNAME,ALLCOUNTS,ERRORMSG,ERRCOUNTS FROM (
SELECT errortable,ColName,SUM(allcounts) AS allcounts,errormsg,sum(errcounts) AS errcounts FROM(
 select '������Ϣ��LCCont' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '�ڽ��ױ�����' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lcpoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_lCCont o
   UNION ALL
   select '������Ϣ��LCPoltransaction' AS errortable,'NOT IN LCCont' ColName,1 AS allcounts,
          '�ڱ���������' errormsg,
          (CASE WHEN EXISTS
          (SELECT 'E'
             FROM t_prp_lCCont t
            WHERE t.transactionno = o.transactionno
             AND t.policyno = o.policyno
             )
           THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_lcpoltransaction o
   UNION ALL
 select '������������Ϣ��LCBnf' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '�ڽ��ױ�����' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lcpoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCBnf o
  UNION ALL
 select '������Ϣ��lCCont' AS errortable,'NOT IN lcpoltransaction' ColName,1 AS allcounts,
        '�ڱ���������' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lcpoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_lCCont o
     UNION ALL
 select '��������Ϣ��LCInsured' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '�ڽ��ױ�����' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lcpoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCInsured o
        UNION ALL
 select '��������Ϣ��LCInsured' AS errortable,'NOT IN LCCont' ColName,1 AS allcounts,
        '�ڱ���������' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lCCont t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCInsured o
    UNION ALL
 select '����������Ϣ��LCProduct' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '�ڽ��ױ�����' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lcpoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
          THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCProduct o
        UNION ALL
 select '����������Ϣ��LCProduct' AS errortable,'NOT IN LCCont' ColName,1 AS allcounts,
        '�ڱ���������' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lCCont t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
          THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCProduct o
   UNION ALL
 select '����������Ϣ��LCProduct' AS errortable,'NOT IN LMProduct' ColName,1 AS allcounts,
        '�����ֶ��������' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LMProduct t
          WHERE t.productcode = o.productcode
           )
          THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCProduct o
    UNION ALL
 select '�����˻���LCInsureAcc' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '�ڽ��ױ�����' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lcpoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCInsureAcc o
       UNION ALL
 select '�����˻���LCInsureAcc' AS errortable,'NOT IN LCInsured' ColName,1 AS allcounts,
        '�ڽ��ױ�����' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LCInsured t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCInsureAcc o
    UNION ALL
 select '���ֱ����˹�����LCProdInsuRela' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '�ڽ��ױ�����' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lcpoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCProdInsuRela o
    UNION ALL
   select '���ֱ����˹�����LCProdInsuRela' AS errortable,'NOT IN LCCont' ColName,1 AS allcounts,
          '�ڱ���������' errormsg,
          (CASE WHEN EXISTS
          (SELECT 'E'
             FROM t_prp_lCCont t
            WHERE t.transactionno = o.transactionno
             AND t.policyno = o.policyno
             )
           THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCProdInsuRela o
       UNION ALL
   select '���ֱ����˹�����LCProdInsuRela' AS errortable,'NOT IN LCInsured' ColName,1 AS allcounts,
          '�ڱ���������' errormsg,
          (CASE WHEN EXISTS
          (SELECT 'E'
             FROM t_prp_LCInsured t
            WHERE t.transactionno = o.transactionno
             AND t.policyno = o.policyno
             AND t.insuredno = t.insuredno
             )
           THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCProdInsuRela o
          UNION ALL
    select '���ֱ����˹�����LCProdInsuRela' AS errortable,'NOT IN LCProduct' ColName,1 AS allcounts,
            '�ڱ���������' errormsg,
            (CASE WHEN EXISTS
            (SELECT 'E'
               FROM t_prp_LCProduct t
              WHERE t.transactionno = o.transactionno
               AND t.policyno = o.policyno
               AND t.productno = o.productno
               )
             THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCProdInsuRela o
 UNION ALL
 select '������Ϣ��LCCont' AS errortable,'NOT IN LCProdInsuRela' ColName,1 AS allcounts,
        '�����ֹ���������' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LCProdInsuRela t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_lCCont o
   UNION ALL
 select '��������Ϣ��LCInsured' AS errortable,'NOT IN LCProdInsuRela' ColName,1 AS allcounts,
        '�����ֹ���������' errormsg,
        (CASE WHEN EXISTS
        (SELECT DISTINCT 'E'
           FROM t_prp_LCProdInsuRela t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           AND t.insuredno = o.insuredno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCInsured o
    UNION ALL
  select '�������ֱ�LCProduct' AS errortable,'NOT IN LCProdInsuRela' ColName,1 AS allcounts,
         '�����ֹ���������' errormsg,
          (CASE WHEN EXISTS
          (SELECT 'E'
             FROM t_prp_LCProdInsuRela t
            WHERE t.transactionno = o.transactionno
             AND t.policyno = o.policyno
             AND t.productNo = o.productNo
             )
           THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCProduct o
    UNION ALL
  select '������Ϣ��LCCont' AS errortable,'NOT IN LCProduct' ColName,1 AS allcounts,
          '�����ֱ�����' errormsg,
          (CASE WHEN EXISTS
          (SELECT 'E'
             FROM t_prp_LCProduct t
            WHERE t.transactionno = o.transactionno
             AND t.policyno = o.policyno
             )
           THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_lCCont o
    UNION ALL
 select '���澭��ȡ��LJAGetLivBene' AS errortable,'NOT IN LCCont' ColName,1 AS allcounts,
        '�ڱ���������' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lCCont t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LJAGetLivBene o
    UNION ALL
 select '������ȡϢ��LJDivDistrib' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '�ڽ��ױ�����' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LCPoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LJDivDistrib o
   UNION ALL
 select '������ȡϢ��LJDivDistrib' AS errortable,'NOT IN LCCont' ColName,1 AS allcounts,
        '�ڱ���������' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lCCont t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LJDivDistrib o
    UNION ALL
 select '������ϸ��LJAPay' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '�ڽ��ױ�����' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LCPoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LJApay o
 UNION ALL
 select '������ϸ��LJAPay' AS errortable,'NOT IN LCCont' ColName,1 AS allcounts,
        '�ڱ���������' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lCCont t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_lJApay o
    UNION ALL
 select '������Ϣ��Ϣ��LJAGet' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '�ڽ��ױ�����' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LCPoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LJAGet o
  UNION ALL
 select '������Ϣ��Ϣ��LJAGet' AS errortable,'NOT IN LCCont' ColName,1 AS allcounts,
        '�ڽ��ױ�����' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lCCont t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LJAGet o
    UNION ALL
 select '������Ա��Ϣ��LAAgent' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '�ڽ��ױ�����' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_lcpoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LAAgent o
    UNION ALL
 select '������Ա��Ϣ��LASales' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '�ڽ��ױ�����' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LCPoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LASales o
    UNION ALL
 select '������Ϣ��LLClaimPolicy' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '�ڽ��ױ�����' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LCPoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LLClaimPolicy o
    UNION ALL
 select '������������Ϣ��LLBnf' AS errortable,'NOT IN LCPoltransaction' ColName,1 AS allcounts,
        '�ڽ��ױ�����' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LCPoltransaction t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LCBnf o
    UNION ALL
 select '������Ϣ��LLClaimPolicy' AS errortable,'NOT IN LLBnf' ColName,1 AS allcounts,
        '�����������˱�����' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LLBnf t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           AND t.ClaimNo = o.ClmCaseNo
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LLClaimPolicy o
    UNION ALL
 select '������������Ϣ��LLBnf' AS errortable,'NOT IN LLClaimPolicy' ColName,1 AS allcounts,
        '��������������Ϣ������' errormsg,
        (CASE WHEN EXISTS
        (SELECT DISTINCT 'E'
           FROM t_prp_LLClaimPolicy t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           AND t.ClmCaseNo = o.ClaimNo
           )
         THEN 0 ELSE 1 END) AS errcounts  FROM t_prp_LLBnf o
    UNION ALL
 select '���ֹ�����LCProdInsuRela' AS errortable,'NOT IN LCInsured' ColName,1 AS allcounts,
        '�ڱ����˱�����' errormsg,
        (CASE WHEN EXISTS
        (SELECT 'E'
           FROM t_prp_LCInsured t
          WHERE t.transactionno = o.transactionno
           AND t.policyno = o.policyno
           AND t.insuredno = o.insuredno
           )
         THEN 0 ELSE 1 END) AS errcounts FROM t_prp_LCProdInsuRela o
    UNION ALL
 select '���ֹ�����LCProdInsuRela' AS errortable,'NOT IN LCProduct' ColName,1 AS allcounts,
        '�����ֱ�����' errormsg,
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

--Ψһ��У��
prompt create or replace views V_CHECK_ONLY...
CREATE OR REPLACE VIEW V_CHECK_ONLY AS
SELECT ERRORTABLE,COLNAME,ALLCOUNTS,ERRORMSG,ERRCOUNTS FROM (
SELECT errortable,colname,sum(allcounts) AS allcounts,errormsg,SUM(counts) AS errcounts FROM (
select '����������Ϣ��T_PRP_LCPoltransaction' AS errortable,'TransactionNo' ColName,count(1) AS allcounts,'Ψһ��У��ʧ��' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from T_PRP_LCPoltransaction GROUP BY TransactionNo UNION ALL
select '������Ϣ��T_PRP_LCCont' AS errortable,'TransactionNo,PolicyNo' ColName,count(1) AS allcounts,'Ψһ��У��ʧ��' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LCCont GROUP BY TransactionNo,PolicyNo UNION ALL
select '�������˱�T_PRP_LCInsured' AS errortable,'TransactionNo,PolicyNo,InsuredNo' ColName,count(1) AS allcounts,'Ψһ��У��ʧ��' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LCInsured GROUP BY TransactionNo,PolicyNo,InsuredNo UNION ALL
select '�����˱�T_PRP_LCBnf' AS errortable,'TransactionNo,PolicyNo,ProductNo,BnfSerialNum' ColName,count(1) AS allcounts,'Ψһ��У��ʧ��' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LCBnf GROUP BY TransactionNo,PolicyNo,ProductNo,BnfSerialNum UNION ALL
select '����������Ϣ��T_PRP_LCProduct' AS errortable,'TransactionNo,PolicyNo,ProductNo' ColName,count(1) AS allcounts,'Ψһ��У��ʧ��' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LCProduct GROUP BY TransactionNo,PolicyNo,ProductNo UNION ALL
select '�����������ֹ�����T_PRP_LCProdInsuRela' AS errortable,'TransactionNo,PolicyNo,ProductNo,InsuredNo' ColName,count(1) AS allcounts,'Ψһ��У��ʧ��' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LCProdInsuRela GROUP BY TransactionNo,PolicyNo,ProductNo,InsuredNo UNION ALL
select '�����˻���T_PRP_LCInsureAcc' AS errortable,'TransactionNo,PolicyNo,ProductNo,InsuAccNo,AccType' ColName,count(1) AS allcounts,'Ψһ��У��ʧ��' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LCInsureAcc GROUP BY TransactionNo,PolicyNo,ProductNo,InsuAccNo,AccType UNION ALL
select '������ϸ��T_PRP_LJAGet' AS errortable,'TransactionNo,PolicyNo,ActuGetNo,GetType' ColName,count(1) AS allcounts,'Ψһ��У��ʧ��' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LJAGet GROUP BY TransactionNo,PolicyNo,ActuGetNo,GetType UNION ALL
select '������ϸ��T_PRP_LJAPay' AS errortable,'TransactionNo,PolicyNo,PayNo,ProductNo' ColName,count(1) AS allcounts,'Ψһ��У��ʧ��' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LJAPay GROUP BY TransactionNo,PolicyNo,PayNo,ProductNo UNION ALL
select '�������ȡ��T_PRP_LJAGetLivBene' AS errortable,'TransactionNo,PolicyNo,ProductNo,WDNo' ColName,count(1) AS allcounts,'Ψһ��У��ʧ��' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LJAGetLivBene GROUP BY TransactionNo,PolicyNo,ProductNo,WDNo UNION ALL
select '���������T_PRP_LJDivDistrib' AS errortable,'TransactionNo,PolicyNo,ProductNo,DivYear,DivType,DivDistribMeth' ColName,count(1) AS allcounts,'Ψһ��У��ʧ��' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LJDivDistrib GROUP BY TransactionNo,PolicyNo,ProductNo,DivYear,DivType,DivDistribMeth UNION ALL
select '�����н���������ҵ��Ա��Ϣ��T_PRP_LAAgent' AS errortable,'TransactionNo,PolicyNo,AgencyCode,AgentCode' ColName,count(1) AS allcounts,'Ψһ��У��ʧ��' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LAAgent GROUP BY TransactionNo,PolicyNo,AgencyCode,AgentCode UNION ALL
select '���չ�˾���۷�����Ա��Ϣ��T_PRP_LASales' AS errortable,'TransactionNo,PolicyNo,AgentCode' ColName,count(1) AS allcounts,'Ψһ��У��ʧ��' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LASales GROUP BY TransactionNo,PolicyNo,AgentCode UNION ALL
select '���Ᵽ����ϸ��T_PRP_LLClaimPolicy' AS errortable,'TransactionNo,PolicyNo,ClmCaseNo,ProductNo,BenefitType' ColName,count(1) AS allcounts,'Ψһ��У��ʧ��' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy GROUP BY TransactionNo,PolicyNo,ClmCaseNo,ProductNo,BenefitType UNION ALL
select '�����������˻���T_PRP_LLBnf' AS errortable,'TransactionNo,ClaimNo,PolicyNo,ProductNo,BnfSerialNum' ColName,count(1) AS allcounts,'Ψһ��У��ʧ��' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LLBnf GROUP BY TransactionNo,ClaimNo,PolicyNo,ProductNo,BnfSerialNum UNION ALL
select '���ֶ����T_PRP_LMProduct' AS errortable,'TransactionNo,CompanyCode,ProductCode' ColName,count(1) AS allcounts,'Ψһ��У��ʧ��' errormsg,(CASE WHEN count(1) > 1 THEN count(1) ELSE 0 END) AS counts from  T_PRP_LMProduct GROUP BY TransactionNo,CompanyCode,ProductCode
) GROUP BY errortable,ColName,errormsg ) WHERE errcounts > 0 ORDER BY errortable;

--ת��У��
prompt create or replace views V_CHECK_TRANSCODE...
CREATE OR REPLACE VIEW V_CHECK_TRANSCODE AS
SELECT ERRORTABLE,CHECKINFO,ALLCOUNTS,COMPANYCODE,TRANSCOL,ERRORCOUNTS FROM (
--�������ױ�
select '�������ױ�:T_PRP_LCPolTransaction' AS  ErrorTable, '���ױ���' AS  CHeckInfo,count(TransactionNo) AS AllCounts, '��˾����' AS CompanyCode,'CompanyCode' AS TransCol,count(CompanyCode) AS ErrorCounts
from T_PRP_lcpoltransaction
where CompanyCode NOT IN ( select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode') union
select '�������ױ�:T_PRP_LCPolTransaction', '���ױ���',count(TransactionNo),'ҵ������','busstype',count(BussType) from  T_PRP_lcpoltransaction where busstype not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='busstype')  union
select '�������ױ�:T_PRP_LCPolTransaction', '���ױ���',count(TransactionNo),'֤������','CertType',count(CertType) from  T_PRP_lcpoltransaction where certtype not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='certtype')  union
--���˱�����
select '���˱�����:T_PRP_LCCont', '���ױ���',count(TransactionNo),'��˾����','CompanyCode',count(CompanyCode) from  T_PRP_LCCont where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '���˱�����:T_PRP_LCCont', '���ױ���',count(TransactionNo),'���ű�־','GPFlag',count(GPFlag) from  T_PRP_lccont where GPFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='gpflag')  union
select '���˱�����:T_PRP_LCCont', '���ױ���',count(TransactionNo),'��ͥ������','FamilyPolType',count(FamilyPolType) from  T_PRP_lccont where FamilyPolType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='familypoltype')  union
select '���˱�����:T_PRP_LCCont', '���ױ���',count(TransactionNo),'�������','ManageCom',count(ManageCom) from  T_PRP_lccont where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
select '���˱�����:T_PRP_LCCont', '���ױ���',count(TransactionNo),'��������','DistribChnl',count(DistribChnl) from  T_PRP_lccont where DistribChnl not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='distribchnl')  union
select '���˱�����:T_PRP_LCCont', '���ױ���',count(TransactionNo),'Ͷ�����Ա�','AppntSex',count(AppntSex) from  T_PRP_lccont where AppntSex not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='sex')  union
select '���˱�����:T_PRP_LCCont', '���ױ���',count(TransactionNo),'Ͷ����֤������','AppntCertType',count(AppntCertType) from  T_PRP_lccont where AppntCertType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='certtype')  union
select '���˱�����:T_PRP_LCCont', '���ױ���',count(TransactionNo),'ʡ','Province',count(Province) from  T_PRP_lccont where Province not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='city')  union
select '���˱�����:T_PRP_LCCont', '���ױ���',count(TransactionNo),'��','City',count(City) from  T_PRP_lccont where Province not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='city')  union
select '���˱�����:T_PRP_LCCont', '���ױ���',(SELECT COUNT(t.transactionno) FROM T_PRP_lccont t GROUP BY t.transactionno) AS allcount,'��/��','County',count(1) from  T_PRP_lccont WHERE County IS NOT NULL AND County not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='city') AND County not in (select BASIC_CODE from T_DEF_code_mapping where CODE_TYPE='city') GROUP BY TransactionNo  union
select '���˱�����:T_PRP_LCCont', '���ױ���',count(TransactionNo),'���Ѽ��','PayMode',count(PayMode) from  T_PRP_lccont where PayMode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='paymode')  union
select '���˱�����:T_PRP_LCCont', '���ױ���',count(TransactionNo),'���ѷ�ʽ','PayWay',count(PayWay) from  T_PRP_lccont where PayWay not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='payway')  union
select '���˱�����:T_PRP_LCCont', '���ױ���',count(TransactionNo),'�ұ�','Currency',count(Currency) from  T_PRP_lccont where Currency not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='currency')  union
select '���˱�����:T_PRP_LCCont', '���ױ���',count(TransactionNo),'�˱�����','UWType',count(UWType) from  T_PRP_lccont where UWType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='uwtype')  union
select '���˱�����:T_PRP_LCCont', '���ױ���',count(TransactionNo),'����״̬','PolStatus',count(PolStatus) from  T_PRP_lccont where PolStatus not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='polstatus')  union
select '���˱�����:T_PRP_LCCont', '���ױ���',count(TransactionNo),'������ʽ','PolicyType',count(PolicyType) from  T_PRP_lccont where PolicyType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='policytype')  union
select '���˱�����:T_PRP_LCCont', '���ױ���',count(TransactionNo),'������ֹԭ��','TerminationReason',count(TerminationReason) from  T_PRP_lccont where TerminationReason not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='terminationreason')  union
--�����������ֹ�����
select '�����������ֹ�����T_PRP_LCProdInsuRela', '���ױ���',count(TransactionNo),'��˾����','CompanyCode',count(CompanyCode) from  T_PRP_LCProdInsuRela where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '�����������ֹ�����T_PRP_LCProdInsuRela', '���ױ���',count(TransactionNo),'�������','ManageCom',count(ManageCom) from  T_PRP_LCProdInsuRela where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
select '�������ֱ�T_PRP_LCProduct', '���ױ���',count(TransactionNo),'�������ͱ��','PolTypeFlag',count(PolTypeFlag) from  T_PRP_LCProduct where PolTypeFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='poltypeflag')  union
select '�������ֱ�T_PRP_LCProduct', '���ױ���',count(TransactionNo),'�����ձ��','PMainProductFlag',count(MainProductFlag) from  T_PRP_LCProduct where MainProductFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='mainproductflag')  union
select '�������ֱ�T_PRP_LCProduct', '���ױ���',count(TransactionNo),'�������','ManageCom',count(ManageCom) from  T_PRP_LCProduct where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
select '�������ֱ�T_PRP_LCProduct', '���ױ���',count(TransactionNo),'���Ѽ��', 'PayMode',count(PayMode) from  T_PRP_LCProduct where PayMode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='paymode')  union
select '�������ֱ�T_PRP_LCProduct', '���ױ���',count(TransactionNo),'������������','PayTermType',count(PayTermType) from  T_PRP_LCProduct where PayTermType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='paytermtype')  union
select '�������ֱ�T_PRP_LCProduct', '���ױ���',count(TransactionNo),'������������','InsurancePeriodFlag',count(InsurancePeriodFlag) from  T_PRP_LCProduct where InsurancePeriodFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='insuranceperiodflag')  union
select '�������ֱ�T_PRP_LCProduct', '���ױ���',count(TransactionNo),'������������','InsuredType',count(InsuredType) from  T_PRP_LCProduct where InsuredType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='insuredtype')  union
select '�������ֱ�T_PRP_LCProduct', '���ױ���',count(TransactionNo),'�˱�����','UWConclusion',count(UWConclusion) from  T_PRP_LCProduct where UWConclusion not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='uwconclusion')  union
select '�������ֱ�T_PRP_LCProduct', '���ױ���',count(TransactionNo),'��������״̬','Status',count(Status) from  T_PRP_LCProduct where Status not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='polstatus')  union
--�����˱�
select '�����˱�T_PRP_LCBnf', '���ױ���',count(TransactionNo),'��˾����','CompanyCode',count(CompanyCode) from  T_PRP_LCBnf where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '�����˱�T_PRP_LCBnf', '���ױ���',count(TransactionNo),'���������','BnfCat',count(BnfCat) from  T_PRP_LCBnf where BnfCat not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='bnfcat')  union
select '�����˱�T_PRP_LCBnf', '���ױ���',count(TransactionNo),'�����˼���','BnfLevel',count(BnfLevel) from  T_PRP_LCBnf where BnfLevel not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='bnflevel')  union
select '�����˱�T_PRP_LCBnf', '���ױ���',count(TransactionNo),'�뱻���˹�ϵ','RelationToInsured',count(RelationToInsured) from  T_PRP_LCBnf where RelationToInsured not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='relationtoinsured')  union
select '�����˱�T_PRP_LCBnf', '���ױ���',count(TransactionNo),'�������Ա�','Sex',count(Sex) from  T_PRP_LCBnf where Sex not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='sex')  union
select '�����˱�T_PRP_LCBnf', '���ױ���',count(TransactionNo),'������֤������','CertType',count(CertType) from  T_PRP_LCBnf where CertType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='certtype')  union
--�������˱�
select '�������˱�T_PRP_LCInsured', '���ױ���',count(TransactionNo),'��˾����','CompanyCode',count(CompanyCode) from  T_PRP_LCInsured where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '�������˱�T_PRP_LCInsured', '���ױ���',count(TransactionNo),'�������','ManageCom',count(ManageCom) from  T_PRP_LCInsured where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
select '�������˱�T_PRP_LCInsured', '���ױ���',count(TransactionNo),'���������˹�ϵ','RelationToMainInsured',count(RelationToMainInsured) from  T_PRP_LCInsured where RelationToMainInsured not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='relationtoinsured')  union
select '�������˱�T_PRP_LCInsured', '���ױ���',count(TransactionNo),'��Ͷ���˹�ϵ','RelationToAppnt',count(RelationToAppnt) from  T_PRP_LCInsured where RelationToAppnt not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='relationtoinsured')  union
select '�������˱�T_PRP_LCInsured', '���ױ���',count(TransactionNo),'�������Ա�','InsuredSex',count(InsuredSex) from  T_PRP_LCInsured where InsuredSex not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='sex')  union
select '�������˱�T_PRP_LCInsured', '���ױ���',count(TransactionNo),'֤������','InsuredCertType',count(InsuredCertType) from  T_PRP_LCInsured where InsuredCertType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='certtype')  union
select '�������˱�T_PRP_LCInsured', '���ױ���',count(TransactionNo),'����','Country',count(Country) from  T_PRP_LCInsured where Country not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='country')  union
select '�������˱�T_PRP_LCInsured', '���ױ���',count(TransactionNo),'����','Nationality',count(Nationality) from  T_PRP_LCInsured where Nationality not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='nationality')  union
select '�������˱�T_PRP_LCInsured', '���ױ���',count(TransactionNo),'����״��','MarriageStatus',count(MarriageStatus) from  T_PRP_LCInsured where MarriageStatus not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='marriagestatus')  union
select '�������˱�T_PRP_LCInsured', '���ױ���',count(TransactionNo),'����״��','HealthCondition',count(HealthCondition) from  T_PRP_LCInsured where HealthCondition not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='healthcondition')  union
select '�������˱�T_PRP_LCInsured', '���ױ���',count(TransactionNo),'ѧ��','EducateLevel',count(EducateLevel) from  T_PRP_LCInsured where EducateLevel not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='educatelevel')  union
select '�������˱�T_PRP_LCInsured', '���ױ���',count(TransactionNo),'ְλ','Position',count(Position) from  T_PRP_LCInsured where Position not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='position')  union
select '�������˱�T_PRP_LCInsured', '���ױ���',count(TransactionNo),'ְҵ����','OccupationType',count(OccupationType) from  T_PRP_LCInsured where OccupationType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='occupationtype')  union
select '�������˱�T_PRP_LCInsured', '���ױ���',count(TransactionNo),'��ְ����','PartTimeOccupationType',count(PartTimeOccupationType) from  T_PRP_LCInsured where PartTimeOccupationType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='occupationtype')  union
select '�������˱�T_PRP_LCInsured', '���ױ���',count(TransactionNo),'�Ƿ����̱�־','SmokeFlag',count(SmokeFlag) from  T_PRP_LCInsured where SmokeFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='smokeflag')  union
select '�������˱�T_PRP_LCInsured', '���ױ���',count(TransactionNo),'��������','LicenseType',count(LicenseType) from  T_PRP_LCInsured where LicenseType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='licensetype')  union
select '�������˱�T_PRP_LCInsured', '���ױ���',count(TransactionNo),'�Ƿ����籣��־','SocialInsuFlag',count(SocialInsuFlag) from  T_PRP_LCInsured where SocialInsuFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='socialinsuflag')  union
select '�������˱�T_PRP_LCInsured', '���ױ���',count(TransactionNo),'��������','ResidentType',count(ResidentType) from  T_PRP_LCInsured where ResidentType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='residenttype')  union
select '�������˱�T_PRP_LCInsured', '���ױ���',count(TransactionNo),'������������','InsuredType',count(InsuredType) from  T_PRP_LCInsured where InsuredType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='insuredtype')  union
--�����˻���
select '�����˻���:T_PRP_LCInsureAcc', '���ױ���',count(TransactionNo),'��˾����','CompanyCode',count(CompanyCode) from  T_PRP_LCInsureAcc where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '�����˻���:T_PRP_LCInsureAcc', '���ױ���',count(TransactionNo),'�������','ManageCom',count(ManageCom) from  T_PRP_LCInsureAcc where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
select '�����˻���:T_PRP_LCInsureAcc', '���ױ���',count(TransactionNo),'�˻�����','AccType',count(AccType) from  T_PRP_LCInsureAcc where AccType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='acctype')  union
--���Ᵽ����ϸ��
select '���Ᵽ����ϸ��T_PRP_LLClaimPolicy', '���ױ���',count(TransactionNo),'��˾����','CompanyCode',count(CompanyCode) from  T_PRP_LLClaimPolicy where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '���Ᵽ����ϸ��T_PRP_LLClaimPolicy', '���ױ���',count(TransactionNo),'����ԭ��','LossOccurReason',count(LossOccurReason) from  T_PRP_LLClaimPolicy where LossOccurReason not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='lossoccurreason')  union
select '���Ᵽ����ϸ��T_PRP_LLClaimPolicy', '���ױ���',count(TransactionNo),'�⸶��������','BenefitType',count(BenefitType) from  T_PRP_LLClaimPolicy where BenefitType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='benefittype')  union
select '���Ᵽ����ϸ��T_PRP_LLClaimPolicy', '���ױ���',count(TransactionNo),'�ұ�','Currency',count(Currency) from  T_PRP_LLClaimPolicy where Currency not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='currency')  union
select '���Ᵽ����ϸ��T_PRP_LLClaimPolicy', '���ױ���',count(TransactionNo),'�����������','PayStatusCode',count(PayStatusCode) from  T_PRP_LLClaimPolicy where PayStatusCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='paystatuscode')  union
select '���Ᵽ����ϸ��T_PRP_LLClaimPolicy', '���ױ���',count(TransactionNo),'�������','ManageCom',count(ManageCom) from  T_PRP_LLClaimPolicy where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
--���������˱�
select '���������˱�T_PRP_LLBnf', '���ױ���',count(TransactionNo),'��˾����','CompanyCode',count(CompanyCode) from  T_PRP_LLBnf where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '���������˱�T_PRP_LLBnf', '���ױ���',count(TransactionNo),'���������','BnfCat',count(BnfCat) from  T_PRP_LLBnf where BnfCat not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='bnfcat')  union
select '���������˱�T_PRP_LLBnf', '���ױ���',count(TransactionNo),'�����˼���','BnfLevel',count(BnfLevel) from  T_PRP_LLBnf where BnfLevel not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='bnflevel')  union
select '���������˱�T_PRP_LLBnf', '���ױ���',count(TransactionNo),'�������뱻���˹�ϵ','RelationToInsured',count(RelationToInsured) from  T_PRP_LLBnf where RelationToInsured not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='relationtoinsured')  union
select '���������˱�T_PRP_LLBnf', '���ױ���',count(TransactionNo),'�������Ա�','Sex',count(Sex) from  T_PRP_LLBnf where Sex not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='sex')  union
select '���������˱�T_PRP_LLBnf', '���ױ���',count(TransactionNo),'������֤������','CertType',count(CertType) from  T_PRP_LLBnf where CertType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='certtype')  union
select '���������˱�T_PRP_LLBnf', '���ױ���',count(TransactionNo),'������뱻���˹�ϵ','RelationOfPayeeAndInsured',count(RelationOfPayeeAndInsured) from  T_PRP_LLBnf where RelationOfPayeeAndInsured not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='relationtoinsured')  union
select '���������˱�T_PRP_LLBnf', '���ױ���',count(TransactionNo),'������Ա�','PayeeSex',count(PayeeSex) from  T_PRP_LLBnf where PayeeSex not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='sex')  union
select '���������˱�T_PRP_LLBnf', '���ױ���',count(TransactionNo),'�����֤������','PayeeCertType',count(PayeeCertType) from  T_PRP_LLBnf where PayeeCertType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='certtype')  union
select '���������˱�T_PRP_LLBnf', '���ױ���',count(TransactionNo),'���ս���ȡ��ʽ','BenefitWDMthd',count(BenefitWDMthd) from  T_PRP_LLBnf where BenefitWDMthd not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='benefitwdmthd')  union
select '���������˱�T_PRP_LLBnf', '���ױ���',count(TransactionNo),'���ս�֧����ʽ','BenefitPayMthd',count(BenefitPayMthd) from  T_PRP_LLBnf where BenefitPayMthd not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='payway')  union
--���۷�����Ա��Ϣ��
select '���۷�����Ա��Ϣ��T_PRP_LAAgent', '���ױ���',count(TransactionNo),'��˾����','CompanyCode',count(CompanyCode) from  T_PRP_LAAgent where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '���۷�����Ա��Ϣ��T_PRP_LAAgent', '���ױ���',count(TransactionNo),'�������','ManageCom',count(ManageCom) from  T_PRP_LAAgent where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
select '���۷�����Ա��Ϣ��T_PRP_LAAgent', '���ױ���',count(TransactionNo),'�Ա�','Sex',count(Sex) from  T_PRP_LAAgent where Sex not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='sex')  union
select '���۷�����Ա��Ϣ��T_PRP_LAAgent', '���ױ���',count(TransactionNo),'���ڱ�־','OfficeWorkFlag',count(OfficeWorkFlag) from T_PRP_LAAgent where OfficeWorkFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='officeworkflag')  union
select '���۷�����Ա��Ϣ��T_PRP_LAAgent', '���ױ���',count(TransactionNo),'�Ƿ�רְ��־','FullTimeFlag',count(FullTimeFlag) from  T_PRP_LAAgent where FullTimeFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='fulltimeflag')  union
select '���۷�����Ա��Ϣ��T_PRP_LAAgent', '���ױ���',count(TransactionNo),'֤������','CertType',count(CertType) from  T_PRP_LAAgent where CertType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='certtype')  union
--���շѱ�
select '���շѱ�T_PRP_LJTempFee', '���ױ���',count(TransactionNo),'��˾����','CompanyCode',count(CompanyCode) from  T_PRP_LJTempFee where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '���շѱ�T_PRP_LJTempFee', '���ױ���',count(TransactionNo),'�������','ManageCom',count(ManageCom) from  T_PRP_LJTempFee where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
select '���շѱ�T_PRP_LJTempFee', '���ױ���',count(TransactionNo),'�ұ�','Currency',count(Currency) from  T_PRP_LJTempFee where Currency not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='currency')  union
select '���շѱ�T_PRP_LJTempFee', '���ױ���',count(TransactionNo),'֤������','CertType',count(CertType) from  T_PRP_LJTempFee where CertType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='certtype')  union
--���������
select '���������T_PRP_LJDivDistrib', '���ױ���',count(TransactionNo),'��˾����','CompanyCode',count(CompanyCode) from  T_PRP_LJDivDistrib where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '���������T_PRP_LJDivDistrib', '���ױ���',count(TransactionNo),'��������','DivType',count(DivType) from  T_PRP_LJDivDistrib where DivType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='divtype')  union
select '���������T_PRP_LJDivDistrib', '���ױ���',count(TransactionNo),'�������䷽ʽ','DivDistribMeth',count(DivDistribMeth) from  T_PRP_LJDivDistrib where DivDistribMeth not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='divdistribmeth')  union
select '���������T_PRP_LJDivDistrib', '���ױ���',count(TransactionNo),'�������','ManageCom',count(ManageCom) from  T_PRP_LJDivDistrib where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
select '���������T_PRP_LJDivDistrib', '���ױ���',count(TransactionNo),'֤������','CertType',count(CertType) from  T_PRP_LJDivDistrib where CertType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='certtype')  union
--�������ȡ��
select '�������ȡ��T_PRP_LJAGetLivBene', '���ױ���',count(TransactionNo),'��˾����','CompanyCode',count(CompanyCode) from  T_PRP_LJAGetLivBene where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '�������ȡ��T_PRP_LJAGetLivBene', '���ױ���',count(TransactionNo),'�������','ManageCom',count(ManageCom) from  T_PRP_LJAGetLivBene where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
select '�������ȡ��T_PRP_LJAGetLivBene', '���ױ���',count(TransactionNo),'֤������','CertType',count(CertType) from  T_PRP_LJAGetLivBene where CertType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='certtype')  union
--������ϸ��
select '������ϸ��T_PRP_LJAPay', '���ױ���',count(TransactionNo), '��˾����','CompanyCode',count(CompanyCode) from  T_PRP_LJAPay where CompanyCode not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='companycode')  union
select '������ϸ��T_PRP_LJAPay', '���ױ���',count(TransactionNo), '�������','ManageCom',count(ManageCom) from  T_PRP_LJAPay where ManageCom not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='managecom')  union
select '������ϸ��T_PRP_LJAPay', '���ױ���',count(TransactionNo), '֤������', 'CertType',count(CertType)  FROM T_PRP_LJAPay WHERE CertType NOT in(SELECT TARGET_CODE FROM T_DEF_code_mapping WHERE CODE_TYPE='certtype')  union
--���ֶ����
select '���ֶ����T_PRP_T_PRP_LMProduct', '���ױ���',count(TransactionNo), '��˾����','CompanyCode',count(CompanyCode)   FROM T_PRP_LMProduct WHERE CompanyCode NOT in(select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE ='companycode')  union
select '���ֶ����T_PRP_LMProduct', '���ױ���',count(TransactionNo),'�����˻����','InsuAccFlag',count(InsuAccFlag) from  T_PRP_LMProduct where InsuAccFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='insuaccflag')  union
select '���ֶ����T_PRP_LMProduct', '���ױ���',count(TransactionNo),'����','ProductType',count(ProductType) from  T_PRP_LMProduct where ProductType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='producttype')  union
select '���ֶ����T_PRP_LMProduct', '���ױ���',count(TransactionNo),'Ͷ�����','InvestmentType',count(InvestmentType) from  T_PRP_LMProduct where InvestmentType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='investmenttype')  union
select '���ֶ����T_PRP_LMProduct', '���ױ���',count(TransactionNo),'�����ձ�־','TermType',count(TermType) from  T_PRP_LMProduct where TermType not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='termtype')  union
select '���ֶ����T_PRP_LMProduct', '���ױ���',count(TransactionNo),'���ű�־','GPFlag',count(GPFlag) from  T_PRP_LMProduct where GPFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='gpflag')  union
select '���ֶ����T_PRP_LMProduct', '���ױ���',count(TransactionNo),'�����ձ�־','MainProductFlag',count(MainProductFlag) from  T_PRP_LMProduct where MainProductFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='mainproductflag')  union
select '���ֶ����T_PRP_LMProduct', '���ױ���',count(TransactionNo),'��Ʒ���۱��','SaleFlag',count(SaleFlag) from  T_PRP_LMProduct where SaleFlag not in (select TARGET_CODE from T_DEF_code_mapping where CODE_TYPE='saleflag')
) WHERE errorcounts > 0;

--�ǿ�У��
prompt create or replace views V_CHECK_ISNULL...
CREATE OR REPLACE VIEW V_CHECK_ISNULL AS
SELECT ERRORTABLE,COLNAME,ALLCOUNTS,ERRORMSG,ERRCOUNTS FROM (
  SELECT errortable,ColName,SUM(allcounts) AS allcounts,errormsg,SUM(counts) AS errcounts FROM (
  -- T_PRP_LMProduct
  select '���ֶ����T_PRP_LMProduct' AS errortable,'ProductName' ColName,1 AS allcounts,'��Ʒ����Ϊ��' errormsg,(CASE WHEN ProductName IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LMProduct UNION ALL
  select '���ֶ����T_PRP_LMProduct' AS errortable,'AssumIntRate' ColName,1 AS allcounts,'Ԥ������Ϊ��' errormsg,(CASE WHEN AssumIntRate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LMProduct UNION ALL
  select '���ֶ����T_PRP_LMProduct' AS errortable,'ProductType' ColName,1 AS allcounts,'����Ϊ��' errormsg,(CASE WHEN ProductType IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LMProduct UNION ALL
  select '���ֶ����T_PRP_LMProduct' AS errortable,'InvestmentType' ColName,1 AS allcounts,'Ͷ�����Ϊ��' errormsg,(CASE WHEN InvestmentType IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LMProduct UNION ALL
  select '���ֶ����T_PRP_LMProduct' AS errortable,'TermType' ColName,1 AS allcounts,'�����ձ�־Ϊ��' errormsg,(CASE WHEN TermType IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LMProduct UNION ALL
  select '���ֶ����T_PRP_LMProduct' AS errortable,'GPFlag' ColName,1 AS allcounts,'���ű�־Ϊ��' errormsg,(CASE WHEN GPFlag IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LMProduct UNION ALL
  select '���ֶ����T_PRP_LMProduct' AS errortable,'MainProductFlag' ColName,1 AS allcounts,'�����ձ�־Ϊ��' errormsg,(CASE WHEN MainProductFlag IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LMProduct UNION ALL
  -- T_PRP_LCPoltransaction
  select '����������Ϣ��T_PRP_LCPoltransaction' AS errortable,'TransAmnt' ColName,1 AS allcounts,'���׽��Ϊ��' errormsg,(CASE WHEN TransAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCPoltransaction UNION ALL
  select '����������Ϣ��T_PRP_LCPoltransaction' AS errortable,'TransDate' ColName,1 AS allcounts,'��������Ϊ��' errormsg,(CASE WHEN TransDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCPoltransaction UNION ALL
  -- T_PRP_LCCont
  select '������Ϣ��T_PRP_LCCont' AS errortable,'PrtNo' ColName,1 AS allcounts,'ӡˢ����Ϊ��' errormsg,(CASE WHEN PrtNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'GPFlag' ColName,1 AS allcounts,'���ű�־Ϊ��' errormsg,(CASE WHEN GPFlag IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'GPFlag' ColName,1 AS allcounts,'���ű�1��Чʧ��' errormsg,(CASE WHEN GPFlag = '1' THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'FamilyPolType' ColName,1 AS allcounts,'��ͥ������Ϊ��' errormsg,(CASE WHEN FamilyPolType IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'ManageCom' ColName,1 AS allcounts,'�������Ϊ��' errormsg,(CASE WHEN ManageCom IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'ManageComName' ColName,1 AS allcounts,'�����������Ϊ��' errormsg,(CASE WHEN ManageComName IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'DistribChnl' ColName,1 AS allcounts,'��������Ϊ��' errormsg,(CASE WHEN DistribChnl IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'AppntNo' ColName,1 AS allcounts,'Ͷ���˿ͻ�����Ϊ��' errormsg,(CASE WHEN AppntNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'AppntName' ColName,1 AS allcounts,'Ͷ��������Ϊ��' errormsg,(CASE WHEN AppntName IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'AppntSex' ColName,1 AS allcounts,'Ͷ�����Ա�Ϊ��' errormsg,(CASE WHEN AppntSex IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'AppntBirthDate' ColName,1 AS allcounts,'Ͷ���˳�������Ϊ��' errormsg,(CASE WHEN AppntBirthDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'AppntCertType' ColName,1 AS allcounts,'Ͷ����֤������Ϊ��' errormsg,(CASE WHEN AppntCertType IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'AppntCertNo' ColName,1 AS allcounts,'Ͷ����֤������Ϊ��' errormsg,(CASE WHEN AppntCertNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'PayMode' ColName,1 AS allcounts,'���Ѽ��Ϊ��' errormsg,(CASE WHEN PayMode IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'SignDate' ColName,1 AS allcounts,'ǩ������Ϊ��' errormsg,(CASE WHEN SignDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'Currency' ColName,1 AS allcounts,'�ұ�Ϊ��' errormsg,(CASE WHEN Currency IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'Copies' ColName,1 AS allcounts,'����Ϊ��' errormsg,(CASE WHEN Copies IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'Premium' ColName,1 AS allcounts,'����Ϊ��' errormsg,(CASE WHEN Premium IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'SumInsured' ColName,1 AS allcounts,'����Ϊ��' errormsg,(CASE WHEN SumInsured IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'CashValue' ColName,1 AS allcounts,'�ֽ��ֵΪ��' errormsg,(CASE WHEN CashValue IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'PolBalance' ColName,1 AS allcounts,'�������Ϊ��' errormsg,(CASE WHEN PolBalance IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'AccumPremium' ColName,1 AS allcounts,'�ۼƱ���Ϊ��' errormsg,(CASE WHEN AccumPremium IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'AccumLoanMoney' ColName,1 AS allcounts,'��ǰ�����Ϊ��' errormsg,(CASE WHEN AccumLoanMoney IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'EffDate' ColName,1 AS allcounts,'������Ч����Ϊ��' errormsg,(CASE WHEN EffDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'PolStatus' ColName,1 AS allcounts,'����״̬Ϊ��' errormsg,(CASE WHEN PolStatus IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'PolicyType' ColName,1 AS allcounts,'������ʽΪ��' errormsg,(CASE WHEN PolicyType IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  select '������Ϣ��T_PRP_LCCont' AS errortable,'PolicyEndDate' ColName,1 AS allcounts,'������������Ϊ��' errormsg,(CASE WHEN PolicyEndDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCCont UNION ALL
  -- T_PRP_LCProdInsuRela
  select '�����������ֹ�����T_PRP_LCProdInsuRela' AS errortable,'ManageCom' ColName,1 AS allcounts,'�������Ϊ��' errormsg,(CASE WHEN ManageCom IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProdInsuRela UNION ALL
  -- T_PRP_LCProduct
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'GPFlag' ColName,1 AS allcounts,'���ű�־Ϊ��' errormsg,(CASE WHEN GPFlag IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'PolTypeFlag' ColName,1 AS allcounts,'�������ͱ��Ϊ��' errormsg,(CASE WHEN PolTypeFlag IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'MainProductNo' ColName,1 AS allcounts,'���ձ������ֺ���Ϊ��' errormsg,(CASE WHEN MainProductNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'MainProductFlag' ColName,1 AS allcounts,'�����ձ��Ϊ��' errormsg,(CASE WHEN MainProductFlag IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'ProductCode' ColName,1 AS allcounts,'��Ʒ����Ϊ��' errormsg,(CASE WHEN ProductCode IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'ManageCom' ColName,1 AS allcounts,'�������Ϊ��' errormsg,(CASE WHEN ManageCom IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'EffDate' ColName,1 AS allcounts,'��Ʒ��Ч����Ϊ��' errormsg,(CASE WHEN EffDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'InvalidDate' ColName,1 AS allcounts,'����������ֹ����Ϊ��' errormsg,(CASE WHEN InvalidDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'PayMode' ColName,1 AS allcounts,'���Ѽ��Ϊ��' errormsg,(CASE WHEN PayMode IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'PayTerm' ColName,1 AS allcounts,'��������Ϊ��' errormsg,(CASE WHEN PayTerm IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'InsurancePeriodFlag' ColName,1 AS allcounts,'������������Ϊ��' errormsg,(CASE WHEN InsurancePeriodFlag IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'InsurancePeriod' ColName,1 AS allcounts,'��������Ϊ��' errormsg,(CASE WHEN InsurancePeriod IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'Copies' ColName,1 AS allcounts,'����Ϊ��' errormsg,(CASE WHEN Copies IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'Premium' ColName,1 AS allcounts,'���ڱ���Ϊ��' errormsg,(CASE WHEN Premium IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'AccumPremium' ColName,1 AS allcounts,'�ۼƱ���Ϊ��' errormsg,(CASE WHEN AccumPremium IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'BasicSumInsured' ColName,1 AS allcounts,'��������Ϊ��' errormsg,(CASE WHEN BasicSumInsured IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'RiskAmnt' ColName,1 AS allcounts,'���ձ���Ϊ��' errormsg,(CASE WHEN RiskAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'CashValue' ColName,1 AS allcounts,'�ֽ��ֵΪ��' errormsg,(CASE WHEN CashValue IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'AccumDiv' ColName,1 AS allcounts,'�ۼƺ������Ϊ��' errormsg,(CASE WHEN AccumDiv IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'AccumDivInt' ColName,1 AS allcounts,'�ۼƺ�����ϢΪ��' errormsg,(CASE WHEN AccumDivInt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'AccumDivSI' ColName,1 AS allcounts,'�ۼƺ�������Ϊ��' errormsg,(CASE WHEN AccumDivSI IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'SurrenderAmnt' ColName,1 AS allcounts,'�˱����Ϊ��' errormsg,(CASE WHEN SurrenderAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'AccumAnnuityWD' ColName,1 AS allcounts,'�ۼ���ȡ�����Ϊ��' errormsg,(CASE WHEN AccumAnnuityWD IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'AccumMaturityWD' ColName,1 AS allcounts,'���ڽ���Ϊ��' errormsg,(CASE WHEN AccumMaturityWD IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'AccumClmBenefit' ColName,1 AS allcounts,'�ۼ��⸶���Ϊ��' errormsg,(CASE WHEN AccumClmBenefit IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'AccumClmTimes' ColName,1 AS allcounts,'�ۼ��⸶����Ϊ��' errormsg,(CASE WHEN AccumClmTimes IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  select '����������Ϣ��T_PRP_LCProduct' AS errortable,'Status' ColName,1 AS allcounts,'��������״̬��' errormsg,(CASE WHEN Status IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCProduct UNION ALL
  -- T_PRP_LCBnf
  select '�����˱�T_PRP_LCBnf' AS errortable,'ProductNo' ColName,1 AS allcounts,'�����������ֺ���Ϊ��' errormsg,(CASE WHEN ProductNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCBnf UNION ALL
  select '�����˱�T_PRP_LCBnf' AS errortable,'InsuredNo' ColName,1 AS allcounts,'�����˿ͻ�����Ϊ��' errormsg,(CASE WHEN InsuredNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCBnf UNION ALL
  select '�����˱�T_PRP_LCBnf' AS errortable,'BnfCat' ColName,1 AS allcounts,'���������Ϊ��' errormsg,(CASE WHEN BnfCat IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCBnf UNION ALL
  select '�����˱�T_PRP_LCBnf' AS errortable,'BnfLevel' ColName,1 AS allcounts,'�����˼���Ϊ��' errormsg,(CASE WHEN BnfLevel IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCBnf UNION ALL
  select '�����˱�T_PRP_LCBnf' AS errortable,'RelationToInsured' ColName,1 AS allcounts,'�뱻���˹�ϵΪ��' errormsg,(CASE WHEN RelationToInsured IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCBnf UNION ALL
  select '�����˱�T_PRP_LCBnf' AS errortable,'PercentOfBenefit' ColName,1 AS allcounts,'�������Ϊ��' errormsg,(CASE WHEN PercentOfBenefit IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCBnf UNION ALL
  select '�����˱�T_PRP_LCBnf' AS errortable,'Name' ColName,1 AS allcounts,'����������Ϊ��' errormsg,(CASE WHEN Name IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCBnf UNION ALL
  -- T_PRP_LCInsured
  select '�������˱�T_PRP_LCInsured' AS errortable,'ManageCom' ColName,1 AS allcounts,'�������Ϊ��' errormsg,(CASE WHEN ManageCom IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '�������˱�T_PRP_LCInsured' AS errortable,'RelationToMainInsured' ColName,1 AS allcounts,'���������˹�ϵΪ��' errormsg,(CASE WHEN RelationToMainInsured IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '�������˱�T_PRP_LCInsured' AS errortable,'MainInsuredNo' ColName,1 AS allcounts,'�������˿ͻ���Ϊ��' errormsg,(CASE WHEN MainInsuredNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '�������˱�T_PRP_LCInsured' AS errortable,'RelationToAppnt' ColName,1 AS allcounts,'��Ͷ���˹�ϵΪ��' errormsg,(CASE WHEN RelationToAppnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '�������˱�T_PRP_LCInsured' AS errortable,'InsuredName' ColName,1 AS allcounts,'����������Ϊ��' errormsg,(CASE WHEN InsuredName IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '�������˱�T_PRP_LCInsured' AS errortable,'InsuredSex' ColName,1 AS allcounts,'�������Ա�Ϊ��' errormsg,(CASE WHEN InsuredSex IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '�������˱�T_PRP_LCInsured' AS errortable,'InsuredBirthDate' ColName,1 AS allcounts,'�����˳�������Ϊ��' errormsg,(CASE WHEN InsuredBirthDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '�������˱�T_PRP_LCInsured' AS errortable,'InsuredCertNo' ColName,1 AS allcounts,'֤������Ϊ��' errormsg,(CASE WHEN InsuredCertNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '�������˱�T_PRP_LCInsured' AS errortable,'AppAge' ColName,1 AS allcounts,'Ͷ��ʱ����Ϊ��' errormsg,(CASE WHEN AppAge IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '�������˱�T_PRP_LCInsured' AS errortable,'Height' ColName,1 AS allcounts,'���Ϊ��' errormsg,(CASE WHEN Height IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '�������˱�T_PRP_LCInsured' AS errortable,'Weight' ColName,1 AS allcounts,'����Ϊ��' errormsg,(CASE WHEN Weight IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '�������˱�T_PRP_LCInsured' AS errortable,'Salary' ColName,1 AS allcounts,'������Ϊ��' errormsg,(CASE WHEN Salary IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '�������˱�T_PRP_LCInsured' AS errortable,'OccupationType' ColName,1 AS allcounts,'ְҵ����Ϊ��' errormsg,(CASE WHEN OccupationType IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  select '�������˱�T_PRP_LCInsured' AS errortable,'BMI' ColName,1 AS allcounts,'����ָ��Ϊ��' errormsg,(CASE WHEN BMI IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsured UNION ALL
  -- T_PRP_LCInsureAcc
  select '�����˻���T_PRP_LCInsureAcc' AS errortable,'ManageCom' ColName,1 AS allcounts,'����ָ��Ϊ��' errormsg,(CASE WHEN ManageCom IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsureAcc UNION ALL
  select '�����˻���T_PRP_LCInsureAcc' AS errortable,'AccumCommission' ColName,1 AS allcounts,'�ۼ�������Ϊ��' errormsg,(CASE WHEN AccumCommission IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsureAcc UNION ALL
  select '�����˻���T_PRP_LCInsureAcc' AS errortable,'AccumMngFee' ColName,1 AS allcounts,'�ۼƱ��������Ϊ��' errormsg,(CASE WHEN AccumMngFee IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsureAcc UNION ALL
  select '�����˻���T_PRP_LCInsureAcc' AS errortable,'AccumRiskPremium' ColName,1 AS allcounts,'�ۼƷ��ձ���Ϊ��' errormsg,(CASE WHEN AccumRiskPremium IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsureAcc UNION ALL
  select '�����˻���T_PRP_LCInsureAcc' AS errortable,'AccountDate' ColName,1 AS allcounts,'�˻���������Ϊ��' errormsg,(CASE WHEN AccountDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsureAcc UNION ALL
  select '�����˻���T_PRP_LCInsureAcc' AS errortable,'AccumPay' ColName,1 AS allcounts,'�ۼƽ���Ϊ��' errormsg,(CASE WHEN AccumPay IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsureAcc UNION ALL
  select '�����˻���T_PRP_LCInsureAcc' AS errortable,'AccumDwAmnt' ColName,1 AS allcounts,'�ۼ���ȡΪ��' errormsg,(CASE WHEN AccumDwAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsureAcc UNION ALL
  select '�����˻���T_PRP_LCInsureAcc' AS errortable,'AccountValue' ColName,1 AS allcounts,'�����˻���ֵΪ��' errormsg,(CASE WHEN AccountValue IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsureAcc UNION ALL
  select '�����˻���T_PRP_LCInsureAcc' AS errortable,'AccountUnitNumber' ColName,1 AS allcounts,'�����˻���λ��Ϊ��' errormsg,(CASE WHEN AccountUnitNumber IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LCInsureAcc UNION ALL
  -- T_PRP_LLClaimPolicy
  select '���Ᵽ����ϸ��T_PRP_LLClaimPolicy' AS errortable,'ClmRegisterNo' ColName,1 AS allcounts,'������Ϊ��' errormsg,(CASE WHEN ClmRegisterNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '���Ᵽ����ϸ��T_PRP_LLClaimPolicy' AS errortable,'BenefitType' ColName,1 AS allcounts,'�⸶��������Ϊ��' errormsg,(CASE WHEN BenefitType IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '���Ᵽ����ϸ��T_PRP_LLClaimPolicy' AS errortable,'Currency' ColName,1 AS allcounts,'�ұ�Ϊ��' errormsg,(CASE WHEN Currency IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '���Ᵽ����ϸ��T_PRP_LLClaimPolicy' AS errortable,'ClmAcountAmnt' ColName,1 AS allcounts,'�����⸶���Ϊ��' errormsg,(CASE WHEN ClmAcountAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '���Ᵽ����ϸ��T_PRP_LLClaimPolicy' AS errortable,'ClmAssessAmnt' ColName,1 AS allcounts,'�����⸶���Ϊ��' errormsg,(CASE WHEN ClmAssessAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '���Ᵽ����ϸ��T_PRP_LLClaimPolicy' AS errortable,'RejectAmnt' ColName,1 AS allcounts,'������Ϊ��' errormsg,(CASE WHEN RejectAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '���Ᵽ����ϸ��T_PRP_LLClaimPolicy' AS errortable,'PrePayAmnt' ColName,1 AS allcounts,'Ԥ�����Ϊ��' errormsg,(CASE WHEN PrePayAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '���Ᵽ����ϸ��T_PRP_LLClaimPolicy' AS errortable,'ApproveAmnt' ColName,1 AS allcounts,'ͨ�ڸ������ϼ�Ϊ��' errormsg,(CASE WHEN ApproveAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '���Ᵽ����ϸ��T_PRP_LLClaimPolicy' AS errortable,'AgreeAmnt' ColName,1 AS allcounts,'Э������ϼ�Ϊ��' errormsg,(CASE WHEN AgreeAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '���Ᵽ����ϸ��T_PRP_LLClaimPolicy' AS errortable,'ClmSettDate' ColName,1 AS allcounts,'�᰸����Ϊ��' errormsg,(CASE WHEN ClmSettDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '���Ᵽ����ϸ��T_PRP_LLClaimPolicy' AS errortable,'PayStatusCode' ColName,1 AS allcounts,'�����������Ϊ��' errormsg,(CASE WHEN PayStatusCode IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  select '���Ᵽ����ϸ��T_PRP_LLClaimPolicy' AS errortable,'ManageCom' ColName,1 AS allcounts,'�������Ϊ��' errormsg,(CASE WHEN ManageCom IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLClaimPolicy UNION ALL
  -- T_PRP_LLBnf
  select '�����������˻���T_PRP_LLBnf' AS errortable,'InsuredNo' ColName,1 AS allcounts,'�����˿ͻ�����Ϊ��' errormsg,(CASE WHEN InsuredNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLBnf UNION ALL
  select '�����������˻���T_PRP_LLBnf' AS errortable,'BnfCat' ColName,1 AS allcounts,'���������Ϊ��' errormsg,(CASE WHEN BnfCat IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLBnf UNION ALL
  select '�����������˻���T_PRP_LLBnf' AS errortable,'BnfLevel' ColName,1 AS allcounts,'�����˼���Ϊ��' errormsg,(CASE WHEN BnfLevel IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLBnf UNION ALL
  select '�����������˻���T_PRP_LLBnf' AS errortable,'RelationToInsured' ColName,1 AS allcounts,'�������뱻���˹�ϵΪ��' errormsg,(CASE WHEN RelationToInsured IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLBnf UNION ALL
  select '�����������˻���T_PRP_LLBnf' AS errortable,'Name' ColName,1 AS allcounts,'����������Ϊ��' errormsg,(CASE WHEN Name IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLBnf UNION ALL
  select '�����������˻���T_PRP_LLBnf' AS errortable,'PercentOfBenefit' ColName,1 AS allcounts,'�������Ϊ��' errormsg,(CASE WHEN PercentOfBenefit IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLBnf UNION ALL
  select '�����������˻���T_PRP_LLBnf' AS errortable,'DrawingAmnt' ColName,1 AS allcounts,'������Ϊ��' errormsg,(CASE WHEN DrawingAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LLBnf UNION ALL
  -- T_PRP_LASales
  select '���չ�˾���۷�����Ա��Ϣ��T_PRP_LASales' AS errortable,'ManageCom' ColName,1 AS allcounts,'�������Ϊ��' errormsg,(CASE WHEN ManageCom IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LASales UNION ALL
  select '���չ�˾���۷�����Ա��Ϣ��T_PRP_LASales' AS errortable,'Name' ColName,1 AS allcounts,'����Ϊ��' errormsg,(CASE WHEN Name IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LASales UNION ALL
  select '���չ�˾���۷�����Ա��Ϣ��T_PRP_LASales' AS errortable,'BusiDevCertifNo' ColName,1 AS allcounts,'ִҵ֤����Ϊ��' errormsg,(CASE WHEN BusiDevCertifNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LASales UNION ALL
  select '���չ�˾���۷�����Ա��Ϣ��T_PRP_LASales' AS errortable,'AgentSignFlag' ColName,1 AS allcounts,'�Ƿ�ǩ������ͬΪ��' errormsg,(CASE WHEN AgentSignFlag IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LASales UNION ALL
  select '���չ�˾���۷�����Ա��Ϣ��T_PRP_LASales' AS errortable,'SaleSvcFlag' ColName,1 AS allcounts,'���۷�����Ա��־Ϊ��' errormsg,(CASE WHEN SaleSvcFlag IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LASales UNION ALL
  -- T_PRP_LAAgent
  select '�����н���������ҵ��Ա��Ϣ��T_PRP_LAAgent' AS errortable,'ManageCom' ColName,1 AS allcounts,'�������Ϊ��' errormsg,(CASE WHEN ManageCom IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LAAgent UNION ALL
  select '�����н���������ҵ��Ա��Ϣ��T_PRP_LAAgent' AS errortable,'AgencyName' ColName,1 AS allcounts,'����򾭼ͻ�������Ϊ��' errormsg,(CASE WHEN AgencyName IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LAAgent UNION ALL
  select '�����н���������ҵ��Ա��Ϣ��T_PRP_LAAgent' AS errortable,'BusiDevCertifNo' ColName,1 AS allcounts,'ִҵ֤����Ϊ��' errormsg,(CASE WHEN BusiDevCertifNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LAAgent UNION ALL
  select '�����н���������ҵ��Ա��Ϣ��T_PRP_LAAgent' AS errortable,'AgentSignFlag' ColName,1 AS allcounts,'�Ƿ�ǩ������ͬΪ��' errormsg,(CASE WHEN AgentSignFlag IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LAAgent UNION ALL
  -- T_PRP_LJDivDistrib
  select '���������T_PRP_LJDivDistrib' AS errortable,'DivAmnt' ColName,1 AS allcounts,'�������Ϊ��' errormsg,(CASE WHEN DivAmnt IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJDivDistrib UNION ALL
  select '���������T_PRP_LJDivDistrib' AS errortable,'AppntNo' ColName,1 AS allcounts,'Ͷ���˿ͻ�����Ϊ��' errormsg,(CASE WHEN AppntNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJDivDistrib UNION ALL
  select '���������T_PRP_LJDivDistrib' AS errortable,'AppntName' ColName,1 AS allcounts,'Ͷ��������Ϊ��' errormsg,(CASE WHEN AppntName IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJDivDistrib UNION ALL
  -- T_PRP_LJAGetLivBene
  select '�������ȡ��T_PRP_LJAGetLivBene' AS errortable,'AppntNo' ColName,1 AS allcounts,'Ͷ���˿ͻ�����Ϊ��' errormsg,(CASE WHEN AppntNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAGetLivBene UNION ALL
  select '�������ȡ��T_PRP_LJAGetLivBene' AS errortable,'InsuredNo' ColName,1 AS allcounts,'�����˿ͻ�����Ϊ��' errormsg,(CASE WHEN InsuredNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAGetLivBene UNION ALL
  select '�������ȡ��T_PRP_LJAGetLivBene' AS errortable,'BenefitDate' ColName,1 AS allcounts,'��������Ϊ��' errormsg,(CASE WHEN BenefitDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAGetLivBene UNION ALL
  select '�������ȡ��T_PRP_LJAGetLivBene' AS errortable,'BenefitAmount' ColName,1 AS allcounts,'�������Ϊ��' errormsg,(CASE WHEN BenefitAmount IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAGetLivBene UNION ALL
  -- T_PRP_LJAPay
  select '������ϸ��T_PRP_LJAPay' AS errortable,'ProductCode' ColName,1 AS allcounts,'��Ʒ����Ϊ��' errormsg,(CASE WHEN ProductCode IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAPay UNION ALL
  select '������ϸ��T_PRP_LJAPay' AS errortable,'ManageCom' ColName,1 AS allcounts,'�������Ϊ��' errormsg,(CASE WHEN ManageCom IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAPay UNION ALL
  select '������ϸ��T_PRP_LJAPay' AS errortable,'AppntNo' ColName,1 AS allcounts,'Ͷ���˿ͻ�����Ϊ��' errormsg,(CASE WHEN AppntNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAPay UNION ALL
  select '������ϸ��T_PRP_LJAPay' AS errortable,'SumActuPayMoney' ColName,1 AS allcounts,'ʵ�����Ϊ��' errormsg,(CASE WHEN SumActuPayMoney IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAPay UNION ALL
  select '������ϸ��T_PRP_LJAPay' AS errortable,'EnterAccDate' ColName,1 AS allcounts,'��������Ϊ��' errormsg,(CASE WHEN EnterAccDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAPay UNION ALL
  select '������ϸ��T_PRP_LJAPay' AS errortable,'ConfDate' ColName,1 AS allcounts,'��������Ϊ��' errormsg,(CASE WHEN ConfDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAPay UNION ALL
  select '������ϸ��T_PRP_LJAPay' AS errortable,'EnterAccDate' ColName,1 AS allcounts,'��������Ϊ��' errormsg,(CASE WHEN EnterAccDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAPay UNION ALL
  select '������ϸ��T_PRP_LJAPay' AS errortable,'EnterAccDate' ColName,1 AS allcounts,'ȷ������Ϊ��' errormsg,(CASE WHEN EnterAccDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAPay UNION ALL
  -- T_PRP_LJAGet
  select '������ϸ��T_PRP_LJAGet' AS errortable,'PrtNo' ColName,1 AS allcounts,'ӡˢ����Ϊ��' errormsg,(CASE WHEN PrtNo IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAGet UNION ALL
  select '������ϸ��T_PRP_LJAGet' AS errortable,'GetWay' ColName,1 AS allcounts,'���ѷ�ʽΪ��' errormsg,(CASE WHEN GetWay IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAGet UNION ALL
  select '������ϸ��T_PRP_LJAGet' AS errortable,'Currency' ColName,1 AS allcounts,'�ұ�Ϊ��' errormsg,(CASE WHEN Currency IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAGet UNION ALL
  select '������ϸ��T_PRP_LJAGet' AS errortable,'SumActuGetMoney' ColName,1 AS allcounts,'ʵ�����Ϊ��' errormsg,(CASE WHEN SumActuGetMoney IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAGet UNION ALL
  select '������ϸ��T_PRP_LJAGet' AS errortable,'EnterAccDate' ColName,1 AS allcounts,'��������Ϊ��' errormsg,(CASE WHEN EnterAccDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAGet UNION ALL
  select '������ϸ��T_PRP_LJAGet' AS errortable,'ConfDate' ColName,1 AS allcounts,'ȷ������Ϊ��' errormsg,(CASE WHEN ConfDate IS NULL THEN 1 ELSE 0 END) AS counts from  T_PRP_LJAGet
) GROUP BY errortable,ColName,errormsg ) WHERE errcounts > 0 ORDER BY errortable;
prompt create or replace views OVER 