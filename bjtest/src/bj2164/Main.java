package bj2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		LinkedList<Integer> myQueue = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int value= Integer.parseInt(br.readLine());
		
		for(int i = 1; i < value +1; i ++) {
			myQueue.add(i);
		}
		
		while(true) {
			if(myQueue.size() > 1) {
				myQueue.removeFirst();
				int firstValue = myQueue.getFirst();
				myQueue.removeFirst();
				myQueue.addLast(firstValue);
			} else {
				break;
			}
		}		
		System.out.println(myQueue.getFirst());
	}
}
