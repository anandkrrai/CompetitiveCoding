package arraysAndstrings;
//https://leetcode.com/problems/teemo-attacking/
//http://134.209.156.168:3004/resource/interview-prep/arrays-and-strings/attacking/ojquestion
public class TeemoAttackingPoision {

	public int findPoisonedDuration(int[] times, int duration) {
		int ans = 0, start = 0, end = 0;
		for (int time : times) {
			if (time > end) {
				ans += end - start;
				start = time;
				end = time + duration;
			} else {
				end = time + duration;
			}
		}
		return ans + end - start;
	}
}
