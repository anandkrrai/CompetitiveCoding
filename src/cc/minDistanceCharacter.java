package cc;

import java.util.;

public class minDistanceCharacter {

	public static void main(String[] args) {

		int[] arr = shortestToChar("loveleetcode", 'e');
		for(int x:arr) {
			System.out.print(x+" ");
		}
	}

	public static int[] shortestToChar(String S, char C) {

		int[] arr = new int[S.length()];
		Arrays.fill(arr, Integer.MAX_VALUE);

		int num = 0, index = 0;
		for (int i = 0; i < S.length(); ++i) {
			if (S.charAt(i) == C) {
				++num;
				arr[i] = 0;
				if (num == 1) {
					index = i;
				}
			}
		}

		while (num-- > 0) {
			int j = index - 1, i = index + 1, step = 1;
			while (j >= 0) {
				arr[j] = Math.min(arr[j], step);
				--j;
				++step;
			}
			step = 1;
			while (i < arr.length) {
				if (arr[i] == 0) {
					index = i;
					break;
				}
				arr[i] = Math.min(arr[i], step);
				++i;
				++step;
			}
		}
		return arr;
	}

}
