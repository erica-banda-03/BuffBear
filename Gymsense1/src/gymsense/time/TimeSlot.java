/**
 * 
 * @author eriklopez
 *
 */
package gymsense.time;

public class TimeSlot {
	
	private int duration; //in minutes
	private int startHour;
	private int startMinutes;
	private String startAMPM;
	private int endHour;
	private int endMinutes;
	private String endAMPM;
/*int startHour, int startMinutes, String startAMPM, int endHour, int endMinutes, String endAMPM*/	
	public TimeSlot(int startHour, int startMinutes, String startAMPM, int endHour, int endMinutes, String endAMPM){
		//startAMPM if it is "PM", then endAMPM must be PM too for this to work properly
		this.startHour = startHour;
		this.startMinutes = startMinutes;
		this.startAMPM=startAMPM;
		if (startAMPM.equalsIgnoreCase("pm") && !(this.startHour == 12 && this.startAMPM.equalsIgnoreCase("pm")) || (this.startHour == 12 && this.startAMPM.equalsIgnoreCase("am"))){
			this.startHour+=12;
		}
		this.endHour = endHour;
		this.endMinutes = endMinutes;
		this.endAMPM = endAMPM;
		if (endAMPM.equalsIgnoreCase("pm") || (this.startHour == 12 && this.startAMPM.equalsIgnoreCase("pm"))){
			this.endHour+=12;
		}
		duration = Math.abs(((this.endHour*60)+this.endMinutes)-((this.startHour*60)+this.startMinutes));
		
	}

	public int getDuration(){return duration;}
	
	/**
	 * @return duration of the time slot in hrs and minutes
	 */
	public String durationToString(){
		int tempHrs = duration/60;
		String hr="hrs";
		if (tempHrs == 1){
			hr = "hr";
		}
		int tempMins = duration%60;
		if (tempMins !=0){
			return "Duration: "+tempHrs+hr+", "+String.format("%02d", tempMins)+" mins";
		}
		return "Duration: "+tempHrs+hr;

	}
	/**
	 * @return timeSlot in the format "Start: hh:mm AM/PM End: hh:mm AM/PM"
	 */
	public String toString(){
		int startTemp= startHour;
		int endTemp= endHour;
		if (startAMPM.equalsIgnoreCase("pm")){
			startTemp = startHour-12;
		}
		if (endAMPM.equalsIgnoreCase("pm")){
			endTemp = endHour-12;
		}
		
		return "Start: "+startTemp+":"+String.format("%02d",startMinutes)+startAMPM
				+" End: "+endTemp+":"+String.format("%02d",endMinutes)+endAMPM;
	}

	/**
	 * @return the startHour
	 */
	public int getStartHour() {
		return startHour;
	}
	/**
	 * @return the startMinutes
	 */
	public int getStartMinutes() {
		return startMinutes;
	}
	/**
	 * @return the startAMPM
	 */
	public String getStartAMPM() {
		return startAMPM;
	}
	/**
	 * @return the endHour
	 */
	public int getEndHour() {
		return endHour;
	}
	/**
	 * @return the endMinutes
	 */
	public int getEndMinutes() {
		return endMinutes;
	}
	/**
	 * @return the endAMPM
	 */
	public String getEndAMPM() {
		return endAMPM;
	}
	
	
	
}
