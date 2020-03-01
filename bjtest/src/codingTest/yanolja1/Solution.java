package codingTest.yanolja1;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		solution(sc.nextInt());
		
		
	}
	
	
    public static void solution(int N) {
        // write your code in Java SE 8
    	
    	String result;
    	    	    	
    	for(int i=1 ; i<= N; i++ ) {
    		
    		result = "";
    		
    		if(i % 2 == 0) {
    			result = "Codility";
    		}
    		
    		if(i % 3 == 0 ) {
    			result = result + "Test";
    		}
    		
    		if(i % 5 == 0 ) {
    			result = result + "Coders";
    		}
    		
    		if("".equals(result)) {
    			result = String.valueOf(i);
    		} 
    		
    		System.out.println(result);
    	}
    	
    }

}
