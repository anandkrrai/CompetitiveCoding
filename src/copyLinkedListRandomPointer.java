//https://leetcode.com/problems/copy-list-with-random-pointer/submissions/
http://134.209.156.168:3004/resource/interview-prep/linked-lists-description/cloning-linked-list-with-random-pointers-and-next/ojquestion
public class copyLinkedListRandomPointer {
	 public Node copyRandomList(Node head) {
	        if(head==null)
	        return head;
	        
	        Node node=head;
	        
	        HashMap<Node,Node>map = new HashMap<>();
	        
	        while(node!=null){
	            map.put(node,new Node(node.val));
	            node=node.next;
	        }
	        
	        node=head;
	        Node sec;
	        while(node!=null){
	            sec=map.get(node);
	            sec.next=map.get(node.next);
	            sec.random=map.get(node.random);
	        node=node.next;
	        }
	        
	        return map.get(head);
	        
	    }
}
