/**
 * MedicalFeeDetailDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class MedicalFeeDetailDTO  implements java.io.Serializable {
    private java.math.BigDecimal feeAmount;

    private java.math.BigDecimal feeDeductibleAmount;

    private java.lang.String medicalDetailName;

    private java.math.BigDecimal quantity;

    private java.math.BigDecimal unit;

    private java.math.BigDecimal unitPrice;

    public MedicalFeeDetailDTO() {
    }

    public MedicalFeeDetailDTO(
           java.math.BigDecimal feeAmount,
           java.math.BigDecimal feeDeductibleAmount,
           java.lang.String medicalDetailName,
           java.math.BigDecimal quantity,
           java.math.BigDecimal unit,
           java.math.BigDecimal unitPrice) {
           this.feeAmount = feeAmount;
           this.feeDeductibleAmount = feeDeductibleAmount;
           this.medicalDetailName = medicalDetailName;
           this.quantity = quantity;
           this.unit = unit;
           this.unitPrice = unitPrice;
    }


    /**
     * Gets the feeAmount value for this MedicalFeeDetailDTO.
     * 
     * @return feeAmount
     */
    public java.math.BigDecimal getFeeAmount() {
        return feeAmount;
    }


    /**
     * Sets the feeAmount value for this MedicalFeeDetailDTO.
     * 
     * @param feeAmount
     */
    public void setFeeAmount(java.math.BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }


    /**
     * Gets the feeDeductibleAmount value for this MedicalFeeDetailDTO.
     * 
     * @return feeDeductibleAmount
     */
    public java.math.BigDecimal getFeeDeductibleAmount() {
        return feeDeductibleAmount;
    }


    /**
     * Sets the feeDeductibleAmount value for this MedicalFeeDetailDTO.
     * 
     * @param feeDeductibleAmount
     */
    public void setFeeDeductibleAmount(java.math.BigDecimal feeDeductibleAmount) {
        this.feeDeductibleAmount = feeDeductibleAmount;
    }


    /**
     * Gets the medicalDetailName value for this MedicalFeeDetailDTO.
     * 
     * @return medicalDetailName
     */
    public java.lang.String getMedicalDetailName() {
        return medicalDetailName;
    }


    /**
     * Sets the medicalDetailName value for this MedicalFeeDetailDTO.
     * 
     * @param medicalDetailName
     */
    public void setMedicalDetailName(java.lang.String medicalDetailName) {
        this.medicalDetailName = medicalDetailName;
    }


    /**
     * Gets the quantity value for this MedicalFeeDetailDTO.
     * 
     * @return quantity
     */
    public java.math.BigDecimal getQuantity() {
        return quantity;
    }


    /**
     * Sets the quantity value for this MedicalFeeDetailDTO.
     * 
     * @param quantity
     */
    public void setQuantity(java.math.BigDecimal quantity) {
        this.quantity = quantity;
    }


    /**
     * Gets the unit value for this MedicalFeeDetailDTO.
     * 
     * @return unit
     */
    public java.math.BigDecimal getUnit() {
        return unit;
    }


    /**
     * Sets the unit value for this MedicalFeeDetailDTO.
     * 
     * @param unit
     */
    public void setUnit(java.math.BigDecimal unit) {
        this.unit = unit;
    }


    /**
     * Gets the unitPrice value for this MedicalFeeDetailDTO.
     * 
     * @return unitPrice
     */
    public java.math.BigDecimal getUnitPrice() {
        return unitPrice;
    }


    /**
     * Sets the unitPrice value for this MedicalFeeDetailDTO.
     * 
     * @param unitPrice
     */
    public void setUnitPrice(java.math.BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MedicalFeeDetailDTO)) return false;
        MedicalFeeDetailDTO other = (MedicalFeeDetailDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.feeAmount==null && other.getFeeAmount()==null) || 
             (this.feeAmount!=null &&
              this.feeAmount.equals(other.getFeeAmount()))) &&
            ((this.feeDeductibleAmount==null && other.getFeeDeductibleAmount()==null) || 
             (this.feeDeductibleAmount!=null &&
              this.feeDeductibleAmount.equals(other.getFeeDeductibleAmount()))) &&
            ((this.medicalDetailName==null && other.getMedicalDetailName()==null) || 
             (this.medicalDetailName!=null &&
              this.medicalDetailName.equals(other.getMedicalDetailName()))) &&
            ((this.quantity==null && other.getQuantity()==null) || 
             (this.quantity!=null &&
              this.quantity.equals(other.getQuantity()))) &&
            ((this.unit==null && other.getUnit()==null) || 
             (this.unit!=null &&
              this.unit.equals(other.getUnit()))) &&
            ((this.unitPrice==null && other.getUnitPrice()==null) || 
             (this.unitPrice!=null &&
              this.unitPrice.equals(other.getUnitPrice())));
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
        if (getFeeAmount() != null) {
            _hashCode += getFeeAmount().hashCode();
        }
        if (getFeeDeductibleAmount() != null) {
            _hashCode += getFeeDeductibleAmount().hashCode();
        }
        if (getMedicalDetailName() != null) {
            _hashCode += getMedicalDetailName().hashCode();
        }
        if (getQuantity() != null) {
            _hashCode += getQuantity().hashCode();
        }
        if (getUnit() != null) {
            _hashCode += getUnit().hashCode();
        }
        if (getUnitPrice() != null) {
            _hashCode += getUnitPrice().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MedicalFeeDetailDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "MedicalFeeDetailDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("medicalDetailName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "medicalDetailName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quantity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unitPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unitPrice"));
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
