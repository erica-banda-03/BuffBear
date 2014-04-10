package gymsense.time;


public class mover {

	public static void main(String[] args) {
		TimeSlot slot = new TimeSlot(9, 0, "PM", 10, 34, "PM");
		TimeSlot slot2 = new TimeSlot(12, 0, "PM", 5, 34, "PM");
		TimeSlot slot3 = new TimeSlot(8, 45, "AM", 10, 0, "AM");
		System.out.println(slot.getStartHour()+" "+slot.getEndHour());
		System.out.println(slot2.getStartHour()+" "+slot2.getEndHour());
		System.out.println(slot3.getStartHour()+" "+slot3.getEndHour());
		
		DailySlots ds = new DailySlots();
		System.out.println("Slot Addition:\n"+ds.add(slot));
		System.out.println(ds.add(slot2));
		System.out.println(ds.add(slot3));
		System.out.println(ds.toString());
		WeeklySlots ws = new WeeklySlots();
		System.out.println(ws.addSlot("monday", slot));
		System.out.println(ws.addSlot("monday", slot2));
		System.out.println(ws.addSlot("monday", slot3));
		//ds.add(slot);
		System.out.println(ws.toString());
		System.out.println(ws.getTotalSlotNumber());
		//System.out.println(slot.toString());
		//System.out.println(slot2.durationToString());
		//System.out.println(ds);
	}

}
