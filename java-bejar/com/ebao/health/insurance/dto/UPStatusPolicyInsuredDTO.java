/**
 * UPStatusPolicyInsuredDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class UPStatusPolicyInsuredDTO  implements java.io.Serializable {
    private com.ebao.health.insurance.dto.UPStatusSpecialUpCoverageDTO[] UPStatusSpecialUpCoverageDTOs;

    private java.lang.String customerNo;

    private java.lang.String offerStatus;

    private java.util.Calendar subEndDate;

    public UPStatusPolicyInsuredDTO() {
    }

    public UPStatusPolicyInsuredDTO(
           com.ebao.health.insurance.dto.UPStatusSpecialUpCoverageDTO[] UPStatusSpecialUpCoverageDTOs,
           java.lang.String customerNo,
           java.lang.String offerStatus,
           java.util.Calendar subEndDate) {
           this.UPStatusSpecialUpCoverageDTOs = UPStatusSpecialUpCoverageDTOs;
           this.customerNo = customerNo;
           this.offerStatus = offerStatus;
           this.subEndDate = subEndDate;
    }


    /**
     * Gets the UPStatusSpecialUpCoverageDTOs value for this UPStatusPolicyInsuredDTO.
     * 
     * @return UPStatusSpecialUpCoverageDTOs
     */
    public com.ebao.health.insurance.dto.UPStatusSpecialUpCoverageDTO[] getUPStatusSpecialUpCoverageDTOs() {
        return UPStatusSpecialUpCoverageDTOs;
    }


    /**
     * Sets the UPStatusSpecialUpCoverageDTOs value for this UPStatusPolicyInsuredDTO.
     * 
     * @param UPStatusSpecialUpCoverageDTOs
     */
    public void setUPStatusSpecialUpCoverageDTOs(com.ebao.health.insurance.dto.UPStatusSpecialUpCoverageDTO[] UPStatusSpecialUpCoverageDTOs) {
        this.UPStatusSpecialUpCoverageDTOs = UPStatusSpecialUpCoverageDTOs;
    }


    /**
     * Gets the customerNo value for this UPStatusPolicyInsuredDTO.
     * 
     * @return customerNo
     */
    public java.lang.String getCustomerNo() {
        return customerNo;
    }


    /**
     * Sets the customerNo value for this UPStatusPolicyInsuredDTO.
     * 
     * @param customerNo
     */
    public void setCustomerNo(java.lang.String customerNo) {
        this.customerNo = customerNo;
    }


    /**
     * Gets the offerStatus value for this UPStatusPolicyInsuredDTO.
     * 
     * @return offerStatus
     */
    public java.lang.String getOfferStatus() {
        return offerStatus;
    }


    /**
     * Sets the offerStatus value for this UPStatusPolicyInsuredDTO.
     * 
     * @param offerStatus
     */
    public void setOfferStatus(java.lang.String offerStatus) {
        this.offerStatus = offerStatus;
    }


    /**
     * Gets the subEndDate value for this UPStatusPolicyInsuredDTO.
     * 
     * @return subEndDate
     */
    public java.util.Calendar getSubEndDate() {
        return subEndDate;
    }


    /**
     * Sets the subEndDate value for this UPStatusPolicyInsuredDTO.
     * 
     * @param subEndDate
     */
    public void setSubEndDate(java.util.Calendar subEndDate) {
        this.subEndDate = subEndDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UPStatusPolicyInsuredDTO)) return false;
        UPStatusPolicyInsuredDTO other = (UPStatusPolicyInsuredDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.UPStatusSpecialUpCoverageDTOs==null && other.getUPStatusSpecialUpCoverageDTOs()==null) || 
             (this.UPStatusSpecialUpCoverageDTOs!=null &&
              java.util.Arrays.equals(this.UPStatusSpecialUpCoverageDTOs, other.getUPStatusSpecialUpCoverageDTOs()))) &&
            ((this.customerNo==null && other.getCustomerNo()==null) || 
             (this.customerNo!=null &&
              this.customerNo.equals(other.getCustomerNo()))) &&
            ((this.offerStatus==null && other.getOfferStatus()==null) || 
             (this.offerStatus!=null &&
              this.offerStatus.equals(other.getOfferStatus()))) &&
            ((this.subEndDate==null && other.getSubEndDate()==null) || 
             (this.subEndDate!=null &&
              this.subEndDate.equals(other.getSubEndDate())));
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
        if (getUPStatusSpecialUpCoverageDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUPStatusSpecialUpCoverageDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUPStatusSpecialUpCoverageDTOs(), i);
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
        if (getSubEndDate() != null) {
            _hashCode += getSubEndDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UPStatusPolicyInsuredDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusPolicyInsuredDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UPStatusSpecialUpCoverageDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "UPStatusSpecialUpCoverageDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusSpecialUpCoverageDTO"));
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
        elemField.setFieldName("subEndDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subEndDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
