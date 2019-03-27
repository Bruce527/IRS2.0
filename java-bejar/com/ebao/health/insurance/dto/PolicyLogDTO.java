/**
 * PolicyLogDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class PolicyLogDTO  implements java.io.Serializable {
    private java.util.Calendar acceptDate;

    private java.util.Calendar applicationDate;

    private java.lang.String applicationFormNo;

    private java.lang.String autoPaidUp;

    private java.lang.String businessAddress;

    private java.util.Calendar cancelDate;

    private java.lang.String channelType;

    private java.lang.String coInsurance;

    private java.lang.String contractNo;

    private java.lang.String contractSource;

    private java.lang.String contractStatus;

    private java.lang.String contractType;

    private java.math.BigDecimal currentPremium;

    private java.util.Calendar effectiveDate;

    private java.math.BigDecimal effectiveInsuredNum;

    private java.math.BigDecimal effectiveSumInsured;

    private java.util.Calendar endorsementApplicationDate;

    private java.lang.String endorsementNo;

    private java.lang.String endorsementType;

    private com.ebao.health.insurance.dto.EndorsementTypeDTO[] endorsementTypeDTOs;

    private java.lang.String formerpolicyNo;

    private java.lang.String leadCoInsurance;

    private java.lang.String mainAttachedFlag;

    private java.lang.String organId;

    private java.lang.String organName;

    private java.lang.String password;

    private java.lang.String paymentMethod;

    private java.math.BigDecimal paymentNo;

    private java.math.BigDecimal paymentYears;

    private java.util.Calendar policyEndDate;

    private com.ebao.health.insurance.dto.PolicyGroupPHLogDTO[] policyGroupPHLogDTOs;

    private java.math.BigDecimal policyHolderNum;

    private java.lang.String policyHolderPro;

    private com.ebao.health.insurance.dto.PolicyInsuredLogDTO[] policyInsuredLogDTOs;

    private java.lang.String policyLoan;

    private java.lang.String policyNo;

    private com.ebao.health.insurance.dto.PolicyPersonPHLogDTO[] policyPersonPHLogDTOs;

    private java.util.Calendar policyStartDate;

    private com.ebao.health.insurance.dto.PolicyUpcoverageLogDTO[] policyUpcoverageLogDTOs;

    private java.math.BigDecimal premium;

    private java.util.Calendar premiumDueDate;

    private java.lang.String realTimeClaimFlag;

    private java.util.Calendar recoverDate;

    private java.lang.String regularClearing;

    private java.util.Calendar regularClearingDate;

    private java.lang.String regularClearingMark;

    private java.lang.String rejection;

    private java.lang.String renewalMethod;

    private java.math.BigDecimal renewalTimes;

    private java.lang.String salesChannelCode;

    private java.lang.String salesChannelName;

    private java.lang.String salesCode;

    private java.lang.String salesName;

    private java.lang.String salesType;

    private java.lang.String specialRemark;

    private java.math.BigDecimal sumInsured;

    private java.math.BigDecimal surrenderCharge;

    private java.util.Calendar suspendDate;

    private java.util.Calendar terminationDate;

    private java.lang.String terminationReason;

    private java.lang.String userName;

    private java.math.BigDecimal yearPremium;

    public PolicyLogDTO() {
    }

    public PolicyLogDTO(
           java.util.Calendar acceptDate,
           java.util.Calendar applicationDate,
           java.lang.String applicationFormNo,
           java.lang.String autoPaidUp,
           java.lang.String businessAddress,
           java.util.Calendar cancelDate,
           java.lang.String channelType,
           java.lang.String coInsurance,
           java.lang.String contractNo,
           java.lang.String contractSource,
           java.lang.String contractStatus,
           java.lang.String contractType,
           java.math.BigDecimal currentPremium,
           java.util.Calendar effectiveDate,
           java.math.BigDecimal effectiveInsuredNum,
           java.math.BigDecimal effectiveSumInsured,
           java.util.Calendar endorsementApplicationDate,
           java.lang.String endorsementNo,
           java.lang.String endorsementType,
           com.ebao.health.insurance.dto.EndorsementTypeDTO[] endorsementTypeDTOs,
           java.lang.String formerpolicyNo,
           java.lang.String leadCoInsurance,
           java.lang.String mainAttachedFlag,
           java.lang.String organId,
           java.lang.String organName,
           java.lang.String password,
           java.lang.String paymentMethod,
           java.math.BigDecimal paymentNo,
           java.math.BigDecimal paymentYears,
           java.util.Calendar policyEndDate,
           com.ebao.health.insurance.dto.PolicyGroupPHLogDTO[] policyGroupPHLogDTOs,
           java.math.BigDecimal policyHolderNum,
           java.lang.String policyHolderPro,
           com.ebao.health.insurance.dto.PolicyInsuredLogDTO[] policyInsuredLogDTOs,
           java.lang.String policyLoan,
           java.lang.String policyNo,
           com.ebao.health.insurance.dto.PolicyPersonPHLogDTO[] policyPersonPHLogDTOs,
           java.util.Calendar policyStartDate,
           com.ebao.health.insurance.dto.PolicyUpcoverageLogDTO[] policyUpcoverageLogDTOs,
           java.math.BigDecimal premium,
           java.util.Calendar premiumDueDate,
           java.lang.String realTimeClaimFlag,
           java.util.Calendar recoverDate,
           java.lang.String regularClearing,
           java.util.Calendar regularClearingDate,
           java.lang.String regularClearingMark,
           java.lang.String rejection,
           java.lang.String renewalMethod,
           java.math.BigDecimal renewalTimes,
           java.lang.String salesChannelCode,
           java.lang.String salesChannelName,
           java.lang.String salesCode,
           java.lang.String salesName,
           java.lang.String salesType,
           java.lang.String specialRemark,
           java.math.BigDecimal sumInsured,
           java.math.BigDecimal surrenderCharge,
           java.util.Calendar suspendDate,
           java.util.Calendar terminationDate,
           java.lang.String terminationReason,
           java.lang.String userName,
           java.math.BigDecimal yearPremium) {
           this.acceptDate = acceptDate;
           this.applicationDate = applicationDate;
           this.applicationFormNo = applicationFormNo;
           this.autoPaidUp = autoPaidUp;
           this.businessAddress = businessAddress;
           this.cancelDate = cancelDate;
           this.channelType = channelType;
           this.coInsurance = coInsurance;
           this.contractNo = contractNo;
           this.contractSource = contractSource;
           this.contractStatus = contractStatus;
           this.contractType = contractType;
           this.currentPremium = currentPremium;
           this.effectiveDate = effectiveDate;
           this.effectiveInsuredNum = effectiveInsuredNum;
           this.effectiveSumInsured = effectiveSumInsured;
           this.endorsementApplicationDate = endorsementApplicationDate;
           this.endorsementNo = endorsementNo;
           this.endorsementType = endorsementType;
           this.endorsementTypeDTOs = endorsementTypeDTOs;
           this.formerpolicyNo = formerpolicyNo;
           this.leadCoInsurance = leadCoInsurance;
           this.mainAttachedFlag = mainAttachedFlag;
           this.organId = organId;
           this.organName = organName;
           this.password = password;
           this.paymentMethod = paymentMethod;
           this.paymentNo = paymentNo;
           this.paymentYears = paymentYears;
           this.policyEndDate = policyEndDate;
           this.policyGroupPHLogDTOs = policyGroupPHLogDTOs;
           this.policyHolderNum = policyHolderNum;
           this.policyHolderPro = policyHolderPro;
           this.policyInsuredLogDTOs = policyInsuredLogDTOs;
           this.policyLoan = policyLoan;
           this.policyNo = policyNo;
           this.policyPersonPHLogDTOs = policyPersonPHLogDTOs;
           this.policyStartDate = policyStartDate;
           this.policyUpcoverageLogDTOs = policyUpcoverageLogDTOs;
           this.premium = premium;
           this.premiumDueDate = premiumDueDate;
           this.realTimeClaimFlag = realTimeClaimFlag;
           this.recoverDate = recoverDate;
           this.regularClearing = regularClearing;
           this.regularClearingDate = regularClearingDate;
           this.regularClearingMark = regularClearingMark;
           this.rejection = rejection;
           this.renewalMethod = renewalMethod;
           this.renewalTimes = renewalTimes;
           this.salesChannelCode = salesChannelCode;
           this.salesChannelName = salesChannelName;
           this.salesCode = salesCode;
           this.salesName = salesName;
           this.salesType = salesType;
           this.specialRemark = specialRemark;
           this.sumInsured = sumInsured;
           this.surrenderCharge = surrenderCharge;
           this.suspendDate = suspendDate;
           this.terminationDate = terminationDate;
           this.terminationReason = terminationReason;
           this.userName = userName;
           this.yearPremium = yearPremium;
    }


    /**
     * Gets the acceptDate value for this PolicyLogDTO.
     * 
     * @return acceptDate
     */
    public java.util.Calendar getAcceptDate() {
        return acceptDate;
    }


    /**
     * Sets the acceptDate value for this PolicyLogDTO.
     * 
     * @param acceptDate
     */
    public void setAcceptDate(java.util.Calendar acceptDate) {
        this.acceptDate = acceptDate;
    }


    /**
     * Gets the applicationDate value for this PolicyLogDTO.
     * 
     * @return applicationDate
     */
    public java.util.Calendar getApplicationDate() {
        return applicationDate;
    }


    /**
     * Sets the applicationDate value for this PolicyLogDTO.
     * 
     * @param applicationDate
     */
    public void setApplicationDate(java.util.Calendar applicationDate) {
        this.applicationDate = applicationDate;
    }


    /**
     * Gets the applicationFormNo value for this PolicyLogDTO.
     * 
     * @return applicationFormNo
     */
    public java.lang.String getApplicationFormNo() {
        return applicationFormNo;
    }


    /**
     * Sets the applicationFormNo value for this PolicyLogDTO.
     * 
     * @param applicationFormNo
     */
    public void setApplicationFormNo(java.lang.String applicationFormNo) {
        this.applicationFormNo = applicationFormNo;
    }


    /**
     * Gets the autoPaidUp value for this PolicyLogDTO.
     * 
     * @return autoPaidUp
     */
    public java.lang.String getAutoPaidUp() {
        return autoPaidUp;
    }


    /**
     * Sets the autoPaidUp value for this PolicyLogDTO.
     * 
     * @param autoPaidUp
     */
    public void setAutoPaidUp(java.lang.String autoPaidUp) {
        this.autoPaidUp = autoPaidUp;
    }


    /**
     * Gets the businessAddress value for this PolicyLogDTO.
     * 
     * @return businessAddress
     */
    public java.lang.String getBusinessAddress() {
        return businessAddress;
    }


    /**
     * Sets the businessAddress value for this PolicyLogDTO.
     * 
     * @param businessAddress
     */
    public void setBusinessAddress(java.lang.String businessAddress) {
        this.businessAddress = businessAddress;
    }


    /**
     * Gets the cancelDate value for this PolicyLogDTO.
     * 
     * @return cancelDate
     */
    public java.util.Calendar getCancelDate() {
        return cancelDate;
    }


    /**
     * Sets the cancelDate value for this PolicyLogDTO.
     * 
     * @param cancelDate
     */
    public void setCancelDate(java.util.Calendar cancelDate) {
        this.cancelDate = cancelDate;
    }


    /**
     * Gets the channelType value for this PolicyLogDTO.
     * 
     * @return channelType
     */
    public java.lang.String getChannelType() {
        return channelType;
    }


    /**
     * Sets the channelType value for this PolicyLogDTO.
     * 
     * @param channelType
     */
    public void setChannelType(java.lang.String channelType) {
        this.channelType = channelType;
    }


    /**
     * Gets the coInsurance value for this PolicyLogDTO.
     * 
     * @return coInsurance
     */
    public java.lang.String getCoInsurance() {
        return coInsurance;
    }


    /**
     * Sets the coInsurance value for this PolicyLogDTO.
     * 
     * @param coInsurance
     */
    public void setCoInsurance(java.lang.String coInsurance) {
        this.coInsurance = coInsurance;
    }


    /**
     * Gets the contractNo value for this PolicyLogDTO.
     * 
     * @return contractNo
     */
    public java.lang.String getContractNo() {
        return contractNo;
    }


    /**
     * Sets the contractNo value for this PolicyLogDTO.
     * 
     * @param contractNo
     */
    public void setContractNo(java.lang.String contractNo) {
        this.contractNo = contractNo;
    }


    /**
     * Gets the contractSource value for this PolicyLogDTO.
     * 
     * @return contractSource
     */
    public java.lang.String getContractSource() {
        return contractSource;
    }


    /**
     * Sets the contractSource value for this PolicyLogDTO.
     * 
     * @param contractSource
     */
    public void setContractSource(java.lang.String contractSource) {
        this.contractSource = contractSource;
    }


    /**
     * Gets the contractStatus value for this PolicyLogDTO.
     * 
     * @return contractStatus
     */
    public java.lang.String getContractStatus() {
        return contractStatus;
    }


    /**
     * Sets the contractStatus value for this PolicyLogDTO.
     * 
     * @param contractStatus
     */
    public void setContractStatus(java.lang.String contractStatus) {
        this.contractStatus = contractStatus;
    }


    /**
     * Gets the contractType value for this PolicyLogDTO.
     * 
     * @return contractType
     */
    public java.lang.String getContractType() {
        return contractType;
    }


    /**
     * Sets the contractType value for this PolicyLogDTO.
     * 
     * @param contractType
     */
    public void setContractType(java.lang.String contractType) {
        this.contractType = contractType;
    }


    /**
     * Gets the currentPremium value for this PolicyLogDTO.
     * 
     * @return currentPremium
     */
    public java.math.BigDecimal getCurrentPremium() {
        return currentPremium;
    }


    /**
     * Sets the currentPremium value for this PolicyLogDTO.
     * 
     * @param currentPremium
     */
    public void setCurrentPremium(java.math.BigDecimal currentPremium) {
        this.currentPremium = currentPremium;
    }


    /**
     * Gets the effectiveDate value for this PolicyLogDTO.
     * 
     * @return effectiveDate
     */
    public java.util.Calendar getEffectiveDate() {
        return effectiveDate;
    }


    /**
     * Sets the effectiveDate value for this PolicyLogDTO.
     * 
     * @param effectiveDate
     */
    public void setEffectiveDate(java.util.Calendar effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    /**
     * Gets the effectiveInsuredNum value for this PolicyLogDTO.
     * 
     * @return effectiveInsuredNum
     */
    public java.math.BigDecimal getEffectiveInsuredNum() {
        return effectiveInsuredNum;
    }


    /**
     * Sets the effectiveInsuredNum value for this PolicyLogDTO.
     * 
     * @param effectiveInsuredNum
     */
    public void setEffectiveInsuredNum(java.math.BigDecimal effectiveInsuredNum) {
        this.effectiveInsuredNum = effectiveInsuredNum;
    }


    /**
     * Gets the effectiveSumInsured value for this PolicyLogDTO.
     * 
     * @return effectiveSumInsured
     */
    public java.math.BigDecimal getEffectiveSumInsured() {
        return effectiveSumInsured;
    }


    /**
     * Sets the effectiveSumInsured value for this PolicyLogDTO.
     * 
     * @param effectiveSumInsured
     */
    public void setEffectiveSumInsured(java.math.BigDecimal effectiveSumInsured) {
        this.effectiveSumInsured = effectiveSumInsured;
    }


    /**
     * Gets the endorsementApplicationDate value for this PolicyLogDTO.
     * 
     * @return endorsementApplicationDate
     */
    public java.util.Calendar getEndorsementApplicationDate() {
        return endorsementApplicationDate;
    }


    /**
     * Sets the endorsementApplicationDate value for this PolicyLogDTO.
     * 
     * @param endorsementApplicationDate
     */
    public void setEndorsementApplicationDate(java.util.Calendar endorsementApplicationDate) {
        this.endorsementApplicationDate = endorsementApplicationDate;
    }


    /**
     * Gets the endorsementNo value for this PolicyLogDTO.
     * 
     * @return endorsementNo
     */
    public java.lang.String getEndorsementNo() {
        return endorsementNo;
    }


    /**
     * Sets the endorsementNo value for this PolicyLogDTO.
     * 
     * @param endorsementNo
     */
    public void setEndorsementNo(java.lang.String endorsementNo) {
        this.endorsementNo = endorsementNo;
    }


    /**
     * Gets the endorsementType value for this PolicyLogDTO.
     * 
     * @return endorsementType
     */
    public java.lang.String getEndorsementType() {
        return endorsementType;
    }


    /**
     * Sets the endorsementType value for this PolicyLogDTO.
     * 
     * @param endorsementType
     */
    public void setEndorsementType(java.lang.String endorsementType) {
        this.endorsementType = endorsementType;
    }


    /**
     * Gets the endorsementTypeDTOs value for this PolicyLogDTO.
     * 
     * @return endorsementTypeDTOs
     */
    public com.ebao.health.insurance.dto.EndorsementTypeDTO[] getEndorsementTypeDTOs() {
        return endorsementTypeDTOs;
    }


    /**
     * Sets the endorsementTypeDTOs value for this PolicyLogDTO.
     * 
     * @param endorsementTypeDTOs
     */
    public void setEndorsementTypeDTOs(com.ebao.health.insurance.dto.EndorsementTypeDTO[] endorsementTypeDTOs) {
        this.endorsementTypeDTOs = endorsementTypeDTOs;
    }


    /**
     * Gets the formerpolicyNo value for this PolicyLogDTO.
     * 
     * @return formerpolicyNo
     */
    public java.lang.String getFormerpolicyNo() {
        return formerpolicyNo;
    }


    /**
     * Sets the formerpolicyNo value for this PolicyLogDTO.
     * 
     * @param formerpolicyNo
     */
    public void setFormerpolicyNo(java.lang.String formerpolicyNo) {
        this.formerpolicyNo = formerpolicyNo;
    }


    /**
     * Gets the leadCoInsurance value for this PolicyLogDTO.
     * 
     * @return leadCoInsurance
     */
    public java.lang.String getLeadCoInsurance() {
        return leadCoInsurance;
    }


    /**
     * Sets the leadCoInsurance value for this PolicyLogDTO.
     * 
     * @param leadCoInsurance
     */
    public void setLeadCoInsurance(java.lang.String leadCoInsurance) {
        this.leadCoInsurance = leadCoInsurance;
    }


    /**
     * Gets the mainAttachedFlag value for this PolicyLogDTO.
     * 
     * @return mainAttachedFlag
     */
    public java.lang.String getMainAttachedFlag() {
        return mainAttachedFlag;
    }


    /**
     * Sets the mainAttachedFlag value for this PolicyLogDTO.
     * 
     * @param mainAttachedFlag
     */
    public void setMainAttachedFlag(java.lang.String mainAttachedFlag) {
        this.mainAttachedFlag = mainAttachedFlag;
    }


    /**
     * Gets the organId value for this PolicyLogDTO.
     * 
     * @return organId
     */
    public java.lang.String getOrganId() {
        return organId;
    }


    /**
     * Sets the organId value for this PolicyLogDTO.
     * 
     * @param organId
     */
    public void setOrganId(java.lang.String organId) {
        this.organId = organId;
    }


    /**
     * Gets the organName value for this PolicyLogDTO.
     * 
     * @return organName
     */
    public java.lang.String getOrganName() {
        return organName;
    }


    /**
     * Sets the organName value for this PolicyLogDTO.
     * 
     * @param organName
     */
    public void setOrganName(java.lang.String organName) {
        this.organName = organName;
    }


    /**
     * Gets the password value for this PolicyLogDTO.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this PolicyLogDTO.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the paymentMethod value for this PolicyLogDTO.
     * 
     * @return paymentMethod
     */
    public java.lang.String getPaymentMethod() {
        return paymentMethod;
    }


    /**
     * Sets the paymentMethod value for this PolicyLogDTO.
     * 
     * @param paymentMethod
     */
    public void setPaymentMethod(java.lang.String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    /**
     * Gets the paymentNo value for this PolicyLogDTO.
     * 
     * @return paymentNo
     */
    public java.math.BigDecimal getPaymentNo() {
        return paymentNo;
    }


    /**
     * Sets the paymentNo value for this PolicyLogDTO.
     * 
     * @param paymentNo
     */
    public void setPaymentNo(java.math.BigDecimal paymentNo) {
        this.paymentNo = paymentNo;
    }


    /**
     * Gets the paymentYears value for this PolicyLogDTO.
     * 
     * @return paymentYears
     */
    public java.math.BigDecimal getPaymentYears() {
        return paymentYears;
    }


    /**
     * Sets the paymentYears value for this PolicyLogDTO.
     * 
     * @param paymentYears
     */
    public void setPaymentYears(java.math.BigDecimal paymentYears) {
        this.paymentYears = paymentYears;
    }


    /**
     * Gets the policyEndDate value for this PolicyLogDTO.
     * 
     * @return policyEndDate
     */
    public java.util.Calendar getPolicyEndDate() {
        return policyEndDate;
    }


    /**
     * Sets the policyEndDate value for this PolicyLogDTO.
     * 
     * @param policyEndDate
     */
    public void setPolicyEndDate(java.util.Calendar policyEndDate) {
        this.policyEndDate = policyEndDate;
    }


    /**
     * Gets the policyGroupPHLogDTOs value for this PolicyLogDTO.
     * 
     * @return policyGroupPHLogDTOs
     */
    public com.ebao.health.insurance.dto.PolicyGroupPHLogDTO[] getPolicyGroupPHLogDTOs() {
        return policyGroupPHLogDTOs;
    }


    /**
     * Sets the policyGroupPHLogDTOs value for this PolicyLogDTO.
     * 
     * @param policyGroupPHLogDTOs
     */
    public void setPolicyGroupPHLogDTOs(com.ebao.health.insurance.dto.PolicyGroupPHLogDTO[] policyGroupPHLogDTOs) {
        this.policyGroupPHLogDTOs = policyGroupPHLogDTOs;
    }


    /**
     * Gets the policyHolderNum value for this PolicyLogDTO.
     * 
     * @return policyHolderNum
     */
    public java.math.BigDecimal getPolicyHolderNum() {
        return policyHolderNum;
    }


    /**
     * Sets the policyHolderNum value for this PolicyLogDTO.
     * 
     * @param policyHolderNum
     */
    public void setPolicyHolderNum(java.math.BigDecimal policyHolderNum) {
        this.policyHolderNum = policyHolderNum;
    }


    /**
     * Gets the policyHolderPro value for this PolicyLogDTO.
     * 
     * @return policyHolderPro
     */
    public java.lang.String getPolicyHolderPro() {
        return policyHolderPro;
    }


    /**
     * Sets the policyHolderPro value for this PolicyLogDTO.
     * 
     * @param policyHolderPro
     */
    public void setPolicyHolderPro(java.lang.String policyHolderPro) {
        this.policyHolderPro = policyHolderPro;
    }


    /**
     * Gets the policyInsuredLogDTOs value for this PolicyLogDTO.
     * 
     * @return policyInsuredLogDTOs
     */
    public com.ebao.health.insurance.dto.PolicyInsuredLogDTO[] getPolicyInsuredLogDTOs() {
        return policyInsuredLogDTOs;
    }


    /**
     * Sets the policyInsuredLogDTOs value for this PolicyLogDTO.
     * 
     * @param policyInsuredLogDTOs
     */
    public void setPolicyInsuredLogDTOs(com.ebao.health.insurance.dto.PolicyInsuredLogDTO[] policyInsuredLogDTOs) {
        this.policyInsuredLogDTOs = policyInsuredLogDTOs;
    }


    /**
     * Gets the policyLoan value for this PolicyLogDTO.
     * 
     * @return policyLoan
     */
    public java.lang.String getPolicyLoan() {
        return policyLoan;
    }


    /**
     * Sets the policyLoan value for this PolicyLogDTO.
     * 
     * @param policyLoan
     */
    public void setPolicyLoan(java.lang.String policyLoan) {
        this.policyLoan = policyLoan;
    }


    /**
     * Gets the policyNo value for this PolicyLogDTO.
     * 
     * @return policyNo
     */
    public java.lang.String getPolicyNo() {
        return policyNo;
    }


    /**
     * Sets the policyNo value for this PolicyLogDTO.
     * 
     * @param policyNo
     */
    public void setPolicyNo(java.lang.String policyNo) {
        this.policyNo = policyNo;
    }


    /**
     * Gets the policyPersonPHLogDTOs value for this PolicyLogDTO.
     * 
     * @return policyPersonPHLogDTOs
     */
    public com.ebao.health.insurance.dto.PolicyPersonPHLogDTO[] getPolicyPersonPHLogDTOs() {
        return policyPersonPHLogDTOs;
    }


    /**
     * Sets the policyPersonPHLogDTOs value for this PolicyLogDTO.
     * 
     * @param policyPersonPHLogDTOs
     */
    public void setPolicyPersonPHLogDTOs(com.ebao.health.insurance.dto.PolicyPersonPHLogDTO[] policyPersonPHLogDTOs) {
        this.policyPersonPHLogDTOs = policyPersonPHLogDTOs;
    }


    /**
     * Gets the policyStartDate value for this PolicyLogDTO.
     * 
     * @return policyStartDate
     */
    public java.util.Calendar getPolicyStartDate() {
        return policyStartDate;
    }


    /**
     * Sets the policyStartDate value for this PolicyLogDTO.
     * 
     * @param policyStartDate
     */
    public void setPolicyStartDate(java.util.Calendar policyStartDate) {
        this.policyStartDate = policyStartDate;
    }


    /**
     * Gets the policyUpcoverageLogDTOs value for this PolicyLogDTO.
     * 
     * @return policyUpcoverageLogDTOs
     */
    public com.ebao.health.insurance.dto.PolicyUpcoverageLogDTO[] getPolicyUpcoverageLogDTOs() {
        return policyUpcoverageLogDTOs;
    }


    /**
     * Sets the policyUpcoverageLogDTOs value for this PolicyLogDTO.
     * 
     * @param policyUpcoverageLogDTOs
     */
    public void setPolicyUpcoverageLogDTOs(com.ebao.health.insurance.dto.PolicyUpcoverageLogDTO[] policyUpcoverageLogDTOs) {
        this.policyUpcoverageLogDTOs = policyUpcoverageLogDTOs;
    }


    /**
     * Gets the premium value for this PolicyLogDTO.
     * 
     * @return premium
     */
    public java.math.BigDecimal getPremium() {
        return premium;
    }


    /**
     * Sets the premium value for this PolicyLogDTO.
     * 
     * @param premium
     */
    public void setPremium(java.math.BigDecimal premium) {
        this.premium = premium;
    }


    /**
     * Gets the premiumDueDate value for this PolicyLogDTO.
     * 
     * @return premiumDueDate
     */
    public java.util.Calendar getPremiumDueDate() {
        return premiumDueDate;
    }


    /**
     * Sets the premiumDueDate value for this PolicyLogDTO.
     * 
     * @param premiumDueDate
     */
    public void setPremiumDueDate(java.util.Calendar premiumDueDate) {
        this.premiumDueDate = premiumDueDate;
    }


    /**
     * Gets the realTimeClaimFlag value for this PolicyLogDTO.
     * 
     * @return realTimeClaimFlag
     */
    public java.lang.String getRealTimeClaimFlag() {
        return realTimeClaimFlag;
    }


    /**
     * Sets the realTimeClaimFlag value for this PolicyLogDTO.
     * 
     * @param realTimeClaimFlag
     */
    public void setRealTimeClaimFlag(java.lang.String realTimeClaimFlag) {
        this.realTimeClaimFlag = realTimeClaimFlag;
    }


    /**
     * Gets the recoverDate value for this PolicyLogDTO.
     * 
     * @return recoverDate
     */
    public java.util.Calendar getRecoverDate() {
        return recoverDate;
    }


    /**
     * Sets the recoverDate value for this PolicyLogDTO.
     * 
     * @param recoverDate
     */
    public void setRecoverDate(java.util.Calendar recoverDate) {
        this.recoverDate = recoverDate;
    }


    /**
     * Gets the regularClearing value for this PolicyLogDTO.
     * 
     * @return regularClearing
     */
    public java.lang.String getRegularClearing() {
        return regularClearing;
    }


    /**
     * Sets the regularClearing value for this PolicyLogDTO.
     * 
     * @param regularClearing
     */
    public void setRegularClearing(java.lang.String regularClearing) {
        this.regularClearing = regularClearing;
    }


    /**
     * Gets the regularClearingDate value for this PolicyLogDTO.
     * 
     * @return regularClearingDate
     */
    public java.util.Calendar getRegularClearingDate() {
        return regularClearingDate;
    }


    /**
     * Sets the regularClearingDate value for this PolicyLogDTO.
     * 
     * @param regularClearingDate
     */
    public void setRegularClearingDate(java.util.Calendar regularClearingDate) {
        this.regularClearingDate = regularClearingDate;
    }


    /**
     * Gets the regularClearingMark value for this PolicyLogDTO.
     * 
     * @return regularClearingMark
     */
    public java.lang.String getRegularClearingMark() {
        return regularClearingMark;
    }


    /**
     * Sets the regularClearingMark value for this PolicyLogDTO.
     * 
     * @param regularClearingMark
     */
    public void setRegularClearingMark(java.lang.String regularClearingMark) {
        this.regularClearingMark = regularClearingMark;
    }


    /**
     * Gets the rejection value for this PolicyLogDTO.
     * 
     * @return rejection
     */
    public java.lang.String getRejection() {
        return rejection;
    }


    /**
     * Sets the rejection value for this PolicyLogDTO.
     * 
     * @param rejection
     */
    public void setRejection(java.lang.String rejection) {
        this.rejection = rejection;
    }


    /**
     * Gets the renewalMethod value for this PolicyLogDTO.
     * 
     * @return renewalMethod
     */
    public java.lang.String getRenewalMethod() {
        return renewalMethod;
    }


    /**
     * Sets the renewalMethod value for this PolicyLogDTO.
     * 
     * @param renewalMethod
     */
    public void setRenewalMethod(java.lang.String renewalMethod) {
        this.renewalMethod = renewalMethod;
    }


    /**
     * Gets the renewalTimes value for this PolicyLogDTO.
     * 
     * @return renewalTimes
     */
    public java.math.BigDecimal getRenewalTimes() {
        return renewalTimes;
    }


    /**
     * Sets the renewalTimes value for this PolicyLogDTO.
     * 
     * @param renewalTimes
     */
    public void setRenewalTimes(java.math.BigDecimal renewalTimes) {
        this.renewalTimes = renewalTimes;
    }


    /**
     * Gets the salesChannelCode value for this PolicyLogDTO.
     * 
     * @return salesChannelCode
     */
    public java.lang.String getSalesChannelCode() {
        return salesChannelCode;
    }


    /**
     * Sets the salesChannelCode value for this PolicyLogDTO.
     * 
     * @param salesChannelCode
     */
    public void setSalesChannelCode(java.lang.String salesChannelCode) {
        this.salesChannelCode = salesChannelCode;
    }


    /**
     * Gets the salesChannelName value for this PolicyLogDTO.
     * 
     * @return salesChannelName
     */
    public java.lang.String getSalesChannelName() {
        return salesChannelName;
    }


    /**
     * Sets the salesChannelName value for this PolicyLogDTO.
     * 
     * @param salesChannelName
     */
    public void setSalesChannelName(java.lang.String salesChannelName) {
        this.salesChannelName = salesChannelName;
    }


    /**
     * Gets the salesCode value for this PolicyLogDTO.
     * 
     * @return salesCode
     */
    public java.lang.String getSalesCode() {
        return salesCode;
    }


    /**
     * Sets the salesCode value for this PolicyLogDTO.
     * 
     * @param salesCode
     */
    public void setSalesCode(java.lang.String salesCode) {
        this.salesCode = salesCode;
    }


    /**
     * Gets the salesName value for this PolicyLogDTO.
     * 
     * @return salesName
     */
    public java.lang.String getSalesName() {
        return salesName;
    }


    /**
     * Sets the salesName value for this PolicyLogDTO.
     * 
     * @param salesName
     */
    public void setSalesName(java.lang.String salesName) {
        this.salesName = salesName;
    }


    /**
     * Gets the salesType value for this PolicyLogDTO.
     * 
     * @return salesType
     */
    public java.lang.String getSalesType() {
        return salesType;
    }


    /**
     * Sets the salesType value for this PolicyLogDTO.
     * 
     * @param salesType
     */
    public void setSalesType(java.lang.String salesType) {
        this.salesType = salesType;
    }


    /**
     * Gets the specialRemark value for this PolicyLogDTO.
     * 
     * @return specialRemark
     */
    public java.lang.String getSpecialRemark() {
        return specialRemark;
    }


    /**
     * Sets the specialRemark value for this PolicyLogDTO.
     * 
     * @param specialRemark
     */
    public void setSpecialRemark(java.lang.String specialRemark) {
        this.specialRemark = specialRemark;
    }


    /**
     * Gets the sumInsured value for this PolicyLogDTO.
     * 
     * @return sumInsured
     */
    public java.math.BigDecimal getSumInsured() {
        return sumInsured;
    }


    /**
     * Sets the sumInsured value for this PolicyLogDTO.
     * 
     * @param sumInsured
     */
    public void setSumInsured(java.math.BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }


    /**
     * Gets the surrenderCharge value for this PolicyLogDTO.
     * 
     * @return surrenderCharge
     */
    public java.math.BigDecimal getSurrenderCharge() {
        return surrenderCharge;
    }


    /**
     * Sets the surrenderCharge value for this PolicyLogDTO.
     * 
     * @param surrenderCharge
     */
    public void setSurrenderCharge(java.math.BigDecimal surrenderCharge) {
        this.surrenderCharge = surrenderCharge;
    }


    /**
     * Gets the suspendDate value for this PolicyLogDTO.
     * 
     * @return suspendDate
     */
    public java.util.Calendar getSuspendDate() {
        return suspendDate;
    }


    /**
     * Sets the suspendDate value for this PolicyLogDTO.
     * 
     * @param suspendDate
     */
    public void setSuspendDate(java.util.Calendar suspendDate) {
        this.suspendDate = suspendDate;
    }


    /**
     * Gets the terminationDate value for this PolicyLogDTO.
     * 
     * @return terminationDate
     */
    public java.util.Calendar getTerminationDate() {
        return terminationDate;
    }


    /**
     * Sets the terminationDate value for this PolicyLogDTO.
     * 
     * @param terminationDate
     */
    public void setTerminationDate(java.util.Calendar terminationDate) {
        this.terminationDate = terminationDate;
    }


    /**
     * Gets the terminationReason value for this PolicyLogDTO.
     * 
     * @return terminationReason
     */
    public java.lang.String getTerminationReason() {
        return terminationReason;
    }


    /**
     * Sets the terminationReason value for this PolicyLogDTO.
     * 
     * @param terminationReason
     */
    public void setTerminationReason(java.lang.String terminationReason) {
        this.terminationReason = terminationReason;
    }


    /**
     * Gets the userName value for this PolicyLogDTO.
     * 
     * @return userName
     */
    public java.lang.String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this PolicyLogDTO.
     * 
     * @param userName
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }


    /**
     * Gets the yearPremium value for this PolicyLogDTO.
     * 
     * @return yearPremium
     */
    public java.math.BigDecimal getYearPremium() {
        return yearPremium;
    }


    /**
     * Sets the yearPremium value for this PolicyLogDTO.
     * 
     * @param yearPremium
     */
    public void setYearPremium(java.math.BigDecimal yearPremium) {
        this.yearPremium = yearPremium;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PolicyLogDTO)) return false;
        PolicyLogDTO other = (PolicyLogDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.acceptDate==null && other.getAcceptDate()==null) || 
             (this.acceptDate!=null &&
              this.acceptDate.equals(other.getAcceptDate()))) &&
            ((this.applicationDate==null && other.getApplicationDate()==null) || 
             (this.applicationDate!=null &&
              this.applicationDate.equals(other.getApplicationDate()))) &&
            ((this.applicationFormNo==null && other.getApplicationFormNo()==null) || 
             (this.applicationFormNo!=null &&
              this.applicationFormNo.equals(other.getApplicationFormNo()))) &&
            ((this.autoPaidUp==null && other.getAutoPaidUp()==null) || 
             (this.autoPaidUp!=null &&
              this.autoPaidUp.equals(other.getAutoPaidUp()))) &&
            ((this.businessAddress==null && other.getBusinessAddress()==null) || 
             (this.businessAddress!=null &&
              this.businessAddress.equals(other.getBusinessAddress()))) &&
            ((this.cancelDate==null && other.getCancelDate()==null) || 
             (this.cancelDate!=null &&
              this.cancelDate.equals(other.getCancelDate()))) &&
            ((this.channelType==null && other.getChannelType()==null) || 
             (this.channelType!=null &&
              this.channelType.equals(other.getChannelType()))) &&
            ((this.coInsurance==null && other.getCoInsurance()==null) || 
             (this.coInsurance!=null &&
              this.coInsurance.equals(other.getCoInsurance()))) &&
            ((this.contractNo==null && other.getContractNo()==null) || 
             (this.contractNo!=null &&
              this.contractNo.equals(other.getContractNo()))) &&
            ((this.contractSource==null && other.getContractSource()==null) || 
             (this.contractSource!=null &&
              this.contractSource.equals(other.getContractSource()))) &&
            ((this.contractStatus==null && other.getContractStatus()==null) || 
             (this.contractStatus!=null &&
              this.contractStatus.equals(other.getContractStatus()))) &&
            ((this.contractType==null && other.getContractType()==null) || 
             (this.contractType!=null &&
              this.contractType.equals(other.getContractType()))) &&
            ((this.currentPremium==null && other.getCurrentPremium()==null) || 
             (this.currentPremium!=null &&
              this.currentPremium.equals(other.getCurrentPremium()))) &&
            ((this.effectiveDate==null && other.getEffectiveDate()==null) || 
             (this.effectiveDate!=null &&
              this.effectiveDate.equals(other.getEffectiveDate()))) &&
            ((this.effectiveInsuredNum==null && other.getEffectiveInsuredNum()==null) || 
             (this.effectiveInsuredNum!=null &&
              this.effectiveInsuredNum.equals(other.getEffectiveInsuredNum()))) &&
            ((this.effectiveSumInsured==null && other.getEffectiveSumInsured()==null) || 
             (this.effectiveSumInsured!=null &&
              this.effectiveSumInsured.equals(other.getEffectiveSumInsured()))) &&
            ((this.endorsementApplicationDate==null && other.getEndorsementApplicationDate()==null) || 
             (this.endorsementApplicationDate!=null &&
              this.endorsementApplicationDate.equals(other.getEndorsementApplicationDate()))) &&
            ((this.endorsementNo==null && other.getEndorsementNo()==null) || 
             (this.endorsementNo!=null &&
              this.endorsementNo.equals(other.getEndorsementNo()))) &&
            ((this.endorsementType==null && other.getEndorsementType()==null) || 
             (this.endorsementType!=null &&
              this.endorsementType.equals(other.getEndorsementType()))) &&
            ((this.endorsementTypeDTOs==null && other.getEndorsementTypeDTOs()==null) || 
             (this.endorsementTypeDTOs!=null &&
              java.util.Arrays.equals(this.endorsementTypeDTOs, other.getEndorsementTypeDTOs()))) &&
            ((this.formerpolicyNo==null && other.getFormerpolicyNo()==null) || 
             (this.formerpolicyNo!=null &&
              this.formerpolicyNo.equals(other.getFormerpolicyNo()))) &&
            ((this.leadCoInsurance==null && other.getLeadCoInsurance()==null) || 
             (this.leadCoInsurance!=null &&
              this.leadCoInsurance.equals(other.getLeadCoInsurance()))) &&
            ((this.mainAttachedFlag==null && other.getMainAttachedFlag()==null) || 
             (this.mainAttachedFlag!=null &&
              this.mainAttachedFlag.equals(other.getMainAttachedFlag()))) &&
            ((this.organId==null && other.getOrganId()==null) || 
             (this.organId!=null &&
              this.organId.equals(other.getOrganId()))) &&
            ((this.organName==null && other.getOrganName()==null) || 
             (this.organName!=null &&
              this.organName.equals(other.getOrganName()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.paymentMethod==null && other.getPaymentMethod()==null) || 
             (this.paymentMethod!=null &&
              this.paymentMethod.equals(other.getPaymentMethod()))) &&
            ((this.paymentNo==null && other.getPaymentNo()==null) || 
             (this.paymentNo!=null &&
              this.paymentNo.equals(other.getPaymentNo()))) &&
            ((this.paymentYears==null && other.getPaymentYears()==null) || 
             (this.paymentYears!=null &&
              this.paymentYears.equals(other.getPaymentYears()))) &&
            ((this.policyEndDate==null && other.getPolicyEndDate()==null) || 
             (this.policyEndDate!=null &&
              this.policyEndDate.equals(other.getPolicyEndDate()))) &&
            ((this.policyGroupPHLogDTOs==null && other.getPolicyGroupPHLogDTOs()==null) || 
             (this.policyGroupPHLogDTOs!=null &&
              java.util.Arrays.equals(this.policyGroupPHLogDTOs, other.getPolicyGroupPHLogDTOs()))) &&
            ((this.policyHolderNum==null && other.getPolicyHolderNum()==null) || 
             (this.policyHolderNum!=null &&
              this.policyHolderNum.equals(other.getPolicyHolderNum()))) &&
            ((this.policyHolderPro==null && other.getPolicyHolderPro()==null) || 
             (this.policyHolderPro!=null &&
              this.policyHolderPro.equals(other.getPolicyHolderPro()))) &&
            ((this.policyInsuredLogDTOs==null && other.getPolicyInsuredLogDTOs()==null) || 
             (this.policyInsuredLogDTOs!=null &&
              java.util.Arrays.equals(this.policyInsuredLogDTOs, other.getPolicyInsuredLogDTOs()))) &&
            ((this.policyLoan==null && other.getPolicyLoan()==null) || 
             (this.policyLoan!=null &&
              this.policyLoan.equals(other.getPolicyLoan()))) &&
            ((this.policyNo==null && other.getPolicyNo()==null) || 
             (this.policyNo!=null &&
              this.policyNo.equals(other.getPolicyNo()))) &&
            ((this.policyPersonPHLogDTOs==null && other.getPolicyPersonPHLogDTOs()==null) || 
             (this.policyPersonPHLogDTOs!=null &&
              java.util.Arrays.equals(this.policyPersonPHLogDTOs, other.getPolicyPersonPHLogDTOs()))) &&
            ((this.policyStartDate==null && other.getPolicyStartDate()==null) || 
             (this.policyStartDate!=null &&
              this.policyStartDate.equals(other.getPolicyStartDate()))) &&
            ((this.policyUpcoverageLogDTOs==null && other.getPolicyUpcoverageLogDTOs()==null) || 
             (this.policyUpcoverageLogDTOs!=null &&
              java.util.Arrays.equals(this.policyUpcoverageLogDTOs, other.getPolicyUpcoverageLogDTOs()))) &&
            ((this.premium==null && other.getPremium()==null) || 
             (this.premium!=null &&
              this.premium.equals(other.getPremium()))) &&
            ((this.premiumDueDate==null && other.getPremiumDueDate()==null) || 
             (this.premiumDueDate!=null &&
              this.premiumDueDate.equals(other.getPremiumDueDate()))) &&
            ((this.realTimeClaimFlag==null && other.getRealTimeClaimFlag()==null) || 
             (this.realTimeClaimFlag!=null &&
              this.realTimeClaimFlag.equals(other.getRealTimeClaimFlag()))) &&
            ((this.recoverDate==null && other.getRecoverDate()==null) || 
             (this.recoverDate!=null &&
              this.recoverDate.equals(other.getRecoverDate()))) &&
            ((this.regularClearing==null && other.getRegularClearing()==null) || 
             (this.regularClearing!=null &&
              this.regularClearing.equals(other.getRegularClearing()))) &&
            ((this.regularClearingDate==null && other.getRegularClearingDate()==null) || 
             (this.regularClearingDate!=null &&
              this.regularClearingDate.equals(other.getRegularClearingDate()))) &&
            ((this.regularClearingMark==null && other.getRegularClearingMark()==null) || 
             (this.regularClearingMark!=null &&
              this.regularClearingMark.equals(other.getRegularClearingMark()))) &&
            ((this.rejection==null && other.getRejection()==null) || 
             (this.rejection!=null &&
              this.rejection.equals(other.getRejection()))) &&
            ((this.renewalMethod==null && other.getRenewalMethod()==null) || 
             (this.renewalMethod!=null &&
              this.renewalMethod.equals(other.getRenewalMethod()))) &&
            ((this.renewalTimes==null && other.getRenewalTimes()==null) || 
             (this.renewalTimes!=null &&
              this.renewalTimes.equals(other.getRenewalTimes()))) &&
            ((this.salesChannelCode==null && other.getSalesChannelCode()==null) || 
             (this.salesChannelCode!=null &&
              this.salesChannelCode.equals(other.getSalesChannelCode()))) &&
            ((this.salesChannelName==null && other.getSalesChannelName()==null) || 
             (this.salesChannelName!=null &&
              this.salesChannelName.equals(other.getSalesChannelName()))) &&
            ((this.salesCode==null && other.getSalesCode()==null) || 
             (this.salesCode!=null &&
              this.salesCode.equals(other.getSalesCode()))) &&
            ((this.salesName==null && other.getSalesName()==null) || 
             (this.salesName!=null &&
              this.salesName.equals(other.getSalesName()))) &&
            ((this.salesType==null && other.getSalesType()==null) || 
             (this.salesType!=null &&
              this.salesType.equals(other.getSalesType()))) &&
            ((this.specialRemark==null && other.getSpecialRemark()==null) || 
             (this.specialRemark!=null &&
              this.specialRemark.equals(other.getSpecialRemark()))) &&
            ((this.sumInsured==null && other.getSumInsured()==null) || 
             (this.sumInsured!=null &&
              this.sumInsured.equals(other.getSumInsured()))) &&
            ((this.surrenderCharge==null && other.getSurrenderCharge()==null) || 
             (this.surrenderCharge!=null &&
              this.surrenderCharge.equals(other.getSurrenderCharge()))) &&
            ((this.suspendDate==null && other.getSuspendDate()==null) || 
             (this.suspendDate!=null &&
              this.suspendDate.equals(other.getSuspendDate()))) &&
            ((this.terminationDate==null && other.getTerminationDate()==null) || 
             (this.terminationDate!=null &&
              this.terminationDate.equals(other.getTerminationDate()))) &&
            ((this.terminationReason==null && other.getTerminationReason()==null) || 
             (this.terminationReason!=null &&
              this.terminationReason.equals(other.getTerminationReason()))) &&
            ((this.userName==null && other.getUserName()==null) || 
             (this.userName!=null &&
              this.userName.equals(other.getUserName()))) &&
            ((this.yearPremium==null && other.getYearPremium()==null) || 
             (this.yearPremium!=null &&
              this.yearPremium.equals(other.getYearPremium())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAcceptDate() != null) {
            _hashCode += getAcceptDate().hashCode();
        }
        if (getApplicationDate() != null) {
            _hashCode += getApplicationDate().hashCode();
        }
        if (getApplicationFormNo() != null) {
            _hashCode += getApplicationFormNo().hashCode();
        }
        if (getAutoPaidUp() != null) {
            _hashCode += getAutoPaidUp().hashCode();
        }
        if (getBusinessAddress() != null) {
            _hashCode += getBusinessAddress().hashCode();
        }
        if (getCancelDate() != null) {
            _hashCode += getCancelDate().hashCode();
        }
        if (getChannelType() != null) {
            _hashCode += getChannelType().hashCode();
        }
        if (getCoInsurance() != null) {
            _hashCode += getCoInsurance().hashCode();
        }
        if (getContractNo() != null) {
            _hashCode += getContractNo().hashCode();
        }
        if (getContractSource() != null) {
            _hashCode += getContractSource().hashCode();
        }
        if (getContractStatus() != null) {
            _hashCode += getContractStatus().hashCode();
        }
        if (getContractType() != null) {
            _hashCode += getContractType().hashCode();
        }
        if (getCurrentPremium() != null) {
            _hashCode += getCurrentPremium().hashCode();
        }
        if (getEffectiveDate() != null) {
            _hashCode += getEffectiveDate().hashCode();
        }
        if (getEffectiveInsuredNum() != null) {
            _hashCode += getEffectiveInsuredNum().hashCode();
        }
        if (getEffectiveSumInsured() != null) {
            _hashCode += getEffectiveSumInsured().hashCode();
        }
        if (getEndorsementApplicationDate() != null) {
            _hashCode += getEndorsementApplicationDate().hashCode();
        }
        if (getEndorsementNo() != null) {
            _hashCode += getEndorsementNo().hashCode();
        }
        if (getEndorsementType() != null) {
            _hashCode += getEndorsementType().hashCode();
        }
        if (getEndorsementTypeDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEndorsementTypeDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEndorsementTypeDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFormerpolicyNo() != null) {
            _hashCode += getFormerpolicyNo().hashCode();
        }
        if (getLeadCoInsurance() != null) {
            _hashCode += getLeadCoInsurance().hashCode();
        }
        if (getMainAttachedFlag() != null) {
            _hashCode += getMainAttachedFlag().hashCode();
        }
        if (getOrganId() != null) {
            _hashCode += getOrganId().hashCode();
        }
        if (getOrganName() != null) {
            _hashCode += getOrganName().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getPaymentMethod() != null) {
            _hashCode += getPaymentMethod().hashCode();
        }
        if (getPaymentNo() != null) {
            _hashCode += getPaymentNo().hashCode();
        }
        if (getPaymentYears() != null) {
            _hashCode += getPaymentYears().hashCode();
        }
        if (getPolicyEndDate() != null) {
            _hashCode += getPolicyEndDate().hashCode();
        }
        if (getPolicyGroupPHLogDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPolicyGroupPHLogDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPolicyGroupPHLogDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPolicyHolderNum() != null) {
            _hashCode += getPolicyHolderNum().hashCode();
        }
        if (getPolicyHolderPro() != null) {
            _hashCode += getPolicyHolderPro().hashCode();
        }
        if (getPolicyInsuredLogDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPolicyInsuredLogDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPolicyInsuredLogDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPolicyLoan() != null) {
            _hashCode += getPolicyLoan().hashCode();
        }
        if (getPolicyNo() != null) {
            _hashCode += getPolicyNo().hashCode();
        }
        if (getPolicyPersonPHLogDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPolicyPersonPHLogDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPolicyPersonPHLogDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPolicyStartDate() != null) {
            _hashCode += getPolicyStartDate().hashCode();
        }
        if (getPolicyUpcoverageLogDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPolicyUpcoverageLogDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPolicyUpcoverageLogDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPremium() != null) {
            _hashCode += getPremium().hashCode();
        }
        if (getPremiumDueDate() != null) {
            _hashCode += getPremiumDueDate().hashCode();
        }
        if (getRealTimeClaimFlag() != null) {
            _hashCode += getRealTimeClaimFlag().hashCode();
        }
        if (getRecoverDate() != null) {
            _hashCode += getRecoverDate().hashCode();
        }
        if (getRegularClearing() != null) {
            _hashCode += getRegularClearing().hashCode();
        }
        if (getRegularClearingDate() != null) {
            _hashCode += getRegularClearingDate().hashCode();
        }
        if (getRegularClearingMark() != null) {
            _hashCode += getRegularClearingMark().hashCode();
        }
        if (getRejection() != null) {
            _hashCode += getRejection().hashCode();
        }
        if (getRenewalMethod() != null) {
            _hashCode += getRenewalMethod().hashCode();
        }
        if (getRenewalTimes() != null) {
            _hashCode += getRenewalTimes().hashCode();
        }
        if (getSalesChannelCode() != null) {
            _hashCode += getSalesChannelCode().hashCode();
        }
        if (getSalesChannelName() != null) {
            _hashCode += getSalesChannelName().hashCode();
        }
        if (getSalesCode() != null) {
            _hashCode += getSalesCode().hashCode();
        }
        if (getSalesName() != null) {
            _hashCode += getSalesName().hashCode();
        }
        if (getSalesType() != null) {
            _hashCode += getSalesType().hashCode();
        }
        if (getSpecialRemark() != null) {
            _hashCode += getSpecialRemark().hashCode();
        }
        if (getSumInsured() != null) {
            _hashCode += getSumInsured().hashCode();
        }
        if (getSurrenderCharge() != null) {
            _hashCode += getSurrenderCharge().hashCode();
        }
        if (getSuspendDate() != null) {
            _hashCode += getSuspendDate().hashCode();
        }
        if (getTerminationDate() != null) {
            _hashCode += getTerminationDate().hashCode();
        }
        if (getTerminationReason() != null) {
            _hashCode += getTerminationReason().hashCode();
        }
        if (getUserName() != null) {
            _hashCode += getUserName().hashCode();
        }
        if (getYearPremium() != null) {
            _hashCode += getYearPremium().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PolicyLogDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acceptDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "acceptDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "applicationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationFormNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "applicationFormNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autoPaidUp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "autoPaidUp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "businessAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancelDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("channelType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "channelType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coInsurance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coInsurance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contractNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contractNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contractSource");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contractSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contractStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contractStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contractType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contractType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currentPremium");
        elemField.setXmlName(new javax.xml.namespace.QName("", "currentPremium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("effectiveDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "effectiveDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("effectiveInsuredNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "effectiveInsuredNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("effectiveSumInsured");
        elemField.setXmlName(new javax.xml.namespace.QName("", "effectiveSumInsured"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endorsementApplicationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementApplicationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endorsementNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endorsementType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endorsementTypeDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementTypeDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "EndorsementTypeDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formerpolicyNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "formerpolicyNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("leadCoInsurance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "leadCoInsurance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mainAttachedFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mainAttachedFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("organId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "organId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("organName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "organName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentYears");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentYears"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyEndDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyEndDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyGroupPHLogDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyGroupPHLogDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyGroupPHLogDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyHolderNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyHolderNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyHolderPro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyHolderPro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyInsuredLogDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyInsuredLogDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyInsuredLogDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyLoan");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyLoan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyPersonPHLogDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyPersonPHLogDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyPersonPHLogDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyStartDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyStartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyUpcoverageLogDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyUpcoverageLogDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyUpcoverageLogDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("premium");
        elemField.setXmlName(new javax.xml.namespace.QName("", "premium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("premiumDueDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "premiumDueDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("realTimeClaimFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "realTimeClaimFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recoverDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recoverDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regularClearing");
        elemField.setXmlName(new javax.xml.namespace.QName("", "regularClearing"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regularClearingDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "regularClearingDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regularClearingMark");
        elemField.setXmlName(new javax.xml.namespace.QName("", "regularClearingMark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rejection");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rejection"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renewalMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "renewalMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renewalTimes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "renewalTimes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesChannelCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "salesChannelCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesChannelName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "salesChannelName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "salesCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "salesName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "salesType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specialRemark");
        elemField.setXmlName(new javax.xml.namespace.QName("", "specialRemark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sumInsured");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sumInsured"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("surrenderCharge");
        elemField.setXmlName(new javax.xml.namespace.QName("", "surrenderCharge"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suspendDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "suspendDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("terminationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "terminationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("terminationReason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "terminationReason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("yearPremium");
        elemField.setXmlName(new javax.xml.namespace.QName("", "yearPremium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
