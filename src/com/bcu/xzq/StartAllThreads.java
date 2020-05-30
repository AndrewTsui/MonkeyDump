package com.bcu.xzq;

import java.io.IOException;
import java.sql.Time;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class StartAllThreads {	// Singleton
	
	private StartAllThreads() {
		// TODO Auto-generated constructor stub
	}
	
	public static void startThreads(int times) throws IOException {
		
		Properties properties = PropertiesContent.getPropertiesContent(new PropertiePath());
		
		CountDownLatch countDownLatch = new CountDownLatch(times*2);
		
		StartThreadImp startMonkeyTestThread = new StartMonkeyTestThread(properties);
		startMonkeyTestThread.run(countDownLatch, times);
		
		StartThreadImp startDumpXMLThread = new StartDumpXMLThread(properties);
		startDumpXMLThread.run(countDownLatch, times);
		
		StartThreadImp startInvertMD5Thread = new StartInvertMD5Thread();
		startInvertMD5Thread.run(countDownLatch);
	}
}
