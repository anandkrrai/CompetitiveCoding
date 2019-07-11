public class maxNumElement{
   
    public class Helper {
        int maxCount;
        Integer last;
        
        public Helper(){
             this.maxCount=-1;
             this.last=null;
        }
    }
    
   
    public Helper longest(TreeNode root){
        if(root==null){
            return null;
        }
        
        Helper left=longest(root.left);
        Helper right=longest(root.left);

        Helper rv= new Helper();
        rv.last=root.val;
        rv.maxCount=1;

        if(left==null&&right==null||left.maxCount==1&&right.maxCount==1){   
            return rv;
        }
        if(left!=null && left.last==root.val){
            left.maxCount++;
        }
        if(right!=null && right.last==root.val){
            right.maxCount++;
        }

        if(left==null)
            left=rv;
        
        if(right==null)
           right= rv;  

        if(left.maxCount>right.maxCount)
            return left;
        else
            return right; 
        
    }
    public int longestUnivaluePath(TreeNode root) {
        Helper help = longest(root);
        return help.maxCount;
    }
}