package com.juwon.collection;

import java.util.*;

public class CollectionMain {
	public static void main(String[] args) {
		CollectionMain cm = new CollectionMain();
		// cm.checkSet();
		cm.checkMap();
		
		
	}
	
	public void checkMap() {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("ID", 2017123456);
		map.put("Password", 12345678);
		
		// one way
		Iterator<String> keys = map.keySet().iterator(); 
		while(keys.hasNext()) {
			String key = keys.next();
			System.out.printf("Key : %s, Value : %d", key, map.get(key).intValue());
			System.out.println( String.format("Key : %s, Value : %d", key, map.get(key)) );
			// format
			// %d : int / %f : float / %s : string / %b : boolean / %n : �ٹٲ�
		}
		
		//two way
		for(String key : map.keySet())
			System.out.println(String.format("Key : %s, Value: %d", key, map.get(key).intValue()));
		// String.format()
		
		//System.out.println(map.get("ID"));
		// System.out.println(map.get("Password"));
		// map �� �ݺ����� ����� �� ����.
	}
	
	public void checkArray() {
		// �⺻���� int long ���� ������ �Ҵ��ϸ� ���ÿ� �⺻������ 0�� �Ҵ�
		int[] intArray = new int[10];
		System.out.println(intArray[7]);
		
		Item[] itemArray = new Item[10];
		int itemLength = itemArray.length;
		for(int i=0; i < itemLength; i++)
			itemArray[i] = new Item();
		System.out.println(itemArray[7].getName());
	}
	
	public void checkList() {
		List list = new ArrayList();
		
		//�Է�
		list.add(new Item());
		list.add(2004);
		//��ȸ
		list.get(0);
		//����
		list.set(0, "Change");
		
		list.add(1, "add");
		// index �ڸ��� ���� index �ڸ��� �ִ� element�� index + 1 �� ������
		// �� ������ ����Ǿ� �ִ� elements �� index + 1 ���� ��ĭ�� �з� ����ȴ�
		
		//����
		list.remove(0);
	}
	
	public void checkGeneric() {
		// Type<GenericType> VarName < GenericType �� class �� ����
		List<String> list = new ArrayList<>();
		list.add("Hi");
		list.add("Hey");
		list.add("Hee");
		list.add("Ho");
		for(String s : list)
			System.out.print(s + " ");
	}
	
	public void checkSet() {
		HashSet<String> set = new HashSet<>();
		set.add("Hi");
		set.add("Hey");
		set.add("Hee");
		set.add("Ho");
		set.add("Hi");
		
		for(String s : set)
			System.out.print(s + " ");
		System.out.println();
		System.out.println("printed by Enhanced For");
		
		Iterator<String> itr = set.iterator();
		while(itr.hasNext())
			System.out.print(itr.next() + " ");
	}
}

class Item {
	private String name = "Zico";
	public String getName() {
		return name;
	}
}
