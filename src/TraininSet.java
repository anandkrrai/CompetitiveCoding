import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TraininSet {

	public static void main(String[] args) {
		HashMap<String, Integer> tmap;
		HashMap<String, Integer> fmap;

		Scanner scan = new Scanner(System.in);
		int t = Integer.parseInt(scan.nextLine());

		while (t-- > 0) {
			tmap = new HashMap<String, Integer>();
			fmap = new HashMap<String, Integer>();
			int n = Integer.parseInt(scan.nextLine());
			for (int i = 0; i < n; ++i) {
				String[] arr = scan.nextLine().trim().split("\\s+");
				if (arr[1].equals("1")) {
					tmap.put(arr[0], tmap.getOrDefault(arr[0], 0) + 1);
				} else {
					fmap.put(arr[0], fmap.getOrDefault(arr[0], 0) + 1);
				}
			}

			int count = 0;
			ArrayList<String> list = new ArrayList<String>(tmap.keySet());
			for (String str : list) {
				int m1 = 0, m2 = 0;
				m1 = tmap.get(str);
				tmap.remove(str);
				if (fmap.containsKey(str)) {
					m2 = fmap.get(str);
					fmap.remove(str);
				}
				count += Math.max(m1, m2);

			}

			for (String str : fmap.keySet())
				count += fmap.get(str);

			System.out.println(count);
		}
		scan.close();
	}
}
