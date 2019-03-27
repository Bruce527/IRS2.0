/**
 * UPStatusInfoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance.dto;

public class UPStatusInfoDTO  implements java.io.Serializable {
    private com.ebao.health.insurance.dto.UPStatusPolicyInsuredDTO[] UPStatusPolicyInsuredDTO;

    private com.ebao.health.insurance.dto.UPStatusUpCoverageDTO[] UPStatusUpCoverageDTOs;

    private java.lang.String autoPaidUp;

    private java.lang.String contractStatus;

    private java.lang.String password;

    private java.util.Calendar pauseDate;

    private java.lang.String policyNo;

    private java.lang.String policyStatusUpdateType;

    private java.lang.String regularClearing;

    private java.util.Calendar regularClearingDate;

    private java.lang.String regularClearingMark;

    private java.util.Calendar terminationDate;

    private java.lang.String terminationReason;

    private java.lang.String userName;

    private java.math.BigDecimal renewalTimes;

    public UPStatusInfoDTO() {
    }

    public UPStatusInfoDTO(
           com.ebao.health.insurance.dto.UPStatusPolicyInsuredDTO[] UPStatusPolicyInsuredDTO,
           com.ebao.health.insurance.dto.UPStatusUpCoverageDTO[] UPStatusUpCoverageDTOs,
           java.lang.String autoPaidUp,
           java.lang.String contractStatus,
           java.lang.String password,
           java.util.Calendar pauseDate,
           java.lang.String policyNo,
           java.lang.String policyStatusUpdateType,
           java.lang.String regularClearing,
           java.util.Calendar regularClearingDate,
           java.lang.String regularClearingMark,
           java.util.Calendar terminationDate,
           java.lang.String terminationReason,
           java.lang.String userName,
           java.math.BigDecimal renewalTimes) {
           this.UPStatusPolicyInsuredDTO = UPStatusPolicyInsuredDTO;
           this.UPStatusUpCoverageDTOs = UPStatusUpCoverageDTOs;
           this.autoPaidUp = autoPaidUp;
           this.contractStatus = contractStatus;
           this.password = password;
           this.pauseDate = pauseDate;
           this.policyNo = policyNo;
           this.policyStatusUpdateType = policyStatusUpdateType;
           this.regularClearing = regularClearing;
           this.regularClearingDate = regularClearingDate;
           this.regularClearingMark = regularClearingMark;
           this.terminationDate = terminationDate;
           this.terminationReason = terminationReason;
           this.userName = userName;
           this.renewalTimes = renewalTimes;
    }


    /**
     * Gets the UPStatusPolicyInsuredDTO value for this UPStatusInfoDTO.
     * 
     * @return UPStatusPolicyInsuredDTO
     */
    public com.ebao.health.insurance.dto.UPStatusPolicyInsuredDTO[] getUPStatusPolicyInsuredDTO() {
        return UPStatusPolicyInsuredDTO;
    }


    /**
     * Sets the UPStatusPolicyInsuredDTO value for this UPStatusInfoDTO.
     * 
     * @param UPStatusPolicyInsuredDTO
     */
    public void setUPStatusPolicyInsuredDTO(com.ebao.health.insurance.dto.UPStatusPolicyInsuredDTO[] UPStatusPolicyInsuredDTO) {
        this.UPStatusPolicyInsuredDTO = UPStatusPolicyInsuredDTO;
    }


    /**
     * Gets the UPStatusUpCoverageDTOs value for this UPStatusInfoDTO.
     * 
     * @return UPStatusUpCoverageDTOs
     */
    public com.ebao.health.insurance.dto.UPStatusUpCoverageDTO[] getUPStatusUpCoverageDTOs() {
        return UPStatusUpCoverageDTOs;
    }


    /**
     * Sets the UPStatusUpCoverageDTOs value for this UPStatusInfoDTO.
     * 
     * @param UPStatusUpCoverageDTOs
     */
    public void setUPStatusUpCoverageDTOs(com.ebao.health.insurance.dto.UPStatusUpCoverageDTO[] UPStatusUpCoverageDTOs) {
        this.UPStatusUpCoverageDTOs = UPStatusUpCoverageDTOs;
    }


    /**
     * Gets the autoPaidUp value for this UPStatusInfoDTO.
     * 
     * @return autoPaidUp
     */
    public java.lang.String getAutoPaidUp() {
        return autoPaidUp;
    }


    /**
     * Sets the autoPaidUp value for this UPStatusInfoDTO.
     * 
     * @param autoPaidUp
     */
    public void setAutoPaidUp(java.lang.String autoPaidUp) {
        this.autoPaidUp = autoPaidUp;
    }


    /**
     * Gets the contractStatus value for this UPStatusInfoDTO.
     * 
     * @return contractStatus
     */
    public java.lang.String getContractStatus() {
        return contractStatus;
    }


    /**
     * Sets the contractStatus value for this UPStatusInfoDTO.
     * 
     * @param contractStatus
     */
    public void setContractStatus(java.lang.String contractStatus) {
        this.contractStatus = contractStatus;
    }


    /**
     * Gets the password value for this UPStatusInfoDTO.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this UPStatusInfoDTO.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the pauseDate value for this UPStatusInfoDTO.
     * 
     * @return pauseDate
     */
    public java.util.Calendar getPauseDate() {
        return pauseDate;
    }


    /**
     * Sets the pauseDate value for this UPStatusInfoDTO.
     * 
     * @param pauseDate
     */
    public void setPauseDate(java.util.Calendar pauseDate) {
        this.pauseDate = pauseDate;
    }


    /**
     * Gets the policyNo value for this UPStatusInfoDTO.
     * 
     * @return policyNo
     */
    public java.lang.String getPolicyNo() {
        return policyNo;
    }


    /**
     * Sets the policyNo value for this UPStatusInfoDTO.
     * 
     * @param policyNo
     */
    public void setPolicyNo(java.lang.String policyNo) {
        this.policyNo = policyNo;
    }


    /**
     * Gets the policyStatusUpdateType value for this UPStatusInfoDTO.
     * 
     * @return policyStatusUpdateType
     */
    public java.lang.String getPolicyStatusUpdateType() {
        return policyStatusUpdateType;
    }


    /**
     * Sets the policyStatusUpdateType value for this UPStatusInfoDTO.
     * 
     * @param policyStatusUpdateType
     */
    public void setPolicyStatusUpdateType(java.lang.String policyStatusUpdateType) {
        this.policyStatusUpdateType = policyStatusUpdateType;
    }


    /**
     * Gets the regularClearing value for this UPStatusInfoDTO.
     * 
     * @return regularClearing
     */
    public java.lang.String getRegularClearing() {
        return regularClearing;
    }


    /**
     * Sets the regularClearing value for this UPStatusInfoDTO.
     * 
     * @param regularClearing
     */
    public void setRegularClearing(java.lang.String regularClearing) {
        this.regularClearing = regularClearing;
    }


    /**
     * Gets the regularClearingDate value for this UPStatusInfoDTO.
     * 
     * @return regularClearingDate
     */
    public java.util.Calendar getRegularClearingDate() {
        return regularClearingDate;
    }


    /**
     * Sets the regularClearingDate value for this UPStatusInfoDTO.
     * 
     * @param regularClearingDate
     */
    public void setRegularClearingDate(java.util.Calendar regularClearingDate) {
        this.regularClearingDate = regularClearingDate;
    }


    /**
     * Gets the regularClearingMark value for this UPStatusInfoDTO.
     * 
     * @return regularClearingMark
     */
    public java.lang.String getRegularClearingMark() {
        return regularClearingMark;
    }


    /**
     * Sets the regularClearingMark value for this UPStatusInfoDTO.
     * 
     * @param regularClearingMark
     */
    public void setRegularClearingMark(java.lang.String regularClearingMark) {
        this.regularClearingMark = regularClearingMark;
    }


    /**
     * Gets the terminationDate value for this UPStatusInfoDTO.
     * 
     * @return terminationDate
     */
    public java.util.Calendar getTerminationDate() {
        return terminationDate;
    }


    /**
     * Sets the terminationDate value for this UPStatusInfoDTO.
     * 
     * @param terminationDate
     */
    public void setTerminationDate(java.util.Calendar terminationDate) {
        this.terminationDate = terminationDate;
    }


    /**
     * Gets the terminationReason value for this UPStatusInfoDTO.
     * 
     * @return terminationReason
     */
    public java.lang.String getTerminationReason() {
        return terminationReason;
    }


    /**
     * Sets the terminationReason value for this UPStatusInfoDTO.
     * 
     * @param terminationReason
     */
    public void setTerminationReason(java.lang.String terminationReason) {
        this.terminationReason = terminationReason;
    }


    /**
     * Gets the userName value for this UPStatusInfoDTO.
     * 
     * @return userName
     */
    public java.lang.String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this UPStatusInfoDTO.
     * 
     * @param userName
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }


    /**
     * Gets the renewalTimes value for this UPStatusInfoDTO.
     * 
     * @return renewalTimes
     */
    public java.math.BigDecimal getRenewalTimes() {
        return renewalTimes;
    }


    /**
     * Sets the renewalTimes value for this UPStatusInfoDTO.
     * 
     * @param renewalTimes
     */
    public void setRenewalTimes(java.math.BigDecimal renewalTimes) {
        this.renewalTimes = renewalTimes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UPStatusInfoDTO)) return false;
        UPStatusInfoDTO other = (UPStatusInfoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.UPStatusPolicyInsuredDTO==null && other.getUPStatusPolicyInsuredDTO()==null) || 
             (this.UPStatusPolicyInsuredDTO!=null &&
              java.util.Arrays.equals(this.UPStatusPolicyInsuredDTO, other.getUPStatusPolicyInsuredDTO()))) &&
            ((this.UPStatusUpCoverageDTOs==null && other.getUPStatusUpCoverageDTOs()==null) || 
             (this.UPStatusUpCoverageDTOs!=null &&
              java.util.Arrays.equals(this.UPStatusUpCoverageDTOs, other.getUPStatusUpCoverageDTOs()))) &&
            ((this.autoPaidUp==null && other.getAutoPaidUp()==null) || 
             (this.autoPaidUp!=null &&
              this.autoPaidUp.equals(other.getAutoPaidUp()))) &&
            ((this.contractStatus==null && other.getContractStatus()==null) || 
             (this.contractStatus!=null &&
              this.contractStatus.equals(other.getContractStatus()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.pauseDate==null && other.getPauseDate()==null) || 
             (this.pauseDate!=null &&
              this.pauseDate.equals(other.getPauseDate()))) &&
            ((this.policyNo==null && other.getPolicyNo()==null) || 
             (this.policyNo!=null &&
              this.policyNo.equals(other.getPolicyNo()))) &&
            ((this.policyStatusUpdateType==null && other.getPolicyStatusUpdateType()==null) || 
             (this.policyStatusUpdateType!=null &&
              this.policyStatusUpdateType.equals(other.getPolicyStatusUpdateType()))) &&
            ((this.regularClearing==null && other.getRegularClearing()==null) || 
             (this.regularClearing!=null &&
              this.regularClearing.equals(other.getRegularClearing()))) &&
            ((this.regularClearingDate==null && other.getRegularClearingDate()==null) || 
             (this.regularClearingDate!=null &&
              this.regularClearingDate.equals(other.getRegularClearingDate()))) &&
            ((this.regularClearingMark==null && other.getRegularClearingMark()==null) || 
             (this.regularClearingMark!=null &&
              this.regularClearingMark.equals(other.getRegularClearingMark()))) &&
            ((this.terminationDate==null && other.getTerminationDate()==null) || 
             (this.terminationDate!=null &&
              this.terminationDate.equals(other.getTerminationDate()))) &&
            ((this.terminationReason==null && other.getTerminationReason()==null) || 
             (this.terminationReason!=null &&
              this.terminationReason.equals(other.getTerminationReason()))) &&
            ((this.userName==null && other.getUserName()==null) || 
             (this.userName!=null &&
              this.userName.equals(other.getUserName()))) &&
            ((this.renewalTimes==null && other.getRenewalTimes()==null) || 
             (this.renewalTimes!=null &&
              this.renewalTimes.equals(other.getRenewalTimes())));
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
        if (getUPStatusPolicyInsuredDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUPStatusPolicyInsuredDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUPStatusPolicyInsuredDTO(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUPStatusUpCoverageDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUPStatusUpCoverageDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUPStatusUpCoverageDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAutoPaidUp() != null) {
            _hashCode += getAutoPaidUp().hashCode();
        }
        if (getContractStatus() != null) {
            _hashCode += getContractStatus().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getPauseDate() != null) {
            _hashCode += getPauseDate().hashCode();
        }
        if (getPolicyNo() != null) {
            _hashCode += getPolicyNo().hashCode();
        }
        if (getPolicyStatusUpdateType() != null) {
            _hashCode += getPolicyStatusUpdateType().hashCode();
        }
        if (getRegularClearing() != null) {
            _hashCode += getRegularClearing().hashCode();
        }
        if (getRegularClearingDate() != null) {
            _hashCode += getRegularClearingDate().hashCode();
        }
        if (getRegularClearingMark() != null) {
            _hashCode += getRegularClearingMark().hashCode();
        }
        if (getTerminationDate() != null) {
            _hashCode += getTerminationDate().hashCode();
        }
        if (getTerminationReason() != null) {
            _hashCode += getTerminationReason().hashCode();
        }
        if (getUserName() != null) {
            _hashCode += getUserName().hashCode();
        }
        if (getRenewalTimes() != null) {
            _hashCode += getRenewalTimes().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UPStatusInfoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusInfoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UPStatusPolicyInsuredDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "UPStatusPolicyInsuredDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusPolicyInsuredDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UPStatusUpCoverageDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "UPStatusUpCoverageDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusUpCoverageDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autoPaidUp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "autoPaidUp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contractStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contractStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pauseDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pauseDate"));
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
        elemField.setFieldName("policyStatusUpdateType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyStatusUpdateType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regularClearing");
        elemField.setXmlName(new javax.xml.namespace.QName("", "regularClearing"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regularClearingDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "regularClearingDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regularClearingMark");
        elemField.setXmlName(new javax.xml.namespace.QName("", "regularClearingMark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("terminationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "terminationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("terminationReason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "terminationReason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renewalTimes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "renewalTimes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
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
