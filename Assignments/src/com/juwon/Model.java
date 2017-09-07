package com.juwon.assignment;

import java.util.*;

public class Model {
	List<Student> list = new ArrayList<>();
	
	static int avrKorScore = 0;
	static int avrEngScore = 0;
	static int avrMathScore = 0;
	
	public void inputStudentScore(Student student) {
		student.index = list.size() + 1;
		list.add(student);
	}
	
	public void averageScore() {
		for(int i = 0; i < list.size(); i++) {
			avrKorScore += list.get(i).koreanScore;
			avrEngScore += list.get(i).englishScore;
			avrMathScore += list.get(i).mathScore;
		}
		System.out.println(list.size());
	}
}
