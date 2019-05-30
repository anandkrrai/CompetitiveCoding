package cc;

import java.math.BigInteger;
import java.util.HashSet;

public class maxsubStringWithoutRepeatingChar {

	public static void main(String[] args) {
////		System.out.println(lengthOfLongestSubstring("abccdef"));
//		String st = "ana   nd  &^%$$@!@#$%^&*()@anand";
//		st = st.replaceAll("[^a-zA-z]", "  ");
//		st = st.trim();
////		st = st.replaceAll("[ ]", "");
//		System.out.println(st);
//
//		double i = 0.0;
//		System.out.println(i);
//		int[] a = {};
//		int[] b = { 1 };
//		BigInteger bd = new BigInteger("0");
//		System.out.println(bd.floatValue());
//		String str = "+1";
//		System.out.println(myAtoi(str));
//
//		System.out.println(isPalindrome(-23432));

//		System.out.println(findMedianSortedArrays(a, b));
//		System.out.println(reverse((long) 1534236469));
//		String s ="abc123 @#$^";
//		s = s.replaceAll("[^a-zA-z0-9]", " ");
//		System.out.println(s);
		System.out.println(isPalindrome("race a car"));

	}

	public static boolean isPalindrome1(String s) {
		s = s.replaceAll("[^a-zA-z0-9]", " ");
		s = s.toLowerCase();
		int l = 0, r = s.length() - 1;
		while (l < r) {
			if (!(s.charAt(l) >= 97 && s.charAt(l) <= 122) && !(s.charAt(l) >= 48 && s.charAt(l) <= 57)) {
				++l;
			} else if (!(s.charAt(r) >= 97 && s.charAt(r) <= 122) && !(s.charAt(r) >= 48 && s.charAt(r) <= 57)) {
				--r;
			} else if (s.charAt(l) == s.charAt(r)) {
				--r;
				++l;
			} else {
				return false;
			}
		}
		return true;
	}

	public static boolean isAlphaNUmerc(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch>='0' && ch<= '9');

	}

	public static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int l = 0, r = s.length() - 1;

		if (s.length() == 0)
			return true;

		while (l < r) {
			if (!isAlphaNUmerc(s.charAt(l))) {
				++l;
			} else if (!isAlphaNUmerc(s.charAt(r))) {
				--r;
			} else if (s.charAt(r) == s.charAt(l)) {
				++l;
				--r;
			}else {
				return false;
			}
		}
		return true;
	}

	public static int myAtoi(String str) {
		String ms = "";
		boolean isNegative = false, isNum = false, isSpaceFinished = false, ispositive = false;
		for (int i = 0; i < str.length(); ++i) {
			char ch = str.charAt(i);
			if (ch == ' ') {
				if (isNum || isNegative || isSpaceFinished || ispositive)
					break;
				else
					continue;
			} else if (ch >= 48 && ch < 58) {
				ms += ch;
				isNum = true;
				isSpaceFinished = true;
			} else if (ch == '-') {
				if (isNum || isNegative || isSpaceFinished || ispositive)
					break;
				isNegative = true;

			} else if (ch == '+') {
				if (isNum || isNegative || isSpaceFinished || ispositive)
					break;
				ispositive = true;

			} else {
				break;
			}
		}
		if (ms.length() == 0)
			return 0;
		else if (ms.length() >= 10) {
			if (isNegative)
				return Integer.MIN_VALUE;
			else
				return Integer.MAX_VALUE;
		}
		int number = Integer.parseInt(ms);
		if (isNegative)
			return number * -1;
		else
			return number;
	}

	public static float reverse(float x) {

		boolean flag = false;

		if (x < 0) {
			flag = true;
			x = x * -1;
		}
		String str = x + "";
		int[] arr = new int[str.length()];
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = str.charAt(i) - 48;
		}

		for (int i = 0; i < arr.length / 2; ++i) {
			int ch = Integer.parseInt(arr[i] + "");
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = ch;
		}
		str = "";
		for (int y : arr) {
			str += y;
		}
		BigInteger bigInteger = new BigInteger(str);
		x = bigInteger.floatValue();
		if (flag)
			return x * -1;
		else
			return x;
	}

	public static boolean isPalindrome(int x) {
		String str = x + "";
		for (int i = 0; i < str.length() / 2; ++i) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1))
				return false;
		}
		return true;
	}

	public String multiply(String num1, String num2) {
		BigInteger n2 = new BigInteger(num2);
		n2 = n2.multiply(new BigInteger(num1));
		return n2.toString();
	}

	public static int lengthOfLongestSubstring(String s) {
		int i = 0, j = 0, max = 0;
		HashSet<Character> set = new HashSet<>();

		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(i++));
			}
		}

		return max;
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double n1 = 0.0, n2 = 0.0;
		int l1 = nums1.length, l2 = nums2.length;
		if (l1 % 2 != 0) {
			n1 = nums1[l1 / 2];
		} else if (l1 != 0) {
			n1 = nums1[l1 / 2];
			n1 += nums1[(l1 / 2) - 1];
			n1 /= 2;
		}

		if (l2 % 2 != 0) {
			n2 = nums2[l2 / 2];
		} else if (l2 != 0) {
			n2 = nums2[l2 / 2];
			n2 += nums2[(l2 / 2) - 1];
			n2 /= 2;
		}

		return (n1 + n2) / 2;
	}
}