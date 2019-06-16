import java.util.Arrays;
import java.util.Scanner;

public class nextSmaller {

	public static int[] smaller(int[] arr) {
		int[] rv = new int[arr.length];
		Arrays.fill(rv, -1);

		for (int i = 0; i < arr.length; ++i) {
			for (int j = i + 1; j < arr.length; ++j) {
				if (arr[j] < arr[i]) {
					arr[i] = arr[j];
					break;
				}
			}
		}

		return rv;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		int[] ans = smaller(arr);
		for (int i : ans)
			System.out.println(i);
	}

}
