package src.com.juwon.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

class Counter {
	int count = 0;
	ReentrantLock criticObj = new ReentrantLock();
	
	public void increment() {
		criticObj.lock();
		// ���� ��ٴ�. �� thread �� lock method �� ȣ���ϰ� ���� ���� ���¿��� �ٸ� thread �� lock method �� ȣ���ϸ�
		// ���� thread �� unlock method �� ȣ���� ������ ����ϰ� �ȴ� 
		try {
			count++;
		} finally {
			criticObj.unlock();
		}
	}
	
	public void decrement() {
		criticObj.lock();
		try {
			count--;
		} finally {
			criticObj.unlock();
		}
	}
	
	public int getCount() {return count;}
}

class MutualAccessReentrantLock {
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
		
		ExecutorService exr = Executors.newFixedThreadPool(3);
		exr.submit(taskIncrement);
		exr.submit(taskDecrement);
		
		exr.shutdown();
		exr.awaitTermination(100, TimeUnit.SECONDS); // thread pool �� ���޵� �۾��� �����⸦ ��ٸ���[100s]
		System.out.println(cnt.getCount()); // ��Ȯ�� ������� ����ϱ� ���ؼ�
	}
}

