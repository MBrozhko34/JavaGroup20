package courseWork;

import java.util.Random;

public class Employees extends Person {
	String name = "Non Developers";
	int spaceRequired = 1;
	int minFloor = 1;
	int maxFloor;
	int range;
	ArrivalSimulator s;
	int timer=0;
	
	public Employees(String name, int spaceRequired, Building b) {
		super(name,spaceRequired, b);
		maxFloor = b.getHowManyFloors()-1;
		range = (maxFloor - minFloor) +1;
		choose();
	}

	public void choose() {
		whatFloor = (int)(Math.random()*range) + minFloor;
	}
	
	public void tick(Floor f, Person p) {
		timer=timer+10;
		f.setFloornumber(whatFloor);
		Random rd = new Random();
		if(s.getPProbability()>rd.nextDouble()) {
			f.addToQ(p);
		}
	}
	
	public int getSimulationTime() {
		return timer;
	}
}