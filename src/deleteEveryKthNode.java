//http://134.209.156.168:3004/resource/interview-prep/linked-lists-description/delete-every-kth-node/ojquestion
public class deleteEveryKthNode {
	ublic static Node delete(Node head, int k) {
        if(head==null)
            return head;

        Node prev=null,curr=head;
        int count=1;
        
        while(curr!=null){
            if(count==k){
                count=1;
                prev.next=curr.next;
                curr=curr=curr.next;
            }else{
                prev=curr;
                curr=curr.next;
                ++count;
            }
        }
        return head;
     }	
}
