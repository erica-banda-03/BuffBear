package gymsense;

public class FoodFinder {
	
	private Restaurant restaurant;
	
	public FoodFinder() {
		
		
		
		
	}
	
	public Restaurant findFood(Location myLoc, Plan myPlan) {
		Restaurant perfect = null;

		setRestaurant(perfect);
		return restaurant;
		
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
