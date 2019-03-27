/**
 * InsuranceWebServiceSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance;

public class InsuranceWebServiceSoapBindingStub extends org.apache.axis.client.Stub implements com.ebao.health.insurance.InsuranceWebServicePort {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[29];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getClaimInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_ClaimInfoDTO"), com.ebao.health.insurance.dto.ClaimInfoDTO[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://claim.datachange.insurance.health.ebao.com", "ClaimInfoResponseObject"));
        oper.setReturnClass(com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getClaimInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getClaimAsyn");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_ClaimInfoDTO"), com.ebao.health.insurance.dto.ClaimInfoDTO[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://asyclaim.datachange.insurance.health.ebao.com", "AsyClaimInfoResponseObject"));
        oper.setReturnClass(com.ebao.health.insurance.datachange.asyclaim.AsyClaimInfoResponseObject.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getClaimAsynReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getClaimAsynResult");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "QueryCommonParamsDTO"), com.ebao.health.insurance.dto.QueryCommonParamsDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://claim.datachange.insurance.health.ebao.com", "ClaimInfoResponseObject"));
        oper.setReturnClass(com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getClaimAsynResultReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPolicyInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyDTO"), com.ebao.health.insurance.dto.PolicyDTO[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyResultsDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.PolicyResultsDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getPolicyInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPolicyInfoAsyn");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyDTO"), com.ebao.health.insurance.dto.PolicyDTO[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyAsynResultDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.PolicyAsynResultDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getPolicyInfoAsynReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPolicyInfoAsynResult");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "QueryCommonParamsDTO"), com.ebao.health.insurance.dto.QueryCommonParamsDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyResultsDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.PolicyResultsDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getPolicyInfoAsynResultReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getEndorsementInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyLogDTO"), com.ebao.health.insurance.dto.PolicyLogDTO[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogResultDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.PolicyLogResultDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getEndorsementInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getEndorsementInfoAsyn");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyLogDTO"), com.ebao.health.insurance.dto.PolicyLogDTO[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogAsyncResultDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getEndorsementInfoAsynReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getEndorsementInfoAsynResult");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "QueryCommonParamsDTO"), com.ebao.health.insurance.dto.QueryCommonParamsDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogResultDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.PolicyLogResultDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getEndorsementInfoAsynResultReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getCustomerInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CustomerQueryDTO"), com.ebao.health.insurance.dto.CustomerQueryDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CustomerQueryResultDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.CustomerQueryResultDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getCustomerInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getGroupCustomerInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "GroupCustomerInfoQueryDTO"), com.ebao.health.insurance.dto.GroupCustomerInfoQueryDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CustomerQueryResultDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.CustomerQueryResultDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getGroupCustomerInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updatePolicyStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_UPStatusInfoDTO"), com.ebao.health.insurance.dto.UPStatusInfoDTO[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusResultsDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.UPStatusResultsDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "updatePolicyStatusReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateClaimStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClaimInfoDTO"), com.ebao.health.insurance.dto.ClaimInfoDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://claim.datachange.insurance.health.ebao.com", "ClaimInfoResponseObject"));
        oper.setReturnClass(com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "updateClaimStatusReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateClaimStatusAsyn");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_ClaimInfoDTO"), com.ebao.health.insurance.dto.ClaimInfoDTO[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://asyclaim.datachange.insurance.health.ebao.com", "AsyClaimInfoResponseObject"));
        oper.setReturnClass(com.ebao.health.insurance.datachange.asyclaim.AsyClaimInfoResponseObject.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "updateClaimStatusAsynReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUpdateClaimStatusAsynResult");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "QueryCommonParamsDTO"), com.ebao.health.insurance.dto.QueryCommonParamsDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://claim.datachange.insurance.health.ebao.com", "ClaimInfoResponseObject"));
        oper.setReturnClass(com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getUpdateClaimStatusAsynResultReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("singlePolicyEndorsementInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogDTO"), com.ebao.health.insurance.dto.PolicyLogDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogResultDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.PolicyLogResultDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "singlePolicyEndorsementInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("singlePolicyEndorsementInfoAsyn");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyLogDTO"), com.ebao.health.insurance.dto.PolicyLogDTO[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogAsyncResultDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "singlePolicyEndorsementInfoAsynReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("singlePolicyEndorsementInfoAsynResult");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "QueryCommonParamsDTO"), com.ebao.health.insurance.dto.QueryCommonParamsDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogResultDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.PolicyLogResultDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "singlePolicyEndorsementInfoAsynResultReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cancelEndorsementInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogDTO"), com.ebao.health.insurance.dto.PolicyLogDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogResultDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.PolicyLogResultDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "cancelEndorsementInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cancelEndorsementInfoAsyn");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyLogDTO"), com.ebao.health.insurance.dto.PolicyLogDTO[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogAsyncResultDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "cancelEndorsementInfoAsynReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getCancelEndorsementInfoAsynResult");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "QueryCommonParamsDTO"), com.ebao.health.insurance.dto.QueryCommonParamsDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogResultDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.PolicyLogResultDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getCancelEndorsementInfoAsynResultReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("policyRenewInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogDTO"), com.ebao.health.insurance.dto.PolicyLogDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogResultDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.PolicyLogResultDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "policyRenewInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("policyRenewInfoAsyn");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyLogDTO"), com.ebao.health.insurance.dto.PolicyLogDTO[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogAsyncResultDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "policyRenewInfoAsynReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("policyRenewInfoAsynResult");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "QueryCommonParamsDTO"), com.ebao.health.insurance.dto.QueryCommonParamsDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogResultDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.PolicyLogResultDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "policyRenewInfoAsynResultReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updatePolicyStatusAsyn");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_UPStatusInfoDTO"), com.ebao.health.insurance.dto.UPStatusInfoDTO[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusAsyncResultDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.UPStatusAsyncResultDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "updatePolicyStatusAsynReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updatePolicyStatusAsynResult");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "QueryCommonParamsDTO"), com.ebao.health.insurance.dto.QueryCommonParamsDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusResultsDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.UPStatusResultsDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "updatePolicyStatusAsynResultReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("groupPolicyRenewInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogDTO"), com.ebao.health.insurance.dto.PolicyLogDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogResultDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.PolicyLogResultDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "groupPolicyRenewInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("groupPolicyRenewInfoAsyn");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyLogDTO"), com.ebao.health.insurance.dto.PolicyLogDTO[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogAsyncResultDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "groupPolicyRenewInfoAsynReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getGroupPolicyRenewInfoAsynResult");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "QueryCommonParamsDTO"), com.ebao.health.insurance.dto.QueryCommonParamsDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogResultDTO"));
        oper.setReturnClass(com.ebao.health.insurance.dto.PolicyLogResultDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getGroupPolicyRenewInfoAsynResultReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[28] = oper;

    }

    public InsuranceWebServiceSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public InsuranceWebServiceSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public InsuranceWebServiceSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
        addBindings0();
        addBindings1();
    }

    private void addBindings0() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://asyclaim.datachange.insurance.health.ebao.com", "AsyClaimInfoResponseObject");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.datachange.asyclaim.AsyClaimInfoResponseObject.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://claim.datachange.insurance.health.ebao.com", "ClaimInfoResponseObject");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://claim.datachange.insurance.health.ebao.com", "ClaimResult");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.datachange.claim.ClaimResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "AccidentResultArrayDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.AccidentResultArrayDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "AccidentResultDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.AccidentResultDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ApprovalReceiptDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.ApprovalReceiptDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "BirthClinicReceiptDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.BirthClinicReceiptDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "BirthHospitalReceiptDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.BirthHospitalReceiptDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClaimantArrayDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.ClaimantArrayDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClaimInfoArrayDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.ClaimInfoArrayDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClaimInfoDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.ClaimInfoDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClinicReceiptDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.ClinicReceiptDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClmCallerDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.ClmCallerDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClmClaimantDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.ClmClaimantDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CooperationHospitalReceiptDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.CooperationHospitalReceiptDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CostItemDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.CostItemDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CoverageInfoDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.CoverageInfoDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CoveragePaymentDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.CoveragePaymentDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CustomerQueryDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.CustomerQueryDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CustomerQueryResultDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.CustomerQueryResultDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "DiagnosisDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.DiagnosisDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "EndorsementInfoDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.EndorsementInfoDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "EndorsementTypeDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.EndorsementTypeDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "GroupCustomerInfoQueryDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.GroupCustomerInfoQueryDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "HospitalReceiptDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.HospitalReceiptDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "MedicalFeeDetailDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.MedicalFeeDetailDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "OperationDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.OperationDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "OrdinaryClinicReceiptDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.OrdinaryClinicReceiptDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "OrdinaryHospitalReceiptDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.OrdinaryHospitalReceiptDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyAmountDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyAmountDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyAmountLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyAmountLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyAsynResultDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyAsynResultDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyBenefitDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyBenefitDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyBenefitLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyBenefitLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyCoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyCoverageDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyCoverageLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyCoverageLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyGroupphDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyGroupphDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyGroupPHLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyGroupPHLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyInfoDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyInfoDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyInsuredDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyInsuredDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyInsuredLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyInsuredLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogAsyncResultDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogResultDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyLogResultDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogResultItemDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyLogResultItemDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyPaymentDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyPaymentDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyPersonphDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyPersonphDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyPersonPHLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyPersonPHLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyResultDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyResultDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyResultsDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyResultsDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyUpcoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyUpcoverageDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyUpcoverageLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyUpcoverageLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "QueryCommonParamsDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.QueryCommonParamsDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SegmentationReceiptDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.SegmentationReceiptDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialPolicyAmountDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.SpecialPolicyAmountDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialPolicyAmountLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.SpecialPolicyAmountLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialPolicyCoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.SpecialPolicyCoverageDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialPolicyCoverageLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.SpecialPolicyCoverageLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialPolicyUpcoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.SpecialPolicyUpcoverageDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialPolicyUpcoverageLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.SpecialPolicyUpcoverageLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialReceiptDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.SpecialReceiptDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialUnderWritingDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.SpecialUnderWritingDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialUnderWritingLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.SpecialUnderWritingLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UnderWritingDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.UnderWritingDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UnderWritingLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.UnderWritingLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusAsyncResultDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.UPStatusAsyncResultDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusCoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.UPStatusCoverageDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusInfoDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.UPStatusInfoDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusPolicyInsuredDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.UPStatusPolicyInsuredDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusResultDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.UPStatusResultDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusResultsDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.UPStatusResultsDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusSpecialCoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.UPStatusSpecialCoverageDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusSpecialUpCoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.UPStatusSpecialUpCoverageDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusUpCoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.UPStatusUpCoverageDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "WesternMedicineDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.WesternMedicineDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_AccidentResultArrayDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.AccidentResultArrayDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "AccidentResultArrayDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_AccidentResultDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.AccidentResultDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "AccidentResultDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_ApprovalReceiptDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.ApprovalReceiptDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ApprovalReceiptDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_BirthClinicReceiptDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.BirthClinicReceiptDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "BirthClinicReceiptDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_BirthHospitalReceiptDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.BirthHospitalReceiptDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "BirthHospitalReceiptDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_ClaimantArrayDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.ClaimantArrayDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClaimantArrayDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_ClaimInfoArrayDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.ClaimInfoArrayDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClaimInfoArrayDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_ClaimInfoDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.ClaimInfoDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClaimInfoDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_ClinicReceiptDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.ClinicReceiptDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClinicReceiptDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_ClmCallerDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.ClmCallerDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClmCallerDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_ClmClaimantDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.ClmClaimantDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "ClmClaimantDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_CooperationHospitalReceiptDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.CooperationHospitalReceiptDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CooperationHospitalReceiptDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_CostItemDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.CostItemDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CostItemDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_CoverageInfoDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.CoverageInfoDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CoverageInfoDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_CoveragePaymentDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.CoveragePaymentDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "CoveragePaymentDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_DiagnosisDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.DiagnosisDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "DiagnosisDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_EndorsementInfoDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.EndorsementInfoDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "EndorsementInfoDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_EndorsementTypeDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.EndorsementTypeDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "EndorsementTypeDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_HospitalReceiptDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.HospitalReceiptDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "HospitalReceiptDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_MedicalFeeDetailDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.MedicalFeeDetailDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "MedicalFeeDetailDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_OperationDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.OperationDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "OperationDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_OrdinaryClinicReceiptDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.OrdinaryClinicReceiptDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "OrdinaryClinicReceiptDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_OrdinaryHospitalReceiptDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.OrdinaryHospitalReceiptDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "OrdinaryHospitalReceiptDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyAmountDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyAmountDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyAmountDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

    }
    private void addBindings1() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyAmountLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyAmountLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyAmountLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyBenefitDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyBenefitDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyBenefitDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyBenefitLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyBenefitLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyBenefitLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyCoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyCoverageDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyCoverageDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyCoverageLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyCoverageLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyCoverageLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyGroupphDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyGroupphDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyGroupphDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyGroupPHLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyGroupPHLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyGroupPHLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyInfoDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyInfoDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyInfoDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyInsuredDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyInsuredDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyInsuredDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyInsuredLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyInsuredLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyInsuredLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyLogResultItemDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyLogResultItemDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyLogResultItemDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyPaymentDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyPaymentDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyPaymentDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyPersonphDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyPersonphDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyPersonphDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyPersonPHLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyPersonPHLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyPersonPHLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyResultDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyResultDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyResultDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyUpcoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyUpcoverageDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyUpcoverageDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_PolicyUpcoverageLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.PolicyUpcoverageLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "PolicyUpcoverageLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_SegmentationReceiptDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.SegmentationReceiptDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SegmentationReceiptDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_SpecialPolicyAmountDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.SpecialPolicyAmountDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialPolicyAmountDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_SpecialPolicyAmountLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.SpecialPolicyAmountLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialPolicyAmountLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_SpecialPolicyCoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.SpecialPolicyCoverageDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialPolicyCoverageDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_SpecialPolicyCoverageLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.SpecialPolicyCoverageLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialPolicyCoverageLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_SpecialPolicyUpcoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.SpecialPolicyUpcoverageDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialPolicyUpcoverageDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_SpecialPolicyUpcoverageLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.SpecialPolicyUpcoverageLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialPolicyUpcoverageLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_SpecialReceiptDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.SpecialReceiptDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialReceiptDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_SpecialUnderWritingDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.SpecialUnderWritingDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialUnderWritingDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_SpecialUnderWritingLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.SpecialUnderWritingLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "SpecialUnderWritingLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_UnderWritingDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.UnderWritingDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UnderWritingDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_UnderWritingLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.UnderWritingLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UnderWritingLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_UPStatusCoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.UPStatusCoverageDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusCoverageDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_UPStatusInfoDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.UPStatusInfoDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusInfoDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_UPStatusPolicyInsuredDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.UPStatusPolicyInsuredDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusPolicyInsuredDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_UPStatusResultDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.UPStatusResultDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusResultDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_UPStatusSpecialCoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.UPStatusSpecialCoverageDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusSpecialCoverageDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_UPStatusSpecialUpCoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.UPStatusSpecialUpCoverageDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusSpecialUpCoverageDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_UPStatusUpCoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.UPStatusUpCoverageDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "UPStatusUpCoverageDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns2_WesternMedicineDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.dto.WesternMedicineDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.health.ebao.com", "WesternMedicineDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.health.ebao.com", "ArrayOf_tns3_ClaimResult");
            cachedSerQNames.add(qName);
            cls = com.ebao.health.insurance.datachange.claim.ClaimResult[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://claim.datachange.insurance.health.ebao.com", "ClaimResult");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject getClaimInfo(com.ebao.health.insurance.dto.ClaimInfoDTO[] in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "getClaimInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.datachange.asyclaim.AsyClaimInfoResponseObject getClaimAsyn(com.ebao.health.insurance.dto.ClaimInfoDTO[] in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "getClaimAsyn"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.datachange.asyclaim.AsyClaimInfoResponseObject) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.datachange.asyclaim.AsyClaimInfoResponseObject) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.datachange.asyclaim.AsyClaimInfoResponseObject.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject getClaimAsynResult(com.ebao.health.insurance.dto.QueryCommonParamsDTO in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "getClaimAsynResult"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.PolicyResultsDTO getPolicyInfo(com.ebao.health.insurance.dto.PolicyDTO[] in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "getPolicyInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.PolicyResultsDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.PolicyResultsDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.PolicyResultsDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.PolicyAsynResultDTO getPolicyInfoAsyn(com.ebao.health.insurance.dto.PolicyDTO[] in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "getPolicyInfoAsyn"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.PolicyAsynResultDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.PolicyAsynResultDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.PolicyAsynResultDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.PolicyResultsDTO getPolicyInfoAsynResult(com.ebao.health.insurance.dto.QueryCommonParamsDTO in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "getPolicyInfoAsynResult"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.PolicyResultsDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.PolicyResultsDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.PolicyResultsDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.PolicyLogResultDTO getEndorsementInfo(com.ebao.health.insurance.dto.PolicyLogDTO[] in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "getEndorsementInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.PolicyLogResultDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.PolicyLogResultDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.PolicyLogResultDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO getEndorsementInfoAsyn(com.ebao.health.insurance.dto.PolicyLogDTO[] in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "getEndorsementInfoAsyn"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.PolicyLogResultDTO getEndorsementInfoAsynResult(com.ebao.health.insurance.dto.QueryCommonParamsDTO in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "getEndorsementInfoAsynResult"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.PolicyLogResultDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.PolicyLogResultDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.PolicyLogResultDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.CustomerQueryResultDTO getCustomerInfo(com.ebao.health.insurance.dto.CustomerQueryDTO in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "getCustomerInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.CustomerQueryResultDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.CustomerQueryResultDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.CustomerQueryResultDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.CustomerQueryResultDTO getGroupCustomerInfo(com.ebao.health.insurance.dto.GroupCustomerInfoQueryDTO in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "getGroupCustomerInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.CustomerQueryResultDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.CustomerQueryResultDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.CustomerQueryResultDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.UPStatusResultsDTO updatePolicyStatus(com.ebao.health.insurance.dto.UPStatusInfoDTO[] in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "updatePolicyStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.UPStatusResultsDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.UPStatusResultsDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.UPStatusResultsDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject updateClaimStatus(com.ebao.health.insurance.dto.ClaimInfoDTO in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "updateClaimStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.datachange.asyclaim.AsyClaimInfoResponseObject updateClaimStatusAsyn(com.ebao.health.insurance.dto.ClaimInfoDTO[] in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "updateClaimStatusAsyn"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.datachange.asyclaim.AsyClaimInfoResponseObject) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.datachange.asyclaim.AsyClaimInfoResponseObject) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.datachange.asyclaim.AsyClaimInfoResponseObject.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject getUpdateClaimStatusAsynResult(com.ebao.health.insurance.dto.QueryCommonParamsDTO in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "getUpdateClaimStatusAsynResult"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.PolicyLogResultDTO singlePolicyEndorsementInfo(com.ebao.health.insurance.dto.PolicyLogDTO in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "singlePolicyEndorsementInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.PolicyLogResultDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.PolicyLogResultDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.PolicyLogResultDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO singlePolicyEndorsementInfoAsyn(com.ebao.health.insurance.dto.PolicyLogDTO[] in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "singlePolicyEndorsementInfoAsyn"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.PolicyLogResultDTO singlePolicyEndorsementInfoAsynResult(com.ebao.health.insurance.dto.QueryCommonParamsDTO in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "singlePolicyEndorsementInfoAsynResult"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.PolicyLogResultDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.PolicyLogResultDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.PolicyLogResultDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.PolicyLogResultDTO cancelEndorsementInfo(com.ebao.health.insurance.dto.PolicyLogDTO in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "cancelEndorsementInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.PolicyLogResultDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.PolicyLogResultDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.PolicyLogResultDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO cancelEndorsementInfoAsyn(com.ebao.health.insurance.dto.PolicyLogDTO[] in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "cancelEndorsementInfoAsyn"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.PolicyLogResultDTO getCancelEndorsementInfoAsynResult(com.ebao.health.insurance.dto.QueryCommonParamsDTO in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "getCancelEndorsementInfoAsynResult"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.PolicyLogResultDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.PolicyLogResultDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.PolicyLogResultDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.PolicyLogResultDTO policyRenewInfo(com.ebao.health.insurance.dto.PolicyLogDTO in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "policyRenewInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.PolicyLogResultDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.PolicyLogResultDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.PolicyLogResultDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO policyRenewInfoAsyn(com.ebao.health.insurance.dto.PolicyLogDTO[] in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "policyRenewInfoAsyn"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.PolicyLogResultDTO policyRenewInfoAsynResult(com.ebao.health.insurance.dto.QueryCommonParamsDTO in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "policyRenewInfoAsynResult"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.PolicyLogResultDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.PolicyLogResultDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.PolicyLogResultDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.UPStatusAsyncResultDTO updatePolicyStatusAsyn(com.ebao.health.insurance.dto.UPStatusInfoDTO[] in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "updatePolicyStatusAsyn"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.UPStatusAsyncResultDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.UPStatusAsyncResultDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.UPStatusAsyncResultDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.UPStatusResultsDTO updatePolicyStatusAsynResult(com.ebao.health.insurance.dto.QueryCommonParamsDTO in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "updatePolicyStatusAsynResult"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.UPStatusResultsDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.UPStatusResultsDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.UPStatusResultsDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.PolicyLogResultDTO groupPolicyRenewInfo(com.ebao.health.insurance.dto.PolicyLogDTO in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "groupPolicyRenewInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.PolicyLogResultDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.PolicyLogResultDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.PolicyLogResultDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO groupPolicyRenewInfoAsyn(com.ebao.health.insurance.dto.PolicyLogDTO[] in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "groupPolicyRenewInfoAsyn"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.health.insurance.dto.PolicyLogResultDTO getGroupPolicyRenewInfoAsynResult(com.ebao.health.insurance.dto.QueryCommonParamsDTO in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "getGroupPolicyRenewInfoAsynResult"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.health.insurance.dto.PolicyLogResultDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.health.insurance.dto.PolicyLogResultDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.health.insurance.dto.PolicyLogResultDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
