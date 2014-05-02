/*
 * Copyright (c) 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.api.services.samples.calendar.appengine;
import static com.googlecode.objectify.ObjectifyService.ofy;
import gymsense.TimeSlotfiller;
import gymsense.Dao.GymsenseDAO;
import gymsense.time.DailySlots;
import gymsense.time.TimeSlot;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.appengine.auth.oauth2.AbstractAppEngineAuthorizationCodeServlet;
import com.google.api.client.util.DateTime;
//import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;

/**
 * Entry servlet for the Calendar API App Engine Sample.
 * Demonstrates how to make an authenticated API call using OAuth 2 helper classes.
 */
public class CalendarSampleServlet
    extends AbstractAppEngineAuthorizationCodeServlet {

  /**
   * Be sure to specify the name of your application. If the application name is {@code null} or
   * blank, the application will log a warning. Suggested format is "MyCompany-ProductName/1.0".
   */
  private static final String APPLICATION_NAME = "gym-sense";

  private static final long serialVersionUID = 1L;

  public java.util.Calendar c;
  public com.google.api.services.calendar.Calendar gc;
  
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    // Get the stored credentials using the Authorization Flow
    AuthorizationCodeFlow authFlow = initializeFlow();
    Credential credential = authFlow.loadCredential(getUserId(req));
    
    String user = req.getParameter("userEmail");
	String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	
  //obtaining current user and retrieving instance from datastore
    gymsense.User person = GymsenseDAO.INSTANCE.getuser(user);
	String intensity = person.getIntensity();
	String workoutType = person.getWorkoutType();
	String weekday = "";
	int time = 0;
	int hour = 0;
	int min = 0;
	
	for (int x=0; x < 7; x++){
		DailySlots day = ofy().load().type(DailySlots.class).id(user+weekdays[x]).get();
		TimeSlot slot = day.getLargestTimeSlot();
		
		if(slot != null){
			TimeSlotfiller tsf = new TimeSlotfiller(slot, weekdays[x], workoutType, intensity);
			time = tsf.getTotalWorkoutTime();
			weekday = weekdays[x]; 
			hour = slot.getStartHour(); 
			min = slot.getStartMinutes();
			
			//adding google reminders
			  // Build the Calendar object using the credentials
		    gc = new com.google.api.services.calendar.Calendar.Builder(
		        Utils.HTTP_TRANSPORT, Utils.JSON_FACTORY, credential)
		        .setApplicationName(APPLICATION_NAME)
		        .build();
		     
		    //call TimeSlot and WorkOut functions to get all the info needed.  
		    c = Calendar.getInstance();
		   // c.setTimeZone(TimeZone.getTimeZone("GMT-5:00"));
		    int currentDayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		    int workoutDay = convertDay(weekday);
		    int date = c.get(Calendar.DATE);
		    int year = c.get(Calendar.YEAR);
		    int month = c.get(Calendar.MONTH);
		    int thisDay = getDay(currentDayOfWeek, date, workoutDay);
		    int start_hour = hour;
		    int toAdd = time*60000;
		    int minutes = min;
		    
		    //setting up the workout time using Google Calendar and Java Calendar API
		    Event myEvent = new Event();
		    
		    //year, month, day, start_hour, minutes, secs
		    c.set(year, month, thisDay, start_hour, minutes, 0);
		    c.setTimeZone(TimeZone.getTimeZone("GMT-5:00"));
		    Date startDate = c.getTime();
		    myEvent.setSummary("Gymsense Workout");
		    myEvent.setColorId("5");
		    Date endDate = new Date(startDate.getTime() + toAdd);
		    DateTime start = new DateTime(startDate);
		    myEvent.setStart(new EventDateTime().setDateTime(start).setTimeZone("America/Los_Angeles"));
		    DateTime end = new DateTime(endDate);
		    myEvent.setEnd(new EventDateTime().setDateTime(end).setTimeZone("America/Los_Angeles"));
		   
		    myEvent.setRecurrence(Arrays.asList("RRULE:FREQ=WEEKLY;UNTIL=20141225T155000Z"));
		    gc.events().insert("primary", myEvent).execute();
			
			
			GymsenseDAO.INSTANCE.updateWorkouts(weekdays[x], tsf.getName(),tsf.createWorkout(), user);
				
			}
			//person.setWorkouts(x, tsf.getName()+tsf.createWorkout()+tsf.getTotalWorkoutTime());
		}
      
    // Send the results as the response
    resp.setStatus(200);
    resp.setContentType("text/html");
    
    //redirect to home sign-in page
    resp.sendRedirect("/signIn.jsp");
  }
  
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}

  @Override
  protected AuthorizationCodeFlow initializeFlow() throws ServletException, IOException {
    return Utils.initializeFlow();
  }

  @Override
  protected String getRedirectUri(HttpServletRequest req) throws ServletException, IOException {
    return Utils.getRedirectUri(req);
  }
  
  public int getDay(int currentDay, int date, int workoutDay){
	  int day = 0;
	  
	  if (currentDay == workoutDay) {  
		  day = date; 
	  }
	 
	  // example values:  cd = 3(tuesday) wd = 1(sunday)
	  //4 thu 5 fri 6 sat 7 sun
	  if (currentDay > workoutDay) {
		  date = date - (currentDay - workoutDay);
		  date += 7;

	  }  else { // cd == 4(thurs) and wd == 6(sat)
		  date += (workoutDay - currentDay);
	  }
	  return day;
  }
 
  
  public int convertDay(String day) {
	  int workDay = 0;
	
	  if(day.equalsIgnoreCase("Sunday")) {
		  workDay = 1;
	  }
	  if(day.equalsIgnoreCase("Monday")) {
		  workDay = 2;
	  }
	  if(day.equalsIgnoreCase("Tuesday")) {
		  workDay = 3;
	  }
	  if(day.equalsIgnoreCase("Wednesday")) {
		  workDay = 4;
	  }	  if(day.equalsIgnoreCase("Thursday")) {
		  workDay = 5;
	  }
	  if(day.equalsIgnoreCase("Friday")) {
		  workDay = 6;
	  }	  if(day.equalsIgnoreCase("Saturday")) {
		  workDay = 7;
	  }
	  
	  return workDay;
  }
}

