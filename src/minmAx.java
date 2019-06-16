import java.util.HashSet;

public class minmAx {
	public static int incomplete(int[] arr) {
		int min = Integer.MAX_VALUE, max = Integer.MAX_VALUE;
		HashSet<Integer> set = new HashSet<Integer>();
	
	
		for (int x : arr) {
			min = Math.min(min, x);
			max = Math.max(max, x);
			set.add(x);

		}
		int count = 0;

		for (int i = min; i <= max; ++i) {
			if (!set.contains(i)) {
				++count;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 5, 3, 8, 6 };
		System.out.println(incomplete(arr));
	}

}
