prompt PL/SQL Developer import file
prompt Created on 2016年11月11日 by gyas-itpingw
set feedback off
set define off
prompt Dropping T_PRP_BUSS2MODERELA...
drop table T_PRP_BUSS2MODERELA cascade constraints;
prompt Dropping T_PRP_CHG_TRANS_ID_MAP...
drop table T_PRP_CHG_TRANS_ID_MAP cascade constraints;
prompt Dropping T_PRP_DEALERRORTRACE...
drop table T_PRP_DEALERRORTRACE cascade constraints;
prompt Dropping T_PRP_LAAGENT...
drop table T_PRP_LAAGENT cascade constraints;
prompt Dropping T_PRP_LASALES...
drop table T_PRP_LASALES cascade constraints;
prompt Dropping T_PRP_LCBNF...
drop table T_PRP_LCBNF cascade constraints;
prompt Dropping T_PRP_LCCLAIMGETRATE...
drop table T_PRP_LCCLAIMGETRATE cascade constraints;
prompt Dropping T_PRP_LCCONT...
drop table T_PRP_LCCONT cascade constraints;
prompt Dropping T_PRP_LCINSUREACC...
drop table T_PRP_LCINSUREACC cascade constraints;
prompt Dropping T_PRP_LCINSURED...
drop table T_PRP_LCINSURED cascade constraints;
prompt Dropping T_PRP_LCPHONECOMPLETERATE...
drop table T_PRP_LCPHONECOMPLETERATE cascade constraints;
prompt Dropping T_PRP_LCPOLICYDELIVERYRATE...
drop table T_PRP_LCPOLICYDELIVERYRATE cascade constraints;
prompt Dropping T_PRP_LCPOLTRANSACTION...
drop table T_PRP_LCPOLTRANSACTION cascade constraints;
prompt Dropping T_PRP_LCPOLTRANSACTION_B...
drop table T_PRP_LCPOLTRANSACTION_B cascade constraints;
prompt Dropping T_PRP_LCPOLTRANSACTION_ERROR...
drop table T_PRP_LCPOLTRANSACTION_ERROR cascade constraints;
prompt Dropping T_PRP_LCPOLTRANSACTION_RETURN...
drop table T_PRP_LCPOLTRANSACTION_RETURN cascade constraints;
prompt Dropping T_PRP_LCPRESERVATIONPERIOD...
drop table T_PRP_LCPRESERVATIONPERIOD cascade constraints;
prompt Dropping T_PRP_LCPRODINSURELA...
drop table T_PRP_LCPRODINSURELA cascade constraints;
prompt Dropping T_PRP_LCPRODUCT...
drop table T_PRP_LCPRODUCT cascade constraints;
prompt Dropping T_PRP_LCQUOTADATA...
drop table T_PRP_LCQUOTADATA cascade constraints;
prompt Dropping T_PRP_LCREVIEWSUCCESSRATE...
drop table T_PRP_LCREVIEWSUCCESSRATE cascade constraints;
prompt Dropping T_PRP_LDGETDATASQL...
drop table T_PRP_LDGETDATASQL cascade constraints;
prompt Dropping T_PRP_LDUSERFILE...
drop table T_PRP_LDUSERFILE cascade constraints;
prompt Dropping T_PRP_LJAGET...
drop table T_PRP_LJAGET cascade constraints;
prompt Dropping T_PRP_LJAGETLIVBENE...
drop table T_PRP_LJAGETLIVBENE cascade constraints;
prompt Dropping T_PRP_LJAPAY...
drop table T_PRP_LJAPAY cascade constraints;
prompt Dropping T_PRP_LJDIVDISTRIB...
drop table T_PRP_LJDIVDISTRIB cascade constraints;
prompt Dropping T_PRP_LJTEMPFEE...
drop table T_PRP_LJTEMPFEE cascade constraints;
prompt Dropping T_PRP_LLBNF...
drop table T_PRP_LLBNF cascade constraints;
prompt Dropping T_PRP_LLCLAIMPOLICY...
drop table T_PRP_LLCLAIMPOLICY cascade constraints;
prompt Dropping T_PRP_LMPRODUCT...
drop table T_PRP_LMPRODUCT cascade constraints;
prompt Dropping T_PRP_MODE2TABLERELA...
drop table T_PRP_MODE2TABLERELA cascade constraints;
prompt Dropping T_PRP_MODEINFO...
drop table T_PRP_MODEINFO cascade constraints;
prompt Creating T_PRP_BUSS2MODERELA...
create table T_PRP_BUSS2MODERELA
(
  relaid    VARCHAR2(20) not null,
  busstype  VARCHAR2(20) not null,
  modeno    VARCHAR2(20) not null,
  stateflag VARCHAR2(2),
  bussname  VARCHAR2(100)
)
;
comment on table T_PRP_BUSS2MODERELA
  is '用于业务与模型的关联';
comment on column T_PRP_BUSS2MODERELA.relaid
  is '唯一逐渐标识';
comment on column T_PRP_BUSS2MODERELA.busstype
  is '对应业务类型编码中的业务类型编码';
comment on column T_PRP_BUSS2MODERELA.modeno
  is '对应ModeInfo的模型编码';
comment on column T_PRP_BUSS2MODERELA.stateflag
  is '状态标识，是否有效 1-是 0-否';
alter table T_PRP_BUSS2MODERELA
  add constraint P_BUSS2MODERELA_PK primary key (RELAID, BUSSTYPE, MODENO);

prompt Creating T_PRP_CHG_TRANS_ID_MAP...
create table T_PRP_CHG_TRANS_ID_MAP
(
  chgid       VARCHAR2(50) not null,
  transno     VARCHAR2(50) not null,
  bussno      VARCHAR2(50),
  busstype    VARCHAR2(50),
  dateserial  VARCHAR2(50) not null,
  companycode VARCHAR2(50)
)
;
alter table T_PRP_CHG_TRANS_ID_MAP
  add constraint PK_CHG_TRANS_ID_MAP primary key (CHGID, TRANSNO, DATESERIAL);
create index PK_CHG_TRANS_ID_MAP_IN1 on T_PRP_CHG_TRANS_ID_MAP (BUSSNO, BUSSTYPE);
create index PK_CHG_TRANS_ID_MAP_IN2 on T_PRP_CHG_TRANS_ID_MAP (CHGID);
create index PK_CHG_TRANS_ID_MAP_IN3 on T_PRP_CHG_TRANS_ID_MAP (CHGID, BUSSNO);
create index PK_CHG_TRANS_ID_MAP_IN4 on T_PRP_CHG_TRANS_ID_MAP (TRANSNO);

prompt Creating T_PRP_DEALERRORTRACE...
create table T_PRP_DEALERRORTRACE
(
  traceid       VARCHAR2(50) not null,
  batchno       VARCHAR2(50),
  dealstate     VARCHAR2(10),
  dealdate      DATE,
  dealtime      VARCHAR2(20),
  dealoper      VARCHAR2(50),
  errorpath     VARCHAR2(2000),
  errorpathtype VARCHAR2(10)
)
;

prompt Creating T_PRP_LAAGENT...
create table T_PRP_LAAGENT
(
  transactionno   VARCHAR2(24) not null,
  companycode     VARCHAR2(6),
  policyno        VARCHAR2(50) not null,
  managecom       VARCHAR2(15),
  agencycode      VARCHAR2(50) not null,
  agencyname      VARCHAR2(120),
  agentcode       VARCHAR2(50) not null,
  name            VARCHAR2(120),
  sex             VARCHAR2(1),
  birthdate       DATE,
  quafcertno      VARCHAR2(50),
  certstartdate   DATE,
  certenddate     DATE,
  busidevcertifno VARCHAR2(50),
  officeworkflag  VARCHAR2(1),
  agentsignflag   VARCHAR2(1),
  fulltimeflag    VARCHAR2(1),
  certtype        VARCHAR2(3),
  certno          VARCHAR2(50),
  salejudge       VARCHAR2(200),
  operator        VARCHAR2(20),
  makedate        DATE,
  maketime        VARCHAR2(20),
  modifydate      DATE,
  modifytime      VARCHAR2(20)
)
;
comment on table T_PRP_LAAGENT
  is '代理人员信息表';
comment on column T_PRP_LAAGENT.transactionno
  is '流水号：公司编码+日期（YYYYMMDD）+10位流水';
comment on column T_PRP_LAAGENT.companycode
  is '保险行业保险公司总公司编码，对应《业务代码表》中的“保险机构代码”。';
comment on column T_PRP_LAAGENT.policyno
  is '保险单的编号，个人保单合同号。';
comment on column T_PRP_LAAGENT.managecom
  is '保标委的机构代码，对应《业务代码表》中的“保险分支机构代码”。';
comment on column T_PRP_LAAGENT.agencycode
  is '代理或经纪机构编码';
comment on column T_PRP_LAAGENT.agencyname
  is '代理或经纪机构名称';
comment on column T_PRP_LAAGENT.agentcode
  is '从业人员编码';
comment on column T_PRP_LAAGENT.name
  is '在公安户籍管理部门正式等级注册、人事档案中正式记载的本人姓氏名称。';
comment on column T_PRP_LAAGENT.sex
  is '销售人员性别代码，对应《业务代码表》中的“性别代码”。';
comment on column T_PRP_LAAGENT.birthdate
  is '出生证签署的并在公安户籍部门登记注册、人事档案中记载的日期';
comment on column T_PRP_LAAGENT.quafcertno
  is '代理机构或代理人取得经营许可的证件号码。';
comment on column T_PRP_LAAGENT.certstartdate
  is '代理人资格证生效日期。';
comment on column T_PRP_LAAGENT.certenddate
  is '代理人资格证失效日期。';
comment on column T_PRP_LAAGENT.busidevcertifno
  is '展业证号码。';
comment on column T_PRP_LAAGENT.officeworkflag
  is '是否为内勤工作人员，对应《业务代码表》中的“是否内勤标记代码”。';
comment on column T_PRP_LAAGENT.fulltimeflag
  is '是否专职标志，对应《业务代码表》中的“是否专职标志代码”。';
comment on column T_PRP_LAAGENT.certtype
  is '销售服务人员的证件类型代码，对应《业务代码表》中的“个人身份证件类型代码”。';
comment on column T_PRP_LAAGENT.certno
  is '证件的号码';
comment on column T_PRP_LAAGENT.salejudge
  is '填写评价描述，如没有，可以为空';
comment on column T_PRP_LAAGENT.operator
  is '操作者';
comment on column T_PRP_LAAGENT.makedate
  is '入库日期';
comment on column T_PRP_LAAGENT.maketime
  is '入库时间';
comment on column T_PRP_LAAGENT.modifydate
  is '修改日期';
comment on column T_PRP_LAAGENT.modifytime
  is '修改时间';
alter table T_PRP_LAAGENT
  add constraint LAAGENT_PK primary key (TRANSACTIONNO, POLICYNO, AGENCYCODE, AGENTCODE);
create index INX_LAAGENT_TNO on T_PRP_LAAGENT (TRANSACTIONNO);

prompt Creating T_PRP_LASALES...
create table T_PRP_LASALES
(
  transactionno   VARCHAR2(24) not null,
  companycode     VARCHAR2(6),
  agentcode       VARCHAR2(50) not null,
  policyno        VARCHAR2(50) not null,
  managecom       VARCHAR2(120),
  name            VARCHAR2(120),
  sex             VARCHAR2(1),
  birthdate       DATE,
  quafcertno      VARCHAR2(50),
  certstartdate   DATE,
  certenddate     DATE,
  busidevcertifno VARCHAR2(50),
  officeworkflag  VARCHAR2(1),
  agentsignflag   VARCHAR2(1),
  fulltimeflag    VARCHAR2(1),
  salesvcflag     VARCHAR2(1),
  certtype        VARCHAR2(3),
  certno          VARCHAR2(50),
  salejudge       VARCHAR2(200),
  operator        VARCHAR2(20),
  makedate        DATE,
  maketime        VARCHAR2(20),
  modifydate      DATE,
  modifytime      VARCHAR2(20)
)
;
comment on table T_PRP_LASALES
  is '销售人员信息表';
comment on column T_PRP_LASALES.transactionno
  is '流水号：公司编码+日期（YYYYMMDD）+10位流水';
comment on column T_PRP_LASALES.companycode
  is '保险行业保险公司总公司编码，对应《业务代码表》中的“保险机构代码”。';
comment on column T_PRP_LASALES.policyno
  is '保险单的编号，个人保单合同号。';
comment on column T_PRP_LASALES.managecom
  is '销售服务人员所属代理机构名称';
comment on column T_PRP_LASALES.name
  is '在公安户籍管理部门正式等级注册、人事档案中正式记载的本人姓氏名称。';
comment on column T_PRP_LASALES.sex
  is '销售人员性别代码，对应《业务代码表》中的“性别代码”。';
comment on column T_PRP_LASALES.birthdate
  is '出生证签署的并在公安户籍部门登记注册、人事档案中记载的日期';
comment on column T_PRP_LASALES.quafcertno
  is '代理机构或代理人取得经营许可的证件号码。';
comment on column T_PRP_LASALES.certstartdate
  is '代理人资格证生效日期。';
comment on column T_PRP_LASALES.certenddate
  is '代理人资格证失效日期。';
comment on column T_PRP_LASALES.busidevcertifno
  is '展业证号码。';
comment on column T_PRP_LASALES.officeworkflag
  is '是否为内勤工作人员，对应《业务代码表》中的“是否内勤标记代码”。';
comment on column T_PRP_LASALES.agentsignflag
  is '销售人员是否为中介代理机构人员标志。对应《业务代码表》中的“销售人员中介标记代码”。';
comment on column T_PRP_LASALES.fulltimeflag
  is '是否专职标志，对应《业务代码表》中的“是否专职标志代码”。';
comment on column T_PRP_LASALES.salesvcflag
  is '销售人员或服务人员，对应《业务代码表》中的“销售服务人员类型代码”。';
comment on column T_PRP_LASALES.certtype
  is '销售服务人员的证件类型代码，对应《业务代码表》中的“个人身份证件类型代码”。';
comment on column T_PRP_LASALES.certno
  is '证件的号码';
comment on column T_PRP_LASALES.salejudge
  is '填写评价描述，如没有，可以为空';
comment on column T_PRP_LASALES.operator
  is '操作者';
comment on column T_PRP_LASALES.makedate
  is '入库日期';
comment on column T_PRP_LASALES.maketime
  is '入库时间';
comment on column T_PRP_LASALES.modifydate
  is '修改日期';
comment on column T_PRP_LASALES.modifytime
  is '修改时间';
