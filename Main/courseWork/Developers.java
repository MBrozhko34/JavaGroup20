package courseWork;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Developers extends Person {
	int minFloor;
	int maxFloor;
	int range;
	
	public Developers(String name, int spaceRequired, Building b) {
		super(name,spaceRequired, b);
		minFloor = (b.getHowManyFloors()-1)/2;
		maxFloor = b.getHowManyFloors()-1;
		range = (maxFloor - minFloor) +1;
		choose();
		
	}
	
	public void choose() {
		Random r = new Random();
		whatFloor = r.nextInt(maxFloor - minFloor +1)+minFloor;
	}
}
