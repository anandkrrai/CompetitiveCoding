import java.util.ArrayList;
import java.util.Scanner;

public class maxRectangle {

	public static int maxArea(int[] arr) {
		int maxArea = -1;
		int i = 0;
		ArrayList<Integer> stack = new ArrayList<>();

		while (i < arr.length) {
			if (stack.size() == 0 || arr[stack.get(stack.size() - 1)] <= arr[i]) {
				stack.add(i);
				++i;
			} else {
				int top = stack.remove(stack.size() - 1);
				int breadth = 1;
				if (stack.size() != 0) {
					breadth = i - stack.get(stack.size() - 1) - 1;
				}
				maxArea = Math.max(maxArea, arr[top] * breadth);

			}
		}
		while (stack.size() != 0) {
			int top = stack.remove(stack.size() - 1);
			int breadth = 1;
			if (stack.size() != 0) {
				breadth = i - stack.get(stack.size() - 1) - 1;
			}
			maxArea = Math.max(maxArea, arr[top] * breadth);

		}
		return maxArea;
	}

	public static int maxrect(int arr[][]) {
		int[] help = new int[arr[0].length];
		int max = 0;
		for (int i = 0; i < arr.length; ++i) {

			for (int j = 0; j < help.length; ++j) {
				if (arr[i][j] == 0) {
					help[j] = 0;
				} else {
					help[j] += 1;
				}
			}

			max = Math.max(maxArea(help), max);
		}
		return max;

	}

	// Dont make changes
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int[][] A = new int[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				A[i][j] = sc.nextInt();

		System.out.println(maxrect(A));

	}
}
