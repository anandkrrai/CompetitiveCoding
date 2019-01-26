package cc;

public class gfg_sentences {

	public static void main(String[] args) {
		String[][] arr = { { "you", "we" }, { "have", "are" }, { "sleep", "eat", "drink" } };

		printSen(arr, 0, 0, "");
	}

	private static void printSen(String[][] arr, int row, int col, String str) {

		if (row >= arr.length) {
			System.out.println(str);
			return;
		}

		for (int i = 0; i < arr[row].length; ++i) {
			printSen(arr, row + 1, i, str + " " + arr[row][i]);
		}
	}

}
