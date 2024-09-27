package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class _08_NextGreaterNode {
	
	public static int[] nextLargerNodes(ListNode head) {
 	    Stack<Integer> stack = new Stack<>();
 	    ArrayList<Integer> arr = new ArrayList<>();
 	    while(head != null){
	    	arr.add(head.val);
	    	head = head.next;
	    }
 	    int[] res = new int[arr.size()];
 	    stack.push(0);
 	    for(int i =0;i<res.length;i++){
 	    	while(!stack.isEmpty() && arr.get(stack.peek()) < arr.get(i)){
	 	    		res[stack.pop()] = arr.get(i);
	 	    }
	    	stack.push(i);
 	    }
 	    while(!stack.isEmpty()){
 	    	res[stack.pop()] = 0;
 	    }
 	    return res;
	 }

	 // Dont make changes here
	 public static void main(String[] args) {
	 	 // TODO Auto-generated method stub
	 	 Scanner sc = new Scanner(System.in);
	 	 int size=sc.nextInt();
	 	 int headval=sc.nextInt();
	 	 ListNode head=new ListNode(headval);
	 	 ListNode tail=head;
	 	 for(int i=1;i<size;i++){
	 	 	 ListNode curr=new ListNode(sc.nextInt());
	 	 	 tail.next=curr;
	 	 	 tail=curr;
	 	 }
	 	 int[] res=nextLargerNodes(head);
	 	 for(int i=0;i<size;i++)System.out.print(res[i]+" ");
	 }
	 static class ListNode {
	       int val;
	       ListNode next;
	       ListNode(int x) { val = x; }
	   }
}
