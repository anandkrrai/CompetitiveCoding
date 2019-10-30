
public class ZAlgo {

	public static void main(String[] args) {
		
		String str = "aab%aabxaabxcaabxaabxay";
		for(int i=0;i<str.length();++i)
			System.out.print(str.charAt(i)+" ");
		int[] arr = zValues(str);
		System.out.println();
		for (int val : arr)
			System.out.print(val + " ");
	}

	private static int[] zValues(String str) {
		int[] z = new int[str.length()];
		int i = 0, k = 0, l = 0, r = 0;

		for (i = 1; i < str.length(); ++i) {
			if (i > r) {
				l = r = i;
				while (r < str.length() && str.charAt(r) == str.charAt(r - l)) {
					++r;
				}
				z[i] = r - l;
				--r;
			} else {
				k = i - l;
				if (z[k] + i < r) {
					z[i] = z[k];
				} else {
					l = i;
					while (r < str.length() && str.charAt(r) == str.charAt(r - l)) {
						++r;
					}
					z[i] = r - l;
					--r;
				}

			}
		}

		return z;
	}

}
