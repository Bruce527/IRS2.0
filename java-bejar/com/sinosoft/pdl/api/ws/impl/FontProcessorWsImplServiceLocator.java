/**
 * FontProcessorWsImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.pdl.api.ws.impl;

public class FontProcessorWsImplServiceLocator extends org.apache.axis.client.Service implements com.sinosoft.pdl.api.ws.impl.FontProcessorWsImplService {

    public FontProcessorWsImplServiceLocator() {
    }


    public FontProcessorWsImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FontProcessorWsImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FontProcessorWsImplPort
    private java.lang.String FontProcessorWsImplPort_address = "http://88.88.4.87:6800/pdl_qzj/api/FontProcessorWs";

    public java.lang.String getFontProcessorWsImplPortAddress() {
        return FontProcessorWsImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FontProcessorWsImplPortWSDDServiceName = "FontProcessorWsImplPort";

    public java.lang.String getFontProcessorWsImplPortWSDDServiceName() {
        return FontProcessorWsImplPortWSDDServiceName;
    }

    public void setFontProcessorWsImplPortWSDDServiceName(java.lang.String name) {
        FontProcessorWsImplPortWSDDServiceName = name;
    }

    public com.sinosoft.pdl.api.ws.FontProcessorWs getFontProcessorWsImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FontProcessorWsImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFontProcessorWsImplPort(endpoint);
    }

    public com.sinosoft.pdl.api.ws.FontProcessorWs getFontProcessorWsImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sinosoft.pdl.api.ws.impl.FontProcessorWsImplServiceSoapBindingStub _stub = new com.sinosoft.pdl.api.ws.impl.FontProcessorWsImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getFontProcessorWsImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFontProcessorWsImplPortEndpointAddress(java.lang.String address) {
        FontProcessorWsImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sinosoft.pdl.api.ws.FontProcessorWs.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sinosoft.pdl.api.ws.impl.FontProcessorWsImplServiceSoapBindingStub _stub = new com.sinosoft.pdl.api.ws.impl.FontProcessorWsImplServiceSoapBindingStub(new java.net.URL(FontProcessorWsImplPort_address), this);
                _stub.setPortName(getFontProcessorWsImplPortWSDDServiceName());
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
        if ("FontProcessorWsImplPort".equals(inputPortName)) {
            return getFontProcessorWsImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.ws.api.pdl.sinosoft.com/", "FontProcessorWsImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.ws.api.pdl.sinosoft.com/", "FontProcessorWsImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("FontProcessorWsImplPort".equals(portName)) {
            setFontProcessorWsImplPortEndpointAddress(address);
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
