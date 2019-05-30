package cc;

import java.util.ArrayList;

public class RightView {

	class TreeNode {
		int data;
		TreeNode left, right;

		public TreeNode(int data) {
			this.data = data;
			left = right = null;
		}

	void rightView(TreeNode node) {
	    int ans = node.data;
	    ArrayList<TreeNode> list = new ArrayList<TreeNode>();
	    list.add(node);
	    list.add(null);
	    while(list.size()>0) {
	    	TreeNode x= list.remove(0);
	    	if(x==null) {
	    		System.out.print(ans+" ");
	    		list.add(null);
	    	}else {
	    		ans=x.data;
	    		list.add(x.left);
	    		list.add(x.right);
	    	}
	    }
	//add code here.
	}

		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}

}
