package com.bcu.xzq;

import java.io.IOException;
import java.util.Properties;

public class RunApplication implements RunApplicationImp {	// Concrete Strategy
	
	private String className = "com.bcu.xzq.StartAllThreads";
	private String methodName = "startThreads";
	private int methodParam = 10;	//单个线程执行次数
	
	@Override
	public void runApplication() {	//需要怎样的运行效果可以继承RunApplicationImp接口重写runApplication()方法
		// TODO Auto-generated method stub
		
		ReflectMethod reflectMethod = new ReflectStaticMethod(className, methodName,methodParam);
		reflectMethod.invoke();
	
	}

}
