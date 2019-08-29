package dp;

public class booleanParenthesization {
	static int countParenth(char symb[], char oper[]) {
		int n = symb.length;
		int[][] tru = new int[n][n];
		int[][] fal = new int[n][n];

		for (int gap = 0; gap < n; ++gap) {
			for (int i = 0, j = i + gap; j < n; ++i,++j) {
				if (i == j) {
					tru[i][i] = symb[i] == 'T' ? 1 : 0;
					fal[i][i] = symb[i] == 'F' ? 1 : 0;
				} else {

					for (int g = 0; g < gap; ++g) {
						int k = i + g;
						int tik = tru[i][k] + fal[i][k];
						int tkj = tru[k + 1][j] + fal[k + 1][j];

						if (oper[k] == '&') {
							tru[i][j] += tru[i][k] * tru[k + 1][j];
							fal[i][j] += tik * tkj - tru[i][k] * tru[k + 1][j];
						} else if (oper[k] == '|') {
							tru[i][j] += tik * tkj - fal[i][k] * fal[k + 1][j];
							fal[i][j] += fal[i][k] * fal[k + 1][j];
						} else if (oper[k] == '^') {
							tru[i][j] += tru[i][k] * fal[k + 1][j] + fal[i][k] * tru[k + 1][j];
							fal[i][j] += tru[i][k] * tru[k + 1][j] + fal[i][k] * fal[k + 1][j];
						}
					}
				}
			}
		}
		return tru[0][n - 1];
	}

	public static void main(String[] args) {
		char symbols[] = "TTFT".toCharArray();
		char operators[] = "|&^".toCharArray();
		int n = symbols.length;

		System.out.println(countParenth(symbols, operators));
	}
}
