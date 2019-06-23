
public class carPooling {

	public static boolean carPooling(int[][] trips, int cap) {

		int max = 0;

		for (int i = 0; i < trips.length; ++i) {
			max = Math.max(trips[i][2], max);
		}
		int[] arr = new int[max+1];
//		int[] arr = new int[100009];
		for (int i = 0; i < trips.length; ++i) {
			arr[trips[i][1]] += trips[i][0];
			arr[trips[i][2]] -= trips[i][0];
		}
		int sum = 0;
		for (int i = 0; i < arr.length; ++i) {
			if (sum > cap) {
				return false;
			}
			sum += arr[i];
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] arr = { { 2, 1, 5 }, { 3, 3, 7 } };

		System.out.println(carPooling(arr, 5));
	}

}
