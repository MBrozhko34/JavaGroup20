package courseWork;

import java.util.Random;

/**
 * The employees class is used to assign characteristics to this specific group of people,
 * including their desired floor range and whether they choose to change floors throughout the
 * simulation.
 */

public class Employees extends Person {
	String name = "Non Developers";
	int spaceRequired = 1;
	int minFloor = 1;
	int maxFloor;
	int range;
	int timer=0;
	
	/**
	 * This is the constructor for the Employees and calls the constructor super of Person
	 *
	 * @param name The name of object we are creating which is Employees
	 * @param spaceRequired how much space this person takes in the lift
	 * @param b the overall building so the person can have access to the floors and the elevators
	 * @param S this is the class that Deals with all of the probabilities and randomness
	 * @param R same random object throughout the program
	 */
	public Employees(String name, int spaceRequired, Building b, ArrivalSimulator s,Random R) {
		super(name,spaceRequired, b,s,R);
		maxFloor = b.getHowManyFloors()-1;
		range = (maxFloor - minFloor) +1;
		choose();
	}

	@Override
	public void choose() {
		whatFloor = (int)(Math.random()*range) + minFloor;
	}
	
	
	public int getSimulationTime() { //returns the total time of the simulation
		return timer;
	}
}