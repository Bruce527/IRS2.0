/**
 * BirthClinicReceiptDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class BirthClinicReceiptDTO  implements java.io.Serializable {
    private java.util.Calendar clinicDate;

    private com.ebao.health.insurance.dto.CostItemDTO[] costItemDTOs;

    private java.math.BigDecimal feeAmount;

    private java.math.BigDecimal feeDeductibleAmount;

    private java.lang.String hospitalCode;

    private java.lang.String operation;

    private com.ebao.health.insurance.dto.OperationDTO[] operationDTOs;

    private java.math.BigDecimal receiptClaimAmount;

    private java.lang.String receiptNo;

    private com.ebao.health.insurance.dto.WesternMedicineDTO[] westernMedicineDTOs;

    public BirthClinicReceiptDTO() {
    }

    public BirthClinicReceiptDTO(
           java.util.Calendar clinicDate,
           com.ebao.health.insurance.dto.CostItemDTO[] costItemDTOs,
           java.math.BigDecimal feeAmount,
           java.math.BigDecimal feeDeductibleAmount,
           java.lang.String hospitalCode,
           java.lang.String operation,
           com.ebao.health.insurance.dto.OperationDTO[] operationDTOs,
           java.math.BigDecimal receiptClaimAmount,
           java.lang.String receiptNo,
           com.ebao.health.insurance.dto.WesternMedicineDTO[] westernMedicineDTOs) {
           this.clinicDate = clinicDate;
           this.costItemDTOs = costItemDTOs;
           this.feeAmount = feeAmount;
           this.feeDeductibleAmount = feeDeductibleAmount;
           this.hospitalCode = hospitalCode;
           this.operation = operation;
           this.operationDTOs = operationDTOs;
           this.receiptClaimAmount = receiptClaimAmount;
           this.receiptNo = receiptNo;
           this.westernMedicineDTOs = westernMedicineDTOs;
    }


    /**
     * Gets the clinicDate value for this BirthClinicReceiptDTO.
     * 
     * @return clinicDate
     */
    public java.util.Calendar getClinicDate() {
        return clinicDate;
    }


    /**
     * Sets the clinicDate value for this BirthClinicReceiptDTO.
     * 
     * @param clinicDate
     */
    public void setClinicDate(java.util.Calendar clinicDate) {
        this.clinicDate = clinicDate;
    }


    /**
     * Gets the costItemDTOs value for this BirthClinicReceiptDTO.
     * 
     * @return costItemDTOs
     */
    public com.ebao.health.insurance.dto.CostItemDTO[] getCostItemDTOs() {
        return costItemDTOs;
    }


    /**
     * Sets the costItemDTOs value for this BirthClinicReceiptDTO.
     * 
     * @param costItemDTOs
     */
    public void setCostItemDTOs(com.ebao.health.insurance.dto.CostItemDTO[] costItemDTOs) {
        this.costItemDTOs = costItemDTOs;
    }


    /**
     * Gets the feeAmount value for this BirthClinicReceiptDTO.
     * 
     * @return feeAmount
     */
    public java.math.BigDecimal getFeeAmount() {
        return feeAmount;
    }


    /**
     * Sets the feeAmount value for this BirthClinicReceiptDTO.
     * 
     * @param feeAmount
     */
    public void setFeeAmount(java.math.BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }


    /**
     * Gets the feeDeductibleAmount value for this BirthClinicReceiptDTO.
     * 
     * @return feeDeductibleAmount
     */
    public java.math.BigDecimal getFeeDeductibleAmount() {
        return feeDeductibleAmount;
    }


    /**
     * Sets the feeDeductibleAmount value for this BirthClinicReceiptDTO.
     * 
     * @param feeDeductibleAmount
     */
    public void setFeeDeductibleAmount(java.math.BigDecimal feeDeductibleAmount) {
        this.feeDeductibleAmount = feeDeductibleAmount;
    }


    /**
     * Gets the hospitalCode value for this BirthClinicReceiptDTO.
     * 
     * @return hospitalCode
     */
    public java.lang.String getHospitalCode() {
        return hospitalCode;
    }


    /**
     * Sets the hospitalCode value for this BirthClinicReceiptDTO.
     * 
     * @param hospitalCode
     */
    public void setHospitalCode(java.lang.String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }


    /**
     * Gets the operation value for this BirthClinicReceiptDTO.
     * 
     * @return operation
     */
    public java.lang.String getOperation() {
        return operation;
    }


    /**
     * Sets the operation value for this BirthClinicReceiptDTO.
     * 
     * @param operation
     */
    public void setOperation(java.lang.String operation) {
        this.operation = operation;
    }


    /**
     * Gets the operationDTOs value for this BirthClinicReceiptDTO.
     * 
     * @return operationDTOs
     */
    public com.ebao.health.insurance.dto.OperationDTO[] getOperationDTOs() {
        return operationDTOs;
    }


    /**
     * Sets the operationDTOs value for this BirthClinicReceiptDTO.
     * 
     * @param operationDTOs
     */
    public void setOperationDTOs(com.ebao.health.insurance.dto.OperationDTO[] operationDTOs) {
        this.operationDTOs = operationDTOs;
    }


    /**
     * Gets the receiptClaimAmount value for this BirthClinicReceiptDTO.
     * 
     * @return receiptClaimAmount
     */
    public java.math.BigDecimal getReceiptClaimAmount() {
        return receiptClaimAmount;
    }


    /**
     * Sets the receiptClaimAmount value for this BirthClinicReceiptDTO.
     * 
     * @param receiptClaimAmount
     */
    public void setReceiptClaimAmount(java.math.BigDecimal receiptClaimAmount) {
        this.receiptClaimAmount = receiptClaimAmount;
    }


    /**
     * Gets the receiptNo value for this BirthClinicReceiptDTO.
     * 
     * @return receiptNo
     */
    public java.lang.String getReceiptNo() {
        return receiptNo;
    }


    /**
     * Sets the receiptNo value for this BirthClinicReceiptDTO.
     * 
     * @param receiptNo
     */
    public void setReceiptNo(java.lang.String receiptNo) {
        this.receiptNo = receiptNo;
    }


    /**
     * Gets the westernMedicineDTOs value for this BirthClinicReceiptDTO.
     * 
     * @return westernMedicineDTOs
     */
    public com.ebao.health.insurance.dto.WesternMedicineDTO[] getWesternMedicineDTOs() {
        return westernMedicineDTOs;
    }


    /**
     * Sets the westernMedicineDTOs value for this BirthClinicReceiptDTO.
     * 
     * @param westernMedicineDTOs
     */
    public void setWesternMedicineDTOs(com.ebao.health.insurance.dto.WesternMedicineDTO[] westernMedicineDTOs) {
        this.westernMedicineDTOs = westernMedicineDTOs;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BirthClinicReceiptDTO)) return false;
        BirthClinicReceiptDTO other = (BirthClinicReceiptDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.clinicDate==null && other.getClinicDate()==null) || 
             (this.clinicDate!=null &&
              this.clinicDate.equals(other.getClinicDate()))) &&
            ((this.costItemDTOs==null && other.getCostItemDTOs()==null) || 
             (this.costItemDTOs!=null &&
              java.util.Arrays.equals(this.costItemDTOs, other.getCostItemDTOs()))) &&
            ((this.feeAmount==null && other.getFeeAmount()==null) || 
             (this.feeAmount!=null &&
              this.feeAmount.equals(other.getFeeAmount()))) &&
            ((this.feeDeductibleAmount==null && other.getFeeDeductibleAmount()==null) || 
             (this.feeDeductibleAmount!=null &&
              this.feeDeductibleAmount.equals(other.getFeeDeductibleAmount()))) &&
            ((this.hospitalCode==null && other.getHospitalCode()==null) || 
             (this.hospitalCode!=null &&
              this.hospitalCode.equals(other.getHospitalCode()))) &&
            ((this.operation==null && other.getOperation()==null) || 
             (this.operation!=null &&
              this.operation.equals(other.getOperation()))) &&
            ((this.operationDTOs==null && other.getOperationDTOs()==null) || 
             (this.operationDTOs!=null &&
              java.util.Arrays.equals(this.operationDTOs, other.getOperationDTOs()))) &&
            ((this.receiptClaimAmount==null && other.getReceiptClaimAmount()==null) || 
             (this.receiptClaimAmount!=null &&
              this.receiptClaimAmount.equals(other.getReceiptClaimAmount()))) &&
            ((this.receiptNo==null && other.getReceiptNo()==null) || 
             (this.receiptNo!=null &&
              this.receiptNo.equals(other.getReceiptNo()))) &&
            ((this.westernMedicineDTOs==null && other.getWesternMedicineDTOs()==null) || 
             (this.westernMedicineDTOs!=null &&
              java.util.Arrays.equals(this.westernMedicineDTOs, other.getWesternMedicineDTOs())));
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
        if (getClinicDate() != null) {
            _hashCode += getClinicDate().hashCode();
        }
        if (getCostItemDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCostItemDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCostItemDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFeeAmount() != null) {
            _hashCode += getFeeAmount().hashCode();
        }
        if (getFeeDeductibleAmount() != null) {
            _hashCode += getFeeDeductibleAmount().hashCode();
        }
        if (getHospitalCode() != null) {
            _hashCode += getHospitalCode().hashCode();
        }
        if (getOperation() != null) {
            _hashCode += getOperation().hashCode();
        }
        if (getOperationDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOperationDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOperationDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getReceiptClaimAmount() != null) {
            _hashCode += getReceiptClaimAmount().hashCode();
        }
        if (getReceiptNo() != null) {
            _hashCode += getReceiptNo().hashCode();
        }
        if (getWesternMedicineDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getWesternMedicineDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getWesternMedicineDTOs(), i);
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
        new org.apache.axis.description.TypeDesc(BirthClinicReceiptDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "BirthClinicReceiptDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clinicDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clinicDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costItemDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "costItemDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CostItemDTO"));
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
        elemField.setFieldName("hospitalCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hospitalCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operationDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operationDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "OperationDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiptClaimAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receiptClaimAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiptNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receiptNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("westernMedicineDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "westernMedicineDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "WesternMedicineDTO"));
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
