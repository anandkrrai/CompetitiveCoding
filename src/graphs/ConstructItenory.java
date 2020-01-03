package graphs;

import java.util.*;

public class ConstructItenory {
	public List<String> findItinerary(List<List<String>> tickets) {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		HashMap<String, Integer> available = new HashMap<>();

		for (List<String> ticket : tickets) {
			String from = ticket.get(0), to = ticket.get(1);
			available.put(from + "*" + to, available.getOrDefault(from + "*" + to, 0) + 1);
			if (!map.containsKey(from)) {
				map.put(from, new ArrayList<String>());
			}
			map.get(from).add(to);
		}

		int stops = tickets.size() + 1;
		ArrayList<String> iten = new ArrayList<>();

		for (String str : map.keySet())
			Collections.sort(map.get(str));

		iten.add("JFK");
		MakeIten(map, iten, "JFK", stops, available);
		return iten;
	}

	public boolean MakeIten(HashMap<String, ArrayList<String>> map, ArrayList<String> iten, String src, int target,
			HashMap<String, Integer> available) {
		if (iten.size() == target) {
			return true;
		}

		for (String nbr : map.get(src)) {
			if (available.get(src + "*" + nbr) > 0) {
				available.put(src + "*" + nbr, available.get(src + "*" + nbr) - 1);
				iten.add(nbr);
				if (MakeIten(map, iten, nbr, target, available))
					return true;
				available.put(src + "*" + nbr, available.get(src + "*" + nbr) + 1);
				iten.remove(iten.size() - 1);
			}
		}
		return false;
	}

}
