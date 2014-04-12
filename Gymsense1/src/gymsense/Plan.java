package gymsense;

import java.util.ArrayList;

public class Plan {
	
	private ArrayList<String> workoutTimes;
	private Workout	myWorkout;
	private String foodType;
	
	
	public Plan () {
		
		this.workoutTimes = getWorkoutTimes();
		
		
	}
	
	private ArrayList<String> getWorkoutTimes (){
		
		ArrayList<String> times = new ArrayList<String>();
		
		
		return times;
		
	}
	
	public Workout getWorkout(ArrayList<Workout> workouts, String type) {
		
		//given list of available workouts just find it. 
		Workout myWorkout = null;
		
		
		
		return myWorkout;
	}
	
	public String findFoodType (String type) {
		
		if (type.equalsIgnoreCase("weight loss")) {
		
			return "low carb/ no fast food" ;
		
		}
		
		if (type.equalsIgnoreCase("weight lifter")) {
			
			return "high protein/ low carb";
			
		}
		
		//running or ....
		
		else {
			
			return "high carbs";
			
		}
	
		
	}
	
	

}
