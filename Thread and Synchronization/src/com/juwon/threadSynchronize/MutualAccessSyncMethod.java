package com.juwon.threadSynchronize;

/**
 * Thread Synchronization Method 연습
 * @author quf93
 * 둘 이상의 쓰레드가 하나의 변수 또는 메모리 공간에 함께 접근을 하면 문제가 발생
 * 동기화를 통해 해결 Sync / SyncBlock
 */

class CounterSync {
	int count = 0;
	
	synchronized public void increment() {
		count++;
	}
	
	synchronized public void decrement() {
		count--;
	}
	
	public int getCount() {return count;}
}

class MutualAccessSyncMethod {
	public static CounterSync cs = new CounterSync();
	public static void main(String[] args) throws InterruptedException {
		Runnable taskIncrement = () -> {
			for(int i = 0; i < 1000; i++)
				cs.increment();
		};
		
		Runnable taskDecrement = () -> {
			for(int i = 0; i < 1000; i++)
				cs.decrement();
		};
		
		Thread t1 = new Thread(taskIncrement);
		Thread t2 = new Thread(taskDecrement);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.print(cs.count);
		// 결과값은 0 이다!
	}
}
