package tmon2;

public class test {
	
	public static void main(String[] args) {
		
		countBits(32);
	}
	
	public static int countBits(int number){

		int result = 0;

		int val = number;
		int rem = 0;
		
		while(val != 0){

			rem = val % 2;
			val = val / 2;
			
			if( rem == 1) {
				result ++;
			}
		}
				
		return result;
	}


}
