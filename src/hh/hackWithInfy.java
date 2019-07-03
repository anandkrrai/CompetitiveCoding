package hh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class hackWithInfy {

//	public static int minNum(int threshold, List<Integer> happy) {
//		int min = happy.size() + 1;
//
//		for (int i = 0; i < happy.size(); ++i) {
//			int local = 1;
//
//			for (int j = i + 1; j < happy.size() - 1; j += 2) {
//				++local;
//				if (happy.get(j) - happy.get(i) >= threshold || 
//					happy.get(j + 1) - happy.get(i) >= threshold) {
//					break;
//				}
//			}
//			min = Math.min(local, min);
//		}
//		return min;
//	}

//	public static int minNum(int threshold, List<Integer> happy) {
//		int i = 0, j = 0, min = happy.size();
//
//		while (j < happy.size()) {
//			if (happy.get(j) - happy.get(i) >= threshold) {
//				min = Math.min(min, j - i);
//				++i;
//			} else {
//				++j;
//			}
//		}
//
//		return min;
//	}

	public static int minNum1(int threshold, List<Integer> happy) {
		int min = happy.size();

		int i = 0, j = 0;
		while (i < happy.size()) {
			int local = 0;

			while (j < happy.size()) {
				++local;
				if (happy.get(j) - happy.get(i) >= threshold) {
					min = Math.min(min, local);
					break;
				} else if (j + 1 < happy.size()) {
					j += 2;
				} else {
					++j;
				}
			}

			++i;

		}

		return min;
	}

	public static int minNum(int threshold, List<Integer> happy) {
		int min = happy.size();

		int i = 0, j = 0;
		int local = 0;

		while (j < happy.size()) {
			++local;
			if (happy.get(j) - happy.get(i) >= threshold) {
				min = Math.min(min, local);
				break;
			} else if (j + 2 < happy.size()) {
				if (happy.get(j) - happy.get(i) >= threshold) {
					min = Math.min(min, local);
					break;
				}
				j += 2;
			} else {
				++j;
			}
		}
//	        while (i < happy.size()) {
//	            int local = 0;
//
//	            while (j < happy.size()) {
//	                ++local;
//	                if (happy.get(j) - happy.get(i) >= threshold) {
//	                	  min=Math.min(min, local);
//		                    break;
//	                }else if(j+2<happy.size()) {
//	                	if(happy.get(j) - happy.get(i) >= threshold) {
//	                		min=Math.min(min, local);
//	  	                    break;	
//	                	}
//	                    j+=2;
//	                }else {
//	                    ++j;
//	                }
//	            }
//	            
//	            ++i;
//
//	        }

		return min;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(7);
		System.out.println(minNum(4, list));
	}

}
//public static int minNum(int threshold, List<Integer> happy) {
//    int min = happy.size();
//
//    int i = 0, j = 0;
//    while (i < happy.size()) {
//        int local = 0;
//
//        while (j < happy.size()) {
//            ++local;
//            if (happy.get(j) - happy.get(i) >= threshold) {
//                min=Math.min(min, local);
//                break;
//            }else if(j+1<happy.size()) {
//                j+=2;
//            }else {
//                ++j;
//            }
//        }
//        
//        ++i;
//
//    }
//
//    return min;
//}
