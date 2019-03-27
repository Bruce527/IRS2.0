/**
 * CustomerQueryResultDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class CustomerQueryResultDTO  implements java.io.Serializable {
    private com.ebao.health.insurance.dto.ClaimInfoArrayDTO[] claimInfoArrayDTOs;

    private com.ebao.health.insurance.dto.EndorsementInfoDTO[] endorsementInfoDTOs;

    private java.lang.String errorMessage;

    private com.ebao.health.insurance.dto.PolicyInfoDTO[] policyInfoDTOs;

    private java.lang.String responseCode;

    private java.lang.String taskNo;

    public CustomerQueryResultDTO() {
    }

    public CustomerQueryResultDTO(
           com.ebao.health.insurance.dto.ClaimInfoArrayDTO[] claimInfoArrayDTOs,
           com.ebao.health.insurance.dto.EndorsementInfoDTO[] endorsementInfoDTOs,
           java.lang.String errorMessage,
           com.ebao.health.insurance.dto.PolicyInfoDTO[] policyInfoDTOs,
           java.lang.String responseCode,
           java.lang.String taskNo) {
           this.claimInfoArrayDTOs = claimInfoArrayDTOs;
           this.endorsementInfoDTOs = endorsementInfoDTOs;
           this.errorMessage = errorMessage;
           this.policyInfoDTOs = policyInfoDTOs;
           this.responseCode = responseCode;
           this.taskNo = taskNo;
    }


    /**
     * Gets the claimInfoArrayDTOs value for this CustomerQueryResultDTO.
     * 
     * @return claimInfoArrayDTOs
     */
    public com.ebao.health.insurance.dto.ClaimInfoArrayDTO[] getClaimInfoArrayDTOs() {
        return claimInfoArrayDTOs;
    }


    /**
     * Sets the claimInfoArrayDTOs value for this CustomerQueryResultDTO.
     * 
     * @param claimInfoArrayDTOs
     */
    public void setClaimInfoArrayDTOs(com.ebao.health.insurance.dto.ClaimInfoArrayDTO[] claimInfoArrayDTOs) {
        this.claimInfoArrayDTOs = claimInfoArrayDTOs;
    }


    /**
     * Gets the endorsementInfoDTOs value for this CustomerQueryResultDTO.
     * 
     * @return endorsementInfoDTOs
     */
    public com.ebao.health.insurance.dto.EndorsementInfoDTO[] getEndorsementInfoDTOs() {
        return endorsementInfoDTOs;
    }


    /**
     * Sets the endorsementInfoDTOs value for this CustomerQueryResultDTO.
     * 
     * @param endorsementInfoDTOs
     */
    public void setEndorsementInfoDTOs(com.ebao.health.insurance.dto.EndorsementInfoDTO[] endorsementInfoDTOs) {
        this.endorsementInfoDTOs = endorsementInfoDTOs;
    }


    /**
     * Gets the errorMessage value for this CustomerQueryResultDTO.
     * 
     * @return errorMessage
     */
    public java.lang.String getErrorMessage() {
        return errorMessage;
    }


    /**
     * Sets the errorMessage value for this CustomerQueryResultDTO.
     * 
     * @param errorMessage
     */
    public void setErrorMessage(java.lang.String errorMessage) {
        this.errorMessage = errorMessage;
    }


    /**
     * Gets the policyInfoDTOs value for this CustomerQueryResultDTO.
     * 
     * @return policyInfoDTOs
     */
    public com.ebao.health.insurance.dto.PolicyInfoDTO[] getPolicyInfoDTOs() {
        return policyInfoDTOs;
    }


    /**
     * Sets the policyInfoDTOs value for this CustomerQueryResultDTO.
     * 
     * @param policyInfoDTOs
     */
    public void setPolicyInfoDTOs(com.ebao.health.insurance.dto.PolicyInfoDTO[] policyInfoDTOs) {
        this.policyInfoDTOs = policyInfoDTOs;
    }


    /**
     * Gets the responseCode value for this CustomerQueryResultDTO.
     * 
     * @return responseCode
     */
    public java.lang.String getResponseCode() {
        return responseCode;
    }


    /**
     * Sets the responseCode value for this CustomerQueryResultDTO.
     * 
     * @param responseCode
     */
    public void setResponseCode(java.lang.String responseCode) {
        this.responseCode = responseCode;
    }


    /**
     * Gets the taskNo value for this CustomerQueryResultDTO.
     * 
     * @return taskNo
     */
    public java.lang.String getTaskNo() {
        return taskNo;
    }


    /**
     * Sets the taskNo value for this CustomerQueryResultDTO.
     * 
     * @param taskNo
     */
    public void setTaskNo(java.lang.String taskNo) {
        this.taskNo = taskNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustomerQueryResultDTO)) return false;
        CustomerQueryResultDTO other = (CustomerQueryResultDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.claimInfoArrayDTOs==null && other.getClaimInfoArrayDTOs()==null) || 
             (this.claimInfoArrayDTOs!=null &&
              java.util.Arrays.equals(this.claimInfoArrayDTOs, other.getClaimInfoArrayDTOs()))) &&
            ((this.endorsementInfoDTOs==null && other.getEndorsementInfoDTOs()==null) || 
             (this.endorsementInfoDTOs!=null &&
              java.util.Arrays.equals(this.endorsementInfoDTOs, other.getEndorsementInfoDTOs()))) &&
            ((this.errorMessage==null && other.getErrorMessage()==null) || 
             (this.errorMessage!=null &&
              this.errorMessage.equals(other.getErrorMessage()))) &&
            ((this.policyInfoDTOs==null && other.getPolicyInfoDTOs()==null) || 
             (this.policyInfoDTOs!=null &&
              java.util.Arrays.equals(this.policyInfoDTOs, other.getPolicyInfoDTOs()))) &&
            ((this.responseCode==null && other.getResponseCode()==null) || 
             (this.responseCode!=null &&
              this.responseCode.equals(other.getResponseCode()))) &&
            ((this.taskNo==null && other.getTaskNo()==null) || 
             (this.taskNo!=null &&
              this.taskNo.equals(other.getTaskNo())));
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
        if (getClaimInfoArrayDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClaimInfoArrayDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClaimInfoArrayDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEndorsementInfoDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEndorsementInfoDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEndorsementInfoDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getErrorMessage() != null) {
            _hashCode += getErrorMessage().hashCode();
        }
        if (getPolicyInfoDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPolicyInfoDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPolicyInfoDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getResponseCode() != null) {
            _hashCode += getResponseCode().hashCode();
        }
        if (getTaskNo() != null) {
            _hashCode += getTaskNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerQueryResultDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CustomerQueryResultDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimInfoArrayDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimInfoArrayDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClaimInfoArrayDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endorsementInfoDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementInfoDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "EndorsementInfoDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errorMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyInfoDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyInfoDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyInfoDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "responseCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taskNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "taskNo"));
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
