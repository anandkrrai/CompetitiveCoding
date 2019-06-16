import java.util.Scanner;
import java.util.Stack;

public class MolecularMass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String str = scan.nextLine();

		Stack<String> stack = new Stack<String>();
		stack.push("0");

		for (int i = 0; i < str.length(); ++i) {
			char ch = str.charAt(i);

			if (ch == '(') {
				stack.push("0");

			} else if (ch == ')') {
				String s = stack.pop();
				++i;
				int num = Integer.parseInt(str.charAt(i) + "");
				int pus = Integer.parseInt(s) * num;
				int x = Integer.parseInt(stack.pop());
				stack.push(num + x + "");
			} else {
				String st = stack.pop();
				int val = 0;
				if (ch == 'O') {
					val = 16;
				} else if (ch == 'H') {
					val = 1;
				} else if (ch == 'C') {
					val = 12;
				}
				stack.push(val + Integer.parseInt(st) + "");
			}

		}

		System.out.println(stack.pop());
	}

}
