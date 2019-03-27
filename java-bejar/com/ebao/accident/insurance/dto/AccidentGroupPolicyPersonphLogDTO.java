/**
 * AccidentGroupPolicyPersonphLogDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.accident.insurance.dto;

public class AccidentGroupPolicyPersonphLogDTO  implements java.io.Serializable {
    private java.lang.String contact;

    private java.lang.String contactPhone;

    private java.lang.String contactTel;

    private java.lang.String critCode;

    private java.lang.String critType;

    private java.lang.String name;

    public AccidentGroupPolicyPersonphLogDTO() {
    }

    public AccidentGroupPolicyPersonphLogDTO(
           java.lang.String contact,
           java.lang.String contactPhone,
           java.lang.String contactTel,
           java.lang.String critCode,
           java.lang.String critType,
           java.lang.String name) {
           this.contact = contact;
           this.contactPhone = contactPhone;
           this.contactTel = contactTel;
           this.critCode = critCode;
           this.critType = critType;
           this.name = name;
    }


    /**
     * Gets the contact value for this AccidentGroupPolicyPersonphLogDTO.
     * 
     * @return contact
     */
    public java.lang.String getContact() {
        return contact;
    }


    /**
     * Sets the contact value for this AccidentGroupPolicyPersonphLogDTO.
     * 
     * @param contact
     */
    public void setContact(java.lang.String contact) {
        this.contact = contact;
    }


    /**
     * Gets the contactPhone value for this AccidentGroupPolicyPersonphLogDTO.
     * 
     * @return contactPhone
     */
    public java.lang.String getContactPhone() {
        return contactPhone;
    }


    /**
     * Sets the contactPhone value for this AccidentGroupPolicyPersonphLogDTO.
     * 
     * @param contactPhone
     */
    public void setContactPhone(java.lang.String contactPhone) {
        this.contactPhone = contactPhone;
    }


    /**
     * Gets the contactTel value for this AccidentGroupPolicyPersonphLogDTO.
     * 
     * @return contactTel
     */
    public java.lang.String getContactTel() {
        return contactTel;
    }


    /**
     * Sets the contactTel value for this AccidentGroupPolicyPersonphLogDTO.
     * 
     * @param contactTel
     */
    public void setContactTel(java.lang.String contactTel) {
        this.contactTel = contactTel;
    }


    /**
     * Gets the critCode value for this AccidentGroupPolicyPersonphLogDTO.
     * 
     * @return critCode
     */
    public java.lang.String getCritCode() {
        return critCode;
    }


    /**
     * Sets the critCode value for this AccidentGroupPolicyPersonphLogDTO.
     * 
     * @param critCode
     */
    public void setCritCode(java.lang.String critCode) {
        this.critCode = critCode;
    }


    /**
     * Gets the critType value for this AccidentGroupPolicyPersonphLogDTO.
     * 
     * @return critType
     */
    public java.lang.String getCritType() {
        return critType;
    }


    /**
     * Sets the critType value for this AccidentGroupPolicyPersonphLogDTO.
     * 
     * @param critType
     */
    public void setCritType(java.lang.String critType) {
        this.critType = critType;
    }


    /**
     * Gets the name value for this AccidentGroupPolicyPersonphLogDTO.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this AccidentGroupPolicyPersonphLogDTO.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccidentGroupPolicyPersonphLogDTO)) return false;
        AccidentGroupPolicyPersonphLogDTO other = (AccidentGroupPolicyPersonphLogDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contact==null && other.getContact()==null) || 
             (this.contact!=null &&
              this.contact.equals(other.getContact()))) &&
            ((this.contactPhone==null && other.getContactPhone()==null) || 
             (this.contactPhone!=null &&
              this.contactPhone.equals(other.getContactPhone()))) &&
            ((this.contactTel==null && other.getContactTel()==null) || 
             (this.contactTel!=null &&
              this.contactTel.equals(other.getContactTel()))) &&
            ((this.critCode==null && other.getCritCode()==null) || 
             (this.critCode!=null &&
              this.critCode.equals(other.getCritCode()))) &&
            ((this.critType==null && other.getCritType()==null) || 
             (this.critType!=null &&
              this.critType.equals(other.getCritType()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName())));
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
        if (getContact() != null) {
            _hashCode += getContact().hashCode();
        }
        if (getContactPhone() != null) {
            _hashCode += getContactPhone().hashCode();
        }
        if (getContactTel() != null) {
            _hashCode += getContactTel().hashCode();
        }
        if (getCritCode() != null) {
            _hashCode += getCritCode().hashCode();
        }
        if (getCritType() != null) {
            _hashCode += getCritType().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccidentGroupPolicyPersonphLogDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyPersonphLogDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contact");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contact"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contactPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contactPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contactTel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contactTel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
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
