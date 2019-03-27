/**
 * ApprovalReceiptDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class ApprovalReceiptDTO  implements java.io.Serializable {
    private java.math.BigDecimal clinicMoney;

    private java.util.Calendar clinicStartDate;

    private java.math.BigDecimal mutualFundPayA;

    private java.math.BigDecimal mutualFundPayB;

    private java.math.BigDecimal overallFinancingPayment;

    private java.math.BigDecimal overallFinancingYearPayment;

    private java.math.BigDecimal ownExpense;

    private java.math.BigDecimal paymentA;

    private java.math.BigDecimal paymentB;

    public ApprovalReceiptDTO() {
    }

    public ApprovalReceiptDTO(
           java.math.BigDecimal clinicMoney,
           java.util.Calendar clinicStartDate,
           java.math.BigDecimal mutualFundPayA,
           java.math.BigDecimal mutualFundPayB,
           java.math.BigDecimal overallFinancingPayment,
           java.math.BigDecimal overallFinancingYearPayment,
           java.math.BigDecimal ownExpense,
           java.math.BigDecimal paymentA,
           java.math.BigDecimal paymentB) {
           this.clinicMoney = clinicMoney;
           this.clinicStartDate = clinicStartDate;
           this.mutualFundPayA = mutualFundPayA;
           this.mutualFundPayB = mutualFundPayB;
           this.overallFinancingPayment = overallFinancingPayment;
           this.overallFinancingYearPayment = overallFinancingYearPayment;
           this.ownExpense = ownExpense;
           this.paymentA = paymentA;
           this.paymentB = paymentB;
    }


    /**
     * Gets the clinicMoney value for this ApprovalReceiptDTO.
     * 
     * @return clinicMoney
     */
    public java.math.BigDecimal getClinicMoney() {
        return clinicMoney;
    }


    /**
     * Sets the clinicMoney value for this ApprovalReceiptDTO.
     * 
     * @param clinicMoney
     */
    public void setClinicMoney(java.math.BigDecimal clinicMoney) {
        this.clinicMoney = clinicMoney;
    }


    /**
     * Gets the clinicStartDate value for this ApprovalReceiptDTO.
     * 
     * @return clinicStartDate
     */
    public java.util.Calendar getClinicStartDate() {
        return clinicStartDate;
    }


    /**
     * Sets the clinicStartDate value for this ApprovalReceiptDTO.
     * 
     * @param clinicStartDate
     */
    public void setClinicStartDate(java.util.Calendar clinicStartDate) {
        this.clinicStartDate = clinicStartDate;
    }


    /**
     * Gets the mutualFundPayA value for this ApprovalReceiptDTO.
     * 
     * @return mutualFundPayA
     */
    public java.math.BigDecimal getMutualFundPayA() {
        return mutualFundPayA;
    }


    /**
     * Sets the mutualFundPayA value for this ApprovalReceiptDTO.
     * 
     * @param mutualFundPayA
     */
    public void setMutualFundPayA(java.math.BigDecimal mutualFundPayA) {
        this.mutualFundPayA = mutualFundPayA;
    }


    /**
     * Gets the mutualFundPayB value for this ApprovalReceiptDTO.
     * 
     * @return mutualFundPayB
     */
    public java.math.BigDecimal getMutualFundPayB() {
        return mutualFundPayB;
    }


    /**
     * Sets the mutualFundPayB value for this ApprovalReceiptDTO.
     * 
     * @param mutualFundPayB
     */
    public void setMutualFundPayB(java.math.BigDecimal mutualFundPayB) {
        this.mutualFundPayB = mutualFundPayB;
    }


    /**
     * Gets the overallFinancingPayment value for this ApprovalReceiptDTO.
     * 
     * @return overallFinancingPayment
     */
    public java.math.BigDecimal getOverallFinancingPayment() {
        return overallFinancingPayment;
    }


    /**
     * Sets the overallFinancingPayment value for this ApprovalReceiptDTO.
     * 
     * @param overallFinancingPayment
     */
    public void setOverallFinancingPayment(java.math.BigDecimal overallFinancingPayment) {
        this.overallFinancingPayment = overallFinancingPayment;
    }


    /**
     * Gets the overallFinancingYearPayment value for this ApprovalReceiptDTO.
     * 
     * @return overallFinancingYearPayment
     */
    public java.math.BigDecimal getOverallFinancingYearPayment() {
        return overallFinancingYearPayment;
    }


    /**
     * Sets the overallFinancingYearPayment value for this ApprovalReceiptDTO.
     * 
     * @param overallFinancingYearPayment
     */
    public void setOverallFinancingYearPayment(java.math.BigDecimal overallFinancingYearPayment) {
        this.overallFinancingYearPayment = overallFinancingYearPayment;
    }


    /**
     * Gets the ownExpense value for this ApprovalReceiptDTO.
     * 
     * @return ownExpense
     */
    public java.math.BigDecimal getOwnExpense() {
        return ownExpense;
    }


    /**
     * Sets the ownExpense value for this ApprovalReceiptDTO.
     * 
     * @param ownExpense
     */
    public void setOwnExpense(java.math.BigDecimal ownExpense) {
        this.ownExpense = ownExpense;
    }


    /**
     * Gets the paymentA value for this ApprovalReceiptDTO.
     * 
     * @return paymentA
     */
    public java.math.BigDecimal getPaymentA() {
        return paymentA;
    }


    /**
     * Sets the paymentA value for this ApprovalReceiptDTO.
     * 
     * @param paymentA
     */
    public void setPaymentA(java.math.BigDecimal paymentA) {
        this.paymentA = paymentA;
    }


    /**
     * Gets the paymentB value for this ApprovalReceiptDTO.
     * 
     * @return paymentB
     */
    public java.math.BigDecimal getPaymentB() {
        return paymentB;
    }


    /**
     * Sets the paymentB value for this ApprovalReceiptDTO.
     * 
     * @param paymentB
     */
    public void setPaymentB(java.math.BigDecimal paymentB) {
        this.paymentB = paymentB;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ApprovalReceiptDTO)) return false;
        ApprovalReceiptDTO other = (ApprovalReceiptDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.clinicMoney==null && other.getClinicMoney()==null) || 
             (this.clinicMoney!=null &&
              this.clinicMoney.equals(other.getClinicMoney()))) &&
            ((this.clinicStartDate==null && other.getClinicStartDate()==null) || 
             (this.clinicStartDate!=null &&
              this.clinicStartDate.equals(other.getClinicStartDate()))) &&
            ((this.mutualFundPayA==null && other.getMutualFundPayA()==null) || 
             (this.mutualFundPayA!=null &&
              this.mutualFundPayA.equals(other.getMutualFundPayA()))) &&
            ((this.mutualFundPayB==null && other.getMutualFundPayB()==null) || 
             (this.mutualFundPayB!=null &&
              this.mutualFundPayB.equals(other.getMutualFundPayB()))) &&
            ((this.overallFinancingPayment==null && other.getOverallFinancingPayment()==null) || 
             (this.overallFinancingPayment!=null &&
              this.overallFinancingPayment.equals(other.getOverallFinancingPayment()))) &&
            ((this.overallFinancingYearPayment==null && other.getOverallFinancingYearPayment()==null) || 
             (this.overallFinancingYearPayment!=null &&
              this.overallFinancingYearPayment.equals(other.getOverallFinancingYearPayment()))) &&
            ((this.ownExpense==null && other.getOwnExpense()==null) || 
             (this.ownExpense!=null &&
              this.ownExpense.equals(other.getOwnExpense()))) &&
            ((this.paymentA==null && other.getPaymentA()==null) || 
             (this.paymentA!=null &&
              this.paymentA.equals(other.getPaymentA()))) &&
            ((this.paymentB==null && other.getPaymentB()==null) || 
             (this.paymentB!=null &&
              this.paymentB.equals(other.getPaymentB())));
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
        if (getClinicMoney() != null) {
            _hashCode += getClinicMoney().hashCode();
        }
        if (getClinicStartDate() != null) {
            _hashCode += getClinicStartDate().hashCode();
        }
        if (getMutualFundPayA() != null) {
            _hashCode += getMutualFundPayA().hashCode();
        }
        if (getMutualFundPayB() != null) {
            _hashCode += getMutualFundPayB().hashCode();
        }
        if (getOverallFinancingPayment() != null) {
            _hashCode += getOverallFinancingPayment().hashCode();
        }
        if (getOverallFinancingYearPayment() != null) {
            _hashCode += getOverallFinancingYearPayment().hashCode();
        }
        if (getOwnExpense() != null) {
            _hashCode += getOwnExpense().hashCode();
        }
        if (getPaymentA() != null) {
            _hashCode += getPaymentA().hashCode();
        }
        if (getPaymentB() != null) {
            _hashCode += getPaymentB().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ApprovalReceiptDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ApprovalReceiptDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clinicMoney");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clinicMoney"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clinicStartDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clinicStartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mutualFundPayA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mutualFundPayA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mutualFundPayB");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mutualFundPayB"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overallFinancingPayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "overallFinancingPayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overallFinancingYearPayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "overallFinancingYearPayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownExpense");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ownExpense"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentB");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentB"));
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
