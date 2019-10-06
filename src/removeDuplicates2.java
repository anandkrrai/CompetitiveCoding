
public class removeDuplicates2 {
	public int removeDuplicates(int[] nums) {
		int i = 0, j = 0, hold = 0;

		for (i = 0; i < nums.length - 1; ++i) {
			if (nums[i] == nums[i + 1]) {
				++hold;
				if (hold <= 2) {
					nums[j++] = nums[i];
				}
			} else {
				nums[j++] = nums[i];
				hold = 0;
			}
		}

		return j;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
