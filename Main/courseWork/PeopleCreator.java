package courseWork;

import java.util.ArrayList;
import java.util.Random;

public class PeopleCreator {
	
	MenuController values;
	Building B;
	int totaldevs;
	ArrivalSimulator sim;
	Random random;
	

	public PeopleCreator(MenuController m, Building b, ArrivalSimulator s,Random R) {
		values = m;
		B = b;
		sim = s;
		random = R;
		totaldevs = values.getMugdevs() + values.getGoggledevs();
		createEmployees();
		createDevs();
	}
	
	public void createEmployees() {
		for (int i=0; i < values.getEmployees();i++) {
			B.getFloors().get(0).addToQ(new Employees("E"+i,1,B,sim,random));
		}
	}
	
	public void createDevs() {
		for (int i=0; i < values.getMugdevs();i++) { //later on split this into the two types of devs
			B.getFloors().get(0).addToQ(new Developers("MD"+i,1,B,sim,random));
		}
		
		for (int i=0; i < values.getGoggledevs();i++) { //later on split this into the two types of devs
			B.getFloors().get(0).addToQ(new Developers("GD"+i,1,B,sim,random));
		}
	}
	
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
