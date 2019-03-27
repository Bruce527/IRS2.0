/**
 * UPStatusSpecialCoverageDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class UPStatusSpecialCoverageDTO  implements java.io.Serializable {
    private java.lang.String liabilityCode;

    private java.util.Calendar liabilityExpireDate;

    private java.lang.String liabilityStatus;

    public UPStatusSpecialCoverageDTO() {
    }

    public UPStatusSpecialCoverageDTO(
           java.lang.String liabilityCode,
           java.util.Calendar liabilityExpireDate,
           java.lang.String liabilityStatus) {
           this.liabilityCode = liabilityCode;
           this.liabilityExpireDate = liabilityExpireDate;
           this.liabilityStatus = liabilityStatus;
    }


    /**
     * Gets the liabilityCode value for this UPStatusSpecialCoverageDTO.
     * 
     * @return liabilityCode
     */
    public java.lang.String getLiabilityCode() {
        return liabilityCode;
    }


    /**
     * Sets the liabilityCode value for this UPStatusSpecialCoverageDTO.
     * 
     * @param liabilityCode
     */
    public void setLiabilityCode(java.lang.String liabilityCode) {
        this.liabilityCode = liabilityCode;
    }


    /**
     * Gets the liabilityExpireDate value for this UPStatusSpecialCoverageDTO.
     * 
     * @return liabilityExpireDate
     */
    public java.util.Calendar getLiabilityExpireDate() {
        return liabilityExpireDate;
    }


    /**
     * Sets the liabilityExpireDate value for this UPStatusSpecialCoverageDTO.
     * 
     * @param liabilityExpireDate
     */
    public void setLiabilityExpireDate(java.util.Calendar liabilityExpireDate) {
        this.liabilityExpireDate = liabilityExpireDate;
    }


    /**
     * Gets the liabilityStatus value for this UPStatusSpecialCoverageDTO.
     * 
     * @return liabilityStatus
     */
    public java.lang.String getLiabilityStatus() {
        return liabilityStatus;
    }


    /**
     * Sets the liabilityStatus value for this UPStatusSpecialCoverageDTO.
     * 
     * @param liabilityStatus
     */
    public void setLiabilityStatus(java.lang.String liabilityStatus) {
        this.liabilityStatus = liabilityStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UPStatusSpecialCoverageDTO)) return false;
        UPStatusSpecialCoverageDTO other = (UPStatusSpecialCoverageDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.liabilityCode==null && other.getLiabilityCode()==null) || 
             (this.liabilityCode!=null &&
              this.liabilityCode.equals(other.getLiabilityCode()))) &&
            ((this.liabilityExpireDate==null && other.getLiabilityExpireDate()==null) || 
             (this.liabilityExpireDate!=null &&
              this.liabilityExpireDate.equals(other.getLiabilityExpireDate()))) &&
            ((this.liabilityStatus==null && other.getLiabilityStatus()==null) || 
             (this.liabilityStatus!=null &&
              this.liabilityStatus.equals(other.getLiabilityStatus())));
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
        if (getLiabilityCode() != null) {
            _hashCode += getLiabilityCode().hashCode();
        }
        if (getLiabilityExpireDate() != null) {
            _hashCode += getLiabilityExpireDate().hashCode();
        }
        if (getLiabilityStatus() != null) {
            _hashCode += getLiabilityStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UPStatusSpecialCoverageDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusSpecialCoverageDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liabilityCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liabilityCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liabilityExpireDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liabilityExpireDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liabilityStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liabilityStatus"));
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
