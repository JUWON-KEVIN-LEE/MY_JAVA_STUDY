package com.juwon.algorithm;

class Solution {
	public static void main(String[] args) {
		int[][] land = {{1,2,3,4}, {100,40,20,30}, {10,4,5,6}, {2,7,5,3},{10,10,10,10}};
		System.out.println(solution(land));
	}
	
    static int solution(int[][] land) {
		int cnt = 5;
        int precnt = 5;
		int sum = 0;
        
		for(int a = 0; a < land.length; a++) {
			int sumE = 0;
			for(int i = 0; i < 4; i++) {
				if(land[a][i] > sumE && i != precnt) {
					sumE = land[a][i];
					cnt = i;
				}
			}
            precnt = cnt;
			sum += sumE;			
		}
		return sum;
    }
}
