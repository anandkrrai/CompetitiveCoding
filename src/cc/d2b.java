package cc;

//Java implementation of the above approach 
import java.util.Arrays;

public class d2b {

	// Function to print k numbers which are powers of two
	// and whose sum is equal to n
	public static void FindAllElements(int n, int k) {
		// Initialising the sum with k
		int sum = k;

		// Initialising an array A with k elements
		// and filling all elements with 1
		int[] A = new int[k];
		Arrays.fill(A, 0, k, 1);

		for (int i = k - 1; i >= 0; --i) {

			// Iterating A[] from k-1 to 0
			while (sum + A[i] <= n) {

				// Update sum and A[i]
				// till sum + A[i] is less than equal to n
				sum += A[i];
				A[i] *= 2;
			}
		}

		// Impossible to find the combination
		if (sum != n) {
			System.out.print("Impossible");
		}

		// Possible solution is stored in A[]
		else {
			for (int i = 0; i < k; ++i)
				System.out.print(A[i] + " ");
		}
	}

	public static void main(String[] args) {

		int n = 132431;
		int k = 6;

		FindAllElements(n, k);
	}
}

//This code is contributed by Rituraj Jain 

//
//public class d2b {
//
//	public static void main(String[] args) {
//		int n = 923329349;
//		int rem, pow = 1;
//		String ans = "";
//		while (n != 0) {
//			rem = n % 2;
//			n /= pow;
//			ans = rem + "" + ans;
//			pow *= 2;
//		}
//
//		System.out.println(ans);
//	}
//
//}
