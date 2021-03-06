/**
 * PolicyCoverageDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class PolicyCoverageDTO  implements java.io.Serializable {
    private java.math.BigDecimal effectivelyAmount;

    private java.lang.String groupName;

    private java.lang.String insuredGroupCode;

    private java.lang.String liabilityClassification;

    private java.lang.String liabilityCode;

    private java.math.BigDecimal liabilityCurrentPremium;

    private java.util.Calendar liabilityEffectiveDate;

    private java.util.Calendar liabilityExpireDate;

    private java.lang.String liabilityName;

    private java.math.BigDecimal liabilityPremium;

    private java.lang.String liabilityStatus;

    private java.math.BigDecimal limitAmount;

    private com.ebao.health.insurance.dto.PolicyAmountDTO[] policyAmountDTOs;

    private java.math.BigDecimal waitingPeriod;

    private java.math.BigDecimal liabilityDayAmount;

    private java.math.BigDecimal liabilitydayEffectiveAmount;

    public PolicyCoverageDTO() {
    }

    public PolicyCoverageDTO(
           java.math.BigDecimal effectivelyAmount,
           java.lang.String groupName,
           java.lang.String insuredGroupCode,
           java.lang.String liabilityClassification,
           java.lang.String liabilityCode,
           java.math.BigDecimal liabilityCurrentPremium,
           java.util.Calendar liabilityEffectiveDate,
           java.util.Calendar liabilityExpireDate,
           java.lang.String liabilityName,
           java.math.BigDecimal liabilityPremium,
           java.lang.String liabilityStatus,
           java.math.BigDecimal limitAmount,
           com.ebao.health.insurance.dto.PolicyAmountDTO[] policyAmountDTOs,
           java.math.BigDecimal waitingPeriod,
           java.math.BigDecimal liabilityDayAmount,
           java.math.BigDecimal liabilitydayEffectiveAmount) {
           this.effectivelyAmount = effectivelyAmount;
           this.groupName = groupName;
           this.insuredGroupCode = insuredGroupCode;
           this.liabilityClassification = liabilityClassification;
           this.liabilityCode = liabilityCode;
           this.liabilityCurrentPremium = liabilityCurrentPremium;
           this.liabilityEffectiveDate = liabilityEffectiveDate;
           this.liabilityExpireDate = liabilityExpireDate;
           this.liabilityName = liabilityName;
           this.liabilityPremium = liabilityPremium;
           this.liabilityStatus = liabilityStatus;
           this.limitAmount = limitAmount;
           this.policyAmountDTOs = policyAmountDTOs;
           this.waitingPeriod = waitingPeriod;
           this.liabilityDayAmount = liabilityDayAmount;
           this.liabilitydayEffectiveAmount = liabilitydayEffectiveAmount;
    }


    /**
     * Gets the effectivelyAmount value for this PolicyCoverageDTO.
     * 
     * @return effectivelyAmount
     */
    public java.math.BigDecimal getEffectivelyAmount() {
        return effectivelyAmount;
    }


    /**
     * Sets the effectivelyAmount value for this PolicyCoverageDTO.
     * 
     * @param effectivelyAmount
     */
    public void setEffectivelyAmount(java.math.BigDecimal effectivelyAmount) {
        this.effectivelyAmount = effectivelyAmount;
    }


    /**
     * Gets the groupName value for this PolicyCoverageDTO.
     * 
     * @return groupName
     */
    public java.lang.String getGroupName() {
        return groupName;
    }


    /**
     * Sets the groupName value for this PolicyCoverageDTO.
     * 
     * @param groupName
     */
    public void setGroupName(java.lang.String groupName) {
        this.groupName = groupName;
    }


    /**
     * Gets the insuredGroupCode value for this PolicyCoverageDTO.
     * 
     * @return insuredGroupCode
     */
    public java.lang.String getInsuredGroupCode() {
        return insuredGroupCode;
    }


    /**
     * Sets the insuredGroupCode value for this PolicyCoverageDTO.
     * 
     * @param insuredGroupCode
     */
    public void setInsuredGroupCode(java.lang.String insuredGroupCode) {
        this.insuredGroupCode = insuredGroupCode;
    }


    /**
     * Gets the liabilityClassification value for this PolicyCoverageDTO.
     * 
     * @return liabilityClassification
     */
    public java.lang.String getLiabilityClassification() {
        return liabilityClassification;
    }


    /**
     * Sets the liabilityClassification value for this PolicyCoverageDTO.
     * 
     * @param liabilityClassification
     */
    public void setLiabilityClassification(java.lang.String liabilityClassification) {
        this.liabilityClassification = liabilityClassification;
    }


    /**
     * Gets the liabilityCode value for this PolicyCoverageDTO.
     * 
     * @return liabilityCode
     */
    public java.lang.String getLiabilityCode() {
        return liabilityCode;
    }


    /**
     * Sets the liabilityCode value for this PolicyCoverageDTO.
     * 
     * @param liabilityCode
     */
    public void setLiabilityCode(java.lang.String liabilityCode) {
        this.liabilityCode = liabilityCode;
    }


    /**
     * Gets the liabilityCurrentPremium value for this PolicyCoverageDTO.
     * 
     * @return liabilityCurrentPremium
     */
    public java.math.BigDecimal getLiabilityCurrentPremium() {
        return liabilityCurrentPremium;
    }


    /**
     * Sets the liabilityCurrentPremium value for this PolicyCoverageDTO.
     * 
     * @param liabilityCurrentPremium
     */
    public void setLiabilityCurrentPremium(java.math.BigDecimal liabilityCurrentPremium) {
        this.liabilityCurrentPremium = liabilityCurrentPremium;
    }


    /**
     * Gets the liabilityEffectiveDate value for this PolicyCoverageDTO.
     * 
     * @return liabilityEffectiveDate
     */
    public java.util.Calendar getLiabilityEffectiveDate() {
        return liabilityEffectiveDate;
    }


    /**
     * Sets the liabilityEffectiveDate value for this PolicyCoverageDTO.
     * 
     * @param liabilityEffectiveDate
     */
    public void setLiabilityEffectiveDate(java.util.Calendar liabilityEffectiveDate) {
        this.liabilityEffectiveDate = liabilityEffectiveDate;
    }


    /**
     * Gets the liabilityExpireDate value for this PolicyCoverageDTO.
     * 
     * @return liabilityExpireDate
     */
    public java.util.Calendar getLiabilityExpireDate() {
        return liabilityExpireDate;
    }


    /**
     * Sets the liabilityExpireDate value for this PolicyCoverageDTO.
     * 
     * @param liabilityExpireDate
     */
    public void setLiabilityExpireDate(java.util.Calendar liabilityExpireDate) {
        this.liabilityExpireDate = liabilityExpireDate;
    }


    /**
     * Gets the liabilityName value for this PolicyCoverageDTO.
     * 
     * @return liabilityName
     */
    public java.lang.String getLiabilityName() {
        return liabilityName;
    }


    /**
     * Sets the liabilityName value for this PolicyCoverageDTO.
     * 
     * @param liabilityName
     */
    public void setLiabilityName(java.lang.String liabilityName) {
        this.liabilityName = liabilityName;
    }


    /**
     * Gets the liabilityPremium value for this PolicyCoverageDTO.
     * 
     * @return liabilityPremium
     */
    public java.math.BigDecimal getLiabilityPremium() {
        return liabilityPremium;
    }


    /**
     * Sets the liabilityPremium value for this PolicyCoverageDTO.
     * 
     * @param liabilityPremium
     */
    public void setLiabilityPremium(java.math.BigDecimal liabilityPremium) {
        this.liabilityPremium = liabilityPremium;
    }


    /**
     * Gets the liabilityStatus value for this PolicyCoverageDTO.
     * 
     * @return liabilityStatus
     */
    public java.lang.String getLiabilityStatus() {
        return liabilityStatus;
    }


    /**
     * Sets the liabilityStatus value for this PolicyCoverageDTO.
     * 
     * @param liabilityStatus
     */
    public void setLiabilityStatus(java.lang.String liabilityStatus) {
        this.liabilityStatus = liabilityStatus;
    }


    /**
     * Gets the limitAmount value for this PolicyCoverageDTO.
     * 
     * @return limitAmount
     */
    public java.math.BigDecimal getLimitAmount() {
        return limitAmount;
    }


    /**
     * Sets the limitAmount value for this PolicyCoverageDTO.
     * 
     * @param limitAmount
     */
    public void setLimitAmount(java.math.BigDecimal limitAmount) {
        this.limitAmount = limitAmount;
    }


    /**
     * Gets the policyAmountDTOs value for this PolicyCoverageDTO.
     * 
     * @return policyAmountDTOs
     */
    public com.ebao.health.insurance.dto.PolicyAmountDTO[] getPolicyAmountDTOs() {
        return policyAmountDTOs;
    }


    /**
     * Sets the policyAmountDTOs value for this PolicyCoverageDTO.
     * 
     * @param policyAmountDTOs
     */
    public void setPolicyAmountDTOs(com.ebao.health.insurance.dto.PolicyAmountDTO[] policyAmountDTOs) {
        this.policyAmountDTOs = policyAmountDTOs;
    }


    /**
     * Gets the waitingPeriod value for this PolicyCoverageDTO.
     * 
     * @return waitingPeriod
     */
    public java.math.BigDecimal getWaitingPeriod() {
        return waitingPeriod;
    }


    /**
     * Sets the waitingPeriod value for this PolicyCoverageDTO.
     * 
     * @param waitingPeriod
     */
    public void setWaitingPeriod(java.math.BigDecimal waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }


    /**
     * Gets the liabilityDayAmount value for this PolicyCoverageDTO.
     * 
     * @return liabilityDayAmount
     */
    public java.math.BigDecimal getLiabilityDayAmount() {
        return liabilityDayAmount;
    }


    /**
     * Sets the liabilityDayAmount value for this PolicyCoverageDTO.
     * 
     * @param liabilityDayAmount
     */
    public void setLiabilityDayAmount(java.math.BigDecimal liabilityDayAmount) {
        this.liabilityDayAmount = liabilityDayAmount;
    }


    /**
     * Gets the liabilitydayEffectiveAmount value for this PolicyCoverageDTO.
     * 
     * @return liabilitydayEffectiveAmount
     */
    public java.math.BigDecimal getLiabilitydayEffectiveAmount() {
        return liabilitydayEffectiveAmount;
    }


    /**
     * Sets the liabilitydayEffectiveAmount value for this PolicyCoverageDTO.
     * 
     * @param liabilitydayEffectiveAmount
     */
    public void setLiabilitydayEffectiveAmount(java.math.BigDecimal liabilitydayEffectiveAmount) {
        this.liabilitydayEffectiveAmount = liabilitydayEffectiveAmount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PolicyCoverageDTO)) return false;
        PolicyCoverageDTO other = (PolicyCoverageDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.effectivelyAmount==null && other.getEffectivelyAmount()==null) || 
             (this.effectivelyAmount!=null &&
              this.effectivelyAmount.equals(other.getEffectivelyAmount()))) &&
            ((this.groupName==null && other.getGroupName()==null) || 
             (this.groupName!=null &&
              this.groupName.equals(other.getGroupName()))) &&
            ((this.insuredGroupCode==null && other.getInsuredGroupCode()==null) || 
             (this.insuredGroupCode!=null &&
              this.insuredGroupCode.equals(other.getInsuredGroupCode()))) &&
            ((this.liabilityClassification==null && other.getLiabilityClassification()==null) || 
             (this.liabilityClassification!=null &&
              this.liabilityClassification.equals(other.getLiabilityClassification()))) &&
            ((this.liabilityCode==null && other.getLiabilityCode()==null) || 
             (this.liabilityCode!=null &&
              this.liabilityCode.equals(other.getLiabilityCode()))) &&
            ((this.liabilityCurrentPremium==null && other.getLiabilityCurrentPremium()==null) || 
             (this.liabilityCurrentPremium!=null &&
              this.liabilityCurrentPremium.equals(other.getLiabilityCurrentPremium()))) &&
            ((this.liabilityEffectiveDate==null && other.getLiabilityEffectiveDate()==null) || 
             (this.liabilityEffectiveDate!=null &&
              this.liabilityEffectiveDate.equals(other.getLiabilityEffectiveDate()))) &&
            ((this.liabilityExpireDate==null && other.getLiabilityExpireDate()==null) || 
             (this.liabilityExpireDate!=null &&
              this.liabilityExpireDate.equals(other.getLiabilityExpireDate()))) &&
            ((this.liabilityName==null && other.getLiabilityName()==null) || 
             (this.liabilityName!=null &&
              this.liabilityName.equals(other.getLiabilityName()))) &&
            ((this.liabilityPremium==null && other.getLiabilityPremium()==null) || 
             (this.liabilityPremium!=null &&
              this.liabilityPremium.equals(other.getLiabilityPremium()))) &&
            ((this.liabilityStatus==null && other.getLiabilityStatus()==null) || 
             (this.liabilityStatus!=null &&
              this.liabilityStatus.equals(other.getLiabilityStatus()))) &&
            ((this.limitAmount==null && other.getLimitAmount()==null) || 
             (this.limitAmount!=null &&
              this.limitAmount.equals(other.getLimitAmount()))) &&
            ((this.policyAmountDTOs==null && other.getPolicyAmountDTOs()==null) || 
             (this.policyAmountDTOs!=null &&
              java.util.Arrays.equals(this.policyAmountDTOs, other.getPolicyAmountDTOs()))) &&
            ((this.waitingPeriod==null && other.getWaitingPeriod()==null) || 
             (this.waitingPeriod!=null &&
              this.waitingPeriod.equals(other.getWaitingPeriod()))) &&
            ((this.liabilityDayAmount==null && other.getLiabilityDayAmount()==null) || 
             (this.liabilityDayAmount!=null &&
              this.liabilityDayAmount.equals(other.getLiabilityDayAmount()))) &&
            ((this.liabilitydayEffectiveAmount==null && other.getLiabilitydayEffectiveAmount()==null) || 
             (this.liabilitydayEffectiveAmount!=null &&
              this.liabilitydayEffectiveAmount.equals(other.getLiabilitydayEffectiveAmount())));
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
        if (getEffectivelyAmount() != null) {
            _hashCode += getEffectivelyAmount().hashCode();
        }
        if (getGroupName() != null) {
            _hashCode += getGroupName().hashCode();
        }
        if (getInsuredGroupCode() != null) {
            _hashCode += getInsuredGroupCode().hashCode();
        }
        if (getLiabilityClassification() != null) {
            _hashCode += getLiabilityClassification().hashCode();
        }
        if (getLiabilityCode() != null) {
            _hashCode += getLiabilityCode().hashCode();
        }
        if (getLiabilityCurrentPremium() != null) {
            _hashCode += getLiabilityCurrentPremium().hashCode();
        }
        if (getLiabilityEffectiveDate() != null) {
            _hashCode += getLiabilityEffectiveDate().hashCode();
        }
        if (getLiabilityExpireDate() != null) {
            _hashCode += getLiabilityExpireDate().hashCode();
        }
        if (getLiabilityName() != null) {
            _hashCode += getLiabilityName().hashCode();
        }
        if (getLiabilityPremium() != null) {
            _hashCode += getLiabilityPremium().hashCode();
        }
        if (getLiabilityStatus() != null) {
            _hashCode += getLiabilityStatus().hashCode();
        }
        if (getLimitAmount() != null) {
            _hashCode += getLimitAmount().hashCode();
        }
        if (getPolicyAmountDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPolicyAmountDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPolicyAmountDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getWaitingPeriod() != null) {
            _hashCode += getWaitingPeriod().hashCode();
        }
        if (getLiabilityDayAmount() != null) {
            _hashCode += getLiabilityDayAmount().hashCode();
        }
        if (getLiabilitydayEffectiveAmount() != null) {
            _hashCode += getLiabilitydayEffectiveAmount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PolicyCoverageDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyCoverageDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("effectivelyAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "effectivelyAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuredGroupCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insuredGroupCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liabilityClassification");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liabilityClassification"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liabilityCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liabilityCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liabilityCurrentPremium");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liabilityCurrentPremium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liabilityEffectiveDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liabilityEffectiveDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liabilityExpireDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liabilityExpireDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liabilityName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liabilityName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liabilityPremium");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liabilityPremium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liabilityStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liabilityStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limitAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "limitAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyAmountDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyAmountDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyAmountDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("waitingPeriod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "waitingPeriod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liabilityDayAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liabilityDayAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liabilitydayEffectiveAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liabilitydayEffectiveAmount"));
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
