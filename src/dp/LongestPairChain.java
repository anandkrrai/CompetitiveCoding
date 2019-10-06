package dp;

import java.util.*;

public class LongestPairChain {

	public static int findLongestChain(int[][] pairs) {

		Comparator<int[]> cmp = new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		};
		Arrays.sort(pairs, cmp);
		int i=0,j=0,rv=0;
		
		while(i<pairs.length) {
			
		}
		
		
		return rv;
	}
}