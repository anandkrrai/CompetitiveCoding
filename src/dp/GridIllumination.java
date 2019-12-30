package dp;

import java.util.HashSet;

public class GridIllumination {
	public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {

		int[] x = new int[N];
		int[] y = new int[N];
		int[] l2r = new int[2 * N + 1]; // x-y
		int[] r2l = new int[2 * N + 1]; // x+y
		HashSet<String> set = new HashSet<>();

		for (int[] lamp : lamps) {
			int xc = lamp[0];
			int yc = lamp[1];

			x[xc]++;
			y[yc]++;
			r2l[xc + yc]++;
			l2r[xc - yc + N]++;
			set.add(xc + "*" + yc);
		}

		int[] rv = new int[queries.length];
		int[] dirx = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
		int[] diry = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

		for (int i = 0; i < queries.length; ++i) {
			int xc = queries[i][0];
			int yc = queries[i][1];

			rv[i] = x[xc] > 0 || y[yc] > 0 || r2l[xc + yc] > 0 || l2r[xc - yc + N] > 0 ? 1 : 0;

			for (int d = 0; d < 9; ++d) {
				if (isValid(xc + dirx[d], yc + diry[d], N) && set.remove(xc + "*" + yc)) {
					x[xc]--;
					y[yc]--;
					r2l[xc + yc]--;
					l2r[xc - yc + N]--;
				}
			}
		}
		return rv;
	}

	public boolean isValid(int x, int y, int N) {
		if (x < 0 || y < 0 || x >= N || y >= N) {
			return false;
		} else {
			return true;
		}
	}
}
