/**
 * PolicyBenefitLogDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class PolicyBenefitLogDTO  implements java.io.Serializable {
    private java.lang.String benefitDistribution;

    private java.util.Calendar birthday;

    private java.lang.String critCode;

    private java.lang.String critType;

    private java.lang.String gender;

    private java.lang.String name;

    private java.lang.String orderNo;

    private java.math.BigDecimal proportion;

    private java.lang.String relationshipWithInsured;

    public PolicyBenefitLogDTO() {
    }

    public PolicyBenefitLogDTO(
           java.lang.String benefitDistribution,
           java.util.Calendar birthday,
           java.lang.String critCode,
           java.lang.String critType,
           java.lang.String gender,
           java.lang.String name,
           java.lang.String orderNo,
           java.math.BigDecimal proportion,
           java.lang.String relationshipWithInsured) {
           this.benefitDistribution = benefitDistribution;
           this.birthday = birthday;
           this.critCode = critCode;
           this.critType = critType;
           this.gender = gender;
           this.name = name;
           this.orderNo = orderNo;
           this.proportion = proportion;
           this.relationshipWithInsured = relationshipWithInsured;
    }


    /**
     * Gets the benefitDistribution value for this PolicyBenefitLogDTO.
     * 
     * @return benefitDistribution
     */
    public java.lang.String getBenefitDistribution() {
        return benefitDistribution;
    }


    /**
     * Sets the benefitDistribution value for this PolicyBenefitLogDTO.
     * 
     * @param benefitDistribution
     */
    public void setBenefitDistribution(java.lang.String benefitDistribution) {
        this.benefitDistribution = benefitDistribution;
    }


    /**
     * Gets the birthday value for this PolicyBenefitLogDTO.
     * 
     * @return birthday
     */
    public java.util.Calendar getBirthday() {
        return birthday;
    }


    /**
     * Sets the birthday value for this PolicyBenefitLogDTO.
     * 
     * @param birthday
     */
    public void setBirthday(java.util.Calendar birthday) {
        this.birthday = birthday;
    }


    /**
     * Gets the critCode value for this PolicyBenefitLogDTO.
     * 
     * @return critCode
     */
    public java.lang.String getCritCode() {
        return critCode;
    }


    /**
     * Sets the critCode value for this PolicyBenefitLogDTO.
     * 
     * @param critCode
     */
    public void setCritCode(java.lang.String critCode) {
        this.critCode = critCode;
    }


    /**
     * Gets the critType value for this PolicyBenefitLogDTO.
     * 
     * @return critType
     */
    public java.lang.String getCritType() {
        return critType;
    }


    /**
     * Sets the critType value for this PolicyBenefitLogDTO.
     * 
     * @param critType
     */
    public void setCritType(java.lang.String critType) {
        this.critType = critType;
    }


    /**
     * Gets the gender value for this PolicyBenefitLogDTO.
     * 
     * @return gender
     */
    public java.lang.String getGender() {
        return gender;
    }


    /**
     * Sets the gender value for this PolicyBenefitLogDTO.
     * 
     * @param gender
     */
    public void setGender(java.lang.String gender) {
        this.gender = gender;
    }


    /**
     * Gets the name value for this PolicyBenefitLogDTO.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this PolicyBenefitLogDTO.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the orderNo value for this PolicyBenefitLogDTO.
     * 
     * @return orderNo
     */
    public java.lang.String getOrderNo() {
        return orderNo;
    }


    /**
     * Sets the orderNo value for this PolicyBenefitLogDTO.
     * 
     * @param orderNo
     */
    public void setOrderNo(java.lang.String orderNo) {
        this.orderNo = orderNo;
    }


    /**
     * Gets the proportion value for this PolicyBenefitLogDTO.
     * 
     * @return proportion
     */
    public java.math.BigDecimal getProportion() {
        return proportion;
    }


    /**
     * Sets the proportion value for this PolicyBenefitLogDTO.
     * 
     * @param proportion
     */
    public void setProportion(java.math.BigDecimal proportion) {
        this.proportion = proportion;
    }


    /**
     * Gets the relationshipWithInsured value for this PolicyBenefitLogDTO.
     * 
     * @return relationshipWithInsured
     */
    public java.lang.String getRelationshipWithInsured() {
        return relationshipWithInsured;
    }


    /**
     * Sets the relationshipWithInsured value for this PolicyBenefitLogDTO.
     * 
     * @param relationshipWithInsured
     */
    public void setRelationshipWithInsured(java.lang.String relationshipWithInsured) {
        this.relationshipWithInsured = relationshipWithInsured;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PolicyBenefitLogDTO)) return false;
        PolicyBenefitLogDTO other = (PolicyBenefitLogDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.benefitDistribution==null && other.getBenefitDistribution()==null) || 
             (this.benefitDistribution!=null &&
              this.benefitDistribution.equals(other.getBenefitDistribution()))) &&
            ((this.birthday==null && other.getBirthday()==null) || 
             (this.birthday!=null &&
              this.birthday.equals(other.getBirthday()))) &&
            ((this.critCode==null && other.getCritCode()==null) || 
             (this.critCode!=null &&
              this.critCode.equals(other.getCritCode()))) &&
            ((this.critType==null && other.getCritType()==null) || 
             (this.critType!=null &&
              this.critType.equals(other.getCritType()))) &&
            ((this.gender==null && other.getGender()==null) || 
             (this.gender!=null &&
              this.gender.equals(other.getGender()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.orderNo==null && other.getOrderNo()==null) || 
             (this.orderNo!=null &&
              this.orderNo.equals(other.getOrderNo()))) &&
            ((this.proportion==null && other.getProportion()==null) || 
             (this.proportion!=null &&
              this.proportion.equals(other.getProportion()))) &&
            ((this.relationshipWithInsured==null && other.getRelationshipWithInsured()==null) || 
             (this.relationshipWithInsured!=null &&
              this.relationshipWithInsured.equals(other.getRelationshipWithInsured())));
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
        if (getBenefitDistribution() != null) {
            _hashCode += getBenefitDistribution().hashCode();
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
        if (getGender() != null) {
            _hashCode += getGender().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getOrderNo() != null) {
            _hashCode += getOrderNo().hashCode();
        }
        if (getProportion() != null) {
            _hashCode += getProportion().hashCode();
        }
        if (getRelationshipWithInsured() != null) {
            _hashCode += getRelationshipWithInsured().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PolicyBenefitLogDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyBenefitLogDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("benefitDistribution");
        elemField.setXmlName(new javax.xml.namespace.QName("", "benefitDistribution"));
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
        elemField.setFieldName("gender");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gender"));
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
        elemField.setFieldName("orderNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("proportion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "proportion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relationshipWithInsured");
        elemField.setXmlName(new javax.xml.namespace.QName("", "relationshipWithInsured"));
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
