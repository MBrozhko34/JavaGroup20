package courseWork;

import java.util.ArrayList;

public class Elevator {

		private Floor currentFloor;
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

		public Elevator() {

			currentFloor = 0;
			idle = 0;
			isOpen = true;
			howManyPeopleIn = 0;
			isLimitReached = false;
			peopleInElevator = new ArrayList<Person>();

		}

		public void addPeople(Person p, Floor f) { 
			if (isLimitReached == false && p.currentFloor == currentFloor) {  //floor needs to have a method to return 
				for (i=0; i<q.getSize() && i < peopleInElevator.size(); i++) { //what floor number it is
					peopleInElevator.add(p);
					f.removeFromQ();
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

		// to finish

		public Floor moveTo(direction d) {
			RequestList r;
			Person p;
			for (i = 0; i< peopleInElevator(); i++) {
				if (r.getFloor() == currentFloor)
			}
		}

}
