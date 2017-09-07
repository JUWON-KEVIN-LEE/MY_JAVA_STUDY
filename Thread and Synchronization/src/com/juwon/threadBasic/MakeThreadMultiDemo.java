package com.juwon.threadBasic;

class MakeThreadMultiDemo {
	public static void main(String[] args) {
		Runnable taskEven = () -> {
			try{
				for(int index = 0; index < 20; index++) {
					if(index % 2 == 0)
						System.out.print(index + " ");
					Thread.sleep(100); // 0.1초간 sleep
					// public static void sleep(long millis) throws InterruptedException
				}
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			/* InterruptedException
			 * thread A 가 sleep method 를 사용해 일시정지 한 상태
			 * Thread.sleep(800000000);
			 * 도중에 취소하고 싶으면...
			 * 다른 thread B 가 A 를 취소해줘야 한다.
			 * A.interrupt();
			 * 일시정지는 중단되고, InterruptedException 예외를 통보하고 예외를 처리하는 catch 절로 이동하게 된다.
			 */
		};
		Runnable taskOdd = () -> {
			try {
				for(int index = 0; index < 20; index++) {
					if(index % 2 == 1)
						System.out.print(index + " ");
					Thread.sleep(100); // 0.1초간 sleep
					// public static void sleep(long millis) throws InterruptedException
				}
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Thread t1 = new Thread(taskEven);
		Thread t2 = new Thread(taskOdd);
		t1.start();
		t2.start();
		// 출력값 0 1 2 ... 16 17 18 19
		// print > sleep 반복
	}
}


