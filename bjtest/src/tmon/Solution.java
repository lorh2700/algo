package tmon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


//9 7
//6 6 4 3
//4 5 3 4 3
//4 1 2
public class Solution {
	public static List<Stack<Integer>> doDo() {
	    final List<Integer> elements = Arrays.asList(9, 7, 6, 6, 4, 3, 4, 5, 3, 4, 3, 4, 1, 2);

	    // 이곳 코드에 해당하는 코드를 작성하시요	    
	    List<Stack<Integer>> result = new ArrayList<Stack<Integer>>();
	    
	    int curSum = 0;
	    int carry = 0;
	    Stack<Integer> tmpResult = new Stack<>();
	    
	    for(int tmp : elements) {
	    	
	    	curSum+=tmp;
	    	if(carry > 0) {
	    		tmpResult.add(carry);
	    	}
	    	
	    	if(curSum > 20) {
	    		result.add(tmpResult);
	    		tmpResult = new Stack<>();
	    		curSum = tmp;
	    		carry = tmp;
	    	} else {
	    		carry = 0;
	    		tmpResult.add(tmp);
	    	}
	    }
	    
	    result.add(tmpResult);

	    return result;
	}

	public static void main(String... args) {
	    List<Stack<Integer>> stackList = doDo();
	    for (Stack<Integer> stack : stackList) {
	        for (Integer element : stack) {
	            System.out.print(element.toString() +" "); 
	        }
	        System.out.println();
	    }
	}
}

