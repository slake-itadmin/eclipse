import java.text.SimpleDateFormat;
import java.util.Date;

public class CompareDateTime {

	public static void main(String[] args) {
		
		 String dateStart = "2020-07-14 23:58:58"; 
		 String dateStop = "2020-07-15 00:05:43";
		 
		 // Custom date format 
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 
		 Date d1 = null; Date d2 = null; 
		 try { 
			 d1 = format.parse(dateStart); d2 = format.parse(dateStop); 
		 } 
		 catch (Exception e) { 
			 e.printStackTrace(); 
		 }
		 
		 // Get msec from each, and subtract. 
		 long diff = d2.getTime() - d1.getTime();
		 long diffSeconds = diff / 1000 % 60; long diffMinutes = diff / (60 * 1000);
		 long diffHours = diff / (60 * 60 * 1000);
		 System.out.println("Time in seconds: " + diffSeconds + " seconds.");
		 System.out.println("Time in minutes: " + diffMinutes + " minutes.");
		 System.out.println("Time in hours: " + diffHours + " hours.");
	}
}
