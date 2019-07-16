package arraysAndstrings;
import java.math.BigInteger;

import java.util.*;

public class sortToMakeLargestumber {
	public String largestNumber(int[] nums) {
		Comparator<String> cmp = new Comparator<String>() {
			public int compare(String s1, String s2) {
				String str1 = s1 + s2;
				String str2 = s2 + s1;
				return str2.compareTo(str1);
			}
		};

		ArrayList<String> list = new ArrayList<>();

		for (int al : nums)
			list.add(al + "");

		Collections.sort(list, cmp);

		String rv = "";

		for (String s : list)
			rv += s;

		BigInteger bg = new BigInteger(rv);
		return bg.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
