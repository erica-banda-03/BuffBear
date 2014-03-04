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
	//private String address;
	private String name;
	
	
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
	
}
