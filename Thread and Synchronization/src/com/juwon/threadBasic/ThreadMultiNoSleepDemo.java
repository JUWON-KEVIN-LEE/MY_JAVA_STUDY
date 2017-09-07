package com.juwon.threadBasic;

class ThreadMultiNoSleepDemo {
	public static void main(String[] args) {
		// 1. Make Runnable instance
		Runnable taskEven = () -> { // 20 미만 짝수 출력
			for(int index = 0; index < 20; index++) {
				if(index % 2 == 0)
					System.out.print(index + " ");
			}
		};
		
		Runnable taskOdd = () -> { // 20 미만 홀수 출력
			for(int index = 0; index < 20; index++) {
				if(index % 2 == 1)
					System.out.print(index + " ");
			}
		};
		// 2. Make Thread instance
		Thread t1 = new Thread(taskEven);
		Thread t2 = new Thread(taskOdd);
		// 3. Call start method
		t1.start();
		t2.start();
		
		// 출력값이 일정하지 않다
		// 각각의 Thread 가 독립적으로 자신의 일을 실행해 나가기 때문
	}
}
