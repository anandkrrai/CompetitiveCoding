package arraysAndstrings;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		
		Integer integer = new Integer("1");
		System.out.println(integer.SIZE);
		System.out.println(Byte.SIZE);

//		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
//		q.add(5);
//		q.add(15);
//		q.add(25);
//		q.add(35);
//		q.add(45);
//		q.add(1);
//
//		while (q.size() != 0)
//			System.out.println(q.remove());
//
//		StringBuilder sb = new StringBuilder("anand");
//		sb.reverse();
//		sb.replace(0, sb.length()-3, "wtf is going on ");
//		System.out.println(sb);

	}

	static int getMaxArea(int hist[], int n) {
		Stack<Integer> s = new Stack<>();

		int max_area = 0; // Initialize max area
		int tp; // To store top of stack
		int area_with_top; // To store area with top bar as the smallest bar
		int i = 0;
		while (i < n) {
			if (s.empty() || hist[s.peek()] <= hist[i])
				s.push(i++);
			else {
				tp = s.peek(); // store the top index
				s.pop(); // pop the top
				area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

				if (max_area < area_with_top)
					max_area = area_with_top;
			}
		}

		while (s.empty() == false) {
			tp = s.peek();
			s.pop();
			area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

			if (max_area < area_with_top)
				max_area = area_with_top;
		}

		return max_area;

	}
}
