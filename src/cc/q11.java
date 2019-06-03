package cc;

import java.util.Scanner;

//public static int MaxPathSum(TreeNode node) {
//    if(node==null)
//        return 0;
//
//    return Math.max(MaxPathSum(node.left),MaxPathSum(node.right))+node.val;
//}
public class q11 {

	static void rotateMatrix(int n, int mat[][]) {
		int[][] arr = new int[n][n];

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				arr[i][j] = mat[i][n - j - 1];
			}
		}
		
		
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				mat[i][j] = arr[j][i];
			}
		}

//		displayMatrix(n, arr);
//		displayMatrix(n, mat);
	}

	static void displayMatrix(int N, int mat[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(mat[i][j] + " ");

			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[][] mat = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = scn.nextInt();
			}
		}

		rotateMatrix(n, mat);
		displayMatrix(n, mat);
	}

//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		int t = scan.nextInt();
//
//		while (t-- > 0) {
//			int n = scan.nextInt();
//			int[] arr = new int[n];
//			for (int i = 0; i < n; ++i) {
//				arr[i] = scan.nextInt();
//			}
//		}
//
//		scan.close();
//	}

}
