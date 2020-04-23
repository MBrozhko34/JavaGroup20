public class Clients extends Person {
	String name = "Clients";
	int spaceRequired = 1;
	currentFloor=0;
	
	public Clients(String name, int spaceRequired) {
		super(name,spaceRequired);
		whatFloor=random(2,4);
		int end=0;
		endFloor(end);
	}
	
	@Override
	public Person(String name, int spaceRequired) {
		this.name = name;
		currentFloor=whatFloor;
		this.spaceRequired=spaceRequired;
	}
	System.out.println(currentFloor);
}