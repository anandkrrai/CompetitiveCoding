package aug12;

public class CompressionClient {

	public static void main(String[] args) throws Exception {
		HEncoder enc = new HEncoder("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccdd");
		System.out.println(enc.compress("aaaabbbbbccccccddddd"));
		System.out.println(enc.decompress(""));
	}

}
