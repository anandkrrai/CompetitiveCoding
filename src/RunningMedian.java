import java.util.*;

public class RunningMedian {
	class MedianFinder {

		PriorityQueue<Integer> minQ, maxQ;

		/** initialize your data structure here. */
		public MedianFinder() {
			Comparator<Integer> min = new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o1 - o2;
				}
			};

			Comparator<Integer> max = new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2 - o1;
				}
			};
			maxQ = new PriorityQueue<>(max);
			minQ = new PriorityQueue<>(min);

		}

		public void addNum(int num) {
			if (maxQ.size() == 0 || maxQ.peek() > num) {
				maxQ.add(num);
			} else {
				minQ.add(num);
			}

			if (minQ.size() > maxQ.size() + 1) {
				maxQ.add(minQ.remove());
			} else if (maxQ.size() > minQ.size() + 1) {
				minQ.add(maxQ.remove());
			}
		}

		public double findMedian() {
			if (minQ.size() > maxQ.size()) {
				return minQ.peek();
			} else if (maxQ.size() > minQ.size()) {
				return maxQ.peek();
			} else {
				return (minQ.peek() + maxQ.peek()) / 2;
			}
		}
	}

	/**
	 * Your MedianFinder object will be instantiated and called as such:
	 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
	 * obj.findMedian();
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
