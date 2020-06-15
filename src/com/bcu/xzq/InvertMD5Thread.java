package com.bcu.xzq;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class InvertMD5Thread extends Thread{	//���߳����ڽ���ȡ��XML�ļ�ת����32λ��ϣֵ
	
	private final CountDownLatch countDownLatch;
    
	public InvertMD5Thread(CountDownLatch countDownLatch) {
		super();
		this.countDownLatch = countDownLatch;
	}
    
	@Override
	public void run() {
		
		try {
			countDownLatch.await();
			System.out.println("Invert all .XMl Files to MD5 Hash Code...");
			InvertMD5.invertMD5();
			CountActivities.countActivities();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
}
