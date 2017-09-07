package src.com.juwon.concurrent;

/** Collections Synchronization
 *  public static <T> Collection<T> synchronizedCollection(Collection<T> c)
 *  위와 같은 method 들을 통해 컬렉션 프레임워크의 동기화 방법을 제공하고 있다.
 *  하지만, Iterator 까지 동기화된 것은 아니므로, 사용할 때 synchronized block 을 씌워줘야한다.
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
			//sync block 이 없으면 제대로된 값이 나오지 않는다.
			//Iterator 는 동기화가 되지 않기 때문에 둘 이상의 thread 가 접근할 때 문제 발생 
		};
		
		ExecutorService exr = Executors.newFixedThreadPool(3);
		exr.submit(task);
		exr.submit(task);
		exr.submit(task); // 3씩 더해진 값들이 저장된다.
		
		exr.shutdown();
		exr.awaitTermination(100, TimeUnit.SECONDS);
		System.out.println(list);
	}
}
