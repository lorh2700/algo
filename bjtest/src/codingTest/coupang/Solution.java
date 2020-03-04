package codingTest.coupang;

public class Solution {
	
	static MyStack inStack = new MyStack(5);
	static MyStack outStack = new MyStack(5);
	
	public static void main(String[] args) {
//		myStack.push(2);
//		System.out.println(myStack.pop());
//		myStack.push(3);
//		myStack.peek();
//		myStack.push(2);
//		myStack.push(4);
//		myStack.peek();
		enQueue(1);
		enQueue(2);
		enQueue(3);
		
		System.out.println(deQueue());
		
	}
	
	
	public static void enQueue(int x) {		
		inStack.push(x);		
	}
	
	public static int deQueue() {
		
		while(!inStack.isEmpty()) {
			outStack.push(inStack.pop());
		}
		return outStack.pop();
	}
		
}


class MyStack {
	
	int[] stack;
	int size;
	int top;
	
	public MyStack(int size) {
		top = -1;
		this.size = size;
		stack = new int[size];		
	}
	
	public boolean isEmpty() {				
		return (top == -1 ? true : false); 
	}
	 // 스택의 최상위(마지막) 데이터 추출 후 삭제
	public int pop() {
		
		if( isEmpty()) {
			System.out.println("empty!!");
			return 0;
		} else {
			return stack[top--];
		}
	}
    // 스택이 가득찬 상태인지 확인
    public boolean isFull() {
        // 스택 포인터가 스택의 마지막 인덱스와 동일한 경우 true 아닌 경우 false를 return
        return (top == this.size-1);
    }
	
	public void push(int x) {
		
		if(isFull()) {
			//가득참
		}else {
			stack[++top] = x;
		}
	}	
	
    // 스택의 최상위(마지막) 데이터 추출
	public int peek() {		
		 if(isEmpty()) {
	            System.out.println("Stack is empty!");
	            return 0;
	        } else { 
	            System.out.println("Item : " + stack[top]);
	            return stack[top];
	        }
	}	
}