package day01;

import java.util.Scanner;
import java.util.Stack;

public class _09_NextSmaller { 
	
	 public static void main(String[] args) 
	 { 	 Scanner sc=new Scanner(System.in);
	 	 int n=sc.nextInt();
	 	 int arr[] = new int[n];
	 	 for(int i=0;i<n;i++)arr[i]=sc.nextInt(); 
	 	 printNSE(arr, n); 
	 }

	private static void printNSE(int[] arr, int n) {
		Stack<Integer> stack = new Stack<>();
		int[] rb = new int[arr.length];
		for(int i=0;i<arr.length;i++){
			if(stack.isEmpty()){
				stack.push(i);
			}
			else{
				if(arr[i]<arr[stack.peek()]){
					while(!stack.isEmpty() && arr[i]<arr[stack.peek()]){
						rb[stack.pop()] = arr[i];
					}
					stack.push(i);
				}
				else{
					stack.push(i);
				}
			}
		}
		while(!stack.isEmpty()){
			rb[stack.pop()] = -1;
		}
		for(int i=0;i<arr.length;i++){
			System.out.println(rb[i]);
		}
	}
}
