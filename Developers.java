package courseWork;

public class Developers extends Person {
	String name = "Developers";
	int minFloor;
	int maxFloor;
	int range;
	
	public Developers(String name, int spaceRequired, Building b) {
		super(name,spaceRequired);
		minFloor = b.getHowManyFloors()-1/2;
		maxFloor = b.getHowManyFloors()-1;
		range = (maxFloor - minFloor) +1;
		choose();
		
	}
	
	public void choose() {
		whatFloor = (int)(Math.random()*range) + minFloor;
	}
}
