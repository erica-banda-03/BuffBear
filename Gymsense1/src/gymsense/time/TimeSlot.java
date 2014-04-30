/**
 * 
 * @author eriklopez
 *
 */
package gymsense.time;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class TimeSlot implements Comparable<TimeSlot>, Serializable{
	
	@Id String dayTime; //start
	private int duration; //in minutes
	private int startHour;
	private int startMinutes;
	private String startAMPM;
	private int endHour;
	private int endMinutes;
	private String endAMPM;
	private String day;

	/*-------------------CONSTRUCTORS--------------------*/
	
	private TimeSlot(){}
	
	public TimeSlot(int startHour, int startMinutes, String startAMPM, int endHour, int endMinutes, String endAMPM, String day){
		//startAMPM if it is "PM", then endAMPM must be PM too for this to work properly
		this.day = day;
		this.startHour = startHour;
		this.startMinutes = startMinutes;
		this.startAMPM=startAMPM;
		if ((startAMPM.equalsIgnoreCase("pm") && !(this.startHour == 12 && this.startAMPM.equalsIgnoreCase("pm"))) || (this.startHour == 12 && this.startAMPM.equalsIgnoreCase("am"))){
			this.startHour+=12;
		}
		this.endHour = endHour;
		this.endMinutes = endMinutes;
		this.endAMPM = endAMPM;
		if ((endAMPM.equalsIgnoreCase("pm") && !(this.endHour == 12 && this.endAMPM.equalsIgnoreCase("pm")))|| (this.endHour == 12 && this.endAMPM.equalsIgnoreCase("am"))){
			this.endHour+=12;
		}

		//time being set, and the id that will be used for accessing from Dailyslot 
		this.dayTime = Integer.toString(startHour)+Integer.toString(startMinutes)+Integer.toString(endHour)+Integer.toString(endMinutes) + day;
		duration = Math.abs(((this.endHour*60)+this.endMinutes)-((this.startHour*60)+this.startMinutes));
		
	}

	public TimeSlot(String startTime, String endTime, String day){
		TimeParser.parseTime(startTime);
		this.day = day;
		this.startHour = TimeParser.getHour();
		this.startMinutes = TimeParser.getMinutes();
		this.startAMPM = TimeParser.getAMPM();
		if ((startAMPM.equalsIgnoreCase("pm") && !(this.startHour == 12 && this.startAMPM.equalsIgnoreCase("pm"))) || (this.startHour == 12 && this.startAMPM.equalsIgnoreCase("am"))){
			this.startHour+=12;
		}
		
		TimeParser.parseTime(endTime);
		this.endHour = TimeParser.getHour();
		this.endMinutes = TimeParser.getMinutes();
		this.endAMPM = TimeParser.getAMPM();
		if ((endAMPM.equalsIgnoreCase("pm") && !(this.endHour == 12 && this.endAMPM.equalsIgnoreCase("pm"))) || (this.endHour == 12 && this.endAMPM.equalsIgnoreCase("am"))){
			this.endHour+=12;
		}
		
		duration = Math.abs(((this.endHour*60)+this.endMinutes)-((this.startHour*60)+this.startMinutes));
		this.dayTime = startTime+endTime+day;
	}
	
	// toStrings
	
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
	@Override
	public String toString(){
		int startTemp= startHour;
		int endTemp= endHour;
		if ((startAMPM.equalsIgnoreCase("pm") && !(this.startHour == 12 && this.startAMPM.equalsIgnoreCase("pm"))) || (this.startHour == 12 && this.startAMPM.equalsIgnoreCase("am"))){
			startTemp = startHour-12;
		}
		if ((endAMPM.equalsIgnoreCase("pm") && !(this.endHour == 12 && this.endAMPM.equalsIgnoreCase("pm"))) || (this.endHour == 12 && this.endAMPM.equalsIgnoreCase("am"))){
			endTemp = endHour-12;
		}
		
		return "Start: "+startTemp+":"+String.format("%02d",startMinutes)+startAMPM
				+" End: "+endTemp+":"+String.format("%02d",endMinutes)+endAMPM;
	}

	//Getters
	
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
	/**
	 * Returns duration of timeslot in minutes
	 * @return duration
	 */
	public int getDuration(){
		return duration;
	}

	public int getStartTimeInMinutes(){
		return (this.startHour*60)+this.startMinutes;
	}
	public int getEndTimeInMinutes(){
		return (this.endHour*60)+this.endMinutes;
	}
	//To Enable Sorting
	
	@Override
	/**
	 * Returns positive if this instance is greater than the parameter
	 * Zero if they're the same (which shouldn't happen)
	 * Negative if this one is earlier than the parameter
	 * @param that
	 * @return positive(>), 0(==), or negative (<) 
	 */
	public int compareTo(TimeSlot that) {
		if (this.startAMPM.equals("am") && that.startAMPM.equals("pm")){
			return -1;
		}
		else if (this.startAMPM.equals("pm") && that.startAMPM.equals("am")){
			return 1;
		}
		
		if (this.startHour < that.startHour){
			return -1;
		}
		else if (this.startHour > that.startHour){
			return 1;
		}

		return 0;
	}
	
	

	
}
