package aug18;

public class SegmentProductOperator implements ISegmentOperator {

	@Override
	public int operation(int lsv, int rsv) {
		// TODO Auto-generated method stub
		return lsv * rsv;
	}

	@Override
	public int defaultValue() {
		// TODO Auto-generated method stub
		return 1;
	}

}
