package com.juwon.ctrlflow;

public class Test {
	public static void print(String str, int index) {
		for(int i = 0; i < index; i++)
			System.out.print(str);
	}
	
	public void Stage1(String str, int lines) {
		for(int index = 0; index < lines; index++) {
			for(int innerIndex = 0; innerIndex < index + 1; innerIndex++)
				System.out.print(str);
			System.out.println();
		}
	}
	
	public void Stage2(String str, int lines) {
		for(int index = 0; index < lines; index++) {
			print(" ", lines - (index + 1));
			print(str, index + 1);
			System.out.println();
		}
	}
	
	public void Stage3(String str, int lines) {
		for(int index = 0; index < lines; index++) {
			print(" ", (lines - (index + 1)));
			print(str, 2*index + 1);
			print(" ", (lines - (index + 1)));
			System.out.println();
		}
	}
	
	public void Stage3_5(String str, int lines) {
		print(" ", lines-1);
		System.out.println(str);
		for(int index = 1; index < lines; index++) {
			print(" ", (lines - (index + 1)));
			System.out.print(str);
			print(" ", 2 * index - 1);
			System.out.print(str);
			System.out.println();
		}
	}
	
	public void Stage3_6(String str, int lines) {
		print(" ", lines-1);
		System.out.println(str);
		for(int index = 1; index < lines-1; index++) {
			print(" ", (lines - (index + 1)));
			System.out.print(str);
			print(" ", 2 * index - 1);
			System.out.print(str);
			System.out.println();
		}
		print(str,lines*2-1);
	}
	
	public void Stage3_8(String str, int lines) {
		for(int index = 0; index < lines; index++) {
			print(" ", (lines - (index + 1)));
			print(str, 2*index + 1);
			print(" ", (lines - (index + 1)));
			System.out.println();
			
			if(index == lines - 1) {
				for(int reverse = index - 1; reverse >= 0; reverse--) {
					print(" ", lines - (reverse + 1));
					print(str, 2 * reverse + 1);
					print(" ", lines - (reverse + 1));
					System.out.println();
				}
			}
		}
	}
	
	public void Stage4(String str, int lines) {
		for(int index = 0; index < lines; index++) {
			print(" ", (lines - (index + 1)));
			if(index == 0)
				System.out.print(str);
			else
				print(str + " ", index + 1);
			System.out.println();
			if(index == lines - 1) {
				for(int reverse = index - 1; reverse >= 0; reverse--) {
					print(" ", lines - (reverse + 1));
					print(str, 2 * reverse + 1);
					print(" ", lines - (reverse + 1));
					System.out.println();
				}
			}
		}
	}
	
	public void Stage5(String str, int lines) {
		for(int index = 0; index < lines; index++) {
			print(" ", (lines - (index + 1)));
			if(index == 0)
				System.out.print(str);
			else {
				System.out.print(str);
				print(" ", 2 * index - 1);
				System.out.print(str);
			}
			System.out.println();
			
			if(index == lines - 1) {
				for(int reverse = index - 1; reverse >= 0; reverse--) {
					print(" ", (lines - (reverse + 1)));
					if(reverse == 0)
						System.out.print(str);
					else {
						System.out.print(str);
						print(" ", 2 * reverse - 1);
						System.out.print(str);
					}
					System.out.println();
				}
			}
		}
	}
	
	public void Stage5_5(String str, int lines) {
		for(int index = 0; index < lines; index++) {
			print(" ", index);
			if(index != lines - 1) {
				System.out.print(str);
				print(" ", 2*lines -1 -2*(index + 1));
				System.out.print(str);
			}
			else 
				System.out.print(str);
			System.out.println();
			
			if(index == lines - 1) {
				for(int reverse = index - 1; reverse >= 0; reverse--) {
					print(" ", reverse);
					System.out.print(str);
					print(" ",2*lines -1 -2*(reverse + 1));
					System.out.print(str);
					print(" ", reverse);
					System.out.println();
				}
			}
		}
	}
	
	public void Stage5_7(String str, int lines) {
		for(int index = 0; index < 2*lines; index++) {
			if(index == 0 || index==2*lines-1) {
				for(int count = 0; count < 2*lines - 1; count++)
					System.out.print(str);
				System.out.println();
			}
			else {
				System.out.print(str);
				print(" ", 2*lines - 3);
				System.out.print(str);
				System.out.println();
			}
		}
	}
	
	public void Stage6(String str, int lines) {
		int count = 0;
		for(int index = lines; index > 0; index--) {
			if(index < lines) {
				count += index;
				print(" ", count);
			}
			for(int innerIndex = 0; innerIndex < index - 1; innerIndex++) {
				System.out.print(str);
				print(" ", index - 1);
			}
			System.out.println(str);
		}
	}
	
	public static int sum(int num) {
		int sum = 0;
		for(int i = num; i > 0; i--) {
			sum += i;
		}
		return sum;
	}
	
	public void Stage7(String str, int lines) {
		int count = 0;
		for(int index = lines; index > 0; index--) {
			print(" ", sum(index - 1));
			System.out.print(str);
			if(index == lines)
				print(" ", lines);
			else {
				count += sum(index) - sum(index-1);
				print(" ", lines + 2*count);
			}
			System.out.print(str);
			System.out.println();
		}
	}
}