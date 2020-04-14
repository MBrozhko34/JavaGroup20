package courseWork;

import java.util.ArrayList;
import java.util.Queue;

public class Floor {
	
	//private Building building;
	private Elevator elevators;  //why does the floor need the elevator class?
	private ArrayList<Person> peopleOnFloor;
	private ArrayList<Person> waitingQueue;
	private int numFloors = 0;
	private ArrayList<String> Floors;
	
	public Floor() {
		peopleOnFloor = new ArrayList<Person>();
		waitingQueue = new ArrayList<Person>();
		ArrayList<String> Floors = new ArrayList<String>();
	}

	public void addToQ(Person P){
		waitingQueue.add(P);
	}

	public Person removeFromQ(){
		Person leaving = waitingQueue.get(0);
		waitingQueue.remove(0);
		return leaving;
	}

//	public float arrive(p: Person){
//		person.getCurrentFloor();
//		peopleOnFloor.add(p);
//	}
//
//	public float leave(p: Person){
//		person.setCurrentFloor();
//		peopleOnFloor.remove(p);
//	}

//	public int getFloors(){
//		return elevators.getCurrentFloor();
//	}
	
	public int sizeQueue() {
		return waitingQueue.size();
	}
	
	//individual people know where they are going-> subclasses of person class

}

