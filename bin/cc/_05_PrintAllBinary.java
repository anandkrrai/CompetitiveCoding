package day01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _05_PrintAllBinary {
		 
		 public static void getBinary(int n){
			 if(n==0){
				 System.out.print(0);
				 return;
			 }
			 boolean isGreater = false;
			 String d = decimalToBinary(n);
			 Queue<String> que = new LinkedList<>();
			 que.add(""+1);
			 while(!que.isEmpty()){
				 String rec = que.remove();
				 if(!isGreater && d.equals(rec+0)){
					 isGreater = true;
					 que.add(rec + 0);
				 }
				 if(!isGreater){
					 que.add(rec+0);
				 }
				 if(!isGreater && d.equals(rec+1)){
					 isGreater = true;
					 que.add(rec + 1);
				 }
				 if(!isGreater){
					 que.add(rec+1);
				 }
				 System.out.print(rec+" ");
			 }
	     }
		 
	 	 private static String decimalToBinary(int n) {
			String i = "";
			while(n>0){
				int rem = n%2;
				i = rem+i;
				n = n/2;
			}
			return i;
		}

		public static void main (String[] args)  {
	 	     
	 		 Scanner scn=new Scanner(System.in);
	 		 int n = scn.nextInt();
	 		 getBinary(n);
	 	         
	 	     
	 	 }
}
