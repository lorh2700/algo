package cd.nexon.question4;

import java.util.HashSet;

public class Solution {
	
	public static void main(String[] args) {

		int[] a = {40, 40, 100, 80,20};
		int[] b = {3, 3, 2, 2,3};
		
//		int[] a = {60, 80, 40};
//		int[] b = {2, 3, 5};
		
		System.out.println(1/2);
		
		System.out.println(solution(a, b, 5, 2, 200));
	}

    public static int solution(int[] A, int[] B, int M, int X, int Y) {
        // write your code in Java SE 8
    	
    	int result = 0;
    	
    	HashSet<Integer> hs = new HashSet<Integer>();
    	
    	int weight = 0;
    	int people = 0;    	
    	
    	int tmp = 0;
    	
    	for(int i = 0 ; i < A.length; i++) {
    		System.out.println(tmp++);
    		//
    		if(Y < (weight+A[i]) || X < (people+1)) {
    			result = result + hs.size() + 1;
    			hs.clear();        	
    			weight = 0;
    			people = 0;
    		}
    		
			weight+= A[i];
    		people++;
    		hs.add(B[i]);
    		
    	}
    	
    	System.out.println("result :"+ result + " hs size : " + hs.size());
    	
    	result = result + hs.size() + 1;
    	
    	return result;
    }
	
}
