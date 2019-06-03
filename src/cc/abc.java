package cc;

import java.util.HashSet;

interface int1 {
	int i = 0;
}

interface int2 {
	int i = 0;
}

public class abc implements int1, int2 {

	public static int[] fix(int[] z) {
		z[1] = 4;
		return z;
	}

	public static void main(String[] args) {
//		12.9762,77.6033

		
		String apiKey = "4d0cdac4d803d375e6083aae29de3eed";
		String requestEndpoint = "https://openweathermap.org/data/2.5/forecast?lat=" + 12.9762 + "&long=" + 77.6033
				+ "&appid=" + apiKey;

		System.out.println(requestEndpoint);
		
		//		System.out.println(i);

//		byte b = 10;
//		byte a = 6;
//
//		System.out.print(b % a+" ,");
//		System.out.println(b == ((b / a) * a + b % a));

//		int[] x = { 7, 8, 9 };
//		int[] y = fix(x);
//
//		System.out.println(x[0] + x[1] + x[2] + " ");
//		System.out.println(y[0] + y[1] + y[2] + " ");

		HashSet<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");

		for (String str : set) {
			System.out.println(str);
		}

	}

}
