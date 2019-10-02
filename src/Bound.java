public class Bound {

	public static int Binary(int hi, int lo, int[] arr, int target) {
		if (lo == hi)
			return lo;
		int mid = (lo + hi) / 2;
		if (arr[mid] > target) {
			return Binary(mid - 1, lo, arr, target);
		} else if (arr[mid] < target) {
			return Binary(hi, mid + 1, arr, target);
		} else {
			return mid;
		}
	}

	public static int lower(int[] arr, int target) {
		int index = Binary(arr.length - 1, 0, arr, target);

		if (index == 0 || arr[index] == target)
			return arr[index];
		else if (arr[index] > target) {
			return arr[index - 1];
		} else {
			return arr[index];
		}

	}

	public static int fl(int[] arr, int size, int target) {
		int start = 0, end = size;
		int count = end - start;
		int step;
		int it = 0;
		while (count > 0) {
			it = start;
			step = count / 2;
			it = it + step;

			if (arr[it] < target) {
				start = ++it;
				count -= step + 1;
			} else {
				count = step;
			}
		}

		return arr[start];

	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 8, 11, 15 };
		for (int val : arr) {
			System.out.println(val);
			System.out.println(lower(arr, val - 1) + " " + fl(arr, 7, val - 1));
			System.out.println(lower(arr, val) + " " + fl(arr, 7, val));
			System.out.println(lower(arr, val + 1) + " " + fl(arr, 7, val + 1));
			System.out.println();
		}

	}

}
