package com.bcu.xzq;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author xzq
 *
 * This is a concrete strategy class
 *
 */

public class ConcreteStatisticsStrategy extends AbstractStatisticsStrategy{

	@Override
	public void countData() {
		// TODO Auto-generated method stub
		FileFactory activtieList = new GetActivityListFile();
		BufferedReader bufferedReader = (BufferedReader) activtieList.getFile();
		ArrayList<String> list=new ArrayList<>();
		String line=null;
		
		try {
			while(bufferedReader.readLine() != null && bufferedReader.readLine() != "\\s+") {
				line = bufferedReader.readLine();
				if(list.contains(line)==false && line != null) {
					list.add(line);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(list);
		AppendToFile appendToFile = new AppendOutcomeToFile();
		try {
			appendToFile.appendToFile(PropertiesContent.getPropertiesContent(new PropertiePath()), "There are "+list.size()+" different activities, and they are "+list+"\r\n");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("There are "+list.size()+" different activities, and they are "+list);
		
		try {
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
