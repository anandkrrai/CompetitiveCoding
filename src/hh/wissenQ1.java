package hh;

import java.util.*;

public class wissenQ1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for (int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}

		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < n; ++i) {
			double loca_sum = 0, counter = 0;
			for (int j = i; j < n; ++j) {
				loca_sum += arr[j];
				++counter;
				double l_avg = (double) loca_sum / counter, 
						avg = (double) (sum - loca_sum) / (n - counter);

				if (counter == n || l_avg > avg) {
					++i;
					++j;
					list.add(i + " " + j);
					--i;
					--j;
				}
			}
		}

		System.out.println(list.size());
		for (String str : list)
			System.out.println(str);

		sc.close();
	}

}
