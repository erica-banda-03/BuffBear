package gymsense;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.google.appengine.api.users.User;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class Post implements Comparable<Post>{
	
	@Id Long id;
    User user;
    String content;
    String title;
    Date date;
    Boolean sent;
    TimeZone zone;
    
    private Post() {}
    
    public Post(User user, String content, String title) {
        this.user = user;
        this.content = content;
        this.title = title;
        TimeZone.setDefault(TimeZone.getDefault());
      // date = Calendar.getInstance(zone).getTime();
        date= new Date();
        this.sent= false;
    }
    
    public User getUser() {
        return user;
    }
    
    public String getTitle(){
    	return title;
    }
    
    public String getContent() {
        return content;
    }
    
    public Date getDate(){
    	return date;
    }
    
    public Boolean getSent(){
    	return sent;
    }
    
    public void setUser(User theUser){
    	user= theUser;
    }
    
    public void setContent(String stuff){
    	content= stuff;
    }
    
    public void setSent(Boolean status){
    	sent= status;
    }
    
    @Override
    public int compareTo(Post other) {
        if (date.after(other.date)) {
            return 1;
        } else if (date.before(other.date)) {
            return -1;
        }
        return 0;
    }
    
    
}