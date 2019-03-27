/**
 * CostItemDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class CostItemDTO  implements java.io.Serializable {
    private java.math.BigDecimal amount;

    private java.lang.String costCategory;

    private java.math.BigDecimal feeDeductibleAmount;

    private com.ebao.health.insurance.dto.MedicalFeeDetailDTO[] medicalFeeDetailDTOs;

    public CostItemDTO() {
    }

    public CostItemDTO(
           java.math.BigDecimal amount,
           java.lang.String costCategory,
           java.math.BigDecimal feeDeductibleAmount,
           com.ebao.health.insurance.dto.MedicalFeeDetailDTO[] medicalFeeDetailDTOs) {
           this.amount = amount;
           this.costCategory = costCategory;
           this.feeDeductibleAmount = feeDeductibleAmount;
           this.medicalFeeDetailDTOs = medicalFeeDetailDTOs;
    }


    /**
     * Gets the amount value for this CostItemDTO.
     * 
     * @return amount
     */
    public java.math.BigDecimal getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this CostItemDTO.
     * 
     * @param amount
     */
    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }


    /**
     * Gets the costCategory value for this CostItemDTO.
     * 
     * @return costCategory
     */
    public java.lang.String getCostCategory() {
        return costCategory;
    }


    /**
     * Sets the costCategory value for this CostItemDTO.
     * 
     * @param costCategory
     */
    public void setCostCategory(java.lang.String costCategory) {
        this.costCategory = costCategory;
    }


    /**
     * Gets the feeDeductibleAmount value for this CostItemDTO.
     * 
     * @return feeDeductibleAmount
     */
    public java.math.BigDecimal getFeeDeductibleAmount() {
        return feeDeductibleAmount;
    }


    /**
     * Sets the feeDeductibleAmount value for this CostItemDTO.
     * 
     * @param feeDeductibleAmount
     */
    public void setFeeDeductibleAmount(java.math.BigDecimal feeDeductibleAmount) {
        this.feeDeductibleAmount = feeDeductibleAmount;
    }


    /**
     * Gets the medicalFeeDetailDTOs value for this CostItemDTO.
     * 
     * @return medicalFeeDetailDTOs
     */
    public com.ebao.health.insurance.dto.MedicalFeeDetailDTO[] getMedicalFeeDetailDTOs() {
        return medicalFeeDetailDTOs;
    }


    /**
     * Sets the medicalFeeDetailDTOs value for this CostItemDTO.
     * 
     * @param medicalFeeDetailDTOs
     */
    public void setMedicalFeeDetailDTOs(com.ebao.health.insurance.dto.MedicalFeeDetailDTO[] medicalFeeDetailDTOs) {
        this.medicalFeeDetailDTOs = medicalFeeDetailDTOs;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CostItemDTO)) return false;
        CostItemDTO other = (CostItemDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.amount==null && other.getAmount()==null) || 
             (this.amount!=null &&
              this.amount.equals(other.getAmount()))) &&
            ((this.costCategory==null && other.getCostCategory()==null) || 
             (this.costCategory!=null &&
              this.costCategory.equals(other.getCostCategory()))) &&
            ((this.feeDeductibleAmount==null && other.getFeeDeductibleAmount()==null) || 
             (this.feeDeductibleAmount!=null &&
              this.feeDeductibleAmount.equals(other.getFeeDeductibleAmount()))) &&
            ((this.medicalFeeDetailDTOs==null && other.getMedicalFeeDetailDTOs()==null) || 
             (this.medicalFeeDetailDTOs!=null &&
              java.util.Arrays.equals(this.medicalFeeDetailDTOs, other.getMedicalFeeDetailDTOs())));
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
        if (getAmount() != null) {
            _hashCode += getAmount().hashCode();
        }
        if (getCostCategory() != null) {
            _hashCode += getCostCategory().hashCode();
        }
        if (getFeeDeductibleAmount() != null) {
            _hashCode += getFeeDeductibleAmount().hashCode();
        }
        if (getMedicalFeeDetailDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMedicalFeeDetailDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMedicalFeeDetailDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CostItemDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CostItemDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costCategory");
        elemField.setXmlName(new javax.xml.namespace.QName("", "costCategory"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feeDeductibleAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "feeDeductibleAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("medicalFeeDetailDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "medicalFeeDetailDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "MedicalFeeDetailDTO"));
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
