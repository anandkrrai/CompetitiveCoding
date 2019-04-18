package cc;

public class down20 {

	public static int[] arr = new int[1000001];
	public static boolean is_processed = false;

	public static int maxDivisor(int n) {
		int sqr = (int) Math.sqrt(n) + 2;
		for (int i = 2; i <= sqr; ++i) {
			if (n % i == 0) {
				return Math.max(i, n / i);
			}
		}
		return -1;
	}

	public static void preProcess() {
		for (int i = 0; i < arr.length; ++i) {
			if (i < 4) {
				arr[i] = i;
			} else {
				arr[i] = arr[i - 1] + 1;
				int a = maxDivisor(i);
				if (a != -1)
					arr[i] = Math.min(arr[i], arr[a] + 1);
			}
		}
		is_processed = true;
	}

	public static void main(String[] args) {
		
		preProcess();
		
		for (int i = 0; i < 100; ++i) {
//			System.out.println(i + ": " + maxDivisor(i));
			System.out.println(i+"->"+arr[i]);
		}
	}

}
