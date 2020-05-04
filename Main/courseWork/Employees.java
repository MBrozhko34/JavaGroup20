package courseWork;

import java.util.Random;

public class Employees extends Person {
	String name = "Non Developers";
	int spaceRequired = 1;
	int minFloor = 1;
	int maxFloor;
	int range;
	int timer=0;
	
	public Employees(String name, int spaceRequired, Building b, ArrivalSimulator s,Random R) {
		super(name,spaceRequired, b,s,R);
		maxFloor = b.getHowManyFloors()-1;
		range = (maxFloor - minFloor) +1;
		choose();
	}

	@Override
	public void choose() {
		whatFloor = (int)(Math.random()*range) + minFloor;
	}
	
	
	public int getSimulationTime() { //returns the total time of the simulation
		return timer;
	}
}