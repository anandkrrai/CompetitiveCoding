package cc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class minWaitTime {

	public static class Node {
		int entry, wait_time;

		public Node(int en, int wt) {
			this.entry = en;
			this.wait_time = wt;
		}
	}

	public static class sortByNode implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			if (o1.wait_time == o2.wait_time) {
				return o1.entry - o2.entry;
			}
			return o1.wait_time - o2.wait_time;
		}

	}

	public static int minimumAverage(int[][] customers) {
		int rv = 0;
		ArrayList<Node> list = new ArrayList<Node>();

		for (int i = 0; i < customers.length; ++i) {
			Node node = new Node(customers[i][0], customers[i][1]);
			list.add(node);
		}

		Collections.sort(list, new sortByNode());
		return rv;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
