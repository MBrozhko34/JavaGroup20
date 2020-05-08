package courseWork;

import java.util.Random;

/**
* Class for the Maintenance crew which extends the default person Class to create another kind of person
* 
*/

public class MaintenanceCrews extends Person{
	int currentFloor=0;
	ArrivalSimulator s;
	Floor f;
	int mintime = 120;
	int maxtime= 240;
	int range = (maxtime - mintime) + mintime;
	int howLong;
	
	
	/**
	 * This is the constructor for the MaintenceCrew and calls the constructor super of Person
	 *
	 * @param name The name of object we are creating which is MaintenceCrew
	 * @param spaceRequired how much space this person takes in the lift
	 * @param b the overall building so the person can have access to the floors and the elevators
	 * @param S this is the class that Deals with all of the probabilities and randomness
	 * @param R same random object throughout the program
	 */
	public MaintenanceCrews(String name, int spaceRequired, Building b,ArrivalSimulator S,Random R) {
		super(name,spaceRequired, b,S,R);
		this.spaceRequired=spaceRequired;
		whatFloor = building.getHowManyFloors()-1;
		howLong = random.nextInt(maxtime - mintime +1)+mintime;
	}
	
	/**
	 * this function sees if the Crew needs to change floor depending on how 
	 * long they have been at the floor 
	 */
	@Override
	public void tick() { //this logic is currently not working
		if ((building.getSimulation().tick - arriveTick) > howLong ) {
			whatFloor = 0;
			wantToMove = true;
			done = true;
		}
		
	}
	
}