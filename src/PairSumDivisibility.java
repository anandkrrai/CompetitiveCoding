import java.util.HashMap;

public class PairSumDivisibility {

	public static boolean doesExist(int[] arr, int target) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i : arr) {
			int val;

			if (i < 0) {
				val = i % target;
				val += target;
			} else {
				val = i % target;
			}

			map.put(val, map.getOrDefault(val, 0) + 1);
		}

		if (target % 2 == 0)
			if (map.get(target / 2) % 2 != 0) {
				return false;
			}

		if (map.getOrDefault(0, 0) % 2 != 0)
			return false;

		for (int i = 1; i < target / 2; ++i) {
			if (map.get(i) != map.get(target - i))
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 11, 3, 8, 9, 12, 7, 4, 14, 20, 27, 16, 21, 25, 0, 28, 29, 35, 10, 17, 19, -53, -3 };
		System.out.println(doesExist(arr, 7));
	}

}
