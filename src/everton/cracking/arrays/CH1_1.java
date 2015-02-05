package everton.cracking.arrays;

public class CH1_1 {
	
	/*
	 * Order chars and run over checking each with next/prev:
	 *    Runtime: O(n log n)
	 *    Space: O(n)
	 *    
	 * Put chars in a set (not duplicates) and check length at end
	 *    Runtime: O (n log n) 
	 *    Space: O(n)
	 *    
	 * Consider a-z chars, fits in an array, with boolean values for each entry
	 *    Runtime: O(n)
	 *    Space: O(256) constant
	 */
	private static boolean uniqueChars(String word) {
		
		boolean[] chars = new boolean[255];
		for (int i = 0; i < word.length(); i++) {
			if (chars[word.charAt(i)]) return false;
			chars[word.charAt(i)] = true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str = "abcdefgh";
		
		System.out.println(uniqueChars(str));
	}
}
