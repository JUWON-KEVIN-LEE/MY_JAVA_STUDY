package com.juwon.threadBasic;

class Task extends Thread {
	@Override
	public void run() { // Thread run method overriding
		int number = 10;
		int number2 = 20;
		String name = Thread.currentThread().getName();
		System.out.println(name + " " + (number + number2)); 
	}
}

class MakeThreadDemo2 {
	public static void main(String[] args) {
		// 1. Make Runnable instance
		// 2. Make Thread instance
		// 3. Call start method
		
		// 1. Make Class extends Thread and instance
		Task t1 = new Task();
		Task t2 = new Task();
		// 2. Call start method
		t1.start();
		t2.start();
	}
}