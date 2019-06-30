package arraysAndstrings;

public class t {
	public static void rotate(int[] a, int k) {
		int[] temp = new int[k];
		for (int i = 0; i < k; i++) {
			temp[i] = a[a.length - k + i];
		}
		for (int i = a.length - k - 1; i >= 0; i--) {
			a[i + k] = a[i];
		}
		for (int i = 0; i < k; i++) {
			a[i] = temp[i];
		}
	}
}
