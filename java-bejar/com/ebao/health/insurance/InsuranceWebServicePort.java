/**
 * InsuranceWebServicePort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance;

public interface InsuranceWebServicePort extends java.rmi.Remote {
    public com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject getClaimInfo(com.ebao.health.insurance.dto.ClaimInfoDTO[] in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.datachange.asyclaim.AsyClaimInfoResponseObject getClaimAsyn(com.ebao.health.insurance.dto.ClaimInfoDTO[] in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject getClaimAsynResult(com.ebao.health.insurance.dto.QueryCommonParamsDTO in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.PolicyResultsDTO getPolicyInfo(com.ebao.health.insurance.dto.PolicyDTO[] in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.PolicyAsynResultDTO getPolicyInfoAsyn(com.ebao.health.insurance.dto.PolicyDTO[] in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.PolicyResultsDTO getPolicyInfoAsynResult(com.ebao.health.insurance.dto.QueryCommonParamsDTO in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.PolicyLogResultDTO getEndorsementInfo(com.ebao.health.insurance.dto.PolicyLogDTO[] in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO getEndorsementInfoAsyn(com.ebao.health.insurance.dto.PolicyLogDTO[] in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.PolicyLogResultDTO getEndorsementInfoAsynResult(com.ebao.health.insurance.dto.QueryCommonParamsDTO in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.CustomerQueryResultDTO getCustomerInfo(com.ebao.health.insurance.dto.CustomerQueryDTO in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.CustomerQueryResultDTO getGroupCustomerInfo(com.ebao.health.insurance.dto.GroupCustomerInfoQueryDTO in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.UPStatusResultsDTO updatePolicyStatus(com.ebao.health.insurance.dto.UPStatusInfoDTO[] in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject updateClaimStatus(com.ebao.health.insurance.dto.ClaimInfoDTO in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.datachange.asyclaim.AsyClaimInfoResponseObject updateClaimStatusAsyn(com.ebao.health.insurance.dto.ClaimInfoDTO[] in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.datachange.claim.ClaimInfoResponseObject getUpdateClaimStatusAsynResult(com.ebao.health.insurance.dto.QueryCommonParamsDTO in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.PolicyLogResultDTO singlePolicyEndorsementInfo(com.ebao.health.insurance.dto.PolicyLogDTO in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO singlePolicyEndorsementInfoAsyn(com.ebao.health.insurance.dto.PolicyLogDTO[] in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.PolicyLogResultDTO singlePolicyEndorsementInfoAsynResult(com.ebao.health.insurance.dto.QueryCommonParamsDTO in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.PolicyLogResultDTO cancelEndorsementInfo(com.ebao.health.insurance.dto.PolicyLogDTO in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO cancelEndorsementInfoAsyn(com.ebao.health.insurance.dto.PolicyLogDTO[] in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.PolicyLogResultDTO getCancelEndorsementInfoAsynResult(com.ebao.health.insurance.dto.QueryCommonParamsDTO in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.PolicyLogResultDTO policyRenewInfo(com.ebao.health.insurance.dto.PolicyLogDTO in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO policyRenewInfoAsyn(com.ebao.health.insurance.dto.PolicyLogDTO[] in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.PolicyLogResultDTO policyRenewInfoAsynResult(com.ebao.health.insurance.dto.QueryCommonParamsDTO in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.UPStatusAsyncResultDTO updatePolicyStatusAsyn(com.ebao.health.insurance.dto.UPStatusInfoDTO[] in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.UPStatusResultsDTO updatePolicyStatusAsynResult(com.ebao.health.insurance.dto.QueryCommonParamsDTO in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.PolicyLogResultDTO groupPolicyRenewInfo(com.ebao.health.insurance.dto.PolicyLogDTO in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.PolicyLogAsyncResultDTO groupPolicyRenewInfoAsyn(com.ebao.health.insurance.dto.PolicyLogDTO[] in0) throws java.rmi.RemoteException;
    public com.ebao.health.insurance.dto.PolicyLogResultDTO getGroupPolicyRenewInfoAsynResult(com.ebao.health.insurance.dto.QueryCommonParamsDTO in0) throws java.rmi.RemoteException;
}
