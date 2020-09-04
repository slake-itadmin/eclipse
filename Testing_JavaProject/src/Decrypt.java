
public class Decrypt {

	public static void main(String[] args) {
		String text = "Mj~1%mt|,x%ny%mfslnslD";
		System.out.println(text);
		
		char[] chars = text.toCharArray();
		
		for (char c : chars) {
			c -= 5;
			System.out.print(c);
		}
	}
}
