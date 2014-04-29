package gymsense.time;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.jdo.annotations.EmbeddedOnly;
import javax.persistence.Embedded;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Embed;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Serialize;

@Entity
public class DailySlots implements Serializable {
	
	@Id String emailDay;
	String day;
	@Embedded
	private ArrayList<TimeSlot> timeSlots;
	
//Constructor
	private DailySlots(){}
	
	public DailySlots(String day, String email){
		this.day= day;
		this.emailDay = email + day;
		timeSlots = new ArrayList<TimeSlot>(3); 
	}
//DailySlots Methods
	/**
	 * Adds to the list of time slots, true if successful
	 * false if not successful 
	 * @param TimeSlot slot
	 * @return true if added successfully
	 */
	public boolean add(TimeSlot slot){
		Iterator<TimeSlot> iter = timeSlots.iterator();
		//checks illegal starting & ending time values 
		if (slot.getStartHour() < 1 || slot.getEndHour() < 1){return false;}
		if (slot.getStartHour() > 24 || slot.getEndHour() > 24){return false;}
		if (slot.getStartHour() > slot.getEndHour()){	return false;}
		if (slot.getStartMinutes() <0 || slot.getStartMinutes() >= 60){return false;}
		if (slot.getEndMinutes() < 0 || slot.getEndMinutes() >= 60){return false;}
		
		//No Timeslots less than 15 mins long
		if (slot.getDuration() < 15){return false;}
		
		while (iter.hasNext()){
				
			TimeSlot hold = iter.next();
			if (hold.getStartHour() > slot.getStartHour() && hold.getStartHour() < slot.getEndHour()){
				//System.out.println("1c");
				return false;
					
			}
			if (hold.getEndHour() > slot.getStartHour() && hold.getEndHour() < slot.getEndHour()){
				//System.out.println("1d");
				return false;
			}
		}
		timeSlots.add(slot);
		
		//SORT them to make them pretty for when we do toString()
		Collections.sort(timeSlots);
		return true;	
	}
	/**
	 * Finds and returns the largest timeSlot
	 * if no time slots found, null is returns
	 * @return TimeSlot or null
	 */
	public TimeSlot getLargestTimeSlot(){
		if (timeSlots.size() == 0)
			return null;
		int indexOfLargest=0;
		for (int i = 0; i < timeSlots.size(); i++){
			if (timeSlots.get(i).getDuration() > timeSlots.get(indexOfLargest).getDuration()){
				indexOfLargest = i;
			}
		}
		return timeSlots.get(indexOfLargest);
	}
	
	public int getNumberOfSlots(){
		return timeSlots.size();
	}
	/**
	 * Deletes all time slots previously entered
	 */
	public void clear(){
		timeSlots.clear();
	}
	/**
 	* Returns true if no timeslots have been added
 	* @return true if empty
 	*/
	public boolean isEmpty(){
		return timeSlots.isEmpty();
	}
	/**
	 * Representation of a DailySlots as a string
	 */
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		//str.append(this.getDay()+":\n");
		Iterator<TimeSlot> iter = timeSlots.iterator();
		if (!iter.hasNext()){
			str.append("No Available Time Slots\n");
		}
		else {
			while (iter.hasNext()){
				str.append(iter.next().toString()+"\n");
			}
		}
		
		return str.toString();
		//return timeSlots.toString();
	}
}
