package courseWork;

import java.util.Random;

public class MaintenanceCrews extends Person{
	int currentFloor=0;
	ArrivalSimulator s;
	Floor f;
	int timer=0; //10 seconds = 1 tick
	int mintime = 120;
	int maxtime= 240;
	int range = (maxtime - mintime) + mintime;
	int howLong = (int)(Math.random()*range) + mintime;
	boolean done = false;
	
	public MaintenanceCrews(String name, int spaceRequired, Building b,ArrivalSimulator S,Random R) {
		super(name,spaceRequired, b,S,R);
		this.spaceRequired=spaceRequired;
		whatFloor = building.getHowManyFloors()-1;
	}
	
	
	public int getSimulationTime() {  //returns the total time of the simulation
		return timer;
	}
	
	@Override
	public void tick() { //this logic is currently not working
		if ((building.getSimulation().tick - arriveTick) > howLong ) {
			whatFloor = 0;
			wantToMove = true;
		}
		
	}
	
}