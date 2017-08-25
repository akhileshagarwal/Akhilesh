package com.akki.misc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HotelReviews {

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

	public static void main(String[] args) {

		int counter = 0;
		// Read dictionary
		Set<String> dict = new HashSet<String>();
		for (String word : args) {
			if (!isNumeric(word)) {
				dict.add(word.toLowerCase());
				counter++;
			} else {
				break;
			}
		}

		// Read number of reviews
		int m = Integer.parseInt(args[counter]);

		// Read review
		Map<Integer, Integer> hotel2count = new HashMap<Integer, Integer>(); // hotel
																				// ID
																				// ->
																				// Word
																				// Count
		counter = counter + 1;
		for (int i = 0; i < m; i++) {
			// Read hotel id

			int id = Integer.parseInt(args[counter].trim());

			// Put id in map in case of new
			if (!hotel2count.containsKey(id)) {
				hotel2count.put(id, 0);
			}
			counter = counter + 1;
			List<String> review = new ArrayList<>();
			// Read review text
			for (int j = counter; j <= counter; j++) {
				if (!isNumeric(args[j])) {
					review.add(args[j]);
					if (args.length == counter + 1) {
						break;
					}
					counter++;
				}
			}
			for (String word : review) {
				// Remove any ' ', ',', '.', '!' or '?' from word
				word = word.replaceAll("[$,.!?]", "").toLowerCase();
				if (dict.contains(word)) {
					hotel2count.put(id, hotel2count.get(id) + 1);
				}
			}
		}

		// Sort
		List<Map.Entry<Integer, Integer>> sorted = new ArrayList<>(hotel2count.entrySet());
		Collections.sort(sorted, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				if (o1.getValue() == o2.getValue()) {
					return o1.getKey() - o2.getKey();
				} else {
					return o2.getValue() - o1.getValue();
				}
			}
		});

		// Print sorted list
		for (Map.Entry<Integer, Integer> hotelEntry : sorted) {
			System.out.print(hotelEntry.getKey() + " ");
		}
	}
}