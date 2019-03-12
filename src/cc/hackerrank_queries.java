package cc;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class hackerrank_queries {

	// Complete the freqQuery function below.
	static void freqQuery(List<List<Integer>> queries) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (List<Integer> ll : queries) {
			int op = ll.get(0);
			int elemnt = ll.get(1);

			if (op == 1) {
				if (map.containsKey(elemnt)) {
					map.put(elemnt, map.get(elemnt) + 1);
				} else {
					map.put(elemnt, +1);
				}

			} else if (op == 2) {
				map.put(elemnt, map.get(elemnt) - 1);

			} else {
				ArrayList<Integer> list = new ArrayList<Integer>(map.keySet());
				boolean flag = false;
				for (Integer x : list) {
					if (map.get(x) == elemnt) {
						flag = true;
						break;
					}
				}
				if (flag) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> queries = new ArrayList<>();

		IntStream.range(0, q).forEach(i -> {
			try {
				queries.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
