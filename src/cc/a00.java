package cc;

import java.util.*;

public class a00 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = 30002;
		int[] arr = new int[size];
		Arrays.fill(arr, -1);
		for (int i = 1; i < size - 2; ++i) {
			for (int j = i + 1; j < size - 1; ++j) {
				int intVal = (int) Math.sqrt(i * i + j * j);
				if (intVal * intVal == i * i + j * j && intVal < size) {
					arr[intVal] = intVal * i * j;
				}
			}
		}
		for (int x : arr) {
			System.out.println(x);
		}

		int max = -1;
		for (int i = 0; i < size; ++i) {
			max = Math.max(arr[i], max);
			arr[i] = max;
		}
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			System.out.println(arr[n]);
		}
		in.close();
	}
}
