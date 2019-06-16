import java.util.Scanner;

public class longestInvalid {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		int max = Integer.MIN_VALUE, count = 0;

		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) == '(') {
				++count;
			} else {
				--count;
			}
			max = Math.max(max, Math.abs(count));
		}
		if(count!=0)
			max=str.length();
		
		System.out.println(max);
	}

}
