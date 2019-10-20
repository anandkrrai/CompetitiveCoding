package hh;

import java.util.*;

public class kickStart_oct_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = Integer.parseInt(scan.nextLine());
		int count = 0;
		while (t-- > 0) {
			++count;
			String[] arr = scan.nextLine().trim().split("\\s+");
			int n = Integer.parseInt(arr[0]);

			String[] q = scan.nextLine().trim().split("\\s+");
			HashSet<Integer> torn = new HashSet<Integer>();
			for (String s : q)
				torn.add(Integer.parseInt(s));

			String[] q1 = scan.nextLine().trim().split("\\s+");
			HashSet<Integer> readers = new HashSet<Integer>();
			for (String s : q1)
				readers.add(Integer.parseInt(s));

			int ans = 0;

			for (int reader : readers) {
				ans += n / reader;
				for (int tor : torn) {
					if (tor % reader == 0)
						--ans;
				}
			}

			System.out.println("Case #" + count + ": " + ans);
		}
		scan.close();
	}
}
