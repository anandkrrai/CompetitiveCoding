package arraysAndstrings;

import java.util.HashSet;

public class concatenationWithItself {
	public int distinctEchoSubstrings(String text) {
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < text.length(); ++i) {
			calc(set, text.substring(i));
		}
		return set.size();
	}

	private void calc(HashSet<String> set, String text) {
		for (int i = 0; i < text.length() / 2; ++i) {
			if (text.substring(0, i + 1).equals(text.substring(i + 1, 2 * (i + 1))))
				set.add(text.substring(0, i + 1));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
