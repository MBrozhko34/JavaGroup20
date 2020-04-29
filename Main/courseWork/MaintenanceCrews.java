package courseWork;

import java.util.Random;

public class MaintenanceCrews extends Person{
	String name = "Maintenance Crews";
	int spaceRequired = 4;
	int currentFloor=0;
	ArrivalSimulator s;
	Floor f;
	int whatFloor=7;
	int timer=0; //10 seconds = 1 tick
	
	public MaintenanceCrews(String name, int spaceRequired, Building b) {
		super(name,spaceRequired, b);
		this.spaceRequired=spaceRequired;
	}
	
	public void tick(Floor f, Person p) {
		timer=timer+10; //represents one tick and 10 seconds
		f.setFloornumber(whatFloor);
		if(timer == p.generateTime(20, 40)) {
			f.addToQ(p);
		}
	}
	
	public int getSimulationTime() {
		return timer;
	}
	
	public void arriveOnGroundFloor(Floor f, Person p){
		Random rd = new Random();
		if(0.005>rd.nextDouble()) {
			f.addToQ(p);
		}
	}
}