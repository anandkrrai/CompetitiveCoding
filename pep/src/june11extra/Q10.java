package june11extra;

import java.util.Scanner;

public class Q10 {

	public static int power(int n, int r) {
		if (r == 1) {
			return n;
		} else if (r == 0) {
			return 1;
		}

		int rv;
		int ret_val = power(n, r / 2);

		rv = ret_val * ret_val;
		if (r % 2 != 0) {
			rv *= n;
		}
		return rv;
	}

	public static void main(String[] args) {

		System.out.println(power(2, 30));
//		Scanner scn = new Scanner(System.in);
//
//		System.out.println("Enter x");
//		int x = scn.nextInt();
//
//		System.out.println("Enter n");
//		int n = scn.nextInt();
//
////		int pow = 1;
////		int count = 1;
////		while(count <= n){
////			pow = pow * x;
////			count++;
////		}
////		
////		System.out.println(pow);
//
//		// Log(x) to the base n
//		int count = 0;
//		while (x != 1) {
//			x = x / n;
//			count++;
//		}
//
//		System.out.println(count);
	}

}
