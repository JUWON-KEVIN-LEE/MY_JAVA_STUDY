package com.juwon.threadSynchronize;

class CounterSyncBlock {
	int count = 0;
	public void increment() {
		synchronized(this) {
			count++;
		}
	}
	
	public void decrement() {
		synchronized(this) {
			count--;
		}
	}
	
	public int getCount() {
		return count;
	}
}

class MutualAccessSyncBlock {
	public static CounterSyncBlock csb = new CounterSyncBlock();
	public static void main(String[] args) throws InterruptedException {
		Runnable taskIncrement = () -> {
			for(int i = 0; i < 1000; i++)
				csb.increment();
		};
		
		Runnable taskDecrement = () -> {
			for(int i = 0; i < 1000; i++)
				csb.decrement();
		};
		
		Thread t1 = new Thread(taskIncrement);
		Thread t2 = new Thread(taskDecrement);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.print(csb.count);
		// 결과값은 0 이다!
	}
}

/* StringBuffer is synchronized 안전하지만 Builder에 비해 느리다.
 * StringBuilder is not synchronized 안전하지 않지만 속도가 빠르다.
 * ArrayList<E> Note that this implementation is not synchronized
 * ...
*/