package greedy;

public class completeCircuit {

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int res = 0, j = 0;

		for (int i = 0; i < gas.length;) {
			res = 0;
			j = i;
			while (res + gas[j] - cost[j] > 0) {
				res = res + gas[j] - cost[j];
				++j;
				j = j % gas.length;
				if (j == i)
					return 1;
			}
			if (j > i) {
				i = j;
			} else {
				++i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };

		System.out.println(canCompleteCircuit(gas, cost));
	}

}
