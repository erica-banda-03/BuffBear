package gymsense;

import java.io.Serializable;
import java.util.ArrayList;

import gymsense.time.DailySlots;
import gymsense.time.TimeSlot;
import gymsense.time.WeeklySlots;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Embedded;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class User implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Key email;	
	private String firstName;
	private String lastName;
	private String heightFeet;
	private String heightInches;
	private String weight;
	private String birthYear;
	private String birthDay;
	private String birthMonth;
	private String workoutType;
	private String sex;
	private String intensity;
	private String Mwork;
	private String Twork;
	private String Wwork;
	private String Thwork;
	private String Fwork;
	private String Swork;
	private String SSwork;

	
	public User(){}
	
	public User(Key email, String firstName, String lastName, String password, String birthMonth, String birthDay, String birthYear, String sex, String workoutType, String intensity, String weight, String heightFeet, String heightInches){
		this.setEmail(email);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setBirthMonth(birthMonth);
		this.setBirthDay(birthDay);
		this.setBirthYear(birthYear);
		this.setWeight(weight);
		this.setHeightFeet(heightFeet);
		this.setHeightInches(heightInches);
		this.setWeight(weight);
		this.setSex(sex);
		this.setWorkoutType(workoutType);
		this.setIntensity(intensity);
		this.setMwork("No Workout");
		this.setTwork("No Workout");
		this.setWwork("No Workout");
		this.setThwork("No Workout");
		this.setFwork("No Workout");
		this.setSwork("No Workout");
		this.setSSwork("No Workout");
		
	}
	
	public void setEmail(Key address){
		this.email= address;
	}
	
	public Key getEmail(){
		return email;
	}

	public void setFirstName(String firstName){
		this.firstName= firstName;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setLastName(String lastName){
		this.lastName= lastName;
	}
	
	public String getLastName(){
		return lastName;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	/*
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	} */
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getWorkoutType() {
		return workoutType;
	}

	public void setWorkoutType(String workoutType) {
		this.workoutType = workoutType;
	}

	public String getHeightFeet() {
		return heightFeet;
	}

	public void setHeightFeet(String heightFeet) {
		this.heightFeet = heightFeet;
	}

	public String getHeightInches() {
		return heightInches;
	}

	public void setHeightInches(String heightInches) {
		this.heightInches = heightInches;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}


	public String getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

/*	public WeeklySlots getWeekSlots() {
		return this.week;
	}

	public void setWeekSlots(WeeklySlots week) {
		this.week = week;
	}
	
	public Boolean addTimeSlot(String day, TimeSlot slot){
		return week.addSlot(day, slot);
	}
	*/
	public String getIntensity() {
		return intensity;
	}

	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}

	public void setWorkouts(String day, String work){
		if (day.equals("Monday")){
			this.Mwork = work;
		}
		else if (day.equals("Tuesday")){this.Twork = work;}
		else if (day.equals("Wednesday")){this.Wwork = work;}
		else if (day.equals("Thursday")){this.Thwork = work;}
		else if (day.equals("Friday")){this.Fwork = work;}
		else if (day.equals("Saturday")){this.Swork = work;}
		else if (day.equals("Sunday")){this.SSwork = work;}
	}
	public String getAllWorkouts(){
		return Mwork+Twork+Wwork+Thwork+Fwork+Swork+SSwork;
	}
	public String getMwork() {
		return Mwork;
	}

	public void setMwork(String mwork) {
		Mwork = mwork;
	}

	public String getTwork() {
		return Twork;
	}

	public void setTwork(String twork) {
		Twork = twork;
	}

	public String getWwork() {
		return Wwork;
	}

	public void setWwork(String wwork) {
		Wwork = wwork;
	}

	public String getThwork() {
		return Thwork;
	}

	public void setThwork(String thwork) {
		Thwork = thwork;
	}

	public String getFwork() {
		return Fwork;
	}

	public void setFwork(String fwork) {
		Fwork = fwork;
	}

	public String getSwork() {
		return Swork;
	}

	public void setSwork(String swork) {
		Swork = swork;
	}

	public String getSSwork() {
		return SSwork;
	}

	public void setSSwork(String sSwork) {
		SSwork = sSwork;
	}


}
