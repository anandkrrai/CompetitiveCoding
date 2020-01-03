package mathematics;

public class maxSumdivisibleby3 {
	public static int maxSumDivThree(int[] nums) {

		int min11 = Integer.MAX_VALUE, min12 = Integer.MAX_VALUE, min21 = Integer.MAX_VALUE, min22 = Integer.MAX_VALUE,
				sum = 0;

		for (int val : nums) {
			sum += val;
			int rem = val % 3;
			switch (rem) {
			case 0: {
				break;
			}

			case 1: {
				if (min11 == Integer.MAX_VALUE || val < min11) {
					min12 = min11;
					min11 = val;
				} else if (val < min12) {
					min12 = val;
				}
				break;
			}

			case 2: {
				if (min21 == Integer.MAX_VALUE || val < min21) {
					min22 = min21;
					min21 = val;
				} else if (val < min22) {
					min22 = val;
				}
				break;
			}
			}
		}

		if (sum % 3 == 0) {
			return sum;
		} else if (sum % 3 == 1) {
			return sum - minimize(min11, min21, min22);
		} else {
			return sum - minimize(min21, min11, min12);
		}

	}

	private static int minimize(int mina, int minb1, int minb2) {
		if (mina == Integer.MAX_VALUE)
			return minb1 + minb2;
		else if (minb1 == Integer.MAX_VALUE || minb2 == Integer.MAX_VALUE)
			return mina;
		else
			return Math.min(mina, minb1 + minb2);

	}

	public static void main(String[] args) {
		int[] arr = {3,6,5,1,8};
		System.out.println(maxSumDivThree(arr));
	}

}
