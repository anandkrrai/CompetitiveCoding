package greedy;

public class completeCircuit {

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int reserve = 0, j = 0;

		for (int i = 0; i < gas.length;) {
			reserve = 0;
			j = i;
			while (reserve > 0) {
				if (reserve < 0)
					break;
				reserve = reserve + gas[j] - cost[j];
				++j;
				j = j % gas.length;
				if (j == i)
					return i;
			}
			i = j;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] gas = { 3, 3, 4 };
		int[] cost = { 3, 4, 4 };

		System.out.println(canCompleteCircuit(gas, cost));
	}

}
