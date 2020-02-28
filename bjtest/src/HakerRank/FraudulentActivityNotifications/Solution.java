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
    static int activityNotifications2(int[] expenditure, int d) {
    	
    	
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
    
   static int activityNotifications(int[] expenditure, int d) {
    	
    	
//    	9 5
//    	2 3 4 2 3 6 8 4 5
    	//2
    	int result = 0;

    	for(int i = 0; i < expenditure.length-d; i++) {
    		int tmpMedian = 0;
    		int[] tmpList = new int[d];
    		int max = 0;
    		
    		for(int j = i; j < i + d; j++){
    			if(max < expenditure[j]) {
    				max = expenditure[j];
    			}
    			tmpList[j-i] = expenditure[j];
    		}
    		
    		//계수정렬?
    		
    		tmpMedian = getMedian(tmpList, d, max);
//    		tmpMedian = getMedian(tmpList, d, max);
    		
//    		Arrays.sort(tmpList);
//    		tmpMedian = tmpList[d/2];
    		
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
   
   
//	9 5
//	2 3 4 2 3 6 8 4 5
   private static int getMedian(int[] arr, int d, int max) {
	   
	   //숫자 세서 저장하는 어레이
	   int[] countTmp = new int[max+1];
	   
	   int result = 0;
	   
	   for(int curInt : arr) {
		   countTmp[curInt] += 1;
	   }
	   
	   for(int i = 1; i < countTmp.length; i++) {
		   countTmp[i] += countTmp[i-1];
		   
		   if(d%2 == 0) {
			   if(countTmp[i] >= d/2) {
				   result = i;
				   break;
			   } 
		   }else {
			   if(countTmp[i] >= d/2 + 1) {
				   result = i;
				   break;
			   }
		   }
	   }
	   
	   return result;
   }
   
	static int CalMedian(int[] tmpArr, int d) {
		
		int count = 0;
		int result = 0;
		
		if(d%2 != 0) {
			for(int i = 0 ; i < tmpArr.length ; i++) {
				count += tmpArr[i];
				if(count > d/2) {
					result = i;
					break;
				}
			}

		}else {
			int ftmpC = 0;
			int stmpC = 0;

			for(int i = 0 ; i < tmpArr.length ; i++) {
				count += tmpArr[i];
				if(ftmpC == 0 && count >= d/2) {
					ftmpC = i;
				}

				if(stmpC == 0 && count >= d/2+1) {
					stmpC = i;
					break;
				}

			}
			result = (ftmpC+stmpC) /2;
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

