package codingTest.naver.codi1;

public class Solution {
	
	public static void main(String[] args) {
		
		int a = 78;
		int b = 195378678;
		
		System.out.println(solution(a, b));
		
		
	}
	
    public static int solution(int A, int B) {
    	
    	String strA = String.valueOf(A);
    	String strB = String.valueOf(B);
    	
    	int resultIdx = strB.indexOf(strA);
    	
    	return resultIdx;    	
    }

}
