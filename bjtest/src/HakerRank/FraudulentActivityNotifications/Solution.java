package HakerRank.FraudulentActivityNotifications;

import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
    	
    	
//    	9 5
//    	2 3 4 2 3 6 8 4 5
    	//2
    	int result = 0;
    	
    	for(int i = 0; i < expenditure.length-d; i++) {
    		
    		int tmpMedian = 0;
    		
    		int[] tmpList = new int[d];
    		
    		for(int j = i; j < i + d; j++){
    			tmpList[j-i] = expenditure[j];
    		}
    		
    		Arrays.sort(tmpList);
    		
    		tmpMedian = tmpList[d/2];
    		
//    		tmpMedian = tmpMedian / d;
    		
    		if(i+ d >= expenditure.length) {
    			break;
    		} else {
    			if(expenditure[i+d] >= tmpMedian * 2) {
    				result++;
    			}
    		}
    		
    	}
    	
		return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);
        
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}

