package com.bcu.xzq;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectInstanceMethod implements ReflectMethod {	//需要先通过反射实例化对象，再调用方法

	private String className;
	private String methodName;
		
	public ReflectInstanceMethod(String className, String methodName) {
		super();
		this.className = className;
		this.methodName = methodName;
	}

	@Override
	public void invoke() {
		// TODO Auto-generated method stub
		Class clazz;
		Method method;
		Constructor c;
		
		try {
			clazz = Class.forName(className);
			method = clazz.getMethod(methodName);
			c = clazz.getConstructor();
			Object service = c.newInstance();
			method.invoke(service);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
