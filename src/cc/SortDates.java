package cc;

import java.util.*;

public class SortDates {
	public static List<Integer> getFirstTwoItemsWithoutPair(List<Integer> list) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int key : list) {

			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}
		List<Integer> rv = new ArrayList<Integer>();

		for (int key : list) {
			if (rv.size() == 2)
				break;
			if (map.get(key) == 1)
				rv.add(key);
		}

		return rv;
	}
//	public static List<Integer> getFirstTwoItemsWithoutPair(List<Integer> list) {
//		HashMap<Integer, Integer> map = new HashMap<>();
//		for (int key : list) {
//			map.put(key, map.getOrDefault(key, 0) + 1);
//		}
//		List<Integer> rv = new ArrayList<Integer>();
//
//		for (int key : list) {
//			if (rv.size() == 2)
//				break;
//			if (map.get(key) == 1)
//				rv.add(key);
//		}
//
//		return rv;
//	}

	public static String reverseWords(String inputWords) {
		String[] arr = inputWords.trim().split("\\s+");
		String rv = "";
		for (int i = arr.length - 1; i >= 0; --i) {
			rv += arr[i] + " ";
		}

		return rv.substring(0, rv.length() - 1);

	}

	public static HashMap<String, Integer> map;

	public static ArrayList<String> sortDates(ArrayList<String> list) {
		map = new HashMap<String, Integer>();
		map.put("Jan", 1);
		map.put("Feb", 2);
		map.put("Mar", 3);
		map.put("Apr", 4);
		map.put("May", 5);
		map.put("Jun", 6);
		map.put("Jul", 7);
		map.put("Aug", 8);
		map.put("Sep", 9);
		map.put("Oct", 10);
		map.put("Nov", 11);
		map.put("Dec", 12);
		Comparator<String> cmp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] arr1 = o1.trim().split("\\s+");
				String[] arr2 = o2.trim().split("\\s+");
//				System.out.println(o1+" "+o2);
//				System.out.println(arr1.length+" "+arr2.length);
				if (arr1[2].equals(arr2[2])) {
					if (arr1[1].equals(arr2[1])) {
						return Integer.parseInt(arr1[0]) - Integer.parseInt(arr2[0]);
					} else {
						return map.get(arr1[1]) - map.get(arr2[1]);
					}
				} else {
					return Integer.parseInt(arr1[2]) - Integer.parseInt(arr2[2]);
				}

			}
		};
		Collections.sort(list, cmp);
		return list;
	}

	public static void main(String[] args) {
//		String sp = "My name is anand rai";
//		System.out.println(reverseWords(sp));
		ArrayList<Integer> lis = new ArrayList<Integer>();
		lis.add(3);
		getFirstTwoItemsWithoutPair(lis);
		ArrayList<String> list = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		while (n-- > 0) {
			String str = scan.nextLine();
			list.add(str);
		}

//		for(String s: list)
//			System.out.println(s);

		list = sortDates(list);
		for (String s : list)
			System.out.println(s);
		scan.close();
//		System.out.println(list);
	}

}
