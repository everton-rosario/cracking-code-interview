package uol;

public class DivisionAddSub {
	public static void main(String[] args) {
		System.out.println(div(50, 2));
		System.out.println(div(5, 2));
		System.out.println(div(3,2));
		try { div(1,0); } catch (Exception ex) { System.out.println("OK divisao por 0"); }
		System.out.println(div(1,1));
	}
	
	// O(log n)
	private static int div(int dividendo, int divisor) {
		
		int quociente = 0;
		
		if (divisor == 0) {
			throw new IllegalArgumentException("divisor zero!");
		}
		
		while (dividendo > 0 && dividendo >= divisor) {
			dividendo = dividendo - divisor;
			quociente = quociente + 1;
		}
		
		return quociente;
	}
}
