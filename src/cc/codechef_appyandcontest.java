package cc;

import java.math.BigInteger;
import java.util.Scanner;

public class codechef_appyandcontest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		while (t-- > 0) {
			BigInteger n = new BigInteger(scan.next());
			BigInteger a = new BigInteger(scan.next());
			BigInteger b = new BigInteger(scan.next());
			BigInteger k = new BigInteger(scan.next());
			BigInteger ans = BigInteger.ZERO;

			ans = ans.add(n.divide(a));
			ans = ans.add(n.divide(b));
			
			BigInteger gcd = a.gcd(b);
			BigInteger lcm = a.multiply(b).divide(gcd);
			
			lcm = n.divide(lcm);

			ans = ans.subtract(lcm);
			ans = ans.subtract(lcm);

			if (ans.compareTo(k) == -1) {
				System.out.println("Lose");
			} else {
				System.out.println("Win");
			}

		}

		scan.close();
	}

}

//int n = scan.nextInt();
//int a = scan.nextInt();
//int b = scan.nextInt();
//int k = scan.nextInt();
//
//int lcm = (a * b) / gcdiv(a, b);
//int ans = n / a + n / b - n / lcm;
//
//if (ans >= k) {
//	System.out.println("Win");
//} else {
//	System.out.println("Lose");
//}
