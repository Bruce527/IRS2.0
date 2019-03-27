/**
 * PolicyAmountLogDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class PolicyAmountLogDTO  implements java.io.Serializable {
    private java.math.BigDecimal claimRatio;

    private java.math.BigDecimal costend;

    private java.math.BigDecimal coststart;

    private java.math.BigDecimal deductible;

    private java.lang.String sectionNo;

    public PolicyAmountLogDTO() {
    }

    public PolicyAmountLogDTO(
           java.math.BigDecimal claimRatio,
           java.math.BigDecimal costend,
           java.math.BigDecimal coststart,
           java.math.BigDecimal deductible,
           java.lang.String sectionNo) {
           this.claimRatio = claimRatio;
           this.costend = costend;
           this.coststart = coststart;
           this.deductible = deductible;
           this.sectionNo = sectionNo;
    }


    /**
     * Gets the claimRatio value for this PolicyAmountLogDTO.
     * 
     * @return claimRatio
     */
    public java.math.BigDecimal getClaimRatio() {
        return claimRatio;
    }


    /**
     * Sets the claimRatio value for this PolicyAmountLogDTO.
     * 
     * @param claimRatio
     */
    public void setClaimRatio(java.math.BigDecimal claimRatio) {
        this.claimRatio = claimRatio;
    }


    /**
     * Gets the costend value for this PolicyAmountLogDTO.
     * 
     * @return costend
     */
    public java.math.BigDecimal getCostend() {
        return costend;
    }


    /**
     * Sets the costend value for this PolicyAmountLogDTO.
     * 
     * @param costend
     */
    public void setCostend(java.math.BigDecimal costend) {
        this.costend = costend;
    }


    /**
     * Gets the coststart value for this PolicyAmountLogDTO.
     * 
     * @return coststart
     */
    public java.math.BigDecimal getCoststart() {
        return coststart;
    }


    /**
     * Sets the coststart value for this PolicyAmountLogDTO.
     * 
     * @param coststart
     */
    public void setCoststart(java.math.BigDecimal coststart) {
        this.coststart = coststart;
    }


    /**
     * Gets the deductible value for this PolicyAmountLogDTO.
     * 
     * @return deductible
     */
    public java.math.BigDecimal getDeductible() {
        return deductible;
    }


    /**
     * Sets the deductible value for this PolicyAmountLogDTO.
     * 
     * @param deductible
     */
    public void setDeductible(java.math.BigDecimal deductible) {
        this.deductible = deductible;
    }


    /**
     * Gets the sectionNo value for this PolicyAmountLogDTO.
     * 
     * @return sectionNo
     */
    public java.lang.String getSectionNo() {
        return sectionNo;
    }


    /**
     * Sets the sectionNo value for this PolicyAmountLogDTO.
     * 
     * @param sectionNo
     */
    public void setSectionNo(java.lang.String sectionNo) {
        this.sectionNo = sectionNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PolicyAmountLogDTO)) return false;
        PolicyAmountLogDTO other = (PolicyAmountLogDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.claimRatio==null && other.getClaimRatio()==null) || 
             (this.claimRatio!=null &&
              this.claimRatio.equals(other.getClaimRatio()))) &&
            ((this.costend==null && other.getCostend()==null) || 
             (this.costend!=null &&
              this.costend.equals(other.getCostend()))) &&
            ((this.coststart==null && other.getCoststart()==null) || 
             (this.coststart!=null &&
              this.coststart.equals(other.getCoststart()))) &&
            ((this.deductible==null && other.getDeductible()==null) || 
             (this.deductible!=null &&
              this.deductible.equals(other.getDeductible()))) &&
            ((this.sectionNo==null && other.getSectionNo()==null) || 
             (this.sectionNo!=null &&
              this.sectionNo.equals(other.getSectionNo())));
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
        if (getClaimRatio() != null) {
            _hashCode += getClaimRatio().hashCode();
        }
        if (getCostend() != null) {
            _hashCode += getCostend().hashCode();
        }
        if (getCoststart() != null) {
            _hashCode += getCoststart().hashCode();
        }
        if (getDeductible() != null) {
            _hashCode += getDeductible().hashCode();
        }
        if (getSectionNo() != null) {
            _hashCode += getSectionNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PolicyAmountLogDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyAmountLogDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimRatio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimRatio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costend");
        elemField.setXmlName(new javax.xml.namespace.QName("", "costend"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coststart");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coststart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deductible");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deductible"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sectionNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sectionNo"));
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
