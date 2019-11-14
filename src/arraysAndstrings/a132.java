package arraysAndstrings;

public class a132 {
	public static boolean find132pattern(int[] nums) {
		if (nums.length < 3)
			return false;
		int[] l2r = new int[nums.length];
		int[] r2l = new int[nums.length];

		l2r[0] = Integer.MAX_VALUE;
		r2l[r2l.length - 1] = Integer.MIN_VALUE;

		for (int i = 1; i < l2r.length; ++i) {
			l2r[i] = Math.min(l2r[i - 1], nums[i - 1]);
		}

		for (int i = r2l.length - 2; i >= 0; --i) {
			r2l[i] = Math.max(r2l[i + 1], nums[i + 1]);
		}

		for (int i = 1; i < nums.length - 1; ++i) {
			if (l2r[i] < nums[i] && nums[i] > r2l[i] && r2l[i] > l2r[i])
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 5, 0, 3, 4 };

		System.out.println(find132pattern(arr));
	}

}
