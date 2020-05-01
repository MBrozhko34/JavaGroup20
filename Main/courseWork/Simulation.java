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
		ArrivalSimulator s = new ArrivalSimulator(randomness);
		PeopleCreator p = new PeopleCreator(MenuVars, building1,s);
		Ui = new TextBasedUI(building1);
		Ui.showUI();
		
		for (int i=0; i< MenuVars.getTicks();i++) {
			building1.tick();
			Ui.showUI();
		}
	}
}
