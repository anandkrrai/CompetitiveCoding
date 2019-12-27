import java.util.TreeMap;

public class MedianInWindowSizeK {

	public static int bigSize;
	public static int smallSize;

	public static double[] medianSlidingWindow(int[] nums, int k) {
		double[] rv = new double[nums.length + 1 - k];
		TreeMap<Integer, Integer> big = new TreeMap<Integer, Integer>();
		TreeMap<Integer, Integer> small = new TreeMap<Integer, Integer>();
		bigSize = 0;
		smallSize = 0;

		for (int i = 0; i < k - 1; ++i) {
			addElement(big, small, nums[i]);
		}

		for (int i = k - 1; i < nums.length; ++i) {
			addElement(big, small, nums[i]);
			if (k % 2 == 0) {
				rv[i - k + 1] = (double) (big.ceilingKey(Integer.MIN_VALUE) + small.floorKey(Integer.MAX_VALUE)) / 2;
			} else {
				rv[i - k + 1] = big.ceilingKey(Integer.MIN_VALUE);
			}

			removeElement(big, small, nums[i - k + 1]);
		}

		return rv;
	}

	public static void addElement(TreeMap<Integer, Integer> big, TreeMap<Integer, Integer> small, int key) {
		big.put(key, big.getOrDefault(key, 0) + 1);
		++bigSize;
	}

	public static void balance(TreeMap<Integer, Integer> big, TreeMap<Integer, Integer> small) {
		if (bigSize > 1 + smallSize) {
			int remKey, remVal;
			remKey = big.ceilingKey(Integer.MIN_VALUE);
			remVal = big.get(remKey);
			--remVal;
			--bigSize;
			++smallSize;
			small.put(remKey, small.getOrDefault(remKey, 0) + 1);
			if (remVal > 0)
				big.put(remKey, remVal);

		}
		System.out.println("big:" + bigSize + " small:" + smallSize);
	}

	public static void removeElement(TreeMap<Integer, Integer> big, TreeMap<Integer, Integer> small, int key) {
		if (big.containsKey(key)) {
			--bigSize;
			int val = big.get(key);
			big.remove(key);
			--val;
			if (val > 0)
				big.put(key, val);
		} else {
			--smallSize;
			int val = small.get(key);
			small.remove(key);
			--val;
			if (val > 0)
				small.put(key, val);
		}
		balance(big, small);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
		double[] ans = medianSlidingWindow(arr, 5);

		for (double d : ans)
			System.out.print(d + " ");

	}

}
