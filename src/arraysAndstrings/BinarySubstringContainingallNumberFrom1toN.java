package arraysAndstrings;

public class BinarySubstringContainingallNumberFrom1toN {
	public static boolean queryString(String S, int N) {

		for (int i = N / 2 - 1; i <= N; ++i) {
			int index = S.indexOf(Integer.toBinaryString(i));
			if (i == -1)
				return false;
		}
		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
