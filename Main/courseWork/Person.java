
import java.util.Random;

public class Person {
	
	String name;
	int currentFloor;
	int spaceRequired;
	String direction;
	int whatFloor; // to store what floor the guy wants to go to
	
	public Person (String name, int space) {
		this.name = name;
		currentFloor = 0;
		spaceRequired = space;
	}
	
	public String returnName() {
		return name;
	}
	
	public void buttonPress() {
		String floor = Integer.toBinaryString(currentFloor);
		System.out.println("The Lift was called at floor"+floor);
		
	}
	
	public int returnFloor() {
		return currentFloor;
	}
	
	public void chooseFloor(int numberOfFloors) {
		//generate random number for floor to go to
		Random R = new Random();
		whatFloor = R.nextInt((numberOfFloors - 1) + 1) + 1;
	}
	
	public void setFloor(Elevator E) {
		if (whatFloor == E.currentFloor) {
			currentFloor = whatFloor;
		}
		
	}
	
	public int getSpace() {
		return spaceRequired;
	}
}
