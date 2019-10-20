import java.util.*;

public class EquivalenceClassTesting {

	public static void comb(char[] carr, int vidx, HashMap<String, String> rv, ArrayList<String> ans) {
		if (ans.size() == 3) {
			ArrayList<String> an = new ArrayList<>(ans);
			String val = an.toString();
			Collections.sort(an);
			rv.put(val, an.toString());
//			System.out.println(val);
			return;
		} else if (vidx == carr.length) {
			return;
		}

		ans.add(carr[vidx] + "");
		comb(carr, vidx, rv, ans);
		ans.remove(ans.size() - 1);

		comb(carr, vidx + 1, rv, ans);
	}

	public static void swap(char[] ar, int i, int j) {
		char temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}

	public static void permutation(char[] arr, int left, int right) {
		if (left > right) {
			System.out.println(Arrays.toString(arr));
			return;
		}

		for (int i = left; i <= right; ++i) {
			swap(arr, i, left);
			permutation(arr, left + 1, right);
			swap(arr, i, left);

		}
	}

	public static void main(String[] args) {
		char[] carr = { 'S', 'C', 'R' };
		permutation(carr, 0, 2);
		HashMap<String, String> map = new HashMap<String, String>();
		HashMap<String, Integer> indexMap = new HashMap<String, Integer>();
		comb(carr, 0, map, new ArrayList<String>());

		for (String key : map.keySet()) {
			if (!indexMap.containsKey(map.get(key))) {
				indexMap.put(map.get(key), indexMap.size() + 1);
			}
			System.out.println(indexMap.get(map.get(key)) + " " + map.get(key) + " " + key);
		}

	}

}
