package com.bcu.xzq;

import java.io.IOException;

/**
 * 
 * @author xzq
 * @version 1.0
 * 
 * This is the Thread of DumpXML class
 * 
 */

public class DumpXMLThread extends Thread{
    
    public DumpXMLThread() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public void run() {
		try {
        	while (true) {
        		synchronized (ThreadContext.lock) {
    				if (ThreadContext.flag) {
    					ThreadContext.lock.wait();
    				}
    				DumpXML.dumpXML();
    				ThreadContext.flag = true;
    				ThreadContext.lock.notify();
    			}
        	}
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
