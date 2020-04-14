package courseWork;

import java.util.ArrayList;

public class Building {
	
	private ArrayList<Floor> floors;
	private Elevator elevator1;
	private int howManyFloors;
	
	public Building() {
		floors = new ArrayList<Floor>();
		howManyFloors = 7;
	}
	
	public void addFloors(int nooffloors) {
		//create floors then pass into this function
		for (int i=0; i<nooffloors+1; i++) {
			floors.add(new Floor());
		}
		System.out.println("We have created "+floors.size()+"number of floors");
	}
	
	
	public void registerElevator() {
		elevator1 = new Elevator();
		System.out.println("Elevator Created");
	}
	
	

}
