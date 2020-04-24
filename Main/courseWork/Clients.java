package courseWork;

public class Clients extends Person {
	
	String name = "Clients";
	int minFloor;
	int maxFloor;
	int range;
	
	public Clients(String name, int spaceRequired, Building b) {
		super(name,spaceRequired);
		minFloor = 1;
		maxFloor = b.getHowManyFloors()-1/2;
		range = (maxFloor - minFloor) +1;
		choose();

	}

	public void choose() {
		whatFloor = (int)(Math.random()*range) + minFloor;
	}
	
}