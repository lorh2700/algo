package cd.nexon.question5;

public class Solution {
	
	
	public static void main(String[] args) {
	
		
		int[] s = {-4,-3,-2,-1};
		
		System.out.println(solution(s, -3));
		
	}
	
	  static int solution(int[] A, int X) {
	        int N = A.length;
	        if (N == 0) {
	            return -1;
	        }
	        int l = 0;
	        int r = N - 1;
	        while (l < r) {
	            int m = (l + r + 1) / 2;
	            if (A[m] > X) {
	                r = m - 1;
	            } else {
	                l = m;
	            }
	        }
	        if (A[l] == X) {
	            return l;
	        }
	        return -1;
	    }
}
