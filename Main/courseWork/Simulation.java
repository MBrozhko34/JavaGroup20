package courseWork;

import java.util.Random;

//import javafx.application.Application;

public class Simulation {
	
	MenuController MenuVars;
	TextBasedUI Ui;


	public Simulation(MenuController m) {
		MenuVars = m;

	}
	

	public void run() {
		Building building1 = new Building(MenuVars);
		Random randomness = new Random();
		PeopleCreator p = new PeopleCreator(MenuVars, building1);
		p.createDevs();
		
		for (int i=0; i< MenuVars.getTicks();i++) {
			Ui = new TextBasedUI(building1);
			Ui.showUI();
			building1.tick();
		}
	}
}
