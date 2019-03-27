/**
 * ClaimInfoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class ClaimInfoDTO  implements java.io.Serializable {
    private java.lang.String accidentReason;

    private com.ebao.health.insurance.dto.AccidentResultDTO[] accidentResultDTOs;

    private java.util.Calendar accidentTime;

    private java.lang.String accidentdes;

    private java.lang.String address1;

    private java.lang.String address2;

    private java.lang.String address3;

    private java.lang.String address4;

    private com.ebao.health.insurance.dto.ApprovalReceiptDTO[] approvalReceiptDTOs;

    private java.lang.String batchNo;

    private com.ebao.health.insurance.dto.BirthClinicReceiptDTO[] birthClinicReceiptDTOs;

    private com.ebao.health.insurance.dto.BirthHospitalReceiptDTO[] birthHospitalReceiptDTOs;

    private java.util.Calendar cancelDate;

    private java.math.BigDecimal claimAmount;

    private java.lang.String claimInvestigation;

    private java.lang.String claimNo;

    private com.ebao.health.insurance.dto.ClinicReceiptDTO[] clinicReceiptDTOs;

    private com.ebao.health.insurance.dto.ClmCallerDTO[] clmCallerDTOs;

    private com.ebao.health.insurance.dto.ClmClaimantDTO[] clmClaimantDTOs;

    private com.ebao.health.insurance.dto.CooperationHospitalReceiptDTO[] cooperationHospitalReceiptDTOs;

    private java.lang.String criticalIllnessNo;

    private java.util.Calendar endcaseDate;

    private com.ebao.health.insurance.dto.HospitalReceiptDTO[] hospitalReceiptDTOs;

    private java.lang.String injuryReasonCode;

    private java.util.Calendar investigationEndDate;

    private java.util.Calendar investigationStartDate;

    private com.ebao.health.insurance.dto.OrdinaryClinicReceiptDTO[] ordinaryClinicReceiptDTOs;

    private com.ebao.health.insurance.dto.OrdinaryHospitalReceiptDTO[] ordinaryHospitalReceiptDTOs;

    private java.lang.String password;

    private com.ebao.health.insurance.dto.PolicyPaymentDTO[] policyPaymentDTOs;

    private java.util.Calendar registrationDate;

    private java.lang.String registrationNo;

    private java.lang.String remoteClaimInvestigation;

    private java.util.Calendar reportDate;

    private java.lang.String reportNo;

    private com.ebao.health.insurance.dto.SpecialReceiptDTO[] specialReceiptDTOs;

    private java.lang.String status;

    private java.lang.String treatmentAdvice;

    private java.lang.String userName;

    private com.ebao.health.insurance.dto.SegmentationReceiptDTO[] segmentationReceiptDTOs;

    public ClaimInfoDTO() {
    }

    public ClaimInfoDTO(
           java.lang.String accidentReason,
           com.ebao.health.insurance.dto.AccidentResultDTO[] accidentResultDTOs,
           java.util.Calendar accidentTime,
           java.lang.String accidentdes,
           java.lang.String address1,
           java.lang.String address2,
           java.lang.String address3,
           java.lang.String address4,
           com.ebao.health.insurance.dto.ApprovalReceiptDTO[] approvalReceiptDTOs,
           java.lang.String batchNo,
           com.ebao.health.insurance.dto.BirthClinicReceiptDTO[] birthClinicReceiptDTOs,
           com.ebao.health.insurance.dto.BirthHospitalReceiptDTO[] birthHospitalReceiptDTOs,
           java.util.Calendar cancelDate,
           java.math.BigDecimal claimAmount,
           java.lang.String claimInvestigation,
           java.lang.String claimNo,
           com.ebao.health.insurance.dto.ClinicReceiptDTO[] clinicReceiptDTOs,
           com.ebao.health.insurance.dto.ClmCallerDTO[] clmCallerDTOs,
           com.ebao.health.insurance.dto.ClmClaimantDTO[] clmClaimantDTOs,
           com.ebao.health.insurance.dto.CooperationHospitalReceiptDTO[] cooperationHospitalReceiptDTOs,
           java.lang.String criticalIllnessNo,
           java.util.Calendar endcaseDate,
           com.ebao.health.insurance.dto.HospitalReceiptDTO[] hospitalReceiptDTOs,
           java.lang.String injuryReasonCode,
           java.util.Calendar investigationEndDate,
           java.util.Calendar investigationStartDate,
           com.ebao.health.insurance.dto.OrdinaryClinicReceiptDTO[] ordinaryClinicReceiptDTOs,
           com.ebao.health.insurance.dto.OrdinaryHospitalReceiptDTO[] ordinaryHospitalReceiptDTOs,
           java.lang.String password,
           com.ebao.health.insurance.dto.PolicyPaymentDTO[] policyPaymentDTOs,
           java.util.Calendar registrationDate,
           java.lang.String registrationNo,
           java.lang.String remoteClaimInvestigation,
           java.util.Calendar reportDate,
           java.lang.String reportNo,
           com.ebao.health.insurance.dto.SpecialReceiptDTO[] specialReceiptDTOs,
           java.lang.String status,
           java.lang.String treatmentAdvice,
           java.lang.String userName,
           com.ebao.health.insurance.dto.SegmentationReceiptDTO[] segmentationReceiptDTOs) {
           this.accidentReason = accidentReason;
           this.accidentResultDTOs = accidentResultDTOs;
           this.accidentTime = accidentTime;
           this.accidentdes = accidentdes;
           this.address1 = address1;
           this.address2 = address2;
           this.address3 = address3;
           this.address4 = address4;
           this.approvalReceiptDTOs = approvalReceiptDTOs;
           this.batchNo = batchNo;
           this.birthClinicReceiptDTOs = birthClinicReceiptDTOs;
           this.birthHospitalReceiptDTOs = birthHospitalReceiptDTOs;
           this.cancelDate = cancelDate;
           this.claimAmount = claimAmount;
           this.claimInvestigation = claimInvestigation;
           this.claimNo = claimNo;
           this.clinicReceiptDTOs = clinicReceiptDTOs;
           this.clmCallerDTOs = clmCallerDTOs;
           this.clmClaimantDTOs = clmClaimantDTOs;
           this.cooperationHospitalReceiptDTOs = cooperationHospitalReceiptDTOs;
           this.criticalIllnessNo = criticalIllnessNo;
           this.endcaseDate = endcaseDate;
           this.hospitalReceiptDTOs = hospitalReceiptDTOs;
           this.injuryReasonCode = injuryReasonCode;
           this.investigationEndDate = investigationEndDate;
           this.investigationStartDate = investigationStartDate;
           this.ordinaryClinicReceiptDTOs = ordinaryClinicReceiptDTOs;
           this.ordinaryHospitalReceiptDTOs = ordinaryHospitalReceiptDTOs;
           this.password = password;
           this.policyPaymentDTOs = policyPaymentDTOs;
           this.registrationDate = registrationDate;
           this.registrationNo = registrationNo;
           this.remoteClaimInvestigation = remoteClaimInvestigation;
           this.reportDate = reportDate;
           this.reportNo = reportNo;
           this.specialReceiptDTOs = specialReceiptDTOs;
           this.status = status;
           this.treatmentAdvice = treatmentAdvice;
           this.userName = userName;
           this.segmentationReceiptDTOs = segmentationReceiptDTOs;
    }


    /**
     * Gets the accidentReason value for this ClaimInfoDTO.
     * 
     * @return accidentReason
     */
    public java.lang.String getAccidentReason() {
        return accidentReason;
    }


    /**
     * Sets the accidentReason value for this ClaimInfoDTO.
     * 
     * @param accidentReason
     */
    public void setAccidentReason(java.lang.String accidentReason) {
        this.accidentReason = accidentReason;
    }


    /**
     * Gets the accidentResultDTOs value for this ClaimInfoDTO.
     * 
     * @return accidentResultDTOs
     */
    public com.ebao.health.insurance.dto.AccidentResultDTO[] getAccidentResultDTOs() {
        return accidentResultDTOs;
    }


    /**
     * Sets the accidentResultDTOs value for this ClaimInfoDTO.
     * 
     * @param accidentResultDTOs
     */
    public void setAccidentResultDTOs(com.ebao.health.insurance.dto.AccidentResultDTO[] accidentResultDTOs) {
        this.accidentResultDTOs = accidentResultDTOs;
    }


    /**
     * Gets the accidentTime value for this ClaimInfoDTO.
     * 
     * @return accidentTime
     */
    public java.util.Calendar getAccidentTime() {
        return accidentTime;
    }


    /**
     * Sets the accidentTime value for this ClaimInfoDTO.
     * 
     * @param accidentTime
     */
    public void setAccidentTime(java.util.Calendar accidentTime) {
        this.accidentTime = accidentTime;
    }


    /**
     * Gets the accidentdes value for this ClaimInfoDTO.
     * 
     * @return accidentdes
     */
    public java.lang.String getAccidentdes() {
        return accidentdes;
    }


    /**
     * Sets the accidentdes value for this ClaimInfoDTO.
     * 
     * @param accidentdes
     */
    public void setAccidentdes(java.lang.String accidentdes) {
        this.accidentdes = accidentdes;
    }


    /**
     * Gets the address1 value for this ClaimInfoDTO.
     * 
     * @return address1
     */
    public java.lang.String getAddress1() {
        return address1;
    }


    /**
     * Sets the address1 value for this ClaimInfoDTO.
     * 
     * @param address1
     */
    public void setAddress1(java.lang.String address1) {
        this.address1 = address1;
    }


    /**
     * Gets the address2 value for this ClaimInfoDTO.
     * 
     * @return address2
     */
    public java.lang.String getAddress2() {
        return address2;
    }


    /**
     * Sets the address2 value for this ClaimInfoDTO.
     * 
     * @param address2
     */
    public void setAddress2(java.lang.String address2) {
        this.address2 = address2;
    }


    /**
     * Gets the address3 value for this ClaimInfoDTO.
     * 
     * @return address3
     */
    public java.lang.String getAddress3() {
        return address3;
    }


    /**
     * Sets the address3 value for this ClaimInfoDTO.
     * 
     * @param address3
     */
    public void setAddress3(java.lang.String address3) {
        this.address3 = address3;
    }


    /**
     * Gets the address4 value for this ClaimInfoDTO.
     * 
     * @return address4
     */
    public java.lang.String getAddress4() {
        return address4;
    }


    /**
     * Sets the address4 value for this ClaimInfoDTO.
     * 
     * @param address4
     */
    public void setAddress4(java.lang.String address4) {
        this.address4 = address4;
    }


    /**
     * Gets the approvalReceiptDTOs value for this ClaimInfoDTO.
     * 
     * @return approvalReceiptDTOs
     */
    public com.ebao.health.insurance.dto.ApprovalReceiptDTO[] getApprovalReceiptDTOs() {
        return approvalReceiptDTOs;
    }


    /**
     * Sets the approvalReceiptDTOs value for this ClaimInfoDTO.
     * 
     * @param approvalReceiptDTOs
     */
    public void setApprovalReceiptDTOs(com.ebao.health.insurance.dto.ApprovalReceiptDTO[] approvalReceiptDTOs) {
        this.approvalReceiptDTOs = approvalReceiptDTOs;
    }


    /**
     * Gets the batchNo value for this ClaimInfoDTO.
     * 
     * @return batchNo
     */
    public java.lang.String getBatchNo() {
        return batchNo;
    }


    /**
     * Sets the batchNo value for this ClaimInfoDTO.
     * 
     * @param batchNo
     */
    public void setBatchNo(java.lang.String batchNo) {
        this.batchNo = batchNo;
    }


    /**
     * Gets the birthClinicReceiptDTOs value for this ClaimInfoDTO.
     * 
     * @return birthClinicReceiptDTOs
     */
    public com.ebao.health.insurance.dto.BirthClinicReceiptDTO[] getBirthClinicReceiptDTOs() {
        return birthClinicReceiptDTOs;
    }


    /**
     * Sets the birthClinicReceiptDTOs value for this ClaimInfoDTO.
     * 
     * @param birthClinicReceiptDTOs
     */
    public void setBirthClinicReceiptDTOs(com.ebao.health.insurance.dto.BirthClinicReceiptDTO[] birthClinicReceiptDTOs) {
        this.birthClinicReceiptDTOs = birthClinicReceiptDTOs;
    }


    /**
     * Gets the birthHospitalReceiptDTOs value for this ClaimInfoDTO.
     * 
     * @return birthHospitalReceiptDTOs
     */
    public com.ebao.health.insurance.dto.BirthHospitalReceiptDTO[] getBirthHospitalReceiptDTOs() {
        return birthHospitalReceiptDTOs;
    }


    /**
     * Sets the birthHospitalReceiptDTOs value for this ClaimInfoDTO.
     * 
     * @param birthHospitalReceiptDTOs
     */
    public void setBirthHospitalReceiptDTOs(com.ebao.health.insurance.dto.BirthHospitalReceiptDTO[] birthHospitalReceiptDTOs) {
        this.birthHospitalReceiptDTOs = birthHospitalReceiptDTOs;
    }


    /**
     * Gets the cancelDate value for this ClaimInfoDTO.
     * 
     * @return cancelDate
     */
    public java.util.Calendar getCancelDate() {
        return cancelDate;
    }


    /**
     * Sets the cancelDate value for this ClaimInfoDTO.
     * 
     * @param cancelDate
     */
    public void setCancelDate(java.util.Calendar cancelDate) {
        this.cancelDate = cancelDate;
    }


    /**
     * Gets the claimAmount value for this ClaimInfoDTO.
     * 
     * @return claimAmount
     */
    public java.math.BigDecimal getClaimAmount() {
        return claimAmount;
    }


    /**
     * Sets the claimAmount value for this ClaimInfoDTO.
     * 
     * @param claimAmount
     */
    public void setClaimAmount(java.math.BigDecimal claimAmount) {
        this.claimAmount = claimAmount;
    }


    /**
     * Gets the claimInvestigation value for this ClaimInfoDTO.
     * 
     * @return claimInvestigation
     */
    public java.lang.String getClaimInvestigation() {
        return claimInvestigation;
    }


    /**
     * Sets the claimInvestigation value for this ClaimInfoDTO.
     * 
     * @param claimInvestigation
     */
    public void setClaimInvestigation(java.lang.String claimInvestigation) {
        this.claimInvestigation = claimInvestigation;
    }


    /**
     * Gets the claimNo value for this ClaimInfoDTO.
     * 
     * @return claimNo
     */
    public java.lang.String getClaimNo() {
        return claimNo;
    }


    /**
     * Sets the claimNo value for this ClaimInfoDTO.
     * 
     * @param claimNo
     */
    public void setClaimNo(java.lang.String claimNo) {
        this.claimNo = claimNo;
    }


    /**
     * Gets the clinicReceiptDTOs value for this ClaimInfoDTO.
     * 
     * @return clinicReceiptDTOs
     */
    public com.ebao.health.insurance.dto.ClinicReceiptDTO[] getClinicReceiptDTOs() {
        return clinicReceiptDTOs;
    }


    /**
     * Sets the clinicReceiptDTOs value for this ClaimInfoDTO.
     * 
     * @param clinicReceiptDTOs
     */
    public void setClinicReceiptDTOs(com.ebao.health.insurance.dto.ClinicReceiptDTO[] clinicReceiptDTOs) {
        this.clinicReceiptDTOs = clinicReceiptDTOs;
    }


    /**
     * Gets the clmCallerDTOs value for this ClaimInfoDTO.
     * 
     * @return clmCallerDTOs
     */
    public com.ebao.health.insurance.dto.ClmCallerDTO[] getClmCallerDTOs() {
        return clmCallerDTOs;
    }


    /**
     * Sets the clmCallerDTOs value for this ClaimInfoDTO.
     * 
     * @param clmCallerDTOs
     */
    public void setClmCallerDTOs(com.ebao.health.insurance.dto.ClmCallerDTO[] clmCallerDTOs) {
        this.clmCallerDTOs = clmCallerDTOs;
    }


    /**
     * Gets the clmClaimantDTOs value for this ClaimInfoDTO.
     * 
     * @return clmClaimantDTOs
     */
    public com.ebao.health.insurance.dto.ClmClaimantDTO[] getClmClaimantDTOs() {
        return clmClaimantDTOs;
    }


    /**
     * Sets the clmClaimantDTOs value for this ClaimInfoDTO.
     * 
     * @param clmClaimantDTOs
     */
    public void setClmClaimantDTOs(com.ebao.health.insurance.dto.ClmClaimantDTO[] clmClaimantDTOs) {
        this.clmClaimantDTOs = clmClaimantDTOs;
    }


    /**
     * Gets the cooperationHospitalReceiptDTOs value for this ClaimInfoDTO.
     * 
     * @return cooperationHospitalReceiptDTOs
     */
    public com.ebao.health.insurance.dto.CooperationHospitalReceiptDTO[] getCooperationHospitalReceiptDTOs() {
        return cooperationHospitalReceiptDTOs;
    }


    /**
     * Sets the cooperationHospitalReceiptDTOs value for this ClaimInfoDTO.
     * 
     * @param cooperationHospitalReceiptDTOs
     */
    public void setCooperationHospitalReceiptDTOs(com.ebao.health.insurance.dto.CooperationHospitalReceiptDTO[] cooperationHospitalReceiptDTOs) {
        this.cooperationHospitalReceiptDTOs = cooperationHospitalReceiptDTOs;
    }


    /**
     * Gets the criticalIllnessNo value for this ClaimInfoDTO.
     * 
     * @return criticalIllnessNo
     */
    public java.lang.String getCriticalIllnessNo() {
        return criticalIllnessNo;
    }


    /**
     * Sets the criticalIllnessNo value for this ClaimInfoDTO.
     * 
     * @param criticalIllnessNo
     */
    public void setCriticalIllnessNo(java.lang.String criticalIllnessNo) {
        this.criticalIllnessNo = criticalIllnessNo;
    }


    /**
     * Gets the endcaseDate value for this ClaimInfoDTO.
     * 
     * @return endcaseDate
     */
    public java.util.Calendar getEndcaseDate() {
        return endcaseDate;
    }


    /**
     * Sets the endcaseDate value for this ClaimInfoDTO.
     * 
     * @param endcaseDate
     */
    public void setEndcaseDate(java.util.Calendar endcaseDate) {
        this.endcaseDate = endcaseDate;
    }


    /**
     * Gets the hospitalReceiptDTOs value for this ClaimInfoDTO.
     * 
     * @return hospitalReceiptDTOs
     */
    public com.ebao.health.insurance.dto.HospitalReceiptDTO[] getHospitalReceiptDTOs() {
        return hospitalReceiptDTOs;
    }


    /**
     * Sets the hospitalReceiptDTOs value for this ClaimInfoDTO.
     * 
     * @param hospitalReceiptDTOs
     */
    public void setHospitalReceiptDTOs(com.ebao.health.insurance.dto.HospitalReceiptDTO[] hospitalReceiptDTOs) {
        this.hospitalReceiptDTOs = hospitalReceiptDTOs;
    }


    /**
     * Gets the injuryReasonCode value for this ClaimInfoDTO.
     * 
     * @return injuryReasonCode
     */
    public java.lang.String getInjuryReasonCode() {
        return injuryReasonCode;
    }


    /**
     * Sets the injuryReasonCode value for this ClaimInfoDTO.
     * 
     * @param injuryReasonCode
     */
    public void setInjuryReasonCode(java.lang.String injuryReasonCode) {
        this.injuryReasonCode = injuryReasonCode;
    }


    /**
     * Gets the investigationEndDate value for this ClaimInfoDTO.
     * 
     * @return investigationEndDate
     */
    public java.util.Calendar getInvestigationEndDate() {
        return investigationEndDate;
    }


    /**
     * Sets the investigationEndDate value for this ClaimInfoDTO.
     * 
     * @param investigationEndDate
     */
    public void setInvestigationEndDate(java.util.Calendar investigationEndDate) {
        this.investigationEndDate = investigationEndDate;
    }


    /**
     * Gets the investigationStartDate value for this ClaimInfoDTO.
     * 
     * @return investigationStartDate
     */
    public java.util.Calendar getInvestigationStartDate() {
        return investigationStartDate;
    }


    /**
     * Sets the investigationStartDate value for this ClaimInfoDTO.
     * 
     * @param investigationStartDate
     */
    public void setInvestigationStartDate(java.util.Calendar investigationStartDate) {
        this.investigationStartDate = investigationStartDate;
    }


    /**
     * Gets the ordinaryClinicReceiptDTOs value for this ClaimInfoDTO.
     * 
     * @return ordinaryClinicReceiptDTOs
     */
    public com.ebao.health.insurance.dto.OrdinaryClinicReceiptDTO[] getOrdinaryClinicReceiptDTOs() {
        return ordinaryClinicReceiptDTOs;
    }


    /**
     * Sets the ordinaryClinicReceiptDTOs value for this ClaimInfoDTO.
     * 
     * @param ordinaryClinicReceiptDTOs
     */
    public void setOrdinaryClinicReceiptDTOs(com.ebao.health.insurance.dto.OrdinaryClinicReceiptDTO[] ordinaryClinicReceiptDTOs) {
        this.ordinaryClinicReceiptDTOs = ordinaryClinicReceiptDTOs;
    }


    /**
     * Gets the ordinaryHospitalReceiptDTOs value for this ClaimInfoDTO.
     * 
     * @return ordinaryHospitalReceiptDTOs
     */
    public com.ebao.health.insurance.dto.OrdinaryHospitalReceiptDTO[] getOrdinaryHospitalReceiptDTOs() {
        return ordinaryHospitalReceiptDTOs;
    }


    /**
     * Sets the ordinaryHospitalReceiptDTOs value for this ClaimInfoDTO.
     * 
     * @param ordinaryHospitalReceiptDTOs
     */
    public void setOrdinaryHospitalReceiptDTOs(com.ebao.health.insurance.dto.OrdinaryHospitalReceiptDTO[] ordinaryHospitalReceiptDTOs) {
        this.ordinaryHospitalReceiptDTOs = ordinaryHospitalReceiptDTOs;
    }


    /**
     * Gets the password value for this ClaimInfoDTO.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this ClaimInfoDTO.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the policyPaymentDTOs value for this ClaimInfoDTO.
     * 
     * @return policyPaymentDTOs
     */
    public com.ebao.health.insurance.dto.PolicyPaymentDTO[] getPolicyPaymentDTOs() {
        return policyPaymentDTOs;
    }


    /**
     * Sets the policyPaymentDTOs value for this ClaimInfoDTO.
     * 
     * @param policyPaymentDTOs
     */
    public void setPolicyPaymentDTOs(com.ebao.health.insurance.dto.PolicyPaymentDTO[] policyPaymentDTOs) {
        this.policyPaymentDTOs = policyPaymentDTOs;
    }


    /**
     * Gets the registrationDate value for this ClaimInfoDTO.
     * 
     * @return registrationDate
     */
    public java.util.Calendar getRegistrationDate() {
        return registrationDate;
    }


    /**
     * Sets the registrationDate value for this ClaimInfoDTO.
     * 
     * @param registrationDate
     */
    public void setRegistrationDate(java.util.Calendar registrationDate) {
        this.registrationDate = registrationDate;
    }


    /**
     * Gets the registrationNo value for this ClaimInfoDTO.
     * 
     * @return registrationNo
     */
    public java.lang.String getRegistrationNo() {
        return registrationNo;
    }


    /**
     * Sets the registrationNo value for this ClaimInfoDTO.
     * 
     * @param registrationNo
     */
    public void setRegistrationNo(java.lang.String registrationNo) {
        this.registrationNo = registrationNo;
    }


    /**
     * Gets the remoteClaimInvestigation value for this ClaimInfoDTO.
     * 
     * @return remoteClaimInvestigation
     */
    public java.lang.String getRemoteClaimInvestigation() {
        return remoteClaimInvestigation;
    }


    /**
     * Sets the remoteClaimInvestigation value for this ClaimInfoDTO.
     * 
     * @param remoteClaimInvestigation
     */
    public void setRemoteClaimInvestigation(java.lang.String remoteClaimInvestigation) {
        this.remoteClaimInvestigation = remoteClaimInvestigation;
    }


    /**
     * Gets the reportDate value for this ClaimInfoDTO.
     * 
     * @return reportDate
     */
    public java.util.Calendar getReportDate() {
        return reportDate;
    }


    /**
     * Sets the reportDate value for this ClaimInfoDTO.
     * 
     * @param reportDate
     */
    public void setReportDate(java.util.Calendar reportDate) {
        this.reportDate = reportDate;
    }


    /**
     * Gets the reportNo value for this ClaimInfoDTO.
     * 
     * @return reportNo
     */
    public java.lang.String getReportNo() {
        return reportNo;
    }


    /**
     * Sets the reportNo value for this ClaimInfoDTO.
     * 
     * @param reportNo
     */
    public void setReportNo(java.lang.String reportNo) {
        this.reportNo = reportNo;
    }


    /**
     * Gets the specialReceiptDTOs value for this ClaimInfoDTO.
     * 
     * @return specialReceiptDTOs
     */
    public com.ebao.health.insurance.dto.SpecialReceiptDTO[] getSpecialReceiptDTOs() {
        return specialReceiptDTOs;
    }


    /**
     * Sets the specialReceiptDTOs value for this ClaimInfoDTO.
     * 
     * @param specialReceiptDTOs
     */
    public void setSpecialReceiptDTOs(com.ebao.health.insurance.dto.SpecialReceiptDTO[] specialReceiptDTOs) {
        this.specialReceiptDTOs = specialReceiptDTOs;
    }


    /**
     * Gets the status value for this ClaimInfoDTO.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ClaimInfoDTO.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the treatmentAdvice value for this ClaimInfoDTO.
     * 
     * @return treatmentAdvice
     */
    public java.lang.String getTreatmentAdvice() {
        return treatmentAdvice;
    }


    /**
     * Sets the treatmentAdvice value for this ClaimInfoDTO.
     * 
     * @param treatmentAdvice
     */
    public void setTreatmentAdvice(java.lang.String treatmentAdvice) {
        this.treatmentAdvice = treatmentAdvice;
    }


    /**
     * Gets the userName value for this ClaimInfoDTO.
     * 
     * @return userName
     */
    public java.lang.String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this ClaimInfoDTO.
     * 
     * @param userName
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }


    /**
     * Gets the segmentationReceiptDTOs value for this ClaimInfoDTO.
     * 
     * @return segmentationReceiptDTOs
     */
    public com.ebao.health.insurance.dto.SegmentationReceiptDTO[] getSegmentationReceiptDTOs() {
        return segmentationReceiptDTOs;
    }


    /**
     * Sets the segmentationReceiptDTOs value for this ClaimInfoDTO.
     * 
     * @param segmentationReceiptDTOs
     */
    public void setSegmentationReceiptDTOs(com.ebao.health.insurance.dto.SegmentationReceiptDTO[] segmentationReceiptDTOs) {
        this.segmentationReceiptDTOs = segmentationReceiptDTOs;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClaimInfoDTO)) return false;
        ClaimInfoDTO other = (ClaimInfoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accidentReason==null && other.getAccidentReason()==null) || 
             (this.accidentReason!=null &&
              this.accidentReason.equals(other.getAccidentReason()))) &&
            ((this.accidentResultDTOs==null && other.getAccidentResultDTOs()==null) || 
             (this.accidentResultDTOs!=null &&
              java.util.Arrays.equals(this.accidentResultDTOs, other.getAccidentResultDTOs()))) &&
            ((this.accidentTime==null && other.getAccidentTime()==null) || 
             (this.accidentTime!=null &&
              this.accidentTime.equals(other.getAccidentTime()))) &&
            ((this.accidentdes==null && other.getAccidentdes()==null) || 
             (this.accidentdes!=null &&
              this.accidentdes.equals(other.getAccidentdes()))) &&
            ((this.address1==null && other.getAddress1()==null) || 
             (this.address1!=null &&
              this.address1.equals(other.getAddress1()))) &&
            ((this.address2==null && other.getAddress2()==null) || 
             (this.address2!=null &&
              this.address2.equals(other.getAddress2()))) &&
            ((this.address3==null && other.getAddress3()==null) || 
             (this.address3!=null &&
              this.address3.equals(other.getAddress3()))) &&
            ((this.address4==null && other.getAddress4()==null) || 
             (this.address4!=null &&
              this.address4.equals(other.getAddress4()))) &&
            ((this.approvalReceiptDTOs==null && other.getApprovalReceiptDTOs()==null) || 
             (this.approvalReceiptDTOs!=null &&
              java.util.Arrays.equals(this.approvalReceiptDTOs, other.getApprovalReceiptDTOs()))) &&
            ((this.batchNo==null && other.getBatchNo()==null) || 
             (this.batchNo!=null &&
              this.batchNo.equals(other.getBatchNo()))) &&
            ((this.birthClinicReceiptDTOs==null && other.getBirthClinicReceiptDTOs()==null) || 
             (this.birthClinicReceiptDTOs!=null &&
              java.util.Arrays.equals(this.birthClinicReceiptDTOs, other.getBirthClinicReceiptDTOs()))) &&
            ((this.birthHospitalReceiptDTOs==null && other.getBirthHospitalReceiptDTOs()==null) || 
             (this.birthHospitalReceiptDTOs!=null &&
              java.util.Arrays.equals(this.birthHospitalReceiptDTOs, other.getBirthHospitalReceiptDTOs()))) &&
            ((this.cancelDate==null && other.getCancelDate()==null) || 
             (this.cancelDate!=null &&
              this.cancelDate.equals(other.getCancelDate()))) &&
            ((this.claimAmount==null && other.getClaimAmount()==null) || 
             (this.claimAmount!=null &&
              this.claimAmount.equals(other.getClaimAmount()))) &&
            ((this.claimInvestigation==null && other.getClaimInvestigation()==null) || 
             (this.claimInvestigation!=null &&
              this.claimInvestigation.equals(other.getClaimInvestigation()))) &&
            ((this.claimNo==null && other.getClaimNo()==null) || 
             (this.claimNo!=null &&
              this.claimNo.equals(other.getClaimNo()))) &&
            ((this.clinicReceiptDTOs==null && other.getClinicReceiptDTOs()==null) || 
             (this.clinicReceiptDTOs!=null &&
              java.util.Arrays.equals(this.clinicReceiptDTOs, other.getClinicReceiptDTOs()))) &&
            ((this.clmCallerDTOs==null && other.getClmCallerDTOs()==null) || 
             (this.clmCallerDTOs!=null &&
              java.util.Arrays.equals(this.clmCallerDTOs, other.getClmCallerDTOs()))) &&
            ((this.clmClaimantDTOs==null && other.getClmClaimantDTOs()==null) || 
             (this.clmClaimantDTOs!=null &&
              java.util.Arrays.equals(this.clmClaimantDTOs, other.getClmClaimantDTOs()))) &&
            ((this.cooperationHospitalReceiptDTOs==null && other.getCooperationHospitalReceiptDTOs()==null) || 
             (this.cooperationHospitalReceiptDTOs!=null &&
              java.util.Arrays.equals(this.cooperationHospitalReceiptDTOs, other.getCooperationHospitalReceiptDTOs()))) &&
            ((this.criticalIllnessNo==null && other.getCriticalIllnessNo()==null) || 
             (this.criticalIllnessNo!=null &&
              this.criticalIllnessNo.equals(other.getCriticalIllnessNo()))) &&
            ((this.endcaseDate==null && other.getEndcaseDate()==null) || 
             (this.endcaseDate!=null &&
              this.endcaseDate.equals(other.getEndcaseDate()))) &&
            ((this.hospitalReceiptDTOs==null && other.getHospitalReceiptDTOs()==null) || 
             (this.hospitalReceiptDTOs!=null &&
              java.util.Arrays.equals(this.hospitalReceiptDTOs, other.getHospitalReceiptDTOs()))) &&
            ((this.injuryReasonCode==null && other.getInjuryReasonCode()==null) || 
             (this.injuryReasonCode!=null &&
              this.injuryReasonCode.equals(other.getInjuryReasonCode()))) &&
            ((this.investigationEndDate==null && other.getInvestigationEndDate()==null) || 
             (this.investigationEndDate!=null &&
              this.investigationEndDate.equals(other.getInvestigationEndDate()))) &&
            ((this.investigationStartDate==null && other.getInvestigationStartDate()==null) || 
             (this.investigationStartDate!=null &&
              this.investigationStartDate.equals(other.getInvestigationStartDate()))) &&
            ((this.ordinaryClinicReceiptDTOs==null && other.getOrdinaryClinicReceiptDTOs()==null) || 
             (this.ordinaryClinicReceiptDTOs!=null &&
              java.util.Arrays.equals(this.ordinaryClinicReceiptDTOs, other.getOrdinaryClinicReceiptDTOs()))) &&
            ((this.ordinaryHospitalReceiptDTOs==null && other.getOrdinaryHospitalReceiptDTOs()==null) || 
             (this.ordinaryHospitalReceiptDTOs!=null &&
              java.util.Arrays.equals(this.ordinaryHospitalReceiptDTOs, other.getOrdinaryHospitalReceiptDTOs()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.policyPaymentDTOs==null && other.getPolicyPaymentDTOs()==null) || 
             (this.policyPaymentDTOs!=null &&
              java.util.Arrays.equals(this.policyPaymentDTOs, other.getPolicyPaymentDTOs()))) &&
            ((this.registrationDate==null && other.getRegistrationDate()==null) || 
             (this.registrationDate!=null &&
              this.registrationDate.equals(other.getRegistrationDate()))) &&
            ((this.registrationNo==null && other.getRegistrationNo()==null) || 
             (this.registrationNo!=null &&
              this.registrationNo.equals(other.getRegistrationNo()))) &&
            ((this.remoteClaimInvestigation==null && other.getRemoteClaimInvestigation()==null) || 
             (this.remoteClaimInvestigation!=null &&
              this.remoteClaimInvestigation.equals(other.getRemoteClaimInvestigation()))) &&
            ((this.reportDate==null && other.getReportDate()==null) || 
             (this.reportDate!=null &&
              this.reportDate.equals(other.getReportDate()))) &&
            ((this.reportNo==null && other.getReportNo()==null) || 
             (this.reportNo!=null &&
              this.reportNo.equals(other.getReportNo()))) &&
            ((this.specialReceiptDTOs==null && other.getSpecialReceiptDTOs()==null) || 
             (this.specialReceiptDTOs!=null &&
              java.util.Arrays.equals(this.specialReceiptDTOs, other.getSpecialReceiptDTOs()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.treatmentAdvice==null && other.getTreatmentAdvice()==null) || 
             (this.treatmentAdvice!=null &&
              this.treatmentAdvice.equals(other.getTreatmentAdvice()))) &&
            ((this.userName==null && other.getUserName()==null) || 
             (this.userName!=null &&
              this.userName.equals(other.getUserName()))) &&
            ((this.segmentationReceiptDTOs==null && other.getSegmentationReceiptDTOs()==null) || 
             (this.segmentationReceiptDTOs!=null &&
              java.util.Arrays.equals(this.segmentationReceiptDTOs, other.getSegmentationReceiptDTOs())));
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
        if (getAccidentReason() != null) {
            _hashCode += getAccidentReason().hashCode();
        }
        if (getAccidentResultDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccidentResultDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccidentResultDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAccidentTime() != null) {
            _hashCode += getAccidentTime().hashCode();
        }
        if (getAccidentdes() != null) {
            _hashCode += getAccidentdes().hashCode();
        }
        if (getAddress1() != null) {
            _hashCode += getAddress1().hashCode();
        }
        if (getAddress2() != null) {
            _hashCode += getAddress2().hashCode();
        }
        if (getAddress3() != null) {
            _hashCode += getAddress3().hashCode();
        }
        if (getAddress4() != null) {
            _hashCode += getAddress4().hashCode();
        }
        if (getApprovalReceiptDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getApprovalReceiptDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getApprovalReceiptDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBatchNo() != null) {
            _hashCode += getBatchNo().hashCode();
        }
        if (getBirthClinicReceiptDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBirthClinicReceiptDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBirthClinicReceiptDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBirthHospitalReceiptDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBirthHospitalReceiptDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBirthHospitalReceiptDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCancelDate() != null) {
            _hashCode += getCancelDate().hashCode();
        }
        if (getClaimAmount() != null) {
            _hashCode += getClaimAmount().hashCode();
        }
        if (getClaimInvestigation() != null) {
            _hashCode += getClaimInvestigation().hashCode();
        }
        if (getClaimNo() != null) {
            _hashCode += getClaimNo().hashCode();
        }
        if (getClinicReceiptDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClinicReceiptDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClinicReceiptDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getClmCallerDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClmCallerDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClmCallerDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getClmClaimantDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClmClaimantDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClmClaimantDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCooperationHospitalReceiptDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCooperationHospitalReceiptDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCooperationHospitalReceiptDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCriticalIllnessNo() != null) {
            _hashCode += getCriticalIllnessNo().hashCode();
        }
        if (getEndcaseDate() != null) {
            _hashCode += getEndcaseDate().hashCode();
        }
        if (getHospitalReceiptDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHospitalReceiptDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHospitalReceiptDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getInjuryReasonCode() != null) {
            _hashCode += getInjuryReasonCode().hashCode();
        }
        if (getInvestigationEndDate() != null) {
            _hashCode += getInvestigationEndDate().hashCode();
        }
        if (getInvestigationStartDate() != null) {
            _hashCode += getInvestigationStartDate().hashCode();
        }
        if (getOrdinaryClinicReceiptDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrdinaryClinicReceiptDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrdinaryClinicReceiptDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOrdinaryHospitalReceiptDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrdinaryHospitalReceiptDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrdinaryHospitalReceiptDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getPolicyPaymentDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPolicyPaymentDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPolicyPaymentDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRegistrationDate() != null) {
            _hashCode += getRegistrationDate().hashCode();
        }
        if (getRegistrationNo() != null) {
            _hashCode += getRegistrationNo().hashCode();
        }
        if (getRemoteClaimInvestigation() != null) {
            _hashCode += getRemoteClaimInvestigation().hashCode();
        }
        if (getReportDate() != null) {
            _hashCode += getReportDate().hashCode();
        }
        if (getReportNo() != null) {
            _hashCode += getReportNo().hashCode();
        }
        if (getSpecialReceiptDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSpecialReceiptDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSpecialReceiptDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getTreatmentAdvice() != null) {
            _hashCode += getTreatmentAdvice().hashCode();
        }
        if (getUserName() != null) {
            _hashCode += getUserName().hashCode();
        }
        if (getSegmentationReceiptDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSegmentationReceiptDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSegmentationReceiptDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClaimInfoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClaimInfoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidentReason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidentReason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidentResultDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidentResultDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "AccidentResultDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidentTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidentTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidentdes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidentdes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address4");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("approvalReceiptDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "approvalReceiptDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ApprovalReceiptDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("batchNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "batchNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("birthClinicReceiptDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "birthClinicReceiptDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "BirthClinicReceiptDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("birthHospitalReceiptDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "birthHospitalReceiptDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "BirthHospitalReceiptDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancelDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimInvestigation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimInvestigation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clinicReceiptDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clinicReceiptDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClinicReceiptDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clmCallerDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clmCallerDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClmCallerDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clmClaimantDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clmClaimantDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClmClaimantDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cooperationHospitalReceiptDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cooperationHospitalReceiptDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CooperationHospitalReceiptDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("criticalIllnessNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "criticalIllnessNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endcaseDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endcaseDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hospitalReceiptDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hospitalReceiptDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "HospitalReceiptDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("injuryReasonCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "injuryReasonCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("investigationEndDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "investigationEndDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("investigationStartDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "investigationStartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordinaryClinicReceiptDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordinaryClinicReceiptDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "OrdinaryClinicReceiptDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordinaryHospitalReceiptDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordinaryHospitalReceiptDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "OrdinaryHospitalReceiptDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyPaymentDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyPaymentDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyPaymentDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registrationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "registrationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registrationNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "registrationNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remoteClaimInvestigation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "remoteClaimInvestigation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reportDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reportNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specialReceiptDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "specialReceiptDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialReceiptDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("treatmentAdvice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "treatmentAdvice"));
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
        elemField.setFieldName("segmentationReceiptDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segmentationReceiptDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SegmentationReceiptDTO"));
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
