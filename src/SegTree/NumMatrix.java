package SegTree;

public class NumMatrix {

	public int[][] ba;
	public int[][] sa;

	public NumMatrix(int[][] matrix) {
		int ln = findLog(matrix[0].length);
		sa = new int[matrix.length][1 << (ln + 1)];
		ba = matrix;
		build(0, 0, matrix[0].length - 1);
	}

	public int findLog(int n) {
		int log = 0;

		while (n > 0) {
			++log;
			n = n >> 1;
		}
		return log;
	}

	public void build(int si, int ss, int se) {
		if (se == ss) {
			for (int i = 0; i < ba.length; ++i) {
				sa[i][si] = ba[i][ss];
			}
			return;
		}

		int mid = (ss + se) / 2;
		build(si * 2 + 1, ss, mid);
		build(si * 2 + 2, mid + 1, se);

		for (int i = 0; i < ba.length; ++i)
			sa[i][si] = sa[i][si * 2 + 1] + sa[i][si * 2 + 2];
	}

	public int query(int si, int qrow1, int qcol1, int qrow2, int qcol2, int col1, int col2) {
		int ans = 0;
		if (col1 >= qcol1 && col2 <= qcol2) {
			for (int i = qrow1; i <= qrow2; ++i) {
				ans += sa[i][si];
			}
		} else if (col1 > qcol2 || col2 < qcol1) {
		} else {
			int mid = (col1 + col2) / 2;
			ans = query(si * 2 + 1, qrow1, qcol1, qrow2, qcol2, col1, mid)
					+ query(si * 2 + 2, qrow1, qcol1, qrow2, qcol2, mid + 1, col2);
		}
		return ans;
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return query(0, row1, col1, row2, col2, 0, ba[0].length-1);
	}
}