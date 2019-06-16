import java.util.LinkedList;
import java.util.Scanner;

public class LinkedLIstInterseaction {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int n1 = s.nextInt();
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		for (int i = 0; i < n1; ++i) {
			l1.addLast(s.nextInt());
		}

		int n2 = s.nextInt();
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		for (int i = 0; i < n2; ++i) {
			l2.addLast(s.nextInt());
		}

		boolean first = true;
		while (true) {
			
			if (first) {
				if (l1.size() == 0)
					break;
				
				System.out.print(l1.removeFirst() + " ");
				first = false;
			} else {
				if (l2.size() == 0)
					break;
				System.out.print(l2.removeFirst() + " ");

				first = true;
			}

		}

		if (l1.size() != 0) {

			while (l1.size() != 0) {
				System.out.print(l1.removeFirst() + " ");
			}
		} else {
			System.out.println();

			while (l2.size() != 0) {
				System.out.print(l2.removeFirst() + " ");
			}
		}

	}

}
