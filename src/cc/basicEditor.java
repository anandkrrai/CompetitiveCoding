package cc;

import java.util.*;

public class basicEditor {
//	public static java.util.LinkedList<String> storage = new java.util.LinkedList<String>();
	public static StringBuilder word = new StringBuilder("");
	public static Stack<String> strg = new Stack<String>();

	public static void append(String str) {
//		storage.addFirst(word.toString());
		strg.push(word.toString());
		word.append(str);
	}

	public static void delete(int k) {
//		storage.addFirst(word.toString());
		strg.push(word.toString());
//		word = word.substring(0, word.length() - k);
		word.delete(word.length() - k, word.length());
//		word = new StringBuilder(word.subSequence(0, word.length() - k));
	}

	public static void printk(int k) {
		System.out.println(word.charAt(k - 1));
	}

	public static void undo() {
//		word = new StringBuilder(storage.removeFirst());
		word = new StringBuilder(strg.pop());

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int q = scan.nextInt();
			if (q == 1) {
				String str = scan.nextLine();
//				System.out.println(":str"+str);
				append(str.substring(1));
			} else if (q == 2) {
				int k = scan.nextInt();
				delete(k);
			} else if (q == 3) {
				int k = scan.nextInt();
				printk(k);
			} else {
				undo();
			}
//			System.out.println(word);
		}
		scan.close();
	}
}
