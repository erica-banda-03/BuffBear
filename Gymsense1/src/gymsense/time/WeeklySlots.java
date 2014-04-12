package gymsense.time;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeMap;


public class WeeklySlots implements Iterable<String>{
	//HashMap<String, DailySlots> week;
	LinkedHashMap<String, DailySlots> week;
	public WeeklySlots(){
		week = new LinkedHashMap<String, DailySlots>();
		week.put("monday", new DailySlots());
		week.put("tuesday", new DailySlots());
		week.put("wednesday", new DailySlots());
		week.put("thursday", new DailySlots());
		week.put("friday", new DailySlots());
		week.put("saturday", new DailySlots());
		week.put("sunday", new DailySlots());
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
	
}
