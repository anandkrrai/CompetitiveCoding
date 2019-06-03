package cc;
import java.util.*;

public class soln {
	public static Scanner scn = new Scanner(System.in);

	// This is a functional problem.
	// Input is managed for you.
	// Don't change main, write your code in the function below
	public static void main(String[] args) {
		int r = scn.nextInt();
		int c = scn.nextInt();
		int[][] arr = new int[r][c];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}
			int i = Integer.MIN_VALUE

		}
		exitPoint(arr);
	}

	public static void exitPoint(int[][] maze1) {
		// Write your code only here.
		int dir = 0;
		int row = 0;
		int col = 0;

		while (col >= 0 && col < maze1[0].length && row >= 0 && row < maze1.length) {

			dir = (dir + maze1[row][col]) % 4;

			if (dir == 0) {
				col++;
			} else if (dir == 1) {
				row++;
			} else if (dir == 2) {
				col--;
			} else if (dir == 3) {
				row--;
			}

		}
		if (dir == 0) {
			col--;
		} else if (dir == 1) {
			row--;
		} else if (dir == 2) {
			col++;
		} else {
			row++;
		}
		System.out.println(row + ", " + col);

	}
}