package bjtest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strText = br.readLine();
	
		int num = Integer.valueOf(strText);
		
		for( int i = 0 ; i < num ; i++) {
			String tmp = br.readLine();
		}
		
	}
}

class MyQueue {
	
	int[] queue;
	int idxFront;
	int idxRear;
	int queueSize;
	
	public MyQueue(int size) {
		idxFront = -1;
		idxRear = -1;
		queueSize= size;
		queue = new int[queueSize];
	}
	
	//push X: 정수 X를 큐에 넣는 연산이다.
	public void push(int X) {
		queue[++idxFront] = X;
	}
	
	//pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public int pop() {
		if(empty() > 0) {
			return queue[idxFront--];
		} else {
			return -1;
		}
	}

	//size: 큐에 들어있는 정수의 개수를 출력한다.
	public int size() {
		return idxRear - idxFront;
	}
	
	//empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
	public int empty() {
		return idxRear == idxFront ? 1 : 0;
	}
	
	//front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public int front() {
		return empty() == 1 ? queue[idxFront] : -1;
	}
	
	
	//back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다
	public int back() {
		
		return -1;
	}
	
	
	/*
	 * 15
	 *  push 1 
	 *  push 2 
	 *  front 
	 *  back 
	 *  size 
	 *  empty 
	 *  pop 
	 *  pop 
	 *  pop 
	 *  size 
	 *  empty 
	 *  pop 
	 *  push 3
	 * empty 
	 * front
	 */
	
	
	/*
	 * 1 
	 * 2 
	 * 2 
	 * 0 
	 * 1 
	 * 2 
	 * -1 
	 * 0 
	 * 1 
	 * -1
	 *  0 
	 *  3
	 */
	
	
	
	
}