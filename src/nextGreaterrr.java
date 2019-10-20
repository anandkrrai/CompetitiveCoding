import java.util.*;

public class nextGreaterrr {

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] arr = new int[nums2.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = nums2.length - 1; i >= 0; --i) {
			while (stack.size() != 0 && stack.peek() <= nums2[i])
				stack.pop();

			if (stack.size() == 0) {
				arr[i] = -1;
			} else {
				arr[i] = stack.peek();
			}
			stack.push(nums2[i]);
		}

		HashMap<Integer, Integer> index = new HashMap<>();
		for (int i = 0; i < nums2.length; ++i)
			index.put(nums2[i], i);

		int[] rv = new int[nums1.length];
		for (int i = 0; i < rv.length; ++i) {
			rv[i] = arr[index.get(nums1[i])];
		}

		return rv;
	}
}
