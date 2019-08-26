package hh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArraySubSets {
	public static List<Integer> subsetA(List<Integer> arr) {
		List<Integer> rv = new ArrayList<Integer>();
		Collections.sort(arr);
		int i = 0, j = arr.size() - 1, sumL = 0, sumR = 0;

		while (i < j) {
			if (sumR <= sumL) {
				sumR += arr.get(j);
				rv.add(arr.get(j));
				--j;
			} else {
				sumL += arr.get(i);
				++i;
			}
		}
		Collections.sort(rv);

		return rv;
	}
}
