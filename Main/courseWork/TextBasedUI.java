package courseWork;

public class TextBasedUI {

	Building b;
	String peoplewaiting = "People waiting for Lift: ";
	String elevatorppl = "People in this Elevator are ";
	Simulation s;
	int totalAverageTime;

	public TextBasedUI(Building b,Simulation S) {
		this.b = b;
		this.s = S;

	}

	public void showUI() {
		System.out.println("---------------------------");
		System.out.println("Current Tick "+s.tick);
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
				peoplewaiting = "People waiting for Lift: ";
			}
			if (f.peopleOnFloor.isEmpty()) {
				System.out.println("There is nobody Currently at this floor");
				System.out.println("");
			} else {
				String floorpeople = "People on this floor are: ";
				for (Person p: f.peopleOnFloor) {
					floorpeople = floorpeople+p.returnName()+" ";
				}
				System.out.println(floorpeople);
				System.out.println("");
				floorpeople = "People on this floor are: ";
			}
		}
		
		
		for (Elevator e: b.elevators) {
			System.out.println("Elevator: "+e.getid());
			System.out.println("Elevator is at floor: "+e.getCurrentFloor());
			System.out.println("Space in elevator is:"+e.getSpaceLeft());
			if (e.getPeopleInElevator().isEmpty()) {
				System.out.println("There is nobody in this lift");
				System.out.println("");
			} else {
				for (Person p: e.getPeopleInElevator()) {
					elevatorppl = elevatorppl+p.returnName()+" "+p.whatFloor+" ";
				}
				System.out.println(elevatorppl);
				System.out.println("");
				elevatorppl = "People in this Elevator are ";
			}
		}
		
//		for(Person p: b.allPeople) {
//			//int waitingTime = 0;
//			//waitingTime=p.getInLift-p.startWaiting;
//			int allWaiting=0;
//			totalAverageTime=0;
//			allWaiting=allWaiting+(p.getInLift-p.startWaiting);
//			totalAverageTime=allWaiting/b.allPeople.size();
//			//System.out.println("The average waiting time is: "+totalAverageTime);
//		}
	}
}





