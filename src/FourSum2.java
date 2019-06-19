import java.util.HashSet;

public class FourSum2 {

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();

		for (int i = 0; i < A.length; ++i) {
			for (int j = 0; j < B.length; ++j) {
				set1.add(A[i] + B[j]);
			}
		}

		for (int i = 0; i < C.length; ++i) {
			for (int j = 0; j < D.length; ++j) {
				set2.add(C[i] + D[j]);
			}
		}
		int count = 0;
		for (int x : set1) {
			if (set2.contains(x * -1))
				++count;
		}
		return count;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
