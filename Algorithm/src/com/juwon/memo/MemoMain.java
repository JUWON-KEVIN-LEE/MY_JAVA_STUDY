package com.juwon.memo;

/**
 * Out > System.out.print
 * In > Scanner(System.in) 
 * @author quf93
 * 메모 데이터에 대한 조작이 필요할 경우 모두 Controller 에서 작업한다.
 */

import java.util.*;

public class MemoMain {
	static View view = new View();
	static Model model = new Model();
	
	public static void main(String[] args) {
		MemoMain main = new MemoMain();
		Scanner sc = new Scanner(System.in);
		
		view.printWelcomeMessage();
		
		String command = "";
		while(!command.equals("exit")) {
			command = sc.nextLine();
			main.switchCtrl(sc, command);
		}
		
		view.printExitMessage();
}
	
	public void switchCtrl(Scanner sc, String command) {
		switch(command) {
		case "c":
		case "ㅊ":
			model.create(view.create(sc));
			view.printCompleteMessage();
			break;
		case "r":
			if(model.list.size()==0) {
				System.out.println("-------- 게시글이 없습니다 --------");
				System.out.println("------- 게시글을 입력해주세요 -------");
				break;
			}
			view.read(sc, model.list);
			view.printCompleteMessage();
			break;
		case "u":
			if(model.list.size()==0) {
				System.out.println("-------- 게시글이 없습니다 --------");
				System.out.println("------- 게시글을 입력해주세요 -------");
				break;
			}
			model.update(view.update(sc, model.list));
			view.printCompleteMessage();
			break;
		case "d":
			if(model.list.size()==0) {
				System.out.println("-------- 게시글이 없습니다 --------");
				System.out.println("------- 게시글을 입력해주세요 -------");
				break;
			}
			view.delete(sc, model.list);
			view.printCompleteMessage();
			break;
		case "l":
			if(model.list.size()==0) {
				System.out.println("-------- 게시글이 없습니다 --------");
				System.out.println("------- 게시글을 입력해주세요 -------");
				break;
			}
			view.showList(model.list);
			view.printCompleteMessage();
			break;
		}
	}
}
