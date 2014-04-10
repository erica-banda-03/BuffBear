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

	public boolean checkDayEmpty(String day){
		return week.isDayEmpty(day);
	}
	

}
