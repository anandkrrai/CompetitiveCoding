import java.util.ArrayList;
import java.util.LinkedList;

public class Test {
	public static class Node {

	}

	public static void main(String[] args) {
		ArrayList ar = new ArrayList();
		ar.add(2);
		ar.add("as");
		ar.add(new Node());
		for (int i = 0; i < ar.size(); ++i) {
			System.out.println(ar.get(i));
		}

		LinkedList<Integer> list = new LinkedList();
		list.add(3);
		System.out.println(list);
		
		Integer b=2,c=2;
		System.out.println(b.hashCode());
		System.out.println(c.hashCode());
	}
}
