package hh;

import java.util.HashMap;

public class TossStrangeCoins {
	public double probabilityOfHeads(double[] prob, int target) {
		return prob(prob, 0, target, new HashMap<String, Double>());
	}

	public double prob(double[] prob, int vidx, int k, HashMap<String, Double> map) {
		if (vidx == prob.length)
			return 1;

		String key = vidx + "*" + k;
		if (map.containsKey(key))
			return (double)map.get(key);

		double ans1 = prob(prob, vidx + 1, k, map) * (1 - prob[vidx]);
		double ans2 = 1.0;
		if (k > 0) {
			ans2 = prob(prob, vidx + 1, k - 1, map) * (prob[vidx]);
		}

		double ans = (double) (ans1 + ans2);
		map.put(key, ans);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
