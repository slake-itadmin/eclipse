import java.text.SimpleDateFormat;
import java.util.Date;

public class CompareDateTime {

	public static long main(String dateStart, String dateStop) {
		 
		 // Custom date format 
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 
		 Date d1 = null; Date d2 = null; 
		 try { 
			 d1 = format.parse(dateStart); d2 = format.parse(dateStop); 
		 } 
		 catch (Exception e) { 
			 e.printStackTrace(); 
		 }
		 
		 // Get minutes
		 long diff = d2.getTime() - d1.getTime();
		 long diffMinutes = diff / (60 * 1000);
		return diffMinutes;
	}
}
