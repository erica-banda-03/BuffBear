package gymsense;

public class Workout{


	private int duration; // 15 30 or 60 minutes
    private String intensity;	//light heavy
    private String type;	// cardio, weight-loss, weightlifting 
    private String description = " ";
	private static String name = " ";

	// Use this to create objects 

	/*
		Workout workoutTest = new Workout(duration, Intensity, type);
		workoutTest.setUpWorkout();
		System.out.println(workoutTest.getName());
		System.out.println(workoutTest.setUpWorkout());
		
	*/

	public Workout(int timePeriod, String workoutIntensity, String planType) {
	     duration = timePeriod;
	     intensity = workoutIntensity;
	     type = planType;
	}

	/*
	public static void main(String args[]){
	  List<String> workouts =  new ArrayList<String>();
		workouts.add(name);
	}*/

	public String setUpWorkout(){
		switch(intensity){
			case "light": switch(type){
							case "cardio": switch(duration){
												case 15: {	name = "#lightCardio15Sense";
															description = "Run 1 mile in 10 minutes \n"
																		+ "Do 3 sets of 20 crunches within 3 minutes \n"
																		+ "Run 2 sprints within 2 minutes";
															break;
												} 
												case 30: { name = "#lightCardio30Sense";
															description = "Run 2 miles in 20 minutes \n"
																		+ "Do 3 sets of 20 crunches interleaved "
																		+ "with 3 sets of 15 pushups within 10 minutes \n";
															break;
												}
												case 45: { name = "#lightCardio45Sense";
														   description = "Swim"; 
														   break;
												}
												default: { name = "Error: Incorrect input parameter";
														   description = " :) ";
														   break;
												}
											}
											break;

							case "weight-loss": switch(duration){
													case 15: { name = "#lightWeightLoss15Sense";
															   description = "Run 3 sprints within 3 minutes"
															   			   + "Do 3 sets of 15 pushups within 3 minutes"
															   			   + "Run 1 mile within 9 minutes";
															   break;
													}
													case 30: { 	name = "#lightWeightLoss30Sense";
																description = "run";
																break;
													}

													case 45: { 	name = "#lightWeightLoss45Sense";
																description = "run";
																break;
													}
													default: { name = "Error: Incorrect input parameter";
																description = " :) ";
																break;
													}
												}
												break;
							case "weightlifting": switch(duration){
														case 15: { name = "#lightBuildMass15Sense";
																   description = "Run 3 sprints within 3 minutes"
																		   		+ "Do 3 sets of 15 pushups within 3 minutes"
																		   		+ "Run 1 mile within 9 minutes";
																   break;
														}
														case 30: { 	name = "#lightWeightLoss30Sense";
																    description = "run";
																    break;
														}

														case 45: { 	name = "#lightWeightLoss45Sense";
																	description = "run";
																	break;
														}
														default: { name = "Error: Incorrect input parameter";
																	description = " :) ";
																	break;
														}
													}
												break;
							default: { name = "Error: Incorrect input parameter";
									   description = " :) ";
									   break;
							}
						} break;

			case "heavy": switch(type){
							case "cardio": switch(duration){
												case 15: {	name = "#heavyCardio15Sense ";
															description = "Run 1 mile in 10 minutes \n"
																		+ "Do 3 sets of 20 crunches within 3 minutes \n"
																		+ "Run 2 sprints within 2 minutes";
															break;
												} 
												case 30: { name = "#heavyCardio30Sense";
														   description = "Run 2 miles in 20 minutes \n"
																   	   + "Do 3 sets of 20 crunches interleaved "
																   	   + "with 3 sets of 15 pushups within 10 minutes \n";
														   break;
												}
												case 45: { name = "#heavyCardio45Sense";
														   description = "Swim"; 
														   break;
												}
												default: { name = "Error: Incorrect input parameter";
															description = " :) ";
															break;
												}
											}
											break;

							case "weight-loss": switch(duration){
													case 15: { name = "#heavyWeightLoss15Sense";
															   description = "Run 3 sprints within 3 minutes"
																	   		+ "Do 3 sets of 15 pushups within 3 minutes"
																	   		+ "Run 1 mile within 9 minutes";
															   break;
													}
													case 30: { 	name = "#heavyWeightLoss30Sense";
																description = "run";
																break;
													}

													case 45: { 	name = "#heavyWeightLoss45Sense";
													description = "run";
													break;
													}
													default: { name = "Error: Incorrect input parameter";
																description = " :) ";
																break;
													}
												}
												break;

							case "weightlifting": switch(duration){
														case 15: { name = "#heavyBuildMass15Sense";
																   description = "Run 3 sprints within 3 minutes"
																		       + "Do 3 sets of 15 pushups within 3 minutes"
																		       + "Run 1 mile within 9 minutes";
																   break;
														}
														case 30: { 	name = "#heavyWeightLoss30Sense";
																	description = "run";
																	break;
														}

														case 45: { 	name = "#heavyWeightLoss45Sense";
																	description = "run";
																	break;
														}
														default: { name = "Error: Incorrect input parameter";
																	description = " :) ";
																	break;
														}
													}
												break;

							default: { name = "Error: Incorrect input parameter";
										description = " :) ";
										break;
							}						
						} break;

			default: { name = "Error: Incorrect input parameter";
						description = " :) ";
						break;
			}

		}

		return description; 	
	}



	public String getName() {
		return name;
	}

}
/*
	//public void setName(String name) {
		//this.name = name;
	//}

	public static int getLength() {
		return length;
	}

	public static void setLength(int length) {
		this.length = length;
	}


	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}


	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	

}
*/
