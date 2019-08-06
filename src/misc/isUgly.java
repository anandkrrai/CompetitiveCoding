package misc;

public class isUgly {

	public static boolean isUgly1(int num) {
		while (num % 2 == 0) {
			if(num==2)
				return true;
			num /= 2;
		}

		while (num > 0 && num % 3 == 0) {
			num /= 3;
		}

		while (num > 0 && num % 5 == 0) {
			num /= 5;
		}

		if (num == 1)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		System.out.println(isUgly1(8));
	}

}
