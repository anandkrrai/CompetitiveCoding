import java.util.*;

public class RelativeSort {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr2.length; ++i) {
			map.put(arr2[i], i);
		}

		Comparator<Integer> cmp = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return map.get(o1) - map.get(o2);
			}
		};
		Integer[] iarr = new Integer[arr1.length];
		for (int i = 0; i < arr1.length; ++i)
			iarr[i] = arr1[i];
		Arrays.sort(iarr, cmp);
		for (int i = 0; i < arr1.length; ++i)
			arr1[i] = iarr[i];
		return arr1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
