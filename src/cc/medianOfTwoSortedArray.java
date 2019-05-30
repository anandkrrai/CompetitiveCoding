package cc;

public class medianOfTwoSortedArray {

	public static void main(String[] args) {

		int[] nums2 = { 1, 2 };
		int[] nums1 = { 1, 2 };

	
		System.out.println(str);
		

		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		if (nums1.length == 0) {
			if (nums2.length % 2 == 0) {
				int index = nums2.length / 2;
				return (double) (nums2[index] + nums2[index - 1]) / 2;
			} else {
				return nums2[nums2.length / 2];
			}
		} else if (nums2.length == 0) {
			if (nums1.length % 2 != 0) {
				return nums1[nums1.length / 2];
			} else {
				int index = nums1.length / 2;
				return (double) (nums1[index] + nums1[index - 1]) / 2;
			}
		} else {

			double n1, n2;

			if (nums2.length % 2 == 0) {
				int index = nums2.length / 2;
				n2 = (double) (nums2[index] + nums2[index - 1]) / 2;
			} else {
				n2 = nums2[nums2.length / 2];
			}

			if (nums1.length % 2 != 0) {
				n1 = nums1[nums1.length / 2];
			} else {
				int index = nums1.length / 2;
				n1 = (double) (nums1[index] + nums1[index - 1]) / 2;
			}

			return (n1 + n2) / 2;
		}

	}

}
