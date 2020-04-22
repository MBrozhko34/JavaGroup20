package courseWork;

import java.util.ArrayList;

public class Elevator {

		public int currentFloor;
		private ArrayList<Person> peopleInElevator;
		private Building building;
		private int spaceLimit = 4;
		public static int up = 2;
		public static int down = 1;
		public static int idle = 0;
		private int howManyPeopleIn;
		private boolean isOpen;
		private boolean isLimitReached;
		private boolean isDoorOpen;
		public boolean goingUp;
		public boolean goingDown;

		public Elevator() {

			currentFloor = 0;
			idle = 0;
			isOpen = true;
			howManyPeopleIn = 0;
			isLimitReached = false;
			peopleInElevator = new ArrayList<Person>();

		}

		public void addPeople(Person p, Floor f) { 
			if (isLimitReached == false) {  //floor needs to have a method to return 
				for (int i=0; i < f.sizeQueue(); i++) { //what floor number it is
					if (isLimitReached == true) {
						break;
					} else {
						Person entering = f.removeFromQ();
						peopleInElevator.add(entering);
						isLimitReached();
					}
				}
			}

		}

		public int howManyPeopleIn() {
			return peopleInElevator.size();
		}

		public void isLimitReached() {
			if (howManyPeopleIn() == spaceLimit ) {
				isLimitReached=true;
			}
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

}
