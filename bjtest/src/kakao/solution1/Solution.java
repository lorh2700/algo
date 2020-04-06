package kakao.solution1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'splitIntoTwo' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
	
/*	Given an array of integers, determine the number of ways the entire array be split into two non-empty subarrays, left and right, such that the sum of elements in the left subarray is greater than the sum of elements in the right subarray.

	 

	Example

	arr =  [10, 4, -8, 7]

	 

	There are three ways to split it into two non-empty subarrays:

	 

	[10] and [4, -8, 7], left sum = 10, right sum = 3
	[10, 4] and [-8, 7], left sum = 10 + 4 = 14, right sum = -8 + 7 = -1
	[10, 4, -8] and [7], left sum = 6, right sum = 7
	 

	The first two satisfy the condition that left sum > right sum, so the return value should be 2.

*/

    public static int splitIntoTwo(List<Integer> arr) {
    // Write your code here
    	
    	int lSum = arr.get(0); 
    	int rSum = arr.stream().mapToInt(Integer::intValue).sum() - lSum;
    	int result = (lSum > rSum ? 1 : 0);

        for(int i = 1; i < arr.size() - 1; i++ ){
        	lSum = lSum + arr.get(i);
        	rSum = rSum - arr.get(i);
        	if(lSum > rSum ) {
        		result++;
        	}        	
        }
        
        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.splitIntoTwo(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
