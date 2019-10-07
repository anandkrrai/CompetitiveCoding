import java.util.*;

public class Add {



	public boolean shouldSwap(int[] nums, int index) {
		for (int i = index + 1; i < nums.length; ++i) {
			if (nums[i] == nums[index])
				return false;
		}
		return true;
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		permu(nums, 0, list);
		return list;
	}

	public void permu(int[] nums, int vidx, List<List<Integer>> list) {
		if (vidx == nums.length) {
			List<Integer> l = new ArrayList<Integer>();
			for (int val : nums)
				l.add(val);
			list.add(l);
			return;
		}

		for (int i = vidx; i < nums.length; ++i) {
			if (shouldSwap(nums, i)) {
				swap(nums, vidx, i);
				permu(nums, vidx + 1, list);
				swap(nums, vidx, i);
			}
		}
	}

	public List<String> getStrings(boolean[][] arr) {
		List<String> rv = new ArrayList<String>();
		for (boolean[] bools : arr) {
			StringBuilder str = new StringBuilder("");
			for (boolean bool : bools)
				str.append(bool == true ? 'Q' : '.');
			rv.add(str.toString());
		}
		return rv;
	}

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> rv = new ArrayList<>();
		boolean[][] arr = new boolean[n][n];
		fill(arr, 0, rv);
		return rv;
	}

	public boolean isSafe(boolean[][] arr, int row, int col) {
		for (int j = 0; j < arr[0].length; ++j) {
			if (arr[row][j])
				return false;
		}
		int i = row, j = col;

		while (i >= 0 && j >= 0) {
			if (arr[i][j])
				return false;
			--i;
			--j;
		}
		i = row;
		j = col;
		while (i < arr.length && j < arr[0].length) {
			if (arr[i][j])
				return false;
			++i;
			++j;
		}

		return true;
	}

	public void fill(boolean[][] arr, int row, List<List<String>> rv) {
		if (row == arr.length) {
			rv.add(getStrings(arr));
			return;
		}

		for (int i = 0; i < arr[0].length; ++i) {
			if (isSafe(arr, row, i)) {
				arr[row][i] = true;
				fill(arr, row + 1, rv);
				arr[row][i] = false;
			}
		}
	}

	public static void main(String[] args) {
		int x = -500, y = 61;
		int and = x & y, ans = x ^ y;
		and = and << 1;
		while (and != 0) {
			int temp = and & ans;
			ans = ans ^ and;
			and = temp;
			and = and << 1;
		}
		System.out.println(ans);

	}

}
