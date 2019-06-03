package cc;

public class ss {
	 
	  public static class Helper{
	      int self_max=0;
	      int pathSum=0;
	      
	      public Helper(){
	          self_max=0;
	          pathSum=0;
	          
	      }
	  }
	    
	    public static Helper MaxSum(TreeNode node){
	        if(node==null)
	            return new Helper();
	        
	        Helper left = MaxSum(node.left);
	        Helper right = MaxSum(node.right);
	        Helper rv = new Helper();
	        rv.pathSum=Math.max(left.pathSum,right.pathSum)+node.val;
	        rv.self_max=Math.max(left.self_max,Math.max(right.self_max,left.pathSum+right.pathSum+node.val));
	        
	        
	        return rv;
	        
	    }
	    
		public static int MaxPathSum(TreeNode node) {
	        if(node==null)
	            return 0;
	    
	        return Math.max(MaxPathSum(node.left),MaxPathSum(node.right))+node.val;
	    }
	  
}
