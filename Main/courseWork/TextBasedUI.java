package courseWork;

/**
 * Shows the current state of the simulation
 * @author amrik
 *
 */

public class TextBasedUI {

	public Building b;
	private static String peoplewaiting = "People waiting for Lift: ";
	private static String elevatorppl = "People in this Elevator are ";
	public Simulation s;
	public float totalAverageTime;
	public int allWaiting=0;
	public int complaints=0;

	public TextBasedUI(Building b,Simulation s) {
		this.b = b;
		this.s = s;

	}

	/**
	 * one main function to show the state of the floors 
	 * then shows the state of the elevators
	 * then updates the average waiting time and complaint numbers
	 */
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
		
		for(Person p1: b.allPeople) {
			//int waitingTime = 0;
			//waitingTime=p.getInLift-p.startWaiting;
			if(p1.getInLift!=0) {
				allWaiting=allWaiting+(p1.getInLift-p1.startWaiting);
				totalAverageTime=allWaiting/b.allPeople.size();
			}
			if(p1.name=="Client") {
				if((p1.getInLift-p1.startWaiting)>60) {
					complaints++;
					if (p1.currentFloor == 0) {
						b.getFloors().get(0).waitingQueue.remove(p1);
					}
				}
			}			
		}
		System.out.println("The average waiting time is: "+totalAverageTime);
		System.out.println("The total number of complaints: "+complaints);	
		totalAverageTime=0;
		allWaiting=0;
		complaints=0;
		}
}





