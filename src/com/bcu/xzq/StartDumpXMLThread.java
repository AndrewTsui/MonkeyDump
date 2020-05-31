package com.bcu.xzq;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class StartDumpXMLThread implements StartThreadImp {

	Properties properties;
	String dumpShellPath;	//dump_XML��ŵ�λ��
	String uiautomatorPythonPath;	//uiautomator�ű���λ��
	String bashPathString;	//bash������λ��
	String exploredActivityListPath;	//explored_activity_list.txtλ��
	
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
		String dumpShellString = "bash "+dumpShellPath+" "+uiautomatorPythonPath+" "+exploredActivityListPath;	//����dump_XML.sh�ű�������
		String[] dumpCmdStrings = new String[] {bashPathString,"-c",dumpShellString};	//Runtime.getRuntime().exec()����
		DumpXML.setUiautomatorParaments(dumpShellString, dumpCmdStrings);
		DumpXMLThread dumpXMLThread = new DumpXMLThread(countDownLatch, times);
		dumpXMLThread.start();
		
	}

	@Override
	public void run(CountDownLatch countDownLatch) {	//��ʵ��
		// TODO Auto-generated method stub
		
	}

}
