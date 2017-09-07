package com.juwon.ctrlflow;
public class TestMain {
	public static void main(String[] args) {
		String str = "A";
		Test t = new Test();
		t.Stage1("A", 5);
		System.out.println();
		t.Stage2("A", 5);
		System.out.println();
		t.Stage3("A", 5);
		System.out.println();
		t.Stage3_5("A", 5);
		System.out.println();
		t.Stage3_6("A", 5);
		System.out.println();
		System.out.println();
		t.Stage3_8("A", 5);
		System.out.println();
		t.Stage4("A", 5);
		System.out.println();		
		t.Stage5("A", 5);
		System.out.println();
		t.Stage5_5("X", 5);
		System.out.println();
		t.Stage5_7("A", 5);
		System.out.println();
		t.Stage6("A", 5);
		System.out.println();
		t.Stage7("A", 5);
	}
}