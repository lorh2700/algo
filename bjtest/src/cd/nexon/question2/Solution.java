package cd.nexon.question2;

public class Solution {

	public static void main(String[] args) {

		System.out.println(solution("011100"));
		
	}	
	
    public static int solution(String S) {
        // write your code in Java SE 8
    	int number = 0;    
    	int square = 1;
    	
    	for(int i = S.length() - 1 ; i >= 0; i--) {
    		
    		if( S.charAt(i) == '1') {
    			number = number + square;
    		}    		
    		square = square * 2;    		
    	}
    	System.out.println("number : "+number);
    	
    	int count 	= 0;
    	
    	while( 0 < number ) {
    		
    		if( number % 2 == 1) {
    			number = number -1;
        	} else {
        		number = number / 2;
        	}
    		count ++;
    	}
    	
    	return count;
    	
    }

}