alter table T_PRP_LASALES
  add constraint LASALES_PK primary key (TRANSACTIONNO, AGENTCODE, POLICYNO);
create index IDX_LASALES_TNO on T_PRP_LASALES (TRANSACTIONNO);
create index IDX_LASALES_TNO1 on T_PRP_LASALES (AGENTCODE, POLICYNO);
create index IDX_LASALES_TNO2 on T_PRP_LASALES (TRANSACTIONNO, POLICYNO);
create index IDX_LASALES_TNO3 on T_PRP_LASALES (POLICYNO);
create index IDX_LASALES_TNO4 on T_PRP_LASALES (AGENTCODE);
create index IDX_LASALES_TNO5 on T_PRP_LASALES (QUAFCERTNO);

prompt Creating T_PRP_LCBNF...
create table T_PRP_LCBNF
(
  transactionno     VARCHAR2(24) not null,
  companycode       VARCHAR2(6) not null,
  policyno          VARCHAR2(50) not null,
  productno         VARCHAR2(50) not null,
  insuredno         VARCHAR2(50) not null,
  bnfcat            VARCHAR2(1),
  bnfserialnum      VARCHAR2(50) not null,
  bnflevel          VARCHAR2(1),
  relationtoinsured VARCHAR2(10),
  percentofbenefit  NUMBER(16,6),
  iccustomerno      VARCHAR2(50),
  customerno        VARCHAR2(50),
  name              VARCHAR2(120),
  sex               VARCHAR2(1),
  birthdate         DATE,
  certtype          VARCHAR2(3),
  certno            VARCHAR2(50),
  operator          VARCHAR2(20),
  makedate          DATE,
  maketime          VARCHAR2(20),
  modifydate        DATE,
  modifytime        VARCHAR2(20)
)
;
comment on table T_PRP_LCBNF
  is '受益人表';
comment on column T_PRP_LCBNF.transactionno
  is '流水号：公司编码+日期（YYYYMMDD）+10位流水。';
comment on column T_PRP_LCBNF.companycode
  is '保险行业保险公司总公司编码，对应《业务代码表》中的“保险机构代码”。';
comment on column T_PRP_LCBNF.policyno
  is '保险单的编号，个人保单合同号。';
comment on column T_PRP_LCBNF.productno
  is '该保单下险种在保险公司系统中的唯一标识（注意不是产品编码）。';
comment on column T_PRP_LCBNF.insuredno
  is '被保人客户在保险公司的唯一标识，需要保险公司提前对客户数据进行合并后报送。';
comment on column T_PRP_LCBNF.bnfcat
  is '受益人类别，对应《业务代码表》中的“生存/身故受益人类型代码”。';
comment on column T_PRP_LCBNF.bnfserialnum
  is '该保单下受益人在保险公司系统中的唯一标识。';
comment on column T_PRP_LCBNF.bnflevel
  is '受益人级别，指对受益人进行分组，对应《业务代码表》中的“受益顺序代码”。';
comment on column T_PRP_LCBNF.relationtoinsured
  is '人员关系的标识代码，对应《业务代码表》中的“人员关系代码”。';
comment on column T_PRP_LCBNF.percentofbenefit
  is '保险合同受益人获取收益份额的百分比。请填写小数，如果收益比例为30%，则填写0.3。';
comment on column T_PRP_LCBNF.iccustomerno
  is '受益人客户在保险公司的唯一标识，需要保险公司提前对客户数据进行合并后报送。如果没有可以为空。';
comment on column T_PRP_LCBNF.customerno
  is '客户在保信的唯一标识，此字段为保信保留字段，保险公司请填写空值。';
comment on column T_PRP_LCBNF.name
  is '人身保险合同中由被保险人或者投保人指定的享有保险金请求权的人。如果受益人是法定受益人则填写“法定受益人”。';
comment on column T_PRP_LCBNF.sex
  is '受益人性别代码，对应《业务代码表》中的“性别代码”。';
comment on column T_PRP_LCBNF.birthdate
  is '出生证签署的并在公安户籍部门登记注册、人事档案中记载的日期。';
comment on column T_PRP_LCBNF.certtype
  is '受益人的证件类型的代码，对应《业务代码表》中的“个人身份证件类型代码”。';
comment on column T_PRP_LCBNF.certno
  is '受益人的证件号码。';
comment on column T_PRP_LCBNF.operator
  is '操作者';
comment on column T_PRP_LCBNF.makedate
  is '入库日期';
comment on column T_PRP_LCBNF.maketime
  is '入库时间';
comment on column T_PRP_LCBNF.modifydate
  is '修改日期';
comment on column T_PRP_LCBNF.modifytime
  is '修改时间';
alter table T_PRP_LCBNF
  add constraint P_LCBNF_PK primary key (TRANSACTIONNO, POLICYNO, PRODUCTNO, INSUREDNO, BNFSERIALNUM);
create index IDX_LCBNF_TNO on T_PRP_LCBNF (TRANSACTIONNO);

prompt Creating T_PRP_LCCLAIMGETRATE...
create table T_PRP_LCCLAIMGETRATE
(
  id           VARCHAR2(50) not null,
  year         VARCHAR2(50) not null,
  claimno      VARCHAR2(50) not null,
  reportdate   DATE not null,
  appclaimdate DATE not null,
  endcasedate  DATE not null,
  endcasetype  VARCHAR2(10) not null,
  companycode  VARCHAR2(50) not null,
  areacode     VARCHAR2(50) not null,
  operator     VARCHAR2(50),
  makedate     DATE,
  maketime     VARCHAR2(20),
  modifydate   DATE,
  modifytime   VARCHAR2(20)
)
;
comment on table T_PRP_LCCLAIMGETRATE
  is '理赔获赔率数据来源清单';
comment on column T_PRP_LCCLAIMGETRATE.id
  is '主键生成规则（前6位公司代码加四位年份加10位随机数）';
comment on column T_PRP_LCCLAIMGETRATE.claimno
  is '保单理赔业务受理号';
comment on column T_PRP_LCCLAIMGETRATE.reportdate
  is '消费者报案日期';
comment on column T_PRP_LCCLAIMGETRATE.appclaimdate
  is '消费者申请理赔业务日期';
comment on column T_PRP_LCCLAIMGETRATE.endcasedate
  is '理赔业务结案日期';
comment on column T_PRP_LCCLAIMGETRATE.endcasetype
  is '保单犹豫期的截止日期';
comment on column T_PRP_LCCLAIMGETRATE.companycode
  is '同保监会统计信息系统上报口径';
comment on column T_PRP_LCCLAIMGETRATE.operator
  is '操作人';
comment on column T_PRP_LCCLAIMGETRATE.makedate
  is '入库日期';
comment on column T_PRP_LCCLAIMGETRATE.maketime
  is '入库时间';
comment on column T_PRP_LCCLAIMGETRATE.modifydate
  is '修改日期';
comment on column T_PRP_LCCLAIMGETRATE.modifytime
  is '修改时间';
alter table T_PRP_LCCLAIMGETRATE
  add constraint P_P_LCCGR_PK primary key (ID);

prompt Creating T_PRP_LCCONT...
create table T_PRP_LCCONT
(
  transactionno     VARCHAR2(24) not null,
  companycode       VARCHAR2(6) not null,
  grppolicyno       VARCHAR2(50),
  policyno          VARCHAR2(50) not null,
  prtno             VARCHAR2(50),
  gpflag            VARCHAR2(2),
  familypoltype     VARCHAR2(1),
  managecom         VARCHAR2(15),
  managecomname     VARCHAR2(100),
  agencycode        VARCHAR2(50),
  agencyname        VARCHAR2(120),
  appntno           VARCHAR2(50),
  customerno        VARCHAR2(50),
  appntname         VARCHAR2(120),
  appntsex          VARCHAR2(1),
  appntbirthdate    DATE,
  appntcerttype     VARCHAR2(3),
  appntcertno       VARCHAR2(50),
  province          VARCHAR2(30),
  city              VARCHAR2(30),
  county            VARCHAR2(30),
  street            VARCHAR2(200),
  appntmp           VARCHAR2(30),
  appntfp           VARCHAR2(30),
  email             VARCHAR2(100),
  paymode           VARCHAR2(2),
  payway            VARCHAR2(2),
  signdate          DATE,
  currency          VARCHAR2(3),
  copies            NUMBER(10),
  premium           NUMBER(16,2),
  suminsured        NUMBER(16,2),
  cashvalue         NUMBER(16,2),
  polbalance        NUMBER(16,2),
  accumpremium      NUMBER(16,2),
  accumloanmoney    NUMBER(16,2),
  aplmoney          NUMBER(16,2),
  curpaidtodate     DATE,
  paybegindate      DATE,
  effdate           DATE,
  uwdate            DATE,
  uwtype            VARCHAR2(1),
  polapplydate      DATE,
  customgetpoldate  DATE,
  polstatus         VARCHAR2(1),
  bankcode          VARCHAR2(20),
  bankname          VARCHAR2(100),
  bankaccno         VARCHAR2(40),
  accname           VARCHAR2(120),
  policytype        VARCHAR2(1),
  policyenddate     DATE,
  terminationdate   DATE,
  suspenddate       DATE,
  recoverdate       DATE,
  terminationreason VARCHAR2(2),
  operator          VARCHAR2(20),
  makedate          DATE,
  maketime          VARCHAR2(20),
  modifydate        DATE,
  modifytime        VARCHAR2(20),
  distribchnl       VARCHAR2(30)
)
;
comment on table T_PRP_LCCONT
  is '个人保单信息';
comment on column T_PRP_LCCONT.transactionno
  is '流水号：公司编码+日期（YYYYMMDD）+10位流水，';
comment on column T_PRP_LCCONT.companycode
  is '保险行业保险公司总公司编码，对应《业务代码表》中的“保险机构代码”。';
comment on column T_PRP_LCCONT.grppolicyno
  is '团体保单号，非团单为空。';
comment on column T_PRP_LCCONT.policyno
  is '保险单的编号，个人保单合同号。';
comment on column T_PRP_LCCONT.prtno
  is '投保单印刷号码。如果没有印刷号码填写投保单号码。';
comment on column T_PRP_LCCONT.gpflag
  is '按个人、集体等特征划分的保单分类代码，对应《业务代码表》中的“保单团个性质代码”。';
comment on column T_PRP_LCCONT.familypoltype
  is '区分个人或者家庭单，对应《业务代码表》中的“家庭保单标记代码”。';
comment on column T_PRP_LCCONT.managecom
  is '保标委的机构代码，对应《业务代码表》中的“保险分支机构代码”。';
comment on column T_PRP_LCCONT.managecomname
  is '保标委的机构名称，对应《业务代码表》中的“保险分支机构代码”中的名称。';
comment on column T_PRP_LCCONT.agencycode
  is '各保险公司核心业务系统所存的代理机构编码。';
comment on column T_PRP_LCCONT.agencyname
  is '代理机构名称。';
comment on column T_PRP_LCCONT.appntno
  is '投保人客户在保险公司的唯一标识，需要保险公司提前对客户数据进行合并后报送。';
comment on column T_PRP_LCCONT.customerno
  is '客户在保信的唯一标识，此字段为保信保留字段，保险公司请填写空值。';
comment on column T_PRP_LCCONT.appntname
  is '投保人姓名。';
comment on column T_PRP_LCCONT.appntsex
  is '投保人性别代码，对应《业务代码表》中的“性别代码”。';
comment on column T_PRP_LCCONT.appntbirthdate
  is '投保人的出生日期。';
comment on column T_PRP_LCCONT.appntcerttype
  is '投保人证件类型的代码，对应《业务代码表》中的“个人身份证件类型代码”。';
comment on column T_PRP_LCCONT.appntcertno
  is '投保人证件的号码。';
comment on column T_PRP_LCCONT.province
  is '投保人省份，对应《业务代码表》中的“县及县以上行政区划代码”之省级编码。';
comment on column T_PRP_LCCONT.city
  is '投保人市/地区，对应《业务代码表》中的“县及县以上行政区划代码”之市/地区级编码。';
comment on column T_PRP_LCCONT.county
  is '投保人县区，对应《业务代码表》中的“县及县以上行政区划代码”之县区级编码。';
comment on column T_PRP_LCCONT.street
  is '投保人街道名称，如地址没有进行省、市、区县的拆分，则在此字段填写完整的地址信息。';
comment on column T_PRP_LCCONT.appntmp
  is '投保人的手机号码，一般11位数组成的。';
comment on column T_PRP_LCCONT.appntfp
  is '投保人的联系电话号码，一般应包括所在地区的长途电话区号。';
comment on column T_PRP_LCCONT.email
  is '投保人的电子邮件地址。';
comment on column T_PRP_LCCONT.paymode
  is '保险合同中约定的缴纳保费的周期代码，对应《业务代码表》中的“交费频率代码”。';
comment on column T_PRP_LCCONT.payway
  is '续期交费方式，对应《业务代码表》中的“收付款方式代码”。';
comment on column T_PRP_LCCONT.signdate
  is '合同签订的日期，即承保日期。格式为''YYYY-MM-DD''。';
comment on column T_PRP_LCCONT.currency
  is '国际上表示货币和资金的名称代码，对应《业务代码表》中的“货币代码”。';
comment on column T_PRP_LCCONT.copies
  is '按照份数销售的产品，该保单下总的份数。';
comment on column T_PRP_LCCONT.premium
  is '投保人为取得保险保障，按保险合同约定向保险人支付的费用；当前保单下各险种的保费和；当期保费。';
comment on column T_PRP_LCCONT.suminsured
  is '保单上记录的所有险种基本保额的和。';
comment on column T_PRP_LCCONT.cashvalue
  is '保单现金价值（不含账户价值），不扣减借款和垫缴金额。';
comment on column T_PRP_LCCONT.polbalance
  is '保单暂收或预收核销后余额。';
comment on column T_PRP_LCCONT.accumpremium
  is '该保单已经缴纳并核销的保费合计。';
comment on column T_PRP_LCCONT.accumloanmoney
  is '当前尚未还清的借款，如果没有借款则填写0。';
comment on column T_PRP_LCCONT.aplmoney
  is '当前尚未还清的垫缴金额，如果没有垫缴金额则填写0。';
comment on column T_PRP_LCCONT.curpaidtodate
  is '下次应交保费日期。如果是最后一次交费，则取本次的应交费日期。';
comment on column T_PRP_LCCONT.paybegindate
  is '缴费的起始日期,格式为''YYYY-MM-DD''。';
