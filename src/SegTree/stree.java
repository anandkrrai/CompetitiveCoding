package SegTree;

public class stree {
	public static int ba[], sa[];

	public static int getLog(int n) {
		int log = 0;
		while ((1 << log) < n) {
			log++;
		}

		return log;
	}

	public static void build(int in, int ss, int se) {
		if (ss == se) {
			sa[in] = ba[ss];
			return;
		}

		int mid = (ss + se) / 2;

		build(2 * in + 1, ss, mid);
		build(2 * in + 2, mid + 1, se);

		sa[in] = Math.max(sa[2 * in + 1], sa[2 * in + 2]);
	}

	public static int query(int index, int qs, int qe, int ss, int se) {
		if (qs <= ss && qe >= se) {
			return sa[index];
		} else if (ss > qe || se < qs) {
			return Integer.MIN_VALUE;
		} else {
			int mid = (ss + se) / 2;
			return Math.max(query(index * 2 + 1, qs, qe, ss, mid), query(index * 2 + 2, qs, qe, mid + 1, se));
		}
	}

	public static void main(String[] args) {
		ba = new int[] { 20, 22, 11, 55, -567, 88, 55, 7, 77, 6 };
		int size = (1 << (getLog(ba.length) + 1))-1;
		sa = new int[size];
		
		build(0, 0, ba.length-1);

		System.out.println(query(0, 1, 4, 0, sa.length-1));
	}

}
