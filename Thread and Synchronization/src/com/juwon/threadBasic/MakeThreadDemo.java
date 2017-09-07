package com.juwon.threadBasic;

class MakeThreadDemo {
	public static void main(String[] args) {
		// java.lang.Runnable interface 
		// void run()
		Runnable task = () -> {
			int number = 10;
			int number2 = 20;
			String name = Thread.currentThread().getName();
			System.out.println(name + " " + (number + number2)); // 결과값 Thread-0 30
		};
		
		Thread t = new Thread(task); // public Thread(Runnable target, String name) 이름을 붙여줄 수 있다.
		t.start(); // Thread 생성과 실행
		System.out.println("End " + Thread.currentThread().getName());
		// 결과값은 End Main
		// Main Thread > Thread-0
	}
}
