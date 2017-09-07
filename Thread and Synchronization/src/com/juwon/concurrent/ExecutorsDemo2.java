package src.com.juwon.concurrent;

/**
 * Executors and ExecutorService Practice
 * @author quf93
 * newSingleThreadExecutor ; Creates an Executor that uses a single worker thread (operating off an unbounded queue)
 * newFixedThreadExecutor ; Creates a thread pool that reuses a fixed number of threads ()
 * newCachedThreadExecutor ; Creates a thread pool that creates new threads as needed
 * > ���� ȿ�������� �����带 �����ϴ� ��ó�� �������� ���޵� �۾��� ���� ����Ͽ� �����尡 ������ �� �־�, ����� �������� ������ �Ҹ�� �̾��� �� �ִ�.
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
		}); // �ݺ����� �۾��� �ƴ� ��� ���� ���� ��ġ�� ���ٽ��� �ۼ��� �� �ִ�.
		
		exr.shutdown();
	}
}
