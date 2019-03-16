package cc;

public class gcg {

	public static int GCD(int A, int B) {
		if (B == 0)
			return A;
		else
			return GCD(B, A % B);
	}

	public static void main(String[] args) {
		char ch ='a';
		int a=ch;
		System.out.println(a);

		int[] arr = new int[2147483643];
		
		System.out.println(GCD(342543323, 1324324324));
	}

}
