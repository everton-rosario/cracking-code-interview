/**
 * 
 */
package everton.cracking.arrays;

import java.util.Arrays;

/**
 * Given an array of integers move all non-zero elements to the left of all zero elements
 *
 * input: [1, 0, 3, 5, 10, 0, 11, 20, 0]
 * output: [1, 3, 5, 10, 11, 20, 0, 0, 0]
 */
public class ZeroesToRight {

	public static void main(String ... args) {
		int []test1 = new int[] {1, 0, 3, 5, 10, 0, 11, 20, 0};
		
		int []out1 = zeroesToRightCopy(test1);
		
		System.out.println(Arrays.toString(out1));
		
		zeroesToRightInplace(test1);
		System.out.println(Arrays.toString(test1));
	}

	/*
	 * (O)=n runtime
	 * (O)=2n space 
	 */
	private static int[] zeroesToRightCopy(int[] array) {
		int []response = new int[array.length];
		int index = 0;
		int lastIndex = array.length -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				response[lastIndex--] = 0;
			}
			else {
				response[index++] = array[i];
			}
		}
		return response;
	}
	
	/*
	 *  
	 */
	private static void zeroesToRightInplace(int[] array) {
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				array[index++] = array[i];
			}
		}
		
		for (; index < array.length; index++) {
			array[index] = 0;
		}
	}
}
