package com.juwon.threadBasic;

class MakeThreadDemo {
	public static void main(String[] args) {
		// java.lang.Runnable interface 
		// void run()
		Runnable task = () -> {
			int number = 10;
			int number2 = 20;
			String name = Thread.currentThread().getName();
			System.out.println(name + " " + (number + number2)); // ����� Thread-0 30
		};
		
		Thread t = new Thread(task); // public Thread(Runnable target, String name) �̸��� �ٿ��� �� �ִ�.
		t.start(); // Thread ������ ����
		System.out.println("End " + Thread.currentThread().getName());
		// ������� End Main
		// Main Thread > Thread-0
	}
}
