package arraysAndstrings;

import java.util.*;

public class removeSubFolders {

	public List<String> removeSubfolders(String[] folder) {
		Arrays.sort(folder);
		List<String> rv = new ArrayList<>();
		if (folder.length == 0)
			return rv;
		rv.add(folder[0]);
		int i = 0, j = 1;
		while (j < folder.length) {

			if (folder[j].startsWith(folder[i] + "/")) {
				++j;
			} else {
				rv.add(folder[j]);
				i = j++;
			}
		}
		return rv;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
