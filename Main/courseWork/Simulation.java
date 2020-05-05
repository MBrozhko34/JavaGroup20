package courseWork;

import java.util.Random;

//import javafx.application.Application;

public class Simulation {
	
	MenuController MenuVars;
	TextBasedUI Ui;
	public int tick;
	int allWaiting=0;
	int totalAverageTime;
	Clients c1;
	int complaints=0;
	Random randomness;


	public Simulation(MenuController m) {
		MenuVars = m;
		tick = 0;

	}
	

	public void run() {
		Building building1 = new Building(MenuVars,this);
		randomness = new Random();
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
			if(p1.getInLift!=0) {
				allWaiting=allWaiting+(p1.getInLift-p1.startWaiting);
				totalAverageTime=allWaiting/building1.allPeople.size();
			}
			if(p1.name=="Client") {
				if((p1.getInLift-p1.startWaiting)>1) {
					complaints++;
				}
			}			
		}
		System.out.println("The average waiting time is: "+totalAverageTime);
		System.out.println("The total number of complaints: "+complaints);
		
		//if(complaints>5) {
		//	System.out.println("We have had more than 5 complaints, this is bad");
		//}
	}
	
	public int getAverageWaitingTime() {
		return totalAverageTime;
	}
}
