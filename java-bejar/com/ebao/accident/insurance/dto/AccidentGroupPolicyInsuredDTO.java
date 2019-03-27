/**
 * AccidentGroupPolicyInsuredDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.accident.insurance.dto;

public class AccidentGroupPolicyInsuredDTO  implements java.io.Serializable {
    private com.ebao.accident.insurance.dto.AccidentGroupPolicyBenefitDTO[] accidentGroupPolicyBenefitDTOs;

    private com.ebao.accident.insurance.dto.AccidentGroupPolicyUpcoverageDTO[] accidentGroupPolicyUpcoverageDTOs;

    private java.lang.String appointedBenefit;

    private java.util.Calendar birthday;

    private java.lang.String critCode;

    private java.lang.String critType;

    private java.lang.String customerNo;

    private java.lang.String gender;

    private java.math.BigDecimal insuredPremium;

    private java.lang.String insuredType;

    private java.lang.String mobile;

    private java.lang.String name;

    private java.lang.String offerStatus;

    private java.lang.String relationshipWithMainInsured;

    private java.lang.String snOfMainInsured;

    private java.util.Calendar subEndDate;

    private java.util.Calendar subStartDate;

    public AccidentGroupPolicyInsuredDTO() {
    }

    public AccidentGroupPolicyInsuredDTO(
           com.ebao.accident.insurance.dto.AccidentGroupPolicyBenefitDTO[] accidentGroupPolicyBenefitDTOs,
           com.ebao.accident.insurance.dto.AccidentGroupPolicyUpcoverageDTO[] accidentGroupPolicyUpcoverageDTOs,
           java.lang.String appointedBenefit,
           java.util.Calendar birthday,
           java.lang.String critCode,
           java.lang.String critType,
           java.lang.String customerNo,
           java.lang.String gender,
           java.math.BigDecimal insuredPremium,
           java.lang.String insuredType,
           java.lang.String mobile,
           java.lang.String name,
           java.lang.String offerStatus,
           java.lang.String relationshipWithMainInsured,
           java.lang.String snOfMainInsured,
           java.util.Calendar subEndDate,
           java.util.Calendar subStartDate) {
           this.accidentGroupPolicyBenefitDTOs = accidentGroupPolicyBenefitDTOs;
           this.accidentGroupPolicyUpcoverageDTOs = accidentGroupPolicyUpcoverageDTOs;
           this.appointedBenefit = appointedBenefit;
           this.birthday = birthday;
           this.critCode = critCode;
           this.critType = critType;
           this.customerNo = customerNo;
           this.gender = gender;
           this.insuredPremium = insuredPremium;
           this.insuredType = insuredType;
           this.mobile = mobile;
           this.name = name;
           this.offerStatus = offerStatus;
           this.relationshipWithMainInsured = relationshipWithMainInsured;
           this.snOfMainInsured = snOfMainInsured;
           this.subEndDate = subEndDate;
           this.subStartDate = subStartDate;
    }


    /**
     * Gets the accidentGroupPolicyBenefitDTOs value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @return accidentGroupPolicyBenefitDTOs
     */
    public com.ebao.accident.insurance.dto.AccidentGroupPolicyBenefitDTO[] getAccidentGroupPolicyBenefitDTOs() {
        return accidentGroupPolicyBenefitDTOs;
    }


    /**
     * Sets the accidentGroupPolicyBenefitDTOs value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @param accidentGroupPolicyBenefitDTOs
     */
    public void setAccidentGroupPolicyBenefitDTOs(com.ebao.accident.insurance.dto.AccidentGroupPolicyBenefitDTO[] accidentGroupPolicyBenefitDTOs) {
        this.accidentGroupPolicyBenefitDTOs = accidentGroupPolicyBenefitDTOs;
    }


    /**
     * Gets the accidentGroupPolicyUpcoverageDTOs value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @return accidentGroupPolicyUpcoverageDTOs
     */
    public com.ebao.accident.insurance.dto.AccidentGroupPolicyUpcoverageDTO[] getAccidentGroupPolicyUpcoverageDTOs() {
        return accidentGroupPolicyUpcoverageDTOs;
    }


    /**
     * Sets the accidentGroupPolicyUpcoverageDTOs value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @param accidentGroupPolicyUpcoverageDTOs
     */
    public void setAccidentGroupPolicyUpcoverageDTOs(com.ebao.accident.insurance.dto.AccidentGroupPolicyUpcoverageDTO[] accidentGroupPolicyUpcoverageDTOs) {
        this.accidentGroupPolicyUpcoverageDTOs = accidentGroupPolicyUpcoverageDTOs;
    }


    /**
     * Gets the appointedBenefit value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @return appointedBenefit
     */
    public java.lang.String getAppointedBenefit() {
        return appointedBenefit;
    }


    /**
     * Sets the appointedBenefit value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @param appointedBenefit
     */
    public void setAppointedBenefit(java.lang.String appointedBenefit) {
        this.appointedBenefit = appointedBenefit;
    }


    /**
     * Gets the birthday value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @return birthday
     */
    public java.util.Calendar getBirthday() {
        return birthday;
    }


    /**
     * Sets the birthday value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @param birthday
     */
    public void setBirthday(java.util.Calendar birthday) {
        this.birthday = birthday;
    }


    /**
     * Gets the critCode value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @return critCode
     */
    public java.lang.String getCritCode() {
        return critCode;
    }


    /**
     * Sets the critCode value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @param critCode
     */
    public void setCritCode(java.lang.String critCode) {
        this.critCode = critCode;
    }


    /**
     * Gets the critType value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @return critType
     */
    public java.lang.String getCritType() {
        return critType;
    }


    /**
     * Sets the critType value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @param critType
     */
    public void setCritType(java.lang.String critType) {
        this.critType = critType;
    }


    /**
     * Gets the customerNo value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @return customerNo
     */
    public java.lang.String getCustomerNo() {
        return customerNo;
    }


    /**
     * Sets the customerNo value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @param customerNo
     */
    public void setCustomerNo(java.lang.String customerNo) {
        this.customerNo = customerNo;
    }


    /**
     * Gets the gender value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @return gender
     */
    public java.lang.String getGender() {
        return gender;
    }


    /**
     * Sets the gender value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @param gender
     */
    public void setGender(java.lang.String gender) {
        this.gender = gender;
    }


    /**
     * Gets the insuredPremium value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @return insuredPremium
     */
    public java.math.BigDecimal getInsuredPremium() {
        return insuredPremium;
    }


    /**
     * Sets the insuredPremium value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @param insuredPremium
     */
    public void setInsuredPremium(java.math.BigDecimal insuredPremium) {
        this.insuredPremium = insuredPremium;
    }


    /**
     * Gets the insuredType value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @return insuredType
     */
    public java.lang.String getInsuredType() {
        return insuredType;
    }


    /**
     * Sets the insuredType value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @param insuredType
     */
    public void setInsuredType(java.lang.String insuredType) {
        this.insuredType = insuredType;
    }


    /**
     * Gets the mobile value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @return mobile
     */
    public java.lang.String getMobile() {
        return mobile;
    }


    /**
     * Sets the mobile value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @param mobile
     */
    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }


    /**
     * Gets the name value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the offerStatus value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @return offerStatus
     */
    public java.lang.String getOfferStatus() {
        return offerStatus;
    }


    /**
     * Sets the offerStatus value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @param offerStatus
     */
    public void setOfferStatus(java.lang.String offerStatus) {
        this.offerStatus = offerStatus;
    }


    /**
     * Gets the relationshipWithMainInsured value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @return relationshipWithMainInsured
     */
    public java.lang.String getRelationshipWithMainInsured() {
        return relationshipWithMainInsured;
    }


    /**
     * Sets the relationshipWithMainInsured value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @param relationshipWithMainInsured
     */
    public void setRelationshipWithMainInsured(java.lang.String relationshipWithMainInsured) {
        this.relationshipWithMainInsured = relationshipWithMainInsured;
    }


    /**
     * Gets the snOfMainInsured value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @return snOfMainInsured
     */
    public java.lang.String getSnOfMainInsured() {
        return snOfMainInsured;
    }


    /**
     * Sets the snOfMainInsured value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @param snOfMainInsured
     */
    public void setSnOfMainInsured(java.lang.String snOfMainInsured) {
        this.snOfMainInsured = snOfMainInsured;
    }


    /**
     * Gets the subEndDate value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @return subEndDate
     */
    public java.util.Calendar getSubEndDate() {
        return subEndDate;
    }


    /**
     * Sets the subEndDate value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @param subEndDate
     */
    public void setSubEndDate(java.util.Calendar subEndDate) {
        this.subEndDate = subEndDate;
    }


    /**
     * Gets the subStartDate value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @return subStartDate
     */
    public java.util.Calendar getSubStartDate() {
        return subStartDate;
    }


    /**
     * Sets the subStartDate value for this AccidentGroupPolicyInsuredDTO.
     * 
     * @param subStartDate
     */
    public void setSubStartDate(java.util.Calendar subStartDate) {
        this.subStartDate = subStartDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccidentGroupPolicyInsuredDTO)) return false;
        AccidentGroupPolicyInsuredDTO other = (AccidentGroupPolicyInsuredDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accidentGroupPolicyBenefitDTOs==null && other.getAccidentGroupPolicyBenefitDTOs()==null) || 
             (this.accidentGroupPolicyBenefitDTOs!=null &&
              java.util.Arrays.equals(this.accidentGroupPolicyBenefitDTOs, other.getAccidentGroupPolicyBenefitDTOs()))) &&
            ((this.accidentGroupPolicyUpcoverageDTOs==null && other.getAccidentGroupPolicyUpcoverageDTOs()==null) || 
             (this.accidentGroupPolicyUpcoverageDTOs!=null &&
              java.util.Arrays.equals(this.accidentGroupPolicyUpcoverageDTOs, other.getAccidentGroupPolicyUpcoverageDTOs()))) &&
            ((this.appointedBenefit==null && other.getAppointedBenefit()==null) || 
             (this.appointedBenefit!=null &&
              this.appointedBenefit.equals(other.getAppointedBenefit()))) &&
            ((this.birthday==null && other.getBirthday()==null) || 
             (this.birthday!=null &&
              this.birthday.equals(other.getBirthday()))) &&
            ((this.critCode==null && other.getCritCode()==null) || 
             (this.critCode!=null &&
              this.critCode.equals(other.getCritCode()))) &&
            ((this.critType==null && other.getCritType()==null) || 
             (this.critType!=null &&
              this.critType.equals(other.getCritType()))) &&
            ((this.customerNo==null && other.getCustomerNo()==null) || 
             (this.customerNo!=null &&
              this.customerNo.equals(other.getCustomerNo()))) &&
            ((this.gender==null && other.getGender()==null) || 
             (this.gender!=null &&
              this.gender.equals(other.getGender()))) &&
            ((this.insuredPremium==null && other.getInsuredPremium()==null) || 
             (this.insuredPremium!=null &&
              this.insuredPremium.equals(other.getInsuredPremium()))) &&
            ((this.insuredType==null && other.getInsuredType()==null) || 
             (this.insuredType!=null &&
              this.insuredType.equals(other.getInsuredType()))) &&
            ((this.mobile==null && other.getMobile()==null) || 
             (this.mobile!=null &&
              this.mobile.equals(other.getMobile()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.offerStatus==null && other.getOfferStatus()==null) || 
             (this.offerStatus!=null &&
              this.offerStatus.equals(other.getOfferStatus()))) &&
            ((this.relationshipWithMainInsured==null && other.getRelationshipWithMainInsured()==null) || 
             (this.relationshipWithMainInsured!=null &&
              this.relationshipWithMainInsured.equals(other.getRelationshipWithMainInsured()))) &&
            ((this.snOfMainInsured==null && other.getSnOfMainInsured()==null) || 
             (this.snOfMainInsured!=null &&
              this.snOfMainInsured.equals(other.getSnOfMainInsured()))) &&
            ((this.subEndDate==null && other.getSubEndDate()==null) || 
             (this.subEndDate!=null &&
              this.subEndDate.equals(other.getSubEndDate()))) &&
            ((this.subStartDate==null && other.getSubStartDate()==null) || 
             (this.subStartDate!=null &&
              this.subStartDate.equals(other.getSubStartDate())));
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
        if (getAccidentGroupPolicyBenefitDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccidentGroupPolicyBenefitDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccidentGroupPolicyBenefitDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAccidentGroupPolicyUpcoverageDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccidentGroupPolicyUpcoverageDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccidentGroupPolicyUpcoverageDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAppointedBenefit() != null) {
            _hashCode += getAppointedBenefit().hashCode();
        }
        if (getBirthday() != null) {
            _hashCode += getBirthday().hashCode();
        }
        if (getCritCode() != null) {
            _hashCode += getCritCode().hashCode();
        }
        if (getCritType() != null) {
            _hashCode += getCritType().hashCode();
        }
        if (getCustomerNo() != null) {
            _hashCode += getCustomerNo().hashCode();
        }
        if (getGender() != null) {
            _hashCode += getGender().hashCode();
        }
        if (getInsuredPremium() != null) {
            _hashCode += getInsuredPremium().hashCode();
        }
        if (getInsuredType() != null) {
            _hashCode += getInsuredType().hashCode();
        }
        if (getMobile() != null) {
            _hashCode += getMobile().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getOfferStatus() != null) {
            _hashCode += getOfferStatus().hashCode();
        }
        if (getRelationshipWithMainInsured() != null) {
            _hashCode += getRelationshipWithMainInsured().hashCode();
        }
        if (getSnOfMainInsured() != null) {
            _hashCode += getSnOfMainInsured().hashCode();
        }
        if (getSubEndDate() != null) {
            _hashCode += getSubEndDate().hashCode();
        }
        if (getSubStartDate() != null) {
            _hashCode += getSubStartDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccidentGroupPolicyInsuredDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyInsuredDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidentGroupPolicyBenefitDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidentGroupPolicyBenefitDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyBenefitDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidentGroupPolicyUpcoverageDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidentGroupPolicyUpcoverageDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyUpcoverageDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("appointedBenefit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "appointedBenefit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("birthday");
        elemField.setXmlName(new javax.xml.namespace.QName("", "birthday"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("critCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "critCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("critType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "critType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gender");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gender"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuredPremium");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insuredPremium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuredType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insuredType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mobile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offerStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "offerStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relationshipWithMainInsured");
        elemField.setXmlName(new javax.xml.namespace.QName("", "relationshipWithMainInsured"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("snOfMainInsured");
        elemField.setXmlName(new javax.xml.namespace.QName("", "snOfMainInsured"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subEndDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subEndDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subStartDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subStartDate"));
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
