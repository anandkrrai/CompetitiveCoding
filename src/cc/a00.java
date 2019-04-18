package cc;

import java.util.*;

public class a00 {

	static int summingSeries(long n) {
		int mod = 1000000007;
		return (int) ((n % mod) * (n % mod)) % mod;

	}

	public static String SortString(String str) {
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	public static String reverseString(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb = sb.reverse();
		return sb.toString();
	}

	public static String swap(String str, int i, int j) {
		StringBuilder sb = new StringBuilder(str);
		char ch = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, ch);
		return sb.toString();
	}

	public static String biggerIsGreater(String w) {
		int i = w.length() - 2;
		int largest = i;
		
		while (i >= 0) {
			if (w.charAt(largest) < w.charAt(i + 1)) {
				largest = i + 1;
			}
			if (w.charAt(i) < w.charAt(i + 1)) {
				break;
			}
			--i;
		}

		if (i == -1) {
			return "no answer";
		}

		int j = i + 1, nextSmaller = largest;
		while (j < w.length()) {
			if (w.charAt(j) > w.charAt(i) && w.charAt(nextSmaller) > w.charAt(j)) {
				nextSmaller = j;
			}
			++j;
		}

		w = swap(w, i, nextSmaller);

		return w.substring(0, i + 1) + reverseString(w.substring(i + 1));
	}

	public static void main(String[] args) {

		System.out.println(biggerIsGreater("zyyxwwtrrnmlggfeb"));
//		System.out.println(summingSeries(4762607));
//		System.out.println(SortString("anand"));
//		System.out.println(reverseString("anand"));
//		System.out.println(replace("anand", 0, 4));

//		int n = Integer.MAX_VALUE;
//		System.out.println(n);
//		System.out.println(Integer.toBinaryString(n));
//
//		n = Integer.MAX_VALUE << 1;
//		System.out.println(n);
//		System.out.println(Integer.toBinaryString(n));

//		for (int n = 0; n <= 10; ++n) {
//			System.out.println("n=" + n + " binary:" + Integer.toBinaryString(n));
//			System.out.println("n=-" + n + " binary:" + Integer.toBinaryString(-n));
//
//		}
	}

}
