package courseWork;

public class MaintenanceCrews extends Person{
	String name = "Maintenance Crews";
	int spaceRequired = 4;
	
	public MaintenanceCrews(String name, int spaceRequired) {
		super(name,spaceRequired);
		whatFloor=7;
	}
	
	public void leave() {
		whatFloor = 0;
	}
}