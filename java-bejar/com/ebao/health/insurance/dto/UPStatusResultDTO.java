/**
 * UPStatusResultDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class UPStatusResultDTO  implements java.io.Serializable {
    private java.lang.String errorReason;

    private java.lang.String policyNo;

    private java.lang.String policyStatusUpdateType;

    private java.lang.String singleResponseCode;

    public UPStatusResultDTO() {
    }

    public UPStatusResultDTO(
           java.lang.String errorReason,
           java.lang.String policyNo,
           java.lang.String policyStatusUpdateType,
           java.lang.String singleResponseCode) {
           this.errorReason = errorReason;
           this.policyNo = policyNo;
           this.policyStatusUpdateType = policyStatusUpdateType;
           this.singleResponseCode = singleResponseCode;
    }


    /**
     * Gets the errorReason value for this UPStatusResultDTO.
     * 
     * @return errorReason
     */
    public java.lang.String getErrorReason() {
        return errorReason;
    }


    /**
     * Sets the errorReason value for this UPStatusResultDTO.
     * 
     * @param errorReason
     */
    public void setErrorReason(java.lang.String errorReason) {
        this.errorReason = errorReason;
    }


    /**
     * Gets the policyNo value for this UPStatusResultDTO.
     * 
     * @return policyNo
     */
    public java.lang.String getPolicyNo() {
        return policyNo;
    }


    /**
     * Sets the policyNo value for this UPStatusResultDTO.
     * 
     * @param policyNo
     */
    public void setPolicyNo(java.lang.String policyNo) {
        this.policyNo = policyNo;
    }


    /**
     * Gets the policyStatusUpdateType value for this UPStatusResultDTO.
     * 
     * @return policyStatusUpdateType
     */
    public java.lang.String getPolicyStatusUpdateType() {
        return policyStatusUpdateType;
    }


    /**
     * Sets the policyStatusUpdateType value for this UPStatusResultDTO.
     * 
     * @param policyStatusUpdateType
     */
    public void setPolicyStatusUpdateType(java.lang.String policyStatusUpdateType) {
        this.policyStatusUpdateType = policyStatusUpdateType;
    }


    /**
     * Gets the singleResponseCode value for this UPStatusResultDTO.
     * 
     * @return singleResponseCode
     */
    public java.lang.String getSingleResponseCode() {
        return singleResponseCode;
    }


    /**
     * Sets the singleResponseCode value for this UPStatusResultDTO.
     * 
     * @param singleResponseCode
     */
    public void setSingleResponseCode(java.lang.String singleResponseCode) {
        this.singleResponseCode = singleResponseCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UPStatusResultDTO)) return false;
        UPStatusResultDTO other = (UPStatusResultDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.errorReason==null && other.getErrorReason()==null) || 
             (this.errorReason!=null &&
              this.errorReason.equals(other.getErrorReason()))) &&
            ((this.policyNo==null && other.getPolicyNo()==null) || 
             (this.policyNo!=null &&
              this.policyNo.equals(other.getPolicyNo()))) &&
            ((this.policyStatusUpdateType==null && other.getPolicyStatusUpdateType()==null) || 
             (this.policyStatusUpdateType!=null &&
              this.policyStatusUpdateType.equals(other.getPolicyStatusUpdateType()))) &&
            ((this.singleResponseCode==null && other.getSingleResponseCode()==null) || 
             (this.singleResponseCode!=null &&
              this.singleResponseCode.equals(other.getSingleResponseCode())));
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
        if (getErrorReason() != null) {
            _hashCode += getErrorReason().hashCode();
        }
        if (getPolicyNo() != null) {
            _hashCode += getPolicyNo().hashCode();
        }
        if (getPolicyStatusUpdateType() != null) {
            _hashCode += getPolicyStatusUpdateType().hashCode();
        }
        if (getSingleResponseCode() != null) {
            _hashCode += getSingleResponseCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UPStatusResultDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusResultDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorReason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errorReason"));
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
        elemField.setFieldName("policyStatusUpdateType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyStatusUpdateType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("singleResponseCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "singleResponseCode"));
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
