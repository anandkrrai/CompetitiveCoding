package arraysAndstrings;

public class calculator {

	public static  int calc(int first, int second, int operator) {
		switch (operator) {
		case ADD: {
			return first + second;
		}
		case SUB: {
			return first - second;
		}
		case MUL: {

			return first * second;
		}
		case DIV: {
			return first / second;
		}
		default:
			return 0;
		}
	}

	public static final int MUL = 3, ADD = 1, DIV = 4, SUB = 2;

	public static  int calculate(String s) {
		String str = "";
		int op = -1, first = 0;
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);

			if (ch >= '0' && ch <= '9') {
				str += ch;
			} else if (ch == ' ') {
				continue;
			} else if (ch == '*') {
				if (op == -1) {
					first = Integer.parseInt(str);
				} else {
					first = calc(first, Integer.parseInt(str), op);
				}
				op = MUL;
				str = "";

			} else if (ch == '+') {
				if (op == -1) {
					first = Integer.parseInt(str);
				} else {
					first = calc(first, Integer.parseInt(str), op);
				}
				op = ADD;
				str = "";
			} else if (ch == '/') {
				if (op == -1) {
					first = Integer.parseInt(str);
				} else {
					first = calc(first, Integer.parseInt(str), op);
				}
				op = DIV;
				str = "";
			} else if (ch == '-') {
				if (op == -1) {
					first = Integer.parseInt(str);
				} else {
					first = calc(first, Integer.parseInt(str), op);
				}
				op = SUB;
				str = "";
			}
		}
		return first;
	}

	public static void main(String[] args) {
		System.out.println(calculate("3+2*2"));
	}

}
