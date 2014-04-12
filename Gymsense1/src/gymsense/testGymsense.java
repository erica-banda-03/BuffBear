package gymsense;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;
import javax.servlet.ServletException;
//import static org.mockito.Mockito.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class testGymsense {

	static String IntensityLight = "light";
	static String IntensityErr = "";
	String typeCardio = "cardio";
	static String typeWeightLift = "weightlifting";
	static String typeWeightloss = "weight-loss";
	static String typeError = "powerlifting";
	static int duration15 = 15;
	static int duration30 = 30;
	static int duration60 = 60;
	


	@Test
	public void workoutTesting() {
		Workout workoutTest = new Workout(duration15, IntensityLight, typeCardio);
		workoutTest.setUpWorkout();
		workoutTest.getName();
		assertEquals("#lightCardio15Sense", workoutTest.getName());
	}
	
	@Test
	public void workoutTesting2() {
		Workout workoutTest = new Workout(duration30, IntensityLight, typeWeightloss);
		workoutTest.setUpWorkout();
		workoutTest.getName();
		assertEquals("#lightWeightLoss30Sense", workoutTest.getName());
	}

	@Test
	public void workoutTestingError() {
		Workout workoutTest = new Workout(duration30, IntensityErr, typeError);
		workoutTest.setUpWorkout();
		workoutTest.getName();
		assertEquals("Error: Incorrect input parameter", workoutTest.getName());
	}
	
	@Test
	public void testRemoveUser(){
		
	}
	
	@Test
	public void testAddUser(){
		
	}
	

	
}
