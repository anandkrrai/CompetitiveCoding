import java.util.PriorityQueue;

//http://134.209.156.168:3004/resource/interview-prep/stacks-and-queues/connecting-ropes/ojquestion
public class connectRopes {
	public static long minCostRopes(long[] arr) {
		// Write your code here
		PriorityQueue<Long> q = new PriorityQueue<Long>();

		for (long x : arr) {
			q.add(x);
		}
		long ans=0;

		while (q.size() > 1) {
			long x = q.remove();
			long y = q.remove();
			ans+=x+y;
			q.add(x + y);
		}

//		return q.remove();
		return ans;

	}

	public static void main(String[] args) {
		long[] arr = { 4, 2, 7, 6, 9 };
		System.out.println(minCostRopes(arr));
	}

}
