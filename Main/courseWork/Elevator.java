package courseWork;

import java.util.ArrayList;

public class Elevator {

		public int currentFloor;
		private ArrayList<Person> peopleInElevator;
		private Building building;
		private int spaceLimit;
		public static int up = 2;
		public static int down = 1;
		public static int idle = 0;
		private int howManyPeopleIn;
		private boolean isOpen;
		private int spaceLeft;
		private boolean isDoorOpen;
		public boolean goingUp;
		public boolean goingDown;

		public Elevator(int c) {
			currentFloor = 0;
			idle = 0;
			isOpen = true;
			spaceLimit = c;
			howManyPeopleIn = 0;
			spaceLeft = spaceLimit;
			peopleInElevator = new ArrayList<Person>();

		}

		public void addPeople(Floor f) {   //floor needs to have a method to return 
			for (int i=0; i < f.sizeQueue(); i++) { //what floor number it is
				Person buffer = f.waitingQueue.get(i);
				if (buffer.getSpace() <= spaceLeft) {
					f.removeFromQ();
					peopleInElevator.add(buffer);
					spaceLeft = spaceLeft - buffer.getSpace();
				} else {
					//leave the person in the floor queue is there isnt space
					System.out.println("There was an Error");
				}
			}

		}

		public int howManyPeopleIn() {
			return peopleInElevator.size();
		}
		
		public int currentFloor() {
			return currentFloor;
		}
		
		public void moveliftup() {
			currentFloor = currentFloor + 1;
		}
		
		public void moveliftdown() {
			currentFloor = currentFloor - 1;
		}

//		public Floor Direction() {
//			RequestList r;
//			Person p;
//			for (i = 0; i< peopleInElevator(); i++) {
//				if (r.getFloor() == currentFloor)			}
//		}
		
		public void tick() {
			//people that need to leave will get out
			//people on the floor waiting will get on 
			// the lift will move
		}

}
