package hh;

import java.math.*;
import java.util.*;

public class price_after_discout {

	public static class Node implements Comparable<Node> {

		double price = 0.00;
		String name;
		int discount;

		@Override
		public int compareTo(Node o) {
			if (this.price == o.price) {
				return o.name.compareTo(this.name);
			}
			if (this.price < o.price) {
				return 1;
			} else {
				return -1;
			}
		}

	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String line = s.nextLine();
		int n = Integer.parseInt(line);
		double total = 0.00;
		ArrayList<Node> list = new ArrayList<Node>();
		for (int i = 0; i < n; ++i) {
			Node node = new Node();
			node.name = s.next();
			node.price = s.nextDouble();
			node.discount = s.nextInt();
			node.price = (node.price * (100 - node.discount)) / 100;
			total += node.price;
			list.add(node);
		}

		Collections.sort(list);

		for (Node node : list) {
			String round = round(node.price, 2) + "";
		    
			if (round.charAt(round.length() - 2) == '.') {
				round += '0';
			}else if (round.charAt(round.length() - 3) != '.') {
				round += ".00";
			}
			
			System.out.println(node.name + " " + round);
		}
		String t = round(total, 2) + "";
		if (t.charAt(t.length() - 2) == '.') {
			t += '0';
		}
		System.out.println("Total " + t);
		s.close();
	}
}
