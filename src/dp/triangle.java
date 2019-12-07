package dp;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class triangle {

	public static void main(String[] args) {
		for(int i=1;i<1000;++i) {
			System.out.print(CountWays(i)+" ");
		}

		
	}

	static long CountWays(int N) {
		int lim = N;
		HashMap<Long, Integer> map = new HashMap<>();

		for (int i = 1; i <= lim; ++i) {
			for (int j = 1; j <= lim; ++j) {
				for (int k = 1; k <= lim; ++k) {
					long val = i + 2 * j + k;
					map.put(val, map.getOrDefault(val, 0) + 1);
				}
			}
		}

		long count = 0;

		for (long val : map.keySet()) {
			for (long i = 1; i <= val; ++i) {
				if (val % i == 0 && map.containsKey(i))
					count += map.get(i) * map.get(val);
			}
		}

		return count;
	}

	public int minimumTotal(List<List<Integer>> triangle) {

		List<List<Integer>> dp = new ArrayList<>();
		for (int i = 0; i < triangle.size(); ++i)
			dp.add(new ArrayList<>());

		dp.get(0).add(triangle.get(0).get(0));

		for (int i = 1; i < triangle.size(); ++i) {
			for (int j = 0; j < triangle.get(i).size(); ++j) {
				if (j == 0) {
					dp.get(i).add(dp.get(i - 1).get(0) + triangle.get(i).get(0));
				} else if (j == triangle.get(i).size() - 1) {
					dp.get(i).add(dp.get(i - 1).get(j - 1) + triangle.get(i).get(j));
				} else {
					dp.get(i).add(Math.max(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j)) + triangle.get(i).get(j));
				}
			}
		}

		int max = 0;
		for (int i = 0; i < dp.get(dp.size() - 1).size(); ++i) {
			max = Math.max(max, dp.get(dp.size() - 1).get(i));
		}

		return max;
	}
}
