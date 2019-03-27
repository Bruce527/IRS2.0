/**
 * PolicyDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class PolicyDTO  implements java.io.Serializable {
    private java.util.Calendar acceptDate;

    private java.util.Calendar applicationDate;

    private java.lang.String applicationFormNo;

    private java.lang.String autoPaidUp;

    private java.lang.String businessAddress;

    private java.lang.String channelType;

    private java.lang.String coInsurance;

    private java.lang.String contractNo;

    private java.lang.String contractSource;

    private java.lang.String contractStatus;

    private java.lang.String contractType;

    private java.math.BigDecimal currentPremium;

    private java.math.BigDecimal effectiveInsuredNum;

    private java.math.BigDecimal effectiveSumInsured;

    private java.lang.String formerpolicyNo;

    private java.lang.String leadCoInsurance;

    private java.lang.String organId;

    private java.lang.String organName;

    private java.lang.String password;

    private java.lang.String paymentMethod;

    private java.math.BigDecimal paymentNo;

    private java.math.BigDecimal paymentYears;

    private java.util.Calendar policyEndDate;

    private com.ebao.health.insurance.dto.PolicyGroupphDTO[] policyGroupphDTOs;

    private java.math.BigDecimal policyHolderNum;

    private java.lang.String policyHolderPro;

    private com.ebao.health.insurance.dto.PolicyInsuredDTO[] policyInsuredDTOs;

    private java.lang.String policyLoan;

    private java.lang.String policyNo;

    private com.ebao.health.insurance.dto.PolicyPersonphDTO[] policyPersonphDTOs;

    private java.util.Calendar policyStartDate;

    private com.ebao.health.insurance.dto.PolicyUpcoverageDTO[] policyUpcoverageDTOs;

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

    private java.lang.String splitPolicyNo;

    private java.math.BigDecimal sumInsured;

    private java.util.Calendar suspendDate;

    private java.util.Calendar terminationDate;

    private java.lang.String terminationReason;

    private java.lang.String userName;

    private java.math.BigDecimal yearPremium;

    public PolicyDTO() {
    }

    public PolicyDTO(
           java.util.Calendar acceptDate,
           java.util.Calendar applicationDate,
           java.lang.String applicationFormNo,
           java.lang.String autoPaidUp,
           java.lang.String businessAddress,
           java.lang.String channelType,
           java.lang.String coInsurance,
           java.lang.String contractNo,
           java.lang.String contractSource,
           java.lang.String contractStatus,
           java.lang.String contractType,
           java.math.BigDecimal currentPremium,
           java.math.BigDecimal effectiveInsuredNum,
           java.math.BigDecimal effectiveSumInsured,
           java.lang.String formerpolicyNo,
           java.lang.String leadCoInsurance,
           java.lang.String organId,
           java.lang.String organName,
           java.lang.String password,
           java.lang.String paymentMethod,
           java.math.BigDecimal paymentNo,
           java.math.BigDecimal paymentYears,
           java.util.Calendar policyEndDate,
           com.ebao.health.insurance.dto.PolicyGroupphDTO[] policyGroupphDTOs,
           java.math.BigDecimal policyHolderNum,
           java.lang.String policyHolderPro,
           com.ebao.health.insurance.dto.PolicyInsuredDTO[] policyInsuredDTOs,
           java.lang.String policyLoan,
           java.lang.String policyNo,
           com.ebao.health.insurance.dto.PolicyPersonphDTO[] policyPersonphDTOs,
           java.util.Calendar policyStartDate,
           com.ebao.health.insurance.dto.PolicyUpcoverageDTO[] policyUpcoverageDTOs,
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
           java.lang.String splitPolicyNo,
           java.math.BigDecimal sumInsured,
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
           this.channelType = channelType;
           this.coInsurance = coInsurance;
           this.contractNo = contractNo;
           this.contractSource = contractSource;
           this.contractStatus = contractStatus;
           this.contractType = contractType;
           this.currentPremium = currentPremium;
           this.effectiveInsuredNum = effectiveInsuredNum;
           this.effectiveSumInsured = effectiveSumInsured;
           this.formerpolicyNo = formerpolicyNo;
           this.leadCoInsurance = leadCoInsurance;
           this.organId = organId;
           this.organName = organName;
           this.password = password;
           this.paymentMethod = paymentMethod;
           this.paymentNo = paymentNo;
           this.paymentYears = paymentYears;
           this.policyEndDate = policyEndDate;
           this.policyGroupphDTOs = policyGroupphDTOs;
           this.policyHolderNum = policyHolderNum;
           this.policyHolderPro = policyHolderPro;
           this.policyInsuredDTOs = policyInsuredDTOs;
           this.policyLoan = policyLoan;
           this.policyNo = policyNo;
           this.policyPersonphDTOs = policyPersonphDTOs;
           this.policyStartDate = policyStartDate;
           this.policyUpcoverageDTOs = policyUpcoverageDTOs;
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
           this.splitPolicyNo = splitPolicyNo;
           this.sumInsured = sumInsured;
           this.suspendDate = suspendDate;
           this.terminationDate = terminationDate;
           this.terminationReason = terminationReason;
           this.userName = userName;
           this.yearPremium = yearPremium;
    }


    /**
     * Gets the acceptDate value for this PolicyDTO.
     * 
     * @return acceptDate
     */
    public java.util.Calendar getAcceptDate() {
        return acceptDate;
    }


    /**
     * Sets the acceptDate value for this PolicyDTO.
     * 
     * @param acceptDate
     */
    public void setAcceptDate(java.util.Calendar acceptDate) {
        this.acceptDate = acceptDate;
    }


    /**
     * Gets the applicationDate value for this PolicyDTO.
     * 
     * @return applicationDate
     */
    public java.util.Calendar getApplicationDate() {
        return applicationDate;
    }


    /**
     * Sets the applicationDate value for this PolicyDTO.
     * 
     * @param applicationDate
     */
    public void setApplicationDate(java.util.Calendar applicationDate) {
        this.applicationDate = applicationDate;
    }


    /**
     * Gets the applicationFormNo value for this PolicyDTO.
     * 
     * @return applicationFormNo
     */
    public java.lang.String getApplicationFormNo() {
        return applicationFormNo;
    }


    /**
     * Sets the applicationFormNo value for this PolicyDTO.
     * 
     * @param applicationFormNo
     */
    public void setApplicationFormNo(java.lang.String applicationFormNo) {
        this.applicationFormNo = applicationFormNo;
    }


    /**
     * Gets the autoPaidUp value for this PolicyDTO.
     * 
     * @return autoPaidUp
     */
    public java.lang.String getAutoPaidUp() {
        return autoPaidUp;
    }


    /**
     * Sets the autoPaidUp value for this PolicyDTO.
     * 
     * @param autoPaidUp
     */
    public void setAutoPaidUp(java.lang.String autoPaidUp) {
        this.autoPaidUp = autoPaidUp;
    }


    /**
     * Gets the businessAddress value for this PolicyDTO.
     * 
     * @return businessAddress
     */
    public java.lang.String getBusinessAddress() {
        return businessAddress;
    }


    /**
     * Sets the businessAddress value for this PolicyDTO.
     * 
     * @param businessAddress
     */
    public void setBusinessAddress(java.lang.String businessAddress) {
        this.businessAddress = businessAddress;
    }


    /**
     * Gets the channelType value for this PolicyDTO.
     * 
     * @return channelType
     */
    public java.lang.String getChannelType() {
        return channelType;
    }


    /**
     * Sets the channelType value for this PolicyDTO.
     * 
     * @param channelType
     */
    public void setChannelType(java.lang.String channelType) {
        this.channelType = channelType;
    }


    /**
     * Gets the coInsurance value for this PolicyDTO.
     * 
     * @return coInsurance
     */
    public java.lang.String getCoInsurance() {
        return coInsurance;
    }


    /**
     * Sets the coInsurance value for this PolicyDTO.
     * 
     * @param coInsurance
     */
    public void setCoInsurance(java.lang.String coInsurance) {
        this.coInsurance = coInsurance;
    }


    /**
     * Gets the contractNo value for this PolicyDTO.
     * 
     * @return contractNo
     */
    public java.lang.String getContractNo() {
        return contractNo;
    }


    /**
     * Sets the contractNo value for this PolicyDTO.
     * 
     * @param contractNo
     */
    public void setContractNo(java.lang.String contractNo) {
        this.contractNo = contractNo;
    }


    /**
     * Gets the contractSource value for this PolicyDTO.
     * 
     * @return contractSource
     */
    public java.lang.String getContractSource() {
        return contractSource;
    }


    /**
     * Sets the contractSource value for this PolicyDTO.
     * 
     * @param contractSource
     */
    public void setContractSource(java.lang.String contractSource) {
        this.contractSource = contractSource;
    }


    /**
     * Gets the contractStatus value for this PolicyDTO.
     * 
     * @return contractStatus
     */
    public java.lang.String getContractStatus() {
        return contractStatus;
    }


    /**
     * Sets the contractStatus value for this PolicyDTO.
     * 
     * @param contractStatus
     */
    public void setContractStatus(java.lang.String contractStatus) {
        this.contractStatus = contractStatus;
    }


    /**
     * Gets the contractType value for this PolicyDTO.
     * 
     * @return contractType
     */
    public java.lang.String getContractType() {
        return contractType;
    }


    /**
     * Sets the contractType value for this PolicyDTO.
     * 
     * @param contractType
     */
    public void setContractType(java.lang.String contractType) {
        this.contractType = contractType;
    }


    /**
     * Gets the currentPremium value for this PolicyDTO.
     * 
     * @return currentPremium
     */
    public java.math.BigDecimal getCurrentPremium() {
        return currentPremium;
    }


    /**
     * Sets the currentPremium value for this PolicyDTO.
     * 
     * @param currentPremium
     */
    public void setCurrentPremium(java.math.BigDecimal currentPremium) {
        this.currentPremium = currentPremium;
    }


    /**
     * Gets the effectiveInsuredNum value for this PolicyDTO.
     * 
     * @return effectiveInsuredNum
     */
    public java.math.BigDecimal getEffectiveInsuredNum() {
        return effectiveInsuredNum;
    }


    /**
     * Sets the effectiveInsuredNum value for this PolicyDTO.
     * 
     * @param effectiveInsuredNum
     */
    public void setEffectiveInsuredNum(java.math.BigDecimal effectiveInsuredNum) {
        this.effectiveInsuredNum = effectiveInsuredNum;
    }


    /**
     * Gets the effectiveSumInsured value for this PolicyDTO.
     * 
     * @return effectiveSumInsured
     */
    public java.math.BigDecimal getEffectiveSumInsured() {
        return effectiveSumInsured;
    }


    /**
     * Sets the effectiveSumInsured value for this PolicyDTO.
     * 
     * @param effectiveSumInsured
     */
    public void setEffectiveSumInsured(java.math.BigDecimal effectiveSumInsured) {
        this.effectiveSumInsured = effectiveSumInsured;
    }


    /**
     * Gets the formerpolicyNo value for this PolicyDTO.
     * 
     * @return formerpolicyNo
     */
    public java.lang.String getFormerpolicyNo() {
        return formerpolicyNo;
    }


    /**
     * Sets the formerpolicyNo value for this PolicyDTO.
     * 
     * @param formerpolicyNo
     */
    public void setFormerpolicyNo(java.lang.String formerpolicyNo) {
        this.formerpolicyNo = formerpolicyNo;
    }


    /**
     * Gets the leadCoInsurance value for this PolicyDTO.
     * 
     * @return leadCoInsurance
     */
    public java.lang.String getLeadCoInsurance() {
        return leadCoInsurance;
    }


    /**
     * Sets the leadCoInsurance value for this PolicyDTO.
     * 
     * @param leadCoInsurance
     */
    public void setLeadCoInsurance(java.lang.String leadCoInsurance) {
        this.leadCoInsurance = leadCoInsurance;
    }


    /**
     * Gets the organId value for this PolicyDTO.
     * 
     * @return organId
     */
    public java.lang.String getOrganId() {
        return organId;
    }


    /**
     * Sets the organId value for this PolicyDTO.
     * 
     * @param organId
     */
    public void setOrganId(java.lang.String organId) {
        this.organId = organId;
    }


    /**
     * Gets the organName value for this PolicyDTO.
     * 
     * @return organName
     */
    public java.lang.String getOrganName() {
        return organName;
    }


    /**
     * Sets the organName value for this PolicyDTO.
     * 
     * @param organName
     */
    public void setOrganName(java.lang.String organName) {
        this.organName = organName;
    }


    /**
     * Gets the password value for this PolicyDTO.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this PolicyDTO.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the paymentMethod value for this PolicyDTO.
     * 
     * @return paymentMethod
     */
    public java.lang.String getPaymentMethod() {
        return paymentMethod;
    }


    /**
     * Sets the paymentMethod value for this PolicyDTO.
     * 
     * @param paymentMethod
     */
    public void setPaymentMethod(java.lang.String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    /**
     * Gets the paymentNo value for this PolicyDTO.
     * 
     * @return paymentNo
     */
    public java.math.BigDecimal getPaymentNo() {
        return paymentNo;
    }


    /**
     * Sets the paymentNo value for this PolicyDTO.
     * 
     * @param paymentNo
     */
    public void setPaymentNo(java.math.BigDecimal paymentNo) {
        this.paymentNo = paymentNo;
    }


    /**
     * Gets the paymentYears value for this PolicyDTO.
     * 
     * @return paymentYears
     */
    public java.math.BigDecimal getPaymentYears() {
        return paymentYears;
    }


    /**
     * Sets the paymentYears value for this PolicyDTO.
     * 
     * @param paymentYears
     */
    public void setPaymentYears(java.math.BigDecimal paymentYears) {
        this.paymentYears = paymentYears;
    }


    /**
     * Gets the policyEndDate value for this PolicyDTO.
     * 
     * @return policyEndDate
     */
    public java.util.Calendar getPolicyEndDate() {
        return policyEndDate;
    }


    /**
     * Sets the policyEndDate value for this PolicyDTO.
     * 
     * @param policyEndDate
     */
    public void setPolicyEndDate(java.util.Calendar policyEndDate) {
        this.policyEndDate = policyEndDate;
    }


    /**
     * Gets the policyGroupphDTOs value for this PolicyDTO.
     * 
     * @return policyGroupphDTOs
     */
    public com.ebao.health.insurance.dto.PolicyGroupphDTO[] getPolicyGroupphDTOs() {
        return policyGroupphDTOs;
    }


    /**
     * Sets the policyGroupphDTOs value for this PolicyDTO.
     * 
     * @param policyGroupphDTOs
     */
    public void setPolicyGroupphDTOs(com.ebao.health.insurance.dto.PolicyGroupphDTO[] policyGroupphDTOs) {
        this.policyGroupphDTOs = policyGroupphDTOs;
    }


    /**
     * Gets the policyHolderNum value for this PolicyDTO.
     * 
     * @return policyHolderNum
     */
    public java.math.BigDecimal getPolicyHolderNum() {
        return policyHolderNum;
    }


    /**
     * Sets the policyHolderNum value for this PolicyDTO.
     * 
     * @param policyHolderNum
     */
    public void setPolicyHolderNum(java.math.BigDecimal policyHolderNum) {
        this.policyHolderNum = policyHolderNum;
    }


    /**
     * Gets the policyHolderPro value for this PolicyDTO.
     * 
     * @return policyHolderPro
     */
    public java.lang.String getPolicyHolderPro() {
        return policyHolderPro;
    }


    /**
     * Sets the policyHolderPro value for this PolicyDTO.
     * 
     * @param policyHolderPro
     */
    public void setPolicyHolderPro(java.lang.String policyHolderPro) {
        this.policyHolderPro = policyHolderPro;
    }


    /**
     * Gets the policyInsuredDTOs value for this PolicyDTO.
     * 
     * @return policyInsuredDTOs
     */
    public com.ebao.health.insurance.dto.PolicyInsuredDTO[] getPolicyInsuredDTOs() {
        return policyInsuredDTOs;
    }


    /**
     * Sets the policyInsuredDTOs value for this PolicyDTO.
     * 
     * @param policyInsuredDTOs
     */
    public void setPolicyInsuredDTOs(com.ebao.health.insurance.dto.PolicyInsuredDTO[] policyInsuredDTOs) {
        this.policyInsuredDTOs = policyInsuredDTOs;
    }


    /**
     * Gets the policyLoan value for this PolicyDTO.
     * 
     * @return policyLoan
     */
    public java.lang.String getPolicyLoan() {
        return policyLoan;
    }


    /**
     * Sets the policyLoan value for this PolicyDTO.
     * 
     * @param policyLoan
     */
    public void setPolicyLoan(java.lang.String policyLoan) {
        this.policyLoan = policyLoan;
    }


    /**
     * Gets the policyNo value for this PolicyDTO.
     * 
     * @return policyNo
     */
    public java.lang.String getPolicyNo() {
        return policyNo;
    }


    /**
     * Sets the policyNo value for this PolicyDTO.
     * 
     * @param policyNo
     */
    public void setPolicyNo(java.lang.String policyNo) {
        this.policyNo = policyNo;
    }


    /**
     * Gets the policyPersonphDTOs value for this PolicyDTO.
     * 
     * @return policyPersonphDTOs
     */
    public com.ebao.health.insurance.dto.PolicyPersonphDTO[] getPolicyPersonphDTOs() {
        return policyPersonphDTOs;
    }


    /**
     * Sets the policyPersonphDTOs value for this PolicyDTO.
     * 
     * @param policyPersonphDTOs
     */
    public void setPolicyPersonphDTOs(com.ebao.health.insurance.dto.PolicyPersonphDTO[] policyPersonphDTOs) {
        this.policyPersonphDTOs = policyPersonphDTOs;
    }


    /**
     * Gets the policyStartDate value for this PolicyDTO.
     * 
     * @return policyStartDate
     */
    public java.util.Calendar getPolicyStartDate() {
        return policyStartDate;
    }


    /**
     * Sets the policyStartDate value for this PolicyDTO.
     * 
     * @param policyStartDate
     */
    public void setPolicyStartDate(java.util.Calendar policyStartDate) {
        this.policyStartDate = policyStartDate;
    }


    /**
     * Gets the policyUpcoverageDTOs value for this PolicyDTO.
     * 
     * @return policyUpcoverageDTOs
     */
    public com.ebao.health.insurance.dto.PolicyUpcoverageDTO[] getPolicyUpcoverageDTOs() {
        return policyUpcoverageDTOs;
    }


    /**
     * Sets the policyUpcoverageDTOs value for this PolicyDTO.
     * 
     * @param policyUpcoverageDTOs
     */
    public void setPolicyUpcoverageDTOs(com.ebao.health.insurance.dto.PolicyUpcoverageDTO[] policyUpcoverageDTOs) {
        this.policyUpcoverageDTOs = policyUpcoverageDTOs;
    }


    /**
     * Gets the premium value for this PolicyDTO.
     * 
     * @return premium
     */
    public java.math.BigDecimal getPremium() {
        return premium;
    }


    /**
     * Sets the premium value for this PolicyDTO.
     * 
     * @param premium
     */
    public void setPremium(java.math.BigDecimal premium) {
        this.premium = premium;
    }


    /**
     * Gets the premiumDueDate value for this PolicyDTO.
     * 
     * @return premiumDueDate
     */
    public java.util.Calendar getPremiumDueDate() {
        return premiumDueDate;
    }


    /**
     * Sets the premiumDueDate value for this PolicyDTO.
     * 
     * @param premiumDueDate
     */
    public void setPremiumDueDate(java.util.Calendar premiumDueDate) {
        this.premiumDueDate = premiumDueDate;
    }


    /**
     * Gets the realTimeClaimFlag value for this PolicyDTO.
     * 
     * @return realTimeClaimFlag
     */
    public java.lang.String getRealTimeClaimFlag() {
        return realTimeClaimFlag;
    }


    /**
     * Sets the realTimeClaimFlag value for this PolicyDTO.
     * 
     * @param realTimeClaimFlag
     */
    public void setRealTimeClaimFlag(java.lang.String realTimeClaimFlag) {
        this.realTimeClaimFlag = realTimeClaimFlag;
    }


    /**
     * Gets the recoverDate value for this PolicyDTO.
     * 
     * @return recoverDate
     */
    public java.util.Calendar getRecoverDate() {
        return recoverDate;
    }


    /**
     * Sets the recoverDate value for this PolicyDTO.
     * 
     * @param recoverDate
     */
    public void setRecoverDate(java.util.Calendar recoverDate) {
        this.recoverDate = recoverDate;
    }


    /**
     * Gets the regularClearing value for this PolicyDTO.
     * 
     * @return regularClearing
     */
    public java.lang.String getRegularClearing() {
        return regularClearing;
    }


    /**
     * Sets the regularClearing value for this PolicyDTO.
     * 
     * @param regularClearing
     */
    public void setRegularClearing(java.lang.String regularClearing) {
        this.regularClearing = regularClearing;
    }


    /**
     * Gets the regularClearingDate value for this PolicyDTO.
     * 
     * @return regularClearingDate
     */
    public java.util.Calendar getRegularClearingDate() {
        return regularClearingDate;
    }


    /**
     * Sets the regularClearingDate value for this PolicyDTO.
     * 
     * @param regularClearingDate
     */
    public void setRegularClearingDate(java.util.Calendar regularClearingDate) {
        this.regularClearingDate = regularClearingDate;
    }


    /**
     * Gets the regularClearingMark value for this PolicyDTO.
     * 
     * @return regularClearingMark
     */
    public java.lang.String getRegularClearingMark() {
        return regularClearingMark;
    }


    /**
     * Sets the regularClearingMark value for this PolicyDTO.
     * 
     * @param regularClearingMark
     */
    public void setRegularClearingMark(java.lang.String regularClearingMark) {
        this.regularClearingMark = regularClearingMark;
    }


    /**
     * Gets the rejection value for this PolicyDTO.
     * 
     * @return rejection
     */
    public java.lang.String getRejection() {
        return rejection;
    }


    /**
     * Sets the rejection value for this PolicyDTO.
     * 
     * @param rejection
     */
    public void setRejection(java.lang.String rejection) {
        this.rejection = rejection;
    }


    /**
     * Gets the renewalMethod value for this PolicyDTO.
     * 
     * @return renewalMethod
     */
    public java.lang.String getRenewalMethod() {
        return renewalMethod;
    }


    /**
     * Sets the renewalMethod value for this PolicyDTO.
     * 
     * @param renewalMethod
     */
    public void setRenewalMethod(java.lang.String renewalMethod) {
        this.renewalMethod = renewalMethod;
    }


    /**
     * Gets the renewalTimes value for this PolicyDTO.
     * 
     * @return renewalTimes
     */
    public java.math.BigDecimal getRenewalTimes() {
        return renewalTimes;
    }


    /**
     * Sets the renewalTimes value for this PolicyDTO.
     * 
     * @param renewalTimes
     */
    public void setRenewalTimes(java.math.BigDecimal renewalTimes) {
        this.renewalTimes = renewalTimes;
    }


    /**
     * Gets the salesChannelCode value for this PolicyDTO.
     * 
     * @return salesChannelCode
     */
    public java.lang.String getSalesChannelCode() {
        return salesChannelCode;
    }


    /**
     * Sets the salesChannelCode value for this PolicyDTO.
     * 
     * @param salesChannelCode
     */
    public void setSalesChannelCode(java.lang.String salesChannelCode) {
        this.salesChannelCode = salesChannelCode;
    }


    /**
     * Gets the salesChannelName value for this PolicyDTO.
     * 
     * @return salesChannelName
     */
    public java.lang.String getSalesChannelName() {
        return salesChannelName;
    }


    /**
     * Sets the salesChannelName value for this PolicyDTO.
     * 
     * @param salesChannelName
     */
    public void setSalesChannelName(java.lang.String salesChannelName) {
        this.salesChannelName = salesChannelName;
    }


    /**
     * Gets the salesCode value for this PolicyDTO.
     * 
     * @return salesCode
     */
    public java.lang.String getSalesCode() {
        return salesCode;
    }


    /**
     * Sets the salesCode value for this PolicyDTO.
     * 
     * @param salesCode
     */
    public void setSalesCode(java.lang.String salesCode) {
        this.salesCode = salesCode;
    }


    /**
     * Gets the salesName value for this PolicyDTO.
     * 
     * @return salesName
     */
    public java.lang.String getSalesName() {
        return salesName;
    }


    /**
     * Sets the salesName value for this PolicyDTO.
     * 
     * @param salesName
     */
    public void setSalesName(java.lang.String salesName) {
        this.salesName = salesName;
    }


    /**
     * Gets the salesType value for this PolicyDTO.
     * 
     * @return salesType
     */
    public java.lang.String getSalesType() {
        return salesType;
    }


    /**
     * Sets the salesType value for this PolicyDTO.
     * 
     * @param salesType
     */
    public void setSalesType(java.lang.String salesType) {
        this.salesType = salesType;
    }


    /**
     * Gets the specialRemark value for this PolicyDTO.
     * 
     * @return specialRemark
     */
    public java.lang.String getSpecialRemark() {
        return specialRemark;
    }


    /**
     * Sets the specialRemark value for this PolicyDTO.
     * 
     * @param specialRemark
     */
    public void setSpecialRemark(java.lang.String specialRemark) {
        this.specialRemark = specialRemark;
    }


    /**
     * Gets the splitPolicyNo value for this PolicyDTO.
     * 
     * @return splitPolicyNo
     */
    public java.lang.String getSplitPolicyNo() {
        return splitPolicyNo;
    }


    /**
     * Sets the splitPolicyNo value for this PolicyDTO.
     * 
     * @param splitPolicyNo
     */
    public void setSplitPolicyNo(java.lang.String splitPolicyNo) {
        this.splitPolicyNo = splitPolicyNo;
    }


    /**
     * Gets the sumInsured value for this PolicyDTO.
     * 
     * @return sumInsured
     */
    public java.math.BigDecimal getSumInsured() {
        return sumInsured;
    }


    /**
     * Sets the sumInsured value for this PolicyDTO.
     * 
     * @param sumInsured
     */
    public void setSumInsured(java.math.BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }


    /**
     * Gets the suspendDate value for this PolicyDTO.
     * 
     * @return suspendDate
     */
    public java.util.Calendar getSuspendDate() {
        return suspendDate;
    }


    /**
     * Sets the suspendDate value for this PolicyDTO.
     * 
     * @param suspendDate
     */
    public void setSuspendDate(java.util.Calendar suspendDate) {
        this.suspendDate = suspendDate;
    }


    /**
     * Gets the terminationDate value for this PolicyDTO.
     * 
     * @return terminationDate
     */
    public java.util.Calendar getTerminationDate() {
        return terminationDate;
    }


    /**
     * Sets the terminationDate value for this PolicyDTO.
     * 
     * @param terminationDate
     */
    public void setTerminationDate(java.util.Calendar terminationDate) {
        this.terminationDate = terminationDate;
    }


    /**
     * Gets the terminationReason value for this PolicyDTO.
     * 
     * @return terminationReason
     */
    public java.lang.String getTerminationReason() {
        return terminationReason;
    }


    /**
     * Sets the terminationReason value for this PolicyDTO.
     * 
     * @param terminationReason
     */
    public void setTerminationReason(java.lang.String terminationReason) {
        this.terminationReason = terminationReason;
    }


    /**
     * Gets the userName value for this PolicyDTO.
     * 
     * @return userName
     */
    public java.lang.String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this PolicyDTO.
     * 
     * @param userName
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }


    /**
     * Gets the yearPremium value for this PolicyDTO.
     * 
     * @return yearPremium
     */
    public java.math.BigDecimal getYearPremium() {
        return yearPremium;
    }


    /**
     * Sets the yearPremium value for this PolicyDTO.
     * 
     * @param yearPremium
     */
    public void setYearPremium(java.math.BigDecimal yearPremium) {
        this.yearPremium = yearPremium;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PolicyDTO)) return false;
        PolicyDTO other = (PolicyDTO) obj;
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
            ((this.effectiveInsuredNum==null && other.getEffectiveInsuredNum()==null) || 
             (this.effectiveInsuredNum!=null &&
              this.effectiveInsuredNum.equals(other.getEffectiveInsuredNum()))) &&
            ((this.effectiveSumInsured==null && other.getEffectiveSumInsured()==null) || 
             (this.effectiveSumInsured!=null &&
              this.effectiveSumInsured.equals(other.getEffectiveSumInsured()))) &&
            ((this.formerpolicyNo==null && other.getFormerpolicyNo()==null) || 
             (this.formerpolicyNo!=null &&
              this.formerpolicyNo.equals(other.getFormerpolicyNo()))) &&
            ((this.leadCoInsurance==null && other.getLeadCoInsurance()==null) || 
             (this.leadCoInsurance!=null &&
              this.leadCoInsurance.equals(other.getLeadCoInsurance()))) &&
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
            ((this.policyGroupphDTOs==null && other.getPolicyGroupphDTOs()==null) || 
             (this.policyGroupphDTOs!=null &&
              java.util.Arrays.equals(this.policyGroupphDTOs, other.getPolicyGroupphDTOs()))) &&
            ((this.policyHolderNum==null && other.getPolicyHolderNum()==null) || 
             (this.policyHolderNum!=null &&
              this.policyHolderNum.equals(other.getPolicyHolderNum()))) &&
            ((this.policyHolderPro==null && other.getPolicyHolderPro()==null) || 
             (this.policyHolderPro!=null &&
              this.policyHolderPro.equals(other.getPolicyHolderPro()))) &&
            ((this.policyInsuredDTOs==null && other.getPolicyInsuredDTOs()==null) || 
             (this.policyInsuredDTOs!=null &&
              java.util.Arrays.equals(this.policyInsuredDTOs, other.getPolicyInsuredDTOs()))) &&
            ((this.policyLoan==null && other.getPolicyLoan()==null) || 
             (this.policyLoan!=null &&
              this.policyLoan.equals(other.getPolicyLoan()))) &&
            ((this.policyNo==null && other.getPolicyNo()==null) || 
             (this.policyNo!=null &&
              this.policyNo.equals(other.getPolicyNo()))) &&
            ((this.policyPersonphDTOs==null && other.getPolicyPersonphDTOs()==null) || 
             (this.policyPersonphDTOs!=null &&
              java.util.Arrays.equals(this.policyPersonphDTOs, other.getPolicyPersonphDTOs()))) &&
            ((this.policyStartDate==null && other.getPolicyStartDate()==null) || 
             (this.policyStartDate!=null &&
              this.policyStartDate.equals(other.getPolicyStartDate()))) &&
            ((this.policyUpcoverageDTOs==null && other.getPolicyUpcoverageDTOs()==null) || 
             (this.policyUpcoverageDTOs!=null &&
              java.util.Arrays.equals(this.policyUpcoverageDTOs, other.getPolicyUpcoverageDTOs()))) &&
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
            ((this.splitPolicyNo==null && other.getSplitPolicyNo()==null) || 
             (this.splitPolicyNo!=null &&
              this.splitPolicyNo.equals(other.getSplitPolicyNo()))) &&
            ((this.sumInsured==null && other.getSumInsured()==null) || 
             (this.sumInsured!=null &&
              this.sumInsured.equals(other.getSumInsured()))) &&
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
        if (getEffectiveInsuredNum() != null) {
            _hashCode += getEffectiveInsuredNum().hashCode();
        }
        if (getEffectiveSumInsured() != null) {
            _hashCode += getEffectiveSumInsured().hashCode();
        }
        if (getFormerpolicyNo() != null) {
            _hashCode += getFormerpolicyNo().hashCode();
        }
        if (getLeadCoInsurance() != null) {
            _hashCode += getLeadCoInsurance().hashCode();
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
        if (getPolicyGroupphDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPolicyGroupphDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPolicyGroupphDTOs(), i);
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
        if (getPolicyInsuredDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPolicyInsuredDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPolicyInsuredDTOs(), i);
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
        if (getPolicyPersonphDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPolicyPersonphDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPolicyPersonphDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPolicyStartDate() != null) {
            _hashCode += getPolicyStartDate().hashCode();
        }
        if (getPolicyUpcoverageDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPolicyUpcoverageDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPolicyUpcoverageDTOs(), i);
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
        if (getSplitPolicyNo() != null) {
            _hashCode += getSplitPolicyNo().hashCode();
        }
        if (getSumInsured() != null) {
            _hashCode += getSumInsured().hashCode();
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
        new org.apache.axis.description.TypeDesc(PolicyDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyDTO"));
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
        elemField.setFieldName("policyGroupphDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyGroupphDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyGroupphDTO"));
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
        elemField.setFieldName("policyInsuredDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyInsuredDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyInsuredDTO"));
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
        elemField.setFieldName("policyPersonphDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyPersonphDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyPersonphDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyStartDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyStartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyUpcoverageDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyUpcoverageDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyUpcoverageDTO"));
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
        elemField.setFieldName("splitPolicyNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "splitPolicyNo"));
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
