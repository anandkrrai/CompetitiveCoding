//http://134.209.156.168:3004/resource/interview-prep/linked-lists-description/are-linked-lists-identical/ojquestion
public class identicalLinkedList {
	  public static boolean isIdentical(Node h1, Node h2) {
	         // write your code here and return true if they are identical, otherwise
	         // false
	         
	         if(h1==h2&&h1==null)
	            return true;
	            
	            while(h1!=null && h2!=null){
	                if(h1.data!=h2.data)
	                    return false;
	                h1=h1.next;
	                h2=h2.next;
	            }
	            
	            if(h1!=null||h2!=null)
	                return false;
	            
	            return true;
	     }
}
