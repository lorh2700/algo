package codingTest.yanolja4;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		int[] A  = {1,7,4,6,3,10,11,13,2};
		
		solution(A);
		
	}
	
	//뒤에서 부터 풀기
    public static int solution2(int[] A) {
       
    	
    	int min = Integer.MAX_VALUE;    	
    	
    	for(int i = 1; i<A.length-2 ; i ++) {    		
    		for(int j = i+2 ; j<A.length-1 ; j++) {    			
    			min = Math.min(min, A[i]+ A[j]);
    		}    		
    	}
        return min;
    }
    
    public static int solution(int[] A) {
        
    	int min = Integer.MAX_VALUE;
    	int jMin = Integer.MAX_VALUE;
    	
    	if(A.length < 5) {
    		return 1;
    	}
    	
    	for(int i = A.length - 4 ; i >= 1 ; i --) {
    		jMin = Math.min(jMin, A[i+2]);    		
    		min = Math.min(min, A[i] + jMin);
    	}
    	
    	System.out.println(min);
    	
    	return min;
    }  

}
