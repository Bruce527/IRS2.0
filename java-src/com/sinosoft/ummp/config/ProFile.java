package com.sinosoft.ummp.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 配置文件索引类
 * @author Darker.Wang
 * @date 2016-7-26 下午8:19:03
 * @company SINOSOFT
 */
public class ProFile {

	Properties properties;
	private static ProFile proFile = null;
	private static final String BasePath = ProFile.class.getResource("").getPath();
	private ProFile(){}
	public static ProFile getInstance(){
		if(proFile == null){
			proFile = new ProFile();
		}
		return proFile;
	}
	
	public Properties getProFile(String fileName) throws FileNotFoundException, IOException{
		InputStream proIn;
		if(fileName.endsWith(".properties")){
			proIn = new FileInputStream(new File(BasePath+fileName));	
		}else{
			proIn = new FileInputStream(new File(BasePath+fileName+".properties"));
		}
		properties = new Properties();
		properties.load(proIn);
		return properties;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		System.out.println(ProFile.getInstance().getProFile("service"));
	}
}
