package arraysAndstrings;

import java.util.ArrayList;
import java.util.List;

public class oneThird {
	public List<Integer> majorityElement(int[] nums) {
		int f1 = 0, f2 = 0, two = -1, one = -1;

		for (int val : nums) {
			if (one == val) {
				++f1;
			} else if (two == val) {
				++f2;
			} else if (f1 == 0) {
				one = val;
				++f1;
			} else if (f2 == 0) {
				two = val;
				++f2;
			} else {
				--f1;
				--f2;
			}
		}
		f1 = 0;
		f2 = 0;
		for (int val : nums) {
			if (val == one)
				++f1;
			else if (val == two)
				++f2;
		}
		List<Integer> rv = new ArrayList<>();
		if (f1 > nums.length / 3)
			rv.add(one);
		if (f2 > nums.length / 3)
			rv.add(two);
		return rv;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
