/**
 * UPStatusSpecialUpCoverageDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class UPStatusSpecialUpCoverageDTO  implements java.io.Serializable {
    private com.ebao.health.insurance.dto.UPStatusSpecialCoverageDTO[] UPStatusSpecialCoverageDTOs;

    private java.lang.String comCoverageCode;

    private java.lang.String coverageCode;

    private java.lang.String coverageStatus;

    private java.math.BigDecimal coverageSuminsured;

    private java.lang.String coverageType;

    public UPStatusSpecialUpCoverageDTO() {
    }

    public UPStatusSpecialUpCoverageDTO(
           com.ebao.health.insurance.dto.UPStatusSpecialCoverageDTO[] UPStatusSpecialCoverageDTOs,
           java.lang.String comCoverageCode,
           java.lang.String coverageCode,
           java.lang.String coverageStatus,
           java.math.BigDecimal coverageSuminsured,
           java.lang.String coverageType) {
           this.UPStatusSpecialCoverageDTOs = UPStatusSpecialCoverageDTOs;
           this.comCoverageCode = comCoverageCode;
           this.coverageCode = coverageCode;
           this.coverageStatus = coverageStatus;
           this.coverageSuminsured = coverageSuminsured;
           this.coverageType = coverageType;
    }


    /**
     * Gets the UPStatusSpecialCoverageDTOs value for this UPStatusSpecialUpCoverageDTO.
     * 
     * @return UPStatusSpecialCoverageDTOs
     */
    public com.ebao.health.insurance.dto.UPStatusSpecialCoverageDTO[] getUPStatusSpecialCoverageDTOs() {
        return UPStatusSpecialCoverageDTOs;
    }


    /**
     * Sets the UPStatusSpecialCoverageDTOs value for this UPStatusSpecialUpCoverageDTO.
     * 
     * @param UPStatusSpecialCoverageDTOs
     */
    public void setUPStatusSpecialCoverageDTOs(com.ebao.health.insurance.dto.UPStatusSpecialCoverageDTO[] UPStatusSpecialCoverageDTOs) {
        this.UPStatusSpecialCoverageDTOs = UPStatusSpecialCoverageDTOs;
    }


    /**
     * Gets the comCoverageCode value for this UPStatusSpecialUpCoverageDTO.
     * 
     * @return comCoverageCode
     */
    public java.lang.String getComCoverageCode() {
        return comCoverageCode;
    }


    /**
     * Sets the comCoverageCode value for this UPStatusSpecialUpCoverageDTO.
     * 
     * @param comCoverageCode
     */
    public void setComCoverageCode(java.lang.String comCoverageCode) {
        this.comCoverageCode = comCoverageCode;
    }


    /**
     * Gets the coverageCode value for this UPStatusSpecialUpCoverageDTO.
     * 
     * @return coverageCode
     */
    public java.lang.String getCoverageCode() {
        return coverageCode;
    }


    /**
     * Sets the coverageCode value for this UPStatusSpecialUpCoverageDTO.
     * 
     * @param coverageCode
     */
    public void setCoverageCode(java.lang.String coverageCode) {
        this.coverageCode = coverageCode;
    }


    /**
     * Gets the coverageStatus value for this UPStatusSpecialUpCoverageDTO.
     * 
     * @return coverageStatus
     */
    public java.lang.String getCoverageStatus() {
        return coverageStatus;
    }


    /**
     * Sets the coverageStatus value for this UPStatusSpecialUpCoverageDTO.
     * 
     * @param coverageStatus
     */
    public void setCoverageStatus(java.lang.String coverageStatus) {
        this.coverageStatus = coverageStatus;
    }


    /**
     * Gets the coverageSuminsured value for this UPStatusSpecialUpCoverageDTO.
     * 
     * @return coverageSuminsured
     */
    public java.math.BigDecimal getCoverageSuminsured() {
        return coverageSuminsured;
    }


    /**
     * Sets the coverageSuminsured value for this UPStatusSpecialUpCoverageDTO.
     * 
     * @param coverageSuminsured
     */
    public void setCoverageSuminsured(java.math.BigDecimal coverageSuminsured) {
        this.coverageSuminsured = coverageSuminsured;
    }


    /**
     * Gets the coverageType value for this UPStatusSpecialUpCoverageDTO.
     * 
     * @return coverageType
     */
    public java.lang.String getCoverageType() {
        return coverageType;
    }


    /**
     * Sets the coverageType value for this UPStatusSpecialUpCoverageDTO.
     * 
     * @param coverageType
     */
    public void setCoverageType(java.lang.String coverageType) {
        this.coverageType = coverageType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UPStatusSpecialUpCoverageDTO)) return false;
        UPStatusSpecialUpCoverageDTO other = (UPStatusSpecialUpCoverageDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.UPStatusSpecialCoverageDTOs==null && other.getUPStatusSpecialCoverageDTOs()==null) || 
             (this.UPStatusSpecialCoverageDTOs!=null &&
              java.util.Arrays.equals(this.UPStatusSpecialCoverageDTOs, other.getUPStatusSpecialCoverageDTOs()))) &&
            ((this.comCoverageCode==null && other.getComCoverageCode()==null) || 
             (this.comCoverageCode!=null &&
              this.comCoverageCode.equals(other.getComCoverageCode()))) &&
            ((this.coverageCode==null && other.getCoverageCode()==null) || 
             (this.coverageCode!=null &&
              this.coverageCode.equals(other.getCoverageCode()))) &&
            ((this.coverageStatus==null && other.getCoverageStatus()==null) || 
             (this.coverageStatus!=null &&
              this.coverageStatus.equals(other.getCoverageStatus()))) &&
            ((this.coverageSuminsured==null && other.getCoverageSuminsured()==null) || 
             (this.coverageSuminsured!=null &&
              this.coverageSuminsured.equals(other.getCoverageSuminsured()))) &&
            ((this.coverageType==null && other.getCoverageType()==null) || 
             (this.coverageType!=null &&
              this.coverageType.equals(other.getCoverageType())));
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
        if (getUPStatusSpecialCoverageDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUPStatusSpecialCoverageDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUPStatusSpecialCoverageDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getComCoverageCode() != null) {
            _hashCode += getComCoverageCode().hashCode();
        }
        if (getCoverageCode() != null) {
            _hashCode += getCoverageCode().hashCode();
        }
        if (getCoverageStatus() != null) {
            _hashCode += getCoverageStatus().hashCode();
        }
        if (getCoverageSuminsured() != null) {
            _hashCode += getCoverageSuminsured().hashCode();
        }
        if (getCoverageType() != null) {
            _hashCode += getCoverageType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UPStatusSpecialUpCoverageDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusSpecialUpCoverageDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UPStatusSpecialCoverageDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "UPStatusSpecialCoverageDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusSpecialCoverageDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comCoverageCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comCoverageCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageSuminsured");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageSuminsured"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageType"));
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
