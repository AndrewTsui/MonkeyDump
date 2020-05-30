package com.bcu.xzq;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class StartMonkeyTestThread implements StartThreadImp{

	Properties properties;
	String monkeyShellPath;	//monkey_test
	String throttle;	//monkey两次随机事件之间的时间间隔
	String appString;	//测试App包名
	String testNumber;	//monkey每次测试随机事件的个数
	String logPath;	//monkey日志存放位置
	String bashPathString;	//bash解释器位置
	
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
		String monkeyShellString = "bash "+monkeyShellPath+" "+throttle+" "+appString+" "+testNumber+" "+logPath;	//运行monkey_test.sh脚本的命令
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
