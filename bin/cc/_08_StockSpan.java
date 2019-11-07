package day01;

import java.util.Scanner;
import java.util.Stack;

public class _08_StockSpan {
	
	static Stack<Integer> stack1 = new Stack<>();
	static Stack<Integer> stack2 = new Stack<>();
	static int increase = -1;
	static class StockSpanner{
		public int next(int price) {
			increase++;
			if(stack1.isEmpty()){
				stack1.push(price);
				stack2.push(increase);
				return increase+1;
			}
			while(!stack1.isEmpty() && stack1.peek() < price){
				stack1.pop();
				stack2.pop();
			}
			if(stack1.isEmpty()){
				stack1.push(price);
				stack2.push(increase);
				return increase+1;
			}
			int temp = stack2.peek();
			stack1.push(price);
			stack2.push(increase);
			return increase-temp;
		}
    }


//Dont make chamnges here
	 public static void main(String[] args){
	 	 StockSpanner ss = new StockSpanner();
	 	 Scanner sc=new Scanner(System.in);
	 	 int n=sc.nextInt();
	 	 for(int i=0;i<n;i++){
	 	 	 System.out.println(ss.next(sc.nextInt()));
	 	 }
	 }
}
