package courseWork;

import java.util.Random;

//import javafx.application.Application;

public class Simulation {
	
	MenuController MenuVars;
	MenuController test; //test for building
	Floor Groundfloor;
	Building b = new Building(test);
	
	int personSize=1;

	public Simulation(MenuController m) {
		MenuVars = m;
		Floor Groundfloor=new Floor();
		generatePeople();
	}
	
	
	public int generatePeople() {
		if(Groundfloor.sizeQueue()==0) {
			while(Groundfloor.sizeQueue()<=20) {
				Groundfloor.addToQ(new Developers("Devs", personSize, b));
				Groundfloor.addToQ(new Employees("Employees", personSize, b));
			}
		System.out.println(Groundfloor.sizeQueue());
		}
		return Groundfloor.sizeQueue();
	}
	
	
	public void run() {
		Building building1 = new Building(MenuVars);
		Random randomness = new Random();
		building1.tick();
	}
}
