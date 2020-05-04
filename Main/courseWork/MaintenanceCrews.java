package courseWork;

import java.util.Random;

public class MaintenanceCrews extends Person{
	int currentFloor=0;
	ArrivalSimulator s;
	Floor f;
	int mintime = 120;
	int maxtime= 240;
	int range = (maxtime - mintime) + mintime;
	int howLong;
	
	public MaintenanceCrews(String name, int spaceRequired, Building b,ArrivalSimulator S,Random R) {
		super(name,spaceRequired, b,S,R);
		this.spaceRequired=spaceRequired;
		whatFloor = building.getHowManyFloors()-1;
		howLong = random.nextInt(maxtime - mintime +1)+mintime;
	}
	
	
	@Override
	public void tick() { //this logic is currently not working
		if ((building.getSimulation().tick - arriveTick) > howLong ) {
			whatFloor = 0;
			wantToMove = true;
			done = true;
		}
		
	}
	
}