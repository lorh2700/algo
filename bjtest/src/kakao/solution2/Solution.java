package kakao.solution2;

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
	
	/*	A web developer has set up a local web host on a low-power, single-board computer. The computer also hosts a media server that has a higher priority. Each second of time that the web host has priority, it responds to at most 5 requests and deletes them from the queue. Requests are served on a last in, first out basis. Given a list of times that the web host has priority, determine the total number of requests that are served.

	 

	Example:

	There are a total of n = 6  requests received

	timestamp = [0, 1, 1, 2, 4, 5]

	top = [5]

	 

	The web server has priority one time at top = 5.  It can respond to the latest 5 requests through the 5th second of time. Those were received from timestamp[1] through timestamp[5].  The request from timestamp[0] is ignored. The total number of requests served is 5.

	 

	Note:

	    

	The server may have priority multiple times in a second.
	The arrays timestamp and top may not be in sorted order.
	 

	Function Description

	Complete the function requestsServed in the editor below. The function should return an integer that denotes the total number requests served.

	 

	requestsServed has the following parameters:

	timestamp[timestamp[0],...timestamp[n-1]]: An array of integers that represent the seconds after time = 0 that the requests arrive
	top[top[0]...top[m-1]]:  An array of integers that represent the seconds after time = 0 that the server has priority
	 

	Constraints

	1 ≤ n ≤ 105
	1 ≤ m ≤ 30
	0 ≤ timestamp[i]  < 60
	0 ≤ top[j]  < 60*/
	
	

    /*
     * Complete the 'requestsServed' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY timestamp
     *  2. INTEGER_ARRAY top
     */

	public static int search(List<Integer> a, int n, int key) {
		int idx = 0;
		
		for(int val : a) {
			if(val > key) return idx;
			idx++;
		}
		
		return idx;
	}
	
    public static int requestsServed(List<Integer> timestamp, List<Integer> top) {
    	// Write your code here
    	//int[] arr = timestamp.toArray(new int[timestamp.size()]);
    	Collections.sort(timestamp);
    	
    	System.out.println(timestamp);
    	System.out.println(top);
    	
    	int[] live = new int[timestamp.size()];
    	Arrays.fill(live, 1);
    	
    	int result = 0, cnt = 0, r;
    	for(int i=0; i<top.size(); i++) {
    		System.out.println(">> ");
    		r = search(timestamp, timestamp.size(), top.get(i));
    		
    		System.out.println("t: "+top.get(i)+" ,r: "+r);
    		
    		cnt = 0;
    		for(int j=r-1; j>=0 & cnt<5; j--) {
    			System.out.print("j: "+j+", val: "+timestamp.get(j));
    			if(live[j] == 1) {
    				result++; 
    				live[j] = 0;
    				cnt++;
    				System.out.print("=> OK");
    			}
    			System.out.println();
    		}
    	}
    	
    	return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
    	List<Integer> timestamp = Arrays.asList(0,1,1,2,4,5);
    	List<Integer> top = Arrays.asList(5);
    	
    	//List<Integer> timestamp = Arrays.asList(1,2,2,3,4,5,6,6,13,16);
    	//List<Integer> top = Arrays.asList(10,15);
    	
        System.out.println(Result.requestsServed(timestamp, top));
    }
}
