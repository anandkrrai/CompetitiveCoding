import java.util.HashMap;

public class fakeId {
	public static void findIfFake(String p) {

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < p.length(); ++i) {
			char ch = p.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int count = 0;

		for (char key : map.keySet()) {
			if (map.get(key) == 1) {
				++count;
			}

		}

		if (count % 2 == 0) {
			System.out.println("she");
		} else {
			System.out.println("he");
		}

	}

	public static void main(String[] args) {
		findIfFake("abhdyenonbb");
	}

}
