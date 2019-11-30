package hh;

import java.io.*;
import java.util.*;

public class SubtreeCount {

	public static class Node {
		int val;
		ArrayList<Node> children;

		public Node(int val) {
			this.val = val;
			children = new ArrayList<>();
		}
	}

	static long[] solve(int[] arr) {
		Stack<Node> stack = new Stack<Node>();
		int vidx = 0;
		Node head = new Node(arr[vidx++]);
		stack.push(head);

		while (stack.size() > 0 && vidx < arr.length) {
			if (stack.peek().val == arr[vidx]) {
				Node rem = stack.pop();
				if (!stack.isEmpty()) {
					stack.peek().children.add(rem);
				}
			} else {
				stack.push(new Node(arr[vidx]));
			}
			vidx++;
		}
		long[] rv = new long[arr.length / 2];
		HashMap<Integer, Long> map = new HashMap<>();
		calc(map, head);
		for (int key : map.keySet())
			rv[key - 1] = map.get(key);
		return rv;
	}

	private static long calc(HashMap<Integer, Long> map, Node head) {
		long ans = 1;
		for (Node child : head.children) {
			ans += calc(map, child);
		}
		map.put(head.val, ans);
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int N = Integer.parseInt(br.readLine().trim());
		String[] arr_arr = br.readLine().trim().split(" ");
		int[] arr = new int[N];
		for (int i_arr = 0; i_arr < arr_arr.length; i_arr++) {
			arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
		}

		long[] out_ = solve(arr);
		wr.print(out_[0]);
		for (int i_out_ = 1; i_out_ < out_.length; i_out_++) {
			wr.print(" " + out_[i_out_]);
		}

		wr.close();
		br.close();
	}
}
