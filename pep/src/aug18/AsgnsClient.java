package aug18;

import java.util.Arrays;
import java.util.HashMap;

public class AsgnsClient {

	public static void main(String[] args) {
		// int n = 15;
		// boolean[] primes = soe(n);
		//
		// HashMap<Integer, Integer> ladders = new HashMap<>();
		// int left = 0;
		// int right = primes.length - 1;
		// while(left < right){
		// while(primes[left] == false){
		// left++;
		// }
		//
		// while(primes[right] == false){
		// right--;
		// }
		//
		// if(left < right){
		// ladders.put(left, right);
		// left++;
		// right--;
		// }
		// }
		//
		// a8bq7(0, n, "", ladders);

		// int n = 15;
		// boolean[] primes = soe(n);
		//
		// HashMap<Integer, Integer> snl = new HashMap<>();
		// int left = 0;
		// int right = primes.length - 1;
		// int counter = 0;
		// while (left < right) {
		// while (primes[left] == false) {
		// left++;
		// }
		//
		// while (primes[right] == false) {
		// right--;
		// }
		//
		// if (left < right) {
		// counter++;
		//
		// if (counter % 2 == 1) {
		// snl.put(left, right);
		// } else {
		// snl.put(right, left);
		// }
		//
		// left++;
		// right--;
		// }
		// }
		//
		// System.out.println(a8bq8(0, n, new int[] { 6, 5, 2, 4, 6, 5, 2, 1},
		// 0, snl));

		// int er = 3;
		// int ec = 3;
		// boolean[] primes = soe((er + 1) * (ec + 1));
		//
		// HashMap<Integer, Boolean> mnp = new HashMap<>();
		// int counter = 0;
		//
		// for (int i = 0; i < primes.length; i++) {
		// if (primes[i] == true) {
		// counter++;
		//
		// if (counter % 2 == 1) {
		// mnp.put(i, false);
		// } else {
		// mnp.put(i, true);
		// }
		// }
		// }
		//
		// a8bq9(0, 0, 3, 3, "", mnp);

//		boolean[][] board = new boolean[3][3];
//		nknights(1, board, "", 0);
		
		int a = 1;
		int b = 2;
		int c = a ^ b;
		System.out.println(c);
	}

	private static boolean a8bq8(int curr, int end, int[] dices, int diceidx, HashMap<Integer, Integer> snl) {
		if (curr == end) {
			return true;
		}

		if (diceidx == dices.length) {
			return false;
		}

		if (snl.containsKey(curr)) {
			return a8bq8(snl.get(curr), end, dices, diceidx, snl);
		} else {
			if (curr + dices[diceidx] <= end) {
				return a8bq8(curr + dices[diceidx], end, dices, diceidx + 1, snl);
			} else {
				return a8bq8(curr, end, dices, diceidx + 1, snl);
			}
		}
	}

	public static boolean[] soe(int n) {
		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);

		primes[0] = primes[1] = false;
		for (int tbl = 2; tbl * tbl <= n; tbl++) {
			if (primes[tbl] == false) {
				continue;
			}

			for (int ja = 2; tbl * ja <= n; ja++) {
				primes[tbl * ja] = false;
			}
		}

		return primes;
	}

	public static void a8bq7(int curr, int end, String psf, HashMap<Integer, Integer> ladders) {
		if (curr == end) {
			System.out.println(psf);
			return;
		}

		if (curr > end) {
			return;
		}

		if (ladders.containsKey(curr)) {
			a8bq7(ladders.get(curr), end, psf + "L[" + curr + " -> " + ladders.get(curr) + "]", ladders);
		} else {
			for (int dice = 1; dice <= 6; dice++) {
				a8bq7(curr + dice, end, psf + "D" + dice, ladders);
			}
		}

	}

	public static void a8bq9(int cr, int cc, int er, int ec, String psf, HashMap<Integer, Boolean> mnp) {
		if (cr == er && cc == ec) {
			System.out.println(psf + ".");
			return;
		}

		if (cr > er || cc > ec) {
			return;
		}

		int num = cr * (ec + 1) + cc + 1;

		if (mnp.containsKey(num)) {
			if (mnp.get(num) == false) {
				return;
			} else {
				a8bq9(er, ec, er, ec, psf + "PORTED", mnp);
			}
		}

		a8bq9(cr + 2, cc + 1, er, ec, psf + "K21 => ", mnp);
		a8bq9(cr + 1, cc + 2, er, ec, psf + "K12 => ", mnp);

		if (cr == 0 || cr == er || cc == 0 || cc == ec) {
			// h
			int movesh = 1;
			while (cc + movesh <= ec) {
				a8bq9(cr, cc + movesh, er, ec, psf + "RH" + movesh + " => ", mnp);
				movesh++;
			}

			// v
			int movesv = 1;
			while (cr + movesv <= er) {
				a8bq9(cr + movesv, cc, er, ec, psf + "RV" + movesv + " => ", mnp);
				movesv++;
			}
		}

		if (cr == cc || cr + cc == ec) {
			int moves = 1;
			while (cr + moves <= er && cc + moves <= ec) {
				a8bq9(cr + moves, cc + moves, er, ec, psf + "B" + moves + " => ", mnp);
				moves++;
			}
		}
	}

	public static void a9q18(int[] arr) {
		int lo = 0, mid = 0, hi = arr.length - 1;

		while (mid <= hi) {
			if (arr[mid] == 0) {
				int temp = arr[mid];
				arr[mid] = arr[lo];
				arr[lo] = temp;

				lo++;
				mid++;
			} else if (arr[mid] == 1) {
				mid++;
			} else {
				int temp = arr[mid];
				arr[mid] = arr[hi];
				arr[hi] = temp;

				hi--;
			}
		}
	}

	static int counter = 0;

	public static void nknights(int cellno, boolean[][] board, String config, int kpsf) {
		if (kpsf == board.length) {
			counter++;
			System.out.println(counter + "." + config);
			return;
		}

		for (int i = cellno; i <= board.length * board.length; i++) {
			int cr = (i - 1) / board.length;
			int cc = (i - 1) % board.length;

			if (isitsafetoplacetheknight(cr, cc, board)) {
				board[cr][cc] = true;
				nknights(i + 1, board, config + "[" + cr + "-" + cc + "], ", kpsf + 1);
				board[cr][cc] = false;
			}
		}
	}

	private static boolean isitsafetoplacetheknight(int cr, int cc, boolean[][] board) {
		if(cr - 2 >= 0 && cc - 1 >= 0 && board[cr - 2][cc - 1] == true) {
			return false;
		}
		
		if(cr - 2 >= 0 && cc + 1 < board.length && board[cr - 2][cc + 1] == true){
			return false;
		}
		
		if(cr - 1 >= 0 && cc - 2 >= 0 && board[cr - 1][cc - 2] == true){
			return false;
		}
		
		if(cr - 1 >= 0 && cc + 2 < board.length && board[cr - 1][cc + 2] == true){
			return false;
		}
		
		return true;
	}
}
