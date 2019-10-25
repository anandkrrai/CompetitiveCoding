package day01;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class _03_NextWarmerDay {
	static class stack 
	 { 
	 	 int top; 
	 	 int items[] = new int[100]; 

	 	 // Stack functions to be used by printNGE 
	 	 void push(int x) 
	 	 { 
	 	 	 if (top == 99) 
	 	 	 { 
	 	 	 	 System.out.println("Stack full"); 
	 	 	 } 
	 	 	 else
	 	 	 { 
	 	 	 	 items[++top] = x; 
	 	 	 } 
	 	 } 

	 	 int pop() 
	 	 { 
	 	 	 if (top == -1) 
	 	 	 { 
	 	 	 	 System.out.println("Underflow error"); 
	 	 	 	 return -1; 
	 	 	 } 
	 	 	 else
	 	 	 { 
	 	 	 	 int element = items[top]; 
	 	 	 	 top--; 
	 	 	 	 return element; 
	 	 	 } 
	 	 } 

	 	 boolean isEmpty() 
	 	 { 
	 	 	 return (top == -1) ? true : false; 
	 	 } 
	 } 

	 /* prints element and NGE pair for 
	 all elements of arr[] of size n */
	 static void printNGE(int arr[], int n) 
	 { 
	 	  Stack<Integer> s = new Stack<>();
	 	  int[] res = new int[arr.length];
	 	  s.push(0);
	 	  for(int i =1;i<arr.length;i++){
	 		 while(!s.isEmpty() && arr[s.peek()] < arr[i]){
	 			 res[s.peek()] = i-s.peek();
	 			 System.out.print(arr[i]+" ");
	 			 s.pop();
	 		 }
	 		 s.push(i);
	 	  }
	 	  while(!s.isEmpty()){
	 		 res[s.pop()] = 0;
	 		  System.out.print(-1+" ");
	 	  }
	 	  System.out.println();
	 	  System.out.println(Arrays.toString(res));
	 } 

	 public static void main(String[] args) 
	 { 	 Scanner sc=new Scanner(System.in);
	 	 int n=sc.nextInt();
	 	 int arr[] = new int[n];
	 	 for(int i=0;i<n;i++)arr[i]=sc.nextInt(); 
	 	 printNGE(arr, n); 
	 }
}
