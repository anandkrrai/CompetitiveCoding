package day01;
import java.util.Scanner;
import java.util.Stack;

public class _01_ArrangingVowel{

	public static int maxRectArea(int[] ht) {
        Stack<Integer> stack = new Stack<>();
        int[] lb = new int[ht.length];
        stack.push(0);
        for(int i=0;i<ht.length;i++){
        	while(!stack.isEmpty() && ht[stack.peek()] > ht[i]){
        		
        	}
        }
        return 0;
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