package arraysAndstrings;

public class subsets {
public List<List<Integer>> rv;
    
    public List<List<Integer>> subsets(int[] nums) {
        rv = new ArrayList<>();
        Helper(new ArrayList<Integer>(),nums,0);
        return rv;
    }
    
    public void Helper(List<Integer> list , int[] arr,int vidx){
        if(vidx==arr.length){
            rv.add(list);
            return;
        }
        
        ArrayList<Integer> l1 = new ArrayList<>(list);
        ArrayList<Integer> l2 = new ArrayList<>(list);
        
        l1.add(arr[vidx]);
        Helper(l2,arr,vidx+1);
        
        Helper(l1,arr,vidx+1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
