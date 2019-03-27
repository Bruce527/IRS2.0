/**
 * EndorsementInfoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class EndorsementInfoDTO  implements java.io.Serializable {
    private java.lang.String company;

    private java.util.Calendar effectiveDate;

    private java.lang.String endorsementNo;

    private java.lang.String endorsementSequenceNo;

    private java.lang.String endorsementType;

    private java.lang.String policyNo;

    private java.lang.String policySequenceNo;

    public EndorsementInfoDTO() {
    }

    public EndorsementInfoDTO(
           java.lang.String company,
           java.util.Calendar effectiveDate,
           java.lang.String endorsementNo,
           java.lang.String endorsementSequenceNo,
           java.lang.String endorsementType,
           java.lang.String policyNo,
           java.lang.String policySequenceNo) {
           this.company = company;
           this.effectiveDate = effectiveDate;
           this.endorsementNo = endorsementNo;
           this.endorsementSequenceNo = endorsementSequenceNo;
           this.endorsementType = endorsementType;
           this.policyNo = policyNo;
           this.policySequenceNo = policySequenceNo;
    }


    /**
     * Gets the company value for this EndorsementInfoDTO.
     * 
     * @return company
     */
    public java.lang.String getCompany() {
        return company;
    }


    /**
     * Sets the company value for this EndorsementInfoDTO.
     * 
     * @param company
     */
    public void setCompany(java.lang.String company) {
        this.company = company;
    }


    /**
     * Gets the effectiveDate value for this EndorsementInfoDTO.
     * 
     * @return effectiveDate
     */
    public java.util.Calendar getEffectiveDate() {
        return effectiveDate;
    }


    /**
     * Sets the effectiveDate value for this EndorsementInfoDTO.
     * 
     * @param effectiveDate
     */
    public void setEffectiveDate(java.util.Calendar effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    /**
     * Gets the endorsementNo value for this EndorsementInfoDTO.
     * 
     * @return endorsementNo
     */
    public java.lang.String getEndorsementNo() {
        return endorsementNo;
    }


    /**
     * Sets the endorsementNo value for this EndorsementInfoDTO.
     * 
     * @param endorsementNo
     */
    public void setEndorsementNo(java.lang.String endorsementNo) {
        this.endorsementNo = endorsementNo;
    }


    /**
     * Gets the endorsementSequenceNo value for this EndorsementInfoDTO.
     * 
     * @return endorsementSequenceNo
     */
    public java.lang.String getEndorsementSequenceNo() {
        return endorsementSequenceNo;
    }


    /**
     * Sets the endorsementSequenceNo value for this EndorsementInfoDTO.
     * 
     * @param endorsementSequenceNo
     */
    public void setEndorsementSequenceNo(java.lang.String endorsementSequenceNo) {
        this.endorsementSequenceNo = endorsementSequenceNo;
    }


    /**
     * Gets the endorsementType value for this EndorsementInfoDTO.
     * 
     * @return endorsementType
     */
    public java.lang.String getEndorsementType() {
        return endorsementType;
    }


    /**
     * Sets the endorsementType value for this EndorsementInfoDTO.
     * 
     * @param endorsementType
     */
    public void setEndorsementType(java.lang.String endorsementType) {
        this.endorsementType = endorsementType;
    }


    /**
     * Gets the policyNo value for this EndorsementInfoDTO.
     * 
     * @return policyNo
     */
    public java.lang.String getPolicyNo() {
        return policyNo;
    }


    /**
     * Sets the policyNo value for this EndorsementInfoDTO.
     * 
     * @param policyNo
     */
    public void setPolicyNo(java.lang.String policyNo) {
        this.policyNo = policyNo;
    }


    /**
     * Gets the policySequenceNo value for this EndorsementInfoDTO.
     * 
     * @return policySequenceNo
     */
    public java.lang.String getPolicySequenceNo() {
        return policySequenceNo;
    }


    /**
     * Sets the policySequenceNo value for this EndorsementInfoDTO.
     * 
     * @param policySequenceNo
     */
    public void setPolicySequenceNo(java.lang.String policySequenceNo) {
        this.policySequenceNo = policySequenceNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EndorsementInfoDTO)) return false;
        EndorsementInfoDTO other = (EndorsementInfoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.company==null && other.getCompany()==null) || 
             (this.company!=null &&
              this.company.equals(other.getCompany()))) &&
            ((this.effectiveDate==null && other.getEffectiveDate()==null) || 
             (this.effectiveDate!=null &&
              this.effectiveDate.equals(other.getEffectiveDate()))) &&
            ((this.endorsementNo==null && other.getEndorsementNo()==null) || 
             (this.endorsementNo!=null &&
              this.endorsementNo.equals(other.getEndorsementNo()))) &&
            ((this.endorsementSequenceNo==null && other.getEndorsementSequenceNo()==null) || 
             (this.endorsementSequenceNo!=null &&
              this.endorsementSequenceNo.equals(other.getEndorsementSequenceNo()))) &&
            ((this.endorsementType==null && other.getEndorsementType()==null) || 
             (this.endorsementType!=null &&
              this.endorsementType.equals(other.getEndorsementType()))) &&
            ((this.policyNo==null && other.getPolicyNo()==null) || 
             (this.policyNo!=null &&
              this.policyNo.equals(other.getPolicyNo()))) &&
            ((this.policySequenceNo==null && other.getPolicySequenceNo()==null) || 
             (this.policySequenceNo!=null &&
              this.policySequenceNo.equals(other.getPolicySequenceNo())));
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
        if (getCompany() != null) {
            _hashCode += getCompany().hashCode();
        }
        if (getEffectiveDate() != null) {
            _hashCode += getEffectiveDate().hashCode();
        }
        if (getEndorsementNo() != null) {
            _hashCode += getEndorsementNo().hashCode();
        }
        if (getEndorsementSequenceNo() != null) {
            _hashCode += getEndorsementSequenceNo().hashCode();
        }
        if (getEndorsementType() != null) {
            _hashCode += getEndorsementType().hashCode();
        }
        if (getPolicyNo() != null) {
            _hashCode += getPolicyNo().hashCode();
        }
        if (getPolicySequenceNo() != null) {
            _hashCode += getPolicySequenceNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EndorsementInfoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "EndorsementInfoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("company");
        elemField.setXmlName(new javax.xml.namespace.QName("", "company"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("effectiveDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "effectiveDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("policyNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policySequenceNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policySequenceNo"));
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
