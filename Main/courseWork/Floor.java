package courseWork;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

/**
 * The class deals with keeping track of the queues on each floor, paying attention to those who 
 * leave and join the queue for the elevator. It also checks if people want to move.
 */

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
	
	/**
	 * This constructor keeps track of the people on the floor and those waiting in the queue. It also
	 * sets the people's initial intentions to saying on the same floor, which will later change throughout
	 * the simulation
	 * @param floorno is the current floor number individual people are on.
	 * @param S is an instance of the Simulation class.
	 * @param b is an instance of the Building class.
	 */
	public Floor(int floorno,Simulation S, Building b) {
		peopleOnFloor = new ArrayList<Person>();
		waitingQueue = new ArrayList<Person>();
		goUp = false;
		goDown = false;
		floornumber = floorno;
		s = S;
		this.b=b;
	}
	
	/**
	 * This function adds people to the waiting queue on each floor.
	 * @param P is an instance of the Person class and is used to add each individual to the queue on 
	 * each floor.
	 */
	public void addToQ(Person P){
		waitingQueue.add(P);
		P.startWaiting=b.getSimulation().tick;
		P.getInLift=0;
		//System.out.println("MoveCheck");
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
	
	public void addToback(Person P) {
		leave(P);
		arrive(P);
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
	
	/**
	 * This function is used to check whether an individual wants to move floors or stay on the current one. If they
	 * want to stay on the current floor, their initial intentions of moving floors will remain the same as 
	 * initialised. Otherwise it becomes 'true' and the individual changes floor.
	 */
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
				b.elevators.get(0).getFloorsCalled().add(buffer.currentFloor);
				
			}
		}
	}
	
	//individual people know where they are going-> subclasses of person class

}

