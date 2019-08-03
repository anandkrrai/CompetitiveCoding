package hh;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class digitPairs {

	public static int getBit(int n) {
		
		int ones = n % 10;
		n /= 10;
		int tens = n % 10;
		n /= 10;
		int hundreds = n;
		int min = Math.min(ones, tens);
		min = Math.min(min, hundreds);

		int max = Math.max(ones, tens);
		max = Math.max(max, hundreds);

		int score = max * 11 + 7 * min;
		score = score % 100;
		return score;
	}

	private static String getBitScore(int x) {
		int score = getBit(x);
		String rv;
		if (score < 10) {
			rv = "0" + score;
		} else {
			rv = score + "";
		}
		return rv;
	}

	public static void main(String[] args) {
		int o = 8;
		System.out.println(o & (-o));
		Scanner sc = new Scanner(System.in);
		HashMap<Character, Integer> even = new HashMap<>();
		HashMap<Character, Integer> odd = new HashMap<>();

		int n = sc.nextInt();

		for (int i = 1; i <= n; ++i) {
			int x = sc.nextInt();
			String score = getBitScore(x);
			if (i % 2 != 1) {
				odd.put(score.charAt(0), odd.getOrDefault(score.charAt(0), 0) + 1);
			} else {
				even.put(score.charAt(0), even.getOrDefault(score.charAt(0), 0) + 1);
			}
		}

		HashMap<Character, Integer> pmap = new HashMap<>();
		for (char myKey : odd.keySet()) {
			if (odd.get(myKey) == 2) {
				pmap.put(myKey, 1);
			} else if (odd.get(myKey) > 2) {
				pmap.put(myKey, 2);
			}
		}

		for (char myKey : even.keySet()) {
			if (even.get(myKey) == 2) {
				pmap.put(myKey, pmap.getOrDefault(myKey, 0) + 1);
			} else if (even.get(myKey) > 2) {
				pmap.put(myKey, pmap.getOrDefault(myKey, 0) + 2);
			}
		}
		int count = 0;

		for (char myKey : pmap.keySet()) {
			count += pmap.get(myKey) == 1 ? 1 : 2;
		}

		System.out.print(count);
		sc.close();
	}
}