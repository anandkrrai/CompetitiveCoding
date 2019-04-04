import java.util.ArrayList;
import java.util.Arrays;

public class BT {

	public static class node {
		int data;
		node left;
		node right;

		public node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	private static node construct(ArrayList<Integer> dlist) {

		ArrayList<node> stack = new ArrayList<>();
		node root = null;
		for (int i = 0; i < dlist.size(); ++i) {
			if (dlist.get(i) == -1) {
				stack.remove(stack.size() - 1);
			} else {
				node nn = new node(dlist.get(i));
				if (stack.isEmpty()) {
					root = nn;
				} else {
					node top = stack.get(stack.size() - 1);
					if (top.left == null) {
						top.left = nn;
					} else {
						top.right = nn;
					}
				}
				stack.add(nn);
			}
		}
		return root;

	}

	private static void display(node root) {
		if (root.left != null)
			System.out.print(root.left.data);
		else
			System.out.print(".");

		System.out.print("->");
		System.out.print(root.data);
		System.out.print("<-");

		if (root.right != null)
			System.out.print(root.right.data);
		else
			System.out.print(".");

		System.out.println();
		if (root.left != null)
			display(root.left);
		if (root.right != null)
			display(root.right);
	}

	// size sum max hright

	private static int size(node root) {
		if (root == null) {
			return 0;
		}
		int ls = size(root.left);
		int rs = size(root.right);
		return ls + rs + 1;
	}

	private static int max(node root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int m = root.data;
		m = Math.max(m, max(root.left));
		m = Math.max(m, max(root.right));
		return m;
	}

	private static int sum(node root) {
		if (root == null) {
			return 0;
		}
		int ls = sum(root.left);
		int rs = sum(root.right);
		return ls + rs + root.data;
	}

	private static int height(node root) {
		if (root == null) {
			return -1;
		}
		int ls = height(root.left);
		int rs = height(root.right);
		return Math.max(ls, rs) + 1;
	}

	private static ArrayList<Integer> n2r(node root, int data) {
		if (root.data == data) {
			ArrayList<Integer> path = new ArrayList<>();
			path.add(data);
			return path;
		}
		if (root.left != null) {
			ArrayList<Integer> path = n2r(root.left, data);
			if (path != null) {
				path.add(root.data);
				return path;
			}
		}
		if (root.right != null) {
			ArrayList<Integer> path = n2r(root.right, data);
			if (path != null) {
				path.add(root.data);
				return path;
			}
		}

		return null;
	}

	// private static void printKaway(node root, int data, int k) {
	// 	ArrayList<Integer> n2d = n2r(root, data);

	// 	for (int i = 0; i < n2d.size(); ++i) {
	// 		printKdown(root, data, k - i, false);
	// 	}
	// }

	// private static void printKdown(node root, int data, int k, boolean f) {
	// 	if (k == 0) {
	// 		System.out.println(root.data);
	// 	}
	// 	if (root.data == data || f) {
	// 		f = true;
	// 	}
	// 	if (!f) {
	// 		if (root.left != null) {
	// 			printKdown(root.left, data, k, false);
	// 		}
	// 		if (root.left != null) {
	// 			printKdown(root.right, data, k, false);
	// 		}
	// 	} else {
	// 		if (root.left != null) {
	// 			printKdown(root.left, data, k - 1, true);
	// 		}
	// 		if (root.left != null) {
	// 			printKdown(root.right, data, k - 1, true);
	// 		}

	// 	}

	// }

		public static ArrayList<node> node2root(node root , int data){
			if(root==null)
				return null;
			
			if(root.data==data){
				ArrayList<node> lst = new ArrayList<>();
				lst.add(root);
				return lst;
			}

				ArrayList<node> pathL = node2root(root.left, data);
				if (pathL != null) {
					pathL.add(root);
					return pathL;
				}
		
			
				ArrayList<node> pathR = node2root(root.right, data);
				if (pathR != null) {
					pathR.add(root);
					return pathR;
				}
						
			return null;
		}

