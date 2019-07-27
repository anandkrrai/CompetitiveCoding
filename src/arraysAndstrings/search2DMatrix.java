package arraysAndstrings;

import java.util.*;

public class search2DMatrix {
	public class Pair {
		int val;
		int row, col;

		public Pair(int val, int row, int col) {
			this.val = val;
			this.row = row;
			this.col = col;
		}
	}

	public boolean searchMatrix(int[][] mat, int target) {
		if (mat.length == 0 || mat[0].length == 0)
			return false;
		Comparator<Pair> cmp = new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				return p1.val - p2.val;
			}
		};

		PriorityQueue<Pair> pq = new PriorityQueue<>(cmp);
		for (int i = 0; i < mat.length; ++i) {
			Pair pair = new Pair(mat[i][0], i, 0);
			pq.add(pair);
		}

		while (pq.size() != 0) {
			Pair rem = pq.remove();
			if (rem.val == target)
				return true;
			if (rem.col + 1 < mat[0].length) {
				Pair pair = new Pair(mat[rem.row][rem.col + 1], rem.row, rem.col + 1);
				pq.add(pair);
			}
		}

		return false;

	}

	  public static int binary_search(int[][] arr, int row, int l, int r, int target) {
			if (l > r ||r>=arr[0].length)
				return -1;
			int mid = (l + r) / 2;
			if (target > arr[row][mid]) {
				return binary_search(arr, row, mid + 1, r, target);
			} else if (target < arr[row][mid]) {
				return binary_search(arr, row, l, mid - 1, target);
			} else {
				return mid;
			}
		}

		public boolean searchMatrixBS(int[][] mat, int target) {
			if (mat.length == 0 || mat[0].length == 0)
				return false;

			for (int i = 0; i < mat.length; ++i) {
				if (binary_search(mat, i, 0, mat[0].length - 1, target) > -1)
					return true;
			}
			return false;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
