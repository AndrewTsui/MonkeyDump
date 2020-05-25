package com.bcu.xzq;

import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author xzq
 * @version 1.1
 * @since 1.1 use system.properties
 * 
 * Program entry
 * 
 */

public class ClientMain {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		/* 1.1 use system.properties */
		Properties properties = PropertiesContent.getPropertiesContent();
		
		String throttle = properties.getProperty("throttle");	//monkey��������¼�֮���ʱ����
		String appString = properties.getProperty("appString");	//����App����
		String testNumber = properties.getProperty("testNumber");	//monkeyÿ�β�������¼��ĸ���
		String logPath = properties.getProperty("logPath");	//monkey��־���λ��
		String uiautomatorPythonPath = properties.getProperty("uiautomatorPythonPath");	//uiautomator�ű���λ��
		String dumpShellPath = properties.getProperty("dumpShellPath");	//dump_XML��ŵ�λ��
		String monkeyShellPath = properties.getProperty("monkeyShellPath");	//monkey_test
		String bashPathString = properties.getProperty("bashPathString");	//bash������λ��
		/* 1.1 end */
		
		/*	1.0
		int throttle = 1000; //monkey��������¼�֮���ʱ����
		String appString = "com.ichi2.anki";	//����App����
		int testNumber = 5;	//monkeyÿ�β�������¼��ĸ���
		String logPath = "/Users/tsui/eclipse-workspace/MonkeyDump/MonkeyLog/log.txt";	//monkey��־���λ��
		String uiautomatorPythonPath = "/Users/tsui/eclipse-workspace/MonkeyDump/dump_verbose.py";	//uiautomator�ű���λ��
		String dumpShellPath = "/Users/tsui/eclipse-workspace/MonkeyDump/dump_XML.sh";	//dump_XML��ŵ�λ��
		String monkeyShellPath = "/Users/tsui/eclipse-workspace/MonkeyDump/monkey_test.sh";	//monkey_test
		String bashPathString = "/bin/bash";	//bash������λ��
		*/
		
		String dumpShellString = "bash "+dumpShellPath+" "+uiautomatorPythonPath;	//����dump_XML.sh�ű�������
		String[] dumpCmdStrings = new String[] {bashPathString,"-c",dumpShellString};	//Runtime.getRuntime().exec()����
		
		DumpXML.setUiautomatorParaments(dumpShellString, dumpCmdStrings);
		
		String monkeyShellString = "bash "+monkeyShellPath+" "+throttle+" "+appString+" "+testNumber+" "+logPath;	//����monkey_test.sh�ű�������
		String[] monkeyCmdStrings = new String[] {bashPathString,"-c",monkeyShellString};
		
		MonkeyTest.setMonkeyParaments(monkeyShellString, monkeyCmdStrings);
		
		DumpXMLThread dumpXMLThread = new DumpXMLThread();
		dumpXMLThread.start();
		
		MonkeyTestThread monkeyTestThread = new MonkeyTestThread();
		monkeyTestThread.start();
	
	}//main

}
