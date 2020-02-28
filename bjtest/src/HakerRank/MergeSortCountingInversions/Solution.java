package HakerRank.MergeSortCountingInversions;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countInversions function below.
//	2  
//	5  
//	1 1 1 2 2  
//	5  
//	2 1 3 1 2
	
	//out
//	0  
//	4
	
    static long countInversions(int[] arr) {
    	
    	long result = 0;
//    	
//    	int idx = 0;
//    	
//    	for(int i = 1; i < arr.length; i++) {
//    		
//    		if(arr[i-1] > arr[i]) {
//    			
//    			//swap
//    			int tmp = arr[i-1];
//    			arr[i-1] = arr[i];
//    			arr[i] = tmp;
//    			result++;
//    			
//    		}
//    	}
    	
    	mergeSort(arr, 0, arr.length);
    	
    	return result;

    }
    
    
    

    private static void mergeSort(int[] arr,int startIdx, int endIdx) {
    	
    	int middle = startIdx + endIdx /2;
    	
		mergeSort(arr, startIdx, middle);
    	mergeSort(arr, middle, endIdx);
    	merge(arr, startIdx, endIdx);
    	
	}




	private static void merge(int[] arr, int startIdx, int endIdx) {
		
		int mid = (startIdx + endIdx) / 2;
		
		int[] newArr = new int[endIdx - startIdx + 1 ];
		
		if(arr[startIdx] > arr[endIdx] ) {
			int tmp = arr[startIdx];
			arr[startIdx] = arr[endIdx];
			arr[endIdx] = tmp;			
		}
		
		
	}




	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);
            
            System.out.println(result);

//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}