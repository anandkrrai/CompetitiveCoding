package cc;

import java.util.*;

public class hackerearth_pikachu {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		StringBuilder builder = new StringBuilder("anand");
		
		int[] arr = new int[n];
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		for (int i = 0; i < n; ++i) {
			arr[i] = s.nextInt();
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (!map.containsKey(arr[i] + " " + arr[j]))
					map.put(arr[i] + " " + arr[j], true);
			}
		}

		System.out.println(map.size());
		s.close();
	}
}
