/**
 * SpecialReceiptDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class SpecialReceiptDTO  implements java.io.Serializable {
    private java.math.BigDecimal accountBalance;

    private java.math.BigDecimal accountPayment;

    private java.math.BigDecimal cash;

    private java.math.BigDecimal civilServants;

    private java.util.Calendar clinicDate;

    private java.math.BigDecimal coOrdinationFund;

    private com.ebao.health.insurance.dto.CostItemDTO[] costItemDTOs;

    private java.math.BigDecimal disabilitySoldier;

    private java.lang.String hospitalCode;

    private java.math.BigDecimal individualPayment;

    private java.math.BigDecimal insurancePayment;

    private java.math.BigDecimal medicalPayment;

    private java.math.BigDecimal mutualPayment;

    private java.lang.String operation;

    private com.ebao.health.insurance.dto.OperationDTO[] operationDTOs;

    private java.math.BigDecimal ownExpense;

    private java.math.BigDecimal paymentA;

    private java.math.BigDecimal paymentB;

    private java.math.BigDecimal paymentCap;

    private java.math.BigDecimal paymentFrom;

    private java.lang.String receiptNo;

    private java.math.BigDecimal retirementPayment;

    private java.math.BigDecimal specialMoney;

    private com.ebao.health.insurance.dto.WesternMedicineDTO[] westernMedicineDTOs;

    private java.math.BigDecimal yearAnnualCoOrdinationfund;

    private java.math.BigDecimal yearAnnualMutualPayment;

    public SpecialReceiptDTO() {
    }

    public SpecialReceiptDTO(
           java.math.BigDecimal accountBalance,
           java.math.BigDecimal accountPayment,
           java.math.BigDecimal cash,
           java.math.BigDecimal civilServants,
           java.util.Calendar clinicDate,
           java.math.BigDecimal coOrdinationFund,
           com.ebao.health.insurance.dto.CostItemDTO[] costItemDTOs,
           java.math.BigDecimal disabilitySoldier,
           java.lang.String hospitalCode,
           java.math.BigDecimal individualPayment,
           java.math.BigDecimal insurancePayment,
           java.math.BigDecimal medicalPayment,
           java.math.BigDecimal mutualPayment,
           java.lang.String operation,
           com.ebao.health.insurance.dto.OperationDTO[] operationDTOs,
           java.math.BigDecimal ownExpense,
           java.math.BigDecimal paymentA,
           java.math.BigDecimal paymentB,
           java.math.BigDecimal paymentCap,
           java.math.BigDecimal paymentFrom,
           java.lang.String receiptNo,
           java.math.BigDecimal retirementPayment,
           java.math.BigDecimal specialMoney,
           com.ebao.health.insurance.dto.WesternMedicineDTO[] westernMedicineDTOs,
           java.math.BigDecimal yearAnnualCoOrdinationfund,
           java.math.BigDecimal yearAnnualMutualPayment) {
           this.accountBalance = accountBalance;
           this.accountPayment = accountPayment;
           this.cash = cash;
           this.civilServants = civilServants;
           this.clinicDate = clinicDate;
           this.coOrdinationFund = coOrdinationFund;
           this.costItemDTOs = costItemDTOs;
           this.disabilitySoldier = disabilitySoldier;
           this.hospitalCode = hospitalCode;
           this.individualPayment = individualPayment;
           this.insurancePayment = insurancePayment;
           this.medicalPayment = medicalPayment;
           this.mutualPayment = mutualPayment;
           this.operation = operation;
           this.operationDTOs = operationDTOs;
           this.ownExpense = ownExpense;
           this.paymentA = paymentA;
           this.paymentB = paymentB;
           this.paymentCap = paymentCap;
           this.paymentFrom = paymentFrom;
           this.receiptNo = receiptNo;
           this.retirementPayment = retirementPayment;
           this.specialMoney = specialMoney;
           this.westernMedicineDTOs = westernMedicineDTOs;
           this.yearAnnualCoOrdinationfund = yearAnnualCoOrdinationfund;
           this.yearAnnualMutualPayment = yearAnnualMutualPayment;
    }


    /**
     * Gets the accountBalance value for this SpecialReceiptDTO.
     * 
     * @return accountBalance
     */
    public java.math.BigDecimal getAccountBalance() {
        return accountBalance;
    }


    /**
     * Sets the accountBalance value for this SpecialReceiptDTO.
     * 
     * @param accountBalance
     */
    public void setAccountBalance(java.math.BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }


    /**
     * Gets the accountPayment value for this SpecialReceiptDTO.
     * 
     * @return accountPayment
     */
    public java.math.BigDecimal getAccountPayment() {
        return accountPayment;
    }


    /**
     * Sets the accountPayment value for this SpecialReceiptDTO.
     * 
     * @param accountPayment
     */
    public void setAccountPayment(java.math.BigDecimal accountPayment) {
        this.accountPayment = accountPayment;
    }


    /**
     * Gets the cash value for this SpecialReceiptDTO.
     * 
     * @return cash
     */
    public java.math.BigDecimal getCash() {
        return cash;
    }


    /**
     * Sets the cash value for this SpecialReceiptDTO.
     * 
     * @param cash
     */
    public void setCash(java.math.BigDecimal cash) {
        this.cash = cash;
    }


    /**
     * Gets the civilServants value for this SpecialReceiptDTO.
     * 
     * @return civilServants
     */
    public java.math.BigDecimal getCivilServants() {
        return civilServants;
    }


    /**
     * Sets the civilServants value for this SpecialReceiptDTO.
     * 
     * @param civilServants
     */
    public void setCivilServants(java.math.BigDecimal civilServants) {
        this.civilServants = civilServants;
    }


    /**
     * Gets the clinicDate value for this SpecialReceiptDTO.
     * 
     * @return clinicDate
     */
    public java.util.Calendar getClinicDate() {
        return clinicDate;
    }


    /**
     * Sets the clinicDate value for this SpecialReceiptDTO.
     * 
     * @param clinicDate
     */
    public void setClinicDate(java.util.Calendar clinicDate) {
        this.clinicDate = clinicDate;
    }


    /**
     * Gets the coOrdinationFund value for this SpecialReceiptDTO.
     * 
     * @return coOrdinationFund
     */
    public java.math.BigDecimal getCoOrdinationFund() {
        return coOrdinationFund;
    }


    /**
     * Sets the coOrdinationFund value for this SpecialReceiptDTO.
     * 
     * @param coOrdinationFund
     */
    public void setCoOrdinationFund(java.math.BigDecimal coOrdinationFund) {
        this.coOrdinationFund = coOrdinationFund;
    }


    /**
     * Gets the costItemDTOs value for this SpecialReceiptDTO.
     * 
     * @return costItemDTOs
     */
    public com.ebao.health.insurance.dto.CostItemDTO[] getCostItemDTOs() {
        return costItemDTOs;
    }


    /**
     * Sets the costItemDTOs value for this SpecialReceiptDTO.
     * 
     * @param costItemDTOs
     */
    public void setCostItemDTOs(com.ebao.health.insurance.dto.CostItemDTO[] costItemDTOs) {
        this.costItemDTOs = costItemDTOs;
    }


    /**
     * Gets the disabilitySoldier value for this SpecialReceiptDTO.
     * 
     * @return disabilitySoldier
     */
    public java.math.BigDecimal getDisabilitySoldier() {
        return disabilitySoldier;
    }


    /**
     * Sets the disabilitySoldier value for this SpecialReceiptDTO.
     * 
     * @param disabilitySoldier
     */
    public void setDisabilitySoldier(java.math.BigDecimal disabilitySoldier) {
        this.disabilitySoldier = disabilitySoldier;
    }


    /**
     * Gets the hospitalCode value for this SpecialReceiptDTO.
     * 
     * @return hospitalCode
     */
    public java.lang.String getHospitalCode() {
        return hospitalCode;
    }


    /**
     * Sets the hospitalCode value for this SpecialReceiptDTO.
     * 
     * @param hospitalCode
     */
    public void setHospitalCode(java.lang.String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }


    /**
     * Gets the individualPayment value for this SpecialReceiptDTO.
     * 
     * @return individualPayment
     */
    public java.math.BigDecimal getIndividualPayment() {
        return individualPayment;
    }


    /**
     * Sets the individualPayment value for this SpecialReceiptDTO.
     * 
     * @param individualPayment
     */
    public void setIndividualPayment(java.math.BigDecimal individualPayment) {
        this.individualPayment = individualPayment;
    }


    /**
     * Gets the insurancePayment value for this SpecialReceiptDTO.
     * 
     * @return insurancePayment
     */
    public java.math.BigDecimal getInsurancePayment() {
        return insurancePayment;
    }


    /**
     * Sets the insurancePayment value for this SpecialReceiptDTO.
     * 
     * @param insurancePayment
     */
    public void setInsurancePayment(java.math.BigDecimal insurancePayment) {
        this.insurancePayment = insurancePayment;
    }


    /**
     * Gets the medicalPayment value for this SpecialReceiptDTO.
     * 
     * @return medicalPayment
     */
    public java.math.BigDecimal getMedicalPayment() {
        return medicalPayment;
    }


    /**
     * Sets the medicalPayment value for this SpecialReceiptDTO.
     * 
     * @param medicalPayment
     */
    public void setMedicalPayment(java.math.BigDecimal medicalPayment) {
        this.medicalPayment = medicalPayment;
    }


    /**
     * Gets the mutualPayment value for this SpecialReceiptDTO.
     * 
     * @return mutualPayment
     */
    public java.math.BigDecimal getMutualPayment() {
        return mutualPayment;
    }


    /**
     * Sets the mutualPayment value for this SpecialReceiptDTO.
     * 
     * @param mutualPayment
     */
    public void setMutualPayment(java.math.BigDecimal mutualPayment) {
        this.mutualPayment = mutualPayment;
    }


    /**
     * Gets the operation value for this SpecialReceiptDTO.
     * 
     * @return operation
     */
    public java.lang.String getOperation() {
        return operation;
    }


    /**
     * Sets the operation value for this SpecialReceiptDTO.
     * 
     * @param operation
     */
    public void setOperation(java.lang.String operation) {
        this.operation = operation;
    }


    /**
     * Gets the operationDTOs value for this SpecialReceiptDTO.
     * 
     * @return operationDTOs
     */
    public com.ebao.health.insurance.dto.OperationDTO[] getOperationDTOs() {
        return operationDTOs;
    }


    /**
     * Sets the operationDTOs value for this SpecialReceiptDTO.
     * 
     * @param operationDTOs
     */
    public void setOperationDTOs(com.ebao.health.insurance.dto.OperationDTO[] operationDTOs) {
        this.operationDTOs = operationDTOs;
    }


    /**
     * Gets the ownExpense value for this SpecialReceiptDTO.
     * 
     * @return ownExpense
     */
    public java.math.BigDecimal getOwnExpense() {
        return ownExpense;
    }


    /**
     * Sets the ownExpense value for this SpecialReceiptDTO.
     * 
     * @param ownExpense
     */
    public void setOwnExpense(java.math.BigDecimal ownExpense) {
        this.ownExpense = ownExpense;
    }


    /**
     * Gets the paymentA value for this SpecialReceiptDTO.
     * 
     * @return paymentA
     */
    public java.math.BigDecimal getPaymentA() {
        return paymentA;
    }


    /**
     * Sets the paymentA value for this SpecialReceiptDTO.
     * 
     * @param paymentA
     */
    public void setPaymentA(java.math.BigDecimal paymentA) {
        this.paymentA = paymentA;
    }


    /**
     * Gets the paymentB value for this SpecialReceiptDTO.
     * 
     * @return paymentB
     */
    public java.math.BigDecimal getPaymentB() {
        return paymentB;
    }


    /**
     * Sets the paymentB value for this SpecialReceiptDTO.
     * 
     * @param paymentB
     */
    public void setPaymentB(java.math.BigDecimal paymentB) {
        this.paymentB = paymentB;
    }


    /**
     * Gets the paymentCap value for this SpecialReceiptDTO.
     * 
     * @return paymentCap
     */
    public java.math.BigDecimal getPaymentCap() {
        return paymentCap;
    }


    /**
     * Sets the paymentCap value for this SpecialReceiptDTO.
     * 
     * @param paymentCap
     */
    public void setPaymentCap(java.math.BigDecimal paymentCap) {
        this.paymentCap = paymentCap;
    }


    /**
     * Gets the paymentFrom value for this SpecialReceiptDTO.
     * 
     * @return paymentFrom
     */
    public java.math.BigDecimal getPaymentFrom() {
        return paymentFrom;
    }


    /**
     * Sets the paymentFrom value for this SpecialReceiptDTO.
     * 
     * @param paymentFrom
     */
    public void setPaymentFrom(java.math.BigDecimal paymentFrom) {
        this.paymentFrom = paymentFrom;
    }


    /**
     * Gets the receiptNo value for this SpecialReceiptDTO.
     * 
     * @return receiptNo
     */
    public java.lang.String getReceiptNo() {
        return receiptNo;
    }


    /**
     * Sets the receiptNo value for this SpecialReceiptDTO.
     * 
     * @param receiptNo
     */
    public void setReceiptNo(java.lang.String receiptNo) {
        this.receiptNo = receiptNo;
    }


    /**
     * Gets the retirementPayment value for this SpecialReceiptDTO.
     * 
     * @return retirementPayment
     */
    public java.math.BigDecimal getRetirementPayment() {
        return retirementPayment;
    }


    /**
     * Sets the retirementPayment value for this SpecialReceiptDTO.
     * 
     * @param retirementPayment
     */
    public void setRetirementPayment(java.math.BigDecimal retirementPayment) {
        this.retirementPayment = retirementPayment;
    }


    /**
     * Gets the specialMoney value for this SpecialReceiptDTO.
     * 
     * @return specialMoney
     */
    public java.math.BigDecimal getSpecialMoney() {
        return specialMoney;
    }


    /**
     * Sets the specialMoney value for this SpecialReceiptDTO.
     * 
     * @param specialMoney
     */
    public void setSpecialMoney(java.math.BigDecimal specialMoney) {
        this.specialMoney = specialMoney;
    }


    /**
     * Gets the westernMedicineDTOs value for this SpecialReceiptDTO.
     * 
     * @return westernMedicineDTOs
     */
    public com.ebao.health.insurance.dto.WesternMedicineDTO[] getWesternMedicineDTOs() {
        return westernMedicineDTOs;
    }


    /**
     * Sets the westernMedicineDTOs value for this SpecialReceiptDTO.
     * 
     * @param westernMedicineDTOs
     */
    public void setWesternMedicineDTOs(com.ebao.health.insurance.dto.WesternMedicineDTO[] westernMedicineDTOs) {
        this.westernMedicineDTOs = westernMedicineDTOs;
    }


    /**
     * Gets the yearAnnualCoOrdinationfund value for this SpecialReceiptDTO.
     * 
     * @return yearAnnualCoOrdinationfund
     */
    public java.math.BigDecimal getYearAnnualCoOrdinationfund() {
        return yearAnnualCoOrdinationfund;
    }


    /**
     * Sets the yearAnnualCoOrdinationfund value for this SpecialReceiptDTO.
     * 
     * @param yearAnnualCoOrdinationfund
     */
    public void setYearAnnualCoOrdinationfund(java.math.BigDecimal yearAnnualCoOrdinationfund) {
        this.yearAnnualCoOrdinationfund = yearAnnualCoOrdinationfund;
    }


    /**
     * Gets the yearAnnualMutualPayment value for this SpecialReceiptDTO.
     * 
     * @return yearAnnualMutualPayment
     */
    public java.math.BigDecimal getYearAnnualMutualPayment() {
        return yearAnnualMutualPayment;
    }


    /**
     * Sets the yearAnnualMutualPayment value for this SpecialReceiptDTO.
     * 
     * @param yearAnnualMutualPayment
     */
    public void setYearAnnualMutualPayment(java.math.BigDecimal yearAnnualMutualPayment) {
        this.yearAnnualMutualPayment = yearAnnualMutualPayment;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SpecialReceiptDTO)) return false;
        SpecialReceiptDTO other = (SpecialReceiptDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accountBalance==null && other.getAccountBalance()==null) || 
             (this.accountBalance!=null &&
              this.accountBalance.equals(other.getAccountBalance()))) &&
            ((this.accountPayment==null && other.getAccountPayment()==null) || 
             (this.accountPayment!=null &&
              this.accountPayment.equals(other.getAccountPayment()))) &&
            ((this.cash==null && other.getCash()==null) || 
             (this.cash!=null &&
              this.cash.equals(other.getCash()))) &&
            ((this.civilServants==null && other.getCivilServants()==null) || 
             (this.civilServants!=null &&
              this.civilServants.equals(other.getCivilServants()))) &&
            ((this.clinicDate==null && other.getClinicDate()==null) || 
             (this.clinicDate!=null &&
              this.clinicDate.equals(other.getClinicDate()))) &&
            ((this.coOrdinationFund==null && other.getCoOrdinationFund()==null) || 
             (this.coOrdinationFund!=null &&
              this.coOrdinationFund.equals(other.getCoOrdinationFund()))) &&
            ((this.costItemDTOs==null && other.getCostItemDTOs()==null) || 
             (this.costItemDTOs!=null &&
              java.util.Arrays.equals(this.costItemDTOs, other.getCostItemDTOs()))) &&
            ((this.disabilitySoldier==null && other.getDisabilitySoldier()==null) || 
             (this.disabilitySoldier!=null &&
              this.disabilitySoldier.equals(other.getDisabilitySoldier()))) &&
            ((this.hospitalCode==null && other.getHospitalCode()==null) || 
             (this.hospitalCode!=null &&
              this.hospitalCode.equals(other.getHospitalCode()))) &&
            ((this.individualPayment==null && other.getIndividualPayment()==null) || 
             (this.individualPayment!=null &&
              this.individualPayment.equals(other.getIndividualPayment()))) &&
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
            ((this.paymentCap==null && other.getPaymentCap()==null) || 
             (this.paymentCap!=null &&
              this.paymentCap.equals(other.getPaymentCap()))) &&
            ((this.paymentFrom==null && other.getPaymentFrom()==null) || 
             (this.paymentFrom!=null &&
              this.paymentFrom.equals(other.getPaymentFrom()))) &&
            ((this.receiptNo==null && other.getReceiptNo()==null) || 
             (this.receiptNo!=null &&
              this.receiptNo.equals(other.getReceiptNo()))) &&
            ((this.retirementPayment==null && other.getRetirementPayment()==null) || 
             (this.retirementPayment!=null &&
              this.retirementPayment.equals(other.getRetirementPayment()))) &&
            ((this.specialMoney==null && other.getSpecialMoney()==null) || 
             (this.specialMoney!=null &&
              this.specialMoney.equals(other.getSpecialMoney()))) &&
            ((this.westernMedicineDTOs==null && other.getWesternMedicineDTOs()==null) || 
             (this.westernMedicineDTOs!=null &&
              java.util.Arrays.equals(this.westernMedicineDTOs, other.getWesternMedicineDTOs()))) &&
            ((this.yearAnnualCoOrdinationfund==null && other.getYearAnnualCoOrdinationfund()==null) || 
             (this.yearAnnualCoOrdinationfund!=null &&
              this.yearAnnualCoOrdinationfund.equals(other.getYearAnnualCoOrdinationfund()))) &&
            ((this.yearAnnualMutualPayment==null && other.getYearAnnualMutualPayment()==null) || 
             (this.yearAnnualMutualPayment!=null &&
              this.yearAnnualMutualPayment.equals(other.getYearAnnualMutualPayment())));
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
        if (getAccountBalance() != null) {
            _hashCode += getAccountBalance().hashCode();
        }
        if (getAccountPayment() != null) {
            _hashCode += getAccountPayment().hashCode();
        }
        if (getCash() != null) {
            _hashCode += getCash().hashCode();
        }
        if (getCivilServants() != null) {
            _hashCode += getCivilServants().hashCode();
        }
        if (getClinicDate() != null) {
            _hashCode += getClinicDate().hashCode();
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
        if (getDisabilitySoldier() != null) {
            _hashCode += getDisabilitySoldier().hashCode();
        }
        if (getHospitalCode() != null) {
            _hashCode += getHospitalCode().hashCode();
        }
        if (getIndividualPayment() != null) {
            _hashCode += getIndividualPayment().hashCode();
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
        if (getPaymentCap() != null) {
            _hashCode += getPaymentCap().hashCode();
        }
        if (getPaymentFrom() != null) {
            _hashCode += getPaymentFrom().hashCode();
        }
        if (getReceiptNo() != null) {
            _hashCode += getReceiptNo().hashCode();
        }
        if (getRetirementPayment() != null) {
            _hashCode += getRetirementPayment().hashCode();
        }
        if (getSpecialMoney() != null) {
            _hashCode += getSpecialMoney().hashCode();
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
        if (getYearAnnualCoOrdinationfund() != null) {
            _hashCode += getYearAnnualCoOrdinationfund().hashCode();
        }
        if (getYearAnnualMutualPayment() != null) {
            _hashCode += getYearAnnualMutualPayment().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SpecialReceiptDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialReceiptDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountBalance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accountBalance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountPayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accountPayment"));
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
        elemField.setFieldName("clinicDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clinicDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("disabilitySoldier");
        elemField.setXmlName(new javax.xml.namespace.QName("", "disabilitySoldier"));
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
        elemField.setFieldName("individualPayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "individualPayment"));
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
        elemField.setFieldName("paymentCap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentCap"));
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
        elemField.setFieldName("receiptNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receiptNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retirementPayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "retirementPayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specialMoney");
        elemField.setXmlName(new javax.xml.namespace.QName("", "specialMoney"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("westernMedicineDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "westernMedicineDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "WesternMedicineDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("yearAnnualCoOrdinationfund");
        elemField.setXmlName(new javax.xml.namespace.QName("", "yearAnnualCoOrdinationfund"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("yearAnnualMutualPayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "yearAnnualMutualPayment"));
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
