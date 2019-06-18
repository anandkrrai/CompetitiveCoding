
//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
import java.util.LinkedList;

public class shortestSubArray {

	public static int shortestSubarray(int[] A, int k) {
		LinkedList<Integer> q = new LinkedList<>();
		q.remo
		int sum = 0, i = 0, len = Integer.MAX_VALUE;
		while (i < A.length || sum >= k) {
			if (sum < k) {
				sum += A[i];
				q.addLast(A[i]);
				++i;
			} else if (sum >= k) {
				sum -= q.removeFirst();
			}
			if (sum >= k) {
				len = Math.min(len, q.size());
			}
		}
		while(q.size()!=0) {
			sum -= q.removeFirst();
			if (sum >= k) {
				len = Math.min(len, q.size());
			}
		}

		if (len == Integer.MAX_VALUE)
			return -1;
		else
			return len;
	}

	public static void main(String[] args) {
		int[] arr = {48,99,37,4,-31};
		int k=140;
		System.out.println(shortestSubarray(arr, k));
	}

}
