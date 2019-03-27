/**
 * CoveragePaymentDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class CoveragePaymentDTO  implements java.io.Serializable {
    private java.lang.String claimConclusionCode;

    private java.lang.String claimOpinion;

    private java.lang.String comcoverageCode;

    private java.lang.String coverageCode;

    private java.lang.String coverageName;

    private java.lang.String coverageType;

    private java.lang.String hospitalCode;

    private java.lang.String liabilityClassification;

    private java.lang.String liabilityCode;

    private java.lang.String operation;

    private com.ebao.health.insurance.dto.OperationDTO[] operationDTOs;

    private java.math.BigDecimal paymentAmount;

    private com.ebao.health.insurance.dto.WesternMedicineDTO[] westernMedicineDTOs;

    public CoveragePaymentDTO() {
    }

    public CoveragePaymentDTO(
           java.lang.String claimConclusionCode,
           java.lang.String claimOpinion,
           java.lang.String comcoverageCode,
           java.lang.String coverageCode,
           java.lang.String coverageName,
           java.lang.String coverageType,
           java.lang.String hospitalCode,
           java.lang.String liabilityClassification,
           java.lang.String liabilityCode,
           java.lang.String operation,
           com.ebao.health.insurance.dto.OperationDTO[] operationDTOs,
           java.math.BigDecimal paymentAmount,
           com.ebao.health.insurance.dto.WesternMedicineDTO[] westernMedicineDTOs) {
           this.claimConclusionCode = claimConclusionCode;
           this.claimOpinion = claimOpinion;
           this.comcoverageCode = comcoverageCode;
           this.coverageCode = coverageCode;
           this.coverageName = coverageName;
           this.coverageType = coverageType;
           this.hospitalCode = hospitalCode;
           this.liabilityClassification = liabilityClassification;
           this.liabilityCode = liabilityCode;
           this.operation = operation;
           this.operationDTOs = operationDTOs;
           this.paymentAmount = paymentAmount;
           this.westernMedicineDTOs = westernMedicineDTOs;
    }


    /**
     * Gets the claimConclusionCode value for this CoveragePaymentDTO.
     * 
     * @return claimConclusionCode
     */
    public java.lang.String getClaimConclusionCode() {
        return claimConclusionCode;
    }


    /**
     * Sets the claimConclusionCode value for this CoveragePaymentDTO.
     * 
     * @param claimConclusionCode
     */
    public void setClaimConclusionCode(java.lang.String claimConclusionCode) {
        this.claimConclusionCode = claimConclusionCode;
    }


    /**
     * Gets the claimOpinion value for this CoveragePaymentDTO.
     * 
     * @return claimOpinion
     */
    public java.lang.String getClaimOpinion() {
        return claimOpinion;
    }


    /**
     * Sets the claimOpinion value for this CoveragePaymentDTO.
     * 
     * @param claimOpinion
     */
    public void setClaimOpinion(java.lang.String claimOpinion) {
        this.claimOpinion = claimOpinion;
    }


    /**
     * Gets the comcoverageCode value for this CoveragePaymentDTO.
     * 
     * @return comcoverageCode
     */
    public java.lang.String getComcoverageCode() {
        return comcoverageCode;
    }


    /**
     * Sets the comcoverageCode value for this CoveragePaymentDTO.
     * 
     * @param comcoverageCode
     */
    public void setComcoverageCode(java.lang.String comcoverageCode) {
        this.comcoverageCode = comcoverageCode;
    }


    /**
     * Gets the coverageCode value for this CoveragePaymentDTO.
     * 
     * @return coverageCode
     */
    public java.lang.String getCoverageCode() {
        return coverageCode;
    }


    /**
     * Sets the coverageCode value for this CoveragePaymentDTO.
     * 
     * @param coverageCode
     */
    public void setCoverageCode(java.lang.String coverageCode) {
        this.coverageCode = coverageCode;
    }


    /**
     * Gets the coverageName value for this CoveragePaymentDTO.
     * 
     * @return coverageName
     */
    public java.lang.String getCoverageName() {
        return coverageName;
    }


    /**
     * Sets the coverageName value for this CoveragePaymentDTO.
     * 
     * @param coverageName
     */
    public void setCoverageName(java.lang.String coverageName) {
        this.coverageName = coverageName;
    }


    /**
     * Gets the coverageType value for this CoveragePaymentDTO.
     * 
     * @return coverageType
     */
    public java.lang.String getCoverageType() {
        return coverageType;
    }


    /**
     * Sets the coverageType value for this CoveragePaymentDTO.
     * 
     * @param coverageType
     */
    public void setCoverageType(java.lang.String coverageType) {
        this.coverageType = coverageType;
    }


    /**
     * Gets the hospitalCode value for this CoveragePaymentDTO.
     * 
     * @return hospitalCode
     */
    public java.lang.String getHospitalCode() {
        return hospitalCode;
    }


    /**
     * Sets the hospitalCode value for this CoveragePaymentDTO.
     * 
     * @param hospitalCode
     */
    public void setHospitalCode(java.lang.String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }


    /**
     * Gets the liabilityClassification value for this CoveragePaymentDTO.
     * 
     * @return liabilityClassification
     */
    public java.lang.String getLiabilityClassification() {
        return liabilityClassification;
    }


    /**
     * Sets the liabilityClassification value for this CoveragePaymentDTO.
     * 
     * @param liabilityClassification
     */
    public void setLiabilityClassification(java.lang.String liabilityClassification) {
        this.liabilityClassification = liabilityClassification;
    }


    /**
     * Gets the liabilityCode value for this CoveragePaymentDTO.
     * 
     * @return liabilityCode
     */
    public java.lang.String getLiabilityCode() {
        return liabilityCode;
    }


    /**
     * Sets the liabilityCode value for this CoveragePaymentDTO.
     * 
     * @param liabilityCode
     */
    public void setLiabilityCode(java.lang.String liabilityCode) {
        this.liabilityCode = liabilityCode;
    }


    /**
     * Gets the operation value for this CoveragePaymentDTO.
     * 
     * @return operation
     */
    public java.lang.String getOperation() {
        return operation;
    }


    /**
     * Sets the operation value for this CoveragePaymentDTO.
     * 
     * @param operation
     */
    public void setOperation(java.lang.String operation) {
        this.operation = operation;
    }


    /**
     * Gets the operationDTOs value for this CoveragePaymentDTO.
     * 
     * @return operationDTOs
     */
    public com.ebao.health.insurance.dto.OperationDTO[] getOperationDTOs() {
        return operationDTOs;
    }


    /**
     * Sets the operationDTOs value for this CoveragePaymentDTO.
     * 
     * @param operationDTOs
     */
    public void setOperationDTOs(com.ebao.health.insurance.dto.OperationDTO[] operationDTOs) {
        this.operationDTOs = operationDTOs;
    }


    /**
     * Gets the paymentAmount value for this CoveragePaymentDTO.
     * 
     * @return paymentAmount
     */
    public java.math.BigDecimal getPaymentAmount() {
        return paymentAmount;
    }


    /**
     * Sets the paymentAmount value for this CoveragePaymentDTO.
     * 
     * @param paymentAmount
     */
    public void setPaymentAmount(java.math.BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }


    /**
     * Gets the westernMedicineDTOs value for this CoveragePaymentDTO.
     * 
     * @return westernMedicineDTOs
     */
    public com.ebao.health.insurance.dto.WesternMedicineDTO[] getWesternMedicineDTOs() {
        return westernMedicineDTOs;
    }


    /**
     * Sets the westernMedicineDTOs value for this CoveragePaymentDTO.
     * 
     * @param westernMedicineDTOs
     */
    public void setWesternMedicineDTOs(com.ebao.health.insurance.dto.WesternMedicineDTO[] westernMedicineDTOs) {
        this.westernMedicineDTOs = westernMedicineDTOs;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CoveragePaymentDTO)) return false;
        CoveragePaymentDTO other = (CoveragePaymentDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.claimConclusionCode==null && other.getClaimConclusionCode()==null) || 
             (this.claimConclusionCode!=null &&
              this.claimConclusionCode.equals(other.getClaimConclusionCode()))) &&
            ((this.claimOpinion==null && other.getClaimOpinion()==null) || 
             (this.claimOpinion!=null &&
              this.claimOpinion.equals(other.getClaimOpinion()))) &&
            ((this.comcoverageCode==null && other.getComcoverageCode()==null) || 
             (this.comcoverageCode!=null &&
              this.comcoverageCode.equals(other.getComcoverageCode()))) &&
            ((this.coverageCode==null && other.getCoverageCode()==null) || 
             (this.coverageCode!=null &&
              this.coverageCode.equals(other.getCoverageCode()))) &&
            ((this.coverageName==null && other.getCoverageName()==null) || 
             (this.coverageName!=null &&
              this.coverageName.equals(other.getCoverageName()))) &&
            ((this.coverageType==null && other.getCoverageType()==null) || 
             (this.coverageType!=null &&
              this.coverageType.equals(other.getCoverageType()))) &&
            ((this.hospitalCode==null && other.getHospitalCode()==null) || 
             (this.hospitalCode!=null &&
              this.hospitalCode.equals(other.getHospitalCode()))) &&
            ((this.liabilityClassification==null && other.getLiabilityClassification()==null) || 
             (this.liabilityClassification!=null &&
              this.liabilityClassification.equals(other.getLiabilityClassification()))) &&
            ((this.liabilityCode==null && other.getLiabilityCode()==null) || 
             (this.liabilityCode!=null &&
              this.liabilityCode.equals(other.getLiabilityCode()))) &&
            ((this.operation==null && other.getOperation()==null) || 
             (this.operation!=null &&
              this.operation.equals(other.getOperation()))) &&
            ((this.operationDTOs==null && other.getOperationDTOs()==null) || 
             (this.operationDTOs!=null &&
              java.util.Arrays.equals(this.operationDTOs, other.getOperationDTOs()))) &&
            ((this.paymentAmount==null && other.getPaymentAmount()==null) || 
             (this.paymentAmount!=null &&
              this.paymentAmount.equals(other.getPaymentAmount()))) &&
            ((this.westernMedicineDTOs==null && other.getWesternMedicineDTOs()==null) || 
             (this.westernMedicineDTOs!=null &&
              java.util.Arrays.equals(this.westernMedicineDTOs, other.getWesternMedicineDTOs())));
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
        if (getClaimConclusionCode() != null) {
            _hashCode += getClaimConclusionCode().hashCode();
        }
        if (getClaimOpinion() != null) {
            _hashCode += getClaimOpinion().hashCode();
        }
        if (getComcoverageCode() != null) {
            _hashCode += getComcoverageCode().hashCode();
        }
        if (getCoverageCode() != null) {
            _hashCode += getCoverageCode().hashCode();
        }
        if (getCoverageName() != null) {
            _hashCode += getCoverageName().hashCode();
        }
        if (getCoverageType() != null) {
            _hashCode += getCoverageType().hashCode();
        }
        if (getHospitalCode() != null) {
            _hashCode += getHospitalCode().hashCode();
        }
        if (getLiabilityClassification() != null) {
            _hashCode += getLiabilityClassification().hashCode();
        }
        if (getLiabilityCode() != null) {
            _hashCode += getLiabilityCode().hashCode();
        }
        if (getOperation() != null) {
            _hashCode += getOperation().hashCode();
        }
        if (getOperationDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOperationDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOperationDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPaymentAmount() != null) {
            _hashCode += getPaymentAmount().hashCode();
        }
        if (getWesternMedicineDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getWesternMedicineDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getWesternMedicineDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CoveragePaymentDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CoveragePaymentDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimConclusionCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimConclusionCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimOpinion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimOpinion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comcoverageCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comcoverageCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hospitalCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hospitalCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liabilityClassification");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liabilityClassification"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liabilityCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liabilityCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operationDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operationDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "OperationDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("westernMedicineDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "westernMedicineDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "WesternMedicineDTO"));
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
