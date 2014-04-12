package gymsense;

public class Restaurant extends Building {
	
	private String classification;
	
	public Restaurant(String name, Location location, String hours, String link, String classification) {
		super(name, location, hours, link);
		setClassification(classification);
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	

}