		public static void printKDown(node root,int k){
			if(root==null){
				return;
			}
				if(k==0){
					System.out.print(root.data+" ");
				}
		
				printKDown(root.left, k-1);
				printKDown(root.right, k-1);
		}

		public static node find(node root, int data){
			if(root==null)
				return null;
			
			if(root.data==data)
				return root;
			
			node lv=find(root.left, data);
			if(lv!=null)
				return lv;
			
			
			return find(root.right, data);
		
		}

		public static void printKfar(node root, int data , int k){
			ArrayList<node> lst = node2root(root, data);
			// node myNode=find(root, data);
			printKDown(lst.get(0), k);

			for(int i=1;i<=k&&i<lst.size();++i){
				node prev=lst.get(i-1);
				node curr=lst.get(i);
				if(curr.left==prev)
				printKDown(curr.right, k-i-1);
				else
				printKDown(curr.left, k-i-1);
			}

		}


public static void toDuplicate(node root){
	if(root==null)
		return;

	node n = new node(root.data);
	
	n.left=root.left;
	root.left=n;

	toDuplicate(root.left.left);
	toDuplicate(root.right);
	
} 

public static void fromDuplicate(node root){
	if(root==null)
		return;
	
	root.left=root.left.left;

	fromDuplicate(root.left);
	fromDuplicate(root.right);
}



// public static void toLinkList(node root,toLinkListHelper help){
// 	if(root==null)
// 		return;
	
// 	toLinkList(root.right,help);


// 	toLinkList(root.left,help);

// }

//root to leaf in bw lo & hi
//remove leaves
// print singlr chile


public static node remove_leave(node root) {

	if(root==null){
		return null;
	}

	if(root.left==null&&root.right==null){
		return null;
	}

	root.left=remove_leave(root.left);
	root.right=remove_leave(root.right);

	return root;
	
}

public static void PrintSingleChild(node root,node parent){
	if(root==null){
		return;
	}

	if(parent!=null&&root.left==null&&root.right==null){
		if(parent.left==null ||parent.right==null){
			System.out.println(root);
		}
		
	}
		PrintSingleChild(root.left, root);
		PrintSingleChild(root.right, root);
	
}

public static void rootToLEafPathInRange(node root , int lo , int hi , int sum,String parh){
	if(root ==null){
		return;
	}

	if(sum> hi)
	{
		return;
	}

	if(root.left==null && root.right==null && sum+root.data <=hi && sum+root.data>=lo){
		System.out.println(parh +" "+root.data);
		return;
	}

	rootToLEafPathInRange(root.left, lo, hi, sum+root.data, parh+" "+root.data);
	rootToLEafPathInRange(root.right, lo, hi, sum+root.data, parh+" "+root.data);
}



	public static void main(String[] args) {
		ArrayList<Integer> dlist = new ArrayList<>(
				Arrays.asList(50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1));

		node root = construct(dlist);
		aman(root);
		display(root);
		// display(root);
		// System.out.println(size(bt));
		// System.out.println(max(bt));
		// System.out.println(sum(bt));
		// System.out.println(height(bt));
		// System.out.println(n2r(bt, 60));
		// printKaway(bt, 25, 2);
			// ArrayList<node> lst = node2root(root, 62);

			// for(node in : lst){
			// 	System.out.println(in.data+" ");
			// }

				// printKDown(root, 0);

			// System.out.println(find(root, 62).data);	

			// printKfar(root, 37, 2);
			// display(root);
			// System.out.println("==================");
			// toDuplicate(root);
			
			// display(root);
			// System.out.println("==================");

			// fromDuplicate(root);
			// display(root);

			// rootToLEafPathInRange(root, 100, 2000, 0, "");

			// PrintSingleChild(root, null);
	}
}
