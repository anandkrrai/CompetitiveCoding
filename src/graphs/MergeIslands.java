package graphs;

import java.util.LinkedList;

public class MergeIslands {

	class Solution {

		public void change(int[][] A) {
			for (int i = 0; i < A.length; ++i) {
				for (int j = 0; j < A[0].length; ++j) {
					if (A[i][j] == 1) {
						dfs(A, i, j, 2);
						return;
					}
				}
			}

		}

		public void dfs(int[][] A, int i, int j, int target) {
			if (i < 0 || j < 0 || i >= A.length || j >= A[0].length) {
				return;
			}
			if (A[i][j] != 1)
				return;
			A[i][j] = target;

			dfs(A, i, j + 1, target);
			dfs(A, i, j - 1, target);
			dfs(A, i + 1, j, target);
			dfs(A, i - 1, j, target);
		}

		public class Pair {
			int i, j, steps;

			public Pair(int i, int j, int steps) {
				this.i = i;
				this.j = j;
				this.steps = steps;
			}

		}

		public boolean isValid(int i, int j, int[][] A) {
			if (i < 0 || j < 0 || i >= A.length || j >= A[0].length) {
				return false;
			} else {
				return true;
			}
		}

		public int shortestBridge(int[][] A) {
			change(A);
			LinkedList<Pair> q = new LinkedList<>();
			for (int i = 0; i < A.length; ++i) {
				for (int j = 0; j < A[0].length; ++j) {
					if (A[i][j] == 1) {
						q.addLast(new Pair(i, j, -1));

					}
				}
			}

			int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

			while (q.size() != 0) {
				Pair rem = q.removeFirst();

				if (A[rem.i][rem.j] == 2)
					return rem.steps;

				if (A[rem.i][rem.j] == -1)
					continue;

				A[rem.i][rem.j] = -1;

				for (int[] d : dir) {
					if (isValid(rem.i + d[0], rem.j + d[1], A) && A[rem.i + d[0]][rem.j + d[1]] != 1)
						q.addLast(new Pair(rem.i + d[0], rem.j + d[1], rem.steps + 1));
				}

			}

			return 0;

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
