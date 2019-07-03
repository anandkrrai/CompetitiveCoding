package rangeQuery;

public class SquareRootDecomosition {
	static int[] originalArray;
	static int[] sumArray;
	static int sizeOfBlock, numberOfBlock;

	public static void build(int[] arr) {
		originalArray = arr;
		numberOfBlock = (int) Math.sqrt(arr.length);
		sizeOfBlock = numberOfBlock;

		sumArray = new int[numberOfBlock];

		for (int i = 0; i < numberOfBlock * numberOfBlock; ++i) {
			int bi = i / sizeOfBlock;
			sumArray[bi] += arr[i];
		}

	}

	public static int query(int l, int r) {
		int sum = 0;

		int lbi = l / sizeOfBlock;
		int rbi = r / sizeOfBlock;

		if (lbi == rbi)
			return trivial(l, r);

		// loop1
		for (int i = l; i / sizeOfBlock == lbi; ++i) {
			sum += originalArray[i];
		}

		// loop2

		for (int i = lbi + 1; i < rbi; ++i) {
			sum += sumArray[i];
		}

		// loop3
		for (int i = r; i / sizeOfBlock == rbi; --i) {
			sum += originalArray[i];
		}
		return sum;
	}

	private static int trivial(int l, int r) {
		int sum = 0;
		for (int i = l; i <= r; ++i) {
			sum += originalArray[i];
		}
		return sum;
	}

	public static void update(int data, int index) {
		sumArray[index / sizeOfBlock] += data - originalArray[index];
		originalArray[index] = data;
	}

	public static void main(String[] args) {
//		int arr[] = { 88, 70, 30, 56, 29, 2, 71, 50, 92, 53, 75, 79, 73, 49, 17, 65, 29, 14, 92, 79, 16, 91, 46, 69, 54,
//				69, 11, 24, 98, 89, 30, 48, 31, 85, 51, 16, 34, 81, 36, 69, 90, 12, 25, 36, 44, 93, 3, 95, 60 };

		int arr[] = { 88, 70, 30, 56, 29, 2, 71, 50, 92, 53, 75, 79, 73, 49, 17, 65, 29, 14, 92, 79, 16, 91, 46, 69, 54,
				69, 11, 24, 98, 89, 30, 48, 31, 85, 51, 16, 34, 81, 36, 69, 90, 12, 25, 36, 44, 93, 3, 95, 60, 10000, 20000,30000,40000 };

		build(arr);
//		System.out.println(Arrays.toString(arr));

		System.out.println(query(45, 51));
//		System.out.println(query(11, 36));
//		System.out.println(query(1, 20));
//		System.out.println(query(25, 27));
//		update(100, 15);
//		System.out.println(query(15, 46));
//		System.out.println(query(11, 36));
//		System.out.println(query(1, 20));
//		System.out.println(query(25, 27));
	}

}
