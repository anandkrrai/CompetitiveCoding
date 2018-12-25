package cc;

public class gfg_on1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int ans = 0;
		String s = "0011";
		String[] arr = s.replace("0", " ").split(" ");
		for (String g : arr) {
			ans = Math.max(ans, g.length());

		}
		System.out.println(ans);

	}

}
