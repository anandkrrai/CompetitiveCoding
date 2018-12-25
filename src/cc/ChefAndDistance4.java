package cc;

import java.util.ArrayList;
import java.util.Scanner;

public class ChefAndDistance4 {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			--t;

			int n = scan.nextInt();
			int m = scan.nextInt();
			scan.nextLine();
			int[] dist = new int[m + n - 1];
			ArrayList<Integer> x = new ArrayList<>();
			ArrayList<Integer> y = new ArrayList<>();
			int v;
			for (int i = 0; i < n; ++i) {
				String str = scan.nextLine();
				for (int j = 0; j < str.length(); ++j) {
					v = Integer.parseInt(str.charAt(j) + "");
					if (v == 1) {
						x.add(i);
						y.add(j);
					}
				}
			}
			int temp;
			int x_values[] = new int[x.size()];
			int y_values[] = new int[x.size()];

			for (int i = x_values.length - 1; x.size() > 0; --i) {
				x_values[i] = x.remove(x.size() - 1);
				y_values[i] = y.remove(y.size() - 1);
			}

			for (int i = 0; i < x_values.length; ++i) {
				for (int j = i + 1; j < y_values.length; ++j) {
					temp = Math.abs(x_values[i] - x_values[j]) + Math.abs(y_values[i] - y_values[j]);
					dist[temp]++;
				}
			}

			for (int i = 1; i < dist.length; ++i) {
				System.out.print(dist[i] + " ");
			}
			System.out.println();
		}
		scan.close();
	}
}
