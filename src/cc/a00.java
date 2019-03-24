package cc;

public class a00 {
	
	static int summingSeries(long n) {
        int mod=1000000007;
       return (int)((n%mod)*(n%mod))%mod;

    }

	public static void main(String[] args) {
		
		System.out.println(summingSeries(4762607));

//		int n = Integer.MAX_VALUE;
//		System.out.println(n);
//		System.out.println(Integer.toBinaryString(n));
//
//		n = Integer.MAX_VALUE << 1;
//		System.out.println(n);
//		System.out.println(Integer.toBinaryString(n));

//		for (int n = 0; n <= 10; ++n) {
//			System.out.println("n=" + n + " binary:" + Integer.toBinaryString(n));
//			System.out.println("n=-" + n + " binary:" + Integer.toBinaryString(-n));
//
//		}
	}

}
