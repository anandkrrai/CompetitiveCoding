import java.util.*;

public class alternateCharacterds {

	public static String reorganizeString(String s) {
		Comparator<Pair> cmp = new Comparator<Pair>() {

			public int compare(Pair p1, Pair p2) {
				if (p1.freq > p2.freq) {
					return -1;
				} else if (p1.freq < p2.freq) {
					return 1;
				} else {
					return (int) (p1.ch - p2.ch);
				}
			}
		};

		char[] arr = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();

		for (char val : arr) {
			map.put(val, map.getOrDefault(val, 0) + 1);
		}

		PriorityQueue<Pair> q = new PriorityQueue<>(cmp);

		for (char val : map.keySet()) {
			Pair pair = new Pair(val, map.get(val));
			q.add(pair);
		}
		Pair p1 = q.peek();
		if (p1.freq > s.length()/2)
			return "";

		String str = "";

		while (q.size() > 1) {
			Pair pair1 = q.remove();
			Pair pair2 = q.remove();
			pair1.freq--;
			pair2.freq--;
			str += pair1.ch + "" + pair2.ch;

			if (pair1.freq > 0)
				q.add(pair1);
			if (pair2.freq > 0)
				q.add(pair2);
		}

		return str + q.remove().ch;
	}

	public static class Pair {
		int freq;
		char ch;

		public Pair(char ch, int freq) {
			this.ch = ch;
			this.freq = freq;
		}
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();

		System.out.println(reorganizeString(s));

	}
}
