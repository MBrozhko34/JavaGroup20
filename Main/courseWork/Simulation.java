package courseWork;

import java.util.Random;

//import javafx.application.Application;

public class Simulation {
	
	MenuController MenuVars;
	TextBasedUI Ui;
	public int tick;
	int allWaiting=0;
	int totalAverageTime;


	public Simulation(MenuController m) {
		MenuVars = m;
		tick = 0;

	}
	

	public void run() {
		Building building1 = new Building(MenuVars,this);
		Random randomness = new Random(20);
		randomness.setSeed(MenuVars.getSeed());	
		ArrivalSimulator s = new ArrivalSimulator(randomness);
		PeopleCreator p = new PeopleCreator(MenuVars, building1,s,randomness);
		Ui = new TextBasedUI(building1,this);
		Ui.showUI();
		
		for (int i=0; i< MenuVars.getTicks();i++) {
			building1.tick();
			p.tick();
			Ui.showUI();
			tick++;
		}
		for(Person p1: building1.allPeople) {
			//int waitingTime = 0;
			//waitingTime=p.getInLift-p.startWaiting;
			allWaiting=allWaiting+(p1.getInLift-p1.startWaiting);
			totalAverageTime=allWaiting/building1.allPeople.size();
		}
		System.out.println("The average waiting time is: "+totalAverageTime);
	}
}
