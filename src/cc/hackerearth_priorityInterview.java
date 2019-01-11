package cc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class hackerearth_priorityInterview {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		ArrayList<Integer> girls = new ArrayList<>();
		ArrayList<Integer> boys = new ArrayList<>();

		while (t-- > 0) {
			int a = s.nextInt();
			int b = s.nextInt();

			if (a == 0) {
				girls.add(b);
			} else {
				boys.add(b);
			}

		}
		Collections.sort(girls);
		Collections.reverse(girls);
		Collections.sort(boys);
		Collections.reverse(boys);
		for (Integer in : girls) {
			System.out.print(in + " ");
		}
		for (Integer in : boys) {
			System.out.print(in + " ");
		}
		s.close();
	}

}
