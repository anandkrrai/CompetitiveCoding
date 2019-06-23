import java.util.Arrays;

public class mean_median_mode {
	public static double[] sampleStats(int[] count) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		double[] arr = new double[5];
		int[] buff = new int[256];
		int sum = 0;

		if (count.length == 0)
			return arr;

		for (int val : count) {
			min = Math.min(min, val);
			max = Math.max(max, val);
			sum += val;
			buff[val]++;
		}
		Arrays.sort(count);

		arr[0] = min * 1.0;
		arr[1] = max * 1.0;
		arr[2] = sum / count.length;
		if (count.length % 2 == 0) {
			arr[3] = 1.0 * (count[count.length / 2] + count[(count.length / 2) - 1]) / 2;
		} else {
			arr[3] = 1.0 * count[count.length / 2];
		}
		max = 0;
		int index = -1;
		for (int i = 0; i < 256; ++i) {
			if (max < buff[i]) {
				max = buff[i];
				index = i;
			}
		}
		arr[4] = index * 1.0;
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		double[] rv = sampleStats(arr);
		for (double x : rv)
			System.out.print(x + " ");
	}

}
