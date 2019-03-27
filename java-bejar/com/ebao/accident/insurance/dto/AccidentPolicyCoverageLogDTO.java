/**
 * AccidentPolicyCoverageLogDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.accident.insurance.dto;

public class AccidentPolicyCoverageLogDTO  implements java.io.Serializable {
    private java.lang.String liabilityCode;

    private java.util.Calendar liabilityEffectiveDate;

    private java.util.Calendar liabilityExpireDate;

    private java.lang.String liabilityName;

    private java.math.BigDecimal liabilityPremium;

    private java.lang.String liabilityStatus;

    private java.math.BigDecimal limitAmount;

    private java.lang.String remark;

    private java.math.BigDecimal waitingPeriod;

    public AccidentPolicyCoverageLogDTO() {
    }

    public AccidentPolicyCoverageLogDTO(
           java.lang.String liabilityCode,
           java.util.Calendar liabilityEffectiveDate,
           java.util.Calendar liabilityExpireDate,
           java.lang.String liabilityName,
           java.math.BigDecimal liabilityPremium,
           java.lang.String liabilityStatus,
           java.math.BigDecimal limitAmount,
           java.lang.String remark,
           java.math.BigDecimal waitingPeriod) {
           this.liabilityCode = liabilityCode;
           this.liabilityEffectiveDate = liabilityEffectiveDate;
           this.liabilityExpireDate = liabilityExpireDate;
           this.liabilityName = liabilityName;
           this.liabilityPremium = liabilityPremium;
           this.liabilityStatus = liabilityStatus;
           this.limitAmount = limitAmount;
           this.remark = remark;
           this.waitingPeriod = waitingPeriod;
    }


    /**
     * Gets the liabilityCode value for this AccidentPolicyCoverageLogDTO.
     * 
     * @return liabilityCode
     */
    public java.lang.String getLiabilityCode() {
        return liabilityCode;
    }


    /**
     * Sets the liabilityCode value for this AccidentPolicyCoverageLogDTO.
     * 
     * @param liabilityCode
     */
    public void setLiabilityCode(java.lang.String liabilityCode) {
        this.liabilityCode = liabilityCode;
    }


    /**
     * Gets the liabilityEffectiveDate value for this AccidentPolicyCoverageLogDTO.
     * 
     * @return liabilityEffectiveDate
     */
    public java.util.Calendar getLiabilityEffectiveDate() {
        return liabilityEffectiveDate;
    }


    /**
     * Sets the liabilityEffectiveDate value for this AccidentPolicyCoverageLogDTO.
     * 
     * @param liabilityEffectiveDate
     */
    public void setLiabilityEffectiveDate(java.util.Calendar liabilityEffectiveDate) {
        this.liabilityEffectiveDate = liabilityEffectiveDate;
    }


    /**
     * Gets the liabilityExpireDate value for this AccidentPolicyCoverageLogDTO.
     * 
     * @return liabilityExpireDate
     */
    public java.util.Calendar getLiabilityExpireDate() {
        return liabilityExpireDate;
    }


    /**
     * Sets the liabilityExpireDate value for this AccidentPolicyCoverageLogDTO.
     * 
     * @param liabilityExpireDate
     */
    public void setLiabilityExpireDate(java.util.Calendar liabilityExpireDate) {
        this.liabilityExpireDate = liabilityExpireDate;
    }


    /**
     * Gets the liabilityName value for this AccidentPolicyCoverageLogDTO.
     * 
     * @return liabilityName
     */
    public java.lang.String getLiabilityName() {
        return liabilityName;
    }


    /**
     * Sets the liabilityName value for this AccidentPolicyCoverageLogDTO.
     * 
     * @param liabilityName
     */
    public void setLiabilityName(java.lang.String liabilityName) {
        this.liabilityName = liabilityName;
    }


    /**
     * Gets the liabilityPremium value for this AccidentPolicyCoverageLogDTO.
     * 
     * @return liabilityPremium
     */
    public java.math.BigDecimal getLiabilityPremium() {
        return liabilityPremium;
    }


    /**
     * Sets the liabilityPremium value for this AccidentPolicyCoverageLogDTO.
     * 
     * @param liabilityPremium
     */
    public void setLiabilityPremium(java.math.BigDecimal liabilityPremium) {
        this.liabilityPremium = liabilityPremium;
    }


    /**
     * Gets the liabilityStatus value for this AccidentPolicyCoverageLogDTO.
     * 
     * @return liabilityStatus
     */
    public java.lang.String getLiabilityStatus() {
        return liabilityStatus;
    }


    /**
     * Sets the liabilityStatus value for this AccidentPolicyCoverageLogDTO.
     * 
     * @param liabilityStatus
     */
    public void setLiabilityStatus(java.lang.String liabilityStatus) {
        this.liabilityStatus = liabilityStatus;
    }


    /**
     * Gets the limitAmount value for this AccidentPolicyCoverageLogDTO.
     * 
     * @return limitAmount
     */
    public java.math.BigDecimal getLimitAmount() {
        return limitAmount;
    }


    /**
     * Sets the limitAmount value for this AccidentPolicyCoverageLogDTO.
     * 
     * @param limitAmount
     */
    public void setLimitAmount(java.math.BigDecimal limitAmount) {
        this.limitAmount = limitAmount;
    }


    /**
     * Gets the remark value for this AccidentPolicyCoverageLogDTO.
     * 
     * @return remark
     */
    public java.lang.String getRemark() {
        return remark;
    }


    /**
     * Sets the remark value for this AccidentPolicyCoverageLogDTO.
     * 
     * @param remark
     */
    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }


    /**
     * Gets the waitingPeriod value for this AccidentPolicyCoverageLogDTO.
     * 
     * @return waitingPeriod
     */
    public java.math.BigDecimal getWaitingPeriod() {
        return waitingPeriod;
    }


    /**
     * Sets the waitingPeriod value for this AccidentPolicyCoverageLogDTO.
     * 
     * @param waitingPeriod
     */
    public void setWaitingPeriod(java.math.BigDecimal waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccidentPolicyCoverageLogDTO)) return false;
        AccidentPolicyCoverageLogDTO other = (AccidentPolicyCoverageLogDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.liabilityCode==null && other.getLiabilityCode()==null) || 
             (this.liabilityCode!=null &&
              this.liabilityCode.equals(other.getLiabilityCode()))) &&
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
            ((this.remark==null && other.getRemark()==null) || 
             (this.remark!=null &&
              this.remark.equals(other.getRemark()))) &&
            ((this.waitingPeriod==null && other.getWaitingPeriod()==null) || 
             (this.waitingPeriod!=null &&
              this.waitingPeriod.equals(other.getWaitingPeriod())));
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
        if (getLiabilityCode() != null) {
            _hashCode += getLiabilityCode().hashCode();
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
        if (getRemark() != null) {
            _hashCode += getRemark().hashCode();
        }
        if (getWaitingPeriod() != null) {
            _hashCode += getWaitingPeriod().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccidentPolicyCoverageLogDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyCoverageLogDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liabilityCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liabilityCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liabilityPremium");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liabilityPremium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liabilityStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liabilityStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limitAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "limitAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remark");
        elemField.setXmlName(new javax.xml.namespace.QName("", "remark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("waitingPeriod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "waitingPeriod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
