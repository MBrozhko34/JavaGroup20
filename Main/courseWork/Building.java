package courseWork;

import java.util.ArrayList;

public class Building {
	
	private ArrayList<Floor> floors;
	public ArrayList<Elevator> elevators;
	private int howManyFloors;
	private int noElevators;
	private int elevatorcap;
	
	public Building(MenuController m) {
		floors = new ArrayList<Floor>();
		howManyFloors = m.getFloors();
		noElevators = m.getElevators();
		elevatorcap = m.getElevatorcap();
		create();
		
	}
	
	public void addFloors() {
		//create floors then pass into this function
		for (int i=0; i<howManyFloors; i++) {
			getFloors().add(new Floor(i));
		}
		System.out.println("We have created "+getFloors().size()+" floors");
	}
	

	public void registerElevator() {
		elevators = new ArrayList<Elevator>();
		for (int i=0; i < noElevators; i++) {
			elevators.add(new Elevator(elevatorcap,i,this));
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

	public void moveliftUp() {
		Elevator elevator1 = elevators.get(0);
		for (int i = 0; i<7;i++) {      //check logic with micheal
			Floor tempfloor = getFloors().get(i+1);
			if (tempfloor.goUp) {
				elevator1.moveliftup();
			} else {
				elevator1.moveliftdown();
			}
			
		}
			
	}
	
	public void tick() {
		for (Elevator e:elevators) {
			e.tick();
		}
	}
	
	public int getHowManyFloors() {
		return howManyFloors;
	}

}
