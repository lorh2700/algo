package HakerRank.NewYearsChaos;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
    	
    	int bribe = 0;
    	int[] tmpArr = new int[q.length];
    	
    	for(int i = 0; i < q.length; i++) {
    		tmpArr[i] = i+1;
    	}
    	
    	for(int i = 0; i <q.length; i++) { 
    		
    		if(tmpArr[i]!=q[i]) {
    			int movingIdx = 0;
    			
    			for(int j=i; j<tmpArr.length; j++) {
    				if(tmpArr[j] == q[i] ) {
    					movingIdx = j;
    					break;
    				}
    			}
    			
    			int limitCount = 0;
    			
    			while(true) {    				
    				if(limitCount > 1) {
    					System.out.println("Too chaotic");
    					return;
    				}
    				
    				bribe++;
    				
    				//swap
    				int preValue = tmpArr[movingIdx - 1 - limitCount];
    				tmpArr[movingIdx - 1 - limitCount] = tmpArr[movingIdx - limitCount];
    				tmpArr[movingIdx - limitCount] = preValue;
    				
    				if(tmpArr[i]==q[i]) {
    					break;
					}
    				limitCount++;    				
    			}
    		}
    	}
    	
    	System.out.println(bribe);
    }
//    2
//    5
//    2 1 5 3 4
//    5
//    2 5 1 3 4
    
   

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
