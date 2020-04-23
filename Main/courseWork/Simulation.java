package courseWork;
//import javafx.application.Application;

public class Simulation {
	
	MenuController MenuVars;


	public Simulation(MenuController m) {
		MenuVars = m;

	}
	

	public void run() {
		Building building1 = new Building(MenuVars);
		building1.tick();
	}
}
