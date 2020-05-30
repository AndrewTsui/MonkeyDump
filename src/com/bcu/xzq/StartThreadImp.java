package com.bcu.xzq;

import java.util.concurrent.CountDownLatch;

public interface StartThreadImp {	//由于Java不支持双指派，重载方法的具体实现一定要放在实现中
	public void run(CountDownLatch countDownLatch,int times);
	public void run(CountDownLatch countDownLatch);
}
