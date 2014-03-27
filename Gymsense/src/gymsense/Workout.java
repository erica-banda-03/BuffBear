package gymsense;

public class Workout {
	
	private String name;
	private int length;
	private String intensity;
	private String type;
	private String description;
	
	public Workout(String name, int length, String intensity, String type, String description) {
	
		setName(name);
		setLength(length);
		setIntensity(intensity);
		setType(type);
		setDescription(description);
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getIntensity() {
		return intensity;
	}

	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	

}
