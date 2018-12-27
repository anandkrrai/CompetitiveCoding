package cc;

public class reverseKlinkList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

Node curr = node, prev = null, next = null;
        int count = 0;
        while(curr != null && count < k)
        {
            next = curr.next;
		    curr.next = prev;
		    prev = curr;
		    curr = next;
		    count++;
        }
        
        if (next != null)
	      node.next = reverse(next, k); 
	      return prev;
	      
	      
	      
	      
	      
	      
	      Node curr = node, prev = null, next = null;
	        int count = 0;
	        while(curr != null && count < k)
	        {
	            next = curr.next;
			    curr.next = prev;
			    prev = curr;
			    curr = next;
			    count++;
	        }
	        
	        if (next != null)
		      node.next = reverse(next, k); 
		      return prev;
	      
	      
	      

	}

}
