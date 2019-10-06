package arraysAndstrings;

public class CountAndSay {
	public static String[] arr;
	public static boolean filled = false;

	public static void fill() {
		arr = new String[32];
		arr[0] = "";
		arr[1] = "1";
		arr[2]="11";

		for (int i = 3; i < arr.length; ++i) {
			String str = arr[i - 1], val = "";
			int count = 1;
			for (int j = 1; j < str.length(); ++j) {
				if (str.charAt(j - 1) != str.charAt(j)) {
					val += ""+count +str.charAt(j - 1);
					count = 1;
				}else {
					++count;
				}
			}
			val += ""+count + str.charAt(str.length() - 1);
			arr[i] = val;
			System.out.println(arr[i]);
		}
	}

	public static String countAndSay(int n) {
		if (!filled) {
			filled = true;
			fill();
		}

		return arr[n];
	}

	public static void main(String[] args) {
		System.out.println(countAndSay(4));
	}

}
