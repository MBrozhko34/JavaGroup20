package courseWork;

import java.util.Random;

//import javafx.application.Application;

public class Simulation {
	
	MenuController MenuVars;


	public Simulation(MenuController m) {
		MenuVars = m;

	}
	

	public void run() {
		Building building1 = new Building(MenuVars);
		Random randomness = new Random();
		building1.tick();
	}
}
