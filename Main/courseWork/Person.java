package courseWork;
import java.util.Random;

/**
 * This is the template class for the different types of people we have in our simulation
 * if another type of person would be added most of the logic is already here and the new person
 * can just inherit from this class
 * @author amrik
 *
 */

public class Person {
	
	public String name;
	public int currentFloor;
	public int spaceRequired;
	public String direction;
	public int whatFloor; // to store what floor the guy wants to go to
	public Building building;
	public String test;
	public ArrivalSimulator s;
	public boolean wantToMove;
	public Random random;
	protected int arriveTick;
	protected boolean done = false;
	public int startWaiting;
	public int getInLift;
	
	/**
	 * This is the constructor for the people
	 *
	 * @param name The name of object we are creating - this changes depending on what person we want
	 * @param spaceRequired how much space this person takes in the lift
	 * @param b the overall building so the person can have access to the floors and the elevators
	 * @param S this is the class that Deals with all of the probabilities and randomness
	 * @param R same random object throughout the program
	 */
	
	public Person (String name, int space,Building b, ArrivalSimulator s,Random R) {
		this.name = name;
		currentFloor = 0;
		spaceRequired = space;
		building = b;
		this.s = s;
		wantToMove = false;
		random = R;
		arriveTick = 0;
	}
	
	public String returnName() {
		return name;
	}
	
	public int returnFloor() {
		return currentFloor;
	}
	
//	public void chooseFloor(int numberOfFloors) {
//		//generate random number for floor to go to
//		Random R = new Random();
//		whatFloor = R.nextInt((numberOfFloors - 1) + 1) + 1;
//	}
	
	/**
	 * when elevator reaches a floor and person leaves elevator that persons floor is 
	 * set to the floor the elevator is current at
	 * @param E Elevator is passed to access the current floor
	 */
	public void setFloor(Elevator E) {
		if (whatFloor == E.getCurrentFloor()) {
			currentFloor = whatFloor;
		}
		
	}
	
	public int getSpace() {
		return spaceRequired;
	}
	
	//Function needed be added to Person class to allow for change in floor after first floor:
		public void Destination(int end) {
			currentFloor=end;
		}

		public int getCurrentFloor() {
			return currentFloor;
		}

		public void setCurrentFloor(int currentFloor) {
			this.currentFloor = currentFloor;
		}

		public int getArriveTick() {
			return arriveTick;
		}

		public void setArriveTick(int arriveTick) {
			this.arriveTick = arriveTick;
		}

		public int getWhatFloor() {
			return whatFloor;
		}

		public void setWhatFloor(int whatFloor) {
			this.whatFloor = whatFloor;
		}	
		
		/**
		 * choose function template
		 */
		public void choose() {
			System.out.println("choosing a floor");
		}
		
		/**
		 * when the simulation runs the people checkif they want to move floor
		 * if they do then they choose a new floor and tell the simulation they want to move
		 */
		public void tick() {
			if (s.getPProbability()) {
				wantToMove = true;
				choose();
			}
		}
}
