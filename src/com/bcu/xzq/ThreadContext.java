package com.bcu.xzq;

/**
 * 
 * @author xzq
 * @version 1.0
 * 
 * flag affects alternating running of Threads
 * lock offered to ensure Threads safety
 * 
 */

public class ThreadContext {
	
	public static boolean flag = true;
	public static Object lock = new Object();

}
