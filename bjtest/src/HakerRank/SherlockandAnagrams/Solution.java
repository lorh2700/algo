package HakerRank.SherlockandAnagrams;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
    	
        int result = 0;

        for(int i=0; i<s.length()-1; i++) {
            int stringLength = 1;

            for(int j=i; j<s.length()-1; j++) {

                LinkedList<String> perCharacter = new LinkedList<>();

                for(int k=i; k<i+stringLength; k++){
                    perCharacter.add(String.valueOf(s.charAt(k)));
                }

                for(int k=i+1; k<s.length(); k++){
                    boolean matchFlag = true;
                    LinkedList<String> dummyCharacter = new LinkedList<>();

                    if(k+stringLength > s.length()){
                        break;
                    }

                    for(int l=0; l<perCharacter.size(); l++) {
                        dummyCharacter.add(perCharacter.get(l));
                    }

                    for(int l=k; l<k+stringLength; l++) {
                        String comparingChar = String.valueOf(s.charAt(l));

                        if(dummyCharacter.contains(comparingChar)) {

                            dummyCharacter.remove(comparingChar);
                        }
                        else {
                            matchFlag = false;
                            break;
                        }
                    }

                    if(matchFlag){
                        result++;
                    }

                }
                stringLength++;

            }

        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            System.out.println(result);
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
