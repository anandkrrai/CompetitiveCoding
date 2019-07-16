package iteratorExample;

public class client {
	public static void main(String[] args) {

		BT bt = new BT();

		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		bt.constructTree(arr);
//		bt.display();

		for (Node node : bt) {
			System.out.println(node);
		}

	}

}