comment on column T_PRP_LCCONT.effdate
  is '依法成立的保险合同，根据法律规定或合同约定在保险合同当事人之间产生法律约束力的日期,格式为''YYYY-MM-DD''。';
comment on column T_PRP_LCCONT.uwdate
  is '核保人作出核保决定的日期,格式为''YYYY-MM-DD''。';
comment on column T_PRP_LCCONT.uwtype
  is '保单自动核保或人工核保，对应《业务代码表》中的“核保类型代码”。';
comment on column T_PRP_LCCONT.polapplydate
  is '投保单申请日期,格式为''YYYY-MM-DD''。';
comment on column T_PRP_LCCONT.customgetpoldate
  is '客户收到保险合同的回执日期,格式为''YYYY-MM-DD''。';
comment on column T_PRP_LCCONT.polstatus
  is '保单状态，对应《业务代码表》中的“保单/险种/责任状态代码”。';
comment on column T_PRP_LCCONT.bankcode
  is '投保人续期交费的银行编码，各保险公司核心业务系统所存的银行编码；也可参考《业务代码表》中的“银行编码”。';
comment on column T_PRP_LCCONT.bankname
  is '投保人续期交费的银行名称。';
comment on column T_PRP_LCCONT.bankaccno
  is '投保人续期交费的开户人或单位银行的户头的账号。';
comment on column T_PRP_LCCONT.accname
  is '投保人续期交费的银行账户名。';
comment on column T_PRP_LCCONT.policytype
  is '保单合同的形式代码，对应《业务代码表》中的“保单形式代码”。';
comment on column T_PRP_LCCONT.policyenddate
  is '保单满期日期。';
comment on column T_PRP_LCCONT.terminationdate
  is '承保为空，当保单状态为终止时，则该字段必填。';
comment on column T_PRP_LCCONT.suspenddate
  is '承保为空，当保单状态为中止（失效）时，则该字段必填。';
comment on column T_PRP_LCCONT.recoverdate
  is '承保为空，保全类型为保单复效时该字段必填。';
comment on column T_PRP_LCCONT.terminationreason
  is '若保单状态为3终止，则该字段必填；对应《业务代码表》中的“保单终止原因代码”。';
alter table T_PRP_LCCONT
  add constraint P_LCCONT_PK primary key (TRANSACTIONNO, POLICYNO);
create index IDX_LCCONT_PNO on T_PRP_LCCONT (POLICYNO);
create index IDX_LCCONT_TNO on T_PRP_LCCONT (TRANSACTIONNO);

prompt Creating T_PRP_LCINSUREACC...
create table T_PRP_LCINSUREACC
(
  transactionno     VARCHAR2(24) not null,
  companycode       VARCHAR2(6) not null,
  grppolicyno       VARCHAR2(50),
  policyno          VARCHAR2(50) not null,
  managecom         VARCHAR2(15),
  productno         VARCHAR2(50) not null,
  insuaccno         VARCHAR2(50) not null,
  acctype           VARCHAR2(10) not null,
  accumcommission   NUMBER(16,2),
  accummngfee       NUMBER(16,2),
  accumriskpremium  NUMBER(16,2),
  accountdate       DATE,
  settlementdate    DATE,
  accumpay          NUMBER(16,2),
  accumdwamnt       NUMBER(16,2),
  accountvalue      NUMBER(16,2),
  accountunitnumber NUMBER(10),
  operator          VARCHAR2(20),
  makedate          DATE,
  maketime          VARCHAR2(20),
  modifydate        DATE,
  modifytime        VARCHAR2(20)
)
;
comment on table T_PRP_LCINSUREACC
  is '保险账户表';
comment on column T_PRP_LCINSUREACC.transactionno
  is '流水号：公司编码+日期（YYYYMMDD）+10位流水。';
comment on column T_PRP_LCINSUREACC.companycode
  is '保险行业保险公司总公司编码，对应《业务代码表》中的“保险机构代码”。';
comment on column T_PRP_LCINSUREACC.grppolicyno
  is '团体保单号，非团单为空。';
comment on column T_PRP_LCINSUREACC.policyno
  is '保险单的编号，个人保单合同号。';
comment on column T_PRP_LCINSUREACC.managecom
  is '保标委的机构代码，对应《业务代码表》中的“保险分支机构代码”。';
comment on column T_PRP_LCINSUREACC.productno
  is '该保单下险种在保险公司系统中的唯一标识（注意不是产品编码）。';
comment on column T_PRP_LCINSUREACC.insuaccno
  is '在保险公司系统中标示该账户的号码。';
comment on column T_PRP_LCINSUREACC.acctype
  is '账户类型，对应《业务代码表》中的“账户类型代码”。';
comment on column T_PRP_LCINSUREACC.accumcommission
  is '保险公司收取的该账户手续费的汇总（包含初始扣费）,不是代理人手续费。';
comment on column T_PRP_LCINSUREACC.accummngfee
  is '保险公司收取的该账户保单管理费的汇总。';
comment on column T_PRP_LCINSUREACC.accumriskpremium
  is '保险公司对所承担的保险责任收取的风险保费的汇总；超出账户价值部分的保障需要支付的保费。';
comment on column T_PRP_LCINSUREACC.accountdate
  is '账户成立日期。';
comment on column T_PRP_LCINSUREACC.settlementdate
  is '保险公司最近的一次对该账户进行结算的日期。';
comment on column T_PRP_LCINSUREACC.accumpay
  is '累计在该账户中缴纳的费用。';
comment on column T_PRP_LCINSUREACC.accumdwamnt
  is '该账户累计领取的金额。';
comment on column T_PRP_LCINSUREACC.accountvalue
  is '保险账户当前的价值。';
comment on column T_PRP_LCINSUREACC.accountunitnumber
  is '指投资型账户中投资单位数量。';
comment on column T_PRP_LCINSUREACC.operator
  is '操作者';
comment on column T_PRP_LCINSUREACC.makedate
  is '入库日期';
comment on column T_PRP_LCINSUREACC.maketime
  is '入库时间';
comment on column T_PRP_LCINSUREACC.modifydate
  is '修改日期';
comment on column T_PRP_LCINSUREACC.modifytime
  is '修改时间';
alter table T_PRP_LCINSUREACC
  add constraint P_LCINSUREACC_PK primary key (TRANSACTIONNO, POLICYNO, PRODUCTNO, INSUACCNO, ACCTYPE);

prompt Creating T_PRP_LCINSURED...
create table T_PRP_LCINSURED
(
  transactionno          VARCHAR2(24) not null,
  companycode            VARCHAR2(6) not null,
  grppolicyno            VARCHAR2(50),
  policyno               VARCHAR2(50) not null,
  insuredno              VARCHAR2(50) not null,
  customerno             VARCHAR2(50),
  managecom              VARCHAR2(15),
  relationtomaininsured  VARCHAR2(2),
  maininsuredno          VARCHAR2(50) not null,
  relationtoappnt        VARCHAR2(2),
  insuredname            VARCHAR2(120),
  insuredsex             VARCHAR2(1),
  insuredbirthdate       DATE,
  insuredcerttype        VARCHAR2(3),
  insuredcertno          VARCHAR2(50),
  appage                 NUMBER(10),
  country                VARCHAR2(20),
  rgtaddress             VARCHAR2(200),
  marriagestatus         VARCHAR2(2),
  marriagedate           DATE,
  height                 NUMBER(5,2),
  weight                 NUMBER(5,2),
  educatelevel           VARCHAR2(2),
  startworkdate          DATE,
  position               VARCHAR2(100),
  salary                 NUMBER(16,2),
  occupation             VARCHAR2(100),
  parttimeoccupation     VARCHAR2(100),
  smokeflag              VARCHAR2(1),
  bmi                    NUMBER(10,2),
  license                VARCHAR2(50),
  socialinsuno           VARCHAR2(50),
  socialinsuflag         VARCHAR2(1),
  residenttype           VARCHAR2(1),
  operator               VARCHAR2(20),
  makedate               DATE,
  maketime               VARCHAR2(20),
  modifydate             DATE,
  modifytime             VARCHAR2(20),
  nationality            VARCHAR2(20),
  healthcondition        VARCHAR2(20),
  occupationtype         VARCHAR2(70),
  parttimeoccupationtype VARCHAR2(70),
  licensetype            VARCHAR2(20),
  insuredtype            VARCHAR2(20)
)
;
comment on table T_PRP_LCINSURED
  is '被保险人表';
comment on column T_PRP_LCINSURED.transactionno
  is '流水号：公司编码+日期（YYYYMMDD）+10位流水。';
comment on column T_PRP_LCINSURED.companycode
  is '保险行业保险公司总公司编码，对应《业务代码表》中的“保险机构代码”。';
comment on column T_PRP_LCINSURED.grppolicyno
  is '团体保单号，非团单为空。';
comment on column T_PRP_LCINSURED.policyno
  is '保险单的编号，个人保单合同号。';
comment on column T_PRP_LCINSURED.insuredno
  is '被保人客户在保险公司的唯一标识，需要保险公司提前对客户数据进行合并后报送。';
comment on column T_PRP_LCINSURED.customerno
  is '客户在保信的唯一标识，此字段为保信保留字段，保险公司请填写空值。';
comment on column T_PRP_LCINSURED.managecom
  is '保标委的机构代码，对应《业务代码表》中的“保险分支机构代码”。';
comment on column T_PRP_LCINSURED.relationtomaininsured
  is '与主被保人关系，对应《业务代码表》中的“人员关系代码”。';
comment on column T_PRP_LCINSURED.maininsuredno
  is '主被保人号';
comment on column T_PRP_LCINSURED.relationtoappnt
  is '被保险人与投保人关系，对应《业务代码表》中的“人员关系代码”。';
comment on column T_PRP_LCINSURED.insuredname
  is '被保险人姓名。';
comment on column T_PRP_LCINSURED.insuredsex
  is '被保险人性别代码，对应《业务代码表》中的“性别代码”。';
comment on column T_PRP_LCINSURED.insuredbirthdate
  is '被保险人的出生日期。';
comment on column T_PRP_LCINSURED.insuredcerttype
  is '证件类型的代码，对应《业务代码表》中的“个人身份证件类型代码”。';
comment on column T_PRP_LCINSURED.insuredcertno
  is '证件的号码。';
comment on column T_PRP_LCINSURED.appage
  is '投保时被保险人的年龄。';
comment on column T_PRP_LCINSURED.country
  is '世界各国和地区的代码，对应《业务代码表》中的“国别代码”。';
comment on column T_PRP_LCINSURED.rgtaddress
  is '被保人居民户口簿登记所在地。';
comment on column T_PRP_LCINSURED.marriagestatus
  is '被保险人的婚姻状况的代码，对应《业务代码表》中的“婚姻状况代码”。';
comment on column T_PRP_LCINSURED.marriagedate
  is '被保人结婚证办理日期。';
comment on column T_PRP_LCINSURED.height
  is '被保险人的身高(cm)。';
comment on column T_PRP_LCINSURED.weight
  is '被保险人的体重(kg)。';
comment on column T_PRP_LCINSURED.educatelevel
  is '受教育者在教育机构接受科学、文化知识训练并获得国家教育行政部门认可的学历证书经历的代码，对应《业务代码表》中的“学历代码”。';
comment on column T_PRP_LCINSURED.startworkdate
  is '被保险人参加工作日期。';
comment on column T_PRP_LCINSURED.position
  is '对应《业务代码表》中的“专业技术职务代码”。';
comment on column T_PRP_LCINSURED.salary
  is '被保险人年收入总金额。';
comment on column T_PRP_LCINSURED.occupation
  is '职业工作描述。';
comment on column T_PRP_LCINSURED.parttimeoccupation
  is '兼职工作描述。';
comment on column T_PRP_LCINSURED.smokeflag
  is '标识被保险人是否吸烟。对应《业务代码表》中的“是否吸烟标记代码”。';
comment on column T_PRP_LCINSURED.bmi
  is '是用（被保险人）体重公斤数除以（被保险人）身高米数平方得出的数字。';
comment on column T_PRP_LCINSURED.license
  is '被保险人的驾照号码。';
comment on column T_PRP_LCINSURED.socialinsuno
  is '社保登记号。';
comment on column T_PRP_LCINSURED.socialinsuflag
  is '对应《业务代码表》中的“是否有社保标志代码”。';
comment on column T_PRP_LCINSURED.residenttype
  is '对应《业务代码表》中的“居民类型代码”。';
comment on column T_PRP_LCINSURED.operator
  is '操作者';
comment on column T_PRP_LCINSURED.makedate
  is '入库日期';
comment on column T_PRP_LCINSURED.maketime
  is '入库时间';
comment on column T_PRP_LCINSURED.modifydate
  is '修改日期';
comment on column T_PRP_LCINSURED.modifytime
  is '修改时间';
comment on column T_PRP_LCINSURED.nationality
  is '销售渠道';
comment on column T_PRP_LCINSURED.healthcondition
  is '职业类型';
alter table T_PRP_LCINSURED
  add constraint P_LCINSURED_PK primary key (TRANSACTIONNO, POLICYNO, INSUREDNO, MAININSUREDNO);
create index IDX_LCINSURED_TNO on T_PRP_LCINSURED (TRANSACTIONNO);

prompt Creating T_PRP_LCPHONECOMPLETERATE...
create table T_PRP_LCPHONECOMPLETERATE
(
  id             VARCHAR2(50) not null,
  year           VARCHAR2(4) not null,
  calltime       DATE not null,
  callnumber     VARCHAR2(20) not null,
  connectiontime DATE,
  downtime       DATE,
  isconnected    VARCHAR2(10) not null,
  companycode    VARCHAR2(50) not null,
  areacode       VARCHAR2(50) not null,
  operator       VARCHAR2(50),
  makedate       DATE,
  maketime       VARCHAR2(20),
  modifydate     DATE,
  modifytime     VARCHAR2(20)
)
;
comment on table T_PRP_LCPHONECOMPLETERATE
  is '电话呼入人工接通率数据来源清单';
comment on column T_PRP_LCPHONECOMPLETERATE.id
  is '主键生成规则（前6位公司代码加四位年份加10位随机数）';
comment on column T_PRP_LCPHONECOMPLETERATE.year
  is '数据清单提取年份';
comment on column T_PRP_LCPHONECOMPLETERATE.calltime
  is '拨打公司客服电话时间';
comment on column T_PRP_LCPHONECOMPLETERATE.callnumber
  is '1、固话包括区位号，除区号外后8位中间4位脱敏；
2、手机号码中间4位脱敏';
comment on column T_PRP_LCPHONECOMPLETERATE.connectiontime
  is '人工坐席接通电话时间';
