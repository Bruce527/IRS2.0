/**
 * CoverageInfoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class CoverageInfoDTO  implements java.io.Serializable {
    private java.lang.String comCoverageCode;

    private java.lang.String coverageCode;

    private java.lang.String coverageName;

    private java.lang.String coverageType;

    private java.lang.String liabilityCode;

    private java.lang.String liabilityName;

    public CoverageInfoDTO() {
    }

    public CoverageInfoDTO(
           java.lang.String comCoverageCode,
           java.lang.String coverageCode,
           java.lang.String coverageName,
           java.lang.String coverageType,
           java.lang.String liabilityCode,
           java.lang.String liabilityName) {
           this.comCoverageCode = comCoverageCode;
           this.coverageCode = coverageCode;
           this.coverageName = coverageName;
           this.coverageType = coverageType;
           this.liabilityCode = liabilityCode;
           this.liabilityName = liabilityName;
    }


    /**
     * Gets the comCoverageCode value for this CoverageInfoDTO.
     * 
     * @return comCoverageCode
     */
    public java.lang.String getComCoverageCode() {
        return comCoverageCode;
    }


    /**
     * Sets the comCoverageCode value for this CoverageInfoDTO.
     * 
     * @param comCoverageCode
     */
    public void setComCoverageCode(java.lang.String comCoverageCode) {
        this.comCoverageCode = comCoverageCode;
    }


    /**
     * Gets the coverageCode value for this CoverageInfoDTO.
     * 
     * @return coverageCode
     */
    public java.lang.String getCoverageCode() {
        return coverageCode;
    }


    /**
     * Sets the coverageCode value for this CoverageInfoDTO.
     * 
     * @param coverageCode
     */
    public void setCoverageCode(java.lang.String coverageCode) {
        this.coverageCode = coverageCode;
    }


    /**
     * Gets the coverageName value for this CoverageInfoDTO.
     * 
     * @return coverageName
     */
    public java.lang.String getCoverageName() {
        return coverageName;
    }


    /**
     * Sets the coverageName value for this CoverageInfoDTO.
     * 
     * @param coverageName
     */
    public void setCoverageName(java.lang.String coverageName) {
        this.coverageName = coverageName;
    }


    /**
     * Gets the coverageType value for this CoverageInfoDTO.
     * 
     * @return coverageType
     */
    public java.lang.String getCoverageType() {
        return coverageType;
    }


    /**
     * Sets the coverageType value for this CoverageInfoDTO.
     * 
     * @param coverageType
     */
    public void setCoverageType(java.lang.String coverageType) {
        this.coverageType = coverageType;
    }


    /**
     * Gets the liabilityCode value for this CoverageInfoDTO.
     * 
     * @return liabilityCode
     */
    public java.lang.String getLiabilityCode() {
        return liabilityCode;
    }


    /**
     * Sets the liabilityCode value for this CoverageInfoDTO.
     * 
     * @param liabilityCode
     */
    public void setLiabilityCode(java.lang.String liabilityCode) {
        this.liabilityCode = liabilityCode;
    }


    /**
     * Gets the liabilityName value for this CoverageInfoDTO.
     * 
     * @return liabilityName
     */
    public java.lang.String getLiabilityName() {
        return liabilityName;
    }


    /**
     * Sets the liabilityName value for this CoverageInfoDTO.
     * 
     * @param liabilityName
     */
    public void setLiabilityName(java.lang.String liabilityName) {
        this.liabilityName = liabilityName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CoverageInfoDTO)) return false;
        CoverageInfoDTO other = (CoverageInfoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.comCoverageCode==null && other.getComCoverageCode()==null) || 
             (this.comCoverageCode!=null &&
              this.comCoverageCode.equals(other.getComCoverageCode()))) &&
            ((this.coverageCode==null && other.getCoverageCode()==null) || 
             (this.coverageCode!=null &&
              this.coverageCode.equals(other.getCoverageCode()))) &&
            ((this.coverageName==null && other.getCoverageName()==null) || 
             (this.coverageName!=null &&
              this.coverageName.equals(other.getCoverageName()))) &&
            ((this.coverageType==null && other.getCoverageType()==null) || 
             (this.coverageType!=null &&
              this.coverageType.equals(other.getCoverageType()))) &&
            ((this.liabilityCode==null && other.getLiabilityCode()==null) || 
             (this.liabilityCode!=null &&
              this.liabilityCode.equals(other.getLiabilityCode()))) &&
            ((this.liabilityName==null && other.getLiabilityName()==null) || 
             (this.liabilityName!=null &&
              this.liabilityName.equals(other.getLiabilityName())));
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
        if (getComCoverageCode() != null) {
            _hashCode += getComCoverageCode().hashCode();
        }
        if (getCoverageCode() != null) {
            _hashCode += getCoverageCode().hashCode();
        }
        if (getCoverageName() != null) {
            _hashCode += getCoverageName().hashCode();
        }
        if (getCoverageType() != null) {
            _hashCode += getCoverageType().hashCode();
        }
        if (getLiabilityCode() != null) {
            _hashCode += getLiabilityCode().hashCode();
        }
        if (getLiabilityName() != null) {
            _hashCode += getLiabilityName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CoverageInfoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CoverageInfoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("coverageName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liabilityCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liabilityCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liabilityName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liabilityName"));
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
