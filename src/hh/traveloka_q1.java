package hh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class traveloka_q1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = Integer.parseInt(scan.nextLine());

		while (t-- > 0) {
			int n = Integer.parseInt(scan.nextLine());
			int delta = 0;
			ArrayList<Integer> list = new ArrayList<Integer>();

			while (n-- > 0) {

				String[] str = scan.nextLine().trim().split("\\s+");
				int num = Integer.parseInt(str[1]);

				if (str[0].equals("A")) {
					num += delta * -1;
					list.add(num);
				} else if (str[0].equals("D")) {
					delta -= num;
				} else if (str[0].equals("I")) {
					delta += num;
				} else {
					if (num > list.size()) {
						System.out.println(-1);
					} else {
						Collections.sort(list);
						System.out.println(list.get(list.size() - num) + delta);
					}
				}
			}
		}
		scan.close();
	}

}

/*
 * package hh;
 * 
 * import java.util.ArrayList; import java.util.Collections; import
 * java.util.Comparator; import java.util.PriorityQueue; import
 * java.util.Scanner;
 * 
 * public class traveloka_q1 {
 * 
 * public static void main(String[] args) { Scanner scan = new
 * Scanner(System.in); int t = Integer.parseInt(scan.nextLine());
 * Comparator<Integer> min = new Comparator<Integer>() {
 * 
 * @Override public int compare(Integer o1, Integer o2) { return
 * o1.compareTo(o2); } }; Comparator<Integer> max = new Comparator<Integer>() {
 * 
 * @Override public int compare(Integer o1, Integer o2) { return
 * o2.compareTo(o1); } }; while (t-- > 0) { int n =
 * Integer.parseInt(scan.nextLine()); int delta = 0;
 * 
 * PriorityQueue<Integer> p_min = new PriorityQueue<Integer>(min);
 * PriorityQueue<Integer> p_max = new PriorityQueue<Integer>(max);
 * 
 * while (n-- > 0) {
 * 
 * String[] str = scan.nextLine().trim().split("\\s+"); int num =
 * Integer.parseInt(str[1]);
 * 
 * if (str[0].equals("A")) { num += delta * -1; if (p_max.size() > 0 && num >
 * p_max.peek()) { p_max.add(num); } else { p_min.add(num); } } else if
 * (str[0].equals("D")) { delta -= num; } else if (str[0].equals("I")) { delta
 * += num; } else { if (num > p_min.size() + p_max.size()) {
 * System.out.println(-1); } else { if (p_min.size() < num) { while
 * (p_min.size() != num) { p_min.add(p_max.remove()); } } else { while
 * (p_min.size() != num) { p_max.add(p_min.remove()); } }
 * System.out.println(p_min.peek() + delta); } } } } scan.close(); }
 * 
 * }
 */
