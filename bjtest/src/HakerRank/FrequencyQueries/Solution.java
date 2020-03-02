package HakerRank.FrequencyQueries;

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

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<int[]> queries) {
    	
    	List<Integer> result = new ArrayList<Integer>();
    	HashMap<Integer, Integer> store = new HashMap<Integer, Integer>();
    	HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
    	
    	for(int[] list : queries) {
    		
    		int order = list[0];
    		int tmp = list[1];
    		
    		if( order== 1) {
    			
				//해당값을 있던곳에 추가
    			if(store.containsKey(tmp) ) {
    				store.put(tmp, store.get(tmp) + 1);

    				//count 값을 저장하는데 기존의 값을 지우고 새로운 값으로 업데이트 시켜주기 위하여 기존값을 삭제
    				if(count.getOrDefault(store.get(tmp) - 1, 0) > 1) {
    					count.put(store.get(tmp) - 1, count.get(store.get(tmp) - 1) - 1);
    				} else {
    					count.remove(store.get(tmp) - 1);
    				}  
    				
				//해당값을 초기에 추가	
    			} else {
    				store.put(tmp, 1);
    			}
    			
    			//count 맵에 해당 갯수 추가 
    			if(count.containsKey(store.get(tmp))) {
    				count.put(store.get(tmp), count.get(store.get(tmp)) + 1);
    			} else {
    				count.put(store.get(tmp), 1);
    			}
    			
    		} else if( order== 2) {
    			
    			//count 맵에 해당 갯수 빼기
    			if(store.containsKey(tmp) && count.containsKey(store.get(tmp))) {
    				if(count.getOrDefault(store.get(tmp), 0) > 1) {
    					count.put(store.get(tmp), count.get(store.get(tmp)) - 1);
    				}else {
    					count.remove(store.get(tmp));
    				}    				
    			}
    			
    			if(store.containsKey(tmp) && store.get(tmp) > 1) {
    				store.put(tmp, store.get(tmp) -1);
    			} else {
    				store.remove(tmp);
    			}
    			
    		} else if( order== 3) {    			
    			if( count.containsKey(tmp)) {
    				result.add(1);
    			} else {
    				result.add(0);
    			}
    		}
    	}
    	
    	return result;
    	
    }

    public static void main(String[] args) throws IOException {
    	try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
    	      int q = Integer.parseInt(bufferedReader.readLine().trim());
    	      List<int[]> queries = new ArrayList<>(q);
    	      Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
    	      for (int i = 0; i < q; i++) {
    	        int[] query = new int[2];
    	        Matcher m = p.matcher(bufferedReader.readLine());
    	        if (m.matches()) {
    	          query[0] = Integer.parseInt(m.group(1));
    	          query[1] = Integer.parseInt(m.group(2));
    	          queries.add(query);
    	        }
    	      }
    	      List<Integer> ans = freqQuery(queries);
    	      
    	      System.out.println(ans.stream().map(Object::toString).collect(joining("\n"))+"\n");
    	      
//    	      try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
//    	        bufferedWriter.write(
//    	                ans.stream()
//    	                        .map(Object::toString)
//    	                        .collect(joining("\n"))
//    	                        + "\n");
//    	      }
    	    }
    }
}
