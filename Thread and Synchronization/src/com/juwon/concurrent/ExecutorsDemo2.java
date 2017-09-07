package src.com.juwon.concurrent;

/**
 * Executors and ExecutorService Practice
 * @author quf93
 * newSingleThreadExecutor ; Creates an Executor that uses a single worker thread (operating off an unbounded queue)
 * newFixedThreadExecutor ; Creates a thread pool that reuses a fixed number of threads ()
 * newCachedThreadExecutor ; Creates a thread pool that creates new threads as needed
 * > 가장 효율적으로 쓰레드를 관리하는 것처럼 보이지만 전달된 작업의 수에 비례하여 쓰레드가 생성될 수 있어, 빈번한 쓰레드의 생성과 소멸로 이어질 수 있다.
 */

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

class ExecutorsDemo2 {
	public static void main(String[] args) {
		Runnable taskSum = () -> {
			int a = 10;
			int b = 100;
			String name = Thread.currentThread().getName();
			System.out.println("result = " + (a + b) + " executed on " + name);
		};
		
		Runnable taskSub = () -> {
			int a = 10;
			int b = 100;
			String name = Thread.currentThread().getName();
			System.out.println("result = " + (a - b) + " executed on " + name);
		};
		
		ExecutorService exr = Executors.newFixedThreadPool(3);
		exr.submit(taskSum);
		exr.submit(taskSub);
		exr.submit(() -> {
			int a = 10;
			int b = 100;
			String name = Thread.currentThread().getName();
			System.out.println("result = " + (a * b) + " executed on " + name);
		}); // 반복적인 작업이 아닐 경우 인자 전달 위치에 람다식을 작성할 수 있다.
		
		exr.shutdown();
	}
}
