package day01;

import java.util.Scanner;
import java.util.Stack;

public class _04_CompareTwoStringsAfterDeletion {
	public static boolean compareString(String S, String T) {
		char[] s = S.toCharArray();
		char[] t = T.toCharArray();
		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		for(int i =0;i<s.length;i++){
			if(s[i] == '#' && stack1.size() > 0){
				stack1.pop();
			}
			else{
				stack1.push(s[i]);
			}
		}
		for(int i =0;i<t.length;i++){
			if(t[i] == '#' && stack2.size() > 0){
				stack2.pop();
			}
			else{
				stack2.push(t[i]);
			}
		}
		if(stack1.size() != stack2.size())
			return false;
		else{
			while(stack1.size() >0 && stack2.size() > 0){
				if(stack1.pop() != stack2.pop())
					return false;
			}
		}
		return true;
	 }

	//Driver program
	public static void main(String[] args) {
	 	 Scanner scn = new Scanner(System.in);
	 	 String s1 = scn.next();
	 	 String s2 = scn.next();

	 	 System.out.println(compareString(s1, s2));
	}
}
