package arraysAndstrings;

public class complexNUmberMultiplication {

	public static String complexNumberMultiply(String a, String b) {
		String[] num1 = a.split("\\+");
		String[] num2 = b.split("\\+");

		int x1 = Integer.parseInt(num1[0]);
		int x2 = Integer.parseInt(num2[0]);
		int y1 = Integer.parseInt(num1[1].substring(0, num1[1].length() - 1));
		int y2 = Integer.parseInt(num2[1].substring(0, num2[1].length() - 1));

		String ans = "";
		ans += (x1 * x2 - y1 * y2);
		ans += "+" + (x1 * y2 + x2 * y1) + "i";

		return ans;
	}

	public static void main(String[] args) {
		String a = "1+-1i", b = "1+-1i";
		System.out.println(complexNumberMultiply(a, b));

//		String f = "asdfgl";
//		String[] arr = f.split("l");
//		System.out.println(arr.length);
	}

}
