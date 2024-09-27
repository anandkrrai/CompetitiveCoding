package day01;

import java.util.Scanner;
import java.util.Stack;

public class _02_MaximumAreaOfHistogram {

	public static int maxRectArea(int[] ht) {
		int[] lb = new int[ht.length];
		int[] rb = new int[ht.length];
		int area = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<ht.length;i++){
			while(stack.size() > 0 && ht[stack.peek()] > ht[i]){
				rb[stack.peek()] = i;
				stack.pop();
			}
			if(stack.size() == 0){
				lb[i] = -1;
			}
			else{
				lb[i] = stack.peek();
			}
			stack.push(i);
		}
		while(stack.size()>0){
			rb[stack.pop()] = ht.length;
		}
		for(int i =0;i<ht.length;i++){
			int temp = (rb[i]-lb[i]-1)*ht[i];
			if(temp>area)
				area = temp;
		}
		if(area==Integer.MIN_VALUE)
			return 0;
		return area;
 	 }
 
 	 public static void main(String[] args) {
 	 	 Scanner scn = new Scanner(System.in);
 	 	 
 	 	 int h=scn.nextInt();
 	 	 int height[]=new int[h];
 	 	 for(int i=0;i<h;i++){
 	 	 	 height[i]=scn.nextInt();
 	 	 }
 	 	 System.out.println(maxRectArea(height));
 	 }	

}
