package src.com.juwon.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

class ExecutorsDemo {
	public static void main(String[] args) {
		Runnable task = () -> { // Thread ���� ������ �۾�
			int a = 10;
			int b = 100;
			String name = Thread.currentThread().getName();
			System.out.println("result = " + (b / a) + " executed on " + name);
		};
		
		ExecutorService exr = Executors.newSingleThreadExecutor(); // Thread pool ����
		exr.submit(task); // Thread pool �� task �� ����
		
		System.out.println("Main Thread Execute");
		exr.shutdown(); // Thread pool �Ҹ�
	}
}