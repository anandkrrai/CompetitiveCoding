import java.util.PriorityQueue;
import java.util.TreeSet;

public class greatest_left {

	public static int[] greatestSmaller(int[] arr) {

		TreeSet<Integer> set = new TreeSet<Integer>();
		int[] rv = new int[arr.length];
		for (int i = 0; i < arr.length; ++i) {
			set.add(arr[i]);
			if (set.lower(arr[i]) != null) {
				rv[i] = set.floor(arr[i]);
			} else {
				rv[i] = -1;
			}
		}

		return rv;
	}

	public static void main(String[] args) {
//		int[] arr = { 4, 2, 5, 6, 8, 7, 3, 9, 1 };
//		greatestSmaller(arr);
		
		PriorityQueue<Integer> q= new PriorityQueue<Integer>();
		q.add(2);
		q.add(3);
		q.add(2);
		while(q.size()!=0) {
			System.out.println(q.remove());
			
		}
	}

}
