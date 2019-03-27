/**
 * InsuranceWebServicePortServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.health.insurance;


public class InsuranceWebServicePortServiceLocator extends org.apache.axis.client.Service implements com.ebao.health.insurance.InsuranceWebServicePortService {

    public InsuranceWebServicePortServiceLocator() {
    }


    public InsuranceWebServicePortServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public InsuranceWebServicePortServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for InsuranceWebService
    private java.lang.String InsuranceWebService_address;
    // ParamUtil.getWSAdd(SysConst.HLT_COMCODE);//��ȡ���͵�ַ

    public java.lang.String getInsuranceWebServiceAddress() {
        return InsuranceWebService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String InsuranceWebServiceWSDDServiceName = "InsuranceWebService";

    public java.lang.String getInsuranceWebServiceWSDDServiceName() {
        return InsuranceWebServiceWSDDServiceName;
    }

    public void setInsuranceWebServiceWSDDServiceName(java.lang.String name) {
        InsuranceWebServiceWSDDServiceName = name;
    }

    public com.ebao.health.insurance.InsuranceWebServicePort getInsuranceWebService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(InsuranceWebService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getInsuranceWebService(endpoint);
    }

    public com.ebao.health.insurance.InsuranceWebServicePort getInsuranceWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.ebao.health.insurance.InsuranceWebServiceSoapBindingStub _stub = new com.ebao.health.insurance.InsuranceWebServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getInsuranceWebServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setInsuranceWebServiceEndpointAddress(java.lang.String address) {
        InsuranceWebService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.ebao.health.insurance.InsuranceWebServicePort.class.isAssignableFrom(serviceEndpointInterface)) {
                com.ebao.health.insurance.InsuranceWebServiceSoapBindingStub _stub = new com.ebao.health.insurance.InsuranceWebServiceSoapBindingStub(new java.net.URL(InsuranceWebService_address), this);
                _stub.setPortName(getInsuranceWebServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("InsuranceWebService".equals(inputPortName)) {
            return getInsuranceWebService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://insurance.health.ebao.com", "InsuranceWebServicePortService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://insurance.health.ebao.com", "InsuranceWebService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("InsuranceWebService".equals(portName)) {
            setInsuranceWebServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
