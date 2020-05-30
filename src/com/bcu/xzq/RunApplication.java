package com.bcu.xzq;

import java.io.IOException;
import java.util.Properties;

public class RunApplication implements RunApplicationImp {	// Concrete Strategy
	
	private String className = "com.bcu.xzq.StartAllThreads";
	private String methodName = "startThreads";
	private int methodParam = 10;	//�����߳�ִ�д���
	
	@Override
	public void runApplication() {	//��Ҫ����������Ч�����Լ̳�RunApplicationImp�ӿ���дrunApplication()����
		// TODO Auto-generated method stub
		
		ReflectMethod reflectMethod = new ReflectStaticMethod(className, methodName,methodParam);
		reflectMethod.invoke();
	
	}

}
