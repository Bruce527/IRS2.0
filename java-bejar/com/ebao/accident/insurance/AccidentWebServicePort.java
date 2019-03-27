/**
 * AccidentWebServicePort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.accident.insurance;

public interface AccidentWebServicePort extends java.rmi.Remote {
    public com.ebao.accident.insurance.dto.AccidentPolicyResultsDTO accPolicyInfo(java.lang.String in0, java.lang.String in1, com.ebao.accident.insurance.dto.AccidentPolicyDTO in2) throws java.rmi.RemoteException;
    public com.ebao.accident.insurance.dto.AccidentGroupPolicyResultsDTO accGroupPolicyInfo(java.lang.String in0, java.lang.String in1, com.ebao.accident.insurance.dto.AccidentGroupPolicyDTO in2) throws java.rmi.RemoteException;
    public com.ebao.accident.insurance.dto.AccidentPolicyResultsLogDTO accEndorsementInfo(java.lang.String in0, java.lang.String in1, com.ebao.accident.insurance.dto.AccidentPolicyLogDTO in2) throws java.rmi.RemoteException;
    public com.ebao.accident.insurance.dto.AccidentGroupPolicyResultsLogDTO groupEndorsementInfo(java.lang.String in0, java.lang.String in1, com.ebao.accident.insurance.dto.AccidentGroupPolicyLogDTO in2) throws java.rmi.RemoteException;
}
