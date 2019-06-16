import java.util.LinkedList;
//https://leetcode.com/problems/number-of-recent-calls/
public class ping {

	class RecentCounter {

		LinkedList<Integer> q;

		public RecentCounter() {
			q = new LinkedList<>();
		}

		public int ping(int t) {
			q.addLast(t);
			while (q.getFirst() < t - 3000)
				q.removeFirst();
			return q.size();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
