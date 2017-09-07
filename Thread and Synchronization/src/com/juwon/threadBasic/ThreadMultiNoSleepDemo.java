package com.juwon.threadBasic;

class ThreadMultiNoSleepDemo {
	public static void main(String[] args) {
		// 1. Make Runnable instance
		Runnable taskEven = () -> { // 20 �̸� ¦�� ���
			for(int index = 0; index < 20; index++) {
				if(index % 2 == 0)
					System.out.print(index + " ");
			}
		};
		
		Runnable taskOdd = () -> { // 20 �̸� Ȧ�� ���
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
		
		// ��°��� �������� �ʴ�
		// ������ Thread �� ���������� �ڽ��� ���� ������ ������ ����
	}
}
