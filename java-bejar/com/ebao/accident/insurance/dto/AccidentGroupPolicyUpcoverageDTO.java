/**
 * AccidentGroupPolicyUpcoverageDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.accident.insurance.dto;

public class AccidentGroupPolicyUpcoverageDTO  implements java.io.Serializable {
    private com.ebao.accident.insurance.dto.AccidentGroupPolicyCoverageDTO[] accidentGroupPolicyCoverageDTOs;

    private java.lang.String comCoverageCode;

    private java.lang.String coverageCode;

    private java.util.Calendar coverageEffectiveDate;

    private java.util.Calendar coverageExpireDate;

    private java.lang.String coverageName;

    private java.math.BigDecimal coveragePremium;

    private java.math.BigDecimal coverageSuminsured;

    private java.lang.String mainAttachedFlag;

    private java.lang.String paymentMethod;

    private java.math.BigDecimal paymentYears;

    private java.lang.String specificBusiness;

    private java.lang.String specificBusinessCode;

    public AccidentGroupPolicyUpcoverageDTO() {
    }

    public AccidentGroupPolicyUpcoverageDTO(
           com.ebao.accident.insurance.dto.AccidentGroupPolicyCoverageDTO[] accidentGroupPolicyCoverageDTOs,
           java.lang.String comCoverageCode,
           java.lang.String coverageCode,
           java.util.Calendar coverageEffectiveDate,
           java.util.Calendar coverageExpireDate,
           java.lang.String coverageName,
           java.math.BigDecimal coveragePremium,
           java.math.BigDecimal coverageSuminsured,
           java.lang.String mainAttachedFlag,
           java.lang.String paymentMethod,
           java.math.BigDecimal paymentYears,
           java.lang.String specificBusiness,
           java.lang.String specificBusinessCode) {
           this.accidentGroupPolicyCoverageDTOs = accidentGroupPolicyCoverageDTOs;
           this.comCoverageCode = comCoverageCode;
           this.coverageCode = coverageCode;
           this.coverageEffectiveDate = coverageEffectiveDate;
           this.coverageExpireDate = coverageExpireDate;
           this.coverageName = coverageName;
           this.coveragePremium = coveragePremium;
           this.coverageSuminsured = coverageSuminsured;
           this.mainAttachedFlag = mainAttachedFlag;
           this.paymentMethod = paymentMethod;
           this.paymentYears = paymentYears;
           this.specificBusiness = specificBusiness;
           this.specificBusinessCode = specificBusinessCode;
    }


    /**
     * Gets the accidentGroupPolicyCoverageDTOs value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @return accidentGroupPolicyCoverageDTOs
     */
    public com.ebao.accident.insurance.dto.AccidentGroupPolicyCoverageDTO[] getAccidentGroupPolicyCoverageDTOs() {
        return accidentGroupPolicyCoverageDTOs;
    }


    /**
     * Sets the accidentGroupPolicyCoverageDTOs value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @param accidentGroupPolicyCoverageDTOs
     */
    public void setAccidentGroupPolicyCoverageDTOs(com.ebao.accident.insurance.dto.AccidentGroupPolicyCoverageDTO[] accidentGroupPolicyCoverageDTOs) {
        this.accidentGroupPolicyCoverageDTOs = accidentGroupPolicyCoverageDTOs;
    }


    /**
     * Gets the comCoverageCode value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @return comCoverageCode
     */
    public java.lang.String getComCoverageCode() {
        return comCoverageCode;
    }


    /**
     * Sets the comCoverageCode value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @param comCoverageCode
     */
    public void setComCoverageCode(java.lang.String comCoverageCode) {
        this.comCoverageCode = comCoverageCode;
    }


    /**
     * Gets the coverageCode value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @return coverageCode
     */
    public java.lang.String getCoverageCode() {
        return coverageCode;
    }


    /**
     * Sets the coverageCode value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @param coverageCode
     */
    public void setCoverageCode(java.lang.String coverageCode) {
        this.coverageCode = coverageCode;
    }


    /**
     * Gets the coverageEffectiveDate value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @return coverageEffectiveDate
     */
    public java.util.Calendar getCoverageEffectiveDate() {
        return coverageEffectiveDate;
    }


    /**
     * Sets the coverageEffectiveDate value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @param coverageEffectiveDate
     */
    public void setCoverageEffectiveDate(java.util.Calendar coverageEffectiveDate) {
        this.coverageEffectiveDate = coverageEffectiveDate;
    }


    /**
     * Gets the coverageExpireDate value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @return coverageExpireDate
     */
    public java.util.Calendar getCoverageExpireDate() {
        return coverageExpireDate;
    }


    /**
     * Sets the coverageExpireDate value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @param coverageExpireDate
     */
    public void setCoverageExpireDate(java.util.Calendar coverageExpireDate) {
        this.coverageExpireDate = coverageExpireDate;
    }


    /**
     * Gets the coverageName value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @return coverageName
     */
    public java.lang.String getCoverageName() {
        return coverageName;
    }


    /**
     * Sets the coverageName value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @param coverageName
     */
    public void setCoverageName(java.lang.String coverageName) {
        this.coverageName = coverageName;
    }


    /**
     * Gets the coveragePremium value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @return coveragePremium
     */
    public java.math.BigDecimal getCoveragePremium() {
        return coveragePremium;
    }


    /**
     * Sets the coveragePremium value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @param coveragePremium
     */
    public void setCoveragePremium(java.math.BigDecimal coveragePremium) {
        this.coveragePremium = coveragePremium;
    }


    /**
     * Gets the coverageSuminsured value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @return coverageSuminsured
     */
    public java.math.BigDecimal getCoverageSuminsured() {
        return coverageSuminsured;
    }


    /**
     * Sets the coverageSuminsured value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @param coverageSuminsured
     */
    public void setCoverageSuminsured(java.math.BigDecimal coverageSuminsured) {
        this.coverageSuminsured = coverageSuminsured;
    }


    /**
     * Gets the mainAttachedFlag value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @return mainAttachedFlag
     */
    public java.lang.String getMainAttachedFlag() {
        return mainAttachedFlag;
    }


    /**
     * Sets the mainAttachedFlag value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @param mainAttachedFlag
     */
    public void setMainAttachedFlag(java.lang.String mainAttachedFlag) {
        this.mainAttachedFlag = mainAttachedFlag;
    }


    /**
     * Gets the paymentMethod value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @return paymentMethod
     */
    public java.lang.String getPaymentMethod() {
        return paymentMethod;
    }


    /**
     * Sets the paymentMethod value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @param paymentMethod
     */
    public void setPaymentMethod(java.lang.String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    /**
     * Gets the paymentYears value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @return paymentYears
     */
    public java.math.BigDecimal getPaymentYears() {
        return paymentYears;
    }


    /**
     * Sets the paymentYears value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @param paymentYears
     */
    public void setPaymentYears(java.math.BigDecimal paymentYears) {
        this.paymentYears = paymentYears;
    }


    /**
     * Gets the specificBusiness value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @return specificBusiness
     */
    public java.lang.String getSpecificBusiness() {
        return specificBusiness;
    }


    /**
     * Sets the specificBusiness value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @param specificBusiness
     */
    public void setSpecificBusiness(java.lang.String specificBusiness) {
        this.specificBusiness = specificBusiness;
    }


    /**
     * Gets the specificBusinessCode value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @return specificBusinessCode
     */
    public java.lang.String getSpecificBusinessCode() {
        return specificBusinessCode;
    }


    /**
     * Sets the specificBusinessCode value for this AccidentGroupPolicyUpcoverageDTO.
     * 
     * @param specificBusinessCode
     */
    public void setSpecificBusinessCode(java.lang.String specificBusinessCode) {
        this.specificBusinessCode = specificBusinessCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccidentGroupPolicyUpcoverageDTO)) return false;
        AccidentGroupPolicyUpcoverageDTO other = (AccidentGroupPolicyUpcoverageDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accidentGroupPolicyCoverageDTOs==null && other.getAccidentGroupPolicyCoverageDTOs()==null) || 
             (this.accidentGroupPolicyCoverageDTOs!=null &&
              java.util.Arrays.equals(this.accidentGroupPolicyCoverageDTOs, other.getAccidentGroupPolicyCoverageDTOs()))) &&
            ((this.comCoverageCode==null && other.getComCoverageCode()==null) || 
             (this.comCoverageCode!=null &&
              this.comCoverageCode.equals(other.getComCoverageCode()))) &&
            ((this.coverageCode==null && other.getCoverageCode()==null) || 
             (this.coverageCode!=null &&
              this.coverageCode.equals(other.getCoverageCode()))) &&
            ((this.coverageEffectiveDate==null && other.getCoverageEffectiveDate()==null) || 
             (this.coverageEffectiveDate!=null &&
              this.coverageEffectiveDate.equals(other.getCoverageEffectiveDate()))) &&
            ((this.coverageExpireDate==null && other.getCoverageExpireDate()==null) || 
             (this.coverageExpireDate!=null &&
              this.coverageExpireDate.equals(other.getCoverageExpireDate()))) &&
            ((this.coverageName==null && other.getCoverageName()==null) || 
             (this.coverageName!=null &&
              this.coverageName.equals(other.getCoverageName()))) &&
            ((this.coveragePremium==null && other.getCoveragePremium()==null) || 
             (this.coveragePremium!=null &&
              this.coveragePremium.equals(other.getCoveragePremium()))) &&
            ((this.coverageSuminsured==null && other.getCoverageSuminsured()==null) || 
             (this.coverageSuminsured!=null &&
              this.coverageSuminsured.equals(other.getCoverageSuminsured()))) &&
            ((this.mainAttachedFlag==null && other.getMainAttachedFlag()==null) || 
             (this.mainAttachedFlag!=null &&
              this.mainAttachedFlag.equals(other.getMainAttachedFlag()))) &&
            ((this.paymentMethod==null && other.getPaymentMethod()==null) || 
             (this.paymentMethod!=null &&
              this.paymentMethod.equals(other.getPaymentMethod()))) &&
            ((this.paymentYears==null && other.getPaymentYears()==null) || 
             (this.paymentYears!=null &&
              this.paymentYears.equals(other.getPaymentYears()))) &&
            ((this.specificBusiness==null && other.getSpecificBusiness()==null) || 
             (this.specificBusiness!=null &&
              this.specificBusiness.equals(other.getSpecificBusiness()))) &&
            ((this.specificBusinessCode==null && other.getSpecificBusinessCode()==null) || 
             (this.specificBusinessCode!=null &&
              this.specificBusinessCode.equals(other.getSpecificBusinessCode())));
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
        if (getAccidentGroupPolicyCoverageDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccidentGroupPolicyCoverageDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccidentGroupPolicyCoverageDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getComCoverageCode() != null) {
            _hashCode += getComCoverageCode().hashCode();
        }
        if (getCoverageCode() != null) {
            _hashCode += getCoverageCode().hashCode();
        }
        if (getCoverageEffectiveDate() != null) {
            _hashCode += getCoverageEffectiveDate().hashCode();
        }
        if (getCoverageExpireDate() != null) {
            _hashCode += getCoverageExpireDate().hashCode();
        }
        if (getCoverageName() != null) {
            _hashCode += getCoverageName().hashCode();
        }
        if (getCoveragePremium() != null) {
            _hashCode += getCoveragePremium().hashCode();
        }
        if (getCoverageSuminsured() != null) {
            _hashCode += getCoverageSuminsured().hashCode();
        }
        if (getMainAttachedFlag() != null) {
            _hashCode += getMainAttachedFlag().hashCode();
        }
        if (getPaymentMethod() != null) {
            _hashCode += getPaymentMethod().hashCode();
        }
        if (getPaymentYears() != null) {
            _hashCode += getPaymentYears().hashCode();
        }
        if (getSpecificBusiness() != null) {
            _hashCode += getSpecificBusiness().hashCode();
        }
        if (getSpecificBusinessCode() != null) {
            _hashCode += getSpecificBusinessCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccidentGroupPolicyUpcoverageDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyUpcoverageDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidentGroupPolicyCoverageDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidentGroupPolicyCoverageDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyCoverageDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comCoverageCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comCoverageCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageEffectiveDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageEffectiveDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageExpireDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageExpireDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coveragePremium");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coveragePremium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageSuminsured");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageSuminsured"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mainAttachedFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mainAttachedFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentYears");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentYears"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specificBusiness");
        elemField.setXmlName(new javax.xml.namespace.QName("", "specificBusiness"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specificBusinessCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "specificBusinessCode"));
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
