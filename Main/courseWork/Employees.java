package courseWork;

public class Employees extends Person {
	String name = "Non Developers";
	int spaceRequired = 1;
	int minFloor = 1;
	int maxFloor;
	int range;
	
	public Employees(String name, int spaceRequired, Building B) {
		super(name,spaceRequired);
		maxFloor = B.getHowManyFloors()-1;
		range = (maxFloor - minFloor) +1;
		choose();
	
	}

	public void choose() {
		whatFloor = (int)(Math.random()*range) + minFloor;
	}
	
}