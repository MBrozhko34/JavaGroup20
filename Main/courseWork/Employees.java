package courseWork;

import java.util.Random;

public class Employees extends Person {
	String name = "Non Developers";
	int spaceRequired = 1;
	int minFloor = 1;
	int maxFloor;
	int range;
	int timer=0;
	
	public Employees(String name, int spaceRequired, Building b, ArrivalSimulator s) {
		super(name,spaceRequired, b,s);
		maxFloor = b.getHowManyFloors()-1;
		range = (maxFloor - minFloor) +1;
		choose();
	}

	public void choose() {
		whatFloor = (int)(Math.random()*range) + minFloor;
	}
	
	@Override
	public void tick() { //takes a destination floor and a person as a a parameter
		timer=timer+10; //increments timer by 10 seconds or 1 tick
		//f.setFloornumber(whatFloor);
		if (s.getPProbability()) {
			wantToMove = true;
			choose();
		}
	}
	
	public int getSimulationTime() { //returns the total time of the simulation
		return timer;
	}
}