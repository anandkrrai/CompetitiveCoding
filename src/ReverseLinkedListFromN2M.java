//http://134.209.156.168:3004/resource/interview-prep/linked-lists-description/reverse-linked-list-from-m-to-n/ojquestion
//https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseLinkedListFromN2M {
	 public ListNode reverseBetween(ListNode head, int m, int n) {
	        if(head==null || head.next==null||m==n)
	            return head;
	        
	        ListNode a =head,prev=null;
	        
	        while(m>1&&head!=null){
	            prev=head;
	            head=head.next;
	            --m;
	            --n;
	        }
	        
	        ListNode t1=prev,h1=head,curr=head,next=null;
	        prev=null;
	        
	        while(n>0){
	            next=curr.next;
	            curr.next=prev;
	            prev=curr;
	            curr=next;
	            --n;
	        }
	        if(t1!=null)
	        t1.next=prev;
	        else
	            a=prev;
	        h1.next=curr;
	        
	        
	        return a;
	        
	    }
}
