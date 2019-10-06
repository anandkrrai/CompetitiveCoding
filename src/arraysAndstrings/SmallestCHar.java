package arraysAndstrings;

public class SmallestCHar {

	public char nextGreatestLetter(char[] letters, char target) {
		char smallest = 'z', rv = (char) 123;
		for (char ch : letters) {
			if (ch > target && ch < rv) {
				rv = ch;
			}
			if (smallest > ch)
				smallest = ch;
		}

		if (rv != (char) 123)
			return rv;
		else
			return smallest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
