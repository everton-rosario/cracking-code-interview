package everton.cracking.moderate;

public class SwapInplace {
	public static void main(String[] args) {
		System.out.println(swapInplace(0,1));
		System.out.println(swapInplace(1,2));
		System.out.println(swapInplace(2,3));
		System.out.println(swapInplace(0,-1));
		System.out.println(swapInplace(5,-1));
	}

	private static String swapInplace(int a, int b) {
		
//		a = b-a;
//		b = b-a;
//		a = a+b;
		
		a = b^a;
		b = b^a;
		a = a|b;
		
		
		return "a="+ a + " b=" + b;
	}
}
