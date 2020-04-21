package courseWork;

import java.util.ArrayList;

public class Building {
	
	private ArrayList<Floor> floors;
	private ArrayList<Elevator> elevators;
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
	
	
	public void registerElevator(int noofelevators) {
		elevators = new ArrayList<Elevator>(noofelevators);
		for (int i=0; i < noofelevators+1; i++) {
			elevators.add(new Elevator());
			System.out.println("Elevator Created");
		}
	}
	
	

}
