package arraysAndstrings;

import java.util.*;

public class revelCardsInIncreasingOrder {

	public static int[] deckRevealedIncreasing(int[] deck) {
		Arrays.sort(deck);

		LinkedList<Integer> list = new LinkedList<>();
		int[] arr = new int[deck.length];

		for (int i = 0; i < deck.length; ++i) {
			list.addLast(i);
		}
		int in = 0;

		while (list.size() != 0) {
			int index = list.removeFirst();

			arr[index] = deck[in];
			++in;

			if (list.size() != 0)
				list.addLast(list.removeFirst());
		}

		return arr;

	}

	public static int[] deckRevealedIncreasing3(int[] deck) {

		int n = deck.length;
		Queue<Integer> index = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			index.add(i);
		}

		Arrays.sort(deck);
		int[] rst = new int[n];
		for (int card : deck) {

			rst[index.poll()] = card;

			if (!index.isEmpty()) {
				index.add(index.poll());
			}
		}
		return rst;
	}

	public static void main(String[] args) {
		int[] deck = { 17, 13, 11, 2, 3, 5, 7 };
		int[] ans = deckRevealedIncreasing(deck);
	}

}
