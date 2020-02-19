package bj4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Stack<String> stack = new Stack<String>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean keepWhile = true;
		
		while(keepWhile) {
			
			String line = br.readLine();			
			char[] sentense = line.toCharArray();
			
			if(sentense.length == 1) {
				if( sentense[0]=='.') {
					keepWhile = false;
					break;
				}
			}
			for(char word : sentense) {			
			switch(word) {
				case '(' :
					stack.add("(");
					break;
				case ')' :
					if(stack.isEmpty() || stack.pop() !="(") {
						stack.add(")");
						keepWhile = true;
						break;
					} 
					break;
				case '[':
					stack.add("[");
					break;
				case ']':
					if(stack.isEmpty() || stack.pop()!="[") {
						stack.add("]");
						keepWhile = true;
						break;
					} 
					break;				
				}
			}
			
			if(stack.isEmpty() && stack.isEmpty()) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
			
			stack.clear();
			stack.clear();
		}
	}
}
