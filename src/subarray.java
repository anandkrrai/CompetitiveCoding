import java.util.HashMap;

public class subarray {

	public static boolean solve(int[] num1, int[] num2) {
        HashMap<Integer,Integer> map =new HashMap<>();
        
        for(int val : num1){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        
        for(int val:num2){
            if(map.getOrDefault(val,0)>0){
                map.put(val,map.getOrDefault(val,0)-1);
            }else{
                return false;
            }
        }
         
         return true;
     }
	
	 public static boolean isTwoArrayEqual(long[] num1, long[] num2) {
		   HashMap<Long,Integer> map =new HashMap<>();
		        
		        for(long val : num1){
		            map.put(val,map.getOrDefault(val,0)+1);
		        }
		        
		        for(long val:num2){
		              int ans=map.getOrDefault(val,0);

		              if(ans<=0)
		                return false;
		                
		                if(ans-1>0)
		                map.put(val,ans-1);
		           
		        }
		        if(map.size()>0)
		        return false;
		         
		         return true; 	 
		 
		 	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
