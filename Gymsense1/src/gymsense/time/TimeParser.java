package gymsense.time;
/**
 * Majority of this code comes from the Testing Tutorial
 * Credit: Dr. KIM (?) 
 * Added code to suit it to the project needs
 * @author EE461L
 */

public class TimeParser {
   private static final int MINS_PER_HR = 60;
   private static final int SECS_PER_MIN = 60;
   
   private static final int MIN_HRS = 0;
   private static final int MAX_HRS = 23;
   private static final int MIN_MINS = 0;
   private static final int MAX_MINS = 59;
  // private static final int MIN_SECS = 0;
   //private static final int MAX_SECS = 59; // ignore leap seconds
   
   private static int hr=0;
   private static int mins=0;
   private static String AM_PM="none";
   
   /**
    * String must be of the form 00:00 XX for us to parse it correctly 
    * Note: XX can stand for either "AM" or "PM"
    * @param time as a string
    * @return time in minutes as an int 
    * @throws NumberFormatException
    */
   public static void parseTime(String time) throws NumberFormatException {
       // Normalize the input (trim whitespace and make lower case)
       time = time.trim().toLowerCase();
       
       int firstColon = time.indexOf(':');
       if (firstColon == -1) {
           throw new NumberFormatException("Unrecognized time format");
       }
       
       // Interpret everything up to the first colon as the hour
        hr = Integer.valueOf(time.substring(0, firstColon));
       // Interpret everything between the two colons as the minute
       mins = Integer.valueOf(time.substring(firstColon+1, firstColon+3));
       // Interpret the two characters after the second colon as the seconds
     
       // Adjust hours if 'pm' specified
       if (time.contains("pm")) {
           AM_PM = new String("pm");
       } else if (time.contains("am")) {
           AM_PM = new String("am");
       }
       else {
    	   throw new IllegalArgumentException("Unacceptable time specified");
       }

       // Range check the values
       if ((hr < MIN_HRS || hr > MAX_HRS) ||(mins < MIN_MINS || mins > MAX_MINS)) {
               throw new IllegalArgumentException("Unacceptable time specified");
       }
   }
   public static int getHour(){
	   return hr;
   }
   public static int getMinutes(){
	   return mins;
   }
   public static String getAMPM(){
	   return AM_PM;
   }
   
}