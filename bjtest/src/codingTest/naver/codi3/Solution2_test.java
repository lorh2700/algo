package codingTest.naver.codi3;

public class Solution2_test {
	
	public static void main(String[] args) {		
		//int[][] arr = {{4,3,4,5,3}, {2,7,3,8,4}, {1,7,6,5,2}, {8,4,9,5,5}};
		//int[][] arr = {{7,2,4},{2,7,6},{9,5,1},{4,3,8},{3,5,4}};
		//int[][] arr = {{2,2,1,1},{2,2,2,2},{1,2,2,2}};
		int[][] arr = {{2,2,1,1}};
		System.out.println(solution(arr));
	}
	
	public static int solution(int[][] A) {
		int N = A.length;
		int M = A[0].length;
		
		System.out.println("arr: "+N+" X "+M);
		
		
		int K = Math.min(N, M);
		for(int k=K; k>=2; k--) {
			System.out.println("->"+k+" x "+k);
			
			for(int i=0; i+k<=N; i++) {
				for(int j=0; j+k<=M; j++) {
					System.out.println(i+","+j);
					if(isMagicSquare(A, i, j, k)) {
						return k;
					}
				}
				System.out.println();
			}
		}
		return 1;
	}
	
	// N,M >= 2
	public static boolean isMagicSquare(int[][] arr, int n, int m, int k) {
		System.out.println("체크시작");
		System.out.println("i :"+n+"~"+(n+k-1));
		System.out.println("j :"+m+"~"+(m+k-1));
		
		/* 대각선 체크 */
		int BASE = 0;
		for(int w=0; w<k; w++) {
			BASE += arr[n+w][m+w];
		}
		System.out.println("###BASE="+BASE);
		
		int sum = 0;
		for(int w=0; w<k; w++) {
			sum += arr[n+w][m+k-w-1];
		}
		System.out.println("###대각선2="+sum);
		if(sum != BASE) return false;
		
		
		/* 가로 체크 */
		for(int i=n; i<n+k; i++) {
			sum = 0;
			for(int j=m; j<m+k; j++) {
				System.out.println("가로-"+i+","+j);
				sum += arr[i][j];
			}
			System.out.println("###가로"+sum);
			if(sum != BASE) return false;
		}
		
		
		/* 세로 체크 */
		for(int j=m; j<m+k; j++) {
			sum = 0;
			for(int i=n; i<n+k; i++) {
				System.out.println("세로-"+i+","+j);
				sum += arr[i][j];
			}
			System.out.println("###세로"+sum);
			if(sum != BASE) return false;
		}
		
		return true;
	}

}
