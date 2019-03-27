/**
 * WesternMedicineDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class WesternMedicineDTO  implements java.io.Serializable {
    private com.ebao.health.insurance.dto.DiagnosisDTO[] diagnosisDTOs;

    private java.lang.String westernMedicineCode;

    public WesternMedicineDTO() {
    }

    public WesternMedicineDTO(
           com.ebao.health.insurance.dto.DiagnosisDTO[] diagnosisDTOs,
           java.lang.String westernMedicineCode) {
           this.diagnosisDTOs = diagnosisDTOs;
           this.westernMedicineCode = westernMedicineCode;
    }


    /**
     * Gets the diagnosisDTOs value for this WesternMedicineDTO.
     * 
     * @return diagnosisDTOs
     */
    public com.ebao.health.insurance.dto.DiagnosisDTO[] getDiagnosisDTOs() {
        return diagnosisDTOs;
    }


    /**
     * Sets the diagnosisDTOs value for this WesternMedicineDTO.
     * 
     * @param diagnosisDTOs
     */
    public void setDiagnosisDTOs(com.ebao.health.insurance.dto.DiagnosisDTO[] diagnosisDTOs) {
        this.diagnosisDTOs = diagnosisDTOs;
    }


    /**
     * Gets the westernMedicineCode value for this WesternMedicineDTO.
     * 
     * @return westernMedicineCode
     */
    public java.lang.String getWesternMedicineCode() {
        return westernMedicineCode;
    }


    /**
     * Sets the westernMedicineCode value for this WesternMedicineDTO.
     * 
     * @param westernMedicineCode
     */
    public void setWesternMedicineCode(java.lang.String westernMedicineCode) {
        this.westernMedicineCode = westernMedicineCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WesternMedicineDTO)) return false;
        WesternMedicineDTO other = (WesternMedicineDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.diagnosisDTOs==null && other.getDiagnosisDTOs()==null) || 
             (this.diagnosisDTOs!=null &&
              java.util.Arrays.equals(this.diagnosisDTOs, other.getDiagnosisDTOs()))) &&
            ((this.westernMedicineCode==null && other.getWesternMedicineCode()==null) || 
             (this.westernMedicineCode!=null &&
              this.westernMedicineCode.equals(other.getWesternMedicineCode())));
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
        if (getDiagnosisDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDiagnosisDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDiagnosisDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getWesternMedicineCode() != null) {
            _hashCode += getWesternMedicineCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WesternMedicineDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "WesternMedicineDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diagnosisDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "diagnosisDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "DiagnosisDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("westernMedicineCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "westernMedicineCode"));
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
