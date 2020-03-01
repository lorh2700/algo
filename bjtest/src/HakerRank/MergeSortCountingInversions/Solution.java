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
    	
    	result = mergeSort(arr, 0, arr.length -1);
    	
    	return result;

    }

    private static long mergeSort(int[] arr,int startIdx, int endIdx) {
    	
    	if(startIdx == endIdx) {
    		return 0;
    	}
    	
    	int middle = (startIdx + endIdx) /2;
    	//왼쪽
		long elapsedCount1 = mergeSort(arr, startIdx, middle);
		//오른쪽
    	long elapsedCount2 = mergeSort(arr, middle+1, endIdx);
    	//합쳐서 정렬
    	long elapsedCount3 = mergeAndCount(arr, startIdx, endIdx, middle);
    	
    	return elapsedCount1 + elapsedCount2 + elapsedCount3;
    	
	}


	private static long mergeAndCount(int[] arr, int startIdx, int endIdx, int middle) {
		
		int[] tmpArr = new int[endIdx - startIdx + 1 ];
		
		long count = 0;
		
		int left = startIdx;
		int right = middle + 1;
		int curIdx = 0;

		while(left < middle +1 && right < endIdx + 1 ) {
			
			if(arr[left] > arr[right]) {
				tmpArr[curIdx++] = arr[right++];
				count += middle - left + 1;
			} else {
				tmpArr[curIdx++] = arr[left++];
			}
		}

		while(left < middle + 1) {
			tmpArr[curIdx++] = arr[left++];
		}
		
		while(right < endIdx + 1) {
			tmpArr[curIdx++] = arr[right++];
		}
		
		System.arraycopy(tmpArr, 0, arr, startIdx, endIdx - startIdx + 1);
		
//		for(int i = startIdx; i < endIdx+1; i++) {
//			arr[i] = tmpArr[i];
//		}
		
		return count;
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