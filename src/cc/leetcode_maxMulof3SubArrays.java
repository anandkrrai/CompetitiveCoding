package cc;

import java.util.PriorityQueue;

//https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/description/

public class leetcode_maxMulof3SubArrays {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 2, 6, 7, 5, 1 };
		int k = 2;
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int mul = 1;
		for (int i = 0; i < k; ++i) {
			mul *= arr[i];
		}
	}

}
