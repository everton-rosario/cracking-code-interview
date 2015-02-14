package facebook;

public class FB02 {
	public static void main(String[]args) {
		String s = "abcdef";
		System.out.println(reverse(s));
	}

	private static String reverse(String s) {
		char[] chars = s.toCharArray();
		
		for (int start = 0, end = chars.length -1; start < end; start++, end--) {
			char aux = chars[start];
			chars[start] = chars[end];
			chars[end] = aux;
		}
		
		return String.valueOf(chars);
	}
}