comment on column T_PRP_LCPHONECOMPLETERATE.downtime
  is '客户挂机时间';
comment on column T_PRP_LCPHONECOMPLETERATE.isconnected
  is '01—是
00—否';
comment on column T_PRP_LCPHONECOMPLETERATE.companycode
  is '同保监会统计信息系统上报口径';
comment on column T_PRP_LCPHONECOMPLETERATE.operator
  is '操作人';
comment on column T_PRP_LCPHONECOMPLETERATE.makedate
  is '入库日期';
comment on column T_PRP_LCPHONECOMPLETERATE.maketime
  is '入库时间';
comment on column T_PRP_LCPHONECOMPLETERATE.modifydate
  is '修改日期';
comment on column T_PRP_LCPHONECOMPLETERATE.modifytime
  is '修改时间';
alter table T_PRP_LCPHONECOMPLETERATE
  add constraint P_P_LCPCR_PK primary key (ID, YEAR);

prompt Creating T_PRP_LCPOLICYDELIVERYRATE...
create table T_PRP_LCPOLICYDELIVERYRATE
(
  id             VARCHAR2(50) not null,
  year           VARCHAR2(50),
  policyno       VARCHAR2(50),
  sourcecode     VARCHAR2(50),
  sourcecode2    VARCHAR2(50),
  appdate        DATE,
  underdate      DATE,
  channel        VARCHAR2(10),
  agenttype      VARCHAR2(50),
  isrecieptok    VARCHAR2(10),
  polrecieptdate DATE,
  companycode    VARCHAR2(50),
  areacode       VARCHAR2(50),
  operator       VARCHAR2(50),
  makedate       DATE,
  maketime       VARCHAR2(20),
  modifydate     DATE,
  modifytime     VARCHAR2(20)
)
;
comment on table T_PRP_LCPOLICYDELIVERYRATE
  is '保单15日送达率数据来源清单';
comment on column T_PRP_LCPOLICYDELIVERYRATE.id
  is '主键生成规则（前6位公司代码加四位年份加10位随机数）';
comment on column T_PRP_LCPOLICYDELIVERYRATE.policyno
  is '保险公司出具保险合同的编号';
comment on column T_PRP_LCPOLICYDELIVERYRATE.appdate
  is '消费者提交投保日期（在保单上签字日期）';
comment on column T_PRP_LCPOLICYDELIVERYRATE.underdate
  is '客户缴费成功且保单核保通过的日期';
comment on column T_PRP_LCPOLICYDELIVERYRATE.channel
  is '保单归属业务渠道';
comment on column T_PRP_LCPOLICYDELIVERYRATE.isrecieptok
  is '01—是
00—否';
comment on column T_PRP_LCPOLICYDELIVERYRATE.polrecieptdate
  is '客户签收保单回执时的日期';
comment on column T_PRP_LCPOLICYDELIVERYRATE.companycode
  is '同保监会统计信息系统上报口径';
comment on column T_PRP_LCPOLICYDELIVERYRATE.operator
  is '操作人';
comment on column T_PRP_LCPOLICYDELIVERYRATE.makedate
  is '入库日期';
comment on column T_PRP_LCPOLICYDELIVERYRATE.maketime
  is '入库时间';
comment on column T_PRP_LCPOLICYDELIVERYRATE.modifydate
  is '修改日期';
comment on column T_PRP_LCPOLICYDELIVERYRATE.modifytime
  is '修改时间';
alter table T_PRP_LCPOLICYDELIVERYRATE
  add constraint P_P_LCPDR_PK primary key (ID);

prompt Creating T_PRP_LCPOLTRANSACTION...
create table T_PRP_LCPOLTRANSACTION
(
  transactionno VARCHAR2(24) not null,
  transtype     VARCHAR2(20),
  batchno       VARCHAR2(20),
  companycode   VARCHAR2(6) not null,
  grppolicyno   VARCHAR2(50),
  policyno      VARCHAR2(50) not null,
  busstype      VARCHAR2(10),
  transamnt     NUMBER(16,2),
  transdate     DATE,
  transtime     VARCHAR2(20),
  bankcode      VARCHAR2(20),
  bankname      VARCHAR2(100),
  bankaccno     VARCHAR2(40),
  accname       VARCHAR2(120),
  certtype      VARCHAR2(3),
  certno        VARCHAR2(50),
  stateflag     VARCHAR2(2),
  operator      VARCHAR2(20),
  makedate      DATE,
  maketime      VARCHAR2(20),
  modifydate    DATE,
  modifytime    VARCHAR2(20)
)
;
comment on table T_PRP_LCPOLTRANSACTION
  is '保单交易表';
comment on column T_PRP_LCPOLTRANSACTION.transactionno
  is '流水号：公司编码+日期（YYYYMMDD）+10位流水';
comment on column T_PRP_LCPOLTRANSACTION.transtype
  is '数据上传的批次号码';
comment on column T_PRP_LCPOLTRANSACTION.batchno
  is '交易批次号';
comment on column T_PRP_LCPOLTRANSACTION.companycode
  is '保险行业保险公司总公司编码，对应《业务代码表》中的“保险机构代码”。';
comment on column T_PRP_LCPOLTRANSACTION.grppolicyno
  is '团体保单号，非团单为空。';
comment on column T_PRP_LCPOLTRANSACTION.policyno
  is '保险单的编号，个人保单合同号。当业务类型（BussType）为“47-产品报送”时，请填写“000000”。';
comment on column T_PRP_LCPOLTRANSACTION.busstype
  is '业务类别，对应《业务代码表》中的“交易业务类型代码”。';
comment on column T_PRP_LCPOLTRANSACTION.transamnt
  is '交易金额；本次交易合计交退费金额，用正负数值表示，保险公司收费为正值，保险公司付费为负值；如果未发生金额填写0。';
comment on column T_PRP_LCPOLTRANSACTION.transdate
  is '业务类型（BussType）所对应的业务确认完成日期。';
comment on column T_PRP_LCPOLTRANSACTION.bankcode
  is '各保险公司核心业务系统所存的银行编码；也可参考《业务代码表》中的“银行编码”。';
comment on column T_PRP_LCPOLTRANSACTION.bankname
  is '银行名称。';
comment on column T_PRP_LCPOLTRANSACTION.bankaccno
  is '开户人或单位银行的户头的账号。';
comment on column T_PRP_LCPOLTRANSACTION.accname
  is '客户银行帐户名。';
comment on column T_PRP_LCPOLTRANSACTION.certtype
  is '证件类型的代码，对应《业务代码表》中的“个人身份证件类型代码”；跟资金相关的人的证件类型。';
comment on column T_PRP_LCPOLTRANSACTION.certno
  is '证件的号码；跟资金相关的人的证件号码。';
comment on column T_PRP_LCPOLTRANSACTION.stateflag
  is '状态标识';
comment on column T_PRP_LCPOLTRANSACTION.operator
  is '操作者';
comment on column T_PRP_LCPOLTRANSACTION.makedate
  is '入库日期';
comment on column T_PRP_LCPOLTRANSACTION.maketime
  is '入库时间';
comment on column T_PRP_LCPOLTRANSACTION.modifydate
  is '修改日期';
comment on column T_PRP_LCPOLTRANSACTION.modifytime
  is '修改时间';
create index IDX_LCPOLTRANSACTION_BNO on T_PRP_LCPOLTRANSACTION (BATCHNO);
create index IDX_LCPOLTRANSACTION_BTNO on T_PRP_LCPOLTRANSACTION (BATCHNO, TRANSACTIONNO);
create index IDX_LCPOLTRANSACTION_PNO on T_PRP_LCPOLTRANSACTION (POLICYNO);
create index IDX_LCPOLTRANSACTION_TNO on T_PRP_LCPOLTRANSACTION (TRANSACTIONNO);
create index IDX_LCPOLTRANSACTION_TPNO on T_PRP_LCPOLTRANSACTION (TRANSACTIONNO, POLICYNO);

prompt Creating T_PRP_LCPOLTRANSACTION_B...
create table T_PRP_LCPOLTRANSACTION_B
(
  transactionno VARCHAR2(24) not null,
  transtype     VARCHAR2(20),
  batchno       VARCHAR2(20),
  companycode   VARCHAR2(6) not null,
  grppolicyno   VARCHAR2(50),
  policyno      VARCHAR2(50) not null,
  busstype      VARCHAR2(20) not null,
  transamnt     NUMBER(16,2),
  transdate     DATE,
  transtime     VARCHAR2(20),
  bankcode      VARCHAR2(20),
  bankname      VARCHAR2(100),
  bankaccno     VARCHAR2(40),
  accname       VARCHAR2(120),
  certtype      VARCHAR2(3),
  certno        VARCHAR2(50),
  stateflag     VARCHAR2(2),
  operator      VARCHAR2(20),
  makedate      DATE,
  maketime      VARCHAR2(20),
  modifydate    DATE,
  modifytime    VARCHAR2(20)
)
;
comment on table T_PRP_LCPOLTRANSACTION_B
  is '保单交易表B';
comment on column T_PRP_LCPOLTRANSACTION_B.transactionno
  is '流水号：公司编码+日期（YYYYMMDD）+10位流水。';
comment on column T_PRP_LCPOLTRANSACTION_B.transtype
  is '数据上传的批次号码';
comment on column T_PRP_LCPOLTRANSACTION_B.batchno
  is '交易批次号';
comment on column T_PRP_LCPOLTRANSACTION_B.companycode
  is '保险行业保险公司总公司编码，对应《业务代码表》中的“保险机构代码”。';
comment on column T_PRP_LCPOLTRANSACTION_B.grppolicyno
  is '团体保单号，非团单为空。';
comment on column T_PRP_LCPOLTRANSACTION_B.policyno
  is '保险单的编号，个人保单合同号。当业务类型（BussType）为“47-产品报送”时，请填写“000000”。';
comment on column T_PRP_LCPOLTRANSACTION_B.busstype
  is '业务类别，对应《业务代码表》中的“交易业务类型代码”。';
comment on column T_PRP_LCPOLTRANSACTION_B.transamnt
  is '交易金额；本次交易合计交退费金额，用正负数值表示，保险公司收费为正值，保险公司付费为负值；如果未发生金额填写0。';
comment on column T_PRP_LCPOLTRANSACTION_B.transdate
  is '业务类型（BussType）所对应的业务确认完成日期。';
comment on column T_PRP_LCPOLTRANSACTION_B.bankcode
  is '各保险公司核心业务系统所存的银行编码；也可参考《业务代码表》中的“银行编码”。';
comment on column T_PRP_LCPOLTRANSACTION_B.bankname
  is '银行名称。';
comment on column T_PRP_LCPOLTRANSACTION_B.bankaccno
  is '开户人或单位银行的户头的账号。';
comment on column T_PRP_LCPOLTRANSACTION_B.accname
  is '客户银行帐户名。';
comment on column T_PRP_LCPOLTRANSACTION_B.certtype
  is '证件类型的代码，对应《业务代码表》中的“个人身份证件类型代码”；跟资金相关的人的证件类型。';
comment on column T_PRP_LCPOLTRANSACTION_B.certno
  is '证件的号码；跟资金相关的人的证件号码。';
comment on column T_PRP_LCPOLTRANSACTION_B.stateflag
  is '状态标识 ';
comment on column T_PRP_LCPOLTRANSACTION_B.operator
  is '操作者';
comment on column T_PRP_LCPOLTRANSACTION_B.makedate
  is '入库日期';
comment on column T_PRP_LCPOLTRANSACTION_B.maketime
  is '入库时间';
comment on column T_PRP_LCPOLTRANSACTION_B.modifydate
  is '修改日期';
comment on column T_PRP_LCPOLTRANSACTION_B.modifytime
  is '修改时间
';
create index CLPOLTRANSACTION_B_I1 on T_PRP_LCPOLTRANSACTION_B (TRANSACTIONNO, POLICYNO, BUSSTYPE);
create index CLPOLTRANSACTION_B_I2 on T_PRP_LCPOLTRANSACTION_B (POLICYNO);
create index CLPOLTRANSACTION_B_I3 on T_PRP_LCPOLTRANSACTION_B (TRANSACTIONNO, POLICYNO);

prompt Creating T_PRP_LCPOLTRANSACTION_ERROR...
create table T_PRP_LCPOLTRANSACTION_ERROR
(
  companycode   VARCHAR2(50),
  tablename     VARCHAR2(50),
  batchno       VARCHAR2(50),
  transactionno VARCHAR2(50),
  errorcode     VARCHAR2(50),
  errormsg      VARCHAR2(2000),
  stateflag     VARCHAR2(20),
  standflag1    VARCHAR2(50),
  standflag2    VARCHAR2(50),
  operator      VARCHAR2(50),
  makedate      DATE,
  maketime      VARCHAR2(20)
)
;
create index INDEX_LCP_E on T_PRP_LCPOLTRANSACTION_ERROR (TABLENAME, BATCHNO, TRANSACTIONNO, ERRORCODE);
create index INDEX_LCP_E1 on T_PRP_LCPOLTRANSACTION_ERROR (TRANSACTIONNO);
create index INDEX_LCP_E2 on T_PRP_LCPOLTRANSACTION_ERROR (BATCHNO, TRANSACTIONNO);
create index INDEX_LCP_E3 on T_PRP_LCPOLTRANSACTION_ERROR (BATCHNO);

prompt Creating T_PRP_LCPOLTRANSACTION_RETURN...
create table T_PRP_LCPOLTRANSACTION_RETURN
(
  transactionid VARCHAR2(100) not null,
  batchno       VARCHAR2(50) not null,
  busstype      VARCHAR2(50) not null,
  returndocid   VARCHAR2(50),
  requestdocid  VARCHAR2(50),
  errinfopath   VARCHAR2(1000),
  actionflag    VARCHAR2(2),
  datastatus    VARCHAR2(50),
  queryno       VARCHAR2(50),
  status        VARCHAR2(50),
  stateflag     VARCHAR2(2),
  msg           VARCHAR2(200),
  returnpath    VARCHAR2(200),
  returndata    VARCHAR2(2000),
  operator      VARCHAR2(50),
  makedate      DATE,
  maketime      VARCHAR2(20),
  modifydate    DATE,
  modifytime    VARCHAR2(20),
  subbusstype   VARCHAR2(50),
  checkflag     VARCHAR2(2),
  checkstatus   VARCHAR2(50),
  errratio      NUMBER,
  standflag1    VARCHAR2(200),
  standflag2    VARCHAR2(200),
  standflag3    VARCHAR2(200),
  standflag4    VARCHAR2(200)
)
;
comment on table T_PRP_LCPOLTRANSACTION_RETURN
  is '用于接收返回文件等';
