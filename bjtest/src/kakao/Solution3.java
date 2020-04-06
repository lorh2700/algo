package kakao;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'segment' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER x
     *  2. INTEGER_ARRAY arr
     */
	
/*	You are at the grocery store trying to determine which cereal to buy. There is a row of different cereal brands in front of you, represented as an n-element array.

	 

	You would like to find a cereal that is not too pricey but also not the most inexpensive. To do this, you scan every subarray of size x, starting from index 0. Subarrays are to be contiguous blocks of elements in the inclusive range from index i to index j, where j − i + 1 = x and 0 ≤ i ≤ j < n. Then, among each of these subarrays, find the cereal with the minimum price. Return the value of the maximum among these.

	 

	For example, given array arr=[8, 2, 4], the subarrays of size x = 2 would be [8, 2] and [2, 4]. The minimum values of the two subarrays are [2, 2]. The maximum of those two minimum values is 2. This is the value you need to determine, which represents the price of the cereal you decide to purchase.

	 

	Function Description 

	Complete the function segment in the editor below. Your function must find the minimum value for each subarray of size x in array arr, then return an integer denoting the maximum of these minima.

	 

	segment has the following parameter(s):

	    x:  an integer, the segment length

	    arr[arr[0],...arr[n-1]]:  an array of integers

	 

	Constraints

	1 ≤ n ≤ 106
	1 ≤ arr[i] ≤ 109
	1 ≤ x ≤ n
*/

    public static int segment(int x, List<Integer> arr) {
    	// Write your code here
    	int tree[] = new int[2097153];
    	int N = arr.size();
    	
    	int leaf_node_start = 1;
		for(; leaf_node_start < N; leaf_node_start=leaf_node_start*2);
		//System.out.println("leaf_node: "+leaf_node_start);
    	
		for(int i=0; i<N; i++) {
			tree[i + leaf_node_start] = arr.get(i);
		}
		
		for(int i=leaf_node_start-1; i>=1; i--) {
			tree[i] = Math.min(tree[i*2], tree[i*2+1]);
		}
		
		for(int i=1; i<15; i++) {
			System.out.print(tree[i]+" ");
		}
		//System.out.println();
		
		int MIN, MAX=0, l, r;
		for(int i=0; i<=N-x; i++) {
			MIN = Integer.MAX_VALUE;
			
			l = i + leaf_node_start; 
			r = l + x - 1;
			
			//System.out.println("l:"+l+", r:"+r);
			
			while( l <= r ) {
				if(l%2 == 1) MIN = Math.min(tree[l], MIN);
				if(r%2 == 0) MIN = Math.min(tree[r], MIN);
				
				l = (l+1)/2;
				r = (r-1)/2;
			}
			
			//System.out.println(MIN);
			MAX = Math.max(MIN, MAX);
		}
		
		
    	return MAX;
    }

}

public class Solution3 {
    public static void main(String[] args) throws IOException {
    	List<Integer> arr = new ArrayList<Integer>();
    	arr.add(1); arr.add(2); arr.add(3); arr.add(1); arr.add(2);
    	System.out.println(Result.segment(1, arr));

    	
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int x = Integer.parseInt(bufferedReader.readLine().trim());

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

        int result = Result.segment(x, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
