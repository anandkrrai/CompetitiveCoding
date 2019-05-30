package pep;

class FenwickTree {

	static int[] arr;
	static int[] fa;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		arr = new int[] { 2, 5, 9, -3, -6, 0, 7, 1, -1, 8, -7, 3, -4, -5, 6, 7 };
		fa = new int[arr.length + 1];

		build();

		System.out.println(query(3, 10));
		System.out.println(query(5, 12));
		update(6, 5);
		System.out.println(query(3, 10));
		System.out.println(query(5, 12));

	}

	public static void build() {
		for (int i = 0; i < arr.length; i++) {
			update(i, arr[i]);
		}
	}

	public static void update(int idx, int delta) {
		idx++;

		while (idx < fa.length) {
			fa[idx] += delta;
			idx += (idx & -idx);
		}
	}

	public static int query(int l, int r) {
		return getPresum(r) - getPresum(l - 1);
	}

	public static int getPresum(int idx) {
		idx++;

		int sum = 0;

		while (idx > 0) {
			sum += fa[idx];
			idx -= (idx & -idx);
		}

		return sum;
	}

}
