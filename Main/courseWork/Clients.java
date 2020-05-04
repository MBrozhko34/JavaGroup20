package courseWork;

import java.util.Random;

public class Clients extends Person {
	String name = "Clients";
	int minFloor;
	int maxFloor;
	ArrivalSimulator s;
	int timer = 0;
	int mintime = 60;
	int maxtime= 180;
	int range = (maxtime - mintime) + mintime;
	int howLong;
	
	public Clients(String name, int spaceRequired, Building b,ArrivalSimulator S, Random R) {
		super(name,spaceRequired, b,S,R);
		minFloor = 1;
		maxFloor = ((b.getHowManyFloors()-1)/2);
		range = (maxFloor - minFloor) +1;
		howLong = random.nextInt(maxtime - mintime +1)+mintime;
		choose();
		
	}

	public void choose() {
		//need to fix the logic in here
		whatFloor = random.nextInt(maxFloor - minFloor +1)+minFloor;
	}
	
	
	public int getSimulationTime() { //returns the total time of the simulation
		return timer;
	}
	
	@Override
	public void tick() {
		if ((building.getSimulation().tick - arriveTick) > howLong ) {
			whatFloor = 0;
			wantToMove = true;
			done = true;
		}
	}
	
}