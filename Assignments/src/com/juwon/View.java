package com.juwon.assignment;

import java.util.List;
import java.util.Scanner;

public class View {
	public void programStartMessage() {
		println("성적관리프로그램");
		println("---------------------------");
		println("학생정보 입력 : 입력");
		println("학생정보 출력 : 출력");
		println("프로그램 종료 : 종료");
		println("---------------------------");
		print("원하는 기능을 입력해주세요 : ");
	}
	public int inputMessage(Scanner sc) {
		println("성적을 입력합니다");
		println("몇 명의 성적을 입력하시겠습니까?");
		print("작성인원 : ");
		int inputNumber = 0;
		while(true) {
			try{
				String str = sc.nextLine();
				inputNumber = Integer.parseInt(str); // 예외처리
				break;
			}
			catch(NumberFormatException e) {
				println("올바른 숫자를 입력해주세요.");
				print("작성인원 : ");
			}
		}
		println("");
		System.out.printf("%d 명의 성적을 입력합니다 \n", inputNumber);
		return inputNumber;
	}
	public Student inputStudentScore(Scanner sc) {
		Student student = new Student();
		print("이름 : ");
		student.name = sc.nextLine();
		print("국어점수 : ");
		student.koreanScore = Integer.parseInt(sc.nextLine());
		print("영어점수 : ");
		student.englishScore = Integer.parseInt(sc.nextLine());
		print("수학점수 : ");
		student.mathScore = Integer.parseInt(sc.nextLine());
		println("---------------------------");
		return student;
	}
	
	public void outputStudentScore(List<Student> list, Model model) {
		println("---------------------------");
		println("성적출력");
		println("---------------------------");
		for(int i = 0; i < list.size(); i++) {
			println("학생이름 : " + list.get(i).name);
			println("번호 : " + (i+1));
			println("국어점수 : " + list.get(i).koreanScore);
			println("영어점수 : " + list.get(i).englishScore);
			println("수학점수 : " + list.get(i).mathScore);
			println("---------------------------");
		}
		model.averageScore();
		println("과목평균");
		println("---------------------------");
		println("국어평균점수 : " + (model.avrKorScore / list.size()));
		println("영어평균점수 : " + (model.avrEngScore / list.size()));
		println("수학평균점수 : " + (model.avrMathScore / list.size()));
		println("---------------------------");
	}
	
	public void wrongModeMessage() {
		println("");
		System.out.println("잘못 입력하셨습니다.");
		println("");
	}
	
	public void noInformationMessage() {
		println("");
		println("학생 정보가 없습니다.");
		println("학생 정보를 입력해주세요.");
		println("");
	}
	
	public void print(String str) {
		System.out.print(str);
	}
	
	public void println(String str) {
		System.out.println(str);
	}
}
