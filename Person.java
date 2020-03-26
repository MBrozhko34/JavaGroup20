package elevatorSimulation;

public class Person {
	
	String name;
	int floor;
	
	public Person (String Name) {
		this.name = Name;
		floor = 0;
	}
	
	public String returnName() {
		return name;
	}
	
	public void buttonPress() {
		
	}
	
	public int returnFloor() {
		return floor;
	}
	
	public int chooseFloor() {
		//generate random number for floor to go to
	}
}
