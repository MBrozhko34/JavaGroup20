package courseWork;

public class TextBasedUI {

	Building b;
	String peoplewaiting = "People waiting for Lift: ";
	String floorpeople = "People on this floor are: ";
	String elevatorppl = "People in this Elevator are ";

	public TextBasedUI(Building b) {
		this.b = b;

	}

	public void showUI() {
		System.out.println("---------------------------");
		System.out.println("Floors:");
		System.out.println("");
		for (Floor f: b.getFloors()) {
			System.out.println("Floor: "+f.getFloornumber());
			if (f.waitingQueue.isEmpty()) {
				System.out.println("There is nobody waiting for the lift");
			} else {
				for (Person p: f.waitingQueue) {
					peoplewaiting = peoplewaiting+p.returnName()+" "+p.whatFloor+" ";
				}
				System.out.println(peoplewaiting);
			}
			if (f.peopleOnFloor.isEmpty()) {
				System.out.println("There is nobody Currently at this floor");
				System.out.println("");
			} else {
				for (Person p: f.peopleOnFloor) {
					floorpeople = floorpeople+p.returnName()+" ";
				}
				System.out.println(floorpeople);
				System.out.println("");
			}
		}
		for (Elevator e: b.elevators) {
			if (e.getPeopleInElevator().isEmpty()) {
				System.out.println("There is nobody in this lift");
				System.out.println("");
			} else {
				for (Person p: e.getPeopleInElevator()) {
					elevatorppl = elevatorppl+p.returnName()+" ";
				}
				System.out.println(peoplewaiting);
				System.out.println("");
			}
		}
		System.out.println("---------------------------");

	}
}





