/**
 * HospitalReceiptDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class HospitalReceiptDTO  implements java.io.Serializable {
    private java.math.BigDecimal accountPayment;

    private java.math.BigDecimal besideInsurancePayment;

    private java.math.BigDecimal cash;

    private java.math.BigDecimal civilServants;

    private java.math.BigDecimal coOrdinationFund;

    private com.ebao.health.insurance.dto.CostItemDTO[] costItemDTOs;

    private java.util.Calendar dischardeDate;

    private java.lang.String hospitalCode;

    private java.util.Calendar hospitalDate;

    private java.math.BigDecimal hospitalMoney;

    private java.math.BigDecimal hospitalStay;

    private java.math.BigDecimal insurancePayment;

    private java.math.BigDecimal medicalPayment;

    private java.math.BigDecimal mutualPayment;

    private java.lang.String operation;

    private com.ebao.health.insurance.dto.OperationDTO[] operationDTOs;

    private java.math.BigDecimal ownExpense;

    private java.math.BigDecimal paymentA;

    private java.math.BigDecimal paymentB;

    private java.math.BigDecimal paymentFrom;

    private java.math.BigDecimal receiptClaimAmount;

    private java.lang.String receiptNo;

    private java.math.BigDecimal totalOwnExpense;

    private com.ebao.health.insurance.dto.WesternMedicineDTO[] westernMedicineDTOs;

    public HospitalReceiptDTO() {
    }

    public HospitalReceiptDTO(
           java.math.BigDecimal accountPayment,
           java.math.BigDecimal besideInsurancePayment,
           java.math.BigDecimal cash,
           java.math.BigDecimal civilServants,
           java.math.BigDecimal coOrdinationFund,
           com.ebao.health.insurance.dto.CostItemDTO[] costItemDTOs,
           java.util.Calendar dischardeDate,
           java.lang.String hospitalCode,
           java.util.Calendar hospitalDate,
           java.math.BigDecimal hospitalMoney,
           java.math.BigDecimal hospitalStay,
           java.math.BigDecimal insurancePayment,
           java.math.BigDecimal medicalPayment,
           java.math.BigDecimal mutualPayment,
           java.lang.String operation,
           com.ebao.health.insurance.dto.OperationDTO[] operationDTOs,
           java.math.BigDecimal ownExpense,
           java.math.BigDecimal paymentA,
           java.math.BigDecimal paymentB,
           java.math.BigDecimal paymentFrom,
           java.math.BigDecimal receiptClaimAmount,
           java.lang.String receiptNo,
           java.math.BigDecimal totalOwnExpense,
           com.ebao.health.insurance.dto.WesternMedicineDTO[] westernMedicineDTOs) {
           this.accountPayment = accountPayment;
           this.besideInsurancePayment = besideInsurancePayment;
           this.cash = cash;
           this.civilServants = civilServants;
           this.coOrdinationFund = coOrdinationFund;
           this.costItemDTOs = costItemDTOs;
           this.dischardeDate = dischardeDate;
           this.hospitalCode = hospitalCode;
           this.hospitalDate = hospitalDate;
           this.hospitalMoney = hospitalMoney;
           this.hospitalStay = hospitalStay;
           this.insurancePayment = insurancePayment;
           this.medicalPayment = medicalPayment;
           this.mutualPayment = mutualPayment;
           this.operation = operation;
           this.operationDTOs = operationDTOs;
           this.ownExpense = ownExpense;
           this.paymentA = paymentA;
           this.paymentB = paymentB;
           this.paymentFrom = paymentFrom;
           this.receiptClaimAmount = receiptClaimAmount;
           this.receiptNo = receiptNo;
           this.totalOwnExpense = totalOwnExpense;
           this.westernMedicineDTOs = westernMedicineDTOs;
    }


    /**
     * Gets the accountPayment value for this HospitalReceiptDTO.
     * 
     * @return accountPayment
     */
    public java.math.BigDecimal getAccountPayment() {
        return accountPayment;
    }


    /**
     * Sets the accountPayment value for this HospitalReceiptDTO.
     * 
     * @param accountPayment
     */
    public void setAccountPayment(java.math.BigDecimal accountPayment) {
        this.accountPayment = accountPayment;
    }


    /**
     * Gets the besideInsurancePayment value for this HospitalReceiptDTO.
     * 
     * @return besideInsurancePayment
     */
    public java.math.BigDecimal getBesideInsurancePayment() {
        return besideInsurancePayment;
    }


    /**
     * Sets the besideInsurancePayment value for this HospitalReceiptDTO.
     * 
     * @param besideInsurancePayment
     */
    public void setBesideInsurancePayment(java.math.BigDecimal besideInsurancePayment) {
        this.besideInsurancePayment = besideInsurancePayment;
    }


    /**
     * Gets the cash value for this HospitalReceiptDTO.
     * 
     * @return cash
     */
    public java.math.BigDecimal getCash() {
        return cash;
    }


    /**
     * Sets the cash value for this HospitalReceiptDTO.
     * 
     * @param cash
     */
    public void setCash(java.math.BigDecimal cash) {
        this.cash = cash;
    }


    /**
     * Gets the civilServants value for this HospitalReceiptDTO.
     * 
     * @return civilServants
     */
    public java.math.BigDecimal getCivilServants() {
        return civilServants;
    }


    /**
     * Sets the civilServants value for this HospitalReceiptDTO.
     * 
     * @param civilServants
     */
    public void setCivilServants(java.math.BigDecimal civilServants) {
        this.civilServants = civilServants;
    }


    /**
     * Gets the coOrdinationFund value for this HospitalReceiptDTO.
     * 
     * @return coOrdinationFund
     */
    public java.math.BigDecimal getCoOrdinationFund() {
        return coOrdinationFund;
    }


    /**
     * Sets the coOrdinationFund value for this HospitalReceiptDTO.
     * 
     * @param coOrdinationFund
     */
    public void setCoOrdinationFund(java.math.BigDecimal coOrdinationFund) {
        this.coOrdinationFund = coOrdinationFund;
    }


    /**
     * Gets the costItemDTOs value for this HospitalReceiptDTO.
     * 
     * @return costItemDTOs
     */
    public com.ebao.health.insurance.dto.CostItemDTO[] getCostItemDTOs() {
        return costItemDTOs;
    }


    /**
     * Sets the costItemDTOs value for this HospitalReceiptDTO.
     * 
     * @param costItemDTOs
     */
    public void setCostItemDTOs(com.ebao.health.insurance.dto.CostItemDTO[] costItemDTOs) {
        this.costItemDTOs = costItemDTOs;
    }


    /**
     * Gets the dischardeDate value for this HospitalReceiptDTO.
     * 
     * @return dischardeDate
     */
    public java.util.Calendar getDischardeDate() {
        return dischardeDate;
    }


    /**
     * Sets the dischardeDate value for this HospitalReceiptDTO.
     * 
     * @param dischardeDate
     */
    public void setDischardeDate(java.util.Calendar dischardeDate) {
        this.dischardeDate = dischardeDate;
    }


    /**
     * Gets the hospitalCode value for this HospitalReceiptDTO.
     * 
     * @return hospitalCode
     */
    public java.lang.String getHospitalCode() {
        return hospitalCode;
    }


    /**
     * Sets the hospitalCode value for this HospitalReceiptDTO.
     * 
     * @param hospitalCode
     */
    public void setHospitalCode(java.lang.String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }


    /**
     * Gets the hospitalDate value for this HospitalReceiptDTO.
     * 
     * @return hospitalDate
     */
    public java.util.Calendar getHospitalDate() {
        return hospitalDate;
    }


    /**
     * Sets the hospitalDate value for this HospitalReceiptDTO.
     * 
     * @param hospitalDate
     */
    public void setHospitalDate(java.util.Calendar hospitalDate) {
        this.hospitalDate = hospitalDate;
    }


    /**
     * Gets the hospitalMoney value for this HospitalReceiptDTO.
     * 
     * @return hospitalMoney
     */
    public java.math.BigDecimal getHospitalMoney() {
        return hospitalMoney;
    }


    /**
     * Sets the hospitalMoney value for this HospitalReceiptDTO.
     * 
     * @param hospitalMoney
     */
    public void setHospitalMoney(java.math.BigDecimal hospitalMoney) {
        this.hospitalMoney = hospitalMoney;
    }


    /**
     * Gets the hospitalStay value for this HospitalReceiptDTO.
     * 
     * @return hospitalStay
     */
    public java.math.BigDecimal getHospitalStay() {
        return hospitalStay;
    }


    /**
     * Sets the hospitalStay value for this HospitalReceiptDTO.
     * 
     * @param hospitalStay
     */
    public void setHospitalStay(java.math.BigDecimal hospitalStay) {
        this.hospitalStay = hospitalStay;
    }


    /**
     * Gets the insurancePayment value for this HospitalReceiptDTO.
     * 
     * @return insurancePayment
     */
    public java.math.BigDecimal getInsurancePayment() {
        return insurancePayment;
    }


    /**
     * Sets the insurancePayment value for this HospitalReceiptDTO.
     * 
     * @param insurancePayment
     */
    public void setInsurancePayment(java.math.BigDecimal insurancePayment) {
        this.insurancePayment = insurancePayment;
    }


    /**
     * Gets the medicalPayment value for this HospitalReceiptDTO.
     * 
     * @return medicalPayment
     */
    public java.math.BigDecimal getMedicalPayment() {
        return medicalPayment;
    }


    /**
     * Sets the medicalPayment value for this HospitalReceiptDTO.
     * 
     * @param medicalPayment
     */
    public void setMedicalPayment(java.math.BigDecimal medicalPayment) {
        this.medicalPayment = medicalPayment;
    }


    /**
     * Gets the mutualPayment value for this HospitalReceiptDTO.
     * 
     * @return mutualPayment
     */
    public java.math.BigDecimal getMutualPayment() {
        return mutualPayment;
    }


    /**
     * Sets the mutualPayment value for this HospitalReceiptDTO.
     * 
     * @param mutualPayment
     */
    public void setMutualPayment(java.math.BigDecimal mutualPayment) {
        this.mutualPayment = mutualPayment;
    }


    /**
     * Gets the operation value for this HospitalReceiptDTO.
     * 
     * @return operation
     */
    public java.lang.String getOperation() {
        return operation;
    }


    /**
     * Sets the operation value for this HospitalReceiptDTO.
     * 
     * @param operation
     */
    public void setOperation(java.lang.String operation) {
        this.operation = operation;
    }


    /**
     * Gets the operationDTOs value for this HospitalReceiptDTO.
     * 
     * @return operationDTOs
     */
    public com.ebao.health.insurance.dto.OperationDTO[] getOperationDTOs() {
        return operationDTOs;
    }


    /**
     * Sets the operationDTOs value for this HospitalReceiptDTO.
     * 
     * @param operationDTOs
     */
    public void setOperationDTOs(com.ebao.health.insurance.dto.OperationDTO[] operationDTOs) {
        this.operationDTOs = operationDTOs;
    }


    /**
     * Gets the ownExpense value for this HospitalReceiptDTO.
     * 
     * @return ownExpense
     */
    public java.math.BigDecimal getOwnExpense() {
        return ownExpense;
    }


    /**
     * Sets the ownExpense value for this HospitalReceiptDTO.
     * 
     * @param ownExpense
     */
    public void setOwnExpense(java.math.BigDecimal ownExpense) {
        this.ownExpense = ownExpense;
    }


    /**
     * Gets the paymentA value for this HospitalReceiptDTO.
     * 
     * @return paymentA
     */
    public java.math.BigDecimal getPaymentA() {
        return paymentA;
    }


    /**
     * Sets the paymentA value for this HospitalReceiptDTO.
     * 
     * @param paymentA
     */
    public void setPaymentA(java.math.BigDecimal paymentA) {
        this.paymentA = paymentA;
    }


    /**
     * Gets the paymentB value for this HospitalReceiptDTO.
     * 
     * @return paymentB
     */
    public java.math.BigDecimal getPaymentB() {
        return paymentB;
    }


    /**
     * Sets the paymentB value for this HospitalReceiptDTO.
     * 
     * @param paymentB
     */
    public void setPaymentB(java.math.BigDecimal paymentB) {
        this.paymentB = paymentB;
    }


    /**
     * Gets the paymentFrom value for this HospitalReceiptDTO.
     * 
     * @return paymentFrom
     */
    public java.math.BigDecimal getPaymentFrom() {
        return paymentFrom;
    }


    /**
     * Sets the paymentFrom value for this HospitalReceiptDTO.
     * 
     * @param paymentFrom
     */
    public void setPaymentFrom(java.math.BigDecimal paymentFrom) {
        this.paymentFrom = paymentFrom;
    }


    /**
     * Gets the receiptClaimAmount value for this HospitalReceiptDTO.
     * 
     * @return receiptClaimAmount
     */
    public java.math.BigDecimal getReceiptClaimAmount() {
        return receiptClaimAmount;
    }


    /**
     * Sets the receiptClaimAmount value for this HospitalReceiptDTO.
     * 
     * @param receiptClaimAmount
     */
    public void setReceiptClaimAmount(java.math.BigDecimal receiptClaimAmount) {
        this.receiptClaimAmount = receiptClaimAmount;
    }


    /**
     * Gets the receiptNo value for this HospitalReceiptDTO.
     * 
     * @return receiptNo
     */
    public java.lang.String getReceiptNo() {
        return receiptNo;
    }


    /**
     * Sets the receiptNo value for this HospitalReceiptDTO.
     * 
     * @param receiptNo
     */
    public void setReceiptNo(java.lang.String receiptNo) {
        this.receiptNo = receiptNo;
    }


    /**
     * Gets the totalOwnExpense value for this HospitalReceiptDTO.
     * 
     * @return totalOwnExpense
     */
    public java.math.BigDecimal getTotalOwnExpense() {
        return totalOwnExpense;
    }


    /**
     * Sets the totalOwnExpense value for this HospitalReceiptDTO.
     * 
     * @param totalOwnExpense
     */
    public void setTotalOwnExpense(java.math.BigDecimal totalOwnExpense) {
        this.totalOwnExpense = totalOwnExpense;
    }


    /**
     * Gets the westernMedicineDTOs value for this HospitalReceiptDTO.
     * 
     * @return westernMedicineDTOs
     */
    public com.ebao.health.insurance.dto.WesternMedicineDTO[] getWesternMedicineDTOs() {
        return westernMedicineDTOs;
    }


    /**
     * Sets the westernMedicineDTOs value for this HospitalReceiptDTO.
     * 
     * @param westernMedicineDTOs
     */
    public void setWesternMedicineDTOs(com.ebao.health.insurance.dto.WesternMedicineDTO[] westernMedicineDTOs) {
        this.westernMedicineDTOs = westernMedicineDTOs;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HospitalReceiptDTO)) return false;
        HospitalReceiptDTO other = (HospitalReceiptDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accountPayment==null && other.getAccountPayment()==null) || 
             (this.accountPayment!=null &&
              this.accountPayment.equals(other.getAccountPayment()))) &&
            ((this.besideInsurancePayment==null && other.getBesideInsurancePayment()==null) || 
             (this.besideInsurancePayment!=null &&
              this.besideInsurancePayment.equals(other.getBesideInsurancePayment()))) &&
            ((this.cash==null && other.getCash()==null) || 
             (this.cash!=null &&
              this.cash.equals(other.getCash()))) &&
            ((this.civilServants==null && other.getCivilServants()==null) || 
             (this.civilServants!=null &&
              this.civilServants.equals(other.getCivilServants()))) &&
            ((this.coOrdinationFund==null && other.getCoOrdinationFund()==null) || 
             (this.coOrdinationFund!=null &&
              this.coOrdinationFund.equals(other.getCoOrdinationFund()))) &&
            ((this.costItemDTOs==null && other.getCostItemDTOs()==null) || 
             (this.costItemDTOs!=null &&
              java.util.Arrays.equals(this.costItemDTOs, other.getCostItemDTOs()))) &&
            ((this.dischardeDate==null && other.getDischardeDate()==null) || 
             (this.dischardeDate!=null &&
              this.dischardeDate.equals(other.getDischardeDate()))) &&
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
            ((this.insurancePayment==null && other.getInsurancePayment()==null) || 
             (this.insurancePayment!=null &&
              this.insurancePayment.equals(other.getInsurancePayment()))) &&
            ((this.medicalPayment==null && other.getMedicalPayment()==null) || 
             (this.medicalPayment!=null &&
              this.medicalPayment.equals(other.getMedicalPayment()))) &&
            ((this.mutualPayment==null && other.getMutualPayment()==null) || 
             (this.mutualPayment!=null &&
              this.mutualPayment.equals(other.getMutualPayment()))) &&
            ((this.operation==null && other.getOperation()==null) || 
             (this.operation!=null &&
              this.operation.equals(other.getOperation()))) &&
            ((this.operationDTOs==null && other.getOperationDTOs()==null) || 
             (this.operationDTOs!=null &&
              java.util.Arrays.equals(this.operationDTOs, other.getOperationDTOs()))) &&
            ((this.ownExpense==null && other.getOwnExpense()==null) || 
             (this.ownExpense!=null &&
              this.ownExpense.equals(other.getOwnExpense()))) &&
            ((this.paymentA==null && other.getPaymentA()==null) || 
             (this.paymentA!=null &&
              this.paymentA.equals(other.getPaymentA()))) &&
            ((this.paymentB==null && other.getPaymentB()==null) || 
             (this.paymentB!=null &&
              this.paymentB.equals(other.getPaymentB()))) &&
            ((this.paymentFrom==null && other.getPaymentFrom()==null) || 
             (this.paymentFrom!=null &&
              this.paymentFrom.equals(other.getPaymentFrom()))) &&
            ((this.receiptClaimAmount==null && other.getReceiptClaimAmount()==null) || 
             (this.receiptClaimAmount!=null &&
              this.receiptClaimAmount.equals(other.getReceiptClaimAmount()))) &&
            ((this.receiptNo==null && other.getReceiptNo()==null) || 
             (this.receiptNo!=null &&
              this.receiptNo.equals(other.getReceiptNo()))) &&
            ((this.totalOwnExpense==null && other.getTotalOwnExpense()==null) || 
             (this.totalOwnExpense!=null &&
              this.totalOwnExpense.equals(other.getTotalOwnExpense()))) &&
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
        if (getAccountPayment() != null) {
            _hashCode += getAccountPayment().hashCode();
        }
        if (getBesideInsurancePayment() != null) {
            _hashCode += getBesideInsurancePayment().hashCode();
        }
        if (getCash() != null) {
            _hashCode += getCash().hashCode();
        }
        if (getCivilServants() != null) {
            _hashCode += getCivilServants().hashCode();
        }
        if (getCoOrdinationFund() != null) {
            _hashCode += getCoOrdinationFund().hashCode();
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
        if (getDischardeDate() != null) {
            _hashCode += getDischardeDate().hashCode();
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
        if (getInsurancePayment() != null) {
            _hashCode += getInsurancePayment().hashCode();
        }
        if (getMedicalPayment() != null) {
            _hashCode += getMedicalPayment().hashCode();
        }
        if (getMutualPayment() != null) {
            _hashCode += getMutualPayment().hashCode();
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
        if (getOwnExpense() != null) {
            _hashCode += getOwnExpense().hashCode();
        }
        if (getPaymentA() != null) {
            _hashCode += getPaymentA().hashCode();
        }
        if (getPaymentB() != null) {
            _hashCode += getPaymentB().hashCode();
        }
        if (getPaymentFrom() != null) {
            _hashCode += getPaymentFrom().hashCode();
        }
        if (getReceiptClaimAmount() != null) {
            _hashCode += getReceiptClaimAmount().hashCode();
        }
        if (getReceiptNo() != null) {
            _hashCode += getReceiptNo().hashCode();
        }
        if (getTotalOwnExpense() != null) {
            _hashCode += getTotalOwnExpense().hashCode();
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
        new org.apache.axis.description.TypeDesc(HospitalReceiptDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "HospitalReceiptDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountPayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accountPayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("besideInsurancePayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "besideInsurancePayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cash");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cash"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("civilServants");
        elemField.setXmlName(new javax.xml.namespace.QName("", "civilServants"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coOrdinationFund");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coOrdinationFund"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("insurancePayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insurancePayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("medicalPayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "medicalPayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mutualPayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mutualPayment"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentFrom");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentFrom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
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
        elemField.setFieldName("totalOwnExpense");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalOwnExpense"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
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
