import java.util.Scanner;

public class gh {

	static int highestPowerof2(int n) {
		int res = 0;
		for (int i = n; i >= 1; i--) {
			// If i is a power of 2
			if ((i & (i - 1)) == 0) {
				res = i;
				break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		if (n <= 4) {
			System.out.println(n);
		} else {
			int count=4;
			int temp=6;
			
			while(temp<n) {
				temp*=2;
				++count;
			}
			System.out.println(count*2-2);

		}
	}

}
