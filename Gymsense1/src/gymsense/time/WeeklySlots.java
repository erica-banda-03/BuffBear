package gymsense.time;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Embedded;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class WeeklySlots implements Iterable<String>{
	//HashMap<String, DailySlots> week;
	
	@Id String email;
	@Embedded
	LinkedHashMap<String, DailySlots> week;
	
	private WeeklySlots(){}
	
	public WeeklySlots(String email){
		this.email= email;
		/*
		week = new LinkedHashMap<String, DailySlots>();
		week.put("sunday", new DailySlots("sunday", email));
		week.put("monday", new DailySlots("monday", email));
		week.put("tuesday", new DailySlots("tuesday", email));
		week.put("wednesday", new DailySlots("wednesday", email));
		week.put("thursday", new DailySlots("thursday",email));
		week.put("friday", new DailySlots("friday",email));
		week.put("saturday", new DailySlots("saturday", email)); */
		
	}
	
	public int getTotalSlotNumber(){
		Iterator<String> iter = week.keySet().iterator();
		int total = 0;
		while (iter.hasNext()){
			total += week.get(iter.next()).getNumberOfSlots();
		}
		return total;
		
	}
	/**
	 * Tells you if theres any slots contained in any of the days
	 * @return true if there's one mapping
	 */
	public boolean isEmpty(){
		Iterator<String> iter = week.keySet().iterator();
		while(iter.hasNext()){
			if (!week.get(iter.next()).isEmpty()){
				return false;
			}
		}
		return true;

	}
	
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		Iterator<String> iter = week.keySet().iterator();
		while(iter.hasNext()){
			String iterDay = iter.next();
			str.append( iterDay.substring(0, 1).toUpperCase() + iterDay.substring(1)+":\n");
			
			str.append(week.get(iterDay).toString()+"\n");
			
		}
		if (str.length() ==0){
			return "No Time Slots Entered :,(\n";
		}
		return str.toString();
		
	}
	
	/**
	 * returns true if there's no entries in the specified day 
	 * of if the day String is not a correct day string
	 * @param day
	 * @return
	 */
	public boolean isDayEmpty(String day){
		
		try {
			return week.get(day.toLowerCase()).isEmpty();
		}
		catch(NullPointerException e){
			return true;
		}
	}
	/*** 
	 * Updates free time slots in a specified day
	 * Returns true if day was an already defined key, false if not
	 * @param day
	 * @param slot
	 * @return boolean 
	 */
	public boolean addSlot(String day, TimeSlot slot){
		DailySlots daily = week.get(day.toLowerCase());
		//System.out.println("addingSlot2: "+daily);
		if (daily == null){
			return false;
		}
		boolean ret = daily.add(slot);
		//System.out.println("adding Slot2: "+daily);
		week.put(day, daily);
		return ret;
	}
	/**
	 * Clears entries from a specified day
	 * @param day
	 */
	public void clearDay(String day){
		DailySlots daily = week.get(day.toLowerCase());
		daily.clear();
		week.put(day, daily);
	}
	/**
	 * Clears all entries in the WeeklySlots 
	 */
	public void clear(){
		week.clear();
	}
	@Override
	public Iterator<String> iterator() {
		
		return week.keySet().iterator();
		
	}
	
	public LinkedHashSet<String> getDefinedDays(){
		LinkedHashSet<String> definedDays = new LinkedHashSet<String>();
		Iterator<String> iter = week.keySet().iterator();
		while(iter.hasNext()){
			String day = iter.next();
			if (week.get(day).getNumberOfSlots() > 0){
				definedDays.add(day);
			}
			
		
		}
		return definedDays;
	}
	
	public TimeSlot[] getWeeklyWorkoutArray(){
		TimeSlot[] slts = new TimeSlot[7];
		String[] days = new String[]{"sunday","monday","tuesday", "wednesday","thursday", "friday", "saturday"};
		for (int i = 0; i < 7; i++){
			slts[i] = getLargestTimeSlot(days[i]);
		}
		
		return slts;
	}

	public TimeSlot getLargestTimeSlot(String day){
		return week.get(day.toLowerCase()).getLargestTimeSlot();
	}
	
}
