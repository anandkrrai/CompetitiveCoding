
public class twoStacksInAray {

	     // sq is the object of class TwoStack
	     /* The method push to push element into the stack 2 */
	     static void push1(int x, TwoStack sq)
	     {
	         sq.top1++;
	         sq.arr[top1]=x;
	         
	     }
	     /* The method push to push element into the stack 2*/
	     static void push2(int x, TwoStack sq)
	     {
	         sq.top2--;
	         sq.arr[top2]=x;
	     }
	     /* The method pop to pop element from the stack 1 */
	     static int pop1(TwoStack sq)
	     {
	         int rv=sq.arr[top1];
	         sq.arr[top1]=0;
	         sq.top1--;
	         return rv;
	     }
	     /* The method pop to pop element from the stack 2 */
	     static int pop2(TwoStack sq)
	     {
	         int rv=sq.arr[top2];
	         sq.arr[top2]=0;
	         sq.top2++;
	         return rv;
	     }
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	    // Dont make changes here 
	     
	     public static void main(String[] args){
	     	 TwoStack sq=new TwoStack();
	     	  Scanner sc=new Scanner(System.in);
	        	  int n=sc.nextInt();
	        	  int i=0;// number of operations to be performed
	        	  while(i!=n){
	        	 	  int q=sc.nextInt();
	        	 	  if(q==1){
	        	 	 	  int op=sc.nextInt();
	        	 	 	  if(op==1)
	        	 	 	 	  push1(sc.nextInt(), sq);
	        	 	 	  else if(op==2)
	        	 	 	 	  System.out.println(pop1(sq));
	        	 	  }
	        	 	  else if(q==2){
	        	 	 	 int op=sc.nextInt();
	       	 	 	 if(op==1)
	       	 	 	 	 push2(sc.nextInt(), sq);
	       	 	 	 else if(op==2)
	       	 	 	 	 System.out.println(pop2(sq));
	       	 	  }
	        	 	  i++;
	        	  }
	       
	     }
	 // Dont make changes here    
	     static class TwoStack
	     {
	     	 int size;
	     	 int top1,top2;
	     	 int arr[] = new int[100];
	     	 TwoStack()
	     	 {
	     	 	 size = 100;
	     	 	 top1 = -1;
	     	 	 top2 = size;
	     	 }
	     }