package courseWork;

import java.util.Random;

/**
 * The client class is used to assign characteristics to this specific group of people,
 * including their desired floor range and whether they choose to change floors throughout the
 * simulation.
 */

public class Developers extends Person {
	int minFloor;
	int maxFloor;
	int range;
	ArrivalSimulator s;
	int timer=0;
	
	/**
	 * This is the constructor for the Developers and calls the constructor super of Person
	 *
	 * @param name The name of object we are creating which is Developers
	 * @param spaceRequired how much space this person takes in the lift
	 * @param b the overall building so the person can have access to the floors and the elevators
	 * @param S this is the class that Deals with all of the probabilities and randomness
	 * @param R same random object throughout the program
	 */
	public Developers(String name, int spaceRequired, Building b,ArrivalSimulator s,Random R) {
		super(name,spaceRequired, b,s,R);
		minFloor = (b.getHowManyFloors()-1)/2;
		maxFloor = b.getHowManyFloors()-1;
		range = (maxFloor - minFloor) +1;
		choose();
		
	}
	@Override
	public void choose() {
		whatFloor = random.nextInt(maxFloor - minFloor +1)+minFloor;
	}
	
	
	
}
