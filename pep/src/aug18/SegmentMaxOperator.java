package aug18;

public class SegmentMaxOperator implements ISegmentOperator {

	@Override
	public int operation(int lsv, int rsv) {
		// TODO Auto-generated method stub
		return Integer.max(lsv, rsv);
	}

	@Override
	public int defaultValue() {
		// TODO Auto-generated method stub
		return Integer.MIN_VALUE;
	}

}
