/**
 * AccidentPolicyPersonphDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.accident.insurance.dto;

public class AccidentPolicyPersonphDTO  implements java.io.Serializable {
    private java.util.Calendar birthday;

    private java.lang.String critCode;

    private java.lang.String critType;

    private java.lang.String gender;

    private java.lang.String mobile;

    private java.lang.String name;

    private java.lang.String relationshipWithInsured;

    public AccidentPolicyPersonphDTO() {
    }

    public AccidentPolicyPersonphDTO(
           java.util.Calendar birthday,
           java.lang.String critCode,
           java.lang.String critType,
           java.lang.String gender,
           java.lang.String mobile,
           java.lang.String name,
           java.lang.String relationshipWithInsured) {
           this.birthday = birthday;
           this.critCode = critCode;
           this.critType = critType;
           this.gender = gender;
           this.mobile = mobile;
           this.name = name;
           this.relationshipWithInsured = relationshipWithInsured;
    }


    /**
     * Gets the birthday value for this AccidentPolicyPersonphDTO.
     * 
     * @return birthday
     */
    public java.util.Calendar getBirthday() {
        return birthday;
    }


    /**
     * Sets the birthday value for this AccidentPolicyPersonphDTO.
     * 
     * @param birthday
     */
    public void setBirthday(java.util.Calendar birthday) {
        this.birthday = birthday;
    }


    /**
     * Gets the critCode value for this AccidentPolicyPersonphDTO.
     * 
     * @return critCode
     */
    public java.lang.String getCritCode() {
        return critCode;
    }


    /**
     * Sets the critCode value for this AccidentPolicyPersonphDTO.
     * 
     * @param critCode
     */
    public void setCritCode(java.lang.String critCode) {
        this.critCode = critCode;
    }


    /**
     * Gets the critType value for this AccidentPolicyPersonphDTO.
     * 
     * @return critType
     */
    public java.lang.String getCritType() {
        return critType;
    }


    /**
     * Sets the critType value for this AccidentPolicyPersonphDTO.
     * 
     * @param critType
     */
    public void setCritType(java.lang.String critType) {
        this.critType = critType;
    }


    /**
     * Gets the gender value for this AccidentPolicyPersonphDTO.
     * 
     * @return gender
     */
    public java.lang.String getGender() {
        return gender;
    }


    /**
     * Sets the gender value for this AccidentPolicyPersonphDTO.
     * 
     * @param gender
     */
    public void setGender(java.lang.String gender) {
        this.gender = gender;
    }


    /**
     * Gets the mobile value for this AccidentPolicyPersonphDTO.
     * 
     * @return mobile
     */
    public java.lang.String getMobile() {
        return mobile;
    }


    /**
     * Sets the mobile value for this AccidentPolicyPersonphDTO.
     * 
     * @param mobile
     */
    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }


    /**
     * Gets the name value for this AccidentPolicyPersonphDTO.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this AccidentPolicyPersonphDTO.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the relationshipWithInsured value for this AccidentPolicyPersonphDTO.
     * 
     * @return relationshipWithInsured
     */
    public java.lang.String getRelationshipWithInsured() {
        return relationshipWithInsured;
    }


    /**
     * Sets the relationshipWithInsured value for this AccidentPolicyPersonphDTO.
     * 
     * @param relationshipWithInsured
     */
    public void setRelationshipWithInsured(java.lang.String relationshipWithInsured) {
        this.relationshipWithInsured = relationshipWithInsured;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccidentPolicyPersonphDTO)) return false;
        AccidentPolicyPersonphDTO other = (AccidentPolicyPersonphDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
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
            ((this.mobile==null && other.getMobile()==null) || 
             (this.mobile!=null &&
              this.mobile.equals(other.getMobile()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
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
        if (getMobile() != null) {
            _hashCode += getMobile().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getRelationshipWithInsured() != null) {
            _hashCode += getRelationshipWithInsured().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccidentPolicyPersonphDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyPersonphDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("relationshipWithInsured");
        elemField.setXmlName(new javax.xml.namespace.QName("", "relationshipWithInsured"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
