/**
 * AccidentGroupPolicyResultsDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.accident.insurance.dto;

public class AccidentGroupPolicyResultsDTO  implements java.io.Serializable {
    private com.ebao.accident.insurance.dto.AccidentGroupPolicyResultDTO[] accidentGroupPolicyResultDTOs;

    private java.lang.String errorMessage;

    private java.lang.String responseCode;

    private java.lang.String taskNo;

    public AccidentGroupPolicyResultsDTO() {
    }

    public AccidentGroupPolicyResultsDTO(
           com.ebao.accident.insurance.dto.AccidentGroupPolicyResultDTO[] accidentGroupPolicyResultDTOs,
           java.lang.String errorMessage,
           java.lang.String responseCode,
           java.lang.String taskNo) {
           this.accidentGroupPolicyResultDTOs = accidentGroupPolicyResultDTOs;
           this.errorMessage = errorMessage;
           this.responseCode = responseCode;
           this.taskNo = taskNo;
    }


    /**
     * Gets the accidentGroupPolicyResultDTOs value for this AccidentGroupPolicyResultsDTO.
     * 
     * @return accidentGroupPolicyResultDTOs
     */
    public com.ebao.accident.insurance.dto.AccidentGroupPolicyResultDTO[] getAccidentGroupPolicyResultDTOs() {
        return accidentGroupPolicyResultDTOs;
    }


    /**
     * Sets the accidentGroupPolicyResultDTOs value for this AccidentGroupPolicyResultsDTO.
     * 
     * @param accidentGroupPolicyResultDTOs
     */
    public void setAccidentGroupPolicyResultDTOs(com.ebao.accident.insurance.dto.AccidentGroupPolicyResultDTO[] accidentGroupPolicyResultDTOs) {
        this.accidentGroupPolicyResultDTOs = accidentGroupPolicyResultDTOs;
    }


    /**
     * Gets the errorMessage value for this AccidentGroupPolicyResultsDTO.
     * 
     * @return errorMessage
     */
    public java.lang.String getErrorMessage() {
        return errorMessage;
    }


    /**
     * Sets the errorMessage value for this AccidentGroupPolicyResultsDTO.
     * 
     * @param errorMessage
     */
    public void setErrorMessage(java.lang.String errorMessage) {
        this.errorMessage = errorMessage;
    }


    /**
     * Gets the responseCode value for this AccidentGroupPolicyResultsDTO.
     * 
     * @return responseCode
     */
    public java.lang.String getResponseCode() {
        return responseCode;
    }


    /**
     * Sets the responseCode value for this AccidentGroupPolicyResultsDTO.
     * 
     * @param responseCode
     */
    public void setResponseCode(java.lang.String responseCode) {
        this.responseCode = responseCode;
    }


    /**
     * Gets the taskNo value for this AccidentGroupPolicyResultsDTO.
     * 
     * @return taskNo
     */
    public java.lang.String getTaskNo() {
        return taskNo;
    }


    /**
     * Sets the taskNo value for this AccidentGroupPolicyResultsDTO.
     * 
     * @param taskNo
     */
    public void setTaskNo(java.lang.String taskNo) {
        this.taskNo = taskNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccidentGroupPolicyResultsDTO)) return false;
        AccidentGroupPolicyResultsDTO other = (AccidentGroupPolicyResultsDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accidentGroupPolicyResultDTOs==null && other.getAccidentGroupPolicyResultDTOs()==null) || 
             (this.accidentGroupPolicyResultDTOs!=null &&
              java.util.Arrays.equals(this.accidentGroupPolicyResultDTOs, other.getAccidentGroupPolicyResultDTOs()))) &&
            ((this.errorMessage==null && other.getErrorMessage()==null) || 
             (this.errorMessage!=null &&
              this.errorMessage.equals(other.getErrorMessage()))) &&
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
        if (getAccidentGroupPolicyResultDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccidentGroupPolicyResultDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccidentGroupPolicyResultDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getErrorMessage() != null) {
            _hashCode += getErrorMessage().hashCode();
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
        new org.apache.axis.description.TypeDesc(AccidentGroupPolicyResultsDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyResultsDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidentGroupPolicyResultDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidentGroupPolicyResultDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyResultDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errorMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "responseCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taskNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "taskNo"));
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
