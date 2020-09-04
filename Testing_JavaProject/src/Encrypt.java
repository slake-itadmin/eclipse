
public class Encrypt {

	public static void main(String[] args) {
		String text = "Hey, how's it hanging?";
		System.out.println(text);

		char[] chars = text.toCharArray();

		for (char c : chars) {
			c += 5;
			System.out.print(c);
		}
	}
}
