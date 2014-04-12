package gymsense;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class User implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Key email;	
	private String firstName;
	private String lastName;
	private String password;
	private String heightFeet;
	private String heightInches;
	private String weight;
	//private int birthYear;
	private String birthYear;
	private String birthDay;
	private String birthMonth;
	private String workoutType;
	private String sex;
	private String intensity;
	
	private String time;
	
	private Schedule schedule;
	private Plan plan;
	private Location location;
	
	
	public User(){}
	
	public User(Key email, String firstName, String lastName, String password, String birthMonth, String birthDay, String birthYear, String sex, String workoutType, String intensity, String weight, String heightFeet, String heightInches){
		this.setEmail(email);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		//this.setPassword(password);
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
		this.setSchedule(null);
		this.setPlan(null);
		this.location = null;
		this.time = null;
	}
	
	public void setTime(String time){
		this.time = time;
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
		//this.heightFeet = Integer.parseInt(heightFeet);
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
		//this.birthYear = Integer.parseInt(birthYear);
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

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public String getIntensity() {
		return intensity;
	}

	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}
	
}
