public class NotDevs extends Person {
	String name = "Non Developers";
	int spaceRequired = 1;
	currentFloor=0;
	
	public NotDevs(String name, int spaceRequired) {
		super(name,spaceRequired);
		whatFloor=random(2,7);
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