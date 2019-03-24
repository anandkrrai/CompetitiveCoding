package cc;

import java.util.ArrayList;

public class BinaryTree {

	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	public static Node root;

	public static void insert(int x, int y,Node node) {
		if(node==null) {
			node = new Node();
			node.children= new ArrayList<Node>();
			
			node.data=x;
			Node child = new Node();
			child.data=y;
			
			return;
		}
		
		for(Node child:node.children) {
			
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
