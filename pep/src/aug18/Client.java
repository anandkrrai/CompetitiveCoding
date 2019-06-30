package aug18;

public class Client {

	public static void main(String[] args) {
		int[] arr = {10, 2, -3, 7, 6, -4, 8, -2};
		
		SegmentTree st = new SegmentTree(arr, new SegmentMinOperator());
		System.out.println(st.query(2, 5));
		System.out.println(st.query(3, 7));
		
		st.changeOperator(new SegmentMaxOperator());
		
		System.out.println(st.query(2, 5));
		System.out.println(st.query(3, 7));
	}

}
