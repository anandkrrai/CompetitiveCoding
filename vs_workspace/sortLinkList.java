public static Node arcv(Node head) {
    Node vh=null,vt=null,ch=null,ct=null;
    while(head!=null){
       if(head.data=='a'||head.data=='e'||head.data=='i'||head.data=='o'||head.data=='u'){
           
           if(vh==null){
               vh=vt=head;
           }else{
               vt.next=head;
               vt=vt.next;
           }
       }else{
            
           if(ch==null){
               ch=ct=head;
           }else{
               ct.next=head;
               ct=ct.next;
           }
           
       } 
        
       head=head.next;
    }
    
    if(vh==null)
       return ch;
   else
       {
           vt.next=ch;
           return vh;
       }
}

public static Node sort(Node head) {
         
    Node myHead = head;
    Node prev=head,curr=prev.next;
    
    while(curr!=null){
       if(curr.data<0){
           prev.next=curr.next;
           curr.next=myHead;
           myHead=curr;
           curr=prev.next;
       }else{
           prev=prev.next;
           curr=curr.next;
       }
    }
    
    return myHead;
    
}


Public static Node arcv(Node node){

}