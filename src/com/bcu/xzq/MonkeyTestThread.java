package com.bcu.xzq;

import java.io.IOException;

/**
 * 
 * @author xzq
 * @version 1.0
 * 
 * This is the Thread of MonkeyTest class
 * 
 */

public class MonkeyTestThread extends Thread{
    
    public MonkeyTestThread() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public void run() {
        try {
        	while (true) {
        		synchronized (ThreadContext.lock) {
        			if (!ThreadContext.flag) {				
        				ThreadContext.lock.wait();
        			}
        			MonkeyTest.monkeyTest();
        			ThreadContext.flag = false;
        			ThreadContext.lock.notify();
        		}
        	}
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
