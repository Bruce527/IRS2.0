/**
 * 
 */
package com.sinosoft.eos.adapte.submit;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;

import com.sinosoft.eos.adapte.SubmitAdapter;
import com.sinosoft.eos.exception.EOSException;
import com.sinosoft.eos.model.SubmitModel;
import com.sinosoft.pdl.api.ws.FontProcessorWsProxy;
import com.sinosoft.platform.core.util.CError;

/**
 * 
 * HTTP 报送协议实现<br>
 * 1、submitAsWSDLService 以字符串方式交互<br>
 * 2、submitAsStream 以字节流方式交互<br>
 * @author Darker.Wang
 * @date 2016-7-4 下午5:55:23 
 */
public class HttpSubmitAdapter extends SubmitAdapter {

	private Logger logger = Logger.getLogger(HttpSubmitAdapter.class);
	private HttpURLConnection g_URLConnection = null;
	private int buff = 4096;
	private int readTimeOut = 6000;
	private int connectTimeOut = 36000;
	public String reqUrl = null;
	
	/**
	 * @param sm
	 */
	public HttpSubmitAdapter() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sinosoft.eos.adapte.submit.SubmitAaptor#submit(com.sinosoft.eos.model
	 * .SubmitModel)
	 */
	@Override
	public boolean submit(SubmitModel model) throws EOSException {
		String message = "交互成功";
		boolean srResult = true;
		try {
			reqUrl = model.getReqModel().getReqUrl();//INT: http://10.192.32.134//circauto/servlet/insurance/interface?wsdl
			encoding = model.getEncoding();//INT:  UTF-8
			logger.info("- HttpSubmitAdapter SUBMIT_TYPE : "+model.getSubmitType()+" ENCODING : "+encoding);
			//北京健康险，北京意外险 DTO 提交
			if(model.getSubmitType().equals(SubmitModel.SUBMIT_TYPE_DTO)){
				rtv = submitAsDTO(model);
			}else{
				//非DTO 提交
				Object obj = model.getSubmitData();
				Class<?> clazz = model.getSubmitClass();
				logger.info("- submit data class : " + clazz);
				logger.info("- model.getSubmitType() : " + model.getSubmitType());
				obj = clazz.cast(obj);
				//保单登记 WSDL 服务客户端提交
				if(model.getSubmitType().equals(SubmitModel.SUBMIT_TYPE_WSDL)){
					if(model.getSubmitClientObj() != null){
						//暂不支持
						message = "暂不支持指定客户端报送，请走其他报送渠道";
						CError cError = new CError();
						cError.errorMessage = message;
						cError.moduleName = "HttpSubmitAdapter";
						cError.functionName = "submit";
						cErrors.addOneError(cError);
						System.out.println("1111: "+message);
						return false;
					}else{
						logger.info("- submitAsWSDL : doing... ");
						rtv = submitAsWSDL(obj.toString());
					}
				}
				//上海人身险 HTTP SERVLET 字符串提交
				else if(model.getSubmitType().equals(SubmitModel.SUBMIT_TYPE_STRING)){
					rtv = submitAsString(obj.toString());
				}
				//江苏中介平台 HTTP SERVLET 字节流提交
				else if(model.getSubmitType().equals(SubmitModel.SUBMIT_TYPE_STREAM)){
					rtv = submitAsStream((InputStream) obj);
				}else{
					message = "不支持的提交类型："+model.getSubmitType();
					CError cError = new CError();
					cError.errorMessage = message;
					cError.moduleName = "HttpSubmitAdapter";
					cError.functionName = "submit";
					cErrors.addOneError(cError);
					System.out.println("2222: "+message);
					return false;
				}
			}
			if(rtv == null){
				message = "交互失败，返回数据为空。";
				CError cError = new CError();
				cError.errorMessage = message;
				cError.moduleName = "HttpSubmitAdapter";
				cError.functionName = "submit";
				cErrors.addOneError(cError);
				System.out.println("3333: "+message);
				return false;
			}
			// 返回数据造型
			if (model.getReturnClass() != null) {
				rtv = model.getReturnClass().cast(rtv);
			}
		}finally{
			//构造返回信息
			sr.setMessage(message);
			sr.setResult(srResult);
			sr.setReturnObj(rtv);
			sr.setReturnObjClass(model.getReturnClass());
		}
		return true;
	}

	/**
	 * 通过访问WSDL服务器发送
	 * 
	 * @param requestXML
	 * @return
	 */
	public String submitAsWSDLService(String requestXML) throws EOSException {
		String endpoint = reqUrl;
		String result = null;
		try {
			logger.info("Endpoint address: " + endpoint);
			System.out.println("Request XML: \n" + requestXML);
			FontProcessorWsProxy proxy = new FontProcessorWsProxy(endpoint);
			result = proxy.getResult(requestXML);
			logger.info("Request succsed!");
			System.out.println("Response XML：\n" + result);
		} catch (Exception e) {
			e.printStackTrace();
			EOSException ee = new EOSException();
			ee.setFunction("submitAsWSDLService");
			ee.setException(e);
			ee.setStackTrace(e.getStackTrace());
			ee.setMessage("WSDL endpoind exception : " + e.getMessage());
			throw ee;
		}
		return result;
	}
	/**
	 * 指定FontProcessorWsProxy 提交
	 * @param fpwsp
	 * @param reqXML
	 * @return
	 */
	public String submitAsWSDL(String reqXML){
		try {
			logger.info("Endpoint address: " + reqUrl);
			System.out.println("Request XML: \n" + reqXML);
//			FontProcessorWsProxy fpwsp1 = new FontProcessorWsProxy(reqUrl);
//			String result = fpwsp1.getResult(reqXML);
			String result = submitAsWSDLService(reqXML);
			logger.info("Request succsed!");
			System.out.println("Response XML：\n" + result);
			return result;
		}catch (EOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	/**
	 * DTO 方式提交
	 * @param model
	 * @return
	 */
	public Object submitAsDTO(SubmitModel model){
		DTOSubmitAdapter submit = new DTOSubmitAdapter();
		submit.submit(model);
		sr = submit.getSubmitReturn();
		return submit.getReturn();
	}
	/**
	 * 字符串访问
	 * @param reqXML
	 * @return
	 * @throws EOSException 
	 */
	public String submitAsString(String reqXML) throws EOSException{
		InputStream in = new ByteArrayInputStream(reqXML.getBytes());
		String rtvStr = this.submitAsStream(in);
		if(rtvStr == null){
			return null;
		}
		return rtvStr;
	}
	/**
	 * 一般字节流发送
	 * 
	 * @param inputXML
	 * @return
	 * @throws EOSException
	 */
	public String submitAsStream(InputStream inputXML) throws EOSException {
		OutputStream v_OutputStream = null;
		InputStream v_return = null;
		URL url = null;
		try {
			url = new URL(reqUrl);
			g_URLConnection = (HttpURLConnection) url.openConnection();
			g_URLConnection.setUseCaches(false);//设置缓存
			g_URLConnection.setDoOutput(true);// 设置流提交为true
			g_URLConnection.setDoInput(true);//设置返回流为true
			g_URLConnection.setRequestMethod("POST");//设置请求方式
			g_URLConnection.setReadTimeout(readTimeOut);//设置超时
			g_URLConnection.setConnectTimeout(connectTimeOut);//设置连接时效
			g_URLConnection.setRequestProperty("Content-Type","application/xwww-form-urlencoded");//设置请求类型
			g_URLConnection.setRequestProperty("Charset",encoding);//设置字符集
			g_URLConnection.connect();//进行连接
			
			v_OutputStream = g_URLConnection.getOutputStream();

			// 将存储报文的数据流流写入输出流
			byte[] bt = new byte[buff];
			int btlen = -1;
			while ((btlen = inputXML.read(bt)) > -1) {
				v_OutputStream.write(bt, 0, btlen);
			}
			logger.info("send to servlet: " + reqUrl);
			logger.info("__________________________________");
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error(" Request Exception ：" + e.getMessage());
			EOSException ee = new EOSException();
			ee.setException(e);
			ee.setFunction("submitAsStream");
			ee.setStackTrace(e.getStackTrace());
			ee.setMessage("Stream endpoind exception : " + e.getMessage());
			throw ee;
		} finally {
			try {
				if (v_OutputStream != null) {
					v_OutputStream.flush();
					v_OutputStream.close();
				}

				// 调用HttpURLConnection连接对象的getInputStream()函数,
				// 将内存缓冲区中封装好的完整的HTTP请求电文发送到服务端。
				// 返回服务器相应的输入流，并更改标志位
				
				v_return = g_URLConnection.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(v_return,encoding));
				String line = null;
				StringBuffer sb = new StringBuffer();
				while(null != (line = reader.readLine())){
					sb.append(line);
				}
				if(reader != null){
					reader.close();
					reader = null;
				}
//				ByteArrayOutputStream baos = new ByteArrayOutputStream();
//				int len = -1;
//				while ((len = v_return.read(bReturn)) > -1) {
//					baos.write(bReturn, 0, len);
//				}
//
//				ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
//
//				if (g_URLConnection != null) {
//					g_URLConnection.disconnect();
//				}
				return sb.toString();
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("Resepted Servlet back info fail : " + e);
			}finally{
				if (g_URLConnection != null) {
					g_URLConnection.disconnect();
					g_URLConnection = null;
				}
			}
		}
		logger.info("Resepted Servlet back info : null");
		return null;
	}
	
	public static void main(String[] args) {
		//测试报文发送
		String reqXml="<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n" + 
				"<PACKET type=\"REQUEST\" version=\"1.0\"><HEAD><USER>metlife_test</USER><PASSWORD>minniee1</PASSWORD><REQUEST_TYPE>C01</REQUEST_TYPE></HEAD><BODY><CLAIM_INFO/></BODY></PACKET>";//测试请求报文
		HttpSubmitAdapter   httpSubmitAdapter=new HttpSubmitAdapter();
		httpSubmitAdapter.reqUrl="http://10.192.32.134//circauto/servlet/insurance/interface?wsdl"; //测试数据请求地址
		httpSubmitAdapter.encoding="GBK";
		try {
		String responseXml=	httpSubmitAdapter.submitAsString(reqXml);
		System.out.println("@@@@@@@请求报文："+reqXml);
		System.out.println("@@@@@@@请求报文："+responseXml);
		} catch (EOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
