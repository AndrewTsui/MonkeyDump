package com.bcu.xzq;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesContent {
		
	private PropertiesContent() {
		
	}
	
	public static Properties getPropertiesContent(PropertiePath propertiePath) throws IOException {
						
		InputStream inputStream = new BufferedInputStream(new FileInputStream(propertiePath.getPropertiePath()));
		Properties properties = new Properties();
		properties.load(inputStream);
		// properties中包含了system.properties的配置信息
		return properties;
	}
}
