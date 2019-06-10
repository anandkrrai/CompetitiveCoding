import java.util.Arrays;
import java.util.Stack;

public class minSTACK {

	static class MinStack {

		Stack<Integer> minStk;
		Stack<Integer> myStk;

		/** initialize your data structure here. */
		public MinStack() {
			minStk = new Stack<>();
			myStk = new Stack<>();
		}

		public void push(int x) {
			myStk.push(x);
			if (minStk.size() == 0 || minStk.peek() <= x) {
				minStk.push(x);
			}
		}

		public void pop() {
			int x = myStk.pop();
			if (x == minStk.peek()) {
				minStk.pop();
			}
		}

		public int top() {
			return myStk.peek();
		}

		public int getMin() {
			return minStk.peek();
		}
	}

	public static void main(String[] args) {
		String s="cb,a,a,a,c,b,bd";
		String[] asr=s.split(",");
		for(String g:asr)
			System.out.println(g);
		
		
		 boolean[] arr = new boolean[26];
	        for(int i=0;i<s.length();++i){
		                arr[s.charAt(i)-'a']=true;
	        }  
	        StringBuilder sb = new StringBuilder("");
	        for(int i=0;i<arr.length;++i){
	            if(arr[i]){
	                int x=97+i;
	                char ch=(char) x;
	                sb.append(x);
	            }
	        }
	        
	        
		String ss ="abdec";
		char[] ch=s.toCharArray();
		Arrays.parallelSort(ch);
		s=ch.toString();
		Stack<Character>stack = new  Stack<Character>();
		for(int i=0;i<s.length();++i) {
			if(stack.size()!=0&&stack.peek()==s.charAt(i)) {
				continue;
			}else {
				stack.push(s.charAt(i));
			}
		}
		s=stack.toString();
		System.out.println(s);
		System.out.println(stack);
		
				System.out.println();
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		minStack.top();
		System.out.println(minStack.getMin());

	}

}
