package aug18;

public class SegmentTree {
	private class Node {
		int data;
		int si;
		int ei;
		Node left;
		Node right;
	}
	
	private Node root;
	private int size;
	private ISegmentOperator operator;
	
	public void changeOperator(ISegmentOperator operator){
		this.operator = operator;
		updateToNewOperator(root);
	}
	
	private void updateToNewOperator(Node node){
		if(node.si == node.ei){
			return;
		}
		
		updateToNewOperator(node.left);
		updateToNewOperator(node.right);
		node.data = operator.operation(node.left.data, node.right.data);
	}
	
	public SegmentTree(int[] arr, ISegmentOperator operator){
		this.operator = operator;
		root = construct(arr, 0, arr.length - 1);
	}
	
	private Node construct(int[] arr, int si, int ei){
		if(si == ei){
			Node base = new Node();
			this.size++;
			
			base.data = arr[si];
			base.si = base.ei = si;
			return base;
		}
		
		int mid = (si + ei) / 2;
		
		Node node = new Node();
		this.size++;
		node.si = si;
		node.ei = ei;
		node.left = construct(arr, si, mid);
		node.right = construct(arr, mid + 1, ei);
		node.data = this.operator.operation(node.left.data, node.right.data);
		
		return node;
	}

	public int query(int qsi, int qei){
		return query(root, qsi, qei);
	}
	
	private int query(Node node, int qsi, int qei){
		//node entirely in the query
		if(node.si >= qsi && node.ei <= qei){
			return node.data;
		}
		// node entirely out the query
		else if(node.ei < qsi || node.si > qei){
			return this.operator.defaultValue();
		}
		// overlap 
		else {
			int lsc = query(node.left, qsi, qei);
			int rsc = query(node.right, qsi, qei);
			return this.operator.operation(lsc, rsc);
		}
	}

	public void update(int nv, int idx){
		update(root, nv, idx);
	}

	private void update(Node node, int nv, int idx) {
		if(node.si == idx && node.ei == idx){
			node.data = nv;
			return;
		}
		
		int mid = (node.si + node.ei) / 2;
		
		if(idx > mid){
			update(node.right, nv, idx);
		} else {
			update(node.left, nv, idx);
		}
		
		node.data = this.operator.operation(node.left.data, node.right.data);
	}
}
