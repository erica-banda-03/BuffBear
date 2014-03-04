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
		
		public String add(String name, String address){
				Key key = KeyFactory.createKey(User.class.getSimpleName(), address);
				User subscriber = new User();
				subscriber.setName(name);
				subscriber.setEmail(key);
				
				synchronized(this){
				PersistenceManager pm = PMF.get().getPersistenceManager();
				try{
					pm.makePersistent(subscriber);
				}
				finally{
					pm.close();
				}
				}
				return (subscriber.getEmail().getName());
			}
		
		public void update(String userName, String address){
				User result;
				synchronized(this){
					PersistenceManager pm = PMF.get().getPersistenceManager();
					Key k = KeyFactory.createKey(User.class.getSimpleName(), address);
					try{
					result = pm.getObjectById(User.class, k);
					result.setName(userName);
					}
					finally{
					pm.close();
					}
				}
			}
		
		public void remove(String address){
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Key k = KeyFactory.createKey(User.class.getSimpleName(), address);
			User subscriber;
			try{
				subscriber = pm.getObjectById(User.class, k);
				pm.deletePersistent(subscriber);
			}
			finally{
				pm.close();
			}
		}
		
		public User getSubscriber(String address){
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Key k = KeyFactory.createKey(User.class.getSimpleName(), address);
			User subscriber = null;
			try{
				subscriber = pm.getObjectById(User.class, k);
			}
			finally{
				pm.close();
			}
			return subscriber;
		}
		
}


