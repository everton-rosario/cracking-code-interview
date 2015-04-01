package careercup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Knows {
	
	private static Map<String, Boolean> knows = new HashMap<String, Boolean>();
	
	public static boolean knows(String one, String other) {
		return Boolean.TRUE.equals(knows.get(one + other));
	}
	
	public static void main(String[] args) {
		
		// A [B, C]
		knows.put("AB", true);
		knows.put("AC", true);
		knows.put("AD", true);
		
		// B [D, C]
		knows.put("BA", true);
		knows.put("BC", true);
		knows.put("BD", true);

		// C []

		// D [A, B]
		knows.put("DA", true);
		knows.put("DB", true);
		knows.put("DC", true);
		
		String celeb = "";
		List<String> people = new ArrayList(Arrays.asList(new String[] { "A", "B", "C", "D" }));
		
		if (!people.isEmpty()) {
			celeb = people.remove(0);
			while (!people.isEmpty() && people.size() > 1) {
				if (knows(celeb, people.get(0))) {
					celeb = people.remove(0);
				} else {
					people.add(celeb);
					celeb = people.remove(0);
				}
			}
			
		}
		
		System.out.println(celeb);

	}
}
