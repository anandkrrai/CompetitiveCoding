package june13;

import java.util.Scanner;

public class Inverse {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//		System.out.println(Integer.toBinaryString(57));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE<<1);

		System.out.println("Enter number");
		int n = scn.nextInt();
		int place = 1;
		
		int inv = 0;
		
		while(n != 0){
			int rem = n % 10;
			n = n / 10;
			
			inv = inv + place * (int)Math.pow(10, rem - 1);
			
			place++;
		}
		
		System.out.println(inv);
	}

}
