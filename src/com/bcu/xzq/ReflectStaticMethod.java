package com.bcu.xzq;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectStaticMethod implements ReflectMethod {	//通过反射调用静态方法
	
	private String className;
	private String methodName;
	private int methodParam;	//startThreads()参数

	public ReflectStaticMethod(String className, String methodName, int methodParam) {
		super();
		this.className = className;
		this.methodName = methodName;
		this.methodParam = methodParam;
	}

	@Override
	public void invoke() {	//这里只用来反射StartThreads类的方法
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
