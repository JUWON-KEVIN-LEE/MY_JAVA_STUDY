package com.juwon.assignment;

import java.util.Scanner;

public class Controller {
	static View view = new View();
	static Model model = new Model();
	
	public static void main(String[] args) {
		Controller ctrl = new Controller();
		Scanner sc = new Scanner(System.in);
		
		String command = "";
		while(!command.equals("종료")) {  
			view.programStartMessage();
			command = sc.nextLine();
			ctrl.switchMode(sc, command);
		}
		System.out.println("");
		
	}
	
	public void switchMode(Scanner sc, String command) {
		switch(command) {
		case "입력": 
			int count = view.inputMessage(sc);
			for(int i=0; i<count; i++)
				model.inputStudentScore(view.inputStudentScore(sc));
			break;
		case "출력":
			if(model.list.size()==0) {
				view.noInformationMessage();
				break;
			}
			view.outputStudentScore(model.list, model);
			break;
		case "종료":
			break;
		default:
			view.wrongModeMessage();
			break;
		}
	}
}
