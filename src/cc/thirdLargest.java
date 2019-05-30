package cc;

import java.util.Comparator;
import java.util.PriorityQueue;

public class thirdLargest {

	public static void main(String[] args) {
		int[] arr = { 2, 2 };
//		System.out.println(thirdMax(arr));

//		StringBuilder sb = new StringBuilder("abcd");

		System.out.println(lastStoneWeight(arr));

	}

	public static int lastStoneWeight1(int[] stones) {
		Comparator<Integer> cmp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		};
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int x : stones)
			q.add(-1 * x);

		while (q.size() > 1)
			q.add(-1 * Math.abs(q.remove() - q.remove()));
		return -1 * q.remove();
	}
	public static int lastStoneWeight(int[] stones) {
		Comparator<Integer> cmp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		};
		PriorityQueue<Integer> q = new PriorityQueue<>(cmp);
		for (int x : stones)
			q.add(x);

		while (q.size() > 1)
			q.add(Math.abs(q.remove() - q.remove()));
		return q.remove();
	}

	public static int thirdMax(int[] nums) {
		int one = Integer.MIN_VALUE, two = Integer.MIN_VALUE, three = Integer.MIN_VALUE;
		boolean flag = false;

		for (int x : nums) {
			if (x == Integer.MIN_VALUE)
				flag = true;
			if (x > one) {
				three = two;
				two = one;
				one = x;
			} else if (x > two && x < one) {
				three = two;
				two = x;
			} else if (x > three && x < two) {
				three = x;
			}
		}

		if (three == Integer.MIN_VALUE) {
			if (flag && two != three)
				return three;
			return one;
		} else {
			return three;
		}
	}
}
