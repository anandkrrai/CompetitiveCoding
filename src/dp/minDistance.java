package dp;

public class minDistance {
	public int minDistance(String word1, String word2) {
		int[][] arr = new int[word1.length() + 1][word2.length() + 1];
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = arr[0].length - 1; j >= 0; j--) {
				if (i == arr.length - 1 && j == arr[0].length - 1) {
					arr[i][j] = 0;
				} else if (i == arr.length - 1) {
					arr[i][j] = arr[i][j + 1] + 1;
				} else if (j == arr[0].length - 1) {
					arr[i][j] = arr[i + 1][j] + 1;
				} else {
					if (word1.charAt(i) == word2.charAt(j)) {
						arr[i][j] = arr[i + 1][j + 1];
					} else {
						arr[i][j] = Math.min(Math.min(arr[i + 1][j + 1], arr[i + 1][j]), arr[i][j + 1]) + 1;
					}
				}
			}
		}
		return arr[0][0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
