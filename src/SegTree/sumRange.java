package SegTree;

public class sumRange {
	public int[] ba, sa;

	public int getLog(int n) {
		int rv = 0;
		while (n > 0) {
			n = n >> 1;
			++rv;
		}
		return rv;
	}

	public NumArray(int[] nums) {
        int h=getLog(nums.length);
        int sz = (1 << (h + 1)) - 1;
		sa = new int[sz];
        ba=nums;
        build(0,0,nums.length-1);
    }

	public void build(int index, int ss, int se) {
		if (ss == se) {
			sa[index] = ba[ss];
			return;
		}

		int mid = (ss + se) / 2;
		build(2 * index + 1, ss, mid);
		build(2 * index + 2, mid + 1, se);

		sa[index] = sa[index * 2 + 1] + sa[index * 2 + 2];

	}

	public void update(int i, int val) {
		update(0, i, val, 0, ba.lngth - 1);
	}

	public void update(int vidx, int index, int val, int ss, int se) {
		if (ss == se) {
			sa[vidx] = val;
			ba[se] = val;
		}
		int mid = (ss + se) / 2;

		if (index <= mid) {
			update(vidx * 2 + 1, index, val, ss, mid);
		} else {
			update(vidx * 2 + 2, index, val, mid + 1, se);
		}

		sa[vidx] = sa[vidx * 2 + 1] + sa[vidx * 2 + 2];
	}

	public int sumRange(int i, int j) {
		return sumRange(0, i, j, 0, ba.length - 1);
	}

	public int sumRange(int index, int qs, int qe, int ss, int se) {
		if (qs <= ss && qe >= se) {
			return sa[index];
		} else if (ss > qe || se < qs) {
			return 0;
		} else {
			int mid = (ss + se) / 2;
			int lv = sumRange(index * 2 + 1, qs, qe, ss, mid);
			int rv = sumRange(index * 2 + 2, qs, qe, mid + 1, se);
			return lv + rv;
		}
	}
}
