package hh;

public class sumOfSquares {

	public static int mod = 1000000007;

	public static int power(int x, int n) {
		if (n == 0) {
			return 1;
		}else if(n==1)
			return x;

		int res = power(x, n / 2);

		if (n % 2 == 0) {
			return (res * res ) % mod;
		} else {
			return (res  *res* x) % mod;
		}
	}

	public static int solve(int[] arr) {
		int sum = 0;
		for (int val : arr) {
			sum += val * val;
		}
//		int pow = power(2, arr.length - 1);
		int pow=modulo(2, arr.length, mod);
		return pow * sum;
	}

	public static int modulo(int a, int b, int n){
	    long x=1, y=a; 
	    while (b > 0) {
	        if (b%2 == 1) {
	            x = (x*y) % n; // multiplying with base
	        }
	        y = (y*y) % n; // squaring the base
	        b /= 2;
	    }
	    return (int)(x % n);
	}

	public static void main(String[] args) {
//		System.out.println(power(2, 38));
//		System.out.println((int)Math.pow(2, 38)%mod);
		System.out.println(modulo(843558417, 344211605, mod));
		int[] arr= {3,7};
		System.out.println(solve(arr));
	}

}
