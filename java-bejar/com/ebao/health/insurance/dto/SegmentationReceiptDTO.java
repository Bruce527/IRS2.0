/**
 * SegmentationReceiptDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class SegmentationReceiptDTO  implements java.io.Serializable {
    private java.lang.String receiptNo;

    private java.lang.String issuedUnit;

    private java.math.BigDecimal feeAmount;

    private java.math.BigDecimal feeDeductibleAmount;

    private java.math.BigDecimal receiptClaimAmount;

    public SegmentationReceiptDTO() {
    }

    public SegmentationReceiptDTO(
           java.lang.String receiptNo,
           java.lang.String issuedUnit,
           java.math.BigDecimal feeAmount,
           java.math.BigDecimal feeDeductibleAmount,
           java.math.BigDecimal receiptClaimAmount) {
           this.receiptNo = receiptNo;
           this.issuedUnit = issuedUnit;
           this.feeAmount = feeAmount;
           this.feeDeductibleAmount = feeDeductibleAmount;
           this.receiptClaimAmount = receiptClaimAmount;
    }


    /**
     * Gets the receiptNo value for this SegmentationReceiptDTO.
     * 
     * @return receiptNo
     */
    public java.lang.String getReceiptNo() {
        return receiptNo;
    }


    /**
     * Sets the receiptNo value for this SegmentationReceiptDTO.
     * 
     * @param receiptNo
     */
    public void setReceiptNo(java.lang.String receiptNo) {
        this.receiptNo = receiptNo;
    }


    /**
     * Gets the issuedUnit value for this SegmentationReceiptDTO.
     * 
     * @return issuedUnit
     */
    public java.lang.String getIssuedUnit() {
        return issuedUnit;
    }


    /**
     * Sets the issuedUnit value for this SegmentationReceiptDTO.
     * 
     * @param issuedUnit
     */
    public void setIssuedUnit(java.lang.String issuedUnit) {
        this.issuedUnit = issuedUnit;
    }


    /**
     * Gets the feeAmount value for this SegmentationReceiptDTO.
     * 
     * @return feeAmount
     */
    public java.math.BigDecimal getFeeAmount() {
        return feeAmount;
    }


    /**
     * Sets the feeAmount value for this SegmentationReceiptDTO.
     * 
     * @param feeAmount
     */
    public void setFeeAmount(java.math.BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }


    /**
     * Gets the feeDeductibleAmount value for this SegmentationReceiptDTO.
     * 
     * @return feeDeductibleAmount
     */
    public java.math.BigDecimal getFeeDeductibleAmount() {
        return feeDeductibleAmount;
    }


    /**
     * Sets the feeDeductibleAmount value for this SegmentationReceiptDTO.
     * 
     * @param feeDeductibleAmount
     */
    public void setFeeDeductibleAmount(java.math.BigDecimal feeDeductibleAmount) {
        this.feeDeductibleAmount = feeDeductibleAmount;
    }


    /**
     * Gets the receiptClaimAmount value for this SegmentationReceiptDTO.
     * 
     * @return receiptClaimAmount
     */
    public java.math.BigDecimal getReceiptClaimAmount() {
        return receiptClaimAmount;
    }


    /**
     * Sets the receiptClaimAmount value for this SegmentationReceiptDTO.
     * 
     * @param receiptClaimAmount
     */
    public void setReceiptClaimAmount(java.math.BigDecimal receiptClaimAmount) {
        this.receiptClaimAmount = receiptClaimAmount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SegmentationReceiptDTO)) return false;
        SegmentationReceiptDTO other = (SegmentationReceiptDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.receiptNo==null && other.getReceiptNo()==null) || 
             (this.receiptNo!=null &&
              this.receiptNo.equals(other.getReceiptNo()))) &&
            ((this.issuedUnit==null && other.getIssuedUnit()==null) || 
             (this.issuedUnit!=null &&
              this.issuedUnit.equals(other.getIssuedUnit()))) &&
            ((this.feeAmount==null && other.getFeeAmount()==null) || 
             (this.feeAmount!=null &&
              this.feeAmount.equals(other.getFeeAmount()))) &&
            ((this.feeDeductibleAmount==null && other.getFeeDeductibleAmount()==null) || 
             (this.feeDeductibleAmount!=null &&
              this.feeDeductibleAmount.equals(other.getFeeDeductibleAmount()))) &&
            ((this.receiptClaimAmount==null && other.getReceiptClaimAmount()==null) || 
             (this.receiptClaimAmount!=null &&
              this.receiptClaimAmount.equals(other.getReceiptClaimAmount())));
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
        if (getReceiptNo() != null) {
            _hashCode += getReceiptNo().hashCode();
        }
        if (getIssuedUnit() != null) {
            _hashCode += getIssuedUnit().hashCode();
        }
        if (getFeeAmount() != null) {
            _hashCode += getFeeAmount().hashCode();
        }
        if (getFeeDeductibleAmount() != null) {
            _hashCode += getFeeDeductibleAmount().hashCode();
        }
        if (getReceiptClaimAmount() != null) {
            _hashCode += getReceiptClaimAmount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SegmentationReceiptDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SegmentationReceiptDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiptNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receiptNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("issuedUnit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "issuedUnit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feeAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "feeAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feeDeductibleAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "feeDeductibleAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiptClaimAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receiptClaimAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
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
