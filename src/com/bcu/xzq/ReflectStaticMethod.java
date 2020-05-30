package com.bcu.xzq;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectStaticMethod implements ReflectMethod {	//ͨ��������þ�̬����
	
	private String className;
	private String methodName;
	private int methodParam;	//startThreads()����

	public ReflectStaticMethod(String className, String methodName, int methodParam) {
		super();
		this.className = className;
		this.methodName = methodName;
		this.methodParam = methodParam;
	}

	@Override
	public void invoke() {	//����ֻ��������StartThreads��ķ���
		// TODO Auto-generated method stub
		Class clazz;
		Method method;
		Constructor c;
		
		try {
			clazz = Class.forName(className);
			method = clazz.getMethod(methodName, int.class);
			method.invoke(null, methodParam);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
