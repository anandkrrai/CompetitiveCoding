package july31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import july17.oops2.P;

public class GenericHeapClient {

	public static void main(String[] args) {
		// Car[] cars = new Car[7];
		// cars[0] = new Car("Audi", 100, 1000);
		// cars[1] = new Car("BMW", 200, 1500);
		// cars[2] = new Car("Porsche", 150, 800);
		// cars[3] = new Car("Merc", 140, 900);
		// cars[4] = new Car("Lambor", 160, 1400);
		// cars[5] = new Car("ABC", 190, 1900);
		// cars[6] = new Car("DEF", 210, 2100);
		//
		// GenericHeap<Car> heap = new GenericHeap<>(Car.namerevctor);
		// for(Car car: cars){
		// heap.add(car);
		// }
		// heap.display();
		//
		// while(heap.size() != 0){
		// System.out.println(heap.removeHP());
		// }

//		ArrayList<Integer> zero = new ArrayList<>(Arrays.asList(10, 15, 20, 25));
//		ArrayList<Integer> one = new ArrayList<>(Arrays.asList(9, 18, 24, 27));
//		ArrayList<Integer> two = new ArrayList<>(Arrays.asList(5, 7, 28, 40));
//		ArrayList<Integer> three = new ArrayList<>(Arrays.asList(17, 19, 21, 29));
//		ArrayList<ArrayList<Integer>> lists = new ArrayList<>(Arrays.asList(zero, one, two, three));
//
//		System.out.println(mergeKlists(lists));
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(20, 2, 19, 55, 32, 66, 88, 34));
		System.out.println(getKLargestElements(list, 3));
	}

	public static ArrayList<Integer> mergeKlists(ArrayList<ArrayList<Integer>> lists) {
		ArrayList<Integer> list = new ArrayList<>();

		GenericHeap<Pair> heap = new GenericHeap<>(Pair.Comparator);

		// fill
		for (int i = 0; i < lists.size(); i++) {
			Pair p = new Pair();
			p.ino = 0;
			p.lno = i;
			p.data = lists.get(i).get(0);
			heap.add(p);
		}

		// while the heap is not empty
		while (heap.size() != 0) {
			Pair top = heap.removeHP();
			list.add(top.data);

			top.ino++;
			if (top.ino < lists.get(top.lno).size()) {
				top.data = lists.get(top.lno).get(top.ino);
				heap.add(top);
			}
		}

		return list;
	}

	private static class Pair {
		int data;
		int lno;
		int ino;
		public static final PairComparator Comparator = new PairComparator();

		private static class PairComparator implements Comparator<Pair> {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o2.data - o1.data;
			}

		}
	}

	public static ArrayList<Integer> getKLargestElements(ArrayList<Integer> list, int k) {
		ArrayList<Integer> rv = new ArrayList<>();
		GenericHeap<Pair> heap = new GenericHeap<>(Pair.Comparator);
		
		for(int i = 0; i < k; i++){
			Pair p = new Pair();
			p.data = list.get(i);
			heap.add(p);
		}
		
		for(int i = k; i < list.size(); i++){
			Pair top = heap.getHP();
			if(list.get(i) > top.data){
				heap.removeHP();
				
				Pair np = new Pair();
				np.data = list.get(i);
				heap.add(np);
			}
		}
		
		while(heap.size() != 0){
			rv.add(heap.removeHP().data);
		}
		
		return rv;
	}

}
