package gymsense;

public class WorkoutFacility extends Building {
	
	private String amenities;
	
	public WorkoutFacility(String name, Location location, String hours, String link){
		
		super(name, location, hours, link);
		
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}
	
	

}
