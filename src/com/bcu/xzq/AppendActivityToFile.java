package com.bcu.xzq;

import java.io.File;
import java.io.FileWriter;
import java.util.Properties;

public class AppendActivityToFile implements AppendToFile {

	@Override
	public void appendToFile(Properties properties, String content) {
		// TODO Auto-generated method stub
		try {
			File file =new File(properties.getProperty("exploredActivityListPath"));
			 
	        if(!file.exists()){
	        	file.createNewFile();
	        }
	 
	        //使用true，即进行append file 
	 
	        FileWriter fileWritter = new FileWriter(file.getName(),true);
	 
	 
	        fileWritter.write(content);
	 
	        fileWritter.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
