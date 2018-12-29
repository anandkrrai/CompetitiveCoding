package cc;

public class plindrome {

	public static void main(String[] args) {
//		System.out.println(palindrome("bdshvfhsd"));
		int[] arr = { 1, 2, 3, 4,5,66,66, 4, 3, 2, 1 };
		
		System.out.println(palindrome(arr));
	}

//	private static int palindrome(String s) {
//		int count = 0;
//
//		double axis = 0, orbit;
//		for (axis = 0; axis < s.length(); ++axis) {
//			for (orbit = 0; orbit <= s.length() / 2; ++orbit) {
//
//				if (axis + orbit >= s.length() || axis - orbit < 0) {
//					break;
//
//				}
//				if (s.charAt((int) (axis + orbit)) == s.charAt((int) (axis - orbit))) {
//					++count;
//				} else {
//					break;
//				}
//			}
//		}
//		for (axis = 0.5; axis < s.length(); ++axis) {
//			for (orbit = 0.5; orbit <= s.length() / 2; ++orbit) {
//
//				if (axis + orbit >= s.length() || axis - orbit < 0) {
//					break;
//
//				}
//				if (s.charAt((int) (axis + orbit)) == s.charAt((int) (axis - orbit))) {
//					++count;
//				} else
//					break;
//			}
//		}
//
//		return count;
//	}

	private static int palindrome(int[] arr) {
		int count = 0, count2 = 0, temp = 0, temp2 = 0;

		double axis = 0, orbit;
		for (axis = 0; axis < arr.length; ++axis) {
			count = -1;
			for (orbit = 0; orbit <= arr.length / 2; ++orbit) {

				if (axis + orbit >= arr.length || axis - orbit < 0) {
					break;

				}
				if (arr[(int) (axis + orbit)] == arr[(int) (axis - orbit)]) {
					count+=2;
				} else {
					break;
				}
			}
			temp = temp > count ? temp : count;
		}
		
		
		for (axis = 0.5; axis < arr.length; ++axis) {
			count2 = 0;
			for (orbit = 0.5; orbit <= arr.length / 2; ++orbit) {

				if (axis + orbit >= arr.length || axis - orbit < 0) {
					break;

				}
				if (arr[(int) (axis + orbit)] == arr[(int) (axis - orbit)]) {
					count2+=2;
				} else {
					break;
				}
			}

			temp2 = temp2 > count2 ? temp2 : count2;

		}
		return temp > temp2 ? temp : temp2;
	}

}
