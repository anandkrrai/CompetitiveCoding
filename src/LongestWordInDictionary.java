import java.util.*;

public class LongestWordInDictionary {
	public class Node {
		char ch;
		boolean eow;
		HashMap<Character, Node> child;

		public Node(char ch) {
			this.ch = ch;
			this.eow = false;
			child = new HashMap<>();
		}
	}

	Node root;

	public boolean find(Node root, String word) {
		if (word.length() == 0) {
			if (root.eow) {
				return true;
			} else
				return false;
		}
		char ch = word.charAt(0);
		if (!root.child.containsKey(ch)) {
			return false;
		} else {
			return find(root.child.get(ch), word.substring(1));
		}
	}

	public void insert(Node root, String word) {
		if (word.length() == 0) {
			root.eow = true;
			return;
		}
		char ch = word.charAt(0);
		if (!root.child.containsKey(ch)) {
			root.child.put(ch, new Node(ch));
		}
		insert(root.child.get(ch), word.substring(1));
	}

	public String longestWord(String[] words) {
		root = new Node('.');
		Arrays.sort(words);
		String rv = "";
		for (int i = 0; i < words.length; ++i) {
			if (words[i].length() == 1) {
				insert(root, words[i]);
				if (words[i].length() > rv.length())
					rv = words[i];
			} else {
				if (find(root, words[i].substring(0, words[i].length() - 1))) {
					insert(root, words[i]);
					if (words[i].length() > rv.length())
						rv = words[i];
				}
			}
		}
		// display(root,"");
		return rv;
	}

	public void display(Node root, String wsf) {
		if (root.eow) {
			System.out.println(wsf);
		}
		for (char ch : root.child.keySet()) {
			display(root.child.get(ch), wsf + ch);
		}
	}
}
