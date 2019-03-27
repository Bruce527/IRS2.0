/**
 * ClaimInfoArrayDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class ClaimInfoArrayDTO  implements java.io.Serializable {
    private java.lang.String accidentReason;

    private com.ebao.health.insurance.dto.AccidentResultArrayDTO[] accidentResultArrayDTOs;

    private java.util.Calendar accidentTime;

    private java.lang.String accidents;

    private java.math.BigDecimal claimAmount;

    private java.lang.String claimCode;

    private java.lang.String claimNo;

    private com.ebao.health.insurance.dto.ClaimantArrayDTO[] claimantArrayDTOs;

    private java.lang.String company;

    private java.util.Calendar endCaseDate;

    private java.lang.String policyNo;

    private java.lang.String policySequenceNo;

    private java.lang.String registrationNo;

    private java.lang.String reportNo;

    private java.lang.String treatmentAdvice;

    public ClaimInfoArrayDTO() {
    }

    public ClaimInfoArrayDTO(
           java.lang.String accidentReason,
           com.ebao.health.insurance.dto.AccidentResultArrayDTO[] accidentResultArrayDTOs,
           java.util.Calendar accidentTime,
           java.lang.String accidents,
           java.math.BigDecimal claimAmount,
           java.lang.String claimCode,
           java.lang.String claimNo,
           com.ebao.health.insurance.dto.ClaimantArrayDTO[] claimantArrayDTOs,
           java.lang.String company,
           java.util.Calendar endCaseDate,
           java.lang.String policyNo,
           java.lang.String policySequenceNo,
           java.lang.String registrationNo,
           java.lang.String reportNo,
           java.lang.String treatmentAdvice) {
           this.accidentReason = accidentReason;
           this.accidentResultArrayDTOs = accidentResultArrayDTOs;
           this.accidentTime = accidentTime;
           this.accidents = accidents;
           this.claimAmount = claimAmount;
           this.claimCode = claimCode;
           this.claimNo = claimNo;
           this.claimantArrayDTOs = claimantArrayDTOs;
           this.company = company;
           this.endCaseDate = endCaseDate;
           this.policyNo = policyNo;
           this.policySequenceNo = policySequenceNo;
           this.registrationNo = registrationNo;
           this.reportNo = reportNo;
           this.treatmentAdvice = treatmentAdvice;
    }


    /**
     * Gets the accidentReason value for this ClaimInfoArrayDTO.
     * 
     * @return accidentReason
     */
    public java.lang.String getAccidentReason() {
        return accidentReason;
    }


    /**
     * Sets the accidentReason value for this ClaimInfoArrayDTO.
     * 
     * @param accidentReason
     */
    public void setAccidentReason(java.lang.String accidentReason) {
        this.accidentReason = accidentReason;
    }


    /**
     * Gets the accidentResultArrayDTOs value for this ClaimInfoArrayDTO.
     * 
     * @return accidentResultArrayDTOs
     */
    public com.ebao.health.insurance.dto.AccidentResultArrayDTO[] getAccidentResultArrayDTOs() {
        return accidentResultArrayDTOs;
    }


    /**
     * Sets the accidentResultArrayDTOs value for this ClaimInfoArrayDTO.
     * 
     * @param accidentResultArrayDTOs
     */
    public void setAccidentResultArrayDTOs(com.ebao.health.insurance.dto.AccidentResultArrayDTO[] accidentResultArrayDTOs) {
        this.accidentResultArrayDTOs = accidentResultArrayDTOs;
    }


    /**
     * Gets the accidentTime value for this ClaimInfoArrayDTO.
     * 
     * @return accidentTime
     */
    public java.util.Calendar getAccidentTime() {
        return accidentTime;
    }


    /**
     * Sets the accidentTime value for this ClaimInfoArrayDTO.
     * 
     * @param accidentTime
     */
    public void setAccidentTime(java.util.Calendar accidentTime) {
        this.accidentTime = accidentTime;
    }


    /**
     * Gets the accidents value for this ClaimInfoArrayDTO.
     * 
     * @return accidents
     */
    public java.lang.String getAccidents() {
        return accidents;
    }


    /**
     * Sets the accidents value for this ClaimInfoArrayDTO.
     * 
     * @param accidents
     */
    public void setAccidents(java.lang.String accidents) {
        this.accidents = accidents;
    }


    /**
     * Gets the claimAmount value for this ClaimInfoArrayDTO.
     * 
     * @return claimAmount
     */
    public java.math.BigDecimal getClaimAmount() {
        return claimAmount;
    }


    /**
     * Sets the claimAmount value for this ClaimInfoArrayDTO.
     * 
     * @param claimAmount
     */
    public void setClaimAmount(java.math.BigDecimal claimAmount) {
        this.claimAmount = claimAmount;
    }


    /**
     * Gets the claimCode value for this ClaimInfoArrayDTO.
     * 
     * @return claimCode
     */
    public java.lang.String getClaimCode() {
        return claimCode;
    }


    /**
     * Sets the claimCode value for this ClaimInfoArrayDTO.
     * 
     * @param claimCode
     */
    public void setClaimCode(java.lang.String claimCode) {
        this.claimCode = claimCode;
    }


    /**
     * Gets the claimNo value for this ClaimInfoArrayDTO.
     * 
     * @return claimNo
     */
    public java.lang.String getClaimNo() {
        return claimNo;
    }


    /**
     * Sets the claimNo value for this ClaimInfoArrayDTO.
     * 
     * @param claimNo
     */
    public void setClaimNo(java.lang.String claimNo) {
        this.claimNo = claimNo;
    }


    /**
     * Gets the claimantArrayDTOs value for this ClaimInfoArrayDTO.
     * 
     * @return claimantArrayDTOs
     */
    public com.ebao.health.insurance.dto.ClaimantArrayDTO[] getClaimantArrayDTOs() {
        return claimantArrayDTOs;
    }


    /**
     * Sets the claimantArrayDTOs value for this ClaimInfoArrayDTO.
     * 
     * @param claimantArrayDTOs
     */
    public void setClaimantArrayDTOs(com.ebao.health.insurance.dto.ClaimantArrayDTO[] claimantArrayDTOs) {
        this.claimantArrayDTOs = claimantArrayDTOs;
    }


    /**
     * Gets the company value for this ClaimInfoArrayDTO.
     * 
     * @return company
     */
    public java.lang.String getCompany() {
        return company;
    }


    /**
     * Sets the company value for this ClaimInfoArrayDTO.
     * 
     * @param company
     */
    public void setCompany(java.lang.String company) {
        this.company = company;
    }


    /**
     * Gets the endCaseDate value for this ClaimInfoArrayDTO.
     * 
     * @return endCaseDate
     */
    public java.util.Calendar getEndCaseDate() {
        return endCaseDate;
    }


    /**
     * Sets the endCaseDate value for this ClaimInfoArrayDTO.
     * 
     * @param endCaseDate
     */
    public void setEndCaseDate(java.util.Calendar endCaseDate) {
        this.endCaseDate = endCaseDate;
    }


    /**
     * Gets the policyNo value for this ClaimInfoArrayDTO.
     * 
     * @return policyNo
     */
    public java.lang.String getPolicyNo() {
        return policyNo;
    }


    /**
     * Sets the policyNo value for this ClaimInfoArrayDTO.
     * 
     * @param policyNo
     */
    public void setPolicyNo(java.lang.String policyNo) {
        this.policyNo = policyNo;
    }


    /**
     * Gets the policySequenceNo value for this ClaimInfoArrayDTO.
     * 
     * @return policySequenceNo
     */
    public java.lang.String getPolicySequenceNo() {
        return policySequenceNo;
    }


    /**
     * Sets the policySequenceNo value for this ClaimInfoArrayDTO.
     * 
     * @param policySequenceNo
     */
    public void setPolicySequenceNo(java.lang.String policySequenceNo) {
        this.policySequenceNo = policySequenceNo;
    }


    /**
     * Gets the registrationNo value for this ClaimInfoArrayDTO.
     * 
     * @return registrationNo
     */
    public java.lang.String getRegistrationNo() {
        return registrationNo;
    }


    /**
     * Sets the registrationNo value for this ClaimInfoArrayDTO.
     * 
     * @param registrationNo
     */
    public void setRegistrationNo(java.lang.String registrationNo) {
        this.registrationNo = registrationNo;
    }


    /**
     * Gets the reportNo value for this ClaimInfoArrayDTO.
     * 
     * @return reportNo
     */
    public java.lang.String getReportNo() {
        return reportNo;
    }


    /**
     * Sets the reportNo value for this ClaimInfoArrayDTO.
     * 
     * @param reportNo
     */
    public void setReportNo(java.lang.String reportNo) {
        this.reportNo = reportNo;
    }


    /**
     * Gets the treatmentAdvice value for this ClaimInfoArrayDTO.
     * 
     * @return treatmentAdvice
     */
    public java.lang.String getTreatmentAdvice() {
        return treatmentAdvice;
    }


    /**
     * Sets the treatmentAdvice value for this ClaimInfoArrayDTO.
     * 
     * @param treatmentAdvice
     */
    public void setTreatmentAdvice(java.lang.String treatmentAdvice) {
        this.treatmentAdvice = treatmentAdvice;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClaimInfoArrayDTO)) return false;
        ClaimInfoArrayDTO other = (ClaimInfoArrayDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accidentReason==null && other.getAccidentReason()==null) || 
             (this.accidentReason!=null &&
              this.accidentReason.equals(other.getAccidentReason()))) &&
            ((this.accidentResultArrayDTOs==null && other.getAccidentResultArrayDTOs()==null) || 
             (this.accidentResultArrayDTOs!=null &&
              java.util.Arrays.equals(this.accidentResultArrayDTOs, other.getAccidentResultArrayDTOs()))) &&
            ((this.accidentTime==null && other.getAccidentTime()==null) || 
             (this.accidentTime!=null &&
              this.accidentTime.equals(other.getAccidentTime()))) &&
            ((this.accidents==null && other.getAccidents()==null) || 
             (this.accidents!=null &&
              this.accidents.equals(other.getAccidents()))) &&
            ((this.claimAmount==null && other.getClaimAmount()==null) || 
             (this.claimAmount!=null &&
              this.claimAmount.equals(other.getClaimAmount()))) &&
            ((this.claimCode==null && other.getClaimCode()==null) || 
             (this.claimCode!=null &&
              this.claimCode.equals(other.getClaimCode()))) &&
            ((this.claimNo==null && other.getClaimNo()==null) || 
             (this.claimNo!=null &&
              this.claimNo.equals(other.getClaimNo()))) &&
            ((this.claimantArrayDTOs==null && other.getClaimantArrayDTOs()==null) || 
             (this.claimantArrayDTOs!=null &&
              java.util.Arrays.equals(this.claimantArrayDTOs, other.getClaimantArrayDTOs()))) &&
            ((this.company==null && other.getCompany()==null) || 
             (this.company!=null &&
              this.company.equals(other.getCompany()))) &&
            ((this.endCaseDate==null && other.getEndCaseDate()==null) || 
             (this.endCaseDate!=null &&
              this.endCaseDate.equals(other.getEndCaseDate()))) &&
            ((this.policyNo==null && other.getPolicyNo()==null) || 
             (this.policyNo!=null &&
              this.policyNo.equals(other.getPolicyNo()))) &&
            ((this.policySequenceNo==null && other.getPolicySequenceNo()==null) || 
             (this.policySequenceNo!=null &&
              this.policySequenceNo.equals(other.getPolicySequenceNo()))) &&
            ((this.registrationNo==null && other.getRegistrationNo()==null) || 
             (this.registrationNo!=null &&
              this.registrationNo.equals(other.getRegistrationNo()))) &&
            ((this.reportNo==null && other.getReportNo()==null) || 
             (this.reportNo!=null &&
              this.reportNo.equals(other.getReportNo()))) &&
            ((this.treatmentAdvice==null && other.getTreatmentAdvice()==null) || 
             (this.treatmentAdvice!=null &&
              this.treatmentAdvice.equals(other.getTreatmentAdvice())));
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
        if (getAccidentReason() != null) {
            _hashCode += getAccidentReason().hashCode();
        }
        if (getAccidentResultArrayDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccidentResultArrayDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccidentResultArrayDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAccidentTime() != null) {
            _hashCode += getAccidentTime().hashCode();
        }
        if (getAccidents() != null) {
            _hashCode += getAccidents().hashCode();
        }
        if (getClaimAmount() != null) {
            _hashCode += getClaimAmount().hashCode();
        }
        if (getClaimCode() != null) {
            _hashCode += getClaimCode().hashCode();
        }
        if (getClaimNo() != null) {
            _hashCode += getClaimNo().hashCode();
        }
        if (getClaimantArrayDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClaimantArrayDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClaimantArrayDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCompany() != null) {
            _hashCode += getCompany().hashCode();
        }
        if (getEndCaseDate() != null) {
            _hashCode += getEndCaseDate().hashCode();
        }
        if (getPolicyNo() != null) {
            _hashCode += getPolicyNo().hashCode();
        }
        if (getPolicySequenceNo() != null) {
            _hashCode += getPolicySequenceNo().hashCode();
        }
        if (getRegistrationNo() != null) {
            _hashCode += getRegistrationNo().hashCode();
        }
        if (getReportNo() != null) {
            _hashCode += getReportNo().hashCode();
        }
        if (getTreatmentAdvice() != null) {
            _hashCode += getTreatmentAdvice().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClaimInfoArrayDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClaimInfoArrayDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidentReason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidentReason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidentResultArrayDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidentResultArrayDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "AccidentResultArrayDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidentTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidentTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidents");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidents"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimantArrayDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimantArrayDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClaimantArrayDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("company");
        elemField.setXmlName(new javax.xml.namespace.QName("", "company"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endCaseDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endCaseDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policySequenceNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policySequenceNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registrationNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "registrationNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reportNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("treatmentAdvice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "treatmentAdvice"));
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
