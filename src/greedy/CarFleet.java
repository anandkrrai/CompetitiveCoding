package greedy;

import java.util.*;

public class CarFleet {

	public class Car {
		int pos;
		double time;

		public Car(int pos, double time) {
			this.time = time;
			this.pos = pos;
		}
	}

	public int carFleet(int target, int[] position, int[] speed) {
		ArrayList<Car> list = new ArrayList<>();
		for (int i = 0; i < position.length; ++i) {
			list.add(new Car(position[i], (double) ((target - position[i]) / speed[i])));
		}
		Comparator<Car> cmp = new Comparator<Car>() {
			public int compare(Car c1, Car c2) {
				return c1.pos - c2.pos;
			}
		};

		Collections.sort(list, cmp);
		int fleet = 0;
		double max = Integer.MIN_VALUE;
		for (int i = list.size() - 1; i >= 0; --i) {
			if (list.get(i).time > max) {
				++fleet;
				max = list.get(i).time;
			}
		}

		return fleet;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
