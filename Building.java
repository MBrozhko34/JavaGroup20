package courseWork;

import java.util.ArrayList;

public class Building {
	
	private ArrayList<Floor> floors;
	private ArrayList<Elevator> elevators;
	private int howManyFloors;
	private int noElevators;
	private int elevatorcap;
	private int timer=0;
	private Elevator elevator;
	
	public Building(MenuController m) {
		floors = new ArrayList<Floor>();
		howManyFloors = m.getFloors();
		noElevators = m.getElevators();
		elevatorcap = m.getElevatorcap();
		elevator=new Elevator(0);
		create();
		
	}
	
	public void addFloors() {
		//create floors then pass into this function
		for (int i=0; i<howManyFloors; i++) {
			floors.add(new Floor());
		}
		System.out.println("We have created "+floors.size()+" floors");
	}
	

	public void registerElevator() {
		elevators = new ArrayList<Elevator>();
		for (int i=0; i < noElevators; i++) {
			elevators.add(new Elevator(elevatorcap));
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
	
	public void moveliftUp() {
		Elevator elevator1 = elevators.get(0);
		for (int i = 0; i<7;i++) {      //check logic with micheal
			Floor tempfloor = floors.get(i+1);
			if (tempfloor.goUp) {
				elevator1.moveliftup();
			} else {
				elevator1.moveliftdown();
			}
			
		}
			
	}
	
	public void tick() {
		timer=timer+10; //increments timer because one tick is 10 seconds
		System.out.println("The time is "+timer+" seconds");
	}
	
	public int getTimer() {
		return timer;
	}
	
	public int getHowManyFloors() {
		return howManyFloors;
	}

}
