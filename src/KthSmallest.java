import java.util.*;

public class KthSmallest {

	public static class Pair {
		int num, den;

		public Pair(int num, int dem) {
			this.num = num;
			this.den = dem;
		}
	}

	public static int[] kthSmallestPrimeFraction(int[] A, int K) {
		Comparator<Pair> cmp = new Comparator<Pair>() {

			public int compare(Pair p1, Pair p2) {
				Double d1 = (double) (p1.num / p1.den);
				Double d2 = (double) (p2.num / p2.den);

//				return d1.compareTo(d2);
				if (d1 > d2) {
					return 1;
				}else if(d1<d1) {
					return -1;
				}else {
					return 0;
				}
			}
		};

		PriorityQueue<Pair> q = new PriorityQueue<Pair>(cmp);


		for (int i = 0; i < A.length; ++i) {
			for (int j = 0; j < A.length; ++j) {
				Pair pair = new Pair(A[i], A[j]);
				q.add(pair);
			}
		}

		Pair p = null;
		while (q.size() > 0) {
			p = q.remove();
			Double x = (double) p.num / p.den;
			System.out.println(p.num + "/" + p.den + "   " + x);

		}

		int[] rv = new int[2];
		rv[0] = p.num;
		rv[1] = p.den;

		return rv;
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int[] ans = kthSmallestPrimeFraction(arr, k);

		System.out.println(ans[0] + "/" + ans[1]);

	}
}
