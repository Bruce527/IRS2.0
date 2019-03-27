package com.sinosoft.pdl.api.ws;

public class FontProcessorWsProxy implements com.sinosoft.pdl.api.ws.FontProcessorWs {
  private String _endpoint = null;
  private com.sinosoft.pdl.api.ws.FontProcessorWs fontProcessorWs = null;
  
  public FontProcessorWsProxy() {
    _initFontProcessorWsProxy();
  }
  
  public FontProcessorWsProxy(String endpoint) {
    _endpoint = endpoint;
    _initFontProcessorWsProxy();
  }
  
  private void _initFontProcessorWsProxy() {
    try {
      fontProcessorWs = (new com.sinosoft.pdl.api.ws.impl.FontProcessorWsImplServiceLocator()).getFontProcessorWsImplPort();
      if (fontProcessorWs != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)fontProcessorWs)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)fontProcessorWs)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {
    	serviceException.printStackTrace();
    	System.out.println("- FontProcessorWsProxy ServiceException : ");
    }
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (fontProcessorWs != null)
      ((javax.xml.rpc.Stub)fontProcessorWs)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sinosoft.pdl.api.ws.FontProcessorWs getFontProcessorWs() {
    if (fontProcessorWs == null)
      _initFontProcessorWsProxy();
    return fontProcessorWs;
  }
  
  public java.lang.String getResult(java.lang.String arg0) throws java.rmi.RemoteException{
    if (fontProcessorWs == null)
      _initFontProcessorWsProxy();
    return fontProcessorWs.getResult(arg0);
  }
  
}