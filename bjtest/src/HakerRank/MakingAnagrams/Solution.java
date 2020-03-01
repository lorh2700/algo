package HakerRank.MakingAnagrams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

    	char[] arrayA = a.toCharArray();
    	char[] arrayB = b.toCharArray();

    	int[] countOfA = new int[27];
    	int[] countOfB = new int[27];
    	
    	int thingsToDelete = 0;
    	
    	for(int i = 0; i < arrayA.length; i++) {
    		char tmp = arrayA[i];
    		int idx = tmp -'a';
    		countOfA[idx] = ( countOfA[idx] == 0 ? 1 : countOfA[idx]+ 1);
    	}

    	for(int i = 0; i < arrayB.length; i++) {
    		
    		char tmp = arrayB[i];
    		int idx = tmp -'a';
    		
    		countOfB[idx ] = ( countOfB[idx ] == 0 ? 1 : countOfB[idx ]+ 1);
    	}
    	
    	for(int i = 0; i < countOfA.length; i++) {
    		
    		int tmpSum = countOfA[i]- countOfB[i];
    		
    		if(tmpSum != 0) {
    			thingsToDelete += Math.abs(tmpSum); 
    		}
    	}
    	
    	return thingsToDelete;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        System.out.println(res);
        
        scanner.close();
    }
}
