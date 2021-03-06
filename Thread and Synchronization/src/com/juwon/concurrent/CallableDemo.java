package src.com.juwon.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutionException;

class CallableDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		Callable<Integer> task = () -> {
			int sum = 0;
			for(int i = 0; i < 10; i++)
				sum += i;
			return sum;
		};
		
		ExecutorService exr = Executors.newFixedThreadPool(2);
		Future<Integer> ft = exr.submit(task);
		
		int i = ft.get();
		System.out.println("result = " + i);
		exr.shutdown();
	}
}
