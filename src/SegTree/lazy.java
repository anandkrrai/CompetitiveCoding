package SegTree;

public class lazy {

	public static int[] ba;
	public static int[] sa;
	public static int[] la;

	public static int getLog(int n) {
		int log = 0;
		while (n > 0) {
			++log;
			n = n >> 1;
		}

		return log;
	}

	public static void make(int[] nums) {
		int size = (1 << (getLog(nums.length) + 1));
		ba = nums;
		sa = new int[size];
		la = new int[size];
		build(0, 0, nums.length - 1);
	}

	private static void build(int si, int ss, int se) {
		if (ss == se) {
			sa[si] = ba[ss];
			return;
		}

		int mid = (ss + se) / 2;

		build(2 * si + 1, ss, mid);
		build(2 * si + 2, mid + 1, se);

		sa[si] = Math.max(sa[2 * si + 1], sa[2 * si + 2]);
	}

	public static int query(int qs, int qe) {
		return query(0, 0, ba.length, qs, qe);
	}

	private static int query(int si, int ss, int se, int qs, int qe) {
		if (ss > qe || qs > se) {
			return Integer.MIN_VALUE;
		} else if (ss >= qs && se <= qe) {
			return sa[si];
		} else {
			int mid = (ss + se) / 2;
			return Math.max(query(si * 2 + 1, ss, mid, qs, qe), query(si * 2 + 2, mid + 1, se, qs, qe));
		}
	}

	public static void update(int index, int val) {
		update(0, index, val, 0, ba.length - 1);
	}

	public static void update(int vidx, int index, int val, int ss, int se) {
		if (ss == se) {
			sa[vidx] = val;
			ba[se] = val;
			return;
		}
		int mid = (ss + se) / 2;

		if (index <= mid) {
			update(vidx * 2 + 1, index, val, ss, mid);
		} else {
			update(vidx * 2 + 2, index, val, mid + 1, se);
		}

		sa[vidx] = Math.max(sa[vidx * 2 + 1], sa[vidx * 2 + 2]);
	}

	public static void lazy_update(int delta, int us, int ue) {
		lazy_update(0, 0, ba.length - 1, us, ue, delta);
	}

	private static void lazy_update(int si, int ss, int se, int us, int ue, int delta) {

		if (la[si] != 0) {

			sa[si] += la[si];
			if (ss != se) {
				la[si * 2 + 1] += la[si];
				la[si * 2 + 2] += la[si];
			}
			la[si] = 0;
		}

		if (ss > ue || se < us) {
			return;
		} else if (ss >= us && se <= ue) {
			sa[si] += delta;

			if (se != ss) {
				la[2 * si + 1] += delta;
				la[2 * si + 2] += delta;
			}
			return;
		}

		int mid = (ss + se) / 2;

		lazy_update(si * 2 + 1, ss, mid, us, ue, delta);
		lazy_update(si * 2 + 2, mid + 1, se, us, ue, delta);

		sa[si] = Math.max(sa[si * 2 + 1], sa[si * 2 + 2]);
	}

	public static int lazy_query(int qs, int qe) {
		return lazy_query(0, 0, ba.length, qs, qe);
	}

	private static int lazy_query(int si, int ss, int se, int qs, int qe) {

		if (la[si] != 0) {
			sa[si] += sa[si];

			if (ss != se) {
				la[2 * si + 1] += la[si];
				la[2 * si + 2] += la[si];
			}
			la[si] = 0;
		}

		if (se < qs || qe < ss) {
			return Integer.MIN_VALUE;
		} else if (ss >= qs && se <= qe) {
			return sa[si];
		}
		int mid = (ss + se) / 2;
		return Math.max(lazy_query(si * 2 + 1, ss, mid, qs, qe), lazy_query(si * 2 + 2, mid + 1, se, qs, qe));

	}

	public static void main(String[] args) {
		int[] nums = { 0,1,2,3,4,5,6,7,8,9,10 };
		make(nums);
//		System.out.println(query(0, 3));
//		update(2, 9999);
//		System.out.println(query(0, 3));
		
		lazy_update(10, 0, 3);
		System.out.println(lazy_query(0, 3));
		lazy_update(-10, 3, 3);
		System.out.println(lazy_query(0, 3));

		
	}

}
