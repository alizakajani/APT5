import java.util.*;

public class SortByFreqs {
	
	public String[] sort(String[] data) {
		
		TreeMap<String,Integer> map = new TreeMap<>();
		for(String s : data) {
			map.putIfAbsent(s, 0);
			map.put(s, map.get(s) + 1);
		}
		
		ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, Collections.reverseOrder(Comparator.comparing(Map.Entry::getValue)));
		
		String[] sorted = new String[list.size()];
		for (int k = 0; k < list.size(); k += 1) {
			sorted[k] = list.get(k).getKey();
		}
		return sorted;
	}
}
