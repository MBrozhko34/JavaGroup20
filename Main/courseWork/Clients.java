package courseWork;

import java.util.Random;

public class Clients extends Person {
	String name = "Clients";
	int minFloor;
	int maxFloor;
	int range;
	ArrivalSimulator s;
	int timer = 0;
	
	public Clients(String name, int spaceRequired, Building b,ArrivalSimulator S, Random R) {
		super(name,spaceRequired, b,S,R);
		minFloor = 1;
		maxFloor = b.getHowManyFloors()-1/2;
		range = (maxFloor - minFloor) +1;
		choose();
		
	}

	public void choose() {
		//need to fix the logic in here
		whatFloor = 2; //random.nextInt(maxFloor - minFloor +1)+minFloor;
	}
	
	
	public int getSimulationTime() { //returns the total time of the simulation
		return timer;
	}
	
}