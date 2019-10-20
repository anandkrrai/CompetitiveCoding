import java.util.*;

public class ArrayNumAdd {
	public List<Integer> addToArrayForm(int[] A, int K) {
		List<Integer> rv = new ArrayList<>();
		String str = K + "";
		int i = A.length - 1, j = str.length() - 1, carry = 0;
		while (i >= 0 || j >= 0 || carry > 0) {
			int a = i < 0 ? 0 : A[i];
			int b = j < 0 ? 0 : str.charAt(j) - '0';
			int temp = a + b + carry;
			carry = temp / 10;
			rv.add(temp % 10);
		}
		Collections.reverse(rv);
		return rv;
	}

	
}
