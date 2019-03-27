/**
 * 
 */
package com.sinosoft.platform.core.util;

import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import com.sinosoft.platform.core.exception.CoreException;

import config.Config;

/**
 * UDP协议客户端：
 * @author Darker.Wang
 * @date 2016-10-8 下午5:24:46
 * @company SINOSOFT
 */
public class UDPClient {
	/**
	 * UDP 状态 1-成功 
	 */
	public static final int UDP_STATUS_SUCCESS = 1;
	/**
	 * UDP 状态 0-失败
	 */
	public static final int UDP_STATUS_FAILS = 0;
	/**
	 * UDP 状态 -1-异常
	 */
	public static final int UDP_STATUS_EXCEPTION = -1;
	//用于文件指定路径时 默认/root/temp/
	private String basePath = "/app/icp/";
	private String remoteHost = "localhost";  
    private int remotePort = 8080; 
    private DatagramSocket datagramSocket;  
    
	public String getBasePath() {
		if(!basePath.endsWith("/")){
			basePath += "/";
		}
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	/**
	 * @throws SocketException 
	 * 
	 */
	public UDPClient(String remoteHost,int remotePort) throws CoreException{
		this.remoteHost = remoteHost;
		this.remotePort = remotePort;
		try{
			datagramSocket = new DatagramSocket(remotePort);
			System.out.println("- UDPClient success : "+toString());
		}catch(SocketException e){
			CoreException coreException = new CoreException();
			coreException.setMessage("SocketException");
			coreException.setException(e);
			throw coreException;
		}
		
	}
	
	@Override
	public String toString() {
		return "UDPClient [remoteHost=" + remoteHost + ", remotePort="
				+ remotePort + ", datagramSocket=" + datagramSocket + "]";
	}

	/**
	 * UDP 协议报送：1-发送成功 0-发送失败
	 * @param xml
	 * @return [1-发送成功  0-发送失败]
	 */
	public int sendMsg(String xml){
		int result = UDP_STATUS_SUCCESS;
		try{
			_send(xml);
		}catch(CoreException e){
			result = UDP_STATUS_FAILS;
		}
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String from = "ICP";
		String to = "F-MAC";
		String mode = "ICP_LIVE";
		String ip = Config.getProperties("amc.service").getProperty("UR_LIVE_OCCUREDIP");
		String xml = "<?xml version=\"1.0\" encoding=\"GBK\"?><APPROOT type=\"BAMC_USABILITY_REPORT\" ver=\"2.0\" from =\""+from+"\" to=\""+to+"\" mode=\"say\">" +
				"<PUBLIC><APPSNAME>ICP</APPSNAME><TYPE>02</TYPE><IP>"+ip+"</IP></PUBLIC><PRIVATE><ROWSET><ROW><OCCUREDAPPSNAME>"+from+"</OCCUREDAPPSNAME><OCCUREDIP>"+ip+"</OCCUREDIP><MODULECODE>"+mode+"</MODULECODE><SUBMODULECODE></SUBMODULECODE><STATUS>0</STATUS><MSG>心跳正常</MSG></ROW></ROWSET></PRIVATE></APPROOT>";
		
		try {
			String remoteHost = Config.getProperties("amc.service").getProperty("AMC_REMOTE_HOST");
			int remotePort = Integer.parseInt(Config.getProperties("amc.service").getProperty("AMC_REMOTE_PORT"));
			UDPClient client = new UDPClient(remoteHost,remotePort);
			client.sendMsg(xml);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 客户端发送：受保护的方法，不可重写
	 * @param msg 发送具体信息
	 * @throws CoreException
	 */
    protected void _send(String msg) throws CoreException{
    	System.out.println("- UDP SEND [remoteHost: "+remoteHost+" ,remotePort: "+remotePort+"]  START ");
        try { 
        	//实例化套接字，并指定发送端口
            InetAddress address = InetAddress.getByName(remoteHost);
            msg = msg.trim();
            String filePath = getBasePath()+getMidPath(2);
            
            //不存在，创建文件路劲则创建
            File fd = new File(filePath);
            if(!fd.exists()){
            	fd.mkdirs();
            	fd = null;
            }
            
            String fileName = filePath+DateUtils.getCurrentDateSerial()+"_hearBeat.xml.txt";
            System.out.println("- UDP SEND MSG : "+msg);
           
            //先发送再落地报文  
            byte [] buffer = msg.getBytes();
            //指定数据目的地的地址，以及目标端口
            DatagramPacket packet = new DatagramPacket(buffer,buffer.length, address, remotePort);  
            datagramSocket.send(packet);
           /* 
            * //接收数据报  
            DatagramPacket inputPacket = new DatagramPacket(new byte[512], 512);  
            datagramSocket.receive(inputPacket);  
            System.out.println(new String(inputPacket.getData(), 0 , inputPacket.getLength()));
            */
            System.out.println("- UDP SAVE MSG : doing ...");
            System.out.println("- UDP MSG PATH : "+fileName);
            XMLLogUtil.saveLocal(fileName, msg,true);
            
        } catch (Exception e) {  
            e.printStackTrace();
            CoreException coreException = new CoreException();
            coreException.setMessage("UDP协议发送数据异常");
            coreException.setException(e);
            throw coreException;
        } finally{
        	System.out.println("- UDP SEND [remoteHost: "+remoteHost+" ,remotePort: "+remotePort+"]  OVER ");
            datagramSocket.close();  
        }
    }
    /**
     * 获取中间path，根据日期来
     * @param type 1-到年 2-到月 3-到日
     * @return
     */
    private String getMidPath(int type){
    	String rtvStr = "";
    	String[] days = DateUtils.getCurrentDate().split("-",-1);
    	switch(type){
    	case 1 :
    		rtvStr = rtvStr+days[0]+"/";
    		break;
    	case 2 :
    		rtvStr = rtvStr+days[0]+"/"+days[1]+"/";
    		break;
    	case 3 :
    		rtvStr = rtvStr+days[0]+"/"+days[1]+"/"+days[2]+"/";
    		break;
    	default :
    		rtvStr = rtvStr+days[0]+"/"+days[1]+"/"+days[2]+"/";
    	}
    	return rtvStr;
    }
}
