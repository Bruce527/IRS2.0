/**
 * PolicyInsuredDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class PolicyInsuredDTO  implements java.io.Serializable {
    private java.lang.String address1;

    private java.lang.String address2;

    private java.lang.String address3;

    private java.lang.String address4;

    private java.lang.String anomalyInform;

    private java.lang.String appointedBenefit;

    private java.util.Calendar birthday;

    private java.lang.String critCode;

    private java.lang.String critType;

    private java.lang.String customerNo;

    private java.lang.String empoyeeNo;

    private java.lang.String gender;

    private java.lang.String healthFlag;

    private java.lang.String insuredGroupCode;

    private java.lang.String insuredType;

    private java.lang.String name;

    private java.lang.String occupationalCode;

    private java.lang.String offerStatus;

    private com.ebao.health.insurance.dto.PolicyBenefitDTO[] policyBenefitDTOs;

    private java.lang.String relationshipWithMainInsured;

    private java.lang.String relationshipWithPh;

    private java.lang.String serviceMark;

    private java.lang.String snOfMainInsured;

    private java.lang.String socialcareNo;

    private com.ebao.health.insurance.dto.SpecialPolicyUpcoverageDTO[] specialPolicyUpcoverageDTOs;

    private java.util.Calendar subEndDate;

    private java.util.Calendar subStartDate;

    private java.lang.String workPlace;

    public PolicyInsuredDTO() {
    }

    public PolicyInsuredDTO(
           java.lang.String address1,
           java.lang.String address2,
           java.lang.String address3,
           java.lang.String address4,
           java.lang.String anomalyInform,
           java.lang.String appointedBenefit,
           java.util.Calendar birthday,
           java.lang.String critCode,
           java.lang.String critType,
           java.lang.String customerNo,
           java.lang.String empoyeeNo,
           java.lang.String gender,
           java.lang.String healthFlag,
           java.lang.String insuredGroupCode,
           java.lang.String insuredType,
           java.lang.String name,
           java.lang.String occupationalCode,
           java.lang.String offerStatus,
           com.ebao.health.insurance.dto.PolicyBenefitDTO[] policyBenefitDTOs,
           java.lang.String relationshipWithMainInsured,
           java.lang.String relationshipWithPh,
           java.lang.String serviceMark,
           java.lang.String snOfMainInsured,
           java.lang.String socialcareNo,
           com.ebao.health.insurance.dto.SpecialPolicyUpcoverageDTO[] specialPolicyUpcoverageDTOs,
           java.util.Calendar subEndDate,
           java.util.Calendar subStartDate,
           java.lang.String workPlace) {
           this.address1 = address1;
           this.address2 = address2;
           this.address3 = address3;
           this.address4 = address4;
           this.anomalyInform = anomalyInform;
           this.appointedBenefit = appointedBenefit;
           this.birthday = birthday;
           this.critCode = critCode;
           this.critType = critType;
           this.customerNo = customerNo;
           this.empoyeeNo = empoyeeNo;
           this.gender = gender;
           this.healthFlag = healthFlag;
           this.insuredGroupCode = insuredGroupCode;
           this.insuredType = insuredType;
           this.name = name;
           this.occupationalCode = occupationalCode;
           this.offerStatus = offerStatus;
           this.policyBenefitDTOs = policyBenefitDTOs;
           this.relationshipWithMainInsured = relationshipWithMainInsured;
           this.relationshipWithPh = relationshipWithPh;
           this.serviceMark = serviceMark;
           this.snOfMainInsured = snOfMainInsured;
           this.socialcareNo = socialcareNo;
           this.specialPolicyUpcoverageDTOs = specialPolicyUpcoverageDTOs;
           this.subEndDate = subEndDate;
           this.subStartDate = subStartDate;
           this.workPlace = workPlace;
    }


    /**
     * Gets the address1 value for this PolicyInsuredDTO.
     * 
     * @return address1
     */
    public java.lang.String getAddress1() {
        return address1;
    }


    /**
     * Sets the address1 value for this PolicyInsuredDTO.
     * 
     * @param address1
     */
    public void setAddress1(java.lang.String address1) {
        this.address1 = address1;
    }


    /**
     * Gets the address2 value for this PolicyInsuredDTO.
     * 
     * @return address2
     */
    public java.lang.String getAddress2() {
        return address2;
    }


    /**
     * Sets the address2 value for this PolicyInsuredDTO.
     * 
     * @param address2
     */
    public void setAddress2(java.lang.String address2) {
        this.address2 = address2;
    }


    /**
     * Gets the address3 value for this PolicyInsuredDTO.
     * 
     * @return address3
     */
    public java.lang.String getAddress3() {
        return address3;
    }


    /**
     * Sets the address3 value for this PolicyInsuredDTO.
     * 
     * @param address3
     */
    public void setAddress3(java.lang.String address3) {
        this.address3 = address3;
    }


    /**
     * Gets the address4 value for this PolicyInsuredDTO.
     * 
     * @return address4
     */
    public java.lang.String getAddress4() {
        return address4;
    }


    /**
     * Sets the address4 value for this PolicyInsuredDTO.
     * 
     * @param address4
     */
    public void setAddress4(java.lang.String address4) {
        this.address4 = address4;
    }


    /**
     * Gets the anomalyInform value for this PolicyInsuredDTO.
     * 
     * @return anomalyInform
     */
    public java.lang.String getAnomalyInform() {
        return anomalyInform;
    }


    /**
     * Sets the anomalyInform value for this PolicyInsuredDTO.
     * 
     * @param anomalyInform
     */
    public void setAnomalyInform(java.lang.String anomalyInform) {
        this.anomalyInform = anomalyInform;
    }


    /**
     * Gets the appointedBenefit value for this PolicyInsuredDTO.
     * 
     * @return appointedBenefit
     */
    public java.lang.String getAppointedBenefit() {
        return appointedBenefit;
    }


    /**
     * Sets the appointedBenefit value for this PolicyInsuredDTO.
     * 
     * @param appointedBenefit
     */
    public void setAppointedBenefit(java.lang.String appointedBenefit) {
        this.appointedBenefit = appointedBenefit;
    }


    /**
     * Gets the birthday value for this PolicyInsuredDTO.
     * 
     * @return birthday
     */
    public java.util.Calendar getBirthday() {
        return birthday;
    }


    /**
     * Sets the birthday value for this PolicyInsuredDTO.
     * 
     * @param birthday
     */
    public void setBirthday(java.util.Calendar birthday) {
        this.birthday = birthday;
    }


    /**
     * Gets the critCode value for this PolicyInsuredDTO.
     * 
     * @return critCode
     */
    public java.lang.String getCritCode() {
        return critCode;
    }


    /**
     * Sets the critCode value for this PolicyInsuredDTO.
     * 
     * @param critCode
     */
    public void setCritCode(java.lang.String critCode) {
        this.critCode = critCode;
    }


    /**
     * Gets the critType value for this PolicyInsuredDTO.
     * 
     * @return critType
     */
    public java.lang.String getCritType() {
        return critType;
    }


    /**
     * Sets the critType value for this PolicyInsuredDTO.
     * 
     * @param critType
     */
    public void setCritType(java.lang.String critType) {
        this.critType = critType;
    }


    /**
     * Gets the customerNo value for this PolicyInsuredDTO.
     * 
     * @return customerNo
     */
    public java.lang.String getCustomerNo() {
        return customerNo;
    }


    /**
     * Sets the customerNo value for this PolicyInsuredDTO.
     * 
     * @param customerNo
     */
    public void setCustomerNo(java.lang.String customerNo) {
        this.customerNo = customerNo;
    }


    /**
     * Gets the empoyeeNo value for this PolicyInsuredDTO.
     * 
     * @return empoyeeNo
     */
    public java.lang.String getEmpoyeeNo() {
        return empoyeeNo;
    }


    /**
     * Sets the empoyeeNo value for this PolicyInsuredDTO.
     * 
     * @param empoyeeNo
     */
    public void setEmpoyeeNo(java.lang.String empoyeeNo) {
        this.empoyeeNo = empoyeeNo;
    }


    /**
     * Gets the gender value for this PolicyInsuredDTO.
     * 
     * @return gender
     */
    public java.lang.String getGender() {
        return gender;
    }


    /**
     * Sets the gender value for this PolicyInsuredDTO.
     * 
     * @param gender
     */
    public void setGender(java.lang.String gender) {
        this.gender = gender;
    }


    /**
     * Gets the healthFlag value for this PolicyInsuredDTO.
     * 
     * @return healthFlag
     */
    public java.lang.String getHealthFlag() {
        return healthFlag;
    }


    /**
     * Sets the healthFlag value for this PolicyInsuredDTO.
     * 
     * @param healthFlag
     */
    public void setHealthFlag(java.lang.String healthFlag) {
        this.healthFlag = healthFlag;
    }


    /**
     * Gets the insuredGroupCode value for this PolicyInsuredDTO.
     * 
     * @return insuredGroupCode
     */
    public java.lang.String getInsuredGroupCode() {
        return insuredGroupCode;
    }


    /**
     * Sets the insuredGroupCode value for this PolicyInsuredDTO.
     * 
     * @param insuredGroupCode
     */
    public void setInsuredGroupCode(java.lang.String insuredGroupCode) {
        this.insuredGroupCode = insuredGroupCode;
    }


    /**
     * Gets the insuredType value for this PolicyInsuredDTO.
     * 
     * @return insuredType
     */
    public java.lang.String getInsuredType() {
        return insuredType;
    }


    /**
     * Sets the insuredType value for this PolicyInsuredDTO.
     * 
     * @param insuredType
     */
    public void setInsuredType(java.lang.String insuredType) {
        this.insuredType = insuredType;
    }


    /**
     * Gets the name value for this PolicyInsuredDTO.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this PolicyInsuredDTO.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the occupationalCode value for this PolicyInsuredDTO.
     * 
     * @return occupationalCode
     */
    public java.lang.String getOccupationalCode() {
        return occupationalCode;
    }


    /**
     * Sets the occupationalCode value for this PolicyInsuredDTO.
     * 
     * @param occupationalCode
     */
    public void setOccupationalCode(java.lang.String occupationalCode) {
        this.occupationalCode = occupationalCode;
    }


    /**
     * Gets the offerStatus value for this PolicyInsuredDTO.
     * 
     * @return offerStatus
     */
    public java.lang.String getOfferStatus() {
        return offerStatus;
    }


    /**
     * Sets the offerStatus value for this PolicyInsuredDTO.
     * 
     * @param offerStatus
     */
    public void setOfferStatus(java.lang.String offerStatus) {
        this.offerStatus = offerStatus;
    }


    /**
     * Gets the policyBenefitDTOs value for this PolicyInsuredDTO.
     * 
     * @return policyBenefitDTOs
     */
    public com.ebao.health.insurance.dto.PolicyBenefitDTO[] getPolicyBenefitDTOs() {
        return policyBenefitDTOs;
    }


    /**
     * Sets the policyBenefitDTOs value for this PolicyInsuredDTO.
     * 
     * @param policyBenefitDTOs
     */
    public void setPolicyBenefitDTOs(com.ebao.health.insurance.dto.PolicyBenefitDTO[] policyBenefitDTOs) {
        this.policyBenefitDTOs = policyBenefitDTOs;
    }


    /**
     * Gets the relationshipWithMainInsured value for this PolicyInsuredDTO.
     * 
     * @return relationshipWithMainInsured
     */
    public java.lang.String getRelationshipWithMainInsured() {
        return relationshipWithMainInsured;
    }


    /**
     * Sets the relationshipWithMainInsured value for this PolicyInsuredDTO.
     * 
     * @param relationshipWithMainInsured
     */
    public void setRelationshipWithMainInsured(java.lang.String relationshipWithMainInsured) {
        this.relationshipWithMainInsured = relationshipWithMainInsured;
    }


    /**
     * Gets the relationshipWithPh value for this PolicyInsuredDTO.
     * 
     * @return relationshipWithPh
     */
    public java.lang.String getRelationshipWithPh() {
        return relationshipWithPh;
    }


    /**
     * Sets the relationshipWithPh value for this PolicyInsuredDTO.
     * 
     * @param relationshipWithPh
     */
    public void setRelationshipWithPh(java.lang.String relationshipWithPh) {
        this.relationshipWithPh = relationshipWithPh;
    }


    /**
     * Gets the serviceMark value for this PolicyInsuredDTO.
     * 
     * @return serviceMark
     */
    public java.lang.String getServiceMark() {
        return serviceMark;
    }


    /**
     * Sets the serviceMark value for this PolicyInsuredDTO.
     * 
     * @param serviceMark
     */
    public void setServiceMark(java.lang.String serviceMark) {
        this.serviceMark = serviceMark;
    }


    /**
     * Gets the snOfMainInsured value for this PolicyInsuredDTO.
     * 
     * @return snOfMainInsured
     */
    public java.lang.String getSnOfMainInsured() {
        return snOfMainInsured;
    }


    /**
     * Sets the snOfMainInsured value for this PolicyInsuredDTO.
     * 
     * @param snOfMainInsured
     */
    public void setSnOfMainInsured(java.lang.String snOfMainInsured) {
        this.snOfMainInsured = snOfMainInsured;
    }


    /**
     * Gets the socialcareNo value for this PolicyInsuredDTO.
     * 
     * @return socialcareNo
     */
    public java.lang.String getSocialcareNo() {
        return socialcareNo;
    }


    /**
     * Sets the socialcareNo value for this PolicyInsuredDTO.
     * 
     * @param socialcareNo
     */
    public void setSocialcareNo(java.lang.String socialcareNo) {
        this.socialcareNo = socialcareNo;
    }


    /**
     * Gets the specialPolicyUpcoverageDTOs value for this PolicyInsuredDTO.
     * 
     * @return specialPolicyUpcoverageDTOs
     */
    public com.ebao.health.insurance.dto.SpecialPolicyUpcoverageDTO[] getSpecialPolicyUpcoverageDTOs() {
        return specialPolicyUpcoverageDTOs;
    }


    /**
     * Sets the specialPolicyUpcoverageDTOs value for this PolicyInsuredDTO.
     * 
     * @param specialPolicyUpcoverageDTOs
     */
    public void setSpecialPolicyUpcoverageDTOs(com.ebao.health.insurance.dto.SpecialPolicyUpcoverageDTO[] specialPolicyUpcoverageDTOs) {
        this.specialPolicyUpcoverageDTOs = specialPolicyUpcoverageDTOs;
    }


    /**
     * Gets the subEndDate value for this PolicyInsuredDTO.
     * 
     * @return subEndDate
     */
    public java.util.Calendar getSubEndDate() {
        return subEndDate;
    }


    /**
     * Sets the subEndDate value for this PolicyInsuredDTO.
     * 
     * @param subEndDate
     */
    public void setSubEndDate(java.util.Calendar subEndDate) {
        this.subEndDate = subEndDate;
    }


    /**
     * Gets the subStartDate value for this PolicyInsuredDTO.
     * 
     * @return subStartDate
     */
    public java.util.Calendar getSubStartDate() {
        return subStartDate;
    }


    /**
     * Sets the subStartDate value for this PolicyInsuredDTO.
     * 
     * @param subStartDate
     */
    public void setSubStartDate(java.util.Calendar subStartDate) {
        this.subStartDate = subStartDate;
    }


    /**
     * Gets the workPlace value for this PolicyInsuredDTO.
     * 
     * @return workPlace
     */
    public java.lang.String getWorkPlace() {
        return workPlace;
    }


    /**
     * Sets the workPlace value for this PolicyInsuredDTO.
     * 
     * @param workPlace
     */
    public void setWorkPlace(java.lang.String workPlace) {
        this.workPlace = workPlace;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PolicyInsuredDTO)) return false;
        PolicyInsuredDTO other = (PolicyInsuredDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.address1==null && other.getAddress1()==null) || 
             (this.address1!=null &&
              this.address1.equals(other.getAddress1()))) &&
            ((this.address2==null && other.getAddress2()==null) || 
             (this.address2!=null &&
              this.address2.equals(other.getAddress2()))) &&
            ((this.address3==null && other.getAddress3()==null) || 
             (this.address3!=null &&
              this.address3.equals(other.getAddress3()))) &&
            ((this.address4==null && other.getAddress4()==null) || 
             (this.address4!=null &&
              this.address4.equals(other.getAddress4()))) &&
            ((this.anomalyInform==null && other.getAnomalyInform()==null) || 
             (this.anomalyInform!=null &&
              this.anomalyInform.equals(other.getAnomalyInform()))) &&
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
            ((this.empoyeeNo==null && other.getEmpoyeeNo()==null) || 
             (this.empoyeeNo!=null &&
              this.empoyeeNo.equals(other.getEmpoyeeNo()))) &&
            ((this.gender==null && other.getGender()==null) || 
             (this.gender!=null &&
              this.gender.equals(other.getGender()))) &&
            ((this.healthFlag==null && other.getHealthFlag()==null) || 
             (this.healthFlag!=null &&
              this.healthFlag.equals(other.getHealthFlag()))) &&
            ((this.insuredGroupCode==null && other.getInsuredGroupCode()==null) || 
             (this.insuredGroupCode!=null &&
              this.insuredGroupCode.equals(other.getInsuredGroupCode()))) &&
            ((this.insuredType==null && other.getInsuredType()==null) || 
             (this.insuredType!=null &&
              this.insuredType.equals(other.getInsuredType()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.occupationalCode==null && other.getOccupationalCode()==null) || 
             (this.occupationalCode!=null &&
              this.occupationalCode.equals(other.getOccupationalCode()))) &&
            ((this.offerStatus==null && other.getOfferStatus()==null) || 
             (this.offerStatus!=null &&
              this.offerStatus.equals(other.getOfferStatus()))) &&
            ((this.policyBenefitDTOs==null && other.getPolicyBenefitDTOs()==null) || 
             (this.policyBenefitDTOs!=null &&
              java.util.Arrays.equals(this.policyBenefitDTOs, other.getPolicyBenefitDTOs()))) &&
            ((this.relationshipWithMainInsured==null && other.getRelationshipWithMainInsured()==null) || 
             (this.relationshipWithMainInsured!=null &&
              this.relationshipWithMainInsured.equals(other.getRelationshipWithMainInsured()))) &&
            ((this.relationshipWithPh==null && other.getRelationshipWithPh()==null) || 
             (this.relationshipWithPh!=null &&
              this.relationshipWithPh.equals(other.getRelationshipWithPh()))) &&
            ((this.serviceMark==null && other.getServiceMark()==null) || 
             (this.serviceMark!=null &&
              this.serviceMark.equals(other.getServiceMark()))) &&
            ((this.snOfMainInsured==null && other.getSnOfMainInsured()==null) || 
             (this.snOfMainInsured!=null &&
              this.snOfMainInsured.equals(other.getSnOfMainInsured()))) &&
            ((this.socialcareNo==null && other.getSocialcareNo()==null) || 
             (this.socialcareNo!=null &&
              this.socialcareNo.equals(other.getSocialcareNo()))) &&
            ((this.specialPolicyUpcoverageDTOs==null && other.getSpecialPolicyUpcoverageDTOs()==null) || 
             (this.specialPolicyUpcoverageDTOs!=null &&
              java.util.Arrays.equals(this.specialPolicyUpcoverageDTOs, other.getSpecialPolicyUpcoverageDTOs()))) &&
            ((this.subEndDate==null && other.getSubEndDate()==null) || 
             (this.subEndDate!=null &&
              this.subEndDate.equals(other.getSubEndDate()))) &&
            ((this.subStartDate==null && other.getSubStartDate()==null) || 
             (this.subStartDate!=null &&
              this.subStartDate.equals(other.getSubStartDate()))) &&
            ((this.workPlace==null && other.getWorkPlace()==null) || 
             (this.workPlace!=null &&
              this.workPlace.equals(other.getWorkPlace())));
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
        if (getAddress1() != null) {
            _hashCode += getAddress1().hashCode();
        }
        if (getAddress2() != null) {
            _hashCode += getAddress2().hashCode();
        }
        if (getAddress3() != null) {
            _hashCode += getAddress3().hashCode();
        }
        if (getAddress4() != null) {
            _hashCode += getAddress4().hashCode();
        }
        if (getAnomalyInform() != null) {
            _hashCode += getAnomalyInform().hashCode();
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
        if (getEmpoyeeNo() != null) {
            _hashCode += getEmpoyeeNo().hashCode();
        }
        if (getGender() != null) {
            _hashCode += getGender().hashCode();
        }
        if (getHealthFlag() != null) {
            _hashCode += getHealthFlag().hashCode();
        }
        if (getInsuredGroupCode() != null) {
            _hashCode += getInsuredGroupCode().hashCode();
        }
        if (getInsuredType() != null) {
            _hashCode += getInsuredType().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getOccupationalCode() != null) {
            _hashCode += getOccupationalCode().hashCode();
        }
        if (getOfferStatus() != null) {
            _hashCode += getOfferStatus().hashCode();
        }
        if (getPolicyBenefitDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPolicyBenefitDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPolicyBenefitDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRelationshipWithMainInsured() != null) {
            _hashCode += getRelationshipWithMainInsured().hashCode();
        }
        if (getRelationshipWithPh() != null) {
            _hashCode += getRelationshipWithPh().hashCode();
        }
        if (getServiceMark() != null) {
            _hashCode += getServiceMark().hashCode();
        }
        if (getSnOfMainInsured() != null) {
            _hashCode += getSnOfMainInsured().hashCode();
        }
        if (getSocialcareNo() != null) {
            _hashCode += getSocialcareNo().hashCode();
        }
        if (getSpecialPolicyUpcoverageDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSpecialPolicyUpcoverageDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSpecialPolicyUpcoverageDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSubEndDate() != null) {
            _hashCode += getSubEndDate().hashCode();
        }
        if (getSubStartDate() != null) {
            _hashCode += getSubStartDate().hashCode();
        }
        if (getWorkPlace() != null) {
            _hashCode += getWorkPlace().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PolicyInsuredDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyInsuredDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address4");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anomalyInform");
        elemField.setXmlName(new javax.xml.namespace.QName("", "anomalyInform"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("appointedBenefit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "appointedBenefit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("critType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "critType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empoyeeNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "empoyeeNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gender");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gender"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("healthFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "healthFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuredGroupCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insuredGroupCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuredType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insuredType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("occupationalCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "occupationalCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offerStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "offerStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyBenefitDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyBenefitDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyBenefitDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relationshipWithMainInsured");
        elemField.setXmlName(new javax.xml.namespace.QName("", "relationshipWithMainInsured"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relationshipWithPh");
        elemField.setXmlName(new javax.xml.namespace.QName("", "relationshipWithPh"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceMark");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceMark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("snOfMainInsured");
        elemField.setXmlName(new javax.xml.namespace.QName("", "snOfMainInsured"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("socialcareNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "socialcareNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specialPolicyUpcoverageDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "specialPolicyUpcoverageDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialPolicyUpcoverageDTO"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workPlace");
        elemField.setXmlName(new javax.xml.namespace.QName("", "workPlace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
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
