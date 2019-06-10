//https://leetcode.com/problems/asteroid-collision/
//http://134.209.156.168:3004/resource/interview-prep/stacks-and-queues-description/fun-with-asteroids/ojquestion
import java.util.*;

public class AsteroidCollision {
	public static int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (int asteroid : asteroids) {
			stack.push(asteroid);
			if (asteroid > 0)
				continue;
			else {
				int curr = stack.pop() * -1;
				while (stack.size() > 0 && stack.peek() > 0) {
					if (stack.peek() > curr) {
						curr = 0;
						break;
					} else if (curr == stack.peek()) {
						curr = 0;
						stack.pop();
						break;
					} else {
						stack.pop();
					}
				}
				if (curr != 0)
					stack.push(curr * -1);
			}
		}

		int[] rv = new int[stack.size()];
		for (int i = rv.length - 1; i >= 0; --i) {
			rv[i] = stack.pop();
		}
		return rv;
	}

	public static void main(String[] args) {
		int[] arr = { -1,-2,1, 2,5,-6 };
		int[] ar = asteroidCollision(arr);
		for (int x : ar)
			System.out.print(x + " ");
	}

}
