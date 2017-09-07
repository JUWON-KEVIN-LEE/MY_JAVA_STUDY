package com.juwon.threadBasic;

class MakeThreadMultiDemo {
	public static void main(String[] args) {
		Runnable taskEven = () -> {
			try{
				for(int index = 0; index < 20; index++) {
					if(index % 2 == 0)
						System.out.print(index + " ");
					Thread.sleep(100); // 0.1�ʰ� sleep
					// public static void sleep(long millis) throws InterruptedException
				}
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			/* InterruptedException
			 * thread A �� sleep method �� ����� �Ͻ����� �� ����
			 * Thread.sleep(800000000);
			 * ���߿� ����ϰ� ������...
			 * �ٸ� thread B �� A �� �������� �Ѵ�.
			 * A.interrupt();
			 * �Ͻ������� �ߴܵǰ�, InterruptedException ���ܸ� �뺸�ϰ� ���ܸ� ó���ϴ� catch ���� �̵��ϰ� �ȴ�.
			 */
		};
		Runnable taskOdd = () -> {
			try {
				for(int index = 0; index < 20; index++) {
					if(index % 2 == 1)
						System.out.print(index + " ");
					Thread.sleep(100); // 0.1�ʰ� sleep
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
		// ��°� 0 1 2 ... 16 17 18 19
		// print > sleep �ݺ�
	}
}


