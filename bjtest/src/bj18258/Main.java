package bj18258;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String strText = br.readLine();
	
		int num = Integer.valueOf(strText);
		
		MyQueue2 mq = new MyQueue2();
		
		for( int i = 0 ; i < num ; i++) {
			String tmp = br.readLine();
			StringTokenizer st = new StringTokenizer(tmp);
			String method = st.nextToken();
			
			switch(method) {
			case "push" :
				String number = st.nextToken();
				mq.push(Integer.parseInt(number) );
				break;
			case "pop" :
				bw.write(String.valueOf(mq.pop()));
				bw.newLine();
				bw.flush();
				break;
			case "front":
				bw.write(String.valueOf(mq.front()) );
				bw.newLine();
				bw.flush();
				break;
			case "back":
				bw.write(String.valueOf(mq.back()));
				bw.newLine();
				bw.flush();
				break;
			case "size":
				bw.write(String.valueOf(mq.size()));
				bw.newLine();
				bw.flush();
				break;
			case "empty":
				bw.write(String.valueOf(mq.empty()));
				bw.newLine();
				bw.flush();
				break;
			}
		}
	}
}

class MyQueue2 {
	
	LinkedList<Integer> queue;
	
	public MyQueue2() {
		queue = new LinkedList<Integer>();
	}
	
	//push X: 정수 X를 큐에 넣는 연산이다.
	public void push(int X) {
		queue.addLast(X);
	}
	
	//pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public int pop() {
		if(empty() == 0) {
			int tmp = queue.getFirst();
			queue.removeFirst();
			
			if(empty() == 1) {
				queue.clear();
			}
			return tmp;
		} else {
			return -1;
		}
	}

	//size: 큐에 들어있는 정수의 개수를 출력한다.
	public int size() {
		return queue.size();
	}
	
	//empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
	public int empty() {
		return queue.isEmpty() ? 1 : 0;
	}
	
	//front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public int front() {
		return empty() == 0 ? queue.getFirst() : -1;
	}
	
	
	//back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다
	public int back() {
		if(empty()== 1) {
			return -1;
		} else {
			return queue.getLast();
		}
	}
	
}

class MyQueue {
	int[] queue;
	int idxFront;
	int idxRear;
	int queueSize;
	int itemCnt;
	public MyQueue(int size) {
		idxFront = 0;
		idxRear = 0;
		this.queueSize= size;
		queue = new int[this.queueSize];
		this.itemCnt = 0;
	}
	//push X: 정수 X를 큐에 넣는 연산이다.
	public void push(int X) {
		queue[idxRear] = X;
		idxRear++;
		itemCnt++;
	}
	//pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public int pop() {
		if(empty() == 1) {
			return -1;
		}
		int val = queue[idxFront];
		idxFront++;
		itemCnt--;
		return val;
	}
	//size: 큐에 들어있는 정수의 개수를 출력한다.
	public int size() {
		return itemCnt;
	}
	//empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
	public int empty() {
		return itemCnt == 0 ? 1 : 0;
	}
	//front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public int front() {
		return empty() == 1 ? -1 : queue[idxFront];
	}
	//back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다
	public int back() {
		return empty() == 1 ? -1 : queue[idxRear-1];
	}
	public void print() {
		System.out.print("=> ");
		for(int i=idxFront; i<idxRear; i++) {
			System.out.print(queue[i]+" ");
		}
		System.out.println();
	}
}