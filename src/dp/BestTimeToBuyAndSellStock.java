package dp;

public class BestTimeToBuyAndSellStock {

	public static int myFunc(int[] arr, int fees) {
		int[] mpb = new int[arr.length];
		int[] mps = new int[arr.length];

		mpb[0] = -arr[0];

		for (int i = 1; i < arr.length; ++i) {
			mpb[i] = Math.max(mpb[i - 1], mps[i - 1] - arr[i]);
			mps[i] = Math.max(mps[i-1], mpb[i-1] + arr[i] - fees);
		}

		return mps[arr.length - 1];
	}

	public static void main(String[] args) {
		int[] arr = {9,1,3,10,1,4,6,9};
		System.out.println(myFunc(arr, 2));
	}

}
