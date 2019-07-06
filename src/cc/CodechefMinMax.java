package cc;

import java.util.Scanner;

public class CodechefMinMax {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();

		while (t-- > 0) {
			int n = scan.nextInt();
			int k = scan.nextInt();
			if(k%n==0) {
				System.out.println(0);
			}else {
				System.out.println(2);
			}
		}
	}

}
