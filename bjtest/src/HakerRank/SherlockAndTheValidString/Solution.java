
package HakerRank.SherlockAndTheValidString;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
    	
    	char[] textArray = s.toCharArray();
    	int[] countArray = new int[26];
    	
    	Map<Integer, Integer> hm = new HashMap<>();
    	
    	for(char tmp : textArray) {
    		int idx = tmp - 'a';    		
    		countArray[idx] = countArray[idx] + 1;
    	}
    	
    	for(int i = 0; i< 26; i++) {
    		if(countArray[i] > 0) {
    			
    			if(hm.containsKey(countArray[i])) {
    				hm.put(countArray[i], hm.get(countArray[i])+1);
    			} else {
    				hm.put(countArray[i], 1);
    			}
    			
    			if(hm.size() > 2) 
    				return "NO";
    		}
    	}
    	
    	if(hm.size() == 1 ) {
    		return "YES";
    	} else {    		
    		int bigInt = 0;
    		int small = 0;
			//(3,3)(4,1) // yes
			//(3,1)(4,3) //no
    		for(int i : hm.keySet()) {
    			
    			if(i > bigInt) {
    				small = bigInt; 
    				bigInt = i;
    			} else {
    				small = i;
    			}    			    			
    			
				if(i == 1 && hm.get(i) == 1) {					
					return "YES";
				} 
				
    		}
    		
			//(3,3)(4,1) // yes    		
    		//큰것과 작은것의 차이가 1밖에 안나고 큰것의 갯수가 1개만 있는경우     		
    		if( bigInt - small == 1) {
    			if( hm.get(bigInt) == 1) {
    				return "YES";
    			}
    		}
    	}
    	
    	return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);
        
        System.out.println(result);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
