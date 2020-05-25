package com.bcu.xzq;

import java.io.IOException;

/**
 * 
 * @author xzq
 * @version 1.0
 * 
 * This is a singleton class
 * 
 * You can use DumpXML to dump application current xml 
 * 
 */

public class DumpXML {	//Singleton
	
	String shellString = "";
	static String[] cmd = new String[]{};

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
			pr.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
