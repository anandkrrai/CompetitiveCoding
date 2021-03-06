package cc;

import java.util.Scanner;

public class markAndToys {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		in.close();
		a=mergesort(a.length-1, 0, a);
//		System.out.println(maxtoys(a, 0, k));
		int price=0,count=0,i=0;
		while(price<k){
			price+=a[i];
			if(price>k)
				break;
			++count;
			++i;
			
		}
		System.out.println(count);
	}
//fails for very large input.
	private static int maxtoys(int[] a, int vidx, int money_left) {
		if(vidx==a.length)
			return 0;
		if (money_left == 0) {
			return 0;
		}
		if(money_left<a[vidx])
			return 0;
		int count1 = 0, count2 = 0;
		count1 = maxtoys(a, vidx + 1, money_left);
		if (money_left - a[vidx] > -1)
			count2 = maxtoys(a, vidx + 1, money_left - a[vidx]);
		if (count1 > count2)
			return count1;
		else
			return count2+1;

	}
	public static int[] merge(int[] one, int[] two) {
		int[] arr = new int[one.length + two.length];
		int i = 0, j = 0, k = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				arr[k] = one[i];
				++i;

			} else {
				arr[k] = two[j];
				++j;
			}
			++k;
		}
		while (i < one.length) {
			arr[k] = one[i];
			++i;
			++k;
		}
		while (j < two.length) {
			arr[k] = two[j];
			++j;
			++k;
		}
		return arr;
	}

	public static int[] mergesort(int hi, int lo, int arr[]) {
		if (hi == lo) {
			int[] a = new int[1];
			a[0] = arr[hi];
			return a;
		}

		int mid = (hi + lo) / 2;
		int[] one = mergesort(hi, mid + 1, arr);
		int[] two = mergesort(mid, lo, arr);
		int[] result = merge(one, two);
		return result;
	}

}
