package cc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class prac {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Comparator<Integer> cmp = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		};

		PriorityQueue<Integer> left = new PriorityQueue<Integer>(cmp);// max
		PriorityQueue<Integer> right = new PriorityQueue<Integer>();// min

		int x, median = 0;
		for (int i = 0; i < n; ++i) {
			x = in.nextInt();
			if (x > median) {
				right.add(x);
			} else {
				left.add(x);
			}

			if (left.size() > right.size()) {
				right.add(left.remove());
			} else if (right.size() > left.size()) {
				left.add(right.remove());
			}

			if (left.size() == right.size()) {
				median = (left.peek() + right.peek()) / 2;
			} else if (left.size() > right.size()) {
				median = left.peek();
			} else {
				median = right.peek();
			}
			System.out.println(median);
		}

	}

	public static boolean isPalin(String str) {
		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static boolean validPalindrome(String s) {

		int l = 0, r = s.length() - 1;
		while (l < r) {
			if (s.charAt(l) == s.charAt(r)) {
				++l;
				--r;
			} else if (isPalin(s.substring(l, r)) || isPalin(s.substring(l + 1, r + 1))) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

}
