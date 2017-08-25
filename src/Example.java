import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Example {
	public static void main(String[] args) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		long totalCost = 0;
		for (int a0 = 0; a0 < q; a0++) {
			int n = in.nextInt();
			int m = in.nextInt();
			long x = in.nextLong();
			long y = in.nextLong();
			for (int a1 = 0; a1 < m; a1++) {
				int city_1 = in.nextInt();
				int city_2 = in.nextInt();
				addCity(map, city_1, city_2);
				addCity(map, city_2, city_1);
			}
			if (x < y) {
				totalCost = x * n;
			} else {
				List<Integer> cities = new ArrayList<>();
				for (int i = 1; i <= n; i++) {
					cities.add(i);
				}
				List<Entry<Integer, List<Integer>>> list = sortByValue(map);
				for (Entry<Integer, List<Integer>> entry : list) {
					List<Integer> nearByCities = entry.getValue();
					Integer city = entry.getKey();
					nearByCities.forEach(nearby -> {
						cities.remove(nearby);
					});
					if (cities.contains(city)) {
						totalCost = totalCost + x + y * nearByCities.size();
					}
				}
				totalCost = totalCost + x * cities.size();

			}
			System.out.println(totalCost);
		}
		in.close();
	}

	static void addCity(Map<Integer, List<Integer>> map, int i1, int i2) {
		if (map.containsKey(i1)) {
			map.get(i1).add(i2);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(i2);
			map.put(i1, list);
		}
	}

	static List<Entry<Integer, List<Integer>>> sortByValue(Map<Integer, List<Integer>> map) {
		Set<Entry<Integer, List<Integer>>> set = map.entrySet();
		List<Entry<Integer, List<Integer>>> list = new ArrayList<>(set);
		Collections.sort(list, new Comparator<Entry<Integer, List<Integer>>>() {
			@Override
			public int compare(Entry<Integer, List<Integer>> o1, Entry<Integer, List<Integer>> o2) {
				return o1.getValue().size() - o2.getValue().size();
			}
		});
		return list;
	}
}
