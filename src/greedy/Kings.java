package greedy;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Kings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int A[] = new int[n];
			int B[] = new int[n];
			for (int j = 0; j < n; j++) {
				A[j] = sc.nextInt();
			}
			for (int j = 0; j < n; j++) {
				B[j] = sc.nextInt();
			}

			int ans = 0;
			
			Arrays.sort(A);
			Arrays.sort(B);
			reverse(A);
			reverse(B);

		
			int a = 0, b = 0;
			while (a < A.length && b < B.length) {
				if (A[a] > B[b]) {
					++a;
					++b;
					++ans;
				} else {
					++b;
				}
			}

			System.out.println(ans);
		}
	}

	private static void reverse(int[] ar) {
		for(int i=0;i<ar.length/2;++i) {
			int temp=ar[i];
			ar[i]=ar[ar.length-i-1];
			ar[ar.length-1-i]=temp;
		}
	}
}