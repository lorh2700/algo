package bjtest;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		MyStack myStack = new MyStack(num);

		
		for(int i = 0 ; i <= num ; i ++) {
			String order = sc.nextLine();
			
			String[] subOrder;
			
			if(order.contains("push")) {
				subOrder = order.split(" ");
				
				myStack.push(Integer.parseInt(subOrder[1]));
				
			}else if(order.contains("top")) {
				System.out.println(myStack.top());				
			}else if(order.contains("size")) {
				System.out.println(myStack.size());
			}else if(order.contains("pop")) {
				System.out.println(myStack.pop());
			}else if(order.contains("empty")) {
				System.out.println(myStack.empty());
			}
			
		}
		
	}
	
}

class MyStack {
	
	int top;
	int[] stack;
	int size;
	
	
	public MyStack(int size) {
		top = -1;
		stack = new int[size];
		this.size = size;
	}
	
	public void push(int x) {
		stack[++top] = x;
	}
	
	public int pop() {
		if(top < 0 ) {
			return -1;
		} else {
			return stack[top--];
		}
	}
	
	public int size() {
		return top< 0 ? 0 : top + 1;
	}
	
	public int empty() {		
		return top < 0 ? 1 : 0 ;
	}
	
	public int top() {
		return top < 0 ? -1 : stack[top] ;
	}
	
}