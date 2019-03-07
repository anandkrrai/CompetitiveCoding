package cc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import cc.ChargingBattries.list;

public class hashcode {

	public static class Node {
		HashSet<String> set = new HashSet<String>();
		int photo_num;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(
				new FileReader("/home/anand/eclipse-workspace/CompetitiveCoding/src/cc/a_example.txt"));

		String line = reader.readLine();
		int n = Integer.parseInt(line);
		ArrayList<Node> image_info = new ArrayList<Node>();

		for (int i = 0; i < n; ++i) {
			line = reader.readLine();
			String[] temp = line.trim().split("\\s+");
			Node node = new Node();
			node.photo_num = Integer.parseInt(temp[1]);
			for (int k = 2; k < temp.length; ++k) {
				node.set.add(temp[k]);
			}
			image_info.add(node);
		}

		ArrayList<LinkedList<Node>> list_set = new ArrayList<LinkedList<Node>>();

		LinkedList<Node> temp_list;
		Node temp_node;

		// adding 1st image
		temp_list = new LinkedList<hashcode.Node>();
		temp_node = image_info.get(0);
		temp_list.add(temp_node);
		list_set.add(temp_list);

		for (int i = 1; i < image_info.size(); ++i) {
			Node curr_img = image_info.get(i);

			for (int j = 0; j < list_set.size(); ++j) {
				LinkedList<Node> compare_list = list_set.get(j);

				for (int k = 0; k < compare_list.size(); ++k) {
					int similarity = findSimilarity(compare_list.get(k), curr_img);

				}
			}

		}

	}

	private static int findSimilarity(Node prev_img, Node curr_img) {
		int rv = 0;
		for (String str : curr_img.set) {
			if (prev_img.set.contains(str)) {
				++rv;
			}
		}
		return rv;
	}

	private static int findDisSimilarity(Node prev_img, Node curr_img) {
		int rv = 0;
		for (String str : curr_img.set) {
			if (!prev_img.set.contains(str)) {
				++rv;
			}
		}
		return rv;
	}

}
