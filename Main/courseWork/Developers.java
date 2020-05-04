package courseWork;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Developers extends Person {
	int minFloor;
	int maxFloor;
	int range;
	ArrivalSimulator s;
	int timer=0;
	
	public Developers(String name, int spaceRequired, Building b,ArrivalSimulator s,Random R) {
		super(name,spaceRequired, b,s,R);
		minFloor = (b.getHowManyFloors()-1)/2;
		maxFloor = b.getHowManyFloors()-1;
		range = (maxFloor - minFloor) +1;
		choose();
		
	}
	@Override
	public void choose() {
		whatFloor = random.nextInt(maxFloor - minFloor +1)+minFloor;
	}
	
	
	public int getSimulationsTime() {  //returns the total time of the simulation
		return timer;
	}
}
