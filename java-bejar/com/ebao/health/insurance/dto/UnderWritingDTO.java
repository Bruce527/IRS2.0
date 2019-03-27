/**
 * UnderWritingDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class UnderWritingDTO  implements java.io.Serializable {
    private java.lang.String declinedReason;

    private java.lang.String physicalExamination;

    private java.lang.String state;

    private java.util.Calendar underwritingDate;

    private java.lang.String underwritingResult;

    public UnderWritingDTO() {
    }

    public UnderWritingDTO(
           java.lang.String declinedReason,
           java.lang.String physicalExamination,
           java.lang.String state,
           java.util.Calendar underwritingDate,
           java.lang.String underwritingResult) {
           this.declinedReason = declinedReason;
           this.physicalExamination = physicalExamination;
           this.state = state;
           this.underwritingDate = underwritingDate;
           this.underwritingResult = underwritingResult;
    }


    /**
     * Gets the declinedReason value for this UnderWritingDTO.
     * 
     * @return declinedReason
     */
    public java.lang.String getDeclinedReason() {
        return declinedReason;
    }


    /**
     * Sets the declinedReason value for this UnderWritingDTO.
     * 
     * @param declinedReason
     */
    public void setDeclinedReason(java.lang.String declinedReason) {
        this.declinedReason = declinedReason;
    }


    /**
     * Gets the physicalExamination value for this UnderWritingDTO.
     * 
     * @return physicalExamination
     */
    public java.lang.String getPhysicalExamination() {
        return physicalExamination;
    }


    /**
     * Sets the physicalExamination value for this UnderWritingDTO.
     * 
     * @param physicalExamination
     */
    public void setPhysicalExamination(java.lang.String physicalExamination) {
        this.physicalExamination = physicalExamination;
    }


    /**
     * Gets the state value for this UnderWritingDTO.
     * 
     * @return state
     */
    public java.lang.String getState() {
        return state;
    }


    /**
     * Sets the state value for this UnderWritingDTO.
     * 
     * @param state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }


    /**
     * Gets the underwritingDate value for this UnderWritingDTO.
     * 
     * @return underwritingDate
     */
    public java.util.Calendar getUnderwritingDate() {
        return underwritingDate;
    }


    /**
     * Sets the underwritingDate value for this UnderWritingDTO.
     * 
     * @param underwritingDate
     */
    public void setUnderwritingDate(java.util.Calendar underwritingDate) {
        this.underwritingDate = underwritingDate;
    }


    /**
     * Gets the underwritingResult value for this UnderWritingDTO.
     * 
     * @return underwritingResult
     */
    public java.lang.String getUnderwritingResult() {
        return underwritingResult;
    }


    /**
     * Sets the underwritingResult value for this UnderWritingDTO.
     * 
     * @param underwritingResult
     */
    public void setUnderwritingResult(java.lang.String underwritingResult) {
        this.underwritingResult = underwritingResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UnderWritingDTO)) return false;
        UnderWritingDTO other = (UnderWritingDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.declinedReason==null && other.getDeclinedReason()==null) || 
             (this.declinedReason!=null &&
              this.declinedReason.equals(other.getDeclinedReason()))) &&
            ((this.physicalExamination==null && other.getPhysicalExamination()==null) || 
             (this.physicalExamination!=null &&
              this.physicalExamination.equals(other.getPhysicalExamination()))) &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            ((this.underwritingDate==null && other.getUnderwritingDate()==null) || 
             (this.underwritingDate!=null &&
              this.underwritingDate.equals(other.getUnderwritingDate()))) &&
            ((this.underwritingResult==null && other.getUnderwritingResult()==null) || 
             (this.underwritingResult!=null &&
              this.underwritingResult.equals(other.getUnderwritingResult())));
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
        if (getDeclinedReason() != null) {
            _hashCode += getDeclinedReason().hashCode();
        }
        if (getPhysicalExamination() != null) {
            _hashCode += getPhysicalExamination().hashCode();
        }
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getUnderwritingDate() != null) {
            _hashCode += getUnderwritingDate().hashCode();
        }
        if (getUnderwritingResult() != null) {
            _hashCode += getUnderwritingResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UnderWritingDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UnderWritingDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("declinedReason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "declinedReason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("physicalExamination");
        elemField.setXmlName(new javax.xml.namespace.QName("", "physicalExamination"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("", "state"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("underwritingDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "underwritingDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("underwritingResult");
        elemField.setXmlName(new javax.xml.namespace.QName("", "underwritingResult"));
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
