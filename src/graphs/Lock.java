package graphs;

import java.util.*;

public class Lock {
	public static class Pair {
		int steps;
		String num;

		public Pair(String num, int moves) {
			this.num = num;
			this.steps = moves;
		}
	}

	public static int openLock(String[] deadend, String target) {
		HashSet<String> deadends = new HashSet<>();

		for (String str : deadend)
			deadends.add(str);

		HashSet<String> visited = new HashSet<>();

		LinkedList<Pair> q = new LinkedList<>();

		q.add(new Pair("0000", 0));

		while (q.size() != 0) {
			Pair rem = q.removeFirst();
			
			System.out.println("num: " + rem.num + " , steps =" + rem.steps);
			
			if (rem.num.equals(target))
				return rem.steps;

			if (deadends.contains(rem.num) || visited.contains(rem.num))
				continue;

			visited.add(rem.num);

			for (String nbr : increment(rem.num))
				q.addLast(new Pair(nbr, rem.steps+1));
			for (String nbr : decrement(rem.num))
				q.addLast(new Pair(nbr, rem.steps+1));

		}
		return -1;
	}

	public static ArrayList<String> increment(String str) {
		ArrayList<String> rv = new ArrayList<>();
		char[] arr = str.toCharArray();
		for (int i = 0; i < str.length(); ++i) {
			char ch = arr[i];
			if (ch == '9') {
				arr[i] = '0';
			} else {
				arr[i]++;
			}
			rv.add(new String(arr));
			arr[i] = ch;
		}
		return rv;
	}

	public static ArrayList<String> decrement(String str) {
		ArrayList<String> rv = new ArrayList<>();
		char[] arr = str.toCharArray();
		for (int i = 0; i < str.length(); ++i) {
			char ch = arr[i];
			if (ch == '0') {
				arr[i] = '9';
			} else {
				arr[i]--;
			}
			rv.add(new String(arr));
			arr[i] = ch;
		}
		return rv;
	}

	public static void main(String[] args) {
		String[] blocked = { "8888" };
		String target = "0009";
		openLock(blocked, target);
	}

}
