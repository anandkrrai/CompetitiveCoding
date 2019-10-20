import java.util.*;

public class ICPC {

	public static class Pair implements Comparable<Pair>{
		int left, right;

		public Pair(int left, int right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public int compareTo(Pair o) {
			return this.left-o.left;
		}
	}

	public static boolean doesIntersect(ArrayList<Pair> list) {
		int count = 0;
		int i = 0, j = 0;
		while (i < list.size()) {
			if (list.get(i).left < list.get(j).right) {
				++count;
				++i;
			} else {
				--count;
				++j;
			}
			if (count > 2)
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = Integer.parseInt(scan.nextLine());

//		Comparator<Pair> cmp = new Comparator<movingSegment.Pair>() {
//
//			@Override
//			public int compare(Pair o1, Pair o2) {
//				return o1.left - o1.right;
//			}
//		};

		while (t-- > 0) {
			int n = Integer.parseInt(scan.nextLine());
			HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();

			for (int i = 0; i < n; ++i) {
				String[] arr = scan.nextLine().trim().split("\\s+");
				int l = Integer.parseInt(arr[0]);
				int r = Integer.parseInt(arr[1]);
				int v = Integer.parseInt(arr[2]);

				if (!map.containsKey(v))
					map.put(v, new ArrayList<Pair>());

				map.get(v).add(new Pair(l, r));
			}

			boolean ans = false;

			for (int val : map.keySet()) {
				ArrayList<Pair> l = map.get(val);
				Collections.sort(l);
				ans = doesIntersect(l);
				if (ans)
					break;
			}

			if (ans) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}

		}
		scan.close();
	}

}
