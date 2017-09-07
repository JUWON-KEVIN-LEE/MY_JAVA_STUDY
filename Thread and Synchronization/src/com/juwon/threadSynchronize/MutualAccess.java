package com.juwon.threadSynchronize;

class Counter {
	int count = 0;
	
	public void increment() {
		count++;
	}
	
	public void decrement() {
		count--;
	}
	public int getCount() {return count;}
}
class MutualAccess {
	public static Counter cnt = new Counter();
	
	public static void main(String[] args) throws InterruptedException {
		Runnable taskIncrement = () -> {
			for(int i = 0; i < 1000; i++)
				cnt.increment();
		};
		
		Runnable taskDecrement = () -> {
			for(int i = 0; i < 1000; i++)
				cnt.decrement();
		};
		
		Thread t1 = new Thread(taskIncrement);
		Thread t2 = new Thread(taskDecrement);
		t1.start();
		t2.start();
		t1.join();
		t2.join(); // Thread �� ���Ḧ ��ٸ�
		// ������� ���� ���ؼ�
		System.out.print(cnt.count);
		// ������� 0 �� �ƴϴ�!
		
	}
}
