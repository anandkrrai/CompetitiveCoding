import java.util.*;

public class GeneratePalindromeInRange {

	public static ArrayList<Long> generate(long r) {
		ArrayList<Long> list = new ArrayList<>();

		long l = 1L, itr = l, num;
		int i;
		for (i = 0, itr = l; i < 2; ++i) {
			while ((num = CreatePalindrome(itr, i)) <= r) {
				++itr;
				list.add(num);
			}
		}
		return list;
	}

	private static long CreatePalindrome(long num, int i) {
		long temp = num;
		if (i == 1) {
			// for generating odd length
			temp /= 10;
		}
		while (temp > 0) {
			num = num * 10 + temp % 10;
			temp /= 10;
		}

		return num;
	}

	public static boolean ispalindrome(long n) {
		StringBuilder str = new StringBuilder(n + "");
		return new String(n + "").equals(str.reverse().toString());
	}

	public static int CountSuperPalindrome(long l, long r) {
		int rv = 0;
		ArrayList<Long> palins = generate((long) Math.sqrt(r)+1);

		for (long num : palins) {
			long sqr = (long)num * num;

			if (sqr >= l && sqr <= r && ispalindrome(sqr)) {
				++rv;
				System.out.println(sqr);
			}

		}
		return rv;
	}
	
	static int createPalindrome(int input, int isOdd) { 
	    int n = input , b=10; 
	    int palin = input; 
	    if (isOdd == 1) 
	        n /= b; 

	    while (n > 0) { 
	        palin = palin * b + (n % b); 
	        n /= b; 
	    } 
	    return palin; 
	} 
	  
	// Function to print decimal  
	// palindromic number 
	static void generatePalindromes(int n) { 
	    int number; 
	  
	    // Run two times for odd and even  
	    // length palindromes 
	    for (int j = 0; j < 2; j++) { 
	  
	    // Creates palindrome numbers with first  
	    // half as i. Value of j decided whether 
	    // we need an odd length of even length 
	    // palindrome. 
	        int i = 1; 
	        while ((number = createPalindrome(i, j)) < n) { 
	            System.out.print(number + ", "); 
	            i++; 
	    } 
	    } 
	} 
	
	public static void main(String[] args) {
		System.out.println(generate(33));

//		System.out.println(CountSuperPalindrome(4, 1000));
		
		generatePalindromes(33);
	}

}
