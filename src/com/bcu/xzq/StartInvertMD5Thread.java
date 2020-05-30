package com.bcu.xzq;

import java.util.concurrent.CountDownLatch;

public class StartInvertMD5Thread implements StartThreadImp {

	@Override
	public void run(CountDownLatch countDownLatch, int times) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run(CountDownLatch countDownLatch) {
		// TODO Auto-generated method stub
		InvertMD5Thread invertMD5Thread = new InvertMD5Thread(countDownLatch);
		invertMD5Thread.start();
	}

}
