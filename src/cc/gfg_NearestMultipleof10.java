package cc;

import java.math.BigInteger;
import java.util.Scanner;

public class gfg_NearestMultipleof10 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int t = scanner.nextInt();
		scanner.nextLine();

		while (t > 0) {
			--t;

			String str = scanner.nextLine();

			BigInteger bigInteger = new BigInteger(str + "");
			BigInteger modulas = bigInteger.mod(BigInteger.valueOf(10));

			if (modulas.compareTo(BigInteger.valueOf(5)) ==1) {
				bigInteger = bigInteger.add(BigInteger.valueOf(10)).subtract(modulas);

			} else {
				bigInteger = bigInteger.subtract(modulas);

			}

			System.out.println(bigInteger);

		}

		scanner.close();
	}

}
