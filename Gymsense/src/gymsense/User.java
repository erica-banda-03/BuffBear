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
	private String name;
	private String password;
	private int feetHeight;
	private int inchHeight;
	private int weight;
	private int age;
	private String gender;
	private Schedule mySchedule;
	private Plan myPlan;
	private Location myLocation;
	
	
	public User(){}
	
	public User(Key address, String person){
		this.email= address;
		this.name = person;
	}
	
	public void setEmail(Key address){
		this.email= address;
	}

	public void setName(String subscriber){
		name= subscriber ;
	}
	
	public String getUserName(){
		return name;
	}
	
	public Key getEmail(){
		return email;
	}
	
	public User(String name, String email, String password, int feetHeight, int inchHeight, String weight, String gender, Schedule mySchedule, Plan myPlan, Location myLocation){
		 
		// update all these using the values obtained from servelet and jsp
 }

	
}
