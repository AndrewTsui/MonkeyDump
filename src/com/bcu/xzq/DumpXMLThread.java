package com.bcu.xzq;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class DumpXMLThread extends Thread{	//该线程用于获取安卓应用状态的XML文件
	
	private final CountDownLatch countDownLatch;
	
	private int times = 0; //线程执行次数，默认不执行
    
    public DumpXMLThread(CountDownLatch countDownLatch, int times) {
		// TODO Auto-generated constructor stub
    	this.countDownLatch = countDownLatch;
    	
    	this.times = times;
	}

	@Override
    public void run() {
		
		try { 	
			for(int i = 0; i < times; i++) {
				synchronized (ThreadContext.lock) {
					if (ThreadContext.flag) {
						ThreadContext.lock.wait(); 
					}	
					System.out.println("Dump .XML File...");
   	
    				DumpXML.dumpXML();
    		
    				ThreadContext.flag = true;
    			
    				countDownLatch.countDown();
    				
    				ThreadContext.lock.notify();
    			}
        	}
        } catch (InterruptedException | IOException e) {
          
        	e.printStackTrace();
        }
    }
}
