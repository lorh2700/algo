package codingTest.yanolja2;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		solution(sc.nextInt());
		
		int[] A  = {-3,2,1,4,4,5};
//		int[] A  = {-3,-3};
		System.out.println(solution(A));
		
	}
	
	
    public static int solution(int[] A) {
        // write your code in Java SE 8
    	
    	int pre = A[0];
    	int result = 1;
    	
    	int INIT = 0;
    	int UP = 1;
    	int DOWN = 2;
    	
    	int state = INIT; // 0 초기 1 up 2 down
    	int preState = INIT; // 0 초기 1 up 2 down
    	   	
    	
    	for(int i = 1 ; i < A.length ; i++) {
    		if( pre == A[i] )  continue;
    		
    		state = (pre < A[i]) ? UP : DOWN ;
    		
    		if( state != preState) {
    			result++;  			
    		}
    		
    		preState = state;
    		pre = A[i];    		
    	}
    	
    	return result;  
    }

}
