/**
 * 
 */
package com.sinosoft.platform.core.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 公共函数类，来源与SINOSOFT核心
 * @author Darker.Wang
 * @date 2016-5-23 下午5:54:49
 * 
 */
public class PubFun {

	/**
	 * 获取当前系统时间戳 hh24:mi:ss
	 * @return Time
	 * @author Darker.Wang
	 */
	public static String getCurrentTime() {
		String pattern = "HH:mm:ss";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(new Date());
	}

	/**
	 * 获取系统当前时间戳 yyyy-mm-dd hh24:mi:ss.fff
	 * 
	 * @return
	 */
	public static String getCurrentTimestamp1() {
		return new Timestamp(System.currentTimeMillis()).toString();
	}
	
	/**
	 * 获取系统当前时间戳 yyyy-mm-dd hh24:mi:ss.fff
	 * 
	 * @return
	 */
	public static Date getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}


	/**
	 * 得到当前系统日期,日期格式为"yyyy-MM-dd HH:mm:ss"
	 * 
	 * @return String
	 * @author Darker.Wang
	 */
	public static String DateToString(Date date) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}
	
	
	/**
	 * 得到当前系统日期,日期格式为"yyyy-MM-dd"
	 * 
	 * @return String
	 * @author Darker.Wang
	 */
	public static String getCurrentDate() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(new Date());
	}

	/**
	 * 通过身份证号号获取生日日期
	 * 
	 * @param IdNo
	 *            String
	 * @return String
	 */
	public static String getBirthdayFromId(String IdNo) {
		String tIdNo = StringTool.cTrim(IdNo);
		String birthday = "";
		if (tIdNo.length() != 15 && tIdNo.length() != 18) {
			return "";
		}
		if (tIdNo.length() == 18) {
			birthday = tIdNo.substring(6, 14);
			birthday = birthday.substring(0, 4) + "-"
					+ birthday.substring(4, 6) + "-" + birthday.substring(6);
		}
		if (tIdNo.length() == 15) {
			birthday = tIdNo.substring(6, 12);
			birthday = birthday.substring(0, 2) + "-"
					+ birthday.substring(2, 4) + "-" + birthday.substring(4);
			birthday = "19" + birthday;
		}
		return birthday;

	}

	/**
	 * 这个方法可以通过与某个类的class文件的相对路径来获取文件或目录的绝对路径。 通常在程序中很难定位某个相对路径，特别是在B/S应用中。
	 * 通过这个方法，我们可以根据我们程序自身的类文件的位置来定位某个相对路径。
	 * 比如：某个txt文件相对于程序的Test类文件的路径是../../resource/test.txt，
	 * 那么使用本方法Path.getFullPathRelateClass("../../resource/test.txt",Test.class)
	 * 得到的结果是txt文件的在系统中的绝对路径。
	 * @param relatedPath 相对路径
	 * @param cls 用来定位的类
	 * @return 相对路径所对应的绝对路径
	 * @throws IOException 因为本方法将查询文件系统，所以可能抛出IO异常
	 */
	public static String getFullPathRelateClass(String relatedPath, Class<?> cls)
			throws IOException {
		String path = null;
		if (relatedPath == null) {
			throw new NullPointerException();
		}
		String clsPath = getPathFromClass(cls);
		File clsFile = new File(clsPath);
		String tempPath = clsFile.getParent() + File.separator + relatedPath;
		File file = new File(tempPath);
		path = file.getCanonicalPath();
		return path;
	}

	/**
	 * 获取一个类的class文件所在的绝对路径。 这个类可以是JDK自身的类，也可以是用户自定义的类，或者是第三方开发包里的类。
	 * 只要是在本程序中可以被加载的类，都可以定位到它的class文件的绝对路径。
	 * @param cls 一个对象的Class属性
	 * @return 这个类的class文件位置的绝对路径。 如果没有这个类的定义，则返回null。
	 */
	public static String getPathFromClass(Class<?> cls) throws IOException {
		String path = null;
		if (cls == null) {
			throw new NullPointerException();
		}
		URL url = getClassLocationURL(cls);
		if (url != null) {
			path = url.getPath();
			if ("jar".equalsIgnoreCase(url.getProtocol())) {
				try {
					path = new URL(path).getPath();
				} catch (MalformedURLException e) {
				}
				int location = path.indexOf("!/");
				if (location != -1) {
					path = path.substring(0, location);
				}
			}
			File file = new File(path);
			path = file.getCanonicalPath();
		}
		return path;
	}

	/**
	 * 获取类的class文件位置的URL。这个方法是本类最基础的方法，供其它方法调用。
	 */
	private static URL getClassLocationURL(final Class<?> cls) {
		if (cls == null)
			throw new IllegalArgumentException("null input: cls");
		URL result = null;
		final String clsAsResource = cls.getName().replace('.', '/')
				.concat(".class");
		final ProtectionDomain pd = cls.getProtectionDomain();
		if (pd != null) {
			final CodeSource cs = pd.getCodeSource();
			if (cs != null)
				result = cs.getLocation();

			if (result != null) {
				if ("file".equals(result.getProtocol())) {
					try {
						if (result.toExternalForm().endsWith(".jar")
								|| result.toExternalForm().endsWith(".zip"))
							result = new URL("jar:"
									.concat(result.toExternalForm())
									.concat("!/").concat(clsAsResource));
						else if (new File(result.getFile()).isDirectory())
							result = new URL(result, clsAsResource);
					} catch (MalformedURLException ignore) {
					}
				}
			}
		}

		if (result == null) {
			final ClassLoader clsLoader = cls.getClassLoader();
			result = clsLoader != null ? clsLoader.getResource(clsAsResource)
					: ClassLoader.getSystemResource(clsAsResource);
		}
		return result;
	}

	/**
	 * 判断是否是数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern
				.compile("([\\+\\-])?([0-9])+(.[0-9])?([0-9])*");
		Matcher isNum = pattern.matcher(str);

		if (!isNum.matches()) {
			return false;
		}

		return true;
	}

	public static String getClassFileName(Object o) {
		String fileName = o.getClass().getName();
		fileName = fileName.substring(fileName.lastIndexOf(".") + 1);
		return fileName;
	}
	
	/**
     * 转换JavaScript解析不了的特殊字符
     * @param s String
     * @return String
     */
    public static String changForHTML(String s){
        char[] arr = s.toCharArray();
        s = "";

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == '"' || arr[i] == '\'')
            {
                s += "\\";
            }

            if (arr[i] == '\n')
            {
                s += "<br>";
                continue;
            }

            s += arr[i];
        }

        return s;
    }
    /**
     * 对数字前补0
     * @param src 需要前部零的数字字符串
     * @param length > 0
     * @return
     */
    public static String getNumber(String src,int length){
    	if(src == null){
    		return null;
    	}
    	if(src.length() >= length){
    		return src;
    	}
    	StringBuffer sb = new StringBuffer(src);
    	for(int i = src.length();i<length;i++){
    		sb.insert(0, "0");
    	}
    	return sb.toString();
    }
    public static void main(String[] args){
    	System.out.println(getNumber("123",2));
    }
}
