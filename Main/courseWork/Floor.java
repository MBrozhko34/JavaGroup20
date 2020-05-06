package courseWork;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public class Floor {
	
	//private Building building;
	public ArrayList<Person> peopleOnFloor;
	public ArrayList<Person> waitingQueue;
	public boolean goUp;
	public int floornumber;
	public boolean goDown;
	public Elevator e;
	Building b;
	Simulation s;
	
	public Floor(int floorno,Simulation S, Building b) {
		peopleOnFloor = new ArrayList<Person>();
		waitingQueue = new ArrayList<Person>();
		goUp = false;
		goDown = false;
		floornumber = floorno;
		s = S;
		this.b=b;
	}

	public void addToQ(Person P){
		waitingQueue.add(P);
		P.startWaiting=b.getSimulation().tick;
		P.getInLift=0;
		System.out.println("MoveCheck");
		if(floornumber==0) {
			b.allPeople.add(P);
		}
	}

	public void removeFromQ(){
		waitingQueue.remove(0);
	}
	
	public void arrive(Person P){
		peopleOnFloor.add(P);
	}

	public void leave(Person p){
		peopleOnFloor.remove(p);
	}

	public int sizeQueue() {
		return waitingQueue.size();
	}

	public int getFloornumber() {
		return floornumber;
	}

	public void setFloornumber(int floornumber) {
		this.floornumber = floornumber;
	}
	
	public void tick() {
//		if (peopleOnFloor.isEmpty()) {
//			System.out.println("Floor is empty");
//		} else {
//			MoveChecker();
//		}
		MoveChecker();
	}
	
	public void MoveChecker() {
		for (int i=0; i<peopleOnFloor.size(); i++) {
			Person buffer = peopleOnFloor.get(i);
			buffer.tick();
			if (buffer.wantToMove && buffer.done ) {
				peopleOnFloor.remove(i);
				i = i-1;
			}
			else if (buffer.wantToMove && !(buffer.whatFloor == floornumber)) {
				peopleOnFloor.remove(i);
				i = i-1;
				addToQ(buffer);
				b.elevators.get(0).getFloorsCalled().add(buffer.whatFloor);
				
			}
		}
	}
	
	//individual people know where they are going-> subclasses of person class

}

