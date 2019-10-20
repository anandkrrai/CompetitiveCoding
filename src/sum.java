import java.util.ArrayList;
import java.util.Collections;

public class sum {
	public static int getSum(int a, int b) {
		int sum = a ^ b;
		int carry = a & b;
		System.out.print(" sum=" + sum);
		System.out.println(" carry=" + carry);
		if (carry == 0)
			return sum;
		else
			return getSum(sum, carry << 1);

	}

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(-1));
		getSum(5, -1);
	}

	public double largestTriangleArea(int[][] points) {
		ArrayList<Double> list = new ArrayList<>();
		for (int i = 0; i < points.length; ++i) {
			for (int j = i + 1; j < points.length; ++j) {
				list.add(Math.sqrt((points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
						+ (points[i][1] - points[j][1]) * (points[i][1] - points[j][1])));
				System.out.println(i + " " + j + " " + list.get(list.size() - 1));
			}
		}
		Collections.sort(list);
		int i = list.size() - 1;
		while (i >= 2) {
			if (list.get(i) >= list.get(i - 1) + list.get(i - 2)) {
				--i;
			} else {
				double a = list.get(i);
				double b = list.get(i - 1);
				double c = list.get(i - 2);

				double s = (double) (a + b + c) / 2;
				double area = s * (s - a) * (s - b) * (s - c);
				return Math.sqrt(area);
			}
		}
		return 0;
	}

}
