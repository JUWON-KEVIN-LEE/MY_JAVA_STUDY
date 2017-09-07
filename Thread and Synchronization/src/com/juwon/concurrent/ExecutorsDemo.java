package src.com.juwon.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

class ExecutorsDemo {
	public static void main(String[] args) {
		Runnable task = () -> { // Thread 에게 전달할 작업
			int a = 10;
			int b = 100;
			String name = Thread.currentThread().getName();
			System.out.println("result = " + (b / a) + " executed on " + name);
		};
		
		ExecutorService exr = Executors.newSingleThreadExecutor(); // Thread pool 생성
		exr.submit(task); // Thread pool 에 task 를 전달
		
		System.out.println("Main Thread Execute");
		exr.shutdown(); // Thread pool 소멸
	}
}