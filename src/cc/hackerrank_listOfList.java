package cc;

import java.util.*;

public class hackerrank_listOfList {
	
	
	 static int[] matchingStrings(String[] strings, String[] queries) {

	        HashMap<String,Integer> map = new HashMap<String,Integer>();
	        
	        for(String str :strings){
	            if(map.containsKey(str)){
	                map.put(str,map.get(str)+1);
	            }else{
	                map.put(str,1);
	            }
	        }

	        int[] rv = new int[queries.length];

	        for(int i=0;i<queries.length;++i){
	            if(map.containsKey(queries[i])){
	                rv[i]=map.get(queries[i]);
	            }
	        }

	        return rv;
	    }

	static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
		List<Integer> result = new ArrayList<Integer>();
		List<List<Integer>> lists = new ArrayList<List<Integer>>();

		for (int i = 0; i < n; ++i) {
			List<Integer> list = new ArrayList<Integer>();
			lists.add(list);
		}

		int lastanswer = 0;
		for (List<Integer> query : queries) {
			int num, x, y;
			num = query.get(0);
			x = query.get(1);
			y = query.get(2);
			int index = (x ^ lastanswer) % n;
//			System.out.println(index+"index");

			if (num == 1) {
				lists.get(index).add(y);
			} else {
				lastanswer = lists.get(index).get(y) % lists.get(index).size();
//				System.out.println(lastanswer);
				result.add(lastanswer);
			}

		}

		return result;

	}

	public static void main(String[] args) {
		List<Integer> one = new ArrayList<Integer>();
		List<Integer> two = new ArrayList<Integer>();
		List<Integer> three = new ArrayList<Integer>();
		List<Integer> four = new ArrayList<Integer>();
		List<Integer> five = new ArrayList<Integer>();

		one.add(1);
		one.add(0);
		one.add(5);

		two.add(1);
		two.add(1);
		two.add(7);

		three.add(1);
		three.add(0);
		three.add(3);

		four.add(2);
		four.add(1);
		four.add(0);

		five.add(2);
		five.add(1);
		five.add(1);

		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		lists.add(one);
		lists.add(two);
		lists.add(three);
		lists.add(four);
		lists.add(five);

		dynamicArray(2, lists);

	}

}
