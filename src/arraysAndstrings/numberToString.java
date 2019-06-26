package arraysAndstrings;

public class numberToString {

	static String[] got = { "", "Thousand ", "Million ", "Billion ", "Trillion " };
	static String[] teens = { "", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ",
			"Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ",
			"Nineteen " };
	static String[] tens = { "", "Ten ", "Twenty ", "Thirty ", "Fourty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ",
			"Ninety " };

	public static String f2(int n) {
		if (n >= 100) {
			return teens[n / 100] + "hundred " + f2(n % 100);
		} else if (n >= 20) {
			return tens[n / 10] + f2(n % 10);
		} else {
			return teens[n];
		}
	}

	public static String f1(int n, int i) {
		if (n == 0) {
			return "";
		} else {
			return f1(n / 1000, i + 1) + f2(n % 1000) +(n%1000 == 0 ? "" :got[i]);
		}
	}

	public static void main(String[] args) {
		System.out.println(f1(1234567891, 0));
	}
}