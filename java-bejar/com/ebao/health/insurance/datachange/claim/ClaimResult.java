/**
 * ClaimResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.datachange.claim;

public class ClaimResult  implements java.io.Serializable {
    private java.lang.String claimCode;

    private java.lang.String claimNo;

    private java.lang.String errorReason;

    private java.lang.String singleResponseCode;

    public ClaimResult() {
    }

    public ClaimResult(
           java.lang.String claimCode,
           java.lang.String claimNo,
           java.lang.String errorReason,
           java.lang.String singleResponseCode) {
           this.claimCode = claimCode;
           this.claimNo = claimNo;
           this.errorReason = errorReason;
           this.singleResponseCode = singleResponseCode;
    }


    /**
     * Gets the claimCode value for this ClaimResult.
     * 
     * @return claimCode
     */
    public java.lang.String getClaimCode() {
        return claimCode;
    }


    /**
     * Sets the claimCode value for this ClaimResult.
     * 
     * @param claimCode
     */
    public void setClaimCode(java.lang.String claimCode) {
        this.claimCode = claimCode;
    }


    /**
     * Gets the claimNo value for this ClaimResult.
     * 
     * @return claimNo
     */
    public java.lang.String getClaimNo() {
        return claimNo;
    }


    /**
     * Sets the claimNo value for this ClaimResult.
     * 
     * @param claimNo
     */
    public void setClaimNo(java.lang.String claimNo) {
        this.claimNo = claimNo;
    }


    /**
     * Gets the errorReason value for this ClaimResult.
     * 
     * @return errorReason
     */
    public java.lang.String getErrorReason() {
        return errorReason;
    }


    /**
     * Sets the errorReason value for this ClaimResult.
     * 
     * @param errorReason
     */
    public void setErrorReason(java.lang.String errorReason) {
        this.errorReason = errorReason;
    }


    /**
     * Gets the singleResponseCode value for this ClaimResult.
     * 
     * @return singleResponseCode
     */
    public java.lang.String getSingleResponseCode() {
        return singleResponseCode;
    }


    /**
     * Sets the singleResponseCode value for this ClaimResult.
     * 
     * @param singleResponseCode
     */
    public void setSingleResponseCode(java.lang.String singleResponseCode) {
        this.singleResponseCode = singleResponseCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClaimResult)) return false;
        ClaimResult other = (ClaimResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.claimCode==null && other.getClaimCode()==null) || 
             (this.claimCode!=null &&
              this.claimCode.equals(other.getClaimCode()))) &&
            ((this.claimNo==null && other.getClaimNo()==null) || 
             (this.claimNo!=null &&
              this.claimNo.equals(other.getClaimNo()))) &&
            ((this.errorReason==null && other.getErrorReason()==null) || 
             (this.errorReason!=null &&
              this.errorReason.equals(other.getErrorReason()))) &&
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
        if (getClaimCode() != null) {
            _hashCode += getClaimCode().hashCode();
        }
        if (getClaimNo() != null) {
            _hashCode += getClaimNo().hashCode();
        }
        if (getErrorReason() != null) {
            _hashCode += getErrorReason().hashCode();
        }
        if (getSingleResponseCode() != null) {
            _hashCode += getSingleResponseCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClaimResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://claim.datachange.insurance.health.ebao.com", "ClaimResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimCode"));
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
        elemField.setFieldName("errorReason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errorReason"));
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
