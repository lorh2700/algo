package codingTest.naver.codi2;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println(solution("zzz"));
		
	}
	
	public static int solution(String S) {
		int[] arr = new int[26]; 
		for(char alpa : S.toCharArray()) {
			arr[ alpa - 'a' ]++;
		}
		
		int result = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > 0 && arr[i] % 2 == 1) {
				result++;
			}
		}
		
		return result;
	}


}
