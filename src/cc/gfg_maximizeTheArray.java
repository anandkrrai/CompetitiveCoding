package cc;
import java.util.*;

public class gfg_maximizeTheArray {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);		
		int t = scan.nextInt();
		scan.nextLine();

		while (t > 0) {
			--t;

			int n = scan.nextInt();
			
			int[] arr1 = new int[n], arr2 = new int[n], arr = new int[2 * n];
			
			for (int i = 0; i < n; ++i) {
				arr1[i] = scan.nextInt();
				arr[i] = arr1[i];
			}

			for (int i = 0; i < n; ++i) {
				arr[n + i] = arr2[i] = scan.nextInt();
			}

			Arrays.sort(arr);
			HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

			int k = arr.length - 1;
			while (map.size() != n) {
				map.put(arr[k], true);
				--k;
			}

			for (int i = 0; i < n; ++i) {
				if (map.containsKey(arr2[i])) {
					System.out.print(arr2[i] + " ");
					map.remove(arr2[i]);
				}
			}
			for (int i = 0; i < n; ++i) {
				if (map.containsKey(arr1[i])) {
					System.out.print(arr1[i] + " ");
					map.remove(arr1[i]);
				}
			}
			System.out.println();
		}
		scan.close();
	}
}