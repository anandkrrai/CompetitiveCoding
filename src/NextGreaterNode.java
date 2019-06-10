//https://leetcode.com/problems/next-greater-node-in-linked-list/
//http://134.209.156.168:3004/resource/interview-prep/stacks-and-queues-description/next-greater-node/ojquestion
public class NextGreaterNode {
	
	  public static int[] arr;
	    public void fillArray(ListNode head,int count,Stack<Integer> stack){
	    
	        if(head.next==null){
	            arr =new int[count+1];
	            arr[count]=0;
	            stack.push(head.val);
	            return;
	        }
	        
	        fillArray(head.next,count+1,stack);
	        while(stack.size()>0&&stack.peek()<=head.val){
	            stack.pop();
	        }
	        
	        if(stack.size()==0){
	            arr[count]=0;
	        }else{
	            arr[count]=stack.peek();
	        }
	        
	        stack.push(head.val);
	        
	    }
	    
	    
	    public int[] nextLargerNodes(ListNode head) {
	        if(head==null)
	            return null;
	                
	        fillArray(head,0,new Stack<Integer>());
	        return arr;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