comment on column T_PRP_LCPOLTRANSACTION_RETURN.actionflag
  is '是否处理成功';
comment on column T_PRP_LCPOLTRANSACTION_RETURN.datastatus
  is '数据处理结果状态';
comment on column T_PRP_LCPOLTRANSACTION_RETURN.queryno
  is '返回查询码';
comment on column T_PRP_LCPOLTRANSACTION_RETURN.status
  is '返回结果状态';
comment on column T_PRP_LCPOLTRANSACTION_RETURN.stateflag
  is '1-是 0-否';
comment on column T_PRP_LCPOLTRANSACTION_RETURN.msg
  is '返回错误描述';
comment on column T_PRP_LCPOLTRANSACTION_RETURN.operator
  is '操作者';
comment on column T_PRP_LCPOLTRANSACTION_RETURN.makedate
  is '入库日期';
comment on column T_PRP_LCPOLTRANSACTION_RETURN.maketime
  is '入库时间';
comment on column T_PRP_LCPOLTRANSACTION_RETURN.modifydate
  is '修改日期';
comment on column T_PRP_LCPOLTRANSACTION_RETURN.modifytime
  is '修改时间';
alter table T_PRP_LCPOLTRANSACTION_RETURN
  add constraint PK_LCPOLTRANSACTION_RETURN primary key (TRANSACTIONID, BATCHNO, BUSSTYPE);

prompt Creating T_PRP_LCPRESERVATIONPERIOD...
create table T_PRP_LCPRESERVATIONPERIOD
(
  id          VARCHAR2(50) not null,
  year        VARCHAR2(4) not null,
  apppolno    VARCHAR2(50) not null,
  apppoltype  VARCHAR2(10) not null,
  apppoldate  DATE not null,
  isunder     VARCHAR2(10) not null,
  underdate   DATE,
  companycode VARCHAR2(50) not null,
  areacode    VARCHAR2(50) not null,
  operator    VARCHAR2(50),
  makedate    DATE,
  maketime    VARCHAR2(20),
  modifydate  DATE,
  modifytime  VARCHAR2(20)
)
;
comment on table T_PRP_LCPRESERVATIONPERIOD
  is '保全时效数据来源清单';
comment on column T_PRP_LCPRESERVATIONPERIOD.id
  is '主键生成规则（前6位公司代码加四位年份加10位随机数）';
comment on column T_PRP_LCPRESERVATIONPERIOD.year
  is '数据清单提取年份';
comment on column T_PRP_LCPRESERVATIONPERIOD.apppolno
  is '保单保全业务受理号';
comment on column T_PRP_LCPRESERVATIONPERIOD.apppoltype
  is '消费者报案日期';
comment on column T_PRP_LCPRESERVATIONPERIOD.apppoldate
  is '客户申请保全业务的日期';
comment on column T_PRP_LCPRESERVATIONPERIOD.isunder
  is '是否回访成功';
comment on column T_PRP_LCPRESERVATIONPERIOD.underdate
  is '保全业务审核通过日期';
comment on column T_PRP_LCPRESERVATIONPERIOD.companycode
  is '同保监会统计信息系统上报口径';
comment on column T_PRP_LCPRESERVATIONPERIOD.operator
  is '操作人';
comment on column T_PRP_LCPRESERVATIONPERIOD.makedate
  is '入库日期';
comment on column T_PRP_LCPRESERVATIONPERIOD.maketime
  is '入库时间';
comment on column T_PRP_LCPRESERVATIONPERIOD.modifydate
  is '修改日期';
comment on column T_PRP_LCPRESERVATIONPERIOD.modifytime
  is '修改时间';
alter table T_PRP_LCPRESERVATIONPERIOD
  add constraint P_P_LCPP_PK primary key (ID, YEAR);

prompt Creating T_PRP_LCPRODINSURELA...
create table T_PRP_LCPRODINSURELA
(
  transactionno VARCHAR2(24) not null,
  companycode   VARCHAR2(6) not null,
  grppolicyno   VARCHAR2(50),
  policyno      VARCHAR2(50) not null,
  productno     VARCHAR2(50) not null,
  insuredno     VARCHAR2(50) not null,
  customerno    VARCHAR2(50),
  managecom     VARCHAR2(15),
  operator      VARCHAR2(20),
  makedate      DATE,
  maketime      VARCHAR2(20),
  modifydate    DATE,
  modifytime    VARCHAR2(20)
)
;
comment on table T_PRP_LCPRODINSURELA
  is '被保险人险种关联表';
comment on column T_PRP_LCPRODINSURELA.transactionno
  is '流水号：公司编码+日期（YYYYMMDD）+10位流水，';
comment on column T_PRP_LCPRODINSURELA.companycode
  is '保险行业保险公司总公司编码，对应《业务代码表》中的“保险机构代码”。';
comment on column T_PRP_LCPRODINSURELA.grppolicyno
  is '团体保单号，非团单为空。';
comment on column T_PRP_LCPRODINSURELA.policyno
  is '保险单的编号，个人保单合同号。';
comment on column T_PRP_LCPRODINSURELA.productno
  is '该保单下险种在保险公司系统中的唯一标识（注意不是产品编码）。';
comment on column T_PRP_LCPRODINSURELA.insuredno
  is '被保人客户在保险公司的唯一标识，需要保险公司提前对客户数据进行合并后报送。';
comment on column T_PRP_LCPRODINSURELA.customerno
  is '客户在保信的唯一标识，此字段为保信保留字段，保险公司请填写空值。';
comment on column T_PRP_LCPRODINSURELA.managecom
  is '保标委的机构代码，对应《业务代码表》中的“保险分支机构代码”。';
comment on column T_PRP_LCPRODINSURELA.operator
  is '操作者';
comment on column T_PRP_LCPRODINSURELA.makedate
  is '入库日期';
comment on column T_PRP_LCPRODINSURELA.maketime
  is '入库时间';
comment on column T_PRP_LCPRODINSURELA.modifydate
  is '修改日期';
comment on column T_PRP_LCPRODINSURELA.modifytime
  is '修改时间';
alter table T_PRP_LCPRODINSURELA
  add constraint P_LCPRODINSURELA_P primary key (TRANSACTIONNO, POLICYNO, PRODUCTNO, INSUREDNO);
create index IDX_TNO on T_PRP_LCPRODINSURELA (TRANSACTIONNO);

prompt Creating T_PRP_LCPRODUCT...
create table T_PRP_LCPRODUCT
(
  transactionno       VARCHAR2(24) not null,
  companycode         VARCHAR2(6) not null,
  grppolicyno         VARCHAR2(50),
  policyno            VARCHAR2(50) not null,
  productno           VARCHAR2(50) not null,
  gpflag              VARCHAR2(2),
  poltypeflag         VARCHAR2(1),
  mainproductno       VARCHAR2(50),
  mainproductflag     VARCHAR2(1),
  productcode         VARCHAR2(50),
  managecom           VARCHAR2(15),
  effdate             DATE,
  paybegindate        DATE,
  finalpaydate        DATE,
  curpaidtodate       DATE,
  annstartwithdwldate DATE,
  anngettodwldate     DATE,
  penstartwithdwldate DATE,
  pengettodwldate     DATE,
  invaliddate         DATE,
  paymode             VARCHAR2(2),
  paytermtype         VARCHAR2(3),
  payterm             NUMBER(10),
  insuranceperiodflag VARCHAR2(20),
  insuranceperiod     NUMBER(10),
  copies              NUMBER(10),
  premium             NUMBER(16,2),
  accumpremium        NUMBER(16,2),
  basicsuminsured     NUMBER(16,2),
  riskamnt            NUMBER(16,2),
  cashvalue           NUMBER(16,2),
  accumdiv            NUMBER(16,2),
  accumdivint         NUMBER(16,2),
  accumdivsi          NUMBER(16,2),
  lstdistridate       DATE,
  surrenderamnt       NUMBER(16,2),
  accumannuitywd      NUMBER(16,2),
  accummaturitywd     NUMBER(16,2),
  accumclmbenefit     NUMBER(16,2),
  accumclmtimes       NUMBER(10),
  insuredtype         VARCHAR2(2),
  uwconclusion        VARCHAR2(2),
  status              VARCHAR2(1),
  operator            VARCHAR2(20),
  makedate            DATE,
  maketime            VARCHAR2(20),
  modifydate          DATE,
  modifytime          VARCHAR2(20)
)
;
comment on table T_PRP_LCPRODUCT
  is '个人险种表';
comment on column T_PRP_LCPRODUCT.transactionno
  is '流水号：公司编码+日期（YYYYMMDD）+10位流水，';
comment on column T_PRP_LCPRODUCT.companycode
  is '保险行业保险公司总公司编码，对应《业务代码表》中的“保险机构代码”。';
comment on column T_PRP_LCPRODUCT.grppolicyno
  is '团体保单号，非团单为空。';
comment on column T_PRP_LCPRODUCT.policyno
  is '保险单的编号，个人保单合同号。';
comment on column T_PRP_LCPRODUCT.productno
  is '该保单下险种在保险公司系统中的唯一标识（注意不是产品编码）。';
comment on column T_PRP_LCPRODUCT.gpflag
  is '按个人、集体等特征划分的保单分类代码，对应《业务代码表》中的“保单团个性质代码”。';
comment on column T_PRP_LCPRODUCT.poltypeflag
  is '本次报送仅报送个人单（1），无名单和公共账户类型暂不报送。对应《业务代码表》中的“保单类型标记代码”。';
comment on column T_PRP_LCPRODUCT.mainproductno
  is '如果险种为主险，则同个单保险险种号码（ProductNo）；如果险种为附加险，则填写所属主险的个单保险险种号码（ProductNo）。';
comment on column T_PRP_LCPRODUCT.mainproductflag
  is '保险产品主险/附加险性质代码，对应《业务代码表》中的“主附险性质代码”。';
comment on column T_PRP_LCPRODUCT.productcode
  is '保险产品编码，对应险种定义LMProduct表中产品编码（ProductCode）。';
comment on column T_PRP_LCPRODUCT.managecom
  is '保标委的机构代码，对应《业务代码表》中的“保险分支机构代码”。';
comment on column T_PRP_LCPRODUCT.effdate
  is '合同下该产品的生效日期。';
comment on column T_PRP_LCPRODUCT.paybegindate
  is '起始缴费日期。';
comment on column T_PRP_LCPRODUCT.finalpaydate
  is '最后一期的交费日期。';
comment on column T_PRP_LCPRODUCT.curpaidtodate
  is '下次应交保费日期。如果是最后一次交费，则取本次的应交费日期。';
comment on column T_PRP_LCPRODUCT.annstartwithdwldate
  is '年金最早的领取日期。';
comment on column T_PRP_LCPRODUCT.anngettodwldate
  is '年金下期应领日期。如果已经领完，则取最后一次的应领日期。';
comment on column T_PRP_LCPRODUCT.penstartwithdwldate
  is '养老金最早领取日期。';
comment on column T_PRP_LCPRODUCT.pengettodwldate
  is '养老金下期应领日期。如果已经领完，则取最后一次的应领日期。';
comment on column T_PRP_LCPRODUCT.invaliddate
  is '保险合同上载定的保险责任终止日期。';
comment on column T_PRP_LCPRODUCT.paymode
  is '保险合同中约定的缴纳保险费的时间区间，对应《业务代码表》中的“交费频率代码”。';
comment on column T_PRP_LCPRODUCT.paytermtype
  is '交费间隔类型，对应《业务代码表》中的“交费年期类型代码”';
comment on column T_PRP_LCPRODUCT.payterm
  is 'Y：表示需要交费的年数。M：表示需要交费的月数。D：表示需要交费的天数。A：表示需要交费到的年龄数。';
comment on column T_PRP_LCPRODUCT.insuranceperiodflag
  is '保险年期类型，对应《业务代码表》中的“保险年期类型代码”。';
comment on column T_PRP_LCPRODUCT.insuranceperiod
  is 'Y：表示保险期限的年数。M：表示保险期限的月数。D：表示保险期限的天数。A：表示保险责任终止时的年龄数。';
comment on column T_PRP_LCPRODUCT.copies
  is '按照份数销售的产品，该险种购买的份数。';
comment on column T_PRP_LCPRODUCT.premium
  is '保单下该险种的当期保费。';
comment on column T_PRP_LCPRODUCT.accumpremium
  is '保单下该险种累计缴纳的保费。';
comment on column T_PRP_LCPRODUCT.basicsuminsured
  is '保单上列明的保额。';
comment on column T_PRP_LCPRODUCT.riskamnt
  is '风险保额为有效保额减去期末责任准备金加上退保手续费。';
comment on column T_PRP_LCPRODUCT.cashvalue
  is '该险种的现金价值（不含账户价值），不扣减借款和垫缴金额。';
comment on column T_PRP_LCPRODUCT.accumdiv
  is '保单下该险种累计给付的红利总额（包含已经分配未实际领取金额）。';
comment on column T_PRP_LCPRODUCT.accumdivint
  is '保单下该险种累计给付的红利利息。';
comment on column T_PRP_LCPRODUCT.accumdivsi
  is '保额分红险种累计分配的保额。';
comment on column T_PRP_LCPRODUCT.lstdistridate
  is '该险种最近一次红利分配日期。';
comment on column T_PRP_LCPRODUCT.surrenderamnt
  is '该险种退保时的退保金。';
comment on column T_PRP_LCPRODUCT.accumannuitywd
  is '保单下该险种累计领取的年金总额（应领金额）。';
comment on column T_PRP_LCPRODUCT.accummaturitywd
  is '保单下该险种的满期金金额（应领金额）。';
comment on column T_PRP_LCPRODUCT.accumclmbenefit
  is '保单下该险种累计理赔赔付金额。';
comment on column T_PRP_LCPRODUCT.accumclmtimes
  is '保单下该险种累计赔付次数。';
comment on column T_PRP_LCPRODUCT.insuredtype
  is '连带被保险人标记，对应《业务代码表》中的“主/连带被保险人类型代码”。';
comment on column T_PRP_LCPRODUCT.uwconclusion
  is '核保结论，对应《业务代码表》中的“人身险核保结论代码”。';
comment on column T_PRP_LCPRODUCT.status
  is '保单险种状态，对应《业务代码表》中的“保单/险种/责任状态代码”。';
comment on column T_PRP_LCPRODUCT.operator
  is '操作者';
comment on column T_PRP_LCPRODUCT.makedate
  is '入库日期';
comment on column T_PRP_LCPRODUCT.maketime
  is '入库时间';
