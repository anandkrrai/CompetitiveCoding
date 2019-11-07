package day01;

import java.util.Scanner;

public class _06_TinyBigTiny {
	 
	 public static boolean find132pattern(int[] num) {
		 for(int i =0;i<num.length-1;i++){
			 if(i%2 == 0){
				 if(num[i+1]>num[i])
					 return false;
			 }
			 else{
				 if(num[i+1]<num[i])
					 return false;
			 }
		 }
		 return true;
	 }

	 //Dont make changes here
	 public static void main(String[] args) {
	 
	 	 Scanner sc=new Scanner(System.in);
	 	 int n=sc.nextInt();
	 	 int[] A=new int[n];
	 	 for(int i=0;i<n;i++)A[i]=sc.nextInt();
	 	 System.out.println(find132pattern(A));
	 }
}
