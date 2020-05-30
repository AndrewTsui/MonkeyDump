package com.bcu.xzq;

import java.io.IOException;
import java.util.LinkedList;

public class GetAllAndroidXMLFileMD5HashCode {
	
	String xmlFilepath;
	
	public GetAllAndroidXMLFileMD5HashCode(String xmlFilepath) {
		// TODO Auto-generated constructor stub
		this.xmlFilepath = xmlFilepath;
	}
	
	public void getAllAndroidXMLFileMD5HashCode() throws IOException {
		
		LinkedList<String> fileNameList = new LinkedList<String>();				
		
		GetAllFileName.getAllFileName(xmlFilepath, fileNameList);
		
		for (int i = 0; i < fileNameList.size(); i++) {
			
			String filePath = xmlFilepath+"/"+fileNameList.get(i);
			
			if (fileNameList.get(i).contains("xml")) {	//判断是否是xml文件
				
				String md5Hashcode32 = GetMD5HashCode.md5HashCode32(filePath);  
		           
				System.out.println(fileNameList.get(i)+ " 32bit MD5: "+md5Hashcode32); 
			}
			
			
		}
	}
}
