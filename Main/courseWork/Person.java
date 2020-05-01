package courseWork;
import java.util.Random;

public class Person {
	
	String name;
	int currentFloor;
	int spaceRequired;
	String direction;
	int whatFloor; // to store what floor the guy wants to go to
	Building building;
	public String test;
	ArrivalSimulator s;
	public boolean wantToMove;
	
	public Person (String name, int space,Building b, ArrivalSimulator s) {
		this.name = name;
		currentFloor = 0;
		spaceRequired = space;
		building = b;
		this.s = s;
		wantToMove = false;
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
	
//	public void chooseFloor(int numberOfFloors) {
//		//generate random number for floor to go to
//		Random R = new Random();
//		whatFloor = R.nextInt((numberOfFloors - 1) + 1) + 1;
//	}
	
	public void setFloor(Elevator E) {
		if (whatFloor == E.getCurrentFloor()) {
			currentFloor = whatFloor;
		}
		
	}
	
	public int getSpace() {
		return spaceRequired;
	}
	
	public int generateTime(int a, int b) { //Generates random number for time on floor
		Random rd = new Random();
		int minTickTime = a*6;
		int maxTickTime = b*6;
		int value = rd.nextInt((maxTickTime-minTickTime)+1) + minTickTime;
		return value;
		
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

		public int getWhatFloor() {
			return whatFloor;
		}

		public void setWhatFloor(int whatFloor) {
			this.whatFloor = whatFloor;
		}	
		
		public void tick() {
			System.out.println("Hello");
		}
}
