package courseWork;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class deals with giving the elevator functionality. It also controls people moving
 * in and out of the lift to help them move between floors.
 */

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
		//private boolean isOpen;
		private int spaceLeft;
		//private boolean isDoorOpen;
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
		
		/**
		 * This constructor is used to the calculate how the space within the elevator
		 * and also track the movement of the elevator
		 * 
		 * @param c is the value of the spaceLimit variable within the elevator. 
		 * @param id is the value of the current elevator id. 
		 * @param b is an instance of the Building class.
		 * @param S is an instance of the Simulation class.
		 */
		public Elevator(int c, int id,Building b,Simulation S) {
			currentFloor = 0;
			idle = 0;
			//isOpen = true;
			spaceLimit = c;
			howManyPeopleIn = 0;
			spaceLeft = spaceLimit;
			peopleInElevator = new ArrayList<Person>();
			floorsCalled = new ArrayList<Integer>();
			this.id = id;
			building = b;
			direction = 1;
			s = S;

		}
		
		/**
		 * The function adds people to the elevator queue, ready for them to be removed once the
		 * elevator arrives and there is enough space within the elevator.
		 * 
		 * @param f is an instance of the Floor class.
		 */
		public void addPeople(Floor f) {   //floor needs to have a method to return 
			for (int i=0; i < f.sizeQueue();i++) { //what floor number it is
				Person buffer = f.waitingQueue.get(i);
				if (buffer.getSpace() <= spaceLeft) {
					boolean gdPresent = false;
					boolean mdPresent = false;
					String bufferName = buffer.name.substring(0, 2);
					if (bufferName.equals("MD")) {
						for (Person pson: peopleInElevator) {
							String substring = pson.name.substring(0,2);
							if (substring.equals("GD")) {
								gdPresent = true;
							}
						}
						if (gdPresent) {
							f.addToback(buffer);
						} else {
							f.removeFromQ(); 
							i -=1; 
							peopleInElevator.add(buffer);
							if (!floorsCalled.contains(buffer.whatFloor)) {
								floorsCalled.add(buffer.whatFloor);
							}
							buffer.getInLift=building.getSimulation().tick;
							spaceLeft = spaceLeft - buffer.getSpace();
							howManyPeopleIn = peopleInElevator.size();
						}
					} else if (bufferName.equals("GD")) {
						for (Person pson: peopleInElevator) {
							String substring = pson.name.substring(0,2);
							if (substring.equals("MD")) {
								mdPresent = true;
							}
						}
						if (mdPresent) {
							f.addToback(buffer);
						} else {
							f.removeFromQ(); 
							i -=1; 
							peopleInElevator.add(buffer);
							if (!floorsCalled.contains(buffer.whatFloor)) {
								floorsCalled.add(buffer.whatFloor);
							}
							buffer.getInLift=building.getSimulation().tick;
							spaceLeft = spaceLeft - buffer.getSpace();
							howManyPeopleIn = peopleInElevator.size();
						}
					} else {
						f.removeFromQ(); 
						i -=1; 
						peopleInElevator.add(buffer);
						if (!floorsCalled.contains(buffer.whatFloor)) {
							floorsCalled.add(buffer.whatFloor);
						}
						buffer.getInLift=building.getSimulation().tick;
						spaceLeft = spaceLeft - buffer.getSpace();
						howManyPeopleIn = peopleInElevator.size();
					}
					
//					f.removeFromQ(); 
//					i -=1; 
//					peopleInElevator.add(buffer);
//					if (!floorsCalled.contains(buffer.whatFloor)) {
//						floorsCalled.add(buffer.whatFloor);
//					}
//					buffer.getInLift=building.getSimulation().tick;
//					spaceLeft = spaceLeft - buffer.getSpace();
//					howManyPeopleIn = peopleInElevator.size();
//					} else {
					//leave the person in the floor queue is there isnt space
					//System.out.println("There is no more space");
				}
			}

		}
		
		/**
		 * The function removes people to the elevator queue, allowing them to enter 
		 * the elevator.
		 * @param f is an instance of the Floor class.
		 */
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

		public ArrayList<Integer> getFloorsCalled() {
			return floorsCalled;
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
		
		/**
		 * This function moves the elevator once called. If no one calls for the elevator
		 * from any floor above the current one, it goes to a lower floor from which it is called.
		 */
		public void move() {
			if (floorsCalled.size() == 0 && currentFloor != 0) {
					moveliftdown();
					direction = -1;
			} else {
				boolean goUp = false;
				boolean goDown = false;
				for (int i=0; i<floorsCalled.size();i++) {
					int temp = floorsCalled.get(i);
					if (temp > currentFloor) { //&& direction ==1
						goUp = true;
					} else if (temp < currentFloor) {  //&& direction == -1
						goDown = true;
					} else {
						floorsCalled.remove(i);
					}
				}
				if (goUp==true) {
					moveliftup();
				}
				if (goDown==true) {
					moveliftdown();
				}
			}
		}
		
//			if (currentFloor == (building.getHowManyFloors())-1) {
//				direction = -1;
//				moveliftdown();
//			} else if (currentFloor == 0) {
//				direction = 1;
//				moveliftup();
//			} else if (currentFloor < building.getHowManyFloors() && direction == -1) {
//				moveliftdown();
//			} else if (currentFloor < building.getHowManyFloors() && direction == 1) {
//				moveliftup();
//			}
		

//		public Floor Direction() {
//			RequestList r;
//			Person p;
//			for (i = 0; i< peopleInElevator(); i++) {
//				if (r.getFloor() == currentFloor)			}
//		}
		
		/**
		 * This function calculates the ticks used to remove and add people from the floors, into
		 * the elevator.
		 */
		public void tick() {
			removePeople(building.getFloors().get(currentFloor));
			addPeople(building.getFloors().get(currentFloor));
			Collections.sort(floorsCalled);
			move();
			//people that need to leave will get out
			//people on the floor waiting will get on 
			// the lift will move
		}

}
