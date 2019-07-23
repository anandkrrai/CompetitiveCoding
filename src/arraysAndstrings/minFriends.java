package arraysAndstrings;

import java.util.Scanner;

public class minFriends {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int x = scan.nextInt();
		int base = n / x;
		int more = n % x;

		int ans = (base - more) * c1(base) + more * c1(base + 1);
		System.out.println(ans);
		scan.close();
	}

	static int c1(int n) {
		return (n * (n - 1)) / 2;
	}

}
