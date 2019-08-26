import java.util.ArrayList;

public class MakeAllSubSet {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		generateSubset(list, arr, 0, new ArrayList<Integer>());

		for (int i = 0; i < list.size(); ++i) {
			System.out.println(list.get(i));
		}
	}

	private static void generateSubset(ArrayList<ArrayList<Integer>> list, int[] arr, int vidx,
			ArrayList<Integer> subList) {
		if (vidx == arr.length) {
			list.add(new ArrayList<Integer>(subList));
			return;
		}

		subList.add(arr[vidx]);
		generateSubset(list, arr, vidx + 1, subList);
		subList.remove(subList.size() - 1);

		generateSubset(list, arr, vidx + 1, subList);

	}

}
