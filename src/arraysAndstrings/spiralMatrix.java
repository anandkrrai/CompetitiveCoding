package arraysAndstrings;

//https://leetcode.com/problems/spiral-matrix/submissions/
import java.util.*;

public class spiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if (matrix.length == 0)
			return list;
		int cr = matrix[0].length - 1, cl = 0, ru = 0, rl = matrix.length - 1;

		int count = 0;
		int size = matrix.length * matrix[0].length;
		while (count < size) {
			for (int i = cl; i <= cr && count < size; ++i) {
				list.add(matrix[ru][i]);
				++count;
			}
			++ru;

			for (int i = ru; i <= rl && count < size; ++i) {
				list.add(matrix[i][cr]);
				++count;
			}
			--cr;

			for (int i = cr; i >= cl && count < size; --i) {
				list.add(matrix[rl][i]);
				++count;
			}
			--rl;

			for (int i = rl; i >= ru && count < size; --i) {
				list.add(matrix[i][cl]);
				++count;
			}
			++cl;

		}

		return list;
	}
}
