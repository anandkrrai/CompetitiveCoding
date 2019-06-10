import java.util.LinkedList;

public class shortestArrayWithSumK {
	public static int shortestSubarray(int[] A, int k) {
		LinkedList<Integer> q = new LinkedList<>();
		int sum = 0, i = 0, length = Integer.MAX_VALUE;
		while (i < A.length) {
			if (sum < k) {
				sum += A[i];
				q.addLast(A[i]);
				++i;
			} else if (sum > k) {
				sum -= q.removeFirst();
			} else {
				length = Math.min(length, q.size());
				sum -= q.removeFirst();
			}
		}
		while (sum > k) {
			sum -= q.removeFirst();
		}
		if (sum == k)
			length= Math.min(length, q.size());
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 48, 99, 37, 4, -31 };
		System.out.println(shortestSubarray(arr, 140));
	}

}
