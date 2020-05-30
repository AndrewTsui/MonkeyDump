package com.bcu.xzq;

import java.io.IOException;
import java.util.Properties;

public class InvertMD5 {	//Singleton
	
	private InvertMD5() {
		// TODO Auto-generated constructor stub
	}
	
	public static void invertMD5() throws IOException {
		Properties properties = PropertiesContent.getPropertiesContent(new PropertiePath());
		String xmlFilepath = properties.getProperty("xmlFilepath");
		GetAllAndroidXMLFileMD5HashCode getAllAndroidXMLFileMD5HashCode = new GetAllAndroidXMLFileMD5HashCode(xmlFilepath);
		getAllAndroidXMLFileMD5HashCode.getAllAndroidXMLFileMD5HashCode();
	}
}
