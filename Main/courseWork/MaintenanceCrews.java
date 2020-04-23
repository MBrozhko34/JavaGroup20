public class MaintenanceCrews extends Person{
	String name = "Maintenance Crews";
	int spaceRequired = 4;
	currentFloor=0;
	
	public MaintenanceCrews(String name, int spaceRequired) {
		super(name,spaceRequired);
		whatFloor=7;
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