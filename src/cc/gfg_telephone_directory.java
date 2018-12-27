package cc;

import java.util.ArrayList;
import java.util.HashMap;

public class gfg_telephone_directory {

	public static class Trie {
		class Node {
			char data;
			HashMap<Character, Node> children = new HashMap<>();
			Boolean eof = false;
		}

		Node root = new Node();

		public void addword(String word) {
			addword(root, word);
		}

		private void addword(Node node, String word) {
			if (word.length() == 0) {
				node.eof = true;
				return;
			}

			char ch = word.charAt(0);
			word = word.substring(1);

			Node child = node.children.get(ch);

			if (child == null) {
				child = new Node();
				child.data = ch;
				node.children.put(ch, child);
			}

			addword(child, word);
		}

		public void display() {
			display(root, "");
		}

		private void display(Node node, String osf) {
			if (node.eof) {
				System.out.print(osf + " ");
			}

			ArrayList<Character> keys = new ArrayList<>(node.children.keySet());
			for (Character key : keys) {
				Node child = node.children.get(key);
				display(child, osf + key);
			}

		}

		public void display(String query) {
			display_query(root, query, "");
		}

		private void display_query(Node node, String query, String prefix) {
			if (query.length() == 0) {
				return;
			}
			if(node==null) {
				System.out.println(0);
				display_query(node, query.substring(1), "");
				return;
			}

			char ch = query.charAt(0);
			query = query.substring(1);

			Node child = node.children.get(ch);

			display(node, prefix);
			prefix += ch;
			System.out.println();
			display_query(child,query,prefix);

		}
	}

	public static void main(String[] args) {

		Trie trie = new Trie();

		trie.addword("geeikistest");
		trie.addword("geeksfortest");
		trie.addword("geeksforgeeks");


//		trie.display();

		trie.display("geeips");
	}

}
