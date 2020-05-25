package com.bcu.xzq;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author xzq
 * @version 1.0
 *
 * This is a singleton class
 * 
 * You can use PropertiesContent.getPropertiesContent() to get an object with
 * an Properties return value type which contains the path of system.properties
 * 
 */

public class PropertiesContent {
	
	private PropertiesContent() {
		
	}
	
	public static Properties getPropertiesContent() throws IOException {
				
		PropertiePath propertiePath = new PropertiePath();
		
		InputStream inputStream = new BufferedInputStream(new FileInputStream(propertiePath.getPropertiePath()));
		Properties properties = new Properties();
		properties.load(inputStream);
		
		return properties;
	}
}
