package arraysAndstrings;

public class TurbulantArray {
	public static int maxTurbulenceSize(int[] A) {
		int rv = 0, run = 1;

		for (int i = 0; i < A.length; ++i) {
			if (i % 2 == 0) {
				if (i + 1 < A.length && A[i] < A[i + 1]) {
					++run;
				} else {
					rv = Math.max(rv, run);
					run = 1;
				}
			} else {
				if (i + 1 < A.length && A[i + 1] < A[i]) {
					++run;
				} else {
					rv = Math.max(rv, run);
					run = 1;
				}
			}
		}
		rv = Math.max(rv, run);
		return rv;
	}

	public static void main(String[] args) {
		int[] arr = {4,8,12,16};
		
		System.out.println(maxTurbulenceSize(arr));
	}

}
