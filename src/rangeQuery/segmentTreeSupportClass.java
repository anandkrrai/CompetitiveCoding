package rangeQuery;

public class segmentTreeSupportClass {

	public class MaxOperator implements Ioperator{

		@Override
		public int identity() {
			// TODO Auto-generated method stub
			return Integer.MIN_VALUE;
		}

		@Override
		public int operation(int x, int y) {
			// TODO Auto-generated method stub
			return Math.max(x, y);
		}

	}
		
	public class MinOperator implements Ioperator{

		@Override
		public int identity() {
			// TODO Auto-generated method stub
			return Integer.MAX_VALUE;
		}

		@Override
		public int operation(int x, int y) {
			// TODO Auto-generated method stub
			return Math.min(x, y);
		}

	}
		
	public class SumOperator implements Ioperator{

		@Override
		public int identity() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int operation(int x, int y) {
			// TODO Auto-generated method stub
			return x+y;
		}

	}
	
	public class ProductOperator implements Ioperator{

		@Override
		public int identity() {
			// TODO Auto-generated method stub
			return 1;
		}

		@Override
		public int operation(int x, int y) {
			// TODO Auto-generated method stub
			return x*y;
		}

	}
}
