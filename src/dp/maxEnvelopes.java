package dp;

import java.util.*;

public class maxEnvelopes {

	public static class Pair {
		int w, h;

		public Pair(int w, int h) {
			this.w = w;
			this.h = h;
		}
	}

	public static int maxEnvelopes(int[][] envelopes) {
		if (envelopes.length == 0)
			return 0;

		Comparator<Pair> cmp = new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				return p1.w - p2.w;
			}
		};

		ArrayList<Pair> list = new ArrayList<>();
		for (int i = 0; i < envelopes.length; ++i) {
			Pair pair = new Pair(envelopes[i][0], envelopes[i][1]);
			list.add(pair);
		}

		Collections.sort(list, cmp);

		int[] arr = new int[list.size()];
		arr[0] = 1;
		int rv = 1;

		for (int i = 1; i < list.size(); ++i) {
			for (int j = 0; j < i; ++j) {
				if (list.get(i).h > list.get(j).h && list.get(i).w > list.get(j).w)
					arr[i] = Math.max(arr[i], arr[j] + 1);
			}
			rv = Math.max(rv, arr[i]);
		}
		return rv;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int r = scn.nextInt();
		int envelopes[][] = new int[r][2];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < 2; j++) {
				envelopes[i][j] = scn.nextInt();
			}
		}
		System.out.println(maxEnvelopes(envelopes));
	}

}
