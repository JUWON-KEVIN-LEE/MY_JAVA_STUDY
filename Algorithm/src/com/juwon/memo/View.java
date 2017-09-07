package com.juwon.memo;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

class View {
	public Memo create(Scanner sc) {
		Memo memo = new Memo();
		println("------------------------------");
		println("");
		print("이름을 입력하세요 : ");
		memo.name = sc.nextLine();
		print("내용을 입력하세요 : ");
		memo.content = sc.nextLine();
		println("");
		println("---- 입력결과 ----");
		println("이름 : " + memo.name);
		println("내용 : " + memo.content);
		println("---------------");
		println("");
		return memo;
	}
	
	public void read(Scanner sc, List<Memo> list) {
		println("-------- 글번호를 입력하세요 --------");
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
				println("------ "+list.size()+"까지 번호만 입력가능합니다 -----");
				tempNo = sc.nextLine();
				index = Integer.parseInt(tempNo);
				println("------------------------------");
			}
		}
	}

	public Memo update(Scanner sc, List<Memo> list) {
		println("------ 수정할 글번호를 입력하세요 ------");
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
				println("------ 올바른 글번호를 입력하세요 ------");
				tempNo = sc.nextLine();
				memoNo = Integer.parseInt(tempNo);
				println("------------------------------");
			}
		}
	}

	public void delete(Scanner sc, List<Memo> list) {
		println("------ 삭제할 글번호를 입력하세요 ------");
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
				println("------ 올바른 글번호를 입력하세요 ------");
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
		println("------- 안녕하세요 반갑습니다 -------");
		println("-------- 명령어를 입력하세요 --------");
		println("c : 쓰기, r : 읽기, u : 수정, d : 삭제, l : 리스트");
		println("exit : 종료");
		println("------------------------------");
	}
	public void printCompleteMessage() {
		println("--------- 완료되었습니다 ---------");
		println("-------- 명령어를 입력하세요 --------");
	}
	public void print(String str) {
		System.out.print(str);
	}
	public void println(String str) {
		System.out.println(str);
	}
	public void printExitMessage() {
		println("시스템 종료");
	}
}
