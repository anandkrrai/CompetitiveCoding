package cc;

public class gfg_searchWirdin2D {

	public static void main(String[] args) {

		String[] grid = { "GEEKSFORGEEKS", "GEEKSQUIZGEEK", "IDEQAPRACTICE" };

		patternSearch(grid, "GE");
		patternSearch(grid, "EEE");
	}

	private static void patternSearch(String[] grid, String pattern) {

		int x[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int y[] = {-1, 0, 1, -1, 1, -1, 0, 1 };
		int tempX, tempy;

		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[i].length(); ++j) {
				if (pattern.charAt(0) == grid[i].charAt(j)) {
					int k, p;
					for (k = 0; k < x.length; ++k) {
						tempX = i;
						tempy = j;
						for (p = 1; i < pattern.length(); ++p) {
							tempX += x[k];
							tempy += y[k];
							if (tempX < 0 || tempy < 0 || tempX >= grid.length || tempy >= grid[i].length()
									) {
								break;
							}
							if(pattern.charAt(p) != grid[tempX].charAt(tempy)) {
								break;								
							}
						}
						if (p == x.length) {
							System.out.println(i + " " + j);
							return;
						}
					}

				}
			}
		}
}

}
