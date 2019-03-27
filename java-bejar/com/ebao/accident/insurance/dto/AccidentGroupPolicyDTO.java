/**
 * AccidentGroupPolicyDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.accident.insurance.dto;

public class AccidentGroupPolicyDTO  implements java.io.Serializable {
    private com.ebao.accident.insurance.dto.AccidentGroupPolicyInsuredDTO[] accidentGroupPolicyInsuredDTOs;

    private com.ebao.accident.insurance.dto.AccidentGroupPolicyPersonphDTO[] accidentGroupPolicyPersonphDTOs;

    private java.util.Calendar applicationDate;

    private java.lang.String applicationFormNo;

    private java.lang.String businessAddress;

    private java.math.BigDecimal effectiveInsuredNum;

    private java.util.Calendar policyEndDate;

    private java.math.BigDecimal policyHolderNum;

    private java.lang.String policyNo;

    private java.util.Calendar policyStartDate;

    private java.math.BigDecimal premium;

    private java.lang.String productName;

    private java.lang.String renewalMethod;

    private java.math.BigDecimal renewalTimes;

    private java.lang.String sales;

    private java.lang.String salesChannelCode;

    private java.lang.String salesChannelName;

    private java.lang.String salesChannelNameComment;

    private java.util.Calendar singleDate;

    private java.lang.String specialRemark;

    private java.lang.String splitPolicyNo;

    private java.util.Calendar underwritngDate;

    public AccidentGroupPolicyDTO() {
    }

    public AccidentGroupPolicyDTO(
           com.ebao.accident.insurance.dto.AccidentGroupPolicyInsuredDTO[] accidentGroupPolicyInsuredDTOs,
           com.ebao.accident.insurance.dto.AccidentGroupPolicyPersonphDTO[] accidentGroupPolicyPersonphDTOs,
           java.util.Calendar applicationDate,
           java.lang.String applicationFormNo,
           java.lang.String businessAddress,
           java.math.BigDecimal effectiveInsuredNum,
           java.util.Calendar policyEndDate,
           java.math.BigDecimal policyHolderNum,
           java.lang.String policyNo,
           java.util.Calendar policyStartDate,
           java.math.BigDecimal premium,
           java.lang.String productName,
           java.lang.String renewalMethod,
           java.math.BigDecimal renewalTimes,
           java.lang.String sales,
           java.lang.String salesChannelCode,
           java.lang.String salesChannelName,
           java.lang.String salesChannelNameComment,
           java.util.Calendar singleDate,
           java.lang.String specialRemark,
           java.lang.String splitPolicyNo,
           java.util.Calendar underwritngDate) {
           this.accidentGroupPolicyInsuredDTOs = accidentGroupPolicyInsuredDTOs;
           this.accidentGroupPolicyPersonphDTOs = accidentGroupPolicyPersonphDTOs;
           this.applicationDate = applicationDate;
           this.applicationFormNo = applicationFormNo;
           this.businessAddress = businessAddress;
           this.effectiveInsuredNum = effectiveInsuredNum;
           this.policyEndDate = policyEndDate;
           this.policyHolderNum = policyHolderNum;
           this.policyNo = policyNo;
           this.policyStartDate = policyStartDate;
           this.premium = premium;
           this.productName = productName;
           this.renewalMethod = renewalMethod;
           this.renewalTimes = renewalTimes;
           this.sales = sales;
           this.salesChannelCode = salesChannelCode;
           this.salesChannelName = salesChannelName;
           this.salesChannelNameComment = salesChannelNameComment;
           this.singleDate = singleDate;
           this.specialRemark = specialRemark;
           this.splitPolicyNo = splitPolicyNo;
           this.underwritngDate = underwritngDate;
    }


    /**
     * Gets the accidentGroupPolicyInsuredDTOs value for this AccidentGroupPolicyDTO.
     * 
     * @return accidentGroupPolicyInsuredDTOs
     */
    public com.ebao.accident.insurance.dto.AccidentGroupPolicyInsuredDTO[] getAccidentGroupPolicyInsuredDTOs() {
        return accidentGroupPolicyInsuredDTOs;
    }


    /**
     * Sets the accidentGroupPolicyInsuredDTOs value for this AccidentGroupPolicyDTO.
     * 
     * @param accidentGroupPolicyInsuredDTOs
     */
    public void setAccidentGroupPolicyInsuredDTOs(com.ebao.accident.insurance.dto.AccidentGroupPolicyInsuredDTO[] accidentGroupPolicyInsuredDTOs) {
        this.accidentGroupPolicyInsuredDTOs = accidentGroupPolicyInsuredDTOs;
    }


    /**
     * Gets the accidentGroupPolicyPersonphDTOs value for this AccidentGroupPolicyDTO.
     * 
     * @return accidentGroupPolicyPersonphDTOs
     */
    public com.ebao.accident.insurance.dto.AccidentGroupPolicyPersonphDTO[] getAccidentGroupPolicyPersonphDTOs() {
        return accidentGroupPolicyPersonphDTOs;
    }


    /**
     * Sets the accidentGroupPolicyPersonphDTOs value for this AccidentGroupPolicyDTO.
     * 
     * @param accidentGroupPolicyPersonphDTOs
     */
    public void setAccidentGroupPolicyPersonphDTOs(com.ebao.accident.insurance.dto.AccidentGroupPolicyPersonphDTO[] accidentGroupPolicyPersonphDTOs) {
        this.accidentGroupPolicyPersonphDTOs = accidentGroupPolicyPersonphDTOs;
    }


    /**
     * Gets the applicationDate value for this AccidentGroupPolicyDTO.
     * 
     * @return applicationDate
     */
    public java.util.Calendar getApplicationDate() {
        return applicationDate;
    }


    /**
     * Sets the applicationDate value for this AccidentGroupPolicyDTO.
     * 
     * @param applicationDate
     */
    public void setApplicationDate(java.util.Calendar applicationDate) {
        this.applicationDate = applicationDate;
    }


    /**
     * Gets the applicationFormNo value for this AccidentGroupPolicyDTO.
     * 
     * @return applicationFormNo
     */
    public java.lang.String getApplicationFormNo() {
        return applicationFormNo;
    }


    /**
     * Sets the applicationFormNo value for this AccidentGroupPolicyDTO.
     * 
     * @param applicationFormNo
     */
    public void setApplicationFormNo(java.lang.String applicationFormNo) {
        this.applicationFormNo = applicationFormNo;
    }


    /**
     * Gets the businessAddress value for this AccidentGroupPolicyDTO.
     * 
     * @return businessAddress
     */
    public java.lang.String getBusinessAddress() {
        return businessAddress;
    }


    /**
     * Sets the businessAddress value for this AccidentGroupPolicyDTO.
     * 
     * @param businessAddress
     */
    public void setBusinessAddress(java.lang.String businessAddress) {
        this.businessAddress = businessAddress;
    }


    /**
     * Gets the effectiveInsuredNum value for this AccidentGroupPolicyDTO.
     * 
     * @return effectiveInsuredNum
     */
    public java.math.BigDecimal getEffectiveInsuredNum() {
        return effectiveInsuredNum;
    }


    /**
     * Sets the effectiveInsuredNum value for this AccidentGroupPolicyDTO.
     * 
     * @param effectiveInsuredNum
     */
    public void setEffectiveInsuredNum(java.math.BigDecimal effectiveInsuredNum) {
        this.effectiveInsuredNum = effectiveInsuredNum;
    }


    /**
     * Gets the policyEndDate value for this AccidentGroupPolicyDTO.
     * 
     * @return policyEndDate
     */
    public java.util.Calendar getPolicyEndDate() {
        return policyEndDate;
    }


    /**
     * Sets the policyEndDate value for this AccidentGroupPolicyDTO.
     * 
     * @param policyEndDate
     */
    public void setPolicyEndDate(java.util.Calendar policyEndDate) {
        this.policyEndDate = policyEndDate;
    }


    /**
     * Gets the policyHolderNum value for this AccidentGroupPolicyDTO.
     * 
     * @return policyHolderNum
     */
    public java.math.BigDecimal getPolicyHolderNum() {
        return policyHolderNum;
    }


    /**
     * Sets the policyHolderNum value for this AccidentGroupPolicyDTO.
     * 
     * @param policyHolderNum
     */
    public void setPolicyHolderNum(java.math.BigDecimal policyHolderNum) {
        this.policyHolderNum = policyHolderNum;
    }


    /**
     * Gets the policyNo value for this AccidentGroupPolicyDTO.
     * 
     * @return policyNo
     */
    public java.lang.String getPolicyNo() {
        return policyNo;
    }


    /**
     * Sets the policyNo value for this AccidentGroupPolicyDTO.
     * 
     * @param policyNo
     */
    public void setPolicyNo(java.lang.String policyNo) {
        this.policyNo = policyNo;
    }


    /**
     * Gets the policyStartDate value for this AccidentGroupPolicyDTO.
     * 
     * @return policyStartDate
     */
    public java.util.Calendar getPolicyStartDate() {
        return policyStartDate;
    }


    /**
     * Sets the policyStartDate value for this AccidentGroupPolicyDTO.
     * 
     * @param policyStartDate
     */
    public void setPolicyStartDate(java.util.Calendar policyStartDate) {
        this.policyStartDate = policyStartDate;
    }


    /**
     * Gets the premium value for this AccidentGroupPolicyDTO.
     * 
     * @return premium
     */
    public java.math.BigDecimal getPremium() {
        return premium;
    }


    /**
     * Sets the premium value for this AccidentGroupPolicyDTO.
     * 
     * @param premium
     */
    public void setPremium(java.math.BigDecimal premium) {
        this.premium = premium;
    }


    /**
     * Gets the productName value for this AccidentGroupPolicyDTO.
     * 
     * @return productName
     */
    public java.lang.String getProductName() {
        return productName;
    }


    /**
     * Sets the productName value for this AccidentGroupPolicyDTO.
     * 
     * @param productName
     */
    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }


    /**
     * Gets the renewalMethod value for this AccidentGroupPolicyDTO.
     * 
     * @return renewalMethod
     */
    public java.lang.String getRenewalMethod() {
        return renewalMethod;
    }


    /**
     * Sets the renewalMethod value for this AccidentGroupPolicyDTO.
     * 
     * @param renewalMethod
     */
    public void setRenewalMethod(java.lang.String renewalMethod) {
        this.renewalMethod = renewalMethod;
    }


    /**
     * Gets the renewalTimes value for this AccidentGroupPolicyDTO.
     * 
     * @return renewalTimes
     */
    public java.math.BigDecimal getRenewalTimes() {
        return renewalTimes;
    }


    /**
     * Sets the renewalTimes value for this AccidentGroupPolicyDTO.
     * 
     * @param renewalTimes
     */
    public void setRenewalTimes(java.math.BigDecimal renewalTimes) {
        this.renewalTimes = renewalTimes;
    }


    /**
     * Gets the sales value for this AccidentGroupPolicyDTO.
     * 
     * @return sales
     */
    public java.lang.String getSales() {
        return sales;
    }


    /**
     * Sets the sales value for this AccidentGroupPolicyDTO.
     * 
     * @param sales
     */
    public void setSales(java.lang.String sales) {
        this.sales = sales;
    }


    /**
     * Gets the salesChannelCode value for this AccidentGroupPolicyDTO.
     * 
     * @return salesChannelCode
     */
    public java.lang.String getSalesChannelCode() {
        return salesChannelCode;
    }


    /**
     * Sets the salesChannelCode value for this AccidentGroupPolicyDTO.
     * 
     * @param salesChannelCode
     */
    public void setSalesChannelCode(java.lang.String salesChannelCode) {
        this.salesChannelCode = salesChannelCode;
    }


    /**
     * Gets the salesChannelName value for this AccidentGroupPolicyDTO.
     * 
     * @return salesChannelName
     */
    public java.lang.String getSalesChannelName() {
        return salesChannelName;
    }


    /**
     * Sets the salesChannelName value for this AccidentGroupPolicyDTO.
     * 
     * @param salesChannelName
     */
    public void setSalesChannelName(java.lang.String salesChannelName) {
        this.salesChannelName = salesChannelName;
    }


    /**
     * Gets the salesChannelNameComment value for this AccidentGroupPolicyDTO.
     * 
     * @return salesChannelNameComment
     */
    public java.lang.String getSalesChannelNameComment() {
        return salesChannelNameComment;
    }


    /**
     * Sets the salesChannelNameComment value for this AccidentGroupPolicyDTO.
     * 
     * @param salesChannelNameComment
     */
    public void setSalesChannelNameComment(java.lang.String salesChannelNameComment) {
        this.salesChannelNameComment = salesChannelNameComment;
    }


    /**
     * Gets the singleDate value for this AccidentGroupPolicyDTO.
     * 
     * @return singleDate
     */
    public java.util.Calendar getSingleDate() {
        return singleDate;
    }


    /**
     * Sets the singleDate value for this AccidentGroupPolicyDTO.
     * 
     * @param singleDate
     */
    public void setSingleDate(java.util.Calendar singleDate) {
        this.singleDate = singleDate;
    }


    /**
     * Gets the specialRemark value for this AccidentGroupPolicyDTO.
     * 
     * @return specialRemark
     */
    public java.lang.String getSpecialRemark() {
        return specialRemark;
    }


    /**
     * Sets the specialRemark value for this AccidentGroupPolicyDTO.
     * 
     * @param specialRemark
     */
    public void setSpecialRemark(java.lang.String specialRemark) {
        this.specialRemark = specialRemark;
    }


    /**
     * Gets the splitPolicyNo value for this AccidentGroupPolicyDTO.
     * 
     * @return splitPolicyNo
     */
    public java.lang.String getSplitPolicyNo() {
        return splitPolicyNo;
    }


    /**
     * Sets the splitPolicyNo value for this AccidentGroupPolicyDTO.
     * 
     * @param splitPolicyNo
     */
    public void setSplitPolicyNo(java.lang.String splitPolicyNo) {
        this.splitPolicyNo = splitPolicyNo;
    }


    /**
     * Gets the underwritngDate value for this AccidentGroupPolicyDTO.
     * 
     * @return underwritngDate
     */
    public java.util.Calendar getUnderwritngDate() {
        return underwritngDate;
    }


    /**
     * Sets the underwritngDate value for this AccidentGroupPolicyDTO.
     * 
     * @param underwritngDate
     */
    public void setUnderwritngDate(java.util.Calendar underwritngDate) {
        this.underwritngDate = underwritngDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccidentGroupPolicyDTO)) return false;
        AccidentGroupPolicyDTO other = (AccidentGroupPolicyDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accidentGroupPolicyInsuredDTOs==null && other.getAccidentGroupPolicyInsuredDTOs()==null) || 
             (this.accidentGroupPolicyInsuredDTOs!=null &&
              java.util.Arrays.equals(this.accidentGroupPolicyInsuredDTOs, other.getAccidentGroupPolicyInsuredDTOs()))) &&
            ((this.accidentGroupPolicyPersonphDTOs==null && other.getAccidentGroupPolicyPersonphDTOs()==null) || 
             (this.accidentGroupPolicyPersonphDTOs!=null &&
              java.util.Arrays.equals(this.accidentGroupPolicyPersonphDTOs, other.getAccidentGroupPolicyPersonphDTOs()))) &&
            ((this.applicationDate==null && other.getApplicationDate()==null) || 
             (this.applicationDate!=null &&
              this.applicationDate.equals(other.getApplicationDate()))) &&
            ((this.applicationFormNo==null && other.getApplicationFormNo()==null) || 
             (this.applicationFormNo!=null &&
              this.applicationFormNo.equals(other.getApplicationFormNo()))) &&
            ((this.businessAddress==null && other.getBusinessAddress()==null) || 
             (this.businessAddress!=null &&
              this.businessAddress.equals(other.getBusinessAddress()))) &&
            ((this.effectiveInsuredNum==null && other.getEffectiveInsuredNum()==null) || 
             (this.effectiveInsuredNum!=null &&
              this.effectiveInsuredNum.equals(other.getEffectiveInsuredNum()))) &&
            ((this.policyEndDate==null && other.getPolicyEndDate()==null) || 
             (this.policyEndDate!=null &&
              this.policyEndDate.equals(other.getPolicyEndDate()))) &&
            ((this.policyHolderNum==null && other.getPolicyHolderNum()==null) || 
             (this.policyHolderNum!=null &&
              this.policyHolderNum.equals(other.getPolicyHolderNum()))) &&
            ((this.policyNo==null && other.getPolicyNo()==null) || 
             (this.policyNo!=null &&
              this.policyNo.equals(other.getPolicyNo()))) &&
            ((this.policyStartDate==null && other.getPolicyStartDate()==null) || 
             (this.policyStartDate!=null &&
              this.policyStartDate.equals(other.getPolicyStartDate()))) &&
            ((this.premium==null && other.getPremium()==null) || 
             (this.premium!=null &&
              this.premium.equals(other.getPremium()))) &&
            ((this.productName==null && other.getProductName()==null) || 
             (this.productName!=null &&
              this.productName.equals(other.getProductName()))) &&
            ((this.renewalMethod==null && other.getRenewalMethod()==null) || 
             (this.renewalMethod!=null &&
              this.renewalMethod.equals(other.getRenewalMethod()))) &&
            ((this.renewalTimes==null && other.getRenewalTimes()==null) || 
             (this.renewalTimes!=null &&
              this.renewalTimes.equals(other.getRenewalTimes()))) &&
            ((this.sales==null && other.getSales()==null) || 
             (this.sales!=null &&
              this.sales.equals(other.getSales()))) &&
            ((this.salesChannelCode==null && other.getSalesChannelCode()==null) || 
             (this.salesChannelCode!=null &&
              this.salesChannelCode.equals(other.getSalesChannelCode()))) &&
            ((this.salesChannelName==null && other.getSalesChannelName()==null) || 
             (this.salesChannelName!=null &&
              this.salesChannelName.equals(other.getSalesChannelName()))) &&
            ((this.salesChannelNameComment==null && other.getSalesChannelNameComment()==null) || 
             (this.salesChannelNameComment!=null &&
              this.salesChannelNameComment.equals(other.getSalesChannelNameComment()))) &&
            ((this.singleDate==null && other.getSingleDate()==null) || 
             (this.singleDate!=null &&
              this.singleDate.equals(other.getSingleDate()))) &&
            ((this.specialRemark==null && other.getSpecialRemark()==null) || 
             (this.specialRemark!=null &&
              this.specialRemark.equals(other.getSpecialRemark()))) &&
            ((this.splitPolicyNo==null && other.getSplitPolicyNo()==null) || 
             (this.splitPolicyNo!=null &&
              this.splitPolicyNo.equals(other.getSplitPolicyNo()))) &&
            ((this.underwritngDate==null && other.getUnderwritngDate()==null) || 
             (this.underwritngDate!=null &&
              this.underwritngDate.equals(other.getUnderwritngDate())));
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
        if (getAccidentGroupPolicyInsuredDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccidentGroupPolicyInsuredDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccidentGroupPolicyInsuredDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAccidentGroupPolicyPersonphDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccidentGroupPolicyPersonphDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccidentGroupPolicyPersonphDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getApplicationDate() != null) {
            _hashCode += getApplicationDate().hashCode();
        }
        if (getApplicationFormNo() != null) {
            _hashCode += getApplicationFormNo().hashCode();
        }
        if (getBusinessAddress() != null) {
            _hashCode += getBusinessAddress().hashCode();
        }
        if (getEffectiveInsuredNum() != null) {
            _hashCode += getEffectiveInsuredNum().hashCode();
        }
        if (getPolicyEndDate() != null) {
            _hashCode += getPolicyEndDate().hashCode();
        }
        if (getPolicyHolderNum() != null) {
            _hashCode += getPolicyHolderNum().hashCode();
        }
        if (getPolicyNo() != null) {
            _hashCode += getPolicyNo().hashCode();
        }
        if (getPolicyStartDate() != null) {
            _hashCode += getPolicyStartDate().hashCode();
        }
        if (getPremium() != null) {
            _hashCode += getPremium().hashCode();
        }
        if (getProductName() != null) {
            _hashCode += getProductName().hashCode();
        }
        if (getRenewalMethod() != null) {
            _hashCode += getRenewalMethod().hashCode();
        }
        if (getRenewalTimes() != null) {
            _hashCode += getRenewalTimes().hashCode();
        }
        if (getSales() != null) {
            _hashCode += getSales().hashCode();
        }
        if (getSalesChannelCode() != null) {
            _hashCode += getSalesChannelCode().hashCode();
        }
        if (getSalesChannelName() != null) {
            _hashCode += getSalesChannelName().hashCode();
        }
        if (getSalesChannelNameComment() != null) {
            _hashCode += getSalesChannelNameComment().hashCode();
        }
        if (getSingleDate() != null) {
            _hashCode += getSingleDate().hashCode();
        }
        if (getSpecialRemark() != null) {
            _hashCode += getSpecialRemark().hashCode();
        }
        if (getSplitPolicyNo() != null) {
            _hashCode += getSplitPolicyNo().hashCode();
        }
        if (getUnderwritngDate() != null) {
            _hashCode += getUnderwritngDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccidentGroupPolicyDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidentGroupPolicyInsuredDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidentGroupPolicyInsuredDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyInsuredDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidentGroupPolicyPersonphDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidentGroupPolicyPersonphDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyPersonphDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "applicationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationFormNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "applicationFormNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "businessAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("effectiveInsuredNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "effectiveInsuredNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyEndDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyEndDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyHolderNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyHolderNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyStartDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyStartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("premium");
        elemField.setXmlName(new javax.xml.namespace.QName("", "premium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renewalMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "renewalMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renewalTimes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "renewalTimes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sales");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sales"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesChannelCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "salesChannelCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesChannelName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "salesChannelName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesChannelNameComment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "salesChannelNameComment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("singleDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "singleDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specialRemark");
        elemField.setXmlName(new javax.xml.namespace.QName("", "specialRemark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("splitPolicyNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "splitPolicyNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("underwritngDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "underwritngDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
