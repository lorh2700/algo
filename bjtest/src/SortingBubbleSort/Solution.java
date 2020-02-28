package SortingBubbleSort;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
    	
    	int swapCount = 0;
    	
    	for(int i = 0; i < a.length; i++) {
    		
    		for(int j = 0; j < a.length - i -1; j++) {
    			if(a[j] > a[j+1]){
    				swap(a, j);
    				swapCount++;
    			}
    		}
    		
    	}
    	
    	System.out.println("Array is sorted in "+ swapCount+" swaps.");
    	System.out.println("First Element: "+a[0]);
    	System.out.println("Last Element: "+ a[a.length-1]);
    	
    }
    
    static void swap(int[] arr, int idx) {
    	
    	int tmp = arr[idx];
    	arr[idx] = arr[idx+1];
    	arr[idx+1] = tmp;  
    	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);
        
        System.out.println(Arrays.toString(a));

        scanner.close();
    }
}
