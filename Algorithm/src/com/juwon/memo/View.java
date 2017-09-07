package com.juwon.memo;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

class View {
	public Memo create(Scanner sc) {
		Memo memo = new Memo();
		println("------------------------------");
		println("");
		print("�̸��� �Է��ϼ��� : ");
		memo.name = sc.nextLine();
		print("������ �Է��ϼ��� : ");
		memo.content = sc.nextLine();
		println("");
		println("---- �Է°�� ----");
		println("�̸� : " + memo.name);
		println("���� : " + memo.content);
		println("---------------");
		println("");
		return memo;
	}
	
	public void read(Scanner sc, List<Memo> list) {
		println("-------- �۹�ȣ�� �Է��ϼ��� --------");
		String tempNo = sc.nextLine();
		int index = Integer.parseInt(tempNo);
		println("------------------------------");
		while(true) {
			try {
				Memo memo = list.get(index-1);
				System.out.println("|No: " + memo.no);
				System.out.println("|Author : " + memo.name);
				System.out.println("|Contents : " + memo.content);
				System.out.println("|Date : " + memo.date);
				System.out.println("------------------------------");
				return;
			}
			catch(IndexOutOfBoundsException e) {
				println("------ "+list.size()+"���� ��ȣ�� �Է°����մϴ� -----");
				tempNo = sc.nextLine();
				index = Integer.parseInt(tempNo);
				println("------------------------------");
			}
		}
	}

	public Memo update(Scanner sc, List<Memo> list) {
		println("------ ������ �۹�ȣ�� �Է��ϼ��� ------");
		String tempNo = sc.nextLine();
		int memoNo = Integer.parseInt(tempNo);
		println("------------------------------");
		while(true) {
			try {
				Memo memo = list.get(memoNo-1);
				println("|No: " + memo.no);
				println("|Author : " + memo.name);
				println("|Contents : " + memo.content);
				println("|Date : " + memo.date);
				println("------------------------------");
				println("|No: " + memo.no);
				print("|Author : ");
				memo.name = sc.nextLine();
				print("|Contents : ");
				memo.content = sc.nextLine();
				memo.date = LocalDate.now();
				println("|Date : " + memo.date);
				println("------------------------------");
				return memo;
			}
			catch(IndexOutOfBoundsException e) {
				println("------ �ùٸ� �۹�ȣ�� �Է��ϼ��� ------");
				tempNo = sc.nextLine();
				memoNo = Integer.parseInt(tempNo);
				println("------------------------------");
			}
		}
	}

	public void delete(Scanner sc, List<Memo> list) {
		println("------ ������ �۹�ȣ�� �Է��ϼ��� ------");
		String tempNo = sc.nextLine();
		int memoNo = Integer.parseInt(tempNo);
		println("------------------------------");
		while(true) {
			try {
				list.remove(memoNo-1);
				for(int i = memoNo-1; i < list.size(); i++)
					list.get(i).no = i+1;
				return;
			}
			catch(IndexOutOfBoundsException e) {
				println("------ �ùٸ� �۹�ȣ�� �Է��ϼ��� ------");
				tempNo = sc.nextLine();
				memoNo = Integer.parseInt(tempNo);
				println("------------------------------");
			}
		}
	}
	
	public void showList(List<Memo> list) {
		println("------------------------------");
		for(Memo memo : list) {
			println("|No: " + memo.no);
			println("|Author : " + memo.name);
			println("|Contents : " + memo.content);
			println("|Date : " + memo.date);
			println("------------------------------");
		}
	}
	
	public void printWelcomeMessage() {
		println("------- �ȳ��ϼ��� �ݰ����ϴ� -------");
		println("-------- ��ɾ �Է��ϼ��� --------");
		println("c : ����, r : �б�, u : ����, d : ����, l : ����Ʈ");
		println("exit : ����");
		println("------------------------------");
	}
	public void printCompleteMessage() {
		println("--------- �Ϸ�Ǿ����ϴ� ---------");
		println("-------- ��ɾ �Է��ϼ��� --------");
	}
	public void print(String str) {
		System.out.print(str);
	}
	public void println(String str) {
		System.out.println(str);
	}
	public void printExitMessage() {
		println("�ý��� ����");
	}
}
