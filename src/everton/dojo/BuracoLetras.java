/**
 * 
 */
package everton.dojo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author peo_erosario
 *
 */
public class BuracoLetras {
	
	private static Map<Character, Integer> holes = new HashMap<Character, Integer>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		holes.put('a', 1);
		holes.put('b', 1);
		holes.put('d', 1);
		holes.put('e', 1);
		holes.put('g', 1);
		holes.put('o', 1);
		holes.put('p', 1);
		holes.put('q', 1);
		holes.put('A', 1);
		holes.put('B', 2);
		holes.put('D', 1);
		holes.put('O', 1);
		holes.put('P', 1);
		holes.put('Q', 1);
		holes.put('R', 1);
		
		System.out.println("Soma: " + sumHolesWords("A Soma dos BURACOS e incrivel"));
		System.out.println("Soma: " + sumHolesWords("l"));
		System.out.println("Soma: " + sumHolesWords(""));
		System.out.println("Soma: " + sumHolesWords("B"));
		System.out.println("Soma: " + sumHolesWords(null));
	}

	private static int sumHolesWords(String string) {
		int total = 0;
		
		if (string != null) {
			for (int i = 0; i < string.length(); i++) {
				Integer charHoles = holes.get(string.charAt(i));
				if (charHoles != null) {
					total += charHoles;
				}
			}
		}
		
		return total;
	}

}
