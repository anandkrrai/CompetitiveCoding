import java.util.*;

public class IPO {
	static class Project {
		int profit;
		int capital;

		Project(int p, int c) {
			this.profit = p;
			this.capital = c;
		}
	}

	public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		ArrayList<Project> arr = new ArrayList<>();
		for (int i = 0; i < Profits.length; ++i) {
			arr.add(new Project(Profits[i], Capital[i]));
		}

		Comparator<Project> cmp = new Comparator<Project>() {
			@Override
			public int compare(Project o1, Project o2) {
				return o2.capital - o1.capital;
			}
		};
		Collections.sort(arr, cmp);
		Comparator<Project> cmp2 = new Comparator<Project>() {
			@Override
			public int compare(Project o1, Project o2) {
				return o2.profit - o1.profit;
			}
		};
		PriorityQueue<Project> q = new PriorityQueue<>(cmp2);

		int j = 0;
		for (int i = 0; i < k; ++i) {
			while (j < arr.size() && arr.get(j).capital <= W) {
				q.add(arr.get(j));
				j++;
			}

			System.out.println(q.peek().capital);
			Project p = q.remove();

			W += p.profit;
		}

		return W;

	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int w = sc.nextInt();

		int n = sc.nextInt();
		int[] profits = new int[n];
		int[] capital = new int[n];

		for (int i = 0; i < n; i++) {
			profits[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			capital[i] = sc.nextInt();
		}

		System.out.println(findMaximizedCapital(k, w, profits, capital));

	}

}