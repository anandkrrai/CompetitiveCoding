package arraysAndstrings;

import java.util.Scanner;

public class bestSightSeeingpair {

	public static int maxScoreSightseeingPair(int[] A) {
		int rv = 0, l = 0, r = A.length - 1;
		while (l < r) {
			rv = Math.max(A[l] + A[r] + l - r, rv);
			if (A[l] > A[r]) {
				--r;
			} else if (A[l] < A[r]) {
				++l;
			} else {
				if (A[l + 1] >= A[r - 1]) {
					++l;
				} else {
					--r;
				}
			}
		}

		return rv;

	}

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int[] arr = new int[N];
//
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = sc.nextInt();
//		}
//
//		System.out.println(maxScoreSightseeingPair(arr));
//		sc.close();

		int[] arr = {7,3,4,7,6,7};
		System.out.println(maxScoreSightseeingPair(arr));

	}

}
