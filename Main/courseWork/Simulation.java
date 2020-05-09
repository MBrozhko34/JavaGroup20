package courseWork;

import java.util.Random;

//import javafx.application.Application;

public class Simulation {
	
	private MenuController MenuVars;
	private TextBasedUI Ui;
	public int tick;
	public static int allWaiting=0;
	public int totalAverageTime;
	public Clients c1;
	public int complaints=0;
	public Random randomness;
	public Study studyTest;
	


	public Simulation(MenuController m) {
		MenuVars = m;
		tick = 0;
		

	}
	

	public void run() {
		Building building1 = new Building(MenuVars,this);
		randomness = new Random();
		randomness.setSeed(MenuVars.getSeed());	
		ArrivalSimulator s = new ArrivalSimulator(randomness,0,0);
		PeopleCreator p = new PeopleCreator(MenuVars, building1,s,randomness);
		Ui = new TextBasedUI(building1,this);
		Ui.showUI();
		
		for (int i=0; i< MenuVars.getTicks();i++) {
			building1.tick();
			p.tick();
			Ui.showUI();
			tick++;
		}
	}
	
	
	public void runStudy(int p, int q) {
		Building building1 = new Building(MenuVars,this);
		randomness = new Random();
		randomness.setSeed(MenuVars.getSeed());
		ArrivalSimulator s = new ArrivalSimulator(randomness,p,q);
		PeopleCreator pc = new PeopleCreator(MenuVars, building1,s,randomness);
		//Ui = new TextBasedUI(building1,this);
		//Ui.showUI();
		
		for (int i=0; i< MenuVars.getTicks();i++) {
			building1.tick();
			pc.tick();
			//Ui.showUI();
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
		System.out.println("The probability of P is: "+s.getPProbability()); 
		System.out.println("The probability of Q is: "+s.getQProbability());
		
		//if(complaints>5) {
		//	System.out.println("We have had more than 5 complaints, this is bad");
		//}
	}
	
	public int getAverageWaitingTime() {
		return totalAverageTime;
	}
}
