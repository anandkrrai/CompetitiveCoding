package arraysAndstrings;

public class floooooodFillll {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		ff(image, sr, sc, newColor, image[sr][sc]);
		return image;
	}

	public void ff(int[][] image, int sr, int sc, int newColor, int color) {
		if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
			return;
		}
		if (image[sr][sc] != color) {
			return;
		}
		image[sr][sc] = newColor;

		ff(image, sr + 1, sc, newColor, color);
		ff(image, sr - 1, sc, newColor, color);
		ff(image, sr, sc + 1, newColor, color);
		ff(image, sr, sc - 1, newColor, color);

	}

}
