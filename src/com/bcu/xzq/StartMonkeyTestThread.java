package com.bcu.xzq;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class StartMonkeyTestThread implements StartThreadImp{

	Properties properties;
	String monkeyShellPath;	//monkey_test
	String throttle;	//monkey��������¼�֮���ʱ����
	String appString;	//����App����
	String testNumber;	//monkeyÿ�β�������¼��ĸ���
	String logPath;	//monkey��־���λ��
	String bashPathString;	//bash������λ��
	
	public StartMonkeyTestThread(Properties properties) {
		// TODO Auto-generated constructor stub
		this.properties = properties;
		this.monkeyShellPath = properties.getProperty("monkeyShellPath");
		this.throttle = properties.getProperty("throttle");
		this.appString = properties.getProperty("appString");
		this.testNumber = properties.getProperty("testNumber");
		this.logPath = properties.getProperty("logPath");
		this.bashPathString = properties.getProperty("bashPathString");
	}
	
	@Override
	public void run(CountDownLatch countDownLatch, int times) {
		// TODO Auto-generated method stub
		String monkeyShellString = "bash "+monkeyShellPath+" "+throttle+" "+appString+" "+testNumber+" "+logPath;	//����monkey_test.sh�ű�������
		String[] monkeyCmdStrings = new String[] {bashPathString,"-c",monkeyShellString};
		MonkeyTest.setMonkeyParaments(monkeyShellString, monkeyCmdStrings);
		MonkeyTestThread monkeyTestThread = new MonkeyTestThread(countDownLatch, times);
		monkeyTestThread.start();
	}

	@Override
	public void run(CountDownLatch countDownLatch) {
		// TODO Auto-generated method stub
		
	}

}
