package rangeQuery;

import rangeQuery.segmentTreeSupportClass.SumOperator;

public class SegmentTree {

	public static class STree {
		int[] oa;
		int oas;
		int[] sa;
		int sas;
		public Ioperator opIoperator;

		public int getlog(int n) {
			int x = 0;
			while ((1 << x) < n) {
				x++;
			}

			return x;
		}

		public STree(int[] oa, int oas) {
//			opIoperator = new segmentTreeSupportClass.SumOperator();
			this.oa = oa;
			this.oas = oas;
			int h = getlog(oas) + 1;
			this.sas = (1 << h) - 1;
			this.sa = new int[sas];
			build(0, oas - 1, 0);

		}

		public STree(int[] oa, int oas, Ioperator ioperator) {
			this.opIoperator = ioperator;
			this.oa = oa;
			this.oas = oas;
			int h = getlog(oas) + 1;
			this.sas = (1 << h) - 1;
			this.sa = new int[sas];
			build(0, oas - 1, 0);
		}

		public void build(int ss, int se, int si) {
			if (ss == se) {
				sa[si] = oa[ss];
				return;
			}

			int mid = (ss + se) / 2;

			build(ss, mid, 2 * si + 1);
			build(mid + 1, se, 2 * si + 2);

//			sa[si] = sa[2 * si + 1] + sa[2 * si + 2];
			sa[si] = opIoperator.operation(sa[2 * si + 1], sa[2 * si + 2]);
		}

		public void update(int idx, int delta, int ss, int se, int si) {
			if (ss == se && ss == idx) {
				sa[si] += delta;
				return;
			}

			int mid = (ss + se) / 2;
			if (idx <= mid) {
				update(idx, delta, ss, mid, 2 * si + 1);
			} else {
				update(idx, delta, mid + 1, se, 2 * si + 2);
			}

//			sa[si] = sa[2 * si + 1] + sa[2 * si + 2];
			sa[si] = opIoperator.operation(sa[2 * si + 1], sa[2 * si + 2]);

		}

		public int query(int qs, int qe, int ss, int se, int si) {

			if (ss >= qs && se <= qe) {
				return sa[si];
			} else if (se < qs || ss > qe) {
				return opIoperator.identity();
			} else {
				int mid = (ss + se) / 2;
				int lc = query(qs, qe, ss, mid, 2 * si + 1);
				int rc = query(qs, qe, mid + 1, se, 2 * si + 2);
//				return lc + rc;
				return opIoperator.operation(lc, rc);

			}

		}

	}

	public static class SumOperator1 implements Ioperator {

		@Override
		public int identity() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int operation(int x, int y) {
			// TODO Auto-generated method stub
			return x + y;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] arr = { 2, 5, -3, 6, 7, 14, 1, 0 };
//		STree st = new STree(arr, arr.length);
//
//		System.out.println(st.query(2, 5, 0, arr.length - 1, 0));
//		System.out.println(st.query(5, 7, 0, arr.length - 1, 0));
//		st.update(4, 10, 0, arr.length, 0);
//		System.out.println(st.query(2, 5, 0, arr.length - 1, 0));
//		System.out.println(st.query(5, 7, 0, arr.length - 1, 0));

		Ioperator op = new SumOperator1();

		int[] arr = { 2, 5, -3, 6, 7, 14, 1, 0 };
		STree st = new STree(arr, arr.length, op);

		System.out.println(st.query(2, 5, 0, arr.length - 1, 0));
		System.out.println(st.query(5, 7, 0, arr.length - 1, 0));
		st.update(4, 10, 0, arr.length, 0);
		System.out.println(st.query(2, 5, 0, arr.length - 1, 0));
		System.out.println(st.query(5, 7, 0, arr.length - 1, 0));

	}
}
