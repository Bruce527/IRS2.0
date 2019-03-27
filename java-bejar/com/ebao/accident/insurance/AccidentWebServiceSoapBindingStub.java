/**
 * AccidentWebServiceSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebao.accident.insurance;

public class AccidentWebServiceSoapBindingStub extends org.apache.axis.client.Stub implements com.ebao.accident.insurance.AccidentWebServicePort {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[4];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("accPolicyInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyDTO"), com.ebao.accident.insurance.dto.AccidentPolicyDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyResultsDTO"));
        oper.setReturnClass(com.ebao.accident.insurance.dto.AccidentPolicyResultsDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "accPolicyInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("accGroupPolicyInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyDTO"), com.ebao.accident.insurance.dto.AccidentGroupPolicyDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyResultsDTO"));
        oper.setReturnClass(com.ebao.accident.insurance.dto.AccidentGroupPolicyResultsDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "accGroupPolicyInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("accEndorsementInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyLogDTO"), com.ebao.accident.insurance.dto.AccidentPolicyLogDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyResultsLogDTO"));
        oper.setReturnClass(com.ebao.accident.insurance.dto.AccidentPolicyResultsLogDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "accEndorsementInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("groupEndorsementInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyLogDTO"), com.ebao.accident.insurance.dto.AccidentGroupPolicyLogDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyResultsLogDTO"));
        oper.setReturnClass(com.ebao.accident.insurance.dto.AccidentGroupPolicyResultsLogDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "groupEndorsementInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

    }

    public AccidentWebServiceSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public AccidentWebServiceSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public AccidentWebServiceSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyBenefitDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyBenefitDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyBenefitLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyBenefitLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyCoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyCoverageDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyCoverageLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyCoverageLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyInsuredDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyInsuredDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyInsuredLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyInsuredLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyPersonphDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyPersonphDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyPersonphLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyPersonphLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyResultDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyResultDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyResultLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyResultLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyResultsDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyResultsDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyResultsLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyResultsLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyUpcoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyUpcoverageDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyUpcoverageLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyUpcoverageLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyBenefitDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyBenefitDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyBenefitLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyBenefitLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyCoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyCoverageDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyCoverageLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyCoverageLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyInsuredDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyInsuredDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyInsuredLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyInsuredLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyPersonphDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyPersonphDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyPersonphLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyPersonphLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyResultDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyResultDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyResultLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyResultLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyResultsDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyResultsDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyResultsLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyResultsLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyUpcoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyUpcoverageDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyUpcoverageLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyUpcoverageLogDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentGroupPolicyBenefitDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyBenefitDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyBenefitDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentGroupPolicyBenefitLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyBenefitLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyBenefitLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentGroupPolicyCoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyCoverageDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyCoverageDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentGroupPolicyCoverageLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyCoverageLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyCoverageLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentGroupPolicyInsuredDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyInsuredDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyInsuredDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentGroupPolicyInsuredLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyInsuredLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyInsuredLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentGroupPolicyPersonphDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyPersonphDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyPersonphDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentGroupPolicyPersonphLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyPersonphLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyPersonphLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentGroupPolicyResultDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyResultDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyResultDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentGroupPolicyResultLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyResultLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyResultLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentGroupPolicyUpcoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyUpcoverageDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyUpcoverageDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentGroupPolicyUpcoverageLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentGroupPolicyUpcoverageLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentGroupPolicyUpcoverageLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentPolicyBenefitDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyBenefitDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyBenefitDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentPolicyBenefitLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyBenefitLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyBenefitLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentPolicyCoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyCoverageDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyCoverageDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentPolicyCoverageLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyCoverageLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyCoverageLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentPolicyInsuredDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyInsuredDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyInsuredDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentPolicyInsuredLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyInsuredLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyInsuredLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentPolicyPersonphDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyPersonphDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyPersonphDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentPolicyPersonphLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyPersonphLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyPersonphLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentPolicyResultDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyResultDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyResultDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentPolicyResultLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyResultLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyResultLogDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentPolicyUpcoverageDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyUpcoverageDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyUpcoverageDTO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "ArrayOf_tns2_AccidentPolicyUpcoverageLogDTO");
            cachedSerQNames.add(qName);
            cls = com.ebao.accident.insurance.dto.AccidentPolicyUpcoverageLogDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dto.insurance.accident.ebao.com", "AccidentPolicyUpcoverageLogDTO");
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

    public com.ebao.accident.insurance.dto.AccidentPolicyResultsDTO accPolicyInfo(java.lang.String in0, java.lang.String in1, com.ebao.accident.insurance.dto.AccidentPolicyDTO in2) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "accPolicyInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1, in2});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.accident.insurance.dto.AccidentPolicyResultsDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.accident.insurance.dto.AccidentPolicyResultsDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.accident.insurance.dto.AccidentPolicyResultsDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.accident.insurance.dto.AccidentGroupPolicyResultsDTO accGroupPolicyInfo(java.lang.String in0, java.lang.String in1, com.ebao.accident.insurance.dto.AccidentGroupPolicyDTO in2) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "accGroupPolicyInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1, in2});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.accident.insurance.dto.AccidentGroupPolicyResultsDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.accident.insurance.dto.AccidentGroupPolicyResultsDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.accident.insurance.dto.AccidentGroupPolicyResultsDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.accident.insurance.dto.AccidentPolicyResultsLogDTO accEndorsementInfo(java.lang.String in0, java.lang.String in1, com.ebao.accident.insurance.dto.AccidentPolicyLogDTO in2) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "accEndorsementInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1, in2});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.accident.insurance.dto.AccidentPolicyResultsLogDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.accident.insurance.dto.AccidentPolicyResultsLogDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.accident.insurance.dto.AccidentPolicyResultsLogDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.ebao.accident.insurance.dto.AccidentGroupPolicyResultsLogDTO groupEndorsementInfo(java.lang.String in0, java.lang.String in1, com.ebao.accident.insurance.dto.AccidentGroupPolicyLogDTO in2) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://insurance.accident.ebao.com", "groupEndorsementInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1, in2});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.ebao.accident.insurance.dto.AccidentGroupPolicyResultsLogDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.ebao.accident.insurance.dto.AccidentGroupPolicyResultsLogDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.ebao.accident.insurance.dto.AccidentGroupPolicyResultsLogDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
