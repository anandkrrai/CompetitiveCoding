package cc;

import java.math.BigInteger;
import java.util.Scanner;

public class PowerDigitSum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		scan.nextLine();
		t--;
		BigInteger bigInteger = new BigInteger(scan.nextLine());
		while (t-- > 0)
			bigInteger=bigInteger.add(new BigInteger(scan.nextLine()));

		System.out.println(bigInteger.toString().substring(0, 10));
		scan.close();
	}

}
