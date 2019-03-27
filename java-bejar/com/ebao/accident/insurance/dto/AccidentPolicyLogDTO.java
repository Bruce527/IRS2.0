/**
 * AccidentPolicyLogDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.accident.insurance.dto;

public class AccidentPolicyLogDTO  implements java.io.Serializable {
    private com.ebao.accident.insurance.dto.AccidentPolicyInsuredLogDTO[] accidentPolicyInsuredLogDTOs;

    private com.ebao.accident.insurance.dto.AccidentPolicyPersonphLogDTO[] accidentPolicyPersonphLogDTOs;

    private java.util.Calendar applicationDate;

    private java.lang.String applicationFormNo;

    private java.util.Calendar effectiveDate;

    private java.util.Calendar endorsementApplicationDate;

    private java.lang.String endorsementNo;

    private java.lang.String endorsementType;

    private java.util.Calendar policyEndDate;

    private java.lang.String policyNo;

    private java.util.Calendar policyStartDate;

    private java.math.BigDecimal premium;

    private java.lang.String productName;

    private java.lang.String renewalMethod;

    private java.math.BigDecimal renewalTimes;

    private java.lang.String sales;

    private java.lang.String salesChannelCode;

    private java.lang.String salesChannelName;

    private java.lang.String specialRemark;

    public AccidentPolicyLogDTO() {
    }

    public AccidentPolicyLogDTO(
           com.ebao.accident.insurance.dto.AccidentPolicyInsuredLogDTO[] accidentPolicyInsuredLogDTOs,
           com.ebao.accident.insurance.dto.AccidentPolicyPersonphLogDTO[] accidentPolicyPersonphLogDTOs,
           java.util.Calendar applicationDate,
           java.lang.String applicationFormNo,
           java.util.Calendar effectiveDate,
           java.util.Calendar endorsementApplicationDate,
           java.lang.String endorsementNo,
           java.lang.String endorsementType,
           java.util.Calendar policyEndDate,
           java.lang.String policyNo,
           java.util.Calendar policyStartDate,
           java.math.BigDecimal premium,
           java.lang.String productName,
           java.lang.String renewalMethod,
           java.math.BigDecimal renewalTimes,
           java.lang.String sales,
           java.lang.String salesChannelCode,
           java.lang.String salesChannelName,
           java.lang.String specialRemark) {
           this.accidentPolicyInsuredLogDTOs = accidentPolicyInsuredLogDTOs;
           this.accidentPolicyPersonphLogDTOs = accidentPolicyPersonphLogDTOs;
           this.applicationDate = applicationDate;
           this.applicationFormNo = applicationFormNo;
           this.effectiveDate = effectiveDate;
           this.endorsementApplicationDate = endorsementApplicationDate;
           this.endorsementNo = endorsementNo;
           this.endorsementType = endorsementType;
           this.policyEndDate = policyEndDate;
           this.policyNo = policyNo;
           this.policyStartDate = policyStartDate;
           this.premium = premium;
           this.productName = productName;
           this.renewalMethod = renewalMethod;
           this.renewalTimes = renewalTimes;
           this.sales = sales;
           this.salesChannelCode = salesChannelCode;
           this.salesChannelName = salesChannelName;
           this.specialRemark = specialRemark;
    }


    /**
     * Gets the accidentPolicyInsuredLogDTOs value for this AccidentPolicyLogDTO.
     * 
     * @return accidentPolicyInsuredLogDTOs
     */
    public com.ebao.accident.insurance.dto.AccidentPolicyInsuredLogDTO[] getAccidentPolicyInsuredLogDTOs() {
        return accidentPolicyInsuredLogDTOs;
    }


    /**
     * Sets the accidentPolicyInsuredLogDTOs value for this AccidentPolicyLogDTO.
     * 
     * @param accidentPolicyInsuredLogDTOs
     */
    public void setAccidentPolicyInsuredLogDTOs(com.ebao.accident.insurance.dto.AccidentPolicyInsuredLogDTO[] accidentPolicyInsuredLogDTOs) {
        this.accidentPolicyInsuredLogDTOs = accidentPolicyInsuredLogDTOs;
    }


    /**
     * Gets the accidentPolicyPersonphLogDTOs value for this AccidentPolicyLogDTO.
     * 
     * @return accidentPolicyPersonphLogDTOs
     */
    public com.ebao.accident.insurance.dto.AccidentPolicyPersonphLogDTO[] getAccidentPolicyPersonphLogDTOs() {
        return accidentPolicyPersonphLogDTOs;
    }


    /**
     * Sets the accidentPolicyPersonphLogDTOs value for this AccidentPolicyLogDTO.
     * 
     * @param accidentPolicyPersonphLogDTOs
     */
    public void setAccidentPolicyPersonphLogDTOs(com.ebao.accident.insurance.dto.AccidentPolicyPersonphLogDTO[] accidentPolicyPersonphLogDTOs) {
        this.accidentPolicyPersonphLogDTOs = accidentPolicyPersonphLogDTOs;
    }


    /**
     * Gets the applicationDate value for this AccidentPolicyLogDTO.
     * 
     * @return applicationDate
     */
    public java.util.Calendar getApplicationDate() {
        return applicationDate;
    }


    /**
     * Sets the applicationDate value for this AccidentPolicyLogDTO.
     * 
     * @param applicationDate
     */
    public void setApplicationDate(java.util.Calendar applicationDate) {
        this.applicationDate = applicationDate;
    }


    /**
     * Gets the applicationFormNo value for this AccidentPolicyLogDTO.
     * 
     * @return applicationFormNo
     */
    public java.lang.String getApplicationFormNo() {
        return applicationFormNo;
    }


    /**
     * Sets the applicationFormNo value for this AccidentPolicyLogDTO.
     * 
     * @param applicationFormNo
     */
    public void setApplicationFormNo(java.lang.String applicationFormNo) {
        this.applicationFormNo = applicationFormNo;
    }


    /**
     * Gets the effectiveDate value for this AccidentPolicyLogDTO.
     * 
     * @return effectiveDate
     */
    public java.util.Calendar getEffectiveDate() {
        return effectiveDate;
    }


    /**
     * Sets the effectiveDate value for this AccidentPolicyLogDTO.
     * 
     * @param effectiveDate
     */
    public void setEffectiveDate(java.util.Calendar effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    /**
     * Gets the endorsementApplicationDate value for this AccidentPolicyLogDTO.
     * 
     * @return endorsementApplicationDate
     */
    public java.util.Calendar getEndorsementApplicationDate() {
        return endorsementApplicationDate;
    }


    /**
     * Sets the endorsementApplicationDate value for this AccidentPolicyLogDTO.
     * 
     * @param endorsementApplicationDate
     */
    public void setEndorsementApplicationDate(java.util.Calendar endorsementApplicationDate) {
        this.endorsementApplicationDate = endorsementApplicationDate;
    }


    /**
     * Gets the endorsementNo value for this AccidentPolicyLogDTO.
     * 
     * @return endorsementNo
     */
    public java.lang.String getEndorsementNo() {
        return endorsementNo;
    }


    /**
     * Sets the endorsementNo value for this AccidentPolicyLogDTO.
     * 
     * @param endorsementNo
     */
    public void setEndorsementNo(java.lang.String endorsementNo) {
        this.endorsementNo = endorsementNo;
    }


    /**
     * Gets the endorsementType value for this AccidentPolicyLogDTO.
     * 
     * @return endorsementType
     */
    public java.lang.String getEndorsementType() {
        return endorsementType;
    }


    /**
     * Sets the endorsementType value for this AccidentPolicyLogDTO.
     * 
     * @param endorsementType
     */
    public void setEndorsementType(java.lang.String endorsementType) {
        this.endorsementType = endorsementType;
    }


    /**
     * Gets the policyEndDate value for this AccidentPolicyLogDTO.
     * 
     * @return policyEndDate
     */
    public java.util.Calendar getPolicyEndDate() {
        return policyEndDate;
    }


    /**
     * Sets the policyEndDate value for this AccidentPolicyLogDTO.
     * 
     * @param policyEndDate
     */
    public void setPolicyEndDate(java.util.Calendar policyEndDate) {
        this.policyEndDate = policyEndDate;
    }


    /**
     * Gets the policyNo value for this AccidentPolicyLogDTO.
     * 
     * @return policyNo
     */
    public java.lang.String getPolicyNo() {
        return policyNo;
    }


    /**
     * Sets the policyNo value for this AccidentPolicyLogDTO.
     * 
     * @param policyNo
     */
    public void setPolicyNo(java.lang.String policyNo) {
        this.policyNo = policyNo;
    }


    /**
     * Gets the policyStartDate value for this AccidentPolicyLogDTO.
     * 
     * @return policyStartDate
     */
    public java.util.Calendar getPolicyStartDate() {
        return policyStartDate;
    }


    /**
     * Sets the policyStartDate value for this AccidentPolicyLogDTO.
     * 
     * @param policyStartDate
     */
    public void setPolicyStartDate(java.util.Calendar policyStartDate) {
        this.policyStartDate = policyStartDate;
    }


    /**
     * Gets the premium value for this AccidentPolicyLogDTO.
     * 
     * @return premium
     */
    public java.math.BigDecimal getPremium() {
        return premium;
    }


    /**
     * Sets the premium value for this AccidentPolicyLogDTO.
     * 
     * @param premium
     */
    public void setPremium(java.math.BigDecimal premium) {
        this.premium = premium;
    }


    /**
     * Gets the productName value for this AccidentPolicyLogDTO.
     * 
     * @return productName
     */
    public java.lang.String getProductName() {
        return productName;
    }


    /**
     * Sets the productName value for this AccidentPolicyLogDTO.
     * 
     * @param productName
     */
    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }


    /**
     * Gets the renewalMethod value for this AccidentPolicyLogDTO.
     * 
     * @return renewalMethod
     */
    public java.lang.String getRenewalMethod() {
        return renewalMethod;
    }


    /**
     * Sets the renewalMethod value for this AccidentPolicyLogDTO.
     * 
     * @param renewalMethod
     */
    public void setRenewalMethod(java.lang.String renewalMethod) {
        this.renewalMethod = renewalMethod;
    }


    /**
     * Gets the renewalTimes value for this AccidentPolicyLogDTO.
     * 
     * @return renewalTimes
     */
    public java.math.BigDecimal getRenewalTimes() {
        return renewalTimes;
    }


    /**
     * Sets the renewalTimes value for this AccidentPolicyLogDTO.
     * 
     * @param renewalTimes
     */
    public void setRenewalTimes(java.math.BigDecimal renewalTimes) {
        this.renewalTimes = renewalTimes;
    }


    /**
     * Gets the sales value for this AccidentPolicyLogDTO.
     * 
     * @return sales
     */
    public java.lang.String getSales() {
        return sales;
    }


    /**
     * Sets the sales value for this AccidentPolicyLogDTO.
     * 
     * @param sales
     */
    public void setSales(java.lang.String sales) {
        this.sales = sales;
    }


    /**
     * Gets the salesChannelCode value for this AccidentPolicyLogDTO.
     * 
     * @return salesChannelCode
     */
    public java.lang.String getSalesChannelCode() {
        return salesChannelCode;
    }


    /**
     * Sets the salesChannelCode value for this AccidentPolicyLogDTO.
     * 
     * @param salesChannelCode
     */
    public void setSalesChannelCode(java.lang.String salesChannelCode) {
        this.salesChannelCode = salesChannelCode;
    }


    /**
     * Gets the salesChannelName value for this AccidentPolicyLogDTO.
     * 
     * @return salesChannelName
     */
    public java.lang.String getSalesChannelName() {
        return salesChannelName;
    }


    /**
     * Sets the salesChannelName value for this AccidentPolicyLogDTO.
     * 
     * @param salesChannelName
     */
    public void setSalesChannelName(java.lang.String salesChannelName) {
        this.salesChannelName = salesChannelName;
    }


    /**
     * Gets the specialRemark value for this AccidentPolicyLogDTO.
     * 
     * @return specialRemark
     */
    public java.lang.String getSpecialRemark() {
        return specialRemark;
    }


    /**
     * Sets the specialRemark value for this AccidentPolicyLogDTO.
     * 
     * @param specialRemark
     */
    public void setSpecialRemark(java.lang.String specialRemark) {
        this.specialRemark = specialRemark;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccidentPolicyLogDTO)) return false;
        AccidentPolicyLogDTO other = (AccidentPolicyLogDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accidentPolicyInsuredLogDTOs==null && other.getAccidentPolicyInsuredLogDTOs()==null) || 
             (this.accidentPolicyInsuredLogDTOs!=null &&
              java.util.Arrays.equals(this.accidentPolicyInsuredLogDTOs, other.getAccidentPolicyInsuredLogDTOs()))) &&
            ((this.accidentPolicyPersonphLogDTOs==null && other.getAccidentPolicyPersonphLogDTOs()==null) || 
             (this.accidentPolicyPersonphLogDTOs!=null &&
              java.util.Arrays.equals(this.accidentPolicyPersonphLogDTOs, other.getAccidentPolicyPersonphLogDTOs()))) &&
            ((this.applicationDate==null && other.getApplicationDate()==null) || 
             (this.applicationDate!=null &&
              this.applicationDate.equals(other.getApplicationDate()))) &&
            ((this.applicationFormNo==null && other.getApplicationFormNo()==null) || 
             (this.applicationFormNo!=null &&
              this.applicationFormNo.equals(other.getApplicationFormNo()))) &&
            ((this.effectiveDate==null && other.getEffectiveDate()==null) || 
             (this.effectiveDate!=null &&
              this.effectiveDate.equals(other.getEffectiveDate()))) &&
            ((this.endorsementApplicationDate==null && other.getEndorsementApplicationDate()==null) || 
             (this.endorsementApplicationDate!=null &&
              this.endorsementApplicationDate.equals(other.getEndorsementApplicationDate()))) &&
            ((this.endorsementNo==null && other.getEndorsementNo()==null) || 
             (this.endorsementNo!=null &&
              this.endorsementNo.equals(other.getEndorsementNo()))) &&
            ((this.endorsementType==null && other.getEndorsementType()==null) || 
             (this.endorsementType!=null &&
              this.endorsementType.equals(other.getEndorsementType()))) &&
            ((this.policyEndDate==null && other.getPolicyEndDate()==null) || 
             (this.policyEndDate!=null &&
              this.policyEndDate.equals(other.getPolicyEndDate()))) &&
            ((this.policyNo==null && other.getPolicyNo()==null) || 
             (this.policyNo!=null &&
              this.policyNo.equals(other.getPolicyNo()))) &&
            ((this.policyStartDate==null && other.getPolicyStartDate()==null) || 
             (this.policyStartDate!=null &&
              this.policyStartDate.equals(other.getPolicyStartDate()))) &&
            ((this.premium==null && other.getPremium()==null) || 
             (this.premium!=null &&
              this.premium.equals(other.getPremium()))) &&
            ((this.productName==null && other.getProductName()==null) || 
             (this.productName!=null &&
              this.productName.equals(other.getProductName()))) &&
            ((this.renewalMethod==null && other.getRenewalMethod()==null) || 
             (this.renewalMethod!=null &&
              this.renewalMethod.equals(other.getRenewalMethod()))) &&
            ((this.renewalTimes==null && other.getRenewalTimes()==null) || 
             (this.renewalTimes!=null &&
              this.renewalTimes.equals(other.getRenewalTimes()))) &&
            ((this.sales==null && other.getSales()==null) || 
             (this.sales!=null &&
              this.sales.equals(other.getSales()))) &&
            ((this.salesChannelCode==null && other.getSalesChannelCode()==null) || 
             (this.salesChannelCode!=null &&
              this.salesChannelCode.equals(other.getSalesChannelCode()))) &&
            ((this.salesChannelName==null && other.getSalesChannelName()==null) || 
             (this.salesChannelName!=null &&
              this.salesChannelName.equals(other.getSalesChannelName()))) &&
            ((this.specialRemark==null && other.getSpecialRemark()==null) || 
             (this.specialRemark!=null &&
              this.specialRemark.equals(other.getSpecialRemark())));
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
        if (getAccidentPolicyInsuredLogDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccidentPolicyInsuredLogDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccidentPolicyInsuredLogDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAccidentPolicyPersonphLogDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccidentPolicyPersonphLogDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccidentPolicyPersonphLogDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getApplicationDate() != null) {
            _hashCode += getApplicationDate().hashCode();
        }
        if (getApplicationFormNo() != null) {
            _hashCode += getApplicationFormNo().hashCode();
        }
        if (getEffectiveDate() != null) {
            _hashCode += getEffectiveDate().hashCode();
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
        if (getPolicyEndDate() != null) {
            _hashCode += getPolicyEndDate().hashCode();
        }
        if (getPolicyNo() != null) {
            _hashCode += getPolicyNo().hashCode();
        }
        if (getPolicyStartDate() != null) {
            _hashCode += getPolicyStartDate().hashCode();
        }
        if (getPremium() != null) {
            _hashCode += getPremium().hashCode();
        }
        if (getProductName() != null) {
            _hashCode += getProductName().hashCode();
        }
        if (getRenewalMethod() != null) {
            _hashCode += getRenewalMethod().hashCode();
        }
        if (getRenewalTimes() != null) {
            _hashCode += getRenewalTimes().hashCode();
        }
        if (getSales() != null) {
            _hashCode += getSales().hashCode();
        }
        if (getSalesChannelCode() != null) {
            _hashCode += getSalesChannelCode().hashCode();
        }
        if (getSalesChannelName() != null) {
            _hashCode += getSalesChannelName().hashCode();
        }
        if (getSpecialRemark() != null) {
            _hashCode += getSpecialRemark().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccidentPolicyLogDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyLogDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidentPolicyInsuredLogDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidentPolicyInsuredLogDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyInsuredLogDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidentPolicyPersonphLogDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidentPolicyPersonphLogDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyPersonphLogDTO"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("effectiveDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "effectiveDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endorsementType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyEndDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyEndDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyStartDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyStartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("premium");
        elemField.setXmlName(new javax.xml.namespace.QName("", "premium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renewalMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "renewalMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renewalTimes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "renewalTimes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sales");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sales"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesChannelCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "salesChannelCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesChannelName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "salesChannelName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specialRemark");
        elemField.setXmlName(new javax.xml.namespace.QName("", "specialRemark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
