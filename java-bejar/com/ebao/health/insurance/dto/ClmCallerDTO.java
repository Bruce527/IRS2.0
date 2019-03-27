/**
 * ClmCallerDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class ClmCallerDTO  implements java.io.Serializable {
    private java.lang.String address1;

    private java.lang.String address2;

    private java.lang.String address3;

    private java.lang.String address4;

    private java.util.Calendar birthday;

    private java.lang.String contactNo;

    private java.lang.String critCode;

    private java.lang.String critType;

    private java.lang.String gender;

    private java.lang.String name;

    private java.lang.String relationshipWithClaimant;

    public ClmCallerDTO() {
    }

    public ClmCallerDTO(
           java.lang.String address1,
           java.lang.String address2,
           java.lang.String address3,
           java.lang.String address4,
           java.util.Calendar birthday,
           java.lang.String contactNo,
           java.lang.String critCode,
           java.lang.String critType,
           java.lang.String gender,
           java.lang.String name,
           java.lang.String relationshipWithClaimant) {
           this.address1 = address1;
           this.address2 = address2;
           this.address3 = address3;
           this.address4 = address4;
           this.birthday = birthday;
           this.contactNo = contactNo;
           this.critCode = critCode;
           this.critType = critType;
           this.gender = gender;
           this.name = name;
           this.relationshipWithClaimant = relationshipWithClaimant;
    }


    /**
     * Gets the address1 value for this ClmCallerDTO.
     * 
     * @return address1
     */
    public java.lang.String getAddress1() {
        return address1;
    }


    /**
     * Sets the address1 value for this ClmCallerDTO.
     * 
     * @param address1
     */
    public void setAddress1(java.lang.String address1) {
        this.address1 = address1;
    }


    /**
     * Gets the address2 value for this ClmCallerDTO.
     * 
     * @return address2
     */
    public java.lang.String getAddress2() {
        return address2;
    }


    /**
     * Sets the address2 value for this ClmCallerDTO.
     * 
     * @param address2
     */
    public void setAddress2(java.lang.String address2) {
        this.address2 = address2;
    }


    /**
     * Gets the address3 value for this ClmCallerDTO.
     * 
     * @return address3
     */
    public java.lang.String getAddress3() {
        return address3;
    }


    /**
     * Sets the address3 value for this ClmCallerDTO.
     * 
     * @param address3
     */
    public void setAddress3(java.lang.String address3) {
        this.address3 = address3;
    }


    /**
     * Gets the address4 value for this ClmCallerDTO.
     * 
     * @return address4
     */
    public java.lang.String getAddress4() {
        return address4;
    }


    /**
     * Sets the address4 value for this ClmCallerDTO.
     * 
     * @param address4
     */
    public void setAddress4(java.lang.String address4) {
        this.address4 = address4;
    }


    /**
     * Gets the birthday value for this ClmCallerDTO.
     * 
     * @return birthday
     */
    public java.util.Calendar getBirthday() {
        return birthday;
    }


    /**
     * Sets the birthday value for this ClmCallerDTO.
     * 
     * @param birthday
     */
    public void setBirthday(java.util.Calendar birthday) {
        this.birthday = birthday;
    }


    /**
     * Gets the contactNo value for this ClmCallerDTO.
     * 
     * @return contactNo
     */
    public java.lang.String getContactNo() {
        return contactNo;
    }


    /**
     * Sets the contactNo value for this ClmCallerDTO.
     * 
     * @param contactNo
     */
    public void setContactNo(java.lang.String contactNo) {
        this.contactNo = contactNo;
    }


    /**
     * Gets the critCode value for this ClmCallerDTO.
     * 
     * @return critCode
     */
    public java.lang.String getCritCode() {
        return critCode;
    }


    /**
     * Sets the critCode value for this ClmCallerDTO.
     * 
     * @param critCode
     */
    public void setCritCode(java.lang.String critCode) {
        this.critCode = critCode;
    }


    /**
     * Gets the critType value for this ClmCallerDTO.
     * 
     * @return critType
     */
    public java.lang.String getCritType() {
        return critType;
    }


    /**
     * Sets the critType value for this ClmCallerDTO.
     * 
     * @param critType
     */
    public void setCritType(java.lang.String critType) {
        this.critType = critType;
    }


    /**
     * Gets the gender value for this ClmCallerDTO.
     * 
     * @return gender
     */
    public java.lang.String getGender() {
        return gender;
    }


    /**
     * Sets the gender value for this ClmCallerDTO.
     * 
     * @param gender
     */
    public void setGender(java.lang.String gender) {
        this.gender = gender;
    }


    /**
     * Gets the name value for this ClmCallerDTO.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this ClmCallerDTO.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the relationshipWithClaimant value for this ClmCallerDTO.
     * 
     * @return relationshipWithClaimant
     */
    public java.lang.String getRelationshipWithClaimant() {
        return relationshipWithClaimant;
    }


    /**
     * Sets the relationshipWithClaimant value for this ClmCallerDTO.
     * 
     * @param relationshipWithClaimant
     */
    public void setRelationshipWithClaimant(java.lang.String relationshipWithClaimant) {
        this.relationshipWithClaimant = relationshipWithClaimant;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClmCallerDTO)) return false;
        ClmCallerDTO other = (ClmCallerDTO) obj;
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
            ((this.birthday==null && other.getBirthday()==null) || 
             (this.birthday!=null &&
              this.birthday.equals(other.getBirthday()))) &&
            ((this.contactNo==null && other.getContactNo()==null) || 
             (this.contactNo!=null &&
              this.contactNo.equals(other.getContactNo()))) &&
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
            ((this.relationshipWithClaimant==null && other.getRelationshipWithClaimant()==null) || 
             (this.relationshipWithClaimant!=null &&
              this.relationshipWithClaimant.equals(other.getRelationshipWithClaimant())));
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
        if (getBirthday() != null) {
            _hashCode += getBirthday().hashCode();
        }
        if (getContactNo() != null) {
            _hashCode += getContactNo().hashCode();
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
        if (getRelationshipWithClaimant() != null) {
            _hashCode += getRelationshipWithClaimant().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClmCallerDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClmCallerDTO"));
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
        elemField.setFieldName("birthday");
        elemField.setXmlName(new javax.xml.namespace.QName("", "birthday"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contactNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contactNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
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
        elemField.setFieldName("relationshipWithClaimant");
        elemField.setXmlName(new javax.xml.namespace.QName("", "relationshipWithClaimant"));
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
