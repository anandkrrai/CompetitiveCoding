package java_ada;

public class min_steps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 0, 2, 2, 0, 4, 0, 3, 1, 2, 0, 1 };
		int[] one = {0,1,1,2,3,1};
		System.out.println(min_steps(arr));
	}

	private static Integer min_steps(int[] arr) {
		Integer[] strg = new Integer[arr.length];

		strg[arr.length - 1] = 0;
		for (int i = arr.length - 2; i >= 0; i--) {

			for (int j = i + 1; j <= i + arr[i] && j < strg.length; j++) {
				if (strg[j] != null) {
					strg[i] = strg[i] == null ? strg[j] + 1 : Math.min(strg[i], strg[j] + 1);
				}
			}
		}

		return strg[0];

	}

}
