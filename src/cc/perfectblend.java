package cc;

import java.util.HashSet;
import java.util.List;

public class perfectblend {
	public static int strangelyCompatible(List<String> students) {
		int rv = 0;

		HashSet<String> set = new HashSet<String>();

		for (String student : students) {
			set.add(student);
		}

//
//		for (String student : students) {
//			for (int i = 0; i < student.length(); ++i) {
//				set.remove(student);
//				for (int k = 97; k < 123; ++k) {
//					char ch1 = (char) (k);
//
//					String str1 = student.substring(0, i) + ch1 + student.substring(i + 1);
//
//					if (set.contains(str1))
//						++rv;
//				}
//
//			}
//		}

		for (String student : students) {
			set.remove(student);

			for (int i = 0; i < student.length(); ++i) {
				char ch = student.charAt(i);
				char ch1 = (char) (ch + 1);
				char ch2 = (char) (ch - 1);

				String str1 = student.substring(0, i) + ch1 + student.substring(i + 1);
				String str2 = student.substring(0, i) + ch2 + student.substring(i + 1);

				if (set.contains(str1))
					++rv;

				if (set.contains(str2))
					++rv;

			}
		}

		return rv;
	}

	public static void main(String[] args) {
		char ch = 'd';
		System.out.println((char) (ch + 1));
//		for (int i = 0; i < n; ++i) {
//			for (int j = i + 1; j < n; ++j) {
//				int dif = 0;
//				for (int k = 0; k < len && dif <= 1; ++k) {
//					if (students.get(i).charAt(k) != students.get(j).charAt(k)) {
//						dif += Math.abs(students.get(i).charAt(k) - students.get(j).charAt(k));
//					}
//				}
//
//				if (dif == 1) {
//					++rv;
//				}
//			}
//		}

	}
}
