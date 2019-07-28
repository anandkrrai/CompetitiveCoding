package arraysAndstrings;

public class findDuplicate {
	 public int findDuplicate(int[] nums) {
	        for(int i=0;i<nums.length;++i){
	            if(nums[Math.abs(nums[i])-1]<0){
	                return Math.abs(nums[i]);
	            }else{
	                nums[Math.abs(nums[i])-1]*=-1;
	            }
	        }
	        return 0;
	    }
}
