import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class SortedFreqs {
	public int[] freqs(String[] data) {
		
		TreeMap<String,Integer> map = new TreeMap<>();
		for(String s : data) {
			map.putIfAbsent(s, 0);
			map.put(s, map.get(s) + 1);
		}
		
		ArrayList<Integer> freqList = new ArrayList<>();
		for(String key : map.keySet()) {
			freqList.add(map.get(key));
		}
		
		int[] freqArray = new int[map.keySet().size()];
		for(int k = 0; k < map.keySet().size(); k += 1) {
			freqArray[k] = freqList.get(k);
		}
		return freqArray;
	}
}
