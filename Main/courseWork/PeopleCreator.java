package courseWork;

import java.util.Random;

public class PeopleCreator {
	
	MenuController values;
	Building B;
	int totaldevs;
	ArrivalSimulator sim;
	Random random;
	
	/**
	 * This is the constructor for the PeopleCreator class and its purpose is to
	 * create the instances of people at the start of the simulation and mid simulation
	 *
	 * @param m The Menu Controller class which holds the information from the UI
	 * @param b the overall building so the person can have access to the floors and the elevators
	 * @param S this is the class that Deals with all of the probabilities and randomness
	 * @param R same random object throughout the program
	 */
	

	public PeopleCreator(MenuController m, Building b, ArrivalSimulator s,Random R) {
		values = m;
		B = b;
		sim = s;
		random = R;
		totaldevs = values.getMugdevs() + values.getGoggledevs();
		createEmployees();
		createDevs();
	}
	
	/**
	 * Function for creating general employees that holds people on the ground floor and 
	 * adding the new employees  employees
	 * we are using the array list on that ground floor
	 * By using the building class this is possible
	 */
	public void createEmployees() {
		for (int i=0; i < values.getEmployees();i++) {
			B.getFloors().get(0).addToQ(new Employees("E"+i,1,B,sim,random));
		}
	}
	
	/**
	 * Very similar logic to createEmployees however MD and GD is passed in 
	 * so the different types of devs can be distingused in the UI
	 */
	public void createDevs() {
		for (int i=0; i < values.getMugdevs();i++) { //later on split this into the two types of devs
			B.getFloors().get(0).addToQ(new Developers("MD"+i,1,B,sim,random));
		}
		
		for (int i=0; i < values.getGoggledevs();i++) { //later on split this into the two types of devs
			B.getFloors().get(0).addToQ(new Developers("GD"+i,1,B,sim,random));
		}
	}
	
	/**
	 * As the simulation runs the following code always needs to be run to check if a client or a 
	 * Maintenance crew needs to be generated.
	 * the check is to see if the double value is less than the chance of the spawn.
	 * The arival Simulator is called to get the right Q value for this simulation
	 * 
	 */
	public void tick() {
		Double chance = random.nextDouble();
		if (chance < 0.005) {
			B.getFloors().get(0).addToQ(new MaintenanceCrews("MaintenceCrew",values.getElevatorcap(),B,sim,random));
			// need to create the logic so the crew stays on that floor for a set time
		}
		
		if (chance < sim.getQProbability()) {
			B.getFloors().get(0).addToQ(new Clients("Client",1,B,sim,random));
		}
	}
	
	

}
