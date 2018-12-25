package cc;
import java.math.BigInteger;
import java.util.Scanner;

public class gfg_sumOfTwoLargeNumbers {

	public static void main(String[] args)  {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		scan.nextLine();

		while (t > 0) {
			--t;

			String line = scan.nextLine();
			String[] strs = line.trim().split("\\s+");

			BigInteger x1 = new BigInteger(strs[0]);
			BigInteger y1 = new BigInteger(strs[1]);

			x1 = x1.add(y1);

			String ans = x1.toString();

			if (strs[0].length() == ans.length()) {
				System.out.println(x1);
			} else {
				System.out.println(strs[0]);
			}

		}
		scan.close();
	}

}
