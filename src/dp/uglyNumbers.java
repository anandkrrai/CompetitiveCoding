package dp;

import java.util.*;

//https://leetcode.com/problems/ugly-number-ii/
public class uglyNumbers {
	public int nthUglyNumber1(int n) {
		PriorityQueue<Long> q = new PriorityQueue<Long>();
		q.add(1L);
		HashSet<Long> set = new HashSet<>();
		long rv = 1;
		while (n-- > 0) {
			rv = q.remove();

			if (!set.contains(rv * 2)) {
				q.add(rv * 2);
				set.add(rv * 2);
			}
			if (!set.contains(rv * 3)) {
				q.add(rv * 3);
				set.add(rv * 3);
			}
			if (!set.contains(rv * 5)) {
				q.add(rv * 5);
				set.add(rv * 5);
			}
		}
		return (int) rv;
	}

	public static int nthUglyNumber(int n) {
		PriorityQueue<Long> q = new PriorityQueue<Long>();
		q.add(1L);
		long rv = 1;
		while (n-- > 0) {
			rv = q.remove();
//			System.out.println(rv);
			q.add(rv * 2);
			q.add(rv * 3);
			q.add(rv * 5);
		}
		return (int) rv;
	}

	public static void main(String[] args) {
		nthUglyNumber(100);
	}

}
