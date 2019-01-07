package cc;

import java.util.*;

class gfg_sortByFreq {

//class for storing data and its frequency
	public static class Node {
		Integer freq = 0;
		int data = 0;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		// number of test case
		int t = scan.nextInt();
		scan.nextLine();

		while (t-- > 0) {
			// number of elements in an array
			int n = scan.nextInt();
			// using hashmap to store data with corresponding frequency
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int temp;
			while (n-- > 0) {
				temp = scan.nextInt();
				// if data already exist , increase the frequency
				if (map.containsKey(temp)) {
					map.put(temp, map.get(temp) + 1);
				} else {
					// fresh data
					map.put(temp, 1);
				}
			}
			// list for travelling throung hashmap
			ArrayList<Integer> tempList = new ArrayList<Integer>(map.keySet());
			ArrayList<Node> list = new ArrayList<Node>();

			Node node;
			for (Integer in : tempList) {
				node = new Node();
				node.data = in;
				node.freq = map.get(in);
				list.add(node);
			}

			// comparator for sorting .this will be used to
//			sort the objects of class Node
			Comparator c = new Comparator<Node>() {
				public int compare(Node o1, Node o2) {
					return o2.freq.compareTo(o1.freq);
				};
			};

			Collections.sort(list, c);
			int freq, data;

			for (int i = 0; i < list.size(); ++i) {
				node = list.get(i);
				freq = node.freq;
				data = node.data;

				while (freq-- > 0) {
					System.out.print(data + " ");
				}
			}

			System.out.println();

		}
		scan.close();

	}
}