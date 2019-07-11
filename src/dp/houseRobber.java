package dp;

public class houseRobber {
	public int rob(int[] arr) {
		int include = 0, exclude = 0;
		for (int i = 0; i < arr.length; ++i) {
			int newinc = Math.max(include, exclude + arr[i]);
			exclude = Math.max(include, exclude);
			include = newinc;
		}
		return Math.max(include, exclude);
	}
}
