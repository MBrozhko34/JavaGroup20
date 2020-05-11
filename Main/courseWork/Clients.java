package courseWork;

import java.util.Random;

/**
 * The client class is used to assign characteristics to this specific group of people,
 * including their desired floor range and the time they spend on their chosen floor throughout the
 * simulation.
 */

public class Clients extends Person {
	String name = "Clients";
	int minFloor;
	int maxFloor;
	ArrivalSimulator s;
	int timer = 0;
	final int minTime = 60;
	final int maxTime= 180;
	int range = (maxTime - minTime) + minTime;
	int howLong;
	
	/**
	 * This is the constructor for the Clients and calls the constructor super of Person
	 *
	 * @param name The name of object we are creating which is Clients
	 * @param spaceRequired how much space this person takes in the lift
	 * @param b the overall building so the person can have access to the floors and the elevators
	 * @param S this is the class that Deals with all of the probabilities and randomness
	 * @param R same random object throughout the program
	 */
	public Clients(String name, int spaceRequired, Building b,ArrivalSimulator S, Random R) {
		super(name,spaceRequired, b,S,R);
		minFloor = 1;
		maxFloor = ((b.getHowManyFloors()-1)/2);
		range = (maxFloor - minFloor) +1;
		howLong = random.nextInt(maxTime - minTime +1)+minTime;
		choose();
		
	}

	public void choose() {
		//need to fix the logic in here
		whatFloor = random.nextInt(maxFloor - minFloor +1)+minFloor;
	}
	
	
	public int getSimulationTime() { //returns the total time of the simulation
		return timer;
	}
	
	/**
	 * This function is used to calculate what tick the clients arrive at.
	 */
	@Override
	public void tick() {
		if ((building.getSimulation().tick - arriveTick) > howLong ) {
			whatFloor = 0;
			wantToMove = true;
			done = true;
		}
	}
	
}