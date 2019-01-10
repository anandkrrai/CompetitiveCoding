package cc;

import java.util.Scanner;

public class codechef_FANCY {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		while (t-- > 0) {
			String str = s.nextLine();
			System.out.println(find(str));
		}

		s.close();
	}

	private static String find(String str) {
		String rv = "regularly fancy", pattern = "not";
		String[] arr = str.trim().split("\\s+");
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i].equals(pattern)) {
				rv = "Real Fancy";
				return rv;
			}
		}

		return rv;
	}

}
