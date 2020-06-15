package com.bcu.xzq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonkeyTest {

	private String shellString = "";
	private static String[] cmd = new String[] {};
	
	private MonkeyTest() {
		
	}

	public static void setMonkeyParaments(String shellString, String[] cmd) {
		MonkeyTest monkeyTest = new MonkeyTest();
		monkeyTest.shellString = shellString;
		monkeyTest.cmd = cmd;
	}

	public static synchronized String monkeyTest() throws IOException {
		// TODO Auto-generated method stub
		String returnValue = null;
		try {
			Process pr = Runtime.getRuntime().exec(cmd);
			
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            //StringBuffer strBuf = new StringBuffer();
			returnValue = stdInput.readLine();

			pr.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

}
