import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DistinctElementsInAString {

	public static void print(String[] arr) throws IOException {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (String str : arr) {
			String[] x = str.split("\\s+");
			if (x[0].equals("A")) {
				map.put(Integer.parseInt(x[1]), map.getOrDefault(Integer.parseInt(x[1]), 0) + 1);
			} else {
				int val = map.get(Integer.parseInt(x[1])) - 1;
				map.remove(Integer.parseInt(x[1]));
				if (val > 0)
					map.put(Integer.parseInt(x[1]), val);

			}
			System.out.println(map.size());
		}
	}

	// Don't make any changes here
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}

		print(arr);

	}

}
