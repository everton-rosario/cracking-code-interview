/**
 * 
 */
package facebook;

/**
 * Dado um numero qualquer inteiro, verificar quais são os fatores que consigam formar o numero pelos divisores de 2, 3 e 5
 * Exemplo:
 * 12: 
 *    6*2 + 0*3 + 0*5
 *    2*2 + 0*3 + 2*5
 *    ...
 *
 */
public class FB01 {
	
	public static void main(String[] args) {
		System.out.println("hello");
		
		System.out.println("" + tryNumber(2));
		System.out.println("" + tryNumber(3));
		System.out.println("" + tryNumber(5));
		System.out.println("" + tryNumber(6));
		System.out.println("" + tryNumber(7));
		System.out.println("" + tryNumber(8));
		System.out.println("" + tryNumber(9));
	}
	
	private static int tryNumber(int t) {
		
		//T = 2*x + 3*y + 5*z
		int count = 0;
	    for (int x = 0; x <= t/2; x++) {
	        for (int y = 0; y <= t/3; y++) {
	          int left = t - 2*x - 3*y;
	          if ((left % 5) == 0) {
	              ++count;
	          }
	        }
	    }
	    return count;
	}
}
