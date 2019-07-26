package tree;


public class trieClient {

	public static void main(String[] args) {
		trie obj = new trie();
		
		obj.insert("anand");
		System.out.println(obj.search("anand"));
		System.out.println(obj.search("anan"));
		System.out.println(obj.startsWith("a"));
	}

}
