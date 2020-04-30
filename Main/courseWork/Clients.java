package courseWork;

import java.util.Random;

public class Clients extends Person {
	String name = "Clients";
	int minFloor;
	int maxFloor;
	int range;
	ArrivalSimulator s;
	int timer = 0;
	
	public Clients(String name, int spaceRequired, Building b) {
		super(name,spaceRequired, b);
		minFloor = 1;
		maxFloor = b.getHowManyFloors()-1/2;
		range = (maxFloor - minFloor) +1;
		choose();
		
	}

	public void choose() {
		whatFloor = (int)(Math.random()*range) + minFloor;
	}
	
	public void tick(Floor f, Person p) { //takes a destination floor and a person as a a parameter
		timer=timer+10;  //increments timer by 10 seconds or 1 tick
		f.setFloornumber(whatFloor);
		if(timer == p.generateTime(10, 30)) {
			f.setFloornumber(0);
			f.addToQ(p);
		}
	}
	
	public int getSimulationTime() { //returns the total time of the simulation
		return timer;
	}
	
	public void arriveOnGroundFloor(Floor f, Person p){
		Random rd = new Random();
		if(s.getQProbability()>rd.nextDouble()) {
			f.addToQ(p);
		}
	}
}