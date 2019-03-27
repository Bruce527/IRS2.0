/**
 * PolicyLogResultItemDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class PolicyLogResultItemDTO  implements java.io.Serializable {
    private java.lang.String endorsementNo;

    private java.lang.String endorsementSequenceNo;

    private java.lang.String endorsementType;

    private java.lang.String errorReason;

    private java.lang.String policyNo;

    private java.lang.String singleResponseCode;

    public PolicyLogResultItemDTO() {
    }

    public PolicyLogResultItemDTO(
           java.lang.String endorsementNo,
           java.lang.String endorsementSequenceNo,
           java.lang.String endorsementType,
           java.lang.String errorReason,
           java.lang.String policyNo,
           java.lang.String singleResponseCode) {
           this.endorsementNo = endorsementNo;
           this.endorsementSequenceNo = endorsementSequenceNo;
           this.endorsementType = endorsementType;
           this.errorReason = errorReason;
           this.policyNo = policyNo;
           this.singleResponseCode = singleResponseCode;
    }


    /**
     * Gets the endorsementNo value for this PolicyLogResultItemDTO.
     * 
     * @return endorsementNo
     */
    public java.lang.String getEndorsementNo() {
        return endorsementNo;
    }


    /**
     * Sets the endorsementNo value for this PolicyLogResultItemDTO.
     * 
     * @param endorsementNo
     */
    public void setEndorsementNo(java.lang.String endorsementNo) {
        this.endorsementNo = endorsementNo;
    }


    /**
     * Gets the endorsementSequenceNo value for this PolicyLogResultItemDTO.
     * 
     * @return endorsementSequenceNo
     */
    public java.lang.String getEndorsementSequenceNo() {
        return endorsementSequenceNo;
    }


    /**
     * Sets the endorsementSequenceNo value for this PolicyLogResultItemDTO.
     * 
     * @param endorsementSequenceNo
     */
    public void setEndorsementSequenceNo(java.lang.String endorsementSequenceNo) {
        this.endorsementSequenceNo = endorsementSequenceNo;
    }


    /**
     * Gets the endorsementType value for this PolicyLogResultItemDTO.
     * 
     * @return endorsementType
     */
    public java.lang.String getEndorsementType() {
        return endorsementType;
    }


    /**
     * Sets the endorsementType value for this PolicyLogResultItemDTO.
     * 
     * @param endorsementType
     */
    public void setEndorsementType(java.lang.String endorsementType) {
        this.endorsementType = endorsementType;
    }


    /**
     * Gets the errorReason value for this PolicyLogResultItemDTO.
     * 
     * @return errorReason
     */
    public java.lang.String getErrorReason() {
        return errorReason;
    }


    /**
     * Sets the errorReason value for this PolicyLogResultItemDTO.
     * 
     * @param errorReason
     */
    public void setErrorReason(java.lang.String errorReason) {
        this.errorReason = errorReason;
    }


    /**
     * Gets the policyNo value for this PolicyLogResultItemDTO.
     * 
     * @return policyNo
     */
    public java.lang.String getPolicyNo() {
        return policyNo;
    }


    /**
     * Sets the policyNo value for this PolicyLogResultItemDTO.
     * 
     * @param policyNo
     */
    public void setPolicyNo(java.lang.String policyNo) {
        this.policyNo = policyNo;
    }


    /**
     * Gets the singleResponseCode value for this PolicyLogResultItemDTO.
     * 
     * @return singleResponseCode
     */
    public java.lang.String getSingleResponseCode() {
        return singleResponseCode;
    }


    /**
     * Sets the singleResponseCode value for this PolicyLogResultItemDTO.
     * 
     * @param singleResponseCode
     */
    public void setSingleResponseCode(java.lang.String singleResponseCode) {
        this.singleResponseCode = singleResponseCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PolicyLogResultItemDTO)) return false;
        PolicyLogResultItemDTO other = (PolicyLogResultItemDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.endorsementNo==null && other.getEndorsementNo()==null) || 
             (this.endorsementNo!=null &&
              this.endorsementNo.equals(other.getEndorsementNo()))) &&
            ((this.endorsementSequenceNo==null && other.getEndorsementSequenceNo()==null) || 
             (this.endorsementSequenceNo!=null &&
              this.endorsementSequenceNo.equals(other.getEndorsementSequenceNo()))) &&
            ((this.endorsementType==null && other.getEndorsementType()==null) || 
             (this.endorsementType!=null &&
              this.endorsementType.equals(other.getEndorsementType()))) &&
            ((this.errorReason==null && other.getErrorReason()==null) || 
             (this.errorReason!=null &&
              this.errorReason.equals(other.getErrorReason()))) &&
            ((this.policyNo==null && other.getPolicyNo()==null) || 
             (this.policyNo!=null &&
              this.policyNo.equals(other.getPolicyNo()))) &&
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
        if (getEndorsementNo() != null) {
            _hashCode += getEndorsementNo().hashCode();
        }
        if (getEndorsementSequenceNo() != null) {
            _hashCode += getEndorsementSequenceNo().hashCode();
        }
        if (getEndorsementType() != null) {
            _hashCode += getEndorsementType().hashCode();
        }
        if (getErrorReason() != null) {
            _hashCode += getErrorReason().hashCode();
        }
        if (getPolicyNo() != null) {
            _hashCode += getPolicyNo().hashCode();
        }
        if (getSingleResponseCode() != null) {
            _hashCode += getSingleResponseCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PolicyLogResultItemDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogResultItemDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endorsementNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endorsementSequenceNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementSequenceNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endorsementType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementType"));
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
        elemField.setFieldName("policyNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyNo"));
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
