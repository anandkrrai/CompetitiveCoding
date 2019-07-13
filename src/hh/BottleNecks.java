
package hh;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BottleNecks {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		LinkedList<Long> q = new LinkedList<>();
		long[] arr = new long[n];
		for (int i = 0; i < n; ++i)
			arr[i] = scan.nextLong();

		Arrays.sort(arr);
		q.add(arr[0]);
		for (int i = 1; i < n; i++) {
			if (arr[i] > q.peek())
				q.remove();
			q.add(arr[i]);
		}
		System.out.println(q.size());
		scan.close();
	}
}
