package everton.studyalgos;

import java.util.Arrays;

public class AppartEvenOdd {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(appartEvenOdd(new int [] { 1, 2, 4, 5, 8 } )));
	}

	private static int[] appartEvenOdd(int[] values) {
		
		int left = 0 ;
		int right = values.length - 1;
		
		while (left < right) {
			while (values[left] % 2 == 0 && left < right) {
				left++;
			}
			while (values[right] % 2 != 0 && left < right) {
				right--;
			}
			
			if (left < right) {
				int aux = values[left];
				values[left] = values[right];
				values[right] = aux;
				right--;
				left++;
			}
			
		}
		
		return values;
	}
}
