package gymsense;

public class Building {
	
	private String name;
	private Location location;
	private String hours;
	private String link;
	
	public Building(String name, Location location, String hours, String link) {
		
		setLocation(location);
		setHours(hours);
		setLink(link);

	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	
}
