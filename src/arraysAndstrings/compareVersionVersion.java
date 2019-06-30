package arraysAndstrings;

public class compareVersionVersion {
	public static int compareVersion(String version1, String version2) {
		StringBuilder sb1 = new StringBuilder("");

		for (int i = 0; i < version1.length(); ++i) {
			if (version1.charAt(i) != '.')
				sb1.append(version1.charAt(i));
		}

		StringBuilder sb2 = new StringBuilder("");

		for (int i = 0; i < version2.length(); ++i) {
			if (version2.charAt(i) != '.')
				sb2.append(version2.charAt(i));
		}

		int i = Integer.parseInt(sb1.toString());
		int j = Integer.parseInt(sb2.toString());

		if (i > j)
			return 1;
		else
			return 0;
	}

	public static void main(String[] args) {

		String str = "1.2.3.4.5";
		str = str.replaceAll(".", "");
		System.out.println(str);
		System.out.println(compareVersion("5.4.8", "5.8"));
	}
}
