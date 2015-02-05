/**
 * 
 */
package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 */
public class Palindroma {
	

	public static void main(String ... args) {
		
		if (args == null || args.length == 0) {
			args = new String[] {"aaabb", "ababa", "gol", "log", "olg", "miss"};
		}
	
		// Separates the words in a map:
		//     wordsMap: {"aaab": {"a": 3, "b" : 1}}
		Map<String, Map<String, Integer>> wordsMap = new HashMap<String, Map<String, Integer>>();
		for (String word : args) {
			Map<String, Integer> wordMap = new HashMap<String, Integer>();
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				Integer amount = wordMap.get("" + c);
				if (amount == null) {
					amount = 0;
				}
				amount = amount +1;
				wordMap.put("" + c, amount);
			}
	
			wordsMap.put(word, wordMap);
		}
	
		// Mounts the list of sets of palindroma words
		List<List<String>> allPalindromas = new ArrayList<List<String>>();
		Set<String> usedWords = new TreeSet<String>();
		for (int j = 0; j < args.length; j++) {
			String word1 = args[j];
			if (!usedWords.contains(word1)) {
				Map<String, Integer> map1 = wordsMap.get(word1);
				
				List<String> listPalindromas = new ArrayList<String>();
				
				listPalindromas.add(word1);
				usedWords.add(word1);
				for (int i = j+1; i < args.length; i++) {
					String word2 = args[i];
		
					Map<String, Integer> map2 = wordsMap.get(word2);
					if (checkPalindroma(map1, map2)) {
						listPalindromas.add(word2);
						usedWords.add(word2);
					}
				}
		
				allPalindromas.add(listPalindromas);
			}
		}
	
		for (List<String> palindroma : allPalindromas) {
			System.out.println(palindroma.toString());
		}
	}


	private static boolean checkPalindroma(Map<String, Integer> map1, Map<String, Integer> map2) {
		boolean isPalindroma = true;
		for (Map.Entry entry : map1.entrySet()) {
		    Integer value2 = map2.get(entry.getKey());
		    if (value2 != null && value2.equals(entry.getValue())) {
		        continue;
		    } else {
		        isPalindroma = false;
		        break;
		    }
		}
		
		return isPalindroma;
	}

}
