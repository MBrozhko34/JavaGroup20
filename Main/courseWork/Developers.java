package courseWork;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Developers extends Person {
	int minFloor;
	int maxFloor;
	int range;
	ArrivalSimulator s;
	int timer=0;
	
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
	
	public void tick(Floor f, Person p) { //takes a destination floor and a person as a a parameter
		timer=timer+10;  //increments timer by 10 seconds or 1 tick
		f.setFloornumber(whatFloor);
		Random rd = new Random();
		if(s.getPProbability()>rd.nextDouble()) {
			f.addToQ(p);
		}
	}
	
	public int getSimulationsTime() {  //returns the total time of the simulation
		return timer;
	}
}
