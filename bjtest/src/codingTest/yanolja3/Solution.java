package codingTest.yanolja3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
				
		System.out.println(solution("(()))(()()())))"));		
	}
	
	
/*  public static int solution(String S) {
        int K = 0;
        int l = 0;
        int r = S.length() - 1;
        
        char[] chars = S.toCharArray();
        
        
        while(l < r) {
        	 while( l < S.length() && chars[l] != '(' ) {
             	l++; 
             	K++;
             	
             }
             while( r >= 0 && chars[r] != ')' ) {
             	r--;
             }
             
             if(l < r) {
            	 K++;
            	 l++; 
            	 r--;
            	 
             }else if( r < l) {
            	 K = r + 1;
             }
        }
        
        return K;
    }*/

	public static int solution2(String S) {
		
		
		int len = S.length(); 
        int open[] = new int[len+1]; 
        int    close[] = new int[len+1]; 
        int index = -1; 
       
        open[0] = 0; 
        close[len] = 0; 
        if (S.charAt(0)=='(') 
            open[1] = 1; 
        if (S.charAt(len-1) == ')') 
            close[len-1] = 1; 
       
        // Store the number of opening brackets 
        // at each index 
        for (int i = 1; i < len; i++) 
        { 
            if ( S.charAt(i) == '(' ) 
                open[i+1] = open[i] + 1; 
            else
                open[i+1] = open[i]; 
            
            
        } 
        
        System.out.println(Arrays.toString(open));
       
        // Store the number of closing brackets 
        // at each index 
        for (int i = len-2; i >= 0; i--) 
        { 
            if ( S.charAt(i) == ')' ) 
                close[i] = close[i+1] + 1; 
            else
                close[i] = close[i+1]; 
        } 
        
        System.out.println(Arrays.toString(close));

       
        // check if there is no opening or closing 
        // brackets 
        if (open[len] == 0) 
            return len; 
        if (close[0] == 0) 
            return 0; 
      
        // check if there is any index at which 
        // both brackets are equal 
        for (int i=0; i<=len; i++) 
            if (open[i] == close[i]) 
                index = i; 
       
        return index;		
	}
	
	
	public static int solution(String S) {
	
		char[] str = S.toCharArray();
		int result = 0;
		int x = 0;
		int y = S.length()-1;
		
		while(x <= y) {
			while( x < S.length() && str[x] == ')' && x <= y) {
				x++;
				result++;
			}
			while( y >= 0 && str[y] == '(' && x <= y) y--;
			
			if( x > y ) break;
			System.out.println("x : "+x+", y : "+y);
			
			x++;
			y--;
			result ++;
		}	
        return result;		
	}
	

	
}
