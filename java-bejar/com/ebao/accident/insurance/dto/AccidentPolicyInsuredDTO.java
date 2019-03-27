/**
 * AccidentPolicyInsuredDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.accident.insurance.dto;

public class AccidentPolicyInsuredDTO  implements java.io.Serializable {
    private com.ebao.accident.insurance.dto.AccidentPolicyBenefitDTO[] accidentPolicyBenefitDTOs;

    private com.ebao.accident.insurance.dto.AccidentPolicyUpcoverageDTO[] accidentPolicyUpcoverageDTOs;

    private java.lang.String appointedBenefit;

    private java.util.Calendar birthday;

    private java.lang.String critCode;

    private java.lang.String critType;

    private java.lang.String customerNo;

    private java.lang.String gender;

    private java.lang.String mobile;

    private java.lang.String name;

    private java.lang.String offerStatus;

    private java.util.Calendar subEndDate;

    private java.util.Calendar subStartDate;

    public AccidentPolicyInsuredDTO() {
    }

    public AccidentPolicyInsuredDTO(
           com.ebao.accident.insurance.dto.AccidentPolicyBenefitDTO[] accidentPolicyBenefitDTOs,
           com.ebao.accident.insurance.dto.AccidentPolicyUpcoverageDTO[] accidentPolicyUpcoverageDTOs,
           java.lang.String appointedBenefit,
           java.util.Calendar birthday,
           java.lang.String critCode,
           java.lang.String critType,
           java.lang.String customerNo,
           java.lang.String gender,
           java.lang.String mobile,
           java.lang.String name,
           java.lang.String offerStatus,
           java.util.Calendar subEndDate,
           java.util.Calendar subStartDate) {
           this.accidentPolicyBenefitDTOs = accidentPolicyBenefitDTOs;
           this.accidentPolicyUpcoverageDTOs = accidentPolicyUpcoverageDTOs;
           this.appointedBenefit = appointedBenefit;
           this.birthday = birthday;
           this.critCode = critCode;
           this.critType = critType;
           this.customerNo = customerNo;
           this.gender = gender;
           this.mobile = mobile;
           this.name = name;
           this.offerStatus = offerStatus;
           this.subEndDate = subEndDate;
           this.subStartDate = subStartDate;
    }


    /**
     * Gets the accidentPolicyBenefitDTOs value for this AccidentPolicyInsuredDTO.
     * 
     * @return accidentPolicyBenefitDTOs
     */
    public com.ebao.accident.insurance.dto.AccidentPolicyBenefitDTO[] getAccidentPolicyBenefitDTOs() {
        return accidentPolicyBenefitDTOs;
    }


    /**
     * Sets the accidentPolicyBenefitDTOs value for this AccidentPolicyInsuredDTO.
     * 
     * @param accidentPolicyBenefitDTOs
     */
    public void setAccidentPolicyBenefitDTOs(com.ebao.accident.insurance.dto.AccidentPolicyBenefitDTO[] accidentPolicyBenefitDTOs) {
        this.accidentPolicyBenefitDTOs = accidentPolicyBenefitDTOs;
    }


    /**
     * Gets the accidentPolicyUpcoverageDTOs value for this AccidentPolicyInsuredDTO.
     * 
     * @return accidentPolicyUpcoverageDTOs
     */
    public com.ebao.accident.insurance.dto.AccidentPolicyUpcoverageDTO[] getAccidentPolicyUpcoverageDTOs() {
        return accidentPolicyUpcoverageDTOs;
    }


    /**
     * Sets the accidentPolicyUpcoverageDTOs value for this AccidentPolicyInsuredDTO.
     * 
     * @param accidentPolicyUpcoverageDTOs
     */
    public void setAccidentPolicyUpcoverageDTOs(com.ebao.accident.insurance.dto.AccidentPolicyUpcoverageDTO[] accidentPolicyUpcoverageDTOs) {
        this.accidentPolicyUpcoverageDTOs = accidentPolicyUpcoverageDTOs;
    }


    /**
     * Gets the appointedBenefit value for this AccidentPolicyInsuredDTO.
     * 
     * @return appointedBenefit
     */
    public java.lang.String getAppointedBenefit() {
        return appointedBenefit;
    }


    /**
     * Sets the appointedBenefit value for this AccidentPolicyInsuredDTO.
     * 
     * @param appointedBenefit
     */
    public void setAppointedBenefit(java.lang.String appointedBenefit) {
        this.appointedBenefit = appointedBenefit;
    }


    /**
     * Gets the birthday value for this AccidentPolicyInsuredDTO.
     * 
     * @return birthday
     */
    public java.util.Calendar getBirthday() {
        return birthday;
    }


    /**
     * Sets the birthday value for this AccidentPolicyInsuredDTO.
     * 
     * @param birthday
     */
    public void setBirthday(java.util.Calendar birthday) {
        this.birthday = birthday;
    }


    /**
     * Gets the critCode value for this AccidentPolicyInsuredDTO.
     * 
     * @return critCode
     */
    public java.lang.String getCritCode() {
        return critCode;
    }


    /**
     * Sets the critCode value for this AccidentPolicyInsuredDTO.
     * 
     * @param critCode
     */
    public void setCritCode(java.lang.String critCode) {
        this.critCode = critCode;
    }


    /**
     * Gets the critType value for this AccidentPolicyInsuredDTO.
     * 
     * @return critType
     */
    public java.lang.String getCritType() {
        return critType;
    }


    /**
     * Sets the critType value for this AccidentPolicyInsuredDTO.
     * 
     * @param critType
     */
    public void setCritType(java.lang.String critType) {
        this.critType = critType;
    }


    /**
     * Gets the customerNo value for this AccidentPolicyInsuredDTO.
     * 
     * @return customerNo
     */
    public java.lang.String getCustomerNo() {
        return customerNo;
    }


    /**
     * Sets the customerNo value for this AccidentPolicyInsuredDTO.
     * 
     * @param customerNo
     */
    public void setCustomerNo(java.lang.String customerNo) {
        this.customerNo = customerNo;
    }


    /**
     * Gets the gender value for this AccidentPolicyInsuredDTO.
     * 
     * @return gender
     */
    public java.lang.String getGender() {
        return gender;
    }


    /**
     * Sets the gender value for this AccidentPolicyInsuredDTO.
     * 
     * @param gender
     */
    public void setGender(java.lang.String gender) {
        this.gender = gender;
    }


    /**
     * Gets the mobile value for this AccidentPolicyInsuredDTO.
     * 
     * @return mobile
     */
    public java.lang.String getMobile() {
        return mobile;
    }


    /**
     * Sets the mobile value for this AccidentPolicyInsuredDTO.
     * 
     * @param mobile
     */
    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }


    /**
     * Gets the name value for this AccidentPolicyInsuredDTO.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this AccidentPolicyInsuredDTO.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the offerStatus value for this AccidentPolicyInsuredDTO.
     * 
     * @return offerStatus
     */
    public java.lang.String getOfferStatus() {
        return offerStatus;
    }


    /**
     * Sets the offerStatus value for this AccidentPolicyInsuredDTO.
     * 
     * @param offerStatus
     */
    public void setOfferStatus(java.lang.String offerStatus) {
        this.offerStatus = offerStatus;
    }


    /**
     * Gets the subEndDate value for this AccidentPolicyInsuredDTO.
     * 
     * @return subEndDate
     */
    public java.util.Calendar getSubEndDate() {
        return subEndDate;
    }


    /**
     * Sets the subEndDate value for this AccidentPolicyInsuredDTO.
     * 
     * @param subEndDate
     */
    public void setSubEndDate(java.util.Calendar subEndDate) {
        this.subEndDate = subEndDate;
    }


    /**
     * Gets the subStartDate value for this AccidentPolicyInsuredDTO.
     * 
     * @return subStartDate
     */
    public java.util.Calendar getSubStartDate() {
        return subStartDate;
    }


    /**
     * Sets the subStartDate value for this AccidentPolicyInsuredDTO.
     * 
     * @param subStartDate
     */
    public void setSubStartDate(java.util.Calendar subStartDate) {
        this.subStartDate = subStartDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccidentPolicyInsuredDTO)) return false;
        AccidentPolicyInsuredDTO other = (AccidentPolicyInsuredDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accidentPolicyBenefitDTOs==null && other.getAccidentPolicyBenefitDTOs()==null) || 
             (this.accidentPolicyBenefitDTOs!=null &&
              java.util.Arrays.equals(this.accidentPolicyBenefitDTOs, other.getAccidentPolicyBenefitDTOs()))) &&
            ((this.accidentPolicyUpcoverageDTOs==null && other.getAccidentPolicyUpcoverageDTOs()==null) || 
             (this.accidentPolicyUpcoverageDTOs!=null &&
              java.util.Arrays.equals(this.accidentPolicyUpcoverageDTOs, other.getAccidentPolicyUpcoverageDTOs()))) &&
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
            ((this.mobile==null && other.getMobile()==null) || 
             (this.mobile!=null &&
              this.mobile.equals(other.getMobile()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.offerStatus==null && other.getOfferStatus()==null) || 
             (this.offerStatus!=null &&
              this.offerStatus.equals(other.getOfferStatus()))) &&
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
        if (getAccidentPolicyBenefitDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccidentPolicyBenefitDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccidentPolicyBenefitDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAccidentPolicyUpcoverageDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccidentPolicyUpcoverageDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccidentPolicyUpcoverageDTOs(), i);
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
        if (getMobile() != null) {
            _hashCode += getMobile().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getOfferStatus() != null) {
            _hashCode += getOfferStatus().hashCode();
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
        new org.apache.axis.description.TypeDesc(AccidentPolicyInsuredDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyInsuredDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidentPolicyBenefitDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidentPolicyBenefitDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyBenefitDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidentPolicyUpcoverageDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidentPolicyUpcoverageDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyUpcoverageDTO"));
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
