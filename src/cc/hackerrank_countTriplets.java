package cc;

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class hackerrank_countTriplets {

	// Complete the countTriplets function below.
	static long countTriplets(List<Long> arr, long r) {

		long rv = 0;
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();

		for (int i = 0; i < arr.size(); ++i) {
			if (map.containsKey(arr.get(i))) {
				map.put(arr.get(i), map.get(arr.get(i)) + 1);
			} else {
				map.put(arr.get(i), 1);
			}
		}

		for (long x : arr) {
			int sum = 0;
			sum = map.get(x);

			if (map.containsKey(x * r) && map.containsKey(x * r * r)) {
				sum *= map.get(x * r) * map.get(x * r * r);
			} else {
				sum = 0;
			}

			rv += sum;
		}

		return rv;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(nr[0]);

		long r = Long.parseLong(nr[1]);

		List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Long::parseLong)
				.collect(toList());

		long ans = countTriplets(arr, r);

		bufferedWriter.write(String.valueOf(ans));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
