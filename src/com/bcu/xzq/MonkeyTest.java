package com.bcu.xzq;

import java.io.IOException;

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

	public static synchronized void monkeyTest() throws IOException {
		// TODO Auto-generated method stub
		try {
			Process pr = Runtime.getRuntime().exec(cmd);
			pr.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
