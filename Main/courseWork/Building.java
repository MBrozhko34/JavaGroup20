package courseWork;

import java.util.ArrayList;

/**
 * The building class is used to create the floors and elevator. It also contains a function to 
 * register the elevator.
 */

public class Building {
	
	private ArrayList<Floor> floors;
	public ArrayList<Elevator> elevators;
	private int howManyFloors;
	private int noElevators;
	private int elevatorcap;
	private Simulation s;
	public ArrayList<Person> allPeople = new ArrayList<Person>();
	
	/**
	 * This constructor creates the building simulation, including the number of floors and
	 * elevators.
	 * 
	 * @param m an instance of the MenuController class and is used to display 
	 * options on the FXML interface 
	 * @param S is an instance of the Simulation class and is used to create movement within
	 * the simulation
	 */
	public Building(MenuController m,Simulation s) {
		floors = new ArrayList<Floor>();
		howManyFloors = m.getFloors();
		noElevators = m.getElevators();
		elevatorcap = m.getElevatorcap();
		this.s = s;
		create();
		
	}
	
	/**
	 * The function adds and displays the number of floors within the building simulation.
	 */
	public void addFloors() {
		//create floors then pass into this function
		for (int i=0; i<howManyFloors; i++) {
			getFloors().add(new Floor(i,s,this));
		}
		System.out.println("We have created "+getFloors().size()+" floors");
	}
	
	/**
	 * This function registers and displays the elevators into the building simulation.
	 */
	public void registerElevator() {
		elevators = new ArrayList<Elevator>();
		for (int i=0; i < noElevators; i++) {
			elevators.add(new Elevator(elevatorcap,i,this,s));
		}
		System.out.println("We have created "+elevators.size()+" Elevators");
	}
	
	/**
	 * The function creates the floors and elevators, displaying that the building has been
	 * created as a whole.
	 */
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
	
	/**
	 * The function is used to track the ticks for both the floors and elevators once 
	 * created.
	 */
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
