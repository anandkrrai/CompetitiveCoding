
//http://134.209.156.168:3004/resource/interview-prep/stacks-and-queues/cpu-tasks-schedule/ojquestion
//	https://leetcode.com/problems/task-scheduler/submissions/
import java.util.*;

public class task_scheduler {

	public static class Pair {
		int num;
		char ch;

		public Pair(int num, char ch) {
			this.ch = ch;
			this.num = num;
		}
	}

	public static int leastInterval(char[] tasks, int n) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (char ch : tasks) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		Comparator<Pair> cmp = new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o2.num - o1.num;
			}
		};

		PriorityQueue<Pair> q = new PriorityQueue<>(cmp);

		for (char ch : map.keySet()) {
			Pair pair = new Pair(map.get(ch), ch);
			q.add(pair);
		}

		LinkedList<Pair> list = new LinkedList<Pair>();
		int cycles = 0;
		while (q.size() > 0) {
			while (q.size() > 0 && list.size() <= n) {
				list.add(q.remove());
			}
			int i = 0;
			while (i <= n) {
				if (list.size() == 0 && q.size() == 0)
					return cycles;
				if (list.size() != 0) {
					Pair p = list.removeFirst();
					p.num--;
					if (p.num > 0)
						q.add(p);
				}
				++i;
				++cycles;
			}
		}

		return cycles;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = { 'A', 'A', 'A', 'B', 'B', 'B', 'B', 'C', 'A' };

		System.out.println(leastInterval(arr, 2));
	}

}
