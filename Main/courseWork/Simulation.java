package courseWork;

import java.util.Random;

/**
 * This class runs the simulation and creates instances of the classes 
 * needed for the simulation to run
 * @author amrik
 *
 */

public class Simulation {
	
	MenuController MenuVars;
	TextBasedUI Ui;
	public int tick;
	int allWaiting=0;
	int totalAverageTime;
	Clients c1;
	int complaints=0;
	Random randomness;
	Study studyTest;
	
	public Simulation(MenuController m) {
		MenuVars = m;
		tick = 0;
	}
	
/**
 * When we want to run the simulation once this function is called
 * the building, random , arival simulator, peoplecreator and UI objects are all created
 * we show the building by calling the show Ui once before the building is ticked to see all
 * the people that are generated
 * 
 * We then tick everything in the simulation for however many ticks the user specifies
 * then show the changes of ticking everything
 */
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
	
	/**
	 * The run study runs the simulation but does not show the Ui as we are only intrested in the waiting time and 
	 * complaint numbers
	 * @param p to loop through all combinations that p and Q can be
	 * @param q same as above, in our study can call this function 
	 */
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
				if((p1.getInLift-p1.startWaiting)>60) {
					complaints++;
				}
			}			
		}
		System.out.println("The average waiting time is: "+totalAverageTime);
		System.out.println("The total number of complaints: "+complaints);
		System.out.println("The probability of P is: "+s.getPProbability()); 
		System.out.println("The probability of Q is: "+s.getQProbability());
	}
	
	public int getAverageWaitingTime() {
		return totalAverageTime;
	}
}
