package com.bcu.xzq;

import java.util.concurrent.CountDownLatch;

public interface StartThreadImp {	//����Java��֧��˫ָ�ɣ����ط����ľ���ʵ��һ��Ҫ����ʵ����
	public void run(CountDownLatch countDownLatch,int times);
	public void run(CountDownLatch countDownLatch);
}
