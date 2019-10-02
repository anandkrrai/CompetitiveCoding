package SegTree;

public class segTree2D {

	public static void main(String[] args) {

		int[][] matrix = { 
				{ 3, 0, 1, 4, 2 },
				{ 5, 6, 3, 2, 1 }, 
				{ 1, 2, 0, 1, 5 },
				{ 4,1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };
		NumMatrix obj = new NumMatrix(matrix);

		System.out.println(obj.sumRegion(2, 1, 4, 3));
		System.out.println(obj.sumRegion(1, 1, 2, 2));
		System.out.println(obj.sumRegion(1, 1, 2, 4));

	}

}
