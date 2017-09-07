package src.com.juwon.concurrent;

/** Collections Synchronization
 *  public static <T> Collection<T> synchronizedCollection(Collection<T> c)
 *  ���� ���� method ���� ���� �÷��� �����ӿ�ũ�� ����ȭ ����� �����ϰ� �ִ�.
 *  ������, Iterator ���� ����ȭ�� ���� �ƴϹǷ�, ����� �� synchronized block �� ��������Ѵ�.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class SyncArrayList {
	public static List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
	// Collections Sync
	public static void main(String[] args) throws InterruptedException {
		for(int i = 0; i < 16; i++)
			list.add(i);
		System.out.println(list);
		
		Runnable task = () -> {
			synchronized(list) { // Must be in synchronized block
				ListIterator<Integer> itr = list.listIterator();
				while(itr.hasNext())
					itr.set(itr.next() + 1);
			}
			//sync block �� ������ ����ε� ���� ������ �ʴ´�.
			//Iterator �� ����ȭ�� ���� �ʱ� ������ �� �̻��� thread �� ������ �� ���� �߻� 
		};
		
		ExecutorService exr = Executors.newFixedThreadPool(3);
		exr.submit(task);
		exr.submit(task);
		exr.submit(task); // 3�� ������ ������ ����ȴ�.
		
		exr.shutdown();
		exr.awaitTermination(100, TimeUnit.SECONDS);
		System.out.println(list);
	}
}
