package elevatorSimulation;

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
		Queue q;
		private boolean isDoorOpen;

		public Elevator() {

			currentFloor = building.getFloor(0);
			idle = 0;
			isOpen = true;
			howManyPeopleIn = 0;
			isLimitReached = false;
			peopleInElevator = new ArrayList<Person>();

		}

		public void addPeople(Person p) {
			if (q.isEmpty() && p.getFloor() == currentFloor) {
				for (i = 0; i<q.getSize() && i < peopleInElevator.size())peopleInElevator.add(q.leaveQFront(); i++) {
					peopleInElevator.add(p);
				}
			}

		}

		public int howManyPeopleIn() {
			return peopleInElevator.size();
		}

		public boolean isLimitReached() {
			if (howManyPeopleIn() == spaceLimit ) {
				return isLimitReached true;
			} else {
				return false;
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
