/**
 * PolicyUpcoverageDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class PolicyUpcoverageDTO  implements java.io.Serializable {
    private java.lang.String comCoverageCode;

    private java.lang.String coverageCode;

    private java.math.BigDecimal coverageCurrentPremium;

    private java.util.Calendar coverageEffectiveDate;

    private java.math.BigDecimal coverageEffectiveSuminsured;

    private java.util.Calendar coverageExpireDate;

    private java.lang.String coverageName;

    private java.math.BigDecimal coveragePremium;

    private java.lang.String coverageStatus;

    private java.math.BigDecimal coverageSuminsured;

    private java.lang.String coverageType;

    private java.lang.String mainAttachedFlag;

    private java.lang.String paymentMethod;

    private java.math.BigDecimal paymentNo;

    private java.math.BigDecimal paymentYears;

    private com.ebao.health.insurance.dto.PolicyCoverageDTO[] policyCoverageDTOs;

    private java.lang.String specificBusiness;

    private java.lang.String specificBusinessCode;

    private com.ebao.health.insurance.dto.UnderWritingDTO[] underWritingDTOs;

    private java.math.BigDecimal coveragedayAmount;

    private java.math.BigDecimal coveragedayEffectiveAmount;

    private java.math.BigDecimal coverageyearPremium;

    private java.lang.String premiumSource;

    public PolicyUpcoverageDTO() {
    }

    public PolicyUpcoverageDTO(
           java.lang.String comCoverageCode,
           java.lang.String coverageCode,
           java.math.BigDecimal coverageCurrentPremium,
           java.util.Calendar coverageEffectiveDate,
           java.math.BigDecimal coverageEffectiveSuminsured,
           java.util.Calendar coverageExpireDate,
           java.lang.String coverageName,
           java.math.BigDecimal coveragePremium,
           java.lang.String coverageStatus,
           java.math.BigDecimal coverageSuminsured,
           java.lang.String coverageType,
           java.lang.String mainAttachedFlag,
           java.lang.String paymentMethod,
           java.math.BigDecimal paymentNo,
           java.math.BigDecimal paymentYears,
           com.ebao.health.insurance.dto.PolicyCoverageDTO[] policyCoverageDTOs,
           java.lang.String specificBusiness,
           java.lang.String specificBusinessCode,
           com.ebao.health.insurance.dto.UnderWritingDTO[] underWritingDTOs,
           java.math.BigDecimal coveragedayAmount,
           java.math.BigDecimal coveragedayEffectiveAmount,
           java.math.BigDecimal coverageyearPremium,
           java.lang.String premiumSource) {
           this.comCoverageCode = comCoverageCode;
           this.coverageCode = coverageCode;
           this.coverageCurrentPremium = coverageCurrentPremium;
           this.coverageEffectiveDate = coverageEffectiveDate;
           this.coverageEffectiveSuminsured = coverageEffectiveSuminsured;
           this.coverageExpireDate = coverageExpireDate;
           this.coverageName = coverageName;
           this.coveragePremium = coveragePremium;
           this.coverageStatus = coverageStatus;
           this.coverageSuminsured = coverageSuminsured;
           this.coverageType = coverageType;
           this.mainAttachedFlag = mainAttachedFlag;
           this.paymentMethod = paymentMethod;
           this.paymentNo = paymentNo;
           this.paymentYears = paymentYears;
           this.policyCoverageDTOs = policyCoverageDTOs;
           this.specificBusiness = specificBusiness;
           this.specificBusinessCode = specificBusinessCode;
           this.underWritingDTOs = underWritingDTOs;
           this.coveragedayAmount = coveragedayAmount;
           this.coveragedayEffectiveAmount = coveragedayEffectiveAmount;
           this.coverageyearPremium = coverageyearPremium;
           this.premiumSource = premiumSource;
    }


    /**
     * Gets the comCoverageCode value for this PolicyUpcoverageDTO.
     * 
     * @return comCoverageCode
     */
    public java.lang.String getComCoverageCode() {
        return comCoverageCode;
    }


    /**
     * Sets the comCoverageCode value for this PolicyUpcoverageDTO.
     * 
     * @param comCoverageCode
     */
    public void setComCoverageCode(java.lang.String comCoverageCode) {
        this.comCoverageCode = comCoverageCode;
    }


    /**
     * Gets the coverageCode value for this PolicyUpcoverageDTO.
     * 
     * @return coverageCode
     */
    public java.lang.String getCoverageCode() {
        return coverageCode;
    }


    /**
     * Sets the coverageCode value for this PolicyUpcoverageDTO.
     * 
     * @param coverageCode
     */
    public void setCoverageCode(java.lang.String coverageCode) {
        this.coverageCode = coverageCode;
    }


    /**
     * Gets the coverageCurrentPremium value for this PolicyUpcoverageDTO.
     * 
     * @return coverageCurrentPremium
     */
    public java.math.BigDecimal getCoverageCurrentPremium() {
        return coverageCurrentPremium;
    }


    /**
     * Sets the coverageCurrentPremium value for this PolicyUpcoverageDTO.
     * 
     * @param coverageCurrentPremium
     */
    public void setCoverageCurrentPremium(java.math.BigDecimal coverageCurrentPremium) {
        this.coverageCurrentPremium = coverageCurrentPremium;
    }


    /**
     * Gets the coverageEffectiveDate value for this PolicyUpcoverageDTO.
     * 
     * @return coverageEffectiveDate
     */
    public java.util.Calendar getCoverageEffectiveDate() {
        return coverageEffectiveDate;
    }


    /**
     * Sets the coverageEffectiveDate value for this PolicyUpcoverageDTO.
     * 
     * @param coverageEffectiveDate
     */
    public void setCoverageEffectiveDate(java.util.Calendar coverageEffectiveDate) {
        this.coverageEffectiveDate = coverageEffectiveDate;
    }


    /**
     * Gets the coverageEffectiveSuminsured value for this PolicyUpcoverageDTO.
     * 
     * @return coverageEffectiveSuminsured
     */
    public java.math.BigDecimal getCoverageEffectiveSuminsured() {
        return coverageEffectiveSuminsured;
    }


    /**
     * Sets the coverageEffectiveSuminsured value for this PolicyUpcoverageDTO.
     * 
     * @param coverageEffectiveSuminsured
     */
    public void setCoverageEffectiveSuminsured(java.math.BigDecimal coverageEffectiveSuminsured) {
        this.coverageEffectiveSuminsured = coverageEffectiveSuminsured;
    }


    /**
     * Gets the coverageExpireDate value for this PolicyUpcoverageDTO.
     * 
     * @return coverageExpireDate
     */
    public java.util.Calendar getCoverageExpireDate() {
        return coverageExpireDate;
    }


    /**
     * Sets the coverageExpireDate value for this PolicyUpcoverageDTO.
     * 
     * @param coverageExpireDate
     */
    public void setCoverageExpireDate(java.util.Calendar coverageExpireDate) {
        this.coverageExpireDate = coverageExpireDate;
    }


    /**
     * Gets the coverageName value for this PolicyUpcoverageDTO.
     * 
     * @return coverageName
     */
    public java.lang.String getCoverageName() {
        return coverageName;
    }


    /**
     * Sets the coverageName value for this PolicyUpcoverageDTO.
     * 
     * @param coverageName
     */
    public void setCoverageName(java.lang.String coverageName) {
        this.coverageName = coverageName;
    }


    /**
     * Gets the coveragePremium value for this PolicyUpcoverageDTO.
     * 
     * @return coveragePremium
     */
    public java.math.BigDecimal getCoveragePremium() {
        return coveragePremium;
    }


    /**
     * Sets the coveragePremium value for this PolicyUpcoverageDTO.
     * 
     * @param coveragePremium
     */
    public void setCoveragePremium(java.math.BigDecimal coveragePremium) {
        this.coveragePremium = coveragePremium;
    }


    /**
     * Gets the coverageStatus value for this PolicyUpcoverageDTO.
     * 
     * @return coverageStatus
     */
    public java.lang.String getCoverageStatus() {
        return coverageStatus;
    }


    /**
     * Sets the coverageStatus value for this PolicyUpcoverageDTO.
     * 
     * @param coverageStatus
     */
    public void setCoverageStatus(java.lang.String coverageStatus) {
        this.coverageStatus = coverageStatus;
    }


    /**
     * Gets the coverageSuminsured value for this PolicyUpcoverageDTO.
     * 
     * @return coverageSuminsured
     */
    public java.math.BigDecimal getCoverageSuminsured() {
        return coverageSuminsured;
    }


    /**
     * Sets the coverageSuminsured value for this PolicyUpcoverageDTO.
     * 
     * @param coverageSuminsured
     */
    public void setCoverageSuminsured(java.math.BigDecimal coverageSuminsured) {
        this.coverageSuminsured = coverageSuminsured;
    }


    /**
     * Gets the coverageType value for this PolicyUpcoverageDTO.
     * 
     * @return coverageType
     */
    public java.lang.String getCoverageType() {
        return coverageType;
    }


    /**
     * Sets the coverageType value for this PolicyUpcoverageDTO.
     * 
     * @param coverageType
     */
    public void setCoverageType(java.lang.String coverageType) {
        this.coverageType = coverageType;
    }


    /**
     * Gets the mainAttachedFlag value for this PolicyUpcoverageDTO.
     * 
     * @return mainAttachedFlag
     */
    public java.lang.String getMainAttachedFlag() {
        return mainAttachedFlag;
    }


    /**
     * Sets the mainAttachedFlag value for this PolicyUpcoverageDTO.
     * 
     * @param mainAttachedFlag
     */
    public void setMainAttachedFlag(java.lang.String mainAttachedFlag) {
        this.mainAttachedFlag = mainAttachedFlag;
    }


    /**
     * Gets the paymentMethod value for this PolicyUpcoverageDTO.
     * 
     * @return paymentMethod
     */
    public java.lang.String getPaymentMethod() {
        return paymentMethod;
    }


    /**
     * Sets the paymentMethod value for this PolicyUpcoverageDTO.
     * 
     * @param paymentMethod
     */
    public void setPaymentMethod(java.lang.String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    /**
     * Gets the paymentNo value for this PolicyUpcoverageDTO.
     * 
     * @return paymentNo
     */
    public java.math.BigDecimal getPaymentNo() {
        return paymentNo;
    }


    /**
     * Sets the paymentNo value for this PolicyUpcoverageDTO.
     * 
     * @param paymentNo
     */
    public void setPaymentNo(java.math.BigDecimal paymentNo) {
        this.paymentNo = paymentNo;
    }


    /**
     * Gets the paymentYears value for this PolicyUpcoverageDTO.
     * 
     * @return paymentYears
     */
    public java.math.BigDecimal getPaymentYears() {
        return paymentYears;
    }


    /**
     * Sets the paymentYears value for this PolicyUpcoverageDTO.
     * 
     * @param paymentYears
     */
    public void setPaymentYears(java.math.BigDecimal paymentYears) {
        this.paymentYears = paymentYears;
    }


    /**
     * Gets the policyCoverageDTOs value for this PolicyUpcoverageDTO.
     * 
     * @return policyCoverageDTOs
     */
    public com.ebao.health.insurance.dto.PolicyCoverageDTO[] getPolicyCoverageDTOs() {
        return policyCoverageDTOs;
    }


    /**
     * Sets the policyCoverageDTOs value for this PolicyUpcoverageDTO.
     * 
     * @param policyCoverageDTOs
     */
    public void setPolicyCoverageDTOs(com.ebao.health.insurance.dto.PolicyCoverageDTO[] policyCoverageDTOs) {
        this.policyCoverageDTOs = policyCoverageDTOs;
    }


    /**
     * Gets the specificBusiness value for this PolicyUpcoverageDTO.
     * 
     * @return specificBusiness
     */
    public java.lang.String getSpecificBusiness() {
        return specificBusiness;
    }


    /**
     * Sets the specificBusiness value for this PolicyUpcoverageDTO.
     * 
     * @param specificBusiness
     */
    public void setSpecificBusiness(java.lang.String specificBusiness) {
        this.specificBusiness = specificBusiness;
    }


    /**
     * Gets the specificBusinessCode value for this PolicyUpcoverageDTO.
     * 
     * @return specificBusinessCode
     */
    public java.lang.String getSpecificBusinessCode() {
        return specificBusinessCode;
    }


    /**
     * Sets the specificBusinessCode value for this PolicyUpcoverageDTO.
     * 
     * @param specificBusinessCode
     */
    public void setSpecificBusinessCode(java.lang.String specificBusinessCode) {
        this.specificBusinessCode = specificBusinessCode;
    }


    /**
     * Gets the underWritingDTOs value for this PolicyUpcoverageDTO.
     * 
     * @return underWritingDTOs
     */
    public com.ebao.health.insurance.dto.UnderWritingDTO[] getUnderWritingDTOs() {
        return underWritingDTOs;
    }


    /**
     * Sets the underWritingDTOs value for this PolicyUpcoverageDTO.
     * 
     * @param underWritingDTOs
     */
    public void setUnderWritingDTOs(com.ebao.health.insurance.dto.UnderWritingDTO[] underWritingDTOs) {
        this.underWritingDTOs = underWritingDTOs;
    }


    /**
     * Gets the coveragedayAmount value for this PolicyUpcoverageDTO.
     * 
     * @return coveragedayAmount
     */
    public java.math.BigDecimal getCoveragedayAmount() {
        return coveragedayAmount;
    }


    /**
     * Sets the coveragedayAmount value for this PolicyUpcoverageDTO.
     * 
     * @param coveragedayAmount
     */
    public void setCoveragedayAmount(java.math.BigDecimal coveragedayAmount) {
        this.coveragedayAmount = coveragedayAmount;
    }


    /**
     * Gets the coveragedayEffectiveAmount value for this PolicyUpcoverageDTO.
     * 
     * @return coveragedayEffectiveAmount
     */
    public java.math.BigDecimal getCoveragedayEffectiveAmount() {
        return coveragedayEffectiveAmount;
    }


    /**
     * Sets the coveragedayEffectiveAmount value for this PolicyUpcoverageDTO.
     * 
     * @param coveragedayEffectiveAmount
     */
    public void setCoveragedayEffectiveAmount(java.math.BigDecimal coveragedayEffectiveAmount) {
        this.coveragedayEffectiveAmount = coveragedayEffectiveAmount;
    }


    /**
     * Gets the coverageyearPremium value for this PolicyUpcoverageDTO.
     * 
     * @return coverageyearPremium
     */
    public java.math.BigDecimal getCoverageyearPremium() {
        return coverageyearPremium;
    }


    /**
     * Sets the coverageyearPremium value for this PolicyUpcoverageDTO.
     * 
     * @param coverageyearPremium
     */
    public void setCoverageyearPremium(java.math.BigDecimal coverageyearPremium) {
        this.coverageyearPremium = coverageyearPremium;
    }


    /**
     * Gets the premiumSource value for this PolicyUpcoverageDTO.
     * 
     * @return premiumSource
     */
    public java.lang.String getPremiumSource() {
        return premiumSource;
    }


    /**
     * Sets the premiumSource value for this PolicyUpcoverageDTO.
     * 
     * @param premiumSource
     */
    public void setPremiumSource(java.lang.String premiumSource) {
        this.premiumSource = premiumSource;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PolicyUpcoverageDTO)) return false;
        PolicyUpcoverageDTO other = (PolicyUpcoverageDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.comCoverageCode==null && other.getComCoverageCode()==null) || 
             (this.comCoverageCode!=null &&
              this.comCoverageCode.equals(other.getComCoverageCode()))) &&
            ((this.coverageCode==null && other.getCoverageCode()==null) || 
             (this.coverageCode!=null &&
              this.coverageCode.equals(other.getCoverageCode()))) &&
            ((this.coverageCurrentPremium==null && other.getCoverageCurrentPremium()==null) || 
             (this.coverageCurrentPremium!=null &&
              this.coverageCurrentPremium.equals(other.getCoverageCurrentPremium()))) &&
            ((this.coverageEffectiveDate==null && other.getCoverageEffectiveDate()==null) || 
             (this.coverageEffectiveDate!=null &&
              this.coverageEffectiveDate.equals(other.getCoverageEffectiveDate()))) &&
            ((this.coverageEffectiveSuminsured==null && other.getCoverageEffectiveSuminsured()==null) || 
             (this.coverageEffectiveSuminsured!=null &&
              this.coverageEffectiveSuminsured.equals(other.getCoverageEffectiveSuminsured()))) &&
            ((this.coverageExpireDate==null && other.getCoverageExpireDate()==null) || 
             (this.coverageExpireDate!=null &&
              this.coverageExpireDate.equals(other.getCoverageExpireDate()))) &&
            ((this.coverageName==null && other.getCoverageName()==null) || 
             (this.coverageName!=null &&
              this.coverageName.equals(other.getCoverageName()))) &&
            ((this.coveragePremium==null && other.getCoveragePremium()==null) || 
             (this.coveragePremium!=null &&
              this.coveragePremium.equals(other.getCoveragePremium()))) &&
            ((this.coverageStatus==null && other.getCoverageStatus()==null) || 
             (this.coverageStatus!=null &&
              this.coverageStatus.equals(other.getCoverageStatus()))) &&
            ((this.coverageSuminsured==null && other.getCoverageSuminsured()==null) || 
             (this.coverageSuminsured!=null &&
              this.coverageSuminsured.equals(other.getCoverageSuminsured()))) &&
            ((this.coverageType==null && other.getCoverageType()==null) || 
             (this.coverageType!=null &&
              this.coverageType.equals(other.getCoverageType()))) &&
            ((this.mainAttachedFlag==null && other.getMainAttachedFlag()==null) || 
             (this.mainAttachedFlag!=null &&
              this.mainAttachedFlag.equals(other.getMainAttachedFlag()))) &&
            ((this.paymentMethod==null && other.getPaymentMethod()==null) || 
             (this.paymentMethod!=null &&
              this.paymentMethod.equals(other.getPaymentMethod()))) &&
            ((this.paymentNo==null && other.getPaymentNo()==null) || 
             (this.paymentNo!=null &&
              this.paymentNo.equals(other.getPaymentNo()))) &&
            ((this.paymentYears==null && other.getPaymentYears()==null) || 
             (this.paymentYears!=null &&
              this.paymentYears.equals(other.getPaymentYears()))) &&
            ((this.policyCoverageDTOs==null && other.getPolicyCoverageDTOs()==null) || 
             (this.policyCoverageDTOs!=null &&
              java.util.Arrays.equals(this.policyCoverageDTOs, other.getPolicyCoverageDTOs()))) &&
            ((this.specificBusiness==null && other.getSpecificBusiness()==null) || 
             (this.specificBusiness!=null &&
              this.specificBusiness.equals(other.getSpecificBusiness()))) &&
            ((this.specificBusinessCode==null && other.getSpecificBusinessCode()==null) || 
             (this.specificBusinessCode!=null &&
              this.specificBusinessCode.equals(other.getSpecificBusinessCode()))) &&
            ((this.underWritingDTOs==null && other.getUnderWritingDTOs()==null) || 
             (this.underWritingDTOs!=null &&
              java.util.Arrays.equals(this.underWritingDTOs, other.getUnderWritingDTOs()))) &&
            ((this.coveragedayAmount==null && other.getCoveragedayAmount()==null) || 
             (this.coveragedayAmount!=null &&
              this.coveragedayAmount.equals(other.getCoveragedayAmount()))) &&
            ((this.coveragedayEffectiveAmount==null && other.getCoveragedayEffectiveAmount()==null) || 
             (this.coveragedayEffectiveAmount!=null &&
              this.coveragedayEffectiveAmount.equals(other.getCoveragedayEffectiveAmount()))) &&
            ((this.coverageyearPremium==null && other.getCoverageyearPremium()==null) || 
             (this.coverageyearPremium!=null &&
              this.coverageyearPremium.equals(other.getCoverageyearPremium()))) &&
            ((this.premiumSource==null && other.getPremiumSource()==null) || 
             (this.premiumSource!=null &&
              this.premiumSource.equals(other.getPremiumSource())));
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
        if (getComCoverageCode() != null) {
            _hashCode += getComCoverageCode().hashCode();
        }
        if (getCoverageCode() != null) {
            _hashCode += getCoverageCode().hashCode();
        }
        if (getCoverageCurrentPremium() != null) {
            _hashCode += getCoverageCurrentPremium().hashCode();
        }
        if (getCoverageEffectiveDate() != null) {
            _hashCode += getCoverageEffectiveDate().hashCode();
        }
        if (getCoverageEffectiveSuminsured() != null) {
            _hashCode += getCoverageEffectiveSuminsured().hashCode();
        }
        if (getCoverageExpireDate() != null) {
            _hashCode += getCoverageExpireDate().hashCode();
        }
        if (getCoverageName() != null) {
            _hashCode += getCoverageName().hashCode();
        }
        if (getCoveragePremium() != null) {
            _hashCode += getCoveragePremium().hashCode();
        }
        if (getCoverageStatus() != null) {
            _hashCode += getCoverageStatus().hashCode();
        }
        if (getCoverageSuminsured() != null) {
            _hashCode += getCoverageSuminsured().hashCode();
        }
        if (getCoverageType() != null) {
            _hashCode += getCoverageType().hashCode();
        }
        if (getMainAttachedFlag() != null) {
            _hashCode += getMainAttachedFlag().hashCode();
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
        if (getPolicyCoverageDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPolicyCoverageDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPolicyCoverageDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSpecificBusiness() != null) {
            _hashCode += getSpecificBusiness().hashCode();
        }
        if (getSpecificBusinessCode() != null) {
            _hashCode += getSpecificBusinessCode().hashCode();
        }
        if (getUnderWritingDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUnderWritingDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUnderWritingDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCoveragedayAmount() != null) {
            _hashCode += getCoveragedayAmount().hashCode();
        }
        if (getCoveragedayEffectiveAmount() != null) {
            _hashCode += getCoveragedayEffectiveAmount().hashCode();
        }
        if (getCoverageyearPremium() != null) {
            _hashCode += getCoverageyearPremium().hashCode();
        }
        if (getPremiumSource() != null) {
            _hashCode += getPremiumSource().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PolicyUpcoverageDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyUpcoverageDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comCoverageCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comCoverageCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageCurrentPremium");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageCurrentPremium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageEffectiveDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageEffectiveDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageEffectiveSuminsured");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageEffectiveSuminsured"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageExpireDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageExpireDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coveragePremium");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coveragePremium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageSuminsured");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageSuminsured"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageType"));
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
        elemField.setFieldName("policyCoverageDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyCoverageDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyCoverageDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specificBusiness");
        elemField.setXmlName(new javax.xml.namespace.QName("", "specificBusiness"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specificBusinessCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "specificBusinessCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("underWritingDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "underWritingDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UnderWritingDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coveragedayAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coveragedayAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coveragedayEffectiveAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coveragedayEffectiveAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageyearPremium");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageyearPremium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("premiumSource");
        elemField.setXmlName(new javax.xml.namespace.QName("", "premiumSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
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
