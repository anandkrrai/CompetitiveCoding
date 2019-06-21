package map_set;

import java.util.*;

public class findKpairsWithSmallestSum {

	public static class Pair {
		int num1, num2, sum;

		public Pair(int num1, int num2, int sum) {
			this.num1 = num1;
			this.num2 = num2;
			this.sum = sum;
		}
	}

	// This is a functional problem. You have to complete this function.
	// It takes as input two arrays and k.
	// It should return list of k lists of pairs with smallest sum.
	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

		Comparator<Pair> cmp = new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				if (p1.sum == p2.sum) {
					return p1.num1 - p2.num1;
				} else {
					return p1.sum - p2.sum;
				}
			}
		};

		ArrayList<Pair> list = new ArrayList<>();

		for (int i = 0; i < nums1.length; ++i) {
			Pair pair = new Pair(nums1[i], nums2[nums2.length - 1 - i], nums1[i] + nums2[nums2.length - 1 - i]);
			list.add(pair);
		}

		Collections.sort(list, cmp);

		List<List<Integer>> rv = new ArrayList<>();

		for (int i = 0; i < k; ++i) {
			ArrayList<Integer> l = new ArrayList<>();
			l.add(list.get(i).num1);
			l.add(list.get(i).num2);
			rv.add(l);
		}

		return rv;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
