import java.util.*;

class Main {

	static void sortByFreq(int arr[], int n) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int val : arr) {
			map.put(val, map.getOrDefault(val, 0) + 1);
		}

		Comparator<Pair> cmp = new Comparator<Pair>() {

			public int compare(Pair p1, Pair p2) {
				if (p1.freq == p2.freq) {
					if (p1.num > p2.num) {
						return 1;
					} else {
						return -1;
					}
				} else {
					if (p1.freq > p2.freq) {
						return -1;
					} else {
						return 1;
					}
				}
			}
		};

		PriorityQueue<Pair> q = new PriorityQueue<>(cmp);

		for (int val : map.keySet()) {
			Pair pair = new Pair(val, map.get(val));
			q.add(pair);
		}

		while (q.size() > 0) {
			Pair pair = q.remove();
			int freq = pair.freq;
			while (freq-- > 0) {
				System.out.print(pair.num + " ");
			}
		}

	}

	public static class Pair {
		int num;
		int freq;

		public Pair(int num, int freq) {
			this.num = num;
			this.freq = freq;
		}
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
	
		sortByFreq(arr, N);
	}
}
