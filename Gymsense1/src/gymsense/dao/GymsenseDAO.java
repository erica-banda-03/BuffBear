package gymsense.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import gymsense.User;
import gymsense.services.PMF;

public enum GymsenseDAO {
		INSTANCE;
		public List<User> getUser() {
			List<User> User;
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query query = pm.newQuery(User.class);
			try{
			User = (List<User>) query.execute();
			}
			finally{
			pm.close();
			}
			return (User);
		}	
		
		public void deleteAll(){
			List<User> User;
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query query = pm.newQuery(User.class);
			try{
				User = (List<User>) query.execute();
				pm.deletePersistentAll(User);
			}
			finally{
				pm.close();
			}
		}
		
		public String add(String firstName, String lastName, String email, String birthMonth, String birthDay, String birthYear, String sex, String workoutType, String intensity, String weight, String heightInches, String heightFeet){
				Key key = KeyFactory.createKey(User.class.getSimpleName(), email);
				User user = new User();
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmail(key);
				//user.setPassword(password);
				user.setBirthMonth(birthMonth);
				user.setBirthDay(birthDay);
				user.setBirthYear(birthYear);
				user.setHeightFeet(heightFeet);
				user.setHeightInches(heightInches);
				user.setSex(sex);
				user.setWeight(weight);
				user.setWorkoutType(workoutType);
				user.setIntensity(intensity);
				
				synchronized(this){
				PersistenceManager pm = PMF.get().getPersistenceManager();
				try{
					pm.makePersistent(user);
				}
				finally{
					pm.close();
				}
				}
				return (user.getEmail().getName());
			}
		
		public void updateWeight(String weight, String address){
				User user;
				synchronized(this){
					PersistenceManager pm = PMF.get().getPersistenceManager();
					Key k = KeyFactory.createKey(User.class.getSimpleName(), address);
					try{
					user = pm.getObjectById(User.class, k);
					user.setWeight(weight);
					}
					finally{
					pm.close();
					}
				}
			}
		
		public void updateWorkoutType(String workoutType, String address){
			User user;
			synchronized(this){
				PersistenceManager pm = PMF.get().getPersistenceManager();
				Key k = KeyFactory.createKey(User.class.getSimpleName(), address);
				try{
				user = pm.getObjectById(User.class, k);
				user.setWorkoutType(workoutType);
				}
				finally{
				pm.close();
				}
			}
		}
		
		public void updateIntensity(String intensity, String address){
			User user;
			synchronized(this){
				PersistenceManager pm = PMF.get().getPersistenceManager();
				Key k = KeyFactory.createKey(User.class.getSimpleName(), address);
				try{
				user = pm.getObjectById(User.class, k);
				user.setIntensity(intensity);
				}
				finally{
				pm.close();
				}
			}
		}
		
		public void updateTime(String time, String address){
			User user;
			synchronized(this){
				PersistenceManager pm = PMF.get().getPersistenceManager();
				Key k = KeyFactory.createKey(User.class.getSimpleName(), address);
				try{
				user = pm.getObjectById(User.class, k);
				user.setTime(time);
				}
				finally{
				pm.close();
				}
			}
		}
		
		//remove a user from the Datastore 
		public void remove(String address){
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Key k = KeyFactory.createKey(User.class.getSimpleName(), address);
			User user;
			try{
				user = pm.getObjectById(User.class, k);
				pm.deletePersistent(user);
			}
			finally{
				pm.close();
			}
		}
		
		public User getuser(String address){
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Key k = KeyFactory.createKey(User.class.getSimpleName(), address);
			User user = null;
			try{
				user = pm.getObjectById(User.class, k);
			}
			finally{
				pm.close();
			}
			return user;
		}
		
}


