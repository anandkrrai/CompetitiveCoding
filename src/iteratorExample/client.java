package iteratorExample;

public class client {
	public static void main(String[] args) {

		BT bt = new BT();

		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		bt.constructTree(arr);

		// TODO : want some public function so that type of iterator can be selected
		// method1 , send the dependency in the constructor of BT by doing this i can
		// dynamically select the type of iterator but if i want to change the type of
		// iterator on the go , it won't be possible because it will be fixed in
		// iterator()

		for (Node node : bt) {
			System.out.println(node);
		}

	}

}
