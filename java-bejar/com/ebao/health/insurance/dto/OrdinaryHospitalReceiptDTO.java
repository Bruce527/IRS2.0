/**
 * OrdinaryHospitalReceiptDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class OrdinaryHospitalReceiptDTO  implements java.io.Serializable {
    private com.ebao.health.insurance.dto.CostItemDTO[] costItemDTOs;

    private java.util.Calendar dischardeDate;

    private java.math.BigDecimal feeDeductibleAmount;

    private java.lang.String hospitalCode;

    private java.util.Calendar hospitalDate;

    private java.math.BigDecimal hospitalMoney;

    private java.math.BigDecimal hospitalStay;

    private java.lang.String operation;

    private com.ebao.health.insurance.dto.OperationDTO[] operationDTOs;

    private java.math.BigDecimal receiptClaimAmount;

    private java.lang.String receiptNo;

    private com.ebao.health.insurance.dto.WesternMedicineDTO[] westernMedicineDTOs;

    public OrdinaryHospitalReceiptDTO() {
    }

    public OrdinaryHospitalReceiptDTO(
           com.ebao.health.insurance.dto.CostItemDTO[] costItemDTOs,
           java.util.Calendar dischardeDate,
           java.math.BigDecimal feeDeductibleAmount,
           java.lang.String hospitalCode,
           java.util.Calendar hospitalDate,
           java.math.BigDecimal hospitalMoney,
           java.math.BigDecimal hospitalStay,
           java.lang.String operation,
           com.ebao.health.insurance.dto.OperationDTO[] operationDTOs,
           java.math.BigDecimal receiptClaimAmount,
           java.lang.String receiptNo,
           com.ebao.health.insurance.dto.WesternMedicineDTO[] westernMedicineDTOs) {
           this.costItemDTOs = costItemDTOs;
           this.dischardeDate = dischardeDate;
           this.feeDeductibleAmount = feeDeductibleAmount;
           this.hospitalCode = hospitalCode;
           this.hospitalDate = hospitalDate;
           this.hospitalMoney = hospitalMoney;
           this.hospitalStay = hospitalStay;
           this.operation = operation;
           this.operationDTOs = operationDTOs;
           this.receiptClaimAmount = receiptClaimAmount;
           this.receiptNo = receiptNo;
           this.westernMedicineDTOs = westernMedicineDTOs;
    }


    /**
     * Gets the costItemDTOs value for this OrdinaryHospitalReceiptDTO.
     * 
     * @return costItemDTOs
     */
    public com.ebao.health.insurance.dto.CostItemDTO[] getCostItemDTOs() {
        return costItemDTOs;
    }


    /**
     * Sets the costItemDTOs value for this OrdinaryHospitalReceiptDTO.
     * 
     * @param costItemDTOs
     */
    public void setCostItemDTOs(com.ebao.health.insurance.dto.CostItemDTO[] costItemDTOs) {
        this.costItemDTOs = costItemDTOs;
    }


    /**
     * Gets the dischardeDate value for this OrdinaryHospitalReceiptDTO.
     * 
     * @return dischardeDate
     */
    public java.util.Calendar getDischardeDate() {
        return dischardeDate;
    }


    /**
     * Sets the dischardeDate value for this OrdinaryHospitalReceiptDTO.
     * 
     * @param dischardeDate
     */
    public void setDischardeDate(java.util.Calendar dischardeDate) {
        this.dischardeDate = dischardeDate;
    }


    /**
     * Gets the feeDeductibleAmount value for this OrdinaryHospitalReceiptDTO.
     * 
     * @return feeDeductibleAmount
     */
    public java.math.BigDecimal getFeeDeductibleAmount() {
        return feeDeductibleAmount;
    }


    /**
     * Sets the feeDeductibleAmount value for this OrdinaryHospitalReceiptDTO.
     * 
     * @param feeDeductibleAmount
     */
    public void setFeeDeductibleAmount(java.math.BigDecimal feeDeductibleAmount) {
        this.feeDeductibleAmount = feeDeductibleAmount;
    }


    /**
     * Gets the hospitalCode value for this OrdinaryHospitalReceiptDTO.
     * 
     * @return hospitalCode
     */
    public java.lang.String getHospitalCode() {
        return hospitalCode;
    }


    /**
     * Sets the hospitalCode value for this OrdinaryHospitalReceiptDTO.
     * 
     * @param hospitalCode
     */
    public void setHospitalCode(java.lang.String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }


    /**
     * Gets the hospitalDate value for this OrdinaryHospitalReceiptDTO.
     * 
     * @return hospitalDate
     */
    public java.util.Calendar getHospitalDate() {
        return hospitalDate;
    }


    /**
     * Sets the hospitalDate value for this OrdinaryHospitalReceiptDTO.
     * 
     * @param hospitalDate
     */
    public void setHospitalDate(java.util.Calendar hospitalDate) {
        this.hospitalDate = hospitalDate;
    }


    /**
     * Gets the hospitalMoney value for this OrdinaryHospitalReceiptDTO.
     * 
     * @return hospitalMoney
     */
    public java.math.BigDecimal getHospitalMoney() {
        return hospitalMoney;
    }


    /**
     * Sets the hospitalMoney value for this OrdinaryHospitalReceiptDTO.
     * 
     * @param hospitalMoney
     */
    public void setHospitalMoney(java.math.BigDecimal hospitalMoney) {
        this.hospitalMoney = hospitalMoney;
    }


    /**
     * Gets the hospitalStay value for this OrdinaryHospitalReceiptDTO.
     * 
     * @return hospitalStay
     */
    public java.math.BigDecimal getHospitalStay() {
        return hospitalStay;
    }


    /**
     * Sets the hospitalStay value for this OrdinaryHospitalReceiptDTO.
     * 
     * @param hospitalStay
     */
    public void setHospitalStay(java.math.BigDecimal hospitalStay) {
        this.hospitalStay = hospitalStay;
    }


    /**
     * Gets the operation value for this OrdinaryHospitalReceiptDTO.
     * 
     * @return operation
     */
    public java.lang.String getOperation() {
        return operation;
    }


    /**
     * Sets the operation value for this OrdinaryHospitalReceiptDTO.
     * 
     * @param operation
     */
    public void setOperation(java.lang.String operation) {
        this.operation = operation;
    }


    /**
     * Gets the operationDTOs value for this OrdinaryHospitalReceiptDTO.
     * 
     * @return operationDTOs
     */
    public com.ebao.health.insurance.dto.OperationDTO[] getOperationDTOs() {
        return operationDTOs;
    }


    /**
     * Sets the operationDTOs value for this OrdinaryHospitalReceiptDTO.
     * 
     * @param operationDTOs
     */
    public void setOperationDTOs(com.ebao.health.insurance.dto.OperationDTO[] operationDTOs) {
        this.operationDTOs = operationDTOs;
    }


    /**
     * Gets the receiptClaimAmount value for this OrdinaryHospitalReceiptDTO.
     * 
     * @return receiptClaimAmount
     */
    public java.math.BigDecimal getReceiptClaimAmount() {
        return receiptClaimAmount;
    }


    /**
     * Sets the receiptClaimAmount value for this OrdinaryHospitalReceiptDTO.
     * 
     * @param receiptClaimAmount
     */
    public void setReceiptClaimAmount(java.math.BigDecimal receiptClaimAmount) {
        this.receiptClaimAmount = receiptClaimAmount;
    }


    /**
     * Gets the receiptNo value for this OrdinaryHospitalReceiptDTO.
     * 
     * @return receiptNo
     */
    public java.lang.String getReceiptNo() {
        return receiptNo;
    }


    /**
     * Sets the receiptNo value for this OrdinaryHospitalReceiptDTO.
     * 
     * @param receiptNo
     */
    public void setReceiptNo(java.lang.String receiptNo) {
        this.receiptNo = receiptNo;
    }


    /**
     * Gets the westernMedicineDTOs value for this OrdinaryHospitalReceiptDTO.
     * 
     * @return westernMedicineDTOs
     */
    public com.ebao.health.insurance.dto.WesternMedicineDTO[] getWesternMedicineDTOs() {
        return westernMedicineDTOs;
    }


    /**
     * Sets the westernMedicineDTOs value for this OrdinaryHospitalReceiptDTO.
     * 
     * @param westernMedicineDTOs
     */
    public void setWesternMedicineDTOs(com.ebao.health.insurance.dto.WesternMedicineDTO[] westernMedicineDTOs) {
        this.westernMedicineDTOs = westernMedicineDTOs;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OrdinaryHospitalReceiptDTO)) return false;
        OrdinaryHospitalReceiptDTO other = (OrdinaryHospitalReceiptDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.costItemDTOs==null && other.getCostItemDTOs()==null) || 
             (this.costItemDTOs!=null &&
              java.util.Arrays.equals(this.costItemDTOs, other.getCostItemDTOs()))) &&
            ((this.dischardeDate==null && other.getDischardeDate()==null) || 
             (this.dischardeDate!=null &&
              this.dischardeDate.equals(other.getDischardeDate()))) &&
            ((this.feeDeductibleAmount==null && other.getFeeDeductibleAmount()==null) || 
             (this.feeDeductibleAmount!=null &&
              this.feeDeductibleAmount.equals(other.getFeeDeductibleAmount()))) &&
            ((this.hospitalCode==null && other.getHospitalCode()==null) || 
             (this.hospitalCode!=null &&
              this.hospitalCode.equals(other.getHospitalCode()))) &&
            ((this.hospitalDate==null && other.getHospitalDate()==null) || 
             (this.hospitalDate!=null &&
              this.hospitalDate.equals(other.getHospitalDate()))) &&
            ((this.hospitalMoney==null && other.getHospitalMoney()==null) || 
             (this.hospitalMoney!=null &&
              this.hospitalMoney.equals(other.getHospitalMoney()))) &&
            ((this.hospitalStay==null && other.getHospitalStay()==null) || 
             (this.hospitalStay!=null &&
              this.hospitalStay.equals(other.getHospitalStay()))) &&
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
        if (getDischardeDate() != null) {
            _hashCode += getDischardeDate().hashCode();
        }
        if (getFeeDeductibleAmount() != null) {
            _hashCode += getFeeDeductibleAmount().hashCode();
        }
        if (getHospitalCode() != null) {
            _hashCode += getHospitalCode().hashCode();
        }
        if (getHospitalDate() != null) {
            _hashCode += getHospitalDate().hashCode();
        }
        if (getHospitalMoney() != null) {
            _hashCode += getHospitalMoney().hashCode();
        }
        if (getHospitalStay() != null) {
            _hashCode += getHospitalStay().hashCode();
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
        new org.apache.axis.description.TypeDesc(OrdinaryHospitalReceiptDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "OrdinaryHospitalReceiptDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costItemDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "costItemDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CostItemDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dischardeDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dischardeDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("hospitalDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hospitalDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hospitalMoney");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hospitalMoney"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hospitalStay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hospitalStay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
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
