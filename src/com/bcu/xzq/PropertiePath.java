package com.bcu.xzq;

public class PropertiePath {	
	
	private String propertiesName = "system.properties";	//一般只会存在一个配置文件
	
	public PropertiePath() {
		// TODO Auto-generated constructor stub
	}

	public String getPropertiePath() {
		String propertiesPath = getClass().getClassLoader().getResource(propertiesName).getPath().replace("%20", " ");
		//getClass()是静态方法，因此getPropertiePath()不能设置成静态方法
		return propertiesPath;
	}
}
