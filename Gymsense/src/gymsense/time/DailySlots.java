package gymsense.time;

import java.util.ArrayList;
import java.util.Iterator;

public class DailySlots {
	private ArrayList<TimeSlot> timeSlots;
	//private int day;

	public DailySlots(){
		timeSlots = new ArrayList<TimeSlot>(3);
		//this.day = day;  
	}
	/**
	 * Adds to the list of time slots, true if successful
	 * false if not successful 
	 * @param TimeSlot slot
	 * @return BOOLEAN
	 */
	public boolean add(TimeSlot slot){
		Iterator<TimeSlot> iter = timeSlots.iterator();
		//	
		if (slot.getStartHour() >= slot.getEndHour()){	
			//System.out.println(slot.getStartHour()+" "+slot.getEndHour());
			return false;
		}
		//No Timeslots less than 15 mins long
		if (slot.getDuration() < 15){
			return false;
		}
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
		return true;
		
		
	}
	
	/*public TimeSlot getLargestTimeSlot(){
		
	}*/
	
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
	 * Returns the day as a String
	 * @return Day as a string
	 */
	/*public String getDay(){
		switch(this.day){
		case 1: return "Monday";
		case 2: return "Tuesday";
		case 3: return "Wednesday";
		case 4: return "Thursday";
		case 5: return "Friday";
		case 6: return "Saturday";
		case 7: return "Sunday";
		}
		return "no day";
		
	}*/
	
	public boolean isEmpty(){
		return timeSlots.isEmpty();
	}
	
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
