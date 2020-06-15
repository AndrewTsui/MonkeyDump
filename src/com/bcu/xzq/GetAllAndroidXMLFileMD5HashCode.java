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
		LinkedList<String> xmlMD5List = new LinkedList<String>();
		String lastState = null;	//上一条状态的MD5
		String currentState = null;	//此条状态的MD5
		int StatesDirvetedCondition = 0;	//状态转换条件数
		
		GetAllFileName.getAllFileName(xmlFilepath, fileNameList);
		
		for (int i = 0; i < fileNameList.size(); i++) {
			
			String filePath = xmlFilepath+"/"+fileNameList.get(i);
			
			if (fileNameList.get(i).contains("xml")) {	//判断是否是xml文件
				
				//String md5Hashcode32 = GetMD5HashCode.md5HashCode32(filePath); 
				String md5Hashcode32 = GetMD5Value.getMD5Value(filePath);
				
				if(!xmlMD5List.contains(md5Hashcode32)) {
					xmlMD5List.add(md5Hashcode32);
				}
				
		        currentState = md5Hashcode32;
		        
		        if(lastState != null && !lastState.equals(currentState)) {
		        	StatesDirvetedCondition++;
		        	lastState = currentState;
		        	//currentState = null;
		        }
				//System.out.println(fileNameList.get(i)+ " 32bit MD5: "+md5Hashcode32); 
			}
		}
		System.out.println("Totally has "+xmlMD5List.size()+" different states");
		System.out.println("Count all of conditions which could dirvet state: "+StatesDirvetedCondition);
//		GetActivitiesStatistics getActivitiesStatistics = new GetActivitiesStatistics();
//		getActivitiesStatistics.getStatisticsConsequence();
//		CountActivities.countActivities();
	}
}
