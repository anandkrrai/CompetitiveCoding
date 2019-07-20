package hh;

public class odometer {

	public static int bruteForece(int n) {
		int count = 0;

		for (int i = 1; i <= n; ++i) {
			String s = i + "";
			if(s.indexOf('4')!=-1) {
				++count;
			}
		}

		return n-count;
	}
	
	public static int superior(int n) {
		int ans=0;
		String str = n+"";
		
		
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(bruteForece(800));
		
		
		
	}

}
