package careercup;

import java.util.ArrayList;
import java.util.HashSet;

public class Steps {
	public static void main(String[] args) {
		int stairs = 6;
		
		printAllPossibleRecursive(stairs, "");
		printAllPossibleIterative(stairs);
		
	}
	
	public static void printAllPossibleRecursive(int steps, String path) {
		if (steps <= 0) {
			System.out.println(path);
		
		} else {
			if (steps >= 1)
				printAllPossibleRecursive(steps -1, path + " 1");
			if (steps >= 2)
				printAllPossibleRecursive(steps -2, path + " 2");
		}
	}
	
	
	public static void printAllPossibleIterative(int steps) {
		ArrayList<HashSet<String>> prevPaths = new ArrayList<HashSet<String>>();

		HashSet<String> st1 = new HashSet<String>();
		st1.add("1");
		if(steps == 1) {
			System.out.println(st1);
			return;
			
		}
		prevPaths.add(st1);

		HashSet<String> st2 = new HashSet<String>();
		st2.add("11");
		st2.add("2");
		if(steps == 2) {
			System.out.println(st2);
			return;
		}
		prevPaths.add(st2);

		for (int i = 3; i <= steps; i++) {
			HashSet<String> sti = new HashSet<String>();

			HashSet<String> sti_1 = prevPaths.get(1);
			for(String subPath : sti_1) {
				sti.add("1" + subPath);
				sti.add(subPath + "1");
			}
			HashSet<String> sti_2 = prevPaths.get(0);
			for(String subPath : sti_2) {
				sti.add("2" + subPath);
				sti.add(subPath + "2");
			}

			prevPaths.add(0, prevPaths.get(1));
			prevPaths.add(1, sti);
		}

		System.out.println(prevPaths.get(1));
	}
	
}
