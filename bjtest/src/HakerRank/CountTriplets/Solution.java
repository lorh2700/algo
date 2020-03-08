package HakerRank.CountTriplets;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countTriplets function below.
	//4 2
	//1 2 2 4
	//2
	//6 3
	//1 3 9 9 27 81
	//6
    static long countTriplets2(List<Long> arr, long r) {
    	
    	long result = 0;
    	int sizeLimit = arr.size();
    	
    	for(int i = 0; i < arr.size(); i++) {
    		
    		long startValue = arr.get(i);
    		
    		//끝 인덱스 확인
    		if(i+1 > sizeLimit)
    			break;
    		
			for(int j = i+1; j < arr.size(); j ++) {    				
				//middel 확인
    			if(arr.get(j) == startValue * r) {
    				
    				long middleValue = arr.get(j);
    				
    				if(j+1 > sizeLimit) 
    					break;
    				
    				for(int k = j + 1; k < arr.size(); k++) {
    					
    					//last 확인
    					if(arr.get(k) == middleValue * r) {
    						System.out.println(startValue + " , " +middleValue+" , "+ arr.get(k));    						
    						result++;
    					}
    					
    					if(arr.get(k) > middleValue * r ) {
    						break;
    					}
    				}
    			}
    		}
    		    		
    	}    	
    	
    	return result;
    }
    
    
//    6 3
//    1 3 9 9 27 81
    //6
    static long countTriplets(List<Long> arr, long r) {
    	
    	long result = 0;
    	long now = 0;
    	
    	HashMap<Long, Long> middle = new HashMap<>();
        HashMap<Long, Long> last = new HashMap<>();        

        for(int i = 0 ; i < arr.size() ; i++) {
        	now = arr.get(i);
        	
        	System.out.println("\n 현재 값: "+ now);
        	
        	System.out.println("last 체크 " + last.getOrDefault(now, 0L));
        	result+= last.getOrDefault(now, 0L);   
        	System.out.println("result = "+result);
        	
        	if(middle.containsKey(now)) {
        		System.out.println("*** Middle에 있음");
        		System.out.println("[last put] key = "+now*r+", value = "+last.getOrDefault(now*r, 0L) + middle.get(now));
        		last.put( now*r, last.getOrDefault(now*r, 0L) + middle.get(now));
        		System.out.println("라스트 값 : " + last.toString());
        	}           

        	System.out.println("[mid put] key = "+now*r+", value = "+(middle.getOrDefault(now*r, 0L) + 1));
        	middle.put(now*r, middle.getOrDefault(now*r, 0L) + 1);
        	System.out.println(" 미들 값 : " + middle.toString());
        }
    	
    	return result;
    }
    
    

    public static void main(String[] args) throws IOException {
    	System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr.add(arrItem);
        }

        long ans = countTriplets(arr, r);
        
        System.out.println(ans);

//        bufferedWriter.write(String.valueOf(ans));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
