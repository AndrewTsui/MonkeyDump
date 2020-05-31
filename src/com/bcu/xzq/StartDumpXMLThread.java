package com.bcu.xzq;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class StartDumpXMLThread implements StartThreadImp {

	Properties properties;
	String dumpShellPath;	//dump_XML存放的位置
	String uiautomatorPythonPath;	//uiautomator脚本的位置
	String bashPathString;	//bash解释器位置
	String exploredActivityListPath;	//explored_activity_list.txt位置
	
	public StartDumpXMLThread(Properties properties) {
		// TODO Auto-generated constructor stub
		this.properties = properties;
		this.dumpShellPath = properties.getProperty("dumpShellPath");
		this.uiautomatorPythonPath = properties.getProperty("uiautomatorPythonPath");
		this.bashPathString = properties.getProperty("bashPathString");
		this.exploredActivityListPath = properties.getProperty("exploredActivityListPath");
	}
	
	@Override
	public void run(CountDownLatch countDownLatch, int times) {
		// TODO Auto-generated method stub
		String dumpShellString = "bash "+dumpShellPath+" "+uiautomatorPythonPath+" "+exploredActivityListPath;	//运行dump_XML.sh脚本的命令
		String[] dumpCmdStrings = new String[] {bashPathString,"-c",dumpShellString};	//Runtime.getRuntime().exec()参数
		DumpXML.setUiautomatorParaments(dumpShellString, dumpCmdStrings);
		DumpXMLThread dumpXMLThread = new DumpXMLThread(countDownLatch, times);
		dumpXMLThread.start();
		
	}

	@Override
	public void run(CountDownLatch countDownLatch) {	//空实现
		// TODO Auto-generated method stub
		
	}

}
