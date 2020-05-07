package courseWork;

import java.util.ArrayList;

public class Elevator {

		public int currentFloor;
		private ArrayList<Person> peopleInElevator;
		private ArrayList<Integer> floorsCalled; 
		private Building building;
		private int spaceLimit;
		public static int up = 2;
		public static int down = 1;
		public static int idle = 0;
		private int howManyPeopleIn;
		private boolean isOpen;
		private int spaceLeft;
		private boolean isDoorOpen;
		public int direction;
		private int id;
		Simulation s;

		public int getCurrentFloor() {
			return currentFloor;
		}
		
		public int getSpaceLeft() {
			return spaceLeft;
		}

		public int getid() {
			return id;
		}
		public Elevator(int c, int id,Building b,Simulation S) {
			currentFloor = 0;
			idle = 0;
			isOpen = true;
			spaceLimit = c;
			howManyPeopleIn = 0;
			spaceLeft = spaceLimit;
			peopleInElevator = new ArrayList<Person>();
			this.id = id;
			building = b;
			direction = 1;
			s = S;

		}

		public void addPeople(Floor f) {   //floor needs to have a method to return 
			for (int i=0; i < f.sizeQueue();i++) { //what floor number it is
				Person buffer = f.waitingQueue.get(i);
				if (buffer.getSpace() <= spaceLeft) {
					f.removeFromQ();
					i -=1;
					peopleInElevator.add(buffer);
					buffer.getInLift=building.getSimulation().tick;
					spaceLeft = spaceLeft - buffer.getSpace();
					howManyPeopleIn = peopleInElevator.size();
				} else {
					//leave the person in the floor queue is there isnt space
					//System.out.println("There is no more space");
				}
			}

		}
		
		public void removePeople(Floor f) {
			for (int i=0; i<howManyPeopleIn; i++) {
				Person buffer = getPeopleInElevator().get(i);
				if (buffer.getWhatFloor()==currentFloor) {
					getPeopleInElevator().remove(i);
					i -=1;
					buffer.setCurrentFloor(currentFloor);
					buffer.setArriveTick(s.tick);
					f.arrive(buffer);
					spaceLeft = spaceLeft + buffer.getSpace();
					howManyPeopleIn = howManyPeopleIn - 1;
				}
			}
		}

		public int howManyPeopleIn() {
			return getPeopleInElevator().size();
		}
		
		
		public ArrayList<Person> getPeopleInElevator() {
			return peopleInElevator;
		}

		public void moveliftup() {
			currentFloor = currentFloor + 1;
		}
		
		public void moveliftdown() {
			currentFloor = currentFloor - 1;
		}
		
		public void move() {
			if (currentFloor == (building.getHowManyFloors())-1) {
				direction = -1;
				moveliftdown();
			} else if (currentFloor == 0) {
				direction = 1;
				moveliftup();
			} else if (currentFloor < building.getHowManyFloors() && direction == -1) {
				moveliftdown();
			} else if (currentFloor < building.getHowManyFloors() && direction == 1) {
				moveliftup();
			}
		}

//		public Floor Direction() {
//			RequestList r;
//			Person p;
//			for (i = 0; i< peopleInElevator(); i++) {
//				if (r.getFloor() == currentFloor)			}
//		}
		
		public void tick() {
			removePeople(building.getFloors().get(currentFloor));
			addPeople(building.getFloors().get(currentFloor));
			move();
			//people that need to leave will get out
			//people on the floor waiting will get on 
			// the lift will move
		}

}
