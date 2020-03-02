package HakerRank.SpecialStringAgain;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the substrCount function below.
    static long substrCount2(int n, String s) {
    	
    	char[] textArr = s.toCharArray();
    	long count = textArr.length;
//    	7
//    	abcbaba
    	//10
    	
    	//갯수 for문
    	for(int i = 2; i <= textArr.length; i++ ) {
    		//짝수일때는 모두다 같아야 한다
    		
    		//이동 인덱스
    		for(int j = 0; j<textArr.length - i + 1; j++) {    	
    			
		    	HashSet<Character> tmpStack = new HashSet<Character>();

    			//검색 부분
    			for(int k = j; k < j + i; k++) {

    	    		//홀수
    				if( i % 2 == 1) {
    					int mid = (i + 1) / 2;
    					if(k == mid + j-1) {
    						continue;
    					} else {
    						tmpStack.add(textArr[k]);
    					}
    				//짝수 
    				} else {    					
    					tmpStack.add(textArr[k]);    					
    				}

    			}
				
				if(tmpStack.size() == 1) {
					count++;
				}
    		}
    	}
    	
    	return count;
    }
    
    
    
    
    /**
     * 풀이 
     * @param n
     * @param s
     * @return
     */
    
    public static long substrCount(int n, String s) {
        
    	int result = 0; 
        
        // it will store the count  
        // of continues same char 
        int[] sameChar = new int[n];
      
        int i = 0; 
      
        // traverse string character 
        // from left to right 
        while (i < n) { 
      
            // store same character count 
            int sameCharCount = 1; 
      
            int j = i + 1; 
      
            // count smiler character 
            while (j < n &&  
                s.charAt(i) == s.charAt(j)) 
            { 
                sameCharCount++; 
                j++; 
            } 
      
            // Case : 1 
            // so total number of  
            // substring that we can 
            // generate are : K *( K + 1 ) / 2 
            // here K is sameCharCount 
            result += (sameCharCount *  
                      (sameCharCount + 1) / 2); 
      
            // store current same char  
            // count in sameChar[] array 
            sameChar[i] = sameCharCount; 
      
            // increment i 
            i = j; 
        } 
      
        // Case 2: Count all odd length 
        //           Special Palindromic 
        //           substring 
        for (int j = 1; j < n; j++) { 
            // if current character is  
            // equal to previous one  
            // then we assign Previous  
            // same character count to 
            // current one 
            if (s.charAt(j) == s.charAt(j - 1)) 
                sameChar[j] = sameChar[j - 1]; 
      
            // case 2: odd length 
            if (j > 0 && j < (n - 1) && 
            (s.charAt(j - 1) == s.charAt(j + 1) && 
                 s.charAt(j) != s.charAt(j - 1))) 
                result += Math.min(sameChar[j - 1], 
                                   sameChar[j + 1]); 
        } 
      
        // subtract all single  
        // length substring 
        return result; 
    	
    }
   
    
    
    ////

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);
        
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
