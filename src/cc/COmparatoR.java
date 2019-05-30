package cc;

import java.util.*;

public class COmparatoR {

	public static class class1 {
		int x;

		public class1(int val) {
			this.x = val;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.x + " ";
		}
	}

	public static class class2 {
		int x;

		public class2(int x) {
			this.x = x;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.x + " ";
		}

	}

	public static class SortByx implements Comparator<class2> {

		@Override
		public int compare(class2 o1, class2 o2) {
			// TODO Auto-generated method stub
			return o2.x - o1.x;
		}

	}

	public static class class3 implements Comparable<class3> {
		int x;

		public class3(int x) {
			this.x = x;
		}

		@Override
		public int compareTo(class3 o) {
			// TODO Auto-generated method stub
			return o.x - this.x;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return x + " ";
		}
	}

	public static void main(String[] args) {
		// =====================Method1==================
		System.out.println("\nMethod1 starts");

		// Annonymous inner class
		Comparator<class1> cmp = new Comparator<class1>() {
			@Override
			public int compare(class1 o1, class1 o2) {
				return o2.x - o1.x;
			}
		};
		ArrayList<class1> list = new ArrayList<class1>();
		for (int i = 0; i < 10; ++i) {
			class1 temp = new class1(i);
			list.add(temp);
		}

		Collections.sort(list, cmp);

		for (class1 c : list)
			System.out.print(c);

		// =====================Method2==================
		System.out.println("\nMethod2 starts");

		ArrayList<class2> list2 = new ArrayList<class2>();
		for (int i = 0; i < 10; ++i) {
			class2 temp = new class2(i);
			list2.add(temp);
		}

		Collections.sort(list2, new SortByx());
		for (class2 c : list2)
			System.out.print(c);

		// =====================Method3==================
		System.out.println("\nMethod2 starts");

		ArrayList<class3> list3 = new ArrayList<class3>();
		for (int i = 0; i < 10; ++i) {
			class3 temp = new class3(i);
			list3.add(temp);
		}

		Collections.sort(list3);

		for (class3 c : list3)
			System.out.print(c);

	
	}

}