comment on column T_PRP_LCPRODUCT.modifydate
  is '修改日期';
comment on column T_PRP_LCPRODUCT.modifytime
  is '修改时间';
alter table T_PRP_LCPRODUCT
  add constraint P_LCPRODUCT_PK primary key (TRANSACTIONNO, POLICYNO, PRODUCTNO);
create index IDX_LCPRODUCT_TNO on T_PRP_LCPRODUCT (TRANSACTIONNO);

prompt Creating T_PRP_LCQUOTADATA...
create table T_PRP_LCQUOTADATA
(
  quotacode  VARCHAR2(30) not null,
  quotayear  VARCHAR2(4) not null,
  quotaname  VARCHAR2(100),
  quotadate  NUMBER(20,6),
  areacode   VARCHAR2(50) not null,
  checkdate  NUMBER(15,6),
  status     VARCHAR2(1),
  operator   VARCHAR2(50),
  makedate   DATE,
  maketime   VARCHAR2(20),
  modifydate DATE,
  modifytime VARCHAR2(20)
)
;
comment on table T_PRP_LCQUOTADATA
  is '每年存放服务评价系统所需的18个指标数据';
comment on column T_PRP_LCQUOTADATA.quotacode
  is 'FWSX+6位序列号';
comment on column T_PRP_LCQUOTADATA.quotayear
  is '提供指标的年份';
comment on column T_PRP_LCQUOTADATA.quotaname
  is '指标名称，由中保信指定';
comment on column T_PRP_LCQUOTADATA.quotadate
  is '用户录入的指标数据';
comment on column T_PRP_LCQUOTADATA.checkdate
  is '由系统自动计算出的指标数据';
comment on column T_PRP_LCQUOTADATA.status
  is '用户录入值与系统计算值核对
0-核对成功
1-核对失败';
comment on column T_PRP_LCQUOTADATA.operator
  is '操作人';
comment on column T_PRP_LCQUOTADATA.makedate
  is '入库日期';
comment on column T_PRP_LCQUOTADATA.maketime
  is '入库时间';
comment on column T_PRP_LCQUOTADATA.modifydate
  is '修改日期';
comment on column T_PRP_LCQUOTADATA.modifytime
  is '修改时间';
alter table T_PRP_LCQUOTADATA
  add constraint P_P_LCQUOTADATA_PK primary key (QUOTACODE, QUOTAYEAR, AREACODE);

prompt Creating T_PRP_LCREVIEWSUCCESSRATE...
create table T_PRP_LCREVIEWSUCCESSRATE
(
  id              VARCHAR2(50) not null,
  year            VARCHAR2(50) not null,
  policyno        VARCHAR2(50) not null,
  sourcecode      VARCHAR2(50),
  sourcecode2     VARCHAR2(50),
  channel         VARCHAR2(20) not null,
  agenttype       VARCHAR2(50),
  underdate       DATE not null,
  polrecieptdate  DATE,
  hesitateenddate DATE,
  isreturnvisit   VARCHAR2(10) not null,
  companycode     VARCHAR2(50) not null,
  areacode        VARCHAR2(50) not null,
  returnvisitdate DATE,
  returnvisittype VARCHAR2(10) not null,
  operator        VARCHAR2(50),
  makedate        DATE,
  maketime        VARCHAR2(20),
  modifydate      DATE,
  modifytime      VARCHAR2(20)
)
;
comment on table T_PRP_LCREVIEWSUCCESSRATE
  is '犹豫期内电话回访成功率数据来源清单';
comment on column T_PRP_LCREVIEWSUCCESSRATE.id
  is '主键生成规则（前6位公司代码加四位年份加10位随机数）';
comment on column T_PRP_LCREVIEWSUCCESSRATE.policyno
  is '保险公司出具保险合同的编号';
comment on column T_PRP_LCREVIEWSUCCESSRATE.channel
  is '保单归属业务渠道';
comment on column T_PRP_LCREVIEWSUCCESSRATE.underdate
  is '客户缴费成功且保单核保通过的日期';
comment on column T_PRP_LCREVIEWSUCCESSRATE.polrecieptdate
  is '客户签收保单回执时的日期';
comment on column T_PRP_LCREVIEWSUCCESSRATE.hesitateenddate
  is '保单犹豫期的截止日期';
comment on column T_PRP_LCREVIEWSUCCESSRATE.isreturnvisit
  is '01—是
00—否';
comment on column T_PRP_LCREVIEWSUCCESSRATE.companycode
  is '同保监会统计信息系统上报口径';
comment on column T_PRP_LCREVIEWSUCCESSRATE.returnvisitdate
  is '保单回访成功日期';
comment on column T_PRP_LCREVIEWSUCCESSRATE.operator
  is '操作人';
comment on column T_PRP_LCREVIEWSUCCESSRATE.makedate
  is '入库日期';
comment on column T_PRP_LCREVIEWSUCCESSRATE.maketime
  is '入库时间';
comment on column T_PRP_LCREVIEWSUCCESSRATE.modifydate
  is '修改日期';
comment on column T_PRP_LCREVIEWSUCCESSRATE.modifytime
  is '修改时间';
alter table T_PRP_LCREVIEWSUCCESSRATE
  add constraint P_P_LCRSR_PK primary key (ID);

prompt Creating T_PRP_LDGETDATASQL...
create table T_PRP_LDGETDATASQL
(
  code       VARCHAR2(20) not null,
  tablename  VARCHAR2(50) not null,
  content    VARCHAR2(4000) not null,
  status     VARCHAR2(10) not null,
  standflag1 VARCHAR2(100),
  standflag2 VARCHAR2(100),
  standflag3 VARCHAR2(100),
  standflag4 VARCHAR2(100),
  operator   VARCHAR2(50),
  makedate   DATE,
  maketime   VARCHAR2(20),
  modifydate DATE,
  modifytime VARCHAR2(20)
)
;
comment on table T_PRP_LDGETDATASQL
  is '存放服务评价体系数据清单提数SQL';
comment on column T_PRP_LDGETDATASQL.code
  is '唯一识别码';
comment on column T_PRP_LDGETDATASQL.tablename
  is '提数的目标表';
comment on column T_PRP_LDGETDATASQL.content
  is '提取SQL';
comment on column T_PRP_LDGETDATASQL.status
  is '0-不可用
1-使用中';
comment on column T_PRP_LDGETDATASQL.standflag1
  is '备用字段1';
comment on column T_PRP_LDGETDATASQL.standflag2
  is '备用字段2';
comment on column T_PRP_LDGETDATASQL.standflag3
  is '备用字段3';
comment on column T_PRP_LDGETDATASQL.standflag4
  is '备用字段4';
comment on column T_PRP_LDGETDATASQL.operator
  is '操作人';
comment on column T_PRP_LDGETDATASQL.makedate
  is '入库日期';
comment on column T_PRP_LDGETDATASQL.maketime
  is '入库时间';
comment on column T_PRP_LDGETDATASQL.modifydate
  is '修改日期';
comment on column T_PRP_LDGETDATASQL.modifytime
  is '修改时间';
alter table T_PRP_LDGETDATASQL
  add constraint P_P_LDGDS_PK primary key (CODE);

prompt Creating T_PRP_LDUSERFILE...
create table T_PRP_LDUSERFILE
(
  id         VARCHAR2(30) not null,
  filename   VARCHAR2(50),
  filetype   VARCHAR2(10),
  filepath   VARCHAR2(200),
  operator   VARCHAR2(20),
  makedate   DATE,
  maketime   VARCHAR2(20),
  modifydate DATE,
  modifytime VARCHAR2(20)
)
;

prompt Creating T_PRP_LJAGET...
create table T_PRP_LJAGET
(
  transactionno   VARCHAR2(24) not null,
  companycode     VARCHAR2(6),
  grppolicyno     VARCHAR2(50),
  policyno        VARCHAR2(50) not null,
  prtno           VARCHAR2(50),
  actugetno       VARCHAR2(50) not null,
  gettype         VARCHAR2(10) not null,
  getway          VARCHAR2(10),
  currency        VARCHAR2(3),
  sumactugetmoney NUMBER(16,2),
  enteraccdate    DATE,
  confdate        DATE,
  bankcode        VARCHAR2(20),
  bankname        VARCHAR2(100),
  bankaccno       VARCHAR2(40),
  accname         VARCHAR2(120),
  certtype        VARCHAR2(3),
  certno          VARCHAR2(50),
  operator        VARCHAR2(20),
  makedate        DATE,
  maketime        VARCHAR2(20),
  modifydate      DATE,
  modifytime      VARCHAR2(20)
)
;
comment on table T_PRP_LJAGET
  is '财务实付信息模块表';
comment on column T_PRP_LJAGET.operator
  is '操作者';
comment on column T_PRP_LJAGET.makedate
  is '入库日期';
comment on column T_PRP_LJAGET.maketime
  is '入库时间';
comment on column T_PRP_LJAGET.modifydate
  is '修改日期';
comment on column T_PRP_LJAGET.modifytime
  is '修改时间';
alter table T_PRP_LJAGET
  add constraint P_LJAGET_PK primary key (TRANSACTIONNO, POLICYNO, ACTUGETNO, GETTYPE);
create index IDX_LJAGET_TNO on T_PRP_LJAGET (TRANSACTIONNO);

prompt Creating T_PRP_LJAGETLIVBENE...
create table T_PRP_LJAGETLIVBENE
(
  transactionno    VARCHAR2(24) not null,
  companycode      VARCHAR2(6),
  grppolicyno      VARCHAR2(50),
  policyno         VARCHAR2(50),
  productno        VARCHAR2(50),
  wdno             VARCHAR2(50),
  appntno          VARCHAR2(50),
  insuredno        VARCHAR2(50),
  benefitdate      DATE,
  benefitamount    NUMBER(16,2),
  enteraccdate     DATE,
  managecom        VARCHAR2(15),
  withdrawaltodate DATE,
  bankcode         VARCHAR2(20),
  bankname         VARCHAR2(100),
  bankaccno        VARCHAR2(40),
  accname          VARCHAR2(120),
  certtype         VARCHAR2(3),
  certno           VARCHAR2(50),
  operator         VARCHAR2(20),
  makedate         DATE,
  maketime         VARCHAR2(20),
  modifydate       DATE,
  modifytime       VARCHAR2(20)
)
;
comment on table T_PRP_LJAGETLIVBENE
  is '生存金领取表';
comment on column T_PRP_LJAGETLIVBENE.transactionno
  is '流水号：公司编码+日期（YYYYMMDD）+10位流水。';
comment on column T_PRP_LJAGETLIVBENE.companycode
  is '保险行业保险公司总公司编码，对应《业务代码表》中的“保险机构代码”。';
comment on column T_PRP_LJAGETLIVBENE.grppolicyno
  is '团体保单号，非团单为空。';
comment on column T_PRP_LJAGETLIVBENE.policyno
  is '保险单的编号，个人保单合同号。';
comment on column T_PRP_LJAGETLIVBENE.productno
  is '该保单下险种在保险公司系统中的唯一标识（注意不是产品编码）。';
comment on column T_PRP_LJAGETLIVBENE.wdno
  is '保单生存金领取的顺序号码。';
comment on column T_PRP_LJAGETLIVBENE.appntno
  is '投保人客户在保险公司的唯一标识，需要保险公司提前对客户数据进行合并后报送。';
comment on column T_PRP_LJAGETLIVBENE.insuredno
  is '被保人客户在保险公司的唯一标识，需要保险公司提前对客户数据进行合并后报送。';
comment on column T_PRP_LJAGETLIVBENE.benefitdate
  is '生存金领取申请通过日期。';
comment on column T_PRP_LJAGETLIVBENE.benefitamount
  is '给付生存金金额。';
comment on column T_PRP_LJAGETLIVBENE.enteraccdate
  is '生存金到领取人银行账户日期。';
comment on column T_PRP_LJAGETLIVBENE.managecom
  is '保标委的机构代码，对应《业务代码表》中的“保险分支机构代码”。';
comment on column T_PRP_LJAGETLIVBENE.withdrawaltodate
  is '下次生存金的应领日期。如果本次领取时最后一次领取，则取本次的应领日期。';
comment on column T_PRP_LJAGETLIVBENE.bankcode
  is '各保险公司核心业务系统所存的银行编码；也可参考《业务代码表》中的“银行编码”。';
comment on column T_PRP_LJAGETLIVBENE.bankname
  is '银行名称';
comment on column T_PRP_LJAGETLIVBENE.bankaccno
  is '生存金领取人银行的户头的账号。';
comment on column T_PRP_LJAGETLIVBENE.accname
  is '生存金领取人银行账户名。';
comment on column T_PRP_LJAGETLIVBENE.certtype
  is '证件类型的代码，对应《业务代码表》中的“个人身份证件类型代码”。跟资金相关的人的证件类型';
comment on column T_PRP_LJAGETLIVBENE.certno
  is '证件的号码。跟资金相关的人的证件号码。';
comment on column T_PRP_LJAGETLIVBENE.operator
  is '操作者';
comment on column T_PRP_LJAGETLIVBENE.makedate
  is '入库日期';
comment on column T_PRP_LJAGETLIVBENE.maketime
  is '入库时间';
comment on column T_PRP_LJAGETLIVBENE.modifydate
  is '修改日期';
comment on column T_PRP_LJAGETLIVBENE.modifytime
  is '修改时间';
create index IDX_LJAGETLIVBENE_TNO on T_PRP_LJAGETLIVBENE (TRANSACTIONNO);

prompt Creating T_PRP_LJAPAY...
create table T_PRP_LJAPAY
(
  transactionno   VARCHAR2(24) not null,
  companycode     VARCHAR2(6),
  grppolicyno     VARCHAR2(50),
  policyno        VARCHAR2(50),
  payno           VARCHAR2(50),
  productno       VARCHAR2(50),
  productcode     VARCHAR2(50),
  managecom       VARCHAR2(15),
  appntno         VARCHAR2(50),
  sumactupaymoney NUMBER(16,2),
  enteraccdate    DATE,
  confdate        DATE,
  curpaidtodate   DATE,
  bankcode        VARCHAR2(20),
  bankname        VARCHAR2(100),
  bankaccno       VARCHAR2(40),
  accname         VARCHAR2(120),
  certtype        VARCHAR2(3),
  certno          VARCHAR2(50),
  operator        VARCHAR2(20),
  makedate        DATE,
  maketime        VARCHAR2(20),
  modifydate      DATE,
  modifytime      VARCHAR2(20)
)
;
comment on table T_PRP_LJAPAY
  is '保费明细表';
