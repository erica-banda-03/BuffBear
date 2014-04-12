package gymsense;

public class Driver {
	
	static String Intensity1 = "light";
	static String type1 = "cardio";
	static int duration1 = 15;
	
	public static void main(String[] args){
		Workout workoutTest = new Workout(duration1, Intensity1, type1);
		workoutTest.setUpWorkout();
		workoutTest.getName();
	}

}
