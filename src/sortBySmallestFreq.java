
public class sortBySmallestFreq {

	public static int[] freq(String[] words) {
		int[] wordsFreq = new int[words.length];

		for (int i = 0; i < words.length; ++i) {
			String str = words[i];
			int[] arr = new int[26];
			for (int j = 0; j < str.length(); ++j) {
				arr[str.charAt(j) - 'a']++;
			}

			int j = 0;
			while (j < 26 && arr[j++] == 0)
				;
			wordsFreq[i] = arr[--j];
		}
		return wordsFreq;
	}

	public static int[] numSmallerByFrequency(String[] queries, String[] words) {
		int[] rv = new int[queries.length];
		int[] wordsFreq = freq(words);
		int[] queriesFreq = freq(queries);

		for (int i = 0; i < queriesFreq.length; ++i) {
			int count = 0;
			for (int val : wordsFreq)
				if (val > queriesFreq[i])
					++count;
			rv[i] = count;
		}
		return rv;
	}

	public static void main(String[] args) {
		String[] queries = { "cbd" };
		String[] words = { "zaaaz", "aabcd" };
		int rv[] = numSmallerByFrequency(queries, words);
		for (int val : rv)
			System.out.print(val + " ");
	}

}
