package hh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class infy3 {

//	public static List<List<Integer>> solveMountain(List<List<Integer>> mountain) {
//		List<List<Integer>> rv = new ArrayList<List<Integer>>();
//		int[][] board = new int[mountain.size()][mountain.get(0).size()];
//		for (int i = 0; i < board.length; ++i) {
//			Arrays.fill(board[i], -1);
//		}
//		for (int i = 0; i < mountain.size(); ++i) {
//			ArrayList<Integer> list = new ArrayList<Integer>();
//			for (int j = 0; j < mountain.get(i).size(); ++j) {
//				int val = func(mountain, i, j, new boolean[mountain.size()][mountain.get(0).size()], board);
//				board[i][j] = val;
//				list.add(val);
//			}
//			rv.add(list);
//		}
//
//		return rv;
//	}
//
//	public static boolean isValid(int i, int j, boolean[][] arr) {
//		if (i >= arr.length || j >= arr[0].length || i < 0 || j < 0) {
//			return false;
//		} else if (arr[i][j] == true) {
//			return false;
//		} else {
//			return true;
//		}
//	}
//
//	private static Integer func(List<List<Integer>> mountain, int i, int j, boolean[][] bs, int[][] board) {
//
//		if (board[i][j] != -1)
//			return board[i][j];
//
//		int rv = mountain.get(i).get(j);
//		bs[i][j] = true;
//
//		if (isValid(i, j + 1, bs) && mountain.get(i).get(j + 1) <= mountain.get(i).get(j)) {
//			int ret = func(mountain, i, j + 1, bs, board);
//			rv = Math.min(rv, ret);
//		}
//		if (isValid(i + 1, j, bs) && mountain.get(i + 1).get(j) <= mountain.get(i).get(j)) {
//			int ret = func(mountain, i + 1, j, bs, board);
//			rv = Math.min(rv, ret);
//		}
//		if (isValid(i, j - 1, bs) && mountain.get(i).get(j - 1) <= mountain.get(i).get(j)) {
//			int ret = func(mountain, i, j - 1, bs, board);
//			rv = Math.min(rv, ret);
//		}
//		if (isValid(i - 1, j, bs) && mountain.get(i - 1).get(j) <= mountain.get(i).get(j)) {
//			int ret = func(mountain, i - 1, j, bs, board);
//			rv = Math.min(rv, ret);
//		}
//
//		bs[i][j] = false;
//		return rv;
//
//	}
	
	 
	   public static List<List<Integer>> solveMountain(List<List<Integer>> mountain) {
	        List<List<Integer>> rv = new ArrayList<List<Integer>>();

	        int[][] board = new int[mountain.size()][mountain.get(0).size()];
	        for (int i = 0; i < board.length; ++i) {
	            Arrays.fill(board[i], -1);
	        }

	        for (int i = 0; i < mountain.size(); ++i) {
	            ArrayList<Integer> list = new ArrayList<Integer>();
	            for (int j = 0; j < mountain.get(i).size(); ++j) {
	                int val = func(mountain, i, j, new boolean[mountain.size()][mountain.get(0).size()], board);
	                board[i][j] = val;
	                list.add(val);
	            }
	            rv.add(list);
	        }

	        return rv;
	    }

	    public static boolean isValid(int i, int j, boolean[][] arr) {
	        if (i >= arr.length || j >= arr[0].length || i < 0 || j < 0) {
	            return false;
	        } else if (arr[i][j] == true) {
	            return false;
	        } else {
	            return true;
	        }
	    }

	    private static Integer func(List<List<Integer>> mountain, int i, int j, boolean[][] bs, int[][] board) {

//	        if (board[i][j] != -1)
//	            return board[i][j];

	        int rv = mountain.get(i).get(j);
	        bs[i][j] = true;

	        if (isValid(i, j + 1, bs) && mountain.get(i).get(j + 1) <= mountain.get(i).get(j)) {
	            int ret = func(mountain, i, j + 1, bs, board);
	            rv = Math.min(rv, ret);
	        }
	        if (isValid(i + 1, j, bs) && mountain.get(i + 1).get(j) <= mountain.get(i).get(j)) {
	            int ret = func(mountain, i + 1, j, bs, board);
	            rv = Math.min(rv, ret);
	        }
	        if (isValid(i, j - 1, bs) && mountain.get(i).get(j - 1) <= mountain.get(i).get(j)) {
	            int ret = func(mountain, i, j - 1, bs, board);
	            rv = Math.min(rv, ret);
	        }
	        if (isValid(i - 1, j, bs) && mountain.get(i - 1).get(j) <= mountain.get(i).get(j)) {
	            int ret = func(mountain, i - 1, j, bs, board);
	            rv = Math.min(rv, ret);
	        }

	        bs[i][j] = false;
	        // board[i][j] = rv;
	        return rv;

	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	
//	public static List<List<Integer>> solveMountain(List<List<Integer>> mountain) {
//        List<List<Integer>> rv = new ArrayList<List<Integer>>();
//        for (int i = 0; i < mountain.size(); ++i) {
//            ArrayList<Integer> list = new ArrayList<Integer>();
//            for (int j = 0; j < mountain.get(i).size(); ++j) {
//                list.add(func(mountain, i, j, new boolean[mountain.size()][mountain.get(0).size()]));
//            }
//            rv.add(list);
//        }
//
//        return rv;
//    }
//
//    public static boolean isValid(int i, int j, boolean[][] arr) {
//        if (i >= arr.length || j >= arr[0].length || i < 0 || j < 0) {
//            return false;
//        } else if (arr[i][j] == true) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//   private static Integer func(List<List<Integer>> mountain, int i, int j, boolean[][] bs) {
//
//        int rv = mountain.get(i).get(j);
//        bs[i][j] = true;
//
//        if (isValid(i, j + 1, bs)&&mountain.get(i).get(j+1)<=mountain.get(i).get(j)) {
//            int ret = func(mountain, i, j + 1, bs);
//            rv=Math.min(rv, ret);
//        }
//        if (isValid(i+1, j, bs)&&mountain.get(i+1).get(j)<=mountain.get(i).get(j)) {
//            int ret = func(mountain, i+1, j, bs);
//            rv=Math.min(rv, ret);
//        }
//        if (isValid(i, j -1, bs)&&mountain.get(i).get(j-1)<=mountain.get(i).get(j)) {
//            int ret = func(mountain, i, j - 1, bs);
//            rv=Math.min(rv, ret);
//        }
//        if (isValid(i-1, j, bs)&&mountain.get(i-1).get(j)<=mountain.get(i).get(j)) {
//            int ret = func(mountain, i-1, j, bs);
//            rv=Math.min(rv, ret);
//        }
//
//        bs[i][j] = false;
//        return rv;
//
//    }

}
