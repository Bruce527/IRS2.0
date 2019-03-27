package com.sinosoft.spoon.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SpoonConfig {

	Properties properties;
	private static SpoonConfig proFile = null;
	private static final String BasePath = SpoonConfig.class.getResource("").getPath();
	private SpoonConfig(){}
	public static SpoonConfig getInstance(){
		if(proFile == null){
			proFile = new SpoonConfig();
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

}
