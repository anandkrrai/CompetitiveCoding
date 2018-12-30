package cc;
/*package whatever //do not write package name here */

import java.util.*;

class Sum {
    
    public static void findSets(int[] arr,int k){
        HashMap<String,Boolean> map = new HashMap<String,Boolean>();
            helper(arr,0,k,0,"(",map);
            
            if(map.size()==0){
                System.out.print("Empty");
            }
}
    
    public static void helper(int[] arr ,int vidx,int k,int sum,String ans,HashMap<String,Boolean> map){
       
        if(k==sum){
        	String key=ans.substring(0,ans.length()-1)+")";
            if(map.containsKey(key))
            	return;
            map.put(key,true);
            System.out.print(key);
            return;
        }
        
        if(vidx>=arr.length||sum>k){
            return;
        }
        
        helper(arr,vidx+1,k,sum+arr[vidx],ans+""+arr[vidx]+" ",map);
        helper(arr,vidx+1,k,sum,ans,map);
    }
    
public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();

		while (t > 0) {
			--t;
			int n = scan.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < n; ++i) {
					arr[i] = scan.nextInt();
			}
			int k = scan.nextInt();
			Arrays.sort(arr);
            findSets(arr,k);
            System.out.println();
		}
		scan.close();
	}
}