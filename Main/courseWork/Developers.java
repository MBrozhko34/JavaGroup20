public class Developers extends Person {
	String name = "Developers";
	int spaceRequired = 1;
	currentFloor=0;
	
	public Developers(String name, int spaceRequired) {
		super(name,spaceRequired);
		whatFloor=random(5,7);
		int end=random(5,7);
		endFloor(end);
	}
	
	@Override
	public Person(String name, int spaceRequired) {
		this.name = name;
		currentFloor=whatFloor;
		this.spaceRequired=spaceRequired;
	}
	System.out.println(currentFloor);
	
	//Function needed to out
	//public void endFloor(int end) {
	//	currentFloor=end;
	//}	
}