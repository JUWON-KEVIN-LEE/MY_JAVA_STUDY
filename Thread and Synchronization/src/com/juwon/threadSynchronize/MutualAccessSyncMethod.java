package com.juwon.threadSynchronize;

/**
 * Thread Synchronization Method ����
 * @author quf93
 * �� �̻��� �����尡 �ϳ��� ���� �Ǵ� �޸� ������ �Բ� ������ �ϸ� ������ �߻�
 * ����ȭ�� ���� �ذ� Sync / SyncBlock
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
		// ������� 0 �̴�!
	}
}
