package cc;

import java.util.Scanner;
import java.util.Stack;

public class maxInStack {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> max = new Stack<Integer>();

		while (t-- > 0) {
			int q = scan.nextInt();

			if (q == 1) {
				int v = scan.nextInt();
				stack.push(v);

				if (max.size() == 0) {
					max.push(v);
				} else if (v >= max.peek()) {
					max.push(v);
				}
			} else if (q == 2) {
				int x = stack.pop();
				if (max.peek() == x) {
					max.pop();
				}
			} else {
				System.out.println(max.peek());
			}
		}
		scan.close();
	}

}
