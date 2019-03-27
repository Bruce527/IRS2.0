/**
 * 
 */
package config;

import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.icbc.ssic.base.PKIException;
import com.icbc.ssic.base.SSICService;

/**
 * 用于定位Config配置文件
 * @author Darker.Wang
 * @date 2016-8-11 下午4:57:21
 * @company SINOSOFT
 */
public class Config {
	/**系统默认字符集 UTF-8**/
	public static String ENCODING = "UTF-8";
	/**字符集GBK**/
	public static String ENCODING_GBK = "GBK";
	/**字符集 ISO-8895-1**/
	public static String ENCODING_ISO = "ISO-8859-1";
	public static String CONFIG_PATH = Config.class.getResource("").getPath();
	private static PublicKey publicKey ;
	private static PrivateKey privateKey ;
	/**
	 * 系统默认统一字符集出处：获取字符集【若在service.properties 中配置ENCODING=XX，则取配置，否则取系统默认】
	 * @return
	 */
	public static String getEncoding(){
		String encoding = getProperties().getProperty("ENCODING");
		if(encoding == null || "".equals(encoding)){
			encoding = ENCODING;
		}
		return encoding;
	}
	
	private static Properties proper = null;
	/**系统默认配置文件**/
	private static String properName = "DEFAULT";
	public static Properties getProperties(){
		if(proper == null){
			try {
				proper = new Properties();
				proper.load(new InputStreamReader(Config.class.getResourceAsStream("system.properties"),getEncoding()));
				properName = "DEFAULT";
				System.out.println("Config.getProperties load properties "+properName+" success");
				return proper;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Config.getProperties load properties "+properName+" fail ,please confirm it's exist!");
				return null;
			}
		}else{
			if(properName.equals("DEFAULT")){
				return proper;
			}else{
				proper = null;
				return getProperties();
			}
		}
	}
	/**
	 * 获取指定名称的配置文件
	 * @param propertiesName
	 * @return
	 */
	public static Properties getProperties(String propertiesName){
		if(!propertiesName.endsWith(".properties")){
			propertiesName = propertiesName+".properties";
		}
		String tproperName = propertiesName.substring(0,propertiesName.lastIndexOf("."));
		try {
			Properties tproper = new Properties();
			tproper.load(new InputStreamReader(Config.class.getResourceAsStream(propertiesName),getEncoding()));
			System.out.println("Config.getProperties load properties "+tproperName+" success");
			return tproper;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Config.getProperties load properties "+tproperName+" fail ,please confirm it's exist!");
			return null;
		}
	}
	/**
	 * 是否统一认证
	 * @return
	 */
	public static String getUniformAuth(){
		 return getProperties().getProperty("SSIC_UNIFORMAUTH");
	}
	/**
	 * 
	 */
	public static PublicKey getPublicKey() {
		// TODO Auto-generated constructor stub
		if(publicKey != null){
			return publicKey;
		}
		//统一认证标识
		String serverName = getProperties().getProperty("SSIC_SERVERSERVICE");
		SSICService server = new SSICService(serverName);
		String keyPath = CONFIG_PATH+"key/ICP/";
		System.out.println("keyPath : "+keyPath);
        try {
			server.initialize(keyPath);
			publicKey = server.getPublicKey();
			return  publicKey;
		} catch (PKIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static PrivateKey getPrivateKey(){
		if(privateKey != null){
			return privateKey;
		}
		//本地站点标识
		String serviceName = getProperties().getProperty("SITE_SERVERSERVICE");
		SSICService site = new SSICService(serviceName);
		String keyPass = getProperties().getProperty("SSIC_PRIVKEYPASSWD");
		String keyPath = CONFIG_PATH+"key/ICP/";
		System.out.println("keyPath : "+keyPath);
		try {
			site.initialize(keyPass,keyPath);
			privateKey = site.getPrivateKey();
			return privateKey;
		} catch (PKIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 获取应用IP
	 * @return
	 */
	public static String getAppsIP(){
		//先获取主应用IP 无则获取附应用IP
		String mIP = getProperties().getProperty("APPS_IP");
		return mIP;
	}
	/**
	 * 获取应用固定名称
	 * @return
	 */
	public static String getAppsName(){
		String mName = getProperties().getProperty("APPS_NAME");
		return mName;
	}
	/**
	 * 创建CodeMap
	 * @param string
	 * @return
	 */
	public static CodeMap createCodeMap(String xKey) {
		// TODO Auto-generated method stub
		return new CodeMap(xKey);
	}
	/**
	 * 支持两个"_" ,三段CODE，EG ABC_DE_EGH，ABC_DF_EGA 等
	 * @author Darker.Wang
	 * @date 2016-10-8 上午11:36:32
	 * @company SINOSOFT
	 */
	public static class CodeMap{
		String startWith;
		CodeMap(String startWith){
			this.startWith = startWith;
		}
		/**
		 * 形如： SF_XX_YY=02，根据前最 SF 获取其下的 XX，获取XX下单YY集合<br> 
		 * <p>
		 * UR_LIVE_STATUS=02<br>
		 * UR_LIVE_SS=02<br>
		 * UR_DAIE_STATUS=02<br>
		 * UR_DAIE_SS=02<br>
		 * <p>
		 * @return
		 */
		public Map<String,Map<String,String>> getCodeMap(Properties prop){
			Enumeration<Object> keys = prop.keys();
			Map<String,Map<String,String>> maps = new HashMap<String,Map<String,String>>();
			Map<String,String> tMap = new HashMap<String,String>();
			List<String> cecondLists = new ArrayList<String>();
			//构造第一层KEY
			while(keys.hasMoreElements()){
				String key = (String) keys.nextElement();
				if(key.startsWith(startWith)){
					String[] _keys = key.split("_", -1);
					//不包括，往里面添加
					if(!tMap.containsKey(_keys[1])){
						cecondLists.add(_keys[1]);
						tMap.put(_keys[1], _keys[1]);
					}
				}
			}
			//构造第二层KEY
			for(int i = 0; i < cecondLists.size(); i++){
				String secondKey = cecondLists.get(i);
				String tSecondKey = startWith+"_"+secondKey;//UR_LIVE_X
				Map<String,String> ttMap = new HashMap<String,String>();
				//keys 重新加载
				keys = prop.keys();
				while(keys.hasMoreElements()){
					String key = (String) keys.nextElement();
					if(key.startsWith(tSecondKey)){
						String[] _keys = key.split("_", -1);// 0 1 2 
						//取第三个字段作为key
						ttMap.put(_keys[2],prop.getProperty(key));
					}
				}
				maps.put(secondKey, ttMap);
			}
			return maps;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop = getProperties("amc.service");
		CodeMap codeMap = new  CodeMap("UR");
		Map<String,Map<String,String>> codes = codeMap.getCodeMap(prop);
		System.out.println(codes);
		Map<String,String> cm = codes.get("LIVE");
		System.out.println(cm);
	}

}
