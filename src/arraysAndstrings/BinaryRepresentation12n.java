package arraysAndstrings;

public class BinaryRepresentation12n {
	public static boolean queryString(String S, int N) {

		for (int i = (N - 1) / 2; i <= N; ++i) {
			int index = S.indexOf(Integer.toBinaryString(i));
			if (index == -1)
				return false;
		}
		return true;

	}

}
