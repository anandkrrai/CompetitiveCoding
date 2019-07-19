package arraysAndstrings;

import java.util.*;

public class islands {

	public class Pair {
		int i;
		int j;

		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public boolean isValid(boolean[][] arr, char[][] grid, int i, int j) {
		if (i >= arr.length || j >= arr[0].length || i < 0 || j < 0) {
			return false;
		} else if (grid[i][j] == '0' || arr[i][j] == true) {
			return false;
		} else {
			return true;
		}
	}

	public int numIslands(char[][] grid) {
		if (grid.length == 0)
			return 0;
		boolean[][] arr = new boolean[grid.length][grid[0].length];
		int count = 0;
		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[0].length; ++j) {

				if (arr[i][j] == true || grid[i][j] == '0')
					continue;

				++count;

				Pair pair = new Pair(i, j);
				LinkedList<Pair> q = new LinkedList<>();
				q.addLast(pair);

				while (q.size() != 0) {
					Pair rem = q.removeFirst();
					if (arr[rem.i][rem.j] == true)
						continue;
					arr[rem.i][rem.j] = true;

					if (isValid(arr, grid, rem.i, rem.j + 1)) {
						q.addLast(new Pair(rem.i, rem.j + 1));
					}

					if (isValid(arr, grid, rem.i + 1, rem.j)) {
						q.addLast(new Pair(rem.i + 1, rem.j));
					}

					if (isValid(arr, grid, rem.i - 1, rem.j)) {
						q.addLast(new Pair(rem.i - 1, rem.j));
					}

					if (isValid(arr, grid, rem.i, rem.j - 1)) {
						q.addLast(new Pair(rem.i, rem.j - 1));
					}

				}

			}
		}
		return count;
	}

	public int numIslands_dfs(char[][] grid) {
		int count = 0;
		boolean[][] arr = new boolean[grid.length][grid[0].length];
		
		for(int i=0;i<grid.length;++i) {
			for(int j=0;j<grid[0].length;++j){
				if(arr[i][j]==false&&grid[i][j]=='1') {
					++count;
					Helper(grid,arr,i,j);
				}
			}
		}

		return count;
	}

	private void Helper(char[][] grid, boolean[][] arr, int i, int j) {
		
		arr[i][j]=true;
	
		if(isValid(arr, grid, i+1, j)) {
			Helper(grid, arr, i+1, j);
		}
		
		if(isValid(arr, grid, i, j+1)) {
			Helper(grid, arr, i, j+1);
		}
		
		if(isValid(arr, grid, i, j-1)) {
			Helper(grid, arr, i, j-1);
		}
		
		if(isValid(arr, grid, i-1, j)) {
			Helper(grid, arr, i-1, j);
		}
		
	}
}
