import java.util.*;

public class PascalsTriangle {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> rv = new ArrayList<>();
		if (numRows == 0)
			return rv;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		rv.add(list);

		for (int i = 1; i < numRows; ++i) {
			list = new ArrayList<Integer>();
			List<Integer> temp = rv.get(rv.size() - 1);
			list.add(1);
			for (int j = 1; j < temp.size(); ++j)
				list.add(temp.get(j) + temp.get(j - 1));
			list.add(1);

			rv.add(list);
		}
		return rv;
	}

	public List<Integer> getRow(int numRows) {
		ArrayList<Integer> curr = new ArrayList<Integer>();
		curr.add(1);
		if (numRows == 0)
			return curr;

		for (int i = 1; i <= numRows; ++i) {
			List<Integer> prev = curr;
			curr = new ArrayList<Integer>();
			curr.add(1);
			for (int j = 1; j < prev.size(); ++j)
				curr.add(prev.get(j) + prev.get(j - 1));
			curr.add(1);
		}
		return curr;
	}

	public static void main(String[] args) {
		List<List<Integer>> rv = generate(5);
		for (List l : rv)
			System.out.println(l);
	}

}
