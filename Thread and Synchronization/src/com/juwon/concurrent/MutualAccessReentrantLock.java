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
		// 문을 잠근다. 한 thread 가 lock method 를 호출하고 실행 중인 상태에서 다른 thread 가 lock method 를 호출하면
		// 먼저 thread 가 unlock method 를 호출할 때까지 대기하게 된다 
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
		exr.awaitTermination(100, TimeUnit.SECONDS); // thread pool 에 전달된 작업이 끝나기를 기다린다[100s]
		System.out.println(cnt.getCount()); // 정확한 결과값을 출력하기 위해서
	}
}

