package com.juwon.assignment;

import java.util.List;
import java.util.Scanner;

public class View {
	public void programStartMessage() {
		println("�����������α׷�");
		println("---------------------------");
		println("�л����� �Է� : �Է�");
		println("�л����� ��� : ���");
		println("���α׷� ���� : ����");
		println("---------------------------");
		print("���ϴ� ����� �Է����ּ��� : ");
	}
	public int inputMessage(Scanner sc) {
		println("������ �Է��մϴ�");
		println("�� ���� ������ �Է��Ͻðڽ��ϱ�?");
		print("�ۼ��ο� : ");
		int inputNumber = 0;
		while(true) {
			try{
				String str = sc.nextLine();
				inputNumber = Integer.parseInt(str); // ����ó��
				break;
			}
			catch(NumberFormatException e) {
				println("�ùٸ� ���ڸ� �Է����ּ���.");
				print("�ۼ��ο� : ");
			}
		}
		println("");
		System.out.printf("%d ���� ������ �Է��մϴ� \n", inputNumber);
		return inputNumber;
	}
	public Student inputStudentScore(Scanner sc) {
		Student student = new Student();
		print("�̸� : ");
		student.name = sc.nextLine();
		print("�������� : ");
		student.koreanScore = Integer.parseInt(sc.nextLine());
		print("�������� : ");
		student.englishScore = Integer.parseInt(sc.nextLine());
		print("�������� : ");
		student.mathScore = Integer.parseInt(sc.nextLine());
		println("---------------------------");
		return student;
	}
	
	public void outputStudentScore(List<Student> list, Model model) {
		println("---------------------------");
		println("�������");
		println("---------------------------");
		for(int i = 0; i < list.size(); i++) {
			println("�л��̸� : " + list.get(i).name);
			println("��ȣ : " + (i+1));
			println("�������� : " + list.get(i).koreanScore);
			println("�������� : " + list.get(i).englishScore);
			println("�������� : " + list.get(i).mathScore);
			println("---------------------------");
		}
		model.averageScore();
		println("�������");
		println("---------------------------");
		println("����������� : " + (model.avrKorScore / list.size()));
		println("����������� : " + (model.avrEngScore / list.size()));
		println("����������� : " + (model.avrMathScore / list.size()));
		println("---------------------------");
	}
	
	public void wrongModeMessage() {
		println("");
		System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		println("");
	}
	
	public void noInformationMessage() {
		println("");
		println("�л� ������ �����ϴ�.");
		println("�л� ������ �Է����ּ���.");
		println("");
	}
	
	public void print(String str) {
		System.out.print(str);
	}
	
	public void println(String str) {
		System.out.println(str);
	}
}
