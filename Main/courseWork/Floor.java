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

	public int initializeFloors(){
		while(numFloors<=7) {
		Floors.add("Floor " + numFloors);
		numFloors++;
		}
		System.out.println(Floors.size());
	}

	public int addToQ(){
		waitingQueue.add();
	}

	public int removeFromQ(){
		waitingQueue.remove(0);
	}

	public float arrive(p: Person){
		person.getCurrentFloor();
		peopleOnFloor.add(p);
	}

	public float leave(p: Person){
		person.setCurrentFloor();
		peopleOnFloor.remove(p);
	}

	public int getFloors(){
		return elevators.getCurrentFloor();
	}
	
	//individual people know where they are going-> subclasses of person class

}

