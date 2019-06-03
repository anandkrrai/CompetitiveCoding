package cc;

import java.util.ArrayList;
import java.util.Collections;

public class lexo {

	public static void main(String[] args) {

		int n=100;
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i=1;i<n;++i) {
			list.add(i+"");
		}
		
		Collections.sort(list);
		
		for(String st : list) {
			System.out.println(st);
		}
		
	}

}
