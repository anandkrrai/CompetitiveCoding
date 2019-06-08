
public class Restaurants {
	public static void main(String[] args) {
		int[][] arr = { { 1, 0, 9, 3, 6, 7 }, { 1, 3, 7, 9, 0, 0 }, { 4, 2, 0, 6, 1, 8 }, { 2, 8, 1, 4, 2, 3 },
				{ 0, 5, 0, 5, 6, 4 }, { 2, 4, 7, 8, 1, 5 } };
		int[][] maxcost = MaxGoldMine(arr);
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < maxcost.length; i++) {
			if (max < maxcost[i][0]) {
				max = maxcost[i][0];
			}
		}
		
		for (int i = 0; i < maxcost.length; i++) {
			if (maxcost[i][0] == max) {
				MaxGoldMinePath(maxcost, i, 0, "");
			}
		}
		
		private static boolean checkTree(BinaryTreeNode root1, BinaryTreeNode root2) {
			if(root1==null && root2 ==null)
				return true;
			
			if (root1 != null && root2 != null)  
	            return (root1.data == root2.data && checkTree(root1.left, root2.left) 
	                    && checkTree(root1.right, root2.right)); 
	        return false; 
		}
	}

	private static void MaxGoldMinePath(int[][] maxcost, int i, int j, String path) {
		if (j == maxcost[0].length - 1) {
			System.out.println(path);
			return;
		} else if (i == 0) {
			int max = Integer.max(maxcost[i][j + 1], maxcost[i + 1][j + 1]);
			if (max == maxcost[i][j + 1]) {
				MaxGoldMinePath(maxcost, i, j + 1, path + " " + maxcost[i][j + 1]);
			}
			if (max == maxcost[i + 1][j + 1]) {
				MaxGoldMinePath(maxcost, i + 1, j + 1, path + " " + maxcost[i + 1][j + 1]);
			}
		} else if (i == maxcost.length - 1) {
			int max = Integer.max(maxcost[i][j + 1], maxcost[i - 1][j + 1]);
			if (max == maxcost[i][j + 1]) {
				MaxGoldMinePath(maxcost, i, j + 1, path + " " + maxcost[i][j + 1]);
			} else if (max == maxcost[i - 1][j + 1]) {
				MaxGoldMinePath(maxcost, i - 1, j + 1, path + " " + maxcost[i - 1][j + 1]);
			}
		} else {
			int max = Integer.max(Integer.max(maxcost[i][j + 1], maxcost[i - 1][j + 1]), maxcost[i + 1][j + 1]);
			if (max == maxcost[i - 1][j + 1]) {
				MaxGoldMinePath(maxcost, i - 1, j + 1, path + " " + maxcost[i - 1][j + 1]);
			} else if (max == maxcost[i][j + 1]) {
				MaxGoldMinePath(maxcost, i, j + 1, path + " " + maxcost[i][j + 1]);
			} else if (max == maxcost[i + 1][j + 1]) {
				MaxGoldMinePath(maxcost, i + 1, j + 1, path + " " + maxcost[i + 1][j + 1]);
			}
		}
	}

	private static int[][] MaxGoldMine(int[][] arr) {
		int[][] cost = new int[arr.length][arr[0].length];

		for (int j = cost[0].length - 1; j >= 0; j--) {
			for (int i = cost.length - 1; i >= 0; i--) {

				if (j == cost[0].length - 1) {
					cost[i][j] = arr[i][j];
				} else if (i == arr.length - 1) {
					cost[i][j] = Integer.max(cost[i][j + 1], cost[i - 1][j + 1]) + arr[i][j];
				} else if (i == 0) {
					cost[i][j] = Integer.max(cost[i + 1][j + 1], cost[i][j + 1]) + arr[i][j];
				} else {
					cost[i][j] = Integer.max(Integer.max(cost[i - 1][j + 1], cost[i][j + 1]), cost[i + 1][j + 1])
							+ arr[i][j];
				}
			}
		}

		for (int i = 0; i < cost.length; i++) {
			for (int j = 0; j < cost[0].length; j++) {
				System.out.print(cost[i][j] + " ");
			}
			System.out.println();
		}
		return cost;
	}

}