comment on column T_PRP_LJAPAY.transactionno
  is '流水号：公司编码+日期（YYYYMMDD）+10位流水。';
comment on column T_PRP_LJAPAY.companycode
  is '保险行业保险公司总公司编码，对应《业务代码表》中的“保险机构代码”。';
comment on column T_PRP_LJAPAY.grppolicyno
  is '团体保单号，非团单为空。';
comment on column T_PRP_LJAPAY.policyno
  is '保险单的编号，个人保单合同号。';
comment on column T_PRP_LJAPAY.payno
  is '保单交费的顺序号码。';
comment on column T_PRP_LJAPAY.productno
  is '该保单下险种在保险公司系统中的唯一标识（注意不是产品编码）。';
comment on column T_PRP_LJAPAY.productcode
  is '保险产品编码，对应险种定义LMProduct表中产品编码（ProductCode）。';
comment on column T_PRP_LJAPAY.managecom
  is '保标委的机构代码，对应《业务代码表》中的“保险分支机构代码”。';
comment on column T_PRP_LJAPAY.appntno
  is '投保人客户在保险公司的唯一标识，需要保险公司提前对客户数据进行合并后报送。';
comment on column T_PRP_LJAPAY.sumactupaymoney
  is '本次缴费的总金额。';
comment on column T_PRP_LJAPAY.enteraccdate
  is '交费到账日期。';
comment on column T_PRP_LJAPAY.confdate
  is '交费核销为保费的日期。';
comment on column T_PRP_LJAPAY.curpaidtodate
  is '下次应交保费日期。如果是最后一次交费，则取本次的应交费日期。';
comment on column T_PRP_LJAPAY.bankcode
  is '各保险公司核心业务系统所存的银行编码；也可参考《业务代码表》中的“银行编码”。';
comment on column T_PRP_LJAPAY.bankname
  is '银行名称';
comment on column T_PRP_LJAPAY.bankaccno
  is '红利领取人银行的户头的账号。';
comment on column T_PRP_LJAPAY.accname
  is '红利领取人银行账户名';
comment on column T_PRP_LJAPAY.certtype
  is '证件类型的代码，对应《业务代码表》中的“个人身份证件类型代码”。跟资金相关的人的证件类型';
comment on column T_PRP_LJAPAY.certno
  is '证件的号码。跟资金相关的人的证件号码。';
comment on column T_PRP_LJAPAY.operator
  is '操作者';
comment on column T_PRP_LJAPAY.makedate
  is '入库日期';
comment on column T_PRP_LJAPAY.maketime
  is '入库时间';
comment on column T_PRP_LJAPAY.modifydate
  is '修改日期';
comment on column T_PRP_LJAPAY.modifytime
  is '修改时间';
create index IDX_LJAPAY_TNO on T_PRP_LJAPAY (TRANSACTIONNO);

prompt Creating T_PRP_LJDIVDISTRIB...
create table T_PRP_LJDIVDISTRIB
(
  transactionno  VARCHAR2(24) not null,
  companycode    VARCHAR2(6) not null,
  grppolicyno    VARCHAR2(50),
  policyno       VARCHAR2(50) not null,
  productno      VARCHAR2(50) not null,
  divyear        VARCHAR2(4) not null,
  divtype        VARCHAR2(10) not null,
  divdistribmeth VARCHAR2(1) not null,
  divamnt        NUMBER(16,2),
  managecom      VARCHAR2(15),
  appntno        VARCHAR2(50),
  appntname      VARCHAR2(120),
  bankcode       VARCHAR2(20),
  bankname       VARCHAR2(100),
  bankaccno      VARCHAR2(40),
  accname        VARCHAR2(120),
  certtype       VARCHAR2(3),
  certno         VARCHAR2(50),
  operator       VARCHAR2(20),
  makedate       DATE,
  maketime       VARCHAR2(20),
  modifydate     DATE,
  modifytime     VARCHAR2(20)
)
;
comment on table T_PRP_LJDIVDISTRIB
  is '红利分配表';
comment on column T_PRP_LJDIVDISTRIB.transactionno
  is '流水号：公司编码+日期（YYYYMMDD）+10位流水。';
comment on column T_PRP_LJDIVDISTRIB.companycode
  is '保险行业保险公司总公司编码，对应《业务代码表》中的“保险机构代码”。';
comment on column T_PRP_LJDIVDISTRIB.grppolicyno
  is '团体保单号，非团单为空。';
comment on column T_PRP_LJDIVDISTRIB.policyno
  is '保险单的编号，个人保单合同号。';
comment on column T_PRP_LJDIVDISTRIB.productno
  is '该保单下险种在保险公司系统中的唯一标识（注意不是产品编码）。';
comment on column T_PRP_LJDIVDISTRIB.divyear
  is '保单应分红的红利年度。';
comment on column T_PRP_LJDIVDISTRIB.divtype
  is '分红类型为英式分红或美式分红，对应《业务代码表》中的“红利类型代码”。';
comment on column T_PRP_LJDIVDISTRIB.divdistribmeth
  is '红利分配方式，对应《业务代码表》中的“红利领取方式代码”。';
comment on column T_PRP_LJDIVDISTRIB.divamnt
  is '领取红利金额';
comment on column T_PRP_LJDIVDISTRIB.managecom
  is '保标委的机构代码，对应《业务代码表》中的“保险分支机构代码”。';
comment on column T_PRP_LJDIVDISTRIB.appntno
  is '投保人客户在保险公司的唯一标识，需要保险公司提前对客户数据进行合并后报送。';
comment on column T_PRP_LJDIVDISTRIB.appntname
  is '投保人姓名。';
comment on column T_PRP_LJDIVDISTRIB.bankcode
  is '各保险公司核心业务系统所存的银行编码；也可参考《业务代码表》中的“银行编码”。';
comment on column T_PRP_LJDIVDISTRIB.bankname
  is '银行名称';
comment on column T_PRP_LJDIVDISTRIB.bankaccno
  is '红利领取人银行的户头的账号。';
comment on column T_PRP_LJDIVDISTRIB.accname
  is '红利领取人银行账户名';
comment on column T_PRP_LJDIVDISTRIB.certtype
  is '证件类型的代码，对应《业务代码表》中的“个人身份证件类型代码”。跟资金相关的人的证件类型';
comment on column T_PRP_LJDIVDISTRIB.certno
  is '证件的号码。跟资金相关的人的证件号码。';
comment on column T_PRP_LJDIVDISTRIB.operator
  is '操作者';
comment on column T_PRP_LJDIVDISTRIB.makedate
  is '入库日期';
comment on column T_PRP_LJDIVDISTRIB.maketime
  is '入库时间';
comment on column T_PRP_LJDIVDISTRIB.modifydate
  is '修改日期';
comment on column T_PRP_LJDIVDISTRIB.modifytime
  is '修改时间';
alter table T_PRP_LJDIVDISTRIB
  add constraint P_LJDIVDISRIB_PK primary key (TRANSACTIONNO, POLICYNO, PRODUCTNO, DIVYEAR, DIVTYPE, DIVDISTRIBMETH);
create index IDX_LJDIVDISTRIB_TNO on T_PRP_LJDIVDISTRIB (TRANSACTIONNO);

prompt Creating T_PRP_LJTEMPFEE...
create table T_PRP_LJTEMPFEE
(
  transactionno VARCHAR2(24) not null,
  companycode   VARCHAR2(6) not null,
  grppolicyno   VARCHAR2(50),
  policyno      VARCHAR2(50) not null,
  prtno         VARCHAR2(50) not null,
  managecom     VARCHAR2(15),
  receiptno     VARCHAR2(50) not null,
  payamnt       NUMBER(16,2),
  currency      VARCHAR2(3),
  enteraccdate  DATE,
  recogdate     DATE,
  bankcode      VARCHAR2(20),
  bankname      VARCHAR2(100),
  bankaccno     VARCHAR2(40),
  accname       VARCHAR2(120),
  certtype      VARCHAR2(3),
  certno        VARCHAR2(50),
  operator      VARCHAR2(20),
  makedate      DATE,
  maketime      VARCHAR2(20),
  modifydate    DATE,
  modifytime    VARCHAR2(20)
)
;
comment on table T_PRP_LJTEMPFEE
  is '暂收费表';
comment on column T_PRP_LJTEMPFEE.transactionno
  is '流水号：公司编码+日期';
comment on column T_PRP_LJTEMPFEE.companycode
  is '保险行业保险公司总公司编码，对应《业务代码表》中的“保险机构代码”。';
comment on column T_PRP_LJTEMPFEE.grppolicyno
  is '团体保单号，非团单为空。';
comment on column T_PRP_LJTEMPFEE.policyno
  is '保险单的编号，个人保单合同号；如果没有承保，保单号字段赋值投保单号或印刷号即可或划款协议号。';
comment on column T_PRP_LJTEMPFEE.prtno
  is '投保单印刷号码。';
comment on column T_PRP_LJTEMPFEE.managecom
  is '保标委的机构代码，对应《业务代码表》中的“保险分支机构代码”。';
comment on column T_PRP_LJTEMPFEE.receiptno
  is '每笔交费对应的凭证号码，且针对该笔交费的核销或者退费该字段为同一号码。';
comment on column T_PRP_LJTEMPFEE.payamnt
  is '本期缴费金额。当报送预收未核销数据时及核销数据时交费金额为正数，当报送退费数据时交费金额需为负数。';
comment on column T_PRP_LJTEMPFEE.currency
  is '国际上表示货币和资金的名称，对应《业务代码表》中的“货币代码”。';
comment on column T_PRP_LJTEMPFEE.enteraccdate
  is '到账日期，''YYYY-MM-DD''。';
comment on column T_PRP_LJTEMPFEE.recogdate
  is '核销日期，''YYYY-MM-DD''，由暂收确认为保费的日期。';
comment on column T_PRP_LJTEMPFEE.bankcode
  is '各保险公司核心业务系统所存的银行编码；也可参考《业务代码表》中的“银行编码”。';
comment on column T_PRP_LJTEMPFEE.bankname
  is '银行名称。';
comment on column T_PRP_LJTEMPFEE.bankaccno
  is '开户人或单位银行的户头的账号。';
comment on column T_PRP_LJTEMPFEE.accname
  is '缴费人银行账户名。';
comment on column T_PRP_LJTEMPFEE.certtype
  is '证件类型的代码，对应《业务代码表》中的“个人身份证件类型代码”。跟资金相关的人的证件类型。';
comment on column T_PRP_LJTEMPFEE.certno
  is '证件的号码。跟资金相关的人的证件号码。';
comment on column T_PRP_LJTEMPFEE.operator
  is '操作者';
comment on column T_PRP_LJTEMPFEE.makedate
  is '入库日期';
comment on column T_PRP_LJTEMPFEE.maketime
  is '入库时间';
comment on column T_PRP_LJTEMPFEE.modifydate
  is '修改日期';
comment on column T_PRP_LJTEMPFEE.modifytime
  is '修改时间';
alter table T_PRP_LJTEMPFEE
  add constraint P_LCTEMPFEE_PK primary key (TRANSACTIONNO, COMPANYCODE, POLICYNO, PRTNO, RECEIPTNO);
create index IDX_LJTEMPFEE_TNO on T_PRP_LJTEMPFEE (TRANSACTIONNO);

prompt Creating T_PRP_LLBNF...
create table T_PRP_LLBNF
(
  transactionno             VARCHAR2(24) not null,
  companycode               VARCHAR2(6),
  claimno                   VARCHAR2(50) not null,
  grppolicyno               VARCHAR2(50),
  policyno                  VARCHAR2(50) not null,
  productno                 VARCHAR2(50) not null,
  insuredno                 VARCHAR2(50),
  customerno                VARCHAR2(50),
  bnfserialnum              VARCHAR2(50) not null,
  bnfcat                    VARCHAR2(1),
  bnflevel                  VARCHAR2(1),
  relationtoinsured         VARCHAR2(10),
  name                      VARCHAR2(120),
  sex                       VARCHAR2(1),
  birthdate                 DATE,
  certtype                  VARCHAR2(3),
  certno                    VARCHAR2(50),
  relationofpayeeandinsured VARCHAR2(3),
  payeeno                   VARCHAR2(50),
  payeename                 VARCHAR2(120),
  payeesex                  VARCHAR2(1),
  payeebirthday             DATE,
  payeecerttype             VARCHAR2(3),
  payeecertno               VARCHAR2(50),
  percentofbenefit          NUMBER(16,6),
  drawingamnt               NUMBER(16,2),
  benefitwdmthd             VARCHAR2(1),
  benefitpaymthd            VARCHAR2(2),
  bankcode                  VARCHAR2(20),
  bankname                  VARCHAR2(100),
  bankaccno                 VARCHAR2(40),
  accname                   VARCHAR2(120),
  operator                  VARCHAR2(20),
  makedate                  DATE,
  maketime                  VARCHAR2(20),
  modifydate                DATE,
  modifytime                VARCHAR2(20)
)
;
comment on table T_PRP_LLBNF
  is '理赔受益人账户表';
comment on column T_PRP_LLBNF.transactionno
  is '流水号：公司编码+日期（YYYYMMDD）+10位流水。';
comment on column T_PRP_LLBNF.companycode
  is '保险行业保险公司总公司编码，对应《业务代码表》中的“保险机构代码”。';
comment on column T_PRP_LLBNF.claimno
  is '保险公司记录的该案件的赔案号。';
comment on column T_PRP_LLBNF.grppolicyno
  is '团体保单号，非团单为空。';
comment on column T_PRP_LLBNF.policyno
  is '保险单的编号，个人保单合同号。';
comment on column T_PRP_LLBNF.productno
  is '该保单下险种在保险公司系统中的唯一标识（注意不是产品编码）。';
comment on column T_PRP_LLBNF.insuredno
  is '出险人的客户号码；被保人客户在保险公司的唯一标识，需要保险公司提前对客户数据进行合并后报送。';
comment on column T_PRP_LLBNF.customerno
  is '客户在保信的唯一标识，此字段为保信保留字段，保险公司请填写空值。';
comment on column T_PRP_LLBNF.bnfserialnum
  is '该保单下受益人在保险公司系统中的唯一标识。';
comment on column T_PRP_LLBNF.bnfcat
  is '受益人类别，对应《业务代码表》中的“生存/身故受益人类型代码”。';
comment on column T_PRP_LLBNF.bnflevel
  is '受益人级别，指对受益人进行分组，对应《业务代码表》中的“受益顺序代码”。';
comment on column T_PRP_LLBNF.relationtoinsured
  is '人员关系的标识代码，对应《业务代码表》中的“人员关系代码”。';
