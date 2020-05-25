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
		
		String throttle = properties.getProperty("throttle");	//monkey两次随机事件之间的时间间隔
		String appString = properties.getProperty("appString");	//测试App包名
		String testNumber = properties.getProperty("testNumber");	//monkey每次测试随机事件的个数
		String logPath = properties.getProperty("logPath");	//monkey日志存放位置
		String uiautomatorPythonPath = properties.getProperty("uiautomatorPythonPath");	//uiautomator脚本的位置
		String dumpShellPath = properties.getProperty("dumpShellPath");	//dump_XML存放的位置
		String monkeyShellPath = properties.getProperty("monkeyShellPath");	//monkey_test
		String bashPathString = properties.getProperty("bashPathString");	//bash解释器位置
		/* 1.1 end */
		
		/*	1.0
		int throttle = 1000; //monkey两次随机事件之间的时间间隔
		String appString = "com.ichi2.anki";	//测试App包名
		int testNumber = 5;	//monkey每次测试随机事件的个数
		String logPath = "/Users/tsui/eclipse-workspace/MonkeyDump/MonkeyLog/log.txt";	//monkey日志存放位置
		String uiautomatorPythonPath = "/Users/tsui/eclipse-workspace/MonkeyDump/dump_verbose.py";	//uiautomator脚本的位置
		String dumpShellPath = "/Users/tsui/eclipse-workspace/MonkeyDump/dump_XML.sh";	//dump_XML存放的位置
		String monkeyShellPath = "/Users/tsui/eclipse-workspace/MonkeyDump/monkey_test.sh";	//monkey_test
		String bashPathString = "/bin/bash";	//bash解释器位置
		*/
		
		String dumpShellString = "bash "+dumpShellPath+" "+uiautomatorPythonPath;	//运行dump_XML.sh脚本的命令
		String[] dumpCmdStrings = new String[] {bashPathString,"-c",dumpShellString};	//Runtime.getRuntime().exec()参数
		
		DumpXML.setUiautomatorParaments(dumpShellString, dumpCmdStrings);
		
		String monkeyShellString = "bash "+monkeyShellPath+" "+throttle+" "+appString+" "+testNumber+" "+logPath;	//运行monkey_test.sh脚本的命令
		String[] monkeyCmdStrings = new String[] {bashPathString,"-c",monkeyShellString};
		
		MonkeyTest.setMonkeyParaments(monkeyShellString, monkeyCmdStrings);
		
		DumpXMLThread dumpXMLThread = new DumpXMLThread();
		dumpXMLThread.start();
		
		MonkeyTestThread monkeyTestThread = new MonkeyTestThread();
		monkeyTestThread.start();
	
	}//main

}
