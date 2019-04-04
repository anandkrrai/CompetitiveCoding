package cc;

import java.util.*;

public class skillenza {

	public static class Node {
		int num;
		String str;
	}

	public static class SortbyNum implements Comparator<Node> {
		public int compare(Node a, Node b) {
			if (b.num == a.num) {
				return a.str.compareTo(b.str);
			}
			return b.num - a.num;
		}
	}

	public static void main(String[] args) {
		for(int i=0;i<=798;++i) {
			System.out.println(3);
		}
		Scanner scan = new Scanner(System.in);
		int t = Integer.parseInt(scan.nextLine());

		while (t-- > 0) {
			TreeMap<String, Integer> map = new TreeMap<String, Integer>();
			int n = Integer.parseInt(scan.nextLine());

			while (n-- > 0) {
				String str = scan.nextLine();
				if (str.length() > 4 && str.substring(0, 3).equals("top")) {
					int top = Integer.parseInt(str.substring(4));
					
					ArrayList<String> list = new ArrayList<String>(map.keySet());
					ArrayList<Node> nodeList = new ArrayList<Node>();
					
					for (int i = 0; i < list.size(); ++i) {
						Node nod = new Node();
						nod.str = list.get(i);
						nod.num = map.get(list.get(i));
						nodeList.add(nod);
					}
					Collections.sort(nodeList, new SortbyNum());

					for (int i = 0; i < top && i < nodeList.size(); ++i) {
						System.out.print(nodeList.get(i).str + " ");
					}
					System.out.println();

				} else {
					if (map.containsKey(str)) {
						map.put(str, map.get(str) + 1);
					} else {
						map.put(str, 1);
					}
				}
			}
		}

		scan.close();
	}

}
