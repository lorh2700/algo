package codingTest.woowa.test1;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println(solution("011100"));
		
	}
	
    public static int solution(String S) {
    	int count = 0;
    	
    	int startIndex = 0;
    	for(; startIndex<=S.length(); startIndex++) {
    		if(S.charAt(startIndex) == '1') break;
    	}
    	
    	for(int i=S.length()-1; i>=startIndex; i--) {
    		if(S.charAt(i) == '0') {
    			count+=1;
    		}else {
    			count+=2;
    		}
    	}
    	
    	return count -1;
    }
}
