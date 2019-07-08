package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import dp.maxEnvelopes.Pair;

public class russianDollEnvolopes2 {

	public static int maxEnvelopes(int[][] envelopes) {
		if (envelopes.length == 0)
			return 0;

		Comparator<int[]> cmp = new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		};

		Arrays.sort(envelopes, cmp);
		int[] arr = new int[envelopes.length];
		Arrays.fill(arr, 1);
		int rv = -1;
		for (int i = 1; i < arr.length; ++i) {
			for (int j = 0; j < i; ++j) {
				if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
					arr[i] = Math.max(arr[i], arr[j] + 1);
			}
			rv = Math.max(rv, arr[i]);
		}
		return rv;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
