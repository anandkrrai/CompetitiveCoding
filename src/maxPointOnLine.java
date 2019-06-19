//http://134.209.156.168:3004/resource/interview-prep/hmap-and-heaps/max-points-on-line/ojquestion

import java.util.*;

public class maxPointOnLine {

	public static class Line {
		int dx;
		int dy;

		public Line(int dy, int dx) {
			this.dy = dy;
			this.dx = dx;
		}

		@Override
		public int hashCode() {
			return this.dy + this.dx;
		}

		@Override
		public boolean equals(Object o) {
			Line lo = (Line) o;
			if (this.dx == lo.dx && this.dy == lo.dy) {
				return true;
			} else {
				return false;
			}
		}

	}

	public static int maxPoints(Point[] points) {
		// Write your code here
		HashMap<Line, Integer> map = new HashMap<>();
		int result = 0;

		for (int i = 0; i < points.length; i++) {
			int max = 0;
			map.clear();

			int x1 = points[i].x;
			int y1 = points[i].y;

			for (int j = i + 1; j < points.length; j++) {

				int x2 = points[j].x;
				int y2 = points[j].y;

				int dy = y2 - y1;
				int dx = x2 - x1;

				int gcd = gcd(dy, dx);
				if (gcd != 0) {
					dx /= gcd;
					dy /= gcd;
				}

				Line l = new Line(dy, dx);
				map.put(l, map.getOrDefault(l, 0) + 1);
				max = Math.max(max, map.getOrDefault(l, 0));
			}
			result = Math.max(result, max);
		}

		return result;

	}

	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else
			return gcd(b, a % b);
	}

	/// Dont make changes here
	static class Point {

		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Point[] points = new Point[N];
		for (int i = 0; i < N; i++) {
			points[i] = new Point(sc.nextInt(), sc.nextInt());
		}
		System.out.println(maxPoints(points));
	}
}

/*
 * import java.util.*;
 
 public class Main {
 
    public static class Line {
		int dx;
		int dy;

		public Line(int dy, int dx) {
			this.dy = dy;
			this.dx = dx;
		}
	}

	public static int maxPoints(Point[] points) {
		// Write your code here
		HashMap<String, Integer> map = new HashMap<>();
		int result = 0;

		for (int i = 0; i < points.length; i++) {
			int max = 0;
			map.clear();
		
				int x1 = points[i].x;
				int y1 = points[i].y;
				
			for (int j = i + 1; j < points.length; j++) {
		
				int x2 = points[j].x;
				int y2 = points[j].y;

				int dy = y2 - y1;
				int dx = x2 - x1;

				int gcd = gcd(dy, dx);
				if (gcd != 0) {
					dx /= gcd;
					dy /= gcd;
				}
        
				// Line l = new Line(dy, dx);
				String l =dy+" "+dx;
				map.put(l, map.getOrDefault(l, 1) + 1);
				max = Math.max(max, map.get(l));
			}
			result=Math.max(result, max);
		}
		
		return result;

	}

	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else
			return gcd(b, a % b);
	}

 
     ///Dont make changes here
     static class Point {
 
         int x, y;
 
         Point(int x, int y) {
             this.x = x;
             this.y = y;
         }
     }
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int N = sc.nextInt();
         Point[] points = new Point[N];
         for (int i = 0; i < N; i++) {
             points[i] = new Point(sc.nextInt(), sc.nextInt());
         }
         System.out.println(maxPoints(points));
     }
 }

 */
*/