package map_set;

public class equalsMethod {

	public static class abc {
		int n;

		public abc(int x) {
			n = x;
		}

		@Override
		public boolean equals(Object obj) {
			// we can not do this because obj is of type Object and this can be any data
			// type so we are not sure if this obj have a data member of type n
			// return this.n ==obj.n;

			if (this == obj) {
				return true;
			} else if (!(obj instanceof abc)) {
				return false;
			} else {
				abc ob = (abc) (obj);
				return this.n == ob.n;
			}
		}
	}

	public static void main(String args[]) throws Exception {
		abc a = new abc(1);
		abc b = new abc(1);
		System.out.println(a.equals(b));

	}
}