comment on column T_PRP_LLBNF.name
  is '人身保险合同中由被保险人或者投保人指定的享有保险金请求权的人。';
comment on column T_PRP_LLBNF.sex
  is '受益人性别代码，对应《业务代码表》中的“性别代码”。';
comment on column T_PRP_LLBNF.birthdate
  is '出生证签署的并在公安户籍部门登记注册、人事档案中记载的日期。';
comment on column T_PRP_LLBNF.certtype
  is '受益人登记的证件类型代码，对应《业务代码表》中的“个人身份证件类型代码”。';
comment on column T_PRP_LLBNF.certno
  is '受益人登记的证件号码。';
comment on column T_PRP_LLBNF.relationofpayeeandinsured
  is '领款人与被保人关系关系的标识代码，对应《业务代码表》中的“人员关系代码”。';
comment on column T_PRP_LLBNF.payeeno
  is '领款人在保险系统内唯一标识。';
comment on column T_PRP_LLBNF.payeename
  is '领款人姓名。';
comment on column T_PRP_LLBNF.payeesex
  is '领款人性别代码，对应《业务代码表》中的“性别代码”。';
comment on column T_PRP_LLBNF.payeebirthday
  is '领款人出生日期。';
comment on column T_PRP_LLBNF.payeecerttype
  is '领款人的证件类型，对应《业务代码表》中的“个人身份证件类型代码”。';
comment on column T_PRP_LLBNF.payeecertno
  is '领款人的证件号码。';
comment on column T_PRP_LLBNF.percentofbenefit
  is '保险合同受益人获取收益份额的百分比。请填写小数，如果收益比例为30%，则填写0.3。';
comment on column T_PRP_LLBNF.drawingamnt
  is '受益人领取的金额。';
comment on column T_PRP_LLBNF.benefitwdmthd
  is '保险金领取方式，对应《业务代码表》中的“赔付金领取方式代码”。';
comment on column T_PRP_LLBNF.benefitpaymthd
  is '保险金支付方式，对应《业务代码表》中的“收付款方式代码”。';
comment on column T_PRP_LLBNF.bankcode
  is '各保险公司核心业务系统所存的银行编码；也可参考《业务代码表》中的“银行编码”。';
comment on column T_PRP_LLBNF.bankname
  is '银行名称。';
comment on column T_PRP_LLBNF.bankaccno
  is '领款人的银行的户头的账号。';
comment on column T_PRP_LLBNF.accname
  is '领款人的银行账户名。';
comment on column T_PRP_LLBNF.operator
  is '操作者';
comment on column T_PRP_LLBNF.makedate
  is '入库日期';
comment on column T_PRP_LLBNF.maketime
  is '入库时间';
comment on column T_PRP_LLBNF.modifydate
  is '修改日期';
comment on column T_PRP_LLBNF.modifytime
  is '修改时间';
alter table T_PRP_LLBNF
  add constraint LLBNF_PK primary key (TRANSACTIONNO, CLAIMNO, POLICYNO, PRODUCTNO, BNFSERIALNUM);
create index IDX_LLBNF_TNO on T_PRP_LLBNF (TRANSACTIONNO);

prompt Creating T_PRP_LLCLAIMPOLICY...
create table T_PRP_LLCLAIMPOLICY
(
  transactionno     VARCHAR2(24) not null,
  companycode       VARCHAR2(6) not null,
  clmcaseno         VARCHAR2(50) not null,
  clmregisterno     VARCHAR2(50) not null,
  grppolicyno       VARCHAR2(50),
  policyno          VARCHAR2(50) not null,
  productno         VARCHAR2(50) not null,
  rgtdate           DATE,
  lossoccurdate     DATE,
  lossoccurlocation VARCHAR2(200),
  lossoccurreason   VARCHAR2(10),
  accidentdesc      VARCHAR2(1000),
  benefittype       VARCHAR2(10),
  productcode       VARCHAR2(50),
  currency          VARCHAR2(3),
  clmacountamnt     NUMBER(16,2),
  clmassessamnt     NUMBER(16,2),
  rejectamnt        NUMBER(16,2),
  prepayamnt        NUMBER(16,2),
  approveamnt       NUMBER(16,2),
  agreeamnt         NUMBER(16,2),
  clmsettdate       DATE,
  paystatuscode     VARCHAR2(2),
  managecom         VARCHAR2(15),
  operator          VARCHAR2(20),
  makedate          DATE,
  maketime          VARCHAR2(20),
  modifydate        DATE,
  modifytime        VARCHAR2(20)
)
;
comment on table T_PRP_LLCLAIMPOLICY
  is '理赔保单明细表';
comment on column T_PRP_LLCLAIMPOLICY.transactionno
  is '流水号：公司编码+日期（YYYYMMDD）+10位流水。';
comment on column T_PRP_LLCLAIMPOLICY.companycode
  is '保险行业保险公司总公司编码，对应《业务代码表》中的“保险机构代码”。';
comment on column T_PRP_LLCLAIMPOLICY.clmcaseno
  is '保险公司记录的该案件的赔案号。';
comment on column T_PRP_LLCLAIMPOLICY.clmregisterno
  is '保险公司记录的该案件的立案号。';
comment on column T_PRP_LLCLAIMPOLICY.grppolicyno
  is '团体保单号，非团单为空。';
comment on column T_PRP_LLCLAIMPOLICY.policyno
  is '保险单的编号，个人保单合同号。';
comment on column T_PRP_LLCLAIMPOLICY.productno
  is '该保单下险种在保险公司系统中的唯一标识（注意不是产品编码）。';
comment on column T_PRP_LLCLAIMPOLICY.rgtdate
  is '对保险客户的理赔申请进行立案的日期。';
comment on column T_PRP_LLCLAIMPOLICY.lossoccurdate
  is '保险期间内被保险人的财产或生命发生了保险责任范围内的保险事故的时间。';
comment on column T_PRP_LLCLAIMPOLICY.lossoccurlocation
  is '保险事故发生地所在区域的名称。';
comment on column T_PRP_LLCLAIMPOLICY.lossoccurreason
  is '被保险人出险原因，对应《业务代码表》中的“人身险出险原因代码”。';
comment on column T_PRP_LLCLAIMPOLICY.accidentdesc
  is '对被保险人事故的详细描述。';
comment on column T_PRP_LLCLAIMPOLICY.benefittype
  is '赔付责任类型，对应《业务代码表》中的“赔付责任类型代码”。';
comment on column T_PRP_LLCLAIMPOLICY.productcode
  is '保险产品编码，对应险种定义LMProduct表中产品编码（ProductCode）。';
comment on column T_PRP_LLCLAIMPOLICY.currency
  is '国际上表示货币和资金的名称代码，对应《业务代码表》中的“货币代码”。';
comment on column T_PRP_LLCLAIMPOLICY.clmacountamnt
  is '理算后的赔偿或给付金额。';
comment on column T_PRP_LLCLAIMPOLICY.clmassessamnt
  is '通过核赔后确定的赔付金额。';
comment on column T_PRP_LLCLAIMPOLICY.rejectamnt
  is '拒绝赔偿的非责任内的金额。';
comment on column T_PRP_LLCLAIMPOLICY.prepayamnt
  is '保险人对索赔的证明文件进行审核后认为事故属于保险责任，并在最终赔款金额之前，预先支付的可以确定的最低数额的赔款金额。';
comment on column T_PRP_LLCLAIMPOLICY.approveamnt
  is '通融给付下的金额合计。';
comment on column T_PRP_LLCLAIMPOLICY.agreeamnt
  is '协议给付下的金额合计。协议给付是指双方通过协议达成的赔付金额。
如果没有该给付方式，该金额可以为0。';
comment on column T_PRP_LLCLAIMPOLICY.clmsettdate
  is '赔案结束的日期。';
comment on column T_PRP_LLCLAIMPOLICY.paystatuscode
  is '核赔结论类型，对应《业务代码表》中的“理赔结论代码”。';
comment on column T_PRP_LLCLAIMPOLICY.managecom
  is '保标委的机构代码，对应《业务代码表》中的“保险分支机构代码”。';
comment on column T_PRP_LLCLAIMPOLICY.operator
  is '操作者';
comment on column T_PRP_LLCLAIMPOLICY.makedate
  is '入库日期';
comment on column T_PRP_LLCLAIMPOLICY.maketime
  is '入库时间';
comment on column T_PRP_LLCLAIMPOLICY.modifydate
  is '修改日期';
comment on column T_PRP_LLCLAIMPOLICY.modifytime
  is '修改时间';
create index IDX_LLCLAIMPOLICY_TNO on T_PRP_LLCLAIMPOLICY (TRANSACTIONNO);

prompt Creating T_PRP_LMPRODUCT...
create table T_PRP_LMPRODUCT
(
  transactionno   VARCHAR2(24) not null,
  companycode     VARCHAR2(6) not null,
  productcode     VARCHAR2(50) not null,
  productname     VARCHAR2(120),
  productabbr     VARCHAR2(120),
  productenname   VARCHAR2(120),
  porductenabbr   VARCHAR2(120),
  insuaccflag     VARCHAR2(1),
  assumintrate    NUMBER(16,6),
  gpflag          VARCHAR2(2),
  mainproductflag VARCHAR2(1),
  stopdate        DATE,
  saleflag        VARCHAR2(1),
  circriskcode    VARCHAR2(20),
  operator        VARCHAR2(20),
  makedate        DATE,
  maketime        VARCHAR2(20),
  modifydate      DATE,
  modifytime      VARCHAR2(20),
  producttype     VARCHAR2(50),
  investmenttype  VARCHAR2(30),
  termtype        VARCHAR2(20)
)
;
comment on table T_PRP_LMPRODUCT
  is '险种定义表';
comment on column T_PRP_LMPRODUCT.transactionno
  is '流水号：公司编码+日期（YYYYMMDD）+10位流水。';
comment on column T_PRP_LMPRODUCT.companycode
  is '保险行业保险公司总公司编码，对应《业务代码表》中的“保险机构代码”。';
comment on column T_PRP_LMPRODUCT.productcode
  is '保险产品使用的缩写标识。';
comment on column T_PRP_LMPRODUCT.productname
  is '保险产品中文名称';
comment on column T_PRP_LMPRODUCT.productabbr
  is '保险产品简称';
comment on column T_PRP_LMPRODUCT.productenname
  is '保险产品英文全称。';
comment on column T_PRP_LMPRODUCT.porductenabbr
  is '保险产品英文简称';
comment on column T_PRP_LMPRODUCT.insuaccflag
  is '是否有保险账户标记。对应《业务代码表》中的“保险账户标记代码”。';
comment on column T_PRP_LMPRODUCT.assumintrate
  is '该险种的预定利率,利差返还时用到。请填写小数，如果利率为0.1%，则填写0.001。';
comment on column T_PRP_LMPRODUCT.gpflag
  is '按个人、集体等特征划分的保单分类代码，对应《业务代码表》中的“保单团个性质代码”。';
comment on column T_PRP_LMPRODUCT.mainproductflag
  is '保险产品主险/附加险性质代码，对应《业务代码表》中的“主附险性质代码”。';
comment on column T_PRP_LMPRODUCT.stopdate
  is '该产品停售日期';
comment on column T_PRP_LMPRODUCT.saleflag
  is '该产品是否在售。对应《业务代码表》中的“在售标记代码”。';
comment on column T_PRP_LMPRODUCT.circriskcode
  is '该产品在保监会的产品编码。';
comment on column T_PRP_LMPRODUCT.operator
  is '操作者';
comment on column T_PRP_LMPRODUCT.makedate
  is '入库日期';
comment on column T_PRP_LMPRODUCT.maketime
  is '入库时间';
comment on column T_PRP_LMPRODUCT.modifydate
  is '修改日期';
comment on column T_PRP_LMPRODUCT.modifytime
  is '修改时间';
alter table T_PRP_LMPRODUCT
  add constraint LMPRODUCT_PK primary key (TRANSACTIONNO, COMPANYCODE, PRODUCTCODE);

prompt Creating T_PRP_MODE2TABLERELA...
create table T_PRP_MODE2TABLERELA
(
  relaid         VARCHAR2(20) not null,
  modeno         VARCHAR2(20) not null,
  tablename      VARCHAR2(50) not null,
  configfilepath VARCHAR2(2000),
  standflag1     VARCHAR2(2000),
  standflag2     VARCHAR2(2000),
  standflag3     VARCHAR2(2000),
  standflag4     VARCHAR2(2000),
  stateflag      VARCHAR2(2)
)
;
comment on table T_PRP_MODE2TABLERELA
  is '模块与数据表的关联关系';
comment on column T_PRP_MODE2TABLERELA.configfilepath
  is 'Spoon提数配置文件路径';
comment on column T_PRP_MODE2TABLERELA.standflag1
  is '备用字段1';
comment on column T_PRP_MODE2TABLERELA.standflag2
  is '备用字段2';
comment on column T_PRP_MODE2TABLERELA.standflag3
  is '备用字段3';
comment on column T_PRP_MODE2TABLERELA.standflag4
  is '备用字段4';
alter table T_PRP_MODE2TABLERELA
  add constraint P_MODE2TABLERELA_P primary key (RELAID, MODENO, TABLENAME);

prompt Creating T_PRP_MODEINFO...
create table T_PRP_MODEINFO
(
  modeno     VARCHAR2(20) not null,
  modename   VARCHAR2(50),
  stateflag  VARCHAR2(2),
  operator   VARCHAR2(20),
  makedate   DATE,
  maketime   VARCHAR2(20),
  modifydate DATE,
  modifytime VARCHAR2(20),
  emodename  VARCHAR2(50)
)
;
comment on table T_PRP_MODEINFO
  is '记录模块的信息';
comment on column T_PRP_MODEINFO.modeno
  is '模块的编号';
comment on column T_PRP_MODEINFO.modename
  is '模块对应名称';
comment on column T_PRP_MODEINFO.stateflag
  is '模块状态标识是否有效： 1 - 是 0 - 否';
comment on column T_PRP_MODEINFO.operator
  is '操作者';
comment on column T_PRP_MODEINFO.makedate
  is '入库日期';
comment on column T_PRP_MODEINFO.maketime
  is '入库时间';
comment on column T_PRP_MODEINFO.modifydate
  is '修改日期';
comment on column T_PRP_MODEINFO.modifytime
  is '修改时间';
comment on column T_PRP_MODEINFO.emodename
  is '模块英文名称';
alter table T_PRP_MODEINFO
  add constraint P_MODEINFO_PK primary key (MODENO);
