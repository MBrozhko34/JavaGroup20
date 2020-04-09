package elevatorSimulation;

import java.util.ArrayList;

public class Building {
	
	private ArrayList<Floor> floors;
<<<<<<< HEAD
	private Elevator elevator;
	
	public Building() {
		floors = new ArrayList<Floor>();
	
=======
	private howManyFloors;
	
	public Building() {
		floors = new ArrayList<Floor>();
		howManyFloors = floor.size()
>>>>>>> 44142c01595fc8bac3579a1c710ff550a1cd93fd
	}
	
	public void addFloors() {
		//create floors then pass into this function
		floors.setFloors();
		System.out.println(floors.size());
		
	}
	
	public void registerElevator() {
		elevator.setElevator();
	}
	
	

}
