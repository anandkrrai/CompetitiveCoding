package map_set;
//http://134.209.156.168:3004/resource/interview-prep/hmap-and-heaps/sum-of-length/ojquestion
import java.util.HashSet;

public class sumOfLength {

	public static int sumOfLength(int[] arr) {
		int rv = 0, start = 0, end = 0, len;
		HashSet<Integer> set = new HashSet<>();

		while (end < arr.length) {
			if (set.contains(arr[end])) {
				len = end - start;
				rv += ((len + 1) * (len)) / 2;
				set.remove(arr[start]);
				++start;
			} else {
				set.add(arr[end]);
				++end;
			}
		}

		while (start < arr.length) {
			len = end - start;
			rv += ((len + 1) * (len)) / 2;
			set.remove(arr[start]);
			++start;
		}
		return rv;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
