package dp;

import java.util.*;

public class MaxFibboSubSequence {

	public int lenLongestFibSubseq(int[] A) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		for (int i = 0; i < A.length; ++i) {
			if (!map.containsKey(A[i]))
				map.put(A[i], new ArrayList<>());
			map.get(A[i]).add(i);
		}

		int rv = 0;
		int[] dp = new int[A.length];

		for (int i = 0; i < A.length; ++i) {
			dp[i] = 1;
			for (int j = 0; j < i; ++j) {
				ArrayList<Integer> list = map.getOrDefault(A[i] - A[j], new ArrayList<>());
				for (int index : list) {
					if (index < j && A[index] <= A[j])
						dp[i] = Math.max(dp[i], dp[index] + 2);
				}
			}
			rv = Math.max(rv, dp[i]);
		}
		return rv;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
