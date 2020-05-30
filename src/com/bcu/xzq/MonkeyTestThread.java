package com.bcu.xzq;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class MonkeyTestThread extends Thread{	//该线程用于执行Monkey测试
    
	private final CountDownLatch countDownLatch;
	private int times = 0; //线程执行次数，默认不执行
	
    public MonkeyTestThread(CountDownLatch countDownLatch, int times) {
		// TODO Auto-generated constructor stub
    	this.countDownLatch = countDownLatch;
    	this.times = times;
	}

	@Override
    public void run() {
        try {
        	for(int i = 0; i < times; i++) {
        		synchronized (ThreadContext.lock) {
        			if (!ThreadContext.flag) {				
        				ThreadContext.lock.wait();
        			}
        			System.out.println("Monkey Testing...");
        			MonkeyTest.monkeyTest();
        			ThreadContext.flag = false;
        			countDownLatch.countDown();
        			ThreadContext.lock.notify();
        		}
        	}
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
