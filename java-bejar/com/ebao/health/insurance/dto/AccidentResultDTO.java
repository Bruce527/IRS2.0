/**
 * AccidentResultDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class AccidentResultDTO  implements java.io.Serializable {
    private java.lang.String accidentResult;

    private java.util.Calendar accidentResultDate;

    public AccidentResultDTO() {
    }

    public AccidentResultDTO(
           java.lang.String accidentResult,
           java.util.Calendar accidentResultDate) {
           this.accidentResult = accidentResult;
           this.accidentResultDate = accidentResultDate;
    }


    /**
     * Gets the accidentResult value for this AccidentResultDTO.
     * 
     * @return accidentResult
     */
    public java.lang.String getAccidentResult() {
        return accidentResult;
    }


    /**
     * Sets the accidentResult value for this AccidentResultDTO.
     * 
     * @param accidentResult
     */
    public void setAccidentResult(java.lang.String accidentResult) {
        this.accidentResult = accidentResult;
    }


    /**
     * Gets the accidentResultDate value for this AccidentResultDTO.
     * 
     * @return accidentResultDate
     */
    public java.util.Calendar getAccidentResultDate() {
        return accidentResultDate;
    }


    /**
     * Sets the accidentResultDate value for this AccidentResultDTO.
     * 
     * @param accidentResultDate
     */
    public void setAccidentResultDate(java.util.Calendar accidentResultDate) {
        this.accidentResultDate = accidentResultDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccidentResultDTO)) return false;
        AccidentResultDTO other = (AccidentResultDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accidentResult==null && other.getAccidentResult()==null) || 
             (this.accidentResult!=null &&
              this.accidentResult.equals(other.getAccidentResult()))) &&
            ((this.accidentResultDate==null && other.getAccidentResultDate()==null) || 
             (this.accidentResultDate!=null &&
              this.accidentResultDate.equals(other.getAccidentResultDate())));
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
        if (getAccidentResult() != null) {
            _hashCode += getAccidentResult().hashCode();
        }
        if (getAccidentResultDate() != null) {
            _hashCode += getAccidentResultDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccidentResultDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "AccidentResultDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidentResult");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidentResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidentResultDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidentResultDate"));
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
