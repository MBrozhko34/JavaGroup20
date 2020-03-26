package elevatorSimulation;

import java.util.ArrayList;
import java.util.Queue;

public class Floor {
	
	private String name;
	private Building building;
	private Elevator elevators;
	private ArrayList<Person> peopleOnFloor;
	private ArrayList<Person> waitingQueue;
	private int numFloors = 0;
	private ArrayList<String> Floors;
	
	public Floor() {
		peopleOnFloor = new ArrayList<Person>();
		waitingQueue = new ArrayList<Person>();
		ArrayList<String> Floors = new ArrayList<String>();
	}

	public int setFloors(){
		while(numFloors<7) {
		Floors.add("Floor " + numFloors);
		numFloors++;
		}
	}

	public int addToQ(){
		waitingQueue.add();
	}

	public int removeFromQ(){
		waitingQueue.remove(0);
	}

	public float arrive(p: Person){
		person.getCurrentFloor();
	}

	public float leave(p: Person){
		person.setCurrentFloor();
	}

	public int getFloors(){
		return elevators.getCurrentFloor();
	}

}

