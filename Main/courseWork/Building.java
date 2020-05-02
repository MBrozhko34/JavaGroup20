package courseWork;

import java.util.ArrayList;

public class Building {
	
	private ArrayList<Floor> floors;
	public ArrayList<Elevator> elevators;
	private int howManyFloors;
	private int noElevators;
	private int elevatorcap;
	private Simulation s;
	
	public Building(MenuController m,Simulation S) {
		floors = new ArrayList<Floor>();
		howManyFloors = m.getFloors();
		noElevators = m.getElevators();
		elevatorcap = m.getElevatorcap();
		s = S;
		create();
		
	}
	
	public void addFloors() {
		//create floors then pass into this function
		for (int i=0; i<howManyFloors; i++) {
			getFloors().add(new Floor(i,s));
		}
		System.out.println("We have created "+getFloors().size()+" floors");
	}
	

	public void registerElevator() {
		elevators = new ArrayList<Elevator>();
		for (int i=0; i < noElevators; i++) {
			elevators.add(new Elevator(elevatorcap,i,this,s));
		}
		System.out.println("We have created "+elevators.size()+" Elevators");
	}
	
	public void create() {
		addFloors();
		registerElevator();
		System.out.println("Building Created");
	}
	
	public int returnfloors() {
		return howManyFloors;
	}
	
	public ArrayList<Floor> getFloors() {
		return floors;
	}
	
	public void tick() {
		for (Elevator e:elevators) {
			e.tick();
		}
		for (Floor f: floors) {
			f.tick();
		}
	}
	
	public int getHowManyFloors() {
		return howManyFloors;
	}
	
	public Simulation getSimulation() {
		return s;
	}

}
