/**
 * PolicyPaymentDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class PolicyPaymentDTO  implements java.io.Serializable {
    private com.ebao.health.insurance.dto.CoveragePaymentDTO[] coveragePaymentDTOs;

    private java.lang.String customerNo;

    private java.lang.String offerStatus;

    private java.lang.String policyNo;

    private java.lang.String policySequenceNo;

    private java.math.BigDecimal totalPaymentAmount;

    private java.math.BigDecimal renewalTimes;

    public PolicyPaymentDTO() {
    }

    public PolicyPaymentDTO(
           com.ebao.health.insurance.dto.CoveragePaymentDTO[] coveragePaymentDTOs,
           java.lang.String customerNo,
           java.lang.String offerStatus,
           java.lang.String policyNo,
           java.lang.String policySequenceNo,
           java.math.BigDecimal totalPaymentAmount,
           java.math.BigDecimal renewalTimes) {
           this.coveragePaymentDTOs = coveragePaymentDTOs;
           this.customerNo = customerNo;
           this.offerStatus = offerStatus;
           this.policyNo = policyNo;
           this.policySequenceNo = policySequenceNo;
           this.totalPaymentAmount = totalPaymentAmount;
           this.renewalTimes = renewalTimes;
    }


    /**
     * Gets the coveragePaymentDTOs value for this PolicyPaymentDTO.
     * 
     * @return coveragePaymentDTOs
     */
    public com.ebao.health.insurance.dto.CoveragePaymentDTO[] getCoveragePaymentDTOs() {
        return coveragePaymentDTOs;
    }


    /**
     * Sets the coveragePaymentDTOs value for this PolicyPaymentDTO.
     * 
     * @param coveragePaymentDTOs
     */
    public void setCoveragePaymentDTOs(com.ebao.health.insurance.dto.CoveragePaymentDTO[] coveragePaymentDTOs) {
        this.coveragePaymentDTOs = coveragePaymentDTOs;
    }


    /**
     * Gets the customerNo value for this PolicyPaymentDTO.
     * 
     * @return customerNo
     */
    public java.lang.String getCustomerNo() {
        return customerNo;
    }


    /**
     * Sets the customerNo value for this PolicyPaymentDTO.
     * 
     * @param customerNo
     */
    public void setCustomerNo(java.lang.String customerNo) {
        this.customerNo = customerNo;
    }


    /**
     * Gets the offerStatus value for this PolicyPaymentDTO.
     * 
     * @return offerStatus
     */
    public java.lang.String getOfferStatus() {
        return offerStatus;
    }


    /**
     * Sets the offerStatus value for this PolicyPaymentDTO.
     * 
     * @param offerStatus
     */
    public void setOfferStatus(java.lang.String offerStatus) {
        this.offerStatus = offerStatus;
    }


    /**
     * Gets the policyNo value for this PolicyPaymentDTO.
     * 
     * @return policyNo
     */
    public java.lang.String getPolicyNo() {
        return policyNo;
    }


    /**
     * Sets the policyNo value for this PolicyPaymentDTO.
     * 
     * @param policyNo
     */
    public void setPolicyNo(java.lang.String policyNo) {
        this.policyNo = policyNo;
    }


    /**
     * Gets the policySequenceNo value for this PolicyPaymentDTO.
     * 
     * @return policySequenceNo
     */
    public java.lang.String getPolicySequenceNo() {
        return policySequenceNo;
    }


    /**
     * Sets the policySequenceNo value for this PolicyPaymentDTO.
     * 
     * @param policySequenceNo
     */
    public void setPolicySequenceNo(java.lang.String policySequenceNo) {
        this.policySequenceNo = policySequenceNo;
    }


    /**
     * Gets the totalPaymentAmount value for this PolicyPaymentDTO.
     * 
     * @return totalPaymentAmount
     */
    public java.math.BigDecimal getTotalPaymentAmount() {
        return totalPaymentAmount;
    }


    /**
     * Sets the totalPaymentAmount value for this PolicyPaymentDTO.
     * 
     * @param totalPaymentAmount
     */
    public void setTotalPaymentAmount(java.math.BigDecimal totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }


    /**
     * Gets the renewalTimes value for this PolicyPaymentDTO.
     * 
     * @return renewalTimes
     */
    public java.math.BigDecimal getRenewalTimes() {
        return renewalTimes;
    }


    /**
     * Sets the renewalTimes value for this PolicyPaymentDTO.
     * 
     * @param renewalTimes
     */
    public void setRenewalTimes(java.math.BigDecimal renewalTimes) {
        this.renewalTimes = renewalTimes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PolicyPaymentDTO)) return false;
        PolicyPaymentDTO other = (PolicyPaymentDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.coveragePaymentDTOs==null && other.getCoveragePaymentDTOs()==null) || 
             (this.coveragePaymentDTOs!=null &&
              java.util.Arrays.equals(this.coveragePaymentDTOs, other.getCoveragePaymentDTOs()))) &&
            ((this.customerNo==null && other.getCustomerNo()==null) || 
             (this.customerNo!=null &&
              this.customerNo.equals(other.getCustomerNo()))) &&
            ((this.offerStatus==null && other.getOfferStatus()==null) || 
             (this.offerStatus!=null &&
              this.offerStatus.equals(other.getOfferStatus()))) &&
            ((this.policyNo==null && other.getPolicyNo()==null) || 
             (this.policyNo!=null &&
              this.policyNo.equals(other.getPolicyNo()))) &&
            ((this.policySequenceNo==null && other.getPolicySequenceNo()==null) || 
             (this.policySequenceNo!=null &&
              this.policySequenceNo.equals(other.getPolicySequenceNo()))) &&
            ((this.totalPaymentAmount==null && other.getTotalPaymentAmount()==null) || 
             (this.totalPaymentAmount!=null &&
              this.totalPaymentAmount.equals(other.getTotalPaymentAmount()))) &&
            ((this.renewalTimes==null && other.getRenewalTimes()==null) || 
             (this.renewalTimes!=null &&
              this.renewalTimes.equals(other.getRenewalTimes())));
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
        if (getCoveragePaymentDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCoveragePaymentDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCoveragePaymentDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCustomerNo() != null) {
            _hashCode += getCustomerNo().hashCode();
        }
        if (getOfferStatus() != null) {
            _hashCode += getOfferStatus().hashCode();
        }
        if (getPolicyNo() != null) {
            _hashCode += getPolicyNo().hashCode();
        }
        if (getPolicySequenceNo() != null) {
            _hashCode += getPolicySequenceNo().hashCode();
        }
        if (getTotalPaymentAmount() != null) {
            _hashCode += getTotalPaymentAmount().hashCode();
        }
        if (getRenewalTimes() != null) {
            _hashCode += getRenewalTimes().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PolicyPaymentDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyPaymentDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coveragePaymentDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coveragePaymentDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CoveragePaymentDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offerStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "offerStatus"));
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
        elemField.setFieldName("policySequenceNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policySequenceNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalPaymentAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalPaymentAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renewalTimes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "renewalTimes"));
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
