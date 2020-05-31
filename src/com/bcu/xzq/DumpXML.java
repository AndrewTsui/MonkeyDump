package com.bcu.xzq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DumpXML {	//Singleton
	
	String shellString = "";
	
	static String[] cmd = new String[]{};

	static BufferedReader br = null;
	
	private DumpXML() {
		
	}
	
	public static void setUiautomatorParaments(String shellString, String[] cmd) {
		
		DumpXML dumpXML = new DumpXML();
		
		dumpXML.shellString = shellString;
		
		dumpXML.cmd = cmd;
	}

	public static synchronized void dumpXML() throws IOException {
		
		try {
		
			Process pr = Runtime.getRuntime().exec(cmd);
			
//			br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
//		
//			String line = null;
//		
//			StringBuilder sb = new StringBuilder();
//		
//			while ((line = br.readLine()) != null) {
//		
//				sb.append(line + "\n");
//		
//			}
//		
//			System.out.println("Current Focused Activity: "+sb.toString());
			
			pr.waitFor();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
