package arraysAndstrings;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/submissions/
public class findMin {
	  public int findMin(int[] nums) {
	        int rv=nums[0];
	        
	        for(int val : nums){
	            if(rv>val)
	                return val;
	        }
	        return rv;
	    }
}
