package gymsense.time;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class WeeklySlotsTest {
	WeeklySlots week;
	
	@Test
	public void testEmptyNewObject() {
		week = new WeeklySlots();
		assertTrue(week.isEmpty());
		
		Iterator<String> iter;
		for(iter = week.iterator(); iter.hasNext();){
			assertTrue(checkDayEmpty(iter.next()));
		}
		
	}
	@Test
	public void testClear() {
		week = new WeeklySlots();
		week.clear();
		assertTrue(week.isEmpty());	
	}
	
	@Test
	public void testIllegalAdditions(){
		week = new WeeklySlots();
		//No such thing as hour Zero
		assertFalse(week.addSlot("monday", new TimeSlot(0, 45, "AM", 2, 0,"PM")));
		//Can't have times that cross days
		assertFalse(week.addSlot("tuesday", new TimeSlot(9, 00, "PM", 2, 0, "AM")));
		//negative values 
		assertFalse(week.addSlot("wednesday", new TimeSlot(-2, -2, "AM", 4, 0, "AM")));
		//Negative Hr
		assertFalse(week.addSlot("wednesday", new TimeSlot(2, 2, "AM", -4, 0, "AM")));
		//Negative Minutes
		assertFalse(week.addSlot("wednesday", new TimeSlot(2, 2, "AM", 4, -1, "AM")));
		//Same start time and end time
		assertFalse(week.addSlot("wednesday", new TimeSlot(2, 2, "AM", 2, 2, "AM")));
		//Duration less than 15 mins
		assertFalse(week.addSlot("wednesday", new TimeSlot(2, 2, "AM", 2, 16, "AM")));	
	}
	
	@Test
	public void testCornerCases(){
		//noon to midnight
		week = new WeeklySlots();
		assertTrue(week.addSlot("thursday", new TimeSlot(12, 0, "PM", 12, 0, "AM")));
		//15 mins min size interval 
		TimeSlot t = new TimeSlot(11, 0, "AM", 11, 15, "AM");
		System.out.println(t.durationToString());
		assertTrue(week.addSlot("friday", new TimeSlot(11, 0, "AM", 11, 15, "AM")));		
	}
	
	@Test
	public void testOverLappingSlots(){
		week = new WeeklySlots();
		assertTrue(week.addSlot("monday", new TimeSlot(9, 0, "AM", 11, 0, "AM")));
		assertFalse(week.addSlot("monday", new TimeSlot(10, 0, "AM", 12, 0, "PM")));
	}
	
	public boolean checkDayEmpty(String day){
		return week.isDayEmpty(day);
	}
	

}
