package hh;

public class TcsDir {

	public static void findDir(int n) {
		int x = 0, y = 0, steps = 10;
		for (int i = 0; i < n; ++i) {
			if (i % 4 == 0) {
				x += steps;
			} else if (i % 4 == 1) {
				y += steps;
			} else if (i % 4 == 2) {
				x -= steps;
			} else if (i % 4 == 3) {
				y -= steps;
			}
			steps += 10;
		}
		System.out.println(x + " " + y);
	}

	public static void main(String[] args) {
		findDir(2000);
	}

}
