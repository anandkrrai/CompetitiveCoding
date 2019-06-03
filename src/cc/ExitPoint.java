package cc;

import java.util.Scanner;

public class ExitPoint {

	public static boolean help(int[][] arr, int i, int j) {
		if (i >= arr.length || j >= arr[0].length || i < 0 || j < 0)
			return true;
		else {
			return false;
		}
	}

	public static boolean exitHelper(int[][] arr, int i, int j, int[] x, int[] y, int dir) {

		for (int k = 0; k < 4; ++k) {
			dir = (dir + 1) % 4;
			if (help(arr, i, j)) {
				System.out.println(i + ", " + j);
				return true;
			}
			if (i + x[dir] >= arr.length || j + y[dir] >= arr[0].length || i + x[dir] < 0 || j + y[dir] < 0) {
				boolean rv = exitHelper(arr, i + x[dir], j + y[dir], x, y, dir);
				if (rv)
					return true;
			}
		}
		return false;
	}

	public static void exitPoint(int[][] arr) {

		int[] x = { 0, 1, 0, -1 };
		int[] y = { 1, 0, -1, 0 };

		exitHelper(arr, 0, 0, x, y, 0);

	}

	public static boolean done = false;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int r = scn.nextInt();
		int c = scn.nextInt();
		int[][] arr = new int[r][c];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}

		}
		exitPoint(arr);
	}

}
