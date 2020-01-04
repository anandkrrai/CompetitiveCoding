package arraysAndstrings;

import java.util.Arrays;

public class MinDeletionsToMakeColumnSorted {
	public static int minDeletionSize(String[] A) {
		int rv = 0;
		if (A.length == 0 || A.length == 1 || A[0].length() == 0)
			return rv;

		for (int j = 0; j < A[0].length(); ++j) {
			StringBuffer sb = new StringBuffer("");
			for (int i = 0; i < A.length; ++i) {
				sb.append(A[i].charAt(j));
			}
			if (!(IsSorted(sb) || IsSorted(sb.reverse()))) {
				++rv;
//				System.out.println(j);
			}

		}
		return rv;

	}

	public static boolean IsSorted(StringBuffer sb) {
		char[] arr = sb.toString().toCharArray();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] != sb.charAt(i))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String[] arr = { "ca","bb","ac" };
//		["ca","bb","ac"]
//				["z","z","z"]
//				["z","w","t"]
		System.out.println(minDeletionSize(arr));
	}

}
