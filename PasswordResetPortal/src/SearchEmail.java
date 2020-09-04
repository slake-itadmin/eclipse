import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchEmail {
	
	public static String search(String emails) throws Exception {
		
		String silverglobe = "silverglobe";
		String silverlakeaxis = "silverlakeaxis";
		Boolean contain_silverlakeaxis = emails.contains(silverlakeaxis);
		Boolean contain_silverglobe = emails.contains(silverglobe);
		
		
		
		if (contain_silverlakeaxis == true) {

			final String silverlakeaxis_regex = "[a-zA-Z0-9-_.]+@silverlakeaxis.com";
			final Pattern silverlakeaxis_pattern = Pattern.compile(silverlakeaxis_regex);
			final Matcher silverlakeaxis_matcher = silverlakeaxis_pattern.matcher(emails);

			if (silverlakeaxis_matcher.find()) {
				return silverlakeaxis_matcher.group(0);
			}
		}
		else if (contain_silverglobe == true) {

			final String silverglobe_regex = "[a-zA-Z0-9-_.]+@silverglobe.com";
			final Pattern silverglobe_pattern = Pattern.compile(silverglobe_regex);
			final Matcher silverglobe_matcher = silverglobe_pattern.matcher(emails);

			if (silverglobe_matcher.find()) {
				return silverglobe_matcher.group(0);
			}
		}
		return null;
	}
}	