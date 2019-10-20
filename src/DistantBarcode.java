import java.util.*;

public class DistantBarcode {
	public class Pair {
		int num, freq;

		public Pair(int num, int freq) {
			this.num = num;
			this.freq = freq;
		}

		public int compareTo(Pair p) {
			return this.freq - p.freq;
		}
	}

	public int[] rearrangeBarcodes(int[] barcodes) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int val : barcodes) {
			map.put(val, map.getOrDefault(val, 0) + 1);
		}
		

		PriorityQueue<Pair> q = new PriorityQueue<>();
		for (int val : map.keySet())
			q.add(new Pair(val, map.get(val)));

		Pair rem = null;
		int i = 0;
		int[] rv = new int[barcodes.length];
		while (i < barcodes.length) {
			rem = q.remove();
			while (rem.freq > 0) {
				rv[i] = rem.num;
				i += 2;
				rem.freq--;
			}
		}
		i = 1;
		while (i < barcodes.length) {
			while (rem.freq > 0) {
				rv[i] = rem.num;
				i += 2;
				rem.freq--;
			}
			rem = q.remove();
		}
		return rv;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
