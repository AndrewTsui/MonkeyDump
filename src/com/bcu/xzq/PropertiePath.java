package com.bcu.xzq;

public class PropertiePath {	
	
	private String propertiesName = "system.properties";	//һ��ֻ�����һ�������ļ�
	
	public PropertiePath() {
		// TODO Auto-generated constructor stub
	}

	public String getPropertiePath() {
		String propertiesPath = getClass().getClassLoader().getResource(propertiesName).getPath().replace("%20", " ");
		//getClass()�Ǿ�̬���������getPropertiePath()�������óɾ�̬����
		return propertiesPath;
	}
}
