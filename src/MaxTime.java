
public class MaxTime {

	public void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public boolean isValid(int n) {
		if (n % 100 < 60 && n / 100 < 24)
			return true;
		else
			return false;
	}

	public void permute(int[] A, int vidx) {
		if (vidx == A.length - 1) {
			int temp = 0;
			for (int i : A)
				temp = temp * 10 + i;
			if (isValid(temp)) {
				// System.out.println(temp);
				valid = true;
				rv = Math.max(rv, temp);
			}
			return;
		}

		for (int i = vidx; i < A.length; ++i) {
			swap(A, i, vidx);
			permute(A, vidx + 1);
			swap(A, i, vidx);

		}
	}

	int rv;
	boolean valid;

	public String largestTimeFromDigits(int[] A) {
		rv = 0;
		valid = false;
		permute(A, 0);
		if (!valid)
			return "";
		String s = rv + "";
		while (s.length() < 4) {
			s = "0" + s;
		}

		return s.substring(0, 2) + ":" + s.substring(2);

	}
}