package cd.nexon.question1;

import java.util.Arrays;

class Solution {
	
	
	public static void main(String[] args) {
		
		int[] arr = {-1, -3,2,3,5,7,8} ;
		
		System.out.println(solution(arr));
		
	}
	
	
	//연속된 숫자에서 
    public static int solution(int[] A) {
        // write your code in Java SE 8
        
    	Arrays.sort(A);
    	
    	System.out.println(Arrays.toString(A));
    	
    	int idx = 0;
    	
    	while(idx< A.length && A[idx] < 0) idx ++;
    	
    	if( idx == A.length ) {
    		return 1;
    	}
    	    	    	
    	int pre 	= A[idx];    	
    	idx++;
    	
    	while(idx < A.length) {
    		
    		if( 1 < (A[idx] -  pre) ) {
    			break;
    		}    		
    		
    		pre = A[idx];
    		
    		idx++;
    	}
    	
        return pre + 1;
        
    }
}