package cd.nexon.question3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) {
		
		String S = "photo.jpeg, Warsaw, 2013-09-05 14:08:15\r\n" + 
				"john.png, London, 2015-06-20 15:13:22\r\n" + 
				"myFriends.png, Warsaw, 2013-09-05 14:07:13\r\n" + 
				"Eiffel.jpg, Paris, 2015-07-23 08:03:02\r\n" + 
				"pisatower.jpg, Paris, 2015-07-22 23:59:59\r\n" + 
				"BOB.jpg, London, 2015-08-05 00:02:03\r\n" + 
				"notredame.png, Paris, 2015-09-01 12:00:00\r\n" + 
				"me.jpg, Warsaw, 2013-09-06 15:40:22\r\n" + 
				"a.png, Warsaw, 2016-02-13 13:33:50\r\n" + 
				"b.jpg, Warsaw, 2016-01-02 15:12:22\r\n" + 
				"c.jpg, Warsaw, 2016-01-02 14:34:30\r\n" + 
				"d.jpg, Warsaw, 2016-01-02 15:15:01\r\n" + 
				"e.png, Warsaw, 2016-01-02 09:49:09\r\n" + 
				"f.png, Warsaw, 2016-01-02 10:55:32\r\n" + 
				"g.jpg, Warsaw, 2016-02-29 22:13:11";
		
		
		System.out.println(solution(S));
		
	}
	
    public static String solution(String S) {
        // write your code in Java SE 8
    	
    	StringTokenizer st = new StringTokenizer(S, ",\r\n");
   	
    	Map<String, List<Item>> resultMap = new HashMap<String, List<Item>>();  
    	
    	String fileName;
    	String city;
    	String time;
    	int id = 0;
    	
    	while(st.hasMoreElements()) {
    		fileName = st.nextToken().trim();
    		city 	 = st.nextToken().trim();
    		time 	 = st.nextToken().trim();
    		
    		if(!resultMap.containsKey(city)) {
    			List<Item> subList = new ArrayList<Item>();
    			subList.add(new Item(fileName, time, id++));
    			resultMap.put(city, subList);
    		} else {
    			List<Item> subList = resultMap.get(city);
    			subList.add(new Item(fileName, time, id++));
    		}
    	}
    	String[] result = new String[id];   	
    	
    	for( String key : resultMap.keySet() ) {
    		
    		List<Item> list = resultMap.get(key);
    		list.sort(new Comparator<Item>() {
				@Override
				public int compare(Item arg0, Item arg1) {
					return arg0.time.compareTo(arg1.time);
				}
			});
    		
    		int i=1;
    		for(Item item : list) {
				String fileNum = String.valueOf(i++);
				int digit =  String.valueOf(list.size()).length();
				while( fileNum.length() < digit ) {
					fileNum = '0' + fileNum;
				}
								
				item.newFileName = key+fileNum+item.fileName.substring(item.fileName.indexOf("."));
				result[item.id] = item.newFileName;
				
    		}
    	}
    	
    	String resultString = "";
    	
    	for(int i = 0 ; i < result.length; i ++) {
    		if(i == 0) {
    			resultString = resultString + result[i];
    		}else {
    			resultString = resultString + "\r\n" + result[i];
    		}    		
    	}   	
    	
    	return resultString;
    }
    
    static class Item {    	
    
    	String fileName;
    	String newFileName;
    	int id;
    	Date time;
    	SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
    	public Item(String fileName, String time, int id) {
			this.fileName = fileName;			
			try {
				this.time = dt.parse(time);
			} catch (Exception e){
				
			}			
			this.id = id;
		}
    }
}
