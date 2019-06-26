package map_set;

import java.util.*;

public class intersectionOfArrays {
		public int[] intersection(int[] nums1, int[] nums2) {
			if (nums1.length == 0 || nums2.length == 0)
				return null;
			HashSet<Integer> set = new HashSet<>();
	
			for (int val : nums1)
				set.add(val);
	
			ArrayList<Integer> list = new ArrayList<>();
			for (int val : nums2) {
				if (set.contains(val)) {
					list.add(val);
				}
			}
	
			int[] rv = new int[list.size()];
			for (int i = 0; i < list.size(); ++i) {
				rv[i] = list.get(i);
			}
			return rv;
		}
}
