package gymsense;

import java.util.*;
import java.lang.*;

public class Workout{
	
	
	private int duration; // 30 60 or 120 minutes
    private String intensity;	//light heavy
    private String type;	// cardio, weight-loss, weightlifting 
    private String description = " ";
	private static String name = " ";
	
	
	
	public Workout(int timePeriod, String workoutIntensity, String planType) {
		
	     duration = timePeriod;
	     intensity = workoutIntensity.toLowerCase();
	     type = planType.toLowerCase();
	     setUpExercise();
	     getName();
	}
	
	public String setUpExercise(){
		switch(intensity){
			case "light": switch(type){
							case "cardio": switch(duration){
												case 30: {	name = "#lightCardio30Sense \n";
															description = "Run 1 mile in 10 minutes. \n"
																		+ "Do 3 sets of 20 crunches within 5 minutes. \n"
																		+ "Do 3 sets of 15 pushups within 5 minutes. \n"
																		+ "Jog for 10 minutes. \n";
															break;
												} 
												case 60: { name = "#lightCardio60Sense \n";
															description = "Run 2 miles in 20 minutes. \n"
																		+ "Do 3 sets of 20 crunches alternated with \n"
																		+ "3 sets of 15 pushups within 10 minutes \n"
																		+ "Swim at Gregory's gym for 20-30 minutes. \n";
															break;
												}
												case 120: { name = "#lightCardio120Sense \n";
														   description = "Run 2 miles in 20 minutes. \n"
														   			+ "Sprint half a mile in 4 minutes. \n"
														   			+ "Do 3 sets of 10 pullups alternated with \n"
														   			+ "3 sets of crunches within 6 minutes. \n"
														   			+ "Bike for 30 minutes and 10 minutes break after. \n"
														   			+ "Swim for 50 minutes \n"; 
														   break;
												}
												default: { name = "Error: Incorrect input parameter";
														   description = " - ";
														   break;
												}
											}
											break;
							
							case "weight-loss": switch(duration){
													case 30: { name = "#lightWeightLoss30Sense \n";
															   description = "Run 6 sprints within 10 minutes. \n"
															   			   + "Do 3 sets of 20 crunches within 5 minutes. \n"
															   			   + "Do 3 sets of 15 pushups within 5 minutes. \n"
															   			   + "Jog for 10 minutes. \n";
															   break;
													}
													case 60: { 	name = "#lightWeightLoss60Sense \n";
																description = "Run 10 sprints within 15 minutes. \n"
															   			   + "Do 3 sets of 20 crunches within 5 minutes. \n"
															   			   + "Do 3 sets of 15 pushups within 5 minutes. \n"
															   			   + "Jog for 5 minutes. \n"
															   			   + "Swim for 30 minutes. \n";
																break;
													}
														
													case 120: { 	name = "#lightWeightLoss120Sense \n";
																	description = "Run 10 sprints within 15 minutes. \n"
															   			   + "Do 3 sets of 20 crunches within 5 minutes. \n"
															   			   + "Do 3 sets of 15 pushups within 5 minutes. \n"
															   			   + "Jog for 5 minutes. \n"
															   			   + "Swim for 50 minutes. \n"
															   			   + "Bike for 20 minutes. \n";
																break;
													}
													default: { name = "Error: Incorrect input parameter";
																description = " - ";
																break;
													}
												}
												break;
												
							case "weightlifting": switch(duration){
														case 30: { name = "#lightWeightLifting30Sense \n";
																   description = "Run half a mile in 5 minutes to warm up. \n"
																		   		+ "Do 3 sets of Bench Press in 5 minutes. \n"
																		   		+ "Do 3 sets of Chest Fly with barbells in 5 minutes. \n"
																		   		+ "Do 3 sets using the pulldown machine in 5 minutes. \n "
																		   		+ "Do 3 sets of shoulder press using machine or barbells in 5 minutes. \n"
																		   		+ "Do 3 sets of squats using the bar with weights in 5 minutes. \n";
																   break;
														}
														case 60: { 	name = "#lightWeightLifting60Sense \n";
																    description = "Run half one mile in 10 minutes to warm up \n"
																	   		+ "Do 3 sets of Bench Press in 5 minutes. \n"
																	   		+ "Do 3 sets of Chest Fly with barbells in 5 minutes. \n"
																	   		+ "Do 3 sets using the pulldown machine in 5 minutes \n "
																	   		+ "Do 3 sets of shoulder press using machine or barbells in 5 minutes. \n"
																	   		+ "Do 3 sets of squats using the bar with weights in 5 minutes. \n"
																	   		+ "Do 3 sets of Curls using barbells in 5 minutes. \n"
																	   		+ "Do 3 sets of Barbell Curl using the curl bench in 5 minutes. \n"
																	   		+ "Do 5 sets of Deadlifts with the bar within 15 minutes.";
																    break;
														}
						
														case 120: { name = "#lightWeightLifting120Sense \n";
																	description = "Do the 300 Spartans' Workout presented on this website \n"
																			+ "http://www.muscleandstrength.com/workouts/300-rise-new-you-workout-muscular-ripped \n";
																	break;
														}
														default: { name = "Error: Incorrect input parameter";
																	description = " - ";
																	break;
														}
													}
												break;
							default: { name = "Error: Incorrect input parameter";
									   description = " - ";
									   break;
							}
						} break;
				
			case "heavy": switch(type){
							case "cardio": switch(duration){
												case 30: {	name = "#heavyCardio30Sense \n";
															description = "Run 1 mile in 8 minutes. \n"
																		+ "Do 3 sets of 20 crunches alternated with \n"
																		+ "3 sets of 10 pullups within 7 minutes \n"
																		+ "Run 5 sprints within 5 minutes. \n"
																		+ "Jog for 10 minutes. \n";
															break;
												} 
												
												case 60: { name = "#heavyCardio60Sense \n";
														   description = "Run 2 miles in 18 minutes. \n"
																   	   + "Do 3 sets of 20 crunches alternated \n"
																   	   + "with 3 sets of 15 pushups within 7 minutes \n"
																   	   + "Bike for 35 minutes. \n";
														   break;
												}
												
												case 120: { name = "#heavyCardio120Sense \n";
												   description = "Run 2 miles in 20 minutes. \n"
												   			+ "Sprint half a mile in 4 minutes. \n"
												   			+ "Do 3 sets of 10 pullups alternated with \n"
												   			+ "3 sets of crunches within 6 minutes. \n"
												   			+ "Bike for 30 minutes and 10 minutes break after. \n"
												   			+ "Swim for 50 minutes. \n"; 
														   break;
												}
												
												default: { name = "Error: Incorrect input parameter";
															description = " - ";
															break;
												}
											}
											break;
											
							case "weight-loss": switch(duration){
													case 30: { name = "#heavyWeightLoss30Sense \n";
															   description = "Run 3 sprints within 3 minutes. \n"
																	   		+ "Do 3 sets of 15 pushups within 3 minutes. \n"
																	   		+ "Run 1 mile within 9 minutes. \n"
																	   		+ "Do 3 sets of crunches alternated with \n "
																	   		+ "3 sets of pullups within 10 minutes. \n"
																	   		+ "Run 10-15 sprints within 15 minutes. \n";
															   break;
													}
													case 60: { 	name = "#heavyWeightLoss60Sense";
																description = "Run 5 sprints within 5 minutes. \n"
																   		+ "Do 4 sets of 15 pushups within 4 minutes. \n"
																   		+ "Run 1 mile within 10 minutes. \n"
																   		+ "Do 3 sets of crunches alternated with \n "
																   		+ "3 sets of pullups within 10 minutes. \n"
																   		+ "Run 2 miles within 16 minutes. \n"
																   		+ "Bike for 15 minutes. \n";
																break;
													}
					
													case 120: { 	name = "#heavyWeightLoss120Sense";
																description = "Run 10 sprints within 10 minutes \n"
																		+ "Do 4 sets of 15 pushups within 4 minutes. \n"
																		+ "Run 1 mile within 10 minutes. \n"
																		+ "Do 3 sets of crunches alternated with \n "
																		+ "3 sets of pullups within 10 minutes. \n"
																		+ "Run 2 miles within 16 minutes. \n"
																		+ "Bike for 40 minutes. \n"
																		+ "Swim for 30 minutes. \n ";
													break;
													}
													default: { name = "Error: Incorrect input parameter";
																description = " - ";
																break;
													}
												}
												break;
												
							case "weightlifting": switch(duration){
														case 30: { name = "#heavyWeightLifting30Sense";
																   description = "Run half a mile in 5 minutes to warm up. \n"
																	   		+ "Do 3 sets of Bench Press in 5 minutes. \n"
																	   		+ "Do 3 sets of 15 PushUps in 5 minutes. \n"
																	   		+ "Do 3 sets of Chest Fly with barbells in 5 minutes. \n"
																	   		+ "Do 3 sets using the pulldown machine in 5 minutes. \n"
																	   		+ "Do 3 sets using the rowing machine in 5 minutes. \n";
																	   	
																   break;
														}
														case 60: { 	name = "#heavyWeightLifting60Sense";
																    description = "Run half a mile in 5 minutes to warm up. \n"
																	   		+ "Do 3 sets of Bench Press in 5 minutes. \n"
																	   		+ "Do 3 sets of 15 PushUps in 5 minutes. \n"
																	   		+ "Do 3 sets of Chest Fly with barbells in 5 minutes. \n"
																	   		+ "Do 3 sets using the pulldown machine in 5 minutes. \n"
																	   		+ "Do 3 sets using the rowing machine in 5 minutes. \n"
																	   		+ "Do 3 sets of shoulder press using machine or barbells in 5 minutes. \n"
																	   		+ "Do 3 sets of squats using the bar with weights in 5 minutes. \n"
																	   		+ "Do 3 sets of abs at the incline bench within 5 minutes. \n"
																	   		+ "Do 3 sets using the abdominal rotator machine within 5 minutes. \n"
																	   		+ "Do 3 sets of tricpes exercise using the rope pulley within 5 minutes. "
																	   		+ "Do 3 sets of ice cream eating within 5 minutes. \n";
																	break;
														}

														case 120: { 	name = "#heavy300SpartansSense";
																		description = "Do the 300 Spartans' Workout presented on this website \n"
																			+ "http://www.muscleandstrength.com/workouts/300-rise-new-you-workout-muscular-ripped \n";
																	break;
														}
														default: { name = "Error: Incorrect input parameter";
																	description = " - ";
																	break;
														}
													}
												break;
												
							default: { name = "Error: Incorrect input parameter";
										description = " - ";
										break;
							}						
						} break;
			
			default: { name = "Error: Incorrect input parameter";
						description = " - ";
						break;
			}

		}
		
		
		return description; 	
	}
	
	public String getDescription(){
		return description;
	}


	public String getName() {
		return name;
	}
	
}

