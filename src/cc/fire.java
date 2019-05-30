package cc;

import java.util.LinkedList;

public class fire {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 0, 0, 0 }, { 1, 2, 1 }, { 2, 0, 0 } };
		int[][] grid = { { 0, 0, 2, 0, 0, 0, }, { 0, 1, 1, 0, 1, 1 }, { 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1, 1 },
				{ 0, 1, 1, 2, 0, 0, } };

		Fire(grid);

	}

	public static class Helper {
		int i, j;
		int time;

		public Helper(int i, int j, int time) {
			this.i = i;
			this.j = j;
			this.time = time;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "the block @ " + i + " ," + j + "  burnt @ time =" + time;
		}

	}

	// 0-wood
	// 1-water;
	// 2=fire
	
	

	public static void Fire(int[][] arr) {
		LinkedList<Helper> list = new LinkedList<Helper>();

		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[0].length; ++j) {
				if (arr[i][j] == 2) {
					Helper helper = new Helper(i, j, 0);
					list.add(helper);
				}
			}
		}
		while (list.size() != 0) {
			Helper rem = list.removeFirst();
			System.out.println(rem);

			int i = rem.i, j = rem.j;

			if (i + 1 < arr.length && arr[i + 1][j] == 0) {
				Helper helper = new Helper(i + 1, j, rem.time + 1);
				arr[i + 1][j] = 2;
				list.add(helper);
			}

			if (i - 1 >= 0 && arr[i - 1][j] == 0) {
				Helper helper = new Helper(i - 1, j, rem.time + 1);
				list.add(helper);
				arr[i - 1][j] = 2;

			}

			if (j + 1 < arr[0].length && arr[i][j + 1] == 0) {
				Helper helper = new Helper(i, j + 1, rem.time + 1);
				list.add(helper);
				arr[i][j + 1] = 2;

			}

			if (j - 1 >= 0 && arr[i][j - 1] == 0) {
				Helper helper = new Helper(i, j - 1, rem.time + 1);
				list.add(helper);
				arr[i][j - 1] = 2;

			}

		}

	}

}